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
 * File created @ [Feb 1, 2014, 12:54:18 PM]
 */
package com.steamcraft.mod.common.block.tile;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.steamcraft.mod.common.api.power.EnumPower;
import com.steamcraft.mod.common.api.power.IPowerGenerator;
import com.steamcraft.mod.common.api.power.IPowerReceptor;

/**
 * @author MrArcane111
 *
 */
public class TileEntityMachine extends TileEntity implements IPowerGenerator, IPowerReceptor
{
	public float currentOutput = 0;
	public boolean isRedstonePowered = false;
	private boolean checkOrienation = false;
	public int progress;
	public int energy;
	public int heat;
	ForgeDirection orientation = ForgeDirection.UP;
	
	@Override
	public void updateEntity() 
	{
		if(this instanceof IPowerGenerator)
		{
			this.generatePower(this.orientation);
		} else if(this instanceof IPowerReceptor)
		{
			this.receievePower(this.orientation);
		}
	}
	
	@Override
	public void receievePower(ForgeDirection side)
	{
	
	}

	@Override
	public void doWork() 
	{
		
	}

	@Override
	public World getWorld()
	{
		return this.worldObj;
	}

	@Override
	public int powerEmitionLimit() 
	{
		return 0;
	}

	@Override
	public boolean generatePower(ForgeDirection side) 
	{
		return side == this.orientation;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		orientation = ForgeDirection.getOrientation(nbt.getInteger("orientation"));
		progress = nbt.getInteger("progress");
		energy = nbt.getInteger("energyF");
		NBTBase tag = nbt.getTag("heat");
		
		if(tag instanceof NBTTagFloat)
			heat = nbt.getInteger("heat");
	}

	@Override
	public void writeToNBT(NBTTagCompound data) 
	{
		super.writeToNBT(data);
		data.setInteger("orientation", orientation.ordinal());
		data.setFloat("progress", progress);
		data.setFloat("energyF", energy);
		data.setFloat("heat", heat);
	}
	
	public void checkRedstonePower() 
	{
		this.isRedstonePowered = this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord);
	}
}
