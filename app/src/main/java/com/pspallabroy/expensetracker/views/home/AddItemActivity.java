package com.pspallabroy.expensetracker.views.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.pspallabroy.expensetracker.R;

public class AddItemActivity extends AppCompatActivity {
    EditText edtName;
    EditText edtAmount;
    EditText edtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtName = findViewById(R.id.etName);
        edtAmount = findViewById(R.id.etAmount);
        edtDesc = findViewById(R.id.etDescription);

        Intent intent = getIntent();
        String comingFrom = intent.getStringExtra("from");

        switch (comingFrom) {
            case "HOME":
                edtName.setVisibility(View.VISIBLE);
                break;

            case "DETAILS":
                edtName.setVisibility(View.GONE);
                break;
        }

        Button btnSave = findViewById(R.id.btnSaveItem);

        btnSave.setOnClickListener(v -> {
            Toast.makeText(this, "Save clicked", Toast.LENGTH_LONG).show();
        });
    }
}