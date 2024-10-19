package org.avpr.common.entities.alien;

import com.mojang.logging.LogUtils;
import com.mojang.serialization.Dynamic;
import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import mod.azure.azurelib.common.api.common.entities.AzureVibrationUser;
import mod.azure.azurelib.common.api.common.interfaces.AzureTicker;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
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
import java.util.function.BiConsumer;

import org.avpr.common.api.common.GrowableInterface;
import org.avpr.common.api.util.EntityUtil;
import org.avpr.common.registries.AVPRStatusEffects;
import org.avpr.common.tags.AVPREntityTags;

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

    public AlienEntity(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
        this.vibrationUser = new AzureVibrationUser(this, 2.5F, 32);
        this.vibrationData = new Data();
        this.dynamicGameEventListener = new DynamicGameEventListener<>(new Listener(this));
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.5F, 1.0F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    @Override
    protected void registerGoals() {}

    public static boolean checkMonsterSpawnRules(
        EntityType<? extends WaterAnimal> type,
        ServerLevelAccessor level,
        MobSpawnType spawnType,
        BlockPos pos,
        RandomSource random
    ) {
        return level.getDifficulty() != Difficulty.PEACEFUL
            && (MobSpawnType.ignoresLightRequirements(spawnType) || isDarkEnoughToSpawn(level, pos, random))
            && checkMobSpawnRules(type, level, spawnType, pos, random);
    }

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
        return 2.5f;
    }

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

    @Override
    protected void customServerAiStep() {
        var serverLevel = (ServerLevel) this.level();
        super.customServerAiStep();
        if (this.tickCount % 20 == 0) {
            this.angerManagement.tick(serverLevel, this::canTargetEntity);
            this.syncClientAngerLevel();
        }
    }

    @Override
    public void tick() {
        super.tick();
        this.setAirSupply(this.getMaxAirSupply());
        if (level() instanceof ServerLevel serverLevel) {
            if (this.isAlive())
                this.grow(this, 1 * getGrowthMultiplier());
            if (this.isVehicle())
                this.setAggressive(false);
            AzureTicker.tick(serverLevel, this.vibrationData, this.vibrationUser);
        }
        if (this.tickCount % 10 == 0)
            this.refreshDimensions();
    }

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

    @Override
    public boolean dampensVibrations() {
        return true;
    }

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

    @Override
    public int calculateFallDamage(float fallDistance, float damageMultiplier) {
        if (fallDistance <= 15)
            return 0;
        return super.calculateFallDamage(fallDistance, damageMultiplier);
    }

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
                for (int i = 0; i < getAcidDiameter(); i++) {
                    int x = this.level().getRandom().nextInt(getAcidDiameter()) - radius;
                    int z = this.level().getRandom().nextInt(getAcidDiameter()) - radius;
                    if (source != damageSources().genericKill() || source != damageSources().generic())
                        EntityUtil.generateAcidPool(this, this.blockPosition(), x, z);
                }
            }
        }
        super.die(source);
    }

    /**
     * Handle entity being pushable
     */
    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    @Override
    public boolean isPushable() {
        return false;
    }

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
