package com.example.bearnapp.challengecontest.spinneradapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bearnapp.R;


public class ChallengeSpinnerAdapter extends BaseAdapter {
    public Context context;
    public int images[];
    public String[] users;

    public LayoutInflater inflter;

    public ChallengeSpinnerAdapter(Context applicationContext, int[] images, String[] users) {
        this.context = applicationContext;
        this.images = images;
        this.users = users;

        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinnerone, null);

        ImageView icons = view.findViewById(R.id.imageView2);
        TextView names = view.findViewById(R.id.textView5);

        icons.setImageResource(images[i]);
        names.setText(users[i]);

        if (i == 0) {

            view.setVisibility(View.VISIBLE);

        }
        return view;
    }

}