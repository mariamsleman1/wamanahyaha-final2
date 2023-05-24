package com.example.wamanahyaha.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wamanahyaha.R;
import com.example.wamanahyaha.classes.addprojectmanager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.CollectionReference;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link add_project_manager#newInstance} factory method to
 * create an instance of this fragment.
 */
public class add_project_manager extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView imageofprojuct;
    private EditText nameofproject;
    private EditText detailsofproject;
    private EditText dateofproject;
    private Button addprojectbtn;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference requestsCollection;

    public void addproject(){
        String etnameofproject,etdetailsofproject,etdateofproject;
        imageofprojuct=getView().findViewById(R.id.imgofproject);
        nameofproject=getView().findViewById(R.id.nameofproject);
        detailsofproject=getView().findViewById(R.id.detailsofproject);
        dateofproject=getView().findViewById(R.id.dateofprojects);
        etnameofproject=nameofproject.getText().toString();
        etdetailsofproject=detailsofproject.getText().toString();
        etdateofproject=dateofproject.getText().toString();
        addprojectbtn=getView().findViewById(R.id.adprojbtn);




        addprojectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etnameofproject.trim().isEmpty()&&etdetailsofproject.trim().isEmpty()&&etdateofproject.trim().isEmpty()) {
                    Toast.makeText(getContext(), "empty! try again!", Toast.LENGTH_SHORT).show();
                    return;}
                else {
                    addprojectmanager project = new addprojectmanager(etnameofproject, etdetailsofproject, etdateofproject);
                    adddatetofirstore(project);
                } }
        });

    }
    private void adddatetofirstore(addprojectmanager project) {

try{

                    db.collection("projects")
                            .add(project).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(), "DATA SAVED", Toast.LENGTH_SHORT).show();
                                    //go to projects
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(getContext(), "somthing failed", Toast.LENGTH_SHORT).show();
                                    //try to save
                                    Log.e("", e.getMessage());
                                }});}
                catch (Exception ex){

            Log.e("",ex.getMessage());

        }




      /*  requestsCollection = FirebaseFirestore.getInstance().collection("projects");
        requestsCollection.add(project)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getContext(), "project added succesfull", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "somthing failed", Toast.LENGTH_SHORT).show();
                    }});*/
    }


    public add_project_manager() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment add_project_manager.
     */
    // TODO: Rename and change types and number of parameters
    public static add_project_manager newInstance(String param1, String param2) {
        add_project_manager fragment = new add_project_manager();
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
        return inflater.inflate(R.layout.fragment_add_project_manager, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        addproject();
    }
}