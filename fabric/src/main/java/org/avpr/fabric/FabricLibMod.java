package org.avpr.fabric;

import mod.azure.azurelib.common.internal.common.AzureLib;
import net.fabricmc.api.ModInitializer;
import org.avpr.common.CommonMod;

public final class FabricLibMod implements ModInitializer {

    @Override
    public void onInitialize() {
        AzureLib.initialize();
        CommonMod.initRegistries();
    }
}
