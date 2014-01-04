package com.steamcraft.mod.main;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLogic;

import com.steamcraft.mod.lib.SC_Info;
import com.steamcraft.mod.proxy.SC_CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = SC_Info.MOD_ID, name = SC_Info.MOD_NAME, version = SC_Info.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class SC_Main
{
	@Instance(value = SC_Info.MOD_ID)
	public static SC_Main instance;
	
	@SidedProxy(clientSide = SC_Info.CLIENT_PROXY, serverSide = SC_Info.COMMON_PROXY)
    public static SC_CommonProxy proxy;
	
	public static final String SC_PREFIX = "steamcraft:";
	
	public static Material solidCircuit = (new MaterialLogic(MapColor.airColor));;
	public static Material staticCircuit = (new MaterialLogic(MapColor.airColor)).setReplaceable();

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