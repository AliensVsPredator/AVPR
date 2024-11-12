package org.avpr.fabric;

import mod.azure.azurelib.common.internal.common.AzureLib;
import mod.azure.azurelib.sblforked.SBLConstants;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;

import org.avpr.common.CommonMod;
import org.avpr.common.blocks.behaviors.AVPRDispenserBlockBehaviors;
import org.avpr.common.entities.alien.AlienEntity;
import org.avpr.common.entities.alien.base_line.*;
import org.avpr.common.entities.alien.beluga_line.BelugabursterEntity;
import org.avpr.common.entities.alien.beluga_line.BelugamorphEntity;
import org.avpr.common.entities.alien.beluga_line.OctohuggerEntity;
import org.avpr.common.entities.alien.deacon_line.*;
import org.avpr.common.entities.alien.draco_line.ChestbursterDracoEntity;
import org.avpr.common.entities.alien.draco_line.DracomorphEntity;
import org.avpr.common.entities.alien.draco_line.OvamorphDracoEntity;
import org.avpr.common.entities.alien.predalien_line.PredalienEntity;
import org.avpr.common.entities.alien.runner_line.ChestbursterRunnerEntity;
import org.avpr.common.entities.alien.runner_line.CrusherEntity;
import org.avpr.common.entities.alien.runner_line.DroneRunnerEntity;
import org.avpr.common.entities.alien.runner_line.WarriorDroneEntity;
import org.avpr.common.entities.engineer.EngineerEntity;
import org.avpr.common.entities.yautja.YautjaEntity;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.tags.AVPRBiomeTags;
import org.avpr.common.worldgen.features.AVPROreFeatures;

public final class FabricLibMod implements ModInitializer {

