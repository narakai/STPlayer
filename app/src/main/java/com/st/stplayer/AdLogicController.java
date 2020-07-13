package com.st.stplayer;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.st.st.controller.BaseLogicController;
import com.st.st.controller.MediaController;

public class AdLogicController extends BaseLogicController {
    private Button mStartButton;
    private Button mStopButton;

    @Override
    public void onProgressChange(long progress) {
        super.onProgressChange(progress);
        Toast.makeText(MyApplication.getInstance(), "" + progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(MyApplication.getInstance(), "video view callback start", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(MyApplication.getInstance(), "video view callback pause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInitControllerView(View mRoot) {
        super.onInitControllerView(mRoot);
        mStartButton = mRoot.findViewById(R.id.mStart_businiss);
        mStopButton = mRoot.findViewById(R.id.mStop_businiss);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLogicMediaControl != null) {
                    mLogicMediaControl.start();
                }
            }
        });
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLogicMediaControl != null) {
                    mLogicMediaControl.pause();
                }
            }
        });
    }
}
