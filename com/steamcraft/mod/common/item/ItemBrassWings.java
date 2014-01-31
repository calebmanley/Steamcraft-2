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
 * File created @ [Jan 30, 2014, 6:11:43 PM]
 */
package com.steamcraft.mod.common.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.steamcraft.mod.common.SC2;
import com.steamcraft.mod.common.lib.SC2_CreativeTabs;
import com.steamcraft.mod.common.lib.SC2_Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * @author MrArcane111
 *
 */
public class ItemBrassWings extends ItemSC2Armor
{
	public ItemBrassWings(int id, EnumArmorMaterial mat, int renderIndex, int armorType)
	{
		super(id, mat, renderIndex, armorType);
		mat = material;
		this.setMaxStackSize(1);
		this.setCreativeTab(SC2_CreativeTabs.tabSCItems);
		this.setUnlocalizedName("brasswings");
	}

	@Override
	@SideOnly(Side.CLIENT) // Thank-you Forge for this method. Otherwise, I would have to use TickHandlers...
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack stack)
	{
		if(Minecraft.getMinecraft().currentScreen == null && Keyboard.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindJump.keyCode))
		{
			if(player.motionY > 0.0D)
			{
				player.motionY += 0.08499999910593033D;
			} else
			{
				player.motionY += 0.11699999910593033D;
			}

			world.spawnParticle("smoke", player.posX, player.posY - 1.0D, player.posZ, 0.0D, 0.0D, 0.0D);
		}
		if(player.motionY < 0.0D)
		{
			player.motionY /= 1.149999976158142D;
		}
		if(!player.onGround)
		{
			player.motionX *= 1.0399999618530273D;
			player.motionZ *= 1.0399999618530273D;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = new ModelBiped();

		if(itemStack != null)
		{
			if(itemStack.getItem() instanceof ItemBrassWings)
			{
				int type = ((ItemArmor)itemStack.getItem()).armorType;

				if(type == 1 || type == 3)
				{
					armorModel = SC2.proxy.getWingsArmorModel(0);
				} else
				{
					armorModel = SC2.proxy.getWingsArmorModel(1);
				}
			}
			if(armorModel != null)
			{
				armorModel.bipedHead.showModel = armorSlot == 0;
				armorModel.bipedHeadwear.showModel = armorSlot == 0;
				armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
				armorModel.bipedRightArm.showModel = armorSlot == 1;
				armorModel.bipedLeftArm.showModel = armorSlot == 1;
				armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
				armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isRiding = entityLiving.isRiding();
				armorModel.isChild = entityLiving.isChild();
				armorModel.heldItemRight = entityLiving.getCurrentItemOrArmor(0) != null ? 1 :0;

				if(entityLiving instanceof EntityPlayer)
				{
					armorModel.aimedBow = ((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
				}

				return armorModel;
			}
		}

		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if(stack.itemID == ModArmors.brassWings.itemID)
		{
			return SC2_Info.SC2_PREFIX + "textures/armor/brasswings.png";
		} else
		{
			return null;
		}
	}
}