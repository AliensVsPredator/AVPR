package org.avpr.common.api.common;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import static java.lang.Math.min;

/**
 * The GrowableInterface defines an entity capable of growth and transformation. It provides methods to get and set the
 * growth level, determine the maximum growth, and manage the growth process.
 */
public interface GrowableInterface {

    /**
     * Retrieves the current growth level of the entity.
     *
     * @return the current growth level as a float value
     */
    float getGrowth();

    /**
     * Sets the growth level of the entity.
     *
     * @param growth the new growth level to set
     */
    void setGrowth(float growth);

    /**
     * Retrieves the maximum growth level that the entity can achieve before undergoing a transformation.
     *
     * @return the maximum growth level as a float value
     */
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
     * Transforms the entity into its next growth stage as a LivingEntity. If the transformation is successful, the
     * original entity is replaced by the new entity.
     *
     * @return the new LivingEntity resulting from the growth transformation
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

    /**
     * Calculates the amount of growth needed for the entity to reach its maximum growth level and transform into its
     * next stage.
     *
     * @return the remaining growth needed until the entity can grow up, as a float value
     */
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
