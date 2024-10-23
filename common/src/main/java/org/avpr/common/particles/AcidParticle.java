package org.avpr.common.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a particle with an acidic visual effect, inheriting from TextureSheetParticle. AcidParticle simulates the
 * behavior of an acidic particle in the game world with custom movement physics, color variations, and lifetime
 * management.
 */
public class AcidParticle extends TextureSheetParticle {

    protected final SpriteSet spriteProvider;

    protected boolean reachedGround;

    public AcidParticle(ClientLevel clientWorld, double d, double e, double f, double g, double h, double i, SpriteSet spriteProvider) {
        super(clientWorld, d, e, f);
        xd = g;
        yd = h;
        zd = i;
        var red = 160 / 255.0f;
        var green = 158 / 255.0f;
        var blue = 9 / 255.0f;
        var colorRed = Mth.nextFloat(random, red - 0.05f, red + 0.05f);
        var colorGreen = Mth.nextFloat(random, green - 0.05f, green + 0.05f);
        var colorBlue = Mth.nextFloat(random, blue - 0.015f, blue + 0.015f);
        this.setColor(colorRed, colorGreen, colorBlue);
        this.gravity = 3.0E-6F;
        this.quadSize *= 0.75f;
        this.lifetime = (int) (10.0 / ((random.nextFloat()) * 0.8 + 0.2));
        this.reachedGround = false;
        this.hasPhysics = true;
        this.spriteProvider = spriteProvider;
        this.setSpriteFromAge(spriteProvider);
    }

    /**
     * Updates the state of the AcidParticle on each tick. Manages particle's position, velocity, age, and visibility.
     * The particle's previous position is saved, its velocity components are adjusted by adding small random values,
     * and it moves according to its velocity. If the particle's age exceeds its lifetime or its transparency (alpha) is
     * too low, the particle is removed from the system. Gradually decreases the alpha value as the particle reaches the
     * end of its lifetime.
     */
    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ < this.lifetime && this.alpha > 0) {
            this.xd += this.random.nextFloat() / 5000 * (this.random.nextBoolean() ? 1 : -1);
            this.zd += this.random.nextFloat() / 5000 * (this.random.nextBoolean() ? 1 : -1);
            this.yd -= this.gravity;
            this.move(this.xd, this.yd, this.zd);
            if (this.age >= this.lifetime && this.alpha > 0.01F)
                this.alpha -= 0.015F;
        } else
            this.remove();
    }

    /**
     * Gets the rendering type of the AcidParticle, specifying the rendering strategy to be used.
     *
     * @return The rendering type used for rendering the particle.
     */
    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    /**
     * Calculates the size of the particle's quad at a given tick delta, scaling it based on the particle's age and
     * lifetime.
     *
     * @param tickDelta The partial tick delta used to interpolate the particle's age.
     * @return The interpolated size of the particle's quad.
     */
    @Override
    public float getQuadSize(float tickDelta) {
        return quadSize * Mth.clamp(((age) + tickDelta) / (lifetime) * 32.0f, 0.0f, 1.0f);
    }

}
