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
                    .title(Component.translatable("tab." + CommonMod.MOD_ID + ".items"))
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
                    .build());

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
                    .build());

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
                    .build());

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
                    .build());

    public static void initialize() {
    }
}
