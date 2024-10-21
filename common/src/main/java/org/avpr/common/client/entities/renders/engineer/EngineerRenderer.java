package org.avpr.common.client.entities.renders.engineer;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.client.entities.renders.engineer.layer.EngineerSuitLayer;
import org.avpr.common.entities.engineer.EngineerEntity;

public class EngineerRenderer extends GeoEntityRenderer<EngineerEntity> {

    public EngineerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("engineer/engineer")));
        this.addRenderLayer(new EngineerSuitLayer(this));
    }

    @Override
    protected float getShadowRadius(@NotNull EngineerEntity entity) {
        return 0.5f;
    }
}
