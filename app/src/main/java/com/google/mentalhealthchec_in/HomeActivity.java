package com.google.mentalhealthchec_in;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.mentalhealthchec_in.Fragments.FragmentCalender;
import com.google.mentalhealthchec_in.Fragments.FragmentEntries;
import com.google.mentalhealthchec_in.Fragments.FragmentMore;
import com.google.mentalhealthchec_in.Fragments.FragmentStats;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_calender;
    TextView txt_calender;
    private LinearLayout tvEntries, tvCalender, tvMore, tvStats;
    FloatingActionButton fab_plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentEntries frag_name = new FragmentEntries();
        FragmentManager manager = this.getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragmentcontainer, frag_name, frag_name.getTag()).commit();

        img_calender = findViewById(R.id.img_calender);
        tvEntries = findViewById(R.id.tvEntries);
        tvCalender = findViewById(R.id.tvCalender);
        tvMore = findViewById(R.id.tvMore);
        tvStats = findViewById(R.id.tvStats);
        fab_plus = findViewById(R.id.fab_plus);
        txt_calender = findViewById(R.id.txt_calender);

        img_calender.setOnClickListener(this);
        tvEntries.setOnClickListener(this);
        tvCalender.setOnClickListener(this);
        tvMore.setOnClickListener(this);
        tvStats.setOnClickListener(this);
        fab_plus.setOnClickListener(this);
        txt_calender.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvEntries:
                FragmentEntries fragment_1 = new FragmentEntries();
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().replace(R.id.fragmentcontainer, fragment_1, fragment_1.getTag()).commit();
                break;

            case R.id.tvStats:
                FragmentStats fragmentStats = new FragmentStats();
                FragmentManager manager2 = getSupportFragmentManager();
                manager2.beginTransaction().replace(R.id.fragmentcontainer, fragmentStats, fragmentStats.getTag()).commit();
                break;

            case R.id.tvCalender:
                break;

            case R.id.tvMore:
                FragmentMore fragmentMore = new FragmentMore();
                FragmentManager manager4 = getSupportFragmentManager();
                manager4.beginTransaction().replace(R.id.fragmentcontainer, fragmentMore, fragmentMore.getTag()).commit();
                break;

            case R.id.fab_plus:
                Intent intent = new Intent(HomeActivity.this, HowAreYouActivity.class);
                startActivity(intent);
                break;

            case R.id.img_calender:
                FragmentCalender fragmentCalender = new FragmentCalender();
                FragmentManager manager3 = getSupportFragmentManager();
                manager3.beginTransaction().replace(R.id.fragmentcontainer, fragmentCalender, fragmentCalender.getTag()).commit();
                break;

            case R.id.txt_calender:
                FragmentCalender fragmentCalender5 = new FragmentCalender();
                FragmentManager manager5 = getSupportFragmentManager();
                manager5.beginTransaction().replace(R.id.fragmentcontainer, fragmentCalender5, fragmentCalender5.getTag()).commit();
                break;
        }
    }
}