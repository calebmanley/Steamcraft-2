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
 * File created @ [Jan 30, 2014, 5:51:27 PM]
 */
package com.steamcraft.mod.common.core.helper;

import net.minecraft.server.MinecraftServer;

/**
 * @author MrArcane111
 *
 */
public class SC2_CommonHelper 
{
	public static MinecraftServer server()
	{
		return MinecraftServer.getServer();
	}

	public static void printCurrentStackTrace(String message)
	{
		if(message != null)
			System.out.println(message);
		for(StackTraceElement element : Thread.currentThread().getStackTrace())
			System.out.println(element);
	}
}