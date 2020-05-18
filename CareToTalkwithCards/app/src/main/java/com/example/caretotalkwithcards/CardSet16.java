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

public class CardSet16 extends AppCompatActivity {

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
        al.add("What do you love most about living in your home? Do you ever think about living somewhere else?");
        al.add("If money wasn’t a factor, what‘s something you would love to do? Who would you do it with?");
        al.add("Pretend I’m moving out of the country. Rather than having a going away party, I decide to hang out with you for the weekend. What would we do together?");
        al.add("If you think about the future, what is your next big challenge or milestone? How do you feel about it?");
        al.add("If you could have any musician (dead or alive) play at your birthday party, who would you choose and why?");
        al.add("Think about the next year. What are you most worried about? What are you most looking forward to?");
        al.add("Tell me about the most important steps you’ve taken to plan the future. Is there more to do?");
        al.add("If you think about the next couple of years, what is something you don’t want to compromise on?");
        al.add("");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item6, R.id.Text_holder, al );

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

                    Intent intent=new Intent(CardSet16.this, Pop_End6.class);
                    intent.putStringArrayListExtra("Key6", ar);
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
                Toast.makeText(CardSet16.this, "Click!", Toast.LENGTH_SHORT).show();
                flag = 1;
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What’s another name for a noisy body of water? “A creek”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet16.this, Pop_Joker.class));
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