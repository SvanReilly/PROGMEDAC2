package com.example.practica7multimediabbdd;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.media.MediaMetadata;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView nowPlayingViewMain;
    private TextView trackNameViewMain;
    private TextView loopNotifViewMain;
    private ImageButton playButtonMain;
    private ImageButton pauseButtonMain;
    private ImageButton loopButtonMain, stopButtonMain;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.feelslikesummer);
        nowPlayingViewMain = findViewById(R.id.nowPlayingView);
        trackNameViewMain = findViewById(R.id.trackNameView);
        loopNotifViewMain = findViewById(R.id.loopNotification);

        playButtonMain = findViewById(R.id.playButton);
        pauseButtonMain = findViewById(R.id.pauseButton);
        stopButtonMain = findViewById(R.id.stopButton);
        loopButtonMain = findViewById(R.id.loopButton);

        playButtonMain.setOnClickListener(this);
        pauseButtonMain.setOnClickListener(this);
        stopButtonMain.setOnClickListener(this);
        loopButtonMain.setOnClickListener(this);

    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.playButton){
            trackNameViewMain.setText("Childish Gambino - Feels Like Summer");
            nowPlayingViewMain.setVisibility(View.VISIBLE);
            trackNameViewMain.setVisibility(View.VISIBLE);
            mediaPlayer.start();
        } else if (v.getId() == R.id.pauseButton){
            nowPlayingViewMain.setVisibility(View.GONE);
            trackNameViewMain.setVisibility(View.GONE);
            mediaPlayer.pause();

        } else if (v.getId() == R.id.stopButton){
            nowPlayingViewMain.setVisibility(View.GONE);
            trackNameViewMain.setVisibility(View.GONE);
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.feelslikesummer);


        } else if (v.getId() == R.id.loopButton){
            if (mediaPlayer.isLooping()) {
                mediaPlayer.setLooping(false);
                loopNotifViewMain.setVisibility(View.GONE);

            } else{
                mediaPlayer.setLooping(true);
                loopNotifViewMain.setVisibility(View.VISIBLE);
                }
            }
        }
    }
