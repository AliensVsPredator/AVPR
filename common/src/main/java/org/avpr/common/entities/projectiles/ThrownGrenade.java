package org.avpr.common.entities.projectiles;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRItems;

/**
 * Represents a grenade that can be thrown by a player, capable of bouncing and exploding after a set duration. The
 * grenade can be either standard or incendiary, with differing effects upon explosion.
 */
public class ThrownGrenade extends BouncingItemProjectile {

    private static final String IS_INCENDIARY_KEY = "IsIncendiary";

    private boolean isIncendiary;

    public ThrownGrenade(EntityType<? extends ThrownGrenade> entityType, Level level) {
        super(entityType, level);
        this.shouldBounce = true;
        this.maxLife = 5 * 20;
    }

    public ThrownGrenade(Level level, LivingEntity livingEntity) {
        super(AVPREntities.GRENADE_THROWN.get(), livingEntity, level);
        this.shouldBounce = true;
        this.maxLife = 5 * 20;
    }

    /**
     * Handles the tick update for the thrown grenade entity. This method is called every game tick and is responsible
     * for updating the entity's state, such as generating particles and playing sound effects. If this is the first
     * tick, it plays a priming sound for the grenade. On the client side, it adds a smoke particle effect to the
     * current position of the grenade.
     */
    @Override
    public void tick() {
        super.tick();

        var level = level();
        var pos = position();
        var posX = pos.x;
        var posY = pos.y;
        var posZ = pos.z;

        if (this.firstTick) {
            playSound(SoundEvents.TNT_PRIMED, 1.0F, 1.0F);
        }

        if (level.isClientSide) {
            level.addParticle(ParticleTypes.SMOKE, posX, posY + 0.5D, posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    /**
     * Returns the default item for the grenade based on its type.
     *
     * @return The default item, either an incendiary grenade or a standard M40 grenade.
     */
    @Override
    protected @NotNull Item getDefaultItem() {
        return isIncendiary ? AVPRItems.WEAPON_GRENADE_INCENDIARY.get() : AVPRItems.WEAPON_GRENADE_M40.get();
    }

    /**
     * Handles the death of the thrown grenade entity by executing explosion logic. This method is called automatically
     * when the grenade's life ends or when specific interaction conditions are met. It causes the grenade to explode at
     * its current position with a specified explosion radius. If the grenade is incendiary, it has fire-related effects
     * upon explosion.
     */
    @Override
    protected void onDeath() {
        // Explosion logic
        level().explode(this, getX(), getY(), getZ(), 3F, isIncendiary, Level.ExplosionInteraction.BLOCK);
    }

    /**
     * Reads additional save data from the given CompoundTag for the ThrownGrenade entity. It retrieves and sets whether
     * the grenade is incendiary based on the stored data.
     *
     * @param compoundTag The tag that contains the saved data for the ThrownGrenade entity.
     */
    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        isIncendiary = compoundTag.getBoolean(IS_INCENDIARY_KEY);
    }

    /**
     * Saves additional data to the given CompoundTag for the ThrownGrenade entity. This method is used to store whether
     * the grenade is incendiary.
     *
     * @param compoundTag The CompoundTag to store the additional save data.
     */
    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean(IS_INCENDIARY_KEY, isIncendiary);
    }

    /**
     * Sets whether the grenade is incendiary.
     *
     * @param incendiary true if the grenade should be incendiary, false otherwise.
     */
    public void setIncendiary(boolean incendiary) {
        isIncendiary = incendiary;
    }
}
