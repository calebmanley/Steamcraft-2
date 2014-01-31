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
 * File created @ [Jan 31, 2014, 3:48:02 PM]
 */
package com.steamcraft.mod.common.block;

import com.steamcraft.mod.common.lib.SC2_Info;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;

/**
 * @author MrArcane111
 *
 */
public class BlockCastIronFence <B extends BlockSC2> extends BlockFence
{
	public BlockCastIronFence(int id)
	{
		super(id, SC2_Info.SC2_PREFIX + "castirongate", Material.iron);
	}

	@Override
	public boolean canConnectFenceTo(IBlockAccess iBlockAccess, int i, int j, int k)
	{
		int bid = iBlockAccess.getBlockId(i, j, k);

		if(bid != this.blockID && bid != ModBlocks.railingCastIron.blockID)
		{
			Block block = Block.blocksList[bid];
			return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
		} else
		{
			return true;
		}
	}
}