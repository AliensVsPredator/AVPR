package org.avpr.common.api.common;

import net.minecraft.sounds.SoundEvent;

import java.util.List;

public record GunProperties(
    SoundEvent reloadSound,
    SoundEvent firingSound,
    List<GunFireMode> gunFireMode
) {}
