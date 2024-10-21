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

    private final Set<Float> triggeredThresholds = new HashSet<>();

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
        var currentHealthPercentage = (animatable.getHealth() / animatable.getMaxHealth()) * 100;
        var maskBone = model.getBone("gArmorMask");
        var wristBladeBone = model.getBone("gWristBlade");
        if (!animatable.hasMask() && maskBone.isPresent())
            maskBone.get().setHidden(true);
//        if (!animatable.isAggressive() && wristBladeBone.isPresent())
//            wristBladeBone.get().setHidden(true);
//        if (animatable.isAggressive() && wristBladeBone.isPresent())
//            wristBladeBone.get().setHidden(false);
        this.update(currentHealthPercentage, model);
    }

    public void update(float currentHealthPercentage, BakedGeoModel model) {
        if (currentHealthPercentage <= 70 && currentHealthPercentage > 61)
            triggerBoneHiding(70, model);
        else if (currentHealthPercentage <= 61 && currentHealthPercentage > 53)
            triggerBoneHiding(61, model);
        else if (currentHealthPercentage <= 53 && currentHealthPercentage > 44)
            triggerBoneHiding(53, model);
        else if (currentHealthPercentage <= 44 && currentHealthPercentage > 35)
            triggerBoneHiding(44, model);
        else if (currentHealthPercentage <= 35 && currentHealthPercentage > 26)
            triggerBoneHiding(35, model);
        else if (currentHealthPercentage <= 26 && currentHealthPercentage > 18)
            triggerBoneHiding(26, model);
        else if (currentHealthPercentage <= 18 && currentHealthPercentage > 9)
            triggerBoneHiding(18, model);
    }

    private void triggerBoneHiding(float threshold, BakedGeoModel model) {
        if (!triggeredThresholds.contains(threshold)) {
            hideBones(model);
            triggeredThresholds.add(threshold);
        }
    }

    private void hideBones(BakedGeoModel model) {
        List<String> boneNames = new ArrayList<>();
        boneNames.add("gLeftLegArmor");
        boneNames.add("gLeftFootArmor");
        boneNames.add("gRightLegArmor");
        boneNames.add("gRightFootArmor");
        boneNames.add("gRightArmArmor");
        boneNames.add("gLeftArmArmor");
        boneNames.add("gLeftForearmArmor");
        boneNames.add("gChestArmor");
        Collections.shuffle(boneNames);
        for (var boneName : boneNames) {
            var bone = model.getBone(boneName);
            if (bone.isPresent() && !bone.get().isHidden()) {
                bone.get().setHidden(true);
                break;
            }
        }
    }
}
