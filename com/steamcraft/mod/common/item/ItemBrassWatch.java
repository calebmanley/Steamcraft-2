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
 * File created @ [Jan 30, 2014, 5:51:27 PM]
 */
package com.steamcraft.mod.common.item;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.steamcraft.mod.client.core.helper.SC2_ClientHelper;

/**
 * @author MrArcane111 & EntireCraft
 *
 */
public class ItemBrassWatch extends ItemSC2
{
	public ItemBrassWatch(int id)
	{
		super(id);
		this.maxStackSize = 1;
		this.setUnlocalizedName("clock");
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		if(!SC2_ClientHelper.isShiftKeyDown())
		{
			list.add(SC2_ClientHelper.shiftForInfo);
			return;
		}
		
		// I thought there was some shortcut using the backslash to carry to the next line...oh well
		list.add("On right-click, this item"); 
		list.add("will display the MC time");
		list.add("and the real-world time");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(!world.isRemote)
		{
			long mcTime = world.getTotalWorldTime();
			Calendar cal = Calendar.getInstance();
	    	cal.getTime();
	    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // hours and minutes, subtract twelve, ya pussy!
	    	// System.out.println(sdf.format(cal.getTime()));
	    	String message = "MC Time: " + mcTime + "; Real-World Time: " + sdf.format(cal.getTime());
	    	player.sendChatToPlayer(ChatMessageComponent.createFromText(message).setColor(EnumChatFormatting.GOLD));
		}
		
		return stack;
	}
}
