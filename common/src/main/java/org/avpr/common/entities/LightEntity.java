package org.avpr.common.entities;

import mod.azure.azurelib.common.api.common.helper.CommonUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import org.avpr.common.registries.AVPRItems;

public class LightEntity extends Entity {

    public LightEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {}

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compound) {}

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compound) {}

    /**
     * Overrides the tick method to update the state of the LightEntity. This method performs the following operations:
     * - Calls the superclass tick method. - Checks if the tick count exceeds 60 and the entity is not a passenger, then
     * kills the entity. - Searches for nearby players within a 10-block radius who are wearing a tactical chestplate. -
     * If such a player is found, this entity starts riding the player. - If the player is a ServerPlayer and not in
     * creative or spectator mode, sends a packet to update the client about the new passenger. - Spawns a light source
     * at the entity's location.
     */
    @Override
    public void tick() {
        super.tick();
        if (tickCount > 60 && !this.isPassenger())
            this.kill();
        var findPlayer = level().getEntitiesOfClass(
            Player.class,
            this.getBoundingBox().inflate(10),
            player -> player.getItemBySlot(
                EquipmentSlot.CHEST
            ).is(AVPRItems.ARMOR_TACTICAL_CHESTPLATE.get())
        );
        if (!findPlayer.isEmpty()) {
            this.startRiding(findPlayer.getFirst(), true);
            if (findPlayer.getFirst() instanceof ServerPlayer player && (!player.isCreative() || !player.isSpectator()))
                player.connection.send(new ClientboundSetPassengersPacket(findPlayer.getFirst()));
        }
        CommonUtils.spawnLightSource(this, false);
    }
}
