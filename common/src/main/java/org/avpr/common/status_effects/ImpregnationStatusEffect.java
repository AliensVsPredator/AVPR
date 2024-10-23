package org.avpr.common.status_effects;

import mod.azure.azurelib.core.object.Color;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.api.util.DamageUtil;
import org.avpr.common.api.util.EntityUtil;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.registries.AVPRDamageSources;
import org.avpr.common.registries.AVPRSounds;
import org.avpr.common.tags.AVPREntityTags;

public class ImpregnationStatusEffect extends MobEffect {

    public ImpregnationStatusEffect() {
        super(MobEffectCategory.HARMFUL, Color.DARK_GRAY.getColor());
    }

    /**
     * Handles the removal of the {@code ImpregnationStatusEffect} from a {@code LivingEntity}. This method checks
     * various conditions to ensure the effect removal process is valid and allowed.
     * <ul>
     * <li>If the entity is in creative mode or spectator mode, the process will be terminated.</li>
     * <li>If the entity type is not categorized under hosts, the process will be terminated.</li>
     * <li>If the method is called on the client-side or the {@code MobEffectInstance} effect is not an instance of
     * {@code ImpregnationStatusEffect}, the process will be terminated.</li>
     * <li>If the entity is a mob and its AI is disabled, the process will be terminated.</li>
     * <li>Upon validation, the method handles spawning a burster entity, setting its properties, and damaging the armor
     * and health of the original entity.</li>
     * </ul>
     *
     * @param entity            The {@code LivingEntity} from which the effect is being removed.
     * @param mobEffectInstance The {@code MobEffectInstance} being removed.
     */
    public static void effectRemoval(LivingEntity entity, MobEffectInstance mobEffectInstance) {
        if (PredicatesUtil.IS_CREATIVEorSPECTATOR.test(entity))
            return;
        if (!entity.getType().is(AVPREntityTags.HOSTS))
            return;
        if (entity.level().isClientSide || !(mobEffectInstance.getEffect().value() instanceof ImpregnationStatusEffect))
            return;
        if (entity instanceof Mob mob && mob.isNoAi())
            return;
        var burster = EntityUtil.spawnBurster(entity);
        if (burster != null) {
            setBursterProperties(entity, burster);
            entity.level().addFreshEntity(burster);
            entity.level()
                .playSound(
                    entity,
                    entity.blockPosition(),
                    AVPRSounds.ENTITY_CHESTBURSTER_HURT.get(),
                    SoundSource.NEUTRAL,
                    2.0f,
                    1.0f
                );
            if (!PredicatesUtil.IS_CREATIVEorSPECTATOR.test(entity))
                DamageUtil.damageArmor(entity.getItemBySlot(EquipmentSlot.CHEST), entity.getRandom(), 5, 10);
            entity.hurt(DamageUtil.of(entity.level(), AVPRDamageSources.CHESTBURST), Integer.MAX_VALUE);
        }
    }

    /**
     * Sets the properties of a burster entity based on an existing entity.
     *
     * @param entity  The original {@code LivingEntity} from which the burster entity is derived.
     * @param burster The burster {@code LivingEntity} that will have properties set.
     */
    private static void setBursterProperties(LivingEntity entity, LivingEntity burster) {
        if (entity.hasCustomName())
            burster.setCustomName(entity.getCustomName());
        burster.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 10), burster);
        burster.moveTo(entity.blockPosition(), entity.getYRot(), entity.getXRot());
    }

    /**
     * Determines whether an effect tick should be applied during the current tick.
     *
     * @param duration  The remaining duration of the effect in ticks.
     * @param amplifier The level or intensity of the effect.
     * @return true if the effect tick should be applied this tick, otherwise false.
     */
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    /**
     * Applies a series of status effects to a LivingEntity if it does not already have those effects.
     *
     * @param livingEntity  The LivingEntity to which the status effects will be applied.
     * @param ticks         The duration in ticks for which the status effects will last.
     * @param statusEffects A variable number of Holder<MobEffect> representing the status effects to be applied.
     */
    @SafeVarargs
    private void handleStatusEffects(@NotNull LivingEntity livingEntity, int ticks, Holder<MobEffect>... statusEffects) {
        for (Holder<MobEffect> effect : statusEffects)
            if (!livingEntity.hasEffect(effect))
                livingEntity.addEffect(new MobEffectInstance(effect, ticks, 3, true, true));
    }
}
