package org.avpr.common.mixins.server;

import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.avpr.common.api.server.BlockBreakProgressManager;

@Mixin(ServerLevel.class)
public abstract class MixinServerLevel {

    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo callbackInfo) {
        var serverLevel = ServerLevel.class.cast(this);
        BlockBreakProgressManager.tick(serverLevel);
    }
}
