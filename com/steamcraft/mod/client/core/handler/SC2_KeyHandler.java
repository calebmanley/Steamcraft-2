package com.steamcraft.mod.client.core.handler;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class SC2_KeyHandler extends KeyHandler
{
	private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);
	public static boolean keyPressed = false;

	public SC2_KeyHandler(KeyBinding[] keyBindings, boolean[] repeating)
	{
		super(keyBindings, repeating);
	}
	
	@Override
	public String getLabel()
	{
		return "SC_KeyHandler";
	}
	
	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{
		// What to do when key is pressed/down
		keyPressed = true;
	}
	
	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
	{
		// What to do when key is released/up
		keyPressed = false;
	}
	
	@Override
	public EnumSet<TickType> ticks()
	{
		return tickTypes;
	}
}