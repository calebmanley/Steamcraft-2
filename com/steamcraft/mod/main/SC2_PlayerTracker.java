package com.steamcraft.mod.main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.IPlayerTracker;

public class SC2_PlayerTracker implements IPlayerTracker
{
	@Override
	public void onPlayerLogin(EntityPlayer player) 
	{
		String message = "Welcome back to Steamcraft, " + player.username + "!";
		player.sendChatToPlayer(ChatMessageComponent.createFromText(message).setColor(EnumChatFormatting.AQUA).setBold(true));
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {}
}