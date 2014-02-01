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
package com.steamcraft.mod.common.core.proxy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import com.steamcraft.mod.client.core.handler.SC2_GuiHandler;
import com.steamcraft.mod.client.core.handler.SC2_KeyHandler;
import com.steamcraft.mod.common.SC2;
import com.steamcraft.mod.common.block.ModBlocks;
import com.steamcraft.mod.common.core.handler.SC2_ChestGenHandler;
import com.steamcraft.mod.common.core.handler.SC2_ConfigHandler;
import com.steamcraft.mod.common.core.handler.SC2_EventHandler;
import com.steamcraft.mod.common.core.handler.SC2_GenerationHandler;
import com.steamcraft.mod.common.core.handler.SC2_ServerTickHandler;
import com.steamcraft.mod.common.item.ModItems;
import com.steamcraft.mod.common.network.SC2_PlayerTracker;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * @author MrArcane111
 *
 */
public class SC2_CommonProxy 
{
    public static SC2_ConfigHandler cfgHandler;

    public void preInit(FMLPreInitializationEvent event)
	{
        cfgHandler = new SC2_ConfigHandler(event.getSuggestedConfigurationFile());
        cfgHandler.loadConfig();
		ModBlocks.initBlocks();
		ModItems.initItems();
	}

	public void init(FMLInitializationEvent event) 
	{
		MinecraftForge.EVENT_BUS.register(new SC2_EventHandler());
		GameRegistry.registerWorldGenerator(new SC2_GenerationHandler());
		NetworkRegistry.instance().registerGuiHandler(SC2.instance, new SC2_GuiHandler());
		GameRegistry.registerPlayerTracker(new SC2_PlayerTracker());
		TickRegistry.registerTickHandler(new SC2_ServerTickHandler(), Side.SERVER);
		SC2_ChestGenHandler.addItemsToChests();
		//this.registerKeyBinds();
	}

	public void postInit(FMLPostInitializationEvent event) 
	{
        cfgHandler.saveConfig();
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

	public ModelBiped getMonocleArmorModel(int id)
	{
		return null;
	}
	
	public ModelBiped getWingsArmorModel(int id)
	{
		return null;
	}
	
	public ModelBiped getCapeArmorModel(int id)
	{
		return null;
	}
	
	public Object rayBeam(World world, EntityPlayer player, double tx, double ty, double tz, int type, /*int color,*/ boolean reverse, float endmod, Object input, int impact)
	{
		return null;
	}
}