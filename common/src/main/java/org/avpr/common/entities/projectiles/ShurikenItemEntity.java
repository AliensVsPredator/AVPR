package org.avpr.common.entities.projectiles;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.api.server.BlockBreakProgressManager;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRItems;

public class ShurikenItemEntity extends ThrowableItemProjectile {

    public ShurikenItemEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(AVPREntities.SHURKIEN_ENTITY.get(), level);
    }

    public ShurikenItemEntity(Level level, LivingEntity livingEntity) {
        super(AVPREntities.SHURKIEN_ENTITY.get(), livingEntity, level);
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return AVPRItems.SHURIKEN.get();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount > 300)
            this.kill();
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult result) {
        BlockBreakProgressManager.damage(
            level(),
            result.getBlockPos(),
            CommonMod.config.itemConfigs.SKURIKEN_BREAKSPEED_MODIFIER * 2.0F
        );
        super.onHitBlock(result);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result) {
        if (result.getEntity() instanceof LivingEntity livingEntity && getOwner() != null)
            livingEntity.hurt(damageSources().thrown(getOwner(), livingEntity), CommonMod.config.itemConfigs.SKURIKEN_DAMAGE);
        super.onHitEntity(result);
    }
}
