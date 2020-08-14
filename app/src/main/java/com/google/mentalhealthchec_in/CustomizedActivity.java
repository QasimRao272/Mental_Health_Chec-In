package com.google.mentalhealthchec_in;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomizedActivity extends AppCompatActivity {
    ConstraintLayout intro_screen1, intro_screen2, intro_screen3, intro_screen4, intro_screen5, intro_screen6;
    ImageView arrow_next;
    ImageView img1, img2, img3, img4, img5, img6;
    TextView tvBack;
    int counter = 1;
    String MY_PREFS_NAME = "Mental_Health_Check-In";
    SharedPreferences.Editor editor;
    LinearLayout emoji1_layout, emoji2_layout, emoji3_layout;
    ImageView img_color_1, img_color_2, img_color_3;
    CheckBox cb_hobbies, cb_social, cb_sleep;
    TextView tvChangeReminder;
    TextView title_setup_reminder;
    RadioButton rb_exercise, rb_sleep_eary, rb_drink_water, rb_eat_healthy, rb_meditation, rb_reading;
    String single_value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        initilise();

        check_if_all_screens_done();

        SharedPreferences prefs1 = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String val = prefs1.getString("single_value", "No Value");
        Toast.makeText(this, "" + val, Toast.LENGTH_SHORT).show();

        arrow_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (counter == 1) {
                    img1.setImageResource(R.mipmap.circle_gray);
                    intro_screen1.setVisibility(View.GONE);
                    intro_screen2.setVisibility(View.VISIBLE);
                    img2.setImageResource(R.mipmap.circle_black);
                    counter++;

                } else if (counter == 2) {
                    img2.setImageResource(R.mipmap.circle_gray);
                    intro_screen2.setVisibility(View.GONE);
                    intro_screen3.setVisibility(View.VISIBLE);
                    img3.setImageResource(R.mipmap.circle_black);
                    counter++;

                } else if (counter == 3) {
                    img3.setImageResource(R.mipmap.circle_gray);
                    intro_screen3.setVisibility(View.GONE);
                    intro_screen4.setVisibility(View.VISIBLE);
                    img4.setImageResource(R.mipmap.circle_black);
                    counter++;
                } else if (counter == 4) {
                    img4.setImageResource(R.mipmap.circle_gray);
                    intro_screen4.setVisibility(View.GONE);
                    intro_screen5.setVisibility(View.VISIBLE);
                    img5.setImageResource(R.mipmap.circle_black);
                    counter++;

                } else if (counter == 5) {
                    img5.setImageResource(R.mipmap.circle_gray);
                    intro_screen5.setVisibility(View.GONE);
                    intro_screen6.setVisibility(View.VISIBLE);
                    img6.setImageResource(R.mipmap.circle_black);
                    counter++;
                } else if (counter == 6) {
                    editor.putString("All_Screens_Done", "Yes");
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), HowAreYouActivity.class));
                }
            }
        });

       /* tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 5;
                if (count == 5) {
                    img5.setImageResource(R.mipmap.circle_black);
                    img6.setImageResource(R.mipmap.circle_gray);
                    intro_screen5.setVisibility(View.VISIBLE);
                    intro_screen6.setVisibility(View.GONE);
                    count--;
                } else if (count == 4) {
                    img4.setImageResource(R.mipmap.circle_black);
                    img5.setImageResource(R.mipmap.circle_gray);
                    intro_screen4.setVisibility(View.VISIBLE);
                    intro_screen5.setVisibility(View.GONE);
                    count--;
                } else if (count == 3) {
                    img3.setImageResource(R.mipmap.circle_black);
                    img4.setImageResource(R.mipmap.circle_gray);
                    intro_screen3.setVisibility(View.VISIBLE);
                    intro_screen4.setVisibility(View.GONE);
                    count--;
                } else if (count == 2) {
                    img2.setImageResource(R.mipmap.circle_black);
                    img3.setImageResource(R.mipmap.circle_gray);
                    intro_screen2.setVisibility(View.VISIBLE);
                    intro_screen3.setVisibility(View.GONE);
                    count--;
                } else if (count == 1) {
                    img1.setImageResource(R.mipmap.circle_black);
                    img2.setImageResource(R.mipmap.circle_gray);
                    intro_screen1.setVisibility(View.VISIBLE);
                    intro_screen2.setVisibility(View.GONE);
                    count--;
                }
            }
        });*/

        // Onclick For Emojis Scroll View
        //Layout Number One
        emoji1_layout.setBackgroundResource(R.drawable.select_border_color);
        emoji1_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emoji1_layout.setBackgroundResource(R.drawable.select_border_color);
                emoji2_layout.setBackgroundResource(R.drawable.unselect_border_color);
                emoji3_layout.setBackgroundResource(R.drawable.unselect_border_color);
            }
        });

        emoji2_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emoji2_layout.setBackgroundResource(R.drawable.select_border_color);
                emoji1_layout.setBackgroundResource(R.drawable.unselect_border_color);
                emoji3_layout.setBackgroundResource(R.drawable.unselect_border_color);
            }
        });

        emoji3_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emoji3_layout.setBackgroundResource(R.drawable.select_border_color);
                emoji1_layout.setBackgroundResource(R.drawable.unselect_border_color);
                emoji2_layout.setBackgroundResource(R.drawable.unselect_border_color);
            }
        });

        img_color_1.setBackgroundResource(R.drawable.select_border_color);
        img_color_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_color_1.setBackgroundResource(R.drawable.select_border_color);
                img_color_2.setBackgroundResource(R.drawable.unselect_border_color);
                img_color_3.setBackgroundResource(R.drawable.unselect_border_color);
            }
        });
        img_color_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_color_2.setBackgroundResource(R.drawable.select_border_color);
                img_color_1.setBackgroundResource(R.drawable.unselect_border_color);
                img_color_3.setBackgroundResource(R.drawable.unselect_border_color);
            }
        });
        img_color_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img_color_3.setBackgroundResource(R.drawable.select_border_color);
                img_color_1.setBackgroundResource(R.drawable.unselect_border_color);
                img_color_2.setBackgroundResource(R.drawable.unselect_border_color);
            }
        });

        // Layout Number Two
        //Onclicks For Social, Hobbies and Sleep
        cb_social.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putString("Social", "Yes");
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "Social Apllied !", Toast.LENGTH_SHORT).show();
                } else {
                    editor.remove("Social");
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "Social Removed !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb_hobbies.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putString("Hobbies", "Yes");
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "Hobbies Apllied !", Toast.LENGTH_SHORT).show();
                } else {
                    editor.remove("Hobbies");
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "Hobbies Removed !", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb_sleep.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    editor.putString("Sleep", "Yes");
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "Sleep Apllied !", Toast.LENGTH_SHORT).show();
                } else {
                    editor.remove("Sleep");
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "Sleep Removed !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Layout Number Three
        //On Clicks For Reminder

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String time = prefs.getString("time", "Set Time");
        title_setup_reminder.setText(time);

        tvChangeReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                final int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(CustomizedActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Time time = new Time(hour, minute, 0);

                                //little h uses 12 hour format and big H uses 24 hour format
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h : mm a");

                                //format takes in a Date, and Time is a sublcass of Date
                                String s = simpleDateFormat.format(time);
                                title_setup_reminder.setText(s);

                                editor.putString("time", s);
                                editor.apply();
                            }
                        }, hour, minute, false);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();

            }
        });

        //Layout Number Four
        //On Clicks For Layout Number 4
        rb_exercise.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    single_value = "exercise";
                    rb_eat_healthy.setChecked(false);
                    rb_drink_water.setChecked(false);
                    rb_sleep_eary.setChecked(false);
                    rb_meditation.setChecked(false);
                    rb_reading.setChecked(false);
                    editor.putString("single_value", single_value);
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "" + single_value, Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb_sleep_eary.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    single_value = "sleep_early";
                    rb_exercise.setChecked(false);
                    rb_drink_water.setChecked(false);
                    rb_eat_healthy.setChecked(false);
                    rb_meditation.setChecked(false);
                    rb_reading.setChecked(false);
                    editor.putString("single_value", single_value);
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "" + single_value, Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb_drink_water.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    single_value = "drink_water";
                    rb_exercise.setChecked(false);
                    rb_sleep_eary.setChecked(false);
                    rb_eat_healthy.setChecked(false);
                    rb_meditation.setChecked(false);
                    rb_reading.setChecked(false);
                    editor.putString("single_value", single_value);
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "" + single_value, Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb_eat_healthy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    single_value = "eat_healthy";
                    rb_exercise.setChecked(false);
                    rb_sleep_eary.setChecked(false);
                    rb_drink_water.setChecked(false);
                    rb_meditation.setChecked(false);
                    rb_reading.setChecked(false);
                    editor.putString("single_value", single_value);
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "" + single_value, Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb_meditation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    single_value = "meditation";
                    rb_exercise.setChecked(false);
                    rb_sleep_eary.setChecked(false);
                    rb_drink_water.setChecked(false);
                    rb_eat_healthy.setChecked(false);
                    rb_reading.setChecked(false);
                    editor.putString("single_value", single_value);
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "" + single_value, Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb_reading.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    single_value = "reading";
                    rb_exercise.setChecked(false);
                    rb_sleep_eary.setChecked(false);
                    rb_drink_water.setChecked(false);
                    rb_eat_healthy.setChecked(false);
                    rb_meditation.setChecked(false);
                    editor.putString("single_value", single_value);
                    editor.apply();
                    Toast.makeText(CustomizedActivity.this, "" + single_value, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void check_if_all_screens_done() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String val = prefs.getString("All_Screens_Done", "No name defined");
        if (val.equals("Yes")) {
            startActivity(new Intent(getApplicationContext(), HowAreYouActivity.class));
            finish();
        }
    }

    private void initilise() {
        intro_screen1 = findViewById(R.id.intro_screen1);
        intro_screen2 = findViewById(R.id.intro_screen2);
        intro_screen3 = findViewById(R.id.intro_screen3);
        intro_screen4 = findViewById(R.id.intro_screen4);
        intro_screen5 = findViewById(R.id.intro_screen5);
        intro_screen6 = findViewById(R.id.intro_screen6);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);

        arrow_next = findViewById(R.id.arrow_Next);
        tvBack = findViewById(R.id.arrow_back);

        editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();

        emoji1_layout = findViewById(R.id.emoji1_layout);
        emoji2_layout = findViewById(R.id.emoji2_layout);
        emoji3_layout = findViewById(R.id.emoji3_layout);

        img_color_1 = findViewById(R.id.img_color_1);
        img_color_2 = findViewById(R.id.img_color_2);
        img_color_3 = findViewById(R.id.img_color_3);

        cb_social = findViewById(R.id.cb_social);
        cb_hobbies = findViewById(R.id.cb_hobbies);
        cb_sleep = findViewById(R.id.cb_sleep);

        tvChangeReminder = findViewById(R.id.tvChangeReminder);
        title_setup_reminder = findViewById(R.id.title_setup_reminder);

        rb_exercise = findViewById(R.id.rb_exercise);
        rb_sleep_eary = findViewById(R.id.rb_sleep_early);
        rb_drink_water = findViewById(R.id.rb_drink_water);
        rb_eat_healthy = findViewById(R.id.rb_eat_healthy);
        rb_meditation = findViewById(R.id.rb_meditation);
        rb_reading = findViewById(R.id.rb_reading);
    }
}