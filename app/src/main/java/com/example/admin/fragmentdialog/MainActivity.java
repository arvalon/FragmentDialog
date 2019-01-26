package com.example.admin.fragmentdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialog.DialogHost {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startDialog(View view) {
        MyDialog dialog = new MyDialog();
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
