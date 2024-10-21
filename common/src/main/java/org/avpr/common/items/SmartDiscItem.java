package org.avpr.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.avpr.common.entities.projectiles.ShurikenItemEntity;
import org.avpr.common.entities.projectiles.SmartDiscItemEntity;
import org.jetbrains.annotations.NotNull;

public class SmartDiscItem extends Item {

    public SmartDiscItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(
        @NotNull Level level,
        @NotNull Player player,
        @NotNull InteractionHand usedHand
    ) {
        var itemInHand = player.getItemInHand(usedHand);
        if (!player.getCooldowns().isOnCooldown(this)) {
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
                var smartDiscItemEntity = new SmartDiscItemEntity(level, player);
                smartDiscItemEntity.setItem(itemInHand);
                smartDiscItemEntity.setOwner(player);
                smartDiscItemEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.5F, 1.0F);
                level.addFreshEntity(smartDiscItemEntity);
            }
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild)
                itemInHand.shrink(1);
            return InteractionResultHolder.sidedSuccess(itemInHand, level.isClientSide());
        } else {
            return InteractionResultHolder.fail(itemInHand);
        }
    }
}
