package com.example.ceritalegendadenganintegrasibarcode;

import android.content.Context;

public class Dao {
	private Database dbHelper;
	
	public Dao(Context context){
		dbHelper = new Database(context);
	}
	

	
	public void close(){
		dbHelper.close();
	}
}
