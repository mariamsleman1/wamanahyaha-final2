package com.example.wamanahyaha;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ShiftRequestManager {
    private static final String TAG = "ShiftRequestManager";
    private CollectionReference requestsCollection;

    public ShiftRequestManager() {
        // Initialize Firestore reference
        requestsCollection = FirebaseFirestore.getInstance().collection("requests");
    }

    public void addShiftRequest(ShiftRequestManager sr) {
        requestsCollection.add(sr)
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
                    }});
}
}


