/**
 * This class was created by <MrArcane111> or his SC2 development team. 
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MIT License.
 * (http://opensource.org/licenses/MIT)
 * 
 * Steamcraft 2 is based on the original Steamcraft created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 * 
 * File created @ [Jan 30, 2014, 5:51:27 PM]
 */
package com.steamcraft.mod.common.block;

import net.minecraft.block.Block;

import com.steamcraft.mod.common.lib.SC2_BlockIDs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * @author MrArcane111
 *
 */
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
