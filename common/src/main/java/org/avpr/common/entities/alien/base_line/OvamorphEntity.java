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

    public static AttributeSupplier.Builder createAttributes() {
        return LivingEntity.createLivingAttributes()
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
                    AVPREntityTags.HOSTS
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
                    this.getBoundingBox().inflate(7.0f)
                )
                .forEach(target -> {
                    // If the entity is alive and can be facehugged
                    if (
                        target.isAlive() && target.getType()
                            .is(
                                AVPREntityTags.HOSTS
                            ) && this.level().random.nextFloat() < 0.2f && !target.isSteppingCarefully()
                            && !PredicatesUtil.IS_CREATIVEorSPECTATOR.test(
                                target
                            )
                    ) {
                        this.setIsHatching(true);
                    }
                });

            // Smaller range for closer entities
            this.level().getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(3)).forEach(target -> {
                if (
                    target.isAlive() && target.getType().is(AVPREntityTags.HOSTS) && this.level().random.nextFloat() < 0.8f
                        && PredicatesUtil.IS_CREATIVEorSPECTATOR.test(target)
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
