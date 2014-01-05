package com.steamcraft.mod.item;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.mod.entity.EntityBullet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFirearm extends ItemSC
{
	private Item Ammunition;
	private Item Ammunitionb;
	public int weaponPower;
	public boolean isWeaponRifled;
	
	public ItemFirearm(int id, int damage, Item ammo, Item ammob, int power, boolean rifled)
	{
		super(id);
		setMaxDamage(damage);
		Ammunition = ammo;
		Ammunitionb = ammob;
		isWeaponRifled = rifled;
		weaponPower = power;
		maxStackSize = 1;
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
		if(stack.getItemDamage() == 0 && player.isInsideOfMaterial(Material.water) == false)
		{
			spawnBullet(stack, world, player);
		}
		
		return stack;
	}

	public void spawnBullet(ItemStack stack, World world, EntityPlayer player)
	{
		world.playSoundAtEntity(player, "mob.ghast.fireball", 0.8F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
		world.playSoundAtEntity(player, "random.explode", 0.4F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.9F));
		stack.setItemDamage(stack.getMaxDamage() - 1);
		
		if(!world.isRemote)
		{
			world.spawnEntityInWorld(new EntityBullet(world));
		}
	}

	public int getFirePower()
	{
		return weaponPower;
	}

	public Item getAmmoA()
	{
		return Ammunition;
	}

	public Item getAmmoB()
	{
		return Ammunitionb;
	}

	public boolean getIsRifled()
	{
		return isWeaponRifled;
	}
}