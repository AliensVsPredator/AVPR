package org.avpr.common.api.util;

import mod.azure.azurelib.core.animation.RawAnimation;

public class Constants {

    public static final String ATTACK_CONTROLLER = "attackController";
    public static final String LIVING_CONTROLLER = "livingController";
    public static final RawAnimation HATCHED = RawAnimation.begin().thenLoop("egg.open_loop");
    public static final RawAnimation HATCHING = RawAnimation.begin().thenPlay("animation.egg.open");
}
