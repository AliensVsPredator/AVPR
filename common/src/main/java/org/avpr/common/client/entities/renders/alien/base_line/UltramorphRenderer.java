package org.avpr.common.client.entities.renders.alien.base_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.base_line.UltramorphEntity;

public class UltramorphRenderer extends GeoEntityRenderer<UltramorphEntity> {

    public UltramorphRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/base_line/ultramorph")));
    }

    @Override
    protected float getShadowRadius(@NotNull UltramorphEntity entity) {
        return 0.5f;
    }
}
