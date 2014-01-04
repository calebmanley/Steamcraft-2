package com.steamcraft.mod.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import cpw.mods.fml.relauncher.Side;

public class ItemChisel extends ItemSC
{
	public ItemChisel(int id, int damage)
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(damage);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
}