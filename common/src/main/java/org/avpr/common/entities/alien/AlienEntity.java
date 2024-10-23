package org.avpr.common.entities.alien;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;
import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.warden.AngerManagement;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.util.Collections;
import java.util.Locale;
import java.util.function.BiConsumer;

import org.avpr.common.api.common.GrowableInterface;
import org.avpr.common.api.util.EntityUtil;
import org.avpr.common.entities.ai.AVPRTicker;
import org.avpr.common.entities.ai.AVPRVibrationUser;
import org.avpr.common.registries.AVPRStatusEffects;
import org.avpr.common.tags.AVPREntityTags;

/**
 * Abstract class representing an alien entity that extends WaterAnimal and implements various interfaces such as Enemy,
 * VibrationSystem, GeoEntity, and GrowableInterface. This class includes methods for handling data registration, growth
 * management, dynamic game event listening, AI behavior, vibration handling, and custom entity-specific mechanics.
 */
public abstract class AlienEntity extends WaterAnimal implements Enemy, VibrationSystem, GeoEntity, GrowableInterface {

    protected static final EntityDataAccessor<Float> GROWTH = SynchedEntityData.defineId(
        AlienEntity.class,
        EntityDataSerializers.FLOAT
    );

    public static final EntityDataAccessor<Boolean> FLEEING_FIRE = SynchedEntityData.defineId(
        AlienEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    protected static final EntityDataAccessor<Integer> CLIENT_ANGER_LEVEL = SynchedEntityData.defineId(
        AlienEntity.class,
        EntityDataSerializers.INT
    );

    protected AngerManagement angerManagement = new AngerManagement(this::canTargetEntity, Collections.emptyList());

    private static final Logger LOGGER = LogUtils.getLogger();

    private final DynamicGameEventListener<Listener> dynamicGameEventListener;

    protected User vibrationUser;

    private Data vibrationData;

    protected String hostId = null;

    protected static int spawnPos = 0;

    public AlienEntity(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
        this.vibrationUser = new AVPRVibrationUser(this, 1.2F);
        this.vibrationData = new Data();
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new Listener(this));
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.05F, 1.0F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    @Override
    protected void registerGoals() {}

    /**
     * Checks whether various conditions are met for a monster to spawn in the given level.
     *
     * @param type      The type of water animal entity to spawn.
     * @param level     The server level accessor providing the environment context.
     * @param spawnType The type of spawning being attempted.
     * @param pos       The block position where the monster is attempting to spawn.
     * @param random    A source of randomness for checking spawn conditions.
     * @return true if the monster can spawn, false otherwise.
     */
    public static boolean checkMonsterSpawnRules(
        EntityType<? extends WaterAnimal> type,
        ServerLevelAccessor level,
        MobSpawnType spawnType,
        BlockPos pos,
        RandomSource random
    ) {
        return level.getDifficulty() != Difficulty.PEACEFUL
            && (MobSpawnType.ignoresLightRequirements(spawnType) || isDarkEnoughToSpawn(level, pos, random))
            && checkMobSpawnRules(type, level, spawnType, pos, random) && pos.getY() <= spawnPos;
    }

    /**
     * Determines if the lighting conditions at a specified position in the given level are dark enough for a monster to
     * spawn.
     *
     * @param level  The server level accessor providing the environment context.
     * @param pos    The block position where the monster is attempting to spawn.
     * @param random A source of randomness for checking light conditions.
     * @return true if the lighting conditions are dark enough for a monster to spawn, false otherwise.
     */
    public static boolean isDarkEnoughToSpawn(ServerLevelAccessor level, BlockPos pos, RandomSource random) {
        if (level.getBrightness(LightLayer.SKY, pos) > random.nextInt(32)) {
            return false;
        } else {
            DimensionType dimensiontype = level.dimensionType();
            int i = dimensiontype.monsterSpawnBlockLightLimit();
            if (i < 15 && level.getBrightness(LightLayer.BLOCK, pos) > i) {
                return false;
            } else {
                int j = level.getLevel().isThundering()
                    ? level.getMaxLocalRawBrightness(
                        pos,
                        10
                    )
                    : level.getMaxLocalRawBrightness(pos);
                return j <= dimensiontype.monsterSpawnLightTest().sample(random);
            }
        }
    }

    @Override
    protected void jumpInLiquid(@NotNull TagKey<Fluid> fluid) {}

    @Override
    public float maxUpStep() {
        return 1.05f;
    }

    /**
     * Always has full air
     */
    @Override
    protected void handleAirSupply(int airSupply) {}

    @Override
    public int getMaxAirSupply() {
        return 4800;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    /**
     * Executes custom AI logic for the AlienEntity on the server side. This method performs the following actions every
     * tick: 1. Obtains the current level as a `ServerLevel` instance. 2. Calls the superclass method to ensure base AI
     * logic is executed. 3. Every 20 ticks: - Manages the entity's anger state using `angerManagement` with the current
     * `ServerLevel` and the entity's targeting logic. - Syncs the entity's anger level with the client using
     * `syncClientAngerLevel`.
     */
    @Override
    protected void customServerAiStep() {
        var serverLevel = (ServerLevel) this.level();
        super.customServerAiStep();
        if (this.tickCount % 20 == 0) {
            this.angerManagement.tick(serverLevel, this::canTargetEntity);
            this.syncClientAngerLevel();
        }
    }

    /**
     * Performs the per-tick update for the `AlienEntity`. This method accomplishes the following tasks: 1. Calls the
     * `super.tick()` method to ensure the base class tick behavior is executed. 2. Resets the entity's air supply to
     * its maximum value. 3. If the current level is a `ServerLevel` instance: - Increases the entity's growth by its
     * growth multiplier if it is alive. - Sets the entity's aggressive state to false if it is a vehicle. - Updates the
     * vibration data and user via `AVPRTicker`. 4. Refreshes the entity's dimensions every 10 ticks.
     */
    @Override
    public void tick() {
        super.tick();
        this.setAirSupply(this.getMaxAirSupply());
        if (level() instanceof ServerLevel serverLevel) {
            if (this.isAlive())
                this.grow(this, 1 * getGrowthMultiplier());
            if (this.isVehicle())
                this.setAggressive(false);
            AVPRTicker.tick(serverLevel, this.vibrationData, this.vibrationUser);
        }
        if (this.tickCount % 10 == 0)
            this.refreshDimensions();
    }

    /**
     * Updates the dynamic game event listener associated with the AlienEntity.
     *
     * @param biConsumer A BiConsumer that takes a DynamicGameEventListener and a ServerLevel as parameters.
     */
    @Override
    public void updateDynamicGameEventListener(@NotNull BiConsumer<DynamicGameEventListener<?>, ServerLevel> biConsumer) {
        if (this.level() instanceof ServerLevel serverLevel)
            biConsumer.accept(this.dynamicGameEventListener, serverLevel);
    }

    @Override
    public boolean onClimbable() {
        return this.fallDistance <= 0.1;
    }

    @Override
    public @NotNull Data getVibrationData() {
        return this.vibrationData;
    }

    @Override
    public @NotNull User getVibrationUser() {
        return this.vibrationUser;
    }

    /**
     * Determines if the AlienEntity can dampen vibrations.
     *
     * @return true if the AlienEntity can dampen vibrations, false otherwise
     */
    @Override
    public boolean dampensVibrations() {
        return true;
    }

    /**
     * Handles the movement logic for the AlienEntity, modifying its travel behavior based on whether it is in water and
     * has effective AI.
     *
     * @param travelVector The vector representing the direction and magnitude of travel.
     */
    @Override
    public void travel(@NotNull Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(this.getSpeed(), travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(travelVector);
        }
    }

    /**
     * Default acid pool size
     */
    public int getAcidDiameter() {
        return 0;
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (!this.level().isClientSide && source.getEntity() != null && source.getEntity() instanceof LivingEntity livingEntity)
            this.brain.setMemory(MemoryModuleType.ATTACK_TARGET, livingEntity);

        if (amount >= 50 && source != this.damageSources().genericKill())
            return super.hurt(source, amount * 0.10f);

        if (source == damageSources().inWall())
            return false;

        if (
            !this.level().isClientSide && source != this.damageSources().genericKill() && amount >= 8
        ) {
            if (getAcidDiameter() == 1)
                EntityUtil.generateAcidPool(this, this.blockPosition(), 0, 0);
            else {
                var radius = (getAcidDiameter() - 1) / 2;
                for (var i = 0; i < getAcidDiameter(); i++) {
                    var x = this.level().getRandom().nextInt(getAcidDiameter()) - radius;
                    var z = this.level().getRandom().nextInt(getAcidDiameter()) - radius;
                    if (source != damageSources().genericKill() || source != damageSources().generic())
                        EntityUtil.generateAcidPool(this, this.blockPosition(), x, z);
                }
            }
        }

        return super.hurt(source, amount);
    }

    /**
     * Data handling
     */
    public float getGrowth() {
        return entityData.get(GROWTH);
    }

    public void setGrowth(float growth) {
        entityData.set(GROWTH, growth);
    }

    protected void syncClientAngerLevel() {
        this.entityData.set(CLIENT_ANGER_LEVEL, this.getActiveAnger());
    }

    private int getActiveAnger() {
        return this.angerManagement.getActiveAnger(this.getTarget());
    }

    public boolean isFleeing() {
        return this.entityData.get(FLEEING_FIRE);
    }

    public void setFleeingStatus(boolean fleeing) {
        this.entityData.set(FLEEING_FIRE, fleeing);
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId.toLowerCase(Locale.ROOT);
    }

    @Override
    public void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(GROWTH, 0.0f);
        builder.define(FLEEING_FIRE, false);
        builder.define(CLIENT_ANGER_LEVEL, 0);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        if (hostId != null)
            compound.putString("hostId", hostId);
        compound.putFloat("growth", this.getGrowth());
        compound.putBoolean("isFleeing", this.isFleeing());
        Data.CODEC.encodeStart(NbtOps.INSTANCE, this.vibrationData)
            .resultOrPartial(
                LOGGER::error
            )
            .ifPresent(tag -> compound.put("listener", tag));
        AngerManagement.codec(this::canTargetEntity)
            .encodeStart(NbtOps.INSTANCE, this.angerManagement)
            .resultOrPartial(
                LOGGER::error
            )
            .ifPresent(tag -> compound.put("anger", tag));
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("hostId"))
            hostId = compound.getString("hostId");
        this.setGrowth(compound.getFloat("growth"));
        this.setFleeingStatus(compound.getBoolean("growth"));
        if (compound.contains("anger")) {
            AngerManagement.codec(this::canTargetEntity)
                .parse(
                    new Dynamic<>(NbtOps.INSTANCE, compound.get("anger"))
                )
                .resultOrPartial(LOGGER::error)
                .ifPresent(
                    angerM -> this.angerManagement = angerM
                );
            this.syncClientAngerLevel();
        }
        if (compound.contains("listener", 10))
            Data.CODEC.parse(
                new Dynamic<>(NbtOps.INSTANCE, compound.getCompound("listener"))
            )
                .resultOrPartial(
                    LOGGER::error
                )
                .ifPresent(data -> this.vibrationData = data);
    }

