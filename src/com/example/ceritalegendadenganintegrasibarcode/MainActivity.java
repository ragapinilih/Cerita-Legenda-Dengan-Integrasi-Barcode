package com.example.ceritalegendadenganintegrasibarcode;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {

	private SQLiteDatabase db;
	private Database dbHelper;
	private Cursor cursor;
	
	public static long contents;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

    public void pindai_barcode(View view) {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "ALL_CODE_TYPES");
        startActivityForResult(intent, 0);
    }

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    if (requestCode == 0) {
	        if (resultCode == RESULT_OK) {
	            contents = Long.parseLong(intent.getStringExtra("SCAN_RESULT"));
	            //String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
	            //Toast.makeText(this, String.valueOf(contents), Toast.LENGTH_SHORT).show();
	            String barcode = String.valueOf(contents);
	    		dbHelper = (new Database(this));
	    		db = dbHelper.getReadableDatabase();
	    		dbHelper.onCreate(db);

	    		cursor = db.rawQuery("SELECT * FROM "+Database.TABLE_CERITA+" WHERE "+Database.COLUMN_BARCODE+" = '"+barcode+"'", null);
	    		cursor.moveToLast();
	    		int jmlhbrs = cursor.getCount();
	    		if (jmlhbrs == 0) {
	    			Toast.makeText(this, "Cerita yang anda pindai tidak ditemukan", Toast.LENGTH_SHORT).show();
				}else {
    	            Intent intent2 = new Intent(this, Cerita.class);
    	            startActivity(intent2);
				}	    			    	
	            // Handle successful scan
	        } else if (resultCode == RESULT_CANCELED) {
	            // Handle cancel
	        }
	    }
	}

}
