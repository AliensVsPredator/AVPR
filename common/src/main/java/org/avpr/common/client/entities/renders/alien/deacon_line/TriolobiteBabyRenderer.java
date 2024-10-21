package org.avpr.common.client.entities.renders.alien.deacon_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.deacon_line.TriolobiteBabyEntity;

public class TriolobiteBabyRenderer extends GeoEntityRenderer<TriolobiteBabyEntity> {

    public TriolobiteBabyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/deacon_line/trilobite_baby")));
    }

    @Override
    protected float getShadowRadius(@NotNull TriolobiteBabyEntity entity) {
        return 0.5f;
    }
}
