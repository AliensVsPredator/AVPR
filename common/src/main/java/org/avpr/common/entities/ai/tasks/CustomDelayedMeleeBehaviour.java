package org.avpr.common.entities.ai.tasks;

import mod.azure.azurelib.sblforked.api.core.behaviour.ExtendedBehaviour;
import mod.azure.azurelib.sblforked.util.BrainUtils;
import net.minecraft.server.level.ServerLevel;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerRoyalEntity;
import org.avpr.common.entities.alien.beluga_line.OctohuggerEntity;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import org.avpr.common.api.util.EntityUtil;
import org.avpr.common.entities.alien.AlienEntity;

/**
 * CustomDelayedMeleeBehaviour is an abstract class that defines a behavior for entities to perform a delayed melee
 * action. The action is executed after a specified delay, during which an animation can be played.
 *
 * @param <E> the type of AlienEntity this behavior is assigned to
 */
public abstract class CustomDelayedMeleeBehaviour<E extends AlienEntity> extends ExtendedBehaviour<E> {

    protected final int delayTime;

    protected long delayFinishedAt = 0;

    protected Consumer<E> delayedCallback = entity -> {};

    protected CustomDelayedMeleeBehaviour(int delayTicks) {
        this.delayTime = delayTicks;
        runFor(entity -> Math.max(delayTicks, 60));
    }

    /**
     * A callback for when the delayed action is called.
     *
     * @param callback The callback
     * @return this
     */
    public final CustomDelayedMeleeBehaviour<E> whenActivating(Consumer<E> callback) {
        this.delayedCallback = callback;

        return this;
    }

    @Override
    protected final void start(@NotNull ServerLevel level, @NotNull E entity, long gameTime) {
        if (this.delayTime > 0) {
            this.delayFinishedAt = gameTime + this.delayTime;
            super.start(level, entity, gameTime);
        } else {
            super.start(level, entity, gameTime);
            doDelayedAction(entity);
        }
        var target = BrainUtils.getTargetOfEntity(entity);
        if (target != null && (entity instanceof FacehuggerEntity || entity instanceof FacehuggerRoyalEntity || entity instanceof OctohuggerEntity))
            EntityUtil.jumpAtTarget(target, entity);
    }

    @Override
    protected final void stop(@NotNull ServerLevel level, @NotNull E entity, long gameTime) {
        super.stop(level, entity, gameTime);

        this.delayFinishedAt = 0;
    }

    @Override
    protected boolean shouldKeepRunning(E entity) {
        return this.delayFinishedAt >= entity.level().getGameTime();
    }

    @Override
    protected final void tick(@NotNull ServerLevel level, @NotNull E entity, long gameTime) {
        super.tick(level, entity, gameTime);

        if (this.delayFinishedAt <= gameTime) {
            doDelayedAction(entity);
            this.delayedCallback.accept(entity);
        }
    }

    /**
     * The action to take once the delay period has elapsed.
     *
     * @param entity The owner of the brain
     */
    protected void doDelayedAction(E entity) {}
}
