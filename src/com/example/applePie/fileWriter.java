package com.example.applePie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.os.Environment;


public class fileWriter {
	File file;
	
	public fileWriter(){
		file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),  "Pit Scouting");
		if(!file.exists()){
			file.mkdir();
			write("Team Number,Team Name,Position,Drive Train,Hot Goal,Move Forward,Truss Shot,Passing,Defensive Arm,Can Shoot,Can Gather,Can Catch,Driver XP,Overall Rating");
		}
		System.out.println("making file");
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