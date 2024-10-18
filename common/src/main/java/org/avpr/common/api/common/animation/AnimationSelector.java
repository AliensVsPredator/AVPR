package org.avpr.common.api.common.animation;

import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import net.minecraft.world.entity.PathfinderMob;

@FunctionalInterface
public interface AnimationSelector<T extends PathfinderMob & GeoEntity> {
    void select(T entity);
}
