package org.avpr.common.blocks.behaviors;

import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import org.avpr.common.registries.AVPRItems;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;

public class AVPRDispenserBlockBehaviors {

    private static final Logger LOGGER = LoggerFactory.getLogger(AVPRDispenserBlockBehaviors.class);

    public static final AVPRDispenserBlockBehaviors INSTANCE = new AVPRDispenserBlockBehaviors();

    private AVPRDispenserBlockBehaviors() {}

    public void registerAll() {
        // Borrowed from Mojang's own dispenser behavior logic for vanilla spawn eggs.
        var defaultDispenseItemBehavior = new DefaultDispenseItemBehavior() {

            @Override
            public @NotNull ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
                var direction = blockSource.state().getValue(DispenserBlock.FACING);
                var entitytype = ((SpawnEggItem) itemStack.getItem()).getType(itemStack);

                try {
                    entitytype.spawn(
                        blockSource.level(),
                        itemStack,
                        null,
                        blockSource.pos().relative(direction),
                        MobSpawnType.DISPENSER,
                        direction != Direction.UP,
                        false
                    );
                } catch (Exception exception) {
                    AVPRDispenserBlockBehaviors.LOGGER.error("Error while dispensing spawn egg from dispenser at {}", blockSource.pos(), exception);
                    return ItemStack.EMPTY;
                }

                itemStack.shrink(1);
                blockSource.level().gameEvent(null, GameEvent.ENTITY_PLACE, blockSource.pos());
                return itemStack;
            }
        };

        SPAWN_EGG_ITEM_SUPPLIERS.forEach(spawnEggItemSupplier -> DispenserBlock.registerBehavior(spawnEggItemSupplier.get(), defaultDispenseItemBehavior));
    }

    // TODO: Holy shit automate this this was annoying to put together and will be annoying to maintain.
    private static final List<Supplier<SpawnEggItem>> SPAWN_EGG_ITEM_SUPPLIERS = List.of(
        AVPRItems.BELUGABURSTER_SPAWN_EGG,
        AVPRItems.BELUGAMORPH_SPAWN_EGG,
        AVPRItems.BOILER_SPAWN_EGG,
        AVPRItems.CHESTBURSTER_DRACO_SPAWN_EGG,
        AVPRItems.CHESTBURSTER_QUEEN_SPAWN_EGG,
        AVPRItems.CHESTBURSTER_RUNNER_SPAWN_EGG,
        AVPRItems.CHESTBURSTER_SPAWN_EGG,
        AVPRItems.CRUSHER_SPAWN_EGG,
        AVPRItems.DEACON_ADULT_ENGINEER_SPAWN_EGG,
        AVPRItems.DEACON_ADULT_SPAWN_EGG,
        AVPRItems.DEACON_SPAWN_EGG,
        AVPRItems.DRACOMORPH_SPAWN_EGG,
        AVPRItems.DRONE_RUNNER_SPAWN_EGG,
        AVPRItems.DRONE_SPAWN_EGG,
        AVPRItems.ENGINEER_SPAWN_EGG,
        AVPRItems.FACEHUGGER_SPAWN_EGG,
        AVPRItems.NAUTICOMORPH_SPAWN_EGG,
        AVPRItems.OCTOHUGGER_SPAWN_EGG,
        AVPRItems.OVAMORPH_DRACO_SPAWN_EGG,
        AVPRItems.OVAMORPH_SPAWN_EGG,
        AVPRItems.PRAETORIAN_SPAWN_EGG,
        AVPRItems.PREDALIEN_SPAWN_EGG,
        AVPRItems.QUEEN_SPAWN_EGG,
        AVPRItems.SPITTER_SPAWN_EGG,
        AVPRItems.TRIOLOBITE_BABY_SPAWN_EGG,
        AVPRItems.TRIOLOBITE_SPAWN_EGG,
        AVPRItems.ULTRAMORPH_SPAWN_EGG,
        AVPRItems.WARRIOR_RUNNER_SPAWN_EGG,
        AVPRItems.WARRIOR_SPAWN_EGG,
        AVPRItems.YAUTJA_SPAWN_EGG
    );
}
