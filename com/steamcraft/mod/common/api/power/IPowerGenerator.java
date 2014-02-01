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
 * File created @ [Feb 1, 2014, 11:55:01 AM]
 */
package com.steamcraft.mod.common.api.power;

import net.minecraftforge.common.ForgeDirection;


/**
 * This Tile Entity interface allows you to indicate that a block can emit power
 * from a specific side.
 * 
 * @author MrArcane111
 *
 */
public interface IPowerGenerator 
{
	// The maximum power amount
	public int powerEmitionLimit();
	
	// Determines whether to generate power
	public boolean generatePower(ForgeDirection side);
}
