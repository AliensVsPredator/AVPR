package org.avpr.neoforge;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.renders.FacehuggerRenderer;
import org.avpr.common.client.entities.renders.OvamorphRenderer;
import org.avpr.common.client.misc.AcidEntityRender;
import org.avpr.common.particles.AcidParticleProvider;
import org.avpr.common.registries.AVPRBlocks;
import org.avpr.common.registries.AVPREntities;
import org.avpr.common.registries.AVPRParticles;

@EventBusSubscriber(modid = CommonMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NeoForgeClientMod {

//    @SubscribeEvent
//    public static void fluidReg(final RegisterClientExtensionsEvent event) {
//    }

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        AVPRBlocks.getAllGlassBlocks().forEach(block -> ItemBlockRenderTypes.setRenderLayer(block, RenderType.translucent()));
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
        event.registerEntityRenderer(AVPREntities.OVAMORPH.get(), OvamorphRenderer::new);
        event.registerEntityRenderer(AVPREntities.FACEHUGGER.get(), FacehuggerRenderer::new);
    }

    @SubscribeEvent
    public static void registry(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(AVPRParticles.ACID.get(), AcidParticleProvider::new);
    }
}
