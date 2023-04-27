package com.meicam.effect.sdk;

import com.meicam.sdk.NvsVideoFrameInfo;
import com.meicam.sdk.NvsVideoResolution;

public class NvsEffectRenderCore {
    public static final int NV_EFFECT_CORE_ERROR_UNKNOWN = -1;
    public static final int NV_EFFECT_CORE_INVALID_TEXTURE = -2;
    public static final int NV_EFFECT_CORE_NO_ERROR = 0;
    long m_internalObject = 0;

    private native void nativeCleanUp(long j);

    private native void nativeClearCacheResources(long j);

    private native void nativeClearEffectResources(long j, NvsEffect nvsEffect);

    private native void nativeDestory(long j);

    private native boolean nativeInitialize(long j);

    private native int nativeRenderEffect(long j, NvsEffect nvsEffect, int i, byte[] bArr, NvsVideoFrameInfo nvsVideoFrameInfo, int i2, NvsVideoResolution nvsVideoResolution, int i3, long j2, int i4);

    public boolean initialize() {
        return nativeInitialize(this.m_internalObject);
    }

    public int renderEffect(NvsEffect nvsEffect, int i, NvsVideoResolution nvsVideoResolution, int i2, long j, int i3) {
        if (nvsEffect == null || nvsVideoResolution == null) {
            return -1;
        } else if (i <= 0 || i2 <= 0) {
            return -2;
        } else {
            return nativeRenderEffect(this.m_internalObject, nvsEffect, i, (byte[]) null, (NvsVideoFrameInfo) null, 0, nvsVideoResolution, i2, j, i3);
        }
    }

    public int renderEffect(NvsEffect nvsEffect, int i, byte[] bArr, NvsVideoFrameInfo nvsVideoFrameInfo, int i2, NvsVideoResolution nvsVideoResolution, int i3, long j, int i4) {
        if (nvsEffect == null || nvsVideoResolution == null) {
            return -1;
        } else if (i <= 0 || i3 <= 0) {
            return -2;
        } else {
            return nativeRenderEffect(this.m_internalObject, nvsEffect, i, bArr, nvsVideoFrameInfo, i2, nvsVideoResolution, i3, j, i4);
        }
    }

    public void clearEffectResources(NvsEffect nvsEffect) {
        nativeClearEffectResources(this.m_internalObject, nvsEffect);
    }

    public void clearCacheResources() {
        nativeClearCacheResources(this.m_internalObject);
    }

    public void cleanUp() {
        nativeCleanUp(this.m_internalObject);
    }

    /* access modifiers changed from: protected */
    public void setInternalObject(long j) {
        this.m_internalObject = j;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        long j = this.m_internalObject;
        if (j != 0) {
            nativeDestory(j);
            this.m_internalObject = 0;
        }
        super.finalize();
    }
}
