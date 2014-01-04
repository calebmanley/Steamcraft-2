package com.steamcraft.mod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.steamcraft.mod.lib.SC_CreativeTabs;
import com.steamcraft.mod.lib.SC_Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSC extends Item
{
	public ItemSC(int id)
	{
		super(id);
		this.setCreativeTab(SC_CreativeTabs.tabSCItems);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		itemIcon = icon.registerIcon(SC_Info.MOD_ID.toLowerCase() + ":" + (getUnlocalizedName().substring(5))); // Cannot do a 'this' reflection!
	}
}
