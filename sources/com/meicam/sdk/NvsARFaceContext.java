package com.meicam.sdk;

import android.os.Handler;
import android.os.Looper;

public class NvsARFaceContext {
    public static final int OBJECT_TRACKING_TYPE_ANIMAL = 1;
    public static final int OBJECT_TRACKING_TYPE_FACE = 0;
    NvsARFaceContextCallback m_callback = null;
    NvsARFaceContextInternalCallback m_callbackinternal = null;
    private long m_contextInterface;
    NvsARFaceContextErrorCallback m_errorCallback = null;
    Handler mainHandler = new Handler(Looper.getMainLooper());

    public interface NvsARFaceContextCallback {
        void notifyFaceItemLoadingBegin(String str);

        void notifyFaceItemLoadingFinish();
    }

    public interface NvsARFaceContextErrorCallback {
        void notifyFaceItemLoadingFailed(String str, int i);
    }

    private interface NvsARFaceContextInternalCallback {
        void notifyFaceItemLoadingBegin(String str);

        void notifyFaceItemLoadingFailed(String str, int i);

        void notifyFaceItemLoadingFinish();
    }

    private native void nativeCleanup(long j);

    private native boolean nativeIsObjectTracking(long j, int i);

    private native void nativeSetARFaceCallback(long j, NvsARFaceContextInternalCallback nvsARFaceContextInternalCallback);

    private native void nativeSetDualBufferInputUsed(long j, boolean z);

    public boolean isFaceTracking() {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsObjectTracking(this.m_contextInterface, 0);
    }

    public boolean isObjectTracking(int i) {
        NvsUtils.checkFunctionInMainThread();
        return nativeIsObjectTracking(this.m_contextInterface, i);
    }

    public void setContextCallback(NvsARFaceContextCallback nvsARFaceContextCallback) {
        this.m_callback = nvsARFaceContextCallback;
        if (this.m_callback == null) {
            this.m_callbackinternal = null;
        } else if (this.m_callbackinternal == null) {
            this.m_callbackinternal = new NvsARFaceContextInternalCallback() {
                public void notifyFaceItemLoadingBegin(final String str) {
                    NvsARFaceContext.this.mainHandler.post(new Runnable() {
                        public void run() {
                            if (NvsARFaceContext.this.m_callback != null) {
                                NvsARFaceContext.this.m_callback.notifyFaceItemLoadingBegin(str);
                            }
                        }
                    });
                }

                public void notifyFaceItemLoadingFinish() {
                    NvsARFaceContext.this.mainHandler.post(new Runnable() {
                        public void run() {
                            if (NvsARFaceContext.this.m_callback != null) {
                                NvsARFaceContext.this.m_callback.notifyFaceItemLoadingFinish();
                            }
                        }
                    });
                }

                public void notifyFaceItemLoadingFailed(final String str, final int i) {
                    NvsARFaceContext.this.mainHandler.post(new Runnable() {
                        public void run() {
                            if (NvsARFaceContext.this.m_errorCallback != null) {
                                NvsARFaceContext.this.m_errorCallback.notifyFaceItemLoadingFailed(str, i);
                            }
                        }
                    });
                }
            };
        } else {
            return;
        }
        nativeSetARFaceCallback(this.m_contextInterface, this.m_callbackinternal);
    }

    public void setContextErrorCallback(NvsARFaceContextErrorCallback nvsARFaceContextErrorCallback) {
        this.m_errorCallback = nvsARFaceContextErrorCallback;
        if (this.m_errorCallback != null) {
            if (this.m_callbackinternal == null) {
                this.m_callbackinternal = new NvsARFaceContextInternalCallback() {
                    public void notifyFaceItemLoadingBegin(final String str) {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() {
                            public void run() {
                                if (NvsARFaceContext.this.m_callback != null) {
                                    NvsARFaceContext.this.m_callback.notifyFaceItemLoadingBegin(str);
                                }
                            }
                        });
                    }

                    public void notifyFaceItemLoadingFinish() {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() {
                            public void run() {
                                if (NvsARFaceContext.this.m_callback != null) {
                                    NvsARFaceContext.this.m_callback.notifyFaceItemLoadingFinish();
                                }
                            }
                        });
                    }

                    public void notifyFaceItemLoadingFailed(final String str, final int i) {
                        NvsARFaceContext.this.mainHandler.post(new Runnable() {
                            public void run() {
                                if (NvsARFaceContext.this.m_errorCallback != null) {
                                    NvsARFaceContext.this.m_errorCallback.notifyFaceItemLoadingFailed(str, i);
                                }
                            }
                        });
                    }
                };
            } else {
                return;
            }
        }
        nativeSetARFaceCallback(this.m_contextInterface, this.m_callbackinternal);
    }

    public void setDualBufferInputUsed(boolean z) {
        nativeSetDualBufferInputUsed(this.m_contextInterface, z);
    }

    public void release() {
        this.m_callbackinternal = null;
        long j = this.m_contextInterface;
        if (j != 0) {
            nativeCleanup(j);
            this.m_contextInterface = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void setContextInterface(long j) {
        this.m_contextInterface = j;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        release();
        super.finalize();
    }
}
