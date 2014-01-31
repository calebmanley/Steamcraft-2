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
 * File created @ [Jan 30, 2014, 5:19:11 PM]
 */
package com.steamcraft.mod.client.core.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.steamcraft.mod.client.gui.GuiChemicalFurnace;
import com.steamcraft.mod.client.gui.GuiNukeFurnace;
import com.steamcraft.mod.client.gui.GuiSteamFurnace;
import com.steamcraft.mod.client.lib.SC2_GuiIDs;
import com.steamcraft.mod.common.block.tile.TileEntityChemicalFurnace;
import com.steamcraft.mod.common.block.tile.TileEntityNukeFurnace;
import com.steamcraft.mod.common.block.tile.TileEntitySteamFurnace;
import com.steamcraft.mod.common.block.tile.container.ContainerChemicalFurnace;
import com.steamcraft.mod.common.block.tile.container.ContainerNukeFurnace;
import com.steamcraft.mod.common.block.tile.container.ContainerSteamFurnace;

import cpw.mods.fml.common.network.IGuiHandler;

/**
 * @author MrArcane111
 *
 */
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