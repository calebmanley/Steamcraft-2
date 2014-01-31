package com.steamcraft.mod.common.block;

import net.minecraft.block.Block;

import com.steamcraft.mod.common.lib.SC2_BlockIDs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModPowerBlocks 
{
	public static BlockCopperWire copperWire;
	public static Block lightningRod;
	
	public static void initPowerBlocks()
	{
		copperWire = (BlockCopperWire) new BlockCopperWire(SC2_BlockIDs.copperWireID);
		lightningRod = new BlockLightningRod(SC2_BlockIDs.lightningRodID);
		
		registerBlocks();
		addBlockNames();
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(copperWire, "copperwire");
		GameRegistry.registerBlock(lightningRod, "lightningrod");
	}
	
	public static void addBlockNames()
	{
		LanguageRegistry.addName(copperWire, "Copper Wire");
		LanguageRegistry.addName(lightningRod, "Lightning Rod");
	}
}	
