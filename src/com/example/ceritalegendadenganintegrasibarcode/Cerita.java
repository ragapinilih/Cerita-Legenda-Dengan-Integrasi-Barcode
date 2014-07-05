package com.example.ceritalegendadenganintegrasibarcode;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Cerita extends Activity{
	
	private static MediaPlayer mp;
	TextView judul_tv, cerita_tv;
	ImageView gambar;

	private static long sbarcode;
	private SQLiteDatabase db;
	private Database dbHelper;
	private Cursor cursor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cerita);
		judul_tv = (TextView) findViewById(R.id.judul);
		cerita_tv = (TextView) findViewById(R.id.cerita);
		gambar = (ImageView) findViewById(R.id.gambar);
		
		dbHelper = (new Database(this));
		db = dbHelper.getReadableDatabase();

		cursor = db.query(Database.TABLE_CERITA, Database.ALL_COLUMN, null, null, null, null, null);
		cursor.moveToLast();
		int jmlhbrs = cursor.getCount();
		cursor.moveToFirst();
		for(int i=0;i<jmlhbrs;i++){
			sbarcode = cursor.getLong(3);
			System.out.println("barcode"+sbarcode);

			if(MainActivity.contents == sbarcode){
				System.out.println(sbarcode);
				judul_tv.setText(cursor.getString(1));
				cerita_tv.setText(cursor.getString(2));				
				gambar.setImageResource(Integer.parseInt(cursor.getString(4)));
				mp = MediaPlayer.create(getApplicationContext(), Integer.parseInt(cursor.getString(5)));
				mp.start();
			}else{
				cursor.moveToNext();
			}
		}
		System.out.println("ada"+MainActivity.contents);
		
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		mp.stop();
		super.onDestroy();
	}
}
