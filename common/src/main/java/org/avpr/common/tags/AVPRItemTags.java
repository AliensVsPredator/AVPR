package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import org.avpr.common.CommonMod;

/**
 * The {@code AVPRItemTags} class contains predefined {@link TagKey} objects for various item categories used in the
 * AVPR (Aliens versus Predator Requiem) mod. These tags are used to group items into specific categories that define
 * their properties, functionalities, and interactions within the mod. They help in managing and referencing specific
 * item types more efficiently.
 */
public record AVPRItemTags() {

    public static final TagKey<Item> ACID_IMMUNE = CommonMod.createTag(Registries.ITEM, "acid_immune");

    public static final TagKey<Item> CASELESS_AMMO = CommonMod.createTag(Registries.ITEM, "caseless_ammo");

    public static final TagKey<Item> CONCRETE = CommonMod.createTag(Registries.ITEM, "concrete");

    public static final TagKey<Item> GUNS = CommonMod.createTag(Registries.ITEM, "guns");

    public static final TagKey<Item> HEAVY_AMMO = CommonMod.createTag(Registries.ITEM, "heavy_ammo");

    public static final TagKey<Item> HEAVY_GUNS = CommonMod.createTag(Registries.ITEM, "heavy_guns");

    public static final TagKey<Item> INDUSTRIAL_GLASS = CommonMod.createTag(Registries.ITEM, "industrial_glass");

    public static final TagKey<Item> MEDIUM_GUNS = CommonMod.createTag(Registries.ITEM, "medium_guns");

    public static final TagKey<Item> PISTOL_AMMO = CommonMod.createTag(Registries.ITEM, "pistol_ammo");

    public static final TagKey<Item> RIFLE_AMMO = CommonMod.createTag(Registries.ITEM, "rifle_ammo");

    public static final TagKey<Item> ROCKET_AMMO = CommonMod.createTag(Registries.ITEM, "rocket_ammo");

    public static final TagKey<Item> SHOTGUN_AMMO = CommonMod.createTag(Registries.ITEM, "shotgun_ammo");

    public static final TagKey<Item> SMALL_GUNS = CommonMod.createTag(Registries.ITEM, "small_guns");

    public static final TagKey<Item> THREATENS_PREDATORS = CommonMod.createTag(Registries.ITEM, "threatens_predators");

    public static final TagKey<Item> UBER_GUNS = CommonMod.createTag(Registries.ITEM, "uber_guns");

    public static final TagKey<Item> PREDARTOR_RANGE_WEAPONS = CommonMod.createTag(Registries.ITEM, "predator_range_weapons");
}
