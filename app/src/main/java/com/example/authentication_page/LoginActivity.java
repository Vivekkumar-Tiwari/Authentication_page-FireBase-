package com.example.authentication_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email,password2;
    private Button login;

    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password2 = findViewById(R.id.password);
        login = findViewById(R.id.loginid);
        auth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_emaill = email.getText().toString();
                String txt_passss = password2.getText().toString();

                LoginUser(txt_passss,txt_emaill);
            }
        });

    }

    private void LoginUser(String Passss, String Emaill) {
        auth.signInWithEmailAndPassword(Emaill,Passss).addOnSuccessListener(LoginActivity.this,new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "You Login successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, MainUi.class));
                finish();
            }
        });
    }
}