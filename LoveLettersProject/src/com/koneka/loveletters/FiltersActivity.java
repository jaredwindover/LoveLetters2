package com.koneka.loveletters;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FiltersActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
		
		final Intent intent = new Intent(this, FieldsActivity.class);
		final Button button = (Button) findViewById(R.id.filterNextBtn);
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				try{					
					startActivity(intent);
				}
				catch(Exception e){			
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filters, menu);
		return true;
	}

}
