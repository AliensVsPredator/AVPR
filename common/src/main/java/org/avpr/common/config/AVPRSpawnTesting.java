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
        add(AVPREntities.BOILER, pos -> pos.getY() <= config.boiler.maxSpawnY && pos.getY() >= config.boiler.minSpawnY);
        add(AVPREntities.CRUSHER, pos -> pos.getY() <= config.crusher.maxSpawnY);
        add(AVPREntities.DRONE, pos -> pos.getY() <= config.drone.maxSpawnY && pos.getY() >= config.drone.minSpawnY);
        add(AVPREntities.DRONE_RUNNER, pos -> pos.getY() <= config.droneRunner.maxSpawnY && pos.getY() >= config.droneRunner.minSpawnY);
        add(AVPREntities.NAUTICOMORPH, pos -> pos.getY() <= config.nauticomorph.maxSpawnY && pos.getY() >= config.nauticomorph.minSpawnY);
        add(AVPREntities.PRAETORIAN, pos -> pos.getY() <= config.praetorian.maxSpawnY);
        add(AVPREntities.QUEEN, pos -> pos.getY() <= config.queen.maxSpawnY);
        add(AVPREntities.SPITTER, pos -> pos.getY() <= config.spitter.maxSpawnY);
        add(AVPREntities.WARRIOR, pos -> pos.getY() <= config.warrior.maxSpawnY);
        add(AVPREntities.WARRIOR_RUNNER, pos -> pos.getY() <= config.warriorRunner.maxSpawnY);

        // Predators
        add(AVPREntities.YAUTJA, pos -> pos.getY() > config.yautja.minSpawnY);
    }

    public boolean test(EntityType<?> entityType, BlockPos pos) {
        return entityTypeSpawnBoundsTesterMap.getOrDefault(entityType, DEFAULT).test(pos);
    }

    private void add(Supplier<? extends EntityType<?>> entityTypeSupplier, SpawnBoundsTester spawnBoundsTester) {
        var entityType = entityTypeSupplier.get();
        entityTypeSpawnBoundsTesterMap.put(entityType, spawnBoundsTester);
    }
}
