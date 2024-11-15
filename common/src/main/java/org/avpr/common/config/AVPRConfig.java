package org.avpr.common.config;

import mod.azure.azurelib.common.api.common.config.Config;
import mod.azure.azurelib.common.internal.common.config.Configurable;

import org.avpr.common.CommonMod;

@Config(id = CommonMod.MOD_ID)
public class AVPRConfig {

    // TODO: If everything is synchronized, why should they all be marked as such? Why is it not just a annotation arg?

    @Configurable
    @Configurable.Synchronized
    public AcidConfigs acid = new AcidConfigs();

    public static class AcidConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float breakSpeedModifier = 40.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 2F;
    }

    @Configurable
    @Configurable.Synchronized
    public ItemConfigs items = new ItemConfigs();

    public static class ItemConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float bulletBreakSpeedMultiplier = 1.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float shurikenBreakSpeedMultiplier = 1.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float shurikenDamage = 5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float smartDiscBreakSpeedModifier = 4.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float smartDiscDamage = 5F;
    }

    @Configurable
    @Configurable.Synchronized
    public OvamorphConfigs ovamorph = new OvamorphConfigs();

    public static class OvamorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 8F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float hatchRange = 7F;

    }

    @Configurable
    @Configurable.Synchronized
    public FacehuggerConfigs facehugger = new FacehuggerConfigs();

    public static class FacehuggerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.3300000041723251F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 1)
        public float attachTimeInTicks = 1200F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Range(min = 1)
        public int impregnationDelayInTicks = 1200;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public boolean blindHostWhileHugging = true;

    }

    @Configurable
    @Configurable.Synchronized
    public FacehuggerRoyalConfigs royalFacehugger = new FacehuggerRoyalConfigs();

    public static class FacehuggerRoyalConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.3300000041723251F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 1)
        public float attachTimeInTicks = 1200F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Range(min = 1)
        public int impregnationDelayInTicks = 1200;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public boolean blindHostWhileHugging = true;

    }

    @Configurable
    @Configurable.Synchronized
    public ChestbursterConfigs chestburster = new ChestbursterConfigs();

    public static class ChestbursterConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 14.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 0.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public ChestbursterQueenConfigs chestbursterQueen = new ChestbursterQueenConfigs();

    public static class ChestbursterQueenConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 14.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 0.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public DroneConfigs drone = new DroneConfigs();

    public static class DroneConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 40.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 7.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.5239000201463699F;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = 75;

        @Configurable
        @Configurable.Synchronized
        public int minSpawnY = 30;
    }

    @Configurable
    @Configurable.Synchronized
    public WarriorConfigs warrior = new WarriorConfigs();

    public static class WarriorConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 50.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 9.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.40300001549720765F;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = 30;
    }

    @Configurable
    @Configurable.Synchronized
    public BoilerConfigs boiler = new BoilerConfigs();

    public static class BoilerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 30.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 4.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.3627000139474869F;

        @Configurable
        @Configurable.Synchronized
        public int minSpawnY = -20;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = -10;
    }

    @Configurable
    @Configurable.Synchronized
    public NauticomorphConfigs nauticomorph = new NauticomorphConfigs();

    public static class NauticomorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 40.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 7.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.5239000201463699F;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = 63;

        @Configurable
        @Configurable.Synchronized
        public int minSpawnY = 30;
    }

    @Configurable
    @Configurable.Synchronized
    public PraetorianConfigs praetorian = new PraetorianConfigs();

    public static class PraetorianConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 100.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 12.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.38285001472234725F;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = -30;
    }

    @Configurable
    @Configurable.Synchronized
    public SpitterConfigs spitter = new SpitterConfigs();

    public static class SpitterConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 30.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 4.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.3627000139474869F;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = 30;
    }

    @Configurable
    @Configurable.Synchronized
    public UltramorphConfigs ultramorph = new UltramorphConfigs();

    public static class UltramorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 230.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 5.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.5239000201463699F;
    }

    @Configurable
    @Configurable.Synchronized
    public QueenConfigs queen = new QueenConfigs();

    public static class QueenConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 300.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 24.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.3627000139474869F;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = -50;
    }

    @Configurable
    @Configurable.Synchronized
    public BelugabursterConfigs belugaburster = new BelugabursterConfigs();

    public static class BelugabursterConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 14.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public BelugamorphConfigs belugamorph = new BelugamorphConfigs();

    public static class BelugamorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 180.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 4.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.40300001549720765F;
    }

    @Configurable
    @Configurable.Synchronized
    public OctohuggerConfigs octohugger = new OctohuggerConfigs();

    public static class OctohuggerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 14F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.2945000113248825F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 1)
        public float attachTimeInTicks = 1200F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Range(min = 1)
        public int impregnationDelayInTicks = 1200;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public boolean blindHostWhileHugging = true;

    }

    @Configurable
    @Configurable.Synchronized
    public TrilobiteBabyConfigs trilobiteBaby = new TrilobiteBabyConfigs();

    public static class TrilobiteBabyConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 16.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.2945000113248825F;
    }

    @Configurable
    @Configurable.Synchronized
    public TrilobiteConfigs trilobite = new TrilobiteConfigs();

    public static class TrilobiteConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 44.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 4.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public DeaconAdultConfigs deaconAdult = new DeaconAdultConfigs();

    public static class DeaconAdultConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 120.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 3.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.44330001704692845F;
    }

    @Configurable
    @Configurable.Synchronized
    public DeaconAdultEngineerConfigs deaconAdultEngineer = new DeaconAdultEngineerConfigs();

    public static class DeaconAdultEngineerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 150.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 4.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.48360001859664914F;
    }

    @Configurable
    @Configurable.Synchronized
    public DeaconConfigs deacon = new DeaconConfigs();

    public static class DeaconConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 120.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 3.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.44330001704692845F;
    }

    @Configurable
    @Configurable.Synchronized
    public ChestbursterDracoConfigs dracoChestburster = new ChestbursterDracoConfigs();

    public static class ChestbursterDracoConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 25.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public DracomorphConfigs dracomorph = new DracomorphConfigs();

    public static class DracomorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 400.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 8F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.38285001472234725F;
    }

    @Configurable
    @Configurable.Synchronized
    public OvamorphDracoConfigs dracoOvamorph = new OvamorphDracoConfigs();

    public static class OvamorphDracoConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 16F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float hatchRange = 7F;

    }

    @Configurable
    @Configurable.Synchronized
    public ChestbursterRunnerConfigs chestbursterRunner = new ChestbursterRunnerConfigs();

    public static class ChestbursterRunnerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 14.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public DroneRunnerConfigs droneRunner = new DroneRunnerConfigs();

    public static class DroneRunnerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 30.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 7.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.5370750206530094F;

        @Configurable
        @Configurable.Synchronized
        public int minSpawnY = 50;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = 75;
    }

    @Configurable
    @Configurable.Synchronized
    public WarriorRunnerConfigs warriorRunner = new WarriorRunnerConfigs();

    public static class WarriorRunnerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 40.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 9.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.562650021636486F;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = 30;
    }

    @Configurable
    @Configurable.Synchronized
    public CrusherConfigs crusher = new CrusherConfigs();

    public static class CrusherConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 90.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 12.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.46345001782178874F;

        @Configurable
        @Configurable.Synchronized
        public int maxSpawnY = -30;
    }

    @Configurable
    @Configurable.Synchronized
    public PredalienConfigs predalien = new PredalienConfigs();

    public static class PredalienConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 230.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 5.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.46345001782178874F;
    }

    @Configurable
    @Configurable.Synchronized
    public EngineerConfigs engineer = new EngineerConfigs();

    public static class EngineerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 160.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 8.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.5115000196695327F;
    }

    @Configurable
    @Configurable.Synchronized
    public YautjaConfigs yautja = new YautjaConfigs();

    public static class YautjaConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float health = 80.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float damage = 12.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float moveSpeed = 0.48360001859664914F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float minSpawnY = 63;
    }
}
