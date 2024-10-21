package org.avpr.common.entities.yautja;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.object.PlayState;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import org.avpr.common.CommonMod;
import org.avpr.common.api.util.Constants;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.registries.AVPRSounds;
import org.avpr.common.tags.AVPREntityTags;

public class YautjaEntity extends WaterAnimal implements Enemy, GeoEntity, SmartBrainOwner<YautjaEntity> {

    private static final EntityDataAccessor<Boolean> HAS_MASK = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public YautjaEntity(EntityType<? extends WaterAnimal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.ATTACK_DAMAGE, CommonMod.config.yautjaConfigs.YAUTJA_ATTACK)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.75F)
            .add(Attributes.MAX_HEALTH, CommonMod.config.yautjaConfigs.YAUTJA_HEALTH)
            .add(Attributes.MOVEMENT_SPEED, CommonMod.config.yautjaConfigs.YAUTJA_SPEED);
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
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, Constants.LIVING_CONTROLLER, 0, event -> {
            if (this.isAggressive())
                return event.setAndContinue(Constants.BLADE_OPEN);
            return event.setAndContinue(Constants.BLADE_CLOSE);
        }).setSoundKeyframeHandler(event -> {
            if (level().isClientSide()) {
                if (event.getKeyframeData().getSound().matches("blade_closing"))
                    level().playLocalSound(
                        this.blockPosition(),
                        AVPRSounds.ITEM_WEAPON_WRISTBLADE_CLOSE.get(),
                        SoundSource.HOSTILE,
                        1,
                        1,
                        true
                    );
                if (event.getKeyframeData().getSound().matches("blade_opening"))
                    level().playLocalSound(
                        this.blockPosition(),
                        AVPRSounds.ITEM_WEAPON_WRISTBLADE_OPEN.get(),
                        SoundSource.HOSTILE,
                        1,
                        1,
                        true
                    );
            }
        }))
            .add(
                new AnimationController<>(this, Constants.ATTACK_CONTROLLER, 0, event -> PlayState.STOP).triggerableAnim(
                    "blade_attack",
                    Constants.BLADE_ATTACK
                )
            );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void tick() {
        super.tick();
        this.setAirSupply(this.getMaxAirSupply());
        var currentHealthPercentage = (this.getHealth() / this.getMaxHealth()) * 100;
        if (this.hasMask() && currentHealthPercentage <= 0.85)
            this.setMaskStatus(true);
    }

    @Override
    public int getArmorValue() {
        var currentHealthPercentage = (this.getHealth() / this.getMaxHealth()) * 100;
        return (int) (currentHealthPercentage * super.getArmorValue());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(HAS_MASK, true);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("hasMask", this.hasMask());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setMaskStatus(compound.getBoolean("hasMask"));
    }

    public void setMaskStatus(boolean hasHelmet) {
        entityData.set(HAS_MASK, hasHelmet);
    }

    public boolean hasMask() {
        return this.entityData.get(HAS_MASK);
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
    public List<? extends ExtendedSensor<YautjaEntity>> getSensors() {
        return ObjectArrayList.of(
            new NearbyPlayersSensor<>(),
            new NearbyLivingEntitySensor<YautjaEntity>().setPredicate(
                (target, self) -> !target.getType()
                    .is(
                        AVPREntityTags.PREDATORS
                    )
            ),
            new NearbyBlocksSensor<YautjaEntity>().setRadius(7),
            new UnreachableTargetSensor<>(),
            new HurtBySensor<>()
        );
    }

    @Override
    public BrainActivityGroup<YautjaEntity> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
            new LookAtTarget<>(),
            new StrafeTarget<>()
                .stopStrafingWhen(entity -> this.getMainHandItem().isEmpty())
                .startCondition(entity -> !this.getMainHandItem().isEmpty()),
            new MoveToWalkTarget<>()
        );
    }

    @SuppressWarnings("unchecked")
    @Override
    public BrainActivityGroup<YautjaEntity> getIdleTasks() {
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
    public BrainActivityGroup<YautjaEntity> getFightTasks() {
        return BrainActivityGroup.fightTasks(
            new InvalidateAttackTarget<>().invalidateIf(
                (entity, target) -> target.getType().is(AVPREntityTags.PREDATORS)
            ),
            new SetWalkTargetToAttackTarget<>().startCondition(entity -> this.getMainHandItem().isEmpty()),
            new AnimatableMeleeAttack<>(6).whenStarting(
                mob -> this.triggerAnim(
                    Constants.ATTACK_CONTROLLER,
                    "blade_attack"
                )
            )
        );
    }
}
