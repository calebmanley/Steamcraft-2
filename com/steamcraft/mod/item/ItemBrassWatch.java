package com.steamcraft.mod.item;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

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
		list.add("On right-click, this item" + '\n'
				+ "will display the MC time\n"
				+ "and the real-world time");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		long mcTime = world.getTotalWorldTime();
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    	//System.out.println(sdf.format(cal.getTime()));
    	String message = "MC Time: " + mcTime + "; Real-World Time: " + sdf.format(cal.getTime());
    	player.sendChatToPlayer(ChatMessageComponent.createFromText(message).setColor(EnumChatFormatting.GOLD));
		return stack;
	}
}
