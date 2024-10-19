package org.avpr.common.mixins.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.avpr.common.CommonMod;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.registries.AVPRBlocks;

@Mixin(ScreenEffectRenderer.class)
public class InGameOverlayRendererMixin {

    private static final ResourceLocation RESIN_OVERLAY_TEXTURE = CommonMod.modResource("textures/overlay/resin_webbing_gui.png");

    @Inject(method = { "renderScreenEffect" }, at = { @At("RETURN") })
    private static void renderOverlays(Minecraft client, PoseStack matrices, CallbackInfo ci) {
        if (
            client.player != null && !client.player.isSpectator() && !PredicatesUtil.IS_CREATIVEorSPECTATOR.test(client.player)
                && client.player.level()
                    .getBlockState(client.player.blockPosition())
                    .is(AVPRBlocks.RESIN_WEBBING_BLOCK.get())
        ) {
            avpr$renderOverlay(client, matrices, RESIN_OVERLAY_TEXTURE);
        }
    }

    /**
     * Renders an overlay over the screen effect with specified texture.
     *
     * @param client           The Minecraft client instance.
     * @param matrices         The PoseStack for GUI rendering transformations.
     * @param resourceLocation The ResourceLocation of the texture to be used as the overlay.
     */
    @Unique
    private static void avpr$renderOverlay(Minecraft client, PoseStack matrices, ResourceLocation resourceLocation) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, resourceLocation);
        BlockPos blockpos = BlockPos.containing(client.player.getX(), client.player.getEyeY(), client.player.getZ());
        float f = LightTexture.getBrightness(
            client.player.level().dimensionType(),
            client.player.level().getMaxLocalRawBrightness(blockpos)
        );
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor(f, f, f, 1);
        float f7 = -client.player.getYRot() / 64.0F;
        float f8 = client.player.getXRot() / 64.0F;
        Matrix4f matrix4f = matrices.last().pose();
        BufferBuilder bufferbuilder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.addVertex(matrix4f, -1.0F, -1.0F, -0.5F).setUv(4.0F + f7, 4.0F + f8);
        bufferbuilder.addVertex(matrix4f, 1.0F, -1.0F, -0.5F).setUv(0.0F + f7, 4.0F + f8);
        bufferbuilder.addVertex(matrix4f, 1.0F, 1.0F, -0.5F).setUv(0.0F + f7, 0.0F + f8);
        bufferbuilder.addVertex(matrix4f, -1.0F, 1.0F, -0.5F).setUv(4.0F + f7, 0.0F + f8);
        BufferUploader.drawWithShader(bufferbuilder.buildOrThrow());
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.disableBlend();
    }
}
