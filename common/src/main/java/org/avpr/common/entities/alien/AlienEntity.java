package org.avpr.common.entities.alien;

import mod.azure.azurelib.common.api.common.ai.pathing.AzureNavigation;
import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.avpr.common.api.common.GrowableInterface;
import org.avpr.common.api.util.EntityUtil;
import org.jetbrains.annotations.NotNull;

public abstract class AlienEntity extends Monster implements GeoEntity, GrowableInterface {
    protected static final EntityDataAccessor<Float> GROWTH = SynchedEntityData.defineId(AlienEntity.class,
            EntityDataSerializers.FLOAT);

    public AlienEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
    }

    @Override
    protected void jumpInLiquid(@NotNull TagKey<Fluid> fluid) {
    }

    /**
     * Default acid pool size
     */
    public int getAcidDiameter() {
        return 0;
    }

    /**
     * Data handling
     */

    public float getGrowth() {
        return entityData.get(GROWTH);
    }

    public void setGrowth(float growth) {
        entityData.set(GROWTH, growth);
    }

    @Override
    public void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(GROWTH, 0.0f);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putFloat("growth", this.getGrowth());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setGrowth(compound.getFloat("growth"));
    }

    /**
     * Handle Pathfinding
     */
    @Override
    protected @NotNull PathNavigation createNavigation(@NotNull Level level) {
        return new AzureNavigation(this, level);
    }

    /**
     * Handle making the entity unridable
     */
    @Override
    protected boolean canRide(@NotNull Entity vehicle) {
        return false;
    }

    /**
     * Handle despawn rules
     */
    @Override
    public boolean requiresCustomPersistence() {
        return true;
    }

    @Override
    public void checkDespawn() {
    }

    /**
     * Handle acid spawning on death
     */
    @Override
    public void die(@NotNull DamageSource source) {
        if (source == damageSources().genericKill()) {
            super.die(source);
            return;
        }

        var damageCheck = !this.level().isClientSide && source != damageSources().genericKill() || source != damageSources().generic();
        if (damageCheck) {
            if (getAcidDiameter() == 1) EntityUtil.generateAcidPool(this, this.blockPosition(), 0, 0);
            else {
                var radius = (getAcidDiameter() - 1) / 2;
                for (int i = 0; i < getAcidDiameter(); i++) {
                    int x = this.level().getRandom().nextInt(getAcidDiameter()) - radius;
                    int z = this.level().getRandom().nextInt(getAcidDiameter()) - radius;
                    if (source != damageSources().genericKill() || source != damageSources().generic())
                        EntityUtil.generateAcidPool(this, this.blockPosition(), x, z);
                }
            }
        }
        super.die(source);
    }

    /**
     * Handle entity being pushable
     */
    @Override
    public boolean canBeCollidedWith() {
        return this.isAlive();
    }

    @Override
    public boolean isPushable() {
        return false;
    }
}
