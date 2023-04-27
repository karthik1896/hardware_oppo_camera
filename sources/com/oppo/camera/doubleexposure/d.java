package com.oppo.camera.doubleexposure;

import android.content.Context;
import android.media.Image;
import android.os.Environment;
import com.anc.humansdk.doubleexposure.HumanEffectDoubleExposureApi;
import com.oppo.camera.e;
import com.oppo.camera.util.Util;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: DoubleExposureManager */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private Context f2813a = null;

    /* renamed from: b  reason: collision with root package name */
    private HumanEffectDoubleExposureApi f2814b = null;

    public d(Context context) {
        this.f2813a = context;
        this.f2814b = HumanEffectDoubleExposureApi.getInstance();
    }

    private void d() {
        try {
            e.a("DoubleExposureManager", "load AncHumanDoubleExposure-jni");
            if (Util.p()) {
                System.loadLibrary("AncHumanDoubleExposure-jni.qti");
            } else {
                System.loadLibrary("AncHumanDoubleExposure-jni.trustonic");
            }
            Field declaredField = HumanEffectDoubleExposureApi.class.getDeclaredField("isSoLoaded");
            declaredField.setAccessible(true);
            declaredField.set(HumanEffectDoubleExposureApi.class, new AtomicBoolean(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int a() {
        try {
            d();
            long currentTimeMillis = System.currentTimeMillis();
            this.f2814b.setLogLevel(4);
            int initByConfig = this.f2814b.initByConfig(new HumanEffectDoubleExposureApi.HumanEffectDoubleExposureConfig(true, Util.k("/odm/etc/camera/doubleexposure/model.data"), Environment.getDataDirectory().getAbsolutePath(), "/odm/lib64;/odm/lib/rfsa/adsp", false));
            e.a("DoubleExposureManager", "init, initByConfig result: " + initByConfig + ", cost time: " + (System.currentTimeMillis() - currentTimeMillis));
            return initByConfig;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void b() {
        HumanEffectDoubleExposureApi humanEffectDoubleExposureApi = this.f2814b;
        if (humanEffectDoubleExposureApi != null) {
            int attachGL = humanEffectDoubleExposureApi.attachGL();
            e.a("DoubleExposureManager", "attachGL, result: " + attachGL);
        }
    }

    public void a(int i) {
        float f = 0.0f;
        if (i != 4 && i == 5) {
            f = 1.0f;
        }
        this.f2814b.setParams(new HumanEffectDoubleExposureApi.HumanVideoDoubleExposureParams(f));
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        int release = this.f2814b.release();
        e.a("DoubleExposureManager", "release, releaseResult: " + release + ", time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public int a(int i, int i2, int i3, boolean z, int i4, boolean z2, Image image, int i5, int i6, boolean z3) {
        int i7;
        boolean z4 = z3;
        HumanEffectDoubleExposureApi.HumanProcessTextureRequest humanProcessTextureRequest = new HumanEffectDoubleExposureApi.HumanProcessTextureRequest(a(z4), new HumanEffectDoubleExposureApi.HumanVideoTexture(i, z, i2, i3, i4, z2));
        if (image.getHeight() % 64 == 0) {
            i7 = image.getHeight();
        } else {
            i7 = ((image.getHeight() / 64) + 1) * 64;
        }
        return this.f2814b.process(new HumanEffectDoubleExposureApi.HumanProcessHardwareBufferRequest(a(z4), new HumanEffectDoubleExposureApi.HumanVideoHardwareBuffer(image.getHardwareBuffer(), HumanEffectDoubleExposureApi.ImageType.ANC_HUM_IMG_NV21, image.getWidth(), image.getHeight(), i7, i6)), humanProcessTextureRequest, new HumanEffectDoubleExposureApi.HumanProcessTexureResult(new HumanEffectDoubleExposureApi.HumanVideoTexture(i5, false, image.getWidth(), image.getHeight(), i6, false)));
    }

    private HumanEffectDoubleExposureApi.CameraType a(boolean z) {
        return z ? HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_FRONT : HumanEffectDoubleExposureApi.CameraType.CAMERA_TYPE_REAR;
    }
}
