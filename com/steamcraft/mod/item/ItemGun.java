package com.steamcraft.mod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.entity.EntityBullet;

public class ItemGun extends ItemSC
{
	private int damage; 
	private int reloadTick; 
	private int reloadMax; 
	private int ammoID; 
	private int ammo; 
	private int fireTick; 
	private int fireMax; 
	private String soundGunshot; 
	private String soundReload; 

	public ItemGun(int id, int damage, int ammo, int clipid, int firedelay, String firesound, String reloadsound)
	{ 
		super(id); 
		this.damage = damage;
		this.fireMax = firedelay; 
		this.fireTick = fireMax;
		this.reloadMax = 5; 
		this.reloadTick = 0;
		this.ammo = ammo;
		this.ammoID = clipid;
		this.soundGunshot = firesound; 
		this.soundReload = reloadsound; 
		this.setMaxStackSize(1);
		this.setMaxDamage(ammo + 1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote && stack.getItemDamage() < ammo)
		{
			if(fireTick == fireMax && fireMax != 0)
			{
				//par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer, damage, 1));
				world.playSoundAtEntity(player, soundGunshot, 1F, 1F);
				stack.damageItem(1, player);
				fireTick = 0;

			} else
			{
				++fireTick;
			}
			if(fireMax == 0)
			{

				//par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer, damage, 1));
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