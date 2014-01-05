package com.steamcraft.mod.handler;

import java.io.File;

import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;

public final class SC_ConfigHandler 
{
	private static Configuration config;

	public static void loadConfig(File file) 
	{
		config = new Configuration(file);
		config.load();
		// Items
		//LibItemIDs.idFocusDeflect = loadItem(LibItemNames.FOCUS_DEFLECT, LibItemIDs.idFocusDeflect);
		// Blocks
		//LibBlockIDs.idDarkQuartz = loadBlock(LibBlockNames.DARK_QUARTZ, LibBlockIDs.idDarkQuartz);
		config.save();
	}

	private static int loadItem(String label, int defaultID) 
	{
		return config.getItem("id_item." + label, defaultID).getInt(defaultID);
	}

	private static int loadBlock(String label, int defaultID) 
	{
		return config.getBlock("id_tile." + label, defaultID).getInt(defaultID);
	}
}