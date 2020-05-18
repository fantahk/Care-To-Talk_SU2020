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

public class CardSet15 extends AppCompatActivity {

    public ArrayList<String> ar;
    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    public int flag = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        ar = new ArrayList<>();
        al = new ArrayList<>();
        al.add("Think about the past 6-12 months. What is something you wish you had? How would things have been different?");
        al.add("What do you need most right now from your support network? From others? From yourself?");
        al.add("If you had three wishes, what would you use them for?");
        al.add("What three things bring you the most comfort?");
        al.add("What’s another name for a noisy body of water? “A creek”");
        al.add("Pretend you had an entire team of personal assistants. What would you ask them to do for you?");
        al.add("Is there anyone you wish was a bigger part of your life? How would things be different if they were?");
        al.add("If you could wake up tomorrow with a brand new quality or ability, what would it be and why?");
        al.add("");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item5, R.id.Text_holder, al);

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

                    Intent intent=new Intent(CardSet15.this, Pop_End5.class);
                    intent.putStringArrayListExtra("Key5", ar);
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
                Toast.makeText(CardSet15.this, "Click!", Toast.LENGTH_SHORT).show();
                flag = 1;
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What’s another name for a noisy body of water? “A creek”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet15.this, Pop_Joker.class));
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