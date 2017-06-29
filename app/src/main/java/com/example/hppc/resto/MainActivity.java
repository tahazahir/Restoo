package com.example.hppc.resto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.hppc.adapter.PlatAdapter;
import com.example.hppc.model.Plat;
import com.example.hppc.rest.RestClient;
import com.example.hppc.rest.RestDelegate;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private RestClient restClient = RestClient.getInstance(this);
    private List<Plat> plats;
    private PlatAdapter platAdapter;

    private RestDelegate restDelegate = new RestDelegate() {
        @Override
        public void onSuccess(Object object) {

            platAdapter = new PlatAdapter(getApplicationContext(),(ArrayList<Plat>)object);
            listView.setAdapter(platAdapter);
        }

        @Override
        public void onError(int code, String error) {

            Log.e("error",error);
        }

        @Override
        public void forbidden() {
            Log.e("error","forbidden");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);

        restClient.getPlat(restDelegate);
    }
}
