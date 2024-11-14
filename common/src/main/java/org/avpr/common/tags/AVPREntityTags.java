package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import org.avpr.common.CommonMod;

public record AVPREntityTags() {

    public static final TagKey<EntityType<?>> ACID_IMMUNE = CommonMod.createTag(Registries.ENTITY_TYPE, "acid_immune");

    public static final TagKey<EntityType<?>> ALIENS = CommonMod.createTag(Registries.ENTITY_TYPE, "aliens");

    public static final TagKey<EntityType<?>> ALL_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "all_hosts");

    public static final TagKey<EntityType<?>> HUMANOID_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "humanoid_hosts");

    public static final TagKey<EntityType<?>> RUNNER_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "runner_hosts");

    public static final TagKey<EntityType<?>> CRUSHER_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "crusher_hosts");

    public static final TagKey<EntityType<?>> SPITTER_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "spitter_hosts");

    public static final TagKey<EntityType<?>> DRACO_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "draco_hosts");

    public static final TagKey<EntityType<?>> DEACON_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "deacon_hosts");

    public static final TagKey<EntityType<?>> BELUGA_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "beluga_hosts");

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
