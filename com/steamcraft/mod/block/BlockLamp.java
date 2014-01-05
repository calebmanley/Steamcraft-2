package com.steamcraft.mod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockLamp extends BlockSC
{
	private boolean isPowered = false;
	
	protected BlockLamp(int id)
	{
		super(id, Material.iron);
		this.setHardness(2.0F);
		this.setStepSound(Block.soundGlassFootstep);
		this.setUnlocalizedName("lampblock");
		
		if(isPowered)
		{
			this.setLightValue(0.98F);
		}
	}

	@Override
	public int tickRate(World world)
	{
		return 1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return true;
	}

	@Override
	public void onBlockAdded(World world, int i, int j, int k)
	{
		world.notifyBlocksOfNeighborChange(i, j - 1, k, blockID);
		world.notifyBlocksOfNeighborChange(i, j + 1, k, blockID);
		world.notifyBlocksOfNeighborChange(i - 1, j, k, blockID);
		world.notifyBlocksOfNeighborChange(i + 1, j, k, blockID);
		world.notifyBlocksOfNeighborChange(i, j, k - 1, blockID);
		world.notifyBlocksOfNeighborChange(i, j, k + 1, blockID);
	}

	@Override
	public void breakBlock(World world, int i, int j, int k, int l, int m)
	{
		world.notifyBlocksOfNeighborChange(i, j - 1, k, blockID);
		world.notifyBlocksOfNeighborChange(i, j + 1, k, blockID);
		world.notifyBlocksOfNeighborChange(i - 1, j, k, blockID);
		world.notifyBlocksOfNeighborChange(i + 1, j, k, blockID);
		world.notifyBlocksOfNeighborChange(i, j, k - 1, blockID);
		world.notifyBlocksOfNeighborChange(i, j, k + 1, blockID);
	}

	@Override
	public void updateTick(World world, int i, int j, int k, Random random)
	{
		isPowered = this.nonOriginalMethod(world, i, j, k);
		
		if(isPowered)
		{
			world.setBlockMetadataWithNotify(i, j, k, ModBlocks.lampOn.blockID, world.getBlockMetadata(i, j, k));
		} else
		{
			world.setBlockMetadataWithNotify(i, j, k, ModBlocks.lampOff.blockID, world.getBlockMetadata(i, j, k));
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int i, int j, int k, int l)
	{
		super.onNeighborBlockChange(world, i, j, k, l);
		world.scheduleBlockUpdate(i, j, k, blockID, tickRate(world));
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	public int idDropped(int i, Random random, int j)
	{
		return ModBlocks.lampOff.blockID;
	}

	private boolean nonOriginalMethod(World world, int i, int j, int k)
	{
		if(world.getIndirectPowerOutput(i, j - 1, k, 0))
		{
			return true;
		}
		if(world.getIndirectPowerOutput(i, j + 1, k, 1))
		{
			return true;
		}
		if(world.getIndirectPowerOutput(i, j, k - 1, 2))
		{
			return true;
		}
		if(world.getIndirectPowerOutput(i, j, k + 1, 3))
		{
			return true;
		}
		if(world.getIndirectPowerOutput(i - 1, j, k, 4))
		{
			return true;
		}
		
		return world.getIndirectPowerOutput(i + 1, j, k, 5);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int i, int j, int k, int l)
	{
		super.harvestBlock(world, player, i, j, k, l);
	}

	@Override
	public boolean canProvidePower()
	{
		return false;
	}
}