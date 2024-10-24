package org.avpr.common.items.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

/**
 * TODO:
 * <ul>
 * <li>Move to {@link mod.azure.azurelib.common.api.common.animatable.GeoItem} to add the new armor.</li>
 * <li>Get the flashlight working on tactical armor chestplate using the new
 * {@link org.avpr.common.entities.LightEntity}.</li>
 * </ul>
 */
public class AVPRArmorItem extends ArmorItem {

    public AVPRArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }
}
