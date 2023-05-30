package com.example.wamanahyaha.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.wamanahyaha.R;
import com.example.wamanahyaha.classes.MyAdapter;
import com.example.wamanahyaha.classes.PersonalpageActivity;
import com.example.wamanahyaha.classes.callBack;
import com.example.wamanahyaha.classes.projectdatA;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecylerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecylerViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
     private RecyclerView recyclerView;
   private DatabaseReference databaseReference;
    private   MyAdapter myAdapter;
   private ArrayList<projectdatA> list=new ArrayList<>();
   private FirebaseFirestore DB=FirebaseFirestore.getInstance();
   private Button Donate ;
private callBack  Callback;
private Button previous;

    public RecylerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecylerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecylerViewFragment newInstance(String param1, String param2) {
        RecylerViewFragment fragment = new RecylerViewFragment();
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
        return inflater.inflate(R.layout.fragment_recyler_view, container, false);


    }


    @Override
    public void onStart() {
        super.onStart();

        recyclerView = getView().findViewById(R.id.recyclerView);


        Donate = getView().findViewById(R.id.donate);
        Donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Donationwaysfragment Donationwaysfragment = new Donationwaysfragment();
                FragmentManager manager = getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction().replace(R.id.FRAME, Donationwaysfragment, Donationwaysfragment.getTag()).commit();
                }
            }
        });


        /*previous=getView().findViewById(R.id.backbtn);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PersonalpageActivity.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);
            }
        });
*/


        // Callback = list->connect();
        DB.collection("projects")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            list.add(document.toObject(projectdatA.class));
                        }
                    }
                    //Callback.onCallBack(list);
                    connect();
                }).addOnFailureListener(e -> {
                    Toast.makeText(getContext(), "no data || something wrong ", Toast.LENGTH_SHORT).show();
                });

    }


    public void connect (){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        myAdapter  = new MyAdapter(getContext(),(list));
        recyclerView.setAdapter(myAdapter);
    }
}