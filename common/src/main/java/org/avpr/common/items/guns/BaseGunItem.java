package org.avpr.common.items.guns;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

import org.avpr.common.api.util.TooltipUtils;
import org.avpr.common.client.items.renders.GunRender;

public class BaseGunItem extends Item implements GeoItem {

    protected final String id;

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public BaseGunItem(String id, Properties properties) {
        super(properties);
        this.id = id;
    }

    public String getItemID() {
        return this.id;
    }

    @Override
    public void appendHoverText(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context,
        @NotNull List<Component> tooltipComponents,
        @NotNull TooltipFlag tooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        TooltipUtils.appendLabel(
            tooltipComponents,
            "tooltip.avp.ammunition_type",
            Component.literal(
                "Weapon features not yet implemented"
            )
        );
    }

    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {

            private final GunRender<BaseGunItem> renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return new GunRender<BaseGunItem>(getItemID());
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        /*
         * TODO
         */
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
