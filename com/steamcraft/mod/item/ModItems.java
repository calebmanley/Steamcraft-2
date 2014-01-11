package com.steamcraft.mod.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.lib.SC2_ItemIDs;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems 
{
	public static Item etherium;
	public static Item chemicSalt;
	public static Item bornite;
	public static Item obsidianSlate;
	public static Item ingotBrass;
	public static Item ingotCastIron;
	public static Item lightBulb;
	public static Item phosphorus;
	public static Item uraniumOre;
	public static Item uraniumPellet;
	public static Item reactorCore;
	public static Item teaSeed;
	public static Item teaLeaves;
	public static Item coldKettle;
	public static Item hotKettle;
	public static Item emptyTeacup;
	public static Item fullTeacup;
	public static Item emptyKettle;
	
	public static void initItems()
	{
		etherium = new ItemSC(SC2_ItemIDs.etheriumID).setUnlocalizedName("etherium");
		chemicSalt = new ItemSC(SC2_ItemIDs.chemicSaltID).setUnlocalizedName("sulphur");
		bornite = new ItemSC(SC2_ItemIDs.borniteID).setUnlocalizedName("copper");
		obsidianSlate = new ItemSC(SC2_ItemIDs.obsidianSlateID).setUnlocalizedName("obsidianslate");
		ingotBrass = new ItemSC(SC2_ItemIDs.ingotBrassID).setUnlocalizedName("ingotbrass");
		ingotCastIron = new ItemSC(SC2_ItemIDs.ingotCastIronID).setUnlocalizedName("ingotcastiron");
		lightBulb = new ItemSC(SC2_ItemIDs.lightBulbID).setUnlocalizedName("lightbulb");
		phosphorus = new ItemSC(SC2_ItemIDs.phosphorusID).setUnlocalizedName("phosphorus");
		uraniumOre = new ItemSC(SC2_ItemIDs.uraniumStoneID).setUnlocalizedName("uraniumstone");
		uraniumPellet = new ItemSC(SC2_ItemIDs.uraniumID).setUnlocalizedName("uraniumpellet");
		reactorCore = new ItemSC(SC2_ItemIDs.reactorCoreID).setUnlocalizedName("reactorcore");
		teaSeed = new ItemTeaSeeds(SC2_ItemIDs.teaSeedID, ModBlocks.teaPlant.blockID, Block.tilledField.blockID).setUnlocalizedName("teaseed"); 
		teaLeaves = new ItemSC(SC2_ItemIDs.teaLeavesID).setUnlocalizedName("tealeaves");
		//coldKettle = new ItemKettle(SC_ItemIDs.coldKettleID, 300).setUnlocalizedName("kettle");
		//hotKettle = new ItemKettle(SC_ItemIDs.hotKettleID, 300).setUnlocalizedName("kettle");
		//emptyKettle = new ItemKettle(SC_ItemIDs.emptyKettleID, 300).setUnlocalizedName("kettle");
		//fullTeacup = new ItemTeacup(SC_ItemIDs.fullTeacupID, 4, 0.6F, false).setUnlocalizedName("teacupfull");
		//emptyTeacup = new ItemTeacup(SC_ItemIDs.emptyTeacupID, 0, 0.0F, false).setUnlocalizedName("teacupempty");
		
		initNames();
		ModTools.initTools();
		ModArmors.initArmors();
		ModGuns.initGuns();
	}
	
	public static void initNames()
	{
		LanguageRegistry.addName(etherium, "Etherium Crystal");
		LanguageRegistry.addName(chemicSalt, "Sulfur");
		LanguageRegistry.addName(bornite, "Purified Copper");
		LanguageRegistry.addName(obsidianSlate, "Obsidian Slate");
		LanguageRegistry.addName(ingotBrass, "Brass Ingot");
		LanguageRegistry.addName(ingotCastIron, "Cast Iron Ingot");
		LanguageRegistry.addName(lightBulb, "Lightbulb");
		LanguageRegistry.addName(phosphorus, "Phosphorus");
		LanguageRegistry.addName(uraniumOre, "Uranium");
		LanguageRegistry.addName(uraniumPellet, "Uranium Pellets");
		LanguageRegistry.addName(reactorCore, "Reactor Core");
		LanguageRegistry.addName(teaSeed, "Tea Seeds");
		LanguageRegistry.addName(teaLeaves, "Tea Leaves");
	}
}