package org.avpr.common.mixins.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.netty.util.internal.UnstableApi;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerRoyalEntity;
import org.avpr.common.entities.alien.beluga_line.OctohuggerEntity;

@UnstableApi
@Mixin(value = GeoEntityRenderer.class)
public abstract class AzureGeoEntityRendererMixin<T extends Entity & GeoEntity> {

    @Shadow
    protected abstract float getDeathMaxRotation(T animatable);

    /**
     * TODO: Finish via renders
     */
    @Inject(
        method = "applyRotations(Lnet/minecraft/world/entity/Entity;Lcom/mojang/blaze3d/vertex/PoseStack;FFFF)V", at = @At("TAIL"),
        remap = false
    )
    private void avpr$azureLayingMixin(
        T animatable,
        PoseStack poseStack,
        float ageInTicks,
        float rotationYaw,
        float partialTick,
        float nativeScale,
        CallbackInfo ci
    ) {
        if (
            getDeathMaxRotation(animatable) == 90 &&
                animatable.hasPassenger(
                    entity -> entity instanceof FacehuggerEntity || entity instanceof FacehuggerRoyalEntity
                        || entity instanceof OctohuggerEntity
                )
        ) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180f - rotationYaw));
            poseStack.mulPose(Axis.YP.rotationDegrees(rotationYaw));
            poseStack.mulPose(Axis.ZP.rotationDegrees(getDeathMaxRotation(animatable)));
            poseStack.mulPose(Axis.YP.rotationDegrees(270f));
        }
    }
}
