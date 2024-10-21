package org.avpr.common.entities.projectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.api.server.BlockBreakProgressManager;
import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRItems;
import org.avpr.common.tags.AVPREntityTags;

public class SmartDiscItemEntity extends ThrowableItemProjectile {

    public SmartDiscItemEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public SmartDiscItemEntity(Level level, LivingEntity livingEntity) {
        super(AVPREntities.SHURKIEN_ENTITY.get(), livingEntity, level);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return AVPRItems.SMART_DISC.get();
    }

    @Override
    public void tick() {
        super.tick();
        // If older then 15 seconds, remove to keep entity count down
        if (this.tickCount > 300)
            this.kill();
        // Searches around itself for an entity to target
        var livingEntities = level().getEntitiesOfClass(
            LivingEntity.class,
            this.getBoundingBox().inflate(5),
            livingEntity -> !livingEntity.getType()
                .is(
                    AVPREntityTags.PREDATORS
                ) && !PredicatesUtil.IS_CREATIVEorSPECTATOR.test(livingEntity)
        );
        if (!livingEntities.isEmpty()) {
            var first = livingEntities.getFirst(); // Get the first entity found.
            var entityPos = new Vec3(first.getX(), first.getY() + first.getEyeHeight(), first.getZ());

            // Calculate the direction vector towards the entity.
            var directionToTarget = entityPos.subtract(this.position()).normalize();

            // Set a fixed speed for the projectile.
            double speed = 0.5; // Adjust this value to control how fast the projectile moves.

            // Multiply the direction vector by the speed to get the new velocity.
            var newVelocity = directionToTarget.scale(speed);

            // Set the new velocity for the projectile.
            this.setDeltaMovement(newVelocity);
        }
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult result) {
        BlockBreakProgressManager.damage(
            level(),
            result.getBlockPos(),
            CommonMod.config.itemConfigs.SMARTDISC_BREAKSPEED_MODIFIER * 2.0F
        );
        this.kill();
        super.onHitBlock(result);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result) {
        if (result.getEntity() instanceof LivingEntity livingEntity && getOwner() != null) {
            livingEntity.hurt(
                damageSources().thrown(getOwner(), livingEntity),
                CommonMod.config.itemConfigs.SMARTDISC_DAMAGE
            );
            this.kill();
        }
        super.onHitEntity(result);
    }
}
