package org.avpr.common.mixins.server;

import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRItems;

@Mixin(ServerPlayer.class)
public abstract class MixinServerPlayer extends Player {

    protected MixinServerPlayer(Level level, BlockPos blockPos, float f, GameProfile gameProfile) {
        super(level, blockPos, f, gameProfile);
    }

    /**
     * Handles the periodic actions for a ServerPlayer instance. This method is executed on each game tick to ensure
     * players wearing specific armor pieces have their air supply replenished and to spawn a light entity if the player
     * is wearing the tactical chestplate.
     *
     * @param callbackInfo the callback information from the mixin injection point
     */
    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo callbackInfo) {
        var self = ServerPlayer.class.cast(this);
        if (
            self.tickCount % org.avpr.common.api.util.Tick.PER_SECOND == 0 &&
                self.getItemBySlot(EquipmentSlot.HEAD).is(AVPRItems.ARMOR_PRESSURE_HELMET.get()) &&
                self.getItemBySlot(EquipmentSlot.CHEST).is(AVPRItems.ARMOR_PRESSURE_CHESTPLATE.get()) &&
                self.getItemBySlot(EquipmentSlot.LEGS).is(AVPRItems.ARMOR_PRESSURE_LEGGINGS.get()) &&
                self.getItemBySlot(EquipmentSlot.FEET).is(AVPRItems.ARMOR_PRESSURE_BOOTS.get())
        ) {
            self.setAirSupply(self.getMaxAirSupply());
        }
        if (
            self.getItemBySlot(EquipmentSlot.CHEST).is(AVPRItems.ARMOR_TACTICAL_CHESTPLATE.get())
        )
            self.level().addFreshEntity(AVPREntities.LIGHT_ENTITY.get().create(self.level()));
    }
}
