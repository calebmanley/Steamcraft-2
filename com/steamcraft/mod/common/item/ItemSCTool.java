package com.steamcraft.mod.common.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;
import com.steamcraft.mod.common.lib.SC2_GeneralUtils;
import com.steamcraft.mod.common.lib.SC2_Material;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSCTool extends ItemSC
{
	protected static Block[] blocksEffectiveAgainst;
	public float efficiencyOnProperMaterial = 4.0F;
	public float damageVsEntity;
	protected EnumToolMaterial toolMaterial;

	protected ItemSCTool(int id, float damage, EnumToolMaterial toolMat, Block[] blockArray)
	{
		super(id);
		this.toolMaterial = toolMat;
		this.blocksEffectiveAgainst = blockArray;
		this.maxStackSize = 1;
		this.setMaxDamage(toolMat.getMaxUses());
		this.efficiencyOnProperMaterial = toolMat.getEfficiencyOnProperMaterial();
		
		/*
		 * This makes the damage of steam tools negative
		 * 
		if(this.toolMaterial == SC2_Material.STEAM_TOOL)
		{
			damageVsEntity = damage - (int) Math.round(this.getMaxDamage() * 5 / 320);
		}
		*/
		
		this.damageVsEntity = damage + toolMat.getDamageVsEntity();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block)
	{
		for(int i = 0; i < blocksEffectiveAgainst.length; i++)
		{
			if(blocksEffectiveAgainst[i] == block)
			{
				if(this.toolMaterial == SC2_Material.STEAM_TOOL)
				{
					return (efficiencyOnProperMaterial - (((float) stack.getItemDamage()) * 11 / 320));
				}

				return efficiencyOnProperMaterial;
			}
		}

		return 1.0F;
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase living1, EntityLivingBase living2)
	{
		itemstack.damageItem(2, living2);
		return true;
	}

	@Override
	public int getItemEnchantability()
	{
		return this.toolMaterial.getEnchantability();
	}

	@Override
	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2)
	{
		return this.toolMaterial.getToolCraftingMaterial() == stack2.itemID ? true : super.getIsRepairable(stack1, stack2);
	}

	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Tool modifier", (double)this.damageVsEntity, 0));
		return multimap;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, int i, int j, int k, int l, EntityLivingBase living)
	{
		if(toolMaterial == SC2_Material.STEAM_TOOL)
		{
			System.out.println(efficiencyOnProperMaterial - (((float) stack.getItemDamage()) * 11 / 320));
			int itemDamage = stack.getItemDamage();
		}

		stack.damageItem(1, living);
		return true;
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean bool) 
	{
    	if(toolMaterial==SC2_Material.INSTANCE.STEAM_TOOL)
    	{
			if(!SC2_GeneralUtils.isShiftKeyDown())
			{
				list.add(SC2_GeneralUtils.shiftForInfo);
				return;
			}
			
			list.add("\u00A77"+ (this.getMaxDamage()-itemStack.getItemDamage()) + "/" + this.getMaxDamage() + " steam");
    	}
	}
    
    @Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			if(toolMaterial==SC2_Material.INSTANCE.STEAM_TOOL)
			{
				/*
				 * Probably not the most efficient way to do it, but it works so you can't complain :P
				 */
				if(player.inventory.hasItem(ModItems.steamCanister.itemID))
				{
					int i=0;
					while(stack.getItemDamage()!=0 && i<36)
					{
						if(player.inventory.mainInventory[i].itemID==ModItems.steamCanister.itemID)
						{
							while(player.inventory.mainInventory[i].getItemDamage()<ModItems.steamCanister.getMaxDamage() && stack.getItemDamage()>0)
							{
								player.inventory.mainInventory[i].damageItem(1, player);
								stack.setItemDamage(stack.getItemDamage()-1);
							}
						}
						i++;
					}
				}
					
			}
		}
		
		return stack;
	}
}