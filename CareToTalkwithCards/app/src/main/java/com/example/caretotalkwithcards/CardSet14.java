package com.example.caretotalkwithcards;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class CardSet14 extends AppCompatActivity {

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
        al.add("Tell me about the three things you are most grateful for and why");
        al.add("If you could go back in time and give yourself advice, what would you tell yourself?");
        al.add("What’s the best wedding you’ve ever been to? What about the best birthday party? Best funeral?");
        al.add("Tell me about a time you recently worried about money. What made you feel that way");
        al.add("Tell me about the best decision you ever made. Is there something you wish you had done differently?");
        al.add("Tell me about the last time you were upset. What made you feel that way?");
        al.add("Tell me about the last time you felt joy? What made you feel that way?");
        al.add("If you could share a tip with someone just starting to care for a loved one, what would it be? Why?");
        al.add("What have you learned about yourself through caring for a loved one? What’s the most wonderful thing you’ve learned as a caregiver?");
        al.add("Imagine you could re-live any day in your life. What day would you choose and why?");
        al.add("");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item4, R.id.Text_holder, al );

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

                    Intent intent=new Intent(CardSet14.this, Pop_End4.class);
                    intent.putStringArrayListExtra("Key4", ar);
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
                Toast.makeText(CardSet14.this, "Click!", Toast.LENGTH_SHORT).show();
                flag = 1;
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What do you get if you cross an apple with a shellfish? “A crab apple”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet14.this, Pop_Joker.class));
        }
        else if (flag == 1){

            sfav.setBackgroundColor(WHITE);
            ar.add(al.get(0));
            flag = 0;
            Intent intent=new Intent(CardSet14.this, Pop_End.class);
            intent.putStringArrayListExtra("Key4", ar);
        }
        else
            sfav.setBackgroundColor(WHITE);
    }

}