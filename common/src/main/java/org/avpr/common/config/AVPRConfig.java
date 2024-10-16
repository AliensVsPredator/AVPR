package org.avpr.common.config;

import mod.azure.azurelib.common.api.common.config.Config;
import mod.azure.azurelib.common.internal.common.config.Configurable;
import org.avpr.common.CommonMod;

@Config(id = CommonMod.MOD_ID)
public class AVPRConfig {

    @Configurable
    @Configurable.Synchronized
    public acidConfigs acidConfigs = new acidConfigs();

    public static class acidConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ACID_BREAKSPEED_MODIFIER = 40.0f;

        @Configurable
        @Configurable.Synchronized
        @Configurable.DecimalRange(min = 0)
        public float ACID_DAMAGE = 2F;
    }

    @Configurable
    @Configurable.Synchronized
    public FacehuggerConfigs facehuggerConfigs = new FacehuggerConfigs();

    public static class FacehuggerConfigs {

    }
}
