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

public class CardSet13 extends AppCompatActivity {

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
        al.add("What’s something you think my generation doesn’t understand about yours?");
        al.add("Imagine you’re moving homes. Who would you call to help you? Who would you ask to help you decorate?");
        al.add("Pretend we’re a superhero team. What would we call ourselves? What powers would we have?");
        al.add("What do you get if you cross an apple with a shellfish? “A crab apple”");
        al.add("Tell me about a topic you think we avoid talking about. Why do you think this is difficult to discuss?");
        al.add("How do you comfort someone you love? How do you show them you care?");
        al.add( "Imagine a stranger asks you about our relationship. What words would you use and why?");
        al.add("");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item3, R.id.Text_holder, al );

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

                    Intent intent=new Intent(CardSet13.this, Pop_End3.class);
                    intent.putStringArrayListExtra("Key3", ar);
                    startActivity(intent);
                }

                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onScroll(float scrollProgressPercent) {

//
            }
        });

        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Toast.makeText(CardSet13.this, "Click!", Toast.LENGTH_SHORT).show();
                flag = 1;
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What do you get if you cross an apple with a shellfish? “A crab apple”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet13.this, Pop_Joker.class));
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