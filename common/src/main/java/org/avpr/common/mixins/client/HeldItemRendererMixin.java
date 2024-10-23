package org.avpr.common.mixins.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.avpr.common.items.guns.BaseGunItem;

@Mixin(value = ItemInHandRenderer.class)
public abstract class HeldItemRendererMixin {

    @Mutable
    @Shadow
    @Final
    private final Minecraft minecraft;

    @Shadow
    private float mainHandHeight;

    @Shadow
    private float offHandHeight;

    @Shadow
    private ItemStack mainHandItem;

    @Shadow
    private ItemStack offHandItem;

    protected HeldItemRendererMixin(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    /**
     * Cancels the item animation for the main hand and offhand if the held items are instances of BaseGunItem and the
     * same as the current main hand or offhand item, respectively.
     *
     * @param ci CallbackInfo provided by the mixin injection which contains information and controls for the injected
     *           callback.
     */
    @Inject(method = "tick", at = @At("TAIL"))
    public void cancelAnimation(CallbackInfo ci) {
        var clientPlayerEntity = this.minecraft.player;
        assert clientPlayerEntity != null;
        var itemStack = clientPlayerEntity.getMainHandItem();
        var itemStack2 = clientPlayerEntity.getOffhandItem();
        if ((this.mainHandItem.getItem() instanceof BaseGunItem) && ItemStack.isSameItem(mainHandItem, itemStack)) {
            this.mainHandHeight = 1;
            this.mainHandItem = itemStack;
        }
        if ((this.offHandItem.getItem() instanceof BaseGunItem) && ItemStack.isSameItem(offHandItem, itemStack2)) {
            this.offHandHeight = 1;
            this.offHandItem = itemStack2;
        }
    }
}
