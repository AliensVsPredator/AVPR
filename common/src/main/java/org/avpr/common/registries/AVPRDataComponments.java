package org.avpr.common.registries;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.avpr.common.platform.AVPRServices;

public record AVPRDataComponments() {

    public static final Supplier<DataComponentType<Integer>> MAX_AMMO = registerDataComponent(
        "max_ammo_count",
        builder -> builder.persistent(ExtraCodecs.NON_NEGATIVE_INT)
            .networkSynchronized(
                ByteBufCodecs.VAR_INT
            )
    );

    public static final Supplier<DataComponentType<Integer>> GUN_DAMAGE = registerDataComponent(
        "gun_damage",
        builder -> builder.persistent(ExtraCodecs.NON_NEGATIVE_INT)
            .networkSynchronized(
                ByteBufCodecs.VAR_INT
            )
    );

    public static final Supplier<DataComponentType<Integer>> GUN_ACCURACY = registerDataComponent(
        "gun_accuracy",
        builder -> builder.persistent(ExtraCodecs.NON_NEGATIVE_INT)
            .networkSynchronized(
                ByteBufCodecs.VAR_INT
            )
    );

    public static final Supplier<DataComponentType<Double>> GUN_RECOIL = registerDataComponent(
        "gun_recoil",
        builder -> builder.persistent(Codec.DOUBLE)
    );

    public static final Supplier<DataComponentType<Integer>> GUN_FIRERATE = registerDataComponent(
        "gun_firerate",
        builder -> builder.persistent(ExtraCodecs.NON_NEGATIVE_INT)
            .networkSynchronized(
                ByteBufCodecs.VAR_INT
            )
    );

    public static final Supplier<DataComponentType<Integer>> GUN_RELOAD_TICKS = registerDataComponent(
        "gun_reload_ticks",
        builder -> builder.persistent(ExtraCodecs.NON_NEGATIVE_INT)
            .networkSynchronized(
                ByteBufCodecs.VAR_INT
            )
    );

    public static final Supplier<DataComponentType<Double>> GUN_KNOCKBACK = registerDataComponent(
        "gun_knockback",
        builder -> builder.persistent(Codec.DOUBLE)
    );

    public static final Supplier<DataComponentType<Double>> GUN_RANGE = registerDataComponent(
        "gun_range",
        builder -> builder.persistent(Codec.DOUBLE)
    );

    public static final Supplier<DataComponentType<Double>> GUN_WIND_UP_LONG = registerDataComponent(
        "gun_wind_up_long",
        builder -> builder.persistent(Codec.DOUBLE)
    );

    public static final Supplier<DataComponentType<Boolean>> GUN_HAS_WINDUP = registerDataComponent(
        "gun_has_windup",
        builder -> builder.persistent(Codec.BOOL)
            .networkSynchronized(
                ByteBufCodecs.BOOL
            )
    );

    public static final Supplier<DataComponentType<Boolean>> GUN_IS_WINDINGUP = registerDataComponent(
        "gun_is_windingup",
        builder -> builder.persistent(Codec.BOOL)
            .networkSynchronized(
                ByteBufCodecs.BOOL
            )
    );

    public static final Supplier<DataComponentType<Boolean>> SHOULD_RENDER_AS_CROSSBOW = registerDataComponent(
        "shouldnt_render_as_bow",
        builder -> builder.persistent(Codec.BOOL)
            .networkSynchronized(
                ByteBufCodecs.BOOL
            )
    );

    public static final Supplier<DataComponentType<Boolean>> STOP_ANIMATIONS = registerDataComponent(
            "stop_animations",
            builder -> builder.persistent(Codec.BOOL)
                    .networkSynchronized(
                            ByteBufCodecs.BOOL
                    )
    );

    public static final Supplier<DataComponentType<Integer>> CURRENT_AMMO = registerDataComponent(
        "current_ammo_count",
        builder -> builder.persistent(ExtraCodecs.NON_NEGATIVE_INT)
            .networkSynchronized(
                ByteBufCodecs.VAR_INT
            )
    );

    /**
     * Example:
     *
     * <pre>{@code
     *
     * public static final Supplier<DataComponentType<Long>> STACK_LONG_COMPONENT = registerDataComponent(
     *     "stack_long",
     *     builder -> builder.persistent(Codec.LONG)
     *         .networkSynchronized(ByteBufCodecs.VAR_LONG)
     * );
     * }</pre>
     *
     * The example registers a data component named "stack_long" that stores a {@code Long} value, making it persistent
     * and network-synchronized using a variable-length long codec. Registers a new {@link DataComponentType} with the
     * specified name and configuration. This method allows the creation and registration of custom data components,
     * which can store and manage data associated with entities or blocks.
     *
     * @param dataComponentName The name of the data component to register. This should be a unique identifier for the
     *                          component.
     * @param builderOperator   A {@link UnaryOperator} that configures the {@link DataComponentType.Builder} for the
     *                          component. It can be used to set properties such as persistence, network
     *                          synchronization, and encoding.
     * @param <T>               The type of data the component will store (e.g., Long, Integer, Custom Object).
     * @return A {@link Supplier} that supplies the registered {@link DataComponentType} when invoked. This is useful
     *         for lazy initialization or deferred registration scenarios.
     */
    public static <T> Supplier<DataComponentType<T>> registerDataComponent(
        String dataComponentName,
        UnaryOperator<DataComponentType.Builder<T>> builderOperator
    ) {
        return AVPRServices.COMMON_REGISTRY.registerDataComponentType(dataComponentName, builderOperator);
    }

    public static void initialize() {}
}
