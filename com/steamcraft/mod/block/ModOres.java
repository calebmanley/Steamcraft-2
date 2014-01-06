package com.steamcraft.mod.block;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.mod.lib.SC_BlockIDs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModOres 
{
	public static Block oreBornite;
	public static Block oreBrimstone;
	public static Block orePhosphate;
	public static Block oreUranite;
	public static Block oreVolucite;
	
	public static void initOres()
	{
		oreBornite = new BlockSCOre(SC_BlockIDs.oreBorniteID).setHardness(3F).setResistance(5F).setUnlocalizedName("bornite");
		oreBrimstone = new BlockSCOre(SC_BlockIDs.oreBrimstoneID).setHardness(3F).setResistance(5F).setUnlocalizedName("brimstone");
		orePhosphate = new BlockSCOre(SC_BlockIDs.orePhosphateID).setHardness(2.5F).setResistance(5F).setLightValue(0.75F).setUnlocalizedName("phosphate");
		oreUranite = new BlockUraniteOre(SC_BlockIDs.oreUraniteID);
		oreVolucite = new BlockSCOre(SC_BlockIDs.oreVoluciteID).setHardness(50F).setResistance(6000000F).setUnlocalizedName("volucite");
		
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