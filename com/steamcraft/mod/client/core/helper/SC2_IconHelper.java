/**
 * This class was created by <MrArcane111> or his SC2 development team. 
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MIT License.
 * (http://opensource.org/licenses/MIT)
 * 
 * Steamcraft 2 is based on the original Steamcraft created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 * 
 * File created @ [Jan 30, 2014, 5:16:43 PM]
 */
package com.steamcraft.mod.client.core.helper;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;

import com.steamcraft.mod.common.lib.SC2_Info;

/**
 * @author Vazkii from Thaumic Tinkerer
 * (https://github.com/Vazkii/ThaumicTinkerer/IconHelper)
 *
 */
public class SC2_IconHelper 
{
	private static Icon emptyTexture;

	public static Icon forName(IconRegister icon, String name) 
	{
		return icon.registerIcon(SC2_Info.SC2_PREFIX + name);
	}

	public static Icon forNameRaw(IconRegister icon, String name) 
	{
		return icon.registerIcon(name);
	}

	/*
	public static Icon emptyTexture(IconRegister icon)
	{
		return emptyTexture == null ? (emptyTexture = forName(icon, SC2_Info.EMTPY_TEXTURE)) : emptyTexture;
	}
	 */

	public static Icon forBlock(IconRegister icon, Block block) 
	{
		return forNameRaw(icon, block.getUnlocalizedName().replaceAll("tile.", ""));
	}

	public static Icon forBlock(IconRegister icon, Block block, int i) 
	{
		return forBlock(icon, block, Integer.toString(i));
	}

	public static Icon forBlock(IconRegister icon, Block block, String s) 
	{
		return forNameRaw(icon, block.getUnlocalizedName().replaceAll("tile.", "") + s);
	}

	public static Icon forItem(IconRegister icon, Item item)
	{
		return forNameRaw(icon, item.getUnlocalizedName().replaceAll("item.", ""));
	}

	public static Icon forItem(IconRegister icon, Item item, int i)
	{
		return forItem(icon, item, Integer.toString(i));
	}

	public static Icon forItem(IconRegister icon, Item item, String s) 
	{
		return forNameRaw(icon, item.getUnlocalizedName().replaceAll("item.", "") + s);
	}
}