package org.avpr.common.client.items.renders;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import net.minecraft.world.item.Item;

import org.avpr.common.client.items.models.ArmorModel;

public class ArmorRenderer<T extends Item & GeoItem> extends GeoArmorRenderer<T> {

    public ArmorRenderer(String armorName) {
        super(new ArmorModel<>(armorName));
    }
}
