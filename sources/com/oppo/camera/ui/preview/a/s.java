package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import com.oppo.camera.aps.adapter.ApsResult;
import com.oppo.camera.doubleexposure.c;
import com.oppo.camera.gl.GLRootView;
import com.oppo.camera.gl.g;
import com.oppo.camera.gl.h;

/* compiled from: TexturePreview */
public abstract class s {
    protected int d = 0;
    protected boolean e = false;
    protected GLRootView f = null;
    protected b g = null;
    protected Context h = null;

    /* compiled from: TexturePreview */
    public interface b {
        com.oppo.camera.t.a a(int i, int i2, int i3, int i4, int i5, boolean z, long j);

        void a();

        void a(int i);

        void a(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3);

        void a(com.oppo.camera.t.a aVar);

        void a(String str);

        Rect[] b();
    }

    public void a(int i, int i2) {
    }

    public void a(long j) {
    }

    public void a(Size size, boolean z) {
    }

    public void a(c cVar) {
    }

    public abstract void a(h hVar);

    public abstract void a(u uVar);

    public void a(boolean z) {
    }

    public void a(byte[] bArr, int i, int i2) {
    }

    public abstract boolean a();

    public abstract boolean a(int i);

    public abstract boolean a(a aVar);

    public abstract void b();

    public void b(int i) {
    }

    public abstract void c();

    public abstract int d();

    public abstract void e();

    public void e(int i) {
    }

    public abstract com.oppo.camera.gl.s f();

    public abstract com.oppo.camera.gl.s g();

    public abstract boolean h();

    public abstract void i();

    public abstract void j();

    public int k() {
        return 0;
    }

    public void l() {
    }

    public void m() {
    }

    public void n() {
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public void v() {
    }

    public void q() {
        this.h = null;
    }

    public boolean c_(int i) {
        return (i & d()) != 0;
    }

    /* compiled from: TexturePreview */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public h f4427a = null;

        /* renamed from: b  reason: collision with root package name */
        public g f4428b = null;
        public com.oppo.camera.gl.s c = null;
        public com.oppo.camera.gl.s d = null;
        public ApsResult.ImageBuffer e = null;
        public boolean f = false;
        public boolean g = false;
        public float[] h = null;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;
        public int m = 0;

        public a() {
        }

        public String toString() {
            return "FrameInfo: " + "mExtTexture: " + this.f4428b + ", mInTexture: " + this.c + ", mWidth: " + this.i + ", mHeight: " + this.j + ", mRequestRenderType: " + this.m;
        }
    }

    public a r() {
        return new a();
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    public s(Context context) {
        this.h = context;
    }

    public void a(GLRootView gLRootView) {
        this.f = gLRootView;
    }

    public void d(int i) {
        this.d = i;
        this.e = com.oppo.camera.f.a.c(this.d);
    }
}
