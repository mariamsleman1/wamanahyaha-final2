package com.example.wamanahyaha;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        String etuemailmanager,etpasswordmanger;
        email = getView().findViewById(R.id.emaillogimnamger);
        password = getView().findViewById(R.id.passwordloginmanager);
       loginmanagerbtn=getView().findViewById(R.id.loginbtnmanager);
        passwordmanager="1234";
        emailmanager="mari";
        etuemailmanager=email.getText().toString();
        etpasswordmanger=password.getText().toString();
        loginmanagerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if(etuemailmanager==emailmanager && passwordmanager==etpasswordmanger){
                    //GO TO ADD PRODUCTS
                    manage_rallprojects_fragmaent manage_rallprojects_fragmaent=new manage_rallprojects_fragmaent();
                    FragmentManager manager=getFragmentManager();
                    manager.beginTransaction().replace(R.id.frameLayout,manage_rallprojects_fragmaent,manage_rallprojects_fragmaent.getTag()).commit();
              //  }

              /*  else{
                    Toast.makeText(getContext(), "somthing failed", Toast.LENGTH_SHORT).show();
                    return;
                }*/
            }

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