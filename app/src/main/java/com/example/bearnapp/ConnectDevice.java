package com.example.bearnapp;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.bearnapp.adapter.AppsAdapter;
import com.example.bearnapp.adapter.ConnectDeviceAdapter;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConnectDevice extends AppCompatActivity implements AppsAdapter.OnClickLisitner {
    ArrayList<DataItems> dataItems;
    TabLayout tabLayout;
    RecyclerView recyclerView;

    private List<Item> data;
    private Shop shop;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter infiniteAdapter;

    TextView textView12;
    MaterialButton btnApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        setContentView(R.layout.activity_connect_device);

        tabLayout = findViewById(R.id.tabLayout);
        textView12 = findViewById(R.id.textView12);
        btnApp = findViewById(R.id.btnApp);

        recyclerView = findViewById(R.id.recyclerViewApp);
        dataItems = new ArrayList<>();
        dataItems.add(new DataItems(R.drawable.fitness, "My Fitness Pall"));
        dataItems.add(new DataItems(R.drawable.bg_route, "Map My Route"));
        dataItems.add(new DataItems(R.drawable.bg_lotus_yoga, "Lotus Yoga"));
        dataItems.add(new DataItems(R.drawable.bg_workout, "Workouts"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        final ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerView.addItemDecoration(itemOffsetDecoration);
        AppsAdapter objCustomAdapter1 = new AppsAdapter(dataItems, this);
        recyclerView.setAdapter(objCustomAdapter1);

        shop = Shop.get();
        data = shop.getData();
        itemPicker = (DiscreteScrollView) findViewById(R.id.item_picker);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new ConnectDeviceAdapter(data));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setVisibility(View.GONE);

        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.actBar));
        tabLayout.setTabTextColors(Color.parseColor("#BDBDBD"), Color.parseColor("#00BCD4"));

        int[] imgResId = {
                R.drawable.app,
                R.drawable.ic_devices
        };

        for (int i = 0; i < imgResId.length; i++) {
            tabLayout.getTabAt(i).setIcon(imgResId[i]);
        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#00BCD4"), PorterDuff.Mode.SRC_IN);
                textView12.setText("SWIPE TO CHOOSE ANOTHER DEVICE");
                btnApp.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.Green));
                switch (tab.getPosition()) {
                    case 0:
                        recyclerView.setVisibility(View.VISIBLE);
                        itemPicker.setVisibility(View.GONE);
                        break;
                    case 1:
                        recyclerView.setVisibility(View.GONE);
                        itemPicker.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.SRC_IN);
                btnApp.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.light_grey));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConnectDevice.this, Dashboard.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void selectedCount(int count) {
        if (count > 0)
            btnApp.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.Green));
        else
            btnApp.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.light_grey));
    }

    public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
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
