package com.steamcraft.mod.lib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.item.ModTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SC2_CreativeTabs extends CreativeTabs 
{
	public SC2_CreativeTabs(int position, String name) 
	{
		super(position, name);
	}

	public static CreativeTabs tabSCBlocks = new SC2_CreativeTabs(CreativeTabs.getNextID(), "Steamcraft Blocks") 
	{
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() 
		{
			return new ItemStack(ModBlocks.decorBrass); 
		}
		
		@Override
		public String getTranslatedTabLabel()
		{
			return "Steamcraft Blocks";
		}
	};

	public static CreativeTabs tabSCItems = new SC2_CreativeTabs(CreativeTabs.getNextID(), "Steamcraft Items")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() 
		{
			return new ItemStack(ModTools.drillCore);
		}
		
		@Override
		public String getTranslatedTabLabel()
		{
			return "Steamcraft Items";
		}
	};
}