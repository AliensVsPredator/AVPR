package org.avpr.common.entities;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.api.server.BlockBreakProgressManager;
import org.avpr.common.api.util.DamageUtil;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.registries.AVPRDamageSources;
import org.avpr.common.registries.AVPRParticles;
import org.avpr.common.registries.AVPRSounds;
import org.avpr.common.tags.AVPRBlockTags;
import org.avpr.common.tags.AVPREntityTags;
import org.avpr.common.tags.AVPRItemTags;

/**
 * The AcidEntity class represents an entity that simulates the behavior of acid within the game world. It extends the
 * basic Entity class and adds functionality specific to the acid entity, such as applying gravity, damaging blocks and
 * entities, creating particles and sounds, and managing its lifespan and multiplier.
 */
public class AcidEntity extends Entity {

    private static final int DEFAULT_MAX_LIFE_IN_TICKS = 20 * 20; // 10 seconds.

    private static final int MAX_MULTIPLIER = 10;

    private static final int MIN_TICKS_UNTIL_PARTICLES = 5;

    private static final String MULTIPLIER_KEY = "Multiplier";

    private static final String TICK_COUNT_FOR_CURRENT_MULTIPLIER = "TickCountForMultiplier";

    private static final EntityDataAccessor<Float> MULTIPLIER = SynchedEntityData.defineId(
        AcidEntity.class,
        EntityDataSerializers.FLOAT
    );

    private float particleTickCounter = 0;

    private float tickCountForCurrentMultiplier = 0;

