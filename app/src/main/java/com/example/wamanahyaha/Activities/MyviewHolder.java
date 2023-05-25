package com.example.wamanahyaha.Activities;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wamanahyaha.R;

import org.checkerframework.checker.nullness.qual.NonNull;

public class MyviewHolder extends RecyclerView.ViewHolder {
    public TextView projectname, projectdetails;


    public MyviewHolder(@NonNull View itemView) {
        super(itemView);
        projectname= itemView.findViewById(R.id.projectname);
        projectdetails =itemView.findViewById(R.id.projectdetails);
    }
}
