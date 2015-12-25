package com.epam.jmp.tabayeu.classloading;

import java.io.File;
import java.nio.file.Files;

/**
 * Custom class loader that reads provided .class file
 * using provided version number.
 * @author Tsimur_Abayeu
 * Dec 25, 2015
 */
public class SemaphoreClassLoader extends ClassLoader {

	/**
	 * @param parent
	 */
	public SemaphoreClassLoader(ClassLoader parent) {
		super(parent);
	}

	private SemaphoreHandler handler;

	/**
	 * Treating name as version number.
	 */
	@Override
	public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		System.out.println("Semaphore class loader");
		System.out.println("Passed name :" + name);
		byte[] classFileBytes = null;
		Class<?> newSemaphoreClass = null;
		if ("1".equals(name) || "2".equals(name)) {
			System.out.println("Using custom way to load a class");
			try {
				classFileBytes = Files.readAllBytes(
						new File(
								this.getClass().getClassLoader().getResource(
										"./Semaphore" + name + ".class").toURI()).toPath());
				newSemaphoreClass = defineClass("com.epam.jmp.tabayeu.classloading.Semaphore", classFileBytes, 0, classFileBytes.length);
				handler.semaphore = (BasicSemaphore) newSemaphoreClass.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Parent classloader is used to load the class:" + getParent());
			newSemaphoreClass = getParent().loadClass(name);
		}
        return newSemaphoreClass;
    }

	public SemaphoreHandler getHandler() {
		return handler;
	}

	public void setHandler(SemaphoreHandler handler) {
		this.handler = handler;
	}
}
