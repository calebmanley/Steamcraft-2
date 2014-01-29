package com.steamcraft.mod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.steamcraft.mod.lib.SC2_CreativeTabs;
import com.steamcraft.mod.model.ModelLightningRod;
import com.steamcraft.mod.tileentity.TileEntityLightningRod;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLightningRod extends BlockContainer //implements ISimpleBlockRenderingHandler
{	
	public BlockLightningRod(int id)
	{
		super(id, Material.circuits);
		this.setCreativeTab(SC2_CreativeTabs.tabSCBlocks);
		float f = 0.24F;
		// minX, minY, minZ, maxX, maxY, maxZ
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 2.0F, 0.5F + f);
        this.setTickRandomly(true);
        this.setHardness(2.0F);
        this.setResistance(0.5F);
	}
	
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		this.blockIcon = icon.registerIcon("Roads:TrafficLightIcon");
	}*/
	
	@Override
	public int tickRate(World world)
	{
		return 10;
	}

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
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
		if(world.canLightningStrikeAt(i, j, k) && world.isRaining() == true)
		{
			if(world.rand.nextInt(this.getLightningChance(world)) == 0)
			{
				world.addWeatherEffect(new EntityLightningBolt(world, i, j + 2, k));
				this.checkForNearbyEntities(world);
			}
		} else
		{
			return;
		}
    }
	
	@Override
	public void updateTick(World world, int i, int j, int k, Random random) {}
	
	public int getLightningChance(World world)
	{
		int chance = 0;
		
		for(int x = -5; x < 5; x++)
		{
			for(int y = -1; y < 2; y++)
			{
				for(int z = -5; z < 5; z++)
				{
					int bid = world.getBlockId(x, y, z);
					
					if(bid == Block.blockGold.blockID || bid == Block.blockIron.blockID 
					|| bid == ModBlocks.decorGold.blockID || bid == ModBlocks.decorIron.blockID
					|| bid == ModBlocks.blockBrass.blockID || bid == ModBlocks.decorBrass.blockID)
					{
						chance = 100;
					} else if(bid == ModBlocks.blockCastIron.blockID || bid == ModBlocks.decorCastIron.blockID)
					{
						chance = 50;
					} else
					{
						chance = 200;
					}
				}
			}
		}
		
		return chance;
	}
	
	public void checkForNearbyEntities(World world)
	{
		
	}
}