package com.surimisoft.goldbachapp;

import android.app.Activity;
import android.widget.Toast;

/**********************************************************
 *  Class that encapsulates a toast meassage
 *
 **********************************************************/
public class ToastMessage implements Runnable {
	
	/** The message to display */
	private String toastMessage;
	/** The activity that owns the UI */
	private Activity activity;
	
	/****************************************************
     *	Constructs a ToastMessage object
	 *
	 *  @param tm The message to display
	 *  @param a  The activity that owns the UI
	 ****************************************************/
	public ToastMessage(String tm, Activity a) {
		toastMessage = tm;
		activity = a;
	}

	@Override
	public void run() {
		  Toast.makeText(activity,
				  toastMessage,
				  Toast.LENGTH_LONG).show();
	  }

}
