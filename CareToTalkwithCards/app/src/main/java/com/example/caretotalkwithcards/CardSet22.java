package com.example.caretotalkwithcards;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class CardSet22 extends AppCompatActivity {

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        al = new ArrayList<>();
        al.add("If you could instantly become an expert in anything, what would you choose?");
        al.add("If you had to delete all but three apps from your phone, what would you keep?");
        al.add("What do you think is the most interesting thing about you?");
        al.add("What was your first job? What did you love about it the most?");
        al.add("What’s something that you experienced over the last few days that made you feel happy?");
        al.add("What’s the best gift you’ve ever received?");
        al.add("What do you call a sad cup of coffee? “A depresso”");
        al.add("If you ever had to separate your life into two sequential parts, what would be part one, what would be part two?");
        al.add("Who would you want to write your biography?");
        al.add("What’s something you’re proud of?");
        al.add("Are you a sunrise, daytime, twilight or nighttime person?");
        al.add("Why couldn’t the sailor play cards? “Because the captain was standing on the deck”");
        al.add("You have one free ride on a time machine. Where and when in the past or future would you visit?");
        al.add("What’s your favorite tradition or holiday?");
        al.add("If you could be amongst the first to live on Mars, would you go? What if it meant you couldn’t return to Earth?");
        al.add("If you had your own talk show, who would you invite as your first guest?");
        al.add("If you were an object, what would you be? Why?");
        al.add("What’s something true about you that no one would believe?");
        al.add("Who is your favorite character, either real or fictional? Why?");
        al.add("What was the best gift you’ve ever given someone else?");
        al.add("");



        arrayAdapter = new ArrayAdapter<>(this, R.layout.item22, R.id.Text_holder, al );

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
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
//                Toast.makeText(CardSet11.this, "Left!", Toast.LENGTH_SHORT).show();
                update(flingContainer);
            }

            @Override
            public void onRightCardExit(Object dataObject) {
//                Toast.makeText(CardSet11.this, "Right!", Toast.LENGTH_SHORT).show();
                update(flingContainer);
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                if(itemsInAdapter == 1)
                    startActivity(new Intent(CardSet22.this, Pop_End22.class));
                arrayAdapter.notifyDataSetChanged();
                Log.d("LIST", "notified");
                i++;
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
                Toast.makeText(CardSet22.this, "Click!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What do you call a sad cup of coffee? “A depresso”" || al.get(0) == "Why couldn’t the sailor play cards? “Because the captain was standing on the deck”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet22.this, Pop_Joker.class));
        }
//        else if (flag == 1){
//
//            sfav.setBackgroundColor(Color.parseColor("#220D0E"));
//            ar.add(al.get(0));
//            flag = 0;
////            Intent intent=new Intent(CardSet11.this, Pop_End.class);
////            intent.putStringArrayListExtra("Key1",ar);
//        }
        else
            sfav.setBackgroundColor(Color.parseColor("#220D0E"));

    }
}