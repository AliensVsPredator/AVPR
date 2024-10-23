package org.avpr.common.particles;

import net.minecraft.core.particles.SimpleParticleType;

/**
 * The AVPRPaticleType class extends SimpleParticleType to represent a specific type of particle in the game. This class
 * allows for the creation of particles with unique behavior or characteristics. The constructor takes a boolean
 * parameter to determine whether to override the particle limit.
 *
 * @see SimpleParticleType
 */
public class AVPRPaticleType extends SimpleParticleType {

    public AVPRPaticleType(boolean overrideLimiter) {
        super(overrideLimiter);
    }
}
