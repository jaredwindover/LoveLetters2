package com.koneka.loveletters;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class ConfirmActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confim);
		
		final Intent intent = new Intent(this, MainActivity.class);
		final Button button = (Button) findViewById(R.id.filterNextBtn);
		
		final Bundle b = getIntent().getBundleExtra("jsonBundle");
		final String jsonString = b.getString("jsonString");
		
		Log.d("test-fields", jsonString);
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				intent.putExtra("jsonBundle", b);
				
				//POST REQUEST HERE
				
				
				//CLOSE ACTIVITIES AND FINISH
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confim, menu);
		return true;
	}

}
