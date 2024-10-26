package org.avpr.common.entities.alien.base_line;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
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
import mod.azure.azurelib.sblforked.api.core.sensor.custom.NearbyItemsSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.custom.UnreachableTargetSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.HurtBySensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.NearbyPlayersSensor;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import org.avpr.common.CommonMod;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.entities.ai.tasks.movement.FleeFireTask;
import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.registries.AVPRStatusEffects;
import org.avpr.common.tags.AVPRBlockTags;
import org.avpr.common.tags.AVPREntityTags;

public class UltramorphEntity extends AlienEntity implements SmartBrainOwner<UltramorphEntity> {

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public UltramorphEntity(EntityType<? extends AlienEntity> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.ATTACK_DAMAGE, CommonMod.config.ultramorphConfigs.ULTRAMORPH_ATTACK)
            .add(Attributes.MAX_HEALTH, CommonMod.config.ultramorphConfigs.ULTRAMORPH_HEALTH)
            .add(Attributes.MOVEMENT_SPEED, CommonMod.config.ultramorphConfigs.ULTRAMORPH_SPEED);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

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

    @Override
    public int getAcidDiameter() {
        return 3;
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
    public List<? extends ExtendedSensor<UltramorphEntity>> getSensors() {
        return ObjectArrayList.of(
            new NearbyPlayersSensor<>(),
            new NearbyLivingEntitySensor<UltramorphEntity>().setPredicate(
                (target, self) -> !(target instanceof Creeper || target instanceof IronGolem) && !target.getType()
                    .is(
                        EntityTypeTags.UNDEAD
                    ) && target.getType()
                        .is(
                            AVPREntityTags.HOSTS
                        )
            ),
            new NearbyBlocksSensor<UltramorphEntity>().setRadius(7)
                .setPredicate(
                    (block, entity) -> block.is(AVPRBlockTags.ALIEN_REPELLENTS)
                ),
            new NearbyItemsSensor<>(),
            new UnreachableTargetSensor<>(),
            new HurtBySensor<>()
        );
    }

    @Override
    public BrainActivityGroup<UltramorphEntity> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
            new FleeFireTask<>(1.0f),
            new LookAtTarget<>(),
            new StrafeTarget<>().stopStrafingWhen(entity -> entity.isWithinMeleeAttackRange(this)),
            new MoveToWalkTarget<>()
        );
    }

    @SuppressWarnings("unchecked")
    @Override
    public BrainActivityGroup<UltramorphEntity> getIdleTasks() {
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
    public BrainActivityGroup<UltramorphEntity> getFightTasks() {
        return BrainActivityGroup.fightTasks(
            new InvalidateAttackTarget<>().invalidateIf(
                (alienEntity, target) -> target.getType().is(AVPREntityTags.ALIENS) || target.isDeadOrDying() || target.hasPassenger(
                    AlienEntity.class::isInstance
                ) || target.hasEffect(AVPRStatusEffects.IMPREGNATION)
            ),
            new SetWalkTargetToAttackTarget<>().speedMod((owner, target) -> 1.85F),
            new AnimatableMeleeAttack<>(6)
        );
    }
}
