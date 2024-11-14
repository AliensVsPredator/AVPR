package org.avpr.common.api.util;

import mod.azure.azurelib.core.animation.RawAnimation;

/**
 * A utility class that holds common constants and static methods used across multiple classes.
 */
// TODO: This class is way too broadly named, should be refactored.
public record Constants() {

    public static final String ATTACK_CONTROLLER = "attackController";

    public static final String LIVING_CONTROLLER = "livingController";

    /**
     * Animations
     */
    public static final RawAnimation HATCHED = RawAnimation.begin().thenLoop("egg.open_loop");

    public static final RawAnimation HATCHING = RawAnimation.begin().thenPlay("animation.egg.open");

    public static final RawAnimation TAIL_SWAY = RawAnimation.begin().thenLoop("animation.tailsway");

    public static final RawAnimation WALK = RawAnimation.begin().thenPlay("animation.walk");

    public static final RawAnimation FACEHUG = RawAnimation.begin().thenPlayAndHold("animation.facehug");

    public static final RawAnimation EAT = RawAnimation.begin().thenPlay("animation.eat");

    public static final RawAnimation BLADE_OPEN = RawAnimation.begin().thenPlayAndHold("animation.bladeopen");

    public static final RawAnimation BLADE_CLOSE = RawAnimation.begin().thenPlayAndHold("animation.bladeclose");

    public static final RawAnimation BLADE_ATTACK = RawAnimation.begin().thenPlay("animation.blade_attack");

    /**
     * Casts the given object to the specified type.
     *
     * @param object The object to be cast.
     * @return The object cast to the specified type.
     */
    public static <T> T self(Object object) {
        return (T) object;
    }
}
