package com.example.wamanahyaha.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wamanahyaha.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VISAdonationfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VISAdonationfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText visatallnum;
    private EditText date;
    private EditText visatcvv;
    private EditText idownervisa;
    private EditText howmuch;

    public void func(){
        String etvisanum,etvisaownerid,etvisacvv,etvisadate,etmablag;
        visatallnum=getView().findViewById(R.id.visanumber);
        date=getView().findViewById(R.id.datevisa);
        visatcvv=getView().findViewById(R.id.cvvvosa);
        idownervisa=getView().findViewById(R.id.visaidnum);
        howmuch=getView().findViewById(R.id.mablag);
        etmablag=howmuch.getText().toString();
        etvisacvv=visatcvv.getText().toString();
        etvisanum=visatallnum.getText().toString();
        etvisadate=visatcvv.getText().toString();
        etvisaownerid=date.getText().toString();

if( etvisacvv==null&&date==null&&visatcvv==null&&idownervisa==null&&etmablag==null){
    Toast.makeText(getContext(), "somthing null !!", Toast.LENGTH_SHORT).show();
}
else{
    Toast.makeText(getContext(), "donate succes!", Toast.LENGTH_SHORT).show();
        Toast.makeText(getContext(), " thank you so much!", Toast.LENGTH_SHORT).show();}






    }





    public VISAdonationfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VISAdonationfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VISAdonationfragment newInstance(String param1, String param2) {
        VISAdonationfragment fragment = new VISAdonationfragment();
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
        return inflater.inflate(R.layout.fragment_v_i_s_adonationfragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        func();
    }
}