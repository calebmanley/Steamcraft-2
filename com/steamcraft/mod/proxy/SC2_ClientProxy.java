package com.steamcraft.mod.proxy;

import java.awt.Color;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.mod.entity.EntityBullet;
import com.steamcraft.mod.handler.SC2_HUDHandler;
import com.steamcraft.mod.handler.SC2_SoundEventHandler;
import com.steamcraft.mod.lib.SC2_EntityIDs;
import com.steamcraft.mod.lib.SC2_Info;
import com.steamcraft.mod.main.FXRayGun;
import com.steamcraft.mod.main.SC2;
import com.steamcraft.mod.model.ModelBrassMonocle;
import com.steamcraft.mod.model.ModelBrassWings;
import com.steamcraft.mod.render.RenderBullet;
import com.steamcraft.mod.tileentity.TileEntityLampRenderer;
import com.steamcraft.mod.tileentity.TileEntityLightningRodRenderer;

import cpw.mods.fml.client.FMLClientHandler;
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
		this.initWeaponEntities();
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

	public void initWeaponEntities()
	{
		// Bullet
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
		EntityRegistry.registerGlobalEntityID(EntityBullet.class, "Bullet", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", SC2_EntityIDs.BULLET_ID, SC2.instance, 100, 10, false);
		// Laser
		/*
		RenderingRegistry.registerEntityRenderingHandler(EntityLaser.class, new RenderLaser());
		EntityRegistry.registerGlobalEntityID(EntityLaser.class, "Laser", EntityRegistry.findGlobalUniqueEntityId());
		EntityRegistry.registerModEntity(EntityLaser.class, "Laser", SC2_EntityIDs.LASER_ID, SC2.instance, 100, 10, false);
		 */
	}

	public void initTileEntities()
	{
		// Lamp
		ClientRegistry.bindTileEntitySpecialRenderer(com.steamcraft.mod.tileentity.TileEntityLamp.class, new TileEntityLampRenderer());
		GameRegistry.registerTileEntity(com.steamcraft.mod.tileentity.TileEntityLamp.class, SC2_Info.MOD_ID + "TELamp");
		// Lightning Rod
		ClientRegistry.bindTileEntitySpecialRenderer(com.steamcraft.mod.tileentity.TileEntityLightningRod.class, new TileEntityLightningRodRenderer());
		GameRegistry.registerTileEntity(com.steamcraft.mod.tileentity.TileEntityLightningRod.class, SC2_Info.MOD_ID + "TELightningRod");
	}

	@Override
	public boolean isClient() 
	{
		return true;
	}

	// ====== WARNING: SEVERE PAIN IN THE ASS MATERIAL! ====== //

	private static final ModelBrassMonocle chest = new ModelBrassMonocle(1.0F);
	private static final ModelBrassMonocle legs = new ModelBrassMonocle(0.5F);

	@Override
	public ModelBiped getMonocleArmorModel(int id)
	{
		switch (id) 
		{
		case 0:
			return chest;
		case 1:
			return legs;
		default:
			break;
		}

		return chest; // Default, if the wrong ID is passed
	}

	private static final ModelBrassWings chest1 = new ModelBrassWings(1.0F);
	private static final ModelBrassWings legs1 = new ModelBrassWings(0.5F);

	@Override
	public ModelBiped getWingsArmorModel(int id)
	{
		switch (id) 
		{
		case 0:
			return chest1;
		case 1:
			return legs1;
		default:
			break;
		}

		return chest; // Default, if the wrong ID is passed
	}

	@Override
	public Object rayBeam(World world, EntityPlayer player, double tx, double ty, double tz, int type, int color, boolean reverse, float endmod, Object input, int impact)
	{
		FXRayGun ray = null;
		Color c = new Color(color);

		if((input instanceof FXRayGun))
		{
			ray = (FXRayGun)input;
		}
		if((ray == null) || (ray.isDead)) 
		{
			ray = new FXRayGun(world, player, tx, ty, tz, c.getRed() / 255.0F, c.getGreen() / 255.0F, c.getBlue() / 255.0F, 8);
			ray.setType(type);
			ray.setEndMod(endmod);
			ray.setReverse(reverse);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(ray);
		} else 
		{
			ray.updateRay(tx, ty, tz);
			ray.setEndMod(endmod);
			ray.impact = impact;
		}

		return ray;
	}
}