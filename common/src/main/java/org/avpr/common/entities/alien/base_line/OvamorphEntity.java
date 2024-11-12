package org.avpr.common.entities.alien.base_line;

import mod.azure.azurelib.common.api.common.entities.AzureVibrationUser;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.api.util.Constants;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.api.util.Tick;
import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRSounds;
import org.avpr.common.tags.AVPREntityTags;

/**
 * The OvamorphEntity class represents an entity in the game that simulates an ovamorph (egg) from the Alien franchise.
 * This entity is responsible for hatching and potentially spawning a Facehugger entity.
 */
public class OvamorphEntity extends AlienEntity {

    private static final EntityDataAccessor<Boolean> IS_HATCHING = SynchedEntityData.defineId(
        OvamorphEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> IS_HATCHED = SynchedEntityData.defineId(
        OvamorphEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_FACEHUGGER = SynchedEntityData.defineId(
        OvamorphEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final long MAX_HATCH_PROGRESS = 50L;

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    private long hatchProgress = 0L;

    private long ticksOpen = 0L;

    private int hatchCheckTimer = 0;

    public OvamorphEntity(EntityType<? extends AlienEntity> entityType, Level level) {
        super(entityType, level);
        this.vibrationUser = new AzureVibrationUser(this, 0.0F, 0);
    }

    /**
     * Creates and returns a builder for the attributes of the `OvamorphEntity`. This builder initializes the following
     * attributes for the entity: - Maximum Health - Armor - Armor Toughness - Knockback Resistance - Follow Range -
     * Movement Speed
     *
     * @return A builder object for defining the attributes of the `OvamorphEntity`.
     */
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(
                Attributes.MAX_HEALTH,
                CommonMod.config.ovamorphConfigs.OVAMORPH_HEALTH
            )
            .add(
                Attributes.ARMOR,
                1.0
            )
            .add(Attributes.ARMOR_TOUGHNESS, 0.0)
            .add(
                Attributes.KNOCKBACK_RESISTANCE,
                1.0
            )
            .add(Attributes.FOLLOW_RANGE, 0.0)
            .add(Attributes.MOVEMENT_SPEED, 0.0);
    }

    /**
     * Registers the animation controllers for the `OvamorphEntity`. This method defines the behavior of the animation
     * based on the state of the entity, such as whether it is hatching or already hatched.
     *
     * @param controllers the controller registrar that manages the registration of animation controllers
     */
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, Constants.LIVING_CONTROLLER, event -> {
            if (isHatched() && !this.isDeadOrDying()) {
                if (!hasFacehugger())
                    return event.setAndContinue(Constants.HATCHED);
                return event.setAndContinue(Constants.HATCHED);
            }
            if (isHatching() && !this.isDeadOrDying())
                event.getController().setAnimation(Constants.HATCHING);
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    /**
     * Growth handling
     */
    @Override
    public int getAcidDiameter() {
        return 1;
    }

    @Override
    public float getMaxGrowth() {
        return 0;
    }

    @Override
    public LivingEntity growInto() {
        return null;
    }

    /**
     * Egg data handling
     */
    public boolean isHatching() {
        return entityData.get(IS_HATCHING);
    }

    public void setIsHatching(boolean value) {
        entityData.set(IS_HATCHING, value);
    }

    public boolean isHatched() {
        return entityData.get(IS_HATCHED);
    }

    public void setIsHatched(boolean value) {
        entityData.set(IS_HATCHED, value);
    }

    public boolean hasFacehugger() {
        return entityData.get(HAS_FACEHUGGER);
    }

    public void setHasFacehugger(boolean value) {
        entityData.set(HAS_FACEHUGGER, value);
    }

    @Override
    public void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(IS_HATCHING, false);
        builder.define(IS_HATCHED, false);
        builder.define(HAS_FACEHUGGER, true);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("isHatching", isHatching());
        nbt.putBoolean("isHatched", isHatched());
        nbt.putBoolean("hasFacehugger", hasFacehugger());
        nbt.putLong("hatchProgress", hatchProgress);
        nbt.putLong("ticksOpen", ticksOpen);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        setIsHatching(nbt.getBoolean("isHatching"));
        setIsHatched(nbt.getBoolean("isHatched"));
        setHasFacehugger(nbt.getBoolean("hasFacehugger"));
        hatchProgress = nbt.getLong("hatchProgress");
        ticksOpen = nbt.getLong("ticksOpen");
    }

    /**
     * Prevents entity collisions from moving the egg.
     */
    @Override
    public void doPush(@NotNull Entity entity) {
        if (
            !level().isClientSide && (entity instanceof LivingEntity living && living.getType()
                .is(
                    AVPREntityTags.HUMANIOD_HOSTS
                ))
        )
            setIsHatching(true);
    }

    /**
     * Prevents the egg from being pushed.
     */
    @Override
    public boolean isPushable() {
        return false;
    }

    /**
     * Prevents fluids from moving the egg.
     */
    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    /**
     * Prevents the egg from moving on its own.
     */
    @Override
    public boolean shouldPassengersInheritMalus() {
        return false;
    }

    /**
     * Prevents the egg moving when hit.
     */
    @Override
    public void knockback(double strength, double x, double z) {}

    /**
     * Handles the entity receiving damage, triggering hatching if certain conditions are met.
     *
     * @param source The source of the damage being inflicted.
     * @param amount The amount of damage being inflicted.
     * @return A boolean indicating whether the damage was successfully inflicted.
     */
    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (source != damageSources().genericKill() && source.getDirectEntity() != null && !this.isHatched())
            setIsHatching(true);
        return source != damageSources().inWall() && super.hurt(source, amount);
    }

    @Override
    public boolean requiresCustomPersistence() {
        return (!this.isHatched() || this.hasFacehugger());
    }

    @Override
    public void checkDespawn() {
        if (this.isHatched() && !this.hasFacehugger())
            super.checkDespawn();
    }

    /**
     * Prevents exp from dropping.
     */
    @Override
    public boolean shouldDropExperience() {
        return false;
    }

    /**
     * Handles the per-tick behavior of the `OvamorphEntity`. This includes managing the hatching process, playing
     * specific sounds when hatching, and spawning a facehugger once hatched. The method extends its parent `tick`
     * method and introduces additional logic specific to the `OvamorphEntity`: - Increments hatch progress if the
     * entity is in the hatching state. - Plays a sound when hatch progress reaches a specific point. - Updates the
     * hatching and hatched states based on progress. - Manages the spawning and movement of a facehugger if the entity
     * has hatched. Exit conditions in the method: - Returns immediately if the entity has no AI. - Progress updates and
     * related actions occur only if the entity is hatching and hatch progress has not yet reached the maximum. -
     * Facehugger spawning logic executes only if the entity is on the server side, has a facehugger, and is not dead or
     * dying.
     */
    @Override
    public void tick() {
        super.tick();
        if (this.isNoAi())
            return;
        if (this.isHatching() && this.hatchProgress < MAX_HATCH_PROGRESS)
            this.hatchProgress++;
        if (hatchProgress == 2L && !this.level().isClientSide)
            this.level()
                .playSound(
                    this,
                    blockPosition(),
                    AVPRSounds.OVAMORPH_OPEN.get(),
                    SoundSource.HOSTILE,
                    1.0F,
                    1.0F
                );

        if (hatchProgress >= MAX_HATCH_PROGRESS) {
            this.setIsHatching(false);
            this.setIsHatched(true);
            this.ticksOpen++;
        }

        if (isHatched() && hasFacehugger())
            this.ticksOpen++;

        if (this.ticksOpen >= 3L * Tick.PER_SECOND && hasFacehugger() && !level().isClientSide && !this.isDeadOrDying()) {
            var facehugger = AVPREntities.FACEHUGGER.get().create(level());
            if (facehugger != null) {
                facehugger.setPos(this.position().x, this.position().y + 1, this.position().z);
                facehugger.setDeltaMovement(
                    Mth.nextFloat(facehugger.getRandom(), -0.5f, 0.5f),
                    0.7,
                    Mth.nextFloat(facehugger.getRandom(), -0.5f, 0.5f)
                );
                facehugger.setEggSpawnState(true);
                level().addFreshEntity(facehugger);
            }
            this.setHasFacehugger(false);
        }
    }

    /**
     * Handles the base tick behavior of the `OvamorphEntity`. This method manages the following tasks: - Increments the
     * hatch check timer on each tick. - Initiates the hatching process if the entity has recently hurt another mob. -
     * Performs hatching checks every second (20 ticks), analyzing nearby entities to determine if hatching conditions
     * are met. - Checks blocks in the immediate vicinity and modifies the hatching state based on their properties.
     */
    @Override
    public void baseTick() {
        super.baseTick();

        // Increment the hatch check timer
        this.hatchCheckTimer++;

        if (this.getLastHurtMob() != null)
            this.setIsHatching(true);

        // Perform hatching check once every second (20 ticks)
        if (this.hatchCheckTimer >= 20) {
            this.hatchCheckTimer = 0; // Reset the timer

            // Get nearby entities within normal hatch range
            this.level()
                .getEntitiesOfClass(
                    LivingEntity.class,
                    this.getBoundingBox().inflate(CommonMod.config.ovamorphConfigs.OVAMORPH_HATCH_RANGE)
                )
                .forEach(target -> {
                    // If the entity is alive and can be facehugged
                    if (
                        target.isAlive() && target.getType()
                            .is(
                                AVPREntityTags.ALL_HOSTS
                            ) && this.level().random.nextFloat() < 0.2f && !target.isSteppingCarefully()
                            && !PredicatesUtil.IS_CREATIVE_OR_SPECTATOR.test(
                                target
                            )
                    ) {
                        this.setIsHatching(true);
                    }
                });

            // Smaller range for closer entities
            this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3)).forEach(target -> {
                if (
                    target.isAlive() && target.getType().is(AVPREntityTags.HUMANIOD_HOSTS) && this.level().random.nextFloat() < 0.8f
                        && !PredicatesUtil.IS_CREATIVE_OR_SPECTATOR.test(target)
                ) {
                    this.setIsHatching(true);
                }
            });
        }

