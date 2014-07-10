package com.example.ceritalegendadenganintegrasibarcode;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Cerita extends Activity{
	
	
	TextView judul_tv, cerita_tv;
	ImageView gambar;

	private static long sbarcode;
	private SQLiteDatabase db;
	private Database dbHelper;
	private Cursor cursor;
	private MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cerita);
		judul_tv = (TextView) findViewById(R.id.judul);
		cerita_tv = (TextView) findViewById(R.id.cerita);
		gambar = (ImageView) findViewById(R.id.gambar);
		
		dbHelper = (new Database(this));
		db = dbHelper.getReadableDatabase();

		cursor = db.rawQuery("SELECT * FROM "+Database.TABLE_CERITA+" WHERE "+Database.COLUMN_BARCODE+" = '"+MainActivity.contents+"'", null);
		cursor.moveToFirst();
				System.out.println(sbarcode);
				judul_tv.setText(cursor.getString(1));
				cerita_tv.setText(cursor.getString(2));				
				gambar.setImageResource(Integer.parseInt(cursor.getString(4)));
				mp = MediaPlayer.create(this, Integer.parseInt(cursor.getString(5)));
				mp.start();		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		if (mp.isPlaying()) {
			mp.stop();
			mp.release();			
		}
		super.onDestroy();
	}
}
