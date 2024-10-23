package org.avpr.common.blocks;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Represents a custom stair block in the AVPR mod. This class extends the functionality of the StairBlock class to
 * create specialized stair blocks with custom properties and behaviors defined by the mod. The AVPRStairBlock class
 * takes a base state and properties for initialization, allowing for the creation of stairs with specific attributes.
 */
public class AVPRStairBlock extends StairBlock {

    public AVPRStairBlock(BlockState baseState, Properties properties) {
        super(baseState, properties);
    }
}
