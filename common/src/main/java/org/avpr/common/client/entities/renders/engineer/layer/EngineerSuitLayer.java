package org.avpr.common.client.entities.renders.engineer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.renderer.layer.GeoRenderLayer;
import mod.azure.azurelib.common.internal.client.renderer.GeoRenderer;
import mod.azure.azurelib.common.internal.common.cache.object.BakedGeoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import org.avpr.common.CommonMod;
import org.avpr.common.entities.engineer.EngineerEntity;

public class EngineerSuitLayer extends GeoRenderLayer<EngineerEntity> {

    private static final ResourceLocation SUIT_TEXTURE = CommonMod.modResource("textures/entity/engineer_suit.png");

    private static final ResourceLocation JOCKEY_TEXTURE = CommonMod.modResource("textures/entity/engineer_jockey.png");

    public EngineerSuitLayer(GeoRenderer<EngineerEntity> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(
        PoseStack poseStack,
        EngineerEntity entity,
        BakedGeoModel bakedModel,
        RenderType renderType,
        MultiBufferSource bufferSource,
        VertexConsumer buffer,
        float partialTick,
        int packedLight,
        int packedOverlay
    ) {
        var suitRenderType = RenderType.entityCutout(entity.getSuitType() == 0 ? SUIT_TEXTURE : JOCKEY_TEXTURE);

        renderer.reRender(
            getDefaultBakedModel(entity),
            poseStack,
            bufferSource,
            entity,
            suitRenderType,
            bufferSource.getBuffer(suitRenderType),
            partialTick,
            packedLight,
            packedOverlay,
            -1
        );
    }
}
