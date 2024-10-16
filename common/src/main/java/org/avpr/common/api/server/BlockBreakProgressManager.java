package org.avpr.common.api.server;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import org.avpr.common.api.util.Tick;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class BlockBreakProgressManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlockBreakProgressManager.class);

    private static final Map<BlockPos, Map.Entry<Long, Float>> BLOCK_BREAK_PROGRESS_MAP = new HashMap<>();

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

    public static void damage(Level level, BlockPos blockPos, float damage) {
        BlockBreakProgressManager.BLOCK_BREAK_PROGRESS_MAP.compute(blockPos, (key, entry) -> {
            var blockState = level.getBlockState(blockPos);
            var block = blockState.getBlock();
            var cachedValue = entry == null ? 0 : entry.getValue();
            var newValue = cachedValue + (damage / (2F + block.defaultDestroyTime() / 2F));
            var progress = (int) Mth.clamp(newValue, 0F, 9F);

            if (progress >= 9) {
                level.destroyBlockProgress(Objects.hash(blockPos), blockPos, -1);
                level.destroyBlock(blockPos, false);
                return null;
            } else {
                level.destroyBlockProgress(Objects.hash(blockPos), blockPos, progress);
            }
            return Map.entry(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5), newValue);
        });
    }

    private BlockBreakProgressManager() {
        throw new UnsupportedOperationException();
    }
}
