package com.knightfinderapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	@Override
  public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
        
    // Create an object of type SplashHandler.
    SplashHandler mHandler = new SplashHandler();
    
    // Set the layout for this activity
    setContentView(R.layout.activity_splash);
        
    @SuppressWarnings("unused")
		ImageView image = (ImageView) findViewById(R.id.splash);
        
    // Create a Message object
    Message msg = new Message();
    
    // Assign a unique code to the message.
    // Later, this code will be used to identify the message in Handler class.
    msg.what = 0;
    
    // Send the message with a delay of 3 seconds(3000 = 3 sec).
    mHandler.sendMessageDelayed(msg, 3000);
        
	}

	private class SplashHandler extends Handler {

		// This method is used to handle received messages
    public void handleMessage(Message msg) {

    	// Switch to identify the message by its code
    	switch (msg.what) {
    		default:
    	  case 0:
    	  	super.handleMessage(msg);
    	      
    	    // Create an intent to start the new activity.
    	    // Our intention is to start MainActivity
    	    Intent intent = new Intent();
    	    intent.setClass(SplashActivity.this,KnightFinderActivity.class);
    	    startActivity(intent);
    	    
    	    // Finish the current activity
    	    SplashActivity.this.finish();
    	}
    }
	}

}
