package com.koneka.loveletters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

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
				/*
				try {

				HttpPost httppost = new HttpPost("http://dating.smartproposition.com");
				intent.putExtra("jsonBundle", b);
				
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://dating.smartproposition.com");
		
			    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		        nameValuePairs.add(new BasicNameValuePair("payload", jsonString));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		        // Execute HTTP Post Request
		        HttpResponse response = httpclient.execute(httppost);
					
				
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		        nameValuePairs.add(new BasicNameValuePair("payload", jsonString));
		        UrlEncodedFormEntity se = new UrlEncodedFormEntity(nameValuePairs);
				//
				httprequest task = new httprequest();
				task.execute("http://namedomain/test.php", se);
				//

			    //httpost.setHeader("Accept", "application/json");
			    //httpost.setHeader("Content-type", "application/json");			
				
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
				  */
				 
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


