package org.avpr.common.items.guns;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.animatable.SingletonGeoAnimatable;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.avpr.common.api.common.ItemUtil;
import org.avpr.common.registries.AVPRItems;
import org.avpr.common.tags.AVPRItemTags;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.api.util.TooltipUtils;
import org.avpr.common.client.items.renders.GunRender;
import org.avpr.common.entities.projectiles.BulletProjectile;
import org.avpr.common.registries.AVPRDataComponments;
import org.avpr.common.registries.AVPRSounds;

public class BaseGunItem extends Item implements GeoItem {

    protected final String id;

    protected long windUpTicks = 0;

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public BaseGunItem(String id, Properties properties) {
        super(properties);
        this.id = id;
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public String getItemID() {
        return this.id;
    }

    @Override
    public void appendHoverText(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context,
        @NotNull List<Component> tooltipComponents,
        @NotNull TooltipFlag tooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        // TooltipUtils.appendLabel(
        // tooltipComponents,
        // "tooltip.avpr.fire_mode",
        // Component.literal(fireMode.identifier() + " (" + fireMode.ammunitionData().consumedAmmunition() + " / Shot)")
        // );
        TooltipUtils.appendLabel(
            tooltipComponents,
            "tooltip.avpr.ammunition",
            Component.literal(
                stack.get(AVPRDataComponments.CURRENT_AMMO.get()) + " / " + stack.get(AVPRDataComponments.MAX_AMMO.get())
            )
        );
        // TooltipUtils.appendLabel(
        // tooltipComponents,
        // "tooltip.avpr.ammunition_type",
        // Component.translatable(
        // "item." + weaponItemStack.getOrSetActiveAmmunitionType().replace(":", ".")
        // )
        // );
        if (stack.get(AVPRDataComponments.GUN_DAMAGE.get()) != null)
            TooltipUtils.appendLabel(
                tooltipComponents,
                "tooltip.avpr.damage",
                Component.literal(stack.get(AVPRDataComponments.GUN_DAMAGE.get()).toString())
            );
        if (stack.get(AVPRDataComponments.GUN_FIRERATE.get()) != null)
            TooltipUtils.appendLabel(
                tooltipComponents,
                "tooltip.avpr.fire_rate",
                Component.literal(stack.get(AVPRDataComponments.GUN_FIRERATE.get()) / 20D + " / Sec")
            );
        if (stack.get(AVPRDataComponments.GUN_ACCURACY.get()) != null)
            TooltipUtils.appendLabel(
                tooltipComponents,
                "tooltip.avpr.accuracy",
                Component.literal(stack.get(AVPRDataComponments.GUN_ACCURACY.get()).toString())
            );
        if (stack.get(AVPRDataComponments.GUN_RECOIL.get()) != null)
            TooltipUtils.appendLabel(
                tooltipComponents,
                "tooltip.avpr.recoil",
                Component.literal(stack.get(AVPRDataComponments.GUN_RECOIL.get()).toString())
            );
    }

    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (stack.get(AVPRDataComponments.CURRENT_AMMO.get()) == null)
            stack.set(AVPRDataComponments.CURRENT_AMMO.get(), entity instanceof Player player && player.getAbilities().instabuild ? 0 : stack.get(AVPRDataComponments.MAX_AMMO.get()));
        if (!level.isClientSide() && stack.get(AVPRDataComponments.STOP_ANIMATIONS.get()) != null && stack.get(AVPRDataComponments.STOP_ANIMATIONS.get()) && entity instanceof Player player)
            triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) level), "main", "idle");

    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack stack, int remainingUseDuration) {
        super.onUseTick(level, livingEntity, stack, remainingUseDuration);
        if (livingEntity instanceof Player player) {
            if (stack.get(AVPRDataComponments.CURRENT_AMMO.get()) > 0 || player.getAbilities().instabuild) {
                if (!stack.has(AVPRDataComponments.GUN_HAS_WINDUP.get()) && !player.getCooldowns().isOnCooldown(this)) {
                    this.fireBullet(player, stack, level);
                    player.getCooldowns().addCooldown(this, stack.get(AVPRDataComponments.GUN_FIRERATE.get()));
                    level.playSound(
                            null,
                            player.blockPosition(),
                            AVPRSounds.ITEM_WEAPON_SHOTGUN_SHOOT.get(),
                            SoundSource.PLAYERS,
                            1,
                            1
                    );
                    if (!player.getAbilities().instabuild)
                        stack.set(AVPRDataComponments.CURRENT_AMMO.get(),
                                stack.get(AVPRDataComponments.CURRENT_AMMO.get()) - 1);
                } else {
                    this.windUpTicks++;
                    stack.set(AVPRDataComponments.STOP_ANIMATIONS.get(), false);
                    if (stack.get(AVPRDataComponments.GUN_HAS_WINDUP.get())) {
                        level.playSound(
                                null,
                                player.blockPosition(),
                                AVPRSounds.ITEM_WEAPON_OLD_PAINLESS_SHOOT_SPINNING.get(),
                                SoundSource.PLAYERS,
                                1,
                                1
                        );
                        if (!level.isClientSide())
                            triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) level), "main", "spin");
                        stack.set(AVPRDataComponments.GUN_HAS_WINDUP.get(), false);
                    }
                    if (this.windUpTicks > stack.get(AVPRDataComponments.GUN_WIND_UP_LONG.get()) * 2) {
                        this.fireBullet(player, stack, level);
                        level.playSound(
                                null,
                                player.blockPosition(),
                                AVPRSounds.ITEM_WEAPON_SHOTGUN_SHOOT.get(),
                                SoundSource.PLAYERS,
                                1,
                                1
                        );
                        if (!level.isClientSide())
                            triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) level), "main", "spin");
                        if (!player.getAbilities().instabuild)
                            stack.set(AVPRDataComponments.CURRENT_AMMO.get(), stack.get(AVPRDataComponments.CURRENT_AMMO.get()) - 1);
                    }
                }
            } else if (player.getInventory().hasAnyMatching(itemStack -> itemStack.is(AVPRItemTags.HEAVY_AMMO))) {
                if (player.getInventory().countItem(AVPRItems.BULLET_HEAVY.get()) > 0)
                    ItemUtil.reloadGun(stack, player, this);
                if (player.getInventory().countItem(AVPRItems.BULLET_HEAVY_ACID.get()) > 0)
                    ItemUtil.reloadGun(stack, player, this);
                if (player.getInventory().countItem(AVPRItems.BULLET_HEAVY_ELECTRIC.get()) > 0)
                    ItemUtil.reloadGun(stack, player, this);
                if (player.getInventory().countItem(AVPRItems.BULLET_HEAVY_EXPLOSIVE.get()) > 0)
                    ItemUtil.reloadGun(stack, player, this);
                if (player.getInventory().countItem(AVPRItems.BULLET_HEAVY_INCENDIARY.get()) > 0)
                    ItemUtil.reloadGun(stack, player, this);
                if (player.getInventory().countItem(AVPRItems.BULLET_HEAVY_PENETRATION.get()) > 0)
                    ItemUtil.reloadGun(stack, player, this);
            }
        }
    }

    @Override
    public boolean useOnRelease(@NotNull ItemStack stack) {
        this.windUpTicks = 0;
        stack.set(AVPRDataComponments.GUN_HAS_WINDUP.get(), true);
        stack.set(AVPRDataComponments.STOP_ANIMATIONS.get(), true);
        return super.useOnRelease(stack);
    }

    protected void fireBullet(@NotNull LivingEntity livingEntity, @NotNull ItemStack stack, @NotNull Level level) {
        if (
            livingEntity instanceof Player player && (stack.get(AVPRDataComponments.CURRENT_AMMO.get()) > 0
                || player.getAbilities().instabuild)
        ) {
            var bulletEntity = new BulletProjectile(level, stack.get(AVPRDataComponments.GUN_DAMAGE.get()));
            bulletEntity.shootFromRotation(
                livingEntity,
                livingEntity.getXRot(),
                livingEntity.getYRot(),
                0.0F,
                3.0F,
                1.0F
            );
            bulletEntity.moveTo(livingEntity.getX(), livingEntity.getY(0.6D), livingEntity.getZ(), 0, 0);
            level.addFreshEntity(bulletEntity);
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        var itemStack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }

    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {

            private final GunRender<BaseGunItem> renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new GunRender<BaseGunItem>(getItemID());
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
            new AnimationController<>(this, "main", event -> PlayState.CONTINUE).triggerableAnim(
                "spin",
                RawAnimation.begin().thenLoop("barrelspin")
            ).triggerableAnim(
                    "idle",
                    RawAnimation.begin().thenPlay("idle")
            )
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
