package com.example.assigment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CourseActivity extends AppCompatActivity {
    BottomNavigationView nav_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        nav_view =(BottomNavigationView) this.findViewById(R.id.nav_view);
//        TabLayout tabLayout = (TabLayout) this.findViewById(R.id.tabLayout);
//        nav_view.setupWithViewPager(viewPager);

        final ListsFragment blankFragment = new ListsFragment();
        final StudentFragment blankFragment2 = new StudentFragment();
        nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.list:
                            fragment = new ListsFragment();
                            break;
                        case R.id.schedule:
                            fragment = new ScheduleFragment();
                            break;
                        case R.id.test:
                            fragment = new TestsFragment();
                            break;
                        case R.id.student:
                            fragment = new StudentFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
                return true;
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ListsFragment()).commit();

    }
}
