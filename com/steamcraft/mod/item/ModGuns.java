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
		flintlockMusket = new ItemFirearm(SC2_ItemIDs.flintlockMusketID, 100, musketRound, musketRound, 8, false).setUnlocalizedName("flintlockmusket");
		matchlockMusket = new ItemFirearm(SC2_ItemIDs.matchlockMusketID, 200, musketRound, musketRound, 6, false).setUnlocalizedName("matchlockmusket");
		percussionCapMusket = new ItemFirearm(SC2_ItemIDs.percussionCapMusketID, 50, percussionRound, musketRound, 10, false).setUnlocalizedName("percussionmusket");
		flintlockRifle = new ItemFirearm(SC2_ItemIDs.flintlockRifleID, 120, musketRound, musketRound, 10, true).setUnlocalizedName("flintlockrifle");
		matchlockRifle = new ItemFirearm(SC2_ItemIDs.matchlockRifleID, 240, musketRound, musketRound, 8, true).setUnlocalizedName("matchlockrifle");
		percussionCapRifle = new ItemFirearm(SC2_ItemIDs.percussionCapRifleID, 60, percussionRound, musketRound, 12, true).setUnlocalizedName("percussionrifle");
		
		initGunNames();
	}
	
	public static void initGunNames()
	{
		LanguageRegistry.addName(smoothBarrel, "");
		LanguageRegistry.addName(rifledBarrel, "");
		LanguageRegistry.addName(woodenStock, "");
		LanguageRegistry.addName(percussionLock, "");
		LanguageRegistry.addName(flintlockMusket, "");
		LanguageRegistry.addName(matchlockMusket, "");
		LanguageRegistry.addName(percussionCapMusket, "");
		LanguageRegistry.addName(flintlockRifle, "");
		LanguageRegistry.addName(matchlockRifle, "");
		LanguageRegistry.addName(percussionCapRifle, "");
		LanguageRegistry.addName(musketRound, "");
		LanguageRegistry.addName(percussionRound, "");
	}
}