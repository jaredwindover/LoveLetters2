package com.koneka.loveletters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

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
		final Button button = (Button) findViewById(R.id.sendButton);
		
		final Bundle b = getIntent().getBundleExtra("jsonBundle");
		final String jsonString = b.getString("jsonString");
		
		Log.d("test-fields", jsonString);
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				try {
				intent.putExtra("jsonBundle", b);
				
				DefaultHttpClient httpclient = new DefaultHttpClient();
				 
				HttpPost httpost = new HttpPost("http://dating.smartproposition.com");

			    StringEntity se = new StringEntity(jsonString);
		
			    httpost.setEntity(se);

			    httpost.setHeader("Accept", "application/json");
			    httpost.setHeader("Content-type", "application/json");

			    BasicResponseHandler responseHandler = new BasicResponseHandler();
			    httpclient.execute(httpost, responseHandler);
				
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
