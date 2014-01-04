package com.steamcraft.mod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.steamcraft.mod.inventory.ContainerChemicalFurnace;
import com.steamcraft.mod.lib.SC_Info;
import com.steamcraft.mod.tileentity.TileEntityChemicalFurnace;

public class GuiChemicalFurnace extends GuiContainer 
{
	private static final ResourceLocation chemGuiTextures = new ResourceLocation(SC_Info.MOD_ID.toLowerCase(), "textures/gui/chemicalfurnace.png");
	private TileEntityChemicalFurnace furnaceInventory;
	
	public GuiChemicalFurnace(InventoryPlayer inventoryplayer, TileEntityChemicalFurnace furnace)
	{
		super(new ContainerChemicalFurnace(inventoryplayer, furnace));
		furnaceInventory = furnace;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRenderer.drawString("Chemcial Furnace", 60, 6, 0x404040);
		fontRenderer.drawString("Inventory", 8, (this.ySize - 96) + 2, 0x404040);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(this.chemGuiTextures);
		int size1 = (this.width - this.xSize) / 2;
		int size2 = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(size1, size2, 0, 0, this.xSize, this.ySize);
	
		if(this.furnaceInventory.isBurning())
		{
			int burnTime = this.furnaceInventory.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(size1 + 56, (size2 + 36 + 12) - burnTime, 176, 12 - burnTime, 14, burnTime + 2);
		}
		
		int cookProgress = furnaceInventory.getCookProgressScaled(24);
		this.drawTexturedModalRect(size1 + 79, size2 + 34, 176, 14, cookProgress + 1, 16);
	}
}