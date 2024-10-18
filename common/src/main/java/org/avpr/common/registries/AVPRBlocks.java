package org.avpr.common.registries;

import com.mojang.datafixers.util.Pair;
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
import org.avpr.common.CommonMod;
import org.avpr.common.api.common.*;
import org.avpr.common.blocks.AVPRStairBlock;
import org.avpr.common.blocks.ColoredTransparentBlock;
import org.avpr.common.blocks.ResinVeinBlock;
import org.avpr.common.blocks.ResinWebbingBlock;
import org.avpr.common.platform.AVPRServices;

import java.util.*;
import java.util.function.Supplier;

public class AVPRBlocks {

    public static final Supplier<Block> RESIN_BLOCK = AVPRBlocks.registerBlock("resin",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(
                            Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)
                    .noOcclusion()));

    public static final Supplier<ResinVeinBlock> RESIN_VEIN_BLOCK = AVPRBlocks.registerBlock("resin_vein",
            () -> new ResinVeinBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.COLOR_GRAY)
                            .replaceable()
                            .noCollission()
                            .randomTicks()
                            .strength(0.2F)
                            .sound(SoundType.VINE)
                            .ignitedByLava()
                            .pushReaction(PushReaction.DESTROY)));

    public static final Supplier<ResinWebbingBlock> RESIN_WEBBING_BLOCK = AVPRBlocks.registerBlock("resin_webbing",
            ResinWebbingBlock::new);

    public static final Supplier<Block> ORIONITE_BLOCK = AVPRBlocks.registerBlock("orionite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER)
                    .strength(4, 6)));

    public static final Supplier<Block> INDUSTRIAL_WALL = AVPRBlocks.registerBlock("industrial_wall",
            ResinWebbingBlock::new);

    public static final Supplier<Block> INDUSTRIAL_WALL_SLAB = AVPRBlocks.registerBlock("industrial_wall_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final Supplier<Block> INDUSTRIAL_WALL_STAIRS = AVPRBlocks.registerBlock("industrial_wall_stairs",
            () -> new AVPRStairBlock(INDUSTRIAL_WALL.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final Supplier<Block> INDUSTRIAL_WALL_WALL = AVPRBlocks.registerBlock("industrial_wall_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final Supplier<Block> SOLAR_PANEL = AVPRBlocks.registerBlock("solar_panel",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> UNIDENTIFIED_DIRT = AVPRBlocks.registerBlock("unidentified_dirt",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> UNIDENTIFIED_GRAVEL = AVPRBlocks.registerBlock("unidentified_gravel",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> UNIDENTIFIED_ROCK = AVPRBlocks.registerBlock("unidentified_rock",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> UNIDENTIFIED_SAND = AVPRBlocks.registerBlock("unidentified_sand",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> UNIDENTIFIED_STONE = AVPRBlocks.registerBlock("unidentified_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> YAUTJA_SHIP_BRICK = AVPRBlocks.registerBlock("yautja_ship_brick",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> YAUTJA_SHIP_BRICK_SLAB = AVPRBlocks.registerBlock("yautja_ship_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> YAUTJA_SHIP_BRICK_STAIRS = AVPRBlocks.registerBlock("yautja_ship_brick_stairs",
            () -> new AVPRStairBlock(YAUTJA_SHIP_BRICK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> YAUTJA_SHIP_BRICK_WALL = AVPRBlocks.registerBlock("yautja_ship_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .mapColor(MapColor.COLOR_GRAY)));

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_1 = AVPRBlocks.registerBlock("yautja_ship_decor_1",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)));

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_2 = AVPRBlocks.registerBlock("yautja_ship_decor_2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)
                    .lightLevel($0 -> 10)));

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_3 = AVPRBlocks.registerBlock("yautja_ship_decor_3",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)
                    .lightLevel(($0) -> 8)));

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_3_SLAB = AVPRBlocks.registerBlock("yautja_ship_decor_3_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)
                    .lightLevel(($0) -> 8)));

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_3_STAIRS = AVPRBlocks.registerBlock("yautja_ship_decor_3_stairs",
            () -> new AVPRStairBlock(YAUTJA_SHIP_DECOR_3.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)
                    .lightLevel(($0) -> 8)));

    public static final Supplier<Block> YAUTJA_SHIP_DECOR_3_WALL = AVPRBlocks.registerBlock("yautja_ship_decor_3_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)
                    .lightLevel(($0) -> 8)));

    public static final Supplier<Block> YAUTJA_SHIP_PANEL = AVPRBlocks.registerBlock("yautja_ship_panel",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)
                    .lightLevel(($0) -> 6)));

    public static final Supplier<Block> YAUTJA_SHIP_SUPPORT_PILLAR = AVPRBlocks.registerBlock("yautja_ship_support_pillar",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)
                    .lightLevel(($0) -> 8)));

    public static final Supplier<Block> YAUTJA_SHIP_WALL_BASE = AVPRBlocks.registerBlock("yautja_ship_wall_base",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .strength(75, 1500)
                    .lightLevel(($0) -> 4)));

    private static final Map<DyeColor, Block> INDUSTRIAL_GLASS_BLOCKS = new EnumMap<>(DyeColor.class);
    private static final Map<DyeColor, Item> INDUSTRIAL_GLASS_ITEMS = new EnumMap<>(DyeColor.class);
    private static final Map<OreType, Block> ORE_BLOCKS = new EnumMap<>(OreType.class);
    private static final Map<OreType, Item> ORE_ITEMS = new EnumMap<>(OreType.class);
    private static final Map<RawBlockType, Block> RAW_BLOCKS = new EnumMap<>(RawBlockType.class);
    private static final Map<RawBlockType, Item> RAW_ITEMS = new EnumMap<>(RawBlockType.class);
    private static final Map<NormalBlockType, Block> NORMAL_BLOCKS = new EnumMap<>(NormalBlockType.class);
    private static final Map<NormalBlockType, Item> NORMAL_ITEMS = new EnumMap<>(NormalBlockType.class);
    private static final Map<RawBlockType, OreProperties> RAW_PROPERTIES = Map.of(
            RawBlockType.BAUXITE, new OreProperties("bauxite", 3.2F, 2.6F),
            RawBlockType.TITANIUM, new OreProperties("titanium", 4.0F, 4.0F)
    );
    private static final Map<NormalBlockType, OreProperties> NORMAL_PROPERTIES = Map.of(
            NormalBlockType.NEODYMIUM, new OreProperties("neodymium", 3.2F, 2.6F),
            NormalBlockType.COBALT, new OreProperties("cobalt", 3.2F, 2.6F),
            NormalBlockType.TITANIUM, new OreProperties("titanium", 4.0F, 4.0F),
            NormalBlockType.LITHIUM, new OreProperties("lithium", 4.0F, 4.0F),
            NormalBlockType.SILICA, new OreProperties("silica", 2.2F, 1.4F)
    );
    private static final Map<OreType, OreProperties> ORE_PROPERTIES = Map.of(
            OreType.BAUXITE, new OreProperties("ore_bauxite", 3.2F, 2.6F),
            OreType.TITANIUM, new OreProperties("ore_titanium", 4.0F, 4.0F),
            OreType.SILICA, new OreProperties("ore_silica", 2.2F, 1.4F),
            OreType.MONAZITE, new OreProperties("ore_monazite", 45F, 15F),
            OreType.LITHIUM, new OreProperties("ore_lithium", 4.2F, 5.4F),
            OreType.COBALT, new OreProperties("ore_cobalt", 50F, 20F)
    );
    private static final Map<Pair<MetalType, String>, Block> METAL_BLOCKS = new HashMap<>();
    private static final Map<Pair<MetalType, String>, Item> METAL_ITEMS = new HashMap<>();
    private static final List<String> VARIATIONS = List.of("block", "grate", "vent", "panel", "plated", "plated_chevron","cut", "slab",
            "stairs", "wall");
    private static final Map<DyeColor, Block> PLASTIC_BLOCKS = new EnumMap<>(DyeColor.class);
    private static final Map<DyeColor, Item> PLASTIC_ITEMS = new EnumMap<>(DyeColor.class);
    private static final Map<DyeColor, Block> PADDING_BLOCKS = new EnumMap<>(DyeColor.class);
    private static final Map<DyeColor, Item> PADDING_ITEMS = new EnumMap<>(DyeColor.class);
    private static final List<String> PADDING_VARIATIONS = List.of("panel", "pipes", "square", "tiles");
    private static final List<String> PLASTIC_VARIATIONS = List.of("slab", "stairs", "wall");

    public static void registerMetalBlocks() {
        Arrays.stream(MetalType.values()).forEach(metalType -> VARIATIONS.forEach(variation -> {
            if (variation.equals("block") && (metalType == MetalType.COPPER
                    || metalType == MetalType.GOLD
                    || metalType == MetalType.IRON
                    || metalType == MetalType.NETHERITE)) {
                return;
            }

            Supplier<Block> blockSupplier = null;

            switch (variation) {
                case "slab" -> {
                    if (METAL_BLOCKS.containsKey(new Pair<>(metalType, "cut")) ||
                            METAL_BLOCKS.containsKey(new Pair<>(metalType, "plated")) ||
                            METAL_BLOCKS.containsKey(new Pair<>(metalType, "plated_chevron"))) {
                        Block baseBlock = METAL_BLOCKS.get(new Pair<>(metalType, variation));
                        if (baseBlock != null) {
                            blockSupplier = AVPRBlocks.registerBlock(
                                    metalType.name().toLowerCase(Locale.ROOT) + "_slab",
                                    () -> new SlabBlock(BlockBehaviour.Properties.of()
                                            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                                            .mapColor(MapColor.COLOR_LIGHT_GRAY)
                                            .requiresCorrectToolForDrops()
                                            .sound(SoundType.COPPER)
                                            .noOcclusion()
                                            .strength(4, 6))
                            );
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                case "stairs" -> {
                    if (METAL_BLOCKS.containsKey(new Pair<>(metalType, "cut")) ||
                            METAL_BLOCKS.containsKey(new Pair<>(metalType, "plated")) ||
                            METAL_BLOCKS.containsKey(new Pair<>(metalType, "plated_chevron"))) {
                        Block baseBlock = METAL_BLOCKS.get(new Pair<>(metalType, variation));
                        if (baseBlock != null) {
                            blockSupplier = AVPRBlocks.registerBlock(
                                    metalType.name().toLowerCase(Locale.ROOT) + "_stairs",
                                    () -> new AVPRStairBlock(
                                            baseBlock.defaultBlockState(),
                                            BlockBehaviour.Properties.of()
                                                    .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                                                    .mapColor(MapColor.COLOR_LIGHT_GRAY)
                                                    .requiresCorrectToolForDrops()
                                                    .sound(SoundType.COPPER)
                                                    .noOcclusion()
                                                    .strength(4, 6))
                            );
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                case "wall" -> {
                    // Only register stairs if the variation is "cut" or "plated".
                    if (METAL_BLOCKS.containsKey(new Pair<>(metalType, "cut")) ||
                            METAL_BLOCKS.containsKey(new Pair<>(metalType, "plated")) ||
                            METAL_BLOCKS.containsKey(new Pair<>(metalType, "plated_chevron"))) {
                        Block baseBlock = METAL_BLOCKS.get(new Pair<>(metalType, variation));
                        if (baseBlock != null) {
                            blockSupplier = AVPRBlocks.registerBlock(
                                    metalType.name().toLowerCase(Locale.ROOT) + "_wall",
                                    () -> new WallBlock(BlockBehaviour.Properties.of()
                                            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                                            .mapColor(MapColor.COLOR_LIGHT_GRAY)
                                            .requiresCorrectToolForDrops()
                                            .sound(SoundType.COPPER)
                                            .noOcclusion()
                                            .strength(4, 6))
                            );
                        }
                    } else {
                        return;
                    }
                }
                default -> blockSupplier = AVPRBlocks.registerBlock(
                        metalType.name().toLowerCase(Locale.ROOT) + "_" + variation,
                        () -> new Block(BlockBehaviour.Properties.of()
                                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                                .mapColor(MapColor.COLOR_LIGHT_GRAY)
                                .requiresCorrectToolForDrops()
                                .sound(SoundType.COPPER)
                                .noOcclusion()
                                .strength(4, 6))
                );
            }

            if (blockSupplier != null) {
                METAL_BLOCKS.put(new Pair<>(metalType, variation), blockSupplier.get());

                Supplier<Block> finalBlockSupplier = blockSupplier;
                Supplier<Item> itemSupplier = AVPRItems.registerItem(
                        metalType.name().toLowerCase(Locale.ROOT) + "_" + variation,
                        () -> new BlockItem(finalBlockSupplier.get(), new Item.Properties())
                );
                METAL_ITEMS.put(new Pair<>(metalType, variation), itemSupplier.get());
            }
        }));
    }
    
    public static void registerOres() {
        ORE_PROPERTIES.forEach((oreType, properties) -> {
            Supplier<Block> blockSupplier = AVPRBlocks.registerBlock(
                    properties.name().toLowerCase(Locale.ROOT),
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                            .noOcclusion()
                            .strength(properties.hardness(), properties.resistance()))
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

    public static void registerPlasticBlocks() {
        Arrays.stream(DyeColor.values()).forEach(dyeColor ->
                PLASTIC_VARIATIONS.forEach(variation -> {
                            Supplier<Block> blockSupplier = null;
                            switch (variation) {
                                case "slab" -> blockSupplier = AVPRBlocks.registerBlock(
                                        "plastic_" + dyeColor.getName().toLowerCase(Locale.ROOT) + "_slab",
                                        () -> new SlabBlock(BlockBehaviour.Properties.of()
                                                .mapColor(dyeColor)
                                                .requiresCorrectToolForDrops()
                                                .sound(SoundType.STONE)
                                                .noOcclusion()
                                                .strength(9, 10))
                                );
                                case "stairs" -> {
                                    Block baseBlock = PLASTIC_BLOCKS.get(dyeColor);
                                    blockSupplier = AVPRBlocks.registerBlock(
                                        "plastic_" + dyeColor.getName().toLowerCase(Locale.ROOT) + "_stairs",
                                        () -> new AVPRStairBlock(baseBlock.defaultBlockState(), BlockBehaviour.Properties.of()
                                                .mapColor(dyeColor)
                                                .requiresCorrectToolForDrops()
                                                .sound(SoundType.STONE)
                                                .noOcclusion()
                                                .strength(9, 10))
                                );
                                }
                                case "wall" -> blockSupplier = AVPRBlocks.registerBlock(
                                        "plastic_" + dyeColor.getName().toLowerCase(Locale.ROOT) + "_wall",
                                        () -> new WallBlock(BlockBehaviour.Properties.of()
                                                .mapColor(dyeColor)
                                                .requiresCorrectToolForDrops()
                                                .sound(SoundType.STONE)
                                                .noOcclusion()
                                                .strength(9, 10))
                                );
                                default -> blockSupplier = AVPRBlocks.registerBlock(
                                        "plastic_" + dyeColor.getName().toLowerCase(Locale.ROOT),
                                        () -> new Block(BlockBehaviour.Properties.of()
                                                .mapColor(dyeColor)
                                                .requiresCorrectToolForDrops()
                                                .sound(SoundType.STONE)
                                                .noOcclusion()
                                                .strength(9, 10))
                                );
                            }

                            if (blockSupplier != null) {
                                PLASTIC_BLOCKS.put(dyeColor, blockSupplier.get());

                                Supplier<Block> finalBlockSupplier = blockSupplier;
                                Supplier<Item> itemSupplier = AVPRItems.registerItem(
                                        "plastic_" + dyeColor.name().toLowerCase(Locale.ROOT) + "_" + variation,
                                        () -> new BlockItem(finalBlockSupplier.get(), new Item.Properties())
                                );
                                PLASTIC_ITEMS.put(dyeColor, itemSupplier.get());
                            }
                        }
                )
        );
    }

    public static void registerPaddingBlocks() {
        Arrays.stream(DyeColor.values()).forEach(dyeColor ->
                PADDING_VARIATIONS.forEach(variation -> {
                            Supplier<Block> blockSupplier = null;
                            switch (variation) {
                                case "panel" -> blockSupplier = AVPRBlocks.registerBlock(
                                        "padding_" + dyeColor.getName().toLowerCase(Locale.ROOT) + "_panel",
                                        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                                                .mapColor(dyeColor))
                                );
                                case "pipes" -> blockSupplier = AVPRBlocks.registerBlock(
                                        "padding_" + dyeColor.getName().toLowerCase(Locale.ROOT) + "_pipes",
                                        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                                                .mapColor(dyeColor))
                                );
                                case "square" -> blockSupplier = AVPRBlocks.registerBlock(
                                        "padding_" + dyeColor.getName().toLowerCase(Locale.ROOT) + "_square",
                                        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                                                .mapColor(dyeColor))
                                );
                                case "tiles" -> blockSupplier = AVPRBlocks.registerBlock(
                                        "padding_" + dyeColor.getName().toLowerCase(Locale.ROOT) + "_tiles",
                                        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)
                                                .mapColor(dyeColor))
                                );
                            }

                            if (blockSupplier != null) {
                                PADDING_BLOCKS.put(dyeColor, blockSupplier.get());

                                Supplier<Block> finalBlockSupplier = blockSupplier;
                                Supplier<Item> itemSupplier = AVPRItems.registerItem(
                                        "padding_" + dyeColor.name().toLowerCase(Locale.ROOT) + "_" + variation,
                                        () -> new BlockItem(finalBlockSupplier.get(), new Item.Properties())
                                );
                                PADDING_ITEMS.put(dyeColor, itemSupplier.get());
                            }
                        }
                )
        );
    }

    public static void registerRawBlocks() {
        RAW_PROPERTIES.forEach((rawBlockType, properties) -> {
            Supplier<Block> blockSupplier = AVPRBlocks.registerBlock(
                    "raw_" + properties.name().toLowerCase(Locale.ROOT) + "_block",
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                            .strength(properties.hardness(), properties.resistance()))
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
                    () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                            .strength(properties.hardness(), properties.resistance()))
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

    public static Block getPaddingBlock(DyeColor dyeColor) {
        return PADDING_BLOCKS.get(dyeColor);
    }

    public static Item getPaddingItem(DyeColor dyeColor) {
        return PADDING_ITEMS.get(dyeColor);
    }

    public static List<Item> getAllPaddingItems() {
        return Arrays.stream(DyeColor.values())
                .map(AVPRBlocks::getPaddingItem)
                .toList();
    }

    public static List<Block> getAllPaddingBlocks() {
        return Arrays.stream(DyeColor.values())
                .map(AVPRBlocks::getPaddingBlock)
                .toList();
    }

    public static Block getPlasticBlock(DyeColor dyeColor) {
        return PLASTIC_BLOCKS.get(dyeColor);
    }

    public static Item getPlasticItem(DyeColor dyeColor) {
        return PLASTIC_ITEMS.get(dyeColor);
    }

    public static List<Item> getAllPlasticItems() {
        return Arrays.stream(DyeColor.values())
                .map(AVPRBlocks::getPlasticItem)
                .toList();
    }

    public static List<Block> getAllPlasticBlocks() {
        return Arrays.stream(DyeColor.values())
                .map(AVPRBlocks::getPlasticBlock)
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

    public static Block getMetalBlock(MetalType metalType, String variation) {
        return METAL_BLOCKS.get(new Pair<>(metalType, variation));
    }

    public static Item getMetalItem(MetalType metalType, String variation) {
        return METAL_ITEMS.get(new Pair<>(metalType, variation));
    }

    public static List<Item> getAllMetalItems() {
        return METAL_ITEMS.values().stream()
                .filter(Objects::nonNull) // Filter out any null values.
                .toList();
    }

    public static List<Block> getAllMetalBlocks() {
        return METAL_BLOCKS.values().stream()
                .filter(Objects::nonNull)
                .toList();
    }

    /**
     * Example of using this method to create a new Block:
     * <p>
     * The following code demonstrates how to register a new block in the game:
     * </p>
     * <pre>{@code
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
     * <pre>{@code
     * public static final Supplier<BlockEntityType<TestBlockEntity>> TEST_BLOCKENTITY = CommonBlockEntityRegistryInterface.registerBlockEntity("modid", "blockentityname", () -> BlockEntityType.Builder.of(TestBlockEntity::new, TEST_BLOCK.get()).build(null));
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerBlockEntity</code> is a method to register a new block entity with the specified mod ID and block entity name.</li>
     * <li><code>TestBlockEntity::new</code> is a reference to the constructor of the <code>TestBlockEntity</code> class.</li>
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
    static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String modID, String blockEntityName, Supplier<BlockEntityType<T>> blockEntity) {
        return AVPRServices.COMMON_REGISTRY.registerBlockEntity(modID, blockEntityName, blockEntity);
    }

    public static void initialize() {
        AVPRBlocks.registerNormalBlocks();
        AVPRBlocks.registerRawBlocks();
        AVPRBlocks.registerGlassBlocks();
        AVPRBlocks.registerOres();
        AVPRBlocks.registerMetalBlocks();
        AVPRBlocks.registerPlasticBlocks();
        AVPRBlocks.registerPaddingBlocks();
        /*
            TODO: Paradise Blocks, Temple, Engineer Ship
         */
    }
}
