package org.avpr.common.blocks;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import org.jetbrains.annotations.NotNull;

public class ColoredTransparentBlock extends CustomTransparentBlock implements BeaconBeamBlock {

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
