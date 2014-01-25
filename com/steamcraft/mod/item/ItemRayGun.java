package com.steamcraft.mod.item;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.steamcraft.mod.lib.SC2_CreativeTabs;
import com.steamcraft.mod.main.SC2;

public class ItemRayGun extends ItemSC
{
	String raySound;
	private Random random = new Random();
	static HashMap<String, Object> ray = new HashMap();

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
		MovingObjectPosition mop = this.getTargetBlock(world, player, false);
		Vec3 vec3 = player.getLookVec();
		double tx = player.posX + vec3.xCoord * 10.0D;
		double ty = player.posY + vec3.yCoord * 10.0D;
		double tz = player.posZ + vec3.zCoord * 10.0D;
		int impact = 0;

		if(mop != null) 
		{
			tx = mop.hitVec.xCoord;
			ty = mop.hitVec.yCoord;
			tz = mop.hitVec.zCoord;
			impact = 5;
		}
		if(world.isRemote) 
		{
			ray.put(player.username, SC2.proxy.rayBeam(world, player, tx, ty, tz, 2, 65382, false, impact > 0 ? 2.0F : 0.0F, ray.get(player), impact));
		}

		return stack;
	}

	// Grabs a vector from the player
	public static MovingObjectPosition getTargetBlock(World world, Entity entity, boolean flag)
	{
		float var4 = 1.0F;
		float var5 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * var4;
		float var6 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * var4;
		double var7 = entity.prevPosX + (entity.posX - entity.prevPosX) * var4;
		double var9 = entity.prevPosY + (entity.posY - entity.prevPosY) * var4 + 1.62D - entity.yOffset;
		double var11 = entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4;
		Vec3 var13 = world.getWorldVec3Pool().getVecFromPool(var7, var9, var11);
		float var14 = MathHelper.cos(-var6 * 0.01745329F - 3.141593F);
		float var15 = MathHelper.sin(-var6 * 0.01745329F - 3.141593F);
		float var16 = -MathHelper.cos(-var5 * 0.01745329F);
		float var17 = MathHelper.sin(-var5 * 0.01745329F);
		float var18 = var15 * var16;
		float var20 = var14 * var16;
		double var21 = 10.0D;
		Vec3 var23 = var13.addVector(var18 * var21, var17 * var21, var20 * var21);
		return world.rayTraceBlocks_do_do(var13, var23, flag, !flag);
	}
}