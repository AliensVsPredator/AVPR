package org.avpr.common.entities.ai.tasks.movement;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.sblforked.api.core.behaviour.ExtendedBehaviour;
import mod.azure.azurelib.sblforked.registry.SBLMemoryTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.tags.AVPRBlockTags;

/**
 * FleeFireTask is a custom task for AlienEntity that makes the entity flee from nearby lava blocks. The task will make
 * the entity move away from detected lava by setting appropriate walk targets.
 *
 * @param <E> the type of AlienEntity this task applies to
 */
public class FleeFireTask<E extends AlienEntity> extends ExtendedBehaviour<E> {

    private static final List<Pair<MemoryModuleType<?>, MemoryStatus>> MEMORY_REQUIREMENTS = ObjectArrayList.of(
        Pair.of(SBLMemoryTypes.NEARBY_BLOCKS.get(), MemoryStatus.VALUE_PRESENT)
    );

    protected final float speed;

    public FleeFireTask(float speed) {
        this.speed = speed;
    }

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements() {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected boolean checkExtraStartConditions(@NotNull ServerLevel serverLevel, AlienEntity pathfinderMob) {
        return !pathfinderMob.isAggressive() || !pathfinderMob.level().dimensionType().respawnAnchorWorks();
    }

    @Override
    protected void start(@NotNull ServerLevel level, AlienEntity entity, long gameTime) {
        entity.getBrain().eraseMemory(MemoryModuleType.WALK_TARGET);
        entity.getBrain().eraseMemory(MemoryModuleType.ATTACK_TARGET);
        entity.setFleeingStatus(true);
    }

    @Override
    protected void stop(@NotNull ServerLevel level, E entity, long gameTime) {
        entity.setFleeingStatus(false);
    }

    @Override
    protected boolean canStillUse(@NotNull ServerLevel level, @NotNull AlienEntity entity, long gameTime) {
        return true;
    }

    /**
     * Determines if the AlienEntity should flee from nearby lava blocks and sets the appropriate walk target to move
     * the entity away from the detected lava.
     *
     * @param level    the server level in which the entity resides
     * @param owner    the AlienEntity for which the task is being executed
     * @param gameTime the current game time
     */
    @Override
    protected void tick(@NotNull ServerLevel level, AlienEntity owner, long gameTime) {
        if (owner.level().dimensionType().piglinSafe())
            return;
        var mobPos = owner.blockPosition();
        var searchRadius = 5; // Define the radius to search for lava blocks
        var isLavaNearby = false;
        var runAwayDirection = new Vec3(0, 0, 0);

        // Iterate through blocks around the mob to detect lava
        for (
            var pos : BlockPos.betweenClosed(mobPos.offset(-searchRadius, -1, -searchRadius), mobPos.offset(searchRadius, 1, searchRadius))
        ) {
            if (level.getBlockState(pos).is(AVPRBlockTags.ALIEN_REPELLENTS)) {
                isLavaNearby = true;
                // Calculate a direction away from the lava block
                var lavaPos = Vec3.atCenterOf(pos);
                runAwayDirection = runAwayDirection.add(owner.position().subtract(lavaPos).normalize());
            }
        }

        // If lava is nearby, set the walk target to move away from it
        if (isLavaNearby && owner.getNavigation().isDone()) {
            var panicPos = owner.position().add(runAwayDirection.normalize().scale(20.0)); // Scale to desired distance
            owner.getBrain().setMemory(MemoryModuleType.WALK_TARGET, new WalkTarget(panicPos, this.speed, 0));
        }
    }

}
