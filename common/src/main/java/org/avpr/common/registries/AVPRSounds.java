package org.avpr.common.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

import org.avpr.common.CommonMod;
import org.avpr.common.platform.AVPRServices;

public record AVPRSounds() {

    public static Supplier<SoundEvent> BLOCK_ACID_BURN = AVPRSounds.registerSound(
        "block.acid.burn",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "block.acid.burn")
        )
    );

    public static Supplier<SoundEvent> OVAMORPH_OPEN = AVPRSounds.registerSound(
        "entity.ovamorph.open",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.ovamorph.open")
        )
    );

    public static Supplier<SoundEvent> IMPREGNATE = AVPRSounds.registerSound(
        "entity.parasite.impregnate",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.parasite.impregnate")
        )
    );

    public static Supplier<SoundEvent> ENTITY_BOILER_AMBIENT = AVPRSounds.registerSound(
        "entity.boiler.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.boiler.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_BOILER_DEATH = AVPRSounds.registerSound(
        "entity.boiler.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.boiler.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_BOILER_HURT = AVPRSounds.registerSound(
        "entity.boiler.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.boiler.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CHESTBURSTER_DEATH = AVPRSounds.registerSound(
        "entity.chestburster.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.chestburster.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CHESTBURSTER_HURT = AVPRSounds.registerSound(
        "entity.chestburster.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.chestburster.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CHESTBURSTER_DRACO_DEATH = AVPRSounds.registerSound(
        "entity.chestburster_draco.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.chestburster_draco.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CHESTBURSTER_DRACO_HURT = AVPRSounds.registerSound(
        "entity.chestburster_draco.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.chestburster_draco.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CHESTBURSTER_QUEEN_DEATH = AVPRSounds.registerSound(
        "entity.chestburster_queen.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.chestburster_queen.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CHESTBURSTER_QUEEN_HURT = AVPRSounds.registerSound(
        "entity.chestburster_queen.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.chestburster_queen.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CHESTBURSTER_RUNNER_DEATH = AVPRSounds.registerSound(
        "entity.chestburster_runner.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.chestburster_runner.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CHESTBURSTER_RUNNER_HURT = AVPRSounds.registerSound(
        "entity.chestburster_runner.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.chestburster_runner.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CRUSHER_AMBIENT = AVPRSounds.registerSound(
        "entity.crusher.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.crusher.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CRUSHER_DEATH = AVPRSounds.registerSound(
        "entity.crusher.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.crusher.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_CRUSHER_HURT = AVPRSounds.registerSound(
        "entity.crusher.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.crusher.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRACOMORPH_AMBIENT = AVPRSounds.registerSound(
        "entity.dracomorph.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.dracomorph.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRACOMORPH_DEATH = AVPRSounds.registerSound(
        "entity.dracomorph.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.dracomorph.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRACOMORPH_HURT = AVPRSounds.registerSound(
        "entity.dracomorph.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.dracomorph.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRONE_AMBIENT = AVPRSounds.registerSound(
        "entity.drone.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.drone.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRONE_DEATH = AVPRSounds.registerSound(
        "entity.drone.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.drone.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRONE_HURT = AVPRSounds.registerSound(
        "entity.drone.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.drone.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRONE_RUNNER_AMBIENT = AVPRSounds.registerSound(
        "entity.drone_runner.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.drone_runner.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRONE_RUNNER_DEATH = AVPRSounds.registerSound(
        "entity.drone_runner.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.drone_runner.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_DRONE_RUNNER_HURT = AVPRSounds.registerSound(
        "entity.drone_runner.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.drone_runner.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_NAUTICOMORPH_AMBIENT = AVPRSounds.registerSound(
        "entity.nauticomorph.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.nauticomorph.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_NAUTICOMORPH_DEATH = AVPRSounds.registerSound(
        "entity.nauticomorph.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.nauticomorph.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_NAUTICOMORPH_HURT = AVPRSounds.registerSound(
        "entity.nauticomorph.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.nauticomorph.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_PRAETORIAN_AMBIENT = AVPRSounds.registerSound(
        "entity.praetorian.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.praetorian.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_PRAETORIAN_DEATH = AVPRSounds.registerSound(
        "entity.praetorian.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.praetorian.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_PRAETORIAN_HURT = AVPRSounds.registerSound(
        "entity.praetorian.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.praetorian.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_QUEEN_AMBIENT = AVPRSounds.registerSound(
        "entity.queen.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.queen.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_QUEEN_AMBIENT_LOOP = AVPRSounds.registerSound(
        "entity.queen.ambient.loop",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.queen.ambient.loop")
        )
    );

    public static Supplier<SoundEvent> ENTITY_QUEEN_DEATH = AVPRSounds.registerSound(
        "entity.queen.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.queen.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_QUEEN_HURT = AVPRSounds.registerSound(
        "entity.queen.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.queen.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_SPITTER_AMBIENT = AVPRSounds.registerSound(
        "entity.spitter.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.spitter.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_SPITTER_DEATH = AVPRSounds.registerSound(
        "entity.spitter.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.spitter.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_SPITTER_HURT = AVPRSounds.registerSound(
        "entity.spitter.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.spitter.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_ULTRAMORPH_AMBIENT = AVPRSounds.registerSound(
        "entity.ultramorph.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.ultramorph.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_ULTRAMORPH_DEATH = AVPRSounds.registerSound(
        "entity.ultramorph.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.ultramorph.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_ULTRAMORPH_HURT = AVPRSounds.registerSound(
        "entity.ultramorph.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.ultramorph.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_WARRIOR_AMBIENT = AVPRSounds.registerSound(
        "entity.warrior.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.warrior.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_WARRIOR_DEATH = AVPRSounds.registerSound(
        "entity.warrior.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.warrior.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_WARRIOR_HURT = AVPRSounds.registerSound(
        "entity.warrior.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.warrior.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_WARRIOR_RUNNER_AMBIENT = AVPRSounds.registerSound(
        "entity.warrior_runner.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.warrior_runner.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_WARRIOR_RUNNER_DEATH = AVPRSounds.registerSound(
        "entity.warrior_runner.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.warrior_runner.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_WARRIOR_RUNNER_HURT = AVPRSounds.registerSound(
        "entity.warrior_runner.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.warrior_runner.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_XENOMORPH_AMBIENT = AVPRSounds.registerSound(
        "entity.xenomorph.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.xenomorph.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_XENOMORPH_ATTACK = AVPRSounds.registerSound(
        "entity.xenomorph.attack",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.xenomorph.attack")
        )
    );

    public static Supplier<SoundEvent> ENTITY_XENOMORPH_DEATH = AVPRSounds.registerSound(
        "entity.xenomorph.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.xenomorph.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_XENOMORPH_EAT = AVPRSounds.registerSound(
        "entity.xenomorph.eat",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.xenomorph.eat")
        )
    );

    public static Supplier<SoundEvent> ENTITY_XENOMORPH_HURT = AVPRSounds.registerSound(
        "entity.xenomorph.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.xenomorph.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_XENOMORPH_HURT_SCREECH = AVPRSounds.registerSound(
        "entity.xenomorph.hurt.screech",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.xenomorph.hurt.screech")
        )
    );

    public static Supplier<SoundEvent> ENTITY_YAUTJA_AMBIENT = AVPRSounds.registerSound(
        "entity.yautja.ambient",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.yautja.ambient")
        )
    );

    public static Supplier<SoundEvent> ENTITY_YAUTJA_CLOAK = AVPRSounds.registerSound(
        "entity.yautja.cloak",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.yautja.cloak")
        )
    );

    public static Supplier<SoundEvent> ENTITY_YAUTJA_DECLOAK = AVPRSounds.registerSound(
        "entity.yautja.decloak",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.yautja.decloak")
        )
    );

    public static Supplier<SoundEvent> ENTITY_YAUTJA_DEATH = AVPRSounds.registerSound(
        "entity.yautja.death",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.yautja.death")
        )
    );

    public static Supplier<SoundEvent> ENTITY_YAUTJA_HURT = AVPRSounds.registerSound(
        "entity.yautja.hurt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.yautja.hurt")
        )
    );

    public static Supplier<SoundEvent> ENTITY_YAUTJA_INTIMIDATE = AVPRSounds.registerSound(
        "entity.yautja.intimidate",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "entity.yautja.intimidate")
        )
    );

    public static Supplier<SoundEvent> ITEM_ARMOR_EQUIP_ALUMINUM = AVPRSounds.registerSound(
        "item.armor.equip_aluminum",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.armor.equip_aluminum")
        )
    );

    public static Supplier<SoundEvent> ITEM_ARMOR_EQUIP_MK50 = AVPRSounds.registerSound(
        "item.armor.equip_mk50",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.armor.equip_mk50")
        )
    );

    public static Supplier<SoundEvent> ITEM_ARMOR_EQUIP_ORIONITE = AVPRSounds.registerSound(
        "item.armor.equip_orionite",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.armor.equip_orionite")
        )
    );

    public static Supplier<SoundEvent> ITEM_ARMOR_EQUIP_PRESSURE = AVPRSounds.registerSound(
        "item.armor.equip_pressure",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.armor.equip_pressure")
        )
    );

    public static Supplier<SoundEvent> ITEM_ARMOR_EQUIP_TACTICAL = AVPRSounds.registerSound(
        "item.armor.equip_tactical",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.armor.equip_tactical")
        )
    );

    public static Supplier<SoundEvent> ITEM_ARMOR_EQUIP_TITANIUM = AVPRSounds.registerSound(
        "item.armor.equip_titanium",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.armor.equip_titanium")
        )
    );

    public static Supplier<SoundEvent> ITEM_ARMOR_EQUIP_VERITANIUM = AVPRSounds.registerSound(
        "item.armor.equip_veritanium",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.armor.equip_veritanium")
        )
    );

    public static Supplier<SoundEvent> ITEM_ARMOR_EQUIP_XENOMORPH_CHITIN = AVPRSounds.registerSound(
        "item.armor.equip_xenomorph_chitin",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.armor.equip_xenomorph_chitin")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_AK_47_SHOOT = AVPRSounds.registerSound(
        "item.weapon.ak_47.shoot",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.ak_47.shoot")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_COMBAT_PISTOL_RELOAD = AVPRSounds.registerSound(
        "item.weapon.combat_pistol.reload",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.combat_pistol.reload")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_COMBAT_PISTOL_SHOOT = AVPRSounds.registerSound(
        "item.weapon.combat_pistol.shoot",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.combat_pistol.shoot")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_FLAMETHROWER_RELOAD_START = AVPRSounds.registerSound(
        "item.weapon.flamethrower.reload_start",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.flamethrower.reload_start")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_FLAMETHROWER_RELOAD_FINISH = AVPRSounds.registerSound(
        "item.weapon.flamethrower.reload_finish",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.flamethrower.reload_finish")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_FLAMETHROWER_SHOOT = AVPRSounds.registerSound(
        "item.weapon.flamethrower.shoot",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.flamethrower.shoot")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_FX_RICOCHET_DIRT = AVPRSounds.registerSound(
        "item.weapon.fx.ricochet.dirt",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.fx.ricochet.dirt")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_FX_RICOCHET_GENERIC = AVPRSounds.registerSound(
        "item.weapon.fx.ricochet.generic",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.fx.ricochet.generic")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_FX_RICOCHET_GLASS = AVPRSounds.registerSound(
        "item.weapon.fx.ricochet.glass",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.fx.ricochet.glass")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_FX_RICOCHET_METAL = AVPRSounds.registerSound(
        "item.weapon.fx.ricochet.metal",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.fx.ricochet.metal")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_FX_ROCKET_EXPLOSION = AVPRSounds.registerSound(
        "item.weapon.fx.rocket_explosion",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.fx.rocket_explosion")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_GENERIC_RELOAD = AVPRSounds.registerSound(
        "item.weapon.generic.reload",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.generic.reload")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_GENERIC_SHOOT = AVPRSounds.registerSound(
        "item.weapon.generic.shoot",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.generic.shoot")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_GENERIC_SHOOT_FAIL = AVPRSounds.registerSound(
        "item.weapon.generic.shoot_fail",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.generic.shoot_fail")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_OLD_PAINLESS_SHOOT_LOOP = AVPRSounds.registerSound(
        "item.weapon.old_painless.shoot_loop",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.old_painless.shoot_loop")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_OLD_PAINLESS_SHOOT_SPINNING = AVPRSounds.registerSound(
        "item.weapon.old_painless.shoot_spinning",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.old_painless.shoot_spinning")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_OLD_PAINLESS_SHOOT_START = AVPRSounds.registerSound(
        "item.weapon.old_painless.shoot_start",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.old_painless.shoot_start")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_OLD_PAINLESS_SHOOT_STOP = AVPRSounds.registerSound(
        "item.weapon.old_painless.shoot_stop",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.old_painless.shoot_stop")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_PULSE_RIFLE_SHOOT = AVPRSounds.registerSound(
        "item.weapon.pulse_rifle.shoot",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.pulse_rifle.shoot")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_ROCKET_LAUNCHER_RELOAD_FINISH = AVPRSounds.registerSound(
        "item.weapon.rocket_launcher.reload_finish",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.rocket_launcher.reload_finish")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_ROCKET_LAUNCHER_RELOAD_START = AVPRSounds.registerSound(
        "item.weapon.rocket_launcher.reload_start",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.rocket_launcher.reload_start")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_ROCKET_LAUNCHER_SHOOT = AVPRSounds.registerSound(
        "item.weapon.rocket_launcher.shoot",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.rocket_launcher.shoot")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_SHOTGUN_SHOOT = AVPRSounds.registerSound(
        "item.weapon.shotgun.shoot",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.shotgun.shoot")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_SNIPER_RIFLE_SHOOT = AVPRSounds.registerSound(
        "item.weapon.sniper_rifle.shoot",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.sniper_rifle.shoot")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_WRISTBLADE_CLOSE = AVPRSounds.registerSound(
        "item.weapon.wristblade.close",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.wristblade.close")
        )
    );

    public static Supplier<SoundEvent> ITEM_WEAPON_WRISTBLADE_OPEN = AVPRSounds.registerSound(
        "item.weapon.wristblade.open",
        () -> SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(CommonMod.MOD_ID, "item.weapon.wristblade.open")
        )
    );

    /**
     * Example of using this method to create a new SoundEvent:
     * <p>
     * The following code demonstrates how to register a new sound event in the game:
     * </p>
     *
     * <pre>{@code
     *
     * public static Supplier<SoundEvent> TEST_SOUND = AVPRSounds.registerSound(
     *     "test_sound",
     *     () -> SoundEvent.createVariableRangeEvent(
     *         ResourceLocation.fromNamespaceAndPath("modid", "test_sound")
     *     )
     * );
     * }</pre>
     * <p>
     * In this example:
     * </p>
     * <ul>
     * <li><code>registerSound</code> is a method to register a new sound event with the specified sound name.</li>
     * <li><code>SoundEvent</code> is used to create a new sound event instance.</li>
     * </ul>
     * <p>
     * The {@link SoundEvent SoundEvent} class represents a sound event in the game.
     * </p>
     * Registers a new sound event.
     *
     * @param soundName The name of the sound event.
     * @param sound     A supplier for the sound event.
     * @param <T>       The type of the sound event.
     * @return A supplier for the registered sound event.
     */
    static <T extends SoundEvent> Supplier<T> registerSound(String soundName, Supplier<T> sound) {
        return AVPRServices.COMMON_REGISTRY.registerSound(CommonMod.MOD_ID, soundName, sound);
    }

    public static void initialize() {}
}
