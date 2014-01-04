package com.steamcraft.mod.handler;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.BlockEvent;

import com.steamcraft.mod.item.ModItems;

public class SC_EventHandler 
{
	@ForgeSubscribe
	public void blockDrops(BlockEvent.HarvestDropsEvent event)
	{
		if(event.block == Block.tallGrass)
		{
			event.drops.add(new ItemStack(ModItems.teaSeed, 1));
			event.dropChance = 0.16F; // Should be 16% chance for tea seeds to drop
		}
	}
}