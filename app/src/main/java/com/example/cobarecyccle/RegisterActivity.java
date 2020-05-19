package com.example.cobarecyccle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etUsername , etPassowrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        mAuth = FirebaseAuth.getInstance();

        etUsername = findViewById(R.id.et_username);
        etPassowrd = findViewById(R.id.et_passowrd);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent goLogin = new Intent(RegisterActivity.this, Login.class);
                startActivity(goLogin);
                finish();


            }


        } );

        FloatingActionButton fabRegister = findViewById(R.id.fab_register);

        fabRegister.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString();
                String password = etPassowrd.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Silahkan Isi username anda !",
                            Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Silahkan Isi password anda !",
                            Toast.LENGTH_SHORT).show();

                } else {


                    mAuth.createUserWithEmailAndPassword(username, password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information

                                        FirebaseUser user = mAuth.getCurrentUser();

                                        Intent goLogin = new Intent(RegisterActivity.this, Login.class);
                                        startActivity(goLogin);
                                        finish();

                                        Toast.makeText(RegisterActivity.this, "Berhasil didaftarkan",
                                                Toast.LENGTH_SHORT).show();


                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(RegisterActivity.this, "Daftar gagal",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
            }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent goLogin = new Intent(RegisterActivity.this, Login.class);
        startActivity(goLogin);
        finish();

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
}
