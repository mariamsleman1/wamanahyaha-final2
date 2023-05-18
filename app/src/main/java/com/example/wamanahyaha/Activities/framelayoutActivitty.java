package com.example.wamanahyaha.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.wamanahyaha.R;
import com.example.wamanahyaha.fragments.Donationwaysfragment;

public class framelayoutActivitty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout_activitty);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame,new Donationwaysfragment());
        ft.commit();
    }
}