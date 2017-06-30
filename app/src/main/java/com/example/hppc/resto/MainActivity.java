package com.example.hppc.resto;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.hppc.adapter.PlatAdapter;
import com.example.hppc.model.Plat;
import com.example.hppc.rest.RestClient;
import com.example.hppc.rest.RestDelegate;

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

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.logo);
        menu.setDisplayUseLogoEnabled(true);
        menu.setBackgroundDrawable(new ColorDrawable(Color.WHITE)); // set your desired color

        restClient.getPlat(restDelegate);
    }

    public void logout(View view){
        Intent intent= new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
