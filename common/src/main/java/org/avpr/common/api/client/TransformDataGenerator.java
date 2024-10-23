package org.avpr.common.api.client;

import net.minecraft.world.entity.Entity;

import org.avpr.common.entities.alien.AlienEntity;

/**
 * Functional interface for generating transformation data based on an AlienEntity and its host Entity. The
 * implementation of this interface should provide the logic to generate a TransformData instance. This can involve
 * calculations or mappings based on the attributes of the input AlienEntity and host Entity.
 */
@FunctionalInterface
public interface TransformDataGenerator {

    /**
     * Generates transformation data based on the provided alien entity and its host entity.
     *
     * @param alienEntity the alien entity for which transformation data needs to be generated
     * @param host        the host entity associated with the alien entity
     * @return the transformation data that includes coordinates and offset values
     */
    TransformData invoke(AlienEntity alienEntity, Entity host);
}
