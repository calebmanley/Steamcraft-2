package com.steamcraft.mod.item;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;

import com.steamcraft.mod.lib.SC_ItemIDs;
import com.steamcraft.mod.lib.SC_Material;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModTools 
{
	// Drills
	public static Item drillCore;
	public static Item drillBase;
	public static Item drillWood;
	public static Item drillStone;
	public static Item drillIron;
	public static Item drillDiamond;
	public static Item drillGold;
	public static Item drillSteam;
	public static Item drillEtherium;
	public static Item drillObsidian;
	
	// Steam
	public static Item pickaxeSteam;
	public static Item swordSteam;
	public static Item shovelSteam;
	public static Item axeSteam;
	public static Item hoeSteam;
	
	
	// Etherium
	public static Item pickaxeEtherium;
	public static Item swordEtherium;
	public static Item shovelEtherium;
	public static Item axeEtherium;
	public static Item hoeEtherium;
	
	// Obsidian
	public static Item pickaxeObsidian;
	public static Item swordObsidian;
	public static Item shovelObsidian;
	public static Item axeObsidian;
	public static Item hoeObsidian;
	
	// Other
	public static Item chisel;
	public static Item spanner;

	public static void initTools()
	{
		drillCore = new ItemCoreDrill(SC_ItemIDs.coreDrillID).setUnlocalizedName("coredrill");
		drillBase = new ItemSC(SC_ItemIDs.drillBaseID).setUnlocalizedName("coredrillbase");
		drillWood = new ItemSCDrill(SC_ItemIDs.drillWoodID, SC_Material.D_WOOD).setUnlocalizedName("wooddrill");
		drillStone = new ItemSCDrill(SC_ItemIDs.drillStoneID, SC_Material.D_STONE).setUnlocalizedName("stonedrill");
		drillIron = new ItemSCDrill(SC_ItemIDs.drillIronID, SC_Material.D_IRON).setUnlocalizedName("irondrill");
		drillDiamond = new ItemSCDrill(SC_ItemIDs.drillDiamondID, SC_Material.D_EMERALD).setUnlocalizedName("diamonddrill");
		drillGold = new ItemSCDrill(SC_ItemIDs.drillGoldID, SC_Material.D_GOLD).setUnlocalizedName("golddrill");
		drillSteam = new ItemSCDrill(SC_ItemIDs.drillSteamID, SC_Material.D_STEAM).setUnlocalizedName("steamdrill");
		drillEtherium = new ItemSCDrill(SC_ItemIDs.drillEtheriumID, SC_Material.D_ETHERIUM).setUnlocalizedName("etheriumdrill");
		drillObsidian = new ItemSCDrill(SC_ItemIDs.drillObsidianID, SC_Material.D_OBSIDIAN).setUnlocalizedName("obsidiandrill");
		
		pickaxeSteam = new ItemSCPickaxe(SC_ItemIDs.pickaxeSteamID, SC_Material.INSTANCE.STEAM_TOOL).setUnlocalizedName("steampick");
		swordSteam = new ItemSCSword(SC_ItemIDs.swordSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamsword");
		shovelSteam = new ItemSCSpade(SC_ItemIDs.shovelSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamspade");
		axeSteam = new ItemSCAxe(SC_ItemIDs.axeSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamaxe");
		hoeSteam = new ItemSCHoe(SC_ItemIDs.hoeSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamhoe");
		
		pickaxeEtherium = new ItemSCPickaxe(SC_ItemIDs.pickaxeEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumpick");
		swordEtherium = new ItemSCSword(SC_ItemIDs.swordEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumsword");
		shovelEtherium = new ItemSCSpade(SC_ItemIDs.shovelEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumspade");
		axeEtherium = new ItemSCAxe(SC_ItemIDs.axeEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumaxe");
		hoeEtherium = new ItemSCHoe(SC_ItemIDs.hoeEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumhoe");
		
		pickaxeObsidian = new ItemSCPickaxe(SC_ItemIDs.pickaxeObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidianpick");
		swordObsidian = new ItemSCSword(SC_ItemIDs.swordObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidiansword");
		shovelObsidian = new ItemSCSpade(SC_ItemIDs.shovelObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidianspade");
		axeObsidian = new ItemSCAxe(SC_ItemIDs.axeObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidianaxe");
		hoeObsidian = new ItemSCHoe(SC_ItemIDs.hoeObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidianhoe");
		
		chisel = new ItemChisel(SC_ItemIDs.chiselID, 64).setUnlocalizedName("chisel"); // TODO: Change from crafting to right-click
		spanner = new ItemChisel(SC_ItemIDs.spannerID, 3).setUnlocalizedName("spanner");	
		
		initToolNames();
	}

	public static void initToolNames()
	{
		LanguageRegistry.addName(drillCore, "Drill Core");
		LanguageRegistry.addName(drillBase, "Drill Base");
		LanguageRegistry.addName(drillWood, "Wooden Drill");
		LanguageRegistry.addName(drillStone, "Stone Drill");
		LanguageRegistry.addName(drillIron, "Iron Drill");
		LanguageRegistry.addName(drillDiamond, "Diamond Drill");
		LanguageRegistry.addName(drillGold, "Golden Drill");
		LanguageRegistry.addName(drillSteam, "Steam-Powered Drill");
		LanguageRegistry.addName(drillEtherium, "Etherium Drill");
		LanguageRegistry.addName(drillObsidian, "Obsidian Drill");
		
		LanguageRegistry.addName(pickaxeSteam, "Steam-Powered Pickaxe");
		LanguageRegistry.addName(swordSteam, "Stean-Powered Sword");
		LanguageRegistry.addName(axeSteam, "Steam-Powered Axe");
		LanguageRegistry.addName(hoeSteam, "Steam-Powered Hoe");
		
		LanguageRegistry.addName(pickaxeEtherium, "Etherium Pickaxe");
		LanguageRegistry.addName(swordEtherium, "Etherium Sword");
		LanguageRegistry.addName(axeEtherium, "Etherium Axe");
		LanguageRegistry.addName(hoeEtherium, "Etherium Hoe");
		
		LanguageRegistry.addName(pickaxeObsidian, "Obsidian Pickaxe");
		LanguageRegistry.addName(swordObsidian, "Obsidian Sword");
		LanguageRegistry.addName(axeObsidian, "Obsidian Axe");
		LanguageRegistry.addName(hoeObsidian, "Obsidian Hoe");
		
		LanguageRegistry.addName(chisel, "Chisel");
		LanguageRegistry.addName(spanner, "Spanner");
	}
}