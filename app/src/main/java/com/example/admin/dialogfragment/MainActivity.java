package com.example.admin.dialogfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MyDialog.DialogHost {

    public static final String LOG = "DIALOG.LOG";

    private MyDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_dialog_button).setOnClickListener(v -> startDialog(null));

        findViewById(R.id.check_dialog_button).setOnClickListener(v -> {
            Log.d(LOG,"FragmentDialog null: " + (dialog == null));
            Log.d(LOG,"Dialog null: " + (dialog.getDialog() == null));
        });
    }

    public void startDialog(View view) {

        dialog = new MyDialog();

        dialog.show(getSupportFragmentManager(), "FILE_DELETE");
    }

    @Override
    public void positive() {
        Toast.makeText(this, "File deleted!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void negative() {
        Toast.makeText(this, "Operation cancelled!", Toast.LENGTH_SHORT).show();
    }
}
