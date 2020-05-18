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

public class CardSet12 extends AppCompatActivity {

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
        al.add("Tell me about your parent growing up. What were they like?");
        al.add("Tell me a story about you and your friends growing up. What did you do for fun?");
        al.add("What do you think is different about the world today? How is it different from when you were growing up?");
        al.add("What’s the best thing you’ve ever eaten? Where were you and who were you with?");
        al.add("What kind of coffee did they serve on the Titanic? “Sanka”");
        al.add("Tell me about growing up. What was life like for you?");
        al.add("What is your most defining experience? What did you learn from it?");
        al.add("Do you remember the very first time you drove a car? What did it feel like?");
        al.add("");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item2, R.id.Text_holder, al );

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

                    Intent intent=new Intent(CardSet12.this, Pop_End2.class);
                    intent.putStringArrayListExtra("Key2",ar);
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
                Toast.makeText(CardSet12.this, "Click!", Toast.LENGTH_SHORT).show();
                flag = 1;
            }
        });

    }

    public void update(SwipeFlingAdapterView sfav){

        if(al.get(0) == "What kind of coffee did they serve on the Titanic? “Sanka”") {
            sfav.setBackgroundColor(RED);
            startActivity(new Intent(CardSet12.this, Pop_Joker.class));
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