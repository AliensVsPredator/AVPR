package org.avpr.common.entities.alien.base_line;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.sblforked.api.SmartBrainOwner;
import mod.azure.azurelib.sblforked.api.core.BrainActivityGroup;
import mod.azure.azurelib.sblforked.api.core.SmartBrainProvider;
import mod.azure.azurelib.sblforked.api.core.behaviour.FirstApplicableBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.OneRandomBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.look.LookAtTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.misc.Idle;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.MoveToWalkTarget;
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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import org.avpr.common.CommonMod;
import org.avpr.common.api.util.*;
import org.avpr.common.entities.ai.AVPRVibrationUser;
import org.avpr.common.entities.ai.tasks.attack.FacePounceTask;
import org.avpr.common.entities.ai.tasks.movement.FleeFireTask;
import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.registries.AVPRSounds;
import org.avpr.common.registries.AVPRStatusEffects;
import org.avpr.common.tags.AVPRBlockTags;
import org.avpr.common.tags.AVPREntityTags;

public class FacehuggerEntity extends AlienEntity implements SmartBrainOwner<FacehuggerEntity> {

    public static final EntityDataAccessor<Boolean> EGGSPAWN = SynchedEntityData.defineId(
        FacehuggerEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> IS_INFERTILE = SynchedEntityData.defineId(
        FacehuggerEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public float ticksAttachedToHost = -1.0f;

    public FacehuggerEntity(EntityType<? extends AlienEntity> entityType, Level level) {
        super(entityType, level);
        this.vibrationUser = new AVPRVibrationUser(this, 1.2F);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.05F, 1.0F, true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, CommonMod.config.facehuggerConfigs.FACEHUGGER_HEALTH)
            .add(
                Attributes.ARMOR,
                1.0
            )
            .add(Attributes.ARMOR_TOUGHNESS, 0.0)
            .add(
                Attributes.KNOCKBACK_RESISTANCE,
                1.0
            )
            .add(Attributes.ATTACK_KNOCKBACK, 0.0)
            .add(Attributes.ATTACK_DAMAGE, 0.0)
            .add(
                Attributes.FOLLOW_RANGE,
                32.0
            )
            .add(Attributes.MOVEMENT_SPEED, CommonMod.config.facehuggerConfigs.FACEHUGGER_SPEED);
    }

    @Override
    public int getAcidDiameter() {
        return this.isPassenger() ? 0 : 1;
    }

    public boolean isEggSpawn() {
        return this.entityData.get(EGGSPAWN);
    }

    public void setEggSpawnState(boolean state) {
        this.entityData.set(EGGSPAWN, state);
    }

    public boolean isInfertile() {
        return entityData.get(IS_INFERTILE);
    }

    public void setIsInfertile(boolean value) {
        entityData.set(IS_INFERTILE, value);
    }

    @Override
    public void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(IS_INFERTILE, false);
        builder.define(EGGSPAWN, false);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        nbt.putBoolean("isInfertile", isInfertile());
        nbt.putFloat("ticksAttachedToHost", ticksAttachedToHost);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        if (nbt.contains("isInfertile"))
            setIsInfertile(nbt.getBoolean("isInfertile"));
        if (nbt.contains("ticksAttachedToHost"))
            ticksAttachedToHost = nbt.getFloat("ticksAttachedToHost");
    }

    public void detachFromHost() {
        this.ticksAttachedToHost = -1.0f;
        this.unRide();
    }

    public boolean isAttachedToHost() {
        return this.getVehicle() instanceof LivingEntity;
    }

    public void handleAttachmentToHost() {
        if (isAttachedToHost()) {
            ticksAttachedToHost += 1;

            if (!(this.getVehicle() instanceof LivingEntity livingEntity))
                return;

            livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1000, 10, false, false));
            if (livingEntity.getHealth() > livingEntity.getMaxHealth())
                livingEntity.heal(6);
            if (getVehicle() instanceof Player player && player.getFoodData().needsFood())
                player.getFoodData().setFoodLevel(20);
            if (ticksAttachedToHost > CommonMod.config.facehuggerConfigs.FACEHUGGER_ATTACH_TIME_IN_TICKS) {
                // if (getVehicle() instanceof Player player && player instanceof ServerPlayer serverPlayer) {
                // var advancement = serverPlayer.server.getAdvancements().get(CommonMod.modResource("facehugged"));
                // if (advancement != null && !serverPlayer.getAdvancements().getOrStartProgress(advancement).isDone())
                // {
                // for (var s : serverPlayer.getAdvancements().getOrStartProgress(advancement).getRemainingCriteria()) {
                // serverPlayer.getAdvancements().award(advancement, s);
                // }
                // }
                // }
                if (livingEntity.hasEffect(MobEffects.BLINDNESS))
                    livingEntity.removeEffect(MobEffects.BLINDNESS);
                if (!livingEntity.hasEffect(AVPRStatusEffects.IMPREGNATION))
                    livingEntity.addEffect(
                        new MobEffectInstance(
                            AVPRStatusEffects.IMPREGNATION,
                            CommonMod.config.facehuggerConfigs.FACEHUGGER_IMPREG_TIMER,
                            0,
                            false,
                            true
                        )
                    );
                if (!level().isClientSide)
                    this.level().playSound(this, this.blockPosition(), AVPRSounds.IMPREGNATE.get(), SoundSource.HOSTILE, 1.0F, 1.0F);
                setIsInfertile(true);
                this.unRide();
                this.hurt(damageSources().genericKill(), Float.MAX_VALUE);
            }

