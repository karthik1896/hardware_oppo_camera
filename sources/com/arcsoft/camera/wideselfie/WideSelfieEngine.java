package com.arcsoft.camera.wideselfie;

import android.util.Log;
import java.nio.ByteBuffer;

public class WideSelfieEngine {
    private static final String TAG = "com.arcsoft.camera.wideselfie.WideSelfieEngine";
    private static WideSelfieEngine mInstance;
    private WideSelfieCallback mCallback = null;
    private AwsInitParameter mInitParamter = null;
    private boolean mIsInit = false;

    private native int native_capture();

    private native int native_init(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f5, int i13, int i14, boolean z, boolean z2, boolean z3);

    private native int native_process(int i, byte[] bArr);

    private native int native_processByteBuffer(int i, ByteBuffer[] byteBufferArr, int i2);

    private native int native_pushSensorDataIn(int i, float[] fArr, long j);

    private native void native_register_callback(WideSelfieCallback wideSelfieCallback);

    private native int native_stopProcessing();

    private native int native_uninit();

    private native AwsVersionInfo native_version();

    static {
        System.loadLibrary("arcsoft_wideselfie");
    }

    private void loadJNILib(String str) {
        if (str == null || str.equalsIgnoreCase("")) {
            System.loadLibrary(ArcWideSelfieDef.DEFAUT_JNI_LIB_NAME);
        } else {
            System.loadLibrary(str);
        }
    }

    private WideSelfieEngine(String str) {
        loadJNILib(str);
    }

    public static synchronized WideSelfieEngine singleInstance() {
        WideSelfieEngine singleInstance;
        synchronized (WideSelfieEngine.class) {
            singleInstance = singleInstance((String) null);
        }
        return singleInstance;
    }

    public static synchronized WideSelfieEngine singleInstance(String str) {
        WideSelfieEngine wideSelfieEngine;
        synchronized (WideSelfieEngine.class) {
            if (mInstance == null) {
                mInstance = new WideSelfieEngine(str);
            }
            wideSelfieEngine = mInstance;
        }
        return wideSelfieEngine;
    }

    public synchronized int init(AwsInitParameter awsInitParameter) {
        AwsInitParameter awsInitParameter2 = awsInitParameter;
        synchronized (this) {
            try {
                if (this.mIsInit) {
                    return 0;
                }
                if (awsInitParameter2 == null) {
                    return 2;
                }
                this.mInitParamter = awsInitParameter2;
                AwsVersionInfo native_version = native_version();
                Log.d("Arcsoft", " ARC_AWS_GetVersion lCodebase = " + native_version.codeBase + ", lMajor = " + native_version.major + ", lMinor = " + native_version.minor + ", lBuild = " + native_version.build + ", CopyRight = " + native_version.copyRight + ", Version = " + native_version.version + ", BuildDate = " + native_version.buildDate);
                try {
                    int native_init = native_init(this.mInitParamter.getBufferSize(), this.mInitParamter.mode, this.mInitParamter.cameraViewAngleForWidth, this.mInitParamter.cameraViewAngleForHeight, this.mInitParamter.resultAngleForWidth, this.mInitParamter.resultAngleForHeight, this.mInitParamter.getSrcFormat(), this.mInitParamter.getFullImageWidth(), this.mInitParamter.getFullImageHeight(), this.mInitParamter.getThumbForamt(), this.mInitParamter.getThumbnailWidth(), this.mInitParamter.getThumbnailHeight(), this.mInitParamter.maxResultWidth, this.mInitParamter.progressBarThumbHeight, this.mInitParamter.guideStopBarThumbHeight, this.mInitParamter.guideStableBarThumbHeight, this.mInitParamter.progressBarThumbHeightCropRatio, this.mInitParamter.changeDirectionThumbThreshold, this.mInitParamter.getDeviceOrientation(), this.mInitParamter.convertNV21, this.mInitParamter.flipResultImage, this.mInitParamter.rotateResultImage);
                    if (native_init != 0) {
                        return native_init;
                    }
                    try {
                        this.mIsInit = true;
                        return native_init;
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
                throw th;
            }
        }
    }

    private AwsVersionInfo version() {
        return native_version();
    }

    public synchronized int process(int i, byte[] bArr) {
        if (bArr == null) {
            return 2;
        }
        return native_process(i, bArr);
    }

    public synchronized int processByteBuffer(int i, ByteBuffer[] byteBufferArr, int i2) {
        if (!this.mIsInit) {
            return 0;
        }
        return native_processByteBuffer(i, byteBufferArr, i2);
    }

    public synchronized int stopProcessing() {
        if (!this.mIsInit) {
            return 0;
        }
        return native_stopProcessing();
    }

    public synchronized int pushSensorDataIn(int i, float[] fArr, long j) {
        return native_pushSensorDataIn(i, fArr, j);
    }

    private int capture() {
        return native_capture();
    }

    public synchronized int uninit() {
        if (!this.mIsInit) {
            return 0;
        }
        int native_uninit = native_uninit();
        if (native_uninit != 0) {
            return native_uninit;
        }
        this.mIsInit = false;
        return native_uninit;
    }

    public synchronized void setOnCallback(WideSelfieCallback wideSelfieCallback) {
        this.mCallback = wideSelfieCallback;
        if (this.mCallback != null) {
            native_register_callback(this.mCallback);
        }
    }

    private WideSelfieCallback getCallback() {
        return this.mCallback;
    }

    private static final class AwsVersionInfo {
        int build;
        String buildDate;
        int codeBase;
        String copyRight;
        int major;
        int minor;
        String version;

        private AwsVersionInfo() {
        }
    }
}
