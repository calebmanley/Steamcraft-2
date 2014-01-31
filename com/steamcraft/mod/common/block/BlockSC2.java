package com.steamcraft.mod.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;

import com.steamcraft.mod.common.SC2;
import com.steamcraft.mod.common.lib.SC2_CreativeTabs;
import com.steamcraft.mod.common.lib.SC2_Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSC2 extends Block
{
	public BlockSC2(int id, Material mat)
	{
		super(id, mat);
		this.setCreativeTab(SC2_CreativeTabs.tabSCBlocks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		blockIcon = icon.registerIcon(SC2_Info.MOD_ID.toLowerCase() + ":" + (getUnlocalizedName().substring(5))); // Cannot do a 'this' reflection!
	}
	
	 /**
     * Determine if this block can make a copper connection on the side provided,
     * Useful to control which sides are inputs and outputs for copper wires.
     *
     * Side:
     *  -1: UP
     *   0: NORTH
     *   1: EAST
     *   2: SOUTH
     *   3: WEST
     *
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param side The side that is trying to make the connection
     * @return True to make the connection
     */
	@Override
    public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
    {
        return Block.blocksList[blockID].canProvidePower() && side != -1;
    }
}