package com.example.wamanahyaha.fragments;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.net.Uri;
import com.example.wamanahyaha.FireBaseServises;
import com.example.wamanahyaha.R;
import com.example.wamanahyaha.classes.personaldetailspenefactor;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;


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
   // private Uri filePath;

    private EditText etusername;
    private EditText etphonenumber;
    private Button adddata;
    private ImageView Perphoto;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FireBaseServises fbs;

   int SELECT_PICTURE =100;


    Bitmap ProductPho = null;

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                   Perphoto.setImageURI(selectedImageUri);
                    if (data != null) {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(privatedetailsfragment.this.getContext().getContentResolver(), data.getData());
                            Perphoto.setImageBitmap(bitmap);
                            ProductPho = bitmap;
                            Perphoto.setRotation(90);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (resultCode == Activity.RESULT_CANCELED)  {
                    Toast.makeText(getContext(), "canceled!", Toast.LENGTH_SHORT).show();
                }
            }
                }
            }


    public void func() {
        Perphoto = getView().findViewById(R.id.perphoto);
        etusername = getView().findViewById(R.id.namebenefactorr);
        etphonenumber = getView().findViewById(R.id.phonebenefactorr);
        adddata = getView().findViewById(R.id.donationpaypal);


        Perphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        adddata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String usernamme, phonenum;
                usernamme = etusername.getText().toString();
                phonenum = etphonenumber.getText().toString();

                if (usernamme.trim().isEmpty() && phonenum.trim().isEmpty()) {
                    Toast.makeText(getContext(), "empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                try{
                personaldetailspenefactor per = new personaldetailspenefactor(usernamme, phonenum);
                   db.collection("users")
                            .add(per).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(), "data was saved", Toast.LENGTH_SHORT).show();

                                    RecylerViewFragment RecylerViewFragment=new RecylerViewFragment();
                                    FragmentManager manager=getFragmentManager();
                                    manager.beginTransaction().replace(R.id.frameLayout,RecylerViewFragment,RecylerViewFragment.getTag()).commit();
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

   /* private void add(View view)
    {
        // check if any field is empty
        String username, phonenumber, pesonPhoto;
        username = etusername.getText().toString();
        phonenumber = etphonenumber.getText().toString();
        if (Perphoto.getDrawable() == null)
            pesonPhoto = "no_image";
        else
            pesonPhoto = UploadImageToFirebase();
        if (username.trim().isEmpty() || phonenumber.trim().isEmpty()
                || pesonPhoto.trim().isEmpty()||Perphoto.getDrawable() == null)
        {
            Toast.makeText(getContext(), "error fields empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            personaldetailspenefactor per = new personaldetailspenefactor(username, phonenumber, pesonPhoto);
            //public Product(String productName, String proInfo, String proCompany, String proPhoto, String proPrice) {
            fbs.getFire().collection("Products")
                    .add(per)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding document", e);
                        }
                    });
        }
    }*/
  /*  private String UploadImageToFirebase()
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ProductPho.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
        StorageReference ref = fbs.getStorage().getReference("Perphot/" + UUID.randomUUID().toString());
        UploadTask uploadTask = ref.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
            }
        });
        return ref.getPath();
    }
*/



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
        adddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               func();
            }
        });
    }

}