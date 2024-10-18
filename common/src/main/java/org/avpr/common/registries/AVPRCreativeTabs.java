package org.avpr.common.registries;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.avpr.common.CommonMod;
import org.avpr.common.items.armor.AVPRArmorMaterials;
import org.avpr.common.platform.AVPRServices;

import java.util.Objects;
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
    public static final Supplier<CreativeModeTab> SPAWN_EGG_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
            "entities",
            () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
                    .title(Component.translatable("tab." + CommonMod.MOD_ID + ".entities"))
                    .icon(() -> new ItemStack(AVPRItems.OVAMORPH_SPAWN_EGG.get()))
                    .displayItems((enabledFeatures, entries) -> {
                        entries.accept(AVPRItems.OVAMORPH_SPAWN_EGG.get());
                        entries.accept(AVPRItems.FACEHUGGER_SPAWN_EGG.get());
                    })
                    .build());

    public static final Supplier<CreativeModeTab> ARMOR_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
            "armor",
            () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
                    .title(Component.translatable("tab." + CommonMod.MOD_ID + ".armor"))
                    .icon(() -> new ItemStack(Objects.requireNonNull(
                            AVPRItems.getArmorItem(AVPRArmorMaterials.VERITANIUM, ArmorItem.Type.HELMET))))
                    .displayItems((enabledFeatures, entries) -> AVPRItems.getAllArmorItems().forEach(entries::accept))
                    .build());

    public static final Supplier<CreativeModeTab> ITEMS_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
            "items",
            () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
                    .title(Component.translatable("tab." + CommonMod.MOD_ID + ".blocks"))
                    .icon(() -> new ItemStack(AVPRItems.ROYAL_JELLY.get()))
                    .displayItems((enabledFeatures, entries) -> {
                        entries.accept(AVPRItems.COLBALT.get());
                        entries.accept(AVPRItems.CARBON.get());
                        entries.accept(AVPRItems.DUST_LITHIUM.get());
                        entries.accept(AVPRItems.XENO_CHITIN.get());
                        entries.accept(AVPRItems.VERITANIUM_SHARD.get());
                        entries.accept(AVPRItems.INGOT_ALUMINUM.get());
                        entries.accept(AVPRItems.INGOT_ORIONITE.get());
                        entries.accept(AVPRItems.INGOT_STEEL.get());
                        entries.accept(AVPRItems.INGOT_TITANIUM.get());
                        entries.accept(AVPRItems.LASER_MINE.get());
                        entries.accept(AVPRItems.NBT_DRIVE.get());
                        entries.accept(AVPRItems.NEODYMIUM.get());
                        entries.accept(AVPRItems.NEODYMIUM_MAGENT.get());
                        entries.accept(AVPRItems.POLYCARBONATE.get());
                        entries.accept(AVPRItems.POLYMER.get());
                        entries.accept(AVPRItems.RAW_BAUXITE.get());
                        entries.accept(AVPRItems.RAW_TITANIUM.get());
                        entries.accept(AVPRItems.RESIN_BALL.get());
                        entries.accept(AVPRItems.ROYAL_JELLY.get());
                        entries.accept(AVPRItems.SHEET_ORIONITE.get());
                        entries.accept(AVPRItems.SHURIKEN.get());
                        entries.accept(AVPRItems.SILICA.get());
                        entries.accept(AVPRItems.SMART_DISC.get());
                        entries.accept(AVPRItems.YAUTJA_ARTIFCAT.get());
                    })
                    .build());

    public static final Supplier<CreativeModeTab> TOOLS_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
            "tools",
            () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
                    .title(Component.translatable("tab." + CommonMod.MOD_ID + ".tools"))
                    .icon(() -> new ItemStack(AVPRItems.VERITANIUM_PICKAXE.get()))
                    .displayItems((enabledFeatures, entries) -> {
                        entries.accept(AVPRItems.ALUMINUM_AXE.get());
                        entries.accept(AVPRItems.ALUMINUM_HOE.get());
                        entries.accept(AVPRItems.ALUMINUM_PICKAXE.get());
                        entries.accept(AVPRItems.ALUMINUM_SHOVEL.get());
                        entries.accept(AVPRItems.ALUMINUM_SWORD.get());
                        entries.accept(AVPRItems.ORIONITE_AXE.get());
                        entries.accept(AVPRItems.ORIONITE_HOE.get());
                        entries.accept(AVPRItems.ORIONITE_PICKAXE.get());
                        entries.accept(AVPRItems.ORIONITE_SHOVEL.get());
                        entries.accept(AVPRItems.ORIONITE_SWORD.get());
                        entries.accept(AVPRItems.TITANIUM_AXE.get());
                        entries.accept(AVPRItems.TITANIUM_HOE.get());
                        entries.accept(AVPRItems.TITANIUM_PICKAXE.get());
                        entries.accept(AVPRItems.TITANIUM_SHOVEL.get());
                        entries.accept(AVPRItems.TITANIUM_SWORD.get());
                        entries.accept(AVPRItems.VERITANIUM_AXE.get());
                        entries.accept(AVPRItems.VERITANIUM_HOE.get());
                        entries.accept(AVPRItems.VERITANIUM_PICKAXE.get());
                        entries.accept(AVPRItems.VERITANIUM_SHOVEL.get());
                        entries.accept(AVPRItems.VERITANIUM_SWORD.get());
                    })
                    .build());

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
