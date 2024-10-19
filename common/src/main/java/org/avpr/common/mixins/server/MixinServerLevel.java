package org.avpr.common.mixins.server;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.avpr.common.api.server.BlockBreakProgressManager;
import org.avpr.common.api.util.Tick;
import org.avpr.common.registries.AVPRItems;

@Mixin(ServerLevel.class)
public abstract class MixinServerLevel {

    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo callbackInfo) {
        var serverLevel = ServerLevel.class.cast(this);
        var self = ServerPlayer.class.cast(this);
        BlockBreakProgressManager.tick(serverLevel);

        if (
            self.tickCount % Tick.PER_SECOND == 0 &&
                self.getItemBySlot(EquipmentSlot.HEAD).is(AVPRItems.ARMOR_PRESSURE_HELMET.get()) &&
                self.getItemBySlot(EquipmentSlot.CHEST).is(AVPRItems.ARMOR_PRESSURE_CHESTPLATE.get()) &&
                self.getItemBySlot(EquipmentSlot.LEGS).is(AVPRItems.ARMOR_PRESSURE_LEGGINGS.get()) &&
                self.getItemBySlot(EquipmentSlot.FEET).is(AVPRItems.ARMOR_PRESSURE_BOOTS.get())
        ) {
            self.setAirSupply(self.getMaxAirSupply());
        }
    }
}
