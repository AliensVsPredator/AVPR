package org.avpr.common.registries;

import net.minecraft.core.Holder;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.*;
import java.util.function.Supplier;

import org.avpr.common.CommonMod;
import org.avpr.common.api.common.items.ArmorProperties;
import org.avpr.common.items.GrenadeItem;
import org.avpr.common.items.armor.AVPRArmorItem;
import org.avpr.common.items.armor.AVPRArmorMaterials;
import org.avpr.common.items.guns.BaseGunItem;
import org.avpr.common.items.tools.AVPRToolMaterials;
import org.avpr.common.platform.AVPRServices;

public record AVPRItems() {

    public static final Supplier<BlockItem> RESIN_BLOCK_ITEM = AVPRItems.registerItem(
        "resin",
        () -> new BlockItem(AVPRBlocks.RESIN_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> RESIN_VEIN_BLOCK_ITEM = AVPRItems.registerItem(
        "resin_vein",
        () -> new BlockItem(AVPRBlocks.RESIN_VEIN_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> RESIN_WEBBING_BLOCK_ITEM = AVPRItems.registerItem(
        "resin_webbing",
        () -> new BlockItem(AVPRBlocks.RESIN_WEBBING_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ORIONITE_BLOCK_ITEM = AVPRItems.registerItem(
        "orionite_block",
        () -> new BlockItem(AVPRBlocks.ORIONITE_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_HAZARD_ITEM = AVPRItems.registerItem(
        "industrial_wall_hazard",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_HAZARD.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> SOLAR_PANEL_ITEM = AVPRItems.registerItem(
        "solar_panel",
        () -> new BlockItem(AVPRBlocks.SOLAR_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_DIRT_ITEM = AVPRItems.registerItem(
        "unidentified_dirt",
        () -> new BlockItem(AVPRBlocks.UNIDENTIFIED_DIRT.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_GRAVEL_ITEM = AVPRItems.registerItem(
        "unidentified_gravel",
        () -> new BlockItem(AVPRBlocks.UNIDENTIFIED_GRAVEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_ROCK_ITEM = AVPRItems.registerItem(
        "unidentified_rock",
        () -> new BlockItem(AVPRBlocks.UNIDENTIFIED_ROCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_SAND_ITEM = AVPRItems.registerItem(
        "unidentified_sand",
        () -> new BlockItem(AVPRBlocks.UNIDENTIFIED_SAND.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_STONE_ITEM = AVPRItems.registerItem(
        "unidentified_stone",
        () -> new BlockItem(AVPRBlocks.UNIDENTIFIED_STONE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_BRICK_ITEM = AVPRItems.registerItem(
        "yautja_ship_brick",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_BRICK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_BRICK_SLAB_ITEM = AVPRItems.registerItem(
        "yautja_ship_brick_slab",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_BRICK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_BRICK_STAIRS_ITEM = AVPRItems.registerItem(
        "yautja_ship_brick_stairs",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_BRICK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_BRICK_WALL_ITEM = AVPRItems.registerItem(
        "yautja_ship_brick_wall",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_BRICK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_1_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_1",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_DECOR_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_2_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_2",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_DECOR_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_3_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_3",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_DECOR_3.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_3_SLAB_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_3_slab",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_DECOR_3_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_3_STAIRS_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_3_stairs",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_DECOR_3_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_3_WALL_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_3_wall",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_DECOR_3_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_PANEL_ITEM = AVPRItems.registerItem(
        "yautja_ship_panel",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_SUPPORT_PILLAR_ITEM = AVPRItems.registerItem(
        "yautja_ship_support_pillar",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_SUPPORT_PILLAR.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_WALL_BASE_ITEM = AVPRItems.registerItem(
        "yautja_ship_wall_base",
        () -> new BlockItem(AVPRBlocks.YAUTJA_SHIP_WALL_BASE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_WALL_BASE_ITEM = AVPRItems.registerItem(
        "temple_wall_base",
        () -> new BlockItem(AVPRBlocks.TEMPLE_WALL_BASE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_CHESTBURSTER_ITEM = AVPRItems.registerItem(
        "temple_brick_chestburster",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_CHESTBURSTER.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_FACEHUGGER_ITEM = AVPRItems.registerItem(
        "temple_brick_facehugger",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_FACEHUGGER.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_SKULL_ITEM = AVPRItems.registerItem(
        "temple_skulls",
        () -> new BlockItem(AVPRBlocks.TEMPLE_SKULL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_ITEM = AVPRItems.registerItem(
        "temple_brick",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SLAB_ITEM = AVPRItems.registerItem(
        "temple_brick_slab",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_STAIRS_ITEM = AVPRItems.registerItem(
        "temple_brick_stairs",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_WALL_ITEM = AVPRItems.registerItem(
        "temple_brick_wall",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SINGLE_ITEM = AVPRItems.registerItem(
        "temple_brick_single",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_SINGLE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SINGLE_SLAB_ITEM = AVPRItems.registerItem(
        "temple_brick_single_slab",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_SINGLE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SIMPLE_STAIRS_ITEM = AVPRItems.registerItem(
        "temple_brick_single_stairs",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_SIMPLE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SIMPLE_WALL_ITEM = AVPRItems.registerItem(
        "temple_brick_single_wall",
        () -> new BlockItem(AVPRBlocks.TEMPLE_BRICK_SIMPLE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_FLOOR_ITEM = AVPRItems.registerItem(
        "temple_floor",
        () -> new BlockItem(AVPRBlocks.TEMPLE_FLOOR.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_FLOOR_SLAB_ITEM = AVPRItems.registerItem(
        "temple_floor_slab",
        () -> new BlockItem(AVPRBlocks.TEMPLE_FLOOR_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_FLOOR_STAIRS_ITEM = AVPRItems.registerItem(
        "temple_floor_stairs",
        () -> new BlockItem(AVPRBlocks.TEMPLE_FLOOR_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_FLOOR_WALL_ITEM = AVPRItems.registerItem(
        "temple_floor_wall",
        () -> new BlockItem(AVPRBlocks.TEMPLE_FLOOR_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_TILE_ITEM = AVPRItems.registerItem(
        "temple_tile",
        () -> new BlockItem(AVPRBlocks.TEMPLE_TILE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_TILE_SLAB_ITEM = AVPRItems.registerItem(
        "temple_tile_slab",
        () -> new BlockItem(AVPRBlocks.TEMPLE_TILE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_TILE_STAIRS_ITEM = AVPRItems.registerItem(
        "temple_tile_stairs",
        () -> new BlockItem(AVPRBlocks.TEMPLE_TILE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_TILE_WALL_ITEM = AVPRItems.registerItem(
        "temple_tile_wall",
        () -> new BlockItem(AVPRBlocks.TEMPLE_TILE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_1",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_1_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_1_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_1_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_1_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_1_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_1_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_1_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_1_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_1_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_2",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_2_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_2_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_2_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_2_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_2_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_2_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_2_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_2_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_2_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_3_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_3",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_3.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_3_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_3_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_3_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_3_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_3_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_3_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_3_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_3_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_BRICK_3_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_0_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_0",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_0.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_0_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_0_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_0_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_0_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_0_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_0_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_0_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_0_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_0_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_1",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_1_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_1_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_1_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_1_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_1_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_1_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_1_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_1_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_1_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_2",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_2_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_2_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_2_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_2_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_2_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_2_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_2_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_2_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_MATERIAL_2_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_1",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_1_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_1_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_1_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_1_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_1_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_1_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_1_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_1_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_1_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_2",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_2_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_2_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_2_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_2_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_2_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_2_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_2_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_2_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_2_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_3_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_3",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_3.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_3_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_3_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_3_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_3_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_3_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_3_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_3_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_3_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_3_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_4_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_4",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_4.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_4_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_4_slab",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_4_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_4_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_4_stairs",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_4_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_4_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_4_wall",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_WALL_4_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_COLUMN_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_column_1",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_COLUMN_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_COLUMN_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_column_2",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_COLUMN_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_FLOOR_ITEM = AVPRItems.registerItem(
        "engineer_ship_floor",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_FLOOR.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_GRAVEL_ITEM = AVPRItems.registerItem(
        "engineer_ship_gravel",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_GRAVEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_ROCK_ITEM = AVPRItems.registerItem(
        "engineer_ship_rock",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_ROCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_ROCK_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_rock_1",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_ROCK_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_ROCK_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_rock_2",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_ROCK_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_ROCK_3_ITEM = AVPRItems.registerItem(
        "engineer_ship_rock_3",
        () -> new BlockItem(AVPRBlocks.ENGINEER_SHIP_ROCK_3.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_WHITE_ITEM = AVPRItems.registerItem(
        "plastic_white",
        () -> new BlockItem(AVPRBlocks.PLASTIC_WHITE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_WHITE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_white_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_WHITE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_WHITE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_white_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_WHITE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_WHITE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_white_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_WHITE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_ORANGE_ITEM = AVPRItems.registerItem(
        "plastic_orange",
        () -> new BlockItem(AVPRBlocks.PLASTIC_ORANGE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_ORANGE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_orange_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_ORANGE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_ORANGE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_orange_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_ORANGE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_ORANGE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_orange_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_ORANGE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_MAGENTA_ITEM = AVPRItems.registerItem(
        "plastic_magenta",
        () -> new BlockItem(AVPRBlocks.PLASTIC_MAGENTA.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_MAGENTA_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_magenta_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_MAGENTA_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_MAGENTA_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_magenta_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_MAGENTA_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_MAGENTA_WALL_ITEM = AVPRItems.registerItem(
        "plastic_magenta_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_MAGENTA_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_BLUE_ITEM = AVPRItems.registerItem(
        "plastic_light_blue",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIGHT_BLUE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PURPLE_ITEM = AVPRItems.registerItem(
        "plastic_purple",
        () -> new BlockItem(AVPRBlocks.PLASTIC_PURPLE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIME_ITEM = AVPRItems.registerItem(
        "plastic_lime",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIME.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PINK_ITEM = AVPRItems.registerItem(
        "plastic_pink",
        () -> new BlockItem(AVPRBlocks.PLASTIC_PINK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GRAY_ITEM = AVPRItems.registerItem(
        "plastic_gray",
        () -> new BlockItem(AVPRBlocks.PLASTIC_GRAY.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLUE_ITEM = AVPRItems.registerItem(
        "plastic_blue",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BLUE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BROWN_ITEM = AVPRItems.registerItem(
        "plastic_brown",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BROWN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_RED_ITEM = AVPRItems.registerItem(
        "plastic_red",
        () -> new BlockItem(AVPRBlocks.PLASTIC_RED.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_BLUE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_light_blue_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIGHT_BLUE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_BLUE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_light_blue_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIGHT_BLUE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_BLUE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_light_blue_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIGHT_BLUE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_YELLOW_ITEM = AVPRItems.registerItem(
        "plastic_yellow",
        () -> new BlockItem(AVPRBlocks.PLASTIC_YELLOW.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_YELLOW_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_yellow_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_YELLOW_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_YELLOW_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_yellow_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_YELLOW_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_YELLOW_WALL_ITEM = AVPRItems.registerItem(
        "plastic_yellow_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_YELLOW_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIME_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_lime_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIME_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIME_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_lime_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIME_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIME_WALL_ITEM = AVPRItems.registerItem(
        "plastic_lime_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIME_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PINK_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_pink_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_PINK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PINK_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_pink_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_PINK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PINK_WALL_ITEM = AVPRItems.registerItem(
        "plastic_pink_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_PINK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GRAY_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_gray_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_GRAY_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GRAY_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_gray_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_GRAY_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GRAY_WALL_ITEM = AVPRItems.registerItem(
        "plastic_gray_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_GRAY_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_GRAY_ITEM = AVPRItems.registerItem(
        "plastic_light_gray",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIGHT_GRAY.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_GRAY_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_light_gray_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIGHT_GRAY_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_GRAY_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_light_gray_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIGHT_GRAY_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_GRAY_WALL_ITEM = AVPRItems.registerItem(
        "plastic_light_gray_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_LIGHT_GRAY_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_CYAN_ITEM = AVPRItems.registerItem(
        "plastic_cyan",
        () -> new BlockItem(AVPRBlocks.PLASTIC_CYAN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_CYAN_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_cyan_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_CYAN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_CYAN_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_cyan_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_CYAN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_CYAN_WALL_ITEM = AVPRItems.registerItem(
        "plastic_cyan_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_CYAN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PURPLE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_purple_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_PURPLE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PURPLE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_purple_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_PURPLE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PURPLE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_purple_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_PURPLE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLUE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_blue_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BLUE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLUE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_blue_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BLUE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLUE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_blue_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BLUE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BROWN_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_brown_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BROWN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BROWN_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_brown_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BROWN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BROWN_WALL_ITEM = AVPRItems.registerItem(
        "plastic_brown_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BROWN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GREEN_ITEM = AVPRItems.registerItem(
        "plastic_green_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_GREEN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GREEN_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_green",
        () -> new BlockItem(AVPRBlocks.PLASTIC_GREEN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GREEN_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_green_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_GREEN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GREEN_WALL_ITEM = AVPRItems.registerItem(
        "plastic_green_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_GREEN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_RED_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_red_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_RED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_RED_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_red_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_RED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_RED_WALL_ITEM = AVPRItems.registerItem(
        "plastic_red_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_RED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLACK_ITEM = AVPRItems.registerItem(
        "plastic_black",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BLACK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLACK_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_black_slab",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BLACK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLACK_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_black_stairs",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BLACK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLACK_WALL_ITEM = AVPRItems.registerItem(
        "plastic_black_wall",
        () -> new BlockItem(AVPRBlocks.PLASTIC_BLACK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_WHITE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_white_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_WHITE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_WHITE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_white_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_WHITE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_WHITE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_white_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_WHITE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_ORANGE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_orange_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_ORANGE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_ORANGE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_orange_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_ORANGE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_ORANGE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_orange_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_ORANGE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_MAGENTA_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_magenta_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_MAGENTA_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_MAGENTA_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_magenta_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_MAGENTA_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_MAGENTA_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_magenta_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_MAGENTA_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_BLUE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_blue_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_BLUE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_BLUE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_blue_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_BLUE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_BLUE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_blue_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_BLUE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_YELLOW_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_yellow_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_YELLOW_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_YELLOW_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_yellow_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_YELLOW_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_YELLOW_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_yellow_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_YELLOW_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIME_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_lime_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIME_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIME_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_lime_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIME_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIME_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_lime_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIME_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PINK_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_pink_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_PINK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PINK_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_pink_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_PINK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PINK_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_pink_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_PINK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GRAY_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_gray_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_GRAY_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GRAY_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_gray_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_GRAY_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GRAY_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_gray_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_GRAY_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_GRAY_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_gray_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_GRAY_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_GRAY_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_gray_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_GRAY_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_GRAY_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_gray_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_LIGHT_GRAY_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_CYAN_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_cyan_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_CYAN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_CYAN_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_cyan_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_CYAN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_CYAN_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_cyan_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_CYAN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PURPLE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_purple_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_PURPLE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PURPLE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_purple_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_PURPLE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PURPLE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_purple_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_PURPLE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLUE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_blue_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BLUE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLUE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_blue_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BLUE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLUE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_blue_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BLUE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BROWN_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_brown_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BROWN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BROWN_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_brown_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BROWN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BROWN_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_brown_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BROWN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GREEN_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_green_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_GREEN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GREEN_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_green_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_GREEN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GREEN_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_green_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_GREEN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_RED_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_red_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_RED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_RED_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_red_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_RED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_RED_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_red_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_RED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLACK_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_black_slab",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BLACK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLACK_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_black_stairs",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BLACK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLACK_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_black_wall",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_BLACK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_white_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_white_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_white_square",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_TILES_ITEM = AVPRItems.registerItem(
        "padding_white_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_orange_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_orange_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_orange_square",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_TILES_ITEM = AVPRItems.registerItem(
        "padding_orange_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_PANEL_ITEM = AVPRItems.registerItem(
        "padding_magenta_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_PIPES_ITEM = AVPRItems.registerItem(
        "padding_magenta_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_magenta_square",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_TILES_ITEM = AVPRItems.registerItem(
        "padding_magenta_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_light_blue_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_light_blue_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_light_blue_square",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_TILES_ITEM = AVPRItems.registerItem(
        "padding_light_blue_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_PANEL_ITEM = AVPRItems.registerItem(
        "padding_yellow_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_PIPES_ITEM = AVPRItems.registerItem(
        "padding_yellow_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_yellow_square",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_TILES_ITEM = AVPRItems.registerItem(
        "padding_yellow_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_PANEL_ITEM = AVPRItems.registerItem(
        "padding_lime_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_PIPES_ITEM = AVPRItems.registerItem(
        "padding_lime_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_lime_square",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_TILES_ITEM = AVPRItems.registerItem(
        "padding_lime_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_PANEL_ITEM = AVPRItems.registerItem(
        "padding_pink_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_PIPES_ITEM = AVPRItems.registerItem(
        "padding_pink_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_pink_square",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_TILES_ITEM = AVPRItems.registerItem(
        "padding_pink_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_PANEL_ITEM = AVPRItems.registerItem(
        "padding_gray_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_PIPES_ITEM = AVPRItems.registerItem(
        "padding_gray_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_gray_square",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_TILES_ITEM = AVPRItems.registerItem(
        "padding_gray_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_PANEL_ITEM = AVPRItems.registerItem(
        "padding_light_gray_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_PIPES_ITEM = AVPRItems.registerItem(
        "padding_light_gray_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_light_gray_square",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_TILES_ITEM = AVPRItems.registerItem(
        "padding_light_gray_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_PANEL_ITEM = AVPRItems.registerItem(
        "padding_cyan_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_PIPES_ITEM = AVPRItems.registerItem(
        "padding_cyan_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_cyan_square",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_TILES_ITEM = AVPRItems.registerItem(
        "padding_cyan_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_purple_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_purple_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_purple_square",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_TILES_ITEM = AVPRItems.registerItem(
        "padding_purple_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_blue_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_blue_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_blue_square",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_TILES_ITEM = AVPRItems.registerItem(
        "padding_blue_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_PANEL_ITEM = AVPRItems.registerItem(
        "padding_brown_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_PIPES_ITEM = AVPRItems.registerItem(
        "padding_brown_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_brown_square",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_TILES_ITEM = AVPRItems.registerItem(
        "padding_brown_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_PANEL_ITEM = AVPRItems.registerItem(
        "padding_green_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_PIPES_ITEM = AVPRItems.registerItem(
        "padding_green_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_green_square",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_TILES_ITEM = AVPRItems.registerItem(
        "padding_green_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_PANEL_ITEM = AVPRItems.registerItem(
        "padding_red_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_PIPES_ITEM = AVPRItems.registerItem(
        "padding_red_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_red_square",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_TILES_ITEM = AVPRItems.registerItem(
        "padding_red_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_PANEL_ITEM = AVPRItems.registerItem(
        "padding_black_panel",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_PIPES_ITEM = AVPRItems.registerItem(
        "padding_black_pipes",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_black_square",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_TILES_ITEM = AVPRItems.registerItem(
        "padding_black_tiles",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_block_item = AVPRItems.registerItem(
        "aluminum_block",
        () -> new BlockItem(AVPRBlocks.aluminum_block.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_grate_item = AVPRItems.registerItem(
        "aluminum_grate",
        () -> new BlockItem(AVPRBlocks.aluminum_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_vent_item = AVPRItems.registerItem(
        "aluminum_vent",
        () -> new BlockItem(AVPRBlocks.aluminum_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_panel_item = AVPRItems.registerItem(
        "aluminum_panel",
        () -> new BlockItem(AVPRBlocks.aluminum_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_plated_item = AVPRItems.registerItem(
        "aluminum_plated",
        () -> new BlockItem(AVPRBlocks.aluminum_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_plated_chevron_item = AVPRItems.registerItem(
        "aluminum_plated_chevron",
        () -> new BlockItem(AVPRBlocks.aluminum_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_cut_item = AVPRItems.registerItem(
        "aluminum_cut",
        () -> new BlockItem(AVPRBlocks.aluminum_cut.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_grate_item = AVPRItems.registerItem(
        "copper_grate",
        () -> new BlockItem(AVPRBlocks.copper_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_vent_item = AVPRItems.registerItem(
        "copper_vent",
        () -> new BlockItem(AVPRBlocks.copper_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_panel_item = AVPRItems.registerItem(
        "copper_panel",
        () -> new BlockItem(AVPRBlocks.copper_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_plated_item = AVPRItems.registerItem(
        "copper_plated",
        () -> new BlockItem(AVPRBlocks.copper_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_plated_chevron_item = AVPRItems.registerItem(
        "copper_plated_chevron",
        () -> new BlockItem(AVPRBlocks.copper_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_block_item = AVPRItems.registerItem(
        "ferroaluminum_block",
        () -> new BlockItem(AVPRBlocks.ferroaluminum_block.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_grate_item = AVPRItems.registerItem(
        "ferroaluminum_grate",
        () -> new BlockItem(AVPRBlocks.ferroaluminum_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_vent_item = AVPRItems.registerItem(
        "ferroaluminum_vent",
        () -> new BlockItem(AVPRBlocks.ferroaluminum_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_panel_item = AVPRItems.registerItem(
        "ferroaluminum_panel",
        () -> new BlockItem(AVPRBlocks.ferroaluminum_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_plated_item = AVPRItems.registerItem(
        "ferroaluminum_plated",
        () -> new BlockItem(AVPRBlocks.ferroaluminum_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_plated_chevron_item = AVPRItems.registerItem(
        "ferroaluminum_plated_chevron",
        () -> new BlockItem(AVPRBlocks.ferroaluminum_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_cut_item = AVPRItems.registerItem(
        "ferroaluminum_cut",
        () -> new BlockItem(AVPRBlocks.ferroaluminum_cut.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_grate_item = AVPRItems.registerItem(
        "gold_grate",
        () -> new BlockItem(AVPRBlocks.gold_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_vent_item = AVPRItems.registerItem(
        "gold_vent",
        () -> new BlockItem(AVPRBlocks.gold_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_panel_item = AVPRItems.registerItem(
        "gold_panel",
        () -> new BlockItem(AVPRBlocks.gold_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_plated_item = AVPRItems.registerItem(
        "gold_plated",
        () -> new BlockItem(AVPRBlocks.gold_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_plated_chevron_item = AVPRItems.registerItem(
        "gold_plated_chevron",
        () -> new BlockItem(AVPRBlocks.gold_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_grate_item = AVPRItems.registerItem(
        "iron_grate",
        () -> new BlockItem(AVPRBlocks.iron_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_vent_item = AVPRItems.registerItem(
        "iron_vent",
        () -> new BlockItem(AVPRBlocks.iron_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_panel_item = AVPRItems.registerItem(
        "iron_panel",
        () -> new BlockItem(AVPRBlocks.iron_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_plated_item = AVPRItems.registerItem(
        "iron_plated",
        () -> new BlockItem(AVPRBlocks.iron_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_plated_chevron_item = AVPRItems.registerItem(
        "iron_plated_chevron",
        () -> new BlockItem(AVPRBlocks.iron_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_grate_item = AVPRItems.registerItem(
        "netherite_grate",
        () -> new BlockItem(AVPRBlocks.netherite_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_vent_item = AVPRItems.registerItem(
        "netherite_vent",
        () -> new BlockItem(AVPRBlocks.netherite_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_panel_item = AVPRItems.registerItem(
        "netherite_panel",
        () -> new BlockItem(AVPRBlocks.netherite_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_plated_item = AVPRItems.registerItem(
        "netherite_plated",
        () -> new BlockItem(AVPRBlocks.netherite_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_plated_chevron_item = AVPRItems.registerItem(
        "netherite_plated_chevron",
        () -> new BlockItem(AVPRBlocks.netherite_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_block_item = AVPRItems.registerItem(
        "steel_block",
        () -> new BlockItem(AVPRBlocks.steel_block.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_grate_item = AVPRItems.registerItem(
        "steel_grate",
        () -> new BlockItem(AVPRBlocks.steel_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_vent_item = AVPRItems.registerItem(
        "steel_vent",
        () -> new BlockItem(AVPRBlocks.steel_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_panel_item = AVPRItems.registerItem(
        "steel_panel",
        () -> new BlockItem(AVPRBlocks.steel_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_plated_item = AVPRItems.registerItem(
        "steel_plated",
        () -> new BlockItem(AVPRBlocks.steel_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_plated_chevron_item = AVPRItems.registerItem(
        "steel_plated_chevron",
        () -> new BlockItem(AVPRBlocks.steel_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_cut_item = AVPRItems.registerItem(
        "steel_cut",
        () -> new BlockItem(AVPRBlocks.steel_cut.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_block_item = AVPRItems.registerItem(
        "titanium_block",
        () -> new BlockItem(AVPRBlocks.titanium_block.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_grate_item = AVPRItems.registerItem(
        "titanium_grate",
        () -> new BlockItem(AVPRBlocks.titanium_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_vent_item = AVPRItems.registerItem(
        "titanium_vent",
        () -> new BlockItem(AVPRBlocks.titanium_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_panel_item = AVPRItems.registerItem(
        "titanium_panel",
        () -> new BlockItem(AVPRBlocks.titanium_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_plated_item = AVPRItems.registerItem(
        "titanium_plated",
        () -> new BlockItem(AVPRBlocks.titanium_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_plated_chevron_item = AVPRItems.registerItem(
        "titanium_plated_chevron",
        () -> new BlockItem(AVPRBlocks.titanium_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_cut_item = AVPRItems.registerItem(
        "titanium_cut",
        () -> new BlockItem(AVPRBlocks.titanium_cut.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_GLASS_ITEM = AVPRItems.registerItem(
        "industrial_glass",
        () -> new BlockItem(AVPRBlocks.INDUSTRIAL_GLASS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_CUT_SLAB_ITEM = AVPRItems.registerItem(
        "aluminum_cut_slab",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_CUT_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_CUT_STAIRS_ITEM = AVPRItems.registerItem(
        "aluminum_cut_stairs",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_CUT_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_CUT_WALL_ITEM = AVPRItems.registerItem(
        "aluminum_cut_wall",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_CUT_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "aluminum_plated_chevron_slab",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "aluminum_plated_chevron_stairs",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "aluminum_plated_chevron_wall",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "aluminum_plated_slab",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "aluminum_plated_stairs",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "aluminum_plated_wall",
        () -> new BlockItem(AVPRBlocks.ALUMINUM_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "copper_plated_chevron_slab",
        () -> new BlockItem(AVPRBlocks.COPPER_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "copper_plated_chevron_stairs",
        () -> new BlockItem(AVPRBlocks.COPPER_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "copper_plated_chevron_wall",
        () -> new BlockItem(AVPRBlocks.COPPER_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "copper_plated_slab",
        () -> new BlockItem(AVPRBlocks.COPPER_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "copper_plated_stairs",
        () -> new BlockItem(AVPRBlocks.COPPER_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "copper_plated_wall",
        () -> new BlockItem(AVPRBlocks.COPPER_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_CUT_SLAB_ITEM = AVPRItems.registerItem(
        "ferroaluminum_cut_slab",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_CUT_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_CUT_STAIRS_ITEM = AVPRItems.registerItem(
        "ferroaluminum_cut_stairs",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_CUT_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_CUT_WALL_ITEM = AVPRItems.registerItem(
        "ferroaluminum_cut_wall",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_CUT_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_chevron_slab",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_chevron_stairs",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_chevron_wall",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_slab",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_stairs",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_wall",
        () -> new BlockItem(AVPRBlocks.FERROALUMINUM_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "gold_plated_chevron_slab",
        () -> new BlockItem(AVPRBlocks.GOLD_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "gold_plated_chevron_stairs",
        () -> new BlockItem(AVPRBlocks.GOLD_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "gold_plated_chevron_wall",
        () -> new BlockItem(AVPRBlocks.GOLD_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "gold_plated_slab",
        () -> new BlockItem(AVPRBlocks.GOLD_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "gold_plated_stairs",
        () -> new BlockItem(AVPRBlocks.GOLD_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "gold_plated_wall",
        () -> new BlockItem(AVPRBlocks.GOLD_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "iron_plated_chevron_slab",
        () -> new BlockItem(AVPRBlocks.IRON_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "iron_plated_chevron_stairs",
        () -> new BlockItem(AVPRBlocks.IRON_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "iron_plated_chevron_wall",
        () -> new BlockItem(AVPRBlocks.IRON_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "iron_plated_slab",
        () -> new BlockItem(AVPRBlocks.IRON_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "iron_plated_stairs",
        () -> new BlockItem(AVPRBlocks.IRON_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "iron_plated_wall",
        () -> new BlockItem(AVPRBlocks.IRON_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "netherite_plated_chevron_slab",
        () -> new BlockItem(AVPRBlocks.NETHERITE_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "netherite_plated_chevron_stairs",
        () -> new BlockItem(AVPRBlocks.NETHERITE_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "netherite_plated_chevron_wall",
        () -> new BlockItem(AVPRBlocks.NETHERITE_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "netherite_plated_slab",
        () -> new BlockItem(AVPRBlocks.NETHERITE_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "netherite_plated_stairs",
        () -> new BlockItem(AVPRBlocks.NETHERITE_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "netherite_plated_wall",
        () -> new BlockItem(AVPRBlocks.NETHERITE_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_black_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_black_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_black_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_black_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_black_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_black_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_BLACK_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_blue_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_blue_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_blue_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_blue_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_blue_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_blue_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_BLUE_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_brown_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_brown_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_brown_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_brown_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_brown_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_brown_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_BROWN_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_cyan_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_cyan_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_cyan_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_cyan_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_cyan_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_cyan_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_CYAN_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_gray_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_gray_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_gray_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_gray_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_gray_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_gray_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_GRAY_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_green_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_green_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_green_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_green_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_green_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_green_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_GREEN_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_light_blue_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_light_blue_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_light_blue_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_light_blue_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_light_blue_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_light_blue_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_BLUE_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_light_gray_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_light_gray_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_light_gray_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_light_gray_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_light_gray_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_light_gray_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_LIGHT_GRAY_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_lime_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_lime_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_lime_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_lime_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_lime_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_lime_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_LIME_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_magenta_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_magenta_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_magenta_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_magenta_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_magenta_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_magenta_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_MAGENTA_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_orange_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_orange_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_orange_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_orange_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_orange_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_orange_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_ORANGE_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_pink_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_pink_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_pink_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_pink_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_pink_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_pink_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_PINK_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_purple_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_purple_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_purple_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_purple_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_purple_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_purple_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_PURPLE_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_red_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_red_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_red_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_red_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_red_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_red_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_RED_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_white_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_white_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_white_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_white_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_white_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_white_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_WHITE_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_yellow_square_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_yellow_square_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_yellow_square_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_TILES_SLAB_ITEM = AVPRItems.registerItem(
        "padding_yellow_tiles_slab",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_TILES_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_TILES_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_yellow_tiles_stairs",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_TILES_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_TILES_WALL_ITEM = AVPRItems.registerItem(
        "padding_yellow_tiles_wall",
        () -> new BlockItem(AVPRBlocks.PADDING_YELLOW_TILES_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_CUT_SLAB_ITEM = AVPRItems.registerItem(
        "steel_cut_slab",
        () -> new BlockItem(AVPRBlocks.STEEL_CUT_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_CUT_STAIRS_ITEM = AVPRItems.registerItem(
        "steel_cut_stairs",
        () -> new BlockItem(AVPRBlocks.STEEL_CUT_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_CUT_WALL_ITEM = AVPRItems.registerItem(
        "steel_cut_wall",
        () -> new BlockItem(AVPRBlocks.STEEL_CUT_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "steel_plated_chevron_slab",
        () -> new BlockItem(AVPRBlocks.STEEL_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "steel_plated_chevron_stairs",
        () -> new BlockItem(AVPRBlocks.STEEL_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "steel_plated_chevron_wall",
        () -> new BlockItem(AVPRBlocks.STEEL_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "steel_plated_slab",
        () -> new BlockItem(AVPRBlocks.STEEL_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "steel_plated_stairs",
        () -> new BlockItem(AVPRBlocks.STEEL_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "steel_plated_wall",
        () -> new BlockItem(AVPRBlocks.STEEL_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_CUT_SLAB_ITEM = AVPRItems.registerItem(
        "titanium_cut_slab",
        () -> new BlockItem(AVPRBlocks.TITANIUM_CUT_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_CUT_STAIRS_ITEM = AVPRItems.registerItem(
        "titanium_cut_stairs",
        () -> new BlockItem(AVPRBlocks.TITANIUM_CUT_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_CUT_WALL_ITEM = AVPRItems.registerItem(
        "titanium_cut_wall",
        () -> new BlockItem(AVPRBlocks.TITANIUM_CUT_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "titanium_plated_chevron_slab",
        () -> new BlockItem(AVPRBlocks.TITANIUM_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "titanium_plated_chevron_stairs",
        () -> new BlockItem(AVPRBlocks.TITANIUM_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "titanium_plated_chevron_wall",
        () -> new BlockItem(AVPRBlocks.TITANIUM_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "titanium_plated_slab",
        () -> new BlockItem(AVPRBlocks.TITANIUM_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "titanium_plated_stairs",
        () -> new BlockItem(AVPRBlocks.TITANIUM_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "titanium_plated_wall",
        () -> new BlockItem(AVPRBlocks.TITANIUM_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<SpawnEggItem> OVAMORPH_SPAWN_EGG = AVPRItems.registerItem(
        "spawn_egg_ovamorph",
        AVPRServices.COMMON_REGISTRY.makeSpawnEggFor(
            AVPREntities.OVAMORPH,
            0x615B45,
            0xBF7872,
            new Item.Properties()
        )
    );

    public static final Supplier<SpawnEggItem> FACEHUGGER_SPAWN_EGG = AVPRItems.registerItem(
        "spawn_egg_facehugger",
        AVPRServices.COMMON_REGISTRY.makeSpawnEggFor(
            AVPREntities.FACEHUGGER,
            0xE4D597,
            0xA55863,
            new Item.Properties()
        )
    );

    public static final Supplier<Item> XENO_CHITIN = AVPRItems.registerItem(
        "xenomorph_chitin",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> VERITANIUM_SHARD = AVPRItems.registerItem(
        "veritanium_shard",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> INGOT_ALUMINUM = AVPRItems.registerItem(
        "ingot_aluminum",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> INGOT_ORIONITE = AVPRItems.registerItem(
        "ingot_orionite",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> INGOT_STEEL = AVPRItems.registerItem(
        "ingot_steel",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> INGOT_TITANIUM = AVPRItems.registerItem(
        "ingot_titanium",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> DUST_LITHIUM = AVPRItems.registerItem(
        "dust_lithium",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> COLBALT = AVPRItems.registerItem(
        "cobalt",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BOTTLE_TINTED = AVPRItems.registerItem(
        "bottle_tinted",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BOTTLE_TINTED_ACID = AVPRItems.registerItem(
        "bottle_tinted_acid",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> CARBON = AVPRItems.registerItem(
        "carbon",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> LASER_MINE = AVPRItems.registerItem(
        "laser_mine",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> NBT_DRIVE = AVPRItems.registerItem(
        "nbt_drive",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> NEODYMIUM = AVPRItems.registerItem(
        "neodymium",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> NEODYMIUM_MAGENT = AVPRItems.registerItem(
        "neodymium_magnet",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> POLYCARBONATE = AVPRItems.registerItem(
        "polycarbonate",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> POLYMER = AVPRItems.registerItem(
        "polymer",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> RAW_BAUXITE = AVPRItems.registerItem(
        "raw_bauxite",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> RAW_TITANIUM = AVPRItems.registerItem(
        "raw_titanium",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> RESIN_BALL = AVPRItems.registerItem(
        "resin_ball",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> ROYAL_JELLY = AVPRItems.registerItem(
        "royal_jelly",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> SHEET_ORIONITE = AVPRItems.registerItem(
        "sheet_orionite",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> SHURIKEN = AVPRItems.registerItem(
        "shuriken",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> SILICA = AVPRItems.registerItem(
        "silica",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> SMART_DISC = AVPRItems.registerItem(
        "smart_disc",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> YAUTJA_ARTIFCAT = AVPRItems.registerItem(
        "yautja_artifact",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> ALUMINUM_AXE = AVPRItems.registerItem(
        "tool_aluminum_axe",
        () -> new AxeItem(
            AVPRToolMaterials.ALUMINUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ALUMINUM, 5.0F, -3.0F))
        )
    );

    public static final Supplier<Item> ALUMINUM_HOE = AVPRItems.registerItem(
        "tool_aluminum_hoe",
        () -> new HoeItem(
            AVPRToolMaterials.ALUMINUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.VERITANIUM, -3.0F, 0.0F))
        )
    );

    public static final Supplier<Item> ALUMINUM_PICKAXE = AVPRItems.registerItem(
        "tool_aluminum_pickaxe",
        () -> new PickaxeItem(
            AVPRToolMaterials.ALUMINUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ALUMINUM, 1.0F, -2.8F))
        )
    );

    public static final Supplier<Item> ALUMINUM_SHOVEL = AVPRItems.registerItem(
        "tool_aluminum_shovel",
        () -> new ShovelItem(
            AVPRToolMaterials.ALUMINUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ALUMINUM, 1.5F, -3.0F))
        )
    );

    public static final Supplier<Item> ALUMINUM_SWORD = AVPRItems.registerItem(
        "tool_aluminum_sword",
        () -> new SwordItem(
            AVPRToolMaterials.ALUMINUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.TITANIUM, 3, -2.4F))
        )
    );

    public static final Supplier<Item> ORIONITE_AXE = AVPRItems.registerItem(
        "tool_orionite_axe",
        () -> new AxeItem(
            AVPRToolMaterials.ORIONITE,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ORIONITE, 5.0F, -3.0F))
        )
    );

    public static final Supplier<Item> ORIONITE_HOE = AVPRItems.registerItem(
        "tool_orionite_hoe",
        () -> new HoeItem(
            AVPRToolMaterials.ORIONITE,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ORIONITE, -3.0F, 0.0F))
        )
    );

    public static final Supplier<Item> ORIONITE_PICKAXE = AVPRItems.registerItem(
        "tool_orionite_pickaxe",
        () -> new PickaxeItem(
            AVPRToolMaterials.ORIONITE,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ORIONITE, 1.0F, -2.8F))
        )
    );

    public static final Supplier<Item> ORIONITE_SHOVEL = AVPRItems.registerItem(
        "tool_orionite_shovel",
        () -> new ShovelItem(
            AVPRToolMaterials.ORIONITE,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ALUMINUM, 1.5F, -3.0F))
        )
    );

    public static final Supplier<Item> ORIONITE_SWORD = AVPRItems.registerItem(
        "tool_orionite_sword",
        () -> new SwordItem(
            AVPRToolMaterials.ORIONITE,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.TITANIUM, 3, -2.4F))
        )
    );

    public static final Supplier<Item> TITANIUM_AXE = AVPRItems.registerItem(
        "tool_titanium_axe",
        () -> new AxeItem(
            AVPRToolMaterials.TITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.TITANIUM, 5.0F, -3.0F))
        )
    );

    public static final Supplier<Item> TITANIUM_HOE = AVPRItems.registerItem(
        "tool_titanium_hoe",
        () -> new HoeItem(
            AVPRToolMaterials.TITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.TITANIUM, -3.0F, 0.0F))
        )
    );

    public static final Supplier<Item> TITANIUM_PICKAXE = AVPRItems.registerItem(
        "tool_titanium_pickaxe",
        () -> new PickaxeItem(
            AVPRToolMaterials.TITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.TITANIUM, 1.0F, -2.8F))
        )
    );

    public static final Supplier<Item> TITANIUM_SHOVEL = AVPRItems.registerItem(
        "tool_titanium_shovel",
        () -> new ShovelItem(
            AVPRToolMaterials.TITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ALUMINUM, 1.5F, -3.0F))
        )
    );

    public static final Supplier<Item> TITANIUM_SWORD = AVPRItems.registerItem(
        "tool_titanium_sword",
        () -> new SwordItem(
            AVPRToolMaterials.TITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.TITANIUM, 3, -2.4F))
        )
    );

    public static final Supplier<Item> VERITANIUM_AXE = AVPRItems.registerItem(
        "tool_veritanium_axe",
        () -> new AxeItem(
            AVPRToolMaterials.VERITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.VERITANIUM, 5.0F, -3.0F))
        )
    );

    public static final Supplier<Item> VERITANIUM_HOE = AVPRItems.registerItem(
        "tool_veritanium_hoe",
        () -> new HoeItem(
            AVPRToolMaterials.VERITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.VERITANIUM, -3.0F, 0.0F))
        )
    );

    public static final Supplier<Item> VERITANIUM_PICKAXE = AVPRItems.registerItem(
        "tool_veritanium_pickaxe",
        () -> new PickaxeItem(
            AVPRToolMaterials.VERITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.VERITANIUM, 1.0F, -2.8F))
        )
    );

    public static final Supplier<Item> VERITANIUM_SHOVEL = AVPRItems.registerItem(
        "tool_veritanium_shovel",
        () -> new ShovelItem(
            AVPRToolMaterials.VERITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.ALUMINUM, 1.5F, -3.0F))
        )
    );

    public static final Supplier<Item> VERITANIUM_SWORD = AVPRItems.registerItem(
        "tool_veritanium_sword",
        () -> new SwordItem(
            AVPRToolMaterials.VERITANIUM,
            new Item.Properties().attributes(DiggerItem.createAttributes(AVPRToolMaterials.TITANIUM, 3, -2.4F))
        )
    );

    public static final Supplier<Item> DORITOS = AVPRItems.registerItem(
        "doritos",
        () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(2).saturationModifier(0.2F).build())
        )
    );

    public static final Supplier<Item> DORITOS_COOL_RANCH = AVPRItems.registerItem(
        "doritos_cool_ranch",
        () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(4).saturationModifier(0.2F).build())
        )
    );

    public static final Supplier<Item> RAW_TENTACLE = AVPRItems.registerItem(
        "raw_tentacle",
        () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(2).saturationModifier(0.2F).build())
        )
    );

    public static final Supplier<Item> TRILO_BITE = AVPRItems.registerItem(
        "trilo_bite",
        () -> new Item(
            new Item.Properties().food(new FoodProperties.Builder().alwaysEdible().nutrition(7).saturationModifier(0.7F).build())
        )
    );

    public static final Supplier<Item> BATTERY = AVPRItems.registerItem(
        "battery",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> CAPACITOR = AVPRItems.registerItem(
        "capacitor",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> CPU = AVPRItems.registerItem(
        "cpu",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> DIODE = AVPRItems.registerItem(
        "diode",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> INTERGRATED_CIRCUIT = AVPRItems.registerItem(
        "integrated_circuit",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> LED = AVPRItems.registerItem(
        "led",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> LED_DISPLAY = AVPRItems.registerItem(
        "led_display",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> MOTHERBOARD = AVPRItems.registerItem(
        "motherboard",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> POWER_SUPPLY = AVPRItems.registerItem(
        "power_supply",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> RAM = AVPRItems.registerItem(
        "ram",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> REGULATOR = AVPRItems.registerItem(
        "regulator",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> RESISTOR = AVPRItems.registerItem(
        "resistor",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> SSD = AVPRItems.registerItem(
        "ssd",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> TRANSISTOR = AVPRItems.registerItem(
        "transistor",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> AMMO_CHARGE_PACK = AVPRItems.registerItem(
        "ammo_charge_pack",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> AMMO_FLAMETHROWER = AVPRItems.registerItem(
        "ammo_flamethrower",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_TIP = AVPRItems.registerItem(
        "bullet_tip",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> CASING_CASELESS = AVPRItems.registerItem(
        "casing_caseless",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> CASING_HEAVY = AVPRItems.registerItem(
        "casing_heavy",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> CASTING_PISTOL = AVPRItems.registerItem(
        "casing_pistol",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> CASING_RIFLE = AVPRItems.registerItem(
        "casing_rifle",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> CASING_SHOTGUN = AVPRItems.registerItem(
        "casing_shotgun",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> ROCKET = AVPRItems.registerItem(
        "rocket",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> ROCKET_ELECTRIC = AVPRItems.registerItem(
        "rocket_electric",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> ROCKET_INCENDIARY = AVPRItems.registerItem(
        "rocket_incendiary",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> ROCKET_PENETRATION = AVPRItems.registerItem(
        "rocket_penetration",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_PART_BARREL = AVPRItems.registerItem(
        "weapon_part_barrel",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_PART_BARREL_MINIGUN = AVPRItems.registerItem(
        "weapon_part_barrel_minigun",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_PART_BARREL_ROCKET = AVPRItems.registerItem(
        "weapon_part_barrel_rocket",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_PART_BARREL_SMART = AVPRItems.registerItem(
        "weapon_part_barrel_smart",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_PART_GRIP = AVPRItems.registerItem(
        "weapon_part_grip",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_PART_RECEIVER = AVPRItems.registerItem(
        "weapon_part_receiver",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_PART_RECEIVER_SMART = AVPRItems.registerItem(
        "weapon_part_receiver_smart",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_PART_STOCK = AVPRItems.registerItem(
        "weapon_part_stock",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_37_12_SHOTGUN = AVPRItems.registerItem(
        "blueprint_37_12_shotgun",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_AK_47 = AVPRItems.registerItem(
        "blueprint_ak_47",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_F90_RIFLE = AVPRItems.registerItem(
        "blueprint_f90_rifle",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_SEVASTOPOL = AVPRItems.registerItem(
        "blueprint_flamethrower_sevastopol",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_M4_CARBINE = AVPRItems.registerItem(
        "blueprint_m4_carbine",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_M41A_PULSE_RIFLE = AVPRItems.registerItem(
        "blueprint_m41a_pulse_rifle",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_M56_SMARTGUN = AVPRItems.registerItem(
        "blueprint_m56_smartgun",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_M83A2_SADAR = AVPRItems.registerItem(
        "blueprint_m83a2_sadar",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_M88MOD4_COMBAT_PISTOL = AVPRItems.registerItem(
        "blueprint_m88mod4_combat_pistol",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_OLD_PAINLESS = AVPRItems.registerItem(
        "blueprint_old_painless",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BLUEPRINT_SNIPER_RIFLE = AVPRItems.registerItem(
        "blueprint_sniper_rifle",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_CASELESS = AVPRItems.registerItem(
        "bullet_caseless",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_CASELESS_ACID = AVPRItems.registerItem(
        "bullet_caseless_acid",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_CASELESS_ELECTRIC = AVPRItems.registerItem(
        "bullet_caseless_electric",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_CASELESS_EXPLOSIVE = AVPRItems.registerItem(
        "bullet_caseless_explosive",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_CASELESS_INCENDIARY = AVPRItems.registerItem(
        "bullet_caseless_incendiary",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_CASELESS_PENETRATION = AVPRItems.registerItem(
        "bullet_caseless_penetration",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_HEAVY = AVPRItems.registerItem(
        "bullet_heavy",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_HEAVY_ACID = AVPRItems.registerItem(
        "bullet_heavy_acid",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_HEAVY_ELECTRIC = AVPRItems.registerItem(
        "bullet_heavy_electric",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_HEAVY_EXPLOSIVE = AVPRItems.registerItem(
        "bullet_heavy_explosive",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_HEAVY_INCENDIARY = AVPRItems.registerItem(
        "bullet_heavy_incendiary",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_HEAVY_PENETRATION = AVPRItems.registerItem(
        "bullet_heavy_penetration",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_PISTOL = AVPRItems.registerItem(
        "bullet_pistol",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_PISTOL_ACID = AVPRItems.registerItem(
        "bullet_pistol_acid",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_PISTOL_ELECTRIC = AVPRItems.registerItem(
        "bullet_pistol_electric",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_PISTOL_EXPLOSIVE = AVPRItems.registerItem(
        "bullet_pistol_explosive",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_PISTOL_INCENDIARY = AVPRItems.registerItem(
        "bullet_pistol_incendiary",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_PISTOL_PENETRATION = AVPRItems.registerItem(
        "bullet_pistol_penetration",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_RIFLE = AVPRItems.registerItem(
        "bullet_rifle",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_RIFLE_ACID = AVPRItems.registerItem(
        "bullet_rifle_acid",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_RIFLE_ELECTRIC = AVPRItems.registerItem(
        "bullet_rifle_electric",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_RIFLE_EXPLOSIVE = AVPRItems.registerItem(
        "bullet_rifle_explosive",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_RIFLE_INCENDIARY = AVPRItems.registerItem(
        "bullet_rifle_incendiary",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_RIFLE_PENETRATION = AVPRItems.registerItem(
        "bullet_rifle_penetration",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_SHOTGUN = AVPRItems.registerItem(
        "bullet_shotgun",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_SHOTGUN_ACID = AVPRItems.registerItem(
        "bullet_shotgun_acid",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_SHOTGUN_ELECTRIC = AVPRItems.registerItem(
        "bullet_shotgun_electric",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_SHOTGUN_EXPLOSIVE = AVPRItems.registerItem(
        "bullet_shotgun_explosive",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_SHOTGUN_INCENDIARY = AVPRItems.registerItem(
        "bullet_shotgun_incendiary",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> BULLET_SHOTGUN_PENETRATION = AVPRItems.registerItem(
        "bullet_shotgun_penetration",
        () -> new Item(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_GRENADE_INCENDIARY = AVPRItems.registerItem(
        "grenade_incendiary",
        () -> new GrenadeItem(new Item.Properties(), true)
    );

    public static final Supplier<Item> WEAPON_GRENADE_M40 = AVPRItems.registerItem(
        "grenade_m40",
        () -> new GrenadeItem(new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_FLAMETHROWER_SEVASTOPOL = AVPRItems.registerItem(
        "weapon_flamethrower_sevastopol",
        () -> new BaseGunItem("weapon_flamethrower_sevastopol", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_M88MOD4_COMBAT_PISTOL = AVPRItems.registerItem(
        "weapon_m88mod4_combat_pistol",
        () -> new BaseGunItem("weapon_m88mod4_combat_pistol", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_37_12_SHOTGUN = AVPRItems.registerItem(
        "weapon_37_12_shotgun",
        () -> new BaseGunItem("weapon_37_12_shotgun", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_AK_47 = AVPRItems.registerItem(
        "weapon_ak_47",
        () -> new BaseGunItem("weapon_ak_47", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_F90_RIFLE = AVPRItems.registerItem(
        "weapon_f90_rifle",
        () -> new BaseGunItem("weapon_f90_rifle", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_M4_CARBINE = AVPRItems.registerItem(
        "weapon_m4_carbine",
        () -> new BaseGunItem("weapon_m4_carbine", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_M41A_PULSE_RIFLE = AVPRItems.registerItem(
        "weapon_m41a_pulse_rifle",
        () -> new BaseGunItem("weapon_m41a_pulse_rifle", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_SNIPER_RIFLE = AVPRItems.registerItem(
        "weapon_sniper_rifle",
        () -> new BaseGunItem("weapon_sniper_rifle", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_M56_SMARTGUN = AVPRItems.registerItem(
        "weapon_m56_smartgun",
        () -> new BaseGunItem("weapon_m56_smartgun", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_M83A2_SADAR = AVPRItems.registerItem(
        "weapon_m83a2_sadar",
        () -> new BaseGunItem("weapon_m83a2_sadar", new Item.Properties())
    );

    public static final Supplier<Item> WEAPON_OLD_PAINLESS = AVPRItems.registerItem(
        "weapon_old_painless",
        () -> new BaseGunItem("weapon_old_painless", new Item.Properties())
    );

    private static final Map<Holder<ArmorMaterial>, ArmorProperties> ARMOR_PROPERTIES = Map.of(
        AVPRArmorMaterials.ALUMINUM,
        new ArmorProperties("aluminum", 14),
        AVPRArmorMaterials.MK50,
        new ArmorProperties("mk50", 24),
        AVPRArmorMaterials.ORIONITE,
        new ArmorProperties("orionite", 35),
        AVPRArmorMaterials.PRESSURE,
        new ArmorProperties("pressure", 22),
        AVPRArmorMaterials.TACTICAL,
        new ArmorProperties("tactical", 26),
        AVPRArmorMaterials.TITANIUM,
        new ArmorProperties("titanium", 24),
        AVPRArmorMaterials.VERITANIUM,
        new ArmorProperties("veritanium", 34),
        AVPRArmorMaterials.XENOMORPH_CHITIN,
        new ArmorProperties("xenomorph_chitin", 30)
    );

    private static final Map<Holder<ArmorMaterial>, EnumMap<ArmorItem.Type, Item>> ARMOR_ITEMS = new HashMap<>();

    public static void registerArmorSets() {
        ARMOR_PROPERTIES.forEach((armorMaterialHolder, properties) -> {
            EnumMap<ArmorItem.Type, Item> items = new EnumMap<>(ArmorItem.Type.class);

            Supplier<Item> helmetSupplier = AVPRItems.registerItem(
                "armor_" + properties.materialName().toLowerCase(Locale.ROOT) + "_helmet",
                () -> new AVPRArmorItem(
                    armorMaterialHolder,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(properties.durabilityFactor()))
                )
            );
            items.put(ArmorItem.Type.HELMET, helmetSupplier.get());

            Supplier<Item> chestplateSupplier = AVPRItems.registerItem(
                "armor_" + properties.materialName().toLowerCase(Locale.ROOT) + "_body",
                () -> new AVPRArmorItem(
                    armorMaterialHolder,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(properties.durabilityFactor()))
                )
            );
            items.put(ArmorItem.Type.CHESTPLATE, chestplateSupplier.get());

            Supplier<Item> leggingsSupplier = AVPRItems.registerItem(
                "armor_" + properties.materialName().toLowerCase(Locale.ROOT) + "_leggings",
                () -> new AVPRArmorItem(
                    armorMaterialHolder,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(properties.durabilityFactor()))
                )
            );
            items.put(ArmorItem.Type.LEGGINGS, leggingsSupplier.get());

            Supplier<Item> bootsSupplier = AVPRItems.registerItem(
                "armor_" + properties.materialName().toLowerCase(Locale.ROOT) + "_boots",
                () -> new AVPRArmorItem(
                    armorMaterialHolder,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(properties.durabilityFactor()))
                )
            );
            items.put(ArmorItem.Type.BOOTS, bootsSupplier.get());

            ARMOR_ITEMS.put(armorMaterialHolder, items);
        });
    }

    public static Item getArmorItem(Holder<ArmorMaterial> armorMaterialHolder, ArmorItem.Type type) {
        EnumMap<ArmorItem.Type, Item> items = ARMOR_ITEMS.get(armorMaterialHolder);
        return items != null ? items.get(type) : null;
    }

    public static List<Item> getAllArmorItems() {
        return ARMOR_ITEMS.values()
            .stream()
            .flatMap(enumMap -> enumMap.values().stream())
            .filter(Objects::nonNull)
            .toList();
    }

    /**
     * Example of using this Interface to create a new Item:
     * <p>
     * The following code demonstrates how to register a new item and a spawn egg in the game:
     * </p>
     *
     * <pre>{@code
     *
     * public static final Supplier<Item> TEST_ITEM = AVPRItems.registerItem("itemname", () -> new Item(new Item.Properties()));
     *
     * public static final Supplier<SpawnEggItem> TEST_SPAWN_EGG = AVPRItems.registerItem(
     *     "entityname_spawn_egg",
     *     AVPRServices.COMMON_REGISTRY.makeSpawnEggFor(TESTENTITY, 0x1F1F1F, 0x0D0D0D, new Item.Properties())
     * );
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerItem</code> is a method to register a new item with the specified item name.</li>
     * <li><code>Item</code> is used to create a new item instance with default properties.</li>
     * <li><code>makeSpawnEggFor</code> is a method to create a spawn egg for the specified entity with primary and
     * secondary colors.</li>
     * </ul>
     * <p>
     * The {@link Item Item} class represents an item in the game.
     * </p>
     * <p>
     * The {@link net.minecraft.world.item.SpawnEggItem SpawnEggItem} class represents a spawn egg in the game.
     * </p>
     * Registers a new Item.
     *
     * @param itemName The name of the item.
     * @param item     A supplier for the item.
     * @param <T>      The type of the item.
     * @return A supplier for the registered item.
     */
    static <T extends Item> Supplier<T> registerItem(String itemName, Supplier<T> item) {
        return AVPRServices.COMMON_REGISTRY.registerItem(CommonMod.MOD_ID, itemName, item);
    }

    public static void initialize() {
        AVPRItems.registerArmorSets();
    }
}
