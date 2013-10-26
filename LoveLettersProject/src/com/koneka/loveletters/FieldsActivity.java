package com.koneka.loveletters;

import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class FieldsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fields);
		
		Bundle b = getIntent().getBundleExtra("jsonBundle");
		String jsonString = b.getString("jsonString");
		Log.d("test", jsonString);
		/*
		try
		{
		JSONObject json = new JSONObject(jsonString);
		}
		catch(Exception e){}
		*/
		// ADD VALUES FROM UI TO JSON HERE

		// ADD BUNDLE AND START NEW INTENT
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fields, menu);
		return true;
	}

}
