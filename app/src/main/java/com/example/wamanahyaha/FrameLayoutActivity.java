package com.example.wamanahyaha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.wamanahyaha.fragments.RecylerViewFragment;
import com.example.wamanahyaha.fragments.thefaceoftheappfragment;

public class FrameLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FRAME,new RecylerViewFragment());
        ft.commit();
    }
}