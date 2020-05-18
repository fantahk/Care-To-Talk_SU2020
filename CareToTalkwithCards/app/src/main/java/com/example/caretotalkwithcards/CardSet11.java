package com.example.caretotalkwithcards;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

import static android.graphics.Color.RED;

public class CardSet11 extends AppCompatActivity {

    public ArrayList<String> ar;
    public ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    public int flag = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        ar = new ArrayList<>();
        al = new ArrayList<>();
        al.add("What’s the most beautiful or fun place you’ve ever visited? What was it like?");
        al.add("Tell me about your favorite movie or television show growing up.");
        al.add("What’s your favorite memory of us and why?");
        al.add("What’s your favorite family tradition or holiday?");
        al.add("What was your favorite job? What did you enjoy about it?");
        al.add("What’s your favorite song of all time? Tell me about it. ");
        al.add("When are you most comfortable? Where are you? What are you doing? Who are you with?");
        al.add("Tell me about your heroes or role models");
        al.add("");
        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.Text_holder, al );

        final SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {

            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {

                update(flingContainer);
            }

            @Override
            public void onRightCardExit(Object dataObject) {

                update(flingContainer);
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {

                if(itemsInAdapter == 1) {

                    Intent intent=new Intent(CardSet11.this, Pop_End.class);

                    if(ar.size() == 0)
                        ar.add("No Favorites");
                    intent.putStringArrayListExtra("Key1", ar);
                    startActivity(intent);
                }

                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onScroll(float scrollProgressPercent) {

//
            }
        });


        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(CardSet11.this, "Click!", Toast.LENGTH_SHORT).show();
                flag = 1;
                update(flingContainer);
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What’s another name for a noisy body of water? “A creek”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet11.this, Pop_Joker.class));
        }
        else if (flag == 1){

            sfav.setBackgroundColor(Color.parseColor("#220D0E"));
            ar.add(al.get(0));
            flag = 0;
//            Intent intent=new Intent(CardSet11.this, Pop_End.class);
//            intent.putStringArrayListExtra("Key1",ar);
        }
        else
            sfav.setBackgroundColor(Color.parseColor("#220D0E"));

    }

}