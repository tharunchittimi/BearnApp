package com.example.bearnapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Invite extends AppCompatActivity {

    TextView textView10;

    TextView btntxt1;
    TextView btntxt2;

    Button btnInvite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

        textView10 = findViewById(R.id.textView10);
        btntxt1 = findViewById(R.id.btntxt1);
        btntxt2 = findViewById(R.id.btntxt2);
        btnInvite = findViewById(R.id.btnInvite);

        textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Invite.this, Summary.class);
                startActivity(intent);
            }
        });
        ImageView imageView1 = findViewById(R.id.imageViewInvite1);
        Glide.with(this)
                .load(R.drawable.bg_person)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.bg_person)
                .into(imageView1);

        ImageView imageView2 = findViewById(R.id.imageViewInvite2);
        Glide.with(this)
                .load(R.drawable.bg_peson)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.bg_peson)
                .into(imageView2);

        btntxt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btntxt1.setBackground(getResources().getDrawable(R.drawable.button_shpe_one));
                btntxt1.setTextColor(getResources().getColor(R.color.White));
                btntxt2.setBackground(getResources().getDrawable(R.drawable.button_shape));
                btntxt2.setTextColor(getResources().getColor(R.color.darkBlue));
            }
        });
        btntxt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntxt1.setBackground(getResources().getDrawable(R.drawable.button_shape));
                btntxt1.setTextColor(getResources().getColor(R.color.darkBlue));
                btntxt2.setBackground(getResources().getDrawable(R.drawable.button_shpe_one));
                btntxt2.setTextColor(getResources().getColor(R.color.White));
            }
        });

        btnInvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Invite.this, InviteFreinds.class);
                startActivity(intent1);
            }
        });
    }
}
