package com.example.bearnapp.listofpurchases.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bearnapp.R;
import com.example.bearnapp.listofpurchases.model.LOPItems;

import java.util.ArrayList;

public class ListOfPurchasesAdapter extends RecyclerView.Adapter<ListOfPurchasesAdapter.ViewHolder> {
    private ArrayList<LOPItems> lopItems;

    public ListOfPurchasesAdapter(ArrayList<LOPItems> lopItems) {
        this.lopItems = lopItems;
    }

    @NonNull
    @Override
    public ListOfPurchasesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListOfPurchasesAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_of_purchase_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListOfPurchasesAdapter.ViewHolder holder, int position) {

        LOPItems objlopItems = lopItems.get(position);
        holder.textView36.setText(objlopItems.status);
        holder.textView37.setText(objlopItems.name);
        holder.textView38.setText(objlopItems.count);
        holder.textView39.setText(objlopItems.cost);

    }

    @Override
    public int getItemCount() {
        return lopItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView36;
        TextView textView37;
        TextView textView38;
        TextView textView39;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView36 = itemView.findViewById(R.id.textView36);
            textView37 = itemView.findViewById(R.id.textView37);
            textView38 = itemView.findViewById(R.id.textView38);
            textView39 = itemView.findViewById(R.id.textView39);

        }
    }
}
