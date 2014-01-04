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
import com.steamcraft.mod.tileentity.TileEntityChemicalFurnace;
import com.steamcraft.mod.tileentity.TileEntityNukeFurnace;
import com.steamcraft.mod.tileentity.TileEntitySteamFurnace;

import cpw.mods.fml.common.network.IGuiHandler;

public class SC_GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		switch(id)
		{
		case 0:
			if(entity != null && entity instanceof TileEntityNukeFurnace) 
			{
				return new ContainerNukeFurnace(player.inventory, (TileEntityNukeFurnace) entity);
			} else 
			{
				return null;
			}
		case 1:
			if(entity != null && entity instanceof TileEntityChemicalFurnace) 
			{
				return new ContainerChemicalFurnace(player.inventory, (TileEntityChemicalFurnace) entity);
			} else 
			{
				return null;
			}
		case 2:
			if(entity != null && entity instanceof TileEntitySteamFurnace) 
			{
				return new ContainerSteamFurnace(player.inventory, (TileEntitySteamFurnace) entity);
			} else 
			{
				return null;
			}
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		switch(id)
		{
		case 0:
			if(entity != null && entity instanceof TileEntityNukeFurnace) 
			{
				return new GuiNukeFurnace(player.inventory, (TileEntityNukeFurnace) entity);
			} else 
			{
				return null;
			}
		case 1:
			if(entity != null && entity instanceof TileEntityNukeFurnace) 
			{
				return new GuiChemicalFurnace(player.inventory, (TileEntityChemicalFurnace) entity);
			} else 
			{
				return null;
			}
		case 2:
			if(entity != null && entity instanceof TileEntitySteamFurnace) 
			{
				return new GuiSteamFurnace(player.inventory, (TileEntitySteamFurnace) entity);
			} else 
			{
				return null;
			}
		default:
			return null;
		}
	}
}