package com.heytap.compat.hardware.camera2.impl;

import android.hardware.camera2.CaptureResult;
import com.color.inner.hardware.camera2.impl.CameraMetadataNativeWrapper;
import com.heytap.compat.d.a.a;
import com.heytap.compat.d.a.b;
import java.util.concurrent.ConcurrentHashMap;

public class CameraMetadataNativeNative {
    private CameraMetadataNativeNative() {
    }

    public static int copyBuf(Object obj, long j) throws a {
        if (b.b()) {
            return CameraMetadataNativeWrapper.copyBuf(obj, j);
        }
        throw new a("Not supported before Q");
    }

    public static int getBufSize(Object obj) throws a {
        if (b.b()) {
            return CameraMetadataNativeWrapper.getBufSize(obj);
        }
        throw new a("Not supported before Q");
    }

    public static long getMetadataPtr(Object obj) throws a {
        if (b.b()) {
            return CameraMetadataNativeWrapper.getMetadataPtr(obj);
        }
        throw new a("Not supported before Q");
    }

    public static ConcurrentHashMap<CaptureResult.Key<?>, Integer> getVendorTagId(CaptureResult captureResult) throws a {
        if (b.b()) {
            return CameraMetadataNativeWrapper.getVendorTagId(captureResult);
        }
        throw new a("Not supported before Q");
    }
}
