package org.avpr.fabric.item.armor;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import org.avpr.common.CommonMod;
import org.avpr.common.registries.AVPRItems;

public class AVPRFabricArmorMaterials {

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
        AVPRItems.INGOT_ALUMINUM
    );

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
        () -> Items.COPPER_INGOT
    );

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
        AVPRItems.INGOT_ORIONITE
    );

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
        AVPRItems.INGOT_ALUMINUM
    );

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
        AVPRItems.INGOT_ALUMINUM
    );

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
        AVPRItems.INGOT_TITANIUM
    );

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
        AVPRItems.VERITANIUM_SHARD
    );

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
        AVPRItems.XENO_CHITIN
    );

    public static Holder<ArmorMaterial> register(
        String name,
        Holder<SoundEvent> equipSound,
        EnumMap<ArmorItem.Type, Integer> typeProtection,
        int enchantability,
        float toughness,
        float knockbackResistance,
        Supplier<Item> ingredientItem
    ) {
        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values())
            typeMap.put(type, typeProtection.get(type));

        return Registry.registerForHolder(
            BuiltInRegistries.ARMOR_MATERIAL,
            CommonMod.modResource(name),
            new ArmorMaterial(
                typeProtection,
                enchantability,
                equipSound,
                () -> Ingredient.of(ingredientItem.get()),
                List.of(new ArmorMaterial.Layer(CommonMod.modResource(name))),
                toughness,
                knockbackResistance
            )
        );
    }
}
