package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import org.avpr.common.CommonMod;

public record AVPRBiomeTags() {
    public static final TagKey<Biome> IS_WET = CommonMod.createTag(Registries.BIOME, "is_wet");
}
