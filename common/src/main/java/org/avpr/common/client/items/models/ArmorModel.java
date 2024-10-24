package org.avpr.common.client.items.models;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import org.avpr.common.CommonMod;

public class ArmorModel<T extends Item & GeoItem> extends GeoModel<T> {

    String armorName;

    public ArmorModel(String setArmorName) {
        armorName = setArmorName;
    }

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return CommonMod.modResource("geo/item/" + armorName + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return CommonMod.modResource("textures/item/" + armorName + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return CommonMod.modResource("animations/item/empty.animation.json");
    }
}
