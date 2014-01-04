package com.steamcraft.mod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.steamcraft.mod.lib.SC_CreativeTabs;
import com.steamcraft.mod.lib.SC_Info;
import com.steamcraft.mod.lib.SC_Material;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSCArmor extends ItemArmor
{
	EnumArmorMaterial material;

	public ItemSCArmor(int id, EnumArmorMaterial mat, int renderIndex, int armorType)
	{
		super(id, mat, renderIndex, armorType);
		mat = material;
		this.setMaxStackSize(1);
		this.setCreativeTab(SC_CreativeTabs.INSTANCE.tabSCItems);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		this.itemIcon = icon.registerIcon(SC_Info.MOD_NAME + ":" + this.getUnlocalizedName().substring(5));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, int layer)
	{
		if(this.material == SC_Material.OBSIDIAN_ARMOR)
		{
			if(slot == 0 || slot == 1 || slot == 3)
			{
				return "/steamcraft/textures/armor/obsidian_1.png";
			} else if(slot == 2)
			{
				return "/steamcraft/textures/armor/obsidian_2.png";
			} else
			{
				return null;
			}
		} else if(this.material == SC_Material.ETHERIUM_ARMOR)
		{
			if(slot == 0 || slot == 1 || slot == 3)
			{
				return "/steamcraft/textures/armor/etherium_1.png";
			} else if(slot == 2)
			{
				return "/steamcraft/textures/armor/etherium_2.png";
			} else
			{
				return null;
			}
		} else if(this.material == SC_Material.STEAM_ARMOR)
		{
			if(slot == 0 || slot == 1 || slot == 3)
			{
				return "/steamcraft/textures/armor/brass_1.png";
			} else if(slot == 2)
			{
				return "/steamcraft/textures/armor/brass_2.png";
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