package com.example.admin.fragmentdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Admin on 02.06.2016.
 */
public class MyDialog extends DialogFragment {

    public interface DialogHost
    {
        void positive();
        void negative();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
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
}
