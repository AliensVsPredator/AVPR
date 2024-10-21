package org.avpr.common.mixins.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import io.netty.util.internal.UnstableApi;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerRoyalEntity;
import org.avpr.common.entities.alien.beluga_line.OctohuggerEntity;

@UnstableApi
@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> {

    @Shadow
    protected abstract float getFlipDegrees(T animatable);

    /**
     * TODO: Finish via renders
     */
    @Inject(method = "setupRotations", at = @At("TAIL"))
    private void avpr$vanillaLayingMixin(
        T entity,
        PoseStack poseStack,
        float bob,
        float yBodyRot,
        float partialTick,
        float scale,
        CallbackInfo ci
    ) {
        if (
            getFlipDegrees(entity) == 90 &&
                entity.hasPassenger(
                    entity2 -> entity2 instanceof FacehuggerEntity || entity2 instanceof FacehuggerRoyalEntity
                        || entity2 instanceof OctohuggerEntity
                )
        ) {
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - yBodyRot));
            poseStack.mulPose(Axis.YP.rotationDegrees(yBodyRot));
            poseStack.mulPose(Axis.ZP.rotationDegrees(this.getFlipDegrees(entity)));
            poseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
        }
    }
}
