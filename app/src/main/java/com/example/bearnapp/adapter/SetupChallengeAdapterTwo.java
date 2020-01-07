package com.example.bearnapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.bearnapp.R;
import com.example.bearnapp.SetupChallengeDataItems;

import java.util.ArrayList;

public class SetupChallengeAdapterTwo extends RecyclerView.Adapter<SetupChallengeAdapterTwo.ViewHolder> {

    private ArrayList<SetupChallengeDataItems> setupChallengeDataItems;

    public SetupChallengeAdapterTwo(ArrayList<SetupChallengeDataItems> setupChallengeDataItems) {
        this.setupChallengeDataItems = setupChallengeDataItems;
    }

    @NonNull
    @Override
    public SetupChallengeAdapterTwo.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SetupChallengeAdapterTwo.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setup_challeneg_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SetupChallengeAdapterTwo.ViewHolder holder, int position) {
        SetupChallengeDataItems objsetupChallengeDataItems = setupChallengeDataItems.get(position);
        holder.No.setText(objsetupChallengeDataItems.no);
        Glide.with(holder.Poster)
                .load(objsetupChallengeDataItems.poster)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.Poster);
        holder.Name.setText(objsetupChallengeDataItems.name);
    }

    @Override
    public int getItemCount() {
        return setupChallengeDataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView No;
        ImageView Poster;
        TextView Name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            No = itemView.findViewById(R.id.textView50);
            Poster = itemView.findViewById(R.id.imageView144);
            Name = itemView.findViewById(R.id.textView51);
        }
    }
}
