package org.avpr.common.client.entities.renders.alien.runner_line;

import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.runner_line.WarriorRunnerEntity;

public class WarriorRunnerRenderer extends GeoEntityRenderer<WarriorRunnerEntity> {

    public WarriorRunnerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("alien/runner_line/warrior_runner")));
    }

    @Override
    protected float getShadowRadius(@NotNull WarriorRunnerEntity entity) {
        return 0.5f;
    }
}
