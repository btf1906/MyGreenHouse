package com.example.berferreira.mygreenhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        final Button writeBtn = (Button) findViewById(R.id.writeBtn);
        final Button readBtn = (Button) findViewById(R.id.ReadBtn);

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, MainActivity.class);
                startActivity(i);
            }
        });

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, CheckData.class);
                startActivity(i);
            }
        });
    }
}
