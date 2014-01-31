package com.steamcraft.mod.common.item;

import java.util.List;

import com.steamcraft.mod.common.lib.SC2_GeneralUtils;
import com.steamcraft.mod.common.lib.SC2_ItemIDs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemCanister extends ItemSC
{
	public ItemCanister(int id, int durabillity)
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(durabillity);
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) 
	{
		if(!SC2_GeneralUtils.isShiftKeyDown())
		{
			list.add(SC2_GeneralUtils.shiftForInfo);
			return;
		}
		
		list.add("\u00A77"+ (this.getMaxDamage()-itemStack.getItemDamage()) + "/" + this.getMaxDamage() + (itemStack.itemID==ModItems.steamCanister.itemID ? " steam" : " compressed gas"));
	}
}
