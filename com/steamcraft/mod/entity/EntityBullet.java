package com.steamcraft.mod.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IProjectile;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityBullet extends Entity implements IProjectile
{
	private int xTile;
	private int yTile;
	private int zTile;
	private double muzzleX;
	private double muzzleZ;
	private int inTile;
	private int inData;
	public boolean doesArrowBelongToPlayer;
	public boolean isRifled;
	public int arrowShake;
	public int damagePower;
	public EntityLiving owner;
	private int ticksInGround;
	private int ticksInAir;

	public EntityBullet(World world)
	{
		super(world);
		xTile = -1;
		yTile = -1;
		zTile = -1;
		inTile = 0;
		damagePower = 4;
		inData = 0;
		doesArrowBelongToPlayer = false;
		arrowShake = 0;
		ticksInAir = 0;
		setSize(0.5F, 0.5F);
	}

	public EntityBullet(World world, double d1, double d2, double d3)
	{
		super(world);
		xTile = -1;
		yTile = -1;
		zTile = -1;
		inTile = 0;
		damagePower = 4;
		inData = 0;
		doesArrowBelongToPlayer = false;
		arrowShake = 0;
		ticksInAir = 0;
		setSize(0.5F, 0.5F);
		setPosition(d1, d2, d3);
		yOffset = 0.0F;
	}

	public EntityBullet(World world, EntityLiving living, int power, boolean rifled)
	{
		super(world);
		xTile = -1;
		yTile = -1;
		zTile = -1;
		inTile = 0;
		damagePower = power;
		inData = 0;
		doesArrowBelongToPlayer = false;
		arrowShake = 0;
		ticksInAir = 0;
		isRifled = rifled;
		owner = living;
		setSize(0.5F, 0.5F);
		setLocationAndAngles(living.posX, living.posY + (double)living.getEyeHeight(), living.posZ, living.rotationYaw, living.rotationPitch);
		posX -= MathHelper.cos((rotationYaw / 180F) * 3.141593F) * 0.16F;
		posY -= 0.10000000149011612D;
		posZ -= MathHelper.sin((rotationYaw / 180F) * 3.141593F) * 0.16F;
		setPosition(posX, posY, posZ);
		yOffset = 0.0F;
		motionX = -2*MathHelper.sin((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);
		motionZ = 2*MathHelper.cos((rotationYaw / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);
		motionY = -2*MathHelper.sin((rotationPitch / 180F) * 3.141593F);
		muzzleX = -0.5*MathHelper.sin(((rotationYaw+25) / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);
		muzzleZ = 0.5*MathHelper.cos(((rotationYaw+25) / 180F) * 3.141593F) * MathHelper.cos((rotationPitch / 180F) * 3.141593F);
		world.spawnParticle("flame", living.posX+muzzleX, living.posY+0.25*motionY, living.posZ+muzzleZ, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", living.posX+muzzleX+0.1D, living.posY+0.25*motionY, living.posZ+muzzleZ, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", living.posX+muzzleX, living.posY+0.25*motionY, living.posZ+muzzleZ+0.1D, 0.0D, 0.0D, 0.0D);
		this.setThrowableHeading(motionX, motionY, motionZ, 1.0F, 1.0F);
	}

	@Override
	protected void entityInit() 
	{
		this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
	}

	@Override
	public void setThrowableHeading(double d, double d1, double d2, float f, float f1)
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
		ticksInGround = 0;
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
			prevRotationPitch = rotationPitch;
			prevRotationYaw = rotationYaw;
			setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
			ticksInGround = 0;
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(prevRotationPitch == 0.0F && prevRotationYaw == 0.0F)
		{
			float f = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
			prevRotationYaw = rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / 3.1415927410125732D);
			prevRotationPitch = rotationPitch = (float)((Math.atan2(motionY, f) * 180D) / 3.1415927410125732D);
		}

		int i = worldObj.getBlockId(xTile, yTile, zTile);

		if(i > 0)
		{
			Block.blocksList[i].setBlockBoundsBasedOnState(worldObj, xTile, yTile, zTile);
			AxisAlignedBB axisalignedbb = Block.blocksList[i].getCollisionBoundingBoxFromPool(worldObj, xTile, yTile, zTile);

			if(axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(posX, posY, posZ)))
			{
				this.setDead();
			}
		}
		if(arrowShake > 0)
		{
			arrowShake--;
		}

		++this.ticksInAir;
		Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
		Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
		MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks_do_do(vec3, vec31, false, true);
		vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
		vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

		if(movingobjectposition != null)
		{
			vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
		}

		Entity entity = null;
		List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.addCoord(motionX, motionY, motionZ).expand(1.0D, 1.0D, 1.0D));
		double d = 0.0D;

		for(int l = 0; l < list.size(); l++)
		{
			Entity entity1 = (Entity)list.get(l);

			if(!entity1.canBeCollidedWith() || entity1 == owner && ticksInAir < 5)
			{
				continue;
			}

			float f4 = 0.3F;
			AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f4, f4, f4);
			MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);

			if(movingobjectposition1 == null)
			{
				continue;
			}

			double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

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
		if(movingobjectposition != null)
		{
			if(movingobjectposition.entityHit != null)
			{
				if(movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage((Entity)this, (Entity)owner), damagePower))
				{
					this.setDead();
				} else
				{
					motionX *= -0.10000000149011612D;
					motionY *= -0.10000000149011612D;
					motionZ *= -0.10000000149011612D;
					rotationYaw += 180F;
					prevRotationYaw += 180F;
					ticksInAir = 0;
				}
			} else
			{
				xTile = movingobjectposition.blockX;
				yTile = movingobjectposition.blockY;
				zTile = movingobjectposition.blockZ;
				inTile = worldObj.getBlockId(xTile, yTile, zTile);
				inData = worldObj.getBlockMetadata(xTile, yTile, zTile);
				// TODO: Breaks glass, mo' fo'!
				if(inTile == Block.glass.blockID || inTile == Block.glowStone.blockID || inTile == Block.leaves.blockID)
				{
					Block block = Block.blocksList[inTile];
					//worldObj.playSoundEffect(xTile, yTile, zTile, "", 1.0F, worldObj.rand.nextFloat() * 0.1F + 0.9F);
					worldObj.setBlockToAir(xTile, yTile, zTile);
				} else
				{
					motionX = (float)(movingobjectposition.hitVec.xCoord - posX);
					motionY = (float)(movingobjectposition.hitVec.yCoord - posY);
					motionZ = (float)(movingobjectposition.hitVec.zCoord - posZ);
					float f1 = MathHelper.sqrt_double(motionX * motionX + motionY * motionY + motionZ * motionZ);
					posX -= (motionX / (double)f1) * 0.05000000074505806D;
					posY -= (motionY / (double)f1) * 0.05000000074505806D;
					posZ -= (motionZ / (double)f1) * 0.05000000074505806D;
					worldObj.spawnParticle("smoke", posX, posY, posZ, 0.0D, 0.0D, 0.0D);
					this.setDead();
					arrowShake = 7;
				}
			}
		}

		posX += motionX;
		posY += motionY;
		posZ += motionZ;
		worldObj.spawnParticle("smoke", posX, posY, posZ, 0.0D, 0.0D, 0.0D);
		float f2 = MathHelper.sqrt_double(motionX * motionX + motionZ * motionZ);
		rotationYaw = (float)((Math.atan2(motionX, motionZ) * 180D) / 3.1415927410125732D);
		for(rotationPitch = (float)((Math.atan2(motionY, f2) * 180D) / 3.1415927410125732D); rotationPitch - prevRotationPitch < -180F; prevRotationPitch -= 360F) { }
		for(; rotationPitch - prevRotationPitch >= 180F; prevRotationPitch += 360F) { }
		for(; rotationYaw - prevRotationYaw < -180F; prevRotationYaw -= 360F) { }
		for(; rotationYaw - prevRotationYaw >= 180F; prevRotationYaw += 360F) { }
		rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2F;
		rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2F;
		float f3 = 0.99F;
		float f5 = 0.03F;

		if(isRifled == true)
		{
			f5 = 0.001F;
		}
		if(isInWater())
		{
			for(int i1 = 0; i1 < 4; i1++)
			{
				float f6 = 0.25F;
				worldObj.spawnParticle("bubble", posX - motionX * (double)f6, posY - motionY * (double)f6, posZ - motionZ * (double)f6, motionX, motionY, motionZ);
			}

			f3 = 0.8F;
		}

		motionX *= f3;
		motionY *= f3;
		motionZ *= f3;
		motionY -= f5;
		setPosition(posX, posY, posZ);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		nbttagcompound.setShort("xTile", (short)xTile);
		nbttagcompound.setShort("yTile", (short)yTile);
		nbttagcompound.setShort("zTile", (short)zTile);
		nbttagcompound.setByte("inTile", (byte)inTile);
		nbttagcompound.setByte("inData", (byte)inData);
		nbttagcompound.setByte("shake", (byte)arrowShake);
		nbttagcompound.setBoolean("player", doesArrowBelongToPlayer);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		xTile = nbttagcompound.getShort("xTile");
		yTile = nbttagcompound.getShort("yTile");
		zTile = nbttagcompound.getShort("zTile");
		inTile = nbttagcompound.getByte("inTile") & 0xff;
		inData = nbttagcompound.getByte("inData") & 0xff;
		arrowShake = nbttagcompound.getByte("shake") & 0xff;
		doesArrowBelongToPlayer = nbttagcompound.getBoolean("player");
	}

	@Override
	public float getShadowSize()
	{
		return 0.0F;
	}
}