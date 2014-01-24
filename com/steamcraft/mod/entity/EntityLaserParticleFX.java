package com.steamcraft.mod.entity;

import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityLaserParticleFX extends EntityReddustFX 
{
	private int part;

	public EntityLaserParticleFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10, int movX, int movY, int movZ, int par)
	{
		super(par1World, par2, par4, par6, 0.5F, par8, par9, par10);

		motionX = 0.04F;
		motionZ = 0.04F;
		motionY = 0.04F;

		motionX *= movX;
		motionZ *= movZ;
		motionY *= movY;
		part = par;

		noClip = true;
	}

	public EntityLaserParticleFX(World par1World, double par2, double par4, double par6, float par8, float par9, float par10, float par11) 
	{
		super(par1World, par2, par4, par6, par8, par9, par10, par11);
	}

	@Override
	public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate()
	{
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;

		if (particleAge++ >= particleMaxAge) {
			setDead();
		}

		setParticleTextureIndex(7 - (particleAge * 8) / particleMaxAge);

		if (!isDead) moveEntity(motionX, motionY, motionZ);

		// motionX *= 0.95999997854232788D;
		// motionZ *= 0.95999997854232788D;

		if (part == 1) {

			if (motionX > 0 && posX - Math.floor(posX) > 0.45F) {
				setDead();
			}
			if (motionX < 0 && posX - Math.floor(posX) < 0.55F) {
				setDead();
			}

			if (motionY > 0 && posY - Math.floor(posY) > 0.45F) {
				setDead();
			}
			if (motionY < 0 && posY - Math.floor(posY) < 0.55F) {
				setDead();
			}

			if (motionZ > 0 && posZ - Math.floor(posZ) > 0.45F) {
				setDead();
			}
			if (motionZ < 0 && posZ - Math.floor(posZ) < 0.55F) {
				setDead();
			}

		}
	}

	@Override
	public int getBrightnessForRender(float par1) {
		return 0xf000f0;
	}

	/**
	 * Gets how bright this entity is.
	 */
	@Override
	public float getBrightness(float par1) {
		return 0.9F;
	}
}