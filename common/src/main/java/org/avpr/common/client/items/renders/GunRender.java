package org.avpr.common.client.items.renders;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import net.minecraft.world.item.Item;

import org.avpr.common.client.items.models.GunModel;

public class GunRender<T extends Item & GeoItem> extends GeoItemRenderer<T> {

    public GunRender(String gunName) {
        super(new GunModel<>(gunName));
    }
}
