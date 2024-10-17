package org.avpr.common.mixins;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.avpr.common.api.util.Constants;
import org.avpr.common.api.util.DamageUtil;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.registries.AVPRDamageSources;
import org.avpr.common.registries.AVPRStatusEffects;
import org.avpr.common.status_effects.ImpregnationStatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    protected LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Shadow
    abstract boolean hasEffect(Holder<MobEffect> effect);

    @Shadow
    abstract boolean addEffect(MobEffectInstance effect);

    @Inject(method = {"isUsingItem"}, at = {@At("RETURN")}, cancellable = true)
    public void isUsingItem(CallbackInfoReturnable<Boolean> callbackInfo) {
        if (this.getPassengers().stream().anyMatch(FacehuggerEntity.class::isInstance))
            callbackInfo.setReturnValue(false);
    }

    @Inject(method = {"removeAllEffects"}, at = {@At("HEAD")}, cancellable = true)
    public void noMilkRemoval(CallbackInfoReturnable<Boolean> callbackInfo) {
        if (this.hasEffect(AVPRStatusEffects.IMPREGNATION))
            callbackInfo.setReturnValue(false);
    }

    @Inject(method = {"tick"}, at = {@At("HEAD")})
    void tick(CallbackInfo callbackInfo) {
        if (!this.level().isClientSide) {
            if (PredicatesUtil.shouldApplyImpEffects.test(this))
                this.hurt(DamageUtil.of(this.level(), AVPRDamageSources.CHESTBURST), 0.2f);
        }
    }

    @Inject(method = "onEffectRemoved(Lnet/minecraft/world/effect/MobEffectInstance;)V", at = @At(value = "TAIL"))
    private void runAtEffectRemoval(MobEffectInstance mobEffectInstance, CallbackInfo ci) {
        ImpregnationStatusEffect.effectRemoval(Constants.<LivingEntity>self(this), mobEffectInstance);
    }
}
