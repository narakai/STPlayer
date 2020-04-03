package com.st.st.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.st.st.AbstractMediaPlayer;

public class STExoPlayer extends AbstractMediaPlayer {
    private ExoPlayer mExoPlayer;

    @Override
    public void setDataSource(Context context, String path) {
//        val dataSourceFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, "you application name"))
//        return ProgressiveMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(uri)
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, "xxx");
        ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(defaultDataSourceFactory);
        ProgressiveMediaSource mediaSource = factory.createMediaSource(Uri.parse(path));
    }

    @Override
    public void setDataSource(Context context, Uri uri) {

    }

    @Override
    public void prepareAsync() {

    }

    @Override
    public void setScreenOnWhilePlaying(boolean flag) {

    }

    @Override
    public void initPlayer(Context context) {
        mExoPlayer = new SimpleExoPlayer.Builder(context).build();
    }

    @Override
    public void setMute() {
        if (mExoPlayer == null) {
            return;
        }
        mExoPlayer.getAudioComponent().setVolume(0.0f);
    }

    @Override
    public void setVolume(float left, float right) {

    }

    @Override
    public void start() {
        if (mExoPlayer == null) {
            return;
        }
        mExoPlayer.setPlayWhenReady(true);
    }

    @Override
    public void pause() {
        if (mExoPlayer == null) {
            return;
        }
        mExoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void stop() {
        if (mExoPlayer == null) {
            return;
        }
    }

    @Override
    public void reset() {

    }

    @Override
    public void release() {
        if (mExoPlayer == null) {
            return;
        }

        mExoPlayer.release();
        mExoPlayer = null;
    }

    @Override
    public void setSpeed(float speed) {

    }

    @Override
    public int getVideoWidth() {
        return 0;
    }

    @Override
    public int getVideoHeight() {
        if (mExoPlayer == null) {
            return 0;
        }
        return 0;
    }

    @Override
    public boolean isPlaying() {
        if (mExoPlayer == null) {
            return false;
        }
        int state = mExoPlayer.getPlaybackState();
        switch (state) {
            case Player.STATE_BUFFERING:
            case Player.STATE_READY:
                return mExoPlayer.getPlayWhenReady();
            case Player.STATE_IDLE:
            case Player.STATE_ENDED:
            default:
                return false;
        }
    }

    @Override
    public void seekTo(long time) {
        if (mExoPlayer == null) {
            return;
        }
        mExoPlayer.seekTo(time);
    }

    @Override
    public long getCurrentPosition() {
        if (mExoPlayer == null) {
            return 0;
        }
        return mExoPlayer.getCurrentPosition();
    }

    @Override
    public void setSurface(Surface var1) {

    }

    @Override
    public long getDuration() {
        if (mExoPlayer == null) {
            return 0;
        }
        return mExoPlayer.getDuration();
    }

    @Override
    public void setAudioStreamType(int var1) {

    }
}
