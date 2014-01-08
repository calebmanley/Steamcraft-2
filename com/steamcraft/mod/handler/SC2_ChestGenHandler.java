package com.steamcraft.mod.handler;

import com.steamcraft.mod.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class SC2_ChestGenHandler 
{
	public static void addItemsToChests()
	{
		//ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.etherium), 1, 2, 1)); // Min amount, max amount, rarity
	}
}