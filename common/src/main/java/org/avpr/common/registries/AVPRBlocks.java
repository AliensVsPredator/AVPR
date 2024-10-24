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

import java.util.function.Supplier;

import org.avpr.common.CommonMod;
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

    public static final Supplier<Block> ORE_BAUXITE = AVPRBlocks.registerBlock(
        "ore_bauxite",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .noOcclusion()
                .strength(3.2F, 2.6F)
        )
    );

    public static final Supplier<Block> ORE_TITANIUM = AVPRBlocks.registerBlock(
        "ore_titanium",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .noOcclusion()
                .strength(4.0F, 4.0F)
        )
    );

    public static final Supplier<Block> ORE_SILICA = AVPRBlocks.registerBlock(
        "ore_silica",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .noOcclusion()
                .strength(2.2F, 1.4F)
        )
    );

    public static final Supplier<Block> ORE_MONAZITE = AVPRBlocks.registerBlock(
        "ore_monazite",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .noOcclusion()
                .strength(45.0F, 15.0F)
        )
    );

    public static final Supplier<Block> ORE_LITHIUM = AVPRBlocks.registerBlock(
        "ore_lithium",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .noOcclusion()
                .strength(4.2F, 5.4F)
        )
    );

    public static final Supplier<Block> ORE_COBALT = AVPRBlocks.registerBlock(
        "ore_cobalt",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .noOcclusion()
                .strength(50.0F, 20.0F)
        )
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_WHITE = AVPRBlocks.registerBlock(
        "industrial_glass_white",
        () -> new ColoredTransparentBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_ORANGE = AVPRBlocks.registerBlock(
        "industrial_glass_orange",
        () -> new ColoredTransparentBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_MAGENTA = AVPRBlocks.registerBlock(
        "industrial_glass_magenta",
        () -> new ColoredTransparentBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_LIGHT_BLUE = AVPRBlocks.registerBlock(
        "industrial_glass_light_blue",
        () -> new ColoredTransparentBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_YELLOW = AVPRBlocks.registerBlock(
        "industrial_glass_yellow",
        () -> new ColoredTransparentBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_LIME = AVPRBlocks.registerBlock(
        "industrial_glass_lime",
        () -> new ColoredTransparentBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_PINK = AVPRBlocks.registerBlock(
        "industrial_glass_pink",
        () -> new ColoredTransparentBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_GRAY = AVPRBlocks.registerBlock(
        "industrial_glass_gray",
        () -> new ColoredTransparentBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_LIGHT_GRAY = AVPRBlocks.registerBlock(
        "industrial_glass_light_gray",
        () -> new ColoredTransparentBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_CYAN = AVPRBlocks.registerBlock(
        "industrial_glass_cyan",
        () -> new ColoredTransparentBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_PURPLE = AVPRBlocks.registerBlock(
        "industrial_glass_purple",
        () -> new ColoredTransparentBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_BLUE = AVPRBlocks.registerBlock(
        "industrial_glass_blue",
        () -> new ColoredTransparentBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_BROWN = AVPRBlocks.registerBlock(
        "industrial_glass_brown",
        () -> new ColoredTransparentBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_GREEN = AVPRBlocks.registerBlock(
        "industrial_glass_green",
        () -> new ColoredTransparentBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_RED = AVPRBlocks.registerBlock(
        "industrial_glass_red",
        () -> new ColoredTransparentBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> INDUSTRIAL_GLASS_BLACK = AVPRBlocks.registerBlock(
        "industrial_glass_black",
        () -> new ColoredTransparentBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS))
    );

    public static final Supplier<Block> RAW_BAUXITE_BLOCK = AVPRBlocks.registerBlock(
        "raw_bauxite_block",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .strength(3.2F, 2.6F)
        )
    );

    public static final Supplier<Block> RAW_TITANIUM_BLOCK = AVPRBlocks.registerBlock(
        "raw_titanium_block",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .strength(4.0F, 4.0F)
        )
    );

    public static final Supplier<Block> NEODYMIUM_BLOCK = AVPRBlocks.registerBlock(
        "neodymium_block",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .strength(3.2F, 2.6F)
        )
    );

    public static final Supplier<Block> COBALT_BLOCK = AVPRBlocks.registerBlock(
        "cobalt_block",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .strength(3.2F, 2.6F)
        )
    );

    public static final Supplier<Block> LITHIUM_BLOCK = AVPRBlocks.registerBlock(
        "lithium_block",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .strength(4.0F, 4.0F)
        )
    );

    public static final Supplier<Block> SILICA_BLOCK = AVPRBlocks.registerBlock(
        "silica_block",
        () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                .strength(2.2F, 1.4F)
        )
    );

    public static final Supplier<BlockItem> RESIN_BLOCK_ITEM = AVPRItems.registerItem(
        "resin",
        () -> new BlockItem(RESIN_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> RESIN_VEIN_BLOCK_ITEM = AVPRItems.registerItem(
        "resin_vein",
        () -> new BlockItem(RESIN_VEIN_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> RESIN_WEBBING_BLOCK_ITEM = AVPRItems.registerItem(
        "resin_webbing",
        () -> new BlockItem(RESIN_WEBBING_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ORIONITE_BLOCK_ITEM = AVPRItems.registerItem(
        "orionite_block",
        () -> new BlockItem(ORIONITE_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_HAZARD_ITEM = AVPRItems.registerItem(
        "industrial_wall_hazard",
        () -> new BlockItem(INDUSTRIAL_WALL_HAZARD.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> SOLAR_PANEL_ITEM = AVPRItems.registerItem(
        "solar_panel",
        () -> new BlockItem(SOLAR_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_DIRT_ITEM = AVPRItems.registerItem(
        "unidentified_dirt",
        () -> new BlockItem(UNIDENTIFIED_DIRT.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_GRAVEL_ITEM = AVPRItems.registerItem(
        "unidentified_gravel",
        () -> new BlockItem(UNIDENTIFIED_GRAVEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_ROCK_ITEM = AVPRItems.registerItem(
        "unidentified_rock",
        () -> new BlockItem(UNIDENTIFIED_ROCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_SAND_ITEM = AVPRItems.registerItem(
        "unidentified_sand",
        () -> new BlockItem(UNIDENTIFIED_SAND.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> UNIDENTIFIED_STONE_ITEM = AVPRItems.registerItem(
        "unidentified_stone",
        () -> new BlockItem(UNIDENTIFIED_STONE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_BRICK_ITEM = AVPRItems.registerItem(
        "yautja_ship_brick",
        () -> new BlockItem(YAUTJA_SHIP_BRICK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_BRICK_SLAB_ITEM = AVPRItems.registerItem(
        "yautja_ship_brick_slab",
        () -> new BlockItem(YAUTJA_SHIP_BRICK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_BRICK_STAIRS_ITEM = AVPRItems.registerItem(
        "yautja_ship_brick_stairs",
        () -> new BlockItem(YAUTJA_SHIP_BRICK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_BRICK_WALL_ITEM = AVPRItems.registerItem(
        "yautja_ship_brick_wall",
        () -> new BlockItem(YAUTJA_SHIP_BRICK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_1_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_1",
        () -> new BlockItem(YAUTJA_SHIP_DECOR_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_2_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_2",
        () -> new BlockItem(YAUTJA_SHIP_DECOR_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_3_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_3",
        () -> new BlockItem(YAUTJA_SHIP_DECOR_3.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_3_SLAB_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_3_slab",
        () -> new BlockItem(YAUTJA_SHIP_DECOR_3_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_3_STAIRS_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_3_stairs",
        () -> new BlockItem(YAUTJA_SHIP_DECOR_3_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_DECOR_3_WALL_ITEM = AVPRItems.registerItem(
        "yautja_ship_decor_3_wall",
        () -> new BlockItem(YAUTJA_SHIP_DECOR_3_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_PANEL_ITEM = AVPRItems.registerItem(
        "yautja_ship_panel",
        () -> new BlockItem(YAUTJA_SHIP_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_SUPPORT_PILLAR_ITEM = AVPRItems.registerItem(
        "yautja_ship_support_pillar",
        () -> new BlockItem(YAUTJA_SHIP_SUPPORT_PILLAR.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> YAUTJA_SHIP_WALL_BASE_ITEM = AVPRItems.registerItem(
        "yautja_ship_wall_base",
        () -> new BlockItem(YAUTJA_SHIP_WALL_BASE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_WALL_BASE_ITEM = AVPRItems.registerItem(
        "temple_wall_base",
        () -> new BlockItem(TEMPLE_WALL_BASE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_CHESTBURSTER_ITEM = AVPRItems.registerItem(
        "temple_brick_chestburster",
        () -> new BlockItem(TEMPLE_BRICK_CHESTBURSTER.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_FACEHUGGER_ITEM = AVPRItems.registerItem(
        "temple_brick_facehugger",
        () -> new BlockItem(TEMPLE_BRICK_FACEHUGGER.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_SKULL_ITEM = AVPRItems.registerItem(
        "temple_skulls",
        () -> new BlockItem(TEMPLE_SKULL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_ITEM = AVPRItems.registerItem(
        "temple_brick",
        () -> new BlockItem(TEMPLE_BRICK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SLAB_ITEM = AVPRItems.registerItem(
        "temple_brick_slab",
        () -> new BlockItem(TEMPLE_BRICK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_STAIRS_ITEM = AVPRItems.registerItem(
        "temple_brick_stairs",
        () -> new BlockItem(TEMPLE_BRICK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_WALL_ITEM = AVPRItems.registerItem(
        "temple_brick_wall",
        () -> new BlockItem(TEMPLE_BRICK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SINGLE_ITEM = AVPRItems.registerItem(
        "temple_brick_single",
        () -> new BlockItem(TEMPLE_BRICK_SINGLE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SINGLE_SLAB_ITEM = AVPRItems.registerItem(
        "temple_brick_single_slab",
        () -> new BlockItem(TEMPLE_BRICK_SINGLE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SIMPLE_STAIRS_ITEM = AVPRItems.registerItem(
        "temple_brick_single_stairs",
        () -> new BlockItem(TEMPLE_BRICK_SIMPLE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_BRICK_SIMPLE_WALL_ITEM = AVPRItems.registerItem(
        "temple_brick_single_wall",
        () -> new BlockItem(TEMPLE_BRICK_SIMPLE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_FLOOR_ITEM = AVPRItems.registerItem(
        "temple_floor",
        () -> new BlockItem(TEMPLE_FLOOR.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_FLOOR_SLAB_ITEM = AVPRItems.registerItem(
        "temple_floor_slab",
        () -> new BlockItem(TEMPLE_FLOOR_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_FLOOR_STAIRS_ITEM = AVPRItems.registerItem(
        "temple_floor_stairs",
        () -> new BlockItem(TEMPLE_FLOOR_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_FLOOR_WALL_ITEM = AVPRItems.registerItem(
        "temple_floor_wall",
        () -> new BlockItem(TEMPLE_FLOOR_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_TILE_ITEM = AVPRItems.registerItem(
        "temple_tile",
        () -> new BlockItem(TEMPLE_TILE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_TILE_SLAB_ITEM = AVPRItems.registerItem(
        "temple_tile_slab",
        () -> new BlockItem(TEMPLE_TILE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_TILE_STAIRS_ITEM = AVPRItems.registerItem(
        "temple_tile_stairs",
        () -> new BlockItem(TEMPLE_TILE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TEMPLE_TILE_WALL_ITEM = AVPRItems.registerItem(
        "temple_tile_wall",
        () -> new BlockItem(TEMPLE_TILE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick",
        () -> new BlockItem(ENGINEER_SHIP_BRICK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_slab",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_stairs",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_wall",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_1",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_1_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_1_slab",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_1_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_1_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_1_stairs",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_1_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_1_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_1_wall",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_1_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_2",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_2_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_2_slab",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_2_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_2_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_2_stairs",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_2_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_2_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_2_wall",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_2_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_3_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_3",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_3.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_3_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_3_slab",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_3_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_3_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_3_stairs",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_3_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_BRICK_3_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_brick_3_wall",
        () -> new BlockItem(ENGINEER_SHIP_BRICK_3_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_0_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_0",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_0.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_0_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_0_slab",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_0_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_0_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_0_stairs",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_0_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_0_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_0_wall",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_0_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_1",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_1_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_1_slab",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_1_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_1_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_1_stairs",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_1_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_1_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_1_wall",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_1_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_2",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_2_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_2_slab",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_2_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_2_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_2_stairs",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_2_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_MATERIAL_2_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_material_2_wall",
        () -> new BlockItem(ENGINEER_SHIP_MATERIAL_2_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall",
        () -> new BlockItem(ENGINEER_SHIP_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_slab",
        () -> new BlockItem(ENGINEER_SHIP_WALL_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_stairs",
        () -> new BlockItem(ENGINEER_SHIP_WALL_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_wall",
        () -> new BlockItem(ENGINEER_SHIP_WALL_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_1",
        () -> new BlockItem(ENGINEER_SHIP_WALL_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_1_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_1_slab",
        () -> new BlockItem(ENGINEER_SHIP_WALL_1_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_1_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_1_stairs",
        () -> new BlockItem(ENGINEER_SHIP_WALL_1_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_1_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_1_wall",
        () -> new BlockItem(ENGINEER_SHIP_WALL_1_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_2",
        () -> new BlockItem(ENGINEER_SHIP_WALL_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_2_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_2_slab",
        () -> new BlockItem(ENGINEER_SHIP_WALL_2_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_2_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_2_stairs",
        () -> new BlockItem(ENGINEER_SHIP_WALL_2_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_2_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_2_wall",
        () -> new BlockItem(ENGINEER_SHIP_WALL_2_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_3_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_3",
        () -> new BlockItem(ENGINEER_SHIP_WALL_3.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_3_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_3_slab",
        () -> new BlockItem(ENGINEER_SHIP_WALL_3_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_3_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_3_stairs",
        () -> new BlockItem(ENGINEER_SHIP_WALL_3_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_3_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_3_wall",
        () -> new BlockItem(ENGINEER_SHIP_WALL_3_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_4_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_4",
        () -> new BlockItem(ENGINEER_SHIP_WALL_4.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_4_SLAB_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_4_slab",
        () -> new BlockItem(ENGINEER_SHIP_WALL_4_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_4_STAIRS_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_4_stairs",
        () -> new BlockItem(ENGINEER_SHIP_WALL_4_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_WALL_4_WALL_ITEM = AVPRItems.registerItem(
        "engineer_ship_wall_4_wall",
        () -> new BlockItem(ENGINEER_SHIP_WALL_4_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_COLUMN_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_column_1",
        () -> new BlockItem(ENGINEER_SHIP_COLUMN_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_COLUMN_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_column_2",
        () -> new BlockItem(ENGINEER_SHIP_COLUMN_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_FLOOR_ITEM = AVPRItems.registerItem(
        "engineer_ship_floor",
        () -> new BlockItem(ENGINEER_SHIP_FLOOR.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_GRAVEL_ITEM = AVPRItems.registerItem(
        "engineer_ship_gravel",
        () -> new BlockItem(ENGINEER_SHIP_GRAVEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_ROCK_ITEM = AVPRItems.registerItem(
        "engineer_ship_rock",
        () -> new BlockItem(ENGINEER_SHIP_ROCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_ROCK_1_ITEM = AVPRItems.registerItem(
        "engineer_ship_rock_1",
        () -> new BlockItem(ENGINEER_SHIP_ROCK_1.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_ROCK_2_ITEM = AVPRItems.registerItem(
        "engineer_ship_rock_2",
        () -> new BlockItem(ENGINEER_SHIP_ROCK_2.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ENGINEER_SHIP_ROCK_3_ITEM = AVPRItems.registerItem(
        "engineer_ship_rock_3",
        () -> new BlockItem(ENGINEER_SHIP_ROCK_3.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_WHITE_ITEM = AVPRItems.registerItem(
        "plastic_white",
        () -> new BlockItem(PLASTIC_WHITE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_WHITE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_white_slab",
        () -> new BlockItem(PLASTIC_WHITE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_WHITE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_white_stairs",
        () -> new BlockItem(PLASTIC_WHITE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_WHITE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_white_wall",
        () -> new BlockItem(PLASTIC_WHITE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_ORANGE_ITEM = AVPRItems.registerItem(
        "plastic_orange",
        () -> new BlockItem(PLASTIC_ORANGE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_ORANGE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_orange_slab",
        () -> new BlockItem(PLASTIC_ORANGE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_ORANGE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_orange_stairs",
        () -> new BlockItem(PLASTIC_ORANGE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_ORANGE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_orange_wall",
        () -> new BlockItem(PLASTIC_ORANGE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_MAGENTA_ITEM = AVPRItems.registerItem(
        "plastic_magenta",
        () -> new BlockItem(PLASTIC_MAGENTA.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_MAGENTA_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_magenta_slab",
        () -> new BlockItem(PLASTIC_MAGENTA_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_MAGENTA_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_magenta_stairs",
        () -> new BlockItem(PLASTIC_MAGENTA_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_MAGENTA_WALL_ITEM = AVPRItems.registerItem(
        "plastic_magenta_wall",
        () -> new BlockItem(PLASTIC_MAGENTA_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_BLUE_ITEM = AVPRItems.registerItem(
        "plastic_light_blue",
        () -> new BlockItem(PLASTIC_LIGHT_BLUE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PURPLE_ITEM = AVPRItems.registerItem(
        "plastic_purple",
        () -> new BlockItem(PLASTIC_PURPLE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIME_ITEM = AVPRItems.registerItem(
        "plastic_lime",
        () -> new BlockItem(PLASTIC_LIME.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PINK_ITEM = AVPRItems.registerItem(
        "plastic_pink",
        () -> new BlockItem(PLASTIC_PINK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GRAY_ITEM = AVPRItems.registerItem(
        "plastic_gray",
        () -> new BlockItem(PLASTIC_GRAY.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLUE_ITEM = AVPRItems.registerItem(
        "plastic_blue",
        () -> new BlockItem(PLASTIC_BLUE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BROWN_ITEM = AVPRItems.registerItem(
        "plastic_brown",
        () -> new BlockItem(PLASTIC_BROWN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_RED_ITEM = AVPRItems.registerItem(
        "plastic_red",
        () -> new BlockItem(PLASTIC_RED.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_BLUE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_light_blue_slab",
        () -> new BlockItem(PLASTIC_LIGHT_BLUE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_BLUE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_light_blue_stairs",
        () -> new BlockItem(PLASTIC_LIGHT_BLUE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_BLUE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_light_blue_wall",
        () -> new BlockItem(PLASTIC_LIGHT_BLUE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_YELLOW_ITEM = AVPRItems.registerItem(
        "plastic_yellow",
        () -> new BlockItem(PLASTIC_YELLOW.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_YELLOW_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_yellow_slab",
        () -> new BlockItem(PLASTIC_YELLOW_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_YELLOW_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_yellow_stairs",
        () -> new BlockItem(PLASTIC_YELLOW_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_YELLOW_WALL_ITEM = AVPRItems.registerItem(
        "plastic_yellow_wall",
        () -> new BlockItem(PLASTIC_YELLOW_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIME_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_lime_slab",
        () -> new BlockItem(PLASTIC_LIME_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIME_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_lime_stairs",
        () -> new BlockItem(PLASTIC_LIME_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIME_WALL_ITEM = AVPRItems.registerItem(
        "plastic_lime_wall",
        () -> new BlockItem(PLASTIC_LIME_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PINK_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_pink_slab",
        () -> new BlockItem(PLASTIC_PINK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PINK_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_pink_stairs",
        () -> new BlockItem(PLASTIC_PINK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PINK_WALL_ITEM = AVPRItems.registerItem(
        "plastic_pink_wall",
        () -> new BlockItem(PLASTIC_PINK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GRAY_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_gray_slab",
        () -> new BlockItem(PLASTIC_GRAY_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GRAY_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_gray_stairs",
        () -> new BlockItem(PLASTIC_GRAY_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GRAY_WALL_ITEM = AVPRItems.registerItem(
        "plastic_gray_wall",
        () -> new BlockItem(PLASTIC_GRAY_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_GRAY_ITEM = AVPRItems.registerItem(
        "plastic_light_gray",
        () -> new BlockItem(PLASTIC_LIGHT_GRAY.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_GRAY_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_light_gray_slab",
        () -> new BlockItem(PLASTIC_LIGHT_GRAY_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_GRAY_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_light_gray_stairs",
        () -> new BlockItem(PLASTIC_LIGHT_GRAY_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_LIGHT_GRAY_WALL_ITEM = AVPRItems.registerItem(
        "plastic_light_gray_wall",
        () -> new BlockItem(PLASTIC_LIGHT_GRAY_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_CYAN_ITEM = AVPRItems.registerItem(
        "plastic_cyan",
        () -> new BlockItem(PLASTIC_CYAN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_CYAN_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_cyan_slab",
        () -> new BlockItem(PLASTIC_CYAN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_CYAN_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_cyan_stairs",
        () -> new BlockItem(PLASTIC_CYAN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_CYAN_WALL_ITEM = AVPRItems.registerItem(
        "plastic_cyan_wall",
        () -> new BlockItem(PLASTIC_CYAN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PURPLE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_purple_slab",
        () -> new BlockItem(PLASTIC_PURPLE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PURPLE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_purple_stairs",
        () -> new BlockItem(PLASTIC_PURPLE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_PURPLE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_purple_wall",
        () -> new BlockItem(PLASTIC_PURPLE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLUE_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_blue_slab",
        () -> new BlockItem(PLASTIC_BLUE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLUE_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_blue_stairs",
        () -> new BlockItem(PLASTIC_BLUE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLUE_WALL_ITEM = AVPRItems.registerItem(
        "plastic_blue_wall",
        () -> new BlockItem(PLASTIC_BLUE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BROWN_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_brown_slab",
        () -> new BlockItem(PLASTIC_BROWN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BROWN_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_brown_stairs",
        () -> new BlockItem(PLASTIC_BROWN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BROWN_WALL_ITEM = AVPRItems.registerItem(
        "plastic_brown_wall",
        () -> new BlockItem(PLASTIC_BROWN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GREEN_ITEM = AVPRItems.registerItem(
        "plastic_green_slab",
        () -> new BlockItem(PLASTIC_GREEN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GREEN_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_green",
        () -> new BlockItem(PLASTIC_GREEN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GREEN_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_green_stairs",
        () -> new BlockItem(PLASTIC_GREEN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_GREEN_WALL_ITEM = AVPRItems.registerItem(
        "plastic_green_wall",
        () -> new BlockItem(PLASTIC_GREEN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_RED_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_red_slab",
        () -> new BlockItem(PLASTIC_RED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_RED_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_red_stairs",
        () -> new BlockItem(PLASTIC_RED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_RED_WALL_ITEM = AVPRItems.registerItem(
        "plastic_red_wall",
        () -> new BlockItem(PLASTIC_RED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLACK_ITEM = AVPRItems.registerItem(
        "plastic_black",
        () -> new BlockItem(PLASTIC_BLACK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLACK_SLAB_ITEM = AVPRItems.registerItem(
        "plastic_black_slab",
        () -> new BlockItem(PLASTIC_BLACK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLACK_STAIRS_ITEM = AVPRItems.registerItem(
        "plastic_black_stairs",
        () -> new BlockItem(PLASTIC_BLACK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PLASTIC_BLACK_WALL_ITEM = AVPRItems.registerItem(
        "plastic_black_wall",
        () -> new BlockItem(PLASTIC_BLACK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_WHITE_ITEM = AVPRItems.registerItem(
        "industrial_wall_white",
        () -> new BlockItem(INDUSTRIAL_WALL_WHITE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_WHITE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_white_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_WHITE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_WHITE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_white_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_WHITE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_WHITE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_white_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_WHITE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_ORANGE_ITEM = AVPRItems.registerItem(
        "industrial_wall_orange",
        () -> new BlockItem(INDUSTRIAL_WALL_ORANGE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_ORANGE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_orange_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_ORANGE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_ORANGE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_orange_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_ORANGE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_ORANGE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_orange_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_ORANGE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_MAGENTA_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_magenta_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_MAGENTA_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_MAGENTA_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_magenta_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_MAGENTA_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_MAGENTA_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_magenta_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_MAGENTA_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_BLUE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_blue_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_LIGHT_BLUE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_BLUE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_blue_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_LIGHT_BLUE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_BLUE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_blue_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_LIGHT_BLUE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_YELLOW_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_yellow_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_YELLOW_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_YELLOW_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_yellow_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_YELLOW_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_YELLOW_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_yellow_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_YELLOW_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIME_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_lime_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_LIME_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIME_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_lime_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_LIME_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIME_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_lime_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_LIME_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PINK_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_pink_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_PINK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PINK_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_pink_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_PINK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PINK_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_pink_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_PINK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GRAY_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_gray_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_GRAY_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GRAY_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_gray_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_GRAY_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GRAY_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_gray_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_GRAY_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_GRAY_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_gray_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_LIGHT_GRAY_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_GRAY_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_gray_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_LIGHT_GRAY_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_GRAY_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_gray_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_LIGHT_GRAY_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_CYAN_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_cyan_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_CYAN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_CYAN_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_cyan_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_CYAN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_CYAN_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_cyan_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_CYAN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PURPLE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_purple_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_PURPLE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PURPLE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_purple_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_PURPLE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PURPLE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_purple_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_PURPLE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLUE_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_blue_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_BLUE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLUE_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_blue_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_BLUE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLUE_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_blue_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_BLUE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BROWN_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_brown_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_BROWN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BROWN_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_brown_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_BROWN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BROWN_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_brown_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_BROWN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GREEN_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_green_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_GREEN_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GREEN_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_green_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_GREEN_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GREEN_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_green_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_GREEN_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_RED_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_red_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_RED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_RED_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_red_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_RED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_RED_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_red_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_RED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLACK_SLAB_ITEM = AVPRItems.registerItem(
        "industrial_wall_black_slab",
        () -> new BlockItem(INDUSTRIAL_WALL_BLACK_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLACK_STAIRS_ITEM = AVPRItems.registerItem(
        "industrial_wall_black_stairs",
        () -> new BlockItem(INDUSTRIAL_WALL_BLACK_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLACK_WALL_ITEM = AVPRItems.registerItem(
        "industrial_wall_black_wall",
        () -> new BlockItem(INDUSTRIAL_WALL_BLACK_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_white_panel",
        () -> new BlockItem(PADDING_WHITE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_white_pipes",
        () -> new BlockItem(PADDING_WHITE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_white_square",
        () -> new BlockItem(PADDING_WHITE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_TILES_ITEM = AVPRItems.registerItem(
        "padding_white_tiles",
        () -> new BlockItem(PADDING_WHITE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_orange_panel",
        () -> new BlockItem(PADDING_ORANGE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_orange_pipes",
        () -> new BlockItem(PADDING_ORANGE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_orange_square",
        () -> new BlockItem(PADDING_ORANGE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_TILES_ITEM = AVPRItems.registerItem(
        "padding_orange_tiles",
        () -> new BlockItem(PADDING_ORANGE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_PANEL_ITEM = AVPRItems.registerItem(
        "padding_magenta_panel",
        () -> new BlockItem(PADDING_MAGENTA_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_PIPES_ITEM = AVPRItems.registerItem(
        "padding_magenta_pipes",
        () -> new BlockItem(PADDING_MAGENTA_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_magenta_square",
        () -> new BlockItem(PADDING_MAGENTA_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_TILES_ITEM = AVPRItems.registerItem(
        "padding_magenta_tiles",
        () -> new BlockItem(PADDING_MAGENTA_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_light_blue_panel",
        () -> new BlockItem(PADDING_LIGHT_BLUE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_light_blue_pipes",
        () -> new BlockItem(PADDING_LIGHT_BLUE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_light_blue_square",
        () -> new BlockItem(PADDING_LIGHT_BLUE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_TILES_ITEM = AVPRItems.registerItem(
        "padding_light_blue_tiles",
        () -> new BlockItem(PADDING_LIGHT_BLUE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_PANEL_ITEM = AVPRItems.registerItem(
        "padding_yellow_panel",
        () -> new BlockItem(PADDING_YELLOW_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_PIPES_ITEM = AVPRItems.registerItem(
        "padding_yellow_pipes",
        () -> new BlockItem(PADDING_YELLOW_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_yellow_square",
        () -> new BlockItem(PADDING_YELLOW_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_TILES_ITEM = AVPRItems.registerItem(
        "padding_yellow_tiles",
        () -> new BlockItem(PADDING_YELLOW_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_PANEL_ITEM = AVPRItems.registerItem(
        "padding_lime_panel",
        () -> new BlockItem(PADDING_LIME_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_PIPES_ITEM = AVPRItems.registerItem(
        "padding_lime_pipes",
        () -> new BlockItem(PADDING_LIME_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_lime_square",
        () -> new BlockItem(PADDING_LIME_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_TILES_ITEM = AVPRItems.registerItem(
        "padding_lime_tiles",
        () -> new BlockItem(PADDING_LIME_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_PANEL_ITEM = AVPRItems.registerItem(
        "padding_pink_panel",
        () -> new BlockItem(PADDING_PINK_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_PIPES_ITEM = AVPRItems.registerItem(
        "padding_pink_pipes",
        () -> new BlockItem(PADDING_PINK_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_pink_square",
        () -> new BlockItem(PADDING_PINK_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_TILES_ITEM = AVPRItems.registerItem(
        "padding_pink_tiles",
        () -> new BlockItem(PADDING_PINK_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_PANEL_ITEM = AVPRItems.registerItem(
        "padding_gray_panel",
        () -> new BlockItem(PADDING_GRAY_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_PIPES_ITEM = AVPRItems.registerItem(
        "padding_gray_pipes",
        () -> new BlockItem(PADDING_GRAY_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_gray_square",
        () -> new BlockItem(PADDING_GRAY_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_TILES_ITEM = AVPRItems.registerItem(
        "padding_gray_tiles",
        () -> new BlockItem(PADDING_GRAY_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_PANEL_ITEM = AVPRItems.registerItem(
        "padding_light_gray_panel",
        () -> new BlockItem(PADDING_LIGHT_GRAY_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_PIPES_ITEM = AVPRItems.registerItem(
        "padding_light_gray_pipes",
        () -> new BlockItem(PADDING_LIGHT_GRAY_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_light_gray_square",
        () -> new BlockItem(PADDING_LIGHT_GRAY_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_TILES_ITEM = AVPRItems.registerItem(
        "padding_light_gray_tiles",
        () -> new BlockItem(PADDING_LIGHT_GRAY_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_PANEL_ITEM = AVPRItems.registerItem(
        "padding_cyan_panel",
        () -> new BlockItem(PADDING_CYAN_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_PIPES_ITEM = AVPRItems.registerItem(
        "padding_cyan_pipes",
        () -> new BlockItem(PADDING_CYAN_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_cyan_square",
        () -> new BlockItem(PADDING_CYAN_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_TILES_ITEM = AVPRItems.registerItem(
        "padding_cyan_tiles",
        () -> new BlockItem(PADDING_CYAN_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_purple_panel",
        () -> new BlockItem(PADDING_PURPLE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_purple_pipes",
        () -> new BlockItem(PADDING_PURPLE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_purple_square",
        () -> new BlockItem(PADDING_PURPLE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_TILES_ITEM = AVPRItems.registerItem(
        "padding_purple_tiles",
        () -> new BlockItem(PADDING_PURPLE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_PANEL_ITEM = AVPRItems.registerItem(
        "padding_blue_panel",
        () -> new BlockItem(PADDING_BLUE_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_PIPES_ITEM = AVPRItems.registerItem(
        "padding_blue_pipes",
        () -> new BlockItem(PADDING_BLUE_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_blue_square",
        () -> new BlockItem(PADDING_BLUE_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_TILES_ITEM = AVPRItems.registerItem(
        "padding_blue_tiles",
        () -> new BlockItem(PADDING_BLUE_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_PANEL_ITEM = AVPRItems.registerItem(
        "padding_brown_panel",
        () -> new BlockItem(PADDING_BROWN_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_PIPES_ITEM = AVPRItems.registerItem(
        "padding_brown_pipes",
        () -> new BlockItem(PADDING_BROWN_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_brown_square",
        () -> new BlockItem(PADDING_BROWN_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_TILES_ITEM = AVPRItems.registerItem(
        "padding_brown_tiles",
        () -> new BlockItem(PADDING_BROWN_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_PANEL_ITEM = AVPRItems.registerItem(
        "padding_green_panel",
        () -> new BlockItem(PADDING_GREEN_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_PIPES_ITEM = AVPRItems.registerItem(
        "padding_green_pipes",
        () -> new BlockItem(PADDING_GREEN_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_green_square",
        () -> new BlockItem(PADDING_GREEN_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_TILES_ITEM = AVPRItems.registerItem(
        "padding_green_tiles",
        () -> new BlockItem(PADDING_GREEN_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_PANEL_ITEM = AVPRItems.registerItem(
        "padding_red_panel",
        () -> new BlockItem(PADDING_RED_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_PIPES_ITEM = AVPRItems.registerItem(
        "padding_red_pipes",
        () -> new BlockItem(PADDING_RED_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_red_square",
        () -> new BlockItem(PADDING_RED_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_TILES_ITEM = AVPRItems.registerItem(
        "padding_red_tiles",
        () -> new BlockItem(PADDING_RED_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_PANEL_ITEM = AVPRItems.registerItem(
        "padding_black_panel",
        () -> new BlockItem(PADDING_BLACK_PANEL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_PIPES_ITEM = AVPRItems.registerItem(
        "padding_black_pipes",
        () -> new BlockItem(PADDING_BLACK_PIPES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_SQUARE_ITEM = AVPRItems.registerItem(
        "padding_black_square",
        () -> new BlockItem(PADDING_BLACK_SQUARE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_TILES_ITEM = AVPRItems.registerItem(
        "padding_black_tiles",
        () -> new BlockItem(PADDING_BLACK_TILES.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_block_item = AVPRItems.registerItem(
        "aluminum_block",
        () -> new BlockItem(aluminum_block.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_grate_item = AVPRItems.registerItem(
        "aluminum_grate",
        () -> new BlockItem(aluminum_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_vent_item = AVPRItems.registerItem(
        "aluminum_vent",
        () -> new BlockItem(aluminum_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_panel_item = AVPRItems.registerItem(
        "aluminum_panel",
        () -> new BlockItem(aluminum_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_plated_item = AVPRItems.registerItem(
        "aluminum_plated",
        () -> new BlockItem(aluminum_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_plated_chevron_item = AVPRItems.registerItem(
        "aluminum_plated_chevron",
        () -> new BlockItem(aluminum_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> aluminum_cut_item = AVPRItems.registerItem(
        "aluminum_cut",
        () -> new BlockItem(aluminum_cut.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_grate_item = AVPRItems.registerItem(
        "copper_grate",
        () -> new BlockItem(copper_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_vent_item = AVPRItems.registerItem(
        "copper_vent",
        () -> new BlockItem(copper_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_panel_item = AVPRItems.registerItem(
        "copper_panel",
        () -> new BlockItem(copper_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_plated_item = AVPRItems.registerItem(
        "copper_plated",
        () -> new BlockItem(copper_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> copper_plated_chevron_item = AVPRItems.registerItem(
        "copper_plated_chevron",
        () -> new BlockItem(copper_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_block_item = AVPRItems.registerItem(
        "ferroaluminum_block",
        () -> new BlockItem(ferroaluminum_block.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_grate_item = AVPRItems.registerItem(
        "ferroaluminum_grate",
        () -> new BlockItem(ferroaluminum_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_vent_item = AVPRItems.registerItem(
        "ferroaluminum_vent",
        () -> new BlockItem(ferroaluminum_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_panel_item = AVPRItems.registerItem(
        "ferroaluminum_panel",
        () -> new BlockItem(ferroaluminum_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_plated_item = AVPRItems.registerItem(
        "ferroaluminum_plated",
        () -> new BlockItem(ferroaluminum_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_plated_chevron_item = AVPRItems.registerItem(
        "ferroaluminum_plated_chevron",
        () -> new BlockItem(ferroaluminum_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ferroaluminum_cut_item = AVPRItems.registerItem(
        "ferroaluminum_cut",
        () -> new BlockItem(ferroaluminum_cut.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_grate_item = AVPRItems.registerItem(
        "gold_grate",
        () -> new BlockItem(gold_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_vent_item = AVPRItems.registerItem(
        "gold_vent",
        () -> new BlockItem(gold_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_panel_item = AVPRItems.registerItem(
        "gold_panel",
        () -> new BlockItem(gold_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_plated_item = AVPRItems.registerItem(
        "gold_plated",
        () -> new BlockItem(gold_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> gold_plated_chevron_item = AVPRItems.registerItem(
        "gold_plated_chevron",
        () -> new BlockItem(gold_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_grate_item = AVPRItems.registerItem(
        "iron_grate",
        () -> new BlockItem(iron_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_vent_item = AVPRItems.registerItem(
        "iron_vent",
        () -> new BlockItem(iron_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_panel_item = AVPRItems.registerItem(
        "iron_panel",
        () -> new BlockItem(iron_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_plated_item = AVPRItems.registerItem(
        "iron_plated",
        () -> new BlockItem(iron_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> iron_plated_chevron_item = AVPRItems.registerItem(
        "iron_plated_chevron",
        () -> new BlockItem(iron_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_grate_item = AVPRItems.registerItem(
        "netherite_grate",
        () -> new BlockItem(netherite_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_vent_item = AVPRItems.registerItem(
        "netherite_vent",
        () -> new BlockItem(netherite_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_panel_item = AVPRItems.registerItem(
        "netherite_panel",
        () -> new BlockItem(netherite_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_plated_item = AVPRItems.registerItem(
        "netherite_plated",
        () -> new BlockItem(netherite_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> netherite_plated_chevron_item = AVPRItems.registerItem(
        "netherite_plated_chevron",
        () -> new BlockItem(netherite_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_block_item = AVPRItems.registerItem(
        "steel_block",
        () -> new BlockItem(steel_block.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_grate_item = AVPRItems.registerItem(
        "steel_grate",
        () -> new BlockItem(steel_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_vent_item = AVPRItems.registerItem(
        "steel_vent",
        () -> new BlockItem(steel_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_panel_item = AVPRItems.registerItem(
        "steel_panel",
        () -> new BlockItem(steel_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_plated_item = AVPRItems.registerItem(
        "steel_plated",
        () -> new BlockItem(steel_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_plated_chevron_item = AVPRItems.registerItem(
        "steel_plated_chevron",
        () -> new BlockItem(steel_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> steel_cut_item = AVPRItems.registerItem(
        "steel_cut",
        () -> new BlockItem(steel_cut.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_block_item = AVPRItems.registerItem(
        "titanium_block",
        () -> new BlockItem(titanium_block.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_grate_item = AVPRItems.registerItem(
        "titanium_grate",
        () -> new BlockItem(titanium_grate.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_vent_item = AVPRItems.registerItem(
        "titanium_vent",
        () -> new BlockItem(titanium_vent.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_panel_item = AVPRItems.registerItem(
        "titanium_panel",
        () -> new BlockItem(titanium_panel.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_plated_item = AVPRItems.registerItem(
        "titanium_plated",
        () -> new BlockItem(titanium_plated.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_plated_chevron_item = AVPRItems.registerItem(
        "titanium_plated_chevron",
        () -> new BlockItem(titanium_plated_chevron.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> titanium_cut_item = AVPRItems.registerItem(
        "titanium_cut",
        () -> new BlockItem(titanium_cut.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_GLASS_ITEM = AVPRItems.registerItem(
        "industrial_glass",
        () -> new BlockItem(INDUSTRIAL_GLASS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_CUT_SLAB_ITEM = AVPRItems.registerItem(
        "aluminum_cut_slab",
        () -> new BlockItem(ALUMINUM_CUT_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_CUT_STAIRS_ITEM = AVPRItems.registerItem(
        "aluminum_cut_stairs",
        () -> new BlockItem(ALUMINUM_CUT_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_CUT_WALL_ITEM = AVPRItems.registerItem(
        "aluminum_cut_wall",
        () -> new BlockItem(ALUMINUM_CUT_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "aluminum_plated_chevron_slab",
        () -> new BlockItem(ALUMINUM_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "aluminum_plated_chevron_stairs",
        () -> new BlockItem(ALUMINUM_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "aluminum_plated_chevron_wall",
        () -> new BlockItem(ALUMINUM_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "aluminum_plated_slab",
        () -> new BlockItem(ALUMINUM_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "aluminum_plated_stairs",
        () -> new BlockItem(ALUMINUM_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> ALUMINUM_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "aluminum_plated_wall",
        () -> new BlockItem(ALUMINUM_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "copper_plated_chevron_slab",
        () -> new BlockItem(COPPER_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "copper_plated_chevron_stairs",
        () -> new BlockItem(COPPER_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "copper_plated_chevron_wall",
        () -> new BlockItem(COPPER_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "copper_plated_slab",
        () -> new BlockItem(COPPER_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "copper_plated_stairs",
        () -> new BlockItem(COPPER_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> COPPER_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "copper_plated_wall",
        () -> new BlockItem(COPPER_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_CUT_SLAB_ITEM = AVPRItems.registerItem(
        "ferroaluminum_cut_slab",
        () -> new BlockItem(FERROALUMINUM_CUT_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_CUT_STAIRS_ITEM = AVPRItems.registerItem(
        "ferroaluminum_cut_stairs",
        () -> new BlockItem(FERROALUMINUM_CUT_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_CUT_WALL_ITEM = AVPRItems.registerItem(
        "ferroaluminum_cut_wall",
        () -> new BlockItem(FERROALUMINUM_CUT_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_chevron_slab",
        () -> new BlockItem(FERROALUMINUM_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_chevron_stairs",
        () -> new BlockItem(FERROALUMINUM_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_chevron_wall",
        () -> new BlockItem(FERROALUMINUM_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_slab",
        () -> new BlockItem(FERROALUMINUM_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_stairs",
        () -> new BlockItem(FERROALUMINUM_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> FERROALUMINUM_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "ferroaluminum_plated_wall",
        () -> new BlockItem(FERROALUMINUM_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "gold_plated_chevron_slab",
        () -> new BlockItem(GOLD_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "gold_plated_chevron_stairs",
        () -> new BlockItem(GOLD_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "gold_plated_chevron_wall",
        () -> new BlockItem(GOLD_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "gold_plated_slab",
        () -> new BlockItem(GOLD_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "gold_plated_stairs",
        () -> new BlockItem(GOLD_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> GOLD_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "gold_plated_wall",
        () -> new BlockItem(GOLD_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "iron_plated_chevron_slab",
        () -> new BlockItem(IRON_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "iron_plated_chevron_stairs",
        () -> new BlockItem(IRON_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "iron_plated_chevron_wall",
        () -> new BlockItem(IRON_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "iron_plated_slab",
        () -> new BlockItem(IRON_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "iron_plated_stairs",
        () -> new BlockItem(IRON_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> IRON_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "iron_plated_wall",
        () -> new BlockItem(IRON_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "netherite_plated_chevron_slab",
        () -> new BlockItem(NETHERITE_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "netherite_plated_chevron_stairs",
        () -> new BlockItem(NETHERITE_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "netherite_plated_chevron_wall",
        () -> new BlockItem(NETHERITE_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "netherite_plated_slab",
        () -> new BlockItem(NETHERITE_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "netherite_plated_stairs",
        () -> new BlockItem(NETHERITE_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> NETHERITE_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "netherite_plated_wall",
        () -> new BlockItem(NETHERITE_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_black_square_slab",
        () -> new BlockItem(PADDING_BLACK_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_black_square_stairs",
        () -> new BlockItem(PADDING_BLACK_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLACK_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_black_square_wall",
        () -> new BlockItem(PADDING_BLACK_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_blue_square_slab",
        () -> new BlockItem(PADDING_BLUE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_blue_square_stairs",
        () -> new BlockItem(PADDING_BLUE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BLUE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_blue_square_wall",
        () -> new BlockItem(PADDING_BLUE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_brown_square_slab",
        () -> new BlockItem(PADDING_BROWN_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_brown_square_stairs",
        () -> new BlockItem(PADDING_BROWN_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_BROWN_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_brown_square_wall",
        () -> new BlockItem(PADDING_BROWN_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_cyan_square_slab",
        () -> new BlockItem(PADDING_CYAN_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_cyan_square_stairs",
        () -> new BlockItem(PADDING_CYAN_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_CYAN_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_cyan_square_wall",
        () -> new BlockItem(PADDING_CYAN_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_gray_square_slab",
        () -> new BlockItem(PADDING_GRAY_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_gray_square_stairs",
        () -> new BlockItem(PADDING_GRAY_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GRAY_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_gray_square_wall",
        () -> new BlockItem(PADDING_GRAY_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_green_square_slab",
        () -> new BlockItem(PADDING_GREEN_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_green_square_stairs",
        () -> new BlockItem(PADDING_GREEN_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_GREEN_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_green_square_wall",
        () -> new BlockItem(PADDING_GREEN_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_light_blue_square_slab",
        () -> new BlockItem(PADDING_LIGHT_BLUE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_light_blue_square_stairs",
        () -> new BlockItem(PADDING_LIGHT_BLUE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_BLUE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_light_blue_square_wall",
        () -> new BlockItem(PADDING_LIGHT_BLUE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_light_gray_square_slab",
        () -> new BlockItem(PADDING_LIGHT_GRAY_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_light_gray_square_stairs",
        () -> new BlockItem(PADDING_LIGHT_GRAY_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIGHT_GRAY_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_light_gray_square_wall",
        () -> new BlockItem(PADDING_LIGHT_GRAY_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_lime_square_slab",
        () -> new BlockItem(PADDING_LIME_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_lime_square_stairs",
        () -> new BlockItem(PADDING_LIME_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_LIME_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_lime_square_wall",
        () -> new BlockItem(PADDING_LIME_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_magenta_square_slab",
        () -> new BlockItem(PADDING_MAGENTA_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_magenta_square_stairs",
        () -> new BlockItem(PADDING_MAGENTA_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_MAGENTA_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_magenta_square_wall",
        () -> new BlockItem(PADDING_MAGENTA_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_orange_square_slab",
        () -> new BlockItem(PADDING_ORANGE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_orange_square_stairs",
        () -> new BlockItem(PADDING_ORANGE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_ORANGE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_orange_square_wall",
        () -> new BlockItem(PADDING_ORANGE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_pink_square_slab",
        () -> new BlockItem(PADDING_PINK_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_pink_square_stairs",
        () -> new BlockItem(PADDING_PINK_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PINK_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_pink_square_wall",
        () -> new BlockItem(PADDING_PINK_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_purple_square_slab",
        () -> new BlockItem(PADDING_PURPLE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_purple_square_stairs",
        () -> new BlockItem(PADDING_PURPLE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_PURPLE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_purple_square_wall",
        () -> new BlockItem(PADDING_PURPLE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_red_square_slab",
        () -> new BlockItem(PADDING_RED_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_red_square_stairs",
        () -> new BlockItem(PADDING_RED_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_RED_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_red_square_wall",
        () -> new BlockItem(PADDING_RED_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_white_square_slab",
        () -> new BlockItem(PADDING_WHITE_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_white_square_stairs",
        () -> new BlockItem(PADDING_WHITE_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_WHITE_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_white_square_wall",
        () -> new BlockItem(PADDING_WHITE_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_SQUARE_SLAB_ITEM = AVPRItems.registerItem(
        "padding_yellow_square_slab",
        () -> new BlockItem(PADDING_YELLOW_SQUARE_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_SQUARE_STAIRS_ITEM = AVPRItems.registerItem(
        "padding_yellow_square_stairs",
        () -> new BlockItem(PADDING_YELLOW_SQUARE_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> PADDING_YELLOW_SQUARE_WALL_ITEM = AVPRItems.registerItem(
        "padding_yellow_square_wall",
        () -> new BlockItem(PADDING_YELLOW_SQUARE_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_CUT_SLAB_ITEM = AVPRItems.registerItem(
        "steel_cut_slab",
        () -> new BlockItem(STEEL_CUT_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_CUT_STAIRS_ITEM = AVPRItems.registerItem(
        "steel_cut_stairs",
        () -> new BlockItem(STEEL_CUT_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_CUT_WALL_ITEM = AVPRItems.registerItem(
        "steel_cut_wall",
        () -> new BlockItem(STEEL_CUT_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "steel_plated_chevron_slab",
        () -> new BlockItem(STEEL_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "steel_plated_chevron_stairs",
        () -> new BlockItem(STEEL_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "steel_plated_chevron_wall",
        () -> new BlockItem(STEEL_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "steel_plated_slab",
        () -> new BlockItem(STEEL_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "steel_plated_stairs",
        () -> new BlockItem(STEEL_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> STEEL_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "steel_plated_wall",
        () -> new BlockItem(STEEL_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_CUT_SLAB_ITEM = AVPRItems.registerItem(
        "titanium_cut_slab",
        () -> new BlockItem(TITANIUM_CUT_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_CUT_STAIRS_ITEM = AVPRItems.registerItem(
        "titanium_cut_stairs",
        () -> new BlockItem(TITANIUM_CUT_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_CUT_WALL_ITEM = AVPRItems.registerItem(
        "titanium_cut_wall",
        () -> new BlockItem(TITANIUM_CUT_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_CHEVRON_SLAB_ITEM = AVPRItems.registerItem(
        "titanium_plated_chevron_slab",
        () -> new BlockItem(TITANIUM_PLATED_CHEVRON_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_CHEVRON_STAIRS_ITEM = AVPRItems.registerItem(
        "titanium_plated_chevron_stairs",
        () -> new BlockItem(TITANIUM_PLATED_CHEVRON_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_CHEVRON_WALL_ITEM = AVPRItems.registerItem(
        "titanium_plated_chevron_wall",
        () -> new BlockItem(TITANIUM_PLATED_CHEVRON_WALL.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_SLAB_ITEM = AVPRItems.registerItem(
        "titanium_plated_slab",
        () -> new BlockItem(TITANIUM_PLATED_SLAB.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_STAIRS_ITEM = AVPRItems.registerItem(
        "titanium_plated_stairs",
        () -> new BlockItem(TITANIUM_PLATED_STAIRS.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> TITANIUM_PLATED_WALL_ITEM = AVPRItems.registerItem(
        "titanium_plated_wall",
        () -> new BlockItem(TITANIUM_PLATED_WALL.get(), new Item.Properties())
    );

    public static final Supplier<Item> ORE_BAUXITE_ITEM = AVPRItems.registerItem(
        "ore_bauxite",
        () -> new BlockItem(ORE_BAUXITE.get(), new Item.Properties())
    );

    public static final Supplier<Item> ORE_TITANIUM_ITEM = AVPRItems.registerItem(
        "ore_titanium",
        () -> new BlockItem(ORE_TITANIUM.get(), new Item.Properties())
    );

    public static final Supplier<Item> ORE_SILICA_ITEM = AVPRItems.registerItem(
        "ore_silica",
        () -> new BlockItem(ORE_SILICA.get(), new Item.Properties())
    );

    public static final Supplier<Item> ORE_MONAZITE_ITEM = AVPRItems.registerItem(
        "ore_monazite",
        () -> new BlockItem(ORE_MONAZITE.get(), new Item.Properties())
    );

    public static final Supplier<Item> ORE_LITHIUM_ITEM = AVPRItems.registerItem(
        "ore_lithium",
        () -> new BlockItem(ORE_LITHIUM.get(), new Item.Properties())
    );

    public static final Supplier<Item> ORE_COBALT_ITEM = AVPRItems.registerItem(
        "ore_cobalt",
        () -> new BlockItem(ORE_COBALT.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_WHITE_ITEM = AVPRItems.registerItem(
        "industrial_glass_white",
        () -> new BlockItem(INDUSTRIAL_GLASS_WHITE.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_ORANGE_ITEM = AVPRItems.registerItem(
        "industrial_glass_orange",
        () -> new BlockItem(INDUSTRIAL_GLASS_ORANGE.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_MAGENTA_ITEM = AVPRItems.registerItem(
        "industrial_glass_magenta",
        () -> new BlockItem(INDUSTRIAL_GLASS_MAGENTA.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_LIGHT_BLUE_ITEM = AVPRItems.registerItem(
        "industrial_glass_light_blue",
        () -> new BlockItem(INDUSTRIAL_GLASS_LIGHT_BLUE.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_YELLOW_ITEM = AVPRItems.registerItem(
        "industrial_glass_yellow",
        () -> new BlockItem(INDUSTRIAL_GLASS_YELLOW.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_LIME_ITEM = AVPRItems.registerItem(
        "industrial_glass_lime",
        () -> new BlockItem(INDUSTRIAL_GLASS_LIME.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_PINK_ITEM = AVPRItems.registerItem(
        "industrial_glass_pink",
        () -> new BlockItem(INDUSTRIAL_GLASS_PINK.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_GRAY_ITEM = AVPRItems.registerItem(
        "industrial_glass_gray",
        () -> new BlockItem(INDUSTRIAL_GLASS_GRAY.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_LIGHT_GRAY_ITEM = AVPRItems.registerItem(
        "industrial_glass_light_gray",
        () -> new BlockItem(INDUSTRIAL_GLASS_LIGHT_GRAY.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_CYAN_ITEM = AVPRItems.registerItem(
        "industrial_glass_cyan",
        () -> new BlockItem(INDUSTRIAL_GLASS_CYAN.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_PURPLE_ITEM = AVPRItems.registerItem(
        "industrial_glass_purple",
        () -> new BlockItem(INDUSTRIAL_GLASS_PURPLE.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_BLUE_ITEM = AVPRItems.registerItem(
        "industrial_glass_blue",
        () -> new BlockItem(INDUSTRIAL_GLASS_BLUE.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_BROWN_ITEM = AVPRItems.registerItem(
        "industrial_glass_brown",
        () -> new BlockItem(INDUSTRIAL_GLASS_BROWN.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_GREEN_ITEM = AVPRItems.registerItem(
        "industrial_glass_green",
        () -> new BlockItem(INDUSTRIAL_GLASS_GREEN.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_RED_ITEM = AVPRItems.registerItem(
        "industrial_glass_red",
        () -> new BlockItem(INDUSTRIAL_GLASS_RED.get(), new Item.Properties())
    );

    public static final Supplier<Item> INDUSTRIAL_GLASS_BLACK_ITEM = AVPRItems.registerItem(
        "industrial_glass_black",
        () -> new BlockItem(INDUSTRIAL_GLASS_BLACK.get(), new Item.Properties())
    );

    public static final Supplier<Item> RAW_BAUXITE_BLOCK_ITEM = AVPRItems.registerItem(
        "raw_bauxite_block",
        () -> new BlockItem(RAW_BAUXITE_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<Item> RAW_TITANIUM_BLOCK_ITEM = AVPRItems.registerItem(
        "raw_titanium_block",
        () -> new BlockItem(RAW_TITANIUM_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<Item> NEODYMIUM_BLOCK_ITEM = AVPRItems.registerItem(
        "neodymium_block",
        () -> new BlockItem(NEODYMIUM_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<Item> COBALT_BLOCK_ITEM = AVPRItems.registerItem(
        "cobalt_block",
        () -> new BlockItem(COBALT_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<Item> LITHIUM_BLOCK_ITEM = AVPRItems.registerItem(
        "lithium_block",
        () -> new BlockItem(LITHIUM_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<Item> SILICA_BLOCK_ITEM = AVPRItems.registerItem(
        "silica_block",
        () -> new BlockItem(SILICA_BLOCK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_MAGENTA_ITEM = AVPRItems.registerItem(
        "industrial_wall_magenta",
        () -> new BlockItem(INDUSTRIAL_WALL_MAGENTA.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_BLUE_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_blue",
        () -> new BlockItem(INDUSTRIAL_WALL_LIGHT_BLUE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_YELLOW_ITEM = AVPRItems.registerItem(
        "industrial_wall_yellow",
        () -> new BlockItem(INDUSTRIAL_WALL_YELLOW.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIME_ITEM = AVPRItems.registerItem(
        "industrial_wall_lime",
        () -> new BlockItem(INDUSTRIAL_WALL_LIME.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PINK_ITEM = AVPRItems.registerItem(
        "industrial_wall_pink",
        () -> new BlockItem(INDUSTRIAL_WALL_PINK.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GRAY_ITEM = AVPRItems.registerItem(
        "industrial_wall_gray",
        () -> new BlockItem(INDUSTRIAL_WALL_GRAY.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_LIGHT_GRAY_ITEM = AVPRItems.registerItem(
        "industrial_wall_light_gray",
        () -> new BlockItem(INDUSTRIAL_WALL_LIGHT_GRAY.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_CYAN_ITEM = AVPRItems.registerItem(
        "industrial_wall_cyan",
        () -> new BlockItem(INDUSTRIAL_WALL_CYAN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_PURPLE_ITEM = AVPRItems.registerItem(
        "industrial_wall_purple",
        () -> new BlockItem(INDUSTRIAL_WALL_PURPLE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLUE_ITEM = AVPRItems.registerItem(
        "industrial_wall_blue",
        () -> new BlockItem(INDUSTRIAL_WALL_BLUE.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BROWN_ITEM = AVPRItems.registerItem(
        "industrial_wall_brown",
        () -> new BlockItem(INDUSTRIAL_WALL_BROWN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_GREEN_ITEM = AVPRItems.registerItem(
        "industrial_wall_green",
        () -> new BlockItem(INDUSTRIAL_WALL_GREEN.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_RED_ITEM = AVPRItems.registerItem(
        "industrial_wall_red",
        () -> new BlockItem(INDUSTRIAL_WALL_RED.get(), new Item.Properties())
    );

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_BLACK_ITEM = AVPRItems.registerItem(
        "industrial_wall_black",
        () -> new BlockItem(INDUSTRIAL_WALL_BLACK.get(), new Item.Properties())
    );

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

    public static void initialize() {}
}
