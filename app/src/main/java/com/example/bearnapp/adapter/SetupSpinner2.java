package com.example.bearnapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bearnapp.R;

public class SetupSpinner2 extends BaseAdapter {
    public Context context;
    public int image[];
    public String[] Levels;

    public LayoutInflater inflter;

    public SetupSpinner2(Context applicationContext, int[] image, String[] Levels) {
        this.context = applicationContext;
        this.image = image;
        this.Levels = Levels;

        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return image.length;
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
        view = inflter.inflate(R.layout.setup_spinner_2, null);

        ImageView icons = view.findViewById(R.id.imageView12);
        TextView names = view.findViewById(R.id.textView15);

        icons.setImageResource(image[i]);
        names.setText(Levels[i]);

        if (i == 0) {

            view.setVisibility(View.VISIBLE);

        }
        return view;
    }
}
