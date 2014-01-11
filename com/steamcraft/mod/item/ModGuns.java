package com.steamcraft.mod.item;

import net.minecraft.item.Item;

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

	public static void initGuns()
	{
		musketRound = new ItemSC(SC2_ItemIDs.musketRoundID).setUnlocalizedName("musketcartridge");
		percussionRound = new ItemSC(SC2_ItemIDs.percussionRoundID).setUnlocalizedName("percussioncap");
		percussionLock = new ItemSC(SC2_ItemIDs.percussionLockID).setUnlocalizedName("percussionlock");
		smoothBarrel = new ItemSC(SC2_ItemIDs.smoothBarrelID).setUnlocalizedName("smoothbarrel");
		rifledBarrel = new ItemSC(SC2_ItemIDs.rifledBarrelID).setUnlocalizedName("rifledbarrel");
		woodenStock = new ItemSC(SC2_ItemIDs.woodenStockID).setUnlocalizedName("woodenstock");
		// ID, damage, ammo, ammo ID, delay, gun-shot sound, reload sound, is rifled
		flintlockMusket = new ItemGun(SC2_ItemIDs.flintlockMusketID, 5, 10, musketRound.itemID, 0, "steamcraft:musket", "steamcraft:reload", false).setUnlocalizedName("flintlockmusket");
		matchlockMusket = new ItemGun(SC2_ItemIDs.matchlockMusketID, 6, 10, musketRound.itemID, 0, "steamcraft:musket", "steamcraft:reload", false).setUnlocalizedName("matchlockmusket");
		percussionCapMusket = new ItemGun(SC2_ItemIDs.percussionCapMusketID, 50, 15, percussionRound.itemID, 0, "steamcraft:musket", "steamcraft:reload", false).setUnlocalizedName("percussionmusket");
		flintlockRifle = new ItemGun(SC2_ItemIDs.flintlockRifleID, 120, 10, musketRound.itemID, 10, "steamcraft:rifle", "steamcraft:reload", true).setUnlocalizedName("flintlockrifle");
		matchlockRifle = new ItemFirearm(SC2_ItemIDs.matchlockRifleID, 240, musketRound, musketRound, 8, true).setUnlocalizedName("matchlockrifle");
		percussionCapRifle = new ItemFirearm(SC2_ItemIDs.percussionCapRifleID, 60, percussionRound, musketRound, 12, true).setUnlocalizedName("percussionrifle");
		
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
		LanguageRegistry.addName(percussionRound, "Percussion-Cap Round");
	}
}