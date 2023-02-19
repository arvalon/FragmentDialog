package com.example.admin.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import static com.example.admin.dialogfragment.MainActivity.LOG;

public class MyDialog extends DialogFragment {

    public MyDialog() {
        super();
        Log.d(LOG, "MyDialog constructor");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(LOG, "MyDialog onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(LOG,"MyDialog onStart");
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(LOG, "MyDialog onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Log.d(LOG, "MyDialog onCreateDialog");

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setMessage("You file will be deleted! Are you sure?")
                .setTitle("Delete file")
                .setPositiveButton("Delete", (dialog, which) -> {
                    try {
                        ((DialogHost)getContext()).positive();
                    }
                    catch (ClassCastException ex) {}
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    try {
                        ((DialogHost)getContext()).negative();
                    }
                    catch (ClassCastException ex) {}
                    dialog.cancel();
                });
        return builder.create();
    }

    @Override
    public void dismiss() {
        Log.d(LOG,"MyDialog dismiss");
        super.dismiss();
    }

    @Override
    public void onStop() {
        Log.d(LOG,"MyDialog onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(LOG,"MyDialog onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(LOG,"MyDialog onDetach");
        super.onDetach();
    }

    public interface DialogHost {
        void positive();
        void negative();
    }
}
