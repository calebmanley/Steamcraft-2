package com.steamcraft.mod.block;

import net.minecraft.block.Block;

import com.steamcraft.mod.lib.SC_BlockIDs;
import com.steamcraft.mod.lib.SC_CreativeTabs;
import com.steamcraft.mod.tileentity.TileEntityChemicalFurnace;
import com.steamcraft.mod.tileentity.TileEntityNukeFurnace;
import com.steamcraft.mod.tileentity.TileEntitySteamFurnace;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModMachines 
{
	public static Block steamOvenIdle;
	public static Block steamOvenActive;
	public static Block chemOvenIdle;
	public static Block chemOvenActive;
	public static Block nukeOvenIdle;
	public static Block nukeOvenActive;

	public static void initMachines()
	{
		steamOvenIdle = new BlockSteamFurnace(SC_BlockIDs.steamOvenIdleID, false).setCreativeTab(SC_CreativeTabs.tabSCBlocks);
		steamOvenActive = new BlockSteamFurnace(SC_BlockIDs.steamOvenActiveID, true);
		chemOvenIdle = new BlockChemicalFurnace(SC_BlockIDs.chemOvenIdleID, false).setCreativeTab(SC_CreativeTabs.tabSCBlocks);
		chemOvenActive = new BlockChemicalFurnace(SC_BlockIDs.chemOvenActiveID, true);
		nukeOvenIdle = new BlockNukeFurnace(SC_BlockIDs.nukeOvenIdleID, false).setCreativeTab(SC_CreativeTabs.tabSCBlocks);;
		nukeOvenActive = new BlockNukeFurnace(SC_BlockIDs.nukeOvenActiveID, true);
		
		registerMachines();
		initMachineNames();
		initMachineTileEntities();
	}

	public static void registerMachines()
	{
		GameRegistry.registerBlock(steamOvenIdle, "steamovenidle");
		GameRegistry.registerBlock(steamOvenActive, "steamovenactive");
		GameRegistry.registerBlock(chemOvenIdle, "chemovenidle");
		GameRegistry.registerBlock(chemOvenActive, "chemovenactive");
		GameRegistry.registerBlock(nukeOvenIdle, "nukeovenidle");
		GameRegistry.registerBlock(nukeOvenActive, "nukeovenactive");
	}

	public static void initMachineNames()
	{
		LanguageRegistry.addName(steamOvenIdle, "Steam Furnace");
		LanguageRegistry.addName(chemOvenIdle, "Chemical Furnace");
		LanguageRegistry.addName(nukeOvenIdle, "Nuke Furnace");
	}
	
	public static void initMachineTileEntities() 
	{
		GameRegistry.registerTileEntity(TileEntityNukeFurnace.class, "TileEntityNukeFurnace");
		GameRegistry.registerTileEntity(TileEntityChemicalFurnace.class, "TileEntityChemicalFurnace");
		GameRegistry.registerTileEntity(TileEntitySteamFurnace.class, "TileEntitySteamFurnace");
	}
}