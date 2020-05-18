package com.example.caretotalkwithcards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CaregiveCategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregive_categories);

        Button uaa = (Button)findViewById(R.id.button10);
        Button aay = (Button)findViewById(R.id.button11);
        Button yac = (Button)findViewById(R.id.button12);

        uaa.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(CaregiveCategories.this, CardSet21.class );
                startActivity(intent);
            }
        });

        aay.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(CaregiveCategories.this, CardSet22.class );
                startActivity(intent);
            }
        });

        yac.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(CaregiveCategories.this, CardSet23.class );
                startActivity(intent);
            }
        });
    }
}