    public AcidEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.setDeltaMovement(Vec3.ZERO);
        this.setNoGravity(false);
        this.refreshDimensions();
    }

    @Override
    protected double getDefaultGravity() {
        return 0.04;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        builder.define(MULTIPLIER, 1.0F);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        this.setMultiplier(compoundTag.getInt(MULTIPLIER_KEY));
        this.tickCountForCurrentMultiplier = compoundTag.getFloat(TICK_COUNT_FOR_CURRENT_MULTIPLIER);
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        compoundTag.putFloat(MULTIPLIER_KEY, getMultiplier());
        compoundTag.putFloat(TICK_COUNT_FOR_CURRENT_MULTIPLIER, tickCountForCurrentMultiplier);
    }

    /**
     * Updates the state of the AcidEntity each tick. This method performs several tasks including: - Increasing the
     * particle tick counter based on the current multiplier. - Applying gravity to the entity and moving it. - Scaling
     * down the entity's delta movement. - Initializing position and orientation on the first tick. - Inflicting damage
     * to blocks and entities. - Creating particles and sounds. - Managing the lifecycle and multiplier of the entity,
     * especially when it's in water. Specific tasks performed by this method: - Applies gravity using the
     * {@code applyGravity()} method. - Moves the entity using {@code move(MoverType, Vec3)}. - Damages blocks and
     * entities using the {@code damageBlock(Level)} and {@code damageEntities(Level)} methods. - Creates particles and
     * sounds client-side using {@code createParticlesAndSounds(Level)} method. - Adjusts the lifecycle of the entity,
     * especially if it's in water. - Reduces the entity's multiplier and resets related counters as needed.
     */
    @Override
    public void tick() {
        super.tick();
        particleTickCounter += getMultiplier();
        /*
         * Sim gravity
         */
        this.applyGravity();
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98));
        if (tickCount == 1)
            this.moveTo(this.blockPosition().offset(0, 0, 0), this.getYRot(), this.getXRot());
        this.damageBlock(this.level());
        this.damageEntities(this.level());
        // Ensures it always plays a sound when first placed
        if (this.tickCount == 1)
            this.createParticlesAndSounds(this.level());
        this.createParticlesAndSounds(this.level());

        if (!this.level().isClientSide) {
            // Acid disappears twice as fast when in water.
            tickCountForCurrentMultiplier += getMultiplier() * (isInWater() ? 2 : 1);

            if (tickCountForCurrentMultiplier > DEFAULT_MAX_LIFE_IN_TICKS) {
                decreaseMultiplier();
                tickCountForCurrentMultiplier = 0;
            }
            if (tickCount >= (this.isInWater() ? 70 : 140))
                kill();
        }
    }

    public void decreaseMultiplier() {
        this.setMultiplier(this.getMultiplier() - 1);
    }

    /**
     * Damages a block in the game world if the conditions are met, such as not being client-side, not being in water,
     * and being on the ground. This method checks the block at the entity's position and below it to account for being
     * in the air. It will only damage blocks that are not immune to acid.
     *
     * @param level The Level object representing the game world.
     */
    private void damageBlock(Level level) {
        if (level.isClientSide || isInWater() || !onGround())
            return;

        var blockPos = blockPosition();
        var blockState = level.getBlockState(blockPos);

        if (blockState.getBlock() == Blocks.AIR) {
            blockPos = blockPos.below();
            blockState = level.getBlockState(blockPos);
        }

        if (!blockState.is(AVPRBlockTags.ACID_IMMUNE)) {
            float hardness = blockState.getDestroySpeed(level(), blockPos);
            // Determine a damage multiplier based on the block's hardness.
            float damageMultiplier = (2F * getMultiplier()) / (CommonMod.config.acid.breakSpeedModifier * hardness);

            // Apply damage to the block using the calculated multiplier.
            BlockBreakProgressManager.damage(level(), blockPos, damageMultiplier);
        }
    }

    /**
     * Creates visual and auditory effects for the AcidEntity. This method is responsible for adding smoke and acid
     * particles as well as playing fizzing sounds. These effects are generated only on the client-side to enhance
     * visual feedback.
     *
     * @param level The level object representing the game world. It is used to determine client-side execution and to
     *              add particles and sounds to the world.
     */
    private void createParticlesAndSounds(Level level) {
        // Both particles and fizzing sounds should only play client-side.
        if (!level.isClientSide)
            return;
        if (particleTickCounter < MIN_TICKS_UNTIL_PARTICLES)
            return;

        if (tickCount % (random.nextInt(100) + 10) == 0)
            level.playLocalSound(this, AVPRSounds.BLOCK_ACID_BURN.get(), SoundSource.NEUTRAL, 1F, 1F);

        particleTickCounter = 0;

        for (var i = 0; i < getMultiplier(); i++) {
            level.addAlwaysVisibleParticle(ParticleTypes.SMOKE, getRandomX(0.5), getRandomY(), getRandomZ(0.5), 0, 0, 0);
            level.addAlwaysVisibleParticle(
                AVPRParticles.ACID.get(),
                getRandomX(0.5),
                getRandomY(),
                getRandomZ(0.5),
                0,
                0,
                0
            );
        }
    }

    /**
     * Inflicts damage on all entities within the bounding box of the AcidEntity, excluding client-side levels. This
     * method filters entities to include only living entities and other AcidEntity instances. It then applies
     * appropriate damages through the `damageEntity` method.
     *
     * @param level The level object representing the game world. It is used to determine whether the method is executed
     *              on the server side and to fetch entities within the bounding box of the AcidEntity.
     */
    private void damageEntities(Level level) {
        // Entity damage should only be done server-side.
        if (level.isClientSide)
            return;

        var entities = level.getEntities(
            this,
            getBoundingBox(),
            entity -> PredicatesUtil.IS_LIVING.test(entity) || entity instanceof AcidEntity
        );
        entities.forEach(this::damageEntity);
    }

    /**
     * Inflicts damage to an entity based on specific conditions. This method takes into account various factors such as
     * the type of entity, whether it is in water, if it is a player in creative or spectator mode, and if the entity
     * has acid-immune equipment or status.
     *
     * @param entity The target entity to be damaged.
     */
    private void damageEntity(Entity entity) {
        if (entity instanceof AcidEntity otherAcid) {
            if (otherAcid.isAlive()) {
                otherAcid.remove(RemovalReason.DISCARDED);
                setMultiplier(getMultiplier() + otherAcid.getMultiplier());
            }
            return;
        }

        if (isInWater() || tickCount % 10 != 0)
            return;
        if (entity instanceof Player player && PredicatesUtil.IS_CREATIVE_OR_SPECTATOR.test(player))
            return;

        if (entity instanceof LivingEntity livingEntity) {
            var itemStack = livingEntity.getItemBySlot(EquipmentSlot.FEET);

            if (itemStack.is(AVPRItemTags.ACID_IMMUNE)) {
                return;
            } else if (!itemStack.isEmpty()) {
                // Damage feet item if present.
                var damage = (random.nextInt(3) + 3) * getMultiplier();
                itemStack.setDamageValue((int) (itemStack.getDamageValue() + damage));
                if (itemStack.getDamageValue() > itemStack.getMaxDamage()) {
                    itemStack.setCount(0);
                }
                return;
            }
        }

        if (!entity.getType().is(AVPREntityTags.ACID_IMMUNE))
            entity.hurt(DamageUtil.of(entity.level(), AVPRDamageSources.ACID), CommonMod.config.acid.damage);
    }

    private float getMultiplier() {
        return entityData.get(MULTIPLIER);
    }

    /**
     * Sets the multiplier value for the AcidEntity, ensuring the value is within acceptable bounds. This method also
     * resets the tick count for the current multiplier to zero and refreshes the entity's dimensions.
     *
     * @param multiplier The desired multiplier value. It will be clamped between 0 and MAX_MULTIPLIER.
     */
    public void setMultiplier(float multiplier) {
        entityData.set(MULTIPLIER, Mth.clamp(multiplier, 0, MAX_MULTIPLIER));
        tickCountForCurrentMultiplier = 0;
        refreshDimensions();
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> entityDataAccessor) {
        if (MULTIPLIER.equals(entityDataAccessor))
            refreshDimensions();

        super.onSyncedDataUpdated(entityDataAccessor);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }
}
