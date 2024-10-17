package org.avpr.common.api.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class DamageUtil {

    public static DamageSource of(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }

    public static void damageArmor(ItemStack itemStack, RandomSource randomSource, int minDamage, int maxDamage) {
        if (!Objects.equals(itemStack, ItemStack.EMPTY))
            itemStack.setDamageValue(itemStack.getDamageValue() + randomSource.nextIntBetweenInclusive(minDamage, maxDamage));
    }
}
