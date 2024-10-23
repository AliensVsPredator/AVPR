package org.avpr.common.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import org.jetbrains.annotations.NotNull;

/**
 * Provides the creation and management of AcidParticle instances. This class implements the ParticleProvider interface
 * and is responsible for spawning AcidParticle with the specified properties.
 *
 * @param <T> The type of ParticleOptions associated with this provider.
 */
public class AcidParticleProvider<T extends ParticleOptions> implements ParticleProvider<T> {

    private final SpriteSet spriteProvider;

    public AcidParticleProvider(SpriteSet spriteProvider) {
        this.spriteProvider = spriteProvider;
    }

    /**
     * Creates an AcidParticle with the given parameters.
     *
     * @param particleOptions Options for configuring the particle.
     * @param clientWorld     The client world in which the particle exists.
     * @param d               The initial x-coordinate of the particle.
     * @param e               The initial y-coordinate of the particle.
     * @param f               The initial z-coordinate of the particle.
     * @param g               The initial velocity in the x-direction.
     * @param h               The initial velocity in the y-direction.
     * @param i               The initial velocity in the z-direction.
     * @return A new instance of an AcidParticle configured with the provided parameters.
     */
    @Override
    public Particle createParticle(
        @NotNull ParticleOptions particleOptions,
        @NotNull ClientLevel clientWorld,
        double d,
        double e,
        double f,
        double g,
        double h,
        double i
    ) {
        return new AcidParticle(clientWorld, d, e, f, g, h, i, spriteProvider);
    }
}
