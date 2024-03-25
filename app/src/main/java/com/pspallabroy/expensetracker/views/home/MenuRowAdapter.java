package com.pspallabroy.expensetracker.views.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pspallabroy.expensetracker.R;
import com.pspallabroy.expensetracker.views.details.DetailsActivity;
import com.pspallabroy.expensetracker.views.models.MainItem;

import java.util.ArrayList;

public class MenuRowAdapter extends RecyclerView.Adapter<MenuRowAdapter.ViewHolder> {
    private Context context;
    private ArrayList<MainItem> mainItems;

    MenuRowAdapter(Context context, ArrayList<MainItem> mainItems) {
        this.context = context;
        this.mainItems = mainItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.main_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MainItem currentItem = mainItems.get(position);
        holder.tvName.setText(currentItem.getName());
        holder.tvAmount.setText(new StringBuilder().append("₹").append(currentItem.getAmount()).toString());
        holder.llRow.setOnClickListener(v -> {
            Intent iDetails = new Intent(context, DetailsActivity.class);

            Bundle bundle = new Bundle();
            bundle.putInt("id", currentItem.getId());
            iDetails.putExtras(bundle);

            context.startActivity(iDetails);
        });
    }

    @Override
    public int getItemCount() {
        return mainItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAmount;
        LinearLayout llRow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvMainRowItemName);
            tvAmount = itemView.findViewById(R.id.tvMainRowItemAmount);
            llRow = itemView.findViewById(R.id.mainRow);
        }
    }
}
