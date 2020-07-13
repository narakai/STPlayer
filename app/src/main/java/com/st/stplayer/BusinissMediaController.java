package com.st.stplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.st.st.controller.MediaController;

public class BusinissMediaController extends MediaController {
    public BusinissMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public BusinissMediaController(Context context, boolean useFastForward) {
        super(context, useFastForward);
        init(context);
    }

    public BusinissMediaController(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        addLogicControl(new AdLogicController());
    }



    @Override
    public int getLayoutId() {
        return R.layout.businiss_media_controller;
    }


}
