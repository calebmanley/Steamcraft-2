package com.steamcraft.mod.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.steamcraft.mod.common.lib.SC2_CreativeTabs;
import com.steamcraft.mod.common.lib.SC2_Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBrassLog extends BlockRotatedPillar
{
	@SideOnly(Side.CLIENT)
	private Icon tree_side;
	@SideOnly(Side.CLIENT)
	private Icon tree_top;

	protected BlockBrassLog(int i)
	{
		super(i, Material.iron);
		this.setHardness(5.0F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setUnlocalizedName("brasslog");
		this.setCreativeTab(SC2_CreativeTabs.tabSCBlocks);
	}

	@Override
	public int idDropped(int i, Random random, int j)
	{
		return this.blockID;
	}

	@Override
	public void breakBlock(World world, int i, int j, int k, int side, int meta)
	{
		byte b0 = 4;
		int num = b0 + 1;

		if(world.checkChunksExist(i - num, j - num, k - num, i + num, j + num, k + num))
		{
			for(int x = -b0; x <= b0; ++x)
			{
				for(int y = -b0; y <= b0; ++y)
				{
					for(int z = -b0; z <= b0; ++z)
					{
						int bid = world.getBlockId(i + x, j + y, k + z);

						if(Block.blocksList[bid] != null)
						{
							Block.blocksList[bid].beginLeavesDecay(world, i + x, j + y, k + z);
						}
					}
				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected Icon getSideIcon(int i)
	{
		return this.tree_side;
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected Icon getEndIcon(int i)
	{
		return this.tree_top;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		this.tree_side = icon.registerIcon(SC2_Info.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + "side");
		this.tree_top = icon.registerIcon(SC2_Info.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5) + "top");
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z)
	{
		return true;
	}
}