package com.steamcraft.mod.item;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.steamcraft.mod.entity.EntityLaser;
import com.steamcraft.mod.lib.SC2_CreativeTabs;
import com.steamcraft.mod.main.SC2_Coord;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRayGun extends ItemSC
{
	String raySound;
	private Random random = new Random();

	public ItemRayGun(int id, String raySound)
	{
		super(id);
		this.raySound = raySound;
		this.setCreativeTab(SC2_CreativeTabs.tabSCItems);
		this.setMaxDamage(300);
		this.setMaxStackSize(1);
		this.setUnlocalizedName("raygun");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		EntityLaser laser = new EntityLaser(world);
		
		if(!world.isRemote)
		{
			world.spawnEntityInWorld(laser);
			System.out.println("WOOF");
		}
		
		return stack;
	}
}