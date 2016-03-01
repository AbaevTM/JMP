package com.epam.jmp.tabayeu.multithreading;

import org.junit.Assert;
import org.junit.Test;

/**
 * Race test.
 * @author Tsimur_Abayeu
 * Jan 30, 2016
 */
public class RaceTest {

	@Test
	public void race() {
		Race race = new Race();
		Car car1 = new Car("Car1", 5, race);
		Car car2 = new Car("Car2", 200, race);
		Car car3 = new Car("Car3", 220, race);
		Car car4 = new Car("Car4", 230, race);
		Car car5 = new Car("Car5", 240, race);
		race.startRace(car1, car2, car3, car4, car5);
		Assert.assertEquals(race.getWinnerName(), "Car1");
	}
}
