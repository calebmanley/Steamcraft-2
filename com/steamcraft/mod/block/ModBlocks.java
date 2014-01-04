package com.steamcraft.mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.material.Material;

import com.steamcraft.mod.lib.SC_BlockIDs;
import com.steamcraft.mod.tileentity.TileEntityChemicalFurnace;
import com.steamcraft.mod.tileentity.TileEntityLamp;
import com.steamcraft.mod.tileentity.TileEntityNukeFurnace;
import com.steamcraft.mod.tileentity.TileEntitySteamFurnace;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	public static Block steamOvenIdle;
	public static Block steamOvenActive;
	public static Block chemOvenIdle;
	public static Block chemOvenActive;
	public static Block nukeOvenIdle;
	public static Block nukeOvenActive;
	public static Block oreBrimstone;
	public static Block oreBornite;
	public static Block orePhosphate;
	public static Block oreUranite;
	public static Block oreVolucite;
	public static Block blockCastIron;
	public static Block blockVolucite;
	public static Block blockBrass;
	public static Block blockUranium;
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
	public static Block ironLampIdle;
	public static Block ironLampActive;
	public static Block teaPlant;
	
	public static void initBlocks() // TODO: Check for SideOnly notations in ALL blocks
	{
		steamOvenIdle = new BlockSteamFurnace(SC_BlockIDs.steamOvenIdleID, false);
		steamOvenActive = new BlockSteamFurnace(SC_BlockIDs.steamOvenActiveID, true);
		chemOvenIdle = new BlockChemicalFurnace(SC_BlockIDs.chemOvenIdleID, false);
		chemOvenActive = new BlockChemicalFurnace(SC_BlockIDs.chemOvenActiveID, true);
		nukeOvenIdle = new BlockNukeFurnace(SC_BlockIDs.nukeOvenIdleID, false);
		nukeOvenActive = new BlockNukeFurnace(SC_BlockIDs.nukeOvenActiveID, true);
		oreBrimstone = new BlockOre(SC_BlockIDs.oreBrimstoneID).setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("brimstone");
		orePhosphate = new BlockOre(SC_BlockIDs.orePhosphateID).setHardness(2.5F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setLightValue(0.75F).setUnlocalizedName("phosphate");
		oreUranite = new BlockUraniteOre(SC_BlockIDs.oreUraniteID);
		oreBornite = new BlockOre(SC_BlockIDs.oreBorniteID).setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("bornite");
		oreVolucite = new BlockOre(SC_BlockIDs.oreVoluciteID).setHardness(50F).setResistance(6000000F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("volucite");
		blockCastIron = new BlockSC(SC_BlockIDs.blockCastIronID, Material.iron).setHardness(7F).setResistance(20F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("castironblock");
		blockVolucite = new BlockSC(SC_BlockIDs.blockVoluciteID, Material.rock).setHardness(50F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("voluciteblock");
		blockBrass = new BlockSC(SC_BlockIDs.blockBrassID, Material.iron).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("brassblock");
		blockUranium = new BlockUranium(SC_BlockIDs.blockUraniumID);
		decorIron = new BlockSC(SC_BlockIDs.decorIronID, Material.iron).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engriron");
		decorGold = new BlockSC(SC_BlockIDs.decorGoldID, Material.iron).setHardness(3F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrgold");
		decorDiamond = new BlockSC(SC_BlockIDs.decorDiamondID, Material.rock).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrdiamond");
		decorCastIron = new BlockSC(SC_BlockIDs.decorCastIronID, Material.iron).setHardness(7F).setResistance(20F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrcastiron");
		decorVolucite = new BlockSC(SC_BlockIDs.decorVoluciteID, Material.rock).setHardness(50F).setResistance(6000000F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrvolucite");
		decorBrass = new BlockSC(SC_BlockIDs.decorBrassID, Material.iron).setHardness(5F).setResistance(10F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("engrbrass");
		decorLapis = new BlockSC(SC_BlockIDs.decorLapisID, Material.rock).setHardness(3F).setResistance(5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("engrlapis");
		decorStone = new BlockSC(SC_BlockIDs.decorStoneID, Material.rock).setHardness(2F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("carvedstone");
		decorUranium = new BlockUranium(SC_BlockIDs.decorUraniumID).setHardness(10F).setResistance(6F).setLightValue(0.625F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("enguranium");
		gateCastIron = new BlockFenceGate(SC_BlockIDs.gateCastIronID).setHardness(7F).setResistance(20F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("castironblock");
		railingCastIron = new BlockFence(SC_BlockIDs.railingCastIronID, null, Material.iron).setHardness(7F).setResistance(20F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("castironblock");
		lampOn = new BlockLamp(SC_BlockIDs.lampOnID);
		lampOff = new BlockLamp(SC_BlockIDs.lampOffID);
		brassWood = new BlockBrassLog(SC_BlockIDs.woodBrassID);
		brassLeaves = new BlockSC(SC_BlockIDs.leavesLampID, Material.wood).setHardness(2F).setLightOpacity(1).setLightValue(0.9375F).setStepSound(Block.soundGlassFootstep).setUnlocalizedName("brassleaves");
		ironLampIdle = new BlockIronLamp(SC_BlockIDs.ironLampIdleID, com.steamcraft.mod.tileentity.TileEntityLamp.class);
		teaPlant = new BlockTeaPlant(SC_BlockIDs.teaPlantID);

		registerBlocks();
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(steamOvenIdle, "steamovenidle");
		GameRegistry.registerBlock(steamOvenActive, "steamovenactive");
		GameRegistry.registerBlock(oreBrimstone, "orebrimstone");
		GameRegistry.registerBlock(orePhosphate, "orephosphate");
		GameRegistry.registerBlock(oreUranite, "oreuranite");
		GameRegistry.registerBlock(oreBornite, "orebornite");
		GameRegistry.registerBlock(oreVolucite, "orevolucite");
		GameRegistry.registerBlock(chemOvenIdle, "chemovenidle");
		GameRegistry.registerBlock(chemOvenActive, "chemovenactive");
		GameRegistry.registerBlock(nukeOvenIdle, "nukeovenidle");
		GameRegistry.registerBlock(nukeOvenActive, "nukeovenactive");
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
		//GameRegistry.registerBlock(ironLampIdle, "ironlampidle");
		//GameRegistry.registerBlock(ironLampActive, "ironlampactive");
		GameRegistry.registerBlock(teaPlant, "teaplant");
	}
	
	public static void initTileEntities() 
	{
		GameRegistry.registerTileEntity(TileEntityNukeFurnace.class, "TileEntityNukeFurnace");
		GameRegistry.registerTileEntity(TileEntityChemicalFurnace.class, "TileEntityChemicalFurnace");
		GameRegistry.registerTileEntity(TileEntitySteamFurnace.class, "TileEntitySteamFurnace");
		GameRegistry.registerTileEntity(TileEntityLamp.class, "TileEntityLamp");
	}
}