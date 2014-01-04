package com.steamcraft.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.steamcraft.mod.lib.SC_CreativeTabs;
import com.steamcraft.mod.lib.SC_Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSC extends Block
{
	public BlockSC(int id, Material mat)
	{
		super(id, mat);
		this.setCreativeTab(SC_CreativeTabs.tabSCBlocks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon("steamcraft:" + (getUnlocalizedName().substring(5)));
	}
}