    /**
     * Calculates the fall damage based on fall distance and a damage multiplier.
     *
     * @param fallDistance     the distance the entity has fallen, in blocks
     * @param damageMultiplier the multiplier to apply to the fall damage calculation
     * @return the amount of damage to apply as a result of the fall
     */
    @Override
    public int calculateFallDamage(float fallDistance, float damageMultiplier) {
        if (fallDistance <= 15)
            return 0;
        return super.calculateFallDamage(fallDistance, damageMultiplier);
    }

    /**
     * Retrieves the maximum fall distance the AlienEntity can fall without taking damage.
     *
     * @return the maximum fall distance in blocks
     */
    @Override
    public int getMaxFallDistance() {
        return 9;
    }

    /**
     * Handle Pathfinding
     */
    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new AmphibiousPathNavigation(this, level);
    }

    /**
     * Handle making the entity unridable
     */
    @Override
    protected boolean canRide(@NotNull Entity vehicle) {
        return false;
    }

    /**
     * Handle despawn rules
     */
    @Override
    public boolean requiresCustomPersistence() {
        return true;
    }

    /**
     * Checks and handles the conditions under which the AlienEntity should be despawned. This method overrides the base
     * entity's despawn logic and performs custom checks related to the AlienEntity's specific behaviors and states.
     */
    @Override
    public void checkDespawn() {}

    /**
     * Handle acid spawning on death
     */
    @Override
    public void die(@NotNull DamageSource source) {
        if (source == damageSources().genericKill()) {
            super.die(source);
            return;
        }

        var damageCheck = !this.level().isClientSide && source != damageSources().genericKill() || source != damageSources().generic();
        if (damageCheck) {
            if (getAcidDiameter() == 1)
                EntityUtil.generateAcidPool(this, this.blockPosition(), 0, 0);
            else {
                var radius = (getAcidDiameter() - 1) / 2;
                for (var i = 0; i < getAcidDiameter(); i++) {
                    var x = this.level().getRandom().nextInt(getAcidDiameter()) - radius;
                    var z = this.level().getRandom().nextInt(getAcidDiameter()) - radius;
                    if (source != damageSources().genericKill() || source != damageSources().generic())
                        EntityUtil.generateAcidPool(this, this.blockPosition(), x, z);
                }
            }
        }
        super.die(source);
    }

    /**
     *
     */
    @Override
    protected @NotNull SoundEvent getSwimSplashSound() {
        return SoundEvents.DOLPHIN_SPLASH;
    }

    /**
     *
     */
    @Override
    protected @NotNull SoundEvent getSwimSound() {
        return SoundEvents.DOLPHIN_SWIM;
    }

    /**
     * Handle entity being pushable
     */
    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    /**
     * Determines if the AlienEntity is pushable.
     *
     * @return false, indicating that the AlienEntity is not pushable.
     */
    @Override
    public boolean isPushable() {
        return false;
    }

    /**
     * Determines whether the AlienEntity can target a given entity based on various conditions.
     *
     * @param entity The entity to be evaluated as a potential target. This can be null.
     * @return true if the entity meets the criteria to be targeted, false otherwise.
     */
    @Contract(value = "null->false")
    public boolean canTargetEntity(@Nullable Entity entity) {
        if (!(entity instanceof LivingEntity livingEntity))
            return false;
        if (this.level() != entity.level())
            return false;
        if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(entity))
            return false;
        if (livingEntity.hasEffect(AVPRStatusEffects.IMPREGNATION))
            return false;
        if (this.isVehicle())
            return false;
        if (this.isAlliedTo(entity))
            return false;
        if (!livingEntity.getType().is(AVPREntityTags.HOSTS))
            return false;
        if (livingEntity.getType().is(EntityTypeTags.UNDEAD))
            return false;
        if (livingEntity.getType() == EntityType.ARMOR_STAND)
            return false;
        if (livingEntity.getType() == EntityType.WARDEN)
            return false;
        if (livingEntity instanceof Bat)
            return false;
        if (livingEntity.isInvulnerable())
            return false;
        if (livingEntity.isDeadOrDying())
            return false;
        if (!this.level().getWorldBorder().isWithinBounds(livingEntity.getBoundingBox()))
            return false;
        if (
            livingEntity.getVehicle() != null && livingEntity.getVehicle()
                .getSelfAndPassengers()
                .anyMatch(
                    AlienEntity.class::isInstance
                )
        )
            return false;
        if (livingEntity.getType().is(AVPREntityTags.ALIENS))
            return false;
        if (this.isAggressive())
            return false;
        return this.level()
            .getBlockState(this.blockPosition().below())
            .isCollisionShapeFullBlock(
                level(),
                this.blockPosition().below()
            );
    }
}
