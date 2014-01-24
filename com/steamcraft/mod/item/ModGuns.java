package com.steamcraft.mod.item;

import net.minecraft.item.Item;

import com.steamcraft.mod.lib.SC2_Info;
import com.steamcraft.mod.lib.SC2_ItemIDs;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModGuns 
{
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
	public static Item rifleRound;
	public static Item rayGun;

	public static void initGuns()
	{
		musketRound = new ItemSC(SC2_ItemIDs.musketRoundID).setUnlocalizedName("musketcartridge");
		rifleRound = new ItemSC(SC2_ItemIDs.rifleRoundID).setUnlocalizedName("rifleround");
		percussionRound = new ItemSC(SC2_ItemIDs.percussionRoundID).setUnlocalizedName("percussioncap");
		percussionLock = new ItemSC(SC2_ItemIDs.percussionLockID).setUnlocalizedName("percussionlock");
		smoothBarrel = new ItemSC(SC2_ItemIDs.smoothBarrelID).setUnlocalizedName("smoothbarrel");
		rifledBarrel = new ItemSC(SC2_ItemIDs.rifledBarrelID).setUnlocalizedName("rifledbarrel");
		woodenStock = new ItemSC(SC2_ItemIDs.woodenStockID).setUnlocalizedName("woodenstock");
		// int id, int damage, int ammoID, int delay, String fireSound, String reloadSound
		flintlockMusket = new ItemGun(SC2_ItemIDs.flintlockMusketID, 6, 3, musketRound.itemID, "steamcraft:musket", "steamcraft:reload").setUnlocalizedName("flintlockmusket");
		matchlockMusket = new ItemGun(SC2_ItemIDs.matchlockMusketID, 7, 2, musketRound.itemID, "steamcraft:musket", "steamcraft:reload").setUnlocalizedName("matchlockmusket");
		percussionCapMusket = new ItemGun(SC2_ItemIDs.percussionCapMusketID, 8, 1, percussionRound.itemID, "steamcraft:musket", "steamcraft:reload").setUnlocalizedName("percussionmusket");
		flintlockRifle = new ItemGun(SC2_ItemIDs.flintlockRifleID, 9, 3, rifleRound.itemID, "steamcraft:rifle", "steamcraft:reload").setUnlocalizedName("flintlockrifle");
		matchlockRifle = new ItemGun(SC2_ItemIDs.matchlockRifleID, 10, 2, rifleRound.itemID, "steamcraft:rifle", "steamcraft:reload").setUnlocalizedName("matchlockrifle");
		percussionCapRifle = new ItemGun(SC2_ItemIDs.percussionCapRifleID, 11, 1, percussionRound.itemID, "steamcraft:rifle", "steamcraft:rifle").setUnlocalizedName("percussionrifle");
		
		// Highly experimental!!
		rayGun = new ItemRayGun(SC2_ItemIDs.rayGunID, SC2_Info.MOD_ID.toLowerCase() + ":raygun");
		
		initGunNames();
	}
	
	public static void initGunNames()
	{
		LanguageRegistry.addName(smoothBarrel, "Smooth Barrel");
		LanguageRegistry.addName(rifledBarrel, "Rifled Barrel");
		LanguageRegistry.addName(woodenStock, "Wooden Stock");
		LanguageRegistry.addName(percussionLock, "Percussion Lock");
		LanguageRegistry.addName(flintlockMusket, "Flintlock Musket");
		LanguageRegistry.addName(matchlockMusket, "Matchlock Musket");
		LanguageRegistry.addName(percussionCapMusket, "Percussion-Cap Musket");
		LanguageRegistry.addName(flintlockRifle, "Flintlock Rifle");
		LanguageRegistry.addName(matchlockRifle, "Matchlock Rifle");
		LanguageRegistry.addName(percussionCapRifle, "Percussion-Cap Rifle");
		LanguageRegistry.addName(musketRound, "Musket Round");
		LanguageRegistry.addName(percussionRound, "Percussion Cap");
		LanguageRegistry.addName(rifleRound, "Rifle Round");
	}
}