package com.anc.humansdk.doubleexposure;

import android.hardware.HardwareBuffer;
import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class HumanEffectDoubleExposureApi {
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    static final String TAG = "HumanEffectDoubleExposureApi";
    private static AtomicBoolean isSoLoaded = new AtomicBoolean(false);
    private static HumanEffectDoubleExposureApi sInstance = new HumanEffectDoubleExposureApi();
    protected AtomicLong handle = new AtomicLong(0);
    private AtomicInteger mPendingLogLevel = new AtomicInteger(-1);

    public enum CameraType {
        CAMERA_TYPE_REAR,
        CAMERA_TYPE_FRONT
    }

    public enum ImageType {
        ANC_HUM_IMG_NV21,
        ANC_HUM_IMG_BGR,
        ANC_HUM_IMG_RGB,
        ANC_HUM_IMG_RGBA,
        ANC_HUM_IMG_DEPTH,
        ANC_HUM_IMG_GREYSCALE,
        ANC_HUM_IMG_NV12
    }

    private native int nativeAttachGl(long j);

    private native long nativeInitHandle(HumanEffectDoubleExposureConfig humanEffectDoubleExposureConfig);

    private native int nativeProcessFrame(long j, byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6);

    private native int nativeProcessFrameInTextureOut(long j, byte[] bArr, int i, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, boolean z2, int i9, int i10);

    private native int nativeProcessHardwareBufferInTextureOut(long j, HardwareBuffer hardwareBuffer, int i, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z2);

    private native int nativeProcessTexture(long j, int i, int i2, int i3, int i4, int i5, boolean z);

    private native int nativeProcessTextureAndHardwareBufferInTextureOut(long j, int i, boolean z, HardwareBuffer hardwareBuffer, int i2, int i3, boolean z2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z3);

    private native int nativeProcessTextures(long j, int i, boolean z, int i2, boolean z2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private native int nativeRelease(long j);

    private native String nativeSdkVersion();

    private native int nativeSetLogLevel(int i);

    private native int nativeSetParams(long j, HumanVideoDoubleExposureParams humanVideoDoubleExposureParams);

    public static class HumanVideoDoubleExposureParams {
        public float bgAlpha;
        public float bgBrightness;
        public float bgSaturation;
        public float blurIntensity;
        public float blurKernelSize;
        public float groundGlassColor;
        public boolean isAdjustParamsMode = false;
        public float portraitAlpha;
        public float portraitBrightness;
        public float portraitSaturation;

        public HumanVideoDoubleExposureParams(float f) {
            this.blurIntensity = f;
        }

        public HumanVideoDoubleExposureParams(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
            this.blurIntensity = f;
            this.portraitSaturation = f2;
            this.portraitBrightness = f3;
            this.bgSaturation = f4;
            this.bgBrightness = f5;
            this.bgAlpha = f6;
            this.groundGlassColor = f7;
            this.portraitAlpha = f8;
            this.blurKernelSize = f9;
        }
    }

    public static class HumanVideoTexture {
        public int height;
        public boolean isBgFromAlbum;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;

        public HumanVideoTexture(int i, boolean z, int i2, int i3, int i4, boolean z2) {
            this.texID = i;
            this.isOES = z;
            this.width = i2;
            this.height = i3;
            this.rotation = i4;
            this.isBgFromAlbum = z2;
        }

        public boolean IsValid() {
            if (this.texID > 0 && this.width != 0 && this.height != 0 && this.rotation % 90 == 0) {
                return true;
            }
            return false;
        }
    }

    public static class HumanVideoFrame {
        public byte[] data;
        public int height;
        public int rotation;
        public ImageType type;
        public int width;

        public HumanVideoFrame(byte[] bArr, ImageType imageType, int i, int i2, int i3) {
            this.data = bArr;
            this.type = imageType;
            this.width = i;
            this.height = i2;
            this.rotation = i3;
        }

        public boolean IsValid() {
            if (this.data != null && this.width > 0 && this.height > 0 && this.rotation % 90 == 0 && this.type != null) {
                return true;
            }
            return false;
        }
    }

    public static class HumanProcessTextureRequestBuilder {
        public CameraType cameraType;
        public int height;
        public boolean isBgFromAlbum;
        public boolean isOES;
        public int rotation;
        public int texID;
        public int width;

        public HumanProcessTextureRequestBuilder setCameraType(CameraType cameraType2) {
            this.cameraType = cameraType2;
            return this;
        }

        public HumanProcessTextureRequestBuilder setTexID(int i) {
            this.texID = i;
            return this;
        }

        public HumanProcessTextureRequestBuilder setOES(boolean z) {
            this.isOES = z;
            return this;
        }

        public HumanProcessTextureRequestBuilder setWidth(int i) {
            this.width = i;
            return this;
        }

        public HumanProcessTextureRequestBuilder setHeight(int i) {
            this.height = i;
            return this;
        }

        public HumanProcessTextureRequestBuilder setRotation(int i) {
            this.rotation = i;
            return this;
        }

        public HumanProcessTextureRequestBuilder setBgFromAlbum(boolean z) {
            this.isBgFromAlbum = z;
            return this;
        }

        public HumanProcessTextureRequest build() {
            int i;
            int i2;
            int i3 = this.texID;
            if (i3 > 0 && (i = this.width) > 0 && (i2 = this.height) > 0) {
                int i4 = this.rotation;
                if (i4 % 90 == 0 && this.cameraType != null) {
                    return new HumanProcessTextureRequest(this.cameraType, new HumanVideoTexture(i3, this.isOES, i, i2, i4, this.isBgFromAlbum));
                }
            }
            String str = HumanEffectDoubleExposureApi.TAG;
            Log.e(str, "invalid HumanProcessTextureRequest, texID=" + this.texID + ", width=" + this.width + ",height=" + this.height + ",rotation=" + this.rotation + ", cameraType=" + this.cameraType);
            return null;
        }
    }

    public static class HumanProcessTextureRequest {
        public CameraType cameraType;
        public HumanVideoTexture humanVideoTexture;

        public static HumanProcessTextureRequestBuilder Builder() {
            return new HumanProcessTextureRequestBuilder();
        }

        public HumanProcessTextureRequest(CameraType cameraType2, HumanVideoTexture humanVideoTexture2) {
            this.cameraType = cameraType2;
            this.humanVideoTexture = humanVideoTexture2;
        }

        public boolean IsValid() {
            HumanVideoTexture humanVideoTexture2 = this.humanVideoTexture;
            return humanVideoTexture2 != null && humanVideoTexture2.IsValid();
        }
    }

    public static class HumanProcessFrameRequestBuilder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public CameraType cameraType;
        public byte[] data;
        public int height;
        public int rotation;
        public ImageType type;
        public int width;

        static {
            Class<HumanEffectDoubleExposureApi> cls = HumanEffectDoubleExposureApi.class;
        }

        public HumanProcessFrameRequestBuilder setCameraType(CameraType cameraType2) {
            this.cameraType = cameraType2;
            return this;
        }

        public HumanProcessFrameRequestBuilder setData(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public HumanProcessFrameRequestBuilder setType(ImageType imageType) {
            this.type = imageType;
            return this;
        }

        public HumanProcessFrameRequestBuilder setWidth(int i) {
            this.width = i;
            return this;
        }

        public HumanProcessFrameRequestBuilder setHeight(int i) {
            this.height = i;
            return this;
        }

        public HumanProcessFrameRequestBuilder setRotation(int i) {
            this.rotation = i;
            return this;
        }

        public HumanProcessFrameRequest build() {
            int i;
            int i2;
            ImageType imageType;
            byte[] bArr = this.data;
            if (bArr == null || (i = this.width) <= 0 || (i2 = this.height) <= 0 || (imageType = this.type) == null || this.cameraType == null) {
                return null;
            }
            return new HumanProcessFrameRequest(this.cameraType, new HumanVideoFrame(bArr, imageType, i, i2, this.rotation));
        }
    }

    public static class HumanProcessFrameRequest {
        public CameraType cameraType;
        public HumanVideoFrame humanVideoFrame;

        public static HumanProcessFrameRequestBuilder Builder() {
            return new HumanProcessFrameRequestBuilder();
        }

        public HumanProcessFrameRequest(CameraType cameraType2, HumanVideoFrame humanVideoFrame2) {
            this.cameraType = cameraType2;
            this.humanVideoFrame = humanVideoFrame2;
        }

        public boolean IsValid() {
            HumanVideoFrame humanVideoFrame2 = this.humanVideoFrame;
            return humanVideoFrame2 != null && humanVideoFrame2.IsValid();
        }
    }

    public static class HumanProcessHardwareBufferRequestBuilder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public CameraType cameraType;
        public HardwareBuffer data;
        public int height;
        public int rotation;
        public int scanline;
        public ImageType type;
        public int width;

        static {
            Class<HumanEffectDoubleExposureApi> cls = HumanEffectDoubleExposureApi.class;
        }

        public HumanProcessHardwareBufferRequestBuilder setCameraType(CameraType cameraType2) {
            this.cameraType = cameraType2;
            return this;
        }

        public HumanProcessHardwareBufferRequestBuilder setData(HardwareBuffer hardwareBuffer) {
            this.data = hardwareBuffer;
            return this;
        }

        public HumanProcessHardwareBufferRequestBuilder setType(ImageType imageType) {
            this.type = imageType;
            return this;
        }

        public HumanProcessHardwareBufferRequestBuilder setWidth(int i) {
            this.width = i;
            return this;
        }

        public HumanProcessHardwareBufferRequestBuilder setHeight(int i) {
            this.height = i;
            return this;
        }

        public HumanProcessHardwareBufferRequestBuilder setScanline(int i) {
            this.scanline = i;
            return this;
        }

        public HumanProcessHardwareBufferRequestBuilder setRotation(int i) {
            this.rotation = i;
            return this;
        }

        public HumanProcessHardwareBufferRequest build() {
            int i;
            int i2;
            ImageType imageType;
            HardwareBuffer hardwareBuffer = this.data;
            if (hardwareBuffer == null || (i = this.width) <= 0 || (i2 = this.height) <= 0 || (imageType = this.type) == null || this.cameraType == null) {
                return null;
            }
            return new HumanProcessHardwareBufferRequest(this.cameraType, new HumanVideoHardwareBuffer(hardwareBuffer, imageType, i, i2, this.scanline, this.rotation));
        }
    }

    public static class HumanVideoHardwareBuffer {
        public HardwareBuffer data;
        public int height;
        public int rotation;
        public int scanline;
        public ImageType type;
        public int width;

        public HumanVideoHardwareBuffer(HardwareBuffer hardwareBuffer, ImageType imageType, int i, int i2, int i3, int i4) {
            this.data = hardwareBuffer;
            this.type = imageType;
            this.width = i;
            this.height = i2;
            this.scanline = i3;
            this.rotation = i4;
        }

        public boolean IsValid() {
            if (this.data != null && this.width > 0 && this.height > 0 && this.rotation % 90 == 0 && this.type != null) {
                return true;
            }
            return false;
        }
    }

    public static class HumanProcessHardwareBufferRequest {
        public CameraType cameraType;
        public HumanVideoHardwareBuffer humanVideoFrame;

        public static HumanProcessFrameRequestBuilder Builder() {
            return new HumanProcessFrameRequestBuilder();
        }

        public HumanProcessHardwareBufferRequest(CameraType cameraType2, HumanVideoHardwareBuffer humanVideoHardwareBuffer) {
            this.cameraType = cameraType2;
            this.humanVideoFrame = humanVideoHardwareBuffer;
        }

        public boolean IsValid() {
            HumanVideoHardwareBuffer humanVideoHardwareBuffer = this.humanVideoFrame;
            return humanVideoHardwareBuffer != null && humanVideoHardwareBuffer.IsValid();
        }
    }

    public static class HumanProcessTexureResult {
        public HumanVideoTexture humanVideoTexture;

        public HumanProcessTexureResult(HumanVideoTexture humanVideoTexture2) {
            this.humanVideoTexture = humanVideoTexture2;
        }

        public HumanProcessTexureResult(int i, boolean z, int i2, int i3, int i4, boolean z2) {
            this.humanVideoTexture = new HumanVideoTexture(i, z, i2, i3, i4, z2);
        }

        public boolean IsValid() {
            HumanVideoTexture humanVideoTexture2 = this.humanVideoTexture;
            return humanVideoTexture2 != null && humanVideoTexture2.IsValid();
        }
    }

    public static class HumanProcessFrameResult {
        public HumanVideoFrame humanVideoFrame;

        public HumanProcessFrameResult(HumanVideoFrame humanVideoFrame2) {
            this.humanVideoFrame = humanVideoFrame2;
        }

        public HumanProcessFrameResult(byte[] bArr, ImageType imageType, int i, int i2, int i3) {
            this.humanVideoFrame = new HumanVideoFrame(bArr, imageType, i, i2, i3);
        }

        public boolean IsValid() {
            HumanVideoFrame humanVideoFrame2 = this.humanVideoFrame;
            return humanVideoFrame2 != null && humanVideoFrame2.IsValid();
        }
    }

    public static class HumanEffectDoubleExposureConfig {
        public String cache_path;
        public boolean isBackCamera;
        public boolean isRealTime;
        public byte[] model_data;
        public String native_lib_path;

        public HumanEffectDoubleExposureConfig(boolean z, byte[] bArr, String str, String str2, boolean z2) {
            this.isRealTime = z;
            this.model_data = bArr;
            this.cache_path = str;
            this.native_lib_path = str2;
            this.isBackCamera = z2;
        }

        public HumanEffectDoubleExposureConfig(byte[] bArr, boolean z, String str, String str2) {
            this.model_data = bArr;
            this.isRealTime = z;
            this.cache_path = str;
            this.native_lib_path = str2;
            this.isBackCamera = true;
        }

        public HumanEffectDoubleExposureConfig() {
            this.model_data = null;
            this.isRealTime = true;
            this.cache_path = "";
            this.native_lib_path = "";
            this.isBackCamera = true;
        }

        public String toString() {
            Object[] objArr = new Object[4];
            byte[] bArr = this.model_data;
            objArr[0] = Integer.valueOf(bArr != null ? bArr.length : 0);
            String str = this.cache_path;
            String str2 = "null";
            objArr[1] = str != null ? new File(str).getName() : str2;
            String str3 = this.native_lib_path;
            if (str3 != null) {
                str2 = new File(str3).getName();
            }
            objArr[2] = str2;
            objArr[3] = Boolean.valueOf(this.isRealTime);
            return String.format("sdkCapability %d, model size %d, cache path %s, lib path %s, realtime %b", objArr);
        }

        public static class HumanEffectDoubleExposureConfigBuilder {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            private String cache_path;
            private boolean isBackCamera;
            private boolean isRealTime = true;
            private byte[] model_data;
            private String native_lib_path;

            static {
                Class<HumanEffectDoubleExposureApi> cls = HumanEffectDoubleExposureApi.class;
            }

            public HumanEffectDoubleExposureConfigBuilder setModel_data(byte[] bArr) {
                this.model_data = bArr;
                return this;
            }

            public HumanEffectDoubleExposureConfigBuilder setCache_path(String str) {
                this.cache_path = str;
                return this;
            }

            public HumanEffectDoubleExposureConfigBuilder setNative_lib_path(String str) {
                this.native_lib_path = str;
                return this;
            }

            public HumanEffectDoubleExposureConfigBuilder setBackCameraFlag(boolean z) {
                this.isBackCamera = z;
                return this;
            }

            public HumanEffectDoubleExposureConfigBuilder setRealTime(boolean z) {
                this.isRealTime = z;
                return this;
            }

            public HumanEffectDoubleExposureConfig build() {
                if (this.model_data == null) {
                    return null;
                }
                HumanEffectDoubleExposureConfig humanEffectDoubleExposureConfig = new HumanEffectDoubleExposureConfig();
                humanEffectDoubleExposureConfig.isRealTime = this.isRealTime;
                humanEffectDoubleExposureConfig.model_data = this.model_data;
                humanEffectDoubleExposureConfig.cache_path = this.cache_path;
                humanEffectDoubleExposureConfig.native_lib_path = this.native_lib_path;
                humanEffectDoubleExposureConfig.isBackCamera = this.isBackCamera;
                return humanEffectDoubleExposureConfig;
            }
        }

        public static HumanEffectDoubleExposureConfigBuilder Builder() {
            return new HumanEffectDoubleExposureConfigBuilder();
        }
    }

    public int initByConfig(HumanEffectDoubleExposureConfig humanEffectDoubleExposureConfig) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("init API by BuildNumber: 143 isRealTime: ");
            sb.append(humanEffectDoubleExposureConfig);
            Log.i(str, sb.toString() != null ? humanEffectDoubleExposureConfig.toString() : " null config");
        } else {
            Log.e(TAG, "init API by config BuildNumber: 143");
        }
        if (this.handle.get() != 0) {
            return 3;
        }
        if (humanEffectDoubleExposureConfig == null || humanEffectDoubleExposureConfig.model_data == null) {
            Log.e(TAG, "config invalid!");
            return 1;
        }
        if (!isSoLoaded.get()) {
            System.loadLibrary("AncHumanDoubleExposure-jni");
            isSoLoaded.set(true);
        }
        if (humanEffectDoubleExposureConfig.cache_path == null) {
            humanEffectDoubleExposureConfig.cache_path = "";
        }
        if (humanEffectDoubleExposureConfig.native_lib_path == null) {
            humanEffectDoubleExposureConfig.native_lib_path = "";
        }
        this.handle.set(nativeInitHandle(humanEffectDoubleExposureConfig));
        int andSet = this.mPendingLogLevel.getAndSet(-1);
        if (andSet >= 0) {
            nativeSetLogLevel(andSet);
        }
        String str2 = TAG;
        Log.e(str2, "log level " + andSet);
        if (this.handle.get() == 0) {
            return 3;
        }
        return 0;
    }

    public int setLogLevel(int i) {
        if (!isSoLoaded.get()) {
            this.mPendingLogLevel.set(i);
            return -1;
        }
        nativeSetLogLevel(i);
        return 0;
    }

    public int setParams(HumanVideoDoubleExposureParams humanVideoDoubleExposureParams) {
        if (this.handle.get() != 0 && humanVideoDoubleExposureParams != null) {
            return nativeSetParams(this.handle.get(), humanVideoDoubleExposureParams);
        }
        Log.e(TAG, "setParams: handle is invalid!");
        return 2;
    }

    public int process(HumanProcessTextureRequest humanProcessTextureRequest, HumanProcessTexureResult humanProcessTexureResult) {
        if (this.handle.get() == 0) {
            Log.e(TAG, "process: handle is invalid!");
            return 2;
        } else if (humanProcessTextureRequest == null || humanProcessTexureResult == null || !humanProcessTextureRequest.IsValid()) {
            return 1;
        } else {
            return nativeProcessTexture(this.handle.get(), humanProcessTextureRequest.humanVideoTexture.texID, humanProcessTexureResult.humanVideoTexture.texID, humanProcessTextureRequest.humanVideoTexture.width, humanProcessTextureRequest.humanVideoTexture.height, humanProcessTextureRequest.humanVideoTexture.rotation, humanProcessTextureRequest.humanVideoTexture.isOES);
        }
    }

    public int process(HumanProcessTextureRequest humanProcessTextureRequest, HumanProcessTextureRequest humanProcessTextureRequest2, HumanProcessTexureResult humanProcessTexureResult) {
        HumanProcessTextureRequest humanProcessTextureRequest3 = humanProcessTextureRequest;
        HumanProcessTextureRequest humanProcessTextureRequest4 = humanProcessTextureRequest2;
        HumanProcessTexureResult humanProcessTexureResult2 = humanProcessTexureResult;
        if (this.handle.get() == 0) {
            Log.e(TAG, "process: handle is invalid!");
            return 2;
        } else if (humanProcessTextureRequest3 == null || humanProcessTexureResult2 == null || !humanProcessTextureRequest.IsValid()) {
            return 1;
        } else {
            int i = humanProcessTextureRequest3.humanVideoTexture.width;
            int i2 = humanProcessTextureRequest3.humanVideoTexture.height;
            int i3 = humanProcessTextureRequest4.humanVideoTexture.width;
            int i4 = humanProcessTextureRequest4.humanVideoTexture.height;
            Log.d(TAG, String.format("process fg %d, bg %d, out %d", new Object[]{Integer.valueOf(humanProcessTextureRequest3.humanVideoTexture.texID), Integer.valueOf(humanProcessTextureRequest4.humanVideoTexture.texID), Integer.valueOf(humanProcessTexureResult2.humanVideoTexture.texID)}));
            if (humanProcessTexureResult2.humanVideoTexture.isOES) {
                Log.e(TAG, "please set output 2d texture instead of oes.");
                return 1;
            }
            return nativeProcessTextures(this.handle.get(), humanProcessTextureRequest3.humanVideoTexture.texID, humanProcessTextureRequest3.humanVideoTexture.isOES, humanProcessTextureRequest4.humanVideoTexture.texID, humanProcessTextureRequest4.humanVideoTexture.isOES, humanProcessTexureResult2.humanVideoTexture.texID, i, i2, i3, i4, humanProcessTextureRequest4.humanVideoTexture.rotation, humanProcessTextureRequest3.humanVideoTexture.rotation);
        }
    }

    public int process(HumanProcessFrameRequest humanProcessFrameRequest, HumanProcessTextureRequest humanProcessTextureRequest, HumanProcessTexureResult humanProcessTexureResult) {
        String str;
        String str2;
        HumanProcessFrameRequest humanProcessFrameRequest2 = humanProcessFrameRequest;
        HumanProcessTextureRequest humanProcessTextureRequest2 = humanProcessTextureRequest;
        HumanProcessTexureResult humanProcessTexureResult2 = humanProcessTexureResult;
        if (this.handle.get() == 0) {
            Log.e(TAG, "process: handle is invalid!");
            return 2;
        }
        if (!(humanProcessFrameRequest2 == null || humanProcessTexureResult2 == null)) {
            if ((!(humanProcessTextureRequest2 == null) && !(!humanProcessFrameRequest.IsValid())) && humanProcessTextureRequest.IsValid() && humanProcessTexureResult.IsValid()) {
                String str3 = TAG;
                Log.e(str3, "fgFrameRequest.cameratype " + humanProcessFrameRequest2.cameraType + " bgTextureRequest.cameratype " + humanProcessTextureRequest2.cameraType);
                int i = humanProcessFrameRequest2.humanVideoFrame.width;
                int i2 = humanProcessFrameRequest2.humanVideoFrame.height;
                if (humanProcessFrameRequest2.humanVideoFrame.type != ImageType.ANC_HUM_IMG_NV21) {
                    String str4 = TAG;
                    Log.e(str4, "process: argment is invalid, image type=%d" + humanProcessFrameRequest2.humanVideoFrame.type);
                    return 1;
                }
                if (i % 64 != 0) {
                    Log.e(TAG, "[Warning]process: argment maybe is invalid, width is not 64 alignment maybe causes abnormal rendering cases");
                }
                int i3 = humanProcessTextureRequest2.humanVideoTexture.width;
                int i4 = humanProcessTextureRequest2.humanVideoTexture.height;
                Log.d(TAG, String.format("process fg %d, bg %d, out %d", new Object[]{Integer.valueOf(humanProcessFrameRequest2.humanVideoFrame.data.length), Integer.valueOf(humanProcessTextureRequest2.humanVideoTexture.texID), Integer.valueOf(humanProcessTexureResult2.humanVideoTexture.texID)}));
                if (humanProcessTexureResult2.humanVideoTexture.isOES) {
                    Log.e(TAG, "process: please set output 2d texture instead of oes.");
                    return 1;
                }
                return nativeProcessFrameInTextureOut(this.handle.get(), humanProcessFrameRequest2.humanVideoFrame.data, humanProcessFrameRequest2.cameraType == CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTextureRequest2.humanVideoTexture.texID, humanProcessTextureRequest2.humanVideoTexture.isOES, humanProcessTextureRequest2.cameraType == CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTexureResult2.humanVideoTexture.texID, i, i2, i3, i4, humanProcessTextureRequest2.humanVideoTexture.isBgFromAlbum, humanProcessTextureRequest2.humanVideoTexture.rotation, humanProcessFrameRequest2.humanVideoFrame.rotation);
            }
        }
        String str5 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("process: argment is invalid, fgFrameRequest is ");
        String str6 = "valid";
        if (humanProcessFrameRequest2 == null || !humanProcessFrameRequest.IsValid()) {
            str = "invalid";
        } else {
            str = str6;
        }
        sb.append(str);
        sb.append(", bgTextureRequest is ");
        if (humanProcessTextureRequest2 == null || !humanProcessTextureRequest.IsValid()) {
            str2 = "invalid";
        } else {
            str2 = str6;
        }
        sb.append(str2);
        sb.append(", texureResult is ");
        if (humanProcessTexureResult2 == null || !humanProcessTexureResult.IsValid()) {
            str6 = "invalid";
        }
        sb.append(str6);
        Log.e(str5, sb.toString());
        return 1;
    }

    public int process(HumanProcessHardwareBufferRequest humanProcessHardwareBufferRequest, HumanProcessTextureRequest humanProcessTextureRequest, HumanProcessTexureResult humanProcessTexureResult) {
        String str;
        String str2;
        HumanProcessHardwareBufferRequest humanProcessHardwareBufferRequest2 = humanProcessHardwareBufferRequest;
        HumanProcessTextureRequest humanProcessTextureRequest2 = humanProcessTextureRequest;
        HumanProcessTexureResult humanProcessTexureResult2 = humanProcessTexureResult;
        if (this.handle.get() == 0) {
            Log.e(TAG, "process: handle is invalid!");
            return 2;
        }
        if (!(humanProcessHardwareBufferRequest2 == null || humanProcessTexureResult2 == null)) {
            if ((!(humanProcessTextureRequest2 == null) && !(!humanProcessHardwareBufferRequest.IsValid())) && humanProcessTextureRequest.IsValid() && humanProcessTexureResult.IsValid()) {
                int i = humanProcessHardwareBufferRequest2.humanVideoFrame.width;
                int i2 = humanProcessHardwareBufferRequest2.humanVideoFrame.height;
                if (humanProcessHardwareBufferRequest2.humanVideoFrame.type != ImageType.ANC_HUM_IMG_NV21) {
                    String str3 = TAG;
                    Log.e(str3, "process: argment is invalid, image type=%d" + humanProcessHardwareBufferRequest2.humanVideoFrame.type);
                    return 1;
                }
                if (i % 64 != 0) {
                    Log.e(TAG, "[Warning]process: argment maybe is invalid, width is not 64 alignment maybe causes abnormal rendering cases");
                }
                int i3 = humanProcessTextureRequest2.humanVideoTexture.width;
                int i4 = humanProcessTextureRequest2.humanVideoTexture.height;
                if (humanProcessTexureResult2.humanVideoTexture.isOES) {
                    Log.e(TAG, "process: please set output 2d texture instead of oes.");
                    return 1;
                }
                return nativeProcessTextureAndHardwareBufferInTextureOut(this.handle.get(), 0, false, humanProcessHardwareBufferRequest2.humanVideoFrame.data, humanProcessHardwareBufferRequest2.humanVideoFrame.scanline, humanProcessTextureRequest2.humanVideoTexture.texID, humanProcessTextureRequest2.humanVideoTexture.isOES, humanProcessTexureResult2.humanVideoTexture.texID, i, i2, i3, i4, humanProcessTextureRequest2.humanVideoTexture.rotation, humanProcessHardwareBufferRequest2.humanVideoFrame.rotation, humanProcessHardwareBufferRequest2.cameraType == CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTextureRequest2.cameraType == CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTextureRequest2.humanVideoTexture.isBgFromAlbum);
            }
        }
        String str4 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("process: argment is invalid, fgFrameRequest is ");
        String str5 = "valid";
        if (humanProcessHardwareBufferRequest2 == null || !humanProcessHardwareBufferRequest.IsValid()) {
            str = "invalid";
        } else {
            str = str5;
        }
        sb.append(str);
        sb.append(", bgTextureRequest is ");
        if (humanProcessTextureRequest2 == null || !humanProcessTextureRequest.IsValid()) {
            str2 = "invalid";
        } else {
            str2 = str5;
        }
        sb.append(str2);
        sb.append(", texureResult is ");
        if (humanProcessTexureResult2 == null || !humanProcessTexureResult.IsValid()) {
            str5 = "invalid";
        }
        sb.append(str5);
        Log.e(str4, sb.toString());
        return 1;
    }

    public int process(HumanProcessTextureRequest humanProcessTextureRequest, HumanProcessHardwareBufferRequest humanProcessHardwareBufferRequest, HumanProcessTextureRequest humanProcessTextureRequest2, HumanProcessTexureResult humanProcessTexureResult) {
        boolean z;
        String str;
        String str2;
        HumanProcessTextureRequest humanProcessTextureRequest3 = humanProcessTextureRequest;
        HumanProcessHardwareBufferRequest humanProcessHardwareBufferRequest2 = humanProcessHardwareBufferRequest;
        HumanProcessTextureRequest humanProcessTextureRequest4 = humanProcessTextureRequest2;
        HumanProcessTexureResult humanProcessTexureResult2 = humanProcessTexureResult;
        if (this.handle.get() == 0) {
            Log.e(TAG, "process: handle is invalid!");
            return 2;
        }
        if (humanProcessTextureRequest3 == null || (humanProcessTextureRequest3 != null && !humanProcessHardwareBufferRequest.IsValid())) {
            Log.w(TAG, "process: argment fgTextureRequest is invalid!");
            z = false;
        } else {
            z = true;
        }
        if (!(humanProcessHardwareBufferRequest2 == null || humanProcessTexureResult2 == null)) {
            if ((!(humanProcessTextureRequest4 == null) && !(!humanProcessHardwareBufferRequest.IsValid())) && humanProcessTextureRequest2.IsValid() && humanProcessTexureResult.IsValid()) {
                int i = humanProcessHardwareBufferRequest2.humanVideoFrame.width;
                int i2 = humanProcessHardwareBufferRequest2.humanVideoFrame.height;
                if (humanProcessHardwareBufferRequest2.humanVideoFrame.type != ImageType.ANC_HUM_IMG_NV21) {
                    Log.e(TAG, "process: argment is invalid, image type=%d" + humanProcessHardwareBufferRequest2.humanVideoFrame.type);
                    return 1;
                }
                if (i % 64 != 0) {
                    Log.e(TAG, "[Warning]process: argment maybe is invalid, width is not 64 alignment maybe causes abnormal rendering cases");
                }
                int i3 = humanProcessTextureRequest4.humanVideoTexture.width;
                int i4 = humanProcessTextureRequest4.humanVideoTexture.height;
                if (humanProcessTexureResult2.humanVideoTexture.isOES) {
                    Log.e(TAG, "process: please set output 2d texture instead of oes.");
                    return 1;
                }
                return nativeProcessTextureAndHardwareBufferInTextureOut(this.handle.get(), z ? humanProcessTextureRequest3.humanVideoTexture.texID : 0, z ? humanProcessTextureRequest3.humanVideoTexture.isOES : false, humanProcessHardwareBufferRequest2.humanVideoFrame.data, humanProcessHardwareBufferRequest2.humanVideoFrame.scanline, humanProcessTextureRequest4.humanVideoTexture.texID, humanProcessTextureRequest4.humanVideoTexture.isOES, humanProcessTexureResult2.humanVideoTexture.texID, i, i2, i3, i4, humanProcessTextureRequest4.humanVideoTexture.rotation, humanProcessHardwareBufferRequest2.humanVideoFrame.rotation, humanProcessHardwareBufferRequest2.cameraType == CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTextureRequest4.cameraType == CameraType.CAMERA_TYPE_REAR ? 0 : 1, humanProcessTextureRequest4.humanVideoTexture.isBgFromAlbum);
            }
        }
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("process: argment is invalid, fgFrameRequest is ");
        String str4 = "valid";
        if (humanProcessHardwareBufferRequest2 == null || !humanProcessHardwareBufferRequest.IsValid()) {
            str = "invalid";
        } else {
            str = str4;
        }
        sb.append(str);
        sb.append(", bgTextureRequest is ");
        if (humanProcessTextureRequest4 == null || !humanProcessTextureRequest2.IsValid()) {
            str2 = "invalid";
        } else {
            str2 = str4;
        }
        sb.append(str2);
        sb.append(", texureResult is ");
        if (humanProcessTexureResult2 == null || !humanProcessTexureResult.IsValid()) {
            str4 = "invalid";
        }
        sb.append(str4);
        Log.e(str3, sb.toString());
        return 1;
    }

    public int process(HumanProcessFrameRequest humanProcessFrameRequest, HumanProcessFrameResult humanProcessFrameResult) {
        if (this.handle.get() == 0) {
            Log.e(TAG, "process: handle is invalid!");
            return 2;
        }
        return nativeProcessFrame(this.handle.get(), humanProcessFrameRequest.humanVideoFrame.data, humanProcessFrameResult.humanVideoFrame.data, humanProcessFrameRequest.humanVideoFrame.width, humanProcessFrameRequest.humanVideoFrame.height, (humanProcessFrameResult.humanVideoFrame.width == 0 ? humanProcessFrameRequest.humanVideoFrame : humanProcessFrameResult.humanVideoFrame).width, (humanProcessFrameResult.humanVideoFrame.height == 0 ? humanProcessFrameRequest.humanVideoFrame : humanProcessFrameResult.humanVideoFrame).height, humanProcessFrameRequest.humanVideoFrame.type.ordinal(), humanProcessFrameRequest.humanVideoFrame.rotation);
    }

    public int release() {
        if (this.handle.get() == 0) {
            Log.e(TAG, "release: handle is invalid!");
            return 2;
        }
        int nativeRelease = nativeRelease(this.handle.get());
        this.handle.set(0);
        return nativeRelease;
    }

    public int attachGL() {
        if (this.handle.get() != 0) {
            return nativeAttachGl(this.handle.get());
        }
        Log.e(TAG, "prepareRun: handle is invalid!");
        return 2;
    }

    public static HumanEffectDoubleExposureApi getInstance() {
        return sInstance;
    }

    public String getVersion() {
        if (!isSoLoaded.get()) {
            return "";
        }
        return nativeSdkVersion();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] getFileContent(java.lang.String r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
        L_0x000e:
            int r4 = r2.read(r1)     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
            r3 = -1
            if (r4 == r3) goto L_0x001a
            r3 = 0
            r0.write(r1, r3, r4)     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
            goto L_0x000e
        L_0x001a:
            r2.close()     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
            r0.close()     // Catch:{ IOException -> 0x0027, all -> 0x0025 }
            byte[] r4 = r0.toByteArray()
            return r4
        L_0x0025:
            r4 = move-exception
            throw r4
        L_0x0027:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi.getFileContent(java.lang.String):byte[]");
    }
}
