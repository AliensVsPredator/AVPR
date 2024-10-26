package org.avpr.common.worldgen.features;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import org.avpr.common.CommonMod;

public record AVPROreFeatures() {

    public static final ResourceKey<PlacedFeature> AUTUNITE_ORE_PLACED_KEY = CommonMod.registerKey("ore_autunite");

    public static final ResourceKey<PlacedFeature> BAUXITE_ORE_PLACED_KEY = CommonMod.registerKey("ore_bauxite");

    public static final ResourceKey<PlacedFeature> COBALT_ORE_PLACED_KEY = CommonMod.registerKey("ore_cobalt");

    public static final ResourceKey<PlacedFeature> LITHIUM_ORE_PLACED_KEY = CommonMod.registerKey("ore_lithium");

    public static final ResourceKey<PlacedFeature> MONAZITE_ORE_PLACED_KEY = CommonMod.registerKey("ore_monazite");

    public static final ResourceKey<PlacedFeature> SILICA_ORE_PLACED_KEY = CommonMod.registerKey("ore_silica");

    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = CommonMod.registerKey("ore_titanium");

    public static void initialize() {}
}
