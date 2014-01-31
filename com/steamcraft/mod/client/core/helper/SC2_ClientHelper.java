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
package com.steamcraft.mod.client.core.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;

/**
 * @author MrArcane111
 *
 */
public class SC2_ClientHelper 
{
	public static Minecraft mc() 
	{
		return Minecraft.getMinecraft();
	}

	public static FontRenderer fontRenderer() 
	{
		return mc().fontRenderer;
	}

	public static EntityClientPlayerMP clientPlayer() 
	{
		return mc().thePlayer;
	}
}