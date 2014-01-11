package com.steamcraft.mod.proxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.entity.EntityBullet;
import com.steamcraft.mod.handler.SC2_ChestGenHandler;
import com.steamcraft.mod.handler.SC2_ConfigHandler;
import com.steamcraft.mod.handler.SC2_EventHandler;
import com.steamcraft.mod.handler.SC2_GuiHandler;
import com.steamcraft.mod.handler.SC2_KeyHandler;
import com.steamcraft.mod.handler.SC2_ServerTickHandler;
import com.steamcraft.mod.item.ModItems;
import com.steamcraft.mod.lib.SC2_EntityIDs;
import com.steamcraft.mod.main.SC2_Generator;
import com.steamcraft.mod.main.SC2_PlayerTracker;
import com.steamcraft.mod.main.SC2;
import com.steamcraft.mod.render.RenderBullet;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class SC2_CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event) 
	{
		SC2_ConfigHandler.loadConfig(event.getSuggestedConfigurationFile());
		ModBlocks.initBlocks();
		ModItems.initItems();
	}

	public void init(FMLInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new SC2_EventHandler());
		GameRegistry.registerWorldGenerator(new SC2_Generator());
		NetworkRegistry.instance().registerGuiHandler(SC2.instance, new SC2_GuiHandler());
		GameRegistry.registerPlayerTracker(new SC2_PlayerTracker());
		TickRegistry.registerTickHandler(new SC2_ServerTickHandler(), Side.SERVER);
		SC2_ChestGenHandler.addItemsToChests();
		//this.registerKeyBinds();
	}

	public void postInit(FMLPostInitializationEvent event) 
	{
		//ModRecipes.initRecipes();
	}
	
	public void registerKeyBinds()
	{
		KeyBinding[] key = { new KeyBinding("FKey", Keyboard.KEY_F) };
        boolean[] repeat = { false };
        KeyBindingRegistry.registerKeyBinding(new SC2_KeyHandler(key, repeat));
	}

	public boolean isClient() 
	{
		return false;
	}
}