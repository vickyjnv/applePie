package com.example.applePie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.os.Environment;


public class fileWriter {
	File file;
	
	public fileWriter(String s){
		file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), s + " Pit" );
	}
	
	public void write(String data){
		OutputStream os;
		try {
			os = new FileOutputStream(file, true);
			os.write(data.getBytes());
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}