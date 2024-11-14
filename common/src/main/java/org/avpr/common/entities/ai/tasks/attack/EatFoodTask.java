package org.avpr.common.entities.ai.tasks.attack;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.sblforked.api.core.behaviour.DelayedBehaviour;
import mod.azure.azurelib.sblforked.registry.SBLMemoryTypes;
import mod.azure.azurelib.sblforked.util.BrainUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import org.avpr.common.api.util.Constants;
import org.avpr.common.entities.alien.AlienEntity;

/**
 * A task that enables an Alien Entity to locate and consume a nearby food item, ensuring specific conditions are met
 * before performing the action.
 *
 * @param <E> the type of AlienEntity this task applies to
 */
public class EatFoodTask<E extends AlienEntity> extends DelayedBehaviour<E> {

    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORY_REQUIREMENTS = ObjectArrayList.of(
        Pair.of(SBLMemoryTypes.NEARBY_ITEMS.get(), MemoryStatus.VALUE_PRESENT)
    );

    @Nullable
    protected LivingEntity target = null;

    public EatFoodTask(int delayTicks) {
        super(delayTicks);
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E entity) {
        return entity.isAlive();
    }

    @Override
    protected void stop(E entity) {
        entity.swinging = false;
    }

    /**
     * Executes a delayed action where the entity attempts to consume a nearby item if certain conditions are met. If
     * the item is within reach, the entity will stop moving, play an eating animation, and consume the item to grow. If
     * the item is not within reach, the entity will start moving towards the item's position.
     *
     * @param entity the entity performing the delayed action
     */
    @Override
    protected void doDelayedAction(E entity) {
        var foodItem = entity.getBrain().getMemory(SBLMemoryTypes.NEARBY_ITEMS.get()).orElse(null);
        if (foodItem != null && foodItem.stream().findFirst().isPresent() && !entity.isAggressive()) {
            var blockPos = foodItem.stream().findFirst().get().blockPosition();
            var item = foodItem.stream().findFirst().get();
            // Check if the block is within the entity's view direction and reachable via pathfinding
            if (entity.distanceToSqr(foodItem.stream().findFirst().get()) < 1) {
                entity.getNavigation().stop();
                entity.swinging = true;
                // TODO: String literals shouldn't be used like this. What if the anim name changes?
                entity.triggerAnim(Constants.ATTACK_CONTROLLER, "animation.eat");
                item.getItem().finishUsingItem(entity.level(), entity);
                item.getItem().shrink(1);
                entity.grow(entity, 1200.0f);
            } else {
                this.startMovingToTarget(entity, blockPos);
            }
        }
    }

    /**
     * Initiates the movement of the alien entity towards the specified target position.
     *
     * @param alien     the alien entity that needs to move.
     * @param targetPos the position that the alien entity should move to.
     */
    private void startMovingToTarget(E alien, BlockPos targetPos) {
        BrainUtils.setMemory(alien, MemoryModuleType.WALK_TARGET, new WalkTarget(targetPos, 3.7F, 0));
    }
}
