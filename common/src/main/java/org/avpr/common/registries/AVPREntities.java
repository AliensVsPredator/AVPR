package org.avpr.common.registries;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

import org.avpr.common.CommonMod;
import org.avpr.common.entities.AcidEntity;
import org.avpr.common.entities.LightEntity;
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
import org.avpr.common.entities.projectiles.*;
import org.avpr.common.entities.yautja.YautjaEntity;
import org.avpr.common.platform.AVPRServices;

public record AVPREntities() {

    public static final Supplier<EntityType<LightEntity>> LIGHT_ENTITY = AVPREntities.registerEntity(
        "light_entity",
        LightEntity::new,
        MobCategory.MISC,
        0.66F,
        0.05F
    );

    public static final Supplier<EntityType<FlamethrowProjectile>> FLAMETHROW_ENTITY = AVPREntities.registerEntity(
        "flamethrow_entity",
        FlamethrowProjectile::new,
        MobCategory.MISC,
        0.66F,
        0.05F
    );

    public static final Supplier<EntityType<BulletProjectile>> BULLET = AVPREntities.registerEntity(
        "bullet",
        BulletProjectile::new,
        MobCategory.MISC,
        0.5F,
        0.5F
    );

    public static final Supplier<EntityType<ThrownGrenade>> GRENADE_THROWN = AVPREntities.registerEntity(
        "grenade_thrown",
        ThrownGrenade::new,
        MobCategory.MISC,
        0.25F,
        0.25F
    );

    public static final Supplier<EntityType<ShurikenItemEntity>> SHURKIEN_ENTITY = AVPREntities.registerEntity(
        "shuriken_entity",
        ShurikenItemEntity::new,
        MobCategory.MISC,
        0.25F,
        0.25F
    );

    public static final Supplier<EntityType<SmartDiscItemEntity>> SMARTDISC_ENTITY = AVPREntities.registerEntity(
        "smartdisc_entity",
        SmartDiscItemEntity::new,
        MobCategory.MISC,
        0.25F,
        0.25F
    );

    public static final Supplier<EntityType<RocketProjectile>> ROCKET_ENTITY = AVPREntities.registerEntity(
        "rocket_entity",
        RocketProjectile::new,
        MobCategory.MISC,
        0.25F,
        0.25F
    );

    public static final Supplier<EntityType<AcidEntity>> ACID = AVPREntities.registerEntity(
        "acid",
        AcidEntity::new,
        MobCategory.MISC,
        0.66F,
        0.05F
    );

    public static final Supplier<EntityType<BoilerEntity>> BOILER = AVPREntities.registerEntity(
        "boiler",
        BoilerEntity::new,
        MobCategory.MONSTER,
        0.98F,
        2.48F
    );

    public static final Supplier<EntityType<ChestbursterEntity>> CHESTBURSTER = AVPREntities.registerEntity(
        "chestburster",
        ChestbursterEntity::new,
        MobCategory.MONSTER,
        0.75F,
        0.3F
    );

    public static final Supplier<EntityType<ChestbursterQueenEntity>> CHESTBURSTER_QUEEN = AVPREntities.registerEntity(
        "chestburster_queen",
        ChestbursterQueenEntity::new,
        MobCategory.MONSTER,
        0.75F,
        0.98F
    );

    public static final Supplier<EntityType<DroneEntity>> DRONE = AVPREntities.registerEntity(
        "drone",
        DroneEntity::new,
        MobCategory.MONSTER,
        0.98F,
        1.98F
    );

    public static final Supplier<EntityType<FacehuggerEntity>> FACEHUGGER = AVPREntities.registerEntity(
        "facehugger",
        FacehuggerEntity::new,
        MobCategory.MONSTER,
        0.75F,
        0.3F
    );

    public static final Supplier<EntityType<FacehuggerRoyalEntity>> FACEHUGGER_ROYAL = AVPREntities.registerEntity(
        "facehugger_royal",
        FacehuggerRoyalEntity::new,
        MobCategory.MONSTER,
        0.75F,
        0.3F
    );

