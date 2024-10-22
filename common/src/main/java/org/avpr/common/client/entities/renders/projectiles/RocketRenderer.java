package org.avpr.common.client.entities.renders.projectiles;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.internal.client.util.RenderUtils;
import mod.azure.azurelib.common.internal.common.cache.object.BakedGeoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.projectiles.RocketProjectile;

public class RocketRenderer extends GeoEntityRenderer<RocketProjectile> {

    public RocketRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("rocket")));
        withScale(2f);
    }

    @Override
    protected int getBlockLightLevel(@NotNull RocketProjectile entity, @NotNull BlockPos pos) {
        return 15;
    }

    @Override
    public void preRender(
        PoseStack poseStack,
        RocketProjectile animatable,
        BakedGeoModel model,
        MultiBufferSource bufferSource,
        VertexConsumer buffer,
        boolean isReRender,
        float partialTick,
        int packedLight,
        int packedOverlay,
        int colour
    ) {
        RenderUtils.faceRotation(poseStack, animatable, partialTick);
        super.preRender(
            poseStack,
            animatable,
            model,
            bufferSource,
            buffer,
            isReRender,
            partialTick,
            packedLight,
            packedOverlay,
            colour
        );
    }
}
