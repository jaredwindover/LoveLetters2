package com.koneka.loveletters;

import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class FieldsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fields);
		
		final Intent intent = new Intent(this, FieldsActivity.class);
		final Button button = (Button) findViewById(R.id.filterNextBtn);
			
		Bundle b = getIntent().getBundleExtra("jsonBundle");
		
		final String jsonString = b.getString("jsonString");
		final JSONObject fieldParams = new JSONObject();
		Log.d("test-fields", jsonString);
		
		// ADD VALUES FROM UI TO JSON HERE

		// ADD BUNDLE AND START NEW INTENT
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				EditText firstName = (EditText) findViewById(R.id.firstText);
				EditText lastName = (EditText) findViewById(R.id.lastText);
				EditText rest = (EditText) findViewById(R.id.restaurantText);
				EditText park = (EditText) findViewById(R.id.parkText);
				EditText theater = (EditText) findViewById(R.id.theaterText);
				EditText time = (EditText) findViewById(R.id.timeText);
				EditText location = (EditText) findViewById(R.id.locationText);
				try
				{
					JSONObject json = new JSONObject(jsonString);
					
					fieldParams.put("FIRSTNAME", firstName.getText() );
					fieldParams.put("LASTNAME", lastName.getText() );
					fieldParams.put("RESTAURANTNAME", rest.getText() );
					fieldParams.put("PARKNAME", park.getText() );
					fieldParams.put("THEATERNAME", theater.getText() );
					fieldParams.put("TIME", time.getText() );
					fieldParams.put("LOCATION", location.getText() );
				
					json.put("fields", fieldParams);
					
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
		getMenuInflater().inflate(R.menu.fields, menu);
		return true;
	}

}
