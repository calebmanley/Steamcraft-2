package com.steamcraft.mod.client.core.handler;

import java.util.logging.Level;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

import com.steamcraft.mod.common.lib.SC2_Info;
import com.steamcraft.mod.common.network.SC2_Logger;

public class SC2_SoundEventHandler 
{	
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) 
	{
		try
		{
			event.manager.addSound("steamcraft:drill.ogg");
			event.manager.addSound("steamcraft:musket.ogg");
			event.manager.addSound("steamcraft:rifle.ogg");
			event.manager.addSound("steamcraft:reload.ogg");
			event.manager.addSound("steamcraft:armor.ogg");
			event.manager.addSound("steamcraft:hitflesh.ogg");
			event.manager.addSound("steamcraft:hitblock.ogg");
			event.manager.addSound("steamcraft:raygun.ogg");
		} catch(Exception e)
		{
			SC2_Logger.log(Level.SEVERE, "Failed to register one or more sounds!");
		}
	}
}