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

/**
 * Utility class providing various predicates that operate on game entities.
 */
public record PredicatesUtil() {

    /**
     * A predicate to check if a given living entity is either a player in creative mode or spectator mode. The
     * predicate returns true if the living entity is an instance of a player and the player is in either creative mode
     * or spectator mode.
     */
    public static final Predicate<LivingEntity> IS_CREATIVEorSPECTATOR = livingEntity -> livingEntity instanceof Player player && (player
        .isCreative()
        || player.isSpectator());

    /**
     * A predicate to determine if a given item is an instance of a shulker box. This predicate returns true if the item
     * is of type {@code BlockItem} and the block's default state belongs to the tag {@code BlockTags.SHULKER_BOXES}.
     */
    public static final Predicate<Item> IS_ITEM_SHULKER_BOX = item -> item instanceof BlockItem blockItem &&
        blockItem.getBlock().defaultBlockState().is(BlockTags.SHULKER_BOXES);

    /**
     * A predicate to check if a given entity is a living entity and is alive. The predicate returns true if the entity
     * is an instance of LivingEntity and is currently alive.
     */
    public static final Predicate<Entity> IS_LIVING = item -> item instanceof LivingEntity livingEntity &&
        livingEntity.isAlive();

    /**
     * A predicate that checks if an entity has the impregnation effect. The predicate evaluates to {@code true} if the
     * entity is a living entity currently affected by the {@link AVPRStatusEffects#IMPREGNATION} status effect.
     * Otherwise, it evaluates to {@code false}.
     */
    public static Predicate<Entity> HASE_IMPREGNATION_EFFECT = entity -> entity instanceof LivingEntity livingEntity && livingEntity
        .hasEffect(
            AVPRStatusEffects.IMPREGNATION
        );

    /**
     * Predicate to determine if an impregnation effect should be applied to an entity. Checks if the entity is a living
     * entity and currently has the impregnation effect. The predicate evaluates to true if the following conditions are
     * met: 1. The entity is a living entity. 2. The entity has the impregnation effect. 3. The impregnation effect's
     * duration is less than 20% of its total duration. 4. The entity's tick count is a multiple of the number of ticks
     * per second.
     */
    public static Predicate<Entity> SHOULD_APPLY_IMPREGNATION_EFFECT = entity -> entity instanceof LivingEntity livingEntity
        && HASE_IMPREGNATION_EFFECT.test(
            livingEntity
        ) && (livingEntity.getEffect(
            AVPRStatusEffects.IMPREGNATION
        ).getDuration() < (0.2 * 1200) && (livingEntity.tickCount % Tick.PER_SECOND == 0L));

    /**
     * A predicate that determines if a given mob should be targeted for facehugging. The conditions checked by this
     * predicate are: 1. The entity must be an instance of Mob and also must be a living entity. 2. The entity type must
     * be a host and not be categorized as an alien. 3. The entity must not already have a passenger of type
     * AlienEntity. 4. The entity must be within melee attack range. 5. The entity must not be categorized as undead.
     * Example tags referenced: - {@link AVPREntityTags#HUMANIOD_HOSTS} - {@link AVPREntityTags#ALIENS} -
     * {@link EntityTypeTags#UNDEAD}
     */
    public static Predicate<Mob> SHOULD_FACEHUG = entity -> entity instanceof Mob livingEntity
        && livingEntity.getType().is(AVPREntityTags.HUMANIOD_HOSTS)
        && !livingEntity.getType().is(AVPREntityTags.ALIENS)
        && !livingEntity.hasPassenger(AlienEntity.class::isInstance)
        && entity.isWithinMeleeAttackRange(entity)
        && !entity.getType().is(EntityTypeTags.UNDEAD);

    /**
     * A predicate that determines whether an {@link Entity} should be removed as a target. This predicate evaluates the
     * entity to determine if: - The entity is a living entity and is classified under the
     * {@link AVPREntityTags#ALIENS}. - The entity is a living entity and has any passenger instances of
     * {@link FacehuggerEntity}. - The entity is a living entity and is dead or dying. - The entity is a living entity
     * and is categorized under {@link EntityTypeTags#UNDEAD}.
     */
    public static Predicate<Entity> SHOULD_REMOVE_TARGET = entity -> entity instanceof LivingEntity livingEntity
        && (livingEntity.getType().is(AVPREntityTags.ALIENS)
            || livingEntity.getPassengers().stream().anyMatch(FacehuggerEntity.class::isInstance)
            || livingEntity.isDeadOrDying()
            || livingEntity.getType()
                .is(
                    EntityTypeTags.UNDEAD
                ));
}
