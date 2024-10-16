package org.avpr.common.registries;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import org.avpr.common.CommonMod;
import org.avpr.common.platform.AVPRServices;

import java.util.function.Supplier;

public class AVPRStatusEffects {

    /**
     * Example of using this method to create a new Status Effect:
     * <p>
     * The following code demonstrates how to register a new Status Effect in the game:
     * </p>
     * <pre>{@code
     * public static final Holder<MobEffect> TEST_EFFECT = AVPRStatusEffects.registerStatusEffect("effectName", () -> new CustomMobEffect(
     *             MobEffectCategory.HARMFUL, Color.BLACK.getColor()));
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerStatusEffect</code> is a method to register a new status effect with the specified effect name.</li>
     * <li><code>MobEffect</code> is the base class for all status effects in the game.</li>
     * <li><code>CustomMobEffect</code> is a user-defined class extending <code>MobEffect</code>.</li>
     * <li><code>MobEffectCategory.HARMFUL</code> specifies the category of the status effect.</li>
     * <li><code>Color.BLACK.getColor()</code> specifies the color of the status effect.</li>
     * </ul>
     * <p>
     * The {@link MobEffect MobEffect} class represents a status effect in the game.
     * </p>
     * <p>
     * The {@link net.minecraft.world.effect.MobEffectCategory MobEffectCategory} class represents the category of a status effect in the game.
     * </p>
     *
     * Registers a new Status Effect.
     *
     * @param effectName   The name of the Status Effect.
     * @param statusEffect A supplier that provides an instance of the Status Effect.
     * @param <T>          The type of the status effect extending from {@link MobEffect}.
     * @return A holder that provides the registered status effect.
     */
    static <T extends MobEffect> Holder<T> registerStatusEffect(String effectName, Supplier<T> statusEffect) {
        return AVPRServices.COMMON_REGISTRY.registerStatusEffect(CommonMod.MOD_ID, effectName, statusEffect);
    }

    public static void initialize() {
    }
}
