package org.avpr.common.registries;

import net.minecraft.world.level.material.Fluid;
import org.avpr.common.CommonMod;
import org.avpr.common.platform.AVPRServices;

import java.util.function.Supplier;

public class AVPRFluids {

    /**
     * Example of using this method to create a new Fluid:
     * <p>
     * The following code demonstrates how to register a new Fluid in the game:
     * </p>
     * <pre>{@code
     * public static final Supplier<Fluid> TEST_FLUID = AVPRFluids.registerFluid("fluidName", () -> new CustomFluid());
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerFluid</code> is a method to register a new fluid with the specified fluid name.</li>
     * <li><code>Fluid</code> is the base class for all fluids in the game.</li>
     * <li><code>CustomFluid</code> is a user-defined class extending <code>Fluid</code>.</li>
     * </ul>
     * <p>
     * The {@link Fluid Fluid} class represents a fluid in the game.
     * </p>
     *
     * Registers a new fluid.
     *
     * @param itemName The name of the fluid.
     * @param fluid    A supplier that provides an instance of the fluid.
     * @param <T>      The type of the fluid extending from {@link Fluid}.
     * @return A supplier that provides the registered fluid.
     */
    static <T extends Fluid> Supplier<T> registerFluid(String itemName, Supplier<T> fluid) {
        return AVPRServices.COMMON_REGISTRY.registerFluid(CommonMod.MOD_ID, itemName, fluid);
    }

    public static void initialize() {
    }
}
