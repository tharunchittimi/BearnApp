package com.example.bearnapp.summary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bearnapp.R;

public class Summary extends AppCompatActivity {
    ImageView imgBackIcon;
    ImageView imgFilterMenu;
    ImageView imgMenuDashBoard;
    TextView txtCreate;

    TextView btntxt1;
    TextView btntxt2;
    TextView btntxt3;

    ImageView imageViewSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);

        btntxt1 = findViewById(R.id.btntxt1);
        btntxt2 = findViewById(R.id.btntxt2);
        btntxt3 = findViewById(R.id.btntxt3);

        imgBackIcon.setVisibility(View.VISIBLE);
        imgBackIcon.setColorFilter(getResources().getColor(R.color.Black));
        imgFilterMenu.setVisibility(View.GONE);
        txtCreate.setText("Summary");
        imgMenuDashBoard.setVisibility(View.GONE);


        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.item_animation_fall_down);
        imageViewSummary = findViewById(R.id.imageViewSummary);
        imageViewSummary.startAnimation(animation1);

        btntxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btntxt1.setBackground(getResources().getDrawable(R.drawable.button_shpe_one));
                btntxt1.setTextColor(getResources().getColor(R.color.White));
                btntxt2.setBackground(getResources().getDrawable(R.drawable.button_shape));
                btntxt2.setTextColor(getResources().getColor(R.color.darkBlue));
                btntxt3.setBackground(getResources().getDrawable(R.drawable.button_shape));
                btntxt3.setTextColor(getResources().getColor(R.color.darkBlue));
            }
        });
        btntxt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntxt1.setBackground(getResources().getDrawable(R.drawable.button_shape));
                btntxt1.setTextColor(getResources().getColor(R.color.darkBlue));
                btntxt2.setBackground(getResources().getDrawable(R.drawable.button_shpe_one));
                btntxt2.setTextColor(getResources().getColor(R.color.White));
                btntxt3.setBackground(getResources().getDrawable(R.drawable.button_shape));
                btntxt3.setTextColor(getResources().getColor(R.color.darkBlue));
            }
        });
        btntxt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntxt1.setBackground(getResources().getDrawable(R.drawable.button_shape));
                btntxt1.setTextColor(getResources().getColor(R.color.darkBlue));
                btntxt2.setBackground(getResources().getDrawable(R.drawable.button_shape));
                btntxt2.setTextColor(getResources().getColor(R.color.darkBlue));
                btntxt3.setBackground(getResources().getDrawable(R.drawable.button_shpe_one));
                btntxt3.setTextColor(getResources().getColor(R.color.White));
            }
        });
        imgBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
