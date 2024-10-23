package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import org.avpr.common.CommonMod;

/**
 * The AVPRBlockTags class contains static definitions of custom Block Tags used in the AVPR (Aliens versus Predator
 * Requiem) mod. These tags categorize different types of blocks within the game to achieve various mod-specific
 * functionalities.
 */
public record AVPRBlockTags() {

    public static final TagKey<Block> ACID_IMMUNE = CommonMod.createTag(Registries.BLOCK, "acid_immune");

    public static final TagKey<Block> ALIEN_REPELLENTS = CommonMod.createTag(Registries.BLOCK, "alien_repellents");

    public static final TagKey<Block> INDUSTRIAL_GLASS = CommonMod.createTag(Registries.BLOCK, "industrial_glass");

    public static final TagKey<Block> PADDING = CommonMod.createTag(Registries.BLOCK, "padding");

    public static final TagKey<Block> PLASTIC = CommonMod.createTag(Registries.BLOCK, "plastic");

    public static final TagKey<Block> RESIN_WEBBING = CommonMod.createTag(Registries.BLOCK, "resin_webbing");

    public static final TagKey<Block> NEST_BLOCKS = CommonMod.createTag(Registries.BLOCK, "nest_blocks");

    public static final TagKey<Block> SHOULD_NOT_BE_DESTROYED = CommonMod.createTag(Registries.BLOCK, "should_not_be_destroyed");

}
