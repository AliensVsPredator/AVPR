package org.avpr.common.api.common;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import static java.lang.Math.min;

/**
 * The GrowableInterface defines an entity capable of growth and transformation. It provides methods to get and set the
 * growth level, determine the maximum growth, and manage the growth process.
 */
public interface GrowableInterface {

    float getGrowth();

    /**
     * Sets the growth level of the entity.
     *
     * @param growth the new growth level to set
     */
    void setGrowth(float growth);

    float getMaxGrowth();

    /**
     * Increases the growth level of the entity by the specified amount. If the growth level reaches or exceeds the
     * maximum growth, the entity will transform into its next stage.
     *
     * @param entity the entity that is growing
     * @param amount the amount by which to increase the entity's growth
     */
    default void grow(Entity entity, float amount) {
        setGrowth(min(getGrowth() + amount, getMaxGrowth()));
        if (getGrowth() >= getMaxGrowth())
            growUp(entity);
    }

    /**
     * Transforms the current growable entity into its next stage as part of its growth process. This method is called
     * to replace the existing entity with a new one that represents the next stage of growth.
     *
     * @return the new LivingEntity instance representing the next stage of growth, or null if no transformation is
     *         possible.
     */
    LivingEntity growInto();

    /**
     * Transforms the given entity into its next growth stage. If the transformation is successful, the original entity
     * is removed from the world and replaced by the new entity.
     *
     * @param entity the entity that is growing up and transforming
     */
    default void growUp(Entity entity) {
        var world = entity.level();
        if (!world.isClientSide()) {
            var newEntity = growInto();
            if (newEntity == null)
                return;
            newEntity.moveTo(entity.blockPosition(), entity.getYRot(), entity.getXRot());
            world.addFreshEntity(newEntity);
            if (entity.hasCustomName())
                newEntity.setCustomName(entity.getCustomName());
            entity.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    default float getGrowthNeededUntilGrowUp() {
        return getMaxGrowth() - getGrowth();
    }

    /**
     * Returns the growth multiplier for an entity. This multiplier is used to influence the rate at which the growth
     * process occurs.
     *
     * @return the growth multiplier as a float value
     */
    default float getGrowthMultiplier() {
        return 1.0f;
    }
}
