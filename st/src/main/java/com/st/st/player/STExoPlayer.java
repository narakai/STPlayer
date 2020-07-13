package com.st.st.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;

import androidx.annotation.NonNull;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.st.st.base.inter.IMediaPlayer;

public class STExoPlayer extends AbstractMediaPlayer {
    private SimpleExoPlayer mExoPlayer;
    private String mUrl;
    private MediaSource mMediaSource;
    private boolean isPreparing = true;
    private Player.EventListener mEventListener = new Player.EventListener() {
        @Override
        public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
            if (isPreparing) {
                switch (playbackState) {
                    case Player.STATE_READY:
                        notifyOnPreparedListener();
                        isPreparing = false;
                        break;
                }
            }
        }
    };

    public STExoPlayer(@NonNull Context context) {
        initPlayer(context);
    }

    @Override
    public void setDataSource(Context context, String path) {
        Uri uri = Uri.parse(path);
        setDataSource(context, uri);
    }

    @Override
    public void setDataSource(Context context, Uri uri) {
        mUrl = uri.toString();
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context, "xxx");
        ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(defaultDataSourceFactory);
        ProgressiveMediaSource mediaSource = factory.createMediaSource(uri);
        mMediaSource = mediaSource;
    }

    @Override
    public void prepareAsync() {
        if (mExoPlayer == null) {
            return;
        }
        mExoPlayer.prepare(mMediaSource);
        mExoPlayer.addListener(mEventListener);
        mExoPlayer.setPlayWhenReady(false);
    }

    @Override
    public void setScreenOnWhilePlaying(boolean flag) {

    }

    @Override
    public void initPlayer(Context context) {
        mExoPlayer = ExoPlayerFactory.newSimpleInstance(context);
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
    public void setSurface(Surface surface) {
        if (mExoPlayer != null) {
            mExoPlayer.setVideoSurface(surface);
        }
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

    @Override
    public int getPlayerState() {
        int state = mExoPlayer.getPlaybackState();
        switch (state) {
            case Player.STATE_BUFFERING:
                return IMediaPlayer.STATE_BUFFERING;
            case Player.STATE_READY:
                return IMediaPlayer.STATE_READY;
            case Player.STATE_IDLE:
                return IMediaPlayer.STATE_IDLE;
            case Player.STATE_ENDED:
                return IMediaPlayer.STATE_ENDED;
            default:
                return IMediaPlayer.STATE_ERROR;
        }
    }
}
