package org.avpr.common.entities.yautja;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.common.api.common.ai.pathing.AzureNavigation;
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
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.AmphibiousPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.avpr.common.api.util.Tick;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

import org.avpr.common.CommonMod;
import org.avpr.common.api.util.Constants;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.entities.ai.tasks.attack.UseItemTask;
import org.avpr.common.registries.AVPRItems;
import org.avpr.common.registries.AVPRSounds;
import org.avpr.common.tags.AVPREntityTags;
import org.avpr.common.tags.AVPRItemTags;

public class YautjaEntity extends WaterAnimal implements Enemy, GeoEntity, SmartBrainOwner<YautjaEntity> {

    private final Set<Float> triggeredThresholds = new HashSet<>();

    private long lastHealTick = 0;

    private static final EntityDataAccessor<Boolean> HAS_MASK = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_lEFT_LEG_ARMOR = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_RIGHT_LEG_ARMOR = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_lEFT_FOOT_ARMOR = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_RIGHT_FOOT_ARMOR = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_RIGHT_ARM_ARMOR = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_lEFT_FOREARM_ARMOR = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_RIGHT_FOREARM_ARMOR = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_CHESTARMOR = SynchedEntityData.defineId(
        YautjaEntity.class,
        EntityDataSerializers.BOOLEAN
    );

