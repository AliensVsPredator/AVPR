package org.avpr.common.client.entities.renders.alien.base_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.base_line.SpitterEntity;

public class SpitterRenderer extends GeoEntityRenderer<SpitterEntity> {

    public SpitterRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/base_line/spitter")));
    }

    @Override
    protected float getShadowRadius(@NotNull SpitterEntity entity) {
        return 0.5f;
    }
}
