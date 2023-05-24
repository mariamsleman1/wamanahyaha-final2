package com.example.wamanahyaha.fragments;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wamanahyaha.Activities.RecyclerViewActivity;
import com.example.wamanahyaha.Activities.privatedatabenefactotactivity;
import com.example.wamanahyaha.R;
import com.example.wamanahyaha.classes.personaldetailspenefactor;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link privatedetailsfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class privatedetailsfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText etusername;
    private EditText etphonenumber;
    private Button adddata;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();



    public void func() {
        String usernamme, phonenum;
        etusername = getView().findViewById(R.id.namebenefactorr);
        etphonenumber = getView().findViewById(R.id.phonebenefactorr);
        adddata = getView().findViewById(R.id.finishbtnn);
        usernamme = etusername.getText().toString();
        phonenum = etphonenumber.getText().toString();



        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernamme.trim().isEmpty()&&phonenum.trim().isEmpty()){
                    Toast.makeText(getContext(), "empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    personaldetailspenefactor per = new personaldetailspenefactor(usernamme, phonenum);
                    db.collection("users")
                            .add(per).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(), "data was saved", Toast.LENGTH_SHORT).show();

                                    //go to projects
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Toast.makeText(getContext(), "data not saved try another data", Toast.LENGTH_SHORT).show();
                                    //try to save
                                    Log.e("",e.getMessage());
                                }
                            });


                }
                catch (Exception ex){

                    Log.e("",ex.getMessage());
                }




            }
        });
    }

    public privatedetailsfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment privatedetailsfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static privatedetailsfragment newInstance(String param1, String param2) {
        privatedetailsfragment fragment = new privatedetailsfragment();
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
        return inflater.inflate(R.layout.fragment_privatedetailsfragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        func();

        //gotorecycler();
    }

   /* private void gotorecycler() {
        Intent i = new Intent(getActivity(), RecyclerViewActivity.class);
        startActivity(i);
        ((RecyclerViewActivity) getActivity()).overridePendingTransition(0, 0);
    }*/
}