    private static final EntityDataAccessor<Boolean> HAS_BLADE = SynchedEntityData.defineId(
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
            && MobSpawnType.ignoresLightRequirements(spawnType) && pos.getY() > CommonMod.config.yautjaConfigs.YAUTJA_MIN_SPAWN_Y
            && checkMobSpawnRules(type, level, spawnType, pos, random);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, Constants.LIVING_CONTROLLER, 0, event -> {
            return event.getAnimatable().hasBlade()
                ? event.setAndContinue(Constants.BLADE_OPEN)
                : event.setAndContinue(Constants.BLADE_CLOSE);
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

    /**
     * Handle Pathfinding
     */
    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return this.isInWater() || this.wasTouchingWater ? new AmphibiousPathNavigation(this, level) : new AzureNavigation(this, level);
    }

    /**
     * Updates the YautjaEntity's state during each tick. This includes refreshing air supply, calculating current
     * health percentage, updating the entity based on its health, and managing equipment and armor statuses.
     * Specifically, the method performs the following actions: - Calls the superclass's tick method. - Resets the air
     * supply to its maximum value. - Calculates the current health percentage and updates the entity's state based on
     * this value. - Checks if the entity's main hand item is empty and if it is aggressive to determine if it should
     * have a blade. - Manages the entity's armor statuses based on its health percentage. - Heals the entity if its
     * health percentage is below 100 and it is not aggressive.
     */
    @Override
    public void tick() {
        super.tick();
        this.setAirSupply(this.getMaxAirSupply());
        var currentHealthPercentage = (this.getHealth() / this.getMaxHealth()) * 100;
        this.update(currentHealthPercentage);
        if (this.getMainHandItem().isEmpty() && this.isAggressive())
            this.setHasBlade(true);
        if (!this.getMainHandItem().isEmpty())
            this.setHasBlade(false);
        if (currentHealthPercentage == 100) {
            this.setHasleftLegArmor(true);
            this.setHasRightLegArmor(true);
            this.setHasleftFootArmor(true);
            this.setHasRightFootArmor(true);
            this.setHasRightArmArmor(true);
            this.setHasleftForearmArmor(true);
            this.setHasRightForearmArmor(true);
            this.setHasChestarmor(true);
        }
        if (currentHealthPercentage < 100 && !this.isAggressive() && (tickCount - lastHealTick >= Tick.PER_MINUTE / 2)) {
            this.heal(0.5F);
            lastHealTick = tickCount;
        }
    }

    /**
     * Finalizes the spawning of a {@link YautjaEntity} within the game world, applying various armor and equipment
     * statuses to the entity upon spawn.
     *
     * @param level          The server level accessor providing the context of the world where the entity is being
     *                       spawned.
     * @param difficulty     The current difficulty instance affecting the spawn conditions.
     * @param spawnType      The type of spawn that is being executed (natural, chunk generation, spawn egg, etc.).
     * @param spawnGroupData Data pertaining to the group this entity may be spawned with, if any.
     * @return The updated spawn group data after the entity has been spawned and modified, or null if none.
     */
    @Override
    public @Nullable SpawnGroupData finalizeSpawn(
        @NotNull ServerLevelAccessor level,
        @NotNull DifficultyInstance difficulty,
        @NotNull MobSpawnType spawnType,
        @Nullable SpawnGroupData spawnGroupData
    ) {
        this.setMaskStatus(true);
        this.setHasleftLegArmor(true);
        this.setHasRightLegArmor(true);
        this.setHasleftFootArmor(true);
        this.setHasRightFootArmor(true);
        this.setHasRightArmArmor(true);
        this.setHasleftForearmArmor(true);
        this.setHasRightForearmArmor(true);
        this.setHasChestarmor(true);
        this.setHasBlade(true);
        if (this.getRandom().nextInt(10) >= 4)
            setItemSlot(EquipmentSlot.MAINHAND, makeInitialWeapon());
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    private ItemStack makeInitialWeapon() {
        final var givenList = Arrays.asList(
            AVPRItems.SHURIKEN.get(),
            AVPRItems.SMART_DISC.get()
        );
        final var randomIndex = random.nextInt(givenList.size());
        final var randomElement = givenList.get(randomIndex);
        return randomElement.getDefaultInstance();
    }

    /**
     * Calculates the armor value of the entity based on its current health percentage and the base armor value.
     *
     * @return The adjusted armor value of the entity.
     */
    @Override
    public int getArmorValue() {
        var currentHealthPercentage = (this.getHealth() / this.getMaxHealth()) * 100;
        return (int) (currentHealthPercentage * super.getArmorValue());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(HAS_MASK, true);
        builder.define(HAS_lEFT_LEG_ARMOR, true);
        builder.define(HAS_RIGHT_LEG_ARMOR, true);
        builder.define(HAS_lEFT_FOOT_ARMOR, true);
        builder.define(HAS_RIGHT_FOOT_ARMOR, true);
        builder.define(HAS_RIGHT_ARM_ARMOR, true);
        builder.define(HAS_lEFT_FOREARM_ARMOR, true);
        builder.define(HAS_RIGHT_FOREARM_ARMOR, true);
        builder.define(HAS_CHESTARMOR, true);
        builder.define(HAS_BLADE, true);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("hasMask", this.hasMask());
        compound.putBoolean("hasLeftLegArmor", this.hasleftLegArmor());
        compound.putBoolean("hasRightLegArmor", this.hasRightLegArmor());
        compound.putBoolean("hasLeftFootArmor", this.hasLeftFootArmor());
        compound.putBoolean("hasRightFootArmor", this.hasRightFootArmor());
        compound.putBoolean("hasRightArmArmor", this.hasRightArmArmor());
        compound.putBoolean("hasLeftForearmArmor", this.hasleftForearmArmor());
        compound.putBoolean("hasRightForearmArmor", this.hasRightForearmArmor());
        compound.putBoolean("hasChestArmor", this.hasChestArmor());
        compound.putBoolean("hasBlade", this.hasBlade());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setMaskStatus(compound.getBoolean("hasMask"));
        this.setHasleftLegArmor(compound.getBoolean("hasLeftLegArmor"));
        this.setHasRightLegArmor(compound.getBoolean("hasRightLegArmor"));
        this.setHasleftFootArmor(compound.getBoolean("hasLeftFootArmor"));
        this.setHasRightFootArmor(compound.getBoolean("hasRightFootArmor"));
        this.setHasRightArmArmor(compound.getBoolean("hasRightArmArmor"));
        this.setHasleftForearmArmor(compound.getBoolean("hasLeftForearmArmor"));
        this.setHasRightForearmArmor(compound.getBoolean("hasRightForearmArmor"));
        this.setHasChestarmor(compound.getBoolean("hasChestArmor"));
        this.setHasBlade(compound.getBoolean("hasBlade"));
    }

    public void setMaskStatus(boolean hasHelmet) {
        entityData.set(HAS_MASK, hasHelmet);
    }

    public boolean hasMask() {
        return this.entityData.get(HAS_MASK);
    }

    public void setHasleftLegArmor(boolean hasleftLegArmor) {
        entityData.set(HAS_lEFT_LEG_ARMOR, hasleftLegArmor);
    }

    public boolean hasleftLegArmor() {
        return this.entityData.get(HAS_lEFT_LEG_ARMOR);
    }

    public void setHasRightLegArmor(boolean hasRightLegArmor) {
        entityData.set(HAS_RIGHT_LEG_ARMOR, hasRightLegArmor);
    }

    public boolean hasRightLegArmor() {
        return this.entityData.get(HAS_RIGHT_LEG_ARMOR);
    }

    public void setHasleftFootArmor(boolean hasleftFootArmor) {
        entityData.set(HAS_lEFT_FOOT_ARMOR, hasleftFootArmor);
    }

    public boolean hasLeftFootArmor() {
        return this.entityData.get(HAS_lEFT_FOOT_ARMOR);
    }

    public void setHasRightFootArmor(boolean hasRightFootArmor) {
        entityData.set(HAS_RIGHT_FOOT_ARMOR, hasRightFootArmor);
    }

    public boolean hasRightFootArmor() {
        return this.entityData.get(HAS_RIGHT_FOOT_ARMOR);
    }

    public void setHasRightArmArmor(boolean hasRightArmArmor) {
        entityData.set(HAS_RIGHT_ARM_ARMOR, hasRightArmArmor);
    }

    public boolean hasRightArmArmor() {
        return this.entityData.get(HAS_RIGHT_ARM_ARMOR);
    }

    public void setHasleftForearmArmor(boolean hasleftForearmArmor) {
        entityData.set(HAS_lEFT_FOREARM_ARMOR, hasleftForearmArmor);
    }

    public boolean hasleftForearmArmor() {
        return this.entityData.get(HAS_lEFT_FOREARM_ARMOR);
    }

    public void setHasRightForearmArmor(boolean hasRightForearmArmor) {
        entityData.set(HAS_RIGHT_FOREARM_ARMOR, hasRightForearmArmor);
    }

    public boolean hasRightForearmArmor() {
        return this.entityData.get(HAS_RIGHT_FOREARM_ARMOR);
    }

    public void setHasChestarmor(boolean hasChestarmor) {
        entityData.set(HAS_CHESTARMOR, hasChestarmor);
    }

    public boolean hasChestArmor() {
        return this.entityData.get(HAS_CHESTARMOR);
    }

    public void setHasBlade(boolean hasBlade) {
        entityData.set(HAS_BLADE, hasBlade);
    }

    public boolean hasBlade() {
        return this.entityData.get(HAS_BLADE);
    }

    /**
     * Updates the entity's state based on its current health percentage. This method triggers the hiding of certain
     * bones when the health percentage falls within specified threshold ranges.
     *
     * @param currentHealthPercentage The current health percentage of the entity.
     */
    public void update(float currentHealthPercentage) {
        if (currentHealthPercentage <= 85 && currentHealthPercentage > 71)
            triggerBoneHiding(85);
        if (currentHealthPercentage <= 70 && currentHealthPercentage > 61)
            triggerBoneHiding(70);
        else if (currentHealthPercentage <= 61 && currentHealthPercentage > 53)
            triggerBoneHiding(61);
        else if (currentHealthPercentage <= 53 && currentHealthPercentage > 44)
            triggerBoneHiding(53);
        else if (currentHealthPercentage <= 44 && currentHealthPercentage > 35)
            triggerBoneHiding(44);
        else if (currentHealthPercentage <= 35 && currentHealthPercentage > 26)
            triggerBoneHiding(35);
        else if (currentHealthPercentage <= 26 && currentHealthPercentage > 18)
            triggerBoneHiding(26);
        else if (currentHealthPercentage <= 18 && currentHealthPercentage > 9)
            triggerBoneHiding(18);
    }

    /**
     * Triggers the hiding of bones when the entity's health percentage drops below a specified threshold. This method
     * ensures that each threshold is only triggered once.
     *
     * @param threshold The specific health percentage threshold that triggers the bone hiding mechanic.
     */
    private void triggerBoneHiding(float threshold) {
        if (!triggeredThresholds.contains(threshold)) {
            hideBones();
            triggeredThresholds.add(threshold);
        }
    }

    /**
     * Randomly hides one of the entity's armor pieces. This method gathers a list of actions to hide each specific
     * piece of armor and shuffles the list before running one of these actions. If the list is not empty, the first
     * action in the shuffled list is executed to hide the armor piece.
     */
    private void hideBones() {
        List<Runnable> hideActions = new ArrayList<>();
        hideActions.add(() -> setHasleftLegArmor(false));
        hideActions.add(() -> setHasRightLegArmor(false));
        hideActions.add(() -> setHasleftFootArmor(false));
        hideActions.add(() -> setHasRightFootArmor(false));
        hideActions.add(() -> setHasRightArmArmor(false));
        hideActions.add(() -> setHasleftForearmArmor(false));
        hideActions.add(() -> setHasChestarmor(false));
        hideActions.add(() -> setMaskStatus(false));
        Collections.shuffle(hideActions);
        if (!hideActions.isEmpty()) {
            hideActions.getFirst().run();
        }
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
                (target, yautjaEntity) -> !target.getType()
                    .is(
                        AVPREntityTags.PREDATORS
                    ) || !target.getType().is(AVPREntityTags.NOT_WORTH_KILLING)
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
            new StrafeTarget<YautjaEntity>()
                .stopStrafingWhen(yautjaEntity -> yautjaEntity.getMainHandItem().isEmpty())
                .startCondition(yautjaEntity -> !yautjaEntity.getMainHandItem().isEmpty()),
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
            new InvalidateAttackTarget<YautjaEntity>().invalidateIf(
                (yautjaEntity, target) -> target.getType().is(AVPREntityTags.PREDATORS) || target.getType()
                    .is(AVPREntityTags.NOT_WORTH_KILLING) || (!target.getType().is(AVPREntityTags.ALIENS) && (target.getMainHandItem()
                        .is(
                            AVPRItemTags.THREATENS_PREDATORS
                        ) && yautjaEntity.getLastAttacker() != target))
            ),
            new SetWalkTargetToAttackTarget<YautjaEntity>().startCondition(yautjaEntity -> yautjaEntity.getMainHandItem().isEmpty()),
            new UseItemTask<YautjaEntity>(20)
                .startCondition(yautjaEntity -> !yautjaEntity.getMainHandItem().is(Items.AIR)),
            new AnimatableMeleeAttack<YautjaEntity>(6).startCondition(
                entity -> entity.getMainHandItem().isEmpty() || (entity.getTarget() != null && entity.getBoundingBox()
                    .intersects(entity.getTarget().getBoundingBox()))
            )
                .whenStarting(
                    mob -> this.triggerAnim(
                        Constants.ATTACK_CONTROLLER,
                        "blade_attack"
                    )
                )
        );
    }
}
