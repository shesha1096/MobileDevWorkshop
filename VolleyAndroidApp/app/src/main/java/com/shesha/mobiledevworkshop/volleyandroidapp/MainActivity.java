package com.shesha.mobiledevworkshop.volleyandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private String countryEndpoint = "https://restcountries.com/v3.1/name/india";
    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseTextView = findViewById(R.id.response_text_view);
        getCountryData();
    }

    private void getCountryData() {
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        stringRequest = new StringRequest(Request.Method.GET, countryEndpoint, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                responseTextView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
        requestQueue.add(stringRequest);
    }
}