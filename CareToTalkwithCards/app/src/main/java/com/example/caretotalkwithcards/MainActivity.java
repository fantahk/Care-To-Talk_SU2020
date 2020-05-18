package com.example.caretotalkwithcards;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spanned Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        TextView l_f =  findViewById(R.id.textView2);
        Text = Html.fromHtml("<a href='https://www.aarp.org/caregiving'>More Resources at AARP</a>");
        l_f.setMovementMethod(LinkMovementMethod.getInstance());
        l_f.setText(Text);

        Button family = (Button)findViewById(R.id.button);
        Button caregiver =(Button)findViewById(R.id.button2);

        family.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent = new Intent(MainActivity.this, FamilyCaregiver.class );
                startActivity(intent);
            }
        });

        caregiver.setOnClickListener(new View.OnClickListener () {

            @Override
            public void onClick(View w) {
                Intent intent2 = new Intent(MainActivity.this, CaregiverConvo.class );
                startActivity((intent2));
            }
        });

    }
}
