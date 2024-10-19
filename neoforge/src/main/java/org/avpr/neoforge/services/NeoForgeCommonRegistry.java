package org.avpr.neoforge.services;

import net.minecraft.core.Holder;
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
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import java.util.function.Supplier;

import org.avpr.common.platform.CommonRegistry;
import org.avpr.neoforge.NeoForgeMod;
import org.avpr.neoforge.item.armor.AVPRNeoForgeArmorMaterials;

public class NeoForgeCommonRegistry implements CommonRegistry {

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(
        String modID,
        String blockEntityName,
        Supplier<BlockEntityType<T>> blockEntityType
    ) {
        return NeoForgeMod.blockEntityTypeDeferredRegister.register(blockEntityName, blockEntityType);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String modID, String blockName, Supplier<T> block) {
        return NeoForgeMod.blockDeferredRegister.register(blockName, block);
    }

    @Override
    public <T extends ArmorMaterial> Holder<T> registerArmorMaterial(String modID, String armorMaterialName, Supplier<T> armorMaterial) {
        return (Holder<T>) NeoForgeMod.armorMaterialDeferredRegister.register(armorMaterialName, armorMaterial);
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String modID, String entityName, Supplier<EntityType<T>> entity) {
        return NeoForgeMod.entityTypeDeferredRegister.register(entityName, entity);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String modID, String itemName, Supplier<T> item) {
        return NeoForgeMod.itemDeferredRegister.register(itemName, item);
    }

    @Override
    public <T extends SoundEvent> Supplier<T> registerSound(String modID, String soundName, Supplier<T> sound) {
        return NeoForgeMod.soundEventDeferredRegister.register(soundName, sound);
    }

    @Override
    public <T extends ParticleType<?>> Supplier<T> registerParticle(String modID, String particleName, Supplier<T> particle) {
        return NeoForgeMod.particleTypeDeferredRegister.register(particleName, particle);
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String tabName, Supplier<T> tab) {
        return NeoForgeMod.creativeModeTabDeferredRegister.register(tabName, tab);
    }

    @Override
    public <T extends MobEffect> Holder<T> registerStatusEffect(String modID, String effectName, Supplier<T> statusEffect) {
        return (Holder<T>) NeoForgeMod.statusEffectDeferredRegister.register(effectName, statusEffect);
    }

    @Override
    public <T extends Fluid> Supplier<T> registerFluid(String modID, String fluidName, Supplier<T> fluid) {
        return NeoForgeMod.fluidDeferredRegister.register(fluidName, fluid);
    }

    @Override
    public <E extends Mob> Supplier<SpawnEggItem> makeSpawnEggFor(
        Supplier<EntityType<E>> entityType,
        int primaryEggColour,
        int secondaryEggColour,
        Item.Properties itemProperties
    ) {
        return () -> new DeferredSpawnEggItem(entityType, primaryEggColour, secondaryEggColour, itemProperties);
    }

    @Override
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }

    @Override
    public Holder<ArmorMaterial> getAluminumMaterial() {
        return AVPRNeoForgeArmorMaterials.ALUMINUM;
    }

    @Override
    public Holder<ArmorMaterial> getMK50Material() {
        return AVPRNeoForgeArmorMaterials.MK50;
    }

    @Override
    public Holder<ArmorMaterial> getOrioniteMaterial() {
        return AVPRNeoForgeArmorMaterials.ORIONITE;
    }

    @Override
    public Holder<ArmorMaterial> getPressureMaterial() {
        return AVPRNeoForgeArmorMaterials.PRESSURE;
    }

    @Override
    public Holder<ArmorMaterial> getTacticalMaterial() {
        return AVPRNeoForgeArmorMaterials.TACTICAL;
    }

    @Override
    public Holder<ArmorMaterial> getTitaniumMaterial() {
        return AVPRNeoForgeArmorMaterials.TITANIUM;
    }

    @Override
    public Holder<ArmorMaterial> getVeritaniumMaterial() {
        return AVPRNeoForgeArmorMaterials.VERITANIUM;
    }

    @Override
    public Holder<ArmorMaterial> getXenomorphMaterial() {
        return AVPRNeoForgeArmorMaterials.XENOMORPH_CHITIN;
    }
}
