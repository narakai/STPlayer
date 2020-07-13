package com.st.st.base.inter;

import android.view.View;

import com.st.st.controller.MediaController;

public interface ILogicControl {
    void onProgressChange(long progress);
    void onPause();
    void onStart();
    void onStop();
    void onComplete();

    void setLogicMediaControl(MediaController mediaController);

    void onInitControllerView(View mRoot);
}
