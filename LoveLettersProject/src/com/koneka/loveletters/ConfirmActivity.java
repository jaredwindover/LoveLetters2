package com.koneka.loveletters;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
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

import android.os.AsyncTask;
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
		
		Log.d("test", jsonString);
		
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				new sendJson().execute(jsonString);
				
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});		
	}
	
	private class sendJson extends AsyncTask<String, Integer, Long> {
	     protected Long doInBackground(String... output) {
	         
	    	 postData(output[0]);
	         
	         return null;
	     }

	     protected void onPostExecute(Long result) {
	         Log.d("test post", "Downloaded " + result + " bytes");
	     }
	     
	     public void postData(String outputString) {
	 	    // Create a new HttpClient and Post Header
	 	    HttpClient httpclient = new DefaultHttpClient();
	 	    HttpPost httppost = new HttpPost("http://dating.smartproposition.com");

	 	    try {
	 	        // Add your data
	 	        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	 	        nameValuePairs.add(new BasicNameValuePair("payload", outputString));
	 	        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	 	        // Execute HTTP Post Request
	 	        HttpResponse response = httpclient.execute(httppost);
	 	        
	 	       Log.d("test-post", "Sent: " + outputString);
	 	        
	 	    } catch (ClientProtocolException e) {
	 	        // TODO Auto-generated catch block
	 	    } catch (IOException e) {
	 	        // TODO Auto-generated catch block
	 	    }
	 	} 
	 }
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confim, menu);
		return true;
	}

}


