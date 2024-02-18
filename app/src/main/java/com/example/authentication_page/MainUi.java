package com.example.authentication_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.FirebaseDatabaseKtxRegistrar;

import java.util.HashMap;

public class MainUi extends AppCompatActivity {
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainUi.this, "Sucessfully Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainUi.this,MainActivity.class));

            }
        });

//        FirebaseDatabase.getInstance().getReference().child("programlanguage:").child("mingprogarm").setValue("jay_shree_ram.");

        HashMap<String,Object> map = new HashMap<>();
        map.put("Name","Vivek");
        map.put("Email","vivektiwari20033@gmail.com");


        FirebaseDatabase.getInstance().getReference().child("Programing").child("mini").updateChildren(map);
    }
}