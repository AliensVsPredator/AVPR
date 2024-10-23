package org.avpr.common.entities.ai.tasks;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.sblforked.api.core.behaviour.DelayedBehaviour;
import mod.azure.azurelib.sblforked.util.BrainUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

public class AnimatableRangeTask<E extends LivingEntity> extends DelayedBehaviour<E> {

    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORY_REQUIREMENTS = ObjectArrayList.of(
        Pair.of(MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT),
        Pair.of(MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT)
    );

    protected ToIntFunction<E> attackIntervalSupplier = entity -> entity.level().getDifficulty() == Difficulty.HARD ? 20 : 40;

    protected float attackRadius;

    @Nullable
    protected LivingEntity target = null;

    public AnimatableRangeTask(int delayTicks) {
        super(delayTicks);

        attackRadius(16);
    }

    /**
     * Set the time between attacks.
     *
     * @param supplier The tick value provider
     * @return this
     */
    public AnimatableRangeTask<E> attackInterval(ToIntFunction<E> supplier) {
        this.attackIntervalSupplier = supplier;

        return this;
    }

    /**
     * Set the radius in blocks that the entity should be able to fire on targets.
     *
     * @param radius The radius, in blocks
     */
    public void attackRadius(float radius) {
        this.attackRadius = radius * radius;
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORY_REQUIREMENTS;
    }

    /**
     * Checks additional conditions required for the task to start.
     *
     * @param level  The current server level.
     * @param entity The entity for which the conditions are being checked.
     * @return true if conditions are met to start the task, false otherwise.
     */
    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E entity) {
        this.target = BrainUtils.getTargetOfEntity(entity);

        return BrainUtils.canSee(entity, this.target) && entity.distanceToSqr(this.target) <= this.attackRadius;
    }

    /**
     * Begins the attack sequence by making the entity perform a swing action and orient towards the target.
     *
     * @param entity The entity that will be starting the attack sequence.
     */
    @Override
    protected void start(E entity) {
        entity.swing(InteractionHand.MAIN_HAND);
        BehaviorUtils.lookAtEntity(entity, this.target);
    }

    /**
     * Stops the current task by resetting the target to null.
     *
     * @param entity The entity for which the task is being stopped.
     */
    @Override
    protected void stop(E entity) {
        this.target = null;
    }

    /**
     * Executes a delayed action involving an attack on a target entity, provided certain conditions are met.
     *
     * @param entity The entity performing the delayed action.
     */
    @Override
    protected void doDelayedAction(E entity) {
        if (this.target == null)
            return;

        if (!BrainUtils.canSee(entity, this.target) || entity.distanceToSqr(this.target) > this.attackRadius)
            return;

        BrainUtils.setForgettableMemory(entity, MemoryModuleType.ATTACK_COOLING_DOWN, true, this.attackIntervalSupplier.applyAsInt(entity));
    }
}
