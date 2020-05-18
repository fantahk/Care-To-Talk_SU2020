package com.example.caretotalkwithcards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FamilyCategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_categories);

        Button favorites = (Button)findViewById(R.id.button20);
        Button memories = (Button)findViewById(R.id.button3);
        Button relationships = (Button)findViewById(R.id.button4);
        Button reflection = (Button)findViewById(R.id.button6);
        Button wishes = (Button)findViewById(R.id.button7);
        Button roadmap = (Button)findViewById(R.id.button8);
        Button legacy = (Button)findViewById(R.id.button9);


        favorites.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCategories.this, CardSet11.class );
                startActivity(intent);
            }
        });

        memories.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCategories.this, CardSet12.class );
                startActivity(intent);
            }
        });

        relationships.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCategories.this, CardSet13.class );
                startActivity(intent);
            }
        });

        reflection.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCategories.this, CardSet14.class );
                startActivity(intent);
            }
        });

        wishes.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCategories.this, CardSet15.class );
                startActivity(intent);
            }
        });

        roadmap.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCategories.this, CardSet16.class );
                startActivity(intent);
            }
        });

        legacy.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(FamilyCategories.this, CardSet17.class );
                startActivity(intent);
            }
        });
    }
}
