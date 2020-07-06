    package com.example.mysqlconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TextView textView = (TextView) findViewById(R.id.text);
        RequestQueue queue = Volley.newRequestQueue(this);
        //String url ="http://192.168.18.177";
        String url ="http://192.168.0.102/php_code.php?t1=ahmed&t2=usernamefield&t3=12345";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText("Response is: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.toString());
            }
        });

        queue.add(stringRequest);



    }
}