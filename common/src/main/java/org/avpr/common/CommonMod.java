package org.avpr.common;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import org.avpr.common.config.AVPRConfig;
import org.avpr.common.config.AVPRSpawnTesting;
import org.avpr.common.registries.*;
import org.avpr.common.worldgen.features.AVPROreFeatures;

public class CommonMod {

    public static AVPRConfig config;

    public static AVPRSpawnTesting SPAWN_TESTING;

    public static final String MOD_ID = "avpr";

    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static <T> TagKey<T> createTag(ResourceKey<? extends Registry<T>> registries, String registryName) {
        return TagKey.create(registries, CommonMod.modResource(registryName));
    }

    public static ResourceKey<PlacedFeature> registerKey(String registryName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, CommonMod.modResource(registryName));
    }

    public static void initRegistries() {
        // TODO: Fix this, these should be final.
        config = AzureLibMod.registerConfig(AVPRConfig.class, ConfigFormats.json()).getConfigInstance();
        SPAWN_TESTING = new AVPRSpawnTesting();
        SPAWN_TESTING.init(config);
        AVPRItems.initialize();
        AVPREntities.initialize();
        AVPRBlocks.initialize();
        AVPRSounds.initialize();
        AVPRParticles.initialize();
        AVPRCreativeTabs.initialize();
        AVPRStatusEffects.initialize();
        AVPRFluids.initialize();
        AVPROreFeatures.initialize();
        AVPRDataComponments.initialize();
    }
}
