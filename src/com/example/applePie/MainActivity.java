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

public class MainActivity extends Activity {
	EditText tNumber;
	EditText tName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		tName = (EditText)findViewById(R.id.tName);
		tNumber = (EditText)findViewById(R.id.tNumber);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void nextScreen(View view){
		fileWriter f = new fileWriter(tName.getEditableText().toString() + tNumber.getEditableText().toString());
		///CheckBox hotGoal = (CheckBox)findByViewId(R.id.hotGoal);
		//f.write()
		Intent intent = new Intent(this, TextPlace.class);
		startActivity(intent);
	}

}
