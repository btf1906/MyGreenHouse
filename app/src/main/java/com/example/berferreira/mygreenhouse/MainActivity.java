package com.example.berferreira.mygreenhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sendBtn = (Button) findViewById(R.id.SendBtn);
        final EditText humidityText = (EditText) findViewById(R.id.humidity);
        final EditText temperatureText = (EditText) findViewById(R.id.temperature);

        final DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Readings");

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reading values = new Reading(temperatureText.getText().toString(), humidityText.getText().toString());
                database.push().setValue(values);
                temperatureText.setText("");
                humidityText.setText("");


                //teste
                //teste
            }
        });
    }
}
