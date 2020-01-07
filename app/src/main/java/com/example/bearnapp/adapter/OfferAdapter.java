package com.example.bearnapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bearnapp.R;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    private ArrayList<OffersItems> offersItems;

    public OfferAdapter(ArrayList<OffersItems> offersItems) {
        this.offersItems = offersItems;
    }

    @NonNull
    @Override
    public OfferAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OfferAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offer_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OfferAdapter.ViewHolder holder, int position) {
        OffersItems objOfferItems = offersItems.get(position);
        holder.rv_txt.setText(objOfferItems.food);
        holder.rv_txt2.setText(objOfferItems.time);
//        holder.poster.setImageDrawable(ContextCompat.getDrawable(holder.poster.getContext(),objOfferItems.poster));

        Glide.with(holder.poster).load(objOfferItems.poster).into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return offersItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView rv_txt;
        TextView rv_txt2;
        ImageView poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_txt = itemView.findViewById(R.id.rv_txtt);
            rv_txt2 = itemView.findViewById(R.id.rv_txtt2);
            poster = itemView.findViewById(R.id.rv_img1);
        }
    }
}
