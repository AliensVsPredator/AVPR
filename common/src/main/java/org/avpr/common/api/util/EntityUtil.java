package org.avpr.common.api.util;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;

import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerRoyalEntity;
import org.avpr.common.entities.alien.beluga_line.OctohuggerEntity;
import org.avpr.common.entities.projectiles.ShurikenItemEntity;
import org.avpr.common.entities.projectiles.SmartDiscItemEntity;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.tags.AVPREntityTags;

public record EntityUtil() {

    /**
     * Shoots a shuriken from the specified living entity, playing a sound effect and spawning a
     * {@code ShurikenItemEntity} in the game world.
     *
     * @param entity The {@code LivingEntity} that is shooting the shuriken. This entity will be used as the source and
     *               owner of the shuriken.
     */
    public static void shootShuriken(LivingEntity entity) {
        // TODO: Change sound effect here.
        entity.level()
            .playSound(
                null,
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                SoundEvents.TRIDENT_THROW,
                SoundSource.PLAYERS,
                0.5F,
                0.4F / (entity.level().getRandom().nextFloat() * 0.4F + 0.8F)
            );
        if (!entity.level().isClientSide) {
            var shurikenItemEntity = new ShurikenItemEntity(entity.level(), entity);
            shurikenItemEntity.setItem(entity.getUseItem());
            shurikenItemEntity.setOwner(entity);
            shurikenItemEntity.shootFromRotation(entity, entity.getXRot(), entity.getYRot(), 0.0F, 1.5F, 1.0F);
            entity.level().addFreshEntity(shurikenItemEntity);
        }
    }

    /**
     * Shoots a smart disc from the specified living entity, playing a sound effect and spawning a
     * {@code SmartDiscItemEntity} in the game world.
     *
     * @param entity The {@code LivingEntity} that is shooting the smart disc. This entity will be used as the source
     *               and owner of the smart disc.
     */
    public static void shootSmartDisc(LivingEntity entity) {
        // TODO: Change sound effect here.
        entity.level()
            .playSound(
                null,
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                SoundEvents.TRIDENT_THROW,
                SoundSource.PLAYERS,
                0.5F,
                0.4F / (entity.level().getRandom().nextFloat() * 0.4F + 0.8F)
            );

        if (!entity.level().isClientSide) {
            var smartDiscItemEntity = new SmartDiscItemEntity(entity.level(), entity);
            smartDiscItemEntity.setItem(entity.getUseItem());
            smartDiscItemEntity.setOwner(entity);
            smartDiscItemEntity.shootFromRotation(entity, entity.getXRot(), entity.getYRot(), 0.0F, 3.5F, 1.0F);
            entity.level().addFreshEntity(smartDiscItemEntity);
        }
    }

    /**
     * Sets the projectile to track the nearest living entity and adjust its movement direction and velocity
     * accordingly.
     *
     * @param projectile  The projectile entity that will track the target.
     * @param bulletSpeed The speed at which the projectile will move towards the target.
     */
    public static void trackToLivingEntity(Projectile projectile, Double bulletSpeed, Boolean highLightMob) {
        // Searches around itself for an entity to target
        var livingEntities = projectile.level()
            .getEntitiesOfClass(
                LivingEntity.class,
                projectile.getBoundingBox().inflate(5),
                livingEntity -> !livingEntity.getType()
                    .is(
                        AVPREntityTags.PREDATORS
                    ) && !PredicatesUtil.IS_CREATIVE_OR_SPECTATOR.test(livingEntity) && livingEntity != projectile.getOwner()
            );
        if (!livingEntities.isEmpty()) {
            var first = livingEntities.getFirst(); // Get the first entity found.
            if (Boolean.TRUE.equals(highLightMob))
                first.setGlowingTag(true);
            var entityPos = new Vec3(first.getX(), first.getY() + first.getEyeHeight(), first.getZ());

            // Calculate the direction vector towards the entity.
            var directionToTarget = entityPos.subtract(projectile.position()).normalize();

            // Multiply the direction vector by the speed to get the new velocity.
            var newVelocity = directionToTarget.scale(bulletSpeed);

            // Set the new velocity for the projectile.
            projectile.setDeltaMovement(newVelocity);
        }
    }

