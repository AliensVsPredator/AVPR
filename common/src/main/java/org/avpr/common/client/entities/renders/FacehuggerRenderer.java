package org.avpr.common.client.entities.renders;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import org.avpr.common.CommonMod;
import org.avpr.common.api.client.TransformData;
import org.avpr.common.api.client.TransformDataGenerator;
import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.alien.base_line.FacehuggerEntity;

public class FacehuggerRenderer extends GeoEntityRenderer<FacehuggerEntity> {

    private final HashMap<EntityType<?>, TransformDataGenerator> headDistances = new HashMap<>();

    public FacehuggerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DefaultEntityModel<>(CommonMod.modResource("facehugger")));
        this.setHeadDistances();
    }

    @Override
    public void render(
        FacehuggerEntity entity,
        float entityYaw,
        float partialTick,
        @NotNull PoseStack poseStack,
        @NotNull MultiBufferSource bufferSource,
        int packedLight
    ) {
        if (entity.isInfertile() && entity.getVehicle() == null) {
            poseStack.translate(0, animatable.getBbHeight() - 0.05f, 0);
            poseStack.mulPose(Axis.ZP.rotationDegrees(180f));
        }
        if (entity.isVehicle() || entity.isPassenger())
            poseStack.translate(0, -0.18, 0);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    protected void applyRotations(
        FacehuggerEntity facehugger,
        PoseStack matrixStackIn,
        float ageInTicks,
        float rotationYaw,
        float partialTicks,
        float nativeScale
    ) {
        if (facehugger.isAlive() && facehugger.isAttachedToHost()) {
            var host = (LivingEntity) facehugger.getVehicle();
            if (host == null)
                return;
            var transformData = getTransformData(facehugger, host);
            var bodyYaw = Mth.rotLerp(partialTicks, host.yBodyRotO, host.yBodyRot);
            var headYaw = Mth.rotLerp(partialTicks, host.yHeadRotO, host.yHeadRot) - bodyYaw;
            var headPitch = Mth.rotLerp(partialTicks, host.getXRot(), host.xRotO);

            // translate head-center
            matrixStackIn.mulPose(Axis.YN.rotationDegrees(bodyYaw));
            matrixStackIn.translate(transformData.originX(), transformData.originY(), transformData.originZ());
            // yaw
            matrixStackIn.mulPose(Axis.YN.rotationDegrees(headYaw));
            // pitch
            matrixStackIn.mulPose(Axis.XP.rotationDegrees(headPitch));
            matrixStackIn.translate(0.0, transformData.headOffset(), transformData.faceOffset()); // apply offsets

        } else
            super.applyRotations(facehugger, matrixStackIn, ageInTicks, rotationYaw, partialTicks, 1);
    }

    @Override
    protected float getShadowRadius(@NotNull FacehuggerEntity entity) {
        return 0.3f;
    }

    @Override
    protected float getDeathMaxRotation(FacehuggerEntity entityLivingBaseIn) {
        return 0.0F;
    }

    @Override
    public float getMotionAnimThreshold(FacehuggerEntity animatable) {
        return 0.005f;
    }

    private double calcStandardOffsetY(FacehuggerEntity facehugger) {
        return -facehugger.getBbWidth();
    }

    public double getPassengersRidingOffset(Entity entity) {
        return entity.getBbHeight() * 0.75;
    }

    private TransformData getTransformData(FacehuggerEntity facehugger, Entity host) {
        return headDistances.computeIfAbsent(
            host.getType(),
            entityType -> (facehugger1, host1) -> new TransformData(
                0.0,
                0.0,
                0.0,
                (host.getEyeHeight(
                    host.getPose()
                )) - this.getPassengersRidingOffset(
                    host
                ) - facehugger.getBbWidth() + host.getBbWidth(),
                calcStandardOffsetY(facehugger)
            )
        ).invoke(facehugger, host);
    }

    public void setHeadDistances() {
        headDistances.put(
            EntityType.SHEEP,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.1,
                0.385,
                calcStandardOffsetY(facehugger) + 0.79
            )
        );// sheep
        headDistances.put(
            EntityType.COW,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.1,
                0.41,
                calcStandardOffsetY(facehugger) + 0.72
            )
        );// cow
        headDistances.put(
            EntityType.PIG,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.1,
                0.41,
                calcStandardOffsetY(facehugger) + 1.00
            )
        );// pig
        headDistances.put(
            EntityType.WOLF,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.2,
                0.74,
                calcStandardOffsetY(facehugger) + 0.92
            )
        );// wolf
        headDistances.put(
            EntityType.VILLAGER,
            (facehugger, host) -> new TransformData(0.0, 0.0, 0.0, 0.36, calcStandardOffsetY(facehugger) + 0.22)
        );// villager
        headDistances.put(
            EntityType.DOLPHIN,
            (facehugger, host) -> new TransformData(0.0, -0.23, 0.0, 0.80, calcStandardOffsetY(facehugger) + 0.5)
        );// doplin
        headDistances.put(
            EntityType.PLAYER,
            (facehugger, host) -> new TransformData(0.0, 0.25, 0.0, 0.21, calcStandardOffsetY(facehugger) + 0.15)
        );// player
        headDistances.put(
            EntityType.DONKEY,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.25,
                0.36,
                calcStandardOffsetY(facehugger) + 1.2
            )
        );// donkey
        headDistances.put(
            EntityType.FOX,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.2,
                0.74,
                calcStandardOffsetY(facehugger) + 1.0
            )
        );// fox
        headDistances.put(
            EntityType.GOAT,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.3,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.0,
                0.36,
                calcStandardOffsetY(facehugger) + 0.9
            )
        );// goat
        headDistances.put(
            EntityType.HOGLIN,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() - 0.1,
                host.getBbWidth() - (facehugger.getBbHeight()) + 0.25,
                0.36,
                calcStandardOffsetY(facehugger) + 0.7
            )
        );// hoglin
        headDistances.put(
            EntityType.HORSE,
            (facehugger, host) -> new TransformData(
                -0.05,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.7,
                host.getBbWidth() - (facehugger.getBbHeight()) + 0.15,
                0.36,
                calcStandardOffsetY(facehugger) + 0.85
            )
        );// horse
        headDistances.put(
            EntityType.MOOSHROOM,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.1,
                0.41,
                calcStandardOffsetY(facehugger) + 0.72
            )
        );// mooshroom
        headDistances.put(
            EntityType.LLAMA,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.6,
                host.getBbWidth() - (facehugger.getBbHeight()) + 0.3,
                0.41,
                calcStandardOffsetY(facehugger) + 1.05
            )
        );// llama
        headDistances.put(
            EntityType.MULE,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.49,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.2,
                0.41,
                calcStandardOffsetY(facehugger) + 1.0
            )
        );// donkey
        headDistances.put(
            EntityType.OCELOT,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.5,
                host.getBbWidth() - (facehugger.getBbHeight()) + 0.1,
                0.41,
                calcStandardOffsetY(facehugger) + 0.95
            )
        );// oce
        headDistances.put(
            EntityType.PANDA,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.2,
                host.getBbWidth() - (facehugger.getBbHeight()) + 0.1,
                0.31,
                calcStandardOffsetY(facehugger) + 0.65
            )
        ); // panda
        headDistances.put(
            EntityType.TURTLE,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.45,
                0.56,
                calcStandardOffsetY(facehugger) + 0.95
            )
        );// turle
        headDistances.put(
            EntityType.PIGLIN,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.1,
                0.11,
                calcStandardOffsetY(facehugger) + 0.5
            )
        );// piglin
        headDistances.put(
            EntityType.PIGLIN_BRUTE,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.4,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.45,
                0.41,
                calcStandardOffsetY(facehugger) + 0.5
            )
        );// piglin brute
        headDistances.put(
            EntityType.RAVAGER,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.3,
                host.getBbWidth() - (facehugger.getBbHeight()) + 0.5,
                -0.3,
                calcStandardOffsetY(facehugger) + 0.0
            )
        );// rev
        headDistances.put(
            EntityType.SNIFFER,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.3,
                host.getBbWidth() - (facehugger.getBbHeight()) + 0.5,
                0.5,
                calcStandardOffsetY(facehugger) + 0.15
            )
        );// sniffer
        headDistances.put(
            EntityType.POLAR_BEAR,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.3,
                host.getBbWidth() - (facehugger.getBbHeight()) + 0.15,
                0.41,
                calcStandardOffsetY(facehugger) + 0.65
            )
        );// polar bear
        headDistances.put(
            EntityType.CAMEL,
            (facehugger, host) -> new TransformData(
                0.0,
                (host.getEyeHeight(host.getPose())) - this.getPassengersRidingOffset(host) - facehugger.getBbWidth() + 0.85,
                host.getBbWidth() - (facehugger.getBbHeight()) - 0.35,
                0.36,
                calcStandardOffsetY(facehugger) + 0.82
            )
        );// camal
    }
}
