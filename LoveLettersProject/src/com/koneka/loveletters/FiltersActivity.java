package com.koneka.loveletters;

import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class FiltersActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filter);
		Log.d("filters", "starting filters");
		final Intent intent = new Intent(this, FieldsActivity.class);
		final Button button = (Button) findViewById(R.id.filterNextBtn);
			
		Bundle b = getIntent().getBundleExtra("jsonBundle");
		
		final String jsonString = b.getString("jsonString");

		Log.d("test", jsonString);
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Spinner girlType = (Spinner) findViewById(R.id.spinner1);
				Spinner firstDate = (Spinner) findViewById(R.id.spinner2);
				try
				{
					JSONObject json = new JSONObject(jsonString);
					
					JSONObject filters = (JSONObject) json.get("filters");
					
					filters.put("DocumentType", "Date");
					filters.put("GirlType", girlType.getSelectedItem().toString() );
					filters.put("FirstDate", firstDate.getSelectedItem().toString() );
										
					Bundle b2 = new Bundle();
					b2.putString("jsonString", json.toString());
					
					intent.putExtra("jsonBundle", b2);
					Log.d("test", json.toString());
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
