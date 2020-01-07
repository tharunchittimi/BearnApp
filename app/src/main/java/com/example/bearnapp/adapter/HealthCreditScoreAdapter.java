package com.example.bearnapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bearnapp.HealthCreditScoreItems;
import com.example.bearnapp.R;

import java.util.ArrayList;

public class HealthCreditScoreAdapter extends RecyclerView.Adapter<HealthCreditScoreAdapter.ViewHolder> {
    private ArrayList<HealthCreditScoreItems> healthCreditScoreItems;

    public HealthCreditScoreAdapter(ArrayList<HealthCreditScoreItems> healthCreditScoreItems) {
        this.healthCreditScoreItems = healthCreditScoreItems;
    }

    @NonNull
    @Override
    public HealthCreditScoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HealthCreditScoreAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.healthcreditscore_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HealthCreditScoreAdapter.ViewHolder holder, int position) {
        HealthCreditScoreItems objhealthCreditScoreItems = healthCreditScoreItems.get(position);
        holder.textView.setColorFilter(objhealthCreditScoreItems.dot);
        holder.textView1.setText(objhealthCreditScoreItems.title);
        holder.textView2.setText(objhealthCreditScoreItems.points);
        if (position == 0) {
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
            params.setMargins(0, 200, 0, 0);
            holder.itemView.setLayoutParams(params);
        }

    }

    @Override
    public int getItemCount() {
        return healthCreditScoreItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView textView;
        TextView textView1;
        TextView textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView22);
            textView1 = itemView.findViewById(R.id.textView23);
            textView2 = itemView.findViewById(R.id.textView26);
        }
    }
}
