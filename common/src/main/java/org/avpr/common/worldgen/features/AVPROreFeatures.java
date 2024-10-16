package org.avpr.common.worldgen.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.avpr.common.CommonMod;

public class AVPROreFeatures {

    public static final ResourceKey<PlacedFeature> BAUXITE_ORE_PLACED_KEY = register("ore_bauxite");

    public static final ResourceKey<PlacedFeature> COBALT_ORE_PLACED_KEY = register("ore_cobalt");

    public static final ResourceKey<PlacedFeature> LITHIUM_ORE_PLACED_KEY = register("ore_lithium");

    public static final ResourceKey<PlacedFeature> MONAZITE_ORE_PLACED_KEY = register("ore_monazite");

    public static final ResourceKey<PlacedFeature> SILICA_ORE_PLACED_KEY = register("ore_silica");

    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = register("ore_titanium");

    private static ResourceKey<PlacedFeature> register(String registryName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, CommonMod.modResource(registryName));
    }

    private AVPROreFeatures() {
        throw new UnsupportedOperationException();
    }
}
