package com.example.bearnapp.listofpurchases.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bearnapp.R;
import com.example.bearnapp.listofpurchases.model.LOPAddItems;

import java.util.ArrayList;

public class ListOfPurchaseAddAdapter extends RecyclerView.Adapter<ListOfPurchaseAddAdapter.ViewHolder> {

    private ArrayList<LOPAddItems> lopAddItems;

    public ListOfPurchaseAddAdapter(ArrayList<LOPAddItems> lopAddItems) {
        this.lopAddItems = lopAddItems;
    }

    @NonNull
    @Override
    public ListOfPurchaseAddAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListOfPurchaseAddAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_of_purchase_add_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListOfPurchaseAddAdapter.ViewHolder holder, int position) {
        LOPAddItems objlopAddItems = lopAddItems.get(position);
        Glide.with(holder.Poster)
                .load(objlopAddItems.poster)
                .into(holder.Poster);

        holder.Title.setText(objlopAddItems.title);
        holder.Price.setText(objlopAddItems.price);
        holder.Cashback.setText(objlopAddItems.cashback);
    }

    @Override
    public int getItemCount() {
        return lopAddItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Poster;
        TextView Title;
        TextView Price;
        TextView Cashback;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Poster = itemView.findViewById(R.id.imageView14);
            Title = itemView.findViewById(R.id.textView40);
            Price = itemView.findViewById(R.id.textView41);
            Cashback = itemView.findViewById(R.id.textView42);

        }
    }
}
