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
 * @author CovertJaguar, SirSengir, Krapht, cpw & bdew from Buildcraft, adapted by MrArcane111
 * (https://github.com/BuildCraft/BuildCraft/PowerHandler)
 * 
 */
public interface IPowerReceptor 
{
	/**
	 * Get the PowerReceiver for this side of the block. You can return the same
	 * PowerReceiver for all sides or one for each side.
	 *
	 * You should NOT return null to this method unless you mean to NEVER
	 * receive power from that side. Returning null, after previous returning a
	 * PowerReceiver, will most likely cause pipe connections to derp out and
	 * engines to eventually explode.
	 *
	 * @param side
	 * @return
	 */
	public PowerHandler.PowerReceiver getPowerReceiver(ForgeDirection side);

	/**
	 * Call back from the PowerHandler that is called when the stored power
	 * exceeds the activation power.
	 *
	 * It can be triggered by update() calls or power modification calls.
	 *
	 * @param workProvider
	 */
	public void doWork(PowerHandler workProvider);

	public World getWorld();
}
