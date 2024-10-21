package org.avpr.common.client.entities.renders.alien.base_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.base_line.DroneEntity;

public class DroneRenderer extends GeoEntityRenderer<DroneEntity> {

    public DroneRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/base_line/drone")));
    }

    @Override
    protected float getShadowRadius(@NotNull DroneEntity entity) {
        return 0.5f;
    }
}
