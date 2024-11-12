package org.avpr.common.entities.ai.tasks.attack;

import mod.azure.azurelib.sblforked.util.BrainUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.projectile.ProjectileUtil;

import org.avpr.common.api.util.EntityUtil;
import org.avpr.common.entities.ai.tasks.AnimatableRangeTask;
import org.avpr.common.registries.AVPRItems;

public class UseItemTask<E extends LivingEntity> extends AnimatableRangeTask<E> {

    public UseItemTask(int delayTicks) {
        super(delayTicks);
    }

    /**
     * Initiates the start of the task by making the entity look at its target and start using an appropriate item.
     *
     * @param entity The entity that will be starting the task.
     */
    @Override
    protected void start(E entity) {
        BehaviorUtils.lookAtEntity(entity, this.target);
        entity.startUsingItem(ProjectileUtil.getWeaponHoldingHand(entity, entity.getMainHandItem().getItem()));
    }

    /**
     * Executes a delayed action for the given entity. This method is invoked after a specified delay and performs an
     * attack if the entity's target is visible and within attack range.
     *
     * @param entity the entity performing the delayed action
     */
    @Override
    protected void doDelayedAction(E entity) {
        if (this.target == null)
            return;

        if (!BrainUtils.canSee(entity, this.target) || entity.distanceToSqr(this.target) > this.attackRadius)
            return;
        if (entity.getMainHandItem().is(AVPRItems.SMART_DISC.get()))
            EntityUtil.shootSmartDisc(entity);
        if (entity.getMainHandItem().is(AVPRItems.SHURIKEN.get()))
            EntityUtil.shootShuriken(entity);
        BrainUtils.setForgettableMemory(entity, MemoryModuleType.ATTACK_COOLING_DOWN, true, this.attackIntervalSupplier.applyAsInt(entity));
    }
}
