package org.avpr.common.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.avpr.common.CommonMod;

public class AVPRItemTags {

    public static final TagKey<Item> ACID_IMMUNE = CommonMod.create(Registries.ITEM, "acid_immune");
}
