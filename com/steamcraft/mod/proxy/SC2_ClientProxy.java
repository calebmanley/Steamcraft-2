package com.steamcraft.mod.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.mod.handler.SC2_HUDHandler;
import com.steamcraft.mod.handler.SC2_SoundEventHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class SC2_ClientProxy extends SC2_CommonProxy
{
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		// MinecraftForge.EVENT_BUS.register(new SC_GuiOpenEventHandler());
		TickRegistry.registerTickHandler(new SC2_HUDHandler(), Side.CLIENT);
		MinecraftForge.EVENT_BUS.register(new SC2_SoundEventHandler());
	}

	@Override
	public boolean isClient() 
	{
		return true;
	}
}