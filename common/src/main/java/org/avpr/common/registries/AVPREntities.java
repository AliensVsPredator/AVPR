package org.avpr.common.registries;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import org.avpr.common.CommonMod;
import org.avpr.common.entities.AcidEntity;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;
import org.avpr.common.entities.alien.base_line.OvamorphEntity;
import org.avpr.common.platform.AVPRServices;

import java.util.function.Supplier;

public class AVPREntities {

    public static final Supplier<EntityType<AcidEntity>> ACID = AVPREntities.registerEntity("acid", AcidEntity::new, MobCategory.MISC, 0.66F, 0.05F);
    public static final Supplier<EntityType<OvamorphEntity>> OVAMORPH = AVPREntities.registerEntity("ovamorph", OvamorphEntity::new, MobCategory.MONSTER, 0.88F, 0.98F);
    public static final Supplier<EntityType<FacehuggerEntity>> FACEHUGGER = AVPREntities.registerEntity("facehugger", FacehuggerEntity::new, MobCategory.MONSTER, 0.75F, 0.3F);

    /**
     * Example of using this method to create a new Entity:
     * <p>
     * The following code demonstrates how to register a new entity type in the game:
     * </p>
     * <pre>{@code
     * public static final Supplier<EntityType<TestEntity>> TEST = AVPREntities.registerEntity("entityname", TestEntity::new, MobCategory.CREATURE, 0.7f, 1.3f);
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerEntity</code> is a method to register a new entity with the specified entity name, factory method, dimensions, and spawn egg colors.</li>
     * <li><code>TestEntity::new</code> is a reference to the constructor of the <code>TestEntity</code> class.</li>
     * <li><code>0.7f</code> and <code>1.3f</code> represent the width and height of the entity, respectively.</li>
     * <li><code>0x1F1F1F</code> and <code>0x0D0D0D</code> represent the primary and secondary colors of the entity's spawn egg.</li>
     * </ul>
     * <p>
     * The {@link EntityType EntityType} class represents an entity type in the game.
     * </p>
     *
     * Registers a new entity type.
     *
     * @param entityName The name of the entity.
     * @param entity     The factory method for creating instances of the entity.
     * @param width      The width of the entity.
     * @param height     The height of the entity.
     * @param <T>        The type of the entity.
     * @return A supplier for the registered entity type.
     */
    static <T extends Entity> Supplier<EntityType<T>> registerEntity(String entityName, EntityType.EntityFactory<T> entity, MobCategory mobCategory, float width, float height) {
        return AVPRServices.COMMON_REGISTRY.registerEntity(CommonMod.MOD_ID, entityName,
                () -> EntityType.Builder.of(entity, mobCategory).sized(width, height).build(entityName));
    }

    public static void initialize() {
    }
}
