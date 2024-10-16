package org.avpr.common;

import mod.azure.azurelib.common.internal.common.AzureLibMod;
import mod.azure.azurelib.common.internal.common.config.format.ConfigFormats;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import org.avpr.common.config.AVPRConfig;
import org.avpr.common.registries.*;

public class CommonMod {
    public static AVPRConfig config;
    public static final String MOD_ID = "avpr";

    /**
     * Creates a {@link ResourceLocation} for a resource within the mod's namespace.
     *
     * <p>This method is used to generate resource paths that are associated with the mod's
     * unique namespace, allowing for easy reference to custom assets such as textures,
     * sounds, models, and other resources.</p>
     *
     * @param name The path of the resource relative to the mod's namespace (e.g., "textures/entity/alien.png").
     * @return A {@link ResourceLocation} object representing the full resource path within the mod's namespace.
     */
    public static ResourceLocation modResource(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static  <T> TagKey<T> create(ResourceKey<? extends Registry<T>> registries, String registryName) {
        return TagKey.create(registries, CommonMod.modResource(registryName));
    }

    /**
     * Initializes all the necessary registries for the AVPR mod.
     * This method is responsible for registering items, entities, blocks, sounds,
     * particles, creative tabs, status effects, and fluids required by the mod.
     *
     * <p>It should be called during the mod's initialization phase to ensure that
     * all components are properly registered and available for use in the game.</p>
     *
     * The following components are initialized:
     * <ul>
     *   <li>{@code AVPRItems} - Registers all custom items.</li>
     *   <li>{@code AVPREntities} - Registers all custom entities.</li>
     *   <li>{@code AVPRBlocks} - Registers all custom blocks.</li>
     *   <li>{@code AVPRSounds} - Registers custom sound effects.</li>
     *   <li>{@code AVPRParticles} - Registers custom particles.</li>
     *   <li>{@code AVPRCreativeTabs} - Registers custom creative inventory tabs.</li>
     *   <li>{@code AVPRStatusEffects} - Registers custom status effects.</li>
     *   <li>{@code AVPRFluids} - Registers custom fluid types.</li>
     * </ul>
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
    }
}
