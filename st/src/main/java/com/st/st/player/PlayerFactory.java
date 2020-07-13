package com.st.st.player;

import android.content.Context;

import androidx.annotation.NonNull;

import com.st.st.base.inter.IMediaFactory;
import com.st.st.base.inter.IMediaPlayer;

public class PlayerFactory implements IMediaFactory {
    @Override
    public IMediaPlayer getMediaPlayer(@PlayerMode int playerMode, @NonNull Context context) {
        return new STExoPlayer(context);
    }
}
