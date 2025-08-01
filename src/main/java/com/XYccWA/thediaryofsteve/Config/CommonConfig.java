package com.XYccWA.thediaryofsteve.Config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
    private static ForgeConfigSpec.Builder BUIDER = new ForgeConfigSpec.Builder();
    private static ForgeConfigSpec.IntValue TECHPOINTINCREACE =BUIDER.defineInRange("techpointincreace", 1, 0, Integer.MAX_VALUE);
    private static ForgeConfigSpec.IntValue TECHPOINTDECREACE =BUIDER.defineInRange("techpointdecreace", 1, 0, Integer.MAX_VALUE);
}
