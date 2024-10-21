package org.avpr.common.api.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Predicate;

import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.registries.AVPRStatusEffects;
import org.avpr.common.tags.AVPREntityTags;

public class PredicatesUtil {

    public static final Predicate<LivingEntity> IS_CREATIVEorSPECTATOR = livingEntity -> livingEntity instanceof Player player && (player
        .isCreative()
        || player.isSpectator());

    public static final Predicate<Item> IS_ITEM_SHULKER_BOX = item -> item instanceof BlockItem blockItem &&
        blockItem.getBlock().defaultBlockState().is(BlockTags.SHULKER_BOXES);

    public static final Predicate<Entity> IS_LIVING = item -> item instanceof LivingEntity livingEntity &&
        livingEntity.isAlive();

    public static Predicate<Entity> HASE_IMPREGNATION_EFFECT = entity -> entity instanceof LivingEntity livingEntity && livingEntity
        .hasEffect(
            AVPRStatusEffects.IMPREGNATION
        );

    public static Predicate<Entity> SHOULD_APPLY_IMPREGNATION_EFFECT = entity -> entity instanceof LivingEntity livingEntity
        && HASE_IMPREGNATION_EFFECT.test(
            livingEntity
        ) && (livingEntity.getEffect(
            AVPRStatusEffects.IMPREGNATION
        ).getDuration() < (0.2 * 1200) && (livingEntity.tickCount % Tick.PER_SECOND == 0L));

    public static Predicate<Mob> SHOULD_FACEHUG = entity -> entity instanceof Mob livingEntity
        && livingEntity.getType().is(AVPREntityTags.HOSTS)
        && !livingEntity.getType().is(AVPREntityTags.ALIENS)
        && !livingEntity.hasPassenger(AlienEntity.class::isInstance)
        && entity.isWithinMeleeAttackRange(entity)
        && !entity.getType().is(EntityTypeTags.UNDEAD);

    public static Predicate<Entity> SHOULD_REMOVE_TARGET = entity -> entity instanceof LivingEntity livingEntity
        && (livingEntity.getType().is(AVPREntityTags.ALIENS)
            || livingEntity.getPassengers().stream().anyMatch(FacehuggerEntity.class::isInstance)
            || livingEntity.isDeadOrDying()
            || livingEntity.getType()
                .is(
                    EntityTypeTags.UNDEAD
                ));

    public static boolean removeFaceHuggerTarget(LivingEntity target) {
        return target.getType().is(AVPREntityTags.ALIENS) || target.getPassengers().stream().anyMatch(FacehuggerEntity.class::isInstance)
            || target.isDeadOrDying() || target.getType()
                .is(
                    EntityTypeTags.UNDEAD
                );
    }
}
