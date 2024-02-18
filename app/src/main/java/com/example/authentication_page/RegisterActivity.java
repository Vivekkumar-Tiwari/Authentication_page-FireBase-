package com.example.authentication_page;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText Email,Password;
    private Button register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.pasword);
        register = findViewById(R.id.register2);
        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String  txt_email = Email.getText().toString();
                String txt_pass = Password.getText().toString();

                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pass)){
                    Toast.makeText(RegisterActivity.this, "invalid Credential:", Toast.LENGTH_SHORT).show();
                } else if (txt_pass.length()<5) {
                    Toast.makeText(RegisterActivity.this, "short password:", Toast.LENGTH_SHORT).show();
                }
                else {
                    registerUser(txt_email,txt_pass);
                }
            }
        });

    }

    private void registerUser(String Email, String Pass) {
        auth.createUserWithEmailAndPassword(Email,Pass).addOnCompleteListener(RegisterActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Register successfull:", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,MainUi.class));
                    finish();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "invalid register:", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}