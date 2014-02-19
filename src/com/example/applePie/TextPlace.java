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
		final TextView  label = (TextView) findViewById(R.id.ratingLabel);
		
		SeekBar driverXP = (SeekBar)findViewById(R.id.seekBar1);
		
		OnSeekBarChangeListener s = new OnSeekBarChangeListener()
        {
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				
				label.setText(String.valueOf(progress));
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
		
		driverXP.setOnSeekBarChangeListener(s);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.text_place, menu);
		return true;
	}

}
