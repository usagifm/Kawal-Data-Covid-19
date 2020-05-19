package com.example.cobarecyccle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleAdapter.OnItemClickListener {
    public static final String EXTRA_COUNTRY = "Country";
    public static final String EXTRA_NEWPOSITIVE = "newPositiveCount";
    public static final String EXTRA_POSITIVE = "PositiveCount";
    public static final String EXTRA_NEWRECOVERED = "newRecoveredCount";
    public static final String EXTRA_RECOVERED = "RecoveredCount";
    public static final String EXTRA_NEWDIED = "newDeathsCount";
    public static final String EXTRA_DIED = "DeathsCount";


    private RecyclerView mRecycleView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = findViewById(R.id.recycler_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();


    }

    private void parseJSON() {
        String url = "https://api.covid19api.com/summary";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("Countries");

                            for (int i = 0; i < jsonArray.length(); i++){
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String countryName = hit.getString("Country");
                                String newPositive = hit.getString("NewConfirmed");
                                String countPositive = hit.getString("TotalConfirmed");
                                String newRecovered = hit.getString("NewRecovered");
                                String countRecovered = hit.getString("TotalRecovered");
                                String newDied = hit.getString("NewDeaths");
                                String countDied = hit.getString("TotalDeaths");


                                mExampleList.add(new ExampleItem(countryName,newPositive,countPositive,newRecovered,countRecovered,newDied,countDied));
                            }

                            mExampleAdapter = new ExampleAdapter(MainActivity.this, mExampleList);
                            mRecycleView.setAdapter(mExampleAdapter);
                            mExampleAdapter.setOnItemClickListener(MainActivity.this);

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

        mRequestQueue.add(request);
    }


    @Override
    public void onItemClick(int position) {

        Intent detailIntent = new Intent(this, DetailActivityGlobal.class);
        ExampleItem clickedItem = mExampleList.get(position);

        detailIntent.putExtra(EXTRA_COUNTRY, clickedItem.getCountry());
        detailIntent.putExtra(EXTRA_NEWPOSITIVE, clickedItem.getNewPositive());
        detailIntent.putExtra(EXTRA_POSITIVE, clickedItem.getPositive());
        detailIntent.putExtra(EXTRA_NEWRECOVERED,clickedItem.getNewRecovered());
        detailIntent.putExtra(EXTRA_RECOVERED, clickedItem.getRecovered());
        detailIntent.putExtra(EXTRA_NEWDIED,clickedItem.getNewdied());
        detailIntent.putExtra(EXTRA_DIED, clickedItem.getdied());


        startActivity(detailIntent);


    }
}