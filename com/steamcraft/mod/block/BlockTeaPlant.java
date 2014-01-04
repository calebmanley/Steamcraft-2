package com.steamcraft.mod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.steamcraft.mod.item.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTeaPlant extends BlockFlower
{
	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	protected BlockTeaPlant(int id)
	{
		super(id);
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setHardness(0.0F);
		this.disableStats();
		this.setStepSound(soundGrassFootstep);
		this.setUnlocalizedName("tea");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int i, int j)
	{
		if(j < 0 || j > 7)
		{
			j = 7;
		}

		return this.iconArray[j];
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int bid)
	{
		return bid == Block.tilledField.blockID;
	}

	@Override
	public void updateTick(World world, int i, int j, int k, Random random)
	{
		super.updateTick(world, i, j, k, random);

		if(world.getBlockLightValue(i, j + 1, k) >= 9)
		{
			int meta = world.getBlockMetadata(i, j, k);

			if(meta < 2)
			{
				float rate = getGrowthRate(world, i, j, k);

				if(random.nextInt((int)(100F / rate)) == 0)
				{
					meta++;
					world.setBlockMetadataWithNotify(i, j, k, this.blockID, meta);
				}
			}
		}
	}

	public void fertilize(World world, int i, int j, int k)
	{
		world.setBlockMetadataWithNotify(i, j, k, this.blockID, 7);
	}

	private float getGrowthRate(World world, int i, int j, int k) // I never bother to clean up these variables...
	{
		float f = 1.0F;
		int l = world.getBlockId(i, j, k - 1);
		int i1 = world.getBlockId(i, j, k + 1);
		int j1 = world.getBlockId(i - 1, j, k);
		int k1 = world.getBlockId(i + 1, j, k);
		int l1 = world.getBlockId(i - 1, j, k - 1);
		int i2 = world.getBlockId(i + 1, j, k - 1);
		int j2 = world.getBlockId(i + 1, j, k + 1);
		int k2 = world.getBlockId(i - 1, j, k + 1);
		boolean flag = j1 == blockID || k1 == blockID;
		boolean flag1 = l == blockID || i1 == blockID;
		boolean flag2 = l1 == blockID || i2 == blockID || j2 == blockID || k2 == blockID;

		for(int l2 = i - 1; l2 <= i + 1; l2++)
		{
			for(int i3 = k - 1; i3 <= k + 1; i3++)
			{
				int j3 = world.getBlockId(l2, j - 1, i3);
				float f1 = 0.0F;

				if(j3 == Block.tilledField.blockID)
				{
					f1 = 1.0F;

					if(world.getBlockMetadata(l2, j - 1, i3) > 0)
					{
						f1 = 3F;
					}
				}
				if(l2 != i || i3 != k)
				{
					f1 /= 4F;
				}

				f += f1;
			}

		}
		if(flag2 || flag && flag1)
		{
			f /= 2.0F;
		}

		return f;
	}

	@Override
	public int getRenderType()
	{
		return 6;
	}

	@Override
	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int m)
	{
		super.dropBlockAsItemWithChance(world, i, j, k, l, f, m);

		if(world.isRemote)
		{
			return;
		}
		for(int num = 0; num < 3; num++)
		{
			if(world.rand.nextInt(15) <= l)
			{
				float f1 = 0.7F;
				float f2 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
				float f3 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
				float f4 = world.rand.nextFloat() * f1 + (1.0F - f1) * 0.5F;
				EntityItem item = new EntityItem(world, (float)i + f2, (float)j + f3, (float)k + f4, new ItemStack(ModItems.teaSeed));
				item.delayBeforeCanPickup = 10;
				world.spawnEntityInWorld(item);
			}
		}
	}

	@Override
	public int idDropped(int i, Random random, int j)
	{
		if(i == 7)
		{
			return ModItems.teaLeaves.itemID;
		} else
		{
			return 0;
		}
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int idPicked(World world, int i, int j, int k)
	{
		return ModItems.teaSeed.itemID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		this.iconArray = new Icon[3];

		for(int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = icon.registerIcon(this.getUnlocalizedName() + "_stage_" + i);
		}
	}
}