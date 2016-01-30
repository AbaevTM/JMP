package com.epam.jmp.tabayeu.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {

	private ExecutorService executor;

	private Map<Integer, Car> results = new ConcurrentHashMap<>();

	private AtomicInteger currentPlace = new AtomicInteger(0);

	private CountDownLatch everyCarHasFinished;

	private String winnerName;

	public void startRace(Car ... cars) {
		everyCarHasFinished = new CountDownLatch(cars.length);
		executor = Executors.newFixedThreadPool(cars.length);
		List<Future<Object>> futures = new ArrayList<>();
		for (Runnable car : cars) {
			futures.add(executor.submit(car, null));
		}
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (Future<Object> future : futures) {
			if (!future.isDone()) {
				future.cancel(true);
				everyCarHasFinished.countDown();
				break;
			}
		}
		try {
			System.out.println("Race is waiting until everybody finishes.");
			everyCarHasFinished.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("The winner is : " + results.get(1).getName());
		winnerName = results.get(1).getName();
		executor.shutdownNow();
	}

	public Map<Integer, Car> getResults() {
		return results;
	}

	public void setResults(Map<Integer, Car> results) {
		this.results = results;
	}

	public AtomicInteger getCurrentPlace() {
		return currentPlace;
	}

	public void setCurrentPlace(AtomicInteger currentPlace) {
		this.currentPlace = currentPlace;
	}

	public CountDownLatch getEveryCarHasFinished() {
		return everyCarHasFinished;
	}

	public void setEveryCarHasFinished(CountDownLatch everyCarHasFinished) {
		this.everyCarHasFinished = everyCarHasFinished;
	}

	public String getWinnerName() {
		return winnerName;
	}

	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}

}
