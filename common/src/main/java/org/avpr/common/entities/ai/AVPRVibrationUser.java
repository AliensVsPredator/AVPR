package org.avpr.common.entities.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.GameEventTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.avpr.common.api.util.PredicatesUtil;
import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;

public class AVPRVibrationUser implements VibrationSystem.User {

    private final AlienEntity mob;

    private final float moveSpeed;

    private final PositionSource positionSource;

    public AVPRVibrationUser(AlienEntity entity, float speed) {
        this.positionSource = new EntityPositionSource(entity, entity.getEyeHeight());
        this.mob = entity;
        this.moveSpeed = speed;
    }

    @Override
    public int getListenerRadius() {
        return 32;
    }

    @Override
    public @NotNull PositionSource getPositionSource() {
        return this.positionSource;
    }

    @Override
    public @NotNull TagKey<GameEvent> getListenableEvents() {
        return GameEventTags.VIBRATIONS;
    }

    @Override
    public boolean canTriggerAvoidVibration() {
        return true;
    }

    @Override
    public boolean isValidVibration(Holder<GameEvent> gameEvent, @NotNull Context context) {
        if (!gameEvent.is(this.getListenableEvents()))
            return false;

        var entity = context.sourceEntity();
        if (entity != null) {
            if (entity instanceof Player player && PredicatesUtil.IS_CREATIVEorSPECTATOR.test(player))
                return false;
            return !entity.dampensVibrations();
        }
        return true;
    }

    @Override
    public boolean canReceiveVibration(
        @NotNull ServerLevel serverLevel,
        @NotNull BlockPos blockPos,
        @NotNull Holder<GameEvent> gameEvent,
        @NotNull Context context
    ) {
        if (
            mob.isNoAi() || mob.isDeadOrDying() || !mob.level()
                .getWorldBorder()
                .isWithinBounds(
                    blockPos
                ) || mob.isRemoved()
        )
            return false;
        var entity = context.sourceEntity();
        return !(entity instanceof LivingEntity) || mob.canTargetEntity(entity);
    }

    @Override
    public void onReceiveVibration(
        @NotNull ServerLevel serverLevel,
        @NotNull BlockPos blockPos,
        @NotNull Holder<GameEvent> gameEvent,
        @Nullable Entity entity,
        @Nullable Entity entity2,
        float f
    ) {
        if (this.mob.isDeadOrDying())
            return;
        if (this.mob.isVehicle())
            return;
        this.doVibrationAction(blockPos, entity2);
    }

    private void doVibrationAction(@NotNull BlockPos blockPos, @Nullable Entity entity2) {
        this.mob.getNavigation().moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ(), this.moveSpeed);

        if (
            this.mob instanceof FacehuggerEntity
                && !(entity2 instanceof IronGolem)
        )
            mob.getNavigation().moveTo(blockPos.getX(), blockPos.getY(), blockPos.getZ(), this.moveSpeed);
    }

}
