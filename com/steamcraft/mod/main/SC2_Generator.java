package com.steamcraft.mod.main;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.block.ModOres;

import cpw.mods.fml.common.IWorldGenerator;

public class SC2_Generator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider generator, IChunkProvider chunk) 
	{
        // For ore generation
		switch(world.provider.dimensionId)
		{
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}
	
	private void generateSurface(World world, Random random, int i, int j) 
	{
		for(int chance = 0; chance < 1; chance++) 
		{
			int etheriumXCoord = i + random.nextInt(16);
			int etheriumYCoord = 8 + random.nextInt(12);
			int etheriumZCoord = j + random.nextInt(16);
			
			new WorldGenMinable(ModOres.oreVolucite.blockID, 13).generate(world, random, etheriumXCoord, etheriumYCoord, etheriumZCoord);
		}
		for(int chance = 0; chance < 2; chance++) 
		{
			int uraniteXCoord = i + random.nextInt(16);
			int uraniteYCoord = random.nextInt(24);
			int uraniteZCoord = j + random.nextInt(16);
			
			new WorldGenMinable(ModOres.oreUranite.blockID, 13).generate(world, random, uraniteXCoord, uraniteYCoord, uraniteZCoord);
		}
		for(int chance = 0; chance < 12; chance++) 
		{
			int brimstoneXCoord = i + random.nextInt(16);
			int brimstoneYCoord = random.nextInt(64);
			int brimstoneZCoord = j + random.nextInt(16);
			
			new WorldGenMinable(ModOres.oreBrimstone.blockID, 13).generate(world, random, brimstoneXCoord, brimstoneYCoord, brimstoneZCoord);
		}
		for(int chance = 0; chance < 16; chance++) 
		{
			int borniteXCoord = i + random.nextInt(16);
			int borniteYCoord = random.nextInt(48);
			int borniteZCoord = j + random.nextInt(16);
			
			new WorldGenMinable(ModOres.oreBornite.blockID, 13).generate(world, random, borniteXCoord, borniteYCoord, borniteZCoord);
		}
		for(int chance = 0; chance < 3; chance++) 
		{
			int phosphateXCoord = i + random.nextInt(16);
			int phosphateYCoord = random.nextInt(36);
			int phosphateZCoord = j + random.nextInt(16);
			
			new WorldGenMinable(ModOres.orePhosphate.blockID, 13).generate(world, random, phosphateXCoord, phosphateYCoord, phosphateZCoord);
		}
	}

	private void generateEnd(World world, Random random, int i, int j) {}
	
	private void generateNether(World world, Random random, int i, int j) 
	{
		int num = random.nextInt(3) + 4;
        boolean flag = true;
        int k = world.getHeightValue(i, j);
        
        if(j < 1 || j + num + 1 > 128)
        {
            return;
        }
        for(int i1 = j; i1 <= j + 1 + num; i1++)
        {
            byte byte0 = 1;
           
            if(i1 == j)
            {
                byte0 = 0;
            }
            if(i1 >= (j + 1 + num) - 2)
            {
                byte0 = 2;
            }
            for(int i2 = i - byte0; i2 <= i + byte0 && flag; i2++)
            {
                for(int l2 = k - byte0; l2 <= k + byte0 && flag; l2++)
                {
                    if(i1 >= 0 && i1 < 128)
                    {
                        int j3 = world.getBlockId(i2, i1, l2);
                       
                        if(j3 != 0 && j3 != ModBlocks.brassLeaves.blockID)
                        {
                            flag = false;
                        }
                    } else
                    {
                        flag = false;
                    }
                }

            }

        }
        if(!flag)
        {
            return;
        }
        
        int j1 = world.getBlockId(i, j - 1, k);
        
        if(j1 != Block.netherrack.blockID || j >= 128 - num - 1)
        {
            return;
        }
        
        world.setBlock(i, j - 1, k, Block.netherrack.blockID);
        
        for(int k1 = (j - 3) + num; k1 <= j + num; k1++)
        {
            int j2 = k1 - (j + num);
            int i3 = 1 - j2 / 2;
           
            for(int k3 = i - i3; k3 <= i + i3; k3++)
            {
                int l3 = k3 - i;
               
                for(int i4 = k - i3; i4 <= k + i3; i4++)
                {
                    int j4 = i4 - k;
                 
                    if((Math.abs(l3) != i3 || Math.abs(j4) != i3 || random.nextInt(2) != 0 && j2 != 0) && !Block.opaqueCubeLookup[world.getBlockId(k3, k1, i4)])
                    {
                        world.setBlock(k3, k1, i4, ModBlocks.brassLeaves.blockID);
                    }
                }
            }
        }
        for(int l1 = 0; l1 < num; l1++)
        {
            int k2 = world.getBlockId(i, j + l1, k);
           
            if(k2 == 0 || k2 == ModBlocks.brassLeaves.blockID)
            {
                world.setBlock(i, j + l1, k, ModBlocks.brassWood.blockID);
            }
        }
	}
}