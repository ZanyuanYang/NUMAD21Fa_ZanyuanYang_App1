package com.example.numad21fa_zanyuanyang;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LinkCollectorDialog extends AppCompatDialogFragment {

    private EditText editTextName;
    private EditText editTextUrl;
    private ExampleDialogListener listener;
    private ArrayList<LinkList> linkList;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.link_collector_dialog, null);
//        View view1 = inflater.inflate(R.layout.link_collector, null);

        builder.setView(view)
                .setTitle("Link Collector")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        String name = editTextName.getText().toString();
                        String url = editTextUrl.getText().toString();
                        listener.applyTexts(name, url);
                    }
                });

        editTextName = view.findViewById(R.id.link_name);
        editTextUrl = view.findViewById(R.id.link_url);



        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            listener = (ExampleDialogListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener{
        void applyTexts(String name, String url);
    }
}
