package com.st.stplayer;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication mApplication;
    public static MyApplication getInstance() {
        return mApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

}
