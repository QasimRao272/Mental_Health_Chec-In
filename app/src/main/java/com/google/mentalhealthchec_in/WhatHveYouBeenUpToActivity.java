package com.google.mentalhealthchec_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WhatHveYouBeenUpToActivity extends AppCompatActivity {
    String img;
    ImageView imgEmoji, btn_save, arow_left;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_hve_you_been_up_to);

        imgEmoji = findViewById(R.id.imgEmoji);
        btn_save = findViewById(R.id.btn_save);
        arow_left = findViewById(R.id.arow_left);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WhatHveYouBeenUpToActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        arow_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WhatHveYouBeenUpToActivity.this, HowAreYouActivity.class);
                startActivity(intent);
            }
        });

        img = getIntent().getStringExtra("img");

        if (img != null) {
            if (img.equals("awful")) {
                imgEmoji.setImageResource(R.mipmap.awful);
            } else if (img.equals("bad")) {
                imgEmoji.setImageResource(R.mipmap.sad);

            } else if (img.equals("good")) {
                imgEmoji.setImageResource(R.mipmap.good);

            } else if (img.equals("rad")) {
                imgEmoji.setImageResource(R.mipmap.rad);

            } else if (img.equals("meh")) {
                imgEmoji.setImageResource(R.mipmap.meh);
            }
        }
    }
}