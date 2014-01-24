package com.steamcraft.mod.handler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import com.steamcraft.mod.block.BlockLightningRod;
import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.item.ModArmors;
import com.steamcraft.mod.item.ModItems;

public class SC2_EventHandler 
{
	public static EntityArrow arrow;
	
	@ForgeSubscribe
	public void onHarvestDrops(HarvestDropsEvent event)
	{
		if(event.block.blockID == Block.tallGrass.blockID)
		{
			event.drops.add(new ItemStack(ModItems.teaSeed, 1));
			event.dropChance = 0.16F; // Should be 16% chance for tea seeds to drop
		}
	}

	@ForgeSubscribe
	public void updatePlayer(LivingEvent.LivingUpdateEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;

			ItemStack chestSlot = player.inventory.armorItemInSlot(2); // le chest

			if(chestSlot != null)
			{
				if(chestSlot.itemID == ModArmors.aqualung.itemID)
				{
					if(player.isInsideOfMaterial(Material.water) && player.getAir() <= 0)
					{	
						player.setAir(300);
						chestSlot.damageItem(1, player);
					}
				}
			}

			ItemStack bootsSlot = player.inventory.armorItemInSlot(0); // le boots

			if(bootsSlot != null)
			{
				if(!player.isInWater() && player.onGround && bootsSlot.itemID == ModArmors.rollerSkates.itemID)
				{	
					player.moveEntityWithHeading(player.moveStrafing, player.moveForward * 0.8F);
					player.jumpMovementFactor = 0.03F;
					player.stepHeight = 0.0F;
				}
			} else if(bootsSlot == null || bootsSlot.itemID != ModArmors.rollerSkates.itemID)
			{
				player.stepHeight = 0.5F;
			}
		}
	}
}