package com.example.wamanahyaha.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.wamanahyaha.R;
import com.example.wamanahyaha.classes.loginmanagerclass;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link managerlogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class managerlogin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText email;
    private EditText password;
    private String passwordmanager;
    private String emailmanager;
    private Button loginmanagerbtn;
    private Button changepassword;

    public void loginstart(){
        String etuemailmanager,etpasswordmanger ,useremail="mariam@gmail.com",pass="11092005";
        loginmanagerclass loginmanagerclass=new loginmanagerclass(useremail,pass);
        loginmanagerclass.setPASS(pass);
        loginmanagerclass.setUSEREMAIL(useremail);


        email = getView().findViewById(R.id.emaillogimnamger);
        password = getView().findViewById(R.id.passwordloginmanager);
       loginmanagerbtn=getView().findViewById(R.id.loginbtnmanager);
        etuemailmanager=email.getText().toString();
        etpasswordmanger=password.getText().toString();

        loginmanagerclass user= new loginmanagerclass(etuemailmanager ,etpasswordmanger);
        loginmanagerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(user.getUSEREMAIL()==useremail && user.getPASS()==pass){
                    //GO TO ADD PRODUCTS
                    add_project_manager add_project_manager=new add_project_manager();
                    FragmentManager manager=getFragmentManager();
                    manager.beginTransaction().replace(R.id.frameLayout,add_project_manager,add_project_manager.getTag()).commit();
               }

               /* else{
                    Toast.makeText(getContext(), "somthing failed", Toast.LENGTH_SHORT).show();
                    return;

            }

        }*/
       });

    }


    public managerlogin() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment managerlogin.
     */
    // TODO: Rename and change types and number of parameters
    public static managerlogin newInstance(String param1, String param2) {
        managerlogin fragment = new managerlogin();
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
        return inflater.inflate(R.layout.fragment_managerlogin, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        loginstart();
    }
}