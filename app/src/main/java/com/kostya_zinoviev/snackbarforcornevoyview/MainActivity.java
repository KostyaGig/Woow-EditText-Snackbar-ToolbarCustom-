package com.kostya_zinoviev.snackbarforcornevoyview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String MY_TAG = "MyTag";
    private FrameLayout frameLayout;
    private FloatingActionButton floatingActionButton;
    private TextView textView;
    private int counterLikes;
    public static final String KEY_LIKES = "Likes";
    private TextView day;
    private TextView month;
    private TextView year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        day = findViewById(R.id.day);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        textView = findViewById(R.id.counter);
        //Получаем все время,дату,день,время
        Date currentTime = Calendar.getInstance().getTime();
        String dateFormat = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);
        //Получаем дату
        /*String dayString = DateFormat
        .getDateInstance(DateFormat.DAY_OF_WEEK_FIELD).format(currentTime);
        String monthString = DateFormat.getDateInstance(DateFormat.MONTH_FIELD).format(currentTime).toString();
        String yearString = DateFormat.getDateInstance(DateFormat.YEAR_FIELD).format(currentTime);
        day.setText(dayString);
        month.setText(monthString);
        year.setText(yearString);
        day.setText(dayString);*/
        String[] split = dateFormat.split(",");
        day.setVisibility(View.GONE);
        year.setVisibility(View.GONE);
        month.setText(split[1]);
        Log.i(MY_TAG,split[1].trim());
        /*Log.i(MY_TAG,split[2].trim());*/
        ConstraintLayout constraintLayout = findViewById(R.id.con);
        if (savedInstanceState != null) {
            counterLikes = savedInstanceState.getInt(KEY_LIKES);
        } else {
            Snackbar.make(constraintLayout, "Null", Snackbar.LENGTH_SHORT).show();
        }
        textView.setText(String.valueOf(counterLikes));
       /* frameLayout = findViewById(R.id.container);
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar make = Snackbar.make(frameLayout, "Сработал SnackBar,относительно frameLayout", Snackbar.LENGTH_SHORT);
                make.
                        setAction("Отмена", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
//                                Действие
                            }
                        })
                       .show();
            }
        });*/
        Button button = findViewById(R.id.button);
        AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
        animationDrawable.start();
    }

    public void like(View view) {
        counterLikes++;
        textView.setText(String.valueOf(counterLikes));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_LIKES, counterLikes);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
