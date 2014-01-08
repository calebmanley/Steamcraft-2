package com.steamcraft.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.steamcraft.mod.lib.SC2_CreativeTabs;
import com.steamcraft.mod.lib.SC2_Info;
import com.steamcraft.mod.main.SC2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSC extends Block
{
	public BlockSC(int id, Material mat)
	{
		super(id, mat);
		this.setCreativeTab(SC2_CreativeTabs.tabSCBlocks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(SC2_Info.MOD_ID.toLowerCase() + ":" + (getUnlocalizedName().substring(5))); // Cannot do a 'this' reflection!
	}
}