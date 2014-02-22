package com.example.applePie;

import com.example.applePie.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	String total;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void nextScreen(View view){
		
		fileWriter f = new fileWriter();
		
		EditText tNumber = (EditText)findViewById(R.id.tNumber);
		EditText tName = (EditText)findViewById(R.id.tName);
		
		Spinner position = (Spinner)findViewById(R.id.position);
		Spinner driveTrain = (Spinner)findViewById(R.id.driveTrain);
		
		CheckBox hotGoal = (CheckBox)findViewById(R.id.hotGoal);
		CheckBox moveForward = (CheckBox)findViewById(R.id.moveForward);
		CheckBox trussShot = (CheckBox)findViewById(R.id.trussShot);
		CheckBox passing = (CheckBox)findViewById(R.id.passing);
		CheckBox defensiveArm = (CheckBox)findViewById(R.id.defensiveArm);
		CheckBox canShoot = (CheckBox)findViewById(R.id.canShoot);
		CheckBox canGather = (CheckBox)findViewById(R.id.canGather);
		CheckBox canCatch = (CheckBox)findViewById(R.id.canCatch);
		
		
		addTo(tNumber.getEditableText().toString());
		addTo(tName.getEditableText().toString());
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
		
		f.write(total);
		
		Intent intent = new Intent(this, TextPlace.class);
		startActivity(intent);
	}
	
	public void updateSeekBar(View view){
		SeekBar seek = (SeekBar) findViewById(R.id.driverXPBar);
	    ((TextView) findViewById(R.id.driverXPLabel)).setText(Integer.toString(seek.getProgress()));
	    System.out.println("updating bar");
	}
	
	
	
	public void addTo(Object s){
		
		total += s +",";
	}
	
}
