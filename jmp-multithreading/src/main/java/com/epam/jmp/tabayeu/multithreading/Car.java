package com.epam.jmp.tabayeu.multithreading;

public class Car implements Runnable {

    private static final long MAX_DISTANCE = 10000;

    private long friction;

    private long distance;

    private String name;

    private Race race;

    public Car(String name, long friction, Race race) {
        this.name = name;
        this.friction = friction;
        this.race = race;
    }

    @Override
    public void run() {
    	boolean hasBeenInerrupted = false;
        try {
            while (distance < MAX_DISTANCE) {
            	if (Thread.interrupted()) {
            		hasBeenInerrupted = true;
            	}
                Thread.sleep(friction);
                distance += 100;
                System.out.println(name + " " + distance);
            }
        } catch (InterruptedException e) {
        	System.out.println(name + " interrupted while sleeping");
        	hasBeenInerrupted = true;
        }
        if (hasBeenInerrupted) {
        	System.out.println(Thread.currentThread().getName() + " Car :" + name + " Has been eliminated.");
        } else {
        	int thisCarPlace = race.getCurrentPlace().incrementAndGet();
        	race.getResults().put(
        			thisCarPlace,
        			this);
        	race.getEveryCarHasFinished().countDown();
        	System.out.println(name + " finishes at place : " + thisCarPlace);
        }
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
