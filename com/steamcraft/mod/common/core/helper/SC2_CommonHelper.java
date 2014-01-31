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
	/*
	 * 0 - Black
     * 1 - Dark Blue
     * 2 - Dark Green
     * 3 - Dark Aqua
     * 4 - Dark Red
     * 5 - Purple
     * 6 - Orange (Gold)
     * 7 - Gray
     * 8 - Dark Gray
     * 9 - Indigo
     * a - Bright Green
     * b - Aqua
     * c - Red
     * d - Pink
     * e - Yellow
     * f - White
     * 
	 */
	public static String baseStem = "\u00a7";

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

	// The colors of the rainbow:
	
	public String getBlack(String s)
	{
		return this.baseStem + "0";
	}
	
	public String getDarkBlue(String s)
	{
		return this.baseStem + "1";
	}
	
	public String getDarkGreen(String s)
	{
		return this.baseStem + "2";
	}
	
	public String getDarkAqua(String s)
	{
		return this.baseStem + "3";
	}
	
	public String getDarkRed(String s)
	{
		return this.baseStem + "4";
	}
	
	public String getPurple(String s)
	{
		return this.baseStem + "5";
	}
	
	public String getGold(String s)
	{
		return this.baseStem + "6";
	}
	
	public String getGray(String s)
	{
		return this.baseStem + "7";
	}
	
	public String getDarkGray(String s)
	{
		return this.baseStem + "8";
	}
	
	public String getIndigo(String s)
	{
		return this.baseStem + "9";
	}
	
	public String getBrightGreen(String s)
	{
		return this.baseStem + "a";
	}
	
	public String getAqua(String s)
	{
		return this.baseStem + "b";
	}
	
	public String getRed(String s)
	{
		return this.baseStem + "c";
	}
	
	public String getPink(String s)
	{
		return this.baseStem + "d";
	}
	
	public String getYellow(String s)
	{
		return this.baseStem + "e";
	}
	
	public String getWhite(String s)
	{
		return this.baseStem + "f";
	}
}