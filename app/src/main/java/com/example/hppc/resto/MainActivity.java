package com.example.hppc.resto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.hppc.adapter.PlatAdapter;
import com.example.hppc.model.Plat;
import com.google.gson.Gson;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
    ListView listView = (ListView) findViewById(R.id.list);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest q = new JsonArrayRequest("http://172.20.10.4:8080/RestoWebService/webapi/myresource/plats", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson g = new Gson();
                Plat[] plats = g.fromJson(response.toString(),Plat[].class);
                PlatAdapter adapter = new PlatAdapter(MainActivity.this,plats);
                listView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//test
            }
        });








    }
}
