package com.steamcraft.mod.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.lib.SC_Material;

public class ItemSCDrill extends ItemSCTool
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stone, Block.sandStone, Block.netherrack};
	protected EnumToolMaterial toolMaterial;

	protected ItemSCDrill(int id, EnumToolMaterial toolMat)
	{
		super(id, 3.0F, toolMat, blocksEffectiveAgainst);
		this.toolMaterial = toolMat;
	}

	@Override
	public boolean canHarvestBlock(Block block)
	{
		if(block == ModBlocks.oreVolucite)
		{
			return false;
		}
		if(block == ModBlocks.lampOff || block == ModBlocks.brassLeaves)
		{
			return true;
		}
		if(block == ModBlocks.blockVolucite || block == ModBlocks.decorVolucite)
		{
			return toolMaterial.getHarvestLevel() == 4;
		}
		if(block == ModBlocks.oreUranite)
		{
			return false;
		}
		if(block == ModBlocks.blockUranium || block == ModBlocks.decorUranium)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == Block.obsidian)
		{
			return false;
		}
		if(block == Block.blockDiamond || block == ModBlocks.decorDiamond)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == Block.oreGold)
		{
			return false;
		}
		if(block == Block.blockGold || block == ModBlocks.decorGold)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == Block.blockIron || block == Block.oreIron || block == ModBlocks.blockCastIron || block == ModBlocks.decorIron || block == ModBlocks.decorCastIron)
		{
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if(block == Block.oreLapis)
		{
			return false;
		}
		if(block == Block.blockLapis || block == ModBlocks.decorLapis)
		{
			return toolMaterial.getHarvestLevel() >= 1;
		}
		if(block == Block.oreRedstone || block == Block.oreRedstoneGlowing || block == ModBlocks.blockBrass || block == ModBlocks.brassWood || block == ModBlocks.decorBrass)
		{
			return toolMaterial.getHarvestLevel() >= 2;
		}
		if(block == ModBlocks.oreBrimstone)
		{
			return false;
		}
		if(block == ModBlocks.orePhosphate)
		{
			return false;
		}
		if(block.blockMaterial == Material.rock)
		{
			return true;
		}

		return block.blockMaterial == Material.iron;
	}

	//@SuppressWarnings("unused")
	@Override
	public float getStrVsBlock(ItemStack itemstack, Block block)
	{
		for(Block element : blocksEffectiveAgainst) 
		{
			if(element == block)
			{
				if(toolMaterial == SC_Material.STEAM_TOOL)
				{
					return (4.0F - (((float)itemstack.getItemDamage()) * 11 / 320));
				}
			}

			return 4.0F;
		}

		return 1.0F;
	}
}