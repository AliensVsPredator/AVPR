package org.avpr.common.api.util;

import net.minecraft.world.phys.Vec3;

import org.avpr.common.api.common.animation.AnimationSelector;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;

public record AttackSelector() {

    public static final AnimationSelector<FacehuggerEntity> HUGGER_SELECTOR = facehuggerEntity -> {
        if (facehuggerEntity.getTarget() != null) {
            var vec3d2 = new Vec3(
                facehuggerEntity.getTarget().getX() - facehuggerEntity.getX(),
                0.0,
                facehuggerEntity.getTarget().getZ() - facehuggerEntity.getZ()
            );
            vec3d2 = vec3d2.normalize().scale(0.2).add(facehuggerEntity.getDeltaMovement().scale(0.2));
            facehuggerEntity.setDeltaMovement(
                vec3d2.x,
                facehuggerEntity.getTarget().getEyeHeight() > 0.8F ? 0.5F : 0.4,
                vec3d2.z
            );
            facehuggerEntity.setJumping(true);
        }
    };
}
