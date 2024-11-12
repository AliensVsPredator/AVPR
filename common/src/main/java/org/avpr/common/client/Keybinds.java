package org.avpr.common.client;

import net.minecraft.client.KeyMapping;

/**
 * The Keybinds class holds key mappings for various functions within the game. This record is used to define and store
 * key bindings, specifically the flashlight toggle key mapping in this context.
 */
public record Keybinds() {

    // TODO: This is a utility class, it should not be a record.

    public static KeyMapping FLASHLIGHT;
}
