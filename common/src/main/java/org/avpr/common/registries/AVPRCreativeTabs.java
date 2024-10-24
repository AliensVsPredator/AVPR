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
                entries.accept(AVPRItems.CHESTBURSTER_SPAWN_EGG.get());
                entries.accept(AVPRItems.DRONE_SPAWN_EGG.get());
                entries.accept(AVPRItems.WARRIOR_SPAWN_EGG.get());
                entries.accept(AVPRItems.BOILER_SPAWN_EGG.get());
                entries.accept(AVPRItems.NAUTICOMORPH_SPAWN_EGG.get());
                entries.accept(AVPRItems.PRAETORIAN_SPAWN_EGG.get());
                entries.accept(AVPRItems.SPITTER_SPAWN_EGG.get());
                entries.accept(AVPRItems.ULTRAMORPH_SPAWN_EGG.get());
                entries.accept(AVPRItems.QUEEN_SPAWN_EGG.get());
                entries.accept(AVPRItems.OCTOHUGGER_SPAWN_EGG.get());
                entries.accept(AVPRItems.BELUGABURSTER_SPAWN_EGG.get());
                entries.accept(AVPRItems.BELUGAMORPH_SPAWN_EGG.get());
                entries.accept(AVPRItems.TRIOLOBITE_BABY_SPAWN_EGG.get());
                entries.accept(AVPRItems.TRIOLOBITE_SPAWN_EGG.get());
                entries.accept(AVPRItems.DEACON_SPAWN_EGG.get());
                entries.accept(AVPRItems.DEACON_ADULT_SPAWN_EGG.get());
                entries.accept(AVPRItems.DEACON_ADULT_ENGINEER_SPAWN_EGG.get());
                entries.accept(AVPRItems.OVAMORPH_DRACO_SPAWN_EGG.get());
                entries.accept(AVPRItems.CHESTBURSTER_DRACO_SPAWN_EGG.get());
                entries.accept(AVPRItems.DRACOMORPH_SPAWN_EGG.get());
                entries.accept(AVPRItems.CHESTBURSTER_RUNNER_SPAWN_EGG.get());
                entries.accept(AVPRItems.WARRIOR_RUNNER_SPAWN_EGG.get());
                entries.accept(AVPRItems.DRONE_RUNNER_SPAWN_EGG.get());
                entries.accept(AVPRItems.CRUSHER_SPAWN_EGG.get());
                entries.accept(AVPRItems.PREDALIEN_SPAWN_EGG.get());
                entries.accept(AVPRItems.YAUTJA_SPAWN_EGG.get());
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
            .icon(() -> new ItemStack(AVPRBlocks.RESIN_WEBBING_BLOCK.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(AVPRBlocks.RESIN_BLOCK.get());
                entries.accept(AVPRBlocks.RESIN_VEIN_BLOCK.get());
                entries.accept(AVPRBlocks.RESIN_WEBBING_BLOCK.get());
                entries.accept(AVPRBlocks.ORIONITE_BLOCK.get());
                entries.accept(AVPRBlocks.ORE_BAUXITE.get());
                entries.accept(AVPRBlocks.ORE_TITANIUM.get());
                entries.accept(AVPRBlocks.ORE_SILICA.get());
                entries.accept(AVPRBlocks.ORE_MONAZITE.get());
                entries.accept(AVPRBlocks.ORE_LITHIUM.get());
                entries.accept(AVPRBlocks.ORE_COBALT.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_WHITE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_ORANGE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_MAGENTA.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_LIGHT_BLUE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_YELLOW.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_LIME.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_PINK.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_GRAY.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_LIGHT_GRAY.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_CYAN.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_PURPLE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_BLUE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_BROWN.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_GREEN.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_RED.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_GLASS_BLACK.get());
                entries.accept(AVPRBlocks.ALUMINUM_CUT_SLAB.get());
                entries.accept(AVPRBlocks.ALUMINUM_CUT_STAIRS.get());
                entries.accept(AVPRBlocks.ALUMINUM_CUT_WALL.get());
                entries.accept(AVPRBlocks.ALUMINUM_PLATED_CHEVRON_SLAB.get());
                entries.accept(AVPRBlocks.ALUMINUM_PLATED_CHEVRON_STAIRS.get());
                entries.accept(AVPRBlocks.ALUMINUM_PLATED_CHEVRON_WALL.get());
                entries.accept(AVPRBlocks.ALUMINUM_PLATED_SLAB.get());
                entries.accept(AVPRBlocks.ALUMINUM_PLATED_STAIRS.get());
                entries.accept(AVPRBlocks.ALUMINUM_PLATED_WALL.get());
                entries.accept(AVPRBlocks.COPPER_PLATED_CHEVRON_SLAB.get());
                entries.accept(AVPRBlocks.COPPER_PLATED_CHEVRON_STAIRS.get());
                entries.accept(AVPRBlocks.COPPER_PLATED_CHEVRON_WALL.get());
                entries.accept(AVPRBlocks.COPPER_PLATED_SLAB.get());
                entries.accept(AVPRBlocks.COPPER_PLATED_STAIRS.get());
                entries.accept(AVPRBlocks.COPPER_PLATED_WALL.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_CUT_SLAB.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_CUT_STAIRS.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_CUT_WALL.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_PLATED_CHEVRON_SLAB.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_PLATED_CHEVRON_STAIRS.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_PLATED_CHEVRON_WALL.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_PLATED_SLAB.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_PLATED_STAIRS.get());
                entries.accept(AVPRBlocks.FERROALUMINUM_PLATED_WALL.get());
                entries.accept(AVPRBlocks.GOLD_PLATED_CHEVRON_SLAB.get());
                entries.accept(AVPRBlocks.GOLD_PLATED_CHEVRON_STAIRS.get());
                entries.accept(AVPRBlocks.GOLD_PLATED_CHEVRON_WALL.get());
                entries.accept(AVPRBlocks.GOLD_PLATED_SLAB.get());
                entries.accept(AVPRBlocks.GOLD_PLATED_STAIRS.get());
                entries.accept(AVPRBlocks.GOLD_PLATED_WALL.get());
                entries.accept(AVPRBlocks.IRON_PLATED_CHEVRON_SLAB.get());
                entries.accept(AVPRBlocks.IRON_PLATED_CHEVRON_STAIRS.get());
                entries.accept(AVPRBlocks.IRON_PLATED_CHEVRON_WALL.get());
                entries.accept(AVPRBlocks.IRON_PLATED_SLAB.get());
                entries.accept(AVPRBlocks.IRON_PLATED_STAIRS.get());
                entries.accept(AVPRBlocks.IRON_PLATED_WALL.get());
                entries.accept(AVPRBlocks.NETHERITE_PLATED_CHEVRON_SLAB.get());
                entries.accept(AVPRBlocks.NETHERITE_PLATED_CHEVRON_STAIRS.get());
                entries.accept(AVPRBlocks.NETHERITE_PLATED_CHEVRON_WALL.get());
                entries.accept(AVPRBlocks.NETHERITE_PLATED_SLAB.get());
                entries.accept(AVPRBlocks.NETHERITE_PLATED_STAIRS.get());
                entries.accept(AVPRBlocks.NETHERITE_PLATED_WALL.get());
                entries.accept(AVPRBlocks.PADDING_BLACK_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_BLACK_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_BLACK_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_BLUE_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_BLUE_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_BLUE_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_BROWN_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_BROWN_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_BROWN_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_CYAN_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_CYAN_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_CYAN_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_GRAY_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_GRAY_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_GRAY_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_GREEN_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_GREEN_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_GREEN_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_BLUE_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_BLUE_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_BLUE_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_GRAY_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_GRAY_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_GRAY_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_LIME_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_LIME_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_LIME_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_MAGENTA_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_MAGENTA_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_MAGENTA_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_ORANGE_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_ORANGE_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_ORANGE_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_PINK_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_PINK_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_PINK_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_PURPLE_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_PURPLE_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_PURPLE_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_RED_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_RED_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_RED_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_WHITE_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_WHITE_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_WHITE_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.PADDING_YELLOW_SQUARE_SLAB.get());
                entries.accept(AVPRBlocks.PADDING_YELLOW_SQUARE_STAIRS.get());
                entries.accept(AVPRBlocks.PADDING_YELLOW_SQUARE_WALL.get());
                entries.accept(AVPRBlocks.STEEL_CUT_SLAB.get());
                entries.accept(AVPRBlocks.STEEL_CUT_STAIRS.get());
                entries.accept(AVPRBlocks.STEEL_CUT_WALL.get());
                entries.accept(AVPRBlocks.STEEL_PLATED_CHEVRON_SLAB.get());
                entries.accept(AVPRBlocks.STEEL_PLATED_CHEVRON_STAIRS.get());
                entries.accept(AVPRBlocks.STEEL_PLATED_CHEVRON_WALL.get());
                entries.accept(AVPRBlocks.STEEL_PLATED_SLAB.get());
                entries.accept(AVPRBlocks.STEEL_PLATED_STAIRS.get());
                entries.accept(AVPRBlocks.STEEL_PLATED_WALL.get());
                entries.accept(AVPRBlocks.TITANIUM_CUT_SLAB.get());
                entries.accept(AVPRBlocks.TITANIUM_CUT_STAIRS.get());
                entries.accept(AVPRBlocks.TITANIUM_CUT_WALL.get());
                entries.accept(AVPRBlocks.TITANIUM_PLATED_CHEVRON_SLAB.get());
                entries.accept(AVPRBlocks.TITANIUM_PLATED_CHEVRON_STAIRS.get());
                entries.accept(AVPRBlocks.TITANIUM_PLATED_CHEVRON_WALL.get());
                entries.accept(AVPRBlocks.TITANIUM_PLATED_SLAB.get());
                entries.accept(AVPRBlocks.TITANIUM_PLATED_STAIRS.get());
                entries.accept(AVPRBlocks.TITANIUM_PLATED_WALL.get());
                entries.accept(AVPRBlocks.aluminum_block.get());
                entries.accept(AVPRBlocks.aluminum_grate.get());
                entries.accept(AVPRBlocks.aluminum_vent.get());
                entries.accept(AVPRBlocks.aluminum_panel.get());
                entries.accept(AVPRBlocks.aluminum_plated.get());
                entries.accept(AVPRBlocks.aluminum_plated_chevron.get());
                entries.accept(AVPRBlocks.aluminum_cut.get());
                entries.accept(AVPRBlocks.copper_grate.get());
                entries.accept(AVPRBlocks.copper_vent.get());
                entries.accept(AVPRBlocks.copper_panel.get());
                entries.accept(AVPRBlocks.copper_plated.get());
                entries.accept(AVPRBlocks.copper_plated_chevron.get());
                entries.accept(AVPRBlocks.ferroaluminum_block.get());
                entries.accept(AVPRBlocks.ferroaluminum_grate.get());
                entries.accept(AVPRBlocks.ferroaluminum_vent.get());
                entries.accept(AVPRBlocks.ferroaluminum_panel.get());
                entries.accept(AVPRBlocks.ferroaluminum_plated.get());
                entries.accept(AVPRBlocks.ferroaluminum_plated_chevron.get());
                entries.accept(AVPRBlocks.ferroaluminum_cut.get());
                entries.accept(AVPRBlocks.gold_grate.get());
                entries.accept(AVPRBlocks.gold_vent.get());
                entries.accept(AVPRBlocks.gold_panel.get());
                entries.accept(AVPRBlocks.gold_plated.get());
                entries.accept(AVPRBlocks.gold_plated_chevron.get());
                entries.accept(AVPRBlocks.iron_grate.get());
                entries.accept(AVPRBlocks.iron_vent.get());
                entries.accept(AVPRBlocks.iron_panel.get());
                entries.accept(AVPRBlocks.iron_plated.get());
                entries.accept(AVPRBlocks.iron_plated_chevron.get());
                entries.accept(AVPRBlocks.netherite_grate.get());
                entries.accept(AVPRBlocks.netherite_vent.get());
                entries.accept(AVPRBlocks.netherite_panel.get());
                entries.accept(AVPRBlocks.netherite_plated.get());
                entries.accept(AVPRBlocks.netherite_plated_chevron.get());
                entries.accept(AVPRBlocks.steel_block.get());
                entries.accept(AVPRBlocks.steel_grate.get());
                entries.accept(AVPRBlocks.steel_vent.get());
                entries.accept(AVPRBlocks.steel_panel.get());
                entries.accept(AVPRBlocks.steel_plated.get());
                entries.accept(AVPRBlocks.steel_plated_chevron.get());
                entries.accept(AVPRBlocks.steel_cut.get());
                entries.accept(AVPRBlocks.titanium_block.get());
                entries.accept(AVPRBlocks.titanium_grate.get());
                entries.accept(AVPRBlocks.titanium_vent.get());
                entries.accept(AVPRBlocks.titanium_panel.get());
                entries.accept(AVPRBlocks.titanium_plated.get());
                entries.accept(AVPRBlocks.titanium_plated_chevron.get());
                entries.accept(AVPRBlocks.titanium_cut.get());
                entries.accept(AVPRBlocks.PADDING_WHITE_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_WHITE_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_WHITE_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_WHITE_TILES.get());
                entries.accept(AVPRBlocks.PADDING_ORANGE_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_ORANGE_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_ORANGE_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_ORANGE_TILES.get());
                entries.accept(AVPRBlocks.PADDING_MAGENTA_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_MAGENTA_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_MAGENTA_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_MAGENTA_TILES.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_BLUE_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_BLUE_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_BLUE_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_BLUE_TILES.get());
                entries.accept(AVPRBlocks.PADDING_YELLOW_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_YELLOW_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_YELLOW_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_YELLOW_TILES.get());
                entries.accept(AVPRBlocks.PADDING_LIME_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_LIME_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_LIME_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_LIME_TILES.get());
                entries.accept(AVPRBlocks.PADDING_PINK_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_PINK_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_PINK_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_PINK_TILES.get());
                entries.accept(AVPRBlocks.PADDING_GRAY_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_GRAY_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_GRAY_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_GRAY_TILES.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_GRAY_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_GRAY_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_GRAY_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_LIGHT_GRAY_TILES.get());
                entries.accept(AVPRBlocks.PADDING_CYAN_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_CYAN_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_CYAN_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_CYAN_TILES.get());
                entries.accept(AVPRBlocks.PADDING_PURPLE_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_PURPLE_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_PURPLE_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_PURPLE_TILES.get());
                entries.accept(AVPRBlocks.PADDING_BLUE_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_BLUE_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_BLUE_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_BLUE_TILES.get());
                entries.accept(AVPRBlocks.PADDING_BROWN_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_BROWN_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_BROWN_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_BROWN_TILES.get());
                entries.accept(AVPRBlocks.PADDING_GREEN_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_GREEN_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_GREEN_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_GREEN_TILES.get());
                entries.accept(AVPRBlocks.PADDING_RED_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_RED_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_RED_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_RED_TILES.get());
                entries.accept(AVPRBlocks.PADDING_BLACK_PANEL.get());
                entries.accept(AVPRBlocks.PADDING_BLACK_PIPES.get());
                entries.accept(AVPRBlocks.PADDING_BLACK_SQUARE.get());
                entries.accept(AVPRBlocks.PADDING_BLACK_TILES.get());
                entries.accept(AVPRBlocks.RAW_BAUXITE_BLOCK.get());
                entries.accept(AVPRBlocks.RAW_TITANIUM_BLOCK.get());
                entries.accept(AVPRBlocks.NEODYMIUM_BLOCK.get());
                entries.accept(AVPRBlocks.COBALT_BLOCK.get());
                entries.accept(AVPRBlocks.LITHIUM_BLOCK.get());
                entries.accept(AVPRBlocks.SILICA_BLOCK.get());
                entries.accept(AVPRBlocks.PLASTIC_WHITE.get());
                entries.accept(AVPRBlocks.PLASTIC_WHITE_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_WHITE_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_WHITE_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_ORANGE.get());
                entries.accept(AVPRBlocks.PLASTIC_ORANGE_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_ORANGE_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_ORANGE_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_MAGENTA.get());
                entries.accept(AVPRBlocks.PLASTIC_MAGENTA_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_MAGENTA_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_MAGENTA_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_LIGHT_BLUE.get());
                entries.accept(AVPRBlocks.PLASTIC_LIGHT_BLUE_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_LIGHT_BLUE_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_LIGHT_BLUE_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_YELLOW.get());
                entries.accept(AVPRBlocks.PLASTIC_YELLOW_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_YELLOW_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_YELLOW_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_LIME.get());
                entries.accept(AVPRBlocks.PLASTIC_LIME_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_LIME_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_LIME_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_PINK.get());
                entries.accept(AVPRBlocks.PLASTIC_PINK_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_PINK_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_PINK_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_GRAY.get());
                entries.accept(AVPRBlocks.PLASTIC_GRAY_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_GRAY_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_GRAY_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_LIGHT_GRAY.get());
                entries.accept(AVPRBlocks.PLASTIC_LIGHT_GRAY_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_LIGHT_GRAY_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_LIGHT_GRAY_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_CYAN.get());
                entries.accept(AVPRBlocks.PLASTIC_CYAN_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_CYAN_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_CYAN_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_PURPLE.get());
                entries.accept(AVPRBlocks.PLASTIC_PURPLE_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_PURPLE_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_PURPLE_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_BLUE.get());
                entries.accept(AVPRBlocks.PLASTIC_BLUE_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_BLUE_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_BLUE_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_BROWN.get());
                entries.accept(AVPRBlocks.PLASTIC_BROWN_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_BROWN_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_BROWN_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_GREEN.get());
                entries.accept(AVPRBlocks.PLASTIC_GREEN_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_GREEN_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_GREEN_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_RED.get());
                entries.accept(AVPRBlocks.PLASTIC_RED_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_RED_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_RED_WALL.get());
                entries.accept(AVPRBlocks.PLASTIC_BLACK.get());
                entries.accept(AVPRBlocks.PLASTIC_BLACK_SLAB.get());
                entries.accept(AVPRBlocks.PLASTIC_BLACK_STAIRS.get());
                entries.accept(AVPRBlocks.PLASTIC_BLACK_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_WHITE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_WHITE_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_WHITE_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_WHITE_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_ORANGE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_ORANGE_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_ORANGE_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_ORANGE_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_MAGENTA.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_MAGENTA_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_MAGENTA_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_MAGENTA_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_BLUE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_BLUE_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_BLUE_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_BLUE_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_YELLOW.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_YELLOW_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_YELLOW_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_YELLOW_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIME.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIME_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIME_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIME_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_PINK.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_PINK_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_PINK_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_PINK_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_GRAY.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_GRAY_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_GRAY_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_GRAY_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_GRAY.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_GRAY_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_GRAY_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_GRAY_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_CYAN.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_CYAN_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_CYAN_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_CYAN_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_PURPLE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_PURPLE_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_PURPLE_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_PURPLE_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BLUE.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BLUE_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BLUE_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BLUE_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BROWN.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BROWN_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BROWN_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BROWN_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_GREEN.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_GREEN_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_GREEN_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_GREEN_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_RED.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_RED_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_RED_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_RED_WALL.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BLACK.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BLACK_SLAB.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BLACK_STAIRS.get());
                entries.accept(AVPRBlocks.INDUSTRIAL_WALL_BLACK_WALL.get());
                entries.accept(AVPRBlocks.SOLAR_PANEL.get());
                entries.accept(AVPRBlocks.UNIDENTIFIED_DIRT.get());
                entries.accept(AVPRBlocks.UNIDENTIFIED_GRAVEL.get());
                entries.accept(AVPRBlocks.UNIDENTIFIED_ROCK.get());
                entries.accept(AVPRBlocks.UNIDENTIFIED_SAND.get());
                entries.accept(AVPRBlocks.UNIDENTIFIED_STONE.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_BRICK.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_BRICK_SLAB.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_BRICK_STAIRS.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_BRICK_WALL.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_DECOR_1.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_DECOR_2.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_DECOR_3.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_DECOR_3_SLAB.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_DECOR_3_STAIRS.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_DECOR_3_WALL.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_PANEL.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_SUPPORT_PILLAR.get());
                entries.accept(AVPRBlocks.YAUTJA_SHIP_WALL_BASE.get());
                entries.accept(AVPRBlocks.TEMPLE_WALL_BASE.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_CHESTBURSTER.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_FACEHUGGER.get());
                entries.accept(AVPRBlocks.TEMPLE_SKULL.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_SLAB.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_STAIRS.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_WALL.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_SINGLE.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_SINGLE_SLAB.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_SIMPLE_STAIRS.get());
                entries.accept(AVPRBlocks.TEMPLE_BRICK_SIMPLE_WALL.get());
                entries.accept(AVPRBlocks.TEMPLE_FLOOR.get());
                entries.accept(AVPRBlocks.TEMPLE_FLOOR_SLAB.get());
                entries.accept(AVPRBlocks.TEMPLE_FLOOR_STAIRS.get());
                entries.accept(AVPRBlocks.TEMPLE_FLOOR_WALL.get());
                entries.accept(AVPRBlocks.TEMPLE_TILE.get());
                entries.accept(AVPRBlocks.TEMPLE_TILE_SLAB.get());
                entries.accept(AVPRBlocks.TEMPLE_TILE_STAIRS.get());
                entries.accept(AVPRBlocks.TEMPLE_TILE_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_1.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_1_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_1_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_1_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_2.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_2_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_2_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_2_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_3.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_3_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_3_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_BRICK_3_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_0.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_0_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_0_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_0_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_1.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_1_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_1_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_1_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_2.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_2_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_2_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_MATERIAL_2_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_1.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_1_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_1_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_1_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_2.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_2_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_2_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_2_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_3.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_3_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_3_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_3_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_4.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_4_SLAB.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_4_STAIRS.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_WALL_4_WALL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_COLUMN_1.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_COLUMN_2.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_FLOOR.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_GRAVEL.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_ROCK.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_ROCK_1.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_ROCK_2.get());
                entries.accept(AVPRBlocks.ENGINEER_SHIP_ROCK_3.get());
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
