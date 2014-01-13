package com.steamcraft.mod.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.steamcraft.mod.lib.SC2_Info;
import com.steamcraft.mod.model.ModelLampSide;
import com.steamcraft.mod.model.ModelLampUp;

public class TileEntityLampRenderer extends TileEntitySpecialRenderer
{
	private ModelLampUp lampModelUp;
	private ModelLampSide lampModelSide;
	private final ResourceLocation lampTextureOn = new ResourceLocation(SC2_Info.MOD_ID.toLowerCase(), "/textures/models/lampon.png");
	private final ResourceLocation lampTextureOff = new ResourceLocation(SC2_Info.MOD_ID.toLowerCase(), "/textures/models/lampoff.png");

	public TileEntityLampRenderer()
	{
		this.lampModelUp = new ModelLampUp();
		this.lampModelSide = new ModelLampSide();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) 
	{
		TileEntityLamp lamp = (TileEntityLamp) tile;
		
		Block block = lamp.getBlockType();
		GL11.glPushMatrix();
		float f1 = 0.6666667F;
		int meta = lamp.getBlockMetadata();
		float f3 = 0.0F;
		float f2 = 1.0F;
		
		if(meta == 2)
		{
			f3 = 180F;
		}
		if(meta == 4)
		{
			f3 = 90F;
		}
		if(meta == 3)
		{
			f3 = -90F;
		}
		if(meta == 6)
		{
			f2 = 180F;
		}
		
		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F * f1, (float)z + 0.5F);
		GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
		
		if(meta == 6)
		{
			GL11.glRotatef(f2, 0.0F, 0.0F, 1.0F);
		}
		
		GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
		
		if(block == Block.torchRedstoneActive || block == Block.torchRedstoneIdle)
		{
			lampModelUp.BracketWide.showModel = false;
			lampModelUp.CrossbarLeft.showModel = false;
			lampModelUp.CrossbarRight.showModel = false;
			lampModelSide.CrossbarLeft.showModel = false;
			lampModelSide.CrossbarRight.showModel = false;
		} 
		if(block == Block.torchRedstoneActive)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(this.lampTextureOn);
		} else if(block == Block.torchRedstoneIdle)
		{
			Minecraft.getMinecraft().renderEngine.bindTexture(this.lampTextureOff);
		}
		
		GL11.glPushMatrix();
		GL11.glScalef(f1, -f1, -f1);
		
		if(meta == 5 || meta == 6)
		{
			lampModelUp.renderSign();
		} else
		{
			lampModelSide.renderSign();
		}
		
		GL11.glPopMatrix();
		float f4 = 0.01666667F * f1;
		GL11.glTranslatef(0.0F, 0.5F * f1, 0.07F * f1);
		GL11.glScalef(f4, -f4, f4);
		GL11.glNormal3f(0.0F, 0.0F, -1F * f4);
		GL11.glDepthMask(false);
		int j = 0;
		GL11.glDepthMask(true);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glPopMatrix();
	}
}