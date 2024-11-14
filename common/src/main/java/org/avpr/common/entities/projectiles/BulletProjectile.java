package org.avpr.common.entities.projectiles;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.api.server.BlockBreakProgressManager;
import org.avpr.common.api.util.EntityUtil;
import org.avpr.common.registries.AVPREntities;

public class BulletProjectile extends AbstractArrow {

    private static int bulletdamage;

    private boolean trackToEntity;

    private static double knockBackDamage;

    /**
     * Constructs a BulletProjectile in the given Level.
     *
     * @param entityType The type of the entity.
     * @param level      The level in which the projectile exists.
     */
    public BulletProjectile(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
    }

    /**
     * Constructs a BulletProjectile with specified attributes.
     *
     * @param world               the Level in which the projectile exists
     * @param damage              the damage inflicted by the projectile
     * @param shouldTrackToEntity if true, the projectile will track to an entity
     * @param setKnockBackDamage  the knockback damage set for the projectile
     */
    public BulletProjectile(Level world, Integer damage, boolean shouldTrackToEntity, Double setKnockBackDamage) {
        this(AVPREntities.BULLET.get(), world);
        this.pickup = AbstractArrow.Pickup.DISALLOWED;
        bulletdamage = damage;
        trackToEntity = shouldTrackToEntity;
        knockBackDamage = setKnockBackDamage;
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

    /**
     * Gets the default item stack that can be picked up when the projectile is retrieved.
     *
     * @return The default item stack, which is an instance of the air item.
     */
    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return Items.AIR.getDefaultInstance();
    }

    /**
     * Performs a knockback effect on the specified entity based on the projectile's settings and the entity's
     * resistance to knockback.
     *
     * @param entity       The living entity to apply the knockback effect to.
     * @param damageSource The source of the damage that caused the knockback.
     */
    @Override
    protected void doKnockback(LivingEntity entity, @NotNull DamageSource damageSource) {
        var knockBackResistance = Math.max(0.0, 1.0 - entity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
        var vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(0.6 * knockBackResistance);
        if (vec3.lengthSqr() > 0.0)
            entity.push(vec3.x, knockBackDamage, vec3.z);
    }

    /**
     * Updates the state of the bullet projectile on each tick. This method performs several key operations on every
     * game tick: - Calls the parent class's tick method to ensure inherited behaviors. - Conditionally adjusts the
     * projectile's movement to track the nearest living entity. - Removes the projectile if it has existed for more
     * than 300 ticks. - On the client side, creates a smoke particle effect near the projectile. - Disables the glowing
     * tag for all entities within a 10-block radius. The method handles both server-side and client-side actions to
     * ensure consistent behavior and appearance of the projectile across the game environment.
     */
    @Override
    public void tick() {
        super.tick();
        if (trackToEntity)
            EntityUtil.trackToLivingEntity(this, 0.5, true);
        if (this.tickCount >= 300)
            this.remove(Entity.RemovalReason.DISCARDED);
        if (this.level().isClientSide) {
            var x = this.getX() + (this.random.nextDouble()) * this.getBbWidth() * 0.5D;
            var y = this.getZ() + (this.random.nextDouble()) * this.getBbWidth() * 0.5D;
            this.level().addParticle(ParticleTypes.SMOKE, true, x, this.getY(), y, 0, 0, 0);
        }
        var livingEntities = this.level()
            .getEntitiesOfClass(
                LivingEntity.class,
                this.getBoundingBox().inflate(10),
                Entity::hasGlowingTag
            );
        livingEntities.forEach(entity -> entity.setGlowingTag(false));
    }

    /**
     * Determines if the bullet projectile is affected by gravity. This method overrides the parent class method by
     * checking if the projectile is underwater. If the projectile is underwater, it returns false indicating no gravity
     * effect; otherwise, it returns true.
     *
     * @return true if the projectile is not underwater (indicating gravity affects it); false otherwise.
     */
    @Override
    public boolean isNoGravity() {
        return !this.isUnderWater();
    }

    /**
     * Method called when the projectile hits a target. It distinguishes between hitting a block and hitting an entity,
     * and delegates the handling to the respective methods.
     *
     * @param result The result of the hit, providing details about the hit target.
     */
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
        if (entity.hasGlowingTag())
            entity.setGlowingTag(false);
        this.setDeltaMovement(this.getDeltaMovement().multiply(0.25, 0.25, 0.25));
        this.kill();
    }

    /**
     * Handles the event when the projectile hits a block. This method processes block hit results, applies damage to
     * the block, and plays the appropriate sound effects.
     *
     * @param result The result of the hit, containing details about the block hit.
     */
    private void handleBlockHit(HitResult result) {
        BlockHitResult blockResult = (BlockHitResult) result;

        BlockBreakProgressManager.damage(
            level(),
            blockResult.getBlockPos(),
            CommonMod.config.items.bulletBreakSpeedMultiplier * 2.0F
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

    /**
     * Determines whether the bullet projectile should render based on the square of the distance.
     *
     * @param distance the square of the distance to consider for rendering.
     * @return true if the projectile should render; false otherwise.
     */
    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return true;
    }
}
