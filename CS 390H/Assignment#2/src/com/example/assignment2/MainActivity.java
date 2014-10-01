package com.example.assignment2;

import android.app.*;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.*;

public class MainActivity extends Activity {
	private Intent launchProjectIntent = new Intent();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("MainActivity_OnCreate", "On create finished");
	}


	public void executeAssignment2(View view) {
		Log.i("MainActivity_executeAssignment2", "button pressed");
		launchProjectIntent = new Intent(this, Activity.class);
		startActivity(launchProjectIntent);
	}

}