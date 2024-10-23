package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import org.avpr.common.CommonMod;

/**
 * The {@code AVPREntityTags} class contains static definitions of tag keys for various entity types used in the AVPR
 * (Aliens versus Predator Requiem) mod. These tags categorize entities based on their characteristics and behaviors
 * within the mod. ACID_IMMUNE indicates entities that are immune to acid damage. ALIENS represents entities categorized
 * as aliens. HOSTS signifies entities that can host other entities. RUNNER_HOSTS are a specific type of host entities.
 * ENGINEERS designates entities that are classified as engineers. PREDATORS indicates entities classified as predators.
 * PARASITES represents entities that are parasitic in nature. NOT_WORTH_KILLING categorizes entities that are not
 * valuable targets. MONSTERS designates entities classified as monsters. MEDIUM_GUNS_IMMUNE indicates entities that are
 * immune to medium firearms. HIVE_ALIENS represents alien entities that are part of a hive. HEAVY_GUNS_IMMUNE indicates
 * entities that are immune to heavy firearms. EGGS represents entities categorized as eggs. ACID_BLEEDERS indicates
 * entities that bleed acid. SMALL_GUNS_IMMUNE signifies entities that are immune to small firearms. ROYAL_ALIENS
 * designates entities that are considered royal aliens. PRODUCES_RESIN represents entities that produce resin.
 */
public record AVPREntityTags() {

    public static final TagKey<EntityType<?>> ACID_IMMUNE = CommonMod.createTag(Registries.ENTITY_TYPE, "acid_immune");

    public static final TagKey<EntityType<?>> ALIENS = CommonMod.createTag(Registries.ENTITY_TYPE, "aliens");

    public static final TagKey<EntityType<?>> HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "hosts");

    public static final TagKey<EntityType<?>> RUNNER_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "runner_hosts");

    public static final TagKey<EntityType<?>> ENGINEERS = CommonMod.createTag(Registries.ENTITY_TYPE, "engineers");

    public static final TagKey<EntityType<?>> PREDATORS = CommonMod.createTag(Registries.ENTITY_TYPE, "predators");

    public static final TagKey<EntityType<?>> PARASITES = CommonMod.createTag(Registries.ENTITY_TYPE, "parasites");

    public static final TagKey<EntityType<?>> NOT_WORTH_KILLING = CommonMod.createTag(Registries.ENTITY_TYPE, "not_worth_killing");

    public static final TagKey<EntityType<?>> MONSTERS = CommonMod.createTag(Registries.ENTITY_TYPE, "monsters");

    public static final TagKey<EntityType<?>> MEDIUM_GUNS_IMMUNE = CommonMod.createTag(Registries.ENTITY_TYPE, "medium_guns_immune");

    public static final TagKey<EntityType<?>> HIVE_ALIENS = CommonMod.createTag(Registries.ENTITY_TYPE, "hive_aliens");

    public static final TagKey<EntityType<?>> HEAVY_GUNS_IMMUNE = CommonMod.createTag(Registries.ENTITY_TYPE, "heavy_guns_immune");

    public static final TagKey<EntityType<?>> EGGS = CommonMod.createTag(Registries.ENTITY_TYPE, "eggs");

    public static final TagKey<EntityType<?>> ACID_BLEEDERS = CommonMod.createTag(Registries.ENTITY_TYPE, "acid_bleeders");

    public static final TagKey<EntityType<?>> SMALL_GUNS_IMMUNE = CommonMod.createTag(Registries.ENTITY_TYPE, "small_guns_immune");

    public static final TagKey<EntityType<?>> ROYAL_ALIENS = CommonMod.createTag(Registries.ENTITY_TYPE, "royal_aliens");

    public static final TagKey<EntityType<?>> PRODUCES_RESIN = CommonMod.createTag(Registries.ENTITY_TYPE, "produces_resin");

}
