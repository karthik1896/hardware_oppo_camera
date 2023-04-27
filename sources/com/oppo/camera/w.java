package com.oppo.camera;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import androidx.collection.ArrayMap;
import com.oppo.camera.aps.adapter.ApsTotalResult;
import com.oppo.camera.aps.service.ApsService;
import com.oppo.camera.f.a;
import com.oppo.camera.f.d;
import com.oppo.camera.f.f;
import java.util.HashSet;
import java.util.Set;

/* compiled from: SatController */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3168a = "w";

    /* renamed from: b  reason: collision with root package name */
    private f f3169b = null;
    private ApsService c = null;
    private volatile ApsTotalResult d = null;
    private volatile ApsTotalResult e = null;
    private volatile ApsTotalResult f = null;

    protected w() {
    }

    /* access modifiers changed from: protected */
    public void a(CaptureRequest.Builder builder, String str, Rect rect) {
        if (!b(this.d)) {
            String str2 = f3168a;
            e.e(str2, "updateCaptureRequestBuilder, param invalid, mPreviewTotalResult: " + this.d);
            return;
        }
        int intValue = ((Integer) this.d.get(ApsTotalResult.SAT_MASTER_CAMERA_ID)).intValue();
        int intValue2 = ((Integer) this.d.get(ApsTotalResult.SAT_ACTIVE_MAP)).intValue();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.putAll(((d) builder.build().getTag()).al);
        builder.set(CaptureRequest.SCALER_CROP_REGION, rect);
        this.c.setRequestMetadata(str, arrayMap, intValue, intValue2);
    }

    /* access modifiers changed from: protected */
    public int a(String str, Rect rect) {
        int i;
        int i2;
        if (b(this.f)) {
            i2 = ((Integer) this.f.get(ApsTotalResult.SAT_MASTER_CAMERA_ID)).intValue();
            i = ((Integer) this.f.get(ApsTotalResult.SAT_ACTIVE_MAP)).intValue();
        } else if (b(this.d)) {
            i2 = ((Integer) this.d.get(ApsTotalResult.SAT_MASTER_CAMERA_ID)).intValue();
            i = ((Integer) this.d.get(ApsTotalResult.SAT_ACTIVE_MAP)).intValue();
        } else {
            i = 2;
            i2 = 0;
        }
        HashSet hashSet = new HashSet();
        boolean z = true;
        boolean z2 = (i & 1) != 0;
        boolean z3 = (i & 2) != 0;
        if ((i & 4) == 0) {
            z = false;
        }
        if (z2) {
            hashSet.add(String.valueOf(a.j()));
        }
        if (z3) {
            hashSet.add(String.valueOf(a.h()));
        }
        if (z) {
            hashSet.add(String.valueOf(a.o()));
        }
        try {
            CaptureRequest.Builder a2 = this.f3169b.a((Set<String>) hashSet);
            if (a2 == null) {
                e.e(f3168a, "onSetRequestMetadata, create null preview builder.");
                return 0;
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.putAll(((d) a2.build().getTag()).al);
            a2.set(CaptureRequest.SCALER_CROP_REGION, rect);
            this.c.setRequestMetadata(str, arrayMap, i2, i);
            return i;
        } catch (CameraAccessException e2) {
            e.d(f3168a, "onSetRequestMetadata, create preview builder error.", e2);
            return 0;
        }
    }

    private boolean b(ApsTotalResult apsTotalResult) {
        int intValue;
        if (apsTotalResult == null || apsTotalResult.get(ApsTotalResult.SAT_MASTER_CAMERA_ID) == null || apsTotalResult.get(ApsTotalResult.SAT_ACTIVE_MAP) == null || -1 == ((Integer) apsTotalResult.get(ApsTotalResult.SAT_MASTER_CAMERA_ID)).intValue() || (intValue = ((Integer) apsTotalResult.get(ApsTotalResult.SAT_ACTIVE_MAP)).intValue()) <= 0 || intValue >= 7) {
            return false;
        }
        if ((intValue & 1) == 0 && (intValue & 2) == 0 && (intValue & 4) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005c, code lost:
        if (r3 == r4) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r6 = this;
            com.oppo.camera.aps.adapter.ApsTotalResult r0 = r6.d
            boolean r0 = r6.b(r0)
            r1 = 1
            if (r0 == 0) goto L_0x0012
            com.oppo.camera.aps.adapter.ApsTotalResult r0 = r6.e
            boolean r0 = r6.b(r0)
            if (r0 != 0) goto L_0x0012
            goto L_0x0060
        L_0x0012:
            com.oppo.camera.aps.adapter.ApsTotalResult r0 = r6.d
            boolean r0 = r6.b(r0)
            if (r0 == 0) goto L_0x005f
            com.oppo.camera.aps.adapter.ApsTotalResult r0 = r6.e
            boolean r0 = r6.b(r0)
            if (r0 == 0) goto L_0x005f
            com.oppo.camera.aps.adapter.ApsTotalResult r0 = r6.e
            com.oppo.camera.aps.adapter.ApsTotalResult$Key<java.lang.Integer> r2 = com.oppo.camera.aps.adapter.ApsTotalResult.SAT_ACTIVE_MAP
            java.lang.Object r0 = r0.get(r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            com.oppo.camera.aps.adapter.ApsTotalResult r2 = r6.d
            com.oppo.camera.aps.adapter.ApsTotalResult$Key<java.lang.Integer> r3 = com.oppo.camera.aps.adapter.ApsTotalResult.SAT_ACTIVE_MAP
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.oppo.camera.aps.adapter.ApsTotalResult r3 = r6.e
            com.oppo.camera.aps.adapter.ApsTotalResult$Key<java.lang.Integer> r4 = com.oppo.camera.aps.adapter.ApsTotalResult.SAT_MASTER_CAMERA_ID
            java.lang.Object r3 = r3.get(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.oppo.camera.aps.adapter.ApsTotalResult r4 = r6.d
            com.oppo.camera.aps.adapter.ApsTotalResult$Key<java.lang.Integer> r5 = com.oppo.camera.aps.adapter.ApsTotalResult.SAT_MASTER_CAMERA_ID
            java.lang.Object r4 = r4.get(r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r0 != r2) goto L_0x0060
            if (r3 == r4) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = 0
        L_0x0060:
            if (r1 == 0) goto L_0x0068
            com.oppo.camera.f.f r0 = r6.f3169b
            r1 = 0
            r0.a((com.oppo.camera.f.f.c) r1)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.w.a():void");
    }

    /* access modifiers changed from: protected */
    public void a(ApsTotalResult apsTotalResult) {
        this.e = this.d;
        this.d = apsTotalResult;
    }

    /* access modifiers changed from: protected */
    public void a(f fVar) {
        this.f3169b = fVar;
    }

    /* access modifiers changed from: protected */
    public void a(ApsService apsService) {
        this.c = apsService;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        this.f = z ? this.d : null;
    }
}