    public static final Supplier<EntityType<NauticomorphEntity>> NAUTICOMORPH = AVPREntities.registerEntity(
        "nauticomorph",
        NauticomorphEntity::new,
        MobCategory.MONSTER,
        0.98F,
        1.98F
    );

    public static final Supplier<EntityType<OvamorphEntity>> OVAMORPH = AVPREntities.registerEntity(
        "ovamorph",
        OvamorphEntity::new,
        MobCategory.MONSTER,
        0.88F,
        0.98F
    );

    public static final Supplier<EntityType<PraetorianEntity>> PRAETORIAN = AVPREntities.registerEntity(
        "praetorian",
        PraetorianEntity::new,
        MobCategory.MONSTER,
        0.98F,
        2.48F
    );

    public static final Supplier<EntityType<QueenEntity>> QUEEN = AVPREntities.registerEntity(
        "queen",
        QueenEntity::new,
        MobCategory.MONSTER,
        1.98F,
        3.98F
    );

    public static final Supplier<EntityType<SpitterEntity>> SPITTER = AVPREntities.registerEntity(
        "spitter",
        SpitterEntity::new,
        MobCategory.MONSTER,
        0.98F,
        1.98F
    );

    public static final Supplier<EntityType<UltramorphEntity>> ULTRAMORPH = AVPREntities.registerEntity(
        "ultramorph",
        UltramorphEntity::new,
        MobCategory.MONSTER,
        0.98F,
        1.98F
    );

    public static final Supplier<EntityType<WarriorEntity>> WARRIOR = AVPREntities.registerEntity(
        "warrior",
        WarriorEntity::new,
        MobCategory.MONSTER,
        0.98F,
        1.98F
    );

    public static final Supplier<EntityType<BelugabursterEntity>> BELUGABURSTER = AVPREntities.registerEntity(
        "belugaburster",
        BelugabursterEntity::new,
        MobCategory.MONSTER,
        0.78F,
        0.98F
    );

    public static final Supplier<EntityType<BelugamorphEntity>> BELUGAMORPH = AVPREntities.registerEntity(
        "belugamorph",
        BelugamorphEntity::new,
        MobCategory.MONSTER,
        0.75F,
        2.98F
    );

    public static final Supplier<EntityType<OctohuggerEntity>> OCTOHUGGER = AVPREntities.registerEntity(
        "octohugger",
        OctohuggerEntity::new,
        MobCategory.MONSTER,
        0.25F,
        0.75F
    );

    public static final Supplier<EntityType<DeaconAdultEntity>> DEACON_ADULT = AVPREntities.registerEntity(
        "deacon_adult",
        DeaconAdultEntity::new,
        MobCategory.MONSTER,
        0.98F,
        2.48F
    );

    public static final Supplier<EntityType<DeaconAdultEngineerEntity>> DEACON_ADULT_ENGINEER = AVPREntities.registerEntity(
        "deacon_adult_engineer",
        DeaconAdultEngineerEntity::new,
        MobCategory.MONSTER,
        0.98F,
        2.98F
    );

    public static final Supplier<EntityType<DeaconEntity>> DEACON = AVPREntities.registerEntity(
        "deacon",
        DeaconEntity::new,
        MobCategory.MONSTER,
        0.75F,
        1.98F
    );

    public static final Supplier<EntityType<TriolobiteBabyEntity>> TRIOLOBITE_BABY = AVPREntities.registerEntity(
        "trilobite_baby",
        TriolobiteBabyEntity::new,
        MobCategory.MONSTER,
        0.5F,
        0.25F
    );

    public static final Supplier<EntityType<TriolobiteEntity>> TRIOLOBITE = AVPREntities.registerEntity(
        "trilobite",
        TriolobiteEntity::new,
        MobCategory.MONSTER,
        1.98F,
        1.98F
    );

    public static final Supplier<EntityType<ChestbursterDracoEntity>> CHESTBURSTER_DRACO = AVPREntities.registerEntity(
        "chestburster_draco",
        ChestbursterDracoEntity::new,
        MobCategory.MONSTER,
        0.75F,
        0.98F
    );

