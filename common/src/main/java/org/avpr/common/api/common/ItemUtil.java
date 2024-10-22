package org.avpr.common.api.common;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.items.guns.BaseGunItem;
import org.avpr.common.registries.AVPRDataComponments;
import org.avpr.common.registries.AVPRItems;

public class ItemUtil {

    public static void reloadGun(@NotNull ItemStack stack, @NotNull Player player, @NotNull Item gun) {
        ItemUtil.removeAmmo(AVPRItems.BULLET_HEAVY.get(), player);
        stack.set(AVPRDataComponments.CURRENT_AMMO.get(), stack.get(AVPRDataComponments.CURRENT_AMMO.get()) + 1);
        player.getCooldowns().addCooldown(gun, stack.getOrDefault(AVPRDataComponments.GUN_RELOAD_TICKS.get(), 10));
        player.level().playSound(null, player.blockPosition(), SoundEvents.LEVER_CLICK, SoundSource.PLAYERS, 1.00F, 1.0F);
    }

    /**
     * Removes matching item from offhand first then checks inventory for item
     *
     * @param ammo         Item you want to be used as ammo
     * @param playerEntity Player whose inventory is being checked.
     */
    public static void removeAmmo(@NotNull Item ammo, @NotNull Player playerEntity) {
        if (playerEntity.getItemInHand(playerEntity.getUsedItemHand()).getItem() instanceof BaseGunItem && !playerEntity.isCreative()) { // Creative
                                                                                                                                         // mode
                                                                                                                                         // reloading
                                                                                                                                         // breaks
                                                                                                                                         // things
            for (var item : playerEntity.getInventory().offhand) {
                if (item.getItem() == ammo) {
                    item.shrink(1);
                    break;
                }
                for (var item1 : playerEntity.getInventory().items) {
                    if (item1.getItem() == ammo) {
                        item1.shrink(1);
                        break;
                    }
                }
            }
        }
    }
}
