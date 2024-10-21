package org.avpr.common.client.entities.renders.alien.deacon_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.deacon_line.DeaconAdultEngineerEntity;

public class DeaconAdultEngineerRenderer extends GeoEntityRenderer<DeaconAdultEngineerEntity> {

    public DeaconAdultEngineerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/deacon_line/deacon_adult_engineer")));
    }

    @Override
    protected float getShadowRadius(@NotNull DeaconAdultEngineerEntity entity) {
        return 0.5f;
    }
}
