package org.avpr.common.mixins.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.InteractionHand;
import org.avpr.common.items.guns.BaseGunItem;
import org.avpr.common.registries.AVPRDataComponments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerRenderer.class)
public class WeaponRenderingMixin {

    @Inject(method = "getArmPose", at = @At(value = "TAIL"), cancellable = true)
    private static void tryItemPose(AbstractClientPlayer player, InteractionHand hand, CallbackInfoReturnable<HumanoidModel.ArmPose> ci) {
        var itemstack = player.getItemInHand(hand);
        if (itemstack.getItem() instanceof BaseGunItem && itemstack.getOrDefault(AVPRDataComponments.SHOULDNT_RENDER_AS_BOW.get(), false)) ci.setReturnValue(HumanoidModel.ArmPose.BOW_AND_ARROW);
        if (itemstack.getItem() instanceof BaseGunItem && itemstack.getOrDefault(AVPRDataComponments.SHOULD_RENDER_AS_CROSSBOW.get(), false)) ci.setReturnValue(HumanoidModel.ArmPose.CROSSBOW_HOLD);
    }
}
