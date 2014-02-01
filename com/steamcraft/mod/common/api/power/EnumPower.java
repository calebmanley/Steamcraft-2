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
 * File created @ [Feb 1, 2014, 12:45:38 PM]
 */
package com.steamcraft.mod.common.api.power;

import java.util.logging.Level;

import com.steamcraft.mod.common.network.SC2_Logger;

/**
 * @author MrArcane111
 *
 */
public enum EnumPower
{
	NONE(0),
	REDSTONE(25),
	COPPER(50),
	WIRELESS(75),
	DEBUG(100);

	private int power;

	EnumPower(int power)
	{
		if(power < 0 || power > 100)
		{
			SC2_Logger.log(Level.SEVERE, "POWER ERROR!");
			SC2_Logger.log(Level.SEVERE, "Power for " + this + " is an invalid amount!");
			
			if(power < 0)
			{
				SC2_Logger.log(Level.SEVERE, "POWER LEVEL TOO LOW: Must be more than or equal to 0!");
			}
			if(power > 100)
			{
				SC2_Logger.log(Level.SEVERE, "POWER LEVEL TOO HIGH: Must be less than or equal to 100!");
			}
		}
		
		this.power = power;
	}

	public int getPower()
	{
		return power;
	}

	public EnumPower getCase(int type)
	{
		switch(type)
		{
		case 1: 
			return NONE;
		case 2:
			return REDSTONE;
		case 3:
			return COPPER;
		case 4:
			return WIRELESS;
		case 5:
			return DEBUG;
		}
		
		if(type < 0 || type > 5)
		{
			SC2_Logger.log(Level.SEVERE, "Invalid Power Level for type: " + type + ", can only range from redstone, copper, or wireless!");
		}
		
		return NONE;
	}
}
