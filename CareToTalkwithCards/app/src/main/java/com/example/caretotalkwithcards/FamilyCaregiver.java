package com.example.caretotalkwithcards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyCaregiver extends AppCompatActivity {

    public ArrayList<String> a_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_caregiver);
        Button categories = (Button)findViewById(R.id.button200);
        Button about = (Button)findViewById(R.id.button14);
        Button instructions = (Button)findViewById(R.id.button16);
        Button shuffle = (Button)findViewById(R.id.button300);
        Button favorites = (Button)findViewById(R.id.button5);

        a_final = getIntent().getStringArrayListExtra("Key");

        categories.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCaregiver.this, FamilyCategories.class );
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCaregiver.this, about1.class );
                startActivity(intent);
            }
        });

        instructions.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCaregiver.this, instructions1.class );
                startActivity(intent);
            }
        });

        shuffle.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                // choose a random category

                int decide_cat = (int)(Math.random() * 10);

                if (decide_cat % 7 == 0) {
                    Intent intent8 = new Intent(FamilyCaregiver.this, CardSet11.class );
                    startActivity(intent8);
                } else if (decide_cat % 7 == 1) {
                    Intent intent9 = new Intent(FamilyCaregiver.this, CardSet12.class );
                    startActivity(intent9);
                } else if (decide_cat % 7 == 2) {
                    Intent intent10 = new Intent(FamilyCaregiver.this, CardSet13.class );
                    startActivity(intent10);
                } else if (decide_cat % 7 == 3) {
                    Intent intent11 = new Intent(FamilyCaregiver.this, CardSet14.class );
                    startActivity(intent11);

                } else if (decide_cat % 7 == 4) {
                    Intent intent12 = new Intent(FamilyCaregiver.this, CardSet15.class );
                    startActivity(intent12);

                } else if (decide_cat % 7 == 5) {
                    Intent intent13 = new Intent(FamilyCaregiver.this, CardSet16.class );
                    startActivity(intent13);
                } else  {
                    Intent intent14 = new Intent(FamilyCaregiver.this, CardSet17.class );
                    startActivity(intent14);
                }
            }

        });

        favorites.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {

                Intent intent = new Intent(FamilyCaregiver.this, FamilyFavorites.class );
                intent.putStringArrayListExtra("Key", a_final);
                startActivity(intent);
            }
        });

    }

}

