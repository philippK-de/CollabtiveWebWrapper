package com.kiszka.collabtive;


import com.kiszka.collabtive.util.SystemUiHider;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); 


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); 
        setContentView(R.layout.activity_fullscreen);

       // final View controlsView = findViewById(R.id.fullscreen_content_controls);
        final WebView contentView = (WebView) findViewById(R.id.webview);
        
        WebSettings webSettings = contentView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        
        contentView.setWebChromeClient(new WebChromeClient());
        
        contentView.setWebViewClient(new WebViewClient() {
        	
        	
        	public boolean shouldOverrideUrlLoading(WebView view, String url) {
        	          view.loadUrl(url);
        	          return true;
        	           }}); 
        
        contentView.addJavascriptInterface(new JSInterface(this), "Android");
        
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theUrl = prefs.getString("theUrl", null);
        
        if(theUrl != null)
        {
        	
        	contentView.loadUrl(theUrl);
        }
        else
        {
        	 Intent intent = new Intent(this, SetupActivity.class);
        	 startActivity(intent);
        // Set up an instance of SystemUiHider to control the system UI for
        }
    }




}
