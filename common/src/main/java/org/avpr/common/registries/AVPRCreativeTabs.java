package org.avpr.common.registries;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.avpr.common.CommonMod;
import org.avpr.common.platform.AVPRServices;

import java.util.function.Supplier;

/**
 * Example of using this Interface to create a new Creative Tab:
 * <p>
 * The following code demonstrates how to register a new creative mode tab in the game:
 * </p>
 * <pre>{@code
 * public static final Supplier<CreativeModeTab> EXAMPLEMOD_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
 *         "examplemod_items",
 *         () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
 *             .title(Component.translatable("itemGroup." + CommonMod.MOD_ID + ".examplemod_items"))
 *             .icon(() -> new ItemStack(AVPRItems.EXAMPLE_ITEM.get()))
 *             .displayItems((enabledFeatures, entries) -> entries.accept(AVPRItems.EXAMPLE_ITEM.get()))
 *             .build());
 * }</pre>
 * <p>
 * In this example:
 * </p>
 * <ul>
 * <li><code>registerCreativeModeTab</code> is a method to register a new creative mode tab with the specified tab name.</li>
 * <li>The <code>newCreativeTabBuilder</code> method is used to build the creative tab with a title, icon, and displayed items.</li>
 * </ul>
 * <p>
 * The {@link net.minecraft.world.item.CreativeModeTab CreativeModeTab} class represents a tab in the creative inventory menu.
 * </p>
 */
public class AVPRCreativeTabs {
    public static final Supplier<CreativeModeTab> BLOCKS_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
            "blocks",
            () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
                    .title(Component.translatable("tab." + CommonMod.MOD_ID + ".blocks"))
                    .icon(() -> new ItemStack(AVPRItems.RESIN_WEBBING_BLOCK_ITEM.get()))
                    .displayItems((enabledFeatures, entries) -> {
                        entries.accept(AVPRItems.RESIN_BLOCK_ITEM.get());
                        entries.accept(AVPRItems.RESIN_VEIN_BLOCK_ITEM.get());
                        entries.accept(AVPRItems.RESIN_WEBBING_BLOCK_ITEM.get());
                        entries.accept(AVPRItems.ORIONITE_BLOCK_ITEM.get());
                        AVPRBlocks.getAllOreItems().forEach(entries::accept);
                        AVPRBlocks.getAllGlassItems().forEach(entries::accept);
                        AVPRBlocks.getAllMetalItems().forEach(entries::accept);
                        AVPRBlocks.getAllPlasticItems().forEach(entries::accept);
                        AVPRBlocks.getAllPaddingItems().forEach(entries::accept);
                        AVPRBlocks.getAllRawItems().forEach(entries::accept);
                        AVPRBlocks.getAllNormalItems().forEach(entries::accept);
                        entries.accept(AVPRItems.INDUSTRIAL_WALL_ITEM.get());
                        entries.accept(AVPRItems.INDUSTRIAL_WALL_SLAB_ITEM.get());
                        entries.accept(AVPRItems.INDUSTRIAL_WALL_STAIRS_ITEM.get());
                        entries.accept(AVPRItems.INDUSTRIAL_WALL_WALL_ITEM.get());
                        entries.accept(AVPRItems.SOLAR_PANEL_ITEM.get());
                    })
                    .build());

    public static void initialize() {
    }
}
