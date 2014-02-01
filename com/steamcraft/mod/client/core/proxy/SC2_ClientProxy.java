/**
 * This class was created by <MrArcane111> or his SC2 development team. 
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MIT License.
 * (http://opensource.org/licenses/MIT)
 * 
 * Steamcraft 2 is based on the original Steamcraft created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 * 
 * File created @ [Jan 30, 2014, 5:19:11 PM]
 */
package com.steamcraft.mod.client.core.proxy;

import java.awt.Color;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.mod.client.core.handler.SC2_HUDHandler;
import com.steamcraft.mod.client.core.handler.SC2_SoundEventHandler;
import com.steamcraft.mod.client.fx.FXRayGun;
import com.steamcraft.mod.client.model.ModelBrassMonocle;
import com.steamcraft.mod.client.model.ModelBrassWings;
import com.steamcraft.mod.client.model.ModelCape;
import com.steamcraft.mod.client.render.RenderBullet;
import com.steamcraft.mod.common.SC2;
import com.steamcraft.mod.common.block.tile.TileEntityLampRenderer;
import com.steamcraft.mod.common.block.tile.TileEntityLightningRodRenderer;
import com.steamcraft.mod.common.core.proxy.SC2_CommonProxy;
import com.steamcraft.mod.common.entity.EntityBullet;
import com.steamcraft.mod.common.lib.SC2_EntityIDs;
import com.steamcraft.mod.common.lib.SC2_Info;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * @author MrArcane111
 * 
 */
public class SC2_ClientProxy extends SC2_CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		// MinecraftForge.EVENT_BUS.register(new SC_GuiOpenEventHandler());
		TickRegistry.registerTickHandler(new SC2_HUDHandler(), Side.CLIENT);
		MinecraftForge.EVENT_BUS.register(new SC2_SoundEventHandler());
		//MinecraftForgeClient.registerItemRenderer(ModTools.drillSteam.itemID, new SC2_ItemRenderer());
	}

    @Override
	public void initEntities()
	{
        super.initEntities();
		// Bullet
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet());
	}

    @Override
	public void initTileEntities()
	{
        super.initTileEntities();
		// Lamp
		ClientRegistry.bindTileEntitySpecialRenderer(com.steamcraft.mod.common.block.tile.TileEntityLamp.class, new TileEntityLampRenderer());
		// Lightning Rod
		ClientRegistry.bindTileEntitySpecialRenderer(com.steamcraft.mod.common.block.tile.TileEntityLightningRod.class, new TileEntityLightningRodRenderer());
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

		return chest1; // Default, if the wrong ID is passed
	}

	private static final ModelCape chest2 = new ModelCape(1.0F);
	private static final ModelCape legs2 = new ModelCape(0.5F);

	@Override
	public ModelBiped getCapeArmorModel(int id)
	{
		switch(id)
		{
		case 0:
			return chest2;
		case 1:
			return legs2;
		default:
			break;
		}

		return chest2; // Default, if the wrong ID is passed
	}

	@Override
	public Object rayBeam(World world, EntityPlayer player, double tx, double ty, double tz, int type, /*int color,*/ boolean reverse, float endmod, Object input, int impact)
	{
		FXRayGun ray = null;
		//Color c = new Color(color);
		Color color = Color.RED; // Change le color here

		if((input instanceof FXRayGun))
			ray = (FXRayGun)input;
		if((ray == null) || (ray.isDead)) 
		{
			ray = new FXRayGun(world, player, tx, ty, tz, color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, 9);
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

		return /*Lana del*/ray;
	}
}