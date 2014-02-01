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
 * File created @ [Jan 30, 2014, 5:33:43 PM]
 */
package com.steamcraft.mod.common.core.handler;

import java.io.File;

import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;

/**
 * 
 * @author MrArcane111, EntireCraft & general3214
 *
 */
public final class SC2_ConfigHandler 
{
	private static Configuration config;
    private static int nextBlockId = 2600;
    private static int nextItemId = 1300;

    public SC2_ConfigHandler(File file)
    {
        config = new Configuration(file);
    }

	public void loadConfig()
	{
		config.load();
		//
	}

    public void saveConfig()
    {
        config.save();
    }

    public int loadItem(String label)
    {
        return loadItem(label, nextItemId++);
    }

    private int loadItem(String label, int defaultID)
    {
        return config.getItem("id_item." + label, defaultID).getInt(defaultID) - 256;
    }

    public int loadBlock(String label)
    {
        return loadBlock(label, nextBlockId++);
    }

    private int loadBlock(String label, int defaultID)
    {
        return config.getBlock("id_tile." + label, defaultID).getInt(defaultID);
    }
}