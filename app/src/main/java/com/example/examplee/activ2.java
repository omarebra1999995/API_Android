package com.example.examplee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class activ2 extends AppCompatActivity {
    public static final String file = "name";
    ImageView h;
    Button Back;
    Button reg;
    TextInputEditText Name;
    TextInputEditText Emil;
    TextInputEditText ID;
    TextInputEditText phon;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activ2);

        Toolbar t = findViewById(R.id.t);
        setSupportActionBar(t);

        h=findViewById(R.id.imm);
        Intent in =getIntent();
        int b =  in.getIntExtra("id",1);
        final String NameComp=in.getStringExtra("comp");
        h.setImageResource(b);

        Back = findViewById(R.id.back);
        reg = findViewById(R.id.reg);
        Name=findViewById(R.id.name);
        Emil=findViewById(R.id.Email);
        ID=findViewById(R.id.ID);
        phon=findViewById(R.id.phon);


        final RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        reg.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       String url = "http://192.168.100.233/n.php";

                                       StringRequest sr = new StringRequest(Request.Method.POST, url , new Response.Listener<String>() {
                                           @Override
                                           public void onResponse(String response) {

                                           }
                                       }, new Response.ErrorListener() {
                                           @Override
                                           public void onErrorResponse(VolleyError error) {

                                           }
                                       }){
                                           @Override
                                           public Map<String,String> getParams(){
                                               Map<String, String> p = new HashMap<String, String>();
                                               p.put("name", Name.getText().toString());
                                               p.put("Emil", Emil.getText().toString());
                                               p.put("phon", phon.getText().toString());

                                               p.put("idd", ID.getText().toString());
                                               p.put("comp", NameComp);


                                               Toast.makeText(getBaseContext(), "successfully registered",
                                                       Toast.LENGTH_LONG).show();
                                               return p;
                                           }

                                           @Override
                                           public Map<String, String> getHeaders() throws AuthFailureError {
                                               Map<String,String> headers = new HashMap<String, String>();
                                               headers.put("Content-Type","application/x-www-form-urlencoded");
                                               headers.put("abc", "value");
                                               return headers;
                                           }
                                       };

                                       queue.add(sr);


                                       };

                               });





Back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent inv =new Intent(getBaseContext(),MainActivity.class);
        startActivity(inv);


    }
});



    }


}