    /**
     * Generates an acid pool entity at the specified position and offsets, with a predefined multiplier.
     *
     * @param entity  The living entity that triggers the generation of the acid pool.
     * @param pos     The position where the acid pool will be generated.
     * @param xOffset The x-coordinate offset from the given position where the acid pool will appear.
     * @param zOffset The z-coordinate offset from the given position where the acid pool will appear.
     */
    public static void generateAcidPool(LivingEntity entity, BlockPos pos, int xOffset, int zOffset, float damageAmount) {
        var acidEntity = AVPREntities.ACID.get().create(entity.level());
        if (acidEntity != null) {
            acidEntity.moveTo(pos.offset(xOffset, 0, zOffset), entity.getYRot(), entity.getXRot());
            acidEntity.setMultiplier(damageAmount * 2);
            entity.level().addFreshEntity(acidEntity);
        }
    }

    /**
     * Spawns a new burster entity based on the type of the given host entity. The spawned burster's type or host ID may
     * vary depending on the host entity's characteristics.
     *
     * @param entity The host living entity from which the burster will emerge.
     * @return The newly spawned burster entity.
     */
    public static LivingEntity spawnBurster(LivingEntity entity) {
        EntityType<? extends AlienEntity> entity_type = AVPREntities.CHESTBURSTER.get();
        AlienEntity defaultBurster = entity_type.create(entity.level());
        // if (SET_CAUSE_FLAG) {
        // entity_type = AVPREntities.CHESTBURSTER_DRACO.get();
        // defaultBurster.setHostId("beluga");
        // return entity_type.create(entity.level());
        // }
        // TODO: What's going on here with string literal host IDs?
        if (entity.getType().is(AVPREntityTags.RUNNER_HOSTS)) {
            entity_type = AVPREntities.CHESTBURSTER_RUNNER.get();
            defaultBurster.setHostId("runner");
            return entity_type.create(entity.level());
        }
        if (entity.getType().is(AVPREntityTags.CRUSHER_HOSTS)) {
            defaultBurster.setHostId("crusher");
        }
        if (entity.getType().is(AVPREntityTags.SPITTER_HOSTS)) {
            defaultBurster.setHostId("spitter");
        }
        if (entity.getType().is(AVPREntityTags.PREDATORS))
            defaultBurster.setHostId("predalien");
        if (entity.getType().is(AVPREntityTags.DRACO_HOSTS)) {
            entity_type = AVPREntities.CHESTBURSTER_DRACO.get();
            defaultBurster.setHostId("draco");
            return entity_type.create(entity.level());
        }
        if (entity.getType().is(AVPREntityTags.BELUGA_HOSTS)) {
            entity_type = AVPREntities.BELUGABURSTER.get();
            defaultBurster.setHostId("beluga");
            return entity_type.create(entity.level());
        }
        if (entity.getType().is(AVPREntityTags.DEACON_HOSTS)) {
            entity_type = AVPREntities.TRILOBITE_BABY.get();
            defaultBurster.setHostId(entity.getType().is(AVPREntityTags.HUMANIOD_HOSTS) ? "humanoid" : "engineer");
            return entity_type.create(entity.level());
        }
        return defaultBurster;
    }

    /**
     * Makes the alien entity jump towards the specified target entity.
     *
     * @param target      The living entity that the alien entity will jump towards.
     * @param alienEntity The alien entity that will perform the jump towards the target.
     */
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

    /**
     * Causes the given alien entity to explode, creating acid pools and an area effect cloud. The explosion creates
     * multiple acid pools around the entity and releases a harmful area effect cloud.
     *
     * @param alienEntity The alien entity that will explode and generate the acid pools and area effect cloud.
     */
    public static void explodeAcid(AlienEntity alienEntity) {
        for (var i = 0; i < 5; i++) {
            var x = alienEntity.level().getRandom().nextInt(5) - 5;
            var z = alienEntity.level().getRandom().nextInt(5) - 5;
            EntityUtil.generateAcidPool(alienEntity, alienEntity.blockPosition(), x, z, 20.0F);
            var areaEffectCloudEntity = new AreaEffectCloud(
                alienEntity.level(),
                alienEntity.getX(),
                alienEntity.getY() + 1,
                alienEntity.getZ()
            );
            areaEffectCloudEntity.setRadius(8.0F);
            areaEffectCloudEntity.setDuration(30);
            areaEffectCloudEntity.setRadiusPerTick(
                -areaEffectCloudEntity.getRadius() / areaEffectCloudEntity.getDuration()
            );
            areaEffectCloudEntity.addEffect(new MobEffectInstance(MobEffects.HARM, 100, 0));
            alienEntity.level().addFreshEntity(areaEffectCloudEntity);
            alienEntity.kill();
        }
    }

    /**
     * Causes the specified alien entity to hug the target living entity, provided the target is not using a shield. The
     * type of alien entity determines the specific grabbing behavior.
     *
     * @param target      The living entity that the alien entity will attempt to hug.
     * @param alienEntity The alien entity that will perform the hugging action on the target.
     */
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
