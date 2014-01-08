package com.steamcraft.mod.handler;

import java.util.EnumSet;

import com.steamcraft.mod.item.ModArmors;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class SC2_ServerTickHandler implements ITickHandler
{
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		if(type.equals(EnumSet.of(TickType.PLAYER)))
		{
			playerTick((EntityPlayer) tickData[0]);
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
		return "SC_ServerTickHandler";
	}
}