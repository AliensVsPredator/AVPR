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
import org.avpr.common.client.entities.renders.FacehuggerRenderer;
import org.avpr.common.client.entities.renders.OvamorphRenderer;
import org.avpr.common.client.misc.AcidEntityRender;
import org.avpr.common.particles.AcidParticleProvider;
import org.avpr.common.registries.AVPRBlocks;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRParticles;

public class FabricClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerParticle("acid", AVPRParticles.ACID.get(), AcidParticleProvider::new);
        EntityRenderers.register(AVPREntities.GRENADE_THROWN.get(), ThrownItemRenderer::new);
        EntityRenderers.register(AVPREntities.ACID.get(), AcidEntityRender::new);
        EntityRenderers.register(AVPREntities.OVAMORPH.get(), OvamorphRenderer::new);
        EntityRenderers.register(AVPREntities.FACEHUGGER.get(), FacehuggerRenderer::new);
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
