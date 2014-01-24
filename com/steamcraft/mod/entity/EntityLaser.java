package com.steamcraft.mod.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityLaser extends Entity
{
	private int xTileLaserBullet;
	private int yTileLaserBullet;
	private int zTileLaserBullet;
	private int inTileLaserBullet;
	private boolean inGroundLaserBullet;
	public int shakeLaserBullet;
	private EntityLiving shootingEntity;
	private int ticksInGroundLaserBullet;
	private int ticksInAirLaserBullet;

	public EntityLaser(World world)
	{
		super(world);
		xTileLaserBullet = -1;
		yTileLaserBullet = -1;
		zTileLaserBullet = -1;
		inTileLaserBullet = 0;
		inGroundLaserBullet = false;
		shakeLaserBullet = 0;
		ticksInAirLaserBullet = 0;
		setSize(0.25F, 0.25F);
	}

	@Override
	protected void entityInit() {}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isInRangeToRenderDist(double d)
	{
		double d1 = boundingBox.getAverageEdgeLength() * 4D;
		d1 *= 64D;
		return d < d1 * d1;
	}

	public EntityLaser(World world, EntityLiving entityliving)
	{
		super(world);
		xTileLaserBullet = -1;
		yTileLaserBullet = -1;
		zTileLaserBullet = -1;
		inTileLaserBullet = 0;
		inGroundLaserBullet = false;
		shakeLaserBullet = 0;
		ticksInAirLaserBullet = 0;
		shootingEntity = entityliving;
		setSize(0.25F, 0.25F);
		setLocationAndAngles(entityliving.posX, entityliving.posY + (double)entityliving.getEyeHeight(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
		posX -= MathHelper.cos((rotationYaw / 180F) * 3.141593F) * 0.16F;
		posY -= 0.10000000149011612D;
		posZ -= MathHelper.sin((rotationYaw / 180F) * 3.141593F) * 0.16F;
		setPosition(posX, posY, posZ);
		yOffset = 0.0F;
		float f = 0.4F;
		motionX = -MathHelper.sin((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F) * f;
		motionZ = MathHelper.cos((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F) * f;
		motionY = -MathHelper.sin((rotationPitch / 180F) * 3.141593F) * f;
		setLaserBulletHeading(motionX, motionY, motionZ, 1.5F, 1.0F);
	}

	public EntityLaser(World world, double d, double d1, double d2)
	{
		super(world);
		xTileLaserBullet = -1;
		yTileLaserBullet = -1;
		zTileLaserBullet = -1;
		inTileLaserBullet = 0;
		inGroundLaserBullet = false;
		shakeLaserBullet = 0;
		ticksInAirLaserBullet = 0;
		ticksInGroundLaserBullet = 0;
		setSize(0.25F, 0.25F);
		setPosition(d, d1, d2);
		yOffset = 0.0F;
	}

	public void setLaserBulletHeading(double d, double d1, double d2, float f, float f1)
	{
		float f2 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
		d /= f2;
		d1 /= f2;
		d2 /= f2;
		d += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;
		d1 += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;
		d2 += rand.nextGaussian() * 0.0074999998323619366D * (double)f1;
		d *= f;
		d1 *= f;
		d2 *= f;
		motionX = d;
		motionY = d1;
		motionZ = d2;
		float f3 = MathHelper.sqrt_double(d * d + d2 * d2);
		prevRotationYaw = rotationYaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
		prevRotationPitch = rotationPitch = (float)((Math.atan2(d1, f3) * 180D) / 3.1415927410125732D);
		ticksInGroundLaserBullet = 0;
	}

	@Override
	public void setVelocity(double d, double d1, double d2)
	{
		motionX = d;
		motionY = d1;
		motionZ = d2;
		
		if(prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
		{
			float f = MathHelper.sqrt_double(d * d + d2 * d2);
			prevRotationYaw = rotationYaw = (float)((Math.atan2(d, d2) * 180D) / 3.1415927410125732D);
			prevRotationPitch = rotationPitch = (float)((Math.atan2(d1, f) * 180D) / 3.1415927410125732D);
		}
	}

	@Override
	public void onUpdate()
	{
		lastTickPosX = posX;
		lastTickPosY = posY;
		lastTickPosZ = posZ;
		super.onUpdate();
		if(shakeLaserBullet > 0)
		{
			shakeLaserBullet--;
		}
		if(inGroundLaserBullet)
		{
			int i = worldObj.getBlockId(xTileLaserBullet, yTileLaserBullet, zTileLaserBullet);
			if(i != inTileLaserBullet)
			{
				inGroundLaserBullet = false;
				motionX *= rand.nextFloat() * 0.2F;
				motionY *= rand.nextFloat() * 0.2F;
				motionZ *= rand.nextFloat() * 0.2F;
				ticksInGroundLaserBullet = 0;
				ticksInAirLaserBullet = 0;
			} else
			{
				ticksInGroundLaserBullet++;
				if(ticksInGroundLaserBullet == 1200)
				{
					this.setDead();
				}
				return;
			}
		} else
		{
			ticksInAirLaserBullet++;
		}
		Vec3 vec3d = Vec3.createVectorHelper(posX, posY, posZ);
		Vec3 vec3d1 = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
		MovingObjectPosition movingobjectposition = worldObj.clip(vec3d, vec3d1);
		vec3d = Vec3.createVectorHelper(posX, posY, posZ);
		vec3d1 = Vec3.createVectorHelper(posX + motionX, posY + motionY, posZ + motionZ);
		
		if(movingobjectposition != null)
		{
			vec3d1 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
		}
		if(!worldObj.isRemote)
		{
			Entity entity = null;
			List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
			double d = 0.0D;
			for(int k = 0; k < list.size(); k++)
			{
				Entity entity1 = (Entity)list.get(k);
				if(!entity1.canBeCollidedWith() || entity1 == shootingEntity && ticksInAirLaserBullet < 5)
				{
					continue;
				}
				float f4 = 0.3F;
				AxisAlignedBB axisalignedbb = entity1.boundingBox.expand(f4, f4, f4);
				MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3d, vec3d1);
				if(movingobjectposition1 == null)
				{
					continue;
				}
				double d1 = vec3d.distanceTo(movingobjectposition1.hitVec);
				if(d1 < d || d == 0.0D)
				{
					entity = entity1;
					d = d1;
				}
			}

			if(entity != null)
			{
				movingobjectposition = new MovingObjectPosition(entity);
			}
		}
		if(movingobjectposition != null)
		{
			if(movingobjectposition.entityHit != null)
			{
				if(movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, shootingEntity), 0));
			}
			this.setDead();
		}
		
		posX += motionX;
		posY += motionY;
		posZ += motionZ;
		float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
		rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / 3.1415927410125732D);
		for(rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / 3.1415927410125732D); rotationPitch - prevRotationPitch < -180F; prevRotationPitch -= 360F) { }
		for(; rotationPitch - prevRotationPitch >= 180F; prevRotationPitch += 360F) { }
		for(; rotationYaw - prevRotationYaw < -180F; prevRotationYaw -= 360F) { }
		for(; rotationYaw - prevRotationYaw >= 180F; prevRotationYaw += 360F) { }
		rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
		rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
		float f1 = 0.99F;
		float f2 = 0.03F;
		if(isInWater())
		{
			for(int j = 0; j < 4; j++)
			{
				float f3 = 0.25F;
				worldObj.spawnParticle("bubble", posX - motionX * (double)f3, posY - motionY * (double)f3, posZ - motionZ * (double)f3, motionX, motionY, motionZ);
			}

			f1 = 0.8F;
		}
		motionX *= f1;
		motionY *= f1;
		motionZ *= f1;
		motionY -= f2;
		setPosition(posX, posY, posZ);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		nbttagcompound.setShort("xTile", (short)xTileLaserBullet);
		nbttagcompound.setShort("yTile", (short)yTileLaserBullet);
		nbttagcompound.setShort("zTile", (short)zTileLaserBullet);
		nbttagcompound.setByte("inTile", (byte)inTileLaserBullet);
		nbttagcompound.setByte("shake", (byte)shakeLaserBullet);
		nbttagcompound.setByte("inGround", (byte)(inGroundLaserBullet ? 1 : 0));
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		xTileLaserBullet = nbttagcompound.getShort("xTile");
		yTileLaserBullet = nbttagcompound.getShort("yTile");
		zTileLaserBullet = nbttagcompound.getShort("zTile");
		inTileLaserBullet = nbttagcompound.getByte("inTile") & 0xff;
		shakeLaserBullet = nbttagcompound.getByte("shake") & 0xff;
		inGroundLaserBullet = nbttagcompound.getByte("inGround") == 1;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityplayer)
	{
		if(inGroundLaserBullet /*&& shootingEntity == entityplayer*/ && shakeLaserBullet <= 0 && entityplayer.inventory.addItemStackToInventory(new ItemStack(Item.arrow, 1)))
		{
			worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			entityplayer.onItemPickup(this, 1);
			this.setDead();
		}
	}

	@Override
	public float getShadowSize()
	{
		return 0.0F;
	}
}