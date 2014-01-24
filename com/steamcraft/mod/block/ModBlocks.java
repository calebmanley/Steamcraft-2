package com.steamcraft.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;

import com.steamcraft.mod.lib.SC2_BlockIDs;
import com.steamcraft.mod.lib.SC2_CreativeTabs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks 
{
	public static Block blockCastIron;
	public static Block blockVolucite;
	public static Block blockBrass;
	public static Block blockUranium;
	public static Block blockSlateTile;
	
	public static BlockStairs stairsSlateTile;
	
	public static Block decorIron;
	public static Block decorGold;
	public static Block decorDiamond;
	public static Block decorCastIron;
	public static Block decorBrass;
	public static Block decorVolucite;
	public static Block decorLapis;
	public static Block decorStone;
	public static Block decorUranium;
	
	public static Block railingCastIron;
	public static Block gateCastIron;
	public static Block lampOn;
	public static Block lampOff;
	public static Block brassWood;
	public static Block brassLeaves;
	public static Block teaPlant;
	public static Block castIronLampIdle;
	public static Block castIronLampActive;
	
	public static void initBlocks()
	{
		blockCastIron = new BlockSC(SC2_BlockIDs.blockCastIronID, Material.iron).setHardness(7F).setResistance(20F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("castironblock");
		blockVolucite = new BlockSC(SC2_BlockIDs.blockVoluciteID, Material.rock).setHardness(50F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("voluciteblock");
		blockBrass = new BlockSC(SC2_BlockIDs.blockBrassID, Material.iron).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("brassblock");
		blockUranium = new BlockUranium(SC2_BlockIDs.blockUraniumID);
		blockSlateTile = new BlockSC(SC2_BlockIDs.blockSlateTileID, Material.rock).setUnlocalizedName("slatetiles");
		
		//stairsSlateTile = new (BlockStairs) BlockSC(SC2_BlockIDs.stairsSlateTileID, blockSlateTile, 0);
		
		decorIron = new BlockSC(SC2_BlockIDs.decorIronID, Material.iron).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engriron");
		decorGold = new BlockSC(SC2_BlockIDs.decorGoldID, Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrgold");
		decorDiamond = new BlockSC(SC2_BlockIDs.decorDiamondID, Material.rock).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrdiamond");
		decorCastIron = new BlockSC(SC2_BlockIDs.decorCastIronID, Material.iron).setHardness(7F).setResistance(20F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrcastiron");
		decorVolucite = new BlockSC(SC2_BlockIDs.decorVoluciteID, Material.rock).setHardness(50F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrvolucite");
		decorBrass = new BlockSC(SC2_BlockIDs.decorBrassID, Material.iron).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrbrass");
		decorLapis = new BlockSC(SC2_BlockIDs.decorLapisID, Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("engrlapis");
		decorStone = new BlockSC(SC2_BlockIDs.decorStoneID, Material.rock).setHardness(2F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("carvedstone");
		decorUranium = new BlockUranium(SC2_BlockIDs.decorUraniumID).setHardness(10F).setResistance(6F).setLightValue(0.625F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engruranium");
		
		gateCastIron = new BlockCastIronGate(SC2_BlockIDs.gateCastIronID, Material.iron);
		railingCastIron = new BlockFence(SC2_BlockIDs.railingCastIronID, "steamcraft:castironblock", Material.iron).setHardness(7F).setResistance(20F).setStepSound(Block.soundMetalFootstep).setCreativeTab(SC2_CreativeTabs.tabSCBlocks);//.setUnlocalizedName("castironblock");
		lampOn = new BlockLamp(SC2_BlockIDs.lampOnID, true).setUnlocalizedName("lampblockon").setCreativeTab(null);
		lampOff = new BlockLamp(SC2_BlockIDs.lampOffID, false).setUnlocalizedName("lampblockoff");
		brassWood = new BlockBrassLog(SC2_BlockIDs.woodBrassID);
		brassLeaves = new BlockSC(SC2_BlockIDs.leavesLampID, Material.wood).setHardness(2F).setLightOpacity(1).setLightValue(0.9375F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("brassleaves");
		teaPlant = new BlockTeaPlant(SC2_BlockIDs.teaPlantID);
		castIronLampIdle = new BlockCastIronLamp(SC2_BlockIDs.castIronLampIdleID, com.steamcraft.mod.tileentity.TileEntityLamp.class, false).setCreativeTab(SC2_CreativeTabs.tabSCBlocks);
		castIronLampActive = new BlockCastIronLamp(SC2_BlockIDs.castIronLampActiveID, com.steamcraft.mod.tileentity.TileEntityLamp.class, true);

		ModMachines.initMachines();
		ModOres.initOres();
		ModPowerBlocks.initPowerBlocks();
		registerBlocks();
		addNames();
	}
	
	public static void registerBlocks()
	{	
		GameRegistry.registerBlock(blockCastIron, "blockcastiron");
		GameRegistry.registerBlock(blockVolucite, "blockvolucite");
		GameRegistry.registerBlock(blockBrass, "blockbrass");
		GameRegistry.registerBlock(lampOn, "lampon");
		GameRegistry.registerBlock(lampOff, "lampoff");
		GameRegistry.registerBlock(brassWood, "woodbrass");
		GameRegistry.registerBlock(brassLeaves, "leaveslamp");
		GameRegistry.registerBlock(railingCastIron, "railingcastiron");
		GameRegistry.registerBlock(gateCastIron, "gatecastiron");
		GameRegistry.registerBlock(decorIron, "decoriron");
		GameRegistry.registerBlock(decorGold, "decorgold");
		GameRegistry.registerBlock(decorDiamond, "decordiamond");
		GameRegistry.registerBlock(decorCastIron, "decorcastiron");
		GameRegistry.registerBlock(decorVolucite, "decorvolucite");
		GameRegistry.registerBlock(decorBrass, "decorbrass");
		GameRegistry.registerBlock(decorLapis, "decorlapis");
		GameRegistry.registerBlock(decorStone, "decorstone");
		GameRegistry.registerBlock(blockUranium, "blockuranium");
		GameRegistry.registerBlock(decorUranium, "decoruranium");
		GameRegistry.registerBlock(teaPlant, "teaplant");
		GameRegistry.registerBlock(castIronLampIdle, "castironlampidle");
		GameRegistry.registerBlock(castIronLampActive, "castironlampactive");
		GameRegistry.registerBlock(blockSlateTile, "slatetiles");
	}
	
	public static void addNames()
	{
		
		LanguageRegistry.addName(blockCastIron, "Cast Iron Block");
		LanguageRegistry.addName(blockVolucite, "Volucite Block");
		LanguageRegistry.addName(blockBrass, "Brass Block");
		LanguageRegistry.addName(lampOff, "Lamp");
		LanguageRegistry.addName(brassWood, "Brasswood");
		LanguageRegistry.addName(brassLeaves, "Brassleaves");
		LanguageRegistry.addName(railingCastIron, "Cast Iron Railing");
		LanguageRegistry.addName(gateCastIron, "Cast Iron Gate");
		LanguageRegistry.addName(decorIron, "Carved Iron");
		LanguageRegistry.addName(decorGold, "Carved Gold");
		LanguageRegistry.addName(decorDiamond, "Carved Diamond");
		LanguageRegistry.addName(decorCastIron, "Carved Cast Iron");
		LanguageRegistry.addName(decorVolucite, "Carved Volucite");
		LanguageRegistry.addName(decorBrass, "Carved Brass");
		LanguageRegistry.addName(decorLapis, "Carved Lapis");
		LanguageRegistry.addName(decorStone, "Carved Stone");
		LanguageRegistry.addName(blockUranium, "Uranium Block");
		LanguageRegistry.addName(decorUranium, "Carved Uranium");
		LanguageRegistry.addName(teaPlant, "Tea Plant");
		LanguageRegistry.addName(blockSlateTile, "Obsidian Slate Tiles");
	}
}