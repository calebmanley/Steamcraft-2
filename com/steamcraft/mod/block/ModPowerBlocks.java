package com.steamcraft.mod.block;

import com.steamcraft.mod.lib.SC2_BlockIDs;

public class ModPowerBlocks 
{
	public static BlockCopperWire copperWire;
	
	public static void initPowerBlocks()
	{
		copperWire = (BlockCopperWire) new BlockCopperWire(SC2_BlockIDs.copperWireID);
		
		registerBlocks();
		addBlockNames();
	}
	
	public static void registerBlocks()
	{
		
	}
	
	public static void addBlockNames()
	{
		
	}
}	
