package org.avpr.common.api.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Predicate;

public class PredicatesUtil {

    public static final Predicate<LivingEntity> IS_CREATIVEorSPECTATOR = livingEntity -> livingEntity instanceof Player player && (player.isCreative()
            || player.isSpectator());

    public static final Predicate<Item> IS_ITEM_SHULKER_BOX = item -> item instanceof BlockItem blockItem &&
            blockItem.getBlock().defaultBlockState().is(BlockTags.SHULKER_BOXES);

    public static final Predicate<Entity> IS_LIVING = item -> item instanceof LivingEntity livingEntity &&
            livingEntity.isAlive();
}
