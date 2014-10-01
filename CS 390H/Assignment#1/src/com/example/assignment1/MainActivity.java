package com.example.assignment1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.graphics.*;

public class MainActivity extends Activity {



    private static NumberPicker redNP = null;
    private static NumberPicker greenNP = null;
    private static NumberPicker blueNP = null;
    private static ImageView drawingImageView = null;
    private boolean intentFlag = false;
    private Intent passedIntent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);

    	passedIntent = getIntent();


    	redNP = (NumberPicker) findViewById(R.id.numberPicker1);
    	greenNP = (NumberPicker) findViewById(R.id.numberPicker2);
    	blueNP = (NumberPicker) findViewById(R.id.numberPicker3);

    	OnValueChangeListener colorValueChangeListener = new OnValueChangeListener() {
    		@Override
    		public void onValueChange(NumberPicker picker, int oldVal,
    				int newVal) {
    			Bitmap bitmap = Bitmap.createBitmap(getWindowManager()
    					.getDefaultDisplay().getWidth(), getWindowManager()
    					.getDefaultDisplay().getHeight(),
    					Bitmap.Config.ARGB_8888);
    			Canvas canvas = new Canvas(bitmap);
    			drawingImageView.setImageBitmap(bitmap);

    			canvas.drawRGB(redNP.getValue(), greenNP.getValue(),
    					blueNP.getValue());
    		}
    	};

    	redNP.setMinValue(0);
    	redNP.setMaxValue(255);
    	greenNP.setMinValue(0);
    	greenNP.setMaxValue(255);
    	blueNP.setMinValue(0);
    	blueNP.setMaxValue(255);
    	
    	if (passedIntent != null) {
    		intentFlag = true;
    		redNP.setValue(Color.red(passedIntent.getIntExtra("CURRENT_COLOR",
    				0)));
    		greenNP.setValue(Color.green(passedIntent.getIntExtra(
    				"CURRENT_COLOR", 0)));
    		blueNP.setValue(Color.blue(passedIntent.getIntExtra(
    				"CURRENT_COLOR", 0)));
    	}

    	drawingImageView = (ImageView) this.findViewById(R.id.imageView1);
    	Bitmap bitmap = Bitmap.createBitmap(getWindowManager()
    			.getDefaultDisplay().getWidth(), getWindowManager()
    			.getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
    	Canvas canvas = new Canvas(bitmap);
    	drawingImageView.setImageBitmap(bitmap);

    	// Rectangle

    	Paint paint = new Paint();
    	paint.setColor(Color.rgb(redNP.getValue(), greenNP.getValue(),
    			blueNP.getValue()));
    	paint.setStyle(Paint.Style.FILL_AND_STROKE);
    	paint.setStrokeWidth(10);
    	float leftx = 0;
    	float topy = 0;
    	float rightx = bitmap.getWidth();
    	float bottomy = bitmap.getHeight();

    	canvas.drawRect(leftx, topy, rightx, bottomy, paint);

    	redNP.setOnValueChangedListener(colorValueChangeListener);
    	greenNP.setOnValueChangedListener(colorValueChangeListener);
    	blueNP.setOnValueChangedListener(colorValueChangeListener);

    	Log.i("Assignemtn1_OnCreate", "On create finished");

    }

    @Override
    public void onStop() {
    	super.onStop();

    	passedIntent.putExtra(
    			"COLOR_PICKED",
    			Color.rgb(redNP.getValue(), greenNP.getValue(),
    					blueNP.getValue()));
    	setResult(Activity.RESULT_OK, passedIntent);
    	finish();
    }

    public void updateColor(View view) {
    	Bitmap bitmap = Bitmap.createBitmap(getWindowManager()
    			.getDefaultDisplay().getWidth(), getWindowManager()
    			.getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
    	Canvas canvas = new Canvas(bitmap);
    	drawingImageView.setImageBitmap(bitmap);

    	canvas.drawRGB(redNP.getValue(), greenNP.getValue(), blueNP.getValue());

    	if (intentFlag) {
    		passedIntent.putExtra(
    				"COLOR_PICKED",
    				Color.rgb(redNP.getValue(), greenNP.getValue(),
    						blueNP.getValue()));
    		setResult(Activity.RESULT_OK, passedIntent);
    		finish();
    	}
    }
}


    