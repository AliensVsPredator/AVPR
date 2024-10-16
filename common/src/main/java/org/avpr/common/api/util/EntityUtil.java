package org.avpr.common.api.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import org.avpr.common.registries.AVPREntities;

public class EntityUtil {

    public static void generateAcidPool(LivingEntity entity, BlockPos pos, int xOffset, int zOffset) {
        var acidEntity = AVPREntities.ACID.get().create(entity.level());
        if (acidEntity != null) {
            acidEntity.moveTo(pos.offset(xOffset, 0, zOffset), entity.getYRot(), entity.getXRot());
            acidEntity.setMultiplier(10);
            entity.level().addFreshEntity(acidEntity);
        }
    }
}
