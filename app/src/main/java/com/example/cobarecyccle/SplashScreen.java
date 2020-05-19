package com.example.cobarecyccle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;


public class SplashScreen extends AppCompatActivity {

    TextView tvSplash;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);



        //menghilangkan ActionBar

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash_screen);



        tvSplash = (TextView) findViewById(R.id.tvSplash);





        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override

            public void run() {

                startActivity(new Intent(getApplicationContext(), Login.class));

                finish();

            }

        }, 6000L); //3000 L = 3 detik

    }

}