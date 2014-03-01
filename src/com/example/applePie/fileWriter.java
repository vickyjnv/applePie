package com.example.applePie;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.os.Environment;


public class fileWriter {
	File file;
	
	public fileWriter(){
		file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),  "Pit Scouting.csv");
		if(!file.exists()){
			try {
				file.createNewFile();
				write("Team Number,Position,Drive Train,Hot Goal,Move Forward,Truss Shot,Passing,Defensive Arm,Can Shoot,Can Gather,Can Catch,Special Notes,Final Notes,Driver XP,Overall Rating,\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String write(String data){
		OutputStream os;
		OutputStreamWriter osw;
		try {
			os = new FileOutputStream(file, true);
			osw = new OutputStreamWriter(os);
			osw.write(data);
			osw.flush();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "didn't work";
		}
		return "works";
		
	}
	
}