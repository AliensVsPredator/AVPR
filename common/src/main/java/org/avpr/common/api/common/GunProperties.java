package org.avpr.common.api.common;

import net.minecraft.sounds.SoundEvent;

import java.util.List;

/**
 * Represents the properties of a gun including sounds for reloading and firing, as well as the available fire modes.
 *
 * @param reloadSound The sound event associated with reloading the gun.
 * @param firingSound The sound event associated with firing the gun.
 * @param gunFireMode A list of available fire modes for the gun.
 */
public record GunProperties(
    SoundEvent reloadSound,
    SoundEvent firingSound,
    List<GunFireMode> gunFireMode
) {}
