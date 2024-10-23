package org.avpr.common.items.guns;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.api.common.helper.CommonUtils;
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
import net.minecraft.sounds.SoundEvent;
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
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Consumer;

import org.avpr.common.api.common.GunEnum;
import org.avpr.common.api.common.GunFireMode;
import org.avpr.common.api.common.GunProperties;
import org.avpr.common.api.common.ItemUtil;
import org.avpr.common.api.util.TooltipUtils;
import org.avpr.common.client.items.renders.GunRender;
import org.avpr.common.entities.projectiles.BulletProjectile;
import org.avpr.common.entities.projectiles.FlamethrowProjectile;
import org.avpr.common.entities.projectiles.RocketProjectile;
import org.avpr.common.registries.AVPRDataComponments;
import org.avpr.common.registries.AVPRItems;
import org.avpr.common.registries.AVPRSounds;
import org.avpr.common.tags.AVPRItemTags;

/**
 * TODO: - Add Rocket launcher. - Add Ammo Type Selection. - Add reloading.
 */
public class BaseGunItem extends Item implements GeoItem {

    protected final String id;

    protected long windUpTicks = 0;

    protected long soundPlayingTicks = 0;

    protected GunEnum gunEnum;

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    /**
     * A mapping of GunEnum types to their respective GunProperties. This map holds the configuration properties for
     * different types of guns, such as reload sound, firing sound, and available fire modes for each gun type.
     */
    protected Map<GunEnum, GunProperties> GUN_ENUM_GUN_PROPERTIES_MAP = new EnumMap<>(GunEnum.class);

