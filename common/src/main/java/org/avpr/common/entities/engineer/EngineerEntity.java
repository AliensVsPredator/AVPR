package org.avpr.common.entities.engineer;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.sblforked.api.SmartBrainOwner;
import mod.azure.azurelib.sblforked.api.core.BrainActivityGroup;
import mod.azure.azurelib.sblforked.api.core.SmartBrainProvider;
import mod.azure.azurelib.sblforked.api.core.behaviour.FirstApplicableBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.OneRandomBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.attack.AnimatableMeleeAttack;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.look.LookAtTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.misc.Idle;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.MoveToWalkTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.StrafeTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetRandomWalkTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.InvalidateAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.SetPlayerLookTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.SetRandomLookTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.TargetOrRetaliate;
import mod.azure.azurelib.sblforked.api.core.sensor.ExtendedSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.custom.NearbyBlocksSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.custom.UnreachableTargetSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.HurtBySensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.NearbyPlayersSensor;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import org.avpr.common.CommonMod;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.tags.AVPREntityTags;

public class EngineerEntity extends WaterAnimal implements Enemy, GeoEntity, SmartBrainOwner<EngineerEntity> {

    private static final EntityDataAccessor<Integer> ENGINEER_TYPE = SynchedEntityData.defineId(
        EngineerEntity.class,
        EntityDataSerializers.INT
    );

    private static final EntityDataAccessor<Boolean> HAS_HELMET = SynchedEntityData.defineId(
        EngineerEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public EngineerEntity(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.ATTACK_DAMAGE, CommonMod.config.engineerConfigs.ENGINEER_ATTACK)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.85)
            .add(Attributes.MAX_HEALTH, CommonMod.config.engineerConfigs.ENGINEER_HEALTH)
            .add(Attributes.MOVEMENT_SPEED, CommonMod.config.engineerConfigs.ENGINEER_SPEED);
    }

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
            && MobSpawnType.ignoresLightRequirements(spawnType)
            && checkMobSpawnRules(type, level, spawnType, pos, random);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ENGINEER_TYPE, this.random.nextInt(2));
        builder.define(HAS_HELMET, this.random.nextBoolean());
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("hasHelmet", this.hasHelmet());
        compound.putInt("suitType", this.getSuitType());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setHelmetStatus(compound.getBoolean("hasHelmet"));
        this.setSuitType(compound.getInt("suitType"));
    }

    public void setHelmetStatus(boolean hasHelmet) {
        entityData.set(HAS_HELMET, hasHelmet);
    }

    public boolean hasHelmet() {
        return this.entityData.get(HAS_HELMET);
    }

    public void setSuitType(int suitType) {
        entityData.set(ENGINEER_TYPE, suitType);
    }

    public int getSuitType() {
        return this.entityData.get(ENGINEER_TYPE);
    }

    @Override
    public void tick() {
        super.tick();
        this.setAirSupply(this.getMaxAirSupply());
    }

    @Override
    protected Brain.@NotNull Provider<?> brainProvider() {
        return new SmartBrainProvider<>(this);
    }

    @Override
    protected void customServerAiStep() {
        tickBrain(this);
        super.customServerAiStep();
    }

    @Override
    public List<? extends ExtendedSensor<EngineerEntity>> getSensors() {
        return ObjectArrayList.of(
            new NearbyPlayersSensor<>(),
            new NearbyLivingEntitySensor<EngineerEntity>().setPredicate(
                (target, self) -> !(target instanceof Creeper || target instanceof IronGolem)
            ),
            new NearbyBlocksSensor<EngineerEntity>().setRadius(7),
            new UnreachableTargetSensor<>(),
            new HurtBySensor<>()
        );
    }

    @Override
    public BrainActivityGroup<EngineerEntity> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
            new LookAtTarget<>(),
            new StrafeTarget<>()
                .stopStrafingWhen(entity -> this.getMainHandItem().isEmpty())
                .startCondition(entity -> !this.getMainHandItem().isEmpty()),
            new MoveToWalkTarget<>()
        );
    }

    @Override
    public BrainActivityGroup<EngineerEntity> getIdleTasks() {
        return BrainActivityGroup.idleTasks(
            new FirstApplicableBehaviour<>(
                new TargetOrRetaliate<>(),
                new SetPlayerLookTarget<>().predicate(
                    target -> target.isAlive() && !PredicatesUtil.IS_CREATIVEorSPECTATOR.test(target)
                ),
                new SetRandomLookTarget<>()
            ),
            new OneRandomBehaviour<>(
                new SetRandomWalkTarget<>().dontAvoidWater().setRadius(20).speedModifier(0.65f),
                new Idle<>().runFor(entity -> entity.getRandom().nextInt(30, 60))
            )
        );
    }

    @Override
    public BrainActivityGroup<EngineerEntity> getFightTasks() {
        return BrainActivityGroup.fightTasks(
            new InvalidateAttackTarget<>().invalidateIf(
                (entity, target) -> target.getType().is(AVPREntityTags.ENGINEERS)
            ),
            new SetWalkTargetToAttackTarget<>().speedMod((owner, target) -> 1.85F)
                .startCondition(entity -> this.getMainHandItem().isEmpty()),
            new AnimatableMeleeAttack<>(6)
        );
    }
}
