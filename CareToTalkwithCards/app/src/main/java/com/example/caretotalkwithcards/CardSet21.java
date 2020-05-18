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

public class CardSet21 extends AppCompatActivity {

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        al = new ArrayList<>();
        al.add("What’s something you’re afraid to tell the person you’re caring for?");
        al.add("What worries you the most about your future?");
        al.add("How has caregiving affected your current financial situation, if at all?");
        al.add("When was the last time you felt out of control in your relationship with the person you’re caring for?");
        al.add("How has being a caregiver affected your relationships with others (family, friends or colleagues)?");
        al.add("What do you think will be the next big change, challenge or major milestone for you as a caregiver?");
        al.add("What’s something you learned about yourself through caregiving? About the world?");
        al.add("What has been the most difficult conversation you’ve had with the person you’re caring for?");
        al.add("Who do you wish were more involved when it comes to the person you are caring for?");
        al.add("What’s been the most challenging part of your relationship with the person you’re caring for?");
        al.add("When was the last time you were worried about money?");
        al.add("When was the last time you were upset with the person you’re caring for? What did you do?");
        al.add("What’s the biggest tension point you’re currently experiencing with the person you are caring for?");
        al.add("How has your role as a caregiver affected your own health? How do you feel about this?");
        al.add("What do you regret most about how you’ve acted towards the person you’re caring for?");
        al.add("Looking ahead to the next year, what are you most pessimistic about?");
        al.add("What conversations do you want to have with the person you’re caring for? What’s holding you back?");
        al.add("What did the dog say when he walked over sandpaper? \"Rough, rough.\" ");
        al.add("");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item21, R.id.Text_holder, al );

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
                    startActivity(new Intent(CardSet21.this, Pop_End21.class));
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
                Toast.makeText(CardSet21.this, "Click!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What did the dog say when he walked over sandpaper? \"Rough, rough.\" ") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet21.this, Pop_Joker.class));
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