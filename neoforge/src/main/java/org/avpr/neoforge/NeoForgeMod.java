package org.avpr.neoforge;

import mod.azure.azurelib.common.internal.common.AzureLib;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import org.avpr.common.CommonMod;
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
import org.avpr.common.entities.alien.runner_line.WarriorRunnerEntity;
import org.avpr.common.entities.engineer.EngineerEntity;
import org.avpr.common.entities.yautja.YautjaEntity;
import org.avpr.common.registries.AVPREntities;

@Mod(CommonMod.MOD_ID)
public final class NeoForgeMod {

    public static DeferredRegister<BlockEntityType<?>> blockEntityTypeDeferredRegister = DeferredRegister.create(
        Registries.BLOCK_ENTITY_TYPE,
        CommonMod.MOD_ID
    );

    public static DeferredRegister<Block> blockDeferredRegister = DeferredRegister.create(Registries.BLOCK, CommonMod.MOD_ID);

    public static DeferredRegister<EntityType<?>> entityTypeDeferredRegister = DeferredRegister.create(
        Registries.ENTITY_TYPE,
        CommonMod.MOD_ID
    );

    public static DeferredRegister<ArmorMaterial> armorMaterialDeferredRegister = DeferredRegister.create(
        Registries.ARMOR_MATERIAL,
        CommonMod.MOD_ID
    );

    public static DeferredRegister<Item> itemDeferredRegister = DeferredRegister.create(Registries.ITEM, CommonMod.MOD_ID);

    public static DeferredRegister<SoundEvent> soundEventDeferredRegister = DeferredRegister.create(
        Registries.SOUND_EVENT,
        CommonMod.MOD_ID
    );

    public static DeferredRegister<MenuType<?>> menuTypeDeferredRegister = DeferredRegister.create(Registries.MENU, CommonMod.MOD_ID);

    public static DeferredRegister<ParticleType<?>> particleTypeDeferredRegister = DeferredRegister.create(
        Registries.PARTICLE_TYPE,
        CommonMod.MOD_ID
    );

