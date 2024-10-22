package org.avpr.common.api.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;

import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerRoyalEntity;
import org.avpr.common.entities.alien.beluga_line.OctohuggerEntity;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.tags.AVPREntityTags;

public record EntityUtil() {

    /**
     * Sets the projectile to track the nearest living entity and adjust its movement direction and velocity accordingly.
     *
     * @param projectile  The projectile entity that will track the target.
     * @param bulletSpeed The speed at which the projectile will move towards the target.
     */
    public static void trackToLivingEntity(Projectile projectile, Double bulletSpeed) {
        // Searches around itself for an entity to target
        var livingEntities = projectile.level().getEntitiesOfClass(
                LivingEntity.class,
                projectile.getBoundingBox().inflate(5),
                livingEntity -> !livingEntity.getType()
                        .is(
                                AVPREntityTags.PREDATORS
                        ) && !PredicatesUtil.IS_CREATIVEorSPECTATOR.test(livingEntity) && livingEntity != projectile.getOwner()
        );
        if (!livingEntities.isEmpty()) {
            var first = livingEntities.getFirst(); // Get the first entity found.
            var entityPos = new Vec3(first.getX(), first.getY() + first.getEyeHeight(), first.getZ());

            // Calculate the direction vector towards the entity.
            var directionToTarget = entityPos.subtract(projectile.position()).normalize();

            // Multiply the direction vector by the speed to get the new velocity.
            var newVelocity = directionToTarget.scale(bulletSpeed);

            // Set the new velocity for the projectile.
            projectile.setDeltaMovement(newVelocity);
        }
    }

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

    public static void jumpAtTarget(LivingEntity target, AlienEntity alienEntity) {
        var vec3d2 = new Vec3(
            target.getX() - alienEntity.getX(),
            0.0,
            target.getZ() - alienEntity.getZ()
        );
        vec3d2 = vec3d2.normalize().scale(0.2).add(alienEntity.getDeltaMovement().scale(0.2));
        alienEntity.setDeltaMovement(
            vec3d2.x,
            target.getEyeHeight() > 0.8F ? 0.5F : 0.4,
            vec3d2.z
        );
    }

    public static void hugTarget(LivingEntity target, AlienEntity alienEntity) {
        if (!target.getUseItem().is(Items.SHIELD)) {
            if (alienEntity instanceof FacehuggerEntity facehugger)
                facehugger.grabTarget(target);
            if (alienEntity instanceof FacehuggerRoyalEntity facehuggerRoyalEntity)
                facehuggerRoyalEntity.grabTarget(target);
            if (alienEntity instanceof OctohuggerEntity octohuggerEntity)
                octohuggerEntity.grabTarget(target);
        }
    }
}
