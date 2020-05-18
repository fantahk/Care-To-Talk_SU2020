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

public class CardSet17 extends AppCompatActivity {

    public ArrayList<String> ar;
    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    public int flag = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        al = new ArrayList<>();
        al.add("How do you want to be remembered by your loved ones? How would you want to be described?");
        al.add("Are you more comfortable giving thanks? Or asking for forgiveness? Which approach do you prefer – in person, phone, text, letter?");
        al.add("Imagine a company has decided to publish your life story. What would you want the beginning, middle and end to say?");
        al.add("If you had to sum up your life as a motto or bumper sticker, what would it be?");
        al.add("Pretend you’re making a time capsule of your life. What would you put in it?");
        al.add("What is the next thing you want to check off your bucket list? Why have you always wanted to do that?");
        al.add("");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item7, R.id.Text_holder, al );

        final SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {

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

                    Intent intent=new Intent(CardSet17.this, Pop_End7.class);
                    intent.putStringArrayListExtra("Key7", ar);
                    startActivity(intent);
                }

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
                Toast.makeText(CardSet17.this, "Click!", Toast.LENGTH_SHORT).show();
                flag = 1;
            }
        });

    }
    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What’s another name for a noisy body of water? “A creek”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet17.this, Pop_Joker.class));
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