        if (this.getLastHurtMob() == null)
            // Loop through nearby blocks in different directions (this logic remains the same)
            for (var testPos : BlockPos.betweenClosed(this.blockPosition().above(1), this.blockPosition().above(1))) {
                for (
                    var testPos1 : BlockPos.betweenClosed(
                        this.blockPosition().below(1),
                        this.blockPosition().below(1)
                    )
                ) {
                    for (
                        var testPos2 : BlockPos.betweenClosed(
                            this.blockPosition().east(1),
                            this.blockPosition().east(1)
                        )
                    ) {
                        for (
                            var testPos3 : BlockPos.betweenClosed(
                                this.blockPosition().west(1),
                                this.blockPosition().west(1)
                            )
                        ) {
                            for (
                                var testPos4 : BlockPos.betweenClosed(
                                    this.blockPosition().south(1),
                                    this.blockPosition().south(1)
                                )
                            ) {
                                for (
                                    var testPos5 : BlockPos.betweenClosed(
                                        this.blockPosition().north(1),
                                        this.blockPosition().north(1)
                                    )
                                ) {
                                    // Check if any nearby blocks are not air
                                    boolean isAnyBlockNotAir = !this.level().getBlockState(testPos).isAir() &&
                                        !this.level().getBlockState(testPos1).isAir() &&
                                        !this.level().getBlockState(testPos2).isAir() &&
                                        !this.level().getBlockState(testPos3).isAir() &&
                                        !this.level().getBlockState(testPos4).isAir() &&
                                        !this.level().getBlockState(testPos5).isAir();

                                    // Check if any nearby blocks are solid
                                    boolean isAnyBlockSolid = !this.level()
                                        .getBlockState(
                                            testPos
                                        )
                                        .isCollisionShapeFullBlock(level(), testPos) &&
                                        !this.level()
                                            .getBlockState(testPos1)
                                            .isCollisionShapeFullBlock(
                                                level(),
                                                testPos1
                                            ) &&
                                        !this.level()
                                            .getBlockState(testPos2)
                                            .isCollisionShapeFullBlock(
                                                level(),
                                                testPos2
                                            ) &&
                                        !this.level()
                                            .getBlockState(testPos3)
                                            .isCollisionShapeFullBlock(
                                                level(),
                                                testPos3
                                            ) &&
                                        !this.level()
                                            .getBlockState(testPos4)
                                            .isCollisionShapeFullBlock(
                                                level(),
                                                testPos4
                                            ) &&
                                        !this.level()
                                            .getBlockState(testPos5)
                                            .isCollisionShapeFullBlock(
                                                level(),
                                                testPos5
                                            );

                                    // Set isHatching to false if conditions are met
                                    if (isAnyBlockSolid || isAnyBlockNotAir)
                                        this.setIsHatching(false);
                                }
                            }
                        }
                    }
                }
            }
    }
}
