package com.steamcraft.mod.main;

import com.steamcraft.mod.handler.SC2_PacketHandler;
import com.steamcraft.mod.lib.SC2_Info;
import com.steamcraft.mod.proxy.SC2_CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = SC2_Info.MOD_ID, name = SC2_Info.MOD_NAME, version = SC2_Info.VERSION)
@NetworkMod(clientSideRequired = true)//, serverSideRequired = false, channels = {SC2_Info.NETWORK_CHANNEL}, packetHandler = SC2_PacketHandler.class)
public class SC2
{
	@Instance(SC2_Info.MOD_ID)
	public static SC2 instance;
	
	@SidedProxy(clientSide = SC2_Info.CLIENT_PROXY, serverSide = SC2_Info.COMMON_PROXY)
    public static SC2_CommonProxy proxy;
	
	public static final String SC2_PREFIX = "steamcraft:";

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
}

// TODO: Fix placement orientation for furnaces/brass log, add IDs to config handler, add mouse-over info to items,
// change ore generation, change tool material aspects, add extra drill functionality, fix nuke furnace texture bug,
// 