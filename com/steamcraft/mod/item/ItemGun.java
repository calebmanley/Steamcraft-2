package com.steamcraft.mod.item;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.entity.EntityBullet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGun extends ItemSC
{
	private int damage; 
	private int reloadTick; 
	private int reloadMax; 
	private int ammoID; 
	private int ammo; 
	private int fireTick; 
	private int fireMax; 
	private boolean isRifled;
	private String soundGunshot; 
	private String soundReload; 
	private Random random = new Random();

	public ItemGun(int id, int damage, int ammo, int ammoID, int delay, String soundGunshot, String soundReload, boolean rifled)
	{ 
		super(id); 
		this.damage = damage;
		this.fireMax = delay; 
		this.fireTick = fireMax;
		this.reloadMax = 5; 
		this.reloadTick = 0;
		this.ammo = ammo;
		this.ammoID = ammoID;
		this.soundGunshot = soundGunshot; 
		this.soundReload = soundReload; 
		this.isRifled = rifled;
		this.setMaxStackSize(1);
		this.setMaxDamage(ammo + 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		EntityBullet bullet = new EntityBullet(world, player, damage, 1);
		
		if(!world.isRemote && stack.getItemDamage() < ammo && !player.isInWater())
		{
			if(fireTick == fireMax && fireMax != 0)
			{
				world.spawnEntityInWorld(bullet);
				world.playSoundAtEntity(player, soundGunshot, 1F, 1F);
				stack.damageItem(1, player);
				fireTick = 0;

			} else
			{
				++fireTick;
			}
			if(fireMax == 0)
			{

				world.spawnEntityInWorld(bullet);
				world.playSoundAtEntity(player, soundGunshot, 1F, 1F);
				stack.damageItem(1, player);
			}
		} else if(!world.isRemote && player.inventory.hasItem(ammoID) && stack.getItemDamage() == ammo)
		{
			if(reloadTick == reloadMax)
			{
				reloadTick = 0;
				world.playSoundAtEntity(player, soundReload, 1F, 1F);
				player.inventory.consumeInventoryItem(ammoID);
				stack.setItemDamage(0);
			} else
			{
				++reloadTick;
			}
		}
		
		return stack;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount)
	{
		fireTick = fireMax;
	}
}