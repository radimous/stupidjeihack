package com.radimous.stupidjeihack;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(StupidJEIHack.MOD_ID)
public class StupidJEIHack {

    public static final String MOD_ID = "stupidjeihack";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static boolean disableJEIRefresh = false;
    public static boolean disableVHAPITemplateSync = false;
    public static boolean disableCraftTweaker = false;

    public StupidJEIHack() {
    }
}
