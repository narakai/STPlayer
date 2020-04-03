package com.st.st.base.inter;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IMediaFactory {
    int PLAYER_MODE_EXO = 1;

    @IntDef({PLAYER_MODE_EXO})
    @Retention(RetentionPolicy.SOURCE)
    @interface PlayerMode {

    }

    IMediaPlayer getMediaPlayer(@PlayerMode int playerMode);
}
