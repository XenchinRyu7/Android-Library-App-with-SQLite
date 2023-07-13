package com.vsga.mylibrary;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnStore, btnGetAll;
    private EditText etName;
    private DatabaseHelper databaseHelper;
    private TextView tVNames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengubah warna latar belakang ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.teal_700));
        }

        databaseHelper = new DatabaseHelper(this);
        tVNames = findViewById(R.id.tVNames);
        btnStore = findViewById(R.id.btnStore);
        btnGetAll = findViewById(R.id.btnGet);
        etName = findViewById(R.id.etName);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.addStudentDetail(etName.getText().toString());
                etName.setText("");
                Toast.makeText(MainActivity.this, "Stored Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList = databaseHelper.getAllStudentsList();
                tVNames.setText("");
                for (int i = 0; i < arrayList.size(); i++) {
                    tVNames.append(arrayList.get(i) + ", ");
                }
            }
        });
    }
}
