package org.avpr.common.api.client;

import net.minecraft.world.entity.Entity;

import org.avpr.common.entities.alien.base_line.FacehuggerEntity;

@FunctionalInterface
public interface TransformDataGenerator {

    TransformData invoke(FacehuggerEntity alienEntity, Entity host);
}
