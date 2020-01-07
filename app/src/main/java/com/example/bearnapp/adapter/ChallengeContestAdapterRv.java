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
import com.example.bearnapp.ChallengeContestItemsRv;
import com.example.bearnapp.R;

import java.util.ArrayList;

public class ChallengeContestAdapterRv extends RecyclerView.Adapter<ChallengeContestAdapterRv.ViewHolder> {

    private ArrayList<ChallengeContestItemsRv> challengeContestItemsRv;

    public ChallengeContestAdapterRv(ArrayList<ChallengeContestItemsRv> challengeContestItemsRv) {
        this.challengeContestItemsRv = challengeContestItemsRv;
    }

    @NonNull
    @Override
    public ChallengeContestAdapterRv.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChallengeContestAdapterRv.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.challenge_contest_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeContestAdapterRv.ViewHolder holder, int position) {
        ChallengeContestItemsRv objchallengeContestItemsRv = challengeContestItemsRv.get(position);
        holder.dot.setColorFilter(objchallengeContestItemsRv.dot);
        Glide.with(holder.imageView)
                .load(objchallengeContestItemsRv.Poster)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView);
        holder.type.setText(objchallengeContestItemsRv.type);
        holder.title.setText(objchallengeContestItemsRv.title);
        holder.cost.setText(objchallengeContestItemsRv.cost);


//        if (position == 0) {
//            holder.itemView.setBackgroundColor(Color.parseColor("#E1E7EB"));
//        } else if (position % 2 == 0) {
//            holder.itemView.setBackgroundColor(Color.parseColor("#E1E7EB"));
//
//        } else {
//            holder.itemView.setBackgroundColor(Color.parseColor("#FEFEFE"));
//        }
    }


    @Override
    public int getItemCount() {
        return challengeContestItemsRv.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView dot;
        ImageView imageView;
        TextView type;
        TextView title;
        TextView cost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dot = itemView.findViewById(R.id.imageView22);
            imageView = itemView.findViewById(R.id.img);
            type = itemView.findViewById(R.id.cardTxt);
            title = itemView.findViewById(R.id.cardTxt2);
            cost = itemView.findViewById(R.id.cardTxt4);

        }
    }
}
