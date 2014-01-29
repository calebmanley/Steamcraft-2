package com.steamcraft.mod.item;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.lib.SC2_CreativeTabs;
import com.steamcraft.mod.lib.SC2_Info;
import com.steamcraft.mod.main.SC2;
import com.steamcraft.mod.model.ModelBrassMonocle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBrassWings extends ItemSCArmor
{
	public ItemBrassWings(int id, EnumArmorMaterial mat, int renderIndex, int armorType)
	{
		super(id, mat, renderIndex, armorType);
		mat = material;
		this.setMaxStackSize(1);
		this.setCreativeTab(SC2_CreativeTabs.tabSCItems);
		this.setUnlocalizedName("brasswings");
	}

	@Override // Thank-you Forge for this method. Otherwise, I would have to use TickHandlers...
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
		//System.out.println("Kittens and penguins!");
		int flyTime = 0;
		
		if(!player.onGround && player.isSneaking())
		{
			player.motionY /= 2.0D;
		} else if(player.motionY > 0.0D && !player.onGround && flyTime <= 1000)
		{
			player.motionY += 2.0D;
			flyTime++;
		}
		if(flyTime > 1000)
		{
			flyTime = 0;
		}

	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = new ModelBiped();

		if(itemStack != null)
		{
			if(itemStack.getItem() instanceof ItemBrassWings)
			{
				int type = ((ItemArmor)itemStack.getItem()).armorType;

				if(type == 1 || type == 3)
				{
					armorModel = SC2.proxy.getWingsArmorModel(0);
				} else
				{
					armorModel = SC2.proxy.getWingsArmorModel(1);
				}
			}
			if(armorModel != null)
			{
				armorModel.bipedHead.showModel = armorSlot == 0;
				armorModel.bipedHeadwear.showModel = armorSlot == 0;
				armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
				armorModel.bipedRightArm.showModel = armorSlot == 1;
				armorModel.bipedLeftArm.showModel = armorSlot == 1;
				armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
				armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isRiding = entityLiving.isRiding();
				armorModel.isChild = entityLiving.isChild();
				armorModel.heldItemRight = entityLiving.getCurrentItemOrArmor(0) != null ? 1 :0;

				if(entityLiving instanceof EntityPlayer)
				{
					armorModel.aimedBow = ((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
				}

				return armorModel;
			}
		}

		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == ModArmors.brassWings.itemID)
		{
			return SC2_Info.MOD_ID.toLowerCase() + ":textures/armor/brasswings.png";
		} else
		{
			return null;
		}
	}
}