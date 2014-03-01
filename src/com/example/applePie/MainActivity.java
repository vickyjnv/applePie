package com.example.applePie;

import com.example.applePie.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String total="";
	Button cont;
	CheckBox jeremy;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		cont = (Button) findViewById(R.id.continueButton);
		cont.setEnabled(false);
		jeremy = (CheckBox) findViewById(R.id.jeremy);
		butter("Welcome to the Pit Scouting App!");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void love(View view) {
		if (jeremy.isChecked())
			cont.setEnabled(true);
		else
			cont.setEnabled(false);
	}

	public void nextScreen(View view) {

		fileWriter f = new fileWriter();

		EditText tNumber = (EditText) findViewById(R.id.tNumber);

		Spinner position = (Spinner) findViewById(R.id.position);
		Spinner driveTrain = (Spinner) findViewById(R.id.driveTrain);

		CheckBox hotGoal = (CheckBox) findViewById(R.id.hotGoal);
		CheckBox moveForward = (CheckBox) findViewById(R.id.moveForward);
		CheckBox trussShot = (CheckBox) findViewById(R.id.trussShot);
		CheckBox passing = (CheckBox) findViewById(R.id.passing);
		CheckBox defensiveArm = (CheckBox) findViewById(R.id.defensiveArm);
		CheckBox canShoot = (CheckBox) findViewById(R.id.canShoot);
		CheckBox canGather = (CheckBox) findViewById(R.id.canGather);
		CheckBox canCatch = (CheckBox) findViewById(R.id.canCatch);

		addTo(tNumber.getText().toString());
		addTo(position.getSelectedItem());
		addTo(driveTrain.getSelectedItem());
		addTo(hotGoal.isChecked());
		addTo(moveForward.isChecked());
		addTo(trussShot.isChecked());
		addTo(passing.isChecked());
		addTo(defensiveArm.isChecked());
		addTo(canShoot.isChecked());
		addTo(canGather.isChecked());
		addTo(canCatch.isChecked());

		if (position.getSelectedItem().toString().equals("POSITION")
				|| driveTrain.getSelectedItem().toString().equals("DRIVETRAIN")
				|| tNumber.getEditableText().toString().equals("")) {
			butter("Cannot advance because you are an idiot");
		} else {
			Intent intent = new Intent(this, TextPlace.class);
			intent.putExtra("dataOne", total);
			startActivity(intent);
			finish();
		}
	}

	public void updateSeekBar(View view) {
		SeekBar seek = (SeekBar) findViewById(R.id.driverXPBar);
		((TextView) findViewById(R.id.driverXPLabel)).setText(Integer
				.toString(seek.getProgress()));
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
	
	public String replaceNull(String s){
		return s.replace("null","");
	}

}
