package com.steamcraft.mod.proxy;

import com.steamcraft.mod.tileentity.TileEntityChemicalFurnace;
import com.steamcraft.mod.tileentity.TileEntityNukeFurnace;
import com.steamcraft.mod.tileentity.TileEntitySteamFurnace;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class SC_ClientProxy extends SC_CommonProxy
{
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		// MinecraftForge.EVENT_BUS.register(new HUDHandler());
		// TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}

	@Override
	public boolean isClient() 
	{
		return true;
	}
}