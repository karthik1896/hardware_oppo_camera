package com.oppo.camera.sticker;

import android.util.Size;
import com.oppo.camera.e;
import com.oppo.camera.gl.s;
import com.sensetime.stmobile.STMobileStickerNative;
import com.sensetime.stmobile.model.STHumanAction;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: MaterailInfo */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Object f3628a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private STMobileStickerNative f3629b = new STMobileStickerNative();
    private STHumanAction c = null;
    private STHumanAction d = null;
    private LinkedHashMap<Long, STHumanAction> e = null;
    private long f = 0;
    private s g = null;
    private int h = -1;
    private Size i = null;
    private float j = 1.0f;
    private float k = 1.0f;
    private boolean l = false;

    public STMobileStickerNative a() {
        return this.f3629b;
    }

    public void a(STHumanAction sTHumanAction) {
        this.c = sTHumanAction;
    }

    public void b(STHumanAction sTHumanAction) {
        synchronized (this.f3628a) {
            if (this.e != null && !this.e.isEmpty() && this.l) {
                Iterator<Long> it = this.e.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Long next = it.next();
                    if (this.e.get(next) == null) {
                        this.e.put(next, sTHumanAction);
                        e.a("MaterialInfo", "setPreviewSTHumanActionForCheck, timeStamp: " + next);
                        break;
                    }
                }
            }
        }
    }

    public void a(float f2) {
        this.j = f2;
    }

    public STHumanAction b(float f2) {
        return STHumanAction.humanActionResize(f2 / this.j, this.c);
    }

    public void a(long j2) {
        this.f = j2;
    }

    public long b() {
        return this.f;
    }

    public void a(s sVar) {
        this.g = sVar;
    }

    public s c() {
        return this.g;
    }
}
