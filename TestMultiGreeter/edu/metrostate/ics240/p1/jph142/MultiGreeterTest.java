package edu.metrostate.ics240.p1.jph142;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MultiGreeterTest {

	@Test
	void testCreate() {
		MultiGreeter mg = new MultiGreeter();
		MultiGreeter mg02 = new MultiGreeter(10);
		MultiGreeter mg03 = new MultiGreeter(1);
		MultiGreeter mg04 = new MultiGreeter(255);
		
		assertThrows(IllegalArgumentException.class, ()->{new MultiGreeter(0);});
		assertThrows(IllegalArgumentException.class, ()->{new MultiGreeter(256);});

		assertEquals(1, mg.getMaxGreetings());
		assertEquals(10, mg02.getMaxGreetings());
		assertEquals(1, mg03.getMaxGreetings());
		assertEquals(255, mg04.getMaxGreetings());

		assertEquals(0, mg.getNumGreetings());
		assertEquals(0, mg02.getNumGreetings());
		
		
	}

	@Test
	void testAdd() {
		MultiGreeter mg = new MultiGreeter();
		MultiGreeter mg02 = new MultiGreeter(10);

		assertEquals(true, mg.add("Aloha"));
		assertEquals(false, mg.add("Good morning"));

		assertEquals(true, mg02.add("Hi"));
		assertEquals(true, mg02.add("Hey"));
		assertEquals(true, mg02.add(null));
		
		assertEquals(1, mg.getNumGreetings());
		assertEquals(3, mg02.getNumGreetings());
	}

	@Test
	void testGetGreetings() {
		MultiGreeter mg = new MultiGreeter();
		MultiGreeter mg02 = new MultiGreeter(10);

		String[] get = mg.getGreetings();
		String[] get02 = mg02.getGreetings();

		assertEquals(0, get.length);
		assertEquals(0, get02.length);

		mg.add("Aloha");
		mg02.add("Hi");
		mg02.add("Hey");
		mg02.add(null);
		
		// tests to see if changes to mg affect get[].
		assertEquals(0, get.length);
		assertEquals(0, get02.length);
		
		assertEquals("[Hi, Hey, null]", Arrays.toString(mg02.getGreetings()));
		assertEquals("[Aloha]", Arrays.toString(mg.getGreetings()));
	}

	@Test
	void testGreet() {
		MultiGreeter mg = new MultiGreeter();
		MultiGreeter mg02 = new MultiGreeter(10);
		
		assertEquals("Hello, World!", mg.greet());
		assertEquals("Hello, World!", mg02.greet());
		assertEquals("Hello, John!", mg.greet("John"));

		mg.add("Aloha");
		mg02.add("Hi");
		mg02.add("Hey");
		mg02.add("Howdy");

		assertEquals("Aloha, World!", mg.greet());
		assertEquals("Aloha, John!", mg.greet("John"));

		assertEquals(true, mg02.greet().matches("(Hi|Hey|Howdy), World!"));
		assertEquals(true, mg02.greet("Bambam").matches("(Hi|Hey|Howdy), Bambam!"));
	}

	/*
	 * @Test void testRand() { int i; for(i = 0; i < 100; i++)
	 * System.out.println(MultiGreeter.randBetween(50, 100));
	 * 
	 * }
	 */

}
