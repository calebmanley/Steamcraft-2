package com.steamcraft.mod.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.steamcraft.mod.container.ContainerNukeFurnace;
import com.steamcraft.mod.gui.GuiNukeFurnace;

import cpw.mods.fml.common.network.IGuiHandler;

public class SC_GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{asdf
		if(id == 0)
		{
			return new ContainerNukeFurnace(player.inventory, world.getBlockTileEntity(x, y, z));
		} else
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(id == 0)
		{
			return new GuiNukeFurnace(player.inventory, world.getBlockTileEntity(x, y, z));
		} else
		{
			return null;
		}
	}
}