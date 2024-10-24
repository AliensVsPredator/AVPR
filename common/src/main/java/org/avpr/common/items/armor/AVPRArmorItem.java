package org.avpr.common.items.armor;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

/**
 * TODO:
 * <ul>
 * <li>Move to {@link AVPRGeoArmorItem} to add the new armor.</li>
 * </ul>
 */
public class AVPRArmorItem extends ArmorItem {

    public AVPRArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }
}
