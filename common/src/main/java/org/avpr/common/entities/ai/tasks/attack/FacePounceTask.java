package org.avpr.common.entities.ai.tasks.attack;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.sblforked.util.BrainUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.ToIntFunction;

import org.avpr.common.api.util.AttackSelector;
import org.avpr.common.entities.ai.tasks.CustomDelayedMeleeBehaviour;
import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.tags.AVPREntityTags;

public class FacePounceTask<E extends FacehuggerEntity> extends CustomDelayedMeleeBehaviour<E> {

    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORY_REQUIREMENTS = ObjectArrayList.of(
        Pair.of(MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT),
        Pair.of(MemoryModuleType.ATTACK_COOLING_DOWN, MemoryStatus.VALUE_ABSENT)
    );

    protected ToIntFunction<E> attackIntervalSupplier = entity -> 80;

    @Nullable
    protected LivingEntity target = null;

    public FacePounceTask(int delayTicks) {
        super(delayTicks, AttackSelector.HUGGER_SELECTOR);
    }

    /**
     * Set the time between attacks.
     *
     * @param supplier The tick value provider
     * @return this
     */
    public FacePounceTask<E> attackInterval(ToIntFunction<E> supplier) {
        this.attackIntervalSupplier = supplier;

        return this;
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORY_REQUIREMENTS;
    }

    /**
     * Checks additional conditions before the entity can start an action.
     *
     * @param level  The server level in which the entity exists.
     * @param entity The entity performing the task.
     * @return true if all extra start conditions are met; false otherwise.
     */
    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E entity) {
        this.target = BrainUtils.getTargetOfEntity(entity);
        return target != null && target.getType().is(AVPREntityTags.HOSTS) && !target.getType().is(AVPREntityTags.ALIENS) && !target
            .hasPassenger(
                AlienEntity.class::isInstance
            ) && entity.isWithinMeleeAttackRange(
                this.target
            ) && !entity.getType().is(EntityTypeTags.UNDEAD);
    }

    @Override
    protected void start(E entity) {
        assert this.target != null;
        BehaviorUtils.lookAtEntity(entity, this.target);
    }

    @Override
    protected void stop(E entity) {
        this.target = null;
    }

    /**
     * Performs a delayed action on the entity, setting a memory state and attempting to grab the target entity if
     * conditions are met.
     *
     * @param entity The entity performing the delayed action.
     */
    @Override
    protected void doDelayedAction(E entity) {
        BrainUtils.setForgettableMemory(
            entity,
            MemoryModuleType.ATTACK_COOLING_DOWN,
            true,
            this.attackIntervalSupplier.applyAsInt(entity)
        );

        if (this.target == null)
            return;

        // Check if the target is within the entity's view direction and reachable via pathfinding
        if (!this.target.getUseItem().is(Items.SHIELD))
            entity.grabTarget(this.target);
    }
}
