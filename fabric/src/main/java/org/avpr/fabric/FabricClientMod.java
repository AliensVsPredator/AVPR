package org.avpr.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.renders.alien.base_line.*;
import org.avpr.common.client.entities.renders.alien.beluga_line.*;
import org.avpr.common.client.entities.renders.alien.deacon_line.*;
import org.avpr.common.client.entities.renders.alien.draco_line.*;
import org.avpr.common.client.entities.renders.alien.predalien_line.PredalienRenderer;
import org.avpr.common.client.entities.renders.alien.runner_line.*;
import org.avpr.common.client.entities.renders.engineer.EngineerRenderer;
import org.avpr.common.client.entities.renders.items.SkurikenItemRenderer;
import org.avpr.common.client.entities.renders.yautja.YautjaRenderer;
import org.avpr.common.client.misc.AcidEntityRender;
import org.avpr.common.particles.AcidParticleProvider;
import org.avpr.common.registries.AVPRBlocks;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRParticles;

public class FabricClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerParticle("acid", AVPRParticles.ACID.get(), AcidParticleProvider::new);
        EntityRenderers.register(AVPREntities.ACID.get(), AcidEntityRender::new);
        EntityRenderers.register(AVPREntities.CHESTBURSTER.get(), ChestbursterRenderer::new);
        EntityRenderers.register(AVPREntities.CHESTBURSTER_QUEEN.get(), ChestbursterQueenRenderer::new);
        EntityRenderers.register(AVPREntities.FACEHUGGER_ROYAL.get(), FacehuggerRoyalRenderer::new);
        EntityRenderers.register(AVPREntities.FACEHUGGER.get(), FacehuggerRenderer::new);
        EntityRenderers.register(AVPREntities.OVAMORPH.get(), OvamorphRenderer::new);
        EntityRenderers.register(AVPREntities.DRONE.get(), DroneRenderer::new);
        EntityRenderers.register(AVPREntities.WARRIOR.get(), WarriorRenderer::new);
        EntityRenderers.register(AVPREntities.BOILER.get(), BoilerRenderer::new);
        EntityRenderers.register(AVPREntities.NAUTICOMORPH.get(), NauticomorphRenderer::new);
        EntityRenderers.register(AVPREntities.PRAETORIAN.get(), PraetorianRenderer::new);
        EntityRenderers.register(AVPREntities.SPITTER.get(), SpitterRenderer::new);
        EntityRenderers.register(AVPREntities.ULTRAMORPH.get(), UltramorphRenderer::new);
        EntityRenderers.register(AVPREntities.QUEEN.get(), QueenRenderer::new);
        EntityRenderers.register(AVPREntities.OCTOHUGGER.get(), OctohuggerRenderer::new);
        EntityRenderers.register(AVPREntities.BELUGABURSTER.get(), BelugabursterRenderer::new);
        EntityRenderers.register(AVPREntities.BELUGAMORPH.get(), BelugamorphRenderer::new);
        EntityRenderers.register(AVPREntities.TRIOLOBITE_BABY.get(), TriolobiteBabyRenderer::new);
        EntityRenderers.register(AVPREntities.TRIOLOBITE.get(), TriolobiteRenderer::new);
        EntityRenderers.register(AVPREntities.DEACON_ADULT.get(), DeaconAdultRenderer::new);
        EntityRenderers.register(AVPREntities.DEACON_ADULT_ENGINEER.get(), DeaconAdultEngineerRenderer::new);
        EntityRenderers.register(AVPREntities.DEACON.get(), DeaconRenderer::new);
        EntityRenderers.register(AVPREntities.CHESTBURSTER_DRACO.get(), ChestbursterDracoRenderer::new);
        EntityRenderers.register(AVPREntities.DRACOMORPH.get(), DracomorphRenderer::new);
        EntityRenderers.register(AVPREntities.OVAMORPH_DRACO.get(), OvamorphDracoRenderer::new);
        EntityRenderers.register(AVPREntities.CHESTBURSTER_RUNNER.get(), ChestbursterRunnerRenderer::new);
        EntityRenderers.register(AVPREntities.DRONE_RUNNER.get(), DroneRunnerRenderer::new);
        EntityRenderers.register(AVPREntities.WARRIOR_RUNNER.get(), WarriorRunnerRenderer::new);
        EntityRenderers.register(AVPREntities.CRUSHER.get(), CrusherRenderer::new);
        EntityRenderers.register(AVPREntities.PREDALIEN.get(), PredalienRenderer::new);
        EntityRenderers.register(AVPREntities.ENGINEER.get(), EngineerRenderer::new);
        EntityRenderers.register(AVPREntities.YAUTJA.get(), YautjaRenderer::new);
        EntityRenderers.register(AVPREntities.GRENADE_THROWN.get(), ThrownItemRenderer::new);
        EntityRenderers.register(AVPREntities.SHURKIEN_ENTITY.get(), SkurikenItemRenderer::new);
        EntityRenderers.register(AVPREntities.SMARTDISC_ENTITY.get(), SkurikenItemRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_WHITE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_ORANGE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_MAGENTA.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_LIGHT_BLUE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_YELLOW.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_LIME.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_PINK.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_GRAY.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_LIGHT_GRAY.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_CYAN.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_PURPLE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_BLUE.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_BROWN.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_GREEN.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_RED.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.INDUSTRIAL_GLASS_BLACK.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.gold_grate.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.aluminum_grate.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.iron_grate.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.copper_grate.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.steel_grate.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.ferroaluminum_grate.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.titanium_grate.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.RESIN_WEBBING_BLOCK.get(), RenderType.cutout());
    }

    private void registerParticle(
        String path,
        SimpleParticleType type,
        ParticleFactoryRegistry.PendingParticleFactory<SimpleParticleType> factory
    ) {
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, CommonMod.modResource(path), type);
        ParticleFactoryRegistry.getInstance().register(type, factory);
    }
}
