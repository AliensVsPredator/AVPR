package org.avpr.common.client.entities.models;

import mod.azure.azurelib.common.api.client.model.DefaultedEntityGeoModel;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class DefaultEntityModel<T extends GeoAnimatable> extends DefaultedEntityGeoModel<T> {
    public DefaultEntityModel(ResourceLocation assetSubpath) {
        super(assetSubpath);
    }

    @Override
    public RenderType getRenderType(T animatable, ResourceLocation texture) {
        return RenderType.entityTranslucentCull(texture);
    }
}
