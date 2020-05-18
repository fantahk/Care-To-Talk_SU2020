package com.example.caretotalkwithcards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CaregiverConvo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregiver_convo);

        Button categories = (Button)findViewById(R.id.button19);
        Button about = (Button)findViewById(R.id.button13);
        Button instructions = (Button)findViewById(R.id.button15);
        Button shuffle = (Button)findViewById(R.id.button18);

        categories.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(CaregiverConvo.this, CaregiveCategories.class );
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(CaregiverConvo.this, about2.class );
                startActivity(intent);
            }
        });
        instructions.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(CaregiverConvo.this, instructions2.class );
                startActivity(intent);
            }
        });

        shuffle.setOnClickListener(new View.OnClickListener () {

            @Override

            public void onClick(View w) {
                int decide_cat = (int) (Math.random() * 3);

                if (decide_cat % 3 == 0) {
                    Intent intent4 = new Intent(CaregiverConvo.this, CardSet21.class);
                    startActivity(intent4);
                } else if (decide_cat % 3 == 1) {
                    Intent intent5 = new Intent(CaregiverConvo.this, CardSet22.class);
                    startActivity(intent5);

                } else {
                    Intent intent6 = new Intent(CaregiverConvo.this, CardSet23.class);
                    startActivity(intent6);
                }
            }
        });

    }
}
