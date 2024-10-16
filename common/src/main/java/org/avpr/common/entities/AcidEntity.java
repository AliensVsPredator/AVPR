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
import org.jetbrains.annotations.NotNull;

public class AcidEntity extends Entity {

    private static final int DEFAULT_MAX_LIFE_IN_TICKS = 20 * 20; // 10 seconds.

    private static final int MAX_MULTIPLIER = 10;

    private static final int MIN_TICKS_UNTIL_PARTICLES = 5;

    private static final String MULTIPLIER_KEY = "Multiplier";

    private static final String TICK_COUNT_FOR_CURRENT_MULTIPLIER = "TickCountForMultiplier";

    private static final EntityDataAccessor<Integer> MULTIPLIER = SynchedEntityData.defineId(
            AcidEntity.class,
            EntityDataSerializers.INT
    );

    private int particleTickCounter = 0;

    private int tickCountForCurrentMultiplier = 0;

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
        builder.define(MULTIPLIER, 1);
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        this.setMultiplier(compoundTag.getInt(MULTIPLIER_KEY));
        this.tickCountForCurrentMultiplier = compoundTag.getInt(TICK_COUNT_FOR_CURRENT_MULTIPLIER);
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        compoundTag.putInt(MULTIPLIER_KEY, getMultiplier());
        compoundTag.putInt(TICK_COUNT_FOR_CURRENT_MULTIPLIER, tickCountForCurrentMultiplier);
    }

    @Override
    public void tick() {
        super.tick();
        particleTickCounter += getMultiplier();
        /*
            Sim gravity
         */
        this.applyGravity();
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.setDeltaMovement(this.getDeltaMovement().scale(0.98));
        if (tickCount == 1)
            this.moveTo(this.blockPosition().offset(0, 0, 0), this.getYRot(), this.getXRot());
        this.damageBlock(this.level());
        this.damageEntities(this.level());
        // Ensures it always plays a sound when first placed
        if (this.tickCount == 1) this.createParticlesAndSounds(this.level());
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

    private void damageBlock(Level level) {
        if (level.isClientSide || isInWater() || !onGround())
            return;

        var blockPos = blockPosition();
        var blockState = level.getBlockState(blockPos);

        if (blockState.getBlock() == Blocks.AIR) {
            blockPos = blockPos.below();
            blockState = level.getBlockState(blockPos);
        }

        if (!blockState.is(AVPRBlockTags.ACID_IMMUNE))
            BlockBreakProgressManager.damage(level(), blockPos, (2F * getMultiplier()) / CommonMod.config.acidConfigs.ACID_BREAKSPEED_MODIFIER);
    }

    private void createParticlesAndSounds(Level level) {
        // Both particles and fizzing sounds should only play client-side.
        if (!level.isClientSide) return;
        if (particleTickCounter < MIN_TICKS_UNTIL_PARTICLES) return;

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

    private void damageEntities(Level level) {
        // Entity damage should only be done server-side.
        if (level.isClientSide) return;

        var entities = level.getEntities(
                this,
                getBoundingBox(),
                entity -> PredicatesUtil.IS_LIVING.test(entity) || entity instanceof AcidEntity
        );
        entities.forEach(this::damageEntity);
    }

    private void damageEntity(Entity entity) {
        if (entity instanceof AcidEntity otherAcid) {
            if (otherAcid.isAlive()) {
                otherAcid.remove(RemovalReason.DISCARDED);
                setMultiplier(getMultiplier() + otherAcid.getMultiplier());
            }
            return;
        }

        if (isInWater() || tickCount % 10 != 0) return;
        if (entity instanceof Player player && PredicatesUtil.IS_CREATIVEorSPECTATOR.test(player)) return;

        if (entity instanceof LivingEntity livingEntity) {
            var itemStack = livingEntity.getItemBySlot(EquipmentSlot.FEET);

            if (itemStack.is(AVPRItemTags.ACID_IMMUNE)) {
                return;
            } else if (!itemStack.isEmpty()) {
                // Damage feet item if present.
                var damage = (random.nextInt(3) + 3) * getMultiplier();
                itemStack.setDamageValue(itemStack.getDamageValue() + damage);
                if (itemStack.getDamageValue() > itemStack.getMaxDamage()) {
                    itemStack.setCount(0);
                }
                return;
            }
        }

        if (!entity.getType().is(AVPREntityTags.ACID_IMMUNE))
            entity.hurt(DamageUtil.of(entity.level(),AVPRDamageSources.ACID), CommonMod.config.acidConfigs.ACID_DAMAGE);
    }

    private int getMultiplier() {
        return entityData.get(MULTIPLIER);
    }

    public void setMultiplier(int multiplier) {
        entityData.set(MULTIPLIER, Mth.clamp(multiplier, 0, MAX_MULTIPLIER));
        tickCountForCurrentMultiplier = 0;
        refreshDimensions();
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> entityDataAccessor) {
        if (MULTIPLIER.equals(entityDataAccessor)) refreshDimensions();

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
