package com.example.berferreira.mygreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_up);

        final Button logInBtn = (Button) findViewById(R.id.startUpLogInBtn);
        final Button signUpBtn = (Button) findViewById(R.id.startUpSignUpBtn);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StartUp.this, LogIn.class);
                startActivity(i);
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(StartUp.this, SignUp.class);
                startActivity(i);
            }
        });
    }
}
