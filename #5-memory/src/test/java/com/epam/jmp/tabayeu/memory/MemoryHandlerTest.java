package com.epam.jmp.tabayeu.memory;

import org.junit.Before;
import org.junit.Test;

import com.epam.jmp.tabayeu.memory.MemoryHandler;

/**
 * MemoryHandler test.
 * @author Tsimur_Abayeu
 *
 */
public class MemoryHandlerTest {

	private MemoryHandler handler;

	@Before
	public void initialize() {
		handler = new MemoryHandler();
	}

	@Test
	public void handleHeapArea() {
	    boolean exceptionIsThrown = false;
	    try {
	        handler.breakHeap();
        } catch (OutOfMemoryError e) {
            if (e.getMessage().toLowerCase().contains("heap")) {
                exceptionIsThrown = true;
                System.out.println(e.getMessage());
            }
            else {
                throw new IllegalStateException();
            }
        }
	    if (!exceptionIsThrown) {
	        throw new IllegalStateException();
	    }
	}

	@Test
    public void handlePermGenArea() throws Exception {
	    boolean exceptionIsThrown = false;
        try {
            handler.breakPermGen();
        } catch (OutOfMemoryError e) {
            if (e.getMessage().toLowerCase().contains("perm")) {
                exceptionIsThrown = true;
                System.out.println(e.getMessage());
            }
            else {
                throw new IllegalStateException();
            }
        }
        if (!exceptionIsThrown) {
            throw new IllegalStateException();
        }
    }
}
