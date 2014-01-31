package com.steamcraft.mod.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

import com.steamcraft.mod.common.lib.SC2_CreativeTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCastIronGate extends BlockFenceGate
{
    public BlockCastIronGate(int id, Material mat)
    {
        super(id);
        this.setHardness(7F);
        this.setResistance(20F);
        this.setStepSound(Block.soundMetalFootstep);
        this.setUnlocalizedName("castirongate");
        this.setCreativeTab(SC2_CreativeTabs.tabSCBlocks);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int i, int j)
    {
        return ModBlocks.blockCastIron.getBlockTextureFromSide(i);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {}
}