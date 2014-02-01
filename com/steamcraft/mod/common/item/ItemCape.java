/**
 * This class was created by <MrArcane111> or his SC2 development team. 
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MIT License.
 * (http://opensource.org/licenses/MIT)
 * 
 * Steamcraft 2 is based on the original Steamcraft created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 * 
 * File created @ [Feb 1, 2014, 8:19:17 AM]
 */
package com.steamcraft.mod.common.item;

import org.lwjgl.input.Keyboard;

import com.steamcraft.mod.common.SC2;
import com.steamcraft.mod.common.lib.SC2_CreativeTabs;
import com.steamcraft.mod.common.lib.SC2_Info;
import com.steamcraft.mod.common.lib.SC2_ItemNames;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @author MrArcane111
 *
 */
public class ItemCape extends ItemSC2Armor 
{
	public ItemCape(int id, EnumArmorMaterial mat, int renderIndex, int armorType)
	{
		super(id, mat, renderIndex, armorType);
		mat = this.material;
		this.setMaxStackSize(1);
		this.setCreativeTab(SC2_CreativeTabs.tabSCItems);
		this.setUnlocalizedName(SC2_ItemNames.LEATHER_CAPE);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, int slot) 
	{
		ModelBiped armorModel = new ModelBiped();

		if(stack != null)
		{
			if(stack.getItem() instanceof ItemCape)
			{
				int type = ((ItemArmor)stack.getItem()).armorType;

				if(type == 1 || type == 3)
				{
					armorModel = SC2.proxy.getCapeArmorModel(0);
				} else
				{
					armorModel = SC2.proxy.getCapeArmorModel(1);
				}
			}
			if(armorModel != null)
			{
				armorModel.bipedHead.showModel = slot == 0;
				armorModel.bipedHeadwear.showModel = slot == 0;
				armorModel.bipedBody.showModel = slot == 1 || slot == 2;
				armorModel.bipedRightArm.showModel = slot == 1;
				armorModel.bipedLeftArm.showModel = slot == 1;
				armorModel.bipedRightLeg.showModel = slot == 2 || slot == 3;
				armorModel.bipedLeftLeg.showModel = slot == 2 || slot == 3;
				armorModel.isSneak = living.isSneaking();
				armorModel.isRiding = living.isRiding();
				armorModel.isChild = living.isChild();
				armorModel.heldItemRight = living.getCurrentItemOrArmor(0) != null ? 1 :0;

				if(living instanceof EntityPlayer)
				{
					armorModel.aimedBow = ((EntityPlayer)living).getItemInUseDuration() > 2;
				}

				return armorModel;
			}
		}

		return null;
	}
	
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == ModArmors.cape.itemID)
		{
			return SC2_Info.SC2_PREFIX + "textures/armor/capebelt.png";
		} else
		{
			return null;
		}
	}
	*/
}
