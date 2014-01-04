package com.steamcraft.mod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.steamcraft.mod.inventory.ContainerSteamFurnace;
import com.steamcraft.mod.lib.SC_Info;
import com.steamcraft.mod.tileentity.TileEntitySteamFurnace;

public class GuiSteamFurnace extends GuiContainer
{
	private static final ResourceLocation steamGuiTextures = new ResourceLocation(SC_Info.MOD_ID.toLowerCase(), "textures/gui/steamfurnace.png");
	private TileEntitySteamFurnace furnaceInventory;

	public GuiSteamFurnace(InventoryPlayer inventoryplayer, TileEntitySteamFurnace furnace)
	{
		super(new ContainerSteamFurnace(inventoryplayer, furnace));
		this.furnaceInventory = furnace;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		this.fontRenderer.drawString("Steam Furnace", 60, 6, 0x404040);
		this.fontRenderer.drawString("Inventory", 8, (this.ySize - 96) + 2, 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(steamGuiTextures);
		int size1 = (this.width - this.xSize) / 2;
		int size2 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(size1, size2, 0, 0, this.xSize, this.ySize);
		
		if(this.furnaceInventory.isBurning())
		{
			int burnTime = furnaceInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(size1 + 56, (size2 + 36 + 12) - burnTime, 176, 12 - burnTime, 14, burnTime + 2);
		}
		
		int cookProgress = this.furnaceInventory.getCookProgressScaled(24);
		this.drawTexturedModalRect(size1 + 79, size2 + 34, 176, 14, cookProgress + 1, 16);
		int waterLevel = furnaceInventory.getWaterScaled(31);
		this.drawTexturedModalRect(size1 + 32, (size2 + 16 + 31) - waterLevel, 176, (31 + 31 - waterLevel), 8, waterLevel + 2);
	}
}