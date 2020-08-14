package com.google.mentalhealthchec_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class HowAreYouActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBad, imgGood, imgAwful, imgRad, imgMeh;
    SharedPreferences pref;
    String MY_PREFS_NAME = "Mental_Health_Check-In";
    SharedPreferences.Editor editor;
    private Bitmap imageToStore;
    DatabaseHandler objectDatabaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_are_you);

        SharedPreferences prefs = this.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String val = prefs.getString("HowAreYou", "No");
        if (val.equals("Yes")) {
            startActivity(new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class));
            finish();
        }

        // In Activity's onCreate() for instance
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        imgAwful = findViewById(R.id.img_awful);
        imgBad = findViewById(R.id.img_bad);
        imgGood = findViewById(R.id.img_good);
        imgRad = findViewById(R.id.img_rad);
        imgMeh = findViewById(R.id.img_meh);

        imgAwful.setOnClickListener(this);
        imgBad.setOnClickListener(this);
        imgGood.setOnClickListener(this);
        imgRad.setOnClickListener(this);
        imgMeh.setOnClickListener(this);

        objectDatabaseHandler = new DatabaseHandler(this);
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_awful:
                String awful = "awful";
                //////
                Bitmap largeIcon1 = BitmapFactory.decodeResource(getResources(), R.drawable.awful);
                objectDatabaseHandler.storeImage(new ModelClass(awful, largeIcon1));
                //////
                Intent intent = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent.putExtra("img", "awful");
                startActivity(intent);
                finish();
                break;
            case R.id.img_bad:
                String bad = "bad";
                //////
                Bitmap largeIcon2 = BitmapFactory.decodeResource(getResources(), R.drawable.sad);
                objectDatabaseHandler.storeImage(new ModelClass(bad, largeIcon2));
                //////
                Intent intent2 = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent2.putExtra("img", "bad");
                startActivity(intent2);
                finish();
                break;
            case R.id.img_good:
                String good = "good";
                //////
                Bitmap largeIcon3 = BitmapFactory.decodeResource(getResources(), R.drawable.good);
                objectDatabaseHandler.storeImage(new ModelClass(good, largeIcon3));
                //////
                Intent intent3 = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent3.putExtra("img", "good");
                startActivity(intent3);
                finish();
                break;
            case R.id.img_rad:
                String rad = "rad";
                //////
                Bitmap largeIcon4 = BitmapFactory.decodeResource(getResources(), R.drawable.rad);
                objectDatabaseHandler.storeImage(new ModelClass(rad, largeIcon4));
                //////
                Intent intent4 = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent4.putExtra("img", "rad");
                startActivity(intent4);
                finish();
                break;
            case R.id.img_meh:
                String meh = "meh";
                //////
                Bitmap largeIcon5 = BitmapFactory.decodeResource(getResources(), R.drawable.meh);
                objectDatabaseHandler.storeImage(new ModelClass(meh, largeIcon5));
                //////
                Intent intent5 = new Intent(getApplicationContext(), WhatHveYouBeenUpToActivity.class);
                intent5.putExtra("img", "meh");
                startActivity(intent5);
                finish();
                break;
        }
    }
}