package org.avpr.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import org.jetbrains.annotations.NotNull;

public class ResinVeinBlock extends MultifaceBlock {

    public static final MapCodec<MultifaceBlock> CODEC = simpleCodec(ResinVeinBlock::new);

    public ResinVeinBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<MultifaceBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull MultifaceSpreader getSpreader() {
        return null;
    }
}
