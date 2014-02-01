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
 * File created @ [Feb 1, 2014, 12:16:04 PM]
 */
package com.steamcraft.mod.common.api.power;

import net.minecraft.world.World;

/**
 * @author CovertJaguar & SirSengir from Buildcraft, adapted by MrArcane111
 * (https://github.com/BuildCraft/BuildCraft/SafeTimeTracker)
 *
 */
public class SafeTimeTracker
{
	private long lastMark = Long.MIN_VALUE;
	private long duration = -1;

	/**
	 * Return true if a given delay has passed since last time marked was called
	 * successfully.
	 */
	public boolean markTimeIfDelay(World world, long delay) 
	{
		if(world == null)
			return false;

		long currentTime = world.getTotalWorldTime();

		if(currentTime < lastMark) 
		{
			lastMark = currentTime;
			return false;
		} else if(lastMark + delay <= currentTime) 
		{
			duration = currentTime - lastMark;
			lastMark = currentTime;
			return true;
		} else
			return false;
	}

	public long durationOfLastDelay() 
	{
		return duration > 0 ? duration : 0;
	}

	public void markTime(World world) 
	{
		lastMark = world.getTotalWorldTime();
	}
}
