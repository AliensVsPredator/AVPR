package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

import org.avpr.common.CommonMod;

public class AVPREntityTags {

    public static final TagKey<EntityType<?>> ACID_IMMUNE = CommonMod.createTag(Registries.ENTITY_TYPE, "acid_immune");

    public static final TagKey<EntityType<?>> ALIENS = CommonMod.createTag(Registries.ENTITY_TYPE, "aliens");

    public static final TagKey<EntityType<?>> HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "hosts");

    public static final TagKey<EntityType<?>> RUNNER_HOSTS = CommonMod.createTag(Registries.ENTITY_TYPE, "runner_hosts");

    public static final TagKey<EntityType<?>> ENGINEERS = CommonMod.createTag(Registries.ENTITY_TYPE, "engineers");

    public static final TagKey<EntityType<?>> PREDATORS = CommonMod.createTag(Registries.ENTITY_TYPE, "predators");
}
