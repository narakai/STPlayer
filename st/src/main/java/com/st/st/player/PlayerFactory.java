package com.st.st.player;

import android.content.Context;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.st.st.base.inter.IMediaFactory;
import com.st.st.base.inter.IMediaPlayer;

public class PlayerFactory implements IMediaFactory {
    @Override
    public IMediaPlayer getMediaPlayer(@PlayerMode int playerMode) {
        return null;
    }
}
