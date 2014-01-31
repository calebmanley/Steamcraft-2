package com.steamcraft.mod.common.item;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.steamcraft.mod.common.lib.SC2_Info;

public class ItemBrassWatch extends ItemSC
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
		if(!SC2_Info.isShiftKeyDown())
		{
			list.add(SC2_Info.shiftForInfo);
			return; // Probs don't need this, but it's cute
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
