package com.steamcraft.mod.item;

import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.entity.EntityBullet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGun extends ItemSC
{
	private int damage; // Damage in half hearts
	public static boolean timerComplete = true;
	private int ammoID; 
	private boolean isRifled;
	private String soundGunshot; 
	private String soundReload; 
	private int delay;
	Timer timer = new Timer();

	public ItemGun(int id, int damage, int delay, int ammoID, String soundGunshot, String soundReload, boolean rifled)
	{ 
		super(id); 
		this.damage = damage;
		this.ammoID = ammoID;
		this.soundGunshot = soundGunshot; 
		this.soundReload = soundReload; 
		this.isRifled = rifled;
		this.delay = delay;
		this.setMaxStackSize(1);
		this.setMaxDamage(300);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	private boolean hasAmmo(EntityPlayer player)
	{
		if(player.inventory.hasItem(ammoID))
		{
			return true;
		} else
		{
			return false;
		}
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		EntityBullet bullet = new EntityBullet(world, player, damage, 1);

		if(!world.isRemote && !player.isInWater() && this.hasAmmo(player) == true)
		{
			if(this.timerComplete == true)
			{
				world.spawnEntityInWorld(bullet);
				world.playSoundAtEntity(player, soundGunshot, 1.0F, 1.0F);
				stack.damageItem(1, player);
				this.timerComplete = false;
			} 
			if(this.timerComplete = false)
			{
				world.playSoundAtEntity(player, soundReload, 1.0F, 1.0F);
				player.inventory.consumeInventoryItem(ammoID);
				this.initiateTimer(this.delay);
			}
		} 

		return stack;
	}

	public void initiateTimer(int delay) // The delay in seconds
	{
		timer.schedule(new TimerTask() 
		{		
			@Override
			public void run()
			{
				ItemGun.timerComplete = true;
				this.cancel();
			}
		}, delay * 1000);
	}
}