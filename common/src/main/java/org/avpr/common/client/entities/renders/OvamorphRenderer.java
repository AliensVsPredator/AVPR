package org.avpr.common.client.entities.renders;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.base_line.OvamorphEntity;

public class OvamorphRenderer extends GeoEntityRenderer<OvamorphEntity> {

    public OvamorphRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("ovamorph")));
        this.withScale(1.75F);
    }

    @Override
    protected float getShadowRadius(@NotNull OvamorphEntity entity) {
        return 0.5f;
    }

    @Override
    protected float getDeathMaxRotation(OvamorphEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
