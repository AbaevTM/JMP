package com.epam.jmp.tabayeu.classloading;

/**
 * Client of semaphore class.
 * @author Tsimur_Abayeu
 * Dec 25, 2015
 */
public class SemaphoreHandler {

	BasicSemaphore semaphore;

	/**
	 * Delegates call to Semaphore instance.
	 * @return
	 */
	public String useSemaphore() {
		return semaphore.lever();
	}

}
