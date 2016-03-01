package com.epam.jmp.tabayeu.memory;

import java.util.ArrayList;
import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassPool;

/**
 * Handles memory gracefully.
 * @author Tsimur_Abayeu
 *
 */
public class MemoryHandler {

	/**
	 * Handles permGen memory area.
	 * @return
	 * @throws RuntimeException
	 * @throws CannotCompileException
	 */
	public void breakPermGen() throws CannotCompileException, RuntimeException {
	    ClassPool dummyClassesPool = ClassPool.getDefault();
	    int currentClassIndex = 0;
	    boolean appIsHardcoreAndWeNeedToCreateSomeClassesFirst = true;
        while(appIsHardcoreAndWeNeedToCreateSomeClassesFirst) {
            dummyClassesPool.makeClass("dummy" + currentClassIndex++).toClass();
        }
        System.out.println("Application warm-up is finished now");
	    return ;
	}

	/**
	 * Handles heap memory area.
	 */
	public void breakHeap() {
	    List<Object> myObjectCacheGoingToBeUsedToTrackAllCreatedByTheAppObjectsAsThisAppIsAKindOfHardcoreApp =
	            new ArrayList<>();
	    boolean appIsHardcoreAndWeNeedToTrackEveryObject = true;
	    while(appIsHardcoreAndWeNeedToTrackEveryObject) {
	        myObjectCacheGoingToBeUsedToTrackAllCreatedByTheAppObjectsAsThisAppIsAKindOfHardcoreApp.add(
	                new ObjectWrapper());
	    }
	    // Now let's print a number of created objects
	    // using hardcore logging library System.out
	    System.out.println(
	            myObjectCacheGoingToBeUsedToTrackAllCreatedByTheAppObjectsAsThisAppIsAKindOfHardcoreApp.size());
	}

	private static class ObjectWrapper {

	    private byte[] objectWrapperMetadata = new byte [1000];

        public ObjectWrapper() {
            super();
            objectWrapperMetadata[0] = 1;
        }

	}
}
