package org.avpr.common.api.client;

import net.minecraft.world.entity.Entity;

import org.avpr.common.entities.alien.AlienEntity;

@FunctionalInterface
public interface TransformDataGenerator {

    TransformData invoke(AlienEntity alienEntity, Entity host);
}