    public static final Supplier<EntityType<DracomorphEntity>> DRACOMORPH = AVPREntities.registerEntity(
        "dracomorph",
        DracomorphEntity::new,
        MobCategory.MONSTER,
        1.98F,
        2.98F
    );

    public static final Supplier<EntityType<OvamorphDracoEntity>> OVAMORPH_DRACO = AVPREntities.registerEntity(
        "ovamorph_draco",
        OvamorphDracoEntity::new,
        MobCategory.MONSTER,
        0.98F,
        0.98F
    );

    public static final Supplier<EntityType<ChestbursterRunnerEntity>> CHESTBURSTER_RUNNER = AVPREntities.registerEntity(
        "chestburster_runner",
        ChestbursterRunnerEntity::new,
        MobCategory.MONSTER,
        0.75F,
        0.98F
    );

    public static final Supplier<EntityType<CrusherEntity>> CRUSHER = AVPREntities.registerEntity(
        "crusher",
        CrusherEntity::new,
        MobCategory.MONSTER,
        0.75F,
        0.3F
    );

    public static final Supplier<EntityType<DroneRunnerEntity>> DRONE_RUNNER = AVPREntities.registerEntity(
        "drone_runner",
        DroneRunnerEntity::new,
        MobCategory.MONSTER,
        0.98F,
        1.98F
    );

    public static final Supplier<EntityType<WarriorDroneEntity>> WARRIOR_RUNNER = AVPREntities.registerEntity(
        "warrior_runner",
        WarriorDroneEntity::new,
        MobCategory.MONSTER,
        0.98F,
        1.98F
    );

    public static final Supplier<EntityType<PredalienEntity>> PREDALIEN = AVPREntities.registerEntity(
        "predalien",
        PredalienEntity::new,
        MobCategory.MONSTER,
        0.98F,
        2.48F
    );

    public static final Supplier<EntityType<EngineerEntity>> ENGINEER = AVPREntities.registerEntity(
        "engineer",
        EngineerEntity::new,
        MobCategory.MONSTER,
        0.98F,
        2.48F
    );

    public static final Supplier<EntityType<YautjaEntity>> YAUTJA = AVPREntities.registerEntity(
        "yautja",
        YautjaEntity::new,
        MobCategory.MONSTER,
        0.98F,
        2.48F
    );

    /**
     * Example of using this method to create a new Entity:
     * <p>
     * The following code demonstrates how to register a new entity type in the game:
     * </p>
     *
     * <pre>{@code
     *
     * public static final Supplier<EntityType<TestEntity>> TEST = AVPREntities.registerEntity(
     *     "entityname",
     *     TestEntity::new,
     *     MobCategory.CREATURE,
     *     0.7f,
     *     1.3f
     * );
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerEntity</code> is a method to register a new entity with the specified entity name, factory
     * method, dimensions, and spawn egg colors.</li>
     * <li><code>TestEntity::new</code> is a reference to the constructor of the <code>TestEntity</code> class.</li>
     * <li><code>0.7f</code> and <code>1.3f</code> represent the width and height of the entity, respectively.</li>
     * <li><code>0x1F1F1F</code> and <code>0x0D0D0D</code> represent the primary and secondary colors of the entity's
     * spawn egg.</li>
     * </ul>
     * <p>
     * The {@link EntityType EntityType} class represents an entity type in the game.
     * </p>
     * Registers a new entity type.
     *
     * @param entityName The name of the entity.
     * @param entity     The factory method for creating instances of the entity.
     * @param width      The width of the entity.
     * @param height     The height of the entity.
     * @param <T>        The type of the entity.
     * @return A supplier for the registered entity type.
     */
    static <T extends Entity> Supplier<EntityType<T>> registerEntity(
        String entityName,
        EntityType.EntityFactory<T> entity,
        MobCategory mobCategory,
        float width,
        float height
    ) {
        return AVPRServices.COMMON_REGISTRY.registerEntity(
            CommonMod.MOD_ID,
            entityName,
            () -> EntityType.Builder.of(entity, mobCategory).sized(width, height).build(entityName)
        );
    }

    public static void initialize() {}
}
