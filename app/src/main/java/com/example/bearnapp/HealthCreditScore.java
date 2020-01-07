package com.example.bearnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bearnapp.adapter.HealthCreditScoreAdapter;
import com.ldoublem.ringPregressLibrary.OnSelectRing;
import com.ldoublem.ringPregressLibrary.Ring;
import com.ldoublem.ringPregressLibrary.RingProgress;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HealthCreditScore extends AppCompatActivity {

    ArrayList<HealthCreditScoreItems> healthCreditScoreItems;

    ImageView imgBackIcon;
    ImageView imgFilterMenu;
    ImageView imgMenuDashBoard;
    TextView txtCreate;

    int i;
    private ValueAnimator valueAnimator;
    private float mAnimatedValue = 1f;

    List<Ring> mlistRing = new ArrayList<>();
    Random random = new Random();
    private RingProgress mRingProgress;
    private RingProgress mRingProgressR;
    ImageView imageViewDashboard1;

    private Handler handler = new Handler();
    private TextView textView52;
    private int initial = 721;
    private int total = 834;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_credit_score);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.item_animation_fall_down);
        imageViewDashboard1 = findViewById(R.id.imageViewDashboard1);
        imageViewDashboard1.startAnimation(animation1);

        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);

        imgBackIcon.setVisibility(View.VISIBLE);
        imgBackIcon.setColorFilter(getResources().getColor(R.color.Black));
        imgFilterMenu.setVisibility(View.VISIBLE);
        txtCreate.setText("Health Credit Score");
        imgMenuDashBoard.setVisibility(View.GONE);
        imgBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textView52 = findViewById(R.id.textView52);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (initial < total) {
                    try {
                        Thread.sleep(55);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView52.setText("" + initial);
                        }
                    });
                    initial++;
                }
            }
        }).start();

        RecyclerView recyclerViewHSC = findViewById(R.id.rv_HSC);
        healthCreditScoreItems = new ArrayList<>();

        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.Green), "Sleep Score", "129"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.yello), "Blood Pressure Score", "120"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.orange), "Blood Lab Work Score", "189"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.Dark_Blue), "DNA Score", "12"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.red), "Cardio Score", "29"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.Green), "Body Mass Score", "39"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.yello), "Age Score", "59"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.orange), "Blood Pressure Score", "19"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.Dark_Blue), "DNA Score", "12"));
        healthCreditScoreItems.add(new HealthCreditScoreItems(this.getColor(R.color.red), "Sleep Score", "129"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewHSC.setLayoutManager(linearLayoutManager);
        HealthCreditScoreAdapter horizontalScrollAdapter = new HealthCreditScoreAdapter(healthCreditScoreItems);
        recyclerViewHSC.setAdapter(horizontalScrollAdapter);

        mRingProgress = findViewById(R.id.lv_ringp);
        mRingProgressR = findViewById(R.id.lv_ringpR);
        setData();
        automatic();
        mRingProgress.setOnSelectRing(new OnSelectRing() {
            @Override
            public void Selected(Ring r) {
                Toast.makeText(HealthCreditScore.this, r.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        mRingProgress.setRingWidthScale(0.6f);
        mRingProgress.setRotateAngle(90);
        mRingProgress.setDrawBg(false);
        mRingProgress.setSweepAngle(180);
        mRingProgress.startAnim(6000);

        mRingProgressR.setOnSelectRing(new OnSelectRing() {
            @Override
            public void Selected(Ring r) {
                Toast.makeText(HealthCreditScore.this, r.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        mRingProgressR.setRingWidthScale(0.6f);
        mRingProgressR.setRotateAngle(140);
        mRingProgressR.setDrawBg(false);
        mRingProgressR.setSweepAngle(180);
        mRingProgressR.setRotation(310f);
        mRingProgressR.setSweepAngle(180);
        mRingProgressR.startAnimOne(6000);
    }

    private String[] data = new String[]{"DNA", "BWL", "BP", "SS"};

    private void setData() {
        mlistRing.clear();
        for (int i = 0; i < data.length; i++) {

            Ring r = new Ring();
            int p = random.nextInt(100);
            r.setProgress(p);
            r.setValue(String.valueOf(p * 100));

            r.setName(data[i]);

            if (i == 0) {
                r.setStartColor(Color.rgb(235, 79, 56));
                r.setEndColor(Color.argb(100, 235, 79, 56));
            }
            if (i == 1) {
                r.setStartColor(Color.rgb(17, 205, 110));
                r.setEndColor(Color.argb(100, 17, 205, 110));
            }
            if (i == 2) {
                r.setStartColor(Color.rgb(234, 128, 16));
                r.setEndColor(Color.argb(100, 234, 128, 16));
            }
            if (i == 3) {
                r.setStartColor(Color.rgb(86, 171, 228));
                r.setEndColor(Color.argb(100, 86, 171, 228));
            }
            if (i == 4) {
                r.setStartColor(Color.rgb(157, 85, 184));
                r.setEndColor(Color.argb(100, 157, 85, 184));
            }
            mlistRing.add(r);
        }
        mRingProgress.setData(mlistRing, 5000);
        mRingProgressR.setData(mlistRing, 5000);
    }

    private void automatic() {
        setData();
    }
}
