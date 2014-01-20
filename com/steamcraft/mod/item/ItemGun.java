package com.steamcraft.mod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.entity.EntityBullet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGun extends ItemSC
{
	private int damage; // damage in half-hearts
	private int reloadTick; 
	private int reloadMax; 
	private int ammoID;
	private int fireTick; 
	private int fireMax; 
	private String fireSound; 
	private String reloadSound;

	public ItemGun(int id, int damage, int delay, int ammoID, String fireSound, String reloadSound)
	{ 
		super(id); 
		this.damage = damage;
		this.fireMax = delay;
		this.fireTick = fireMax; 
		this.reloadMax = 5; 
		this.reloadTick = 0; 
		this.ammoID = ammoID; 
		this.fireSound = fireSound; 
		this.reloadSound = reloadSound; 
		this.setMaxStackSize(1);  
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
		if(player.inventory.hasItem(this.ammoID))
		{
			player.inventory.consumeInventoryItem(this.ammoID);

			if(this.fireTick == this.fireMax && this.fireMax != 0)
			{
				if(!world.isRemote)
				{
					world.spawnEntityInWorld(new EntityBullet(world, player, this.damage, 1));
				}

				world.playSoundAtEntity(player, this.fireSound, 1.0F, 1.0F);
				this.fireTick = 0;
			} else
			{
				++this.fireTick;
			}
			if(this.fireMax == 0)
			{
				if(!world.isRemote)
				{
					world.spawnEntityInWorld(new EntityBullet(world, player, this.damage, 1));
				}

				world.playSoundAtEntity(player, this.fireSound, 1.0F, 1.0F);
			}
			/*
			if(this.reloadTick == this.reloadMax)
			{
				this.reloadTick = 0;
				world.playSoundAtEntity(player, this.reloadSound, 1.0F, 1.0F);
				player.inventory.consumeInventoryItem(this.ammoID);
			} else
			{
				++this.reloadTick;
			}
			 */
		} 

		return stack;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount)
	{
		this.fireTick = this.fireMax;
	}
}