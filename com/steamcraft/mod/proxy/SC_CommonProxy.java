package com.steamcraft.mod.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.handler.SC_ConfigHandler;
import com.steamcraft.mod.handler.SC_EventHandler;
import com.steamcraft.mod.handler.SC_GuiHandler;
import com.steamcraft.mod.item.ModItems;
import com.steamcraft.mod.main.SC_Generator;
import com.steamcraft.mod.main.SC_Main;
import com.steamcraft.mod.main.SC_PlayerTracker;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class SC_CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event) 
	{
		SC_ConfigHandler.loadConfig(event.getSuggestedConfigurationFile());
		ModBlocks.initBlocks();
		ModItems.initItems();
	}

	public void init(FMLInitializationEvent event) 
	{
		ModBlocks.initTileEntities();
		MinecraftForge.EVENT_BUS.register(new SC_EventHandler());
		GameRegistry.registerWorldGenerator(new SC_Generator());
		NetworkRegistry.instance().registerGuiHandler(SC_Main.instance, new SC_GuiHandler());
		GameRegistry.registerPlayerTracker(new SC_PlayerTracker());
	}

	public void postInit(FMLPostInitializationEvent event) 
	{
		//ModRecipes.initRecipes();
	}

	public boolean isClient() 
	{
		return false;
	}
}