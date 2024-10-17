package org.avpr.common.status_effects;

import mod.azure.azurelib.core.object.Color;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.avpr.common.api.util.DamageUtil;
import org.avpr.common.api.util.EntityUtil;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.registries.AVPRDamageSources;
import org.avpr.common.tags.AVPREntityTags;
import org.jetbrains.annotations.NotNull;

public class ImpregnationStatusEffect extends MobEffect {

    public ImpregnationStatusEffect() {
        super(MobEffectCategory.HARMFUL, Color.DARK_GRAY.getColor());
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @SafeVarargs
    private void handleStatusEffects(@NotNull LivingEntity livingEntity, int ticks, Holder<MobEffect>... statusEffects) {
        for (Holder<MobEffect> effect : statusEffects)
            if (!livingEntity.hasEffect(effect)) livingEntity.addEffect(new MobEffectInstance(effect, ticks, 3, true, true));
    }

    public static void effectRemoval(LivingEntity entity, MobEffectInstance mobEffectInstance) {
        if (PredicatesUtil.IS_CREATIVEorSPECTATOR.test(entity)) return;
        if (!entity.getType().is(AVPREntityTags.HOSTS)) return;
        if (entity.level().isClientSide || !(mobEffectInstance.getEffect().value() instanceof ImpregnationStatusEffect)) return;
        if (entity instanceof Mob mob && mob.isNoAi()) return;
        var burster = EntityUtil.spawnBurster(entity);
        if (burster != null) {
            setBursterProperties(entity, burster);
            entity.level().addFreshEntity(burster);
//            entity.level().playSound(entity, entity.blockPosition(), AVPRSounds.CHESTBURSTING.get(), SoundSource.NEUTRAL, 2.0f, 1.0f);
            if (!PredicatesUtil.IS_CREATIVEorSPECTATOR.test(entity))
                DamageUtil.damageArmor(entity.getItemBySlot(EquipmentSlot.CHEST), entity.getRandom(), 5, 10);
            entity.hurt(DamageUtil.of(entity.level(), AVPRDamageSources.CHESTBURST), Integer.MAX_VALUE);
        }
    }

    private static void setBursterProperties(LivingEntity entity, LivingEntity burster) {
        if (entity.hasCustomName()) burster.setCustomName(entity.getCustomName());
        burster.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10), burster);
        burster.moveTo(entity.blockPosition(), entity.getYRot(), entity.getXRot());
    }
}
