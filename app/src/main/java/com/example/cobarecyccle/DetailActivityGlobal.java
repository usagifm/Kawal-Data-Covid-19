package com.example.cobarecyccle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.cobarecyccle.MainActivity.EXTRA_COUNTRY;
import static com.example.cobarecyccle.MainActivity.EXTRA_DIED;
import static com.example.cobarecyccle.MainActivity.EXTRA_NEWDIED;
import static com.example.cobarecyccle.MainActivity.EXTRA_NEWPOSITIVE;
import static com.example.cobarecyccle.MainActivity.EXTRA_NEWRECOVERED;
import static com.example.cobarecyccle.MainActivity.EXTRA_POSITIVE;
import static com.example.cobarecyccle.MainActivity.EXTRA_RECOVERED;

public class DetailActivityGlobal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_global);

        Intent intent = getIntent();
        String Country = intent.getStringExtra(EXTRA_COUNTRY);
        String newPositiveCount = intent.getStringExtra(EXTRA_NEWPOSITIVE);
        String PositiveCount = intent.getStringExtra(EXTRA_POSITIVE);
        String newRecoveredCount = intent.getStringExtra(EXTRA_NEWRECOVERED);
        String RecoveredCount = intent.getStringExtra(EXTRA_RECOVERED);
        String newDeathsCount = intent.getStringExtra(EXTRA_NEWDIED);
        String DeathsCount = intent.getStringExtra(EXTRA_DIED);

        TextView textViewCountry = findViewById(R.id.text_view_country_detail);
        TextView textViewNewPositive = findViewById(R.id.text_view_newpositive_detail);
        TextView textViewPositive = findViewById(R.id.text_view_positive_detail);
        TextView textViewNewRecovered = findViewById(R.id.text_view_newrecovered_detail);
        TextView textViewRecovered = findViewById(R.id.text_view_recovered_detail);
        TextView textViewNewDied = findViewById(R.id.text_view_newdied_detail);
        TextView textViewDied = findViewById(R.id.text_view_died_detail);

        textViewCountry.setText("Negara :  " +Country);
        textViewNewPositive.setText("Kasus Baru  :  " + newPositiveCount);
        textViewPositive.setText("Total Kasus :  "+PositiveCount);
        textViewNewRecovered.setText("Pasien Sembuh Baru :  " + newRecoveredCount);
        textViewRecovered.setText("Total Pasien Sembuh :  "+RecoveredCount);
        textViewNewDied.setText("Kematian Terbaru :  " + newDeathsCount);
        textViewDied.setText("Total Kematian :  "+DeathsCount);
    }
}
