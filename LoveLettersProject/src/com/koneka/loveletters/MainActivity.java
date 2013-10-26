package com.koneka.loveletters;

import org.json.JSONObject;

import com.koneka.loveletters.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		final JSONObject json = new JSONObject();
		final JSONObject fields = new JSONObject();
		final JSONObject filters = new JSONObject();
		
		try
		{
			json.put("fields", fields);
			json.put("filters", filters);
		}
		catch(Exception e){}
		
		final Button button = (Button) findViewById(R.id.continueButton);
		
		final Intent intent = new Intent(this, FiltersActivity.class);
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				

				TextView firstName = (TextView) findViewById(R.id.userFirstName);
				TextView lastName = (TextView) findViewById(R.id.userLastName);
				TextView phone = (TextView) findViewById(R.id.userPhone);
				TextView email = (TextView) findViewById(R.id.userEmail);
				
				try
				{
					fields.put("userFirstName", firstName.getText());
					fields.put("userLastName", lastName.getText());
					fields.put("userPhone", phone.getText());
					fields.put("userEmail", email.getText());
				}
				catch(Exception e){}
									
				Bundle b = new Bundle();
				b.putString("jsonString", json.toString());
				
				intent.putExtra("jsonBundle", b);
				Log.d("test", json.toString());
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
