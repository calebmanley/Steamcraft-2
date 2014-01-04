package com.steamcraft.mod.proxy;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class SC_ClientProxy extends SC_CommonProxy
{
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		//LocalizationHandler.loadLocalizations();
		//MinecraftForge.EVENT_BUS.register(new HUDHandler());
		//TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		this.registerTileEntities();
	}

	private void registerTileEntities() 
	{
		//ClientRegistry.bindTileEntitySpecialRenderer(TileAnimationTablet.class, new RenderTileAnimationTablet());
	}

	@Override
	public boolean isClient() 
	{
		return true;
	}
}