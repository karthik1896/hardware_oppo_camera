package com.oppo.camera.ui.menu.levelcontrol;

import android.graphics.Bitmap;
import co.polarr.renderer.entities.DrawingItem;
import com.oppo.camera.ui.preview.a.g;
import java.util.List;

/* compiled from: GLModelParam */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private String f4140a = null;

    /* renamed from: b  reason: collision with root package name */
    private List<DrawingItem> f4141b = null;
    private List<Bitmap> c = null;
    private Bitmap d = null;
    private Bitmap e = null;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = g.f4385a;
    private float l = 0.0f;
    private float m = 0.0f;
    private float n = 0.0f;
    private float o = 0.0f;
    private float p = 0.0f;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;
    private int y = -1;
    private int z = -1;

    public f(String str) {
        this.f4140a = str;
    }

    public List<DrawingItem> a() {
        return this.f4141b;
    }

    public void a(List<DrawingItem> list) {
        this.f4141b = list;
    }

    public List<Bitmap> b() {
        return this.c;
    }

    public void b(List<Bitmap> list) {
        this.c = list;
    }

    public Bitmap c() {
        return this.d;
    }

    public void a(Bitmap bitmap) {
        this.d = bitmap;
    }

    public Bitmap d() {
        return this.e;
    }

    public void b(Bitmap bitmap) {
        this.e = bitmap;
    }

    public int e() {
        return this.f;
    }

    public void a(int i2) {
        this.f = i2;
    }

    public int f() {
        return this.g;
    }

    public void b(int i2) {
        this.g = i2;
    }

    public int g() {
        return this.h;
    }

    public void c(int i2) {
        this.h = i2;
    }

    public int h() {
        return this.i;
    }

    public void d(int i2) {
        this.i = i2;
    }

    public int i() {
        return this.j;
    }

    public void e(int i2) {
        this.j = i2;
    }

    public int j() {
        return this.k;
    }

    public void f(int i2) {
        this.k = i2;
    }

    public boolean k() {
        return this.q;
    }

    public void a(boolean z2) {
        this.q = z2;
    }

    public boolean l() {
        return this.s;
    }

    public void b(boolean z2) {
        this.s = z2;
    }

    public float m() {
        return this.l;
    }

    public void a(float f2) {
        this.l = f2;
    }

    public float n() {
        return this.m;
    }

    public void b(float f2) {
        this.m = f2;
    }

    public float o() {
        return this.n;
    }

    public void c(float f2) {
        this.n = f2;
    }

    public float p() {
        return this.o;
    }

    public void d(float f2) {
        this.o = f2;
    }

    public float q() {
        return this.p;
    }

    public void e(float f2) {
        this.p = f2;
    }

    public boolean r() {
        return this.r;
    }

    public void c(boolean z2) {
        this.r = z2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = -1
            switch(r0) {
                case -1635943362: goto L_0x0045;
                case -928591791: goto L_0x003b;
                case -404148440: goto L_0x0031;
                case 205787002: goto L_0x0027;
                case 895928230: goto L_0x001d;
                case 1207726869: goto L_0x0013;
                case 1560871751: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x004f
        L_0x0009:
            java.lang.String r0 = "tree-green.cube.rgb.bin"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 3
            goto L_0x0050
        L_0x0013:
            java.lang.String r0 = "sky-blue.cube.rgb.bin"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 4
            goto L_0x0050
        L_0x001d:
            java.lang.String r0 = "red-red.cube.rgb.bin"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 2
            goto L_0x0050
        L_0x0027:
            java.lang.String r0 = "portrait_retention"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 0
            goto L_0x0050
        L_0x0031:
            java.lang.String r0 = "neon-2020.cube.rgb.bin"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 6
            goto L_0x0050
        L_0x003b:
            java.lang.String r0 = "portrait_streamer"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 1
            goto L_0x0050
        L_0x0045:
            java.lang.String r0 = "oppo_video_filter_portrait_retention"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x004f
            r3 = 5
            goto L_0x0050
        L_0x004f:
            r3 = r1
        L_0x0050:
            switch(r3) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0063;
                case 2: goto L_0x0060;
                case 3: goto L_0x005d;
                case 4: goto L_0x005a;
                case 5: goto L_0x0057;
                case 6: goto L_0x0054;
                default: goto L_0x0053;
            }
        L_0x0053:
            return r1
        L_0x0054:
            int r3 = r2.z
            return r3
        L_0x0057:
            int r3 = r2.y
            return r3
        L_0x005a:
            int r3 = r2.x
            return r3
        L_0x005d:
            int r3 = r2.w
            return r3
        L_0x0060:
            int r3 = r2.v
            return r3
        L_0x0063:
            int r3 = r2.u
            return r3
        L_0x0066:
            int r3 = r2.t
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.levelcontrol.f.a(java.lang.String):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r2, int r3) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1635943362: goto L_0x0044;
                case -928591791: goto L_0x003a;
                case -404148440: goto L_0x0030;
                case 205787002: goto L_0x0026;
                case 895928230: goto L_0x001c;
                case 1207726869: goto L_0x0012;
                case 1560871751: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x004e
        L_0x0008:
            java.lang.String r0 = "tree-green.cube.rgb.bin"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 3
            goto L_0x004f
        L_0x0012:
            java.lang.String r0 = "sky-blue.cube.rgb.bin"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 4
            goto L_0x004f
        L_0x001c:
            java.lang.String r0 = "red-red.cube.rgb.bin"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 2
            goto L_0x004f
        L_0x0026:
            java.lang.String r0 = "portrait_retention"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 0
            goto L_0x004f
        L_0x0030:
            java.lang.String r0 = "neon-2020.cube.rgb.bin"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 6
            goto L_0x004f
        L_0x003a:
            java.lang.String r0 = "portrait_streamer"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 1
            goto L_0x004f
        L_0x0044:
            java.lang.String r0 = "oppo_video_filter_portrait_retention"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x004e
            r2 = 5
            goto L_0x004f
        L_0x004e:
            r2 = -1
        L_0x004f:
            switch(r2) {
                case 0: goto L_0x0065;
                case 1: goto L_0x0062;
                case 2: goto L_0x005f;
                case 3: goto L_0x005c;
                case 4: goto L_0x0059;
                case 5: goto L_0x0056;
                case 6: goto L_0x0053;
                default: goto L_0x0052;
            }
        L_0x0052:
            goto L_0x0067
        L_0x0053:
            r1.z = r3
            goto L_0x0067
        L_0x0056:
            r1.y = r3
            goto L_0x0067
        L_0x0059:
            r1.x = r3
            goto L_0x0067
        L_0x005c:
            r1.w = r3
            goto L_0x0067
        L_0x005f:
            r1.v = r3
            goto L_0x0067
        L_0x0062:
            r1.u = r3
            goto L_0x0067
        L_0x0065:
            r1.t = r3
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.levelcontrol.f.a(java.lang.String, int):void");
    }

    public boolean a(f fVar) {
        return fVar != null && this.f4141b == fVar.a() && this.f == fVar.e() && this.g == fVar.f() && this.h == fVar.g() && this.l == fVar.m() && this.m == fVar.n() && this.n == fVar.o() && this.o == fVar.p() && this.q == fVar.k() && this.r == fVar.r();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb, "mModelName", this.f4140a);
        a(sb, "mBitmaps", this.c);
        a(sb, "mHighlightBmp", this.d);
        a(sb, "mHighlightBmpInverse", this.e);
        a(sb, "mElementNum", Integer.valueOf(this.f));
        a(sb, "mTexW", Integer.valueOf(this.g));
        a(sb, "mTexH", Integer.valueOf(this.h));
        a(sb, "mCurrItemIndex", Integer.valueOf(this.k));
        a(sb, "mCenterAng", Float.valueOf(this.l));
        a(sb, "mElementH", Float.valueOf(this.m));
        a(sb, "mElementGap", Float.valueOf(this.n));
        a(sb, "mHighlightH", Float.valueOf(this.o));
        a(sb, "mbFrontCamera", Boolean.valueOf(this.q));
        a(sb, "mbFromSurfaceTexture", Boolean.valueOf(this.r));
        return sb.toString();
    }

    private void a(StringBuilder sb, String str, Object obj) {
        if (sb != null) {
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(", ");
        }
    }
}
