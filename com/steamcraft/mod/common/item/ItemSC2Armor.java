package com.steamcraft.mod.common.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.steamcraft.mod.common.lib.SC2_CreativeTabs;
import com.steamcraft.mod.common.lib.SC2_Info;
import com.steamcraft.mod.common.lib.SC2_Material;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSC2Armor extends ItemArmor
{
	EnumArmorMaterial material;

	public ItemSC2Armor(int id, EnumArmorMaterial mat, int renderIndex, int armorType)
	{
		super(id, mat, renderIndex, armorType);
		mat = material;
		this.setMaxStackSize(1);
		this.setCreativeTab(SC2_CreativeTabs.tabSCItems);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		this.itemIcon = icon.registerIcon(SC2_Info.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName().substring(5));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, int layer) // TODO: This needs some cleanup!
	{
		if(armor.itemID == ModArmors.bootsObsidian.itemID || armor.itemID == ModArmors.legsObsidian.itemID || armor.itemID == ModArmors.plateObsidian.itemID || armor.itemID == ModArmors.helmetObsidian.itemID)
		{
			if(slot == 0 || slot == 1 || slot == 3)
			{
				return "steamcraft:textures/armor/obsidian_1.png";
			} else if(slot == 2)
			{
				return "steamcraft:textures/armor/obsidian_2.png";
			} else
			{
				return null;
			}
		} else if(armor.itemID == ModArmors.bootsEtherium.itemID || armor.itemID == ModArmors.legsEtherium.itemID || armor.itemID == ModArmors.plateEtherium.itemID || armor.itemID == ModArmors.helmetEtherium.itemID)
		{
			if(slot == 0 || slot == 1 || slot == 3)
			{
				return "steamcraft:textures/armor/etherium_1.png";
			} else if(slot == 2)
			{
				return "steamcraft:textures/armor/etherium_2.png";
			} else
			{
				return null;
			}
		} else if(armor.itemID == ModArmors.rollerSkates.itemID || armor.itemID == ModArmors.legBraces.itemID || armor.itemID == ModArmors.aqualung.itemID || armor.itemID == ModArmors.brassGoggles.itemID)
		{
			if(slot == 0 || slot == 1 || slot == 3)
			{
				return "steamcraft:textures/armor/brass_1.png";
			} else if(slot == 2)
			{
				return "steamcraft:textures/armor/brass_2.png";
			} else
			{
				return null;
			}
		} else
		{
			return null;
		}
	}
}