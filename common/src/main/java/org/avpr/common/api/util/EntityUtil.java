package org.avpr.common.api.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.tags.AVPREntityTags;

public class EntityUtil {

    public static void generateAcidPool(LivingEntity entity, BlockPos pos, int xOffset, int zOffset) {
        var acidEntity = AVPREntities.ACID.get().create(entity.level());
        if (acidEntity != null) {
            acidEntity.moveTo(pos.offset(xOffset, 0, zOffset), entity.getYRot(), entity.getXRot());
            acidEntity.setMultiplier(10);
            entity.level().addFreshEntity(acidEntity);
        }
    }

    public static LivingEntity spawnBurster(LivingEntity entity) {
        EntityType<? extends AlienEntity> entity_type = AVPREntities.CHESTBURSTER.get();
        AlienEntity defaultBurster = entity_type.create(entity.level());
        // if (SET_CAUSE_FLAG) {
        // entity_type = AVPREntities.CHESTBURSTER_DRACO.get();
        // defaultBurster.setHostId("beluga");
        // return entity_type.create(entity.level());
        // }
        // if (entity.getType().is(AVPREntityTags.RUNNER_HOSTS)) {
        // entity_type = AVPREntities.CHESTBURSTER_RUNNER.get();
        // defaultBurster.setHostId("runner");
        // return entity_type.create(entity.level());
        // }
        if (entity.getType().is(AVPREntityTags.PREDATORS))
            defaultBurster.setHostId("predalien");
        return defaultBurster;
    }
}
