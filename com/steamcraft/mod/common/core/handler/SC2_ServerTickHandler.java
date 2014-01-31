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
 * File created @ [Jan 30, 2014, 5:33:43 PM]
 */
package com.steamcraft.mod.common.core.handler;

import java.util.EnumSet;

import com.steamcraft.mod.common.item.ModArmors;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

/**
 * 
 * @author MrArcane111
 *
 */
public class SC2_ServerTickHandler implements ITickHandler
{
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		if(type.equals(EnumSet.of(TickType.PLAYER)))
		{
			this.playerTick((EntityPlayer)tickData[0]);
		}	
	}

	private void playerTick(EntityPlayer player)
	{
		ItemStack legsSlot = player.inventory.armorItemInSlot(1); // le pants

		if(legsSlot != null)
		{
			if(legsSlot.itemID == ModArmors.legBraces.itemID)
			{
				float distToFall = player.fallDistance;
				
				if(distToFall > 3.0F)
				{
					player.fallDistance = distToFall * 0.888F;
					legsSlot.damageItem(1, player);
				}
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel()
	{
		return "SC2_ServerTickHandler";
	}
}