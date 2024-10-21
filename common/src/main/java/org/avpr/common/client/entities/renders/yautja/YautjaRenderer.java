package org.avpr.common.client.entities.renders.yautja;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.yautja.YautjaModel;
import org.avpr.common.entities.yautja.YautjaEntity;

public class YautjaRenderer extends GeoEntityRenderer<YautjaEntity> {

    public YautjaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new YautjaModel(CommonMod.modResource("yautja/yautja")));
    }

    @Override
    protected float getShadowRadius(@NotNull YautjaEntity entity) {
        return 0.5f;
    }
}
