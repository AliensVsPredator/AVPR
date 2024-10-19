package org.avpr.fabric;

import mod.azure.azurelib.common.internal.common.AzureLib;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

import org.avpr.common.CommonMod;
import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.entities.alien.base_line.OvamorphEntity;
import org.avpr.common.registries.AVPREntities;

public final class FabricLibMod implements ModInitializer {

    @Override
    public void onInitialize() {
        AzureLib.initialize();
        CommonMod.initRegistries();
        FabricDefaultAttributeRegistry.register(AVPREntities.OVAMORPH.get(), OvamorphEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.FACEHUGGER.get(), FacehuggerEntity.createAttributes());
        SpawnPlacements.register(
            AVPREntities.OVAMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.FACEHUGGER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
    }
}
