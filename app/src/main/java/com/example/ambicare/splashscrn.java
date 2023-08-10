package com.example.ambicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class splashscrn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscrn);
        getSupportActionBar().hide();
        FirebaseApp firebaseApp = FirebaseApp.initializeApp(this);
        if (firebaseApp != null) {
            // Firebase is connected
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
            System.out.println("You are connected");
            System.out.println("reference is "+ databaseReference);
            // You can perform further operations with the database reference or other Firebase services
        } else {
            // Firebase is not connected or initialization failed
            System.out.println("You are not connected");
        }

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splashscrn.this, Welcome_Activity.class);
            startActivity(intent);
            finish(); // Optional: Finish the current activity if needed
        }, 1000);
    }
}