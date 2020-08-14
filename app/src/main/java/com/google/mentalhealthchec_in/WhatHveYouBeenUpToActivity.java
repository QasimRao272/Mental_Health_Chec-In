package com.google.mentalhealthchec_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.mentalhealthchec_in.Fragments.FragmentEntries;

import java.util.ArrayList;

public class WhatHveYouBeenUpToActivity extends AppCompatActivity implements View.OnClickListener {
    String img;
    ImageView imgEmoji, btn_save, arow_left;
    SharedPreferences pref;
    ImageView imgFamily, imgFriends, imgDate, imgExercise, imgSport, imgSleepEarly, imgEatHealthy, imgRelax, imgMovies, imgReading;
    ImageView imgGaming, imgCleaning, imgShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_hve_you_been_up_to);

        imgEmoji = findViewById(R.id.imgEmoji);
        btn_save = findViewById(R.id.btn_save);
        arow_left = findViewById(R.id.arow_left);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        imgFamily = findViewById(R.id.imgFamily);
        imgFriends = findViewById(R.id.imgFriend);
        imgDate = findViewById(R.id.imgDate);
        imgExercise = findViewById(R.id.imgExercise);
        imgSport = findViewById(R.id.imgSport);
        imgSleepEarly = findViewById(R.id.imgSleepEarly);
        imgEatHealthy = findViewById(R.id.imgEatHealthy);
        imgRelax = findViewById(R.id.imgRelax);
        imgMovies = findViewById(R.id.imgMovies);
        imgReading = findViewById(R.id.imgReading);
        imgGaming = findViewById(R.id.imgGaming);
        imgCleaning = findViewById(R.id.imgCleaning);
        imgShopping = findViewById(R.id.imgShopping);

        imgFamily.setOnClickListener(this);
        imgFriends.setOnClickListener(this);
        imgDate.setOnClickListener(this);
        imgExercise.setOnClickListener(this);
        imgSport.setOnClickListener(this);
        imgSleepEarly.setOnClickListener(this);
        imgEatHealthy.setOnClickListener(this);
        imgRelax.setOnClickListener(this);
        imgMovies.setOnClickListener(this);
        imgReading.setOnClickListener(this);
        imgGaming.setOnClickListener(this);
        imgCleaning.setOnClickListener(this);
        imgShopping.setOnClickListener(this);

        btn_save.setOnClickListener(this);
        arow_left.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgFamily:
                break;
            case R.id.imgFriend:
                break;
            case R.id.imgDate:
                break;
            case R.id.imgExercise:
                break;
            case R.id.imgSport:
                break;
            case R.id.imgSleepEarly:
                break;
            case R.id.imgEatHealthy:
                break;
            case R.id.imgRelax:
                break;
            case R.id.imgMovies:
                break;
            case R.id.imgReading:
                break;
            case R.id.imgGaming:
                break;
            case R.id.imgCleaning:
                break;
            case R.id.imgShopping:
                break;
            case R.id.arow_left:
                Intent intent1 = new Intent(WhatHveYouBeenUpToActivity.this, HowAreYouActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_save:
                Intent intent2 = new Intent(WhatHveYouBeenUpToActivity.this, HomeActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}