package org.avpr.common.api.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Objects;

/**
 * Utility class for handling damage-related operations in the game.
 */
public record DamageUtil() {

    public static DamageSource of(Level level, ResourceKey<DamageType> key) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(key));
    }

    /**
     * Inflicts damage on the specified armor item within the bounds of the given minimum and maximum damage values.
     *
     * @param itemStack    The armor ItemStack to be damaged.
     * @param randomSource The RandomSource instance used to generate a random damage value.
     * @param minDamage    The minimum amount of damage to be inflicted on the armor.
     * @param maxDamage    The maximum amount of damage to be inflicted on the armor.
     */
    public static void damageArmor(ItemStack itemStack, RandomSource randomSource, int minDamage, int maxDamage) {
        if (!Objects.equals(itemStack, ItemStack.EMPTY))
            itemStack.setDamageValue(itemStack.getDamageValue() + randomSource.nextIntBetweenInclusive(minDamage, maxDamage));
    }
}
