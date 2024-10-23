package org.avpr.common.config;

import mod.azure.azurelib.common.api.common.config.Config;
import mod.azure.azurelib.common.internal.common.config.Configurable;

import org.avpr.common.CommonMod;

@Config(id = CommonMod.MOD_ID)
public class AVPRConfig {

    @Configurable
    @Configurable.Synchronized
    public AcidConfigs acidConfigs = new AcidConfigs();

    public static class AcidConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ACID_BREAKSPEED_MODIFIER = 40.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ACID_DAMAGE = 2F;
    }

    @Configurable
    @Configurable.Synchronized
    public ItemConfigs itemConfigs = new ItemConfigs();

    public static class ItemConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BULLET_BREAKSPEED_MODIFIER = 1.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float SKURIKEN_BREAKSPEED_MODIFIER = 1.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float SKURIKEN_DAMAGE = 5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float SMARTDISC_BREAKSPEED_MODIFIER = 4.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float SMARTDISC_DAMAGE = 5F;
    }

    @Configurable
    @Configurable.Synchronized
    public OvamorphConfigs ovamorphConfigs = new OvamorphConfigs();

    public static class OvamorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float OVAMORPH_HEALTH = 8F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float OVAMORPH_HATCH_RANGE = 7F;

    }

    @Configurable
    @Configurable.Synchronized
    public FacehuggerConfigs facehuggerConfigs = new FacehuggerConfigs();

    public static class FacehuggerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float FACEHUGGER_HEALTH = 5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float FACEHUGGER_SPEED = 0.3300000041723251F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 1)
        public float FACEHUGGER_ATTACH_TIME_IN_TICKS = 1200F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Range(min = 1)
        public int FACEHUGGER_IMPREG_TIMER = 1200;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public boolean FACEHUGGER_GIVE_BLINDNESS = true;

    }

    @Configurable
    @Configurable.Synchronized
    public FacehuggerRoyalConfigs facehuggerRoyalConfigs = new FacehuggerRoyalConfigs();

    public static class FacehuggerRoyalConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float FACEHUGGER_ROYAL_HEALTH = 5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float FACEHUGGER_QUEEN_SPEED = 0.3300000041723251F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 1)
        public float FACEHUGGER_ROYAL_ATTACH_TIME_IN_TICKS = 1200F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Range(min = 1)
        public int FACEHUGGER_ROYAL_IMPREG_TIMER = 1200;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public boolean FACEHUGGER_ROYAL_GIVE_BLINDNESS = true;

    }

    @Configurable
    @Configurable.Synchronized
    public ChestbursterConfigs chestbursterConfigs = new ChestbursterConfigs();

    public static class ChestbursterConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTER_HEALTH = 14.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTER_ATTACK = 0.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTER_SPEED = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public ChestbursterQueenConfigs chestbursterQueenConfigs = new ChestbursterQueenConfigs();

    public static class ChestbursterQueenConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTER_QUEEN_HEALTH = 14.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTER_QUEEN_ATTACK = 0.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTER_QUEEN_SPEED = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public DroneConfigs droneConfigs = new DroneConfigs();

    public static class DroneConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRONE_HEALTH = 40.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRONE_ATTACK = 7.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRONE_SPEED = 0.5239000201463699F;

        @Configurable
        @Configurable.Synchronized
        public int DRONE_MIN_SPAWN_Y = 75;
    }

    @Configurable
    @Configurable.Synchronized
    public WarriorConfigs warriorConfigs = new WarriorConfigs();

    public static class WarriorConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float WARRIOR_HEALTH = 50.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float WARRIOR_ATTACK = 9.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float WARRIOR_SPEED = 0.40300001549720765F;

        @Configurable
        @Configurable.Synchronized
        public int WARRIOR_MIN_SPAWN_Y = 32;
    }

    @Configurable
    @Configurable.Synchronized
    public BoilerConfigs boilerConfigs = new BoilerConfigs();

    public static class BoilerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BOILER_HEALTH = 30.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BOILER_ATTACK = 4.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BOILER_SPEED = 0.3627000139474869F;

        @Configurable
        @Configurable.Synchronized
        public int BOILER_MIN_SPAWN_Y = 75;
    }

    @Configurable
    @Configurable.Synchronized
    public NauticomorphConfigs nauticomorphConfigs = new NauticomorphConfigs();

    public static class NauticomorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float NAUTICOMORPH_HEALTH = 40.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float NAUTICOMORPH_ATTACK = 7.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float NAUTICOMORPH_SPEED = 0.5239000201463699F;

        @Configurable
        @Configurable.Synchronized
        public int NAUTICOMORPH_MIN_SPAWN_Y = 63;
    }

    @Configurable
    @Configurable.Synchronized
    public PraetorianConfigs praetorianConfigs = new PraetorianConfigs();

    public static class PraetorianConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float PRAETORIAN_HEALTH = 100.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float PRAETORIAN_ATTACK = 12.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float PRAETORIAN_SPEED = 0.38285001472234725F;

        @Configurable
        @Configurable.Synchronized
        public int PRAETORIAN_MIN_SPAWN_Y = 0;
    }

    @Configurable
    @Configurable.Synchronized
    public SpitterConfigs spitterConfigs = new SpitterConfigs();

    public static class SpitterConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float SPITTER_HEALTH = 30.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float SPITTER_ATTACK = 4.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float SPITTER_SPEED = 0.3627000139474869F;

        @Configurable
        @Configurable.Synchronized
        public int SPITTER_MIN_SPAWN_Y = 0;
    }

    @Configurable
    @Configurable.Synchronized
    public UltramorphConfigs ultramorphConfigs = new UltramorphConfigs();

    public static class UltramorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ULTRAMORPH_HEALTH = 230.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ULTRAMORPH_ATTACK = 5.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ULTRAMORPH_SPEED = 0.5239000201463699F;
    }

    @Configurable
    @Configurable.Synchronized
    public QueenConfigs queenConfigs = new QueenConfigs();

    public static class QueenConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float QUEEN_HEALTH = 300.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float QUEEN_ATTACK = 24.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float QUEEN_SPEED = 0.3627000139474869F;

        @Configurable
        @Configurable.Synchronized
        public int QUEEN_MIN_SPAWN_Y = -24;
    }

    @Configurable
    @Configurable.Synchronized
    public BelugabursterConfigs belugabursterConfigs = new BelugabursterConfigs();

    public static class BelugabursterConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BELUGABURSTER_HEALTH = 14.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BELUGABURSTER_SPEED = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public BelugamorphConfigs belugamorphConfigs = new BelugamorphConfigs();

    public static class BelugamorphConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BELUGAMORPH_HEALTH = 180.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BELUGAMORPH_ATTACK = 4.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float BELUGAMORPH_SPEED = 0.40300001549720765F;
    }

    @Configurable
    @Configurable.Synchronized
    public OctohuggerConfigs octohuggerConfigs = new OctohuggerConfigs();

    public static class OctohuggerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float OCTOHUGGER_HEALTH = 14F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float OCTOHUGGER_SPEED = 0.2945000113248825F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 1)
        public float OCTOHUGGER_ATTACH_TIME_IN_TICKS = 1200F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Range(min = 1)
        public int OCTOHUGGER_IMPREG_TIMER = 1200;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public boolean OCTOHUGGER_GIVE_BLINDNESS = true;

    }

    @Configurable
    @Configurable.Synchronized
    public TrilobiteBabyConfigs trilobiteBabyConfigs = new TrilobiteBabyConfigs();

    public static class TrilobiteBabyConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float TRILOBITE_BABY_HEALTH = 16.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float TRILOBITE_BABY_SPEED = 0.2945000113248825F;
    }

    @Configurable
    @Configurable.Synchronized
    public TrilobiteConfigs trilobiteConfigs = new TrilobiteConfigs();

    public static class TrilobiteConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float TRILOBITE_HEALTH = 44.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float TRILOBITE_ATTACK = 4.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float TRILOBITE_SPEED = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public DeaconAdultConfigs deaconAdultConfigs = new DeaconAdultConfigs();

    public static class DeaconAdultConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_ADULT_HEALTH = 120.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_ADULT_ATTACK = 3.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_ADULT_SPEED = 0.44330001704692845F;
    }

    @Configurable
    @Configurable.Synchronized
    public DeaconAdultEnineerConfigs deaconAdultEnineerConfigs = new DeaconAdultEnineerConfigs();

    public static class DeaconAdultEnineerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_ADULT_ENGINEER_HEALTH = 150.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_ADULT_ENGINEER_ATTACK = 4.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_ADULT_ENGINEER_SPEED = 0.48360001859664914F;
    }

    @Configurable
    @Configurable.Synchronized
    public DeaconConfigs deaconConfigs = new DeaconConfigs();

    public static class DeaconConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_HEALTH = 120.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_ATTACK = 3.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DEACON_SPEED = 0.44330001704692845F;
    }

    @Configurable
    @Configurable.Synchronized
    public ChestbursterDracoConfigs chestbursterDracoConfigs = new ChestbursterDracoConfigs();

    public static class ChestbursterDracoConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTERDRACO_HEALTH = 25.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTERDRACO_SPEED = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public DracomorpthConfigs dracomorpthConfigs = new DracomorpthConfigs();

    public static class DracomorpthConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRACOMORPTH_HEALTH = 400.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRACOMORPTH_ATTACK = 8F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRACOMORPTH_SPEED = 0.38285001472234725F;
    }

    @Configurable
    @Configurable.Synchronized
    public OvamorphDracoConfigs ovamorphDracoConfigs = new OvamorphDracoConfigs();

    public static class OvamorphDracoConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float OVAMORPHDRACO_HEALTH = 16F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float OVAMORPHDRACO_HATCH_RANGE = 7F;

    }

    @Configurable
    @Configurable.Synchronized
    public ChestbursterRunnerConfigs chestbursterRunnerConfigs = new ChestbursterRunnerConfigs();

    public static class ChestbursterRunnerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTERRUNNER_HEALTH = 14.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CHESTBURSTERRUNNER_SPEED = 0.42315001627206805F;
    }

    @Configurable
    @Configurable.Synchronized
    public DroneRunnerConfigs droneRunnerConfigs = new DroneRunnerConfigs();

    public static class DroneRunnerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRONERUNNER_HEALTH = 30.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRONERUNNER_ATTACK = 7.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float DRONERUNNER_SPEED = 0.5370750206530094F;

        @Configurable
        @Configurable.Synchronized
        public int DRONERUNNER_MIN_SPAWN_Y = 75;
    }

    @Configurable
    @Configurable.Synchronized
    public WarriorRunnerConfigs warriorRunnerConfigs = new WarriorRunnerConfigs();

    public static class WarriorRunnerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float WARRIOR_RUNNER_HEALTH = 40.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float WARRIOR_RUNNER_ATTACK = 9.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float WARRIOR_RUNNER_SPEED = 0.562650021636486F;

        @Configurable
        @Configurable.Synchronized
        public int WARRIOR_RUNNER_MIN_SPAWN_Y = 32;
    }

    @Configurable
    @Configurable.Synchronized
    public CrusherConfigs crusherConfigs = new CrusherConfigs();

    public static class CrusherConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CRUSHER_HEALTH = 90.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CRUSHER_ATTACK = 12.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float CRUSHER_SPEED = 0.46345001782178874F;

        @Configurable
        @Configurable.Synchronized
        public int CRUSHER_MIN_SPAWN_Y = 0;
    }

    @Configurable
    @Configurable.Synchronized
    public PredalienConfigs predalienConfigs = new PredalienConfigs();

    public static class PredalienConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float PREDALIEN_HEALTH = 230.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float PREDALIEN_ATTACK = 5.5F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float PREDALIEN_SPEED = 0.46345001782178874F;
    }

    @Configurable
    @Configurable.Synchronized
    public EngineerConfigs engineerConfigs = new EngineerConfigs();

    public static class EngineerConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ENGINEER_HEALTH = 160.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ENGINEER_ATTACK = 8.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ENGINEER_SPEED = 0.5115000196695327F;
    }

    @Configurable
    @Configurable.Synchronized
    public YautjaConfigs yautjaConfigs = new YautjaConfigs();

    public static class YautjaConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float YAUTJA_HEALTH = 80.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float YAUTJA_ATTACK = 12.0F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float YAUTJA_SPEED = 0.48360001859664914F;
    }
}
