package com.example.tony.mustapp.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tony.mustapp.R;

public class PosterActivity extends AppCompatActivity {

    private Fragment fragment = null;
    private Class fragmentClass = null;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster);

        fragmentManager = getSupportFragmentManager();
        fragmentClass = PosterFragment.class;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        fragmentManager.beginTransaction().add(R.id.container, fragment).commit();



    }
}
