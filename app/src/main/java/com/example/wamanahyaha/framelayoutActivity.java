package com.example.wamanahyaha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.wamanahyaha.fragments.privatedetailsfragment;
import com.example.wamanahyaha.fragments.thefaceoftheappfragment;

public class framelayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framelayout);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FRAME,new privatedetailsfragment());
        ft.commit();
    }
}