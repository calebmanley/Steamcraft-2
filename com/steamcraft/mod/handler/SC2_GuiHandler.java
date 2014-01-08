package com.steamcraft.mod.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.steamcraft.mod.gui.GuiChemicalFurnace;
import com.steamcraft.mod.gui.GuiNukeFurnace;
import com.steamcraft.mod.gui.GuiSteamFurnace;
import com.steamcraft.mod.inventory.ContainerChemicalFurnace;
import com.steamcraft.mod.inventory.ContainerNukeFurnace;
import com.steamcraft.mod.inventory.ContainerSteamFurnace;
import com.steamcraft.mod.lib.SC2_GuiIDs;
import com.steamcraft.mod.tileentity.TileEntityChemicalFurnace;
import com.steamcraft.mod.tileentity.TileEntityNukeFurnace;
import com.steamcraft.mod.tileentity.TileEntitySteamFurnace;

import cpw.mods.fml.common.network.IGuiHandler;

public class SC2_GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);

		switch(id)
		{
		case SC2_GuiIDs.GUI_ID_NukeOven:
			return new ContainerNukeFurnace(player.inventory, (TileEntityNukeFurnace) tile);

		case SC2_GuiIDs.GUI_ID_ChemicalOven:
			return new ContainerChemicalFurnace(player.inventory, (TileEntityChemicalFurnace) tile);

		case SC2_GuiIDs.GUI_ID_SteamOven:
			return new ContainerSteamFurnace(player.inventory, (TileEntitySteamFurnace) tile);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);

		switch(id)
		{
		case SC2_GuiIDs.GUI_ID_NukeOven:
			return new GuiNukeFurnace(player.inventory, (TileEntityNukeFurnace) tile);

		case SC2_GuiIDs.GUI_ID_ChemicalOven:
			return new GuiChemicalFurnace(player.inventory, (TileEntityChemicalFurnace) tile);

		case SC2_GuiIDs.GUI_ID_SteamOven:
			return new GuiSteamFurnace(player.inventory, (TileEntitySteamFurnace) tile);
		}
		
		return null;
	}
}