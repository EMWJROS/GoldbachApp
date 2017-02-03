package com.surimisoft.goldbachapp;

import android.app.Activity;
import android.view.View;

/*************************************************************************************
 *  A Class that performs the search for odd composite numbers that are not Goldbach
 *
 *************************************************************************************/
public class GoldbachSearch implements Runnable {
	
	/** The limit for the search */
	static int MAX_NUM;
	/** The activity conneced with the search */
	static Activity activity;
	/** The view that will handle UI events */
	static View view;
	
	/*********************************************************
	 * Constructs a GoldbachSearch object
	 *
	 * @param m The search limit
	 * @param g The associated activity
	 * @param v The viea that handles the UI
	 ********************************************************/
	public GoldbachSearch(int m, GoldbachActivity g, View v) {
		MAX_NUM = m;
		activity = g;
		view = v;
	}
	
	private static boolean isOdd(int x) {
		  return (x%2 == 1);
	}

	private static boolean isGoldbachNumber(int x) {
		int maxSquare = (int) Math.sqrt(x/2.0);
		boolean goldbachNumber = false;
		// Test possible squares
		int s = 1;
		while ((s <= maxSquare) && !goldbachNumber) {
		  // Check if the remainder is a prime
		  // If it is, we have found a Goldbach number
		  goldbachNumber = SetOfPrimeNumbers.isMember(x - 2*s*s);
		   // Check next square
		  ++s;
		}
		return goldbachNumber;
	}

	@Override
	public void run() {
    	int i = 2;
		boolean found = false;
		while (i < MAX_NUM) {
			// Check odd composite number
			if ( isOdd(i) && !SetOfPrimeNumbers.isMember(i) ) {
			  // We have found it if it isn't a Goldbach number
			  if (!isGoldbachNumber(i)) {
				  found = true;
				  view.post(new ToastMessage(i + activity.getString(R.string.found_toast), 
						                              activity));
			  };
			}
			++i;
		}
		if (found) {
			  view.post(new ToastMessage(activity.getString(R.string.no_further_toast),
									     activity));
		}
		else {
			  view.post(new ToastMessage(activity.getString(R.string.no_numbers_toast),
								 activity));
		}			
				  
	}

}
