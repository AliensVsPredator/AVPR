package org.avpr.common.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

import org.avpr.common.CommonMod;
import org.avpr.common.platform.AVPRServices;

public record AVPRSounds() {

    public static Supplier<SoundEvent> BLOCK_ACID_BURN = AVPRSounds.registerSound(
        "block.acid.burn",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "block.acid.burn")
        )
    );

    public static Supplier<SoundEvent> OVAMORPH_OPEN = AVPRSounds.registerSound(
        "entity.ovamorph.open",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.ovamorph.open")
        )
    );

    public static Supplier<SoundEvent> IMPREGNATE = AVPRSounds.registerSound(
        "entity.parasite.impregnate",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.parasite.impregnate")
        )
    );

    /**
     * Example of using this method to create a new SoundEvent:
     * <p>
     * The following code demonstrates how to register a new sound event in the game:
     * </p>
     *
     * <pre>{@code
     *
     * public static Supplier<SoundEvent> TEST_SOUND = AVPRSounds.registerSound(
     *     "test_sound",
     *     () -> SoundEvent.createVariableRangeEvent(
     *         ResourceLocation.fromNamespaceAndPath("modid", "test_sound")
     *     )
     * );
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerSound</code> is a method to register a new sound event with the specified sound name.</li>
     * <li><code>SoundEvent</code> is used to create a new sound event instance.</li>
     * </ul>
     * <p>
     * The {@link SoundEvent SoundEvent} class represents a sound event in the game.
     * </p>
     * Registers a new sound event.
     *
     * @param soundName The name of the sound event.
     * @param sound     A supplier for the sound event.
     * @param <T>       The type of the sound event.
     * @return A supplier for the registered sound event.
     */
    static <T extends SoundEvent> Supplier<T> registerSound(String soundName, Supplier<T> sound) {
        return AVPRServices.COMMON_REGISTRY.registerSound(CommonMod.MOD_ID, soundName, sound);
    }

    public static void initialize() {}
}
