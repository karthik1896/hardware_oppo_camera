package com.oppo.camera.ui.inverse;

import java.lang.ref.WeakReference;

/* compiled from: InverseData */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f4025a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4026b = 0;
    public boolean c = false;
    public float d = 1.0f;
    public a e = a.common;
    public WeakReference<?> f = null;

    /* compiled from: InverseData */
    public enum a {
        common,
        background,
        mask,
        preview
    }

    public b(a aVar) {
        this.e = aVar;
    }
}
