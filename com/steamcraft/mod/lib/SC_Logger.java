package com.steamcraft.mod.lib;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class SC_Logger 
{
	private static Logger logger = Logger.getLogger("SteamCraft");

	public static void init()
	{
		logger.setParent(FMLLog.getLogger());
	}

	public static void log(Level level, String message)
	{
		logger.log(level, message);
	}
}