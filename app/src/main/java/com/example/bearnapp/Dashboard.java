package com.example.bearnapp;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.bearnapp.adapter.DashboardAdapter;
import com.google.android.material.navigation.NavigationView;

import net.bohush.geometricprogressview.GeometricProgressView;
import net.bohush.geometricprogressview.TYPE;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    ArrayList<DashboardItems> dashboardItems;
    ImageView imgBackIcon;
    ImageView imgFilterMenu;

    ImageView imgMenuDashBoard;
    TextView txtCreate;

    TextView txt11;
    ImageView imageViewDashboard;

    private DrawerLayout mDrawerLayout;
    private Handler handler = new Handler();
    TextView txt15;

    GeometricProgressView progressView14;

    private float initial = 0.0f;
    private float total = 45.45f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        RecyclerView rv_dashboard = findViewById(R.id.rv_dashboard);
        TextView textView = findViewById(R.id.txt12);

        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);
        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        txt11 = findViewById(R.id.txt11);

        txt15 = findViewById(R.id.txt15);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (initial < total) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            txt15.setText("" + initial);
                        }
                    });
                    initial++;
                }
            }
        }).start();

        progressView14 = findViewById(R.id.progressView14);
        progressView14.setDuration(3000);
        progressView14.animate();
        progressView14.setType(TYPE.KITE);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.item_animation_fall_down);
        imageViewDashboard = findViewById(R.id.imageViewDashboard);
        imageViewDashboard.startAnimation(animation1);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        imgMenuDashBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        });

        imgBackIcon.setVisibility(View.VISIBLE);
        imgBackIcon.setImageDrawable(getResources().getDrawable(R.drawable.ic_person));
        imgBackIcon.setColorFilter(getResources().getColor(R.color.Black));
        imgFilterMenu.setVisibility(View.GONE);
        txtCreate.setText("Dashboard");
        imgMenuDashBoard.setVisibility(View.VISIBLE);

        dashboardItems = new ArrayList<>();

        dashboardItems.add(new DashboardItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        dashboardItems.add(new DashboardItems("1 Free Drink", "12h 58m", R.drawable.drink));
        dashboardItems.add(new DashboardItems("Equinox", "12d 10m", R.drawable.equinox));
        dashboardItems.add(new DashboardItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        dashboardItems.add(new DashboardItems("1 Free Drink", "12h 58m", R.drawable.drink));
        dashboardItems.add(new DashboardItems("Equinox", "12d 10m", R.drawable.equinox));
        dashboardItems.add(new DashboardItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        dashboardItems.add(new DashboardItems("1 Free Drink", "12h 58m", R.drawable.drink));
        dashboardItems.add(new DashboardItems("Equinox", "12d 10m", R.drawable.equinox));
        dashboardItems.add(new DashboardItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        dashboardItems.add(new DashboardItems("1 Free Drink", "12h 58m", R.drawable.drink));
        dashboardItems.add(new DashboardItems("Equinox", "12d 10m", R.drawable.equinox));
        dashboardItems.add(new DashboardItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        dashboardItems.add(new DashboardItems("1 Free Drink", "12h 58m", R.drawable.drink));
        dashboardItems.add(new DashboardItems("Equinox", "12d 10m", R.drawable.equinox));
        dashboardItems.add(new DashboardItems("1 Meal Free", "12h 10m", R.drawable.beachhfood));
        dashboardItems.add(new DashboardItems("1 Free Drink", "12h 58m", R.drawable.drink));
        dashboardItems.add(new DashboardItems("Equinox", "12d 10m", R.drawable.equinox));
        textView.setText(String.valueOf(dashboardItems.size()));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_dashboard.setLayoutManager(linearLayoutManager);
        final ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        rv_dashboard.addItemDecoration(itemOffsetDecoration);
        DashboardAdapter dashboardAdapter = new DashboardAdapter(dashboardItems);
        rv_dashboard.setAdapter(dashboardAdapter);

        NavigationView navigationView = findViewById(R.id.nav_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {

                    case R.id.invite:
                        Intent myintent = new Intent(Dashboard.this, Invite.class);
                        startActivity(myintent);
                        break;
                    case R.id.offers:
                        Intent myintentone = new Intent(Dashboard.this, Offer.class);
                        startActivity(myintentone);
                        break;
                    case R.id.healthCreditScore:
                        Intent myintenttwo = new Intent(Dashboard.this, HealthCreditScore.class);
                        startActivity(myintenttwo);
                        break;
                    case R.id.challenge:
                        Intent myintentthree = new Intent(Dashboard.this, ChallengeContest.class);
                        startActivity(myintentthree);
                        break;
                    case R.id.purchases:
                        Intent myintentfour = new Intent(Dashboard.this, ListOfPurchases.class);
                        startActivity(myintentfour);
                        break;
                }
                mDrawerLayout.closeDrawer(Gravity.RIGHT);
                return false;
            }
        });

        txt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Offer.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    public static class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
        private int mItemOffset;

        public ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,
                                   @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }
}
