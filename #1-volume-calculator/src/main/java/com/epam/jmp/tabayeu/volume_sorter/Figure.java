package com.epam.jmp.tabayeu.volume_sorter;

import java.util.List;

/**
 * Figure is defined by list of planes.
 * @author Tsimur_Abayeu
 * Nov 28, 2015
 */
public class Figure {

	private List<Plane> planes;

	/**
	 * @param planes
	 */
	public Figure(List<Plane> planes) {
		super();
		this.planes = planes;
	}

	public boolean isPointBelongsToFigure(final Point point) {
		boolean result = true;
		for (Plane plane : planes) {
			result = plane.isPointBelongsToSubspace(point);
			if (!result) {
				break;
			}
		}
		return result;
	}
}
