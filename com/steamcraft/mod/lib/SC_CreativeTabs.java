package com.steamcraft.mod.lib;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SC_CreativeTabs extends CreativeTabs 
{
	public static final SC_CreativeTabs INSTANCE = new SC_CreativeTabs();

	public SC_CreativeTabs() 
	{
		super(SC_Info.MOD_ID);
	}

	public static CreativeTabs tabSCBlocks = new CreativeTabs("SteamCraft Blocks") 
	{
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() 
		{
			return new ItemStack(ModBlocks.decorBrass); 
		}
	};

	public static CreativeTabs tabSCItems = new CreativeTabs("SteamCraft Items")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() 
		{
			return new ItemStack(ModItems.coreDrill);
		}
	};
}