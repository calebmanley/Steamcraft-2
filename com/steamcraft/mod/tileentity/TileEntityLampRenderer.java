package com.steamcraft.mod.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.steamcraft.mod.block.ModBlocks;
import com.steamcraft.mod.model.ModelLampSide;
import com.steamcraft.mod.model.ModelLampUp;

public class TileEntityLampRenderer extends TileEntitySpecialRenderer
{
	private ModelLampUp lampModelUp;
	private ModelLampSide lampModelSide;

	public TileEntityLampRenderer()
	{
		lampModelUp = new ModelLampUp();
		lampModelSide = new ModelLampSide();
	}

	public void renderTileEntityLampAt(TileEntityLamp tile, double d1, double d2, double d3, float f)
	{
		Block block = tile.getBlockType();
		GL11.glPushMatrix();
		float f1 = 0.6666667F;
		int i = tile.getBlockMetadata();
		float f3 = 0.0F;
		float f2 = 1.0F;
		
		if(i == 2)
		{
			f3 = 180F;
		}
		if(i == 4)
		{
			f3 = 90F;
		}
		if(i == 3)
		{
			f3 = -90F;
		}
		if(i == 6)
		{
			f2 = 180F;
		}
		
		GL11.glTranslatef((float)d1 + 0.5F, (float)d2 + 0.75F * f1, (float)d3 + 0.5F);
		GL11.glRotatef(f3, 0.0F, 1.0F, 0.0F);
		
		if(i == 6)
		{
			GL11.glRotatef(f2, 0.0F, 0.0F, 1.0F);
		}
		
		GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
		
		/*
		if(block == ModBlocks.torchElectricIdle)
		{
			lampModelUp.BracketWide.showModel = false;
			lampModelUp.CrossbarLeft.showModel = false;
			lampModelUp.CrossbarRight.showModel = false;
			lampModelSide.CrossbarLeft.showModel = false;
			lampModelSide.CrossbarRight.showModel = false;
		} else*/
		if(block == ModBlocks.ironLampActive || block == ModBlocks.ironLampIdle)
		{
			lampModelUp.BracketWide.showModel = true;
			lampModelUp.CrossbarLeft.showModel = true;
			lampModelUp.CrossbarRight.showModel = true;
			lampModelSide.CrossbarLeft.showModel = true;
			lampModelSide.CrossbarRight.showModel = true;
		}
		if(block == ModBlocks.ironLampActive)
		{
			//bindTexture("/item/lampon.png");
		} else if(block == ModBlocks.ironLampIdle)
		{
			//bindTexture("/item/lampoff.png");
		}
		
		GL11.glPushMatrix();
		GL11.glScalef(f1, -f1, -f1);
		
		if(i == 5 || i == 6)
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

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d1, double d2, double d3, float f)
	{
		renderTileEntityLampAt((TileEntityLamp)tileentity, d1, d2, d3, f);
	}
}