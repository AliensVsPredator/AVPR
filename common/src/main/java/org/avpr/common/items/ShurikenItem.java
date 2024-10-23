package org.avpr.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.entities.projectiles.ShurikenItemEntity;

public class ShurikenItem extends Item {

    public ShurikenItem(Properties properties) {
        super(properties);
    }

    /**
     * Retrieves the use duration of the shuriken item.
     *
     * @param stack  The item stack holding the shuriken item.
     * @param entity The entity using the shuriken item, typically a player.
     * @return The duration for which the shuriken item can be used.
     */
    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return 72000;
    }

    /**
     * Releases the shuriken item that has been charged by the player.
     *
     * @param stack        The item stack holding the shuriken item.
     * @param level        The level in which the entity is present.
     * @param livingEntity The entity using the shuriken item, typically a player.
     * @param timeCharged  The amount of time the item was charged by the player.
     */
    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity livingEntity, int timeCharged) {
        int i = this.getUseDuration(stack, livingEntity) - timeCharged;
        float powerForTime = getPowerForTime(i);
        if (powerForTime > 0.1 && livingEntity instanceof Player player && !player.getCooldowns().isOnCooldown(this)) {
            player.getCooldowns().addCooldown(this, 5);
            // TODO: Change sound effect here.
            level.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.TRIDENT_THROW,
                SoundSource.PLAYERS,
                0.5F,
                0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F)
            );

            if (!level.isClientSide) {
                var shurikenItemEntity = new ShurikenItemEntity(level, player);
                shurikenItemEntity.setItem(stack);
                shurikenItemEntity.setOwner(player);
                shurikenItemEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, powerForTime * 6.5F, 1.0F);
                level.addFreshEntity(shurikenItemEntity);
            }
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild)
                stack.shrink(1);
        }

        super.releaseUsing(stack, level, livingEntity, timeCharged);
    }

    /**
     * Calculates the power level based on the time an item has been charged.
     *
     * @param charge The amount of time the item has been charged.
     * @return The calculated power level for the given charge time.
     */
    public static float getPowerForTime(int charge) {
        float f = charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    /**
     * Handles the use action for the shuriken item.
     *
     * @param level  The current level or world in which the action is taking place.
     * @param player The player who is using the shuriken item.
     * @param hand   The hand in which the item is held.
     * @return An InteractionResultHolder containing the result of the interaction and the item stack.
     */
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        var itemStack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }
}
