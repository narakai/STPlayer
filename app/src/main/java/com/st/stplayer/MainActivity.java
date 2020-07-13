package com.st.stplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.st.st.STVideoView;
import com.st.st.controller.MediaController;

public class MainActivity extends AppCompatActivity {
    private static final String PATH = "https://video19.ifeng.com/video06/2012/04/11/629da9ec-60d4-4814-a940-997e6487804a.mp4";
    private Button mStartButton;
    private Button mChangeButton;
    private STVideoView mSTVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mSTVideoView = findViewById(R.id.mSTVideoView);
        mStartButton = findViewById(R.id.mStart);
        mChangeButton = findViewById(R.id.mChange);
        mChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaController mediaController = new BusinissMediaController(MainActivity.this);
                mediaController.setAnchorView(mSTVideoView);
                mSTVideoView.setMediaController(mediaController);
            }
        });
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlay();
            }
        });
    }


    private void startPlay() {
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mSTVideoView);
        mSTVideoView.setVideoPath(PATH);
        mSTVideoView.setMediaController(mediaController);
        mSTVideoView.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSTVideoView.onActivityResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSTVideoView.onActivityPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSTVideoView.release();
    }
}
