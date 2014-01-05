package com.steamcraft.mod.block;

import java.util.Random;

import com.steamcraft.mod.item.ModItems;
import com.steamcraft.mod.lib.SC_CreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSCOre extends BlockSC
{
	public BlockSCOre(int id)
	{
		super(id, Material.rock);
		this.setCreativeTab(SC_CreativeTabs.tabSCBlocks);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@Override
	public int idDropped(int i, Random random, int j)
	{
		if(this.blockID == ModOres.oreBornite.blockID)
		{
			return ModOres.oreBornite.blockID;
		} else if(this.blockID == ModOres.oreBrimstone.blockID)
		{
			return ModOres.oreBrimstone.blockID;
		} else if(this.blockID == ModOres.orePhosphate.blockID)
		{
			return ModOres.orePhosphate.blockID;
		} else if(this.blockID == ModOres.oreVolucite.blockID) 
		{
			return ModItems.etherium.itemID;
		} else
		{
			return 0;
		}
	}

	@Override
	public int quantityDroppedWithBonus(int i, Random random)
	{
		if(this.blockID != ModOres.oreVolucite.blockID)
		{
			if(i > 0 && this.blockID != this.idDropped(0, random, i))
			{
				int j = random.nextInt(i + 2) - 1;

				if(j < 0)
				{
					j = 0;
				}

				return this.quantityDropped(random) * (j + 1);
			} else
			{
				return this.quantityDropped(random);
			}
		} else
		{
			return 1;
		}
	}

	@Override
	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int m)
	{
		super.dropBlockAsItemWithChance(world, i, j, k, l, f, m);

	}

	@Override
	public int getExpDrop(World world, int i, int j)
	{
		if(this.idDropped(i, world.rand, j) != this.blockID)
		{
			int k = 0;

			if(this.blockID == ModOres.oreVolucite.blockID)
			{
				k = MathHelper.getRandomIntegerInRange(world.rand, 4, 10);
			} 

			return k;
		}

		return 0;
	}
}