    public BaseGunItem(String id, GunEnum setGunEnum, Properties properties) {
        super(properties);
        this.id = id;
        this.gunEnum = setGunEnum;
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.FLAMETHROWER,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_FLAMETHROWER_RELOAD_START.get(),
                AVPRSounds.ITEM_WEAPON_FLAMETHROWER_SHOOT.get(),
                List.of(GunFireMode.AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.PISTOL,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_COMBAT_PISTOL_RELOAD.get(),
                AVPRSounds.ITEM_WEAPON_COMBAT_PISTOL_SHOOT.get(),
                List.of(GunFireMode.SEMI_AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.SHOTGUN,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_GENERIC_RELOAD.get(),
                AVPRSounds.ITEM_WEAPON_SHOTGUN_SHOOT.get(),
                List.of(GunFireMode.SEMI_AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.AK47,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_GENERIC_RELOAD.get(),
                AVPRSounds.ITEM_WEAPON_AK_47_SHOOT.get(),
                List.of(GunFireMode.AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.F90RIFLE,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_GENERIC_RELOAD.get(),
                AVPRSounds.ITEM_WEAPON_AK_47_SHOOT.get(),
                List.of(GunFireMode.AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.M4CARBINE,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_GENERIC_RELOAD.get(),
                AVPRSounds.ITEM_WEAPON_AK_47_SHOOT.get(),
                List.of(GunFireMode.AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.M41APULSERIFLE,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_GENERIC_RELOAD.get(),
                AVPRSounds.ITEM_WEAPON_PULSE_RIFLE_SHOOT.get(),
                List.of(GunFireMode.AUTOMATIC, GunFireMode.BURST)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.SNIPER,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_GENERIC_RELOAD.get(),
                AVPRSounds.ITEM_WEAPON_SNIPER_RIFLE_SHOOT.get(),
                List.of(GunFireMode.SEMI_AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.SMARTGUN,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_GENERIC_RELOAD.get(),
                AVPRSounds.ITEM_WEAPON_AK_47_SHOOT.get(),
                List.of(GunFireMode.AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.SADAR,
            new GunProperties(
                AVPRSounds.ITEM_WEAPON_ROCKET_LAUNCHER_RELOAD_START.get(),
                AVPRSounds.ITEM_WEAPON_ROCKET_LAUNCHER_SHOOT.get(),
                List.of(GunFireMode.SEMI_AUTOMATIC)
            )
        );
        GUN_ENUM_GUN_PROPERTIES_MAP.put(
            GunEnum.OLDPAINLESS,
            new GunProperties(SoundEvents.LEVER_CLICK, AVPRSounds.ITEM_WEAPON_OLD_PAINLESS_SHOOT_LOOP.get(), List.of(GunFireMode.AUTOMATIC))
        );
    }

    /**
     * Retrieves the ID of the item.
     *
     * @return The ID of the item as a String.
     */
    public String getItemID() {
        return this.id;
    }

    /**
     * Returns the reload sound associated with the gun item. This method retrieves the reload sound defined in the
     * GunProperties for the current gun type.
     *
     * @return The SoundEvent representing the reload sound, or null if no gun type is specified or if no reload sound
     *         is defined.
     */
    protected SoundEvent getReloadSound() {
        return this.gunEnum != null ? GUN_ENUM_GUN_PROPERTIES_MAP.get(this.gunEnum).reloadSound() : null;
    }

    /**
     * Retrieves the firing sound associated with the gun item. This method fetches the firing sound defined in the
     * GunProperties for the current gun type.
     *
     * @return The SoundEvent representing the firing sound, or null if no gun type is specified or if no firing sound
     *         is defined.
     */
    protected SoundEvent getFiringSound() {
        return this.gunEnum != null ? GUN_ENUM_GUN_PROPERTIES_MAP.get(this.gunEnum).firingSound() : null;
    }

    /**
     * Retrieves the list of fire modes available for the gun. If the gun enum is not specified, it returns an empty
     * list.
     *
     * @return A list of GunFireMode enums representing the available fire modes for the gun. Returns an empty list if
     *         the gun enum is null.
     */
    protected List<GunFireMode> getGunFireMode() {
        return this.gunEnum != null ? GUN_ENUM_GUN_PROPERTIES_MAP.get(this.gunEnum).gunFireMode() : Collections.emptyList();
    }

    /**
     * Appends custom hover text to the provided tooltip components for a gun item. This method enhances the default
     * tooltip with additional information such as fire mode, ammunition count, damage, fire rate, accuracy, and recoil.
     *
     * @param stack             The ItemStack representing the gun.
     * @param context           The TooltipContext for the current environment or view.
     * @param tooltipComponents The list of Components to which the hover text will be appended.
     * @param tooltipFlag       Flags indicating what information should be shown on the tooltip.
     */
    @Override
    public void appendHoverText(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context,
        @NotNull List<Component> tooltipComponents,
        @NotNull TooltipFlag tooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        if (this.getGunFireMode() != null)
            TooltipUtils.appendLabel(
                tooltipComponents,
                "tooltip.avpr.fire_mode",
                Component.literal(this.getGunFireMode().toString().toUpperCase(Locale.ROOT).replace("_", "-") + " (1 / Shot)")
            );
        TooltipUtils.appendLabel(
            tooltipComponents,
            "tooltip.avpr.ammunition",
            Component.literal(
                stack.get(AVPRDataComponments.CURRENT_AMMO.get()) != null
                    ? stack.get(AVPRDataComponments.CURRENT_AMMO.get()).toString()
                    : "0" + " / " + stack.get(AVPRDataComponments.MAX_AMMO.get())
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

    /**
     * Handles inventory tick updates for the gun item. This method manages the state of ammunition, triggers
     * animations, and processes specific events pertaining to the item.
     *
     * @param stack      The ItemStack representing the gun.
     * @param level      The current level or world in which the item exists.
     * @param entity     The entity holding or interacting with the item.
     * @param slotId     The inventory slot ID in which the item resides.
     * @param isSelected A boolean indicating whether the item is currently selected.
     */
    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        if (stack.get(AVPRDataComponments.CURRENT_AMMO.get()) == null)
            stack.set(
                AVPRDataComponments.CURRENT_AMMO.get(),
                entity instanceof Player player && player.getAbilities().instabuild ? 0 : stack.get(AVPRDataComponments.MAX_AMMO.get())
            );
        if (
            !level.isClientSide() && stack.get(AVPRDataComponments.STOP_ANIMATIONS.get()) != null && stack.get(
                AVPRDataComponments.STOP_ANIMATIONS.get()
            ) && entity instanceof Player player
        ) {
            triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) level), "main", "idle");
            if (this.getItemID().matches("weapon_old_painless"))
                level.playSound(
                    null,
                    player.blockPosition(),
                    AVPRSounds.ITEM_WEAPON_OLD_PAINLESS_SHOOT_STOP.get(),
                    SoundSource.PLAYERS,
                    1,
                    1
                );
            stack.set(AVPRDataComponments.STOP_ANIMATIONS.get(), false);
        }
        stack.getOrDefault(AVPRDataComponments.GUN_HAS_WINDUP.get(), false);
    }

    /**
     * Handles the behavior of an item when it is being used by a player, such as consuming ammunition, playing firing
     * sounds, triggering animations, and handling cooldowns.
     *
     * @param level                The current level or world in which the player and item exist.
     * @param livingEntity         The entity using the item, expected to be a player.
     * @param stack                The ItemStack representing the item being used.
     * @param remainingUseDuration The remaining duration for which the item can be used.
     */
    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack stack, int remainingUseDuration) {
        super.onUseTick(level, livingEntity, stack, remainingUseDuration);
        if (livingEntity instanceof Player player) {
            if (stack.get(AVPRDataComponments.CURRENT_AMMO.get()) > 0 || player.getAbilities().instabuild) {
                if (this.getItemID().matches("weapon_old_painless")) {
                    this.windUpTicks++;
                    stack.set(AVPRDataComponments.STOP_ANIMATIONS.get(), false);
                    if (stack.get(AVPRDataComponments.GUN_HAS_WINDUP.get())) {
                        // level.playSound(
                        // null,
                        // player.blockPosition(),
                        // AVPRSounds.ITEM_WEAPON_OLD_PAINLESS_SHOOT_STOP.get(),
                        // SoundSource.PLAYERS,
                        // 1,
                        // 1
                        // );
                        if (!level.isClientSide())
                            triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) level), "main", "spin");
                        stack.set(AVPRDataComponments.GUN_HAS_WINDUP.get(), false);
                    }
                    if (
                        this.windUpTicks > stack.get(
                            AVPRDataComponments.GUN_WIND_UP_LONG.get()
                        )
                    ) {
                        this.fireBullet(player, stack, level);
                        level.playSound(
                            null,
                            player.blockPosition(),
                            this.getFiringSound(),
                            SoundSource.PLAYERS,
                            1,
                            1
                        );
                        if (!level.isClientSide() && this.getItemID().matches("weapon_old_painless"))
                            triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) level), "main", "spin");
                        if (!player.getAbilities().instabuild)
                            stack.set(AVPRDataComponments.CURRENT_AMMO.get(), stack.get(AVPRDataComponments.CURRENT_AMMO.get()) - 1);
                    }
                } else if (this.getItemID().matches("weapon_flamethrower_sevastopol")) {
                    if (!player.getCooldowns().isOnCooldown(this)) {
                        this.fireFlamethrower(player, stack, level);
                        player.getCooldowns().addCooldown(this, stack.get(AVPRDataComponments.GUN_FIRERATE.get()));
                        if (!level.isClientSide())
                            soundPlayingTicks++;
                        if (soundPlayingTicks == 1)
                            level.playSound(
                                null,
                                player.blockPosition(),
                                this.getFiringSound(),
                                SoundSource.PLAYERS,
                                0.5F,
                                1
                            );
                        if (soundPlayingTicks > 25) {
                            level.playSound(
                                null,
                                player.blockPosition(),
                                this.getFiringSound(),
                                SoundSource.PLAYERS,
                                0.5F,
                                1
                            );
                            soundPlayingTicks = 0;
                        }
                        if (!player.getAbilities().instabuild)
                            stack.set(
                                AVPRDataComponments.CURRENT_AMMO.get(),
                                stack.get(AVPRDataComponments.CURRENT_AMMO.get()) - 1
                            );
                    }
                } else if (this.getItemID().matches("weapon_m83a2_sadar")) {
                    if (!player.getCooldowns().isOnCooldown(this)) {
                        this.fireRocket(player, stack, level);
                        player.getCooldowns().addCooldown(this, stack.get(AVPRDataComponments.GUN_FIRERATE.get()));
                        level.playSound(
                            null,
                            player.blockPosition(),
                            this.getFiringSound(),
                            SoundSource.PLAYERS,
                            0.5F,
                            1
                        );
                        if (!player.getAbilities().instabuild)
                            stack.set(
                                AVPRDataComponments.CURRENT_AMMO.get(),
                                stack.get(AVPRDataComponments.CURRENT_AMMO.get()) - 1
                            );
                    }

                } else {
                    if (!player.getCooldowns().isOnCooldown(this)) {
                        this.fireBullet(player, stack, level);
                        player.getCooldowns().addCooldown(this, stack.get(AVPRDataComponments.GUN_FIRERATE.get()));
                        level.playSound(
                            null,
                            player.blockPosition(),
                            this.getFiringSound(),
                            SoundSource.PLAYERS,
                            0.5F,
                            1
                        );
                        if (!player.getAbilities().instabuild)
                            stack.set(
                                AVPRDataComponments.CURRENT_AMMO.get(),
                                stack.get(AVPRDataComponments.CURRENT_AMMO.get()) - 1
                            );
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

    /**
     * Handles the action of releasing the item after using it. This method resets the wind-up ticks and updates
     * specific data components in the item stack to control its state and animations.
     *
     * @param stack the item stack representing the gun being used
     * @return true if the release action is successfully handled, otherwise false
     */
    @Override
    public boolean useOnRelease(@NotNull ItemStack stack) {
        this.windUpTicks = 0;
        stack.set(AVPRDataComponments.GUN_HAS_WINDUP.get(), true);
        stack.set(AVPRDataComponments.STOP_ANIMATIONS.get(), true);
        return super.useOnRelease(stack);
    }

    /**
     * Fires a flamethrower from the weapon held by the specified living entity. This method checks if the entity is a
     * player and if there is enough ammunition or if the player has creative mode enabled. If the checks pass, a new
     * flamethrower projectile is created and fired.
     *
     * @param livingEntity The living entity (e.g., player) that is firing the flamethrower.
     * @param stack        The item stack representing the weapon from which the flamethrower is fired.
     * @param level        The current level or world in which the entity is situated.
     */
    protected void fireFlamethrower(@NotNull LivingEntity livingEntity, @NotNull ItemStack stack, @NotNull Level level) {
        if (
            livingEntity instanceof Player player && (stack.get(AVPRDataComponments.CURRENT_AMMO.get()) > 0
                || player.getAbilities().instabuild)
        ) {
            var flamethrowProjectile = new FlamethrowProjectile(level);
            flamethrowProjectile.setOwner(player);
            flamethrowProjectile.shootFromRotation(
                livingEntity,
                livingEntity.getXRot(),
                livingEntity.getYRot(),
                0.0F,
                1.0F,
                1.0F
            );
            flamethrowProjectile.moveTo(livingEntity.getX(), livingEntity.getY(0.7D), livingEntity.getZ(), 0, 0);
            level.addFreshEntity(flamethrowProjectile);
        }
    }

    /**
     * Fires a rocket from the weapon held by the specified living entity. This method checks if the entity is a player
     * and if there is enough ammunition or if the player has creative mode enabled. If the checks pass, a new rocket
     * projectile is created and fired, and a light source is spawned.
     *
     * @param livingEntity The living entity (e.g., player) that is firing the rocket.
     * @param stack        The item stack representing the weapon from which the rocket is fired.
     * @param level        The current level or world in which the entity is situated.
     */
    protected void fireRocket(@NotNull LivingEntity livingEntity, @NotNull ItemStack stack, @NotNull Level level) {
        if (
            livingEntity instanceof Player player && (stack.get(AVPRDataComponments.CURRENT_AMMO.get()) > 0
                || player.getAbilities().instabuild)
        ) {
            var rocketProjectile = new RocketProjectile(level, stack.get(AVPRDataComponments.GUN_DAMAGE.get()));
            rocketProjectile.shootFromRotation(
                livingEntity,
                livingEntity.getXRot(),
                livingEntity.getYRot(),
                0.0F,
                3.0F,
                1.0F
            );
            CommonUtils.spawnLightSource(livingEntity, player.level().isWaterAt(player.blockPosition()));
            rocketProjectile.moveTo(livingEntity.getX(), livingEntity.getY(0.7D), livingEntity.getZ(), 0, 0);
            level.addFreshEntity(rocketProjectile);
        }
    }

    /**
     * Fires a bullet from the weapon held by the specified living entity. This method checks if the entity is a player
     * and if there is enough ammunition or if the player has creative mode enabled. If the checks pass, a new bullet
     * projectile is created and fired.
     *
     * @param livingEntity The living entity (e.g., player) that is firing the bullet.
     * @param stack        The item stack representing the weapon from which the bullet is fired.
     * @param level        The current level or world in which the entity is situated.
     */
    protected void fireBullet(@NotNull LivingEntity livingEntity, @NotNull ItemStack stack, @NotNull Level level) {
        if (
            livingEntity instanceof Player player && (stack.get(AVPRDataComponments.CURRENT_AMMO.get()) > 0
                || player.getAbilities().instabuild)
        ) {
            var bulletEntity = new BulletProjectile(
                level,
                stack.get(AVPRDataComponments.GUN_DAMAGE.get()),
                false,
                stack.get(AVPRDataComponments.GUN_KNOCKBACK.get())
            );
            if (this.getItemID().matches("weapon_m56_smartgun"))
                bulletEntity = new BulletProjectile(
                    level,
                    stack.get(AVPRDataComponments.GUN_DAMAGE.get()),
                    true,
                    stack.get(AVPRDataComponments.GUN_KNOCKBACK.get())
                );
            bulletEntity.shootFromRotation(
                livingEntity,
                livingEntity.getXRot(),
                livingEntity.getYRot(),
                0.0F,
                3.0F,
                1.0F
            );
            CommonUtils.spawnLightSource(livingEntity, player.level().isWaterAt(player.blockPosition()));
            bulletEntity.moveTo(livingEntity.getX(), livingEntity.getY(0.7D), livingEntity.getZ(), 0, 0);
            level.addFreshEntity(bulletEntity);
        }
    }

    /**
     * Handles the use action of the gun item. When a player uses the item, it starts the item usage and returns the
     * consumed item stack with an interaction result.
     *
     * @param level  The current level or world the player is in.
     * @param player The player who is using the gun item.
     * @param hand   The hand in which the player is holding the gun item.
     * @return InteractionResultHolder containing the item stack and the interaction result.
     */
    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        var itemStack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemStack);
    }

    /**
     * Creates and provides a custom renderer for the gun item.
     *
     * @param consumer A Consumer that accepts a RenderProvider which supplies a custom BlockEntityWithoutLevelRenderer
     */
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

    /**
     * Registers animation controllers for the gun items with various triggerable animations.
     *
     * @param controllers The ControllerRegistrar instance used to add animation controllers.
     */
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
            new AnimationController<>(this, "main", 5, event -> PlayState.CONTINUE).triggerableAnim(
                "spin",
                RawAnimation.begin().thenLoop("barrelspin")
            )
                .triggerableAnim(
                    "idle",
                    RawAnimation.begin().thenPlay("idle")
                )
                .triggerableAnim(
                    "shoot",
                    RawAnimation.begin().thenLoop("shoot")
                )
        );
    }

    /**
     * Retrieves the animatable instance cache associated with the gun item.
     *
     * @return The AnimatableInstanceCache instance used for managing the animation states and instances of the gun
     *         item.
     */
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
