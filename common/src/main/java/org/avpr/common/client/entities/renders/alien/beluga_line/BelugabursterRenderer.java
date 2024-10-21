package org.avpr.common.client.entities.renders.alien.beluga_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.beluga_line.BelugabursterEntity;

public class BelugabursterRenderer extends GeoEntityRenderer<BelugabursterEntity> {

    public BelugabursterRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/beluga_line/belugaburster")));
    }

    @Override
    protected float getShadowRadius(@NotNull BelugabursterEntity entity) {
        return 0.5f;
    }
}
