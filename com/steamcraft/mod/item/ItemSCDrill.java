package com.steamcraft.mod.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.block.ModOres;
import com.steamcraft.mod.lib.SC_Material;

public class ItemSCDrill extends ItemSCTool
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, 
		Block.cobblestoneMossy, Block.cobblestoneWall, Block.stone, Block.sandStone, 
		Block.netherrack, Block.dirt, Block.gravel, Block.grass, Block.sand};
	protected EnumToolMaterial toolMaterial;

	protected ItemSCDrill(int id, EnumToolMaterial toolMat)
	{
		super(id, 1.0F, toolMat, blocksEffectiveAgainst);
		this.toolMaterial = toolMat;
	}

	@Override
	public boolean canHarvestBlock(Block block)
    {
		if(block == block.oreCoal)
		{
			return false;
		}
		
        return block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (block != Block.blockDiamond && block != Block.oreDiamond ? (block != Block.oreEmerald && block != Block.blockEmerald ? (block != Block.blockGold && block != Block.oreGold ? (block != Block.blockIron && block != Block.oreIron ? (block != Block.blockLapis && block != Block.oreLapis ? (block != Block.oreRedstone && block != Block.oreRedstoneGlowing ? (block.blockMaterial == Material.rock ? true : (block.blockMaterial == Material.iron ? true : block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }
	
	@Override
	public float getStrVsBlock(ItemStack stack, Block block)
	{
		if(this.toolMaterial == SC_Material.STEAM_TOOL)
		{
			return (4.0F - (((float) stack.getItemDamage()) * 11 / 320));
		}
		if(block != null && (block.blockMaterial == Material.iron || block.blockMaterial == Material.anvil || block.blockMaterial == Material.rock))
		{
			super.getStrVsBlock(stack, block);
		}
		
		return this.efficiencyOnProperMaterial;
	}
}