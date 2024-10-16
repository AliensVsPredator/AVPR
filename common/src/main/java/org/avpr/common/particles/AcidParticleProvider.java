package org.avpr.common.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleOptions;
import org.jetbrains.annotations.NotNull;

public class AcidParticleProvider<T extends ParticleOptions> implements ParticleProvider<T> {

    private final SpriteSet spriteProvider;

    public AcidParticleProvider(SpriteSet spriteProvider) {
        this.spriteProvider = spriteProvider;
    }

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
