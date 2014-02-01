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
 * File created @ [Feb 1, 2014, 11:54:15 AM]
 */
package com.steamcraft.mod.common.api.power;

import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

/** 
 * @author MrArcane111
 * 
 */
public interface IPowerReceptor 
{
	// Determines if the tile entity is receiving power from a specified side
	public void receievePower(ForgeDirection side);

	// Now get to work, bitch
	public void doWork();

	// Grabs a world instance
	public World getWorld();
}
