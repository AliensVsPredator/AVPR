package org.avpr.common.items.armor;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import org.avpr.common.CommonMod;
import org.avpr.common.platform.AVPRServices;
import org.avpr.common.registries.AVPRItems;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class AVPRArmorMaterials {

    public static final Holder<ArmorMaterial> ALUMINUM = register(
            "aluminum",
            SoundEvents.ARMOR_EQUIP_IRON,
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 5);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.BODY, 7);
            }),
            10,
            0,
            0,
            AVPRItems.INGOT_ALUMINUM);

    public static final Holder<ArmorMaterial> MK50 = register(
            "mk50",
            SoundEvents.ARMOR_EQUIP_IRON,
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 3);
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.BODY, 5);
            }),
            6,
            0,
            0,
            () -> Items.COPPER_INGOT);

    public static final Holder<ArmorMaterial> ORIONITE = register(
            "orionite",
            SoundEvents.ARMOR_EQUIP_IRON,
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.BODY, 11);
            }),
            17,
            2.5f,
            0.05f,
            AVPRItems.INGOT_ORIONITE);

    public static final Holder<ArmorMaterial> PRESSURE = register(
            "pressure",
            SoundEvents.ARMOR_EQUIP_IRON,
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 3);
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.BODY, 5);
            }),
            6,
            0,
            0,
            AVPRItems.INGOT_ALUMINUM);

    public static final Holder<ArmorMaterial> TACTICAL = register(
            "tactical",
            SoundEvents.ARMOR_EQUIP_IRON,
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 6);
                attribute.put(ArmorItem.Type.LEGGINGS, 3);
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.BODY, 5);
            }),
            5,
            0,
            0,
            AVPRItems.INGOT_ALUMINUM);

    public static final Holder<ArmorMaterial> TITANIUM = register(
            "titanium",
            SoundEvents.ARMOR_EQUIP_IRON,
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 6);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.BOOTS, 2);
                attribute.put(ArmorItem.Type.BODY, 5);
            }),
            9,
            1,
            0,
            AVPRItems.INGOT_TITANIUM);

    public static final Holder<ArmorMaterial> VERITANIUM = register(
            "veritanium",
            SoundEvents.ARMOR_EQUIP_IRON,
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.CHESTPLATE, 9);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.BODY, 11);
            }),
            0,
            5,
            0,
            AVPRItems.VERITANIUM_SHARD);

    public static final Holder<ArmorMaterial> XENOMORPH_CHITIN = register(
            "xenomorph_chitin",
            SoundEvents.ARMOR_EQUIP_IRON,
            Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
                attribute.put(ArmorItem.Type.HELMET, 2);
                attribute.put(ArmorItem.Type.CHESTPLATE, 7);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.BODY, 11);
            }),
            7,
            1,
            0,
            AVPRItems.XENO_CHITIN);

    /**
     * Example usage:
     * <pre>{@code
     *
     *     // Register a new armor material named "steel_armor" with custom properties
     *     Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_IRON; // Example equip sound
     *     Holder<ArmorMaterial> steelArmor = register(
     *         "steel_armor",
     *         SoundEvents.ARMOR_EQUIP_IRON,
     *         Util.make(new EnumMap<>(ArmorItem.Type.class), attribute -> {
     *                 attribute.put(ArmorItem.Type.BOOTS, 5);
     *                 attribute.put(ArmorItem.Type.LEGGINGS, 7);
     *                 attribute.put(ArmorItem.Type.CHESTPLATE, 9);
     *                 attribute.put(ArmorItem.Type.HELMET, 5);
     *                 attribute.put(ArmorItem.Type.BODY, 11);
     *         }),
     *         15,
     *         1.0f,
     *         0.1f,
     *         () -> Items.IRON_INGOT
     *     );
     * }</pre>
     * This example registers an armor material named "steel_armor" with specified protection levels, enchantability, toughness,
     * and knockback resistance, using an iron ingot as the repair material.
     * See {@link ArmorMaterials} for vanilla values
     * <p>
     * Registers a custom {@link ArmorMaterial} with the specified properties.
     *
     * @param name                The unique name of the armor material. Used for registry purposes.
     * @param equipSound          A {@link Holder} of the {@link SoundEvent} that plays when the armor is equipped.
     * @param typeProtection      An {@link EnumMap} containing the protection values for each {@link ArmorItem.Type}.
     *                            The keys are the armor types (HELMET, CHESTPLATE, LEGGINGS, BOOTS), and the values are the respective protection levels.
     * @param enchantability      The enchantability value of the armor, affecting the likelihood of receiving better enchantments.
     * @param toughness           The toughness value of the armor, which affects how much damage is reduced.
     * @param knockbackResistance The knockback resistance of the armor, which reduces the distance the player is knocked back when hit.
     * @param ingredientItem      A {@link Supplier} for the {@link Item} used to repair the armor.
     * @return A {@link Holder} of the registered {@link ArmorMaterial}.
     */
    private static Holder<ArmorMaterial> register(String name, Holder<SoundEvent> equipSound, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        var location = CommonMod.modResource(name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        var layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values())
            typeMap.put(type, typeProtection.get(type));

        return AVPRServices.COMMON_REGISTRY.registerArmorMaterial(CommonMod.MOD_ID, name,
                () -> new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness,
                knockbackResistance));
    }
}
