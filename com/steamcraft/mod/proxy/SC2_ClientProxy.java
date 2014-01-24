package com.steamcraft.mod.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.mod.entity.EntityBullet;
import com.steamcraft.mod.handler.SC2_HUDHandler;
import com.steamcraft.mod.handler.SC2_SoundEventHandler;
import com.steamcraft.mod.lib.SC2_EntityIDs;
import com.steamcraft.mod.lib.SC2_Info;
import com.steamcraft.mod.main.SC2;
import com.steamcraft.mod.render.RenderBullet;
import com.steamcraft.mod.tileentity.TileEntityLampRenderer;
import com.steamcraft.mod.tileentity.TileEntityLightningRodRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class SC2_ClientProxy extends SC2_CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		this.initBulletEntity();
	}
	
	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		// MinecraftForge.EVENT_BUS.register(new SC_GuiOpenEventHandler());
		TickRegistry.registerTickHandler(new SC2_HUDHandler(), Side.CLIENT);
		MinecraftForge.EVENT_BUS.register(new SC2_SoundEventHandler());
		//MinecraftForgeClient.registerItemRenderer(ModTools.drillSteam.itemID, new SC2_ItemRenderer());
		
		this.initTileEntities();
	}

	public void initBulletEntity()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		EntityRegistry.registerGlobalEntityID(EntityBullet.class, "Bullet", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", SC2_EntityIDs.BULLET_ID, SC2.instance, 100, 10, false);
	}
	
	public void initTileEntities()
	{
		// Lamp
		ClientRegistry.bindTileEntitySpecialRenderer(com.steamcraft.mod.tileentity.TileEntityLamp.class, new TileEntityLampRenderer());
		GameRegistry.registerTileEntity(com.steamcraft.mod.tileentity.TileEntityLamp.class, SC2_Info.MOD_ID + "TELamp");
		// Lightning Rod
		ClientRegistry.bindTileEntitySpecialRenderer(com.steamcraft.mod.tileentity.TileEntityLightningRod.class, new TileEntityLightningRodRenderer());
		GameRegistry.registerTileEntity(com.steamcraft.mod.tileentity.TileEntityLightningRod.class, SC2_Info.MOD_ID + "TELightningRod");
		// Wings!
	}

	@Override
	public boolean isClient() 
	{
		return true;
	}
}