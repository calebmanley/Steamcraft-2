package com.steamcraft.mod.item;

import net.minecraft.item.Item;

import com.steamcraft.mod.lib.SC2_ItemIDs;
import com.steamcraft.mod.lib.SC2_Material;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModArmors 
{
	// Steam
	public static Item brassGoggles;
	public static Item aqualung;
	public static Item legBraces;
	public static Item rollerSkates;
	
	// Etherium
	public static Item helmetEtherium;
	public static Item plateEtherium;
	public static Item legsEtherium;
	public static Item bootsEtherium;
	
	// Obsidian
	public static Item helmetObsidian;
	public static Item plateObsidian;
	public static Item legsObsidian;
	public static Item bootsObsidian;
	
	// ==== Experimental! ==== //
	public static Item brassMonocle;
	public static Item brassWings;
	
	public static void initArmors()
	{
		// 0 = Helm, 1 = Chest, 2 = Leggings, 3 = Boots
		brassGoggles = new ItemSCArmor(SC2_ItemIDs.brassGogglesID, SC2_Material.STEAM_ARMOR, 0, 0).setUnlocalizedName("brassgoggles");
		aqualung = new ItemSCArmor(SC2_ItemIDs.aqualungID, SC2_Material.STEAM_ARMOR, 0, 1).setUnlocalizedName("aqualung");
		legBraces = new ItemSCArmor(SC2_ItemIDs.legBracesID, SC2_Material.STEAM_ARMOR, 0, 2).setUnlocalizedName("pneumaticbraces");
		rollerSkates = new ItemSCArmor(SC2_ItemIDs.rollerSkatesID, SC2_Material.STEAM_ARMOR, 0, 3).setUnlocalizedName("rollerskates");
		
		helmetEtherium = new ItemSCArmor(SC2_ItemIDs.helmetEtheriumID, SC2_Material.ETHERIUM_ARMOR, 0, 0).setUnlocalizedName("etheriumhelmet");
		plateEtherium = new ItemSCArmor(SC2_ItemIDs.plateEtheriumID, SC2_Material.ETHERIUM_ARMOR, 0, 1).setUnlocalizedName("etheriumplate");
		legsEtherium = new ItemSCArmor(SC2_ItemIDs.legsEtheriumID, SC2_Material.ETHERIUM_ARMOR, 0, 2).setUnlocalizedName("etheriumlegs");
		bootsEtherium = new ItemSCArmor(SC2_ItemIDs.bootsEtheriumID, SC2_Material.ETHERIUM_ARMOR, 0, 3).setUnlocalizedName("etheriumboots");
		
		helmetObsidian = new ItemSCArmor(SC2_ItemIDs.helmetObsidianID, SC2_Material.OBSIDIAN_ARMOR, 0, 0).setUnlocalizedName("obsidianhelmet");
		plateObsidian = new ItemSCArmor(SC2_ItemIDs.plateObsidianID, SC2_Material.OBSIDIAN_ARMOR, 0, 1).setUnlocalizedName("obsidianplate");
		legsObsidian = new ItemSCArmor(SC2_ItemIDs.legsObsidianID, SC2_Material.OBSIDIAN_ARMOR, 0, 2).setUnlocalizedName("obsidianlegs");
		bootsObsidian = new ItemSCArmor(SC2_ItemIDs.bootsObsidianID, SC2_Material.OBSIDIAN_ARMOR, 0, 3).setUnlocalizedName("obsidianboots");
		
		brassMonocle = new ItemBrassMonocle(SC2_ItemIDs.brassMonocleID, SC2_Material.STEAM_ARMOR, 0, 0);
		brassWings = new ItemBrassWings(SC2_ItemIDs.brassWingsID, SC2_Material.STEAM_ARMOR, 0, 1);
		
		initArmorNames();
	}

	public static void initArmorNames()
	{
		LanguageRegistry.addName(brassGoggles, "Brass Goggles");
		LanguageRegistry.addName(aqualung, "Aqualung");
		LanguageRegistry.addName(legBraces, "Pneumatic Leg Braces");
		LanguageRegistry.addName(rollerSkates, "Roller Skates");
		
		LanguageRegistry.addName(helmetEtherium, "Etherium Helmet");
		LanguageRegistry.addName(plateEtherium, "Etherium Chestplate");
		LanguageRegistry.addName(legsEtherium, "Etherium Leggings");
		LanguageRegistry.addName(bootsEtherium, "Etherium Boots");
		
		LanguageRegistry.addName(helmetObsidian, "Obsidian Helmet");
		LanguageRegistry.addName(plateObsidian, "Obsidian Chestplate");
		LanguageRegistry.addName(legsObsidian, "Obsidian Leggings");
		LanguageRegistry.addName(bootsObsidian, "Obsidian Boots");
		
		LanguageRegistry.addName(brassMonocle, "Brass Monocle");
		LanguageRegistry.addName(brassWings, "Brass Wings");
	}
}