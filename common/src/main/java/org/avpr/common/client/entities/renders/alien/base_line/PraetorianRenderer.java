package org.avpr.common.client.entities.renders.alien.base_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.base_line.PraetorianEntity;

public class PraetorianRenderer extends GeoEntityRenderer<PraetorianEntity> {

    public PraetorianRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/base_line/praetorian")));
    }

    @Override
    protected float getShadowRadius(@NotNull PraetorianEntity entity) {
        return 0.5f;
    }
}
