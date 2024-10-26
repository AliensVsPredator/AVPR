package org.avpr.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;
import org.jetbrains.annotations.NotNull;

public class AVPRFallingBlock extends FallingBlock {

    public static final MapCodec<AVPRFallingBlock> CODEC = simpleCodec(AVPRFallingBlock::new);

    public AVPRFallingBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }
}
