package org.avpr.common.items.tools;

import com.google.common.base.Suppliers;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import org.avpr.common.registries.AVPRItems;

/**
 * Enum representing different tool materials available in the AVPR mod. Each material defines properties such as
 * durability, mining speed, attack damage, enchantability, and the ingredient required for repairing tools made of that
 * material.
 */
public enum AVPRToolMaterials implements Tier {

    ALUMINUM(BlockTags.INCORRECT_FOR_IRON_TOOL, 200, 5.0F, 1.5F, 10, () -> Ingredient.of(AVPRItems.INGOT_ALUMINUM.get())),
    ORIONITE(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1750, 8.5F, 3.5F, 12, () -> Ingredient.of(AVPRItems.INGOT_ORIONITE.get())),
    TITANIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1000, 7.0F, 2.5F, 12, () -> Ingredient.of(AVPRItems.INGOT_TITANIUM.get())),
    VERITANIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3000, 10.0F, 5.0F, 10, () -> Ingredient.of(AVPRItems.VERITANIUM_SHARD.get()));

    private final TagKey<Block> inverseTag;

    private final int itemDurability;

    private final float miningSpeed;

    private final float attackDamage;

    private final int enchantability;

    private final Supplier<Ingredient> repairIngredient;

    /**
     * Constructs an instance of AVPRToolMaterials with specified properties.
     *
     * @param inverseTag       The tag of blocks for which the material is incorrect.
     * @param itemDurability   The durability of the tool made from this material.
     * @param miningSpeed      The speed at which the material can mine.
     * @param attackDamage     The attack damage of the tool made from this material.
     * @param enchantability   The enchantability of the material.
     * @param repairIngredient The ingredient used to repair the tool made from this material.
     */
    AVPRToolMaterials(
        final TagKey<Block> inverseTag,
        final int itemDurability,
        final float miningSpeed,
        final float attackDamage,
        final int enchantability,
        final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getUses() {
        return this.itemDurability;
    }

    @Override
    public float getSpeed() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
