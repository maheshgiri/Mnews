package android.mvp.mnews.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.mvp.mnews.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MasterFragment extends DialogFragment{

    @Bind(R.id.head)
    private TextInputEditText head;
    @Bind(R.id.url)
    private TextInputEditText url;
    @Bind(R.id.desc)
    private TextInputEditText desc;
    @Bind(R.id.expd)
    private TextInputEditText expd;



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        View view= LayoutInflater.from(getContext()).inflate(R.layout.activity_newsadd,null);
        ButterKnife.bind(view);
        builder.setView(view);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Map<String, Object> city = new HashMap<>();
                city.put("name", "Los Angeles");
                city.put("state", "CA");
                city.put("country", "USA");

                FirebaseFirestore.getInstance().collection("master").document("BGsDQ4Xzci4Db2AhY2xb")
                        .set(city)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("DEBUG", "DocumentSnapshot successfully written!");
                                dismiss();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("DEBUG", "Error writing document", e);
                                dismiss();
                            }
                        });
            }
        });

        return builder.create();
    }
}
