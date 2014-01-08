package com.steamcraft.mod.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

import com.steamcraft.mod.lib.SC2_Info;

public class SC2_SoundEventHandler 
{	
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) 
	{
		event.manager.addSound(SC2_Info.MOD_ID.toLowerCase() + ":drill.ogg");
	}
}