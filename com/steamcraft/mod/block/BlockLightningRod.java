package com.steamcraft.mod.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.steamcraft.mod.lib.SC2_CreativeTabs;
import com.steamcraft.mod.tileentity.TileEntityLightningRod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLightningRod extends BlockContainer
{
	public BlockLightningRod(int id)
	{
		super(id, Material.circuits);
		this.setCreativeTab(SC2_CreativeTabs.tabSCBlocks);
		float f = 0.24F;
		// minX, minY, minZ, maxX, maxY, maxZ
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 2.0F, 0.5F + f);
	}
	
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		this.blockIcon = icon.registerIcon("Roads:TrafficLightIcon");
	}*/

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityLightningRod();
	}
	
	@Override
	public int getRenderType() 
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube() 
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() 
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
}
