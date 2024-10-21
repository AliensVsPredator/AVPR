package org.avpr.common.client.entities.renders.alien.base_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.base_line.QueenEntity;

public class QueenRenderer extends GeoEntityRenderer<QueenEntity> {

    public QueenRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/base_line/queen")));
    }

    @Override
    protected float getShadowRadius(@NotNull QueenEntity entity) {
        return 0.5f;
    }
}
