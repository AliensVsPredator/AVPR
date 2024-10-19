package org.avpr.common.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.*;
import java.util.function.Supplier;

import org.avpr.common.CommonMod;
import org.avpr.common.api.common.blocks.*;
import org.avpr.common.blocks.AVPRStairBlock;
import org.avpr.common.blocks.ColoredTransparentBlock;
import org.avpr.common.blocks.ResinVeinBlock;
import org.avpr.common.blocks.ResinWebbingBlock;
import org.avpr.common.platform.AVPRServices;

public record AVPRBlocks() {

    public static final Supplier<Block> RESIN_BLOCK = AVPRBlocks.registerBlock(
        "resin",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(
                Blocks.STONE
            )
                .mapColor(MapColor.COLOR_GRAY)
                .noOcclusion()
        )
    );

    public static final Supplier<ResinVeinBlock> RESIN_VEIN_BLOCK = AVPRBlocks.registerBlock(
        "resin_vein",
        () -> new ResinVeinBlock(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_GRAY)
                .replaceable()
                .noCollission()
                .randomTicks()
                .strength(0.2F)
                .sound(SoundType.VINE)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)
        )
    );

    public static final Supplier<ResinWebbingBlock> RESIN_WEBBING_BLOCK = AVPRBlocks.registerBlock(
        "resin_webbing",
        ResinWebbingBlock::new
    );

    public static final Supplier<Block> ORIONITE_BLOCK = AVPRBlocks.registerBlock(
        "orionite_block",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_HAZARD = AVPRBlocks.registerBlock(
        "industrial_wall_hazard",
        () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK))
    );

    public static final Supplier<Block> SOLAR_PANEL = AVPRBlocks.registerBlock(
        "solar_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> UNIDENTIFIED_DIRT = AVPRBlocks.registerBlock(
        "unidentified_dirt",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> UNIDENTIFIED_GRAVEL = AVPRBlocks.registerBlock(
        "unidentified_gravel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> UNIDENTIFIED_ROCK = AVPRBlocks.registerBlock(
        "unidentified_rock",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> UNIDENTIFIED_SAND = AVPRBlocks.registerBlock(
        "unidentified_sand",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> UNIDENTIFIED_STONE = AVPRBlocks.registerBlock(
        "unidentified_stone",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_BRICK = AVPRBlocks.registerBlock(
        "yautja_ship_brick",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_BRICK_SLAB = AVPRBlocks.registerBlock(
        "yautja_ship_brick_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_BRICK_STAIRS = AVPRBlocks.registerBlock(
        "yautja_ship_brick_stairs",
        () -> new AVPRStairBlock(
            YAUTJA_SHIP_BRICK.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_BRICK_WALL = AVPRBlocks.registerBlock(
        "yautja_ship_brick_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .mapColor(MapColor.COLOR_GRAY)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_1 = AVPRBlocks.registerBlock(
        "yautja_ship_decor_1",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_2 = AVPRBlocks.registerBlock(
        "yautja_ship_decor_2",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
                .lightLevel($0 -> 10)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_3 = AVPRBlocks.registerBlock(
        "yautja_ship_decor_3",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
                .lightLevel(lightLevel -> 8)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_3_SLAB = AVPRBlocks.registerBlock(
        "yautja_ship_decor_3_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
                .lightLevel(lightLevel -> 8)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_3_STAIRS = AVPRBlocks.registerBlock(
        "yautja_ship_decor_3_stairs",
        () -> new AVPRStairBlock(
            YAUTJA_SHIP_DECOR_3.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
                .lightLevel(lightLevel -> 8)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_3_WALL = AVPRBlocks.registerBlock(
        "yautja_ship_decor_3_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
                .lightLevel(lightLevel -> 8)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_PANEL = AVPRBlocks.registerBlock(
        "yautja_ship_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
                .lightLevel(lightLevel -> 6)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_SUPPORT_PILLAR = AVPRBlocks.registerBlock(
        "yautja_ship_support_pillar",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
                .lightLevel(lightLevel -> 8)
        )
    );

    public static final Supplier<Block> YAUTJA_SHIP_WALL_BASE = AVPRBlocks.registerBlock(
        "yautja_ship_wall_base",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .strength(75, 1500)
                .lightLevel(lightLevel -> 4)
        )
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS = AVPRBlocks.registerBlock(
        "industrial_glass",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> TEMPLE_WALL_BASE = AVPRBlocks.registerBlock(
        "temple_wall_base",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(3, 6))
    );

    public static final Supplier<Block> TEMPLE_BRICK_CHESTBURSTER = AVPRBlocks.registerBlock(
        "temple_brick_chestburster",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK_FACEHUGGER = AVPRBlocks.registerBlock(
        "temple_brick_facehugger",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_SKULL = AVPRBlocks.registerBlock(
        "temple_skulls",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK = AVPRBlocks.registerBlock(
        "temple_brick",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK_SLAB = AVPRBlocks.registerBlock(
        "temple_brick_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK_STAIRS = AVPRBlocks.registerBlock(
        "temple_brick_stairs",
        () -> new AVPRStairBlock(TEMPLE_WALL_BASE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK_WALL = AVPRBlocks.registerBlock(
        "temple_brick_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK_SINGLE = AVPRBlocks.registerBlock(
        "temple_brick_single",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK_SINGLE_SLAB = AVPRBlocks.registerBlock(
        "temple_brick_single_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK_SIMPLE_STAIRS = AVPRBlocks.registerBlock(
        "temple_brick_single_stairs",
        () -> new AVPRStairBlock(TEMPLE_WALL_BASE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_BRICK_SIMPLE_WALL = AVPRBlocks.registerBlock(
        "temple_brick_single_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_FLOOR = AVPRBlocks.registerBlock(
        "temple_floor",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_FLOOR_SLAB = AVPRBlocks.registerBlock(
        "temple_floor_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_FLOOR_STAIRS = AVPRBlocks.registerBlock(
        "temple_floor_stairs",
        () -> new AVPRStairBlock(TEMPLE_WALL_BASE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_FLOOR_WALL = AVPRBlocks.registerBlock(
        "temple_floor_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_TILE = AVPRBlocks.registerBlock(
        "temple_tile",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_TILE_SLAB = AVPRBlocks.registerBlock(
        "temple_tile_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_TILE_STAIRS = AVPRBlocks.registerBlock(
        "temple_tile_stairs",
        () -> new AVPRStairBlock(TEMPLE_WALL_BASE.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> TEMPLE_TILE_WALL = AVPRBlocks.registerBlock(
        "temple_tile_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(TEMPLE_WALL_BASE.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK = AVPRBlocks.registerBlock(
        "engineer_ship_brick",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_brick_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_brick_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_BRICK.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_brick_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_1 = AVPRBlocks.registerBlock(
        "engineer_ship_brick_1",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_1_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_brick_1_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_1.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_1_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_brick_1_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_BRICK_1.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_1.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_1_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_brick_1_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_1.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_2 = AVPRBlocks.registerBlock(
        "engineer_ship_brick_2",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_2_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_brick_2_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_2.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_2_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_brick_2_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_BRICK_2.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_2.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_2_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_brick_2_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_2.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_3 = AVPRBlocks.registerBlock(
        "engineer_ship_brick_3",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_3_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_brick_3_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_3.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_3_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_brick_3_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_BRICK_3.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_3.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_BRICK_3_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_brick_3_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_BRICK_3.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_0 = AVPRBlocks.registerBlock(
        "engineer_ship_material_0",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_0_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_material_0_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_0.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_0_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_material_0_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_MATERIAL_0.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_0.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_0_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_material_0_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_0.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_1 = AVPRBlocks.registerBlock(
        "engineer_ship_material_1",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_1_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_material_1_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_1.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_1_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_material_1_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_MATERIAL_1.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_1.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_1_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_material_1_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_1.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_2 = AVPRBlocks.registerBlock(
        "engineer_ship_material_2",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_2_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_material_2_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_2.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_2_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_material_2_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_MATERIAL_2.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_2.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_MATERIAL_2_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_material_2_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_MATERIAL_2.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_wall",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_wall_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_wall_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_WALL.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_wall_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_1 = AVPRBlocks.registerBlock(
        "engineer_ship_wall_1",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_1_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_wall_1_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_1.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_1_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_wall_1_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_WALL_1.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_1.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_1_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_wall_1_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_1.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_2 = AVPRBlocks.registerBlock(
        "engineer_ship_wall_2",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_2_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_wall_2_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_2.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_2_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_wall_2_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_WALL_2.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_2.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_2_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_wall_2_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_2.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_3 = AVPRBlocks.registerBlock(
        "engineer_ship_wall_3",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_3_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_wall_3_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_3.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_3_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_wall_3_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_WALL_3.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_3.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_3_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_wall_3_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_3.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_4 = AVPRBlocks.registerBlock(
        "engineer_ship_wall_4",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_4_SLAB = AVPRBlocks.registerBlock(
        "engineer_ship_wall_4_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_4.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_4_STAIRS = AVPRBlocks.registerBlock(
        "engineer_ship_wall_4_stairs",
        () -> new AVPRStairBlock(
            ENGINEER_SHIP_WALL_4.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_4.get())
        )
    );

    public static final Supplier<Block> ENGINEER_SHIP_WALL_4_WALL = AVPRBlocks.registerBlock(
        "engineer_ship_wall_4_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ENGINEER_SHIP_WALL_4.get()))
    );

    public static final Supplier<Block> ENGINEER_SHIP_COLUMN_1 = AVPRBlocks.registerBlock(
        "engineer_ship_column_1",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_COLUMN_2 = AVPRBlocks.registerBlock(
        "engineer_ship_column_2",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_FLOOR = AVPRBlocks.registerBlock(
        "engineer_ship_floor",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_GRAVEL = AVPRBlocks.registerBlock(
        "engineer_ship_gravel",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_ROCK = AVPRBlocks.registerBlock(
        "engineer_ship_rock",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_ROCK_1 = AVPRBlocks.registerBlock(
        "engineer_ship_rock_1",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_ROCK_2 = AVPRBlocks.registerBlock(
        "engineer_ship_rock_2",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    public static final Supplier<Block> ENGINEER_SHIP_ROCK_3 = AVPRBlocks.registerBlock(
        "engineer_ship_rock_3",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(100, 1800))
    );

    // Start here
    public static final Supplier<Block> INDUSTRIAL_WALL_WHITE = AVPRBlocks.registerBlock(
        "industrial_wall_white",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_WHITE_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_white_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_WHITE_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_white_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_WHITE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_WHITE_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_white_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_ORANGE = AVPRBlocks.registerBlock(
        "industrial_wall_orange",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_ORANGE_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_orange_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_ORANGE_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_orange_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_ORANGE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_ORANGE_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_orange_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_MAGENTA = AVPRBlocks.registerBlock(
        "industrial_wall_magenta",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_MAGENTA_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_magenta_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_MAGENTA_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_magenta_stairs",
        () -> new AVPRStairBlock(
            INDUSTRIAL_WALL_MAGENTA.get().defaultBlockState(),
            BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA)
        )
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_MAGENTA_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_magenta_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIGHT_BLUE = AVPRBlocks.registerBlock(
        "industrial_wall_light_blue",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIGHT_BLUE_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_light_blue_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIGHT_BLUE_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_light_blue_stairs",
        () -> new AVPRStairBlock(
            INDUSTRIAL_WALL_LIGHT_BLUE.get().defaultBlockState(),
            BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE)
        )
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIGHT_BLUE_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_light_blue_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_YELLOW = AVPRBlocks.registerBlock(
        "industrial_wall_yellow",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_YELLOW_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_yellow_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_YELLOW_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_yellow_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_YELLOW.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_YELLOW_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_yellow_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIME = AVPRBlocks.registerBlock(
        "industrial_wall_lime",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIME_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_lime_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIME_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_lime_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_LIME.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIME))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIME_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_lime_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_PINK = AVPRBlocks.registerBlock(
        "industrial_wall_pink",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_PINK_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_pink_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_PINK_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_pink_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_PINK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.PINK))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_PINK_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_pink_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_GRAY = AVPRBlocks.registerBlock(
        "industrial_wall_gray",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_GRAY_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_gray_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_GRAY_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_gray_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_GRAY.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_GRAY_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_gray_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIGHT_GRAY = AVPRBlocks.registerBlock(
        "industrial_wall_light_gray",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIGHT_GRAY_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_light_gray_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIGHT_GRAY_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_light_gray_stairs",
        () -> new AVPRStairBlock(
            INDUSTRIAL_WALL_LIGHT_GRAY.get().defaultBlockState(),
            BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY)
        )
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_LIGHT_GRAY_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_light_gray_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_CYAN = AVPRBlocks.registerBlock(
        "industrial_wall_cyan",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_CYAN_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_cyan_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_CYAN_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_cyan_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_CYAN.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_CYAN_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_cyan_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_PURPLE = AVPRBlocks.registerBlock(
        "industrial_wall_purple",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_PURPLE_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_purple_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_PURPLE_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_purple_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_PURPLE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_PURPLE_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_purple_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BLUE = AVPRBlocks.registerBlock(
        "industrial_wall_blue",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BLUE_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_blue_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BLUE_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_blue_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_BLUE.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BLUE_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_blue_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BROWN = AVPRBlocks.registerBlock(
        "industrial_wall_brown",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BROWN_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_brown_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BROWN_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_brown_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_BROWN.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BROWN_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_brown_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_GREEN = AVPRBlocks.registerBlock(
        "industrial_wall_green",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_GREEN_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_green_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_GREEN_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_green_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_GREEN.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_GREEN_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_green_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_RED = AVPRBlocks.registerBlock(
        "industrial_wall_red",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_RED_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_red_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_RED_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_red_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_RED.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.RED))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_RED_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_red_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BLACK = AVPRBlocks.registerBlock(
        "industrial_wall_black",
        () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BLACK_SLAB = AVPRBlocks.registerBlock(
        "industrial_wall_black_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BLACK_STAIRS = AVPRBlocks.registerBlock(
        "industrial_wall_black_stairs",
        () -> new AVPRStairBlock(INDUSTRIAL_WALL_BLACK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK))
    );

    public static final Supplier<Block> INDUSTRIAL_WALL_BLACK_WALL = AVPRBlocks.registerBlock(
        "industrial_wall_black_wall",
        () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK))
    );

    public static final Supplier<Block> PLASTIC_WHITE = AVPRBlocks.registerBlock(
        "plastic_white",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.WHITE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_WHITE_SLAB = AVPRBlocks.registerBlock(
        "plastic_white_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.WHITE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_WHITE_STAIRS = AVPRBlocks.registerBlock(
        "plastic_white_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_WHITE.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.WHITE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_WHITE_WALL = AVPRBlocks.registerBlock(
        "plastic_white_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.WHITE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_ORANGE = AVPRBlocks.registerBlock(
        "plastic_orange",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.ORANGE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_ORANGE_SLAB = AVPRBlocks.registerBlock(
        "plastic_orange_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.ORANGE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_ORANGE_STAIRS = AVPRBlocks.registerBlock(
        "plastic_orange_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_ORANGE.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.ORANGE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_ORANGE_WALL = AVPRBlocks.registerBlock(
        "plastic_orange_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.ORANGE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_MAGENTA = AVPRBlocks.registerBlock(
        "plastic_magenta",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.MAGENTA)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_MAGENTA_SLAB = AVPRBlocks.registerBlock(
        "plastic_magenta_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.MAGENTA)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_MAGENTA_STAIRS = AVPRBlocks.registerBlock(
        "plastic_magenta_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_MAGENTA.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.MAGENTA)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_MAGENTA_WALL = AVPRBlocks.registerBlock(
        "plastic_magenta_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.MAGENTA)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIGHT_BLUE = AVPRBlocks.registerBlock(
        "plastic_light_blue",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIGHT_BLUE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIGHT_BLUE_SLAB = AVPRBlocks.registerBlock(
        "plastic_light_blue_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIGHT_BLUE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIGHT_BLUE_STAIRS = AVPRBlocks.registerBlock(
        "plastic_light_blue_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_LIGHT_BLUE.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIGHT_BLUE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIGHT_BLUE_WALL = AVPRBlocks.registerBlock(
        "plastic_light_blue_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIGHT_BLUE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_YELLOW = AVPRBlocks.registerBlock(
        "plastic_yellow",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.YELLOW)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_YELLOW_SLAB = AVPRBlocks.registerBlock(
        "plastic_yellow_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.YELLOW)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_YELLOW_STAIRS = AVPRBlocks.registerBlock(
        "plastic_yellow_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_YELLOW.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.YELLOW)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_YELLOW_WALL = AVPRBlocks.registerBlock(
        "plastic_yellow_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.YELLOW)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIME = AVPRBlocks.registerBlock(
        "plastic_lime",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIME)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIME_SLAB = AVPRBlocks.registerBlock(
        "plastic_lime_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIME)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIME_STAIRS = AVPRBlocks.registerBlock(
        "plastic_lime_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_LIME.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIME)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIME_WALL = AVPRBlocks.registerBlock(
        "plastic_lime_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIME)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_PINK = AVPRBlocks.registerBlock(
        "plastic_pink",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.PINK)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_PINK_SLAB = AVPRBlocks.registerBlock(
        "plastic_pink_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.PINK)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_PINK_STAIRS = AVPRBlocks.registerBlock(
        "plastic_pink_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_PINK.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.PINK)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_PINK_WALL = AVPRBlocks.registerBlock(
        "plastic_pink_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.PINK)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_GRAY = AVPRBlocks.registerBlock(
        "plastic_gray",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_GRAY_SLAB = AVPRBlocks.registerBlock(
        "plastic_gray_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_GRAY_STAIRS = AVPRBlocks.registerBlock(
        "plastic_gray_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_GRAY.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_GRAY_WALL = AVPRBlocks.registerBlock(
        "plastic_gray_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIGHT_GRAY = AVPRBlocks.registerBlock(
        "plastic_light_gray",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIGHT_GRAY_SLAB = AVPRBlocks.registerBlock(
        "plastic_light_gray_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIGHT_GRAY_STAIRS = AVPRBlocks.registerBlock(
        "plastic_light_gray_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_LIGHT_GRAY.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_LIGHT_GRAY_WALL = AVPRBlocks.registerBlock(
        "plastic_light_gray_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_CYAN = AVPRBlocks.registerBlock(
        "plastic_cyan",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.CYAN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_CYAN_SLAB = AVPRBlocks.registerBlock(
        "plastic_cyan_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.CYAN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_CYAN_STAIRS = AVPRBlocks.registerBlock(
        "plastic_cyan_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_CYAN.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.CYAN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_CYAN_WALL = AVPRBlocks.registerBlock(
        "plastic_cyan_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.CYAN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_PURPLE = AVPRBlocks.registerBlock(
        "plastic_purple",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.PURPLE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_PURPLE_SLAB = AVPRBlocks.registerBlock(
        "plastic_purple_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.PURPLE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_PURPLE_STAIRS = AVPRBlocks.registerBlock(
        "plastic_purple_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_PURPLE.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.PURPLE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_PURPLE_WALL = AVPRBlocks.registerBlock(
        "plastic_purple_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.PURPLE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BLUE = AVPRBlocks.registerBlock(
        "plastic_blue",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BLUE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BLUE_SLAB = AVPRBlocks.registerBlock(
        "plastic_blue_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BLUE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BLUE_STAIRS = AVPRBlocks.registerBlock(
        "plastic_blue_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_BLUE.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BLUE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BLUE_WALL = AVPRBlocks.registerBlock(
        "plastic_blue_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BLUE)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BROWN = AVPRBlocks.registerBlock(
        "plastic_brown",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BROWN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BROWN_SLAB = AVPRBlocks.registerBlock(
        "plastic_brown_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BROWN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BROWN_STAIRS = AVPRBlocks.registerBlock(
        "plastic_brown_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_BROWN.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BROWN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BROWN_WALL = AVPRBlocks.registerBlock(
        "plastic_brown_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BROWN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_GREEN = AVPRBlocks.registerBlock(
        "plastic_green",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.GREEN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_GREEN_SLAB = AVPRBlocks.registerBlock(
        "plastic_green_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.GREEN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_GREEN_STAIRS = AVPRBlocks.registerBlock(
        "plastic_green_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_GREEN.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.GREEN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_GREEN_WALL = AVPRBlocks.registerBlock(
        "plastic_green_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.GREEN)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_RED = AVPRBlocks.registerBlock(
        "plastic_red",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.RED)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_RED_SLAB = AVPRBlocks.registerBlock(
        "plastic_red_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.RED)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_RED_STAIRS = AVPRBlocks.registerBlock(
        "plastic_red_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_RED.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.RED)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_RED_WALL = AVPRBlocks.registerBlock(
        "plastic_red_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.RED)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BLACK = AVPRBlocks.registerBlock(
        "plastic_black",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BLACK)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BLACK_SLAB = AVPRBlocks.registerBlock(
        "plastic_black_slab",
        () -> new SlabBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BLACK)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BLACK_STAIRS = AVPRBlocks.registerBlock(
        "plastic_black_stairs",
        () -> new AVPRStairBlock(
            PLASTIC_BLACK.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BLACK)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PLASTIC_BLACK_WALL = AVPRBlocks.registerBlock(
        "plastic_black_wall",
        () -> new WallBlock(
            BlockBehaviour.Properties.of()
                .mapColor(DyeColor.BLACK)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE)
                .noOcclusion()
                .strength(9, 10)
        )
    );

    public static final Supplier<Block> PADDING_WHITE_PANEL = AVPRBlocks.registerBlock(
        "padding_white_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.WHITE)
        )
    );

    public static final Supplier<Block> PADDING_WHITE_PIPES = AVPRBlocks.registerBlock(
        "padding_white_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.WHITE)
        )
    );

    public static final Supplier<Block> PADDING_WHITE_SQUARE = AVPRBlocks.registerBlock(
        "padding_white_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.WHITE)
        )
    );

    public static final Supplier<Block> PADDING_WHITE_TILES = AVPRBlocks.registerBlock(
        "padding_white_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.WHITE)
        )
    );

    public static final Supplier<Block> PADDING_ORANGE_PANEL = AVPRBlocks.registerBlock(
        "padding_orange_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.ORANGE)
        )
    );

    public static final Supplier<Block> PADDING_ORANGE_PIPES = AVPRBlocks.registerBlock(
        "padding_orange_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.ORANGE)
        )
    );

    public static final Supplier<Block> PADDING_ORANGE_SQUARE = AVPRBlocks.registerBlock(
        "padding_orange_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.ORANGE)
        )
    );

    public static final Supplier<Block> PADDING_ORANGE_TILES = AVPRBlocks.registerBlock(
        "padding_orange_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.ORANGE)
        )
    );

    public static final Supplier<Block> PADDING_MAGENTA_PANEL = AVPRBlocks.registerBlock(
        "padding_magenta_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.MAGENTA)
        )
    );

    public static final Supplier<Block> PADDING_MAGENTA_PIPES = AVPRBlocks.registerBlock(
        "padding_magenta_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.MAGENTA)
        )
    );

    public static final Supplier<Block> PADDING_MAGENTA_SQUARE = AVPRBlocks.registerBlock(
        "padding_magenta_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.MAGENTA)
        )
    );

    public static final Supplier<Block> PADDING_MAGENTA_TILES = AVPRBlocks.registerBlock(
        "padding_magenta_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.MAGENTA)
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_PANEL = AVPRBlocks.registerBlock(
        "padding_light_blue_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIGHT_BLUE)
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_PIPES = AVPRBlocks.registerBlock(
        "padding_light_blue_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIGHT_BLUE)
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_SQUARE = AVPRBlocks.registerBlock(
        "padding_light_blue_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIGHT_BLUE)
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_TILES = AVPRBlocks.registerBlock(
        "padding_light_blue_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIGHT_BLUE)
        )
    );

    public static final Supplier<Block> PADDING_YELLOW_PANEL = AVPRBlocks.registerBlock(
        "padding_yellow_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.YELLOW)
        )
    );

    public static final Supplier<Block> PADDING_YELLOW_PIPES = AVPRBlocks.registerBlock(
        "padding_yellow_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.YELLOW)
        )
    );

    public static final Supplier<Block> PADDING_YELLOW_SQUARE = AVPRBlocks.registerBlock(
        "padding_yellow_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.YELLOW)
        )
    );

    public static final Supplier<Block> PADDING_YELLOW_TILES = AVPRBlocks.registerBlock(
        "padding_yellow_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.YELLOW)
        )
    );

    public static final Supplier<Block> PADDING_LIME_PANEL = AVPRBlocks.registerBlock(
        "padding_lime_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIME)
        )
    );

    public static final Supplier<Block> PADDING_LIME_PIPES = AVPRBlocks.registerBlock(
        "padding_lime_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIME)
        )
    );

    public static final Supplier<Block> PADDING_LIME_SQUARE = AVPRBlocks.registerBlock(
        "padding_lime_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIME)
        )
    );

    public static final Supplier<Block> PADDING_LIME_TILES = AVPRBlocks.registerBlock(
        "padding_lime_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIME)
        )
    );

    public static final Supplier<Block> PADDING_PINK_PANEL = AVPRBlocks.registerBlock(
        "padding_pink_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.PINK)
        )
    );

    public static final Supplier<Block> PADDING_PINK_PIPES = AVPRBlocks.registerBlock(
        "padding_pink_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.PINK)
        )
    );

    public static final Supplier<Block> PADDING_PINK_SQUARE = AVPRBlocks.registerBlock(
        "padding_pink_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.PINK)
        )
    );

    public static final Supplier<Block> PADDING_PINK_TILES = AVPRBlocks.registerBlock(
        "padding_pink_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.PINK)
        )
    );

    public static final Supplier<Block> PADDING_GRAY_PANEL = AVPRBlocks.registerBlock(
        "padding_gray_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.GRAY)
        )
    );

    public static final Supplier<Block> PADDING_GRAY_PIPES = AVPRBlocks.registerBlock(
        "padding_gray_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.GRAY)
        )
    );

    public static final Supplier<Block> PADDING_GRAY_SQUARE = AVPRBlocks.registerBlock(
        "padding_gray_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.GRAY)
        )
    );

    public static final Supplier<Block> PADDING_GRAY_TILES = AVPRBlocks.registerBlock(
        "padding_gray_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.GRAY)
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_PANEL = AVPRBlocks.registerBlock(
        "padding_light_gray_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIGHT_GRAY)
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_PIPES = AVPRBlocks.registerBlock(
        "padding_light_gray_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIGHT_GRAY)
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_SQUARE = AVPRBlocks.registerBlock(
        "padding_light_gray_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIGHT_GRAY)
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_TILES = AVPRBlocks.registerBlock(
        "padding_light_gray_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.LIGHT_GRAY)
        )
    );

    public static final Supplier<Block> PADDING_CYAN_PANEL = AVPRBlocks.registerBlock(
        "padding_cyan_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.CYAN)
        )
    );

    public static final Supplier<Block> PADDING_CYAN_PIPES = AVPRBlocks.registerBlock(
        "padding_cyan_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.CYAN)
        )
    );

    public static final Supplier<Block> PADDING_CYAN_SQUARE = AVPRBlocks.registerBlock(
        "padding_cyan_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.CYAN)
        )
    );

    public static final Supplier<Block> PADDING_CYAN_TILES = AVPRBlocks.registerBlock(
        "padding_cyan_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.CYAN)
        )
    );

    public static final Supplier<Block> PADDING_PURPLE_PANEL = AVPRBlocks.registerBlock(
        "padding_purple_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.PURPLE)
        )
    );

    public static final Supplier<Block> PADDING_PURPLE_PIPES = AVPRBlocks.registerBlock(
        "padding_purple_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.PURPLE)
        )
    );

    public static final Supplier<Block> PADDING_PURPLE_SQUARE = AVPRBlocks.registerBlock(
        "padding_purple_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.PURPLE)
        )
    );

    public static final Supplier<Block> PADDING_PURPLE_TILES = AVPRBlocks.registerBlock(
        "padding_purple_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.PURPLE)
        )
    );

    public static final Supplier<Block> PADDING_BLUE_PANEL = AVPRBlocks.registerBlock(
        "padding_blue_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BLUE)
        )
    );

    public static final Supplier<Block> PADDING_BLUE_PIPES = AVPRBlocks.registerBlock(
        "padding_blue_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BLUE)
        )
    );

    public static final Supplier<Block> PADDING_BLUE_SQUARE = AVPRBlocks.registerBlock(
        "padding_blue_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BLUE)
        )
    );

    public static final Supplier<Block> PADDING_BLUE_TILES = AVPRBlocks.registerBlock(
        "padding_blue_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BLUE)
        )
    );

    public static final Supplier<Block> PADDING_BROWN_PANEL = AVPRBlocks.registerBlock(
        "padding_brown_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BROWN)
        )
    );

    public static final Supplier<Block> PADDING_BROWN_PIPES = AVPRBlocks.registerBlock(
        "padding_brown_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BROWN)
        )
    );

    public static final Supplier<Block> PADDING_BROWN_SQUARE = AVPRBlocks.registerBlock(
        "padding_brown_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BROWN)
        )
    );

    public static final Supplier<Block> PADDING_BROWN_TILES = AVPRBlocks.registerBlock(
        "padding_brown_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BROWN)
        )
    );

    public static final Supplier<Block> PADDING_GREEN_PANEL = AVPRBlocks.registerBlock(
        "padding_green_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.GREEN)
        )
    );

    public static final Supplier<Block> PADDING_GREEN_PIPES = AVPRBlocks.registerBlock(
        "padding_green_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.GREEN)
        )
    );

    public static final Supplier<Block> PADDING_GREEN_SQUARE = AVPRBlocks.registerBlock(
        "padding_green_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.GREEN)
        )
    );

    public static final Supplier<Block> PADDING_GREEN_TILES = AVPRBlocks.registerBlock(
        "padding_green_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.GREEN)
        )
    );

    public static final Supplier<Block> PADDING_RED_PANEL = AVPRBlocks.registerBlock(
        "padding_red_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.RED)
        )
    );

    public static final Supplier<Block> PADDING_RED_PIPES = AVPRBlocks.registerBlock(
        "padding_red_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.RED)
        )
    );

    public static final Supplier<Block> PADDING_RED_SQUARE = AVPRBlocks.registerBlock(
        "padding_red_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.RED)
        )
    );

    public static final Supplier<Block> PADDING_RED_TILES = AVPRBlocks.registerBlock(
        "padding_red_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.RED)
        )
    );

    public static final Supplier<Block> PADDING_BLACK_PANEL = AVPRBlocks.registerBlock(
        "padding_black_panel",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BLACK)
        )
    );

    public static final Supplier<Block> PADDING_BLACK_PIPES = AVPRBlocks.registerBlock(
        "padding_black_pipes",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BLACK)
        )
    );

    public static final Supplier<Block> PADDING_BLACK_SQUARE = AVPRBlocks.registerBlock(
        "padding_black_square",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BLACK)
        )
    );

    public static final Supplier<Block> PADDING_BLACK_TILES = AVPRBlocks.registerBlock(
        "padding_black_tiles",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                .mapColor(DyeColor.BLACK)
        )
    );

    public static final Supplier<Block> aluminum_block = AVPRBlocks.registerBlock(
        "aluminum_block",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> aluminum_grate = AVPRBlocks.registerBlock(
        "aluminum_grate",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> aluminum_vent = AVPRBlocks.registerBlock(
        "aluminum_vent",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> aluminum_panel = AVPRBlocks.registerBlock(
        "aluminum_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> aluminum_plated = AVPRBlocks.registerBlock(
        "aluminum_plated",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> aluminum_plated_chevron = AVPRBlocks.registerBlock(
        "aluminum_plated_chevron",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> aluminum_cut = AVPRBlocks.registerBlock(
        "aluminum_cut",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> copper_grate = AVPRBlocks.registerBlock(
        "copper_grate",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> copper_vent = AVPRBlocks.registerBlock(
        "copper_vent",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> copper_panel = AVPRBlocks.registerBlock(
        "copper_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> copper_plated = AVPRBlocks.registerBlock(
        "copper_plated",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> copper_plated_chevron = AVPRBlocks.registerBlock(
        "copper_plated_chevron",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> ferroaluminum_block = AVPRBlocks.registerBlock(
        "ferroaluminum_block",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> ferroaluminum_grate = AVPRBlocks.registerBlock(
        "ferroaluminum_grate",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> ferroaluminum_vent = AVPRBlocks.registerBlock(
        "ferroaluminum_vent",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> ferroaluminum_panel = AVPRBlocks.registerBlock(
        "ferroaluminum_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> ferroaluminum_plated = AVPRBlocks.registerBlock(
        "ferroaluminum_plated",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> ferroaluminum_plated_chevron = AVPRBlocks.registerBlock(
        "ferroaluminum_plated_chevron",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> ferroaluminum_cut = AVPRBlocks.registerBlock(
        "ferroaluminum_cut",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> gold_grate = AVPRBlocks.registerBlock(
        "gold_grate",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> gold_vent = AVPRBlocks.registerBlock(
        "gold_vent",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> gold_panel = AVPRBlocks.registerBlock(
        "gold_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> gold_plated = AVPRBlocks.registerBlock(
        "gold_plated",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> gold_plated_chevron = AVPRBlocks.registerBlock(
        "gold_plated_chevron",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> iron_grate = AVPRBlocks.registerBlock(
        "iron_grate",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> iron_vent = AVPRBlocks.registerBlock(
        "iron_vent",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> iron_panel = AVPRBlocks.registerBlock(
        "iron_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> iron_plated = AVPRBlocks.registerBlock(
        "iron_plated",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> iron_plated_chevron = AVPRBlocks.registerBlock(
        "iron_plated_chevron",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> netherite_grate = AVPRBlocks.registerBlock(
        "netherite_grate",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> netherite_vent = AVPRBlocks.registerBlock(
        "netherite_vent",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> netherite_panel = AVPRBlocks.registerBlock(
        "netherite_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> netherite_plated = AVPRBlocks.registerBlock(
        "netherite_plated",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> netherite_plated_chevron = AVPRBlocks.registerBlock(
        "netherite_plated_chevron",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> steel_block = AVPRBlocks.registerBlock(
        "steel_block",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> steel_grate = AVPRBlocks.registerBlock(
        "steel_grate",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> steel_vent = AVPRBlocks.registerBlock(
        "steel_vent",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> steel_panel = AVPRBlocks.registerBlock(
        "steel_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> steel_plated = AVPRBlocks.registerBlock(
        "steel_plated",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> steel_plated_chevron = AVPRBlocks.registerBlock(
        "steel_plated_chevron",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> steel_cut = AVPRBlocks.registerBlock(
        "steel_cut",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> titanium_block = AVPRBlocks.registerBlock(
        "titanium_block",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> titanium_grate = AVPRBlocks.registerBlock(
        "titanium_grate",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> titanium_vent = AVPRBlocks.registerBlock(
        "titanium_vent",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> titanium_panel = AVPRBlocks.registerBlock(
        "titanium_panel",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> titanium_plated = AVPRBlocks.registerBlock(
        "titanium_plated",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> titanium_plated_chevron = AVPRBlocks.registerBlock(
        "titanium_plated_chevron",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> titanium_cut = AVPRBlocks.registerBlock(
        "titanium_cut",
        () -> new Block(
            BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .requiresCorrectToolForDrops()
                .sound(SoundType.COPPER)
                .noOcclusion()
                .strength(4, 6)
        )
    );

    public static final Supplier<Block> ALUMINUM_CUT_SLAB = AVPRBlocks.registerBlock(
        "aluminum_cut_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> ALUMINUM_CUT_STAIRS = AVPRBlocks.registerBlock(
        "aluminum_cut_stairs",
        () -> new AVPRStairBlock(aluminum_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> ALUMINUM_CUT_WALL = AVPRBlocks.registerBlock(
        "aluminum_cut_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> ALUMINUM_PLATED_CHEVRON_SLAB = AVPRBlocks.registerBlock(
        "aluminum_plated_chevron_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> ALUMINUM_PLATED_CHEVRON_STAIRS = AVPRBlocks.registerBlock(
        "aluminum_plated_chevron_stairs",
        () -> new AVPRStairBlock(aluminum_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> ALUMINUM_PLATED_CHEVRON_WALL = AVPRBlocks.registerBlock(
        "aluminum_plated_chevron_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> ALUMINUM_PLATED_SLAB = AVPRBlocks.registerBlock(
        "aluminum_plated_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> ALUMINUM_PLATED_STAIRS = AVPRBlocks.registerBlock(
        "aluminum_plated_stairs",
        () -> new AVPRStairBlock(aluminum_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> ALUMINUM_PLATED_WALL = AVPRBlocks.registerBlock(
        "aluminum_plated_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(aluminum_plated.get()))
    );

    public static final Supplier<Block> COPPER_PLATED_CHEVRON_SLAB = AVPRBlocks.registerBlock(
        "copper_plated_chevron_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(copper_plated.get()))
    );

    public static final Supplier<Block> COPPER_PLATED_CHEVRON_STAIRS = AVPRBlocks.registerBlock(
        "copper_plated_chevron_stairs",
        () -> new AVPRStairBlock(copper_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(copper_plated.get()))
    );

    public static final Supplier<Block> COPPER_PLATED_CHEVRON_WALL = AVPRBlocks.registerBlock(
        "copper_plated_chevron_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(copper_plated.get()))
    );

    public static final Supplier<Block> COPPER_PLATED_SLAB = AVPRBlocks.registerBlock(
        "copper_plated_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(copper_plated.get()))
    );

    public static final Supplier<Block> COPPER_PLATED_STAIRS = AVPRBlocks.registerBlock(
        "copper_plated_stairs",
        () -> new AVPRStairBlock(copper_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(copper_plated.get()))
    );

    public static final Supplier<Block> COPPER_PLATED_WALL = AVPRBlocks.registerBlock(
        "copper_plated_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(copper_plated.get()))
    );

    public static final Supplier<Block> FERROALUMINUM_CUT_SLAB = AVPRBlocks.registerBlock(
        "ferroaluminum_cut_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get()))
    );

    public static final Supplier<Block> FERROALUMINUM_CUT_STAIRS = AVPRBlocks.registerBlock(
        "ferroaluminum_cut_stairs",
        () -> new AVPRStairBlock(
            ferroaluminum_block.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get())
        )
    );

    public static final Supplier<Block> FERROALUMINUM_CUT_WALL = AVPRBlocks.registerBlock(
        "ferroaluminum_cut_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get()))
    );

    public static final Supplier<Block> FERROALUMINUM_PLATED_CHEVRON_SLAB = AVPRBlocks.registerBlock(
        "ferroaluminum_plated_chevron_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get()))
    );

    public static final Supplier<Block> FERROALUMINUM_PLATED_CHEVRON_STAIRS = AVPRBlocks.registerBlock(
        "ferroaluminum_plated_chevron_stairs",
        () -> new AVPRStairBlock(
            ferroaluminum_block.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get())
        )
    );

    public static final Supplier<Block> FERROALUMINUM_PLATED_CHEVRON_WALL = AVPRBlocks.registerBlock(
        "ferroaluminum_plated_chevron_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get()))
    );

    public static final Supplier<Block> FERROALUMINUM_PLATED_SLAB = AVPRBlocks.registerBlock(
        "ferroaluminum_plated_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get()))
    );

    public static final Supplier<Block> FERROALUMINUM_PLATED_STAIRS = AVPRBlocks.registerBlock(
        "ferroaluminum_plated_stairs",
        () -> new AVPRStairBlock(
            ferroaluminum_block.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get())
        )
    );

    public static final Supplier<Block> FERROALUMINUM_PLATED_WALL = AVPRBlocks.registerBlock(
        "ferroaluminum_plated_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ferroaluminum_block.get()))
    );

    public static final Supplier<Block> GOLD_PLATED_CHEVRON_SLAB = AVPRBlocks.registerBlock(
        "gold_plated_chevron_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(gold_plated.get()))
    );

    public static final Supplier<Block> GOLD_PLATED_CHEVRON_STAIRS = AVPRBlocks.registerBlock(
        "gold_plated_chevron_stairs",
        () -> new AVPRStairBlock(gold_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(gold_plated.get()))
    );

    public static final Supplier<Block> GOLD_PLATED_CHEVRON_WALL = AVPRBlocks.registerBlock(
        "gold_plated_chevron_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(gold_plated.get()))
    );

    public static final Supplier<Block> GOLD_PLATED_SLAB = AVPRBlocks.registerBlock(
        "gold_plated_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(gold_plated.get()))
    );

    public static final Supplier<Block> GOLD_PLATED_STAIRS = AVPRBlocks.registerBlock(
        "gold_plated_stairs",
        () -> new AVPRStairBlock(gold_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(gold_plated.get()))
    );

    public static final Supplier<Block> GOLD_PLATED_WALL = AVPRBlocks.registerBlock(
        "gold_plated_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(gold_plated.get()))
    );

    public static final Supplier<Block> IRON_PLATED_CHEVRON_SLAB = AVPRBlocks.registerBlock(
        "iron_plated_chevron_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(iron_plated.get()))
    );

    public static final Supplier<Block> IRON_PLATED_CHEVRON_STAIRS = AVPRBlocks.registerBlock(
        "iron_plated_chevron_stairs",
        () -> new AVPRStairBlock(iron_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(iron_plated.get()))
    );

    public static final Supplier<Block> IRON_PLATED_CHEVRON_WALL = AVPRBlocks.registerBlock(
        "iron_plated_chevron_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(iron_plated.get()))
    );

    public static final Supplier<Block> IRON_PLATED_SLAB = AVPRBlocks.registerBlock(
        "iron_plated_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(iron_plated.get()))
    );

    public static final Supplier<Block> IRON_PLATED_STAIRS = AVPRBlocks.registerBlock(
        "iron_plated_stairs",
        () -> new AVPRStairBlock(iron_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(iron_plated.get()))
    );

    public static final Supplier<Block> IRON_PLATED_WALL = AVPRBlocks.registerBlock(
        "iron_plated_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(iron_plated.get()))
    );

    public static final Supplier<Block> NETHERITE_PLATED_CHEVRON_SLAB = AVPRBlocks.registerBlock(
        "netherite_plated_chevron_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(netherite_plated.get()))
    );

    public static final Supplier<Block> NETHERITE_PLATED_CHEVRON_STAIRS = AVPRBlocks.registerBlock(
        "netherite_plated_chevron_stairs",
        () -> new AVPRStairBlock(netherite_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(netherite_plated.get()))
    );

    public static final Supplier<Block> NETHERITE_PLATED_CHEVRON_WALL = AVPRBlocks.registerBlock(
        "netherite_plated_chevron_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(netherite_plated.get()))
    );

    public static final Supplier<Block> NETHERITE_PLATED_SLAB = AVPRBlocks.registerBlock(
        "netherite_plated_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(netherite_plated.get()))
    );

    public static final Supplier<Block> NETHERITE_PLATED_STAIRS = AVPRBlocks.registerBlock(
        "netherite_plated_stairs",
        () -> new AVPRStairBlock(netherite_plated.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(netherite_plated.get()))
    );

    public static final Supplier<Block> NETHERITE_PLATED_WALL = AVPRBlocks.registerBlock(
        "netherite_plated_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BLACK_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_black_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BLACK_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_black_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_BLACK_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_BLACK_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_black_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BLACK_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_black_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BLACK_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_black_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_BLACK_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_BLACK_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_black_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BLUE_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_blue_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BLUE_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_blue_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_BLUE_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_BLUE_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_blue_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BLUE_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_blue_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BLUE_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_blue_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_BLUE_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_BLUE_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_blue_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BROWN_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_brown_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BROWN_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_brown_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_BROWN_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_BROWN_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_brown_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BROWN_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_brown_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_BROWN_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_brown_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_BROWN_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_BROWN_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_brown_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_CYAN_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_cyan_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_CYAN_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_cyan_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_CYAN_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_CYAN_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_cyan_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_CYAN_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_cyan_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_CYAN_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_cyan_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_CYAN_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_CYAN_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_cyan_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_GRAY_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_gray_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_GRAY_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_gray_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_GRAY_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_GRAY_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_gray_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_GRAY_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_gray_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_GRAY_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_gray_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_GRAY_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_GRAY_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_gray_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_GREEN_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_green_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_GREEN_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_green_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_GREEN_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_GREEN_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_green_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_GREEN_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_green_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_GREEN_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_green_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_GREEN_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_GREEN_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_green_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_light_blue_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_light_blue_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_LIGHT_BLUE_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_light_blue_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_light_blue_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_light_blue_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_LIGHT_BLUE_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_BLUE_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_light_blue_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_light_gray_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_light_gray_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_LIGHT_GRAY_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_light_gray_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_light_gray_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_light_gray_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_LIGHT_GRAY_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_LIGHT_GRAY_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_light_gray_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIME_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_lime_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIME_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_lime_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_LIME_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_LIME_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_lime_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIME_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_lime_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_LIME_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_lime_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_LIME_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_LIME_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_lime_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_MAGENTA_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_magenta_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_MAGENTA_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_magenta_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_MAGENTA_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_MAGENTA_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_magenta_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_MAGENTA_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_magenta_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_MAGENTA_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_magenta_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_MAGENTA_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_MAGENTA_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_magenta_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_ORANGE_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_orange_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_ORANGE_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_orange_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_ORANGE_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_ORANGE_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_orange_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_ORANGE_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_orange_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_ORANGE_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_orange_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_ORANGE_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_ORANGE_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_orange_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_PINK_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_pink_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_PINK_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_pink_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_PINK_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_PINK_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_pink_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_PINK_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_pink_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_PINK_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_pink_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_PINK_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_PINK_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_pink_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_PURPLE_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_purple_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_PURPLE_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_purple_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_PURPLE_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_PURPLE_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_purple_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_PURPLE_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_purple_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_PURPLE_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_purple_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_PURPLE_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_PURPLE_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_purple_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_RED_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_red_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_RED_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_red_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_RED_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_RED_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_red_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_RED_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_red_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_RED_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_red_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_RED_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_RED_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_red_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_WHITE_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_white_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_WHITE_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_white_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_WHITE_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_WHITE_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_white_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_WHITE_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_white_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_WHITE_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_white_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_WHITE_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_WHITE_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_white_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_YELLOW_SQUARE_SLAB = AVPRBlocks.registerBlock(
        "padding_yellow_square_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_YELLOW_SQUARE_STAIRS = AVPRBlocks.registerBlock(
        "padding_yellow_square_stairs",
        () -> new AVPRStairBlock(
            PADDING_YELLOW_SQUARE.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_YELLOW_SQUARE_WALL = AVPRBlocks.registerBlock(
        "padding_yellow_square_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_YELLOW_TILES_SLAB = AVPRBlocks.registerBlock(
        "padding_yellow_tiles_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get()))
    );

    public static final Supplier<Block> PADDING_YELLOW_TILES_STAIRS = AVPRBlocks.registerBlock(
        "padding_yellow_tiles_stairs",
        () -> new AVPRStairBlock(
            PADDING_YELLOW_TILES.get().defaultBlockState(),
            BlockBehaviour.Properties.ofFullCopy(PADDING_WHITE_PANEL.get())
        )
    );

    public static final Supplier<Block> PADDING_YELLOW_TILES_WALL = AVPRBlocks.registerBlock(
        "padding_yellow_tiles_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_CUT_SLAB = AVPRBlocks.registerBlock(
        "steel_cut_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_CUT_STAIRS = AVPRBlocks.registerBlock(
        "steel_cut_stairs",
        () -> new AVPRStairBlock(steel_block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_CUT_WALL = AVPRBlocks.registerBlock(
        "steel_cut_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_PLATED_CHEVRON_SLAB = AVPRBlocks.registerBlock(
        "steel_plated_chevron_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_PLATED_CHEVRON_STAIRS = AVPRBlocks.registerBlock(
        "steel_plated_chevron_stairs",
        () -> new AVPRStairBlock(steel_block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_PLATED_CHEVRON_WALL = AVPRBlocks.registerBlock(
        "steel_plated_chevron_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_PLATED_SLAB = AVPRBlocks.registerBlock(
        "steel_plated_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_PLATED_STAIRS = AVPRBlocks.registerBlock(
        "steel_plated_stairs",
        () -> new AVPRStairBlock(steel_block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> STEEL_PLATED_WALL = AVPRBlocks.registerBlock(
        "steel_plated_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(steel_block.get()))
    );

    public static final Supplier<Block> TITANIUM_CUT_SLAB = AVPRBlocks.registerBlock(
        "titanium_cut_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    public static final Supplier<Block> TITANIUM_CUT_STAIRS = AVPRBlocks.registerBlock(
        "titanium_cut_stairs",
        () -> new AVPRStairBlock(titanium_block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    public static final Supplier<Block> TITANIUM_CUT_WALL = AVPRBlocks.registerBlock(
        "titanium_cut_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    public static final Supplier<Block> TITANIUM_PLATED_CHEVRON_SLAB = AVPRBlocks.registerBlock(
        "titanium_plated_chevron_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    public static final Supplier<Block> TITANIUM_PLATED_CHEVRON_STAIRS = AVPRBlocks.registerBlock(
        "titanium_plated_chevron_stairs",
        () -> new AVPRStairBlock(titanium_block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    public static final Supplier<Block> TITANIUM_PLATED_CHEVRON_WALL = AVPRBlocks.registerBlock(
        "titanium_plated_chevron_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    public static final Supplier<Block> TITANIUM_PLATED_SLAB = AVPRBlocks.registerBlock(
        "titanium_plated_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    public static final Supplier<Block> TITANIUM_PLATED_STAIRS = AVPRBlocks.registerBlock(
        "titanium_plated_stairs",
        () -> new AVPRStairBlock(titanium_block.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    public static final Supplier<Block> TITANIUM_PLATED_WALL = AVPRBlocks.registerBlock(
        "titanium_plated_wall",
        () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(titanium_block.get()))
    );

    private static final Map<DyeColor, Block> INDUSTRIAL_GLASS_BLOCKS = new EnumMap<>(DyeColor.class);

    private static final Map<DyeColor, Item> INDUSTRIAL_GLASS_ITEMS = new EnumMap<>(DyeColor.class);

    private static final Map<OreType, Block> ORE_BLOCKS = new EnumMap<>(OreType.class);

    private static final Map<OreType, Item> ORE_ITEMS = new EnumMap<>(OreType.class);

    private static final Map<RawBlockType, Block> RAW_BLOCKS = new EnumMap<>(RawBlockType.class);

    private static final Map<RawBlockType, Item> RAW_ITEMS = new EnumMap<>(RawBlockType.class);

    private static final Map<NormalBlockType, Block> NORMAL_BLOCKS = new EnumMap<>(NormalBlockType.class);

    private static final Map<NormalBlockType, Item> NORMAL_ITEMS = new EnumMap<>(NormalBlockType.class);

    private static final Map<RawBlockType, OreProperties> RAW_PROPERTIES = Map.of(
        RawBlockType.BAUXITE,
        new OreProperties("bauxite", 3.2F, 2.6F),
        RawBlockType.TITANIUM,
        new OreProperties("titanium", 4.0F, 4.0F)
    );

    private static final Map<NormalBlockType, OreProperties> NORMAL_PROPERTIES = Map.of(
        NormalBlockType.NEODYMIUM,
        new OreProperties("neodymium", 3.2F, 2.6F),
        NormalBlockType.COBALT,
        new OreProperties("cobalt", 3.2F, 2.6F),
        NormalBlockType.TITANIUM,
        new OreProperties("titanium", 4.0F, 4.0F),
        NormalBlockType.LITHIUM,
        new OreProperties("lithium", 4.0F, 4.0F),
        NormalBlockType.SILICA,
        new OreProperties("silica", 2.2F, 1.4F)
    );

    private static final Map<OreType, OreProperties> ORE_PROPERTIES = Map.of(
        OreType.BAUXITE,
        new OreProperties("ore_bauxite", 3.2F, 2.6F),
        OreType.TITANIUM,
        new OreProperties("ore_titanium", 4.0F, 4.0F),
        OreType.SILICA,
        new OreProperties("ore_silica", 2.2F, 1.4F),
        OreType.MONAZITE,
        new OreProperties("ore_monazite", 45F, 15F),
        OreType.LITHIUM,
        new OreProperties("ore_lithium", 4.2F, 5.4F),
        OreType.COBALT,
        new OreProperties("ore_cobalt", 50F, 20F)
    );

    public static void registerOres() {
        ORE_PROPERTIES.forEach((oreType, properties) -> {
            Supplier<Block> blockSupplier = AVPRBlocks.registerBlock(
                properties.name().toLowerCase(Locale.ROOT),
                () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                        .noOcclusion()
                        .strength(properties.hardness(), properties.resistance())
                )
            );
            ORE_BLOCKS.put(oreType, blockSupplier.get());

            Supplier<Item> itemSupplier = AVPRItems.registerItem(
                properties.name().toLowerCase(Locale.ROOT),
                () -> new BlockItem(blockSupplier.get(), new Item.Properties())
            );
            ORE_ITEMS.put(oreType, itemSupplier.get());
        });
    }

    public static void registerGlassBlocks() {
        Arrays.stream(DyeColor.values()).forEach(dyeColor -> {
            Supplier<Block> glassBlock = AVPRBlocks.registerBlock(
                "industrial_glass_" + dyeColor.getName().toLowerCase(Locale.ROOT),
                () -> new ColoredTransparentBlock(dyeColor, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
            );
            INDUSTRIAL_GLASS_BLOCKS.put(dyeColor, glassBlock.get());

            Supplier<Item> glassItem = AVPRItems.registerItem(
                "industrial_glass_" + dyeColor.getName().toLowerCase(Locale.ROOT),
                () -> new BlockItem(glassBlock.get(), new Item.Properties())
            );
            INDUSTRIAL_GLASS_ITEMS.put(dyeColor, glassItem.get());
        });
    }

    public static void registerRawBlocks() {
        RAW_PROPERTIES.forEach((rawBlockType, properties) -> {
            Supplier<Block> blockSupplier = AVPRBlocks.registerBlock(
                "raw_" + properties.name().toLowerCase(Locale.ROOT) + "_block",
                () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                        .strength(properties.hardness(), properties.resistance())
                )
            );
            RAW_BLOCKS.put(rawBlockType, blockSupplier.get());

            Supplier<Item> itemSupplier = AVPRItems.registerItem(
                "raw_" + properties.name().toLowerCase(Locale.ROOT) + "_block",
                () -> new BlockItem(blockSupplier.get(), new Item.Properties())
            );
            RAW_ITEMS.put(rawBlockType, itemSupplier.get());
        });
    }

    public static void registerNormalBlocks() {
        NORMAL_PROPERTIES.forEach((normalBlockType, properties) -> {
            Supplier<Block> blockSupplier = AVPRBlocks.registerBlock(
                properties.name().toLowerCase(Locale.ROOT) + "_block",
                () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                        .strength(properties.hardness(), properties.resistance())
                )
            );
            NORMAL_BLOCKS.put(normalBlockType, blockSupplier.get());

            Supplier<Item> itemSupplier = AVPRItems.registerItem(
                properties.name().toLowerCase(Locale.ROOT) + "_block",
                () -> new BlockItem(blockSupplier.get(), new Item.Properties())
            );
            NORMAL_ITEMS.put(normalBlockType, itemSupplier.get());
        });
    }

    public static Block getNormalBlock(NormalBlockType rawBlockType) {
        return NORMAL_BLOCKS.get(rawBlockType);
    }

    public static Item getNormalItem(NormalBlockType rawBlockType) {
        return NORMAL_ITEMS.get(rawBlockType);
    }

    public static List<Item> getAllNormalItems() {
        return Arrays.stream(NormalBlockType.values())
            .map(AVPRBlocks::getNormalItem)
            .toList();
    }

    public static List<Block> getAllNormalBlocks() {
        return Arrays.stream(NormalBlockType.values())
            .map(AVPRBlocks::getNormalBlock)
            .toList();
    }

    public static Block getRawBlock(RawBlockType rawBlockType) {
        return RAW_BLOCKS.get(rawBlockType);
    }

    public static Item getRawItem(RawBlockType rawBlockType) {
        return RAW_ITEMS.get(rawBlockType);
    }

    public static List<Item> getAllRawItems() {
        return Arrays.stream(RawBlockType.values())
            .map(AVPRBlocks::getRawItem)
            .toList();
    }

    public static List<Block> getAllRawBlocks() {
        return Arrays.stream(RawBlockType.values())
            .map(AVPRBlocks::getRawBlock)
            .toList();
    }

    public static Block getOreBlock(OreType oreType) {
        return ORE_BLOCKS.get(oreType);
    }

    public static Item getOreItem(OreType oreType) {
        return ORE_ITEMS.get(oreType);
    }

    public static List<Item> getAllOreItems() {
        return Arrays.stream(OreType.values())
            .map(AVPRBlocks::getOreItem)
            .toList();
    }

    public static List<Block> getAllOreBlocks() {
        return Arrays.stream(OreType.values())
            .map(AVPRBlocks::getOreBlock)
            .toList();
    }

    public static Block getGlassBlock(DyeColor dyeColor) {
        return INDUSTRIAL_GLASS_BLOCKS.get(dyeColor);
    }

    public static Item getGlassItem(DyeColor dyeColor) {
        return INDUSTRIAL_GLASS_ITEMS.get(dyeColor);
    }

    public static List<Item> getAllGlassItems() {
        return Arrays.stream(DyeColor.values())
            .map(AVPRBlocks::getGlassItem)
            .toList();
    }

    public static List<Block> getAllGlassBlocks() {
        return Arrays.stream(DyeColor.values())
            .map(AVPRBlocks::getGlassBlock)
            .toList();
    }

    /**
     * Example of using this method to create a new Block:
     * <p>
     * The following code demonstrates how to register a new block in the game:
     * </p>
     *
     * <pre>{@code
     *
     * public static final Supplier<TestBlock> TEST_BLOCK = AVPRBlocks.registerBlock("blockname", TestBlock::new);
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerBlock</code> is a method to register a new block with the specified block name.</li>
     * <li><code>TestBlock</code> is used to create a new block instance.</li>
     * </ul>
     * <p>
     * The {@link Block Block} class represents a block in the game.
     * </p>
     * <p>
     * Registers a new Block.
     *
     * @param blockName The name of the block.
     * @param block     A supplier for the block.
     * @param <T>       The type of the block.
     * @return A supplier for the registered block.
     */
    static <T extends Block> Supplier<T> registerBlock(String blockName, Supplier<T> block) {
        return AVPRServices.COMMON_REGISTRY.registerBlock(CommonMod.MOD_ID, blockName, block);
    }

    /**
     * Example of using this method to create a new Block Entity:
     * <p>
     * The following code demonstrates how to register a new block entity type in the game:
     * </p>
     *
     * <pre>{@code
     *
     * public static final Supplier<BlockEntityType<TestBlockEntity>> TEST_BLOCKENTITY = CommonBlockEntityRegistryInterface
     *     .registerBlockEntity(
     *         "modid",
     *         "blockentityname",
     *         () -> BlockEntityType.Builder.of(TestBlockEntity::new, TEST_BLOCK.get()).build(null)
     *     );
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerBlockEntity</code> is a method to register a new block entity with the specified mod ID and
     * block entity name.</li>
     * <li><code>TestBlockEntity::new</code> is a reference to the constructor of the <code>TestBlockEntity</code>
     * class.</li>
     * <li><code>TEST_BLOCK.get()</code> is a reference to the block associated with this block entity.</li>
     * </ul>
     * <p>
     * The {@link BlockEntityType BlockEntityType} class represents a block entity type in the game.
     * </p>
     * <p>
     * Registers a new Block Entity.
     *
     * @param modID           The mod ID.
     * @param blockEntityName The name of the Block Entity.
     * @param blockEntity     A supplier for the block entity type.
     * @param <T>             The type of the block entity.
     * @return A supplier for the registered block entity type.
     */
    static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(
        String modID,
        String blockEntityName,
        Supplier<BlockEntityType<T>> blockEntity
    ) {
        return AVPRServices.COMMON_REGISTRY.registerBlockEntity(modID, blockEntityName, blockEntity);
    }

    public static void initialize() {
        AVPRBlocks.registerNormalBlocks();
        AVPRBlocks.registerRawBlocks();
        AVPRBlocks.registerGlassBlocks();
        AVPRBlocks.registerOres();
        /*
         * TODO: Engineer Ship
         */
    }
}
