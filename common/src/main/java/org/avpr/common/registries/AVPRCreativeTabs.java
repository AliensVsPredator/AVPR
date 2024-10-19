package org.avpr.common.registries;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;
import java.util.function.Supplier;

import org.avpr.common.CommonMod;
import org.avpr.common.platform.AVPRServices;

/**
 * Example of using this Interface to create a new Creative Tab:
 * <p>
 * The following code demonstrates how to register a new creative mode tab in the game:
 * </p>
 *
 * <pre>{@code
 *
 * public static final Supplier<CreativeModeTab> EXAMPLEMOD_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
 *     "examplemod_items",
 *     () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
 *         .title(Component.translatable("itemGroup." + CommonMod.MOD_ID + ".examplemod_items"))
 *         .icon(() -> new ItemStack(AVPRItems.EXAMPLE_ITEM.get()))
 *         .displayItems((enabledFeatures, entries) -> entries.accept(AVPRItems.EXAMPLE_ITEM.get()))
 *         .build()
 * );
 * }</pre>
 * <p>
 * In this example:
 * </p>
 * <ul>
 * <li><code>registerCreativeModeTab</code> is a method to register a new creative mode tab with the specified tab
 * name.</li>
 * <li>The <code>newCreativeTabBuilder</code> method is used to build the creative tab with a title, icon, and displayed
 * items.</li>
 * </ul>
 * <p>
 * The {@link net.minecraft.world.item.CreativeModeTab CreativeModeTab} class represents a tab in the creative inventory
 * menu.
 * </p>
 */
public record AVPRCreativeTabs() {

