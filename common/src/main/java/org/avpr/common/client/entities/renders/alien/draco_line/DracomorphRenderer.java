package org.avpr.common.client.entities.renders.alien.draco_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.draco_line.DracomorphEntity;

public class DracomorphRenderer extends GeoEntityRenderer<DracomorphEntity> {

    public DracomorphRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/draco_line/dracomorph")));
    }

    @Override
    protected float getShadowRadius(@NotNull DracomorphEntity entity) {
        return 0.5f;
    }
}
