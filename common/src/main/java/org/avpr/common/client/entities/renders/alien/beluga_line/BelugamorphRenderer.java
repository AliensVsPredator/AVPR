package org.avpr.common.client.entities.renders.alien.beluga_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.beluga_line.BelugamorphEntity;

public class BelugamorphRenderer extends GeoEntityRenderer<BelugamorphEntity> {

    public BelugamorphRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/beluga_line/belugamorph")));
    }

    @Override
    protected float getShadowRadius(@NotNull BelugamorphEntity entity) {
        return 0.5f;
    }
}
