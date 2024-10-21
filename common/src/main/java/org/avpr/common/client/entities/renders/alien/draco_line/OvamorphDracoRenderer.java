package org.avpr.common.client.entities.renders.alien.draco_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.draco_line.OvamorphDracoEntity;

public class OvamorphDracoRenderer extends GeoEntityRenderer<OvamorphDracoEntity> {

    public OvamorphDracoRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/draco_line/ovamorph_draco")));
        this.withScale(1.75F);
    }

    @Override
    protected float getShadowRadius(@NotNull OvamorphDracoEntity entity) {
        return 0.5f;
    }

    @Override
    protected float getDeathMaxRotation(OvamorphDracoEntity entityLivingBaseIn) {
        return 0.0F;
    }
}
