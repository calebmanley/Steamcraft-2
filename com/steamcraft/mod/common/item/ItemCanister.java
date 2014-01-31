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
 * File created @ [Jan 30, 2014, 6:11:43 PM]
 */
package com.steamcraft.mod.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.steamcraft.mod.client.core.helper.SC2_ClientHelper;

/**
 *
 * @author MrArcane111 & EntireCraft
 *
 */
public class ItemCanister extends ItemSC2
{
	public ItemCanister(int id, int durability)
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(durability);  
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean flag) 
	{
		if(!SC2_ClientHelper.isShiftKeyDown())
		{
			list.add(SC2_ClientHelper.shiftForInfo);
			return;
		}
		
		list.add("\u00A77"+ (this.getMaxDamage() - itemStack.getItemDamage()) + "/" + this.getMaxDamage() + (itemStack.itemID == ModItems.steamCanister.itemID ? " steam" : " compressed gas"));
	}
}
