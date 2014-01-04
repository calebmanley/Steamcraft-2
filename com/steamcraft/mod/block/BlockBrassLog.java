package com.steamcraft.mod.block;

import java.util.List;
import java.util.Random;

import com.steamcraft.mod.lib.SC_CreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBrassLog extends Block
{
	@SideOnly(Side.CLIENT)
	private Icon logTop;
	
	protected BlockBrassLog(int i)
	{
		super(i, Material.iron);
		this.setHardness(5F);
		this.setStepSound(Block.soundMetalFootstep);
		this.setUnlocalizedName("brasslog");
		this.setCreativeTab(SC_CreativeTabs.tabSCBlocks);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	public int idDropped(int i, Random random, int j)
	{
		return ModBlocks.brassWood.blockID;
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int i, int j, int k, int l)
	{
		super.harvestBlock(world, player, i, j, k, l);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int i, int j)
	{
		if(i == 0 || i == 1)
		{
			return this.logTop;
		} else
		{
			return this.blockIcon;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		this.blockIcon = icon.registerIcon("steamcraft:brasslogside");
		this.logTop = icon.registerIcon("steamcraft:brasslogtop");
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