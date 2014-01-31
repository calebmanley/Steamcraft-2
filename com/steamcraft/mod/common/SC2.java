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
package com.steamcraft.mod.common;

import com.steamcraft.mod.common.core.proxy.SC2_CommonProxy;
import com.steamcraft.mod.common.lib.SC2_Info;
import com.steamcraft.mod.common.network.SC2_PacketHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = SC2_Info.MOD_ID, name = SC2_Info.MOD_NAME, version = SC2_Info.VERSION)
@NetworkMod(clientSideRequired = true)//, serverSideRequired = false, channels = {SC2_Info.NETWORK_CHANNEL}, packetHandler = SC2_PacketHandler.class)
/**
 * 
 * @author MrArcane111
 *
 */
public class SC2
{
	@Instance(SC2_Info.MOD_ID)
	public static SC2 instance;
	
	@SidedProxy(clientSide = SC2_Info.CLIENT_PROXY, serverSide = SC2_Info.COMMON_PROXY)
    public static SC2_CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
}