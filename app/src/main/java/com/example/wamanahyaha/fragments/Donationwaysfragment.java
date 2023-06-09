package com.example.wamanahyaha.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wamanahyaha.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Donationwaysfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Donationwaysfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button cashbtn;
    private Button bitbtn;
    private Button visabtn;
    private Button previous;
    public void func(){
        cashbtn=getView().findViewById(R.id.cashdanationbtn);
        bitbtn=getView().findViewById(R.id.bitdonation);
        visabtn=getView().findViewById(R.id.visadonation);
        previous=getView().findViewById(R.id.backbtnn);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecylerViewFragment RecylerViewFragment=new RecylerViewFragment();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.FRAME, RecylerViewFragment,RecylerViewFragment.getTag()).commit();
            }
        });


        cashbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cashdonatefragment cashdonatefragment=new cashdonatefragment();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.FRAME, cashdonatefragment,cashdonatefragment.getTag()).commit();
            }
        });

        bitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Bitfragment Bitfragment=new Bitfragment();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.FRAME, Bitfragment,Bitfragment.getTag()).commit();
            }
        });
        visabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VISAdonationfragment VISAdonationfragment=new VISAdonationfragment();
                FragmentManager manager=getFragmentManager();
                manager.beginTransaction().replace(R.id.FRAME, VISAdonationfragment,VISAdonationfragment.getTag()).commit();
            }
        });
    }

    public Donationwaysfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Donationwaysfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Donationwaysfragment newInstance(String param1, String param2) {
        Donationwaysfragment fragment = new Donationwaysfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donationwaysfragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        func();
    }
}