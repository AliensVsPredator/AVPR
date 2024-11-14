package org.avpr.common.config;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import org.avpr.common.registries.AVPREntities;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AVPRSpawnTesting {

    public interface SpawnBoundsTester {
        boolean test(BlockPos pos);
    }

    private static final SpawnBoundsTester DEFAULT = pos -> pos.getY() >= -255 && pos.getY() <= 255;

    private final Map<EntityType<?>, SpawnBoundsTester> entityTypeSpawnBoundsTesterMap;

    public AVPRSpawnTesting() {
        this.entityTypeSpawnBoundsTesterMap = new HashMap<>();
    }

    public void init(AVPRConfig config) {
        // Aliens
        add(AVPREntities.BOILER, pos -> pos.getY() <= config.boilerConfigs.BOILER_MAX_SPAWN_Y &&
            pos.getY() >= config.boilerConfigs.BOILER_MIN_SPAWN_Y);
        add(AVPREntities.CRUSHER, pos -> pos.getY() <= config.crusherConfigs.CRUSHER_MAX_SPAWN_Y);
        add(AVPREntities.DRONE, pos -> pos.getY() <= config.droneConfigs.DRONE_MAX_SPAWN_Y &&
            pos.getY() >= config.droneConfigs.DRONE_MIN_SPAWN_Y);
        add(AVPREntities.DRONE_RUNNER, pos -> pos.getY() <= config.droneRunnerConfigs.DRONERUNNER_MAX_SPAWN_Y &&
            pos.getY() >= config.droneRunnerConfigs.DRONERUNNER_MIN_SPAWN_Y);
        add(AVPREntities.NAUTICOMORPH, pos -> pos.getY() <= config.nauticomorphConfigs.NAUTICOMORPH_MAX_SPAWN_Y &&
            pos.getY() >= config.nauticomorphConfigs.NAUTICOMORPH_MIN_SPAWN_Y);
        add(AVPREntities.PRAETORIAN, pos -> pos.getY() <= config.praetorianConfigs.PRAETORIAN_MAX_SPAWN_Y);
        add(AVPREntities.QUEEN, pos -> pos.getY() <= config.queenConfigs.QUEEN_MAX_SPAWN_Y);
        add(AVPREntities.SPITTER, pos -> pos.getY() <= config.spitterConfigs.SPITTER_MAX_SPAWN_Y);
        add(AVPREntities.WARRIOR, pos -> pos.getY() <= config.warriorConfigs.WARRIOR_MAX_SPAWN_Y);
        add(AVPREntities.WARRIOR_RUNNER, pos -> pos.getY() <= config.warriorRunnerConfigs.WARRIOR_RUNNER_MAX_SPAWN_Y);

        // Predators
        add(AVPREntities.YAUTJA, pos -> pos.getY() > config.yautjaConfigs.YAUTJA_MIN_SPAWN_Y);
    }

    public boolean test(EntityType<?> entityType, BlockPos pos) {
        return entityTypeSpawnBoundsTesterMap.getOrDefault(entityType, DEFAULT).test(pos);
    }

    private void add(Supplier<? extends EntityType<?>> entityTypeSupplier, SpawnBoundsTester spawnBoundsTester) {
        var entityType = entityTypeSupplier.get();
        entityTypeSpawnBoundsTesterMap.put(entityType, spawnBoundsTester);
    }
}
