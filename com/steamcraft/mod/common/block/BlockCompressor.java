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
 * File created @ [Feb 1, 2014, 8:46:02 PM]
 */
package com.steamcraft.mod.common.block;

import java.util.ArrayList;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.steamcraft.mod.client.lib.SC2_GuiIDs;
import com.steamcraft.mod.common.SC2;
import com.steamcraft.mod.common.block.tile.TileEntityCompressor;

/**
 * @author MrArcane111
 *
 */
public class BlockCompressor extends BlockSC2Container
{
	public BlockCompressor(int id, Material mat)
	{
		super(id, Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World world) 
	{
		return new TileEntityCompressor();
	}

	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase living, ItemStack stack) 
	{
		super.onBlockPlacedBy(world, i, j, k, living, stack);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
	{
		TileEntity tile = world.getBlockTileEntity(x, y, z);

		if(!(tile instanceof TileEntityCompressor))
			return false;
		if(!world.isRemote) 
		{
			player.openGui(SC2.instance, SC2_GuiIDs.GUI_ID_COMPRESSOR, world, x, y, z);
		}

		return true;
	}

	@Override
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void addCreativeItems(ArrayList list) 
	{
		list.add(new ItemStack(this));
	}
}
