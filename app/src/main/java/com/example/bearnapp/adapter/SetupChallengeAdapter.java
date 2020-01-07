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
import com.example.bearnapp.SetupChallenegItems;

import java.util.ArrayList;

public class SetupChallengeAdapter extends RecyclerView.Adapter<SetupChallengeAdapter.ViewHolder> {

    private ArrayList<SetupChallenegItems> setupChallenegItems;

    public SetupChallengeAdapter(ArrayList<SetupChallenegItems> setupChallenegItems) {
        this.setupChallenegItems = setupChallenegItems;
    }

    @NonNull
    @Override
    public SetupChallengeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SetupChallengeAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.setup_challeneg_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SetupChallengeAdapter.ViewHolder holder, int position) {
        SetupChallenegItems objsetupChallenegItems = setupChallenegItems.get(position);
        holder.No.setText(objsetupChallenegItems.no);
        Glide.with(holder.Poster)
                .load(objsetupChallenegItems.poster)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.Poster);
        holder.Name.setText(objsetupChallenegItems.name);
    }

    @Override
    public int getItemCount() {
        return setupChallenegItems.size();
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
