package com.arcsoft.camera.burstpmk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.nio.ByteBuffer;

public class BurstPMKEngine {
    private static final String TAG = "com.arcsoft.camera.burstpmk.BurstPMKEngine";
    private long mEngine = 0;
    private EventHandler mEventHandler = null;
    private int mHeight = 0;
    private BurstPMKInitParameter mInitParamter = null;
    private boolean mIsActive = false;
    private int mWidth = 0;
    /* access modifiers changed from: private */
    public Object objLocked = new Object();

    public interface PMKListener {
        int onPMKNotify(int i, Object obj);
    }

    private native long _InitPMK(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, boolean z);

    private native int _ProcessPMK(long j, byte[] bArr);

    private native int _ProcessPMK_ByteBuffer(long j, ByteBuffer[] byteBufferArr, int i);

    private native int _PushSensorDataIn(long j, int i, float[] fArr, long j2);

    private native byte[] _ResizeData(int i, int i2, byte[] bArr, int i3, int i4, int i5);

    private native int _StopProcessPMK(long j);

    private native int _UninitPMK(long j);

    static {
        System.loadLibrary("arcsoft_panorama_burstcapture");
    }

    private void loadJNILib(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            System.loadLibrary(ArcBurstPMKDef.DEFAUT_JNI_LIB_NAME);
        } else {
            System.loadLibrary(str);
        }
    }

    private class EventHandler extends Handler {
        PMKListener mListener = null;

        public EventHandler(PMKListener pMKListener, Looper looper) {
            super(looper);
            this.mListener = pMKListener;
        }

        public void handleMessage(Message message) {
            synchronized (BurstPMKEngine.this.objLocked) {
                if (this.mListener != null) {
                    this.mListener.onPMKNotify(message.what, message.obj);
                }
            }
        }
    }

    public BurstPMKEngine(PMKListener pMKListener, String str) {
        loadJNILib(str);
        if (pMKListener != null) {
            Looper myLooper = Looper.myLooper();
            if (myLooper != null) {
                this.mEventHandler = new EventHandler(pMKListener, myLooper);
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(pMKListener, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
    }

    public BurstPMKEngine(PMKListener pMKListener, Looper looper, String str) {
        loadJNILib(str);
        if (pMKListener != null && looper != null) {
            this.mEventHandler = new EventHandler(pMKListener, looper);
        }
    }

    public boolean IsInited() {
        return this.mEngine != 0 && this.mIsActive;
    }

    public int Init(BurstPMKInitParameter burstPMKInitParameter) {
        Object obj;
        BurstPMKInitParameter burstPMKInitParameter2 = burstPMKInitParameter;
        Uninit();
        if (burstPMKInitParameter2 == null) {
            return 2;
        }
        Object obj2 = this.objLocked;
        synchronized (obj2) {
            try {
                this.mInitParamter = burstPMKInitParameter2;
                obj = obj2;
                try {
                    try {
                        this.mEngine = _InitPMK(this, this.mInitParamter.deviceDirection, this.mInitParamter.deviceOrientation, this.mInitParamter.sensorOrientation, this.mInitParamter.getImageFormat(), this.mInitParamter.getFullImageWidth(), this.mInitParamter.getFullImageHeight(), this.mInitParamter.getSmallImageWidth(), this.mInitParamter.getSmallImageHeight(), this.mInitParamter.getBufferSize(), this.mInitParamter.maxfullResultLength, this.mInitParamter.thumbnailResultWidthH, this.mInitParamter.thumbnailResultHeightH, this.mInitParamter.thumbnailResultWidthV, this.mInitParamter.thumbnailResultHeightV, this.mInitParamter.resultImageRotated);
                        this.mIsActive = this.mEngine != 0;
                        return this.mIsActive ? 0 : -1;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
                throw th;
            }
        }
    }

    public void Uninit() {
        synchronized (this.objLocked) {
            if (this.mEngine != 0) {
                this.mIsActive = false;
                this.mEventHandler = null;
                _UninitPMK(this.mEngine);
                this.mEngine = 0;
            }
        }
    }

    public int Process(byte[] bArr) {
        int i;
        synchronized (this.objLocked) {
            if (!IsInited() || bArr == null) {
                String str = TAG;
                StringBuilder sb = new StringBuilder("Process Error  data ");
                sb.append(bArr != null);
                Log.d(str, sb.toString());
                i = -1;
            } else {
                int length = bArr.length;
                i = _ProcessPMK(this.mEngine, bArr);
            }
        }
        return i;
    }

    public int Process(ByteBuffer[] byteBufferArr, int i) {
        int i2;
        synchronized (this.objLocked) {
            if (!IsInited() || byteBufferArr == null) {
                String str = TAG;
                StringBuilder sb = new StringBuilder("Process Error  data ");
                sb.append(byteBufferArr != null);
                Log.d(str, sb.toString());
                i2 = -1;
            } else {
                int length = byteBufferArr.length;
                i2 = _ProcessPMK_ByteBuffer(this.mEngine, byteBufferArr, i);
            }
        }
        return i2;
    }

    public int StopProcessing() {
        int i;
        synchronized (this.objLocked) {
            if (IsInited()) {
                this.mIsActive = false;
                i = _StopProcessPMK(this.mEngine);
            } else {
                i = -1;
            }
        }
        return i;
    }

    public int PushSensorDataIn(int i, float[] fArr, long j) {
        int i2;
        synchronized (this.objLocked) {
            if (IsInited()) {
                i2 = _PushSensorDataIn(this.mEngine, i, fArr, j);
            } else {
                i2 = -1;
            }
        }
        return i2;
    }

    private int onNotify(int i, Object obj) {
        if (this.mEventHandler == null || this.mEngine == 0) {
            return 0;
        }
        if (i != 2) {
            Message message = new Message();
            message.what = i;
            message.obj = obj;
            this.mEventHandler.sendMessage(message);
            return 0;
        }
        Message message2 = new Message();
        message2.what = i;
        message2.obj = obj;
        this.mEventHandler.sendMessage(message2);
        return 0;
    }

    public static byte[] ResizeData(int i, int i2, byte[] bArr, int i3, int i4, int i5) {
        return new BurstPMKEngine((PMKListener) null, (String) null)._ResizeData(i, i2, bArr, i3, i4, i5);
    }
}
