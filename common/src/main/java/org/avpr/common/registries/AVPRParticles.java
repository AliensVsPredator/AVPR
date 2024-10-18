package org.avpr.common.registries;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import org.avpr.common.CommonMod;
import org.avpr.common.particles.AVPRPaticleType;
import org.avpr.common.platform.AVPRServices;

import java.util.function.Supplier;

public record AVPRParticles() {

    public static final Supplier<SimpleParticleType> ACID = AVPRParticles.registerParticle("acid", () -> new AVPRPaticleType(true));

    /**
     * Example of using this method to create a new Particle:
     * <p>
     * The following code demonstrates how to register a new particle type in the game:
     * </p>
     * <pre>{@code
     * public static final Supplier<SimpleParticleType> TEST = AVPRParticles.registerParticle("particlename", () -> new AVPRPaticleType(true));
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerParticle</code> is a method to register a new particle with the specified particle name.</li>
     * <li><code>SimpleParticleType</code> is used to create a new particle type instance.</li>
     * </ul>
     * <p>
     * The {@link net.minecraft.core.particles.SimpleParticleType SimpleParticleType} class represents a basic particle type in the game.
     * </p>
     *
     * Registers a new Particle.
     *
     * @param particleName The ID of the particle.
     * @param particle     A supplier for the particle type.
     * @param <T>          The type of the particle type.
     * @return A supplier for the registered particle type.
     */
    static <T extends ParticleType<?>> Supplier<T> registerParticle(String particleName, Supplier<T> particle) {
        return AVPRServices.COMMON_REGISTRY.registerParticle(CommonMod.MOD_ID, particleName, particle);
    }

    public static void initialize() {
    }
}
