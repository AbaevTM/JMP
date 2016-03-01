package com.epam.jmp.tabayeu.classloading;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test for custom Semaphore class loader.
 * @author Tsimur_Abayeu
 * Dec 25, 2015
 */
public class ClassLoaderTest {

	private static SemaphoreHandler handler;

	private static SemaphoreClassLoader classLoader;

	@BeforeClass
	public static void initialize() {
		handler = new SemaphoreHandler();
	}

	/**
	 * Tests that loading of .class file happens and inner instance of handler is
	 * instantiated with new object of loaded Semaphore class.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void classLoadingWorks() throws ClassNotFoundException {
		handler.semaphore = null;
		reloadClass("1");
		Assert.assertNotNull(handler.semaphore);
	}

	/**
	 * Tests that loading of .class file happens and loaded class then can be dinamically
	 * changed to other version.
	 * @throws ClassNotFoundException
	 */
	@Test
	public void classLoadingWorksWithDynamicChane() throws ClassNotFoundException {
		reloadClass("1");
		Assert.assertEquals(handler.useSemaphore(), "1");
		// Here other version is loaded and 2 should be returned.
		reloadClass("2");
		Assert.assertEquals(handler.useSemaphore(), "2");
	}

	/**
	 * @throws ClassNotFoundException
	 */
	private void reloadClass(String versionName) throws ClassNotFoundException {
		classLoader = new SemaphoreClassLoader(BasicSemaphore.class.getClassLoader());
		classLoader.setHandler(handler);
		classLoader.loadClass(versionName);
	}
}
