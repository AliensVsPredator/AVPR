package org.avpr.common.items.armor;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

import org.avpr.common.client.items.renders.ArmorRenderer;

/**
 * TODO:
 * <ul>
 * <li>Get the flashlight working on tactical armor chestplate using the new
 * {@link org.avpr.common.entities.LightEntity}.</li>
 * </ul>
 */
public class AVPRGeoArmorItem extends ArmorItem implements GeoItem {

    protected final String id;

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public AVPRGeoArmorItem(String id, Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
        this.id = id;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public String getItemID() {
        return this.id;
    }

    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {

            private ArmorRenderer<AVPRGeoArmorItem> renderer;

            @Override
            public HumanoidModel<LivingEntity> getHumanoidArmorModel(
                LivingEntity livingEntity,
                ItemStack itemStack,
                EquipmentSlot equipmentSlot,
                HumanoidModel<LivingEntity> original
            ) {
                if (renderer == null) {
                    renderer = new ArmorRenderer<>(getItemID());
                }
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }
}
