package org.avpr.common.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import org.avpr.common.CommonMod;
import org.avpr.common.platform.AVPRServices;

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
    }
}
