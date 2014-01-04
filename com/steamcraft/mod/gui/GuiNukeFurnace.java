package com.steamcraft.mod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.steamcraft.mod.container.ContainerNukeFurnace;
import com.steamcraft.mod.tileentity.TileEntityNukeFurnace;

public class GuiNukeFurnace extends GuiContainer
{
	private static final ResourceLocation nukeGuiTextures = new ResourceLocation("textures/gui/nukefurnace.png");
	private TileEntityNukeFurnace furnaceInventory;
	
	public GuiNukeFurnace(InventoryPlayer inventory, TileEntityNukeFurnace furnace)
	{
		super(new ContainerNukeFurnace(inventory, furnace));
		furnaceInventory = furnace;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRenderer.drawString("Nuclear Reactor", 60, 6, 0x404040);
		fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(nukeGuiTextures);
		int size1 = (this.width - this.xSize) / 2;
		int size2 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(size1, size2, 0, 0, this.xSize, this.ySize);
		
		if(furnaceInventory.isBurning())
		{
			int burnTime = furnaceInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(size1 + 56, (size2 + 36 + 12) - burnTime, 176, 12 - burnTime, 14, burnTime + 2);
		}
		
		int cookProgress = furnaceInventory.getCookProgressScaled(24);
		drawTexturedModalRect(size1 + 79, size2 + 34, 176, 14, cookProgress + 1, 16);
		int heat = furnaceInventory.getHeatScaled(54);
		drawTexturedModalRect(size1 + 37, size2 + 16 + 54 - heat, 176, 31 + 54 - heat, 8, heat);
	}
}