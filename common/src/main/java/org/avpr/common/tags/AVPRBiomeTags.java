package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

import org.avpr.common.CommonMod;

/**
 * The {@code AVPRBiomeTags} class is a record that contains biome tag constants used in the AVPR mod. These tags help
 * categorize various biomes based on specific criteria.
 */
public record AVPRBiomeTags() {

    public static final TagKey<Biome> IS_WET = CommonMod.createTag(Registries.BIOME, "is_wet");
}
