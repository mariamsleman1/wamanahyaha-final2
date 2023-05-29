package com.example.wamanahyaha.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wamanahyaha.Activities.MyviewHolder;
import com.example.wamanahyaha.R;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyviewHolder> {
    private  Context context ;
    private ArrayList<projectdatA> projects =new ArrayList<>();
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyviewHolder(LayoutInflater.from(context).inflate(R.layout.project,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        holder.projectname.setText("The score : "+projects.get(position).getNameproject());
        holder.projectdetails.setText("The Player : "+projects.get(position).getDetailsproject());
    }
    @Override
    public int getItemCount() {
        return projects.size();
    }
    public MyAdapter(Context context, ArrayList<projectdatA> projects) {
        this.context = context;
        projects = projects;
    }
}

