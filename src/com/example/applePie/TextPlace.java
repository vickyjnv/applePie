package com.example.applePie;

import com.example.applePie.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class TextPlace extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_place);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		final TextView  finalLabel = (TextView) findViewById(R.id.ratingLabel);
		final TextView  XPLabel = (TextView) findViewById(R.id.driverXPLabel);
		
		SeekBar finalBar = (SeekBar)findViewById(R.id.finalRatingBar);
		SeekBar driverXP = (SeekBar)findViewById(R.id.driverXPBar);
		
		OnSeekBarChangeListener s = new OnSeekBarChangeListener()
        {
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				
				finalLabel.setText(String.valueOf(progress));
			}
			
			public void onStartTrackingTouch(SeekBar seekBar)
			{
				// TODO Auto-generated method stub
			}
			
			public void onStopTrackingTouch(SeekBar seekBar)
			{
				// TODO Auto-generated method stub
			}
		};
		
		OnSeekBarChangeListener s2 = new OnSeekBarChangeListener()
        {
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				
				XPLabel.setText(String.valueOf(progress));
			}
			
			public void onStartTrackingTouch(SeekBar seekBar)
			{
				// TODO Auto-generated method stub
			}
			
			public void onStopTrackingTouch(SeekBar seekBar)
			{
				// TODO Auto-generated method stub
			}
		};
		
		driverXP.setOnSeekBarChangeListener(s2);
		finalBar.setOnSeekBarChangeListener(s);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text_place, menu);
		return true;
	}

}
