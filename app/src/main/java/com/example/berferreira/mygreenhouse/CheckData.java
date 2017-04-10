package com.example.berferreira.mygreenhouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CheckData extends AppCompatActivity {
    private static final String TAG="My";
    String lastHumidity;
    String lastTemperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_data);

        final Button homeBtn = (Button) findViewById(R.id.homeBtn);
        final Button getDataBtn = (Button) findViewById(R.id.GetBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CheckData.this, Home.class);
                startActivity(i);
            }
        });

        final EditText humidityText = (EditText) findViewById(R.id.humidityReading);
        final EditText temperatureText = (EditText) findViewById(R.id.temperatureReading);

        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        final Query lastQuery = database.child("Readings").orderByKey().limitToLast(1);


        getDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Read from the database
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        int i=0;
                        int dbSize = (int) dataSnapshot.child("Readings").getChildrenCount();
                        Log.d(TAG,""+dataSnapshot.child("Readings").getChildrenCount());
                    for (DataSnapshot a: dataSnapshot.child("Readings").getChildren())
                    {Reading post =a.getValue(Reading.class);
                        Log.d("Humidity:", post.getHumidity());
                        Log.d("Temperature:", post.getTemperature());

                        if (i==(dbSize-1)){
                            //String lastHumidity=post.getHumidity();
                            //String lastTemperature=post.getTemperature();

                            humidityText.setText(post.getHumidity());
                            temperatureText.setText(post.getTemperature());


                        }
                        i++;
                    }}
                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        //Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });


               // humidityText.setText(lastQuery.ch);
                //temperatureText.setText();


                //Reading values = new Reading(temperatureText.getText().toString(), humidityText.getText().toString());
                //database.push().setValue(values);
                //temperatureText.setText("");
                //humidityText.setText("");
            }
        });
    }
}
