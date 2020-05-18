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

public class CardSet23 extends AppCompatActivity {

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_viewer);

        al = new ArrayList<>();
        al.add("What’s your favorite memory of you and the person you’re caring for? What made that moment special?");
        al.add("What’s the most important thing you’ve learned from the person you’re caring for? Does that insight make you a better caregiver?");
        al.add("What’s the worst job you’ve had? Did caregiving ever affect your work or a job? ");
        al.add("What’s going on with the person you’re caring for, but hasn’t been discussed? Why is that?");
        al.add("If you could un-invent or un-learn something, what would it be?");
        al.add("What do you call a sad cup of coffee? “A depresso”");
        al.add("If a magic genie could grant you three wishes to improve your situation as a caregiver, what would they be?");
        al.add("Finish the statement, “Thinking about taking care of myself, I wish I did more…”");
        al.add("What’s something you wish everyone knew about being a family caregiver?");
        al.add("Where do you turn to find more information or advice about family caregiving?");
        al.add("When you take a break from caregiving, where do you go and what do you do to recharge?");
        al.add("Not everyone identifies as a “caregiver”. What words best describe your role in caring for your loved one?");
        al.add("What’s your “caregiving philosophy”?");
        al.add("Pretend the person you’re caring for were a superhero. What power would they have? What would you call them?");
        al.add("Looking ahead to next year, what are you most optimistic about as a caregiver?");
        al.add("What about your caregiving experience brings you the most joy?");
        al.add("What is the one thing you want to accomplish in your lifetime?");
        al.add("Who do you care for? What is the extent or scope of your role as a family caregiver?");
        al.add("");


        arrayAdapter = new ArrayAdapter<>(this, R.layout.item23, R.id.Text_holder, al );

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
                    startActivity(new Intent(CardSet23.this, Pop_End23.class));
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
                Toast.makeText(CardSet23.this, "Click!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What do you call a sad cup of coffee? “A depresso”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet23.this, Pop_Joker.class));
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