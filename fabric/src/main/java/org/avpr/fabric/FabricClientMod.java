package org.avpr.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import org.avpr.common.CommonMod;
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
        AVPRBlocks.getAllGlassBlocks().forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.translucent()));
        AVPRBlocks.getAllMetalBlocks().forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.translucent()));
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.RESIN_VEIN_BLOCK.get(), RenderType.translucent());
        BlockRenderLayerMap.INSTANCE.putBlock(AVPRBlocks.RESIN_WEBBING_BLOCK.get(), RenderType.cutout());
    }

    private void registerParticle(String path, SimpleParticleType type, ParticleFactoryRegistry.PendingParticleFactory<SimpleParticleType> factory) {
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, CommonMod.modResource(path), type);
        ParticleFactoryRegistry.getInstance().register(type, factory);
    }
}
