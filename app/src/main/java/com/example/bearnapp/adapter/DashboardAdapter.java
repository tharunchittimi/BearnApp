package com.example.bearnapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bearnapp.DashboardItems;
import com.example.bearnapp.R;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
    ArrayList<DashboardItems> dashboardItems;

    public DashboardAdapter(ArrayList<DashboardItems> dashboardItems) {
        this.dashboardItems = dashboardItems;
    }

    @NonNull
    @Override
    public DashboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DashboardAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_rv_slider, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapter.ViewHolder holder, int position) {

        DashboardItems objdashboardItems = dashboardItems.get(position);
        holder.rv_txt.setText(objdashboardItems.food);
        holder.rv_txt2.setText(objdashboardItems.time);

        Glide.with(holder.poster).load(objdashboardItems.poster).into(holder.poster);

        if (position == 0) {
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) holder.cardViewItem.getLayoutParams();
            params.setMargins(40, 0, 0, 0);
            holder.cardViewItem.setLayoutParams(params);
        }
    }

    @Override
    public int getItemCount() {
        return dashboardItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rv_txt;
        TextView rv_txt2;
        ImageView poster;
        CardView cardViewItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_txt = itemView.findViewById(R.id.rv_txt);
            rv_txt2 = itemView.findViewById(R.id.rv_txt2);
            poster = itemView.findViewById(R.id.rv_img);
            cardViewItem = itemView.findViewById(R.id.card);
        }
    }
}
