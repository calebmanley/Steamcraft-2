package com.steamcraft.mod.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.mod.handler.SC_HUDHandler;
import com.steamcraft.mod.handler.SC_HUDHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class SC_ClientProxy extends SC_CommonProxy
{
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		// MinecraftForge.EVENT_BUS.register(new SC_GuiOpenEventHandler());
		TickRegistry.registerTickHandler(new SC_HUDHandler(), Side.CLIENT);
	}

	@Override
	public boolean isClient() 
	{
		return true;
	}
}