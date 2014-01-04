package com.steamcraft.mod.lib;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class SC_Material
{
	// Creates an instance of this class that is static
	public static final SC_Material INSTANCE = new SC_Material();
	
	// Tool Materials
	// name, int harvest level, int max uses, float efficiency, float damage, int enchantability
	public static EnumToolMaterial OBSIDIAN_TOOL = EnumHelper.addToolMaterial("OBSIDIAN_TOOL", 1, -1, 1.5F, 6.5F, 4);
	public static EnumToolMaterial ETHERIUM_TOOL = EnumHelper.addToolMaterial("ETHERIUM_TOOL", 4, 2345, 17.0F, 9.5F, 3);
	public static EnumToolMaterial STEAM_TOOL = EnumHelper.addToolMaterial("STEAM_TOOL", 2, 321, 12.0F, 12.0F, 5);
	
	// Armor Materials
	// name, int durability, int[] reduction amounts, int enchantability
	public static EnumArmorMaterial OBSIDIAN_ARMOR = EnumHelper.addArmorMaterial("OBSIDIAN_ARMOR", -1, new int [] {1, 4, 3, 1}, 7);
	public static EnumArmorMaterial ETHERIUM_ARMOR = EnumHelper.addArmorMaterial("ETHERIUM_ARMOR", 40, new int [] {4, 9, 8, 4}, 14);
	public static EnumArmorMaterial STEAM_ARMOR = EnumHelper.addArmorMaterial("STEAM_ARMOR", 12, new int [] {1, 2, 2, 1}, 9);
	// Damage reduction (each 1 point is a half a shield on gui) of the piece index passed (0 = helmet, 1 = plate, 2 = legs and 3 = boots)
    
	// ======= Actual Code from Proloe! ======= //
	/*
	WOOD("WOOD", 0, 0, 59, 2.0F, 0),
	STONE("STONE", 1, 1, 131, 4F, 1),
	IRON("IRON", 2, 2, 250, 6F, 2),
	EMERALD("EMERALD", 3, 3, 1561, 8F, 3),
	GOLD("GOLD", 4, 0, 32, 12F, 0),
	OBSIDIAN("OBSIDIAN", 5, 5, 210, 7F, 4),
	ETHERIUM("ETHERIUM", 6, 6, -1, 8F, 3),
	STEAM("STEAM", 7, 2, 321, 12F, 5);
	*/
}