    public static DeferredRegister<CreativeModeTab> creativeModeTabDeferredRegister = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB,
        CommonMod.MOD_ID
    );

    public static DeferredRegister<MobEffect> statusEffectDeferredRegister = DeferredRegister.create(
        Registries.MOB_EFFECT,
        CommonMod.MOD_ID
    );

    public static DeferredRegister<Fluid> fluidDeferredRegister = DeferredRegister.create(Registries.FLUID, CommonMod.MOD_ID);

    public static DeferredRegister.DataComponents dataComponentTypeDeferredRegister = DeferredRegister.createDataComponents(
        Registries.DATA_COMPONENT_TYPE,
        CommonMod.MOD_ID
    );

    public static final DeferredRegister<FluidType> fluidTypeDeferredRegister = DeferredRegister.create(
        NeoForgeRegistries.Keys.FLUID_TYPES,
        CommonMod.MOD_ID
    );

    public NeoForgeMod(IEventBus modEventBus) {
        AzureLib.initialize();
        AzureLib.hasKeyBindsInitialized = true;
        CommonMod.initRegistries();
        if (NeoForgeMod.blockEntityTypeDeferredRegister != null)
            NeoForgeMod.blockEntityTypeDeferredRegister.register(modEventBus);
        NeoForgeMod.blockDeferredRegister.register(modEventBus);
        NeoForgeMod.entityTypeDeferredRegister.register(modEventBus);
        if (NeoForgeMod.armorMaterialDeferredRegister != null)
            NeoForgeMod.armorMaterialDeferredRegister.register(modEventBus);
        NeoForgeMod.itemDeferredRegister.register(modEventBus);
        NeoForgeMod.soundEventDeferredRegister.register(modEventBus);
        if (NeoForgeMod.menuTypeDeferredRegister != null)
            NeoForgeMod.menuTypeDeferredRegister.register(modEventBus);
        NeoForgeMod.particleTypeDeferredRegister.register(modEventBus);
        NeoForgeMod.creativeModeTabDeferredRegister.register(modEventBus);
        NeoForgeMod.statusEffectDeferredRegister.register(modEventBus);
        if (NeoForgeMod.fluidDeferredRegister != null)
            NeoForgeMod.fluidDeferredRegister.register(modEventBus);
        if (NeoForgeMod.dataComponentTypeDeferredRegister != null)
            NeoForgeMod.dataComponentTypeDeferredRegister.register(modEventBus);
        modEventBus.addListener(this::createEntityAttributes);
        modEventBus.addListener(this::onRegisterEvent);
    }

    public void onRegisterEvent(RegisterSpawnPlacementsEvent event) {
        /*
         * Mob Spawn Placement
         */
        event.register(
            AVPREntities.BOILER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.CHESTBURSTER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.CHESTBURSTER_QUEEN.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.DRONE.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.FACEHUGGER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.FACEHUGGER_ROYAL.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.NAUTICOMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.OVAMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.PRAETORIAN.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.QUEEN.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.SPITTER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.ULTRAMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.WARRIOR.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.BELUGABURSTER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.BELUGAMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.OCTOHUGGER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.DEACON_ADULT.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.DEACON_ADULT_ENGINEER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.DEACON.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.TRILOBITE_BABY.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.TRILOBITE.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.CHESTBURSTER_DRACO.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.DRACOMORPH.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.OVAMORPH_DRACO.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.CHESTBURSTER_RUNNER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.CRUSHER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.DRONE_RUNNER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.WARRIOR_RUNNER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.PREDALIEN.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            AlienEntity::checkAlienSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.ENGINEER.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            EngineerEntity::checkEngineerSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
        event.register(
            AVPREntities.YAUTJA.get(),
            SpawnPlacementTypes.ON_GROUND,
            Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            YautjaEntity::checkYautjaSpawnRules,
            RegisterSpawnPlacementsEvent.Operation.AND
        );
    }

    public void createEntityAttributes(final EntityAttributeCreationEvent event) {
        /*
         * Mob Attribute Registry
         */
        event.put(AVPREntities.BOILER.get(), BoilerEntity.createAttributes().build());
        event.put(AVPREntities.CHESTBURSTER.get(), ChestbursterEntity.createAttributes().build());
        event.put(AVPREntities.CHESTBURSTER_QUEEN.get(), ChestbursterQueenEntity.createAttributes().build());
        event.put(AVPREntities.DRONE.get(), DroneEntity.createAttributes().build());
        event.put(AVPREntities.FACEHUGGER.get(), FacehuggerEntity.createAttributes().build());
        event.put(AVPREntities.FACEHUGGER_ROYAL.get(), FacehuggerRoyalEntity.createAttributes().build());
        event.put(AVPREntities.NAUTICOMORPH.get(), NauticomorphEntity.createAttributes().build());
        event.put(AVPREntities.OVAMORPH.get(), OvamorphEntity.createAttributes().build());
        event.put(AVPREntities.PRAETORIAN.get(), PraetorianEntity.createAttributes().build());
        event.put(AVPREntities.QUEEN.get(), QueenEntity.createAttributes().build());
        event.put(AVPREntities.SPITTER.get(), SpitterEntity.createAttributes().build());
        event.put(AVPREntities.ULTRAMORPH.get(), UltramorphEntity.createAttributes().build());
        event.put(AVPREntities.WARRIOR.get(), WarriorEntity.createAttributes().build());
        event.put(AVPREntities.BELUGABURSTER.get(), BelugabursterEntity.createAttributes().build());
        event.put(AVPREntities.BELUGAMORPH.get(), BelugamorphEntity.createAttributes().build());
        event.put(AVPREntities.OCTOHUGGER.get(), OctohuggerEntity.createAttributes().build());
        event.put(AVPREntities.DEACON_ADULT.get(), DeaconAdultEntity.createAttributes().build());
        event.put(AVPREntities.DEACON_ADULT_ENGINEER.get(), DeaconAdultEngineerEntity.createAttributes().build());
        event.put(AVPREntities.DEACON.get(), DeaconEntity.createAttributes().build());
        event.put(AVPREntities.TRILOBITE_BABY.get(), TriolobiteBabyEntity.createAttributes().build());
        event.put(AVPREntities.TRILOBITE.get(), TriolobiteEntity.createAttributes().build());
        event.put(AVPREntities.CHESTBURSTER_DRACO.get(), ChestbursterDracoEntity.createAttributes().build());
        event.put(AVPREntities.DRACOMORPH.get(), DracomorphEntity.createAttributes().build());
        event.put(AVPREntities.OVAMORPH_DRACO.get(), OvamorphDracoEntity.createAttributes().build());
        event.put(AVPREntities.CHESTBURSTER_RUNNER.get(), ChestbursterRunnerEntity.createAttributes().build());
        event.put(AVPREntities.CRUSHER.get(), CrusherEntity.createAttributes().build());
        event.put(AVPREntities.DRONE_RUNNER.get(), DroneRunnerEntity.createAttributes().build());
        event.put(AVPREntities.WARRIOR_RUNNER.get(), WarriorRunnerEntity.createAttributes().build());
        event.put(AVPREntities.PREDALIEN.get(), PredalienEntity.createAttributes().build());
        event.put(AVPREntities.ENGINEER.get(), EngineerEntity.createAttributes().build());
        event.put(AVPREntities.YAUTJA.get(), YautjaEntity.createAttributes().build());
    }
}
