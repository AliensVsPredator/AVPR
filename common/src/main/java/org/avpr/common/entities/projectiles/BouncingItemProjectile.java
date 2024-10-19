package org.avpr.common.entities.projectiles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

/**
 * Modified version of MrCrayfish's <a href=
 * "https://github.com/MrCrayfish/MrCrayfishGunMod/blob/1.19.X/src/main/java/com/mrcrayfish/guns/entity/ThrowableGrenadeEntity.java">ThrowableGrenadeEntity</a>.
 * Please go support MrCrayfish, he makes some awesome mods! :)
 */
public abstract class BouncingItemProjectile extends ThrowableItemProjectile {

    protected boolean shouldBounce;

    protected int maxLife;

    protected BouncingItemProjectile(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    protected BouncingItemProjectile(EntityType<? extends ThrowableItemProjectile> entityType, double x, double y, double z, Level level) {
        super(entityType, x, y, z, level);
    }

    protected BouncingItemProjectile(EntityType<? extends ThrowableItemProjectile> entityType, LivingEntity livingEntity, Level level) {
        super(entityType, livingEntity, level);
    }

    protected void onDeath() {}

    @Override
    public void tick() {
        super.tick();

        if (this.shouldBounce && this.tickCount >= this.maxLife) {
            remove(RemovalReason.KILLED);
            onDeath();
        }
    }

    @Override
    protected void onHit(HitResult result) {
        HitResult.Type type = result.getType();
        if (type == HitResult.Type.BLOCK) {
            handleBlockHit(result);
        } else if (type == HitResult.Type.ENTITY) {
            handleEntityHit((EntityHitResult) result);
        }
    }

    /**
     * Handles the behavior when the projectile hits an entity. If the projectile is set to bounce, it will inflict
     * damage to the entity and bounce off in the opposite direction. If not, the projectile will be removed and trigger
     * the death behavior.
     *
     * @param result The result of the entity hit, providing details about the entity hit.
     */
    private void handleEntityHit(EntityHitResult result) {
        var entity = result.getEntity();

        if (this.shouldBounce) {
            double speed = this.getDeltaMovement().length();
            if (speed > 0.1) {
                entity.hurt(entity.damageSources().thrown(this, this.getOwner()), 1.0F);
            }
            this.bounce(
                Direction.getNearest(this.getDeltaMovement().x(), this.getDeltaMovement().y(), this.getDeltaMovement().z()).getOpposite()
            );
            this.setDeltaMovement(this.getDeltaMovement().multiply(0.25, 0.25, 0.25));
        } else {
            this.remove(RemovalReason.KILLED);
            onDeath();
        }
    }

    private void handleBlockHit(HitResult result) {
        BlockHitResult blockResult = (BlockHitResult) result;

        if (!this.shouldBounce) {
            this.remove(RemovalReason.KILLED);
            onDeath();
            return;
        }

        double speed = getDeltaMovement().length();

        if (speed > 0.1) {
            var level = level();
            BlockPos resultPos = blockResult.getBlockPos();
            BlockState state = level.getBlockState(resultPos);
            SoundEvent event = state.getBlock().getSoundType(state).getStepSound();
            level.playSound(
                null,
                result.getLocation().x,
                result.getLocation().y,
                result.getLocation().z,
                event,
                SoundSource.AMBIENT,
                1.0F,
                1.0F
            );
        }

        this.bounce(blockResult.getDirection());
    }

    /**
     * Alters the direction and magnitude of the projectile's movement based on the specified direction of impact.
     *
     * @param direction The direction in which the projectile should bounce, influencing how its movement vector will be
     *                  modified.
     */
    private void bounce(Direction direction) {
        switch (direction.getAxis()) {
            case X -> this.setDeltaMovement(this.getDeltaMovement().multiply(-0.5, 0.75, 0.75));
            case Y -> {
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.75, -0.25, 0.75));
                if (this.getDeltaMovement().y() < this.getGravity()) {
                    this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0, 1));
                }
            }
            case Z -> this.setDeltaMovement(this.getDeltaMovement().multiply(0.75, 0.75, -0.5));
        }
    }

    @Override
    public boolean isNoGravity() {
        return false;
    }
}
