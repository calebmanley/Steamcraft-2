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

    public static final String CATEGORY_RENDER = "render";
    public static final String CATEGORY_GUI = "gui";
    public static final String CATEGORY_ENTITY = "entity";

    private static int nextBlockId = 2600;
    private static int nextItemId = 1300;
    private static int nextRenderId = 8;
    private static int nextGuiId = 5;
    private static int nextEntityId = 5;

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

    public int loadItem(String label, int defaultID)
    {
        return config.getItem("id_item." + label, defaultID).getInt(defaultID) - 256;
    }

    public int loadBlock(String label)
    {
        return loadBlock(label, nextBlockId++);
    }

    public int loadBlock(String label, int defaultID)
    {
        return config.getBlock("id_tile." + label, defaultID).getInt(defaultID);
    }

    public int loadRender(String label)
    {
        return loadRender(label, nextRenderId++);
    }

    public int loadRender(String label, int defaultID)
    {
        return config.get(CATEGORY_RENDER, "id_render." + label, defaultID).getInt(defaultID);
    }

    public int loadGui(String label)
    {
        return loadGui(label, nextGuiId++);
    }

    public int loadGui(String label, int defaultID)
    {
        return config.get(CATEGORY_GUI, "id_gui." + label, defaultID).getInt(defaultID);
    }

    public int loadEntity(String label)
    {
        return loadEntity(label, nextEntityId++);
    }

    public int loadEntity(String label, int defaultID)
    {
        return config.get(CATEGORY_ENTITY, "id_entity." + label, defaultID).getInt(defaultID);
    }
}