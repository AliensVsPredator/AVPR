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

    @Override
    protected @NotNull Item getDefaultItem() {
        return isIncendiary ? AVPRItems.WEAPON_GRENADE_INCENDIARY.get() : AVPRItems.WEAPON_GRENADE_M40.get();
    }

    @Override
    protected void onDeath() {
        // Explosion logic
        level().explode(this, getX(), getY(), getZ(), 3F, isIncendiary, Level.ExplosionInteraction.BLOCK);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        isIncendiary = compoundTag.getBoolean(IS_INCENDIARY_KEY);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putBoolean(IS_INCENDIARY_KEY, isIncendiary);
    }

    public void setIncendiary(boolean incendiary) {
        isIncendiary = incendiary;
    }
}
