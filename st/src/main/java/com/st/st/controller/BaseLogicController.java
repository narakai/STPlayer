package com.st.st.controller;

import android.view.View;

import com.st.st.base.inter.ILogicControl;
import com.st.st.base.inter.ILogicMediaControl;

public abstract class BaseLogicController implements ILogicControl {
    protected ILogicMediaControl mLogicMediaControl;

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onComplete() {

    }


    @Override
    public void onProgressChange(long progress) {

    }


    @Override
    public void onInitControllerView(View mRoot) {

    }

    @Override
    public void setLogicMediaControl(MediaController mediaController) {
        mLogicMediaControl = mediaController;
    }
}
