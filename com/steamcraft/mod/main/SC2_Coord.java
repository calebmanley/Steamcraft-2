package com.steamcraft.mod.main;

/**
 * Integer coordinate class, can be used to hold information about position or a movement vector
 * 
 */
public class SC2_Coord 
{
	public static SC2_Coord instance;
	public int x, y, z;

	/**
	 * Create coordinate [x,y,z]
	 * 
	 * @param a x
	 * @param b y
	 * @param c z
	 */
	public SC2_Coord(int a, int b, int c) 
	{
		x = a;
		y = b;
		z = c;
	}

	/**
	 * Copy the give coordinate
	 * @param coord
	 */
	public SC2_Coord(SC2_Coord coord) 
	{
		x = coord.x;
		y = coord.y;
		z = coord.z;
	}

	/**
	 * Return a copy of this coordinate
	 * @return
	 */
	public SC2_Coord copy() 
	{
		return new SC2_Coord(x, y, z);
	}

	/**
	 * Tests if the coordinates have equal numbers;
	 * if both are null, they are also equal
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null) 
		{
			return false;
		}
		if(!this.getClass().equals(obj.getClass())) 
		{
			return false;
		}

		return ((SC2_Coord) obj).x == x && ((SC2_Coord) obj).y == y && ((SC2_Coord) obj).z == z;
	}
}