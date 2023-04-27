package com.meicam.sdk;

import android.graphics.Bitmap;

public class NvsVideoFrameRetriever {
    public static final int VIDEO_FRAME_HEIGHT_GRADE_360 = 0;
    public static final int VIDEO_FRAME_HEIGHT_GRADE_480 = 1;
    public static final int VIDEO_FRAME_HEIGHT_GRADE_720 = 2;
    long m_internalKeyFrameList = 0;
    long m_internalReader = 0;
    long m_internalReaderFactory = 0;

    public static class KeyFrameRange {
        public long nextKeyFrame;
        public long preKeyFrame;
    }

    private native void nativeCleanup(long j, long j2, long j3);

    private native void nativeCreateVideoRetrieverReader(String str, int i);

    private native Bitmap nativeGetFrameAtTime(long j, long j2, int i, int i2);

    private native KeyFrameRange nativeGetKeyFramePositionAtTime(long j, long j2);

    public Bitmap getFrameAtTime(long j, int i) {
        long j2 = this.m_internalReader;
        if (j2 == 0) {
            return null;
        }
        return nativeGetFrameAtTime(j2, j, i, 0);
    }

    public void release() {
        long j = this.m_internalReader;
        if (j != 0) {
            nativeCleanup(j, this.m_internalReaderFactory, this.m_internalKeyFrameList);
            this.m_internalReader = 0;
            this.m_internalReaderFactory = 0;
            this.m_internalKeyFrameList = 0;
        }
    }

    public Bitmap getFrameAtTimeWithCustomVideoFrameHeight(long j, int i) {
        long j2 = this.m_internalReader;
        if (j2 == 0 || i <= 0) {
            return null;
        }
        return nativeGetFrameAtTime(j2, j, 0, i);
    }

    public KeyFrameRange getKeyFramePositionAtTime(long j) {
        return nativeGetKeyFramePositionAtTime(this.m_internalKeyFrameList, j);
    }

    NvsVideoFrameRetriever(String str, int i) {
        nativeCreateVideoRetrieverReader(str, i);
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        release();
        super.finalize();
    }
}
