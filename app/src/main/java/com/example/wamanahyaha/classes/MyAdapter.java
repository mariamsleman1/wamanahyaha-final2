package com.example.wamanahyaha.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.wamanahyaha.R;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<projectdatA>list;

    public MyAdapter(Context context, ArrayList<projectdatA> list) {
        this.context = context;
        this.list = list;
    }

    @androidx.annotation.NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.project,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull MyViewHolder holder, int position) {
        projectdatA projectdatA=list.get(position);
        holder.projectname.setText(projectdatA.getNameproject());
        holder.projectdetails.setText(projectdatA.getDetailsproject());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView projectname,projectdetails;
        public MyViewHolder(@NonNull View itemView)
        { super(itemView);
        projectname=itemView.findViewById(R.id.projectname);
        projectdetails=itemView.findViewById(R.id.detailsofproject);


    }

}}
