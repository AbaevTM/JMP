package com.epam.jmp.tabayeu.volume_sorter;

/**
 * Really simple things are going there, stupid!
 * @author Tsimur_Abayeu
 * Nov 28, 2015
 */
public class VolumeCalculator {

	public static final float INCREMENT = 0.01f;

	/**
	 * Calculates approximate volume (can be configured with INCREMENT value)
	 * of figure defined by any number of planes.
	 *
	 * @param figure
	 * @param coveringOXEdge
	 * @param coveringOYEdge
	 * @param coveringOZEdge
	 * @return
	 */
	public static float calculateVolume(
			final Figure figure,
			final float coveringOXEdge,
			final float coveringOYEdge,
			final float coveringOZEdge) {
		float coveringFigureVolume = coveringOXEdge * coveringOYEdge * coveringOZEdge;
		long numberOfPoints = 0;
		long numberOfPointsWithinFugure = 0;
		Point curentPoint = new Point(0, 0, 0);
		for (float x = 0; x < coveringOXEdge; x += INCREMENT) {
			for (float y = 0; y < coveringOYEdge; y += INCREMENT) {
				for (float z = 0; z < coveringOZEdge; z += INCREMENT) {
					curentPoint.x = x;
					curentPoint.y = y;
					curentPoint.z = z;
					numberOfPoints++;
					if (figure.isPointBelongsToFigure(curentPoint)) {
						numberOfPointsWithinFugure++;
					}
				}
			}
		}
		// Calculation of volume is simple, stupid!
		float figureVolume = coveringFigureVolume * ((float) numberOfPointsWithinFugure / numberOfPoints);
		// Simple logging using System.out
		System.out.println("Number of points " + numberOfPoints);
		System.out.println("Number of points within figure " + numberOfPointsWithinFugure);
		System.out.println("Covering figure volume " + coveringFigureVolume);
		System.out.println("Figure volume " + figureVolume);
		return figureVolume;
	}

}
