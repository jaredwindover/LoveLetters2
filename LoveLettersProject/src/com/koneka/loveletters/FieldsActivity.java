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
		
		final Intent intent = new Intent(this, ConfirmActivity.class);
		final Button button = (Button) findViewById(R.id.filterNextBtn);
			
		Bundle b = getIntent().getBundleExtra("jsonBundle");
		
		final String jsonString = b.getString("jsonString");

		Log.d("test-fields", jsonString);
		
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
					
					JSONObject fields = (JSONObject) json.get("fields");
					
					fields.put("FIRSTNAME", firstName.getText() );
					fields.put("LASTNAME", lastName.getText() );
					fields.put("RESTAURANTNAME", rest.getText() );
					fields.put("PARKNAME", park.getText() );
					fields.put("THEATERNAME", theater.getText() );
					fields.put("TIME", time.getText() );
					fields.put("LOCATION", location.getText() );
									
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
