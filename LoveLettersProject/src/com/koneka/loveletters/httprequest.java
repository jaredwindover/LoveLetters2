package com.koneka.loveletters;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class httprequest extends AsyncTask<String, Integer, HttpResponse> {

    private Context context;
    private String message;

    public httprequest (Context context) 
    {
        this.context = context;     
    }

    @Override
    protected HttpResponse doInBackground(String... params) {
        HttpResponse response = null;
        HttpPost httppost = new HttpPost(params[0]);

        try {
            HttpClient client = new DefaultHttpClient();
            response = client.execute(httppost);
            //httppost.setEntity(params[1]);

        } catch (ClientProtocolException e) {
            Toast.makeText(this.context, "Caught ClientProtocolException", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this.context, "Caught IOException", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this.context, "Exception", Toast.LENGTH_SHORT).show();                  
        }

        return response;

    }

}