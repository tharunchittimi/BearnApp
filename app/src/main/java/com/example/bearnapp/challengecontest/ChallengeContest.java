package com.example.bearnapp.challengecontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bearnapp.R;
import com.example.bearnapp.challengecontest.adapter.ChallengeContestAdapterRv;
import com.example.bearnapp.challengecontest.model.ChallengeContestItemsRv;
import com.example.bearnapp.challengecontest.spinneradapter.ChallengeSpinnerAdapter;
import com.example.bearnapp.challengecontest.spinneradapter.ChallengeSpinnerAdapterTwo;
import com.example.bearnapp.setupchallenge.SetupChallenge;
import com.example.bearnapp.dashboard.Dashboard;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;


public class ChallengeContest extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private ArrayList<ChallengeContestItemsRv> challengeContestItemsRv;

    Spinner spinner1;
    Spinner spinner2;

    private String[] users = {"All Users", "America Users", "Australia Users", "India Users", "Ethereum Users", "British Users"};
    private int images[] = {R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut,};

    private String[] levels = {"Levels", "Level1", "Level2", "Level3", "Level4", "Level5"};
    private int image[] = {R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut,};

    ImageView imgBackIcon;
    ImageView imgFilterMenu;
    ImageView imgMenuDashBoard;
    TextView txtCreate;

    MaterialButton btnInviteFriends;

    ImageView imageViewChallengeContest;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_contest);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        btnInviteFriends = findViewById(R.id.btnInviteFriends);

        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.item_animation_fall_down);
        imageViewChallengeContest = findViewById(R.id.imageViewChallengeContest);
        imageViewChallengeContest.startAnimation(animation1);

        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);

        imgBackIcon.setVisibility(View.GONE);
        imgBackIcon.setColorFilter(getResources().getColor(R.color.Black));
        imgFilterMenu.setVisibility(View.VISIBLE);
        txtCreate.setText("Challenge Contest");
        imgMenuDashBoard.setVisibility(View.GONE);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        ChallengeSpinnerAdapter challengeSpinnerAdapter = new ChallengeSpinnerAdapter(this, images, users);
        spinner1.setAdapter(challengeSpinnerAdapter);

        ChallengeSpinnerAdapterTwo challengeSpinnerAdapter1 = new ChallengeSpinnerAdapterTwo(this, image, levels);
        spinner2.setAdapter(challengeSpinnerAdapter1);

        RecyclerView rv_Challenge = findViewById(R.id.rv_Challenge);

        challengeContestItemsRv = new ArrayList<>();

        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.Green), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.Dark_Blue), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.yello), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.red), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.actBar), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.Black), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.Green), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.yello), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.red), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.actBar), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.Green), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));
        challengeContestItemsRv.add(new ChallengeContestItemsRv(this.getColor(R.color.orange), R.drawable.bg_person, "PRO", "Jonathan \nMcGomery", "129.25"));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rv_Challenge.setLayoutManager(gridLayoutManager);
        final Dashboard.ItemOffsetDecoration itemOffsetDecoration = new Dashboard.ItemOffsetDecoration(this, R.dimen.item_offset);
        rv_Challenge.addItemDecoration(itemOffsetDecoration);
        ChallengeContestAdapterRv challengeContestAdapterRv = new ChallengeContestAdapterRv(challengeContestItemsRv);
        rv_Challenge.setAdapter(challengeContestAdapterRv);

        btnInviteFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChallengeContest.this, SetupChallenge.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
