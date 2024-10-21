package org.avpr.common.client.entities.renders.alien.predalien_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.predalien_line.PredalienEntity;

public class PredalienRenderer extends GeoEntityRenderer<PredalienEntity> {

    public PredalienRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/predalien_line/predalien")));
    }

    @Override
    protected float getShadowRadius(@NotNull PredalienEntity entity) {
        return 0.5f;
    }
}
