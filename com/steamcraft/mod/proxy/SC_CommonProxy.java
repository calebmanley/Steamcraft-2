package com.steamcraft.mod.proxy;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.entity.EntityBullet;
import com.steamcraft.mod.handler.SC_ChestGenHandler;
import com.steamcraft.mod.handler.SC_ConfigHandler;
import com.steamcraft.mod.handler.SC_EventHandler;
import com.steamcraft.mod.handler.SC_GuiHandler;
import com.steamcraft.mod.handler.SC_KeyHandler;
import com.steamcraft.mod.handler.SC_ServerTickHandler;
import com.steamcraft.mod.item.ModItems;
import com.steamcraft.mod.lib.SC_EntityIDs;
import com.steamcraft.mod.main.SC_Generator;
import com.steamcraft.mod.main.SC_PlayerTracker;
import com.steamcraft.mod.main.Steamcraft;
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
		MinecraftForge.EVENT_BUS.register(new SC_EventHandler());
		GameRegistry.registerWorldGenerator(new SC_Generator());
		NetworkRegistry.instance().registerGuiHandler(Steamcraft.instance, new SC_GuiHandler());
		GameRegistry.registerPlayerTracker(new SC_PlayerTracker());
		TickRegistry.registerTickHandler(new SC_ServerTickHandler(), Side.SERVER);
		SC_ChestGenHandler.addItemsToChests();
		this.initBulletEntity();	
		//this.registerKeyBinds();
	}

	public void postInit(FMLPostInitializationEvent event) 
	{
		//ModRecipes.initRecipes();
	}
	
	public void initBulletEntity()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		EntityRegistry.registerGlobalEntityID(EntityBullet.class, "Bullet", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", SC_EntityIDs.BULLET_ID, Steamcraft.instance, 100, 10, false);
	}
	
	public void registerKeyBinds()
	{
		KeyBinding[] key = { new KeyBinding("FKey", Keyboard.KEY_F) };
        boolean[] repeat = { false };
        KeyBindingRegistry.registerKeyBinding(new SC_KeyHandler(key, repeat));
	}

	public boolean isClient() 
	{
		return false;
	}
}