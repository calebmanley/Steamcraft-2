package com.steamcraft.mod.common.lib;

public final class SC2_Info 
{
    public static final String MOD_ID = "Steamcraft";
    public static final String MOD_NAME = "Steamcraft 2";
    public static final String VERSION = "infiniti"; // TODO: Change me!

    public static final String NETWORK_CHANNEL = MOD_ID;

    public static final String COMMON_PROXY = "com.steamcraft.mod.common.core.proxy.SC2_CommonProxy";
    public static final String CLIENT_PROXY = "com.steamcraft.mod.client.core.proxy.SC2_ClientProxy";
    
    // I should really use this instead of "SC2_Info.MOD_ID.toLowerCase()" but I'm too lazy
    // to change all of the necessary files...is laziness contagious?
    public static final String SC2_PREFIX = "steamcraft:";
}