package com.surimisoft.goldbachapp;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/****************************************************************************
 *  Class to model the set of all primes
 *
 ***************************************************************************/
public class SetOfPrimeNumbers {
	
	// Initialize the set with the first (and most basic) prime
	/** The highest number that has been tested so far */
	private static int maximum = 2;
	/** The already determined primes (below maximum)*/
	private static TreeSet<Integer> primes = new TreeSet<Integer>(Arrays.asList(2));

	/********************************************************************
	 *  Checks if an integer is a member of the set of all prime numbers
	 *
	 *  @param a The integer to check
	 *  @return True or false
	 ********************************************************************/
	public static boolean isMember(int a) {
	  if (a >= maximum) {
		checkAndGenerate(a);
	  }

	  return primes.contains(a);
	}

	private static void checkAndGenerate(int newHigh) {
	  if (newHigh > maximum) {
		for (int i=maximum+1; i<=newHigh; ++i) {
			if ( isPrime(i) ) {
				primes.add(i);
			}
		}
		maximum = newHigh;
	  }
	}

	/*************************************************************************
	 *  Checks if a given integer is a prime using the Sieve of Eratosthenes
	 *
	 *  NB: The calculation is quite expensive and should only be done once
	 *      per integer. Only for internal use.
	 *
	 *  @param a The integer to check
	 *  @return True or false
	 *************************************************************************/
	private static boolean isPrime(int a) {
	  // We only need to check up to the square root
	  int limit = (int) Math.sqrt(a);
	  // Make sure that our internal data is fully stocked
	  checkAndGenerate(limit);
	  
	  // Check if any of the existing primes is a divisor
	  Iterator<Integer> it = primes.iterator();
	  boolean divisor = false;
	  boolean reachedLimit = false;
	  while (!reachedLimit && it.hasNext() && !divisor)
	  {
		int nextValue = it.next();
		if (nextValue <= limit) {
			divisor = (a%(nextValue) == 0);
		}
		else {
			reachedLimit = true;
		}
	  }

	  return !divisor;
	}

}
