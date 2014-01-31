package com.steamcraft.mod.common.item;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.common.lib.SC2_Material;

public class ItemSCDrill extends ItemSCTool
{
	private Random random = new Random();
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
	public boolean onBlockDestroyed(ItemStack stack, World world, int i, int j, int k, int l, EntityLivingBase living)
    {
		world.playSoundAtEntity((EntityPlayer)living, "steamcraft:drill", 1.0F, 1.0F);
		world.spawnParticle("smoke", i + 0.5, j + 0.5, k + 0.5, random.nextGaussian(), random.nextGaussian(), random.nextGaussian());
        return true;
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
		if(this.toolMaterial == SC2_Material.STEAM_TOOL)
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