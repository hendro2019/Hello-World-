/**
 * 
 */
package edu.metrostate.ics240.p1.jph142;

import java.util.Random;

/**
 * MultiGreeter is a collection class that stores Greeting objects for holding and
 * manipulating multiple String greetings.
 * 
 * @author John
 *
 */
public class MultiGreeter {
	// For a given MultiGreeter, we are only interested in the
	// elements stored in greetings[0] through greetings[numGreetings - 1].
	private String[] greetings;

	// The number of elements in the multiGreeter is in the instance variable
	// numGreetings.
	private int numGreetings;

	// SEED and RAND generate random numbers for method greet().
	private static final long SEED = 20190124001L;
	private static final Random RAND = new Random(SEED);

	/**
	 * Initializes this Greeter to size 1, this is the max greetings this Greeter can hold.
	 */
	public MultiGreeter() {
		this(1);
	}

	/**
	 * Initializes this Greeter to size maxGreetings, this is the max greetings this Greeter can
	 * hold.
	 * 
	 * @param maxGreetings the maximum number of greetings this Greeter can hold.
	 */
	public MultiGreeter(int maxGreetings) {
		if (maxGreetings < 1 || maxGreetings > 255 )
			throw new IllegalArgumentException("maxGreetings is out of range (1 - 255): " + maxGreetings);

		greetings = new String[maxGreetings];
	}

	/**
	 * Gets the maximum number of greetings this Greeter can hold.
	 * 
	 * @return maxGreetings The number of greetings this Greeter can hold.
	 */
	public int getMaxGreetings() {
		return greetings.length;
	}

	/**
	 * Gets the number of greetings currently in this Greeter.
	 * 
	 * @return numGreetings The current number of greetings in this Greeter.
	 */
	public int getNumGreetings() {
		return numGreetings;
	}

	/**
	 * If this Greeter is not at capacity, adds a greeting String to this Greeter
	 * and returns true. Else returns false
	 * 
	 * @param greeting A String containing a greeting
	 * @return Returns true if greeting has been added. Else returns false
	 */
	public boolean add(String greeting) {
		if (numGreetings == greetings.length)
			return false;

		greetings[numGreetings] = greeting;
		numGreetings++;
		return true;
	}

	/**
	 * Generates and returns a String[] containing all the greetings in this Greeter
	 * the size of which is number of greetings in this Greeter.
	 * 
	 * @return greetings A String[] containing all the greeting strings in this Greeter.
	 */
	public String[] getGreetings() {
		String[] greetings01 = new String[numGreetings];

		System.arraycopy(greetings, 0, greetings01, 0, numGreetings);

		return greetings01;
	}

	/**
	 * Returns a salutation in the form “greetingString, name!”
	 * if greetingString or name is null or empty, they will be assigned "Hello" and "World" respectively.  
	 * 
	 * @param name String holding a name
	 * @return salutation in the form “greetingString, name!”
	 */
	public String greet(String name) {
	

		return String.format("%s, %s!",
				numGreetings == 0  ? "Hello" : greetings[RAND.nextInt(numGreetings)].trim(), name.trim());
	}

	/**
	 * Returns a salutation in the form “greetingString, World!”
	 * if greetingString is null or empty, returns "Hello, World!"
	 * 
	 * @return Salutation in the form “greetingString, World!”
	 */
	public String greet() {
		return greet("World");
	}


}
