package org.avpr.common.api.server;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.avpr.common.api.util.Tick;

/**
 * Manages the progress of block breaking actions in the game world. This class is responsible for handling the addition
 * and cleanup of block break progress entries.
 */
public class BlockBreakProgressManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlockBreakProgressManager.class);

    private static final Map<BlockPos, Map.Entry<Long, Float>> BLOCK_BREAK_PROGRESS_MAP = new HashMap<>();

    /**
     * Executes periodic tasks related to block break progress management in the game world. This method is intended to
     * be called every game tick and will perform cleanup operations on the block break progress map.
     *
     * @param level The Level object representing the game world, to obtain the current game time.
     */
    public static void tick(Level level) {
        var gameTime = level.getGameTime();
        if (gameTime % Tick.PER_MINUTE != 0) {
            return;
        }

        LOGGER.debug(
            "Cleaning block break progress map ({} entries)",
            BlockBreakProgressManager.BLOCK_BREAK_PROGRESS_MAP.size()
        );
        BlockBreakProgressManager.BLOCK_BREAK_PROGRESS_MAP.entrySet().removeIf(entry -> {
            var lastUpdateTimeMillis = entry.getValue().getKey();
            return System.currentTimeMillis() > lastUpdateTimeMillis;
        });
        LOGGER.debug(
            "Finished cleaning block break progress map ({} entries)",
            BlockBreakProgressManager.BLOCK_BREAK_PROGRESS_MAP.size()
        );
    }

    /**
     * Applies damage to a block at the specified position and updates its break progress.
     *
     * @param level    The Level object representing the game world.
     * @param blockPos The position of the block to apply damage to.
     * @param damage   The amount of damage to apply to the block.
     */
    public static void damage(Level level, BlockPos blockPos, float damage) {
        if (!level.isClientSide())
            BlockBreakProgressManager.BLOCK_BREAK_PROGRESS_MAP.compute(blockPos, (key, entry) -> {
                var blockState = level.getBlockState(blockPos);
                var block = blockState.getBlock();
                var cachedValue = entry == null ? 0 : entry.getValue();
                var newValue = cachedValue + (damage / (2F + block.defaultDestroyTime() / 2F));
                var progress = (int) Mth.clamp(newValue, 0F, 9F);

                if (progress >= 9) {
                    level.destroyBlockProgress(level.getRandom().nextInt(), blockPos, -1);
                    level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());
                    return null;
                } else {
                    level.destroyBlockProgress(level.getRandom().nextInt(), blockPos, progress);
                }
                return Map.entry(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5), newValue);
            });
    }

    private BlockBreakProgressManager() {
        throw new UnsupportedOperationException();
    }
}
