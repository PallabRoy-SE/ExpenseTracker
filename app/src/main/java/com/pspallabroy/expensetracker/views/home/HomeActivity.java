package com.pspallabroy.expensetracker.views.home;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pspallabroy.expensetracker.R;
import com.pspallabroy.expensetracker.databinding.ActivityHomeBinding;
import com.pspallabroy.expensetracker.views.models.MainItem;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    ArrayList<MainItem> mainItems = new ArrayList<MainItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityHomeBinding.inflate(getLayoutInflater());

        binding.mainList.setLayoutManager(new LinearLayoutManager(this));

        mainItems.add(new MainItem(1, "Jan 24", 2500.20));
        mainItems.add(new MainItem(2, "FEB 24", 25000));
        mainItems.add(new MainItem(3, "MAR 24", 5060));
        mainItems.add(new MainItem(4, "APR 24", 2190.39));
    }
}