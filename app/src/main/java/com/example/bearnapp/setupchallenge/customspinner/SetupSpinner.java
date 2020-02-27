package com.example.bearnapp.setupchallenge.customspinner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bearnapp.R;

public class SetupSpinner extends BaseAdapter {
    public Context context;
    public String[] users;

    public LayoutInflater inflter;

    public SetupSpinner(Context applicationContext, String[] users) {
        this.context = applicationContext;
        this.users = users;

        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return users.length;
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
        view = inflter.inflate(R.layout.setup_spinner, null);

        TextView names = view.findViewById(R.id.textView5);

        names.setText(users[i]);

        if (i == 0) {

            view.setVisibility(View.VISIBLE);

        }
        return view;
    }
}
