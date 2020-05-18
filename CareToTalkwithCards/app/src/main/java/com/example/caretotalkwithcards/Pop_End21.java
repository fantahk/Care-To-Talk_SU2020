package com.example.caretotalkwithcards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Pop_End21 extends Activity {

    public ArrayList<String> a_final, ar1, ar2, ar3, ar4, ar5, ar6, ar7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_end21);

        a_final = new ArrayList<>();
        ar1 = new ArrayList<>();
        ar2 = new ArrayList<>();
        ar3 = new ArrayList<>();
        ar4 = new ArrayList<>();
        ar5 = new ArrayList<>();
        ar6 = new ArrayList<>();
        ar7 = new ArrayList<>();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.7), (int)(width*0.7));

        Button ret = (Button) findViewById(R.id.button17);

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getIntent().getStringArrayListExtra("Key1") != null){
                    ar1 = (ArrayList<String>) getIntent().getStringArrayListExtra("Key1");
                    if (ar1.size() != 0) {
                        while (ar1.size() != 0) {

                            a_final.add(ar1.get(0));
                            ar1.remove(0);

                        }
                    }
                }
                else if(getIntent().getStringArrayListExtra("Key2") != null) {
                    ar2 = (ArrayList<String>) getIntent().getStringArrayListExtra("Key2");
                    if (ar2.size() != 0) {
                        while (ar2.size() != 0) {

                            a_final.add(ar2.get(0));
                            ar2.remove(0);

                        }
                    }
                }

                else if(getIntent().getStringArrayListExtra("Key3") != null) {
                    ar3 = (ArrayList<String>) getIntent().getStringArrayListExtra("Key3");
                    if (ar3.size() != 0) {
                        while (ar3.size() != 0) {

                            a_final.add(ar3.get(0));
                            ar3.remove(0);

                        }
                    }
                }
                else if(getIntent().getStringArrayListExtra("Key4") != null) {
                    ar4 = (ArrayList<String>) getIntent().getStringArrayListExtra("Key4");
                    if (ar4.size() != 0) {
                        while (ar4.size() != 0) {

                            a_final.add(ar4.get(0));
                            ar4.remove(0);

                        }
                    }
                }
                else if(getIntent().getStringArrayListExtra("Key5") != null) {
                    ar5 = (ArrayList<String>) getIntent().getStringArrayListExtra("Key5");
                    if (ar5.size() != 0) {
                        while (ar5.size() != 0) {

                            a_final.add(ar5.get(0));
                            ar5.remove(0);

                        }
                    }
                }
                else if(getIntent().getStringArrayListExtra("Key6") != null) {
                    ar6 = (ArrayList<String>) getIntent().getStringArrayListExtra("Key6");
                    if (ar6.size() != 0) {
                        while (ar6.size() != 0) {

                            a_final.add(ar6.get(0));
                            ar6.remove(0);

                        }
                    }
                }
                else if(getIntent().getStringArrayListExtra("Key7") != null) {
                    ar7 = (ArrayList<String>) getIntent().getStringArrayListExtra("Key7");
                    if (ar7.size() != 0) {
                        while (ar7.size() != 0) {

                            a_final.add(ar7.get(0));
                            ar7.remove(0);

                        }
                    }
                }
                else
                    a_final.add("No Favorites!");
                Intent intent=new Intent(Pop_End21.this, CaregiverConvo.class);
                intent.putStringArrayListExtra("Key",a_final);
                startActivity(intent);
            }
        });

    }
}
