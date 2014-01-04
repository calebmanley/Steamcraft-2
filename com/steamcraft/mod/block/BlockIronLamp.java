package com.steamcraft.mod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.steamcraft.mod.item.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockIronLamp extends BlockContainer
{
	private Class EntityClass;

	protected BlockIronLamp(int id, Class class1)
	{
		super(id, Material.circuits);
		this.EntityClass = class1;
		this.setLightValue(0.876F);
		float f = 0.25F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

	@Override
	public int tickRate(World world)
	{
		return 1;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
	{
		return null;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
	{
		setBlockBoundsBasedOnState(world, i, j, k);
		return super.getSelectedBoundingBoxFromPool(world, i, j, k);
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		try {
			return (TileEntity) EntityClass.newInstance();
		} catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public int onBlockPlaced(World world, int i, int j, int k, int l, float f1, float f2, float f3, int m)
	{
		if(l == 0 && canPlaceBottom(world, i, j + 1 , k))
		{
			world.setBlockMetadataWithNotify(i, j, k, this.blockID, 6);
		}
		if(l == 1 && canPlaceTop(world, i, j - 1, k))
		{
			world.setBlockMetadataWithNotify(i, j, k, this.blockID, 5);
		}
		if(l == 2 && canPlaceSide(world, i, j , k + 1))
		{
			world.setBlockMetadataWithNotify(i, j, k, this.blockID, 4);
		}
		if(l == 3 && canPlaceSide(world, i, j , k - 1))
		{
			world.setBlockMetadataWithNotify(i, j, k, this.blockID, 3);
		}
		if(l == 4 && canPlaceSide(world, i + 1, j , k))
		{
			world.setBlockMetadataWithNotify(i, j, k, this.blockID, 2);
		}
		if(l == 5 && canPlaceSide(world, i - 1, j , k))
		{
			world.setBlockMetadataWithNotify(i, j, k, this.blockID, 1);
		}

		return m;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int i, int j, int k)
	{
		if(canPlaceSide(world, i - 1, j , k))
		{
			return true;
		}
		if(canPlaceSide(world, i + 1, j , k))
		{
			return true;
		}
		if(canPlaceSide(world, i, j , k - 1))
		{
			return true;
		}
		if(canPlaceSide(world, i, j , k + 1))
		{
			return true;
		}
		if(canPlaceBottom(world, i, j + 1 , k))
		{
			return true;
		}

		return canPlaceTop(world, i, j - 1, k);
	}

	private boolean canPlaceTop(World world, int i, int j, int k)
	{
		return (world.isBlockNormalCube(i, j, k) 
				|| world.getBlockId(i, j, k) == Block.fence.blockID
				|| world.getBlockId(i, j, k) == ModBlocks.railingCastIron.blockID
				|| world.getBlockId(i, j, k) == Block.glass.blockID);
	}

	private boolean canPlaceSide(World world, int i, int j, int k)
	{
		return (world.isBlockNormalCube(i, j, k) 
				|| world.getBlockId(i, j, k) == Block.glass.blockID
				|| world.getBlockId(i, j, k) == Block.stairsBrick.blockID
				|| world.getBlockId(i, j, k) == Block.stairsCobblestone.blockID
				|| world.getBlockId(i, j, k) == Block.stairsNetherBrick.blockID
				|| world.getBlockId(i, j, k) == Block.stairsNetherQuartz.blockID
				|| world.getBlockId(i, j, k) == Block.stairsSandStone.blockID
				|| world.getBlockId(i, j, k) == Block.stairsStoneBrick.blockID
				|| world.getBlockId(i, j, k) == Block.stairsWoodBirch.blockID
				|| world.getBlockId(i, j, k) == Block.stairsWoodOak.blockID
				|| world.getBlockId(i, j, k) == Block.stairsWoodJungle.blockID
				|| world.getBlockId(i, j, k) == Block.stairsWoodSpruce.blockID);
	}

	private boolean canPlaceBottom(World world, int i, int j, int k)
	{
		return (world.isBlockNormalCube(i, j, k)
				|| world.getBlockId(i, j, k) == Block.glass.blockID
				|| world.getBlockId(i, j, k) == Block.stairsBrick.blockID
				|| world.getBlockId(i, j, k) == Block.stairsCobblestone.blockID
				|| world.getBlockId(i, j, k) == Block.stairsNetherBrick.blockID
				|| world.getBlockId(i, j, k) == Block.stairsNetherQuartz.blockID
				|| world.getBlockId(i, j, k) == Block.stairsSandStone.blockID
				|| world.getBlockId(i, j, k) == Block.stairsStoneBrick.blockID
				|| world.getBlockId(i, j, k) == Block.stairsWoodBirch.blockID
				|| world.getBlockId(i, j, k) == Block.stairsWoodOak.blockID
				|| world.getBlockId(i, j, k) == Block.stairsWoodJungle.blockID
				|| world.getBlockId(i, j, k) == Block.stairsWoodSpruce.blockID);
	}

	@Override
	public int idDropped(int i, Random random, int j)
	{
		return ModItems.ironLamp.itemID;
	}

	@Override
	public boolean canProvidePower()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int i, int j, int k, Random random)
	{
		int meta = world.getBlockMetadata(i, j, k);
		double d = (double)((float)i + 0.5F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
		double d1 = (double)((float)j + 1.0F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
		double d2 = (double)((float)k + 0.5F) + (double)(random.nextFloat() - 0.5F) * 0.20000000000000001D;
		double d3 = 0.2199999988079071D;
		double d4 = 0.27000001072883606D;

		if(meta == 1)
		{
			world.spawnParticle("reddust", d - d4, d1 + d3, d2, -1.0D, 0.7D, 1.0D);
		} else if(meta == 2)
		{
			world.spawnParticle("reddust", d + d4, d1 + d3, d2, -1.0D, 0.7D, 1.0D);
		} else if(meta == 3)
		{
			world.spawnParticle("reddust", d, d1 + d3, d2 - d4, -1.0D, 0.7D, 1.0D);
		} else if(meta == 4)
		{
			world.spawnParticle("reddust", d, d1 + d3, d2 + d4, -1.0D, 0.7D, 1.0D);
		} else
		{
			world.spawnParticle("reddust", d, d1, d2, -1.0D, 0.7D, 1.0D);
		}
	}
}