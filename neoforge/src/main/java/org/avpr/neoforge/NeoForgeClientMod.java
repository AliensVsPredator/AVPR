package org.avpr.neoforge;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import org.lwjgl.glfw.GLFW;

import org.avpr.common.CommonMod;
import org.avpr.common.client.Keybinds;
import org.avpr.common.client.entities.renders.alien.base_line.*;
import org.avpr.common.client.entities.renders.alien.beluga_line.*;
import org.avpr.common.client.entities.renders.alien.deacon_line.*;
import org.avpr.common.client.entities.renders.alien.draco_line.*;
import org.avpr.common.client.entities.renders.alien.predalien_line.PredalienRenderer;
import org.avpr.common.client.entities.renders.alien.runner_line.*;
import org.avpr.common.client.entities.renders.engineer.EngineerRenderer;
import org.avpr.common.client.entities.renders.items.SkurikenItemRenderer;
import org.avpr.common.client.entities.renders.projectiles.EmptyRender;
import org.avpr.common.client.entities.renders.projectiles.RocketRenderer;
import org.avpr.common.client.entities.renders.yautja.YautjaRenderer;
import org.avpr.common.client.misc.AcidEntityRender;
import org.avpr.common.particles.AcidParticleProvider;
import org.avpr.common.registries.AVPRBlocks;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRParticles;

@EventBusSubscriber(modid = CommonMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NeoForgeClientMod {

    // @SubscribeEvent
    // public static void fluidReg(final RegisterClientExtensionsEvent event) {
    // }

    @SubscribeEvent
    public static void registerKeys(final RegisterKeyMappingsEvent event) {
        Keybinds.FLASHLIGHT = new KeyMapping(
            "key.avpr.flashlighttoggle",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_F,
            "keybind.category.avpr"
        );
        event.register(Keybinds.FLASHLIGHT);
    }

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_WHITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_ORANGE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_MAGENTA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_LIGHT_BLUE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_YELLOW.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_LIME.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_PINK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_GRAY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_LIGHT_GRAY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_CYAN.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_PURPLE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_BLUE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_BROWN.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_GREEN.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_RED.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS_BLACK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.RESIN_VEIN_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.INDUSTRIAL_GLASS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.gold_grate.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.aluminum_grate.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.iron_grate.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.copper_grate.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.steel_grate.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.ferroaluminum_grate.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.titanium_grate.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(AVPRBlocks.RESIN_WEBBING_BLOCK.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AVPREntities.ACID.get(), AcidEntityRender::new);
        event.registerEntityRenderer(AVPREntities.LIGHT_ENTITY.get(), AcidEntityRender::new);
        event.registerEntityRenderer(AVPREntities.CHESTBURSTER.get(), ChestbursterRenderer::new);
        event.registerEntityRenderer(AVPREntities.CHESTBURSTER_QUEEN.get(), ChestbursterQueenRenderer::new);
        event.registerEntityRenderer(AVPREntities.FACEHUGGER_ROYAL.get(), FacehuggerRoyalRenderer::new);
        event.registerEntityRenderer(AVPREntities.FACEHUGGER.get(), FacehuggerRenderer::new);
        event.registerEntityRenderer(AVPREntities.OVAMORPH.get(), OvamorphRenderer::new);
        event.registerEntityRenderer(AVPREntities.DRONE.get(), DroneRenderer::new);
        event.registerEntityRenderer(AVPREntities.WARRIOR.get(), WarriorRenderer::new);
        event.registerEntityRenderer(AVPREntities.BOILER.get(), BoilerRenderer::new);
        event.registerEntityRenderer(AVPREntities.NAUTICOMORPH.get(), NauticomorphRenderer::new);
        event.registerEntityRenderer(AVPREntities.PRAETORIAN.get(), PraetorianRenderer::new);
        event.registerEntityRenderer(AVPREntities.SPITTER.get(), SpitterRenderer::new);
        event.registerEntityRenderer(AVPREntities.ULTRAMORPH.get(), UltramorphRenderer::new);
        event.registerEntityRenderer(AVPREntities.QUEEN.get(), QueenRenderer::new);
        event.registerEntityRenderer(AVPREntities.OCTOHUGGER.get(), OctohuggerRenderer::new);
        event.registerEntityRenderer(AVPREntities.BELUGABURSTER.get(), BelugabursterRenderer::new);
        event.registerEntityRenderer(AVPREntities.BELUGAMORPH.get(), BelugamorphRenderer::new);
        event.registerEntityRenderer(AVPREntities.TRILOBITE_BABY.get(), TriolobiteBabyRenderer::new);//
        event.registerEntityRenderer(AVPREntities.TRILOBITE.get(), TriolobiteRenderer::new);
        event.registerEntityRenderer(AVPREntities.DEACON_ADULT.get(), DeaconAdultRenderer::new);
        event.registerEntityRenderer(AVPREntities.DEACON_ADULT_ENGINEER.get(), DeaconAdultEngineerRenderer::new);
        event.registerEntityRenderer(AVPREntities.DEACON.get(), DeaconRenderer::new);
        event.registerEntityRenderer(AVPREntities.CHESTBURSTER_DRACO.get(), ChestbursterDracoRenderer::new);//
        event.registerEntityRenderer(AVPREntities.DRACOMORPH.get(), DracomorphRenderer::new);//
        event.registerEntityRenderer(AVPREntities.OVAMORPH_DRACO.get(), OvamorphDracoRenderer::new);//
        event.registerEntityRenderer(AVPREntities.CHESTBURSTER_RUNNER.get(), ChestbursterRunnerRenderer::new);//
        event.registerEntityRenderer(AVPREntities.DRONE_RUNNER.get(), DroneRunnerRenderer::new);//
        event.registerEntityRenderer(AVPREntities.WARRIOR_RUNNER.get(), WarriorRunnerRenderer::new);//
        event.registerEntityRenderer(AVPREntities.CRUSHER.get(), CrusherRenderer::new);//
        event.registerEntityRenderer(AVPREntities.PREDALIEN.get(), PredalienRenderer::new);
        event.registerEntityRenderer(AVPREntities.ENGINEER.get(), EngineerRenderer::new);
        event.registerEntityRenderer(AVPREntities.YAUTJA.get(), YautjaRenderer::new);
        event.registerEntityRenderer(AVPREntities.GRENADE_THROWN.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(AVPREntities.SHURIKEN_ENTITY.get(), SkurikenItemRenderer::new);
        event.registerEntityRenderer(AVPREntities.SMART_DISC_ENTITY.get(), SkurikenItemRenderer::new);
        event.registerEntityRenderer(AVPREntities.BULLET.get(), EmptyRender::new);
        event.registerEntityRenderer(AVPREntities.ROCKET_ENTITY.get(), RocketRenderer::new);
        event.registerEntityRenderer(AVPREntities.FLAMETHROW_ENTITY.get(), EmptyRender::new);
    }

    @SubscribeEvent
    public static void registry(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(AVPRParticles.ACID.get(), AcidParticleProvider::new);
    }
}
