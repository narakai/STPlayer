package com.st.st.base.inter;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface IMediaPlayer {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({STATE_IDLE, STATE_BUFFERING, STATE_READY, STATE_ENDED, STATE_ERROR})
    @interface State {}
    int STATE_IDLE = 1;
    int STATE_BUFFERING = 2;
    int STATE_READY = 3;
    int STATE_ENDED = 4;
    int STATE_ERROR = 5;


    void setDataSource(Context context, String path);

    void setDataSource(Context context, Uri uri);

    void prepareAsync();

    void setScreenOnWhilePlaying(boolean flag);

    void initPlayer(Context context);

    void setSurface(Surface surface);

    void setMute();

    void setVolume(float left, float right);

    void start();

    void pause();

    void stop();

    void reset();

    void release();

    void setSpeed(float speed);

    int getVideoWidth();

    int getVideoHeight();

    boolean isPlaying();

    void seekTo(long time);

    long getCurrentPosition();

    long getDuration();

    void setOnPreparedListener(IMediaPlayer.OnPreparedListener var1);

    void setOnCompletionListener(IMediaPlayer.OnCompletionListener var1);

    void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener var1);

    void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener var1);

    void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener var1);

    void setOnErrorListener(IMediaPlayer.OnErrorListener var1);

    void setOnInfoListener(IMediaPlayer.OnInfoListener var1);

    void setAudioStreamType(int var1);

    @State int getPlayerState();

    public interface OnInfoListener {
        boolean onInfo(IMediaPlayer var1, int var2, int var3);
    }

    public interface OnErrorListener {
        boolean onError(IMediaPlayer var1, int var2, int var3);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(IMediaPlayer var1, int var2, int var3, int var4, int var5);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(IMediaPlayer var1);
    }

    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(IMediaPlayer var1, int var2);
    }

    public interface OnCompletionListener {
        void onCompletion(IMediaPlayer var1);
    }

    public interface OnPreparedListener {
        void onPrepared(IMediaPlayer var1);
    }


}
