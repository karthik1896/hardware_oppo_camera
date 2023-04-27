package com.oppo.camera.ui.preview.a;

import android.graphics.Bitmap;
import android.graphics.Point;
import co.polarr.renderer.FilterPackageUtil;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.tiltshift.TiltShiftParam;
import com.oppo.camera.util.Util;
import java.math.BigDecimal;

/* compiled from: TexturePreviewRequest */
public class u {
    private a A = null;
    private Point B = new Point(0, 0);
    private Bitmap C = null;
    private byte[] D = null;
    private long E = 0;
    private int F = 0;
    private boolean G = false;
    private int H = 5;

    /* renamed from: a  reason: collision with root package name */
    private StickerItem f4429a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f4430b = 0;
    private String c = FilterPackageUtil.F_DEFAULT;
    private int d = 0;
    private int e = -1;
    private boolean f = false;
    private boolean g = true;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private float o = 1.0f;
    private float p = 1.0f;
    private float q = new BigDecimal(60).multiply(com.oppo.camera.d.c).floatValue();
    private float r = 0.0f;
    private float s = 0.0f;
    private TiltShiftParam t = null;
    private int[] u = null;
    private int[] v = null;
    private String w = null;
    private c x = null;
    private d y = null;
    private b z = null;

    /* compiled from: TexturePreviewRequest */
    public interface a {
        void c(int i);
    }

    /* compiled from: TexturePreviewRequest */
    public interface b {
        void a(float f);

        boolean a();
    }

    /* compiled from: TexturePreviewRequest */
    public interface c {
        void a(String str);

        void b(boolean z);
    }

    /* compiled from: TexturePreviewRequest */
    public interface d {
        void b(boolean z);
    }

    public void a(float f2) {
        this.q = f2;
    }

    public float a() {
        return this.q;
    }

    public boolean b() {
        return this.h;
    }

    public void a(boolean z2) {
        this.h = z2;
    }

    public void b(float f2) {
        this.r = f2;
    }

    public boolean c() {
        return this.i;
    }

    public void b(boolean z2) {
        this.i = z2;
    }

    public void c(float f2) {
        this.s = f2;
    }

    public void a(TiltShiftParam tiltShiftParam) {
        this.t = tiltShiftParam;
    }

    public TiltShiftParam d() {
        return this.t;
    }

    public float e() {
        return this.s;
    }

    public float f() {
        return this.r;
    }

    public boolean g() {
        return this.j;
    }

    public void c(boolean z2) {
        this.j = z2;
    }

    public void a(int i2) {
        this.f4430b = i2;
    }

    public int h() {
        return this.f4430b;
    }

    public void a(String str) {
        this.c = str;
        c cVar = this.x;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void d(boolean z2) {
        this.F = z2 ? 1 : 2;
        D();
    }

    public boolean i() {
        return this.f;
    }

    public void e(boolean z2) {
        this.f = z2;
    }

    public void a(StickerItem stickerItem) {
        this.f4429a = stickerItem;
    }

    public StickerItem j() {
        return this.f4429a;
    }

    public boolean k() {
        return this.G;
    }

    public void f(boolean z2) {
        this.G = z2;
    }

    public void a(int[] iArr) {
        this.u = Util.a(iArr);
    }

    public int[] l() {
        return this.u;
    }

    public boolean m() {
        return this.g;
    }

    public boolean n() {
        return this.f4429a != null;
    }

    public void a(byte[] bArr) {
        synchronized (this) {
            this.D = bArr;
        }
    }

    public byte[] o() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.D;
        }
        return bArr;
    }

    public void a(long j2) {
        synchronized (this) {
            this.E = j2;
        }
    }

    public long p() {
        long j2;
        synchronized (this) {
            j2 = this.E;
        }
        return j2;
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.C = bitmap;
            this.k = true;
            return;
        }
        this.C = null;
        this.k = false;
    }

    public Bitmap q() {
        return this.C;
    }

    public boolean r() {
        return this.k;
    }

    public void g(boolean z2) {
        this.l = z2;
    }

    public boolean s() {
        return this.l;
    }

    public boolean t() {
        return this.m;
    }

    public void h(boolean z2) {
        this.m = z2;
    }

    public void b(int i2) {
        this.d = i2;
    }

    public int u() {
        return this.d;
    }

    public void a(Point point) {
        this.B = point;
    }

    public void c(int i2) {
        this.e = i2;
    }

    public int v() {
        return this.e;
    }

    public void a(c cVar) {
        this.x = cVar;
        c cVar2 = this.x;
        if (cVar2 != null) {
            cVar2.b(this.g);
            this.x.a(this.c);
        }
    }

    public void a(d dVar) {
        this.y = dVar;
        D();
    }

    private void D() {
        int i2;
        d dVar = this.y;
        if (dVar != null && (i2 = this.F) != 0) {
            boolean z2 = true;
            if (1 != i2) {
                z2 = false;
            }
            dVar.b(z2);
            this.F = 0;
        }
    }

    public void i(boolean z2) {
        this.n = z2;
    }

    public void d(float f2) {
        this.o = f2;
    }

    public boolean w() {
        return this.n;
    }

    public float x() {
        return this.o;
    }

    public float y() {
        return this.p;
    }

    public void z() {
        this.x = null;
    }

    public void a(b bVar) {
        this.z = bVar;
    }

    public b A() {
        return this.z;
    }

    public Point B() {
        return this.B;
    }

    public int C() {
        return this.H;
    }

    public void a(a aVar) {
        this.A = aVar;
    }

    public void d(int i2) {
        this.H = i2;
        e(i2);
    }

    private void e(int i2) {
        a aVar = this.A;
        if (aVar != null) {
            aVar.c(i2);
        }
    }
}
