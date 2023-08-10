package com.example.ambicare;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Welcome_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    RelativeLayout rellay1, rellay2;
    Button driver,patient;
    private Button mdriver, mCustomer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        // Check if the user is already logged in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is already logged in, proceed to the main activity or other appropriate flow
            if (currentUser.isEmailVerified()) {
                Intent intent = new Intent(Welcome_Activity.this, CustomerMapActivity.class);
                Toast.makeText(Welcome_Activity.this, "Welcome to AmbiCare", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            } else {
               Intent intent = new Intent(Welcome_Activity.this, CustomerLoginActivity.class);
               startActivity(intent);
            }
        }

        driver=  findViewById(R.id.driver);
        patient = findViewById(R.id.patient);


        startService(new Intent(Welcome_Activity.this,onAppKilled.class));


    }

    public void driver(View v) {
        Toast.makeText(this,"I am a driver",Toast.LENGTH_SHORT).show();
    }

    public void patient(View v) {
        Toast.makeText(this,"I am a Patient",Toast.LENGTH_SHORT).show();
    }

    public void sendMessage(View view)
    {
        System.out.println("Patient button pressed");
        Intent intent = new Intent(Welcome_Activity.this, CustomerLoginActivity.class);
        startActivity(intent);

    }
    public void sendMessage2(View view)
    {
       Intent intent = new Intent(Welcome_Activity.this, DriverLoginActivity.class);
       startActivity(intent);
    }
}
