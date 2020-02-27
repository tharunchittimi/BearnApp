package com.example.bearnapp.qusandanswer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bearnapp.R;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {
    private String[] dataItems;
    private OnAnswerClicked onAnswerClicked;

    public AnswersAdapter(String[] dataItems, OnAnswerClicked onAnswerClicked) {
        this.dataItems = dataItems;
        this.onAnswerClicked = onAnswerClicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.answers_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtAnswer.setText(dataItems[holder.getAdapterPosition()]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAnswerClicked.onSelected(dataItems[holder.getAdapterPosition()]);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItems.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtAnswer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAnswer = itemView.findViewById(R.id.txtAnswer);
        }
    }

    public interface OnAnswerClicked {
        void onSelected(String answer);
    }
}