package com.google.mentalhealthchec_in;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class HelpUsImprove extends AppCompatActivity {
    Button btnAgree, btnDisagree;
    String MY_PREFS_NAME = "Mental_Health_Check-In";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_us_improve);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String done = prefs.getString("done", "no");
        if (done.equals("yes")) {
            startActivity(new Intent(getApplicationContext(), CustomizedActivity.class));
            finish();
        }

        btnAgree = findViewById(R.id.btn_agree);
        btnDisagree = findViewById(R.id.btnDisagree);

        btnDisagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("done", "yes");
                editor.apply();
                startActivity(new Intent(getApplicationContext(), CustomizedActivity.class));
                finish();
            }
        });
        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                editor.putString("done", "yes");
                editor.apply();
                startActivity(new Intent(getApplicationContext(), CustomizedActivity.class));
                finish();
            }
        });
    }
}