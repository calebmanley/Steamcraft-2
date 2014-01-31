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
 * File created @ [Jan 30, 2014, 6:11:43 PM]
 */
package com.steamcraft.mod.common.block;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.mod.common.lib.SC2_BlockIDs;
import com.steamcraft.mod.common.lib.SC2_BlockNames;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * 
 * @author MrArcane111
 *
 */
public class ModOres 
{
	public static Block oreBornite;
	public static Block oreBrimstone;
	public static Block orePhosphate;
	public static Block oreUranite;
	public static Block oreVolucite;
	
	public static void initOres()
	{
		oreBornite = new BlockSCOre(SC2_BlockIDs.oreBorniteID, "bornite").setUnlocalizedName(SC2_BlockNames.ORE_BORNITE);
		oreBrimstone = new BlockSCOre(SC2_BlockIDs.oreBrimstoneID, "brimstone").setUnlocalizedName(SC2_BlockNames.ORE_BRIMSTONE);
		orePhosphate = new BlockSCOre(SC2_BlockIDs.orePhosphateID, "phosphate").setUnlocalizedName(SC2_BlockNames.ORE_PHOSPHATE);
		oreUranite = new BlockUraniteOre(SC2_BlockIDs.oreUraniteID).setUnlocalizedName(SC2_BlockNames.ORE_URANITE);
		oreVolucite = new BlockSCOre(SC2_BlockIDs.oreVoluciteID, "volucite").setUnlocalizedName(SC2_BlockNames.ORE_VOLUCITE);
		
		registerOres();
		initOreNames();
		initOreHarvestLevels();
		registerOreDictionary();
	}
	
	public static void registerOres()
	{
		GameRegistry.registerBlock(oreBornite, "orebornite");
		GameRegistry.registerBlock(oreBrimstone, "orebrimstone");
		GameRegistry.registerBlock(orePhosphate, "orephosphate");
		GameRegistry.registerBlock(oreUranite, "oreuranite");
		GameRegistry.registerBlock(oreVolucite, "orevolucite");
	}
	
	public static void initOreNames()
	{
		LanguageRegistry.addName(oreBornite, "Bornite Ore");
		LanguageRegistry.addName(oreBrimstone, "Brimstone Ore");
		LanguageRegistry.addName(orePhosphate, "Phosphate Ore");
		LanguageRegistry.addName(oreUranite, "Uranite Ore");
		LanguageRegistry.addName(oreVolucite, "Volucite Ore");
	}
	
	public static void initOreHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(oreBornite, 0, "pickaxe", 1); 
		MinecraftForge.setBlockHarvestLevel(oreBrimstone, 0, "pickaxe", 1); 
		MinecraftForge.setBlockHarvestLevel(orePhosphate, 0, "pickaxe", 2); 
		MinecraftForge.setBlockHarvestLevel(oreUranite, 0, "pickaxe", 2); 
		MinecraftForge.setBlockHarvestLevel(oreVolucite, 0, "pickaxe", 4);
	}
	
	public static void registerOreDictionary()
	{
		// TODO: 
	}
}