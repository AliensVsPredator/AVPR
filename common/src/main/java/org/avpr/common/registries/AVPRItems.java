package org.avpr.common.registries;

import net.minecraft.core.Holder;
import net.minecraft.world.item.*;
import org.avpr.common.CommonMod;
import org.avpr.common.api.common.ArmorProperties;
import org.avpr.common.items.armor.AVPRArmorItem;
import org.avpr.common.items.armor.AVPRArmorMaterials;
import org.avpr.common.platform.AVPRServices;

import java.util.*;
import java.util.function.Supplier;

public class AVPRItems {

    public static final Supplier<BlockItem> RESIN_BLOCK_ITEM = AVPRItems.registerItem(
            "resin", () -> new BlockItem(AVPRBlocks.RESIN_BLOCK.get(), new Item.Properties()));

    public static final Supplier<BlockItem> RESIN_VEIN_BLOCK_ITEM = AVPRItems.registerItem(
            "resin_vein", () -> new BlockItem(AVPRBlocks.RESIN_VEIN_BLOCK.get(), new Item.Properties()));

    public static final Supplier<BlockItem> RESIN_WEBBING_BLOCK_ITEM = AVPRItems.registerItem(
            "resin_webbing", () -> new BlockItem(AVPRBlocks.RESIN_WEBBING_BLOCK.get(), new Item.Properties()));

    public static final Supplier<BlockItem> ORIONITE_BLOCK_ITEM = AVPRItems.registerItem(
            "orionite_block", () -> new BlockItem(AVPRBlocks.ORIONITE_BLOCK.get(), new Item.Properties()));

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_ITEM = AVPRItems.registerItem(
            "industrial_wall", () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL.get(), new Item.Properties()));

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_SLAB_ITEM = AVPRItems.registerItem(
            "industrial_wall_slab", () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_SLAB.get(), new Item.Properties()));

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_STAIRS_ITEM = AVPRItems.registerItem(
            "industrial_wall_stairs", () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_STAIRS.get(), new Item.Properties()));

    public static final Supplier<BlockItem> INDUSTRIAL_WALL_WALL_ITEM = AVPRItems.registerItem(
            "industrial_wall_wall", () -> new BlockItem(AVPRBlocks.INDUSTRIAL_WALL_WALL.get(), new Item.Properties()));

    public static final Supplier<BlockItem> SOLAR_PANEL_ITEM = AVPRItems.registerItem(
            "solar_panel", () -> new BlockItem(AVPRBlocks.SOLAR_PANEL.get(), new Item.Properties()));


    public static final Supplier<SpawnEggItem> OVAMORPH_SPAWN_EGG = AVPRItems.registerItem(
            "spawn_egg_ovamorph",
            AVPRServices.COMMON_REGISTRY.makeSpawnEggFor(
                    AVPREntities.OVAMORPH,
                    0x615B45,
                    0xBF7872,
                    new Item.Properties()));


    public static final Supplier<SpawnEggItem> FACEHUGGER_SPAWN_EGG = AVPRItems.registerItem(
            "spawn_egg_facehugger",
            AVPRServices.COMMON_REGISTRY.makeSpawnEggFor(
                    AVPREntities.FACEHUGGER,
                    0xE4D597,
                    0xA55863,
                    new Item.Properties()));

    public static final Supplier<Item> XENO_CHITIN = AVPRItems.registerItem(
            "xenomorph_chitin",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> VERITANIUM_SHARD = AVPRItems.registerItem(
            "veritanium_shard",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> INGOT_ALUMINUM = AVPRItems.registerItem(
            "ingot_aluminum",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> INGOT_ORIONITE = AVPRItems.registerItem(
            "ingot_orionite",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> INGOT_STEEL = AVPRItems.registerItem(
            "ingot_steel",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> INGOT_TITANIUM = AVPRItems.registerItem(
            "ingot_titanium",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> DUST_LITHIUM = AVPRItems.registerItem(
            "dust_lithium",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> COLBALT = AVPRItems.registerItem(
            "cobalt",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> CARBON = AVPRItems.registerItem(
            "carbon",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> LASER_MINE = AVPRItems.registerItem(
            "laser_mine",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> NBT_DRIVE = AVPRItems.registerItem(
            "nbt_drive",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> NEODYMIUM = AVPRItems.registerItem(
            "neodymium",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> NEODYMIUM_MAGENT = AVPRItems.registerItem(
            "neodymium_magnet",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> POLYCARBONATE = AVPRItems.registerItem(
            "polycarbonate",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> POLYMER = AVPRItems.registerItem(
            "polymer",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> RAW_BAUXITE = AVPRItems.registerItem(
            "raw_bauxite",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> RAW_TITANIUM = AVPRItems.registerItem(
            "raw_titanium",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> RESIN_BALL = AVPRItems.registerItem(
            "resin_ball",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> ROYAL_JELLY = AVPRItems.registerItem(
            "royal_jelly",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> SHEET_ORIONITE = AVPRItems.registerItem(
            "sheet_orionite",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> SHURIKEN = AVPRItems.registerItem(
            "shuriken",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> SILICA = AVPRItems.registerItem(
            "silica",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> SMART_DISC = AVPRItems.registerItem(
            "smart_disc",
            () -> new Item(new Item.Properties()));

    public static final Supplier<Item> YAUTJA_ARTIFCAT = AVPRItems.registerItem(
            "yautja_artifact",
            () -> new Item(new Item.Properties()));

    private static final Map<Holder<ArmorMaterial>, ArmorProperties> ARMOR_PROPERTIES = Map.of(
            AVPRArmorMaterials.ALUMINUM, new ArmorProperties("aluminum", 14),
            AVPRArmorMaterials.MK50, new ArmorProperties("mk50", 24),
            AVPRArmorMaterials.ORIONITE, new ArmorProperties("orionite", 35),
            AVPRArmorMaterials.PRESSURE, new ArmorProperties("pressure", 22),
            AVPRArmorMaterials.TACTICAL, new ArmorProperties("tactical", 26),
            AVPRArmorMaterials.TITANIUM, new ArmorProperties("titanium", 24),
            AVPRArmorMaterials.VERITANIUM, new ArmorProperties("veritanium", 34),
            AVPRArmorMaterials.XENOMORPH_CHITIN, new ArmorProperties("xenomorph_chitin", 30)
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
        return ARMOR_ITEMS.values().stream()
                .flatMap(enumMap -> enumMap.values().stream())
                .filter(Objects::nonNull)
                .toList();
    }

    /**
     * Example of using this Interface to create a new Item:
     * <p>
     * The following code demonstrates how to register a new item and a spawn egg in the game:
     * </p>
     * <pre>{@code
     * public static final Supplier<Item> TEST_ITEM = AVPRItems.registerItem("itemname", () -> new Item(new Item.Properties()));
     * public static final Supplier<SpawnEggItem> TEST_SPAWN_EGG = AVPRItems.registerItem("entityname_spawn_egg", AVPRServices.COMMON_REGISTRY.makeSpawnEggFor(TESTENTITY, 0x1F1F1F, 0x0D0D0D, new Item.Properties()));
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerItem</code> is a method to register a new item with the specified item name.</li>
     * <li><code>Item</code> is used to create a new item instance with default properties.</li>
     * <li><code>makeSpawnEggFor</code> is a method to create a spawn egg for the specified entity with primary and secondary colors.</li>
     * </ul>
     * <p>
     * The {@link Item Item} class represents an item in the game.
     * </p>
     * <p>
     * The {@link net.minecraft.world.item.SpawnEggItem SpawnEggItem} class represents a spawn egg in the game.
     * </p>
     *
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
