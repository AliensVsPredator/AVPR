package org.avpr.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.tags.AVPREntityTags;

/**
 * ResinWebbingBlock is a class that extends the Block class and represents a block that entities can become stuck in,
 * specifically excluding entities tagged as aliens from being affected. Creative and spectator mode players are also
 * unaffected. The block has unique properties including lack of collision and occlusion. The primary behavior of the
 * block is to slow down and immobilize entities that stand in it.
 */
public class ResinWebbingBlock extends Block {

    private int standingTick = 0;

    public ResinWebbingBlock() {
        super(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
                .noCollission()
                .noOcclusion()
        );
    }

    /**
     * Manages the interaction between an entity and the ResinWebbingBlock, applying specific effects when certain
     * conditions are met, such as preventing alien entities from being affected, or making living entities stuck and
     * potentially repositioned if they remain in the block for a long duration.
     *
     * @param state  The current block state.
     * @param world  The level where the block is located.
     * @param pos    The position of the block in the world.
     * @param entity The entity that is interacting with the block.
     */
    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Entity entity) {
        if (entity.getType().is(AVPREntityTags.ALIENS))
            return;
        if (entity instanceof LivingEntity livingEntity && PredicatesUtil.IS_CREATIVE_OR_SPECTATOR.test(livingEntity))
            return;
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.makeStuckInBlock(state, new Vec3(0.25, 0.05F, 0.25));
            if (!world.isClientSide())
                standingTick++;
            if (standingTick >= 100) {
                if (!world.getBlockState(pos.below()).is(this))
                    livingEntity.setPos(pos.getCenter().x, pos.getY(), pos.getCenter().z);
                if (world.getBlockState(pos.below()).is(this))
                    livingEntity.setPos(pos.getCenter().x, pos.below().getY(), pos.getCenter().z);
                livingEntity.makeStuckInBlock(state, new Vec3(0.25, 0.0F, 0.25));
                standingTick = 0;
            }
        } else {
            standingTick = 0;
        }
    }
}
