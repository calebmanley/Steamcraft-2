package com.steamcraft.mod.handler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.steamcraft.mod.entity.EntityBullet;
import com.steamcraft.mod.item.ModArmors;
import com.steamcraft.mod.lib.SC2_Info;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class SC2_HUDHandler implements ITickHandler
{
	private static final ResourceLocation overlay = new ResourceLocation(SC2_Info.MOD_ID.toLowerCase(), "/textures/misc/goggles.png");

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		Minecraft mc = Minecraft.getMinecraft();

		if(mc.thePlayer == null || mc.currentScreen != null)
		{
			return;
		}

		ItemStack helmet = Minecraft.getMinecraft().thePlayer.inventory.armorItemInSlot(3);

		if(mc.gameSettings.thirdPersonView == 0 && helmet != null && helmet.itemID == ModArmors.brassGoggles.itemID)// && SC_KeyHandler.keyPressed)
		{
			ArrayList list = (ArrayList) MinecraftServer.getServer().getConfigurationManager().playerEntityList;
			Iterator iterator = list.iterator();

			while(iterator.hasNext())
			{
				EntityBullet bullet = (EntityBullet) iterator.next();
				GL11.glPushMatrix();
				GL11.glTranslatef(0, -0.5F, 0);
				GL11.glDisable(GL11.GL_CULL_FACE);
				GL11.glDisable(GL11.GL_TEXTURE_2D);
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glBegin(GL11.GL_LINE_STRIP);
				GL11.glColor4f(0, 0, 0, 1f);
				double motionX = bullet.motionX;
				double motionY = bullet.motionY;
				double motionZ = bullet.motionZ;
				float posX = 0f;
				float posY = 0f;
				float posZ = 0f;
				
				for(int i = 0; i < 200; i++) 
				{
					GL11.glVertex3f(posX, posY, posZ);
					motionY -= 0.03999999910593033D;
					posX += motionX;
					posY += motionY;
					posZ += motionZ;
					// motionX *= 0.98;
					// motionY *= 0.9800000190734863D;
					// motionZ *= 0.98;
				}
				
				GL11.glEnd();
				GL11.glEnable(GL11.GL_CULL_FACE);
				GL11.glEnable(GL11.GL_TEXTURE_2D);
				GL11.glDisable(GL11.GL_BLEND);
				GL11.glColor4f(1, 1, 1, 1);
				GL11.glPopMatrix();
			}


			/*
			mc.getTextureManager().bindTexture(this.overlay);
			GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
			Tessellator tessellator = Tessellator.instance;
			ScaledResolution scale = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
			int width = scale.getScaledWidth();
			int height = scale.getScaledHeight();
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(false);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_SRC_COLOR); // Does cool effects with the brightness
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); // Changes the rendering color; values must be between 0.0F-1.0F, leave the last value as 1.0FÑalpha affects transparency
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glClearDepth(1.0);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(0.0D, (double)height, 90.0D, 0.0D, 1.0D);
			tessellator.addVertexWithUV((double)width, (double)height, 90.0D, 1.0D, 1.0D);
			tessellator.addVertexWithUV((double)width, 0.0D, 90.0D, 1.0D, 0.0D);
			tessellator.addVertexWithUV(0.0D, 0.0D, 90.0D, 0.0D, 0.0D);
			tessellator.draw();
			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopAttrib();

			if(!mc.gameSettings.hideGUI || mc.currentScreen != null)
			{
				int k = (Mouse.getX() * width) / mc.displayWidth;
				int l = height - (Mouse.getY() * height) / mc.displayHeight - 1;
				mc.ingameGUI.renderGameOverlay(0.0F, mc.currentScreen != null, k, l);
			}*/
		}
	}

	@Override
	public EnumSet<TickType> ticks()
	{
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel()
	{
		return "SC_HUDHandler";
	}
}