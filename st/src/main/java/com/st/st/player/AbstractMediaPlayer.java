package com.st.st.player;

import com.st.st.base.inter.IMediaPlayer;

public abstract class AbstractMediaPlayer implements IMediaPlayer {
    protected OnPreparedListener mOnPreparedListener;
    protected OnCompletionListener mOnCompletionListener;
    protected OnBufferingUpdateListener mOnBufferingUpdateListener;
    protected OnSeekCompleteListener mOnSeekCompleteListener;
    protected OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    protected OnErrorListener mOnErrorListener;
    protected OnInfoListener mOnInfoListener;

    public void setOnPreparedListener(OnPreparedListener listener) {
        mOnPreparedListener = listener;
    }

    public void setOnCompletionListener(OnCompletionListener listener) {
        mOnCompletionListener = listener;
    }

    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {
        mOnBufferingUpdateListener = listener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {
        mOnSeekCompleteListener = listener;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        mOnVideoSizeChangedListener = listener;
    }

    public void setOnErrorListener(OnErrorListener listener) {
        mOnErrorListener = listener;
    }

    public void setOnInfoListener(OnInfoListener listener) {
        mOnInfoListener = listener;
    }

    public void notifyOnPreparedListener() {
        if (mOnPreparedListener != null) {
            mOnPreparedListener.onPrepared(this);
        }
    }
}
