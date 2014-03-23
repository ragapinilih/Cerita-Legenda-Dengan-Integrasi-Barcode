package com.example.ceritalegendadenganintegrasibarcode;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Cerita extends Activity{
	
	TextView judul_tv, cerita_tv;
	ImageView gambar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cerita);
		judul_tv = (TextView) findViewById(R.id.judul);
		cerita_tv = (TextView) findViewById(R.id.cerita);
		gambar = (ImageView) findViewById(R.id.gambar);
	}
}
