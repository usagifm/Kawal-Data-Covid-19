package com.example.cobarecyccle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView mRecyclerViewlocal;
    private LocalAdapter mLocalAdapter;
    private ArrayList<LocalItem> mLocalList;
    private RequestQueue mRequestQueuelocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecyclerViewlocal = findViewById(R.id.recyclyer_local);
        mRecyclerViewlocal.setHasFixedSize(true);
        mRecyclerViewlocal.setLayoutManager(new LinearLayoutManager(this));

      mLocalList = new ArrayList<>();

      mRequestQueuelocal = Volley.newRequestQueue(this);
      parseJSONlocal();

    }

    private void parseJSONlocal(){
        String urllocal = "https://api.kawalcorona.com/indonesia/provinsi/";

        JsonArrayRequest requestlocal = new JsonArrayRequest(Request.Method.GET, urllocal, null,
                new Response.Listener<JSONArray>() {
                    @Override


                    public void onResponse(JSONArray response) {
                        try {
                            for (int j = 0; j < response.length(); j++){


                                JSONObject jsonObject = response.getJSONObject(j);



                                JSONObject jsonObject1 =jsonObject.getJSONObject("attributes");

                                String provinsi = jsonObject1.getString("Provinsi");
                                String positif = jsonObject1.getString("Kasus_Posi");

                                String sembuh = jsonObject1.getString("Kasus_Semb");

                                String meninggal = jsonObject1.getString("Kasus_Meni");

                                mLocalList.add(new LocalItem(provinsi,positif,sembuh,meninggal));

                            }

                            mLocalAdapter = new LocalAdapter(Main2Activity.this, mLocalList);
                            mRecyclerViewlocal.setAdapter(mLocalAdapter);

                        } catch (JSONException e){
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueuelocal.add(requestlocal);

    }

}
