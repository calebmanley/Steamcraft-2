package com.steamcraft.mod.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

import com.steamcraft.mod.lib.SC2_Info;

public class SC2_SoundEventHandler 
{	
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) 
	{
		event.manager.addSound("steamcraft:drill.ogg");
		event.manager.addSound("steamcraft:musket.ogg");
		event.manager.addSound("steamcraft:rifle.ogg");
		event.manager.addSound("steamcraft:reload.ogg");
	}
}