package com.steamcraft.mod.item;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.src.ModLoader;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.lib.SC_ItemIDs;
import com.steamcraft.mod.lib.SC_Material;

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
	public static Item coreDrill;
	public static Item drillBase;
	public static Item pickaxeObsidian;
	public static Item shovelObsidian;
	public static Item axeObsidian;
	public static Item hoeObsidian;
	public static Item swordObsidian;
	public static Item drillObsidian;
	public static Item helmetObsidian;
	public static Item plateObsidian;
	public static Item legsObsidian;
	public static Item bootsObsidian;
	public static Item brassGoggles;
	public static Item aqualung;
	public static Item rollerSkates;
	public static Item legBraces;
	public static Item pickaxeEtherium;
	public static Item shovelEtherium;
	public static Item axeEtherium;
	public static Item hoeEtherium;
	public static Item swordEtherium;
	public static Item drillEtherium;
	public static Item helmetEtherium;
	public static Item plateEtherium;
	public static Item legsEtherium;
	public static Item bootsEtherium;
	public static Item swordSteam;
	public static Item shovelSteam;
	public static Item pickaxeSteam;
	public static Item drillSteam;
	public static Item axeSteam;
	public static Item hoeSteam;
	public static Item drillWood;
	public static Item drillStone;
	public static Item drillIron;
	public static Item drillDiamond;
	public static Item drillGold;
	public static Item chisel;
	public static Item spanner;
	public static Item smoothBarrel;
	public static Item rifledBarrel;
	public static Item woodenStock;
	public static Item percussionLock;
	public static Item flintlockMusket;
	public static Item matchlockMusket;
	public static Item percussionCapMusket;
	public static Item flintlockRifle;
	public static Item matchlockRifle;
	public static Item percussionCapRifle;
	public static Item musketRound;
	public static Item percussionRound;
	public static Item ironLamp;
	public static Item teaSeed;
	public static Item teaLeaves;
	public static Item coldKettle;
	public static Item hotKettle;
	public static Item emptyTeacup;
	public static Item fullTeacup;
	public static Item emptyKettle;
	
	public static void initItems()
	{
		etherium = new ItemSC(SC_ItemIDs.etheriumID).setUnlocalizedName("etherium").setTextureName("steamcraft:etherium");
		chemicSalt = new ItemSC(SC_ItemIDs.chemicSaltID).setUnlocalizedName("sulphur");
		//bornite = new ItemSC(SC_ItemIDs.borniteID).setUnlocalizedName("sulphur");
		obsidianSlate = new ItemSC(SC_ItemIDs.obsidianSlateID).setUnlocalizedName("obsidianslate");
		ingotBrass = new ItemSC(SC_ItemIDs.ingotBrassID).setUnlocalizedName("ingotbrass");
		ingotCastIron = new ItemSC(SC_ItemIDs.ingotCastIronID).setUnlocalizedName("ingotcastiron");
		lightBulb = new ItemSC(SC_ItemIDs.lightBulbID).setUnlocalizedName("lightbulb");
		phosphorus = new ItemSC(SC_ItemIDs.phosphorusID).setUnlocalizedName("phosphorus");
		uraniumOre = new ItemSC(SC_ItemIDs.uraniumStoneID).setUnlocalizedName("uraniumstone");
		uraniumPellet = new ItemSC(SC_ItemIDs.uraniumID).setUnlocalizedName("uraniumpellet");
		reactorCore = new ItemSC(SC_ItemIDs.reactorCoreID).setUnlocalizedName("reactorcore");
		coreDrill = new ItemCoreDrill(SC_ItemIDs.coreDrillID).setUnlocalizedName("coredrill");
		drillBase = new ItemSC(SC_ItemIDs.drillBaseID).setUnlocalizedName("coredrillbase");
		pickaxeObsidian = new ItemSCPickaxe(SC_ItemIDs.pickaxeObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidianpick");
		shovelObsidian = new ItemSCSpade(SC_ItemIDs.shovelObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidianspade");
		axeObsidian = new ItemSCAxe(SC_ItemIDs.axeObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidianaxe");
		hoeObsidian = new ItemSCHoe(SC_ItemIDs.hoeObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidianhoe");
		swordObsidian = new ItemSCSword(SC_ItemIDs.swordObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("swordObsidian");
		drillObsidian = new ItemSCDrill(SC_ItemIDs.drillObsidianID, SC_Material.OBSIDIAN_TOOL).setUnlocalizedName("obsidiandrill");
		// 0 = Helm, 1 = Chest, 2 = Leggings, 3 = Boots
		helmetObsidian = new ItemSCArmor(SC_ItemIDs.helmetObsidianID, SC_Material.OBSIDIAN_ARMOR, 0, 0).setUnlocalizedName("obsidianhelmet");
		plateObsidian = new ItemSCArmor(SC_ItemIDs.plateObsidianID, SC_Material.OBSIDIAN_ARMOR, 0, 1).setUnlocalizedName("obsidianplate");
		legsObsidian = new ItemSCArmor(SC_ItemIDs.legsObsidianID, SC_Material.OBSIDIAN_ARMOR, 0, 2).setUnlocalizedName("obsidianlegs");
		bootsObsidian = new ItemSCArmor(SC_ItemIDs.bootsObsidianID, SC_Material.OBSIDIAN_ARMOR, 0, 3).setUnlocalizedName("obsidianboots");
		brassGoggles = new ItemSCArmor(SC_ItemIDs.brassGogglesID, SC_Material.STEAM_ARMOR, 0, 0).setUnlocalizedName("brassgoggles");
		aqualung = new ItemSCArmor(SC_ItemIDs.aqualungID, SC_Material.STEAM_ARMOR, 0, 1).setUnlocalizedName("aqualung");
		legBraces = new ItemSCArmor(SC_ItemIDs.legBracesID, SC_Material.STEAM_ARMOR, 0, 2).setUnlocalizedName("pneumaticbraces");
		rollerSkates = new ItemSCArmor(SC_ItemIDs.rollerSkatesID, SC_Material.STEAM_ARMOR, 0, 3).setUnlocalizedName("rollerskates");
		pickaxeEtherium = new ItemSCPickaxe(SC_ItemIDs.pickaxeEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumpick");
		shovelEtherium = new ItemSCSpade(SC_ItemIDs.shovelEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumspade");
		axeEtherium = new ItemSCAxe(SC_ItemIDs.axeEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumaxe");
		hoeEtherium = new ItemSCHoe(SC_ItemIDs.hoeEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumhoe");
		swordEtherium = new ItemSCSword(SC_ItemIDs.swordEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumsword");
		drillEtherium = new ItemSCDrill(SC_ItemIDs.drillEtheriumID, SC_Material.ETHERIUM_TOOL).setUnlocalizedName("etheriumdrill");
		helmetEtherium = new ItemSCArmor(SC_ItemIDs.helmetEtheriumID, SC_Material.ETHERIUM_ARMOR, 0, 0).setUnlocalizedName("etheriumhelmet");
		plateEtherium = new ItemSCArmor(SC_ItemIDs.plateEtheriumID, SC_Material.ETHERIUM_ARMOR, 0, 1).setUnlocalizedName("etheriumplate");
		legsEtherium = new ItemSCArmor(SC_ItemIDs.legsEtheriumID, SC_Material.ETHERIUM_ARMOR, 0, 2).setUnlocalizedName("etheriumlegs");
		bootsEtherium = new ItemSCArmor(SC_ItemIDs.bootsEtheriumID, SC_Material.ETHERIUM_ARMOR, 0, 3).setUnlocalizedName("etheriumboots");
		pickaxeSteam = new ItemSCPickaxe(SC_ItemIDs.pickaxeSteamID, SC_Material.INSTANCE.STEAM_TOOL).setUnlocalizedName("steampick");
		shovelSteam = new ItemSCSpade(SC_ItemIDs.shovelSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamspade");
		axeSteam = new ItemSCAxe(SC_ItemIDs.axeSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamaxe");
		hoeSteam = new ItemSCHoe(SC_ItemIDs.hoeSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamhoe");
		swordSteam = new ItemSCSword(SC_ItemIDs.swordSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamsword");
		drillSteam = new ItemSCDrill(SC_ItemIDs.drillSteamID, SC_Material.STEAM_TOOL).setUnlocalizedName("steamdrill");
		drillWood = new ItemSCDrill(SC_ItemIDs.drillWoodID, EnumToolMaterial.WOOD).setUnlocalizedName("wooddrill");
		drillStone = new ItemSCDrill(SC_ItemIDs.drillStoneID, EnumToolMaterial.STONE).setUnlocalizedName("stonedrill");
		drillIron = new ItemSCDrill(SC_ItemIDs.drillIronID, EnumToolMaterial.IRON).setUnlocalizedName("irondrill");
		drillDiamond = new ItemSCDrill(SC_ItemIDs.drillDiamondID, EnumToolMaterial.EMERALD).setUnlocalizedName("diamonddrill");
		drillGold = new ItemSCDrill(SC_ItemIDs.drillGoldID, EnumToolMaterial.GOLD).setUnlocalizedName("golddrill");
		chisel = new ItemChisel(SC_ItemIDs.chiselID, 64).setUnlocalizedName("chisel"); // TODO: Change from crafting to right-click
		spanner = new ItemChisel(SC_ItemIDs.spannerID, 3).setUnlocalizedName("spanner");				
		musketRound = new ItemSC(SC_ItemIDs.musketRoundID).setUnlocalizedName("musketcartridge");
		percussionRound = new ItemSC(SC_ItemIDs.percussionRoundID).setUnlocalizedName("percussioncap");
		percussionLock = new ItemSC(SC_ItemIDs.percussionLockID).setUnlocalizedName("percussionlock");
		smoothBarrel = new ItemSC(SC_ItemIDs.smoothBarrelID).setUnlocalizedName("smoothbarrel");
		rifledBarrel = new ItemSC(SC_ItemIDs.rifledBarrelID).setUnlocalizedName("rifledbarrel");
		woodenStock = new ItemSC(SC_ItemIDs.woodenStockID).setUnlocalizedName("woodenstock");
		flintlockMusket = new ItemFirearm(SC_ItemIDs.flintlockMusketID, 100, musketRound, musketRound, 8, false).setUnlocalizedName("flintlockmusket");
		matchlockMusket = new ItemFirearm(SC_ItemIDs.matchlockMusketID, 200, musketRound, musketRound, 6, false).setUnlocalizedName("matchlockmusket");
		percussionCapMusket = new ItemFirearm(SC_ItemIDs.percussionCapMusketID, 50, percussionRound, musketRound, 10, false).setUnlocalizedName("percussionmusket");
		flintlockRifle = new ItemFirearm(SC_ItemIDs.flintlockRifleID, 120, musketRound, musketRound, 10, true).setUnlocalizedName("flintlockrifle");
		matchlockRifle = new ItemFirearm(SC_ItemIDs.matchlockRifleID, 240, musketRound, musketRound, 8, true).setUnlocalizedName("matchlockrifle");
		percussionCapRifle = new ItemFirearm(SC_ItemIDs.percussionCapRifleID, 60, percussionRound, musketRound, 12, true).setUnlocalizedName("percussionrifle");
		//ironLamp = new ItemElectricLamp(SC_ItemIDs.ironLampID, ModBlocks.ironLampIdle).setUnlocalizedName("ironlamp");
		teaSeed = new ItemSeeds(SC_ItemIDs.teaSeedID, ModBlocks.teaPlant.blockID, 0).setUnlocalizedName("teaseed"); 
		teaLeaves = new ItemSC(SC_ItemIDs.teaLeavesID).setUnlocalizedName("tealeaves");
		coldKettle = new ItemKettle(SC_ItemIDs.coldKettleID, 300).setUnlocalizedName("kettle");
		hotKettle = new ItemKettle(SC_ItemIDs.hotKettleID, 300).setUnlocalizedName("kettle");
		emptyKettle = new ItemKettle(SC_ItemIDs.emptyKettleID, 300).setUnlocalizedName("kettle");
		fullTeacup = new ItemTeacup(SC_ItemIDs.fullTeacupID, 4, 0.6F, false).setUnlocalizedName("teacupfull");
		emptyTeacup = new ItemTeacup(SC_ItemIDs.emptyTeacupID, 0, 0.0F, false).setUnlocalizedName("teacupempty");
		
		addNames();
	}
	
	public static void addNames()
	{
		
	}
}