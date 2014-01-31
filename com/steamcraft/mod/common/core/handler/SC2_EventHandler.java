/**
 * This class was created by <MrArcane111> or his SC2 development team. 
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MIT License.
 * (http://opensource.org/licenses/MIT)
 * 
 * Steamcraft 2 is based on the original Steamcraft created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 * 
 * File created @ [Jan 30, 2014, 5:33:43 PM]
 */
package com.steamcraft.mod.common.core.handler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

import com.steamcraft.mod.common.item.ModArmors;
import com.steamcraft.mod.common.item.ModItems;

/**
 * 
 * @author MrArcane111
 *
 */
public class SC2_EventHandler 
{
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