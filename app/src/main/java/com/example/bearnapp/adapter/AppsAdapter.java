package com.example.bearnapp.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bearnapp.DataItems;
import com.example.bearnapp.R;

import java.util.ArrayList;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder> {
    private Button btnApp;
    private ArrayList<DataItems> dataItems;
    private OnClickLisitner onClickLisitner;

    public AppsAdapter(ArrayList<DataItems> dataItems, OnClickLisitner onClickLisitner) {
        this.dataItems = dataItems;
        this.onClickLisitner = onClickLisitner;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AppsAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_fragment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppsAdapter.ViewHolder holder, final int position) {
        DataItems objDataItems = dataItems.get(position);
        holder.title.setText(objDataItems.title);
        Glide.with(holder.itemView).load(objDataItems.Poster).into(holder.poster);
        if (objDataItems.isSleceted) {
            holder.checkBtn.setVisibility(View.VISIBLE);
        } else {
            holder.checkBtn.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataItems objDataItems = dataItems.get(position);
                objDataItems.isSleceted = !objDataItems.isSleceted;
                notifyItemChanged(position);
                onClickLisitner.selectedCount(getSelectedCount());
            }
        });
    }

    private int getSelectedCount() {
        int count = 0;
        for (DataItems dataItems : dataItems) {
            if (dataItems.isSleceted) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView poster;
        ImageView checkBtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.imageViewApp);
            title = itemView.findViewById(R.id.textView8);
            checkBtn = itemView.findViewById(R.id.checkBtn);
        }
    }

    public interface OnClickLisitner {
        void selectedCount(int count);
    }
}
