package com.example.bearnapp.invite.adapter;

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
import com.example.bearnapp.invite.model.InviteFriendsItems;

import java.util.ArrayList;

public class InviteFriendsAdapter extends RecyclerView.Adapter<InviteFriendsAdapter.ViewHolder> {

    private InviteFriendsAdapter.OnClickLisitner1 onClickLisitner1;
    private ArrayList<InviteFriendsItems> inviteFriendsItems;

    public InviteFriendsAdapter(ArrayList<InviteFriendsItems> inviteFriendsItems, InviteFriendsAdapter.OnClickLisitner1 onClickLisitner1) {
        this.inviteFriendsItems = inviteFriendsItems;
        this.onClickLisitner1 = onClickLisitner1;
    }

    @NonNull
    @Override
    public InviteFriendsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InviteFriendsAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.invitefriends_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InviteFriendsAdapter.ViewHolder holder, final int position) {

        InviteFriendsItems objinviteFriendsItems = inviteFriendsItems.get(position);
        holder.textView.setText(objinviteFriendsItems.name);

        Glide.with(holder.imageView)
                .load(objinviteFriendsItems.poster)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.imageView);
        if (objinviteFriendsItems.isSleceted) {
            holder.tickbtn.setVisibility(View.VISIBLE);
        } else {
            holder.tickbtn.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InviteFriendsItems objinviteFriendsItems = inviteFriendsItems.get(position);
                objinviteFriendsItems.isSleceted = !objinviteFriendsItems.isSleceted;
                notifyItemChanged(position);
                onClickLisitner1.selectedCount1(getSelectedCount());
            }
        });
    }

    private int getSelectedCount() {
        int count = 0;
        for (InviteFriendsItems objinviteFriendsItems : inviteFriendsItems) {
            if (objinviteFriendsItems.isSleceted) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getItemCount() {
        return inviteFriendsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        ImageView tickbtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView21);
            imageView = itemView.findViewById(R.id.imageView9);
            tickbtn = itemView.findViewById(R.id.tickbtn);
        }
    }

    public interface OnClickLisitner1 {
        void selectedCount1(int count);
    }
}
