package com.steamcraft.mod.common.block.tile;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.steamcraft.mod.client.model.ModelLightningRod;
import com.steamcraft.mod.common.lib.SC2_Info;

public class TileEntityLightningRodRenderer extends TileEntitySpecialRenderer 
{
	private final ModelLightningRod model;

	public TileEntityLightningRodRenderer() 
	{
		this.model = new ModelLightningRod();
	}

	@Override // TODO: It's as simple as that!
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		ResourceLocation lightningRod = (new ResourceLocation(SC2_Info.MOD_ID.toLowerCase() + ":textures/models/lightningrod.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(lightningRod);                     
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}