            if (livingEntity.hasEffect(AVPRStatusEffects.IMPREGNATION)) {
                if (livingEntity.hasEffect(MobEffects.BLINDNESS))
                    livingEntity.removeEffect(MobEffects.BLINDNESS);
                detachFromHost();
                setIsInfertile(true);
                this.kill();
            }

            if (PredicatesUtil.IS_CREATIVEorSPECTATOR.test(livingEntity)) {
                detachFromHost();
                setIsInfertile(true);
                this.kill();
            }
        } else
            ticksAttachedToHost = -1.0f;
    }

    @Override
    public void stopRiding() {
        if (
            this.getVehicle() != null && this.getVehicle() instanceof LivingEntity livingEntity && livingEntity.isAlive()
                && ticksAttachedToHost < Tick.PER_MINUTE * 5 && isInWater()
        )
            return;
        super.stopRiding();
    }

    public void grabTarget(LivingEntity entity) {
        this.startRiding(entity, true);
        this.setAggressive(false);
        entity.xxa = 0;
        entity.zza = 0;
        entity.yya = 0;
        entity.yBodyRot = 0;
        entity.setSpeed(0.0f);
        if (CommonMod.config.facehuggerConfigs.FACEHUGGER_GIVE_BLINDNESS)
            entity.addEffect(
                new MobEffectInstance(
                    MobEffects.BLINDNESS,
                    (int) CommonMod.config.facehuggerConfigs.FACEHUGGER_ATTACH_TIME_IN_TICKS,
                    0
                )
            );
        if (entity instanceof ServerPlayer player && (!player.isCreative() || !player.isSpectator()))
            player.connection.send(new ClientboundSetPassengersPacket(entity));
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        var multiplier = 1.0f;

        if (source == this.damageSources().onFire())
            multiplier = 2.0f;

        if ((isAttachedToHost() || isInfertile()) && (source == damageSources().drown()))
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
        return super.hurt(source, amount * multiplier);
    }

    @Override
    public void knockback(double strength, double x, double z) {
        if (!isInfertile())
            super.knockback(strength, x, z);
    }

    @Override
    public void tick() {
        super.tick();
        this.handleAttachmentToHost();
        if (isInfertile()) {
            this.kill();
            this.removeAllGoals(goals -> true);
            this.getBrain().removeAllBehaviors();
            return;
        }
        if (this.isEggSpawn() && this.tickCount > 30)
            this.setEggSpawnState(false);
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
    public List<ExtendedSensor<FacehuggerEntity>> getSensors() {
        return ObjectArrayList.of(
            new NearbyPlayersSensor<>(),
            new NearbyLivingEntitySensor<FacehuggerEntity>().setPredicate(
                (target, self) -> !(target instanceof Creeper || target instanceof IronGolem) && !target.getType()
                    .is(
                        EntityTypeTags.UNDEAD
                    ) && !target.getType().is(AVPREntityTags.ALIENS) && target.getType()
                        .is(
                            AVPREntityTags.HOSTS
                        )
            ),
            new NearbyBlocksSensor<FacehuggerEntity>().setRadius(7)
                .setPredicate(
                    (block, entity) -> block.is(AVPRBlockTags.ALIEN_REPELLENTS)
                ),
            new NearbyBlocksSensor<FacehuggerEntity>().setRadius(7),
            new UnreachableTargetSensor<>(),
            new HurtBySensor<>()
        );
    }

    @Override
    public BrainActivityGroup<FacehuggerEntity> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
            new FleeFireTask<>(2.2F),
            new LookAtTarget<>(),
            new MoveToWalkTarget<>().stopIf(entity -> this.isFleeing())
        );
    }

    @SuppressWarnings("unchecked")
    @Override
    public BrainActivityGroup<FacehuggerEntity> getIdleTasks() {
        return BrainActivityGroup.idleTasks(
            new FirstApplicableBehaviour<FacehuggerEntity>(
                new TargetOrRetaliate<>().stopIf(entity -> this.isFleeing()),
                new SetPlayerLookTarget<>().predicate(
                    target -> target.isAlive() && (!target.isCreative() || !target.isSpectator())
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
    public BrainActivityGroup<FacehuggerEntity> getFightTasks() {
        return BrainActivityGroup.fightTasks(
            new InvalidateAttackTarget<>().invalidateIf(
                (entity, target) -> PredicatesUtil.SHOULD_REMOVE_TARGET.test(target) || this.isFleeing()
            ),
            new SetWalkTargetToAttackTarget<>().speedMod((owner, target) -> 1.85F),
            new FacePounceTask<>(6)
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, Constants.LIVING_CONTROLLER, event -> {
            if (event.isMoving())
                return event.setAndContinue(Constants.WALK);
            if (this.isPassenger())
                return event.setAndContinue(Constants.FACEHUG);
            return event.setAndContinue(Constants.TAIL_SWAY);
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public float getMaxGrowth() {
        return 0;
    }

    @Override
    public LivingEntity growInto() {
        return null;
    }
}
