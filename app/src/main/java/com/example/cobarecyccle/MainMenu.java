package com.example.cobarecyccle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mRecyclerviewindo,mRecyclerviewglobal;
    private IndonesiaAdaptor mIndonesiaAdapter;
    private GlobalAdaptor mGlobalAdapter;
    private ArrayList<IndonesiaItem> mIndolist;
    private ArrayList<GlobalItem> mGlobalist;

    private RequestQueue mRequestQueueindo,mRequestQueueglobal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mRecyclerviewindo = findViewById(R.id.recycler_indo);
        mRecyclerviewindo.setHasFixedSize(true);
        mRecyclerviewindo.setLayoutManager(new LinearLayoutManager(this));

        mIndolist = new ArrayList<>();

        mRequestQueueindo = Volley.newRequestQueue(this);
        parsejsonindo();


        // Batassss Suci

        mRecyclerviewglobal = findViewById(R.id.recycler_global);
        mRecyclerviewglobal.setHasFixedSize(true);
        mRecyclerviewglobal.setLayoutManager(new LinearLayoutManager(this));

        mGlobalist = new ArrayList<>();

        mRequestQueueglobal = Volley.newRequestQueue(this);
        parsejsonglobal();


        findViewById(R.id.global).setOnClickListener(this);
        findViewById(R.id.lokal).setOnClickListener(this);
        findViewById(R.id.langkah_pencegahan).setOnClickListener(this);
        findViewById(R.id.gejala).setOnClickListener(this);
        findViewById(R.id.maps).setOnClickListener(this);
    }

    private void parsejsonglobal() {
        String urlglobal = "https://api.covid19api.com/summary";

        JsonObjectRequest requestglobal = new JsonObjectRequest(Request.Method.GET, urlglobal, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject responseglobal) {


                        try {

                            JSONObject jsonObjectglobal =  responseglobal.getJSONObject("Global");


                            String globalpositif = jsonObjectglobal.getString("TotalConfirmed");
                            String globalsembuh = jsonObjectglobal.getString("TotalRecovered");
                            String  globalmeninggal = jsonObjectglobal.getString("TotalDeaths");

                            mGlobalist.add(new GlobalItem(globalpositif,globalsembuh,globalmeninggal));


                            mGlobalAdapter = new GlobalAdaptor(MainMenu.this, mGlobalist);
                            mRecyclerviewglobal.setAdapter(mGlobalAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        mRequestQueueindo.add(requestglobal);


    }

    private void parsejsonindo() {
        String urlindo = "https://api.kawalcorona.com/indonesia";

        JsonArrayRequest requestindo = new JsonArrayRequest(Request.Method.GET, urlindo, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray responseindo) {


                        try {

                            JSONObject jsonObject =  responseindo.getJSONObject(0);

                            String indo = jsonObject.getString("name");
                            String sakit = jsonObject.getString("positif");
                            String sehat = jsonObject.getString("sembuh");
                            String mati = jsonObject.getString("meninggal");

                            mIndolist.add(new IndonesiaItem(indo,sakit,sehat,mati));


                            mIndonesiaAdapter = new IndonesiaAdaptor(MainMenu.this, mIndolist);
                            mRecyclerviewindo.setAdapter(mIndonesiaAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });


        mRequestQueueindo.add(requestindo);


    }


    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.global) {

            Intent intent = new Intent(MainMenu.this, MainActivity.class);
            startActivity(intent);
        } else if (view.getId() == R.id.lokal) {
            Intent intent2 = new Intent(MainMenu.this, Main2Activity.class);
            startActivity(intent2);
        }else if (view.getId() == R.id.langkah_pencegahan) {
            Intent intent3 = new Intent(MainMenu.this, pencegahan_detail.class);
            startActivity(intent3);
        } else if (view.getId() == R.id.gejala) {
            Intent intent4 = new Intent(MainMenu.this, gejala.class);
            startActivity(intent4);
        } else if (view.getId() == R.id.maps) {
            Intent intent5 = new Intent(MainMenu.this, Hospitals.class);
            startActivity(intent5);
        }

    }



    @SuppressLint("MissingPermission")
    public void telfoncovid(View view) {

        Intent intenttelfon = new Intent(Intent.ACTION_CALL);

        intenttelfon.setData(Uri.parse("tel:119"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            return;
        }
        startActivity(intenttelfon);
    }

}
