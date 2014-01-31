package com.steamcraft.mod.common.lib;

import org.lwjgl.input.Keyboard;

public class SC2_GeneralUtils 
{
	public static String shiftForInfo = "\u00A77Hold §aShift \u00A77for more info.";
	
	public static boolean isShiftKeyDown()
	{
		return (Keyboard.isKeyDown(42)) || (Keyboard.isKeyDown(54));
	}
}
