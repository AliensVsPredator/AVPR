package org.avpr.common.client.entities.models.yautja;

import mod.azure.azurelib.common.internal.common.constant.DataTickets;
import mod.azure.azurelib.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import org.avpr.common.client.entities.models.DefaultEntityModel;
import org.avpr.common.entities.yautja.YautjaEntity;

public class YautjaModel extends DefaultEntityModel<YautjaEntity> {

    public YautjaModel(ResourceLocation assetSubpath) {
        super(assetSubpath);
    }

    @Override
    public void setCustomAnimations(YautjaEntity animatable, long instanceId, AnimationState<YautjaEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
        var head = getAnimationProcessor().getBone("gNeckUpper");
        var leftArm = getAnimationProcessor().getBone("gLeftArm");
        var rightArm = getAnimationProcessor().getBone("gRightArm");
        var leftLeg = getAnimationProcessor().getBone("gLeftLeg");
        var rightLeg = getAnimationProcessor().getBone("gRightLeg");
        var entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        if (head != null) {
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
        if (leftArm != null)
            leftArm.setRotX(
                Mth.cos(
                    animatable.walkAnimation.position(
                        animationState.getPartialTick()
                    ) * 0.6662F
                ) * 2.0F * animatable.walkAnimation.speed() * 0.5F
            );
        if (rightArm != null)
            rightArm.setRotX(
                Mth.cos(
                    animatable.walkAnimation.position(
                        animationState.getPartialTick()
                    ) * 0.6662F + 3.1415927F
                ) * 2.0F * animatable.walkAnimation.speed() * 0.5F
            );
        if (leftLeg != null)
            leftLeg.setRotX(
                Mth.cos(
                    animatable.walkAnimation.position(
                        animationState.getPartialTick()
                    ) * 0.6662F + 3.1415927F
                ) * 1.4F * animatable.walkAnimation.speed() * 0.5F
            );
        if (rightLeg != null)
            rightLeg.setRotX(
                Mth.cos(
                    animatable.walkAnimation.position(
                        animationState.getPartialTick()
                    ) * 0.6662F
                ) * 1.4F * animatable.walkAnimation.speed() * 0.5F
            );
    }
}
