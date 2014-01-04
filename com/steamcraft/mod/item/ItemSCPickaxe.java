package com.steamcraft.mod.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.lib.SC_Material;

public class ItemSCPickaxe extends ItemSCTool
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, 
		Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone,
		Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, 
		Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, 
		Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone,
		Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, 
		Block.railActivator};

	protected ItemSCPickaxe(int id, EnumToolMaterial toolMat)
	{
		super(id, 2.0F, toolMat, blocksEffectiveAgainst);
	}

	@Override
	public boolean canHarvestBlock(Block block)
	{
		if(block == ModBlocks.oreVolucite || block == ModBlocks.blockVolucite || block == ModBlocks.decorVolucite)
		{
			return toolMaterial.getHarvestLevel() == 4;
		}
		if(block == ModBlocks.lampOn || block == ModBlocks.brassLeaves)
		{
			return true;
		}
		if(block == ModBlocks.oreUranite || block == ModBlocks.blockUranium || block == ModBlocks.decorUranium)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == Block.obsidian)
		{
			return toolMaterial.getHarvestLevel() >= 3;
		}
		if(block == Block.blockGold || block == Block.oreGold || block == Block.blockDiamond ||  block == ModBlocks.decorDiamond)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == Block.blockIron || block == Block.oreIron || block == ModBlocks.blockCastIron || block == ModBlocks.decorIron || block == ModBlocks.decorCastIron)
		{
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if(block == Block.blockLapis || block == Block.oreLapis || block == ModBlocks.decorLapis)
		{
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if(block == ModBlocks.oreBornite || block == ModBlocks.blockBrass || block == ModBlocks.brassWood || block == ModBlocks.decorBrass)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == ModBlocks.oreBrimstone)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == ModBlocks.orePhosphate)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block.blockMaterial == Material.rock)
		{
			return true;
		}
		
		return block.blockMaterial == Material.iron;
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block)
	{
		for(int i = 0; i < blocksEffectiveAgainst.length; i++)
		{
			if(blocksEffectiveAgainst[i] == block)
			{
				if(this.toolMaterial == SC_Material.STEAM_TOOL)
				{
					return (4.0F - (((float) stack.getItemDamage()) * 11 / 320));
				}
				
				return 4.0F;
			}
		}
		
		return 1.0F;
	}
}