package com.example.applePie;

import com.example.applePie.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class TextPlace extends Activity {

	String total = "";

	SeekBar finalBar;
	SeekBar driverXP;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text_place);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		finalBar = (SeekBar) findViewById(R.id.finalRatingBar);
		driverXP = (SeekBar) findViewById(R.id.driverXPBar);

		final TextView finalLabel = (TextView) findViewById(R.id.ratingLabel);
		final TextView XPLabel = (TextView) findViewById(R.id.driverXPLabel);

		OnSeekBarChangeListener s = new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				finalLabel.setText(String.valueOf(progress));
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
		};

		OnSeekBarChangeListener s2 = new OnSeekBarChangeListener() {
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

				XPLabel.setText(String.valueOf(progress));
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
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

	public void finishWrite(View view) {

		fileWriter f = new fileWriter();

		EditText special = (EditText) findViewById(R.id.special);
		EditText notes = (EditText) findViewById(R.id.finalNotes);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String dataOne = extras.getString("dataOne");
			total += dataOne;
			addTo(fixReturnAndCommas(special.getEditableText().toString()));
			addTo(fixReturnAndCommas(notes.getEditableText().toString()));
			addTo(driverXP.getProgress());
			addTo(finalBar.getProgress());
			total += '\n';

			f.write(total);
			butter("Submission Submerged");
			finish();
		}else{
			butter("Issues with previous values");
		}

	}

	public void addTo(Object s) {

		total += s + ",";
	}

	public void butter(String s) {
		Context context = getApplicationContext();
		CharSequence text = s;
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}
	
	public String fixReturnAndCommas(String s){
		s = s.replace("\n", "  ");
		return s.replace(",", "/");
	}

}
