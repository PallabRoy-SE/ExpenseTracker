package com.pspallabroy.expensetracker.views.details;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pspallabroy.expensetracker.R;
import com.pspallabroy.expensetracker.views.models.DetailsItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DetailsRowAdapter extends RecyclerView.Adapter<DetailsRowAdapter.ViewHolder> {
    private ArrayList<DetailsItem> detailsItems;
    private Context context;

    public DetailsRowAdapter(Context context, ArrayList<DetailsItem> detailsItems) {
        this.context = context;
        this.detailsItems = detailsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.detail_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DetailsItem currentItem = detailsItems.get(position);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMM, yyyy");
        holder.tvDate.setText(dateFormatter.format(currentItem.getDate()));

        holder.tvAmount.setText(new StringBuilder().append("₹").append(currentItem.getAmount()).toString());

        holder.ivDetailBtn.setOnClickListener(v -> {
            Toast.makeText(context, currentItem.getDate().toLocaleString(), Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getItemCount() {
        return detailsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvAmount;
        TextView tvDate;
        ImageView ivDetailBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tvDate);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            ivDetailBtn = itemView.findViewById(R.id.ivDetail);
        }
    }
}
