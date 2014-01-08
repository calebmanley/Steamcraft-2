package com.steamcraft.mod.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.lib.SC2_Material;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSCHoe extends ItemSC
{
	protected EnumToolMaterial toolMaterial;

	public ItemSCHoe(int id, EnumToolMaterial toolMat)
	{
		super(id);
		this.maxStackSize = 1;
		this.setMaxDamage(toolMat.getMaxUses());
		this.toolMaterial = toolMat;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int i, int j, int k, int l, float f1, float f2, float f3)
	{
		if(!player.canPlayerEdit(i, j, k, l, stack))
		{
			return false;
		}
		
		int i1 = world.getBlockId(i, j, k);
		int j1 = world.getBlockId(i, j + 1, k);
		
		if(l != 0 && j1 == 0 && i1 == Block.grass.blockID || i1 == Block.dirt.blockID)
		{
			Block block = Block.tilledField;
			world.playSoundEffect((double)((float)i + 0.5F), (double)((float)j + 0.5F), (double)((float)k + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
			
			if(world.isRemote)
			{
				return true;
			} else
			{
				world.setBlock(i, j, k, block.blockID);
				
				if(this.toolMaterial == SC2_Material.STEAM_TOOL)
				{
					stack.damageItem(1 + (int)Math.round(stack.getItemDamage() * 5 / 320), player);
					return true;
				}
				
				stack.damageItem(1, player);
				return true;
			}
		} else
		{
			return false;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
}