package com.example.bearnapp.offers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bearnapp.R;
import com.example.bearnapp.dashboard.Dashboard;
import com.example.bearnapp.offers.adapter.OfferAdapter;
import com.example.bearnapp.offers.model.OffersItems;

import java.util.ArrayList;

public class Offer extends AppCompatActivity {
    private ArrayList<OffersItems> offersItems;
    ImageView imgBackIcon;
    ImageView imgFilterMenu;
    ImageView imgMenuDashBoard;
    TextView txtCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);

        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);

        imgBackIcon.setVisibility(View.VISIBLE);
        imgBackIcon.setColorFilter(getResources().getColor(R.color.Black));
        imgFilterMenu.setVisibility(View.GONE);
        txtCreate.setText("Offers");
        imgMenuDashBoard.setVisibility(View.GONE);

        imgBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        RecyclerView recyclerViewOffer = findViewById(R.id.rv_offer);
        offersItems = new ArrayList<>();

        offersItems.add(new OffersItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        offersItems.add(new OffersItems("1 Free Drink", "12h 58m", R.drawable.drink));
        offersItems.add(new OffersItems("Equinox", "12d 10m", R.drawable.equinox));
        offersItems.add(new OffersItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        offersItems.add(new OffersItems("1 Free Drink", "12h 58m", R.drawable.drink));
        offersItems.add(new OffersItems("Equinox", "12d 10m", R.drawable.equinox));
        offersItems.add(new OffersItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        offersItems.add(new OffersItems("1 Free Drink", "12h 58m", R.drawable.drink));
        offersItems.add(new OffersItems("Equinox", "12d 10m", R.drawable.equinox));
        offersItems.add(new OffersItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        offersItems.add(new OffersItems("1 Free Drink", "12h 58m", R.drawable.drink));
        offersItems.add(new OffersItems("Equinox", "12d 10m", R.drawable.equinox));
        offersItems.add(new OffersItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        offersItems.add(new OffersItems("1 Free Drink", "12h 58m", R.drawable.drink));
        offersItems.add(new OffersItems("Equinox", "12d 10m", R.drawable.equinox));
        offersItems.add(new OffersItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        offersItems.add(new OffersItems("1 Free Drink", "12h 58m", R.drawable.drink));
        offersItems.add(new OffersItems("Equinox", "12d 10m", R.drawable.equinox));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewOffer.setLayoutManager(linearLayoutManager);
        final Dashboard.ItemOffsetDecoration itemOffsetDecoration = new Dashboard.ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerViewOffer.addItemDecoration(itemOffsetDecoration);
        OfferAdapter offerAdapter = new OfferAdapter(offersItems);
        recyclerViewOffer.setAdapter(offerAdapter);

    }
}
