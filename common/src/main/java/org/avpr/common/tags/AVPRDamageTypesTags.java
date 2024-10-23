package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;

import org.avpr.common.CommonMod;

/**
 * The {@code AVPRDamageTypesTags} class holds a collection of tag keys for different damage types used in the AVPR
 * (Aliens versus Predator Requiem) mod. These tags are used to categorize and identify specific characteristics of
 * damage types within the mod.
 */
public record AVPRDamageTypesTags() {

    public static final TagKey<DamageType> IS_BULLET_PROJECTILE = CommonMod.createTag(Registries.DAMAGE_TYPE, "is_bullet_projectile");

    public static final TagKey<DamageType> IS_PUNCTURING = CommonMod.createTag(Registries.DAMAGE_TYPE, "is_puncturing");

}
