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
 * File created @ [Feb 1, 2014, 8:32:03 PM]
 */
package com.steamcraft.mod.common.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.steamcraft.mod.common.block.BlockSC2Container;

/**
 * @author MrArcane111
 *
 */
public abstract class TileEntitySC2 extends TileEntity implements ISidedInventory
{	
	public String owner = BlockSC2Container.owner;
	
	public TileEntitySC2() {}

	@Override
	public void updateEntity() {}

	@Override
	public void invalidate() 
	{
		super.invalidate();
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) 
	{
		super.writeToNBT(nbt);
		nbt.setString("owner", this.owner);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) 
	{
		super.readFromNBT(nbt);
		
		if(nbt.hasKey("owner"))
			this.owner = nbt.getString("owner");
	}

	@Override
	public boolean isInvNameLocalized() 
	{
		return false;
	}

	public World getWorld() 
	{
		return this.worldObj;
	}
	
	@Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

	@Override
    public void openChest() {}

	@Override
    public void closeChest() {}

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int slot, ItemStack stack, int side)
    {
        return side != 0 || slot != 1 || stack.itemID == Item.bucketEmpty.itemID;
    }
}
