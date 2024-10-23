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
import org.avpr.common.registries.*;
import org.avpr.common.worldgen.features.AVPROreFeatures;

public class CommonMod {

    /**
     * The {@code config} variable holds the configuration settings for the AVPR (Aliens versus Predator Requiem) mod.
     * This configuration object is used to manage various parameters and properties that define the behavior and
     * settings of the mod. Typically, it includes settings related to gameplay, resources, and other mod-specific
     * options that can be adjusted to customize the mod's functionality.
     */
    public static AVPRConfig config;

    /**
     * The unique identifier for the mod 'avpr'.
     * <p>
     * This constant is used as the namespace for all resources, registry keys, and identifiers associated with the mod.
     * It ensures that all elements tied to the mod are uniquely identifiable and avoids conflicts with identifiers from
     * other mods or the base game.
     */
    public static final String MOD_ID = "avpr";

    /**
     * Creates a {@link ResourceLocation} for a resource within the mod's namespace.
     * <p>
     * This method is used to generate resource paths that are associated with the mod's unique namespace, allowing for
     * easy reference to custom assets such as textures, sounds, models, and other resources.
     * </p>
     *
     * @param name The path of the resource relative to the mod's namespace (e.g., "textures/entity/alien.png").
     * @return A {@link ResourceLocation} object representing the full resource path within the mod's namespace.
     */
    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    /**
     * Creates a {@link TagKey} for the specified registry and registry name.
     *
     * @param registries   The {@link ResourceKey} representing a specific registry within which the tag is to be
     *                     created.
     * @param registryName A string representing the name of the registry for which the tag is created.
     * @return A {@link TagKey} representing the created tag within the specified registry.
     */
    public static <T> TagKey<T> createTag(ResourceKey<? extends Registry<T>> registries, String registryName) {
        return TagKey.create(registries, CommonMod.modResource(registryName));
    }

    /**
     * Registers a key for a placed feature within the mod's registry namespace.
     *
     * @param registryName The name of the registry key to be created.
     * @return A {@link ResourceKey} for the placed feature with the specified registry name.
     */
    public static ResourceKey<PlacedFeature> registerKey(String registryName) {
        return ResourceKey.create(Registries.PLACED_FEATURE, CommonMod.modResource(registryName));
    }

    /**
     * Initializes all the core registries for the mod. This includes configuration settings, items, entities, blocks,
     * sounds, particles, creative tabs, status effects, fluids, and ore features. This method is typically called
     * during the mod's startup sequence to ensure that all necessary resources and definitions are properly registered
     * and available for use within the mod.
     */
    public static void initRegistries() {
        config = AzureLibMod.registerConfig(AVPRConfig.class, ConfigFormats.json()).getConfigInstance();
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
