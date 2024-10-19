package org.avpr.common.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import org.avpr.common.CommonMod;

public record AVPRDamageSources() {

    public static final ResourceKey<DamageType> ACID = ResourceKey.create(Registries.DAMAGE_TYPE, CommonMod.modResource("acid"));

    public static final ResourceKey<DamageType> BULLET = ResourceKey.create(Registries.DAMAGE_TYPE, CommonMod.modResource("bullet"));

    public static final ResourceKey<DamageType> CHESTBURST = ResourceKey.create(
        Registries.DAMAGE_TYPE,
        CommonMod.modResource("chestburst")
    );
}
