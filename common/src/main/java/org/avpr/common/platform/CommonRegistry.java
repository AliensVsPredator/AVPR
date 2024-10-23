package org.avpr.common.platform;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * CommonRegistry provides a set of methods for registering various game components such as blocks, entities, items,
 * sounds, particles, and other elements.
 */
public interface CommonRegistry {

    /**
     * Checks if a mod with the specified ID is loaded.
     *
     * @param modId The unique identifier for the mod.
     * @return true if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(
        String modID,
        String blockEntityName,
        Supplier<BlockEntityType<T>> blockEntityType
    );

    <T extends Block> Supplier<T> registerBlock(String modID, String blockName, Supplier<T> block);

    <T> Supplier<DataComponentType<T>> registerDataComponentType(
        String dataComponentName,
        UnaryOperator<DataComponentType.Builder<T>> builderOperator
    );

    <T extends Entity> Supplier<EntityType<T>> registerEntity(String modID, String entityName, Supplier<EntityType<T>> entity);

    <T extends Item> Supplier<T> registerItem(String modID, String itemName, Supplier<T> item);

    <T extends SoundEvent> Supplier<T> registerSound(String modID, String soundName, Supplier<T> sound);

    <T extends ParticleType<?>> Supplier<T> registerParticle(String modID, String particleName, Supplier<T> particle);

    <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String tabName, Supplier<T> tab);

    <T extends MobEffect> Holder<T> registerStatusEffect(String modID, String effectName, Supplier<T> statusEffect);

    <T extends Fluid> Supplier<T> registerFluid(String modID, String fluidName, Supplier<T> item);

    <E extends Mob> Supplier<SpawnEggItem> makeSpawnEggFor(
        Supplier<EntityType<E>> entityType,
        int primaryEggColour,
        int secondaryEggColour,
        Item.Properties itemProperties
    );

    CreativeModeTab.Builder newCreativeTabBuilder();

    Holder<ArmorMaterial> getAluminumMaterial();

    Holder<ArmorMaterial> getMK50Material();

    Holder<ArmorMaterial> getOrioniteMaterial();

    Holder<ArmorMaterial> getPressureMaterial();

    Holder<ArmorMaterial> getTacticalMaterial();

    Holder<ArmorMaterial> getTitaniumMaterial();

    Holder<ArmorMaterial> getVeritaniumMaterial();

    Holder<ArmorMaterial> getXenomorphMaterial();
}
