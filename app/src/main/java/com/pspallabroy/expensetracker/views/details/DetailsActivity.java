package com.pspallabroy.expensetracker.views.details;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pspallabroy.expensetracker.R;
import com.pspallabroy.expensetracker.views.home.AddItemActivity;
import com.pspallabroy.expensetracker.views.models.DetailsItem;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    private ArrayList<DetailsItem> detailsItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        int id = bundle.getInt("id");

        detailsItems.add(new DetailsItem(1, 4590, "1 description"));
        detailsItems.add(new DetailsItem(2, 4440, "2 description"));
        detailsItems.add(new DetailsItem(3, 400290, "3 description"));
        detailsItems.add(new DetailsItem(4, 10940, "4 description"));
        detailsItems.add(new DetailsItem(5, 45520, "5 description"));

        DetailsRowAdapter adapter = new DetailsRowAdapter(this, detailsItems);

        RecyclerView detailsList = findViewById(R.id.revSecondaryList);
        detailsList.setLayoutManager(new LinearLayoutManager(this));
        detailsList.setAdapter(adapter);

        ImageView btnBack = findViewById(R.id.ivBack);
        btnBack.setOnClickListener(v -> onBackPressed());

        FloatingActionButton addBtn = findViewById(R.id.flBtnAddDetailItem);
        addBtn.setOnClickListener(v -> {
            Intent iAddExpense = new Intent(this, AddItemActivity.class);
            iAddExpense.putExtra("from", "DETAILS");
            startActivity(iAddExpense);
        });
    }
}