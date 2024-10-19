package org.avpr.common.api.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.registries.AVPRStatusEffects;
import org.avpr.common.tags.AVPREntityTags;

import java.util.function.Predicate;

public class PredicatesUtil {

    public static final Predicate<LivingEntity> IS_CREATIVEorSPECTATOR = livingEntity -> livingEntity instanceof Player player && (player.isCreative()
            || player.isSpectator());

    public static final Predicate<Item> IS_ITEM_SHULKER_BOX = item -> item instanceof BlockItem blockItem &&
            blockItem.getBlock().defaultBlockState().is(BlockTags.SHULKER_BOXES);

    public static final Predicate<Entity> IS_LIVING = item -> item instanceof LivingEntity livingEntity &&
            livingEntity.isAlive();

    public static Predicate<Entity> hasImpEffect = entity -> entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(AVPRStatusEffects.IMPREGNATION);
    public static Predicate<Entity> shouldApplyImpEffects = entity -> entity instanceof LivingEntity livingEntity && hasImpEffect.test(
            livingEntity) && (livingEntity.getEffect(
            AVPRStatusEffects.IMPREGNATION).getDuration() < (0.2 * 1200) && (livingEntity.tickCount % Tick.PER_SECOND == 0L));

    public static boolean removeFaceHuggerTarget(LivingEntity target) {
        return target.getType().is(AVPREntityTags.ALIENS) || target.getPassengers().stream().anyMatch(FacehuggerEntity.class::isInstance) || target.isDeadOrDying()|| target.getType().is(
                EntityTypeTags.UNDEAD);
    }
}
