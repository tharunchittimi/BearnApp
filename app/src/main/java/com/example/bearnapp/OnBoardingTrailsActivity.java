package com.example.bearnapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.bearnapp.adapter.AnswersAdapter;


import java.util.ArrayList;

public class OnBoardingTrailsActivity extends AppCompatActivity implements AnswersAdapter.OnAnswerClicked {
    private ArrayList<SliderClas> contentList;
    private int currentPosition = 0;
    VideoView videoView;
    TextView txtQuestion;
    RecyclerView recyclerViewAnswers;

    ImageView ken, dot1, dot2, dot3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding_trails);
//        videoView = findViewById(R.id.videoView);
        txtQuestion = findViewById(R.id.txtQuestion);
        dot1 = findViewById(R.id.dot1);
        dot2 = findViewById(R.id.dot2);
        dot3 = findViewById(R.id.dot3);

        recyclerViewAnswers = findViewById(R.id.recyclerViewAnswers);
        recyclerViewAnswers.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAnswers.setAdapter(new AnswersAdapter(new String[]{}, this));
        contentList = new ArrayList<>();
        contentList.add(new SliderClas(R.raw.exe, "Do You Have Health Insurance ?", new String[]{"YES", "NO"}));
        contentList.add(new SliderClas(R.raw.clipthree, "How physically healthy \nare you ?", new String[]{"NOT AT ALL HEALTHY", "HEALTHY", "EXTREMELY HEALTHY"}));
        contentList.add(new SliderClas(R.raw.clipthree, "How important is exercise to \nyou ?", new String[]{"NOT AT ALL IMPORTANT", "QUITE IMPORTANT", "EXTREMELY IMPORTANT"}));
        setValues(currentPosition);

    }

    @Override
    public void onSelected(String answer) {
        currentPosition++;
        if (currentPosition < 4) {
            setValues(currentPosition);
        }
    }

    private void setValues(int currentPosition) {
        if (currentPosition == 0) {
            dot1.setBackground(getResources().getDrawable(R.drawable.changedots));
            dot2.setBackground(getResources().getDrawable(R.drawable.dots));
            dot3.setBackground(getResources().getDrawable(R.drawable.dots));
        } else if (currentPosition == 1) {
            dot2.setBackground(getResources().getDrawable(R.drawable.changedots));
            dot3.setBackground(getResources().getDrawable(R.drawable.dots));
            dot1.setBackground(getResources().getDrawable(R.drawable.changedots));
        } else if (currentPosition == 2) {
            dot3.setBackground(getResources().getDrawable(R.drawable.changedots));
            dot2.setBackground(getResources().getDrawable(R.drawable.changedots));
            dot1.setBackground(getResources().getDrawable(R.drawable.changedots));
        } else {
            Intent intent = new Intent(this, ConnectDevice.class);
            startActivity(intent);
            finish();
            return;
        }

        SliderClas sliderClas = contentList.get(currentPosition);

//        String path = "android.resource://" + getPackageName() + "/" + sliderClas.videoView;
//        videoView.setVideoURI(Uri.parse(path));
//////        if (videoView != null) {
//            videoView.start();
////        }
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (videoView != null) {
//                    videoView.start();
//                    play.setVisibility(View.GONE);
//                    pause.setVisibility(View.VISIBLE);
//                } else {
//                    play.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        pause.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (videoView.isPlaying()) {
//                    videoView.pause();
//                    pause.setVisibility(View.GONE);
//                    play.setVisibility(View.VISIBLE);
//                } else {
//                    pause.setVisibility(View.GONE);
//                    play.setVisibility(View.VISIBLE);
//                }
//            }
//        });
        txtQuestion.setText(sliderClas.questions);
        recyclerViewAnswers.setAdapter(new AnswersAdapter(sliderClas.answers, this));
    }
}
