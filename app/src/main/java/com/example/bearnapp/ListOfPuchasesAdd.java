package com.example.bearnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bearnapp.adapter.ListOfPurchaseAddAdapter;
import com.example.bearnapp.adapter.ListOfPurchasesAdapter;

import java.util.ArrayList;

public class ListOfPuchasesAdd extends AppCompatActivity {
    ImageView imgBackIcon;
    ImageView imgAdd;
    ImageView imgFilterMenu;
    ImageView imgMenuDashBoard;
    TextView txtCreate;
    ArrayList<LOPAddItems> lopAddItems;

    ImageView imageViewSummary1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_puchases_add);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.item_animation_fall_down);
        imageViewSummary1 = findViewById(R.id.imageViewSummary1);
        imageViewSummary1.startAnimation(animation1);

        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgAdd = findViewById(R.id.imgAdd);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);

        imgBackIcon.setVisibility(View.VISIBLE);
        imgAdd.setVisibility(View.GONE);
        imgBackIcon.setColorFilter(getResources().getColor(R.color.Black));
        imgFilterMenu.setVisibility(View.GONE);
        txtCreate.setText("List of Purchases");
        imgMenuDashBoard.setVisibility(View.GONE);

        imgBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RecyclerView rv_LOPADD = findViewById(R.id.rv_LOPADD);

        lopAddItems = new ArrayList<>();

        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));
        lopAddItems.add(new LOPAddItems(R.drawable.ic_tick, "Chesapeake Shirmp \nSalad Healthy", "$22.20", "$0.05"));

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        rv_LOPADD.setLayoutManager(linearLayout);
        ListOfPurchaseAddAdapter listOfPurchaseAddAdapter = new ListOfPurchaseAddAdapter(lopAddItems);
        rv_LOPADD.setAdapter(listOfPurchaseAddAdapter);

    }
}
