package org.avpr.common.blocks;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.TransparentBlock;
import org.jetbrains.annotations.NotNull;

/**
 * The ColoredTransparentBlock class represents a block that is both colored and transparent. This class extends the
 * TransparentBlock class and implements the BeaconBeamBlock interface. The block is initialized with a specific
 * DyeColor, which dictates its color. Constructor: - ColoredTransparentBlock(DyeColor dyeColor, Properties properties):
 * Creates a ColoredTransparentBlock with the specified dye color and properties. Methods: - getColor(): Returns the
 * DyeColor associated with this block.
 */
public class ColoredTransparentBlock extends TransparentBlock implements BeaconBeamBlock {

    private final DyeColor dyeColor;

    public ColoredTransparentBlock(DyeColor dyeColor, Properties properties) {
        super(properties);
        this.dyeColor = dyeColor;
    }

    @Override
    public @NotNull DyeColor getColor() {
        return dyeColor;
    }
}
