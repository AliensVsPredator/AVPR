package org.avpr.common.entities.projectiles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.avpr.common.api.util.EntityUtil;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.api.server.BlockBreakProgressManager;
import org.avpr.common.registries.AVPREntities;

public class BulletProjectile extends AbstractArrow {

    private static int bulletdamage;
    private boolean trackToEntity;

    public BulletProjectile(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    public BulletProjectile(Level world, Integer damage, boolean shouldTrackToEntity) {
        this(AVPREntities.BULLET.get(), world);
        bulletdamage = damage;
        trackToEntity = shouldTrackToEntity;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putShort("life", (short) this.tickCount);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        this.tickCount = tag.getShort("life");
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return Items.AIR.getDefaultInstance();
    }

    @Override
    public void tick() {
        super.tick();
        if (trackToEntity)
            EntityUtil.trackToLivingEntity(this, 0.5);
        if (this.tickCount >= 300)
            this.remove(Entity.RemovalReason.DISCARDED);
        if (this.level().isClientSide) {
            var x = this.getX() + (this.random.nextDouble()) * this.getBbWidth() * 0.5D;
            var y = this.getZ() + (this.random.nextDouble()) * this.getBbWidth() * 0.5D;
            this.level().addParticle(ParticleTypes.SMOKE, true, x, this.getY(), y, 0, 0, 0);
        }
    }

    @Override
    public boolean isNoGravity() {
        return !this.isUnderWater();
    }

    @Override
    protected void onHit(HitResult result) {
        HitResult.Type type = result.getType();
        if (type == HitResult.Type.BLOCK)
            handleBlockHit(result);
        else if (type == HitResult.Type.ENTITY)
            handleEntityHit((EntityHitResult) result);
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
        var speed = this.getDeltaMovement().length();
        if (speed > 0.1)
            entity.hurt(entity.damageSources().thrown(this, this.getOwner()), bulletdamage);
        this.setDeltaMovement(this.getDeltaMovement().multiply(0.25, 0.25, 0.25));
        this.kill();
    }

    private void handleBlockHit(HitResult result) {
        BlockHitResult blockResult = (BlockHitResult) result;

        BlockBreakProgressManager.damage(
            level(),
            blockResult.getBlockPos(),
            CommonMod.config.itemConfigs.BULLET_BREAKSPEED_MODIFIER * 2.0F
        );
        var speed = getDeltaMovement().length();

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
        this.kill();
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return true;
    }
}
