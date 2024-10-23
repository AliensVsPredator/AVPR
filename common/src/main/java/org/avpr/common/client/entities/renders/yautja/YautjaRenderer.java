package org.avpr.common.client.entities.renders.yautja;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.renderer.GeoEntityRenderer;
import mod.azure.azurelib.common.internal.common.cache.object.BakedGeoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import org.avpr.common.CommonMod;
import org.avpr.common.client.entities.models.yautja.YautjaModel;
import org.avpr.common.entities.yautja.YautjaEntity;

public class YautjaRenderer extends GeoEntityRenderer<YautjaEntity> {

    public YautjaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new YautjaModel(CommonMod.modResource("yautja/yautja")));
    }

    @Override
    protected float getShadowRadius(@NotNull YautjaEntity entity) {
        return 0.5f;
    }

    @Override
    public void preRender(
        PoseStack poseStack,
        YautjaEntity animatable,
        BakedGeoModel model,
        MultiBufferSource bufferSource,
        VertexConsumer buffer,
        boolean isReRender,
        float partialTick,
        int packedLight,
        int packedOverlay,
        int colour
    ) {
        super.preRender(
            poseStack,
            animatable,
            model,
            bufferSource,
            buffer,
            isReRender,
            partialTick,
            packedLight,
            packedOverlay,
            colour
        );
        var maskBone = model.getBone("gArmorMask");
        var wristBladeBone = model.getBone("gWristBlade");
        var leftLegArmor = model.getBone("gLeftLegArmor");
        var leftFootArmor = model.getBone("gLeftFootArmor");
        var rightLegArmor = model.getBone("gRightLegArmor");
        var rightFootArmor = model.getBone("gRightFootArmor");
        var rightArmArmor = model.getBone("gRightArmArmor");
        var leftArmArmor = model.getBone("gLeftArmArmor");
        var leftForearmArmor = model.getBone("gLeftForearmArmor");
        var chestArmor = model.getBone("gChestArmor");
        if (animatable.hasMask() && maskBone.isPresent()) {
            maskBone.get().setHidden(false);
        } else if (!animatable.hasMask() && maskBone.isPresent()) {
            maskBone.get().setHidden(true);
        }
        if (animatable.hasBlade() && wristBladeBone.isPresent()) {
            wristBladeBone.get().setHidden(false);
        } else if (!animatable.hasBlade() && wristBladeBone.isPresent()) {
            wristBladeBone.get().setHidden(true);
        }
        if (animatable.hasleftLegArmor() && leftLegArmor.isPresent()) {
            leftLegArmor.get().setHidden(false);
        } else if (!animatable.hasleftLegArmor() && leftLegArmor.isPresent()) {
            leftLegArmor.get().setHidden(true);
        }
        if (animatable.hasLeftFootArmor() && leftFootArmor.isPresent()) {
            leftFootArmor.get().setHidden(false);
        } else if (!animatable.hasLeftFootArmor() && leftFootArmor.isPresent()) {
            leftFootArmor.get().setHidden(true);
        }
        if (animatable.hasRightLegArmor() && rightLegArmor.isPresent()) {
            rightLegArmor.get().setHidden(false);
        } else if (!animatable.hasRightLegArmor() && rightLegArmor.isPresent()) {
            rightLegArmor.get().setHidden(true);
        }
        if (animatable.hasRightFootArmor() && rightFootArmor.isPresent()) {
            rightFootArmor.get().setHidden(false);
        } else if (!animatable.hasRightFootArmor() && rightFootArmor.isPresent()) {
            rightFootArmor.get().setHidden(true);
        }
        if (animatable.hasRightArmArmor() && rightArmArmor.isPresent()) {
            rightArmArmor.get().setHidden(false);
        } else if (!animatable.hasRightArmArmor() && rightArmArmor.isPresent()) {
            rightArmArmor.get().setHidden(true);
        }
        if (animatable.hasRightArmArmor() && leftArmArmor.isPresent()) {
            leftArmArmor.get().setHidden(false);
        } else if (!animatable.hasRightArmArmor() && leftArmArmor.isPresent()) {
            leftArmArmor.get().setHidden(true);
        }
        if (animatable.hasleftForearmArmor() && leftForearmArmor.isPresent()) {
            leftForearmArmor.get().setHidden(false);
        } else if (!animatable.hasleftForearmArmor() && leftForearmArmor.isPresent()) {
            leftForearmArmor.get().setHidden(true);
        }
        if (animatable.hasChestArmor() && chestArmor.isPresent()) {
            chestArmor.get().setHidden(false);
        } else if (!animatable.hasChestArmor() && chestArmor.isPresent()) {
            chestArmor.get().setHidden(true);
        }
    }
}
