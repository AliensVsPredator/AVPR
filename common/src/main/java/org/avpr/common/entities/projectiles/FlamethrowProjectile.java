package org.avpr.common.entities.projectiles;

import mod.azure.azurelib.common.api.common.helper.CommonUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.tags.AVPREntityTags;

public class FlamethrowProjectile extends AbstractArrow {

    public FlamethrowProjectile(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    public FlamethrowProjectile(Level level) {
        this(AVPREntities.BULLET.get(), level);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return Items.AIR.getDefaultInstance();
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    protected void onHit(HitResult result) {
        HitResult.Type type = result.getType();
        if (type == HitResult.Type.BLOCK)
            handleBlockHit(result);
        else if (type == HitResult.Type.ENTITY)
            handleEntityHit((EntityHitResult) result);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isInWater())
            this.kill();
        var livingEntities = this.level()
            .getEntitiesOfClass(
                LivingEntity.class,
                this.getBoundingBox().inflate(2),
                livingEntity -> !livingEntity.getType()
                    .is(
                        AVPREntityTags.PREDATORS
                    ) && !PredicatesUtil.IS_CREATIVE_OR_SPECTATOR.test(livingEntity) && livingEntity != this.getOwner()
            );
        if (!livingEntities.isEmpty()) {
            var first = livingEntities.getFirst();
            if (!first.isOnFire())
                first.setRemainingFireTicks(300);
        }
        if (this.level().isClientSide) {
            var x = this.getX() + (this.random.nextDouble() * 2.0D - 1.0D) * this.getBbWidth() * 0.5D;
            var y = this.getY() + 0.05D + this.random.nextDouble();
            var z = this.getZ() + (this.random.nextDouble() * 2.0D - 1.0D) * this.getBbWidth() * 0.5D;
            this.level().addParticle(ParticleTypes.LARGE_SMOKE, true, x, y, z, 0, 0, 0);
        }
        CommonUtils.spawnLightSource(this, this.level().isWaterAt(this.blockPosition()));
    }

    private void handleEntityHit(EntityHitResult result) {
        var entity = result.getEntity();
        if (!entity.isOnFire())
            entity.setRemainingFireTicks(300);
        this.kill();
    }

    /**
     * Handles the event when the projectile hits a block. If the impact occurs server-side, it iterates around the hit
     * position and sets nearby air blocks on fire. After executing this action, the projectile is terminated.
     *
     * @param result The result of the hit, containing information about the block hit.
     */
    private void handleBlockHit(HitResult result) {
        BlockHitResult blockHitResult = (BlockHitResult) result;
        if (!this.level().isClientSide) {
            var hitPos = blockHitResult.getBlockPos().above();
            for (var x = -1; x <= 1; x++) {
                for (var z = -1; z <= 1; z++) {
                    var firePos = hitPos.offset(x, 0, z);
                    if (this.level().getBlockState(firePos).isAir())
                        this.level().setBlockAndUpdate(firePos, Blocks.FIRE.defaultBlockState());
                }
            }
        }
        this.kill();
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return true;
    }

    /**
     * Adds additional data to be saved to the provided tag.
     *
     * @param tag the CompoundTag to which additional data will be written
     */
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putShort("life", (short) this.tickCount);
    }

    /**
     * Reads additional saved data from the provided CompoundTag.
     *
     * @param tag the CompoundTag from which additional data will be read
     */
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        this.tickCount = tag.getShort("life");
    }
}
