package com.steamcraft.mod.handler;

import java.io.File;

import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;

public final class SC_ConfigHandler 
{
	private static Configuration config;
	private static final String CATEGORY_POTIONS = "potions";
	private static final String CATEGORY_ENCHANTMENTS = "enchantments";
	private static ConfigCategory categoryPotions;
	private static ConfigCategory categoryEnchants;

	public static void loadConfig(File file) 
	{
		config = new Configuration(file);
		categoryPotions = new ConfigCategory(CATEGORY_POTIONS);
		categoryEnchants = new ConfigCategory(CATEGORY_ENCHANTMENTS);
		config.load();
		//LibBlockIDs.idDarkQuartz = loadBlock(LibBlockNames.DARK_QUARTZ, LibBlockIDs.idDarkQuartz);
		
		//LibItemIDs.idFocusDeflect = loadItem(LibItemNames.FOCUS_DEFLECT, LibItemIDs.idFocusDeflect);
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

	private static int loadEnchant(String label, int deafultID) 
	{
		return config.get(CATEGORY_ENCHANTMENTS, "id_enchant." + label, deafultID).getInt(deafultID);
	}
}