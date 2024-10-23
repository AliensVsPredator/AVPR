package org.avpr.common.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import org.jetbrains.annotations.NotNull;

/**
 * A custom block class named ResinVeinBlock, which extends the MultifaceBlock class. This block behaves similarly to
 * other multifaced blocks but contains its own specific properties and behaviors. The class includes the following key
 * functionalities: - Utilizes a static codec field to simplify instantiation and serialization. - Contains a
 * constructor to initialize the block with specific properties. - Overrides the codec method to return the
 * corresponding codec for the ResinVeinBlock class. - Overrides the getSpreader method, expected to handle the
 * spreading behavior of the block, though it currently returns null.
 */
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
