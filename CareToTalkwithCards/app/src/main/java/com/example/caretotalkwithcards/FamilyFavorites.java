package com.example.caretotalkwithcards;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import java.util.ArrayList;

public class FamilyFavorites extends AppCompatActivity {
    private ArrayAdapter<String> arrayAdapter;
    public ArrayList<String> ar1;
    public ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

//        al = new ArrayList<>();

        ar1 = (ArrayList<String>) getIntent().getStringArrayListExtra("Key");

//        ar1.add("No More Favorites!");

////        while(ar1.isEmpty() != true)
//        {
//
//            al.add(ar1.get(0));
//            ar1.remove(0);
//
//        }

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.Text_holder, ar1 );

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {

            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                ar1.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(FamilyFavorites.this, "Left!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(FamilyFavorites.this, "Right!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                ar1.add("XML ".concat(String.valueOf(0)));
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onScroll(float scrollProgressPercent) {

            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(FamilyFavorites.this, "Click!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
