package com.example.bearnapp.setupchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bearnapp.R;
import com.example.bearnapp.setupchallenge.adapter.SetupChallengeAdapter;
import com.example.bearnapp.setupchallenge.adapter.SetupChallengeAdapterTwo;
import com.example.bearnapp.setupchallenge.customspinner.SetupSpinner;
import com.example.bearnapp.setupchallenge.customspinner.SetupSpinner2;
import com.example.bearnapp.setupchallenge.model.SetupChallenegItems;
import com.example.bearnapp.setupchallenge.model.SetupChallengeDataItems;

import java.util.ArrayList;

public class SetupChallenge extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<SetupChallenegItems> setupChallenegItems;

    ArrayList<SetupChallengeDataItems> setupChallengeDataItems;

    Spinner spinner1;
    Spinner spinner2;

    ImageView imgBackIcon;
    ImageView imgFilterMenu;
    ImageView imgMenuDashBoard;
    TextView txtCreate;

    TextView textView31;
    TextView textView32;
    RecyclerView rv_setUpChallenge;
    SetupChallengeAdapterTwo setupChallengeAdapterTwo;
    SetupChallengeAdapter setupChallengeAdapter;

    private String[] users = {"5 days", "5 days", "5 days", "5 days", "5 days", "5 days"};

    private String[] levels = {"Money Earned During Compensation", "Money Earned During Compensation", "Money Earned During Compensation", "Money Earned During Compensation", "Money Earned During Compensation", "Money Earned During Compensation"};
    private int image[] = {R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut, R.drawable.ic_donut,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_challenge);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        textView31 = findViewById(R.id.textView31);
        textView32 = findViewById(R.id.textView32);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

        imgBackIcon = findViewById(R.id.imgBackIcon);
        imgFilterMenu = findViewById(R.id.imgFilterMenu);
        txtCreate = findViewById(R.id.txtCreate);
        imgMenuDashBoard = findViewById(R.id.imgMenuDashBoard);

        imgBackIcon.setVisibility(View.GONE);
        imgBackIcon.setColorFilter(getResources().getColor(R.color.Black));
        imgFilterMenu.setVisibility(View.VISIBLE);
        txtCreate.setText("Setup Challenge");
        imgMenuDashBoard.setVisibility(View.GONE);

        SetupSpinner setupSpinner = new SetupSpinner(this, users);
        spinner1.setAdapter(setupSpinner);

        SetupSpinner2 setupSpinner2 = new SetupSpinner2(this, image, levels);
        spinner2.setAdapter(setupSpinner2);

        textView32.setTextColor(getResources().getColor(R.color.darkBlue));

        rv_setUpChallenge = findViewById(R.id.rv_setUpChallenge);


        setupChallenegItems = new ArrayList<>();
        setupChallenegItems.add(new SetupChallenegItems("1.", R.drawable.bg_person, "Jennie McGee"));
        setupChallenegItems.add(new SetupChallenegItems("2.", R.drawable.bg_person, "Jennie McGee"));
        setupChallenegItems.add(new SetupChallenegItems("3.", R.drawable.bg_person, "Jennie McGee"));
        setupChallenegItems.add(new SetupChallenegItems("4.", R.drawable.bg_person, "Jennie McGee"));
        setupChallenegItems.add(new SetupChallenegItems("5.", R.drawable.bg_person, "Jennie McGee"));
        setupChallenegItems.add(new SetupChallenegItems("6.", R.drawable.bg_person, "Jennie McGee"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv_setUpChallenge.setLayoutManager(linearLayoutManager);
        setupChallengeAdapter = new SetupChallengeAdapter(setupChallenegItems);
        rv_setUpChallenge.setAdapter(setupChallengeAdapter);

        setupChallengeDataItems = new ArrayList<>();

        setupChallengeDataItems.add(new SetupChallengeDataItems("1.", R.drawable.bg_peson, "Jubli"));
        setupChallengeDataItems.add(new SetupChallengeDataItems("2.", R.drawable.bg_peson, "Jubli"));
        setupChallengeDataItems.add(new SetupChallengeDataItems("3.", R.drawable.bg_peson, "Jubli"));
        setupChallengeDataItems.add(new SetupChallengeDataItems("4.", R.drawable.bg_peson, "Jubli"));

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        rv_setUpChallenge.setLayoutManager(linearLayoutManager1);
        setupChallengeAdapterTwo = new SetupChallengeAdapterTwo(setupChallengeDataItems);


        textView31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rv_setUpChallenge.setAdapter(setupChallengeAdapterTwo);
                textView32.setTextColor(getResources().getColor(R.color.light_greyy));
                textView31.setTextColor(getResources().getColor(R.color.darkBlue));
            }
        });

        textView32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rv_setUpChallenge.setAdapter(setupChallengeAdapter);
                textView32.setTextColor(getResources().getColor(R.color.darkBlue));
                textView31.setTextColor(getResources().getColor(R.color.light_greyy));

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
