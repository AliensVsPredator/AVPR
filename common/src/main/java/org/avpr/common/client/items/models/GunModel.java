package org.avpr.common.client.items.models;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.avpr.common.CommonMod;

public class GunModel<T extends Item & GeoItem> extends GeoModel<T> {
    String gunname;

    public GunModel(String gunName) {
        gunname = gunName;
    }
    @Override
    public ResourceLocation getModelResource(T animatable) {
        return CommonMod.modResource("geo/item/" + gunname + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return CommonMod.modResource("textures/item/" + gunname + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        if (gunname.equals("weapon_old_painless"))
            return CommonMod.modResource("animations/item/" + gunname + ".animation.json");
        return CommonMod.modResource("animations/item/empty.animation.json");
    }
}
