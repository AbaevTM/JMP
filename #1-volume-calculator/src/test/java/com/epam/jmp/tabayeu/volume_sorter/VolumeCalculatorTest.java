package com.epam.jmp.tabayeu.volume_sorter;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class VolumeCalculatorTest {

	public static final float delta = 0.15f;

	/**
     * Calculate cube's (0.5 * 0.5 * 0.5) volume - should be around 0.125
     * Covering figure - cube (1 * 1 * 1)
     */
	@Test
    public void cubeTest() {
		Plane plane1 = new Plane(0, 0, 1, 0, false);
		Plane plane2 = new Plane(0, 1, 0, 0, false);
		Plane plane3 = new Plane(1, 0, 0, 0, false);
		Plane plane4 = new Plane(0, 0, 1, -0.5f, true);
		Plane plane5 = new Plane(0, 1, 0, -0.5f, true);
		Plane plane6 = new Plane(1, 0, 0, -0.5f, true);
        Figure smallCube = new Figure(Arrays.asList(plane1, plane2, plane3, plane4, plane5, plane6));
        float figureVolume = VolumeCalculator.calculateVolume(smallCube, 1, 1, 1);
        assertVolumeWothinExpectedRange(figureVolume, 0.125f);
    }

	/**
     * Calculate triangular prism's (1 * 1 * square(2) - base; height = 1) volume - should be around 0.5
     * Covering figure - cube (1 * 1 * 1)
     */
	@Test
    public void cubePrismTest() {
		Plane plane1 = new Plane(0, 0, 1, 0, false);
		Plane plane2 = new Plane(0, 1, 0, 0, false);
		Plane plane3 = new Plane(1, 0, 0, 0, false);
		Plane plane4 = new Plane(0, 0, 1, -1, true);
		Plane plane5 = new Plane(0, 1, 0, -1, true);
		Plane plane6 = new Plane(1, 0, 0, -1, true);
		Plane plane7 = new Plane(1, 1, 0, -1, true);
        Figure smallPrism = new Figure(Arrays.asList(plane1, plane2, plane3, plane4, plane5, plane6, plane7));
        float figureVolume = VolumeCalculator.calculateVolume(smallPrism, 1, 1, 1);
        assertVolumeWothinExpectedRange(figureVolume, 0.5f);
    }

	private void assertVolumeWothinExpectedRange(
			final float volume,
			final float expectedVolume) {
		Assert.assertTrue(volume >= expectedVolume * (1 - delta));
		Assert.assertTrue(volume <= expectedVolume * (1 + delta));
	}
}
