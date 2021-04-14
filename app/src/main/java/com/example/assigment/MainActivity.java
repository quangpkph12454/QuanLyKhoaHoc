package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.assigment.DAO.ScheduleDAO;

public class MainActivity extends AppCompatActivity {
    public static ScheduleDAO scheduleDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scheduleDAO = new ScheduleDAO(MainActivity.this);
    }

    public void course(View view) {
        Intent i = new Intent(MainActivity.this,CourseActivity.class);
        startActivity(i);
    }

    public void maps(View view) {
        Intent i = new Intent(MainActivity.this,MapsActivity.class);
        startActivity(i);

    }

    public void news(View view) {
        Intent i = new Intent(MainActivity.this,NewsActivity.class);
        startActivity(i);
    }

    public void social(View view) {
        Intent i = new Intent(MainActivity.this,SocialActivity.class);
        startActivity(i);
    }
}
