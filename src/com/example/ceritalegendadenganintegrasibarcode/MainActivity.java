package com.example.ceritalegendadenganintegrasibarcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

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
	            String contents = intent.getStringExtra("SCAN_RESULT");
	            //String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
	            Toast.makeText(this, contents, Toast.LENGTH_SHORT).show();
	            Intent intent2 = new Intent(this, Cerita.class);
	            startActivity(intent2);
	            // Handle successful scan
	        } else if (resultCode == RESULT_CANCELED) {
	            // Handle cancel
	        }
	    }
	}

}
