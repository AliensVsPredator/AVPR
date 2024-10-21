package org.avpr.common.client.entities.renders.alien.deacon_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.deacon_line.DeaconEntity;

public class DeaconRenderer extends GeoEntityRenderer<DeaconEntity> {

    public DeaconRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/deacon_line/deacon")));
    }

    @Override
    protected float getShadowRadius(@NotNull DeaconEntity entity) {
        return 0.5f;
    }
}
