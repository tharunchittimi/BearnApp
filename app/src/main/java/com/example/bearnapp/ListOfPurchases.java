package com.example.bearnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bearnapp.adapter.ListOfPurchasesAdapter;

import java.util.ArrayList;

public class ListOfPurchases extends AppCompatActivity {

    ArrayList<LOPItems> lopItems;

    ImageView imgBackIcon;
    ImageView imgAdd;
    ImageView imgFilterMenu;
    ImageView imgMenuDashBoard;
    TextView txtCreate;

    ImageView imageViewLOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_purchases);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.item_animation_fall_down);
        imageViewLOP = findViewById(R.id.imageViewLOP);
        imageViewLOP.startAnimation(animation1);

        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgAdd = findViewById(R.id.imgAdd);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);

        imgBackIcon.setVisibility(View.VISIBLE);
        imgAdd.setVisibility(View.VISIBLE);
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

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListOfPurchases.this, ListOfPuchasesAdd.class);
                startActivity(intent);
            }
        });

        RecyclerView rv_LOP = findViewById(R.id.rv_LOP);
        lopItems = new ArrayList<>();

        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));
        lopItems.add(new LOPItems("PENDING", "Salewa Running \nShoes", "2", "+$1"));

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        rv_LOP.setLayoutManager(linearLayout);
        final Dashboard.ItemOffsetDecoration itemOffsetDecoration = new Dashboard.ItemOffsetDecoration(this, R.dimen.item_offset);
        rv_LOP.addItemDecoration(itemOffsetDecoration);
        ListOfPurchasesAdapter listOfPurchasesAdapter = new ListOfPurchasesAdapter(lopItems);
        rv_LOP.setAdapter(listOfPurchasesAdapter);

    }
}
