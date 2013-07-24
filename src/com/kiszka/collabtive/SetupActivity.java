package com.kiszka.collabtive;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class SetupActivity extends Activity {
	Button button;
	EditText theUrl;
	SharedPreferences prefs;
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
	       requestWindowFeature(Window.FEATURE_NO_TITLE); 
	       this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
	        setContentView(R.layout.activity_setup);
	        
	        prefs = PreferenceManager.getDefaultSharedPreferences(this);
	        button = (Button) findViewById(R.id.button1);
	        theUrl   = (EditText)findViewById(R.id.editText1);
	        
	         button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 String myUrl = theUrl.getText().toString();
	            	 
	            	if(!myUrl.isEmpty() && myUrl != null )
	            	{
	            	SharedPreferences.Editor editor = prefs.edit();
	         		editor.putString("theUrl", theUrl.getText().toString());
	         		editor.commit();
	         		Intent intent = new Intent(v.getContext(),FullscreenActivity.class);
	         		startActivity(intent);
	            	}
	            }
	         });

	      
	 }

}