    @Override
    public void onInitialize() {
        SBLConstants.SBL_LOADER.init(null);
        AzureLib.initialize();
        AzureLib.hasKeyBindsInitialized = true;
        CommonMod.initRegistries();

        // Dispenser behavior registration.
        AVPRDispenserBlockBehaviors.INSTANCE.registerAll();

        /*
         * Mob Attribute Registry
         */
        FabricDefaultAttributeRegistry.register(AVPREntities.BOILER.get(), BoilerEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.CHESTBURSTER.get(), ChestbursterEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.CHESTBURSTER_QUEEN.get(), ChestbursterQueenEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.DRONE.get(), DroneEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.FACEHUGGER.get(), FacehuggerEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.FACEHUGGER_ROYAL.get(), FacehuggerRoyalEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.NAUTICOMORPH.get(), NauticomorphEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.OVAMORPH.get(), OvamorphEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.PRAETORIAN.get(), PraetorianEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.QUEEN.get(), QueenEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.SPITTER.get(), SpitterEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.ULTRAMORPH.get(), UltramorphEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.WARRIOR.get(), WarriorEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.BELUGABURSTER.get(), BelugabursterEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.BELUGAMORPH.get(), BelugamorphEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.OCTOHUGGER.get(), OctohuggerEntity.createAttributes().build());
        FabricDefaultAttributeRegistry.register(AVPREntities.DEACON_ADULT.get(), DeaconAdultEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.DEACON_ADULT_ENGINEER.get(), DeaconAdultEngineerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.DEACON.get(), DeaconEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.TRIOLOBITE_BABY.get(), TriolobiteBabyEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.TRIOLOBITE.get(), TriolobiteEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.CHESTBURSTER_DRACO.get(), ChestbursterDracoEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.DRACOMORPH.get(), DracomorphEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.OVAMORPH_DRACO.get(), OvamorphDracoEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.CHESTBURSTER_RUNNER.get(), ChestbursterRunnerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.CRUSHER.get(), CrusherEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.DRONE_RUNNER.get(), DroneRunnerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.WARRIOR_RUNNER.get(), WarriorDroneEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.PREDALIEN.get(), PredalienEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.ENGINEER.get(), EngineerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(AVPREntities.YAUTJA.get(), YautjaEntity.createAttributes());
        /*
         * Mob Spawn Placement
         */
        SpawnPlacements.register(
            AVPREntities.BOILER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.CHESTBURSTER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            ChestbursterEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.CHESTBURSTER_QUEEN.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.DRONE.get(),
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
        SpawnPlacements.register(
            AVPREntities.FACEHUGGER_ROYAL.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            FacehuggerRoyalEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.NAUTICOMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.OVAMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.PRAETORIAN.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.QUEEN.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.SPITTER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.ULTRAMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.WARRIOR.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.BELUGABURSTER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            BelugabursterEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.BELUGAMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            BelugamorphEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.OCTOHUGGER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            OctohuggerEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.DEACON_ADULT.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.DEACON_ADULT_ENGINEER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.DEACON.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.TRIOLOBITE_BABY.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.TRIOLOBITE.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.CHESTBURSTER_DRACO.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.DRACOMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.OVAMORPH_DRACO.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.CHESTBURSTER_RUNNER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.CRUSHER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.DRONE_RUNNER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.WARRIOR_RUNNER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.PREDALIEN.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.ENGINEER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            EngineerEntity::checkMonsterSpawnRules
        );
        SpawnPlacements.register(
            AVPREntities.YAUTJA.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            YautjaEntity::checkMonsterSpawnRules
        );
        /*
         * Mob Spawns
         */
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            MobCategory.MONSTER,
            AVPREntities.BOILER.get(),
            7,
            1,
            1
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            MobCategory.MONSTER,
            AVPREntities.CRUSHER.get(),
            10,
            1,
            1
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(AVPRBiomeTags.RUNNER_SPAWNS),
            MobCategory.MONSTER,
            AVPREntities.DRONE_RUNNER.get(),
            50,
            1,
            3
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            MobCategory.MONSTER,
            AVPREntities.DRONE.get(),
            50,
            1,
            2
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(AVPRBiomeTags.IS_WET),
            MobCategory.MONSTER,
            AVPREntities.NAUTICOMORPH.get(),
            30,
            1,
            1
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            MobCategory.MONSTER,
            AVPREntities.PRAETORIAN.get(),
            10,
            1,
            1
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            MobCategory.MONSTER,
            AVPREntities.QUEEN.get(),
            5,
            1,
            1
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            MobCategory.MONSTER,
            AVPREntities.SPITTER.get(),
            10,
            1,
            1
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(AVPRBiomeTags.RUNNER_SPAWNS),
            MobCategory.MONSTER,
            AVPREntities.WARRIOR_RUNNER.get(),
            25,
            1,
            2
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            MobCategory.MONSTER,
            AVPREntities.WARRIOR.get(),
            25,
            1,
            1
        );
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(AVPRBiomeTags.PREDATOR_SPAWNS),
            MobCategory.MONSTER,
            AVPREntities.YAUTJA.get(),
            30,
            1,
            1
        );
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Decoration.LOCAL_MODIFICATIONS,
            AVPROreFeatures.AUTUNITE_ORE_PLACED_KEY
        );
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            AVPROreFeatures.BAUXITE_ORE_PLACED_KEY
        );
        BiomeModifications.addFeature(
            BiomeSelectors.tag(BiomeTags.IS_JUNGLE),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            AVPROreFeatures.COBALT_ORE_PLACED_KEY
        );
        BiomeModifications.addFeature(
            BiomeSelectors.tag(AVPRBiomeTags.IS_WET),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            AVPROreFeatures.LITHIUM_ORE_PLACED_KEY
        );
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            AVPROreFeatures.MONAZITE_ORE_PLACED_KEY
        );
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            AVPROreFeatures.SILICON_ORE_PLACED_KEY
        );
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Decoration.UNDERGROUND_ORES,
            AVPROreFeatures.TITANIUM_ORE_PLACED_KEY
        );
    }
}