    public static final Supplier<CreativeModeTab> SPAWN_EGG_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
        "entities",
        () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
            .title(Component.translatable("tab." + CommonMod.MOD_ID + ".entities"))
            .icon(() -> new ItemStack(AVPRItems.OVAMORPH_SPAWN_EGG.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(AVPRItems.OVAMORPH_SPAWN_EGG.get());
                entries.accept(AVPRItems.FACEHUGGER_SPAWN_EGG.get());
            })
            .build()
    );

    public static final Supplier<CreativeModeTab> ARMOR_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
        "armor",
        () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
            .title(Component.translatable("tab." + CommonMod.MOD_ID + ".armor"))
            .icon(
                () -> new ItemStack(
                    Objects.requireNonNull(
                        AVPRItems.ARMOR_VERITANIUM_HELMET.get()
                    )
                )
            )
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(AVPRItems.ARMOR_ALUMINUM_HELMET.get());
                entries.accept(AVPRItems.ARMOR_ALUMINUM_CHESTPLATE.get());
                entries.accept(AVPRItems.ARMOR_ALUMINUM_LEGGINGS.get());
                entries.accept(AVPRItems.ARMOR_ALUMINUM_BOOTS.get());
                entries.accept(AVPRItems.ARMOR_MK50_HELMET.get());
                entries.accept(AVPRItems.ARMOR_MK50_CHESTPLATE.get());
                entries.accept(AVPRItems.ARMOR_MK50_LEGGINGS.get());
                entries.accept(AVPRItems.ARMOR_MK50_BOOTS.get());
                entries.accept(AVPRItems.ARMOR_ORIONITE_HELMET.get());
                entries.accept(AVPRItems.ARMOR_ORIONITE_CHESTPLATE.get());
                entries.accept(AVPRItems.ARMOR_ORIONITE_LEGGINGS.get());
                entries.accept(AVPRItems.ARMOR_ORIONITE_BOOTS.get());
                entries.accept(AVPRItems.ARMOR_PRESSURE_HELMET.get());
                entries.accept(AVPRItems.ARMOR_PRESSURE_CHESTPLATE.get());
                entries.accept(AVPRItems.ARMOR_PRESSURE_LEGGINGS.get());
                entries.accept(AVPRItems.ARMOR_PRESSURE_BOOTS.get());
                entries.accept(AVPRItems.ARMOR_TACTICAL_HELMET.get());
                entries.accept(AVPRItems.ARMOR_TACTICAL_CHESTPLATE.get());
                entries.accept(AVPRItems.ARMOR_TACTICAL_LEGGINGS.get());
                entries.accept(AVPRItems.ARMOR_TACTICAL_BOOTS.get());
                entries.accept(AVPRItems.ARMOR_TITANIUM_HELMET.get());
                entries.accept(AVPRItems.ARMOR_TITANIUM_CHESTPLATE.get());
                entries.accept(AVPRItems.ARMOR_TITANIUM_LEGGINGS.get());
                entries.accept(AVPRItems.ARMOR_TITANIUM_BOOTS.get());
                entries.accept(AVPRItems.ARMOR_VERITANIUM_HELMET.get());
                entries.accept(AVPRItems.ARMOR_VERITANIUM_CHESTPLATE.get());
                entries.accept(AVPRItems.ARMOR_VERITANIUM_LEGGINGS.get());
                entries.accept(AVPRItems.ARMOR_VERITANIUM_BOOTS.get());
                entries.accept(AVPRItems.ARMOR_XENOMORPH_CHITIN_HELMET.get());
                entries.accept(AVPRItems.ARMOR_XENOMORPH_CHITIN_CHESTPLATE.get());
                entries.accept(AVPRItems.ARMOR_XENOMORPH_CHITIN_LEGGINGS.get());
                entries.accept(AVPRItems.ARMOR_XENOMORPH_CHITIN_BOOTS.get());
            })
            .build()
    );

    public static final Supplier<CreativeModeTab> ITEMS_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
        "items",
        () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
            .title(Component.translatable("tab." + CommonMod.MOD_ID + ".items"))
            .icon(() -> new ItemStack(AVPRItems.ROYAL_JELLY.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(AVPRItems.BOTTLE_TINTED.get());
                entries.accept(AVPRItems.BOTTLE_TINTED_ACID.get());
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
            .build()
    );

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
            .build()
    );

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
                entries.accept(AVPRItems.INDUSTRIAL_GLASS_ITEM.get());
                AVPRBlocks.getAllGlassItems().forEach(entries::accept);
                entries.accept(AVPRItems.ALUMINUM_CUT_SLAB_ITEM.get());
                entries.accept(AVPRItems.ALUMINUM_CUT_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ALUMINUM_CUT_WALL_ITEM.get());
                entries.accept(AVPRItems.ALUMINUM_PLATED_CHEVRON_SLAB_ITEM.get());
                entries.accept(AVPRItems.ALUMINUM_PLATED_CHEVRON_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ALUMINUM_PLATED_CHEVRON_WALL_ITEM.get());
                entries.accept(AVPRItems.ALUMINUM_PLATED_SLAB_ITEM.get());
                entries.accept(AVPRItems.ALUMINUM_PLATED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ALUMINUM_PLATED_WALL_ITEM.get());
                entries.accept(AVPRItems.COPPER_PLATED_CHEVRON_SLAB_ITEM.get());
                entries.accept(AVPRItems.COPPER_PLATED_CHEVRON_STAIRS_ITEM.get());
                entries.accept(AVPRItems.COPPER_PLATED_CHEVRON_WALL_ITEM.get());
                entries.accept(AVPRItems.COPPER_PLATED_SLAB_ITEM.get());
                entries.accept(AVPRItems.COPPER_PLATED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.COPPER_PLATED_WALL_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_CUT_SLAB_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_CUT_STAIRS_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_CUT_WALL_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_PLATED_CHEVRON_SLAB_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_PLATED_CHEVRON_STAIRS_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_PLATED_CHEVRON_WALL_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_PLATED_SLAB_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_PLATED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.FERROALUMINUM_PLATED_WALL_ITEM.get());
                entries.accept(AVPRItems.GOLD_PLATED_CHEVRON_SLAB_ITEM.get());
                entries.accept(AVPRItems.GOLD_PLATED_CHEVRON_STAIRS_ITEM.get());
                entries.accept(AVPRItems.GOLD_PLATED_CHEVRON_WALL_ITEM.get());
                entries.accept(AVPRItems.GOLD_PLATED_SLAB_ITEM.get());
                entries.accept(AVPRItems.GOLD_PLATED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.GOLD_PLATED_WALL_ITEM.get());
                entries.accept(AVPRItems.IRON_PLATED_CHEVRON_SLAB_ITEM.get());
                entries.accept(AVPRItems.IRON_PLATED_CHEVRON_STAIRS_ITEM.get());
                entries.accept(AVPRItems.IRON_PLATED_CHEVRON_WALL_ITEM.get());
                entries.accept(AVPRItems.IRON_PLATED_SLAB_ITEM.get());
                entries.accept(AVPRItems.IRON_PLATED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.IRON_PLATED_WALL_ITEM.get());
                entries.accept(AVPRItems.NETHERITE_PLATED_CHEVRON_SLAB_ITEM.get());
                entries.accept(AVPRItems.NETHERITE_PLATED_CHEVRON_STAIRS_ITEM.get());
                entries.accept(AVPRItems.NETHERITE_PLATED_CHEVRON_WALL_ITEM.get());
                entries.accept(AVPRItems.NETHERITE_PLATED_SLAB_ITEM.get());
                entries.accept(AVPRItems.NETHERITE_PLATED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.NETHERITE_PLATED_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_SQUARE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_SQUARE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_SQUARE_WALL_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_TILES_SLAB_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_TILES_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_TILES_WALL_ITEM.get());
                entries.accept(AVPRItems.STEEL_CUT_SLAB_ITEM.get());
                entries.accept(AVPRItems.STEEL_CUT_STAIRS_ITEM.get());
                entries.accept(AVPRItems.STEEL_CUT_WALL_ITEM.get());
                entries.accept(AVPRItems.STEEL_PLATED_CHEVRON_SLAB_ITEM.get());
                entries.accept(AVPRItems.STEEL_PLATED_CHEVRON_STAIRS_ITEM.get());
                entries.accept(AVPRItems.STEEL_PLATED_CHEVRON_WALL_ITEM.get());
                entries.accept(AVPRItems.STEEL_PLATED_SLAB_ITEM.get());
                entries.accept(AVPRItems.STEEL_PLATED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.STEEL_PLATED_WALL_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_CUT_SLAB_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_CUT_STAIRS_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_CUT_WALL_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_PLATED_CHEVRON_SLAB_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_PLATED_CHEVRON_STAIRS_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_PLATED_CHEVRON_WALL_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_PLATED_SLAB_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_PLATED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.TITANIUM_PLATED_WALL_ITEM.get());
                entries.accept(AVPRItems.aluminum_block_item.get());
                entries.accept(AVPRItems.aluminum_grate_item.get());
                entries.accept(AVPRItems.aluminum_vent_item.get());
                entries.accept(AVPRItems.aluminum_panel_item.get());
                entries.accept(AVPRItems.aluminum_plated_item.get());
                entries.accept(AVPRItems.aluminum_plated_chevron_item.get());
                entries.accept(AVPRItems.aluminum_cut_item.get());
                entries.accept(AVPRItems.copper_grate_item.get());
                entries.accept(AVPRItems.copper_vent_item.get());
                entries.accept(AVPRItems.copper_panel_item.get());
                entries.accept(AVPRItems.copper_plated_item.get());
                entries.accept(AVPRItems.copper_plated_chevron_item.get());
                entries.accept(AVPRItems.ferroaluminum_block_item.get());
                entries.accept(AVPRItems.ferroaluminum_grate_item.get());
                entries.accept(AVPRItems.ferroaluminum_vent_item.get());
                entries.accept(AVPRItems.ferroaluminum_panel_item.get());
                entries.accept(AVPRItems.ferroaluminum_plated_item.get());
                entries.accept(AVPRItems.ferroaluminum_plated_chevron_item.get());
                entries.accept(AVPRItems.ferroaluminum_cut_item.get());
                entries.accept(AVPRItems.gold_grate_item.get());
                entries.accept(AVPRItems.gold_vent_item.get());
                entries.accept(AVPRItems.gold_panel_item.get());
                entries.accept(AVPRItems.gold_plated_item.get());
                entries.accept(AVPRItems.gold_plated_chevron_item.get());
                entries.accept(AVPRItems.iron_grate_item.get());
                entries.accept(AVPRItems.iron_vent_item.get());
                entries.accept(AVPRItems.iron_panel_item.get());
                entries.accept(AVPRItems.iron_plated_item.get());
                entries.accept(AVPRItems.iron_plated_chevron_item.get());
                entries.accept(AVPRItems.netherite_grate_item.get());
                entries.accept(AVPRItems.netherite_vent_item.get());
                entries.accept(AVPRItems.netherite_panel_item.get());
                entries.accept(AVPRItems.netherite_plated_item.get());
                entries.accept(AVPRItems.netherite_plated_chevron_item.get());
                entries.accept(AVPRItems.steel_block_item.get());
                entries.accept(AVPRItems.steel_grate_item.get());
                entries.accept(AVPRItems.steel_vent_item.get());
                entries.accept(AVPRItems.steel_panel_item.get());
                entries.accept(AVPRItems.steel_plated_item.get());
                entries.accept(AVPRItems.steel_plated_chevron_item.get());
                entries.accept(AVPRItems.steel_cut_item.get());
                entries.accept(AVPRItems.titanium_block_item.get());
                entries.accept(AVPRItems.titanium_grate_item.get());
                entries.accept(AVPRItems.titanium_vent_item.get());
                entries.accept(AVPRItems.titanium_panel_item.get());
                entries.accept(AVPRItems.titanium_plated_item.get());
                entries.accept(AVPRItems.titanium_plated_chevron_item.get());
                entries.accept(AVPRItems.titanium_cut_item.get());
                entries.accept(AVPRItems.PADDING_WHITE_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_WHITE_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_ORANGE_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_MAGENTA_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_BLUE_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_YELLOW_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIME_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_PINK_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_GRAY_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_LIGHT_GRAY_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_CYAN_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_PURPLE_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLUE_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_BROWN_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_GREEN_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_RED_TILES_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_PANEL_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_PIPES_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_SQUARE_ITEM.get());
                entries.accept(AVPRItems.PADDING_BLACK_TILES_ITEM.get());
                AVPRBlocks.getAllRawItems().forEach(entries::accept);
                AVPRBlocks.getAllNormalItems().forEach(entries::accept);
                entries.accept(AVPRItems.PLASTIC_WHITE_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_WHITE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_WHITE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_WHITE_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_ORANGE_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_ORANGE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_ORANGE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_ORANGE_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_MAGENTA_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_MAGENTA_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_MAGENTA_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_MAGENTA_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIGHT_BLUE_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIGHT_BLUE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIGHT_BLUE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIGHT_BLUE_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_YELLOW_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_YELLOW_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_YELLOW_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_YELLOW_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIME_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIME_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIME_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIME_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_PINK_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_PINK_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_PINK_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_PINK_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_GRAY_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_GRAY_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_GRAY_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_GRAY_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIGHT_GRAY_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIGHT_GRAY_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIGHT_GRAY_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_LIGHT_GRAY_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_CYAN_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_CYAN_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_CYAN_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_CYAN_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_PURPLE_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_PURPLE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_PURPLE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_PURPLE_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BLUE_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BLUE_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BLUE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BLUE_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BROWN_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BROWN_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BROWN_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BROWN_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_GREEN_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_GREEN_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_GREEN_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_GREEN_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_RED_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_RED_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_RED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_RED_WALL_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BLACK_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BLACK_SLAB_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BLACK_STAIRS_ITEM.get());
                entries.accept(AVPRItems.PLASTIC_BLACK_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_WHITE_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_WHITE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_WHITE_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_ORANGE_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_ORANGE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_ORANGE_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_MAGENTA_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_MAGENTA_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_MAGENTA_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIGHT_BLUE_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIGHT_BLUE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIGHT_BLUE_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_YELLOW_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_YELLOW_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_YELLOW_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIME_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIME_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIME_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_PINK_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_PINK_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_PINK_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_GRAY_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_GRAY_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_GRAY_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIGHT_GRAY_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIGHT_GRAY_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_LIGHT_GRAY_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_CYAN_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_CYAN_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_CYAN_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_PURPLE_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_PURPLE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_PURPLE_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BLUE_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BLUE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BLUE_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BROWN_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BROWN_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BROWN_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_GREEN_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_GREEN_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_GREEN_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_RED_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_RED_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_RED_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BLACK_SLAB_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BLACK_STAIRS_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_BLACK_WALL_ITEM.get());
                entries.accept(AVPRItems.INDUSTRIAL_WALL_HAZARD_ITEM.get());
                entries.accept(AVPRItems.SOLAR_PANEL_ITEM.get());
                entries.accept(AVPRItems.UNIDENTIFIED_DIRT_ITEM.get());
                entries.accept(AVPRItems.UNIDENTIFIED_GRAVEL_ITEM.get());
                entries.accept(AVPRItems.UNIDENTIFIED_ROCK_ITEM.get());
                entries.accept(AVPRItems.UNIDENTIFIED_SAND_ITEM.get());
                entries.accept(AVPRItems.UNIDENTIFIED_STONE_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_BRICK_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_BRICK_SLAB_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_BRICK_STAIRS_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_BRICK_WALL_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_DECOR_1_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_DECOR_2_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_DECOR_3_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_DECOR_3_SLAB_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_DECOR_3_STAIRS_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_DECOR_3_WALL_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_PANEL_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_SUPPORT_PILLAR_ITEM.get());
                entries.accept(AVPRItems.YAUTJA_SHIP_WALL_BASE_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_WALL_BASE_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_CHESTBURSTER_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_FACEHUGGER_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_SKULL_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_SLAB_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_STAIRS_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_WALL_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_SINGLE_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_SINGLE_SLAB_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_SIMPLE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_BRICK_SIMPLE_WALL_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_FLOOR_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_FLOOR_SLAB_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_FLOOR_STAIRS_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_FLOOR_WALL_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_TILE_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_TILE_SLAB_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_TILE_STAIRS_ITEM.get());
                entries.accept(AVPRItems.TEMPLE_TILE_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_1_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_1_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_1_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_1_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_2_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_2_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_2_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_2_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_3_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_3_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_3_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_BRICK_3_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_0_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_0_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_0_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_0_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_1_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_1_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_1_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_1_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_2_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_2_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_2_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_MATERIAL_2_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_1_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_1_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_1_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_1_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_2_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_2_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_2_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_2_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_3_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_3_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_3_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_3_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_4_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_4_SLAB_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_4_STAIRS_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_WALL_4_WALL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_COLUMN_1_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_COLUMN_2_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_FLOOR_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_GRAVEL_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_ROCK_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_ROCK_1_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_ROCK_2_ITEM.get());
                entries.accept(AVPRItems.ENGINEER_SHIP_ROCK_3_ITEM.get());
            })
            .build()
    );

    public static final Supplier<CreativeModeTab> ELECTRONICS_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
        "electronics",
        () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
            .title(Component.translatable("tab." + CommonMod.MOD_ID + ".electronics"))
            .icon(() -> new ItemStack(AVPRItems.CPU.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(AVPRItems.BATTERY.get());
                entries.accept(AVPRItems.CAPACITOR.get());
                entries.accept(AVPRItems.CPU.get());
                entries.accept(AVPRItems.DIODE.get());
                entries.accept(AVPRItems.INTERGRATED_CIRCUIT.get());
                entries.accept(AVPRItems.LED.get());
                entries.accept(AVPRItems.LED_DISPLAY.get());
                entries.accept(AVPRItems.MOTHERBOARD.get());
                entries.accept(AVPRItems.POWER_SUPPLY.get());
                entries.accept(AVPRItems.RAM.get());
                entries.accept(AVPRItems.REGULATOR.get());
                entries.accept(AVPRItems.RESISTOR.get());
                entries.accept(AVPRItems.SSD.get());
                entries.accept(AVPRItems.TRANSISTOR.get());
            })
            .build()
    );

    public static final Supplier<CreativeModeTab> WEAPONS_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
        "weapons",
        () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
            .title(Component.translatable("tab." + CommonMod.MOD_ID + ".weapons"))
            .icon(() -> new ItemStack(AVPRItems.WEAPON_GRENADE_M40.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(AVPRItems.AMMO_CHARGE_PACK.get());
                entries.accept(AVPRItems.AMMO_FLAMETHROWER.get());
                entries.accept(AVPRItems.BULLET_TIP.get());
                entries.accept(AVPRItems.CASING_CASELESS.get());
                entries.accept(AVPRItems.CASING_HEAVY.get());
                entries.accept(AVPRItems.CASTING_PISTOL.get());
                entries.accept(AVPRItems.CASING_RIFLE.get());
                entries.accept(AVPRItems.CASING_SHOTGUN.get());
                entries.accept(AVPRItems.BULLET_CASELESS.get());
                entries.accept(AVPRItems.BULLET_CASELESS_ACID.get());
                entries.accept(AVPRItems.BULLET_CASELESS_ELECTRIC.get());
                entries.accept(AVPRItems.BULLET_CASELESS_EXPLOSIVE.get());
                entries.accept(AVPRItems.BULLET_CASELESS_INCENDIARY.get());
                entries.accept(AVPRItems.BULLET_CASELESS_PENETRATION.get());
                entries.accept(AVPRItems.BULLET_HEAVY.get());
                entries.accept(AVPRItems.BULLET_HEAVY_ACID.get());
                entries.accept(AVPRItems.BULLET_HEAVY_ELECTRIC.get());
                entries.accept(AVPRItems.BULLET_HEAVY_EXPLOSIVE.get());
                entries.accept(AVPRItems.BULLET_HEAVY_INCENDIARY.get());
                entries.accept(AVPRItems.BULLET_HEAVY_PENETRATION.get());
                entries.accept(AVPRItems.BULLET_PISTOL.get());
                entries.accept(AVPRItems.BULLET_PISTOL_ACID.get());
                entries.accept(AVPRItems.BULLET_PISTOL_ELECTRIC.get());
                entries.accept(AVPRItems.BULLET_PISTOL_EXPLOSIVE.get());
                entries.accept(AVPRItems.BULLET_PISTOL_INCENDIARY.get());
                entries.accept(AVPRItems.BULLET_PISTOL_PENETRATION.get());
                entries.accept(AVPRItems.BULLET_RIFLE.get());
                entries.accept(AVPRItems.BULLET_RIFLE_ACID.get());
                entries.accept(AVPRItems.BULLET_RIFLE_ELECTRIC.get());
                entries.accept(AVPRItems.BULLET_RIFLE_EXPLOSIVE.get());
                entries.accept(AVPRItems.BULLET_RIFLE_INCENDIARY.get());
                entries.accept(AVPRItems.BULLET_RIFLE_PENETRATION.get());
                entries.accept(AVPRItems.BULLET_SHOTGUN.get());
                entries.accept(AVPRItems.BULLET_SHOTGUN_ACID.get());
                entries.accept(AVPRItems.BULLET_SHOTGUN_ELECTRIC.get());
                entries.accept(AVPRItems.BULLET_SHOTGUN_EXPLOSIVE.get());
                entries.accept(AVPRItems.BULLET_SHOTGUN_INCENDIARY.get());
                entries.accept(AVPRItems.BULLET_SHOTGUN_PENETRATION.get());
                entries.accept(AVPRItems.ROCKET.get());
                entries.accept(AVPRItems.ROCKET_ELECTRIC.get());
                entries.accept(AVPRItems.ROCKET_INCENDIARY.get());
                entries.accept(AVPRItems.ROCKET_PENETRATION.get());
                entries.accept(AVPRItems.WEAPON_PART_BARREL.get());
                entries.accept(AVPRItems.WEAPON_PART_BARREL_MINIGUN.get());
                entries.accept(AVPRItems.WEAPON_PART_BARREL_ROCKET.get());
                entries.accept(AVPRItems.WEAPON_PART_BARREL_SMART.get());
                entries.accept(AVPRItems.WEAPON_PART_GRIP.get());
                entries.accept(AVPRItems.WEAPON_PART_RECEIVER.get());
                entries.accept(AVPRItems.WEAPON_PART_RECEIVER_SMART.get());
                entries.accept(AVPRItems.WEAPON_PART_STOCK.get());
                entries.accept(AVPRItems.BLUEPRINT_37_12_SHOTGUN.get());
                entries.accept(AVPRItems.BLUEPRINT_AK_47.get());
                entries.accept(AVPRItems.BLUEPRINT_F90_RIFLE.get());
                entries.accept(AVPRItems.BLUEPRINT_SEVASTOPOL.get());
                entries.accept(AVPRItems.BLUEPRINT_M4_CARBINE.get());
                entries.accept(AVPRItems.BLUEPRINT_M41A_PULSE_RIFLE.get());
                entries.accept(AVPRItems.BLUEPRINT_M56_SMARTGUN.get());
                entries.accept(AVPRItems.BLUEPRINT_M83A2_SADAR.get());
                entries.accept(AVPRItems.BLUEPRINT_M88MOD4_COMBAT_PISTOL.get());
                entries.accept(AVPRItems.BLUEPRINT_OLD_PAINLESS.get());
                entries.accept(AVPRItems.BLUEPRINT_SNIPER_RIFLE.get());

                entries.accept(AVPRItems.WEAPON_GRENADE_INCENDIARY.get());
                entries.accept(AVPRItems.WEAPON_GRENADE_M40.get());
                entries.accept(AVPRItems.WEAPON_FLAMETHROWER_SEVASTOPOL.get());
                entries.accept(AVPRItems.WEAPON_M88MOD4_COMBAT_PISTOL.get());
                entries.accept(AVPRItems.WEAPON_37_12_SHOTGUN.get());
                entries.accept(AVPRItems.WEAPON_AK_47.get());
                entries.accept(AVPRItems.WEAPON_F90_RIFLE.get());
                entries.accept(AVPRItems.WEAPON_M4_CARBINE.get());
                entries.accept(AVPRItems.WEAPON_M41A_PULSE_RIFLE.get());
                entries.accept(AVPRItems.WEAPON_SNIPER_RIFLE.get());
                entries.accept(AVPRItems.WEAPON_M56_SMARTGUN.get());
                entries.accept(AVPRItems.WEAPON_M83A2_SADAR.get());
                entries.accept(AVPRItems.WEAPON_OLD_PAINLESS.get());
            })
            .build()
    );

    public static final Supplier<CreativeModeTab> FOOD_TAB = AVPRServices.COMMON_REGISTRY.registerCreativeModeTab(
        "food",
        () -> AVPRServices.COMMON_REGISTRY.newCreativeTabBuilder()
            .title(Component.translatable("tab." + CommonMod.MOD_ID + ".food"))
            .icon(() -> new ItemStack(AVPRItems.DORITOS.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(AVPRItems.DORITOS.get());
                entries.accept(AVPRItems.DORITOS_COOL_RANCH.get());
                entries.accept(AVPRItems.RAW_TENTACLE.get());
                entries.accept(AVPRItems.TRILO_BITE.get());
            })
            .build()
    );

    public static void initialize() {}
}
