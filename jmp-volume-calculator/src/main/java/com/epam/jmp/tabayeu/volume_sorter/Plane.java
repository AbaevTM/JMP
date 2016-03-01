package com.epam.jmp.tabayeu.volume_sorter;

public class Plane {

	private float a;

	private float b;

	private float c;

	private float d;

	private boolean inverseNormal;

	/**
	 *
	 * Each plane is defined as ax + by + cz + d = 0
	 *
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param inverseNormal is used while calculating whether a point belongs to one of subspaces that
	 * 			have been separated by the pane.
	 */
	public Plane(float a, float b, float c, float d, boolean inverseNormal) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.inverseNormal = inverseNormal;
	}

	public boolean isPointBelongsToSubspace(final Point point) {
		boolean result = (a * point.x + b * point.y + c * point.z + d) > 0;
		if (inverseNormal) {
			result = !result;
		}
		return result;
	}

}
