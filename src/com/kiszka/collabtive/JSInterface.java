package com.kiszka.collabtive;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class JSInterface {
	
	  Context mContext;
	  SharedPreferences prefs;
	    /** Instantiate the interface and set the context */
	  	JSInterface(Context c) {
	        mContext = c;
	           
	        prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
	    }

	public void submitURL(String theUrl)
	{
		 Activity a = (Activity) mContext;
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString("theUrl", theUrl);
		editor.commit();
	}
	
}