package com.steamcraft.mod.item;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.entity.EntityLaserParticleFX;
import com.steamcraft.mod.lib.SC2_CreativeTabs;
import com.steamcraft.mod.main.SC2_Coord;

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
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		SC2_Coord coord = SC2_Coord.instance;
		SC2_Coord move = SC2_Coord.instance;
		double r = 1.0D;
		double g = 0.001D;
		double b = 0.001D;
		this.spawnParticles(coord, move, world, 0, r, g, b);
		return stack;
	}

	private void spawnParticles(SC2_Coord coord, SC2_Coord move, World world, int half, double r, double g, double b)
	{
		double shift = 0;

		if(half == 0) shift = -0.5D + random.nextFloat() * 1.0D;
		if(half == 1) shift = -random.nextFloat() * 0.5D;
		if(half == 2) shift = random.nextFloat() * 0.5D;

		double x = coord.x + 0.5D;
		double y = coord.y + 0.5D;
		double z = coord.z + 0.5D;
		double d1, d2, d3;
		d1 = x;
		d2 = y;
		d3 = z;

		if(move.x > 0) d1 = x + shift;
		if(move.y > 0) d2 = y + shift;
		if(move.z > 0) d3 = z + shift;
		if(move.x < 0) d1 = x - shift;
		if(move.y < 0) d2 = y - shift;
		if(move.z < 0) d3 = z - shift;

		Minecraft.getMinecraft().effectRenderer.addEffect(new EntityLaserParticleFX(world, d1, d2, d3, (float) r, (float) g, (float) b, move.x, move.y, move.z, half));
	}
}