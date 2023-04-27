package a.a.b;

import a.a.b.a.a.b;
import a.a.b.a.a.c;
import a.a.b.a.aa;
import a.a.b.a.af;
import a.a.b.a.ah;
import a.a.b.a.ai;
import a.a.b.a.aj;
import a.a.b.a.ak;
import a.a.b.a.an;
import a.a.b.a.ao;
import a.a.b.a.ap;
import a.a.b.a.aq;
import a.a.b.a.at;
import a.a.b.a.av;
import a.a.b.a.aw;
import a.a.b.a.ay;
import a.a.b.a.az;
import a.a.b.a.ba;
import a.a.b.a.bb;
import a.a.b.a.bd;
import a.a.b.a.be;
import a.a.b.a.bg;
import a.a.b.a.bi;
import a.a.b.a.bj;
import a.a.b.a.bl;
import a.a.b.a.bm;
import a.a.b.a.bo;
import a.a.b.a.e;
import a.a.b.a.g;
import a.a.b.a.i;
import a.a.b.a.l;
import a.a.b.a.m;
import a.a.b.a.p;
import a.a.b.a.v;
import a.a.b.a.w;
import a.a.b.a.y;
import a.a.b.e.f;
import a.a.b.e.h;
import a.a.b.e.j;
import a.a.b.e.k;
import a.a.b.e.n;
import a.a.b.e.o;
import a.a.b.e.r;
import a.a.b.e.s;
import a.a.b.e.t;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.util.TimingLogger;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.entities.Adjustment;
import co.polarr.renderer.entities.BrushItem;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.DrawingItem;
import co.polarr.renderer.entities.FaceItem;
import co.polarr.renderer.entities.LutItem;
import co.polarr.renderer.entities.MagicEraserPath;
import co.polarr.renderer.entities.SpotItem;
import co.polarr.renderer.entities.TextItem;
import co.polarr.renderer.filters.Basic;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d {
    public bo A;
    public v B;
    public int C;
    public int D;
    public boolean E = true;
    public boolean F = false;
    public boolean G = false;
    public boolean H = true;
    public a.a.b.b.d I;
    public a.a.b.b.d J;
    public a.a.b.b.d K;
    public h L;
    public int M = 0;
    public boolean N;
    public int[] O;
    public byte[] P;
    public Bitmap Q;
    public boolean R = false;

    /* renamed from: a  reason: collision with root package name */
    public ak f27a;

    /* renamed from: b  reason: collision with root package name */
    public ah f28b;
    public Basic c;
    public boolean d = true;
    public c e;
    public b f;
    public int g = 0;
    public boolean h;
    public Map<String, Object> i = new HashMap();
    public Handler j;
    public ByteBuffer k;
    public boolean l;
    public bj m;
    public n n = new n(10);
    public n o = new n(20);
    public float p;
    public float q;
    public float r;
    public a.a.b.a.a.d s;
    public Context t;
    public int u;
    public int v;
    public List<b> w;
    public r x;
    public Resources y;
    public c z;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f29a;

        public a(byte[] bArr) {
            this.f29a = bArr;
        }

        public void run() {
            boolean unused = d.this.l = true;
            Map<String, Float> a2 = j.a(300, 300, this.f29a, d.this.t.renderStates, false);
            HashMap hashMap = new HashMap();
            hashMap.putAll(a2);
            if (!d.this.E) {
                hashMap.remove("highlights");
                hashMap.remove("shadows");
                hashMap.remove("clarity");
                hashMap.remove("dehaze");
            }
            Map<String, Object> GetRefStates = FilterPackageUtil.GetRefStates(hashMap, 0.5f);
            synchronized (d.this.i) {
                d.this.i.clear();
                d.this.i.putAll(GetRefStates);
            }
            boolean unused2 = d.this.l = false;
        }
    }

    public d() {
        this.o.a(false);
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 1.0f;
    }

    public static List<PointF> a(List<PointF> list, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        float f5 = (f4 - 1.0f) / 2.0f;
        for (PointF next : list) {
            PointF pointF = new PointF();
            pointF.x = ((next.x + f5) - (f2 / 2.0f)) / f4;
            pointF.y = ((next.y + f5) - (f3 / 2.0f)) / f4;
            arrayList.add(pointF);
        }
        return arrayList;
    }

    public int a(List<PointF> list) {
        this.x.a(a(list, this.p, this.q, this.r), this.p, this.q, this.r);
        return this.t.writableTexture.f11a;
    }

    public final a.a.b.b.d a(Context context, g gVar, a.a.b.b.d dVar, a.a.b.b.d dVar2, float f2, Float f3) {
        if (dVar2 == null) {
            dVar2 = dVar;
        }
        if (f3 == null) {
            f3 = Float.valueOf(f2);
        }
        float f4 = 1.0f / ((float) dVar2.f12b);
        float floatValue = f3.floatValue();
        float floatValue2 = f3.floatValue();
        gVar.r = new float[]{f4 * f2, 0.0f, f4 * floatValue, 0.0f};
        gVar.s = Context.overlayMesh;
        a((a.a.b.a.a.a) gVar, dVar.f11a, context.readableTexture);
        gVar.r = new float[]{0.0f, (1.0f / ((float) dVar2.c)) * f2, 0.0f, (1.0f / ((float) dVar2.c)) * floatValue2};
        gVar.s = Context.overlayMesh;
        a((a.a.b.a.a.a) gVar, context.readableTexture.f11a, dVar2);
        return dVar2;
    }

    public final a.a.b.b.d a(Context context, a.a.b.a.r rVar, an anVar, a.a.b.b.d dVar, a.a.b.b.d dVar2) {
        if (dVar2 == null) {
            dVar2 = dVar;
        }
        rVar.r = new float[]{(1.0f / ((float) dVar2.f12b)) * 8.0f, 0.0f};
        rVar.s = Context.overlayMesh;
        a((a.a.b.a.a.a) rVar, dVar.f11a, context.readableTexture);
        anVar.r = new float[]{0.0f, (1.0f / ((float) dVar2.c)) * 8.0f};
        anVar.s = Context.overlayMesh;
        a((a.a.b.a.a.a) anVar, context.readableTexture.f11a, dVar2);
        return dVar2;
    }

    public Bitmap a(Bitmap bitmap, String str) {
        return a(bitmap, str, 1.0f);
    }

    public Bitmap a(Bitmap bitmap, String str, float f2) {
        return a(bitmap, str, f2, 0.0f);
    }

    public Bitmap a(Bitmap bitmap, String str, float f2, float f3) {
        a.a("start render bitmap");
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        a.a.b.e.b.a("fastRenderBitmap::filterId=%s::fastRenderBitmap=%f", str, Float.valueOf(f2));
        GLES20.glBindTexture(3553, this.C);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        boolean z2 = this.H;
        this.H = false;
        w();
        this.H = z2;
        c(f3);
        b(str, f2);
        g();
        GLES20.glFinish();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(s.a(this.t.readableTexture.f11a, bitmap.getWidth(), bitmap.getHeight()));
        a.a("end render bitmap");
        return createBitmap;
    }

    public Bitmap a(Bitmap bitmap, Map<String, Object> map) {
        a.a("start render bitmap");
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        a.a.b.e.b.a("renderBitmap::renderStates=%s", map == null ? "null" : map.toString());
        GLES20.glBindTexture(3553, this.C);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        boolean z2 = this.H;
        this.H = false;
        w();
        this.H = z2;
        b(map);
        a((android.content.Context) null, false);
        GLES20.glFinish();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(s.a(this.t.readableTexture.f11a, bitmap.getWidth(), bitmap.getHeight()));
        a.a("end render bitmap");
        return createBitmap;
    }

    public Map<String, Object> a(float f2) {
        a.a.b.e.b.a("autoEnhanceGlobalForFace::percent=%f", Float.valueOf(f2));
        a.a("start auto enhance global face");
        Map<String, Object> GetRefStates = FilterPackageUtil.GetRefStates((Map) a.a.b.e.g.b(j.f62a), f2);
        a.a("end auto enhance global face");
        return GetRefStates;
    }

    public Map<String, Object> a(float f2, Map<String, Object> map) {
        int i2;
        Map<String, Object> map2 = map;
        a.a.b.e.b.a("autoEnhanceGlobal::percent=%f", Float.valueOf(f2));
        a.a("start auto enhance global");
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        a.a.b.b.d dVar = this.t.imageTexture;
        float f3 = (float) dVar.f12b;
        float f4 = (float) dVar.c;
        HashMap hashMap = new HashMap();
        if (this.P == null || this.Q == null) {
            int i3 = (int) f3;
            int i4 = (int) f4;
            this.P = a.a.b.b.a.b(this.y, this.t.imageTexture, i3, i4);
            this.Q = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            this.Q.copyPixelsFromBuffer(ByteBuffer.wrap(this.P));
        }
        int i5 = 80;
        if (f3 > f4) {
            i2 = (int) (((float) 80) * (f3 / f4));
        } else {
            i5 = (int) (((float) 80) * (f4 / f3));
            i2 = 80;
        }
        Bitmap a2 = a.a.b.e.a.a(this.Q, (float) i2, (float) i5);
        byte[] a3 = a.a.b.e.a.a(a2);
        List<FaceItem> list = null;
        if (!(map2 == null || map2.get("faces") == null)) {
            list = (List) map2.get("faces");
        }
        Map<String, Float> a4 = j.a(a2.getWidth(), a2.getHeight(), a3, this.t.renderStates, list != null && !list.isEmpty());
        if (list != null) {
            HashMap hashMap2 = new HashMap();
            for (FaceItem faceItem : list) {
                int height = this.Q.getHeight();
                int width = this.Q.getWidth();
                float[] fArr = faceItem.boundaries;
                float f5 = (float) width;
                float f6 = (float) height;
                int i6 = (int) (fArr[2] * f5);
                int i7 = (int) (fArr[3] * f6);
                Bitmap createBitmap = Bitmap.createBitmap(this.Q, (int) (fArr[0] * f5), (int) (fArr[1] * f6), i6, i7);
                if (i6 > 50 || i7 > 50) {
                    createBitmap = a.a.b.e.a.a(createBitmap, 50.0f, 50.0f);
                }
                Map<String, Float> a5 = j.a(createBitmap.getWidth(), createBitmap.getHeight(), a.a.b.e.a.a(createBitmap), this.t.renderStates);
                for (String next : a5.keySet()) {
                    hashMap2.put(next, !hashMap2.containsKey(next) ? a5.get(next) : Float.valueOf(Math.min(((Float) hashMap2.get(next)).floatValue(), a5.get(next).floatValue())));
                }
            }
            for (Map.Entry entry : hashMap2.entrySet()) {
                j.a(a4, (String) entry.getKey(), ((Float) entry.getValue()).floatValue());
            }
        }
        hashMap.putAll(a4);
        if (!this.E) {
            hashMap.remove("highlights");
            hashMap.remove("shadows");
            hashMap.remove("clarity");
            hashMap.remove("dehaze");
        }
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        Map<String, Object> GetRefStates = FilterPackageUtil.GetRefStates(hashMap, f2);
        a.a("end auto enhance global");
        return GetRefStates;
    }

    public void a() {
        this.x.d();
    }

    public void a(float f2, float f3, float f4) {
        this.p = f2;
        this.q = f3;
        this.r = f4;
    }

    public void a(int i2) {
        this.x.a(i2);
    }

    public void a(int i2, int i3) {
        this.x.a(i2, i3, this.p, this.q, this.r);
    }

    public void a(int i2, int i3, int i4) {
        a.a.b.e.b.a("clearTexture::textureId=%d::width=%d::height=%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        GLES20.glDisable(3089);
        this.z.b(i2);
        this.z.a(o.a());
        this.z.b(i3, i4);
        this.z.p();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.z.m();
    }

    public final void a(a.a.b.a.a.a aVar, int i2, int i3, int i4, int i5) {
        this.z.b(i3);
        this.z.a(o.a());
        this.z.b(i4, i5);
        this.z.a(aVar);
        if (i2 != 0) {
            this.z.a(i2);
        }
        this.z.draw();
        a.a("render tex out id");
    }

    public final void a(a.a.b.a.a.a aVar, int i2, a.a.b.b.d dVar) {
        if (aVar != null) {
            a.a.b.e.b.a("renderTextrue::inputTextureID=%d::outputTexture=%s", Integer.valueOf(i2), dVar.toString());
            this.z.b(dVar.f11a);
            this.z.a(o.a());
            this.z.b(dVar.f12b, dVar.c);
            this.z.a(aVar);
            if (i2 != 0) {
                this.z.a(i2);
            }
            this.z.draw();
            a.a("render tex");
        }
    }

    public void a(android.content.Context context, boolean z2) {
        int i2;
        a.a.b.e.b.a("render::fastDraw=%b", Boolean.valueOf(z2));
        if (this.s == null) {
            Log.e("PPE_RENDER", "getBitmap: Renderer was not set.");
        }
        if (!z2) {
            a(this.y);
        }
        a.a("render blur");
        a(context, z2, z2);
        a.a("do render");
        if (!z2 && (i2 = this.D) > 0) {
            this.z.b(i2);
            this.z.b(this.u, this.v);
            this.z.p();
            GLES20.glViewport(0, 0, this.u, this.v);
            Basic a2 = Basic.a(this.y, this.t);
            a2.a(this.t.readableTexture.f11a);
            Matrix.translateM(a2.getMatrix(), 0, this.p, this.q, 0.0f);
            float[] matrix = a2.getMatrix();
            float f2 = this.r;
            Matrix.scaleM(matrix, 0, f2, f2, 1.0f);
            a2.draw();
            this.z.m();
        }
    }

    public final void a(android.content.Context context, boolean z2, boolean z3) {
        Context.WatermarkOptions watermarkOptions;
        Context context2;
        Resources resources;
        List list;
        v vVar;
        boolean z4 = false;
        a.a.b.e.b.a("render::needSkip=%b::fastDraw=%b", Boolean.valueOf(z2), Boolean.valueOf(z3));
        if (this.s == null) {
            Log.e("PPE_RENDER", "getBitmap: Renderer was not set.");
        }
        if (!z3) {
            this.x.a(this.t, false);
            f.a(this.t, this.y);
        }
        if (!z3) {
            Context context3 = this.t;
            int[] iArr = context3.textures;
            a.a.b.a.a.a a2 = (iArr == null || iArr.length <= 0) ? y.a(this.y, this.t) : bb.a(this.y, context3);
            a2.a(this.t.matrix);
            if (this.z == null) {
                this.z = c.a(this.t);
            }
            this.z.a(a2);
            this.z.b(this.t.readableTexture.f11a);
            c cVar = this.z;
            a.a.b.b.d dVar = this.t.readableTexture;
            cVar.b(dVar.f12b, dVar.c);
            this.z.a(this.t.imageTexture.f11a);
            this.z.draw();
        }
        System.currentTimeMillis();
        this.s.a(this.t.readableTexture.f11a);
        this.s.v();
        if (z3) {
            a.a.b.a.a.d dVar2 = this.s;
            Context context4 = this.t;
            dVar2.c(context4.readableTexture.f11a, context4.writableTexture.f11a);
            if (this.C >= 0) {
                this.s.s();
                Basic a3 = Basic.a(this.y, this.t);
                a3.a(this.C);
                a3.draw();
            }
        }
        if (!z3 && (list = (List) this.t.renderStates.get("spots")) != null && !list.isEmpty()) {
            Context context5 = this.t;
            int[] iArr2 = context5.textures;
            if (iArr2 == null || iArr2.length <= 0) {
                v vVar2 = this.B;
                if (vVar2 == null) {
                    this.B = v.a(this.y, this.t);
                } else {
                    vVar2.a(this.t);
                }
                vVar = this.B;
            } else {
                bo boVar = this.A;
                if (boVar == null) {
                    this.A = bo.b(this.y, context5);
                } else {
                    boVar.a(context5);
                }
                vVar = this.A;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                SpotItem spotItem = (SpotItem) list.get(i2);
                vVar.r = spotItem.feather;
                vVar.s = spotItem.size;
                vVar.t = a.a.b.e.a.a(spotItem.position);
                vVar.u = a.a.b.e.a.a(spotItem.sourcePosition);
                vVar.v = spotItem.angle;
                vVar.w = spotItem.opacity;
                vVar.x = spotItem.mode;
                this.s.b(vVar);
            }
        }
        this.s.n();
        if (!z3) {
            Context context6 = this.t;
            if (context6.faceMasks != null) {
                List list2 = (List) context6.renderStates.get("faces");
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    if (this.t.faceMasks.length > i3) {
                        FaceItem faceItem = (FaceItem) list2.get(i3);
                        Context context7 = this.t;
                        a.a.b.b.f fVar = context7.faceMasks[i3];
                        if (faceItem.adjustments != null) {
                            bj a4 = bj.a(this.y, context7);
                            a4.r = fVar;
                            a4.s = faceItem.adjustments;
                            this.s.b(a4);
                        }
                    }
                }
            }
        }
        if (!z3) {
            a.a.b.b.g.a(this.y, this.t, this.s, this.w);
        }
        if (z2) {
            this.s.o();
            if (!z3) {
                resources = this.y;
                context2 = this.t;
            } else {
                int q2 = this.s.q();
                context2 = this.t;
                if (q2 == context2.writableTexture.f11a) {
                    resources = this.y;
                } else {
                    return;
                }
            }
            a((a.a.b.a.a.a) Basic.a(resources, context2), this.s.q(), this.t.readableTexture);
            return;
        }
        Object obj = this.t.renderStates.get("blur_opacity");
        if (((obj instanceof Integer) && ((Integer) obj).intValue() != 0) || ((obj instanceof Float) && ((Float) obj).floatValue() != 0.0f)) {
            z4 = true;
        }
        if (z4) {
            Context context8 = this.t;
            if (context8.lensBlurTexture.f12b != 1) {
                this.s.b(bd.a(this.y, context8));
            }
        }
        this.t.renderStates.remove("zPrevText");
        a.a.b.b.g.a(context, this.y, this.t, (ArrayList<TextItem>) (ArrayList) this.t.renderStates.get("text"));
        this.s.o();
        a((a.a.b.a.a.a) Basic.a(this.y, this.t), this.s.q(), this.t.readableTexture);
        a.a.b.b.g.e(this.y, this.t);
        Context context9 = this.t;
        if (context9.watermarkTexture != null && (watermarkOptions = context9.watermarkOptions) != null) {
            if (watermarkOptions.enabled || watermarkOptions.preview) {
                m a5 = m.a(this.y, this.t);
                a5.a(this.t.matrix);
                this.z.a((a.a.b.a.a.a) a5);
                this.z.b(this.t.writableTexture.f11a);
                c cVar2 = this.z;
                a.a.b.b.d dVar3 = this.t.readableTexture;
                cVar2.b(dVar3.f12b, dVar3.c);
                this.z.a(this.t.readableTexture.f11a);
                this.z.draw();
                a.a.b.b.g.b(this.t);
                a.a.b.b.g.f(this.y, this.t);
            }
        }
    }

    public final void a(Resources resources) {
        boolean z2;
        Context context = this.t;
        List list = (List) context.renderStates.get("local_adjustments");
        boolean z3 = false;
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            loop0:
            while (true) {
                z2 = false;
                while (true) {
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    Adjustment adjustment = (Adjustment) it.next();
                    if (z2 || adjustment.adjustments.blur != 0.0f) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                a.a.b.b.d dVar = context.readableTexture;
                int i2 = dVar.f12b;
                int i3 = dVar.c;
                int i4 = i2 >> 1;
                int i5 = i3 >> 1;
                s.b(dVar, i4, i5);
                s.b(context.writableTexture, i4, i5);
                s.b(context.lensBlurTexture, i4, i5);
                float[] fArr = context.matrix;
                context.matrix = o.a();
                a((android.content.Context) null, true, false);
                a.a.b.b.g.c(resources, context);
                a.a.b.b.g.a(resources, context, context.lensBlurTexture);
                s.b(context.readableTexture, i2, i3);
                s.b(context.writableTexture, i2, i3);
                context.matrix = fArr;
            }
            z3 = z2;
        }
        if (!z3) {
            s.b(context.lensBlurTexture, 1, 1);
        }
    }

    public void a(Resources resources, int i2, int i3, Map<String, Object> map) {
        Resources resources2 = resources;
        int i4 = i2;
        int i5 = i3;
        this.u = i4;
        this.v = i5;
        this.y = resources2;
        TimingLogger timingLogger = new TimingLogger("Polarr", "nativeInit_width/height=" + i4 + "/" + i5);
        this.t = new Context(this.N);
        this.t.shaderUtil = new t();
        this.t.shaderUtil.b(resources2);
        timingLogger.addSplit("shaderUtil.init");
        if (this.M == 1) {
            this.t.isOES = true;
        }
        this.t.resources = resources2;
        if (!this.N) {
            a(map, false, false);
            a.a.b.b.g.a(resources2, this.t, new Point(i4, i5));
            this.s = new a.a.b.a.a.d(this.t, resources2);
            for (a.a.b.a.a.a next : t.a(resources2, this.t)) {
                this.s.a(next);
                if (next instanceof ak) {
                    this.f27a = (ak) next;
                }
            }
            this.s.a();
            this.s.b(this.u, this.v);
        }
        if (this.N) {
            int[] iArr = new int[7];
            int[] iArr2 = iArr;
            s.a(iArr.length, iArr, 0, 6408, i2, i3);
            this.t.imageTexture = s.b(iArr2[0], 6408, i4, i5);
            this.t.readableTexture = s.b(iArr2[1], 6408, i4, i5);
            this.t.writableTexture = s.b(iArr2[2], 6408, i4, i5);
            this.t.dehazeTexture = s.b(iArr2[2], 6408, i4, i5);
            this.t.denoiseTexture = s.b(iArr2[3], 6408, i4, i5);
            this.t.grainTexture = s.b(iArr2[4], 6408, 1024, 1024);
            this.t.overlayTexture = s.b(iArr2[5], 6408, 1000, 1000);
            timingLogger.addSplit("outScreenContext.denoiseTexture");
            this.f28b = new ah(resources2, this.t);
            this.f28b.a();
            timingLogger.addSplit("BasicOes.create");
            this.f27a = new ak(resources2, this.t);
            timingLogger.addSplit("lookup2DFilter.create");
            this.f27a.a();
            timingLogger.addSplit("lookup2DFilter.create()");
        } else {
            this.w = t.b(resources2, this.t);
            for (a.a.b.a.a.a next2 : this.w) {
                next2.a();
                next2.b(this.u, this.v);
            }
            this.x = new r(this.t, resources2);
            this.x.b(this.t.denoiseTexture);
            a.a.b.b.g.d(this.t);
            a.a.b.b.g.e(this.t);
            a.a.b.b.g.a(this.t, (float) this.u, (float) this.v, this.H, true, (float[]) null);
        }
        this.z = c.a(this.t);
        timingLogger.addSplit("RenderTextureFilter.getInstance");
        if (!this.N) {
            float min = Math.min(1.0f, 512.0f / ((float) Math.max(i2, i3)));
            int i6 = (int) (((float) i4) * min);
            int i7 = (int) (((float) i5) * min);
            int[] iArr3 = new int[3];
            s.a(iArr3.length, iArr3, 0, 6408, i6, i7);
            this.I = s.b(iArr3[0], 6408, i6, i7);
            this.J = s.b(iArr3[1], 6408, i6, i7);
            this.K = s.b(iArr3[2], 6408, i6, i7);
        }
        timingLogger.dumpToLog();
    }

    public void a(Resources resources, int i2, int i3, boolean z2) {
        a(resources, i2, i3, z2, z2 ? 1 : 0);
    }

    public void a(Resources resources, int i2, int i3, boolean z2, int i4) {
        this.r = 1.0f;
        long currentTimeMillis = System.currentTimeMillis();
        a.a.b.e.b.a("initRender::width=%d::height=%d::fastMode=%b::textureType=%d", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Integer.valueOf(i4));
        a.a("start init");
        if (resources != null && i2 > 0 && i3 > 0) {
            this.N = z2;
            this.E = !z2;
            this.M = i4;
            if (z2) {
                a(resources, 1, 1, (Map<String, Object>) null);
            } else {
                a(resources, 800, 800, (Map<String, Object>) null);
            }
            Context context = this.t;
            context.isSDK = true;
            this.H = false;
            if (!z2) {
                s.b(context.lensBlurTexture, 1, 1);
            }
            c(i2, i3);
            if (z2) {
                n();
            }
            Context.backgroundColor = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
            a.a("end init");
            a.a.b.e.b.a("End of initRender, time = %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void a(Resources resources, Context context, int i2, boolean z2) {
        a.a.b.b.d dVar;
        a.a.b.b.d dVar2 = context.imageTexture;
        int i3 = dVar2.f12b;
        int i4 = dVar2.c;
        int max = Math.max(0, (int) (Math.log((double) i2) / Math.log(2.0d)));
        int i5 = 1;
        int max2 = Math.max(i3 >> max, 1);
        int max3 = Math.max(i4 >> max, 1);
        s.b(context.writableTexture, max2, max3);
        s.b(context.readableTexture, max2, max3);
        s.b(context.dehazeTexture, max2, max3);
        s.b(context.denoiseTexture, max2, max3);
        if (!z2) {
            float max4 = 1024.0f / ((float) Math.max(i3, i4));
            int floor = (int) Math.floor((double) (((float) i3) * max4));
            int floor2 = (int) Math.floor((double) (((float) i4) * max4));
            s.b(context.paintTexture, floor, floor2);
            s.b(context.intermediateTexture, floor, floor2);
        }
        GLES20.glDisable(3042);
        int[] iArr = context.textures;
        if (iArr == null || iArr.length <= 0) {
            dVar = context.imageTexture;
        } else {
            a((a.a.b.a.a.a) ba.a(resources, context), 0, context.readableTexture);
            dVar = context.readableTexture;
        }
        float[] fArr = new float[15];
        float f2 = 1.0f / ((float) 15);
        float f3 = 1.0f / ((float) i3);
        float f4 = 1.0f / ((float) i4);
        for (int i6 = 0; i6 <= 7; i6++) {
            float exp = (float) Math.exp((double) (((float) (-(i6 * i6))) * f2));
            fArr[7 - i6] = exp;
            fArr[i6 + 7] = exp;
        }
        af a2 = af.a(resources, context);
        a2.a("delta", (Object) Float.valueOf(f3));
        a2.r = fArr;
        e a3 = e.a(resources, context);
        a3.a("delta", (Object) Float.valueOf(f4));
        a3.r = fArr;
        a((a.a.b.a.a.a) a2, dVar.f11a, context.writableTexture);
        a((a.a.b.a.a.a) a3, context.writableTexture.f11a, context.denoiseTexture);
        if (z2) {
            i5 = 4;
        }
        a(context, resources, i5);
    }

    public void a(BrushItem brushItem) {
        if (this.r != 1.0f) {
            brushItem = brushItem.copy();
            brushItem.size /= this.r;
            brushItem.mosaicSize = Math.min(brushItem.mosaicSize, 3.0f);
        }
        r rVar = this.x;
        Context context = this.t;
        rVar.a(context, brushItem, context.writableTexture);
    }

    public void a(BrushItem brushItem, PointF pointF) {
        a.a.b.e.b.a("addBrushPathPoint::brushItem=%s::point", brushItem, pointF);
        if (brushItem != null) {
            if (brushItem.points == null) {
                brushItem.points = new ArrayList();
            }
            synchronized (brushItem.points) {
                r.a(brushItem, pointF, (float) this.t.paintTexture.f12b, (float) this.t.paintTexture.c);
            }
        }
    }

    public final void a(Context context, Resources resources, int i2) {
        g a2 = g.a(resources, context);
        a.a.b.a.r a3 = a.a.b.a.r.a(resources, context);
        an a4 = an.a(resources, context);
        a.a.b.a.f a5 = a.a.b.a.f.a(resources, context);
        p a6 = p.a(resources, context);
        w a7 = w.a(resources, context);
        aj a8 = aj.a(resources, context);
        a.a.b.b.d dVar = context.imageTexture;
        float f2 = (float) dVar.f12b;
        float f3 = (float) dVar.c;
        float min = Math.min(1.0f, (512.0f / ((float) i2)) / Math.max(f2, f3));
        int i3 = (int) (f2 * min);
        int i4 = (int) (f3 * min);
        s.b(context.writableTexture, i3, i4);
        s.b(context.readableTexture, i3, i4);
        s.b(this.I, i3, i4);
        s.b(this.J, i3, i4);
        s.b(this.K, i3, i4);
        a.a.b.b.d dVar2 = context.denoiseTexture;
        a(context, a3, a4, dVar2, this.K);
        a8.r = Context.overlayMesh;
        a((a.a.b.a.a.a) a8, dVar2.f11a, this.J);
        Context context2 = context;
        g gVar = a2;
        this.I = a(context2, gVar, dVar2, this.I, 8.0f, (Float) null);
        a.a.b.b.d dVar3 = this.J;
        this.J = a(context2, gVar, dVar3, dVar3, 8.0f, (Float) null);
        a.a.b.b.d dVar4 = this.K;
        this.K = a(context2, gVar, dVar4, dVar4, 48.0f, (Float) null);
        a6.r = this.I.f11a;
        a6.s = this.J.f11a;
        a6.t = this.K.f11a;
        a6.u = Context.overlayMesh;
        a((a.a.b.a.a.a) a6, 0, context.writableTexture);
        a.a.b.b.d dVar5 = context.writableTexture;
        a7.r = this.I.f11a;
        a7.s = this.K.f11a;
        a7.t = dVar5.f11a;
        a7.u = Context.overlayMesh;
        a((a.a.b.a.a.a) a7, 0, this.J);
        a.a.b.b.d dVar6 = this.J;
        Float valueOf = Float.valueOf(48.0f);
        a.a.b.b.d a9 = a(context2, gVar, dVar5, dVar5, 8.0f, valueOf);
        a.a.b.b.d a10 = a(context2, gVar, dVar6, dVar6, 8.0f, valueOf);
        a5.r = a9.f11a;
        a5.s = a10.f11a;
        a5.t = dVar2.f11a;
        a5.u = Context.overlayMesh;
        a((a.a.b.a.a.a) a5, 0, context.dehazeTexture);
    }

    public void a(MagicEraserPath magicEraserPath, int i2, int i3, int i4) {
        a.a.b.e.b.a("magicEraserPathOverLay::path=%s::outputTexture=%d::width=%d::height=%d", magicEraserPath, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.L == null) {
            Context context = this.t;
            this.L = new h(context.resources, context.shaderUtil);
            int i5 = i3;
            this.L.b(this.t.imageTexture.f11a, i3, i4, 0);
        } else {
            int i6 = i3;
            int i7 = i4;
        }
        this.L.a(this.t.intermediateTexture, i2, magicEraserPath, i3, i4, 0.0f, 0.0f, 1.0f);
    }

    public void a(String str) {
        a.a.b.e.b.a("fastUpdateFilter::filterID=%s", str);
        b(str, 1.0f);
    }

    public final void a(String str, float f2) {
        ak akVar = this.f27a;
        if (akVar != null) {
            if (!akVar.c(str)) {
                this.f27a.a(FilterPackageUtil.b(this.y.getAssets(), str));
            }
            this.f27a.a(f2);
        }
    }

    public void a(List<FaceItem> list, float f2) {
        a.a.b.e.b.a("updateFaces::faceItems=%s::faceAdjustIntensity=%f", list, Float.valueOf(f2));
        if (!list.isEmpty()) {
            k.a((float) this.u, (float) this.v, list, this.y, this.t);
        }
        this.t.renderStates.put("faces", list);
        if (this.O == null) {
            this.O = a.a.b.b.a.a(this.y, this.t.imageTexture, 300, 300);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            j.a(300, 300, this.O, list.get(i2), (Context.FaceFeaturesState) null, f2, false);
        }
    }

    public void a(List<DrawingItem> list, int i2) {
        a(list, i2, false, 0.0f, 0.0f, 0.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0081 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<co.polarr.renderer.entities.DrawingItem> r22, int r23, boolean r24, float r25, float r26, float r27) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            if (r1 == 0) goto L_0x0265
            boolean r3 = r22.isEmpty()
            if (r3 != 0) goto L_0x0265
            if (r2 > 0) goto L_0x0012
            goto L_0x0265
        L_0x0012:
            r3 = 2
            int[] r4 = new int[r3]
            r5 = 4096(0x1000, float:5.74E-42)
            r6 = 3553(0xde1, float:4.979E-42)
            r7 = 0
            android.opengl.GLES31.glGetTexLevelParameteriv(r6, r7, r5, r4, r7)
            r5 = 4097(0x1001, float:5.741E-42)
            r8 = 1
            android.opengl.GLES31.glGetTexLevelParameteriv(r6, r7, r5, r4, r8)
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = r22.toString()
            r5[r7] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r23)
            r5[r8] = r6
            r6 = r4[r7]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5[r3] = r6
            r3 = 3
            r4 = r4[r8]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5[r3] = r4
            java.lang.String r3 = "drawFiltersFrame::drawingItems=%s::outputTexture=%d::width=%d::height=%d"
            a.a.b.e.b.a(r3, r5)
            java.lang.String r3 = "start draw filter frame"
            a.a.b.a.a((java.lang.String) r3)
            r3 = 3089(0xc11, float:4.329E-42)
            boolean r4 = android.opengl.GLES20.glIsEnabled(r3)
            if (r4 == 0) goto L_0x0058
            android.opengl.GLES20.glDisable(r3)
        L_0x0058:
            java.lang.Object r5 = r1.get(r7)
            co.polarr.renderer.entities.DrawingItem r5 = (co.polarr.renderer.entities.DrawingItem) r5
            android.graphics.Rect r5 = r5.rect
            int r6 = r0.D
            r9 = -1
            r0.D = r9
            java.util.Iterator r9 = r22.iterator()
        L_0x0069:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0081
            java.lang.Object r10 = r9.next()
            co.polarr.renderer.entities.DrawingItem r10 = (co.polarr.renderer.entities.DrawingItem) r10
            android.graphics.Bitmap r10 = r10.thumbBitmap
            if (r10 == 0) goto L_0x007f
            boolean r10 = r10.isRecycled()
            if (r10 == 0) goto L_0x0069
        L_0x007f:
            r9 = r8
            goto L_0x0082
        L_0x0081:
            r9 = r7
        L_0x0082:
            int r10 = r0.u
            int r11 = r0.v
            boolean r12 = r0.d
            if (r12 == 0) goto L_0x00f1
            a.a.b.c r12 = r0.e
            if (r12 != 0) goto L_0x0099
            a.a.b.c r12 = new a.a.b.c
            android.content.res.Resources r13 = r0.y
            co.polarr.renderer.entities.Context r14 = r0.t
            r12.<init>(r13, r14)
            r0.e = r12
        L_0x0099:
            if (r9 == 0) goto L_0x00ad
            co.polarr.renderer.entities.Context r9 = r0.t
            boolean r9 = r9.isOES
            if (r9 == 0) goto L_0x00ad
            a.a.b.a.ah r9 = r0.f28b
            float[] r9 = r9.getMatrix()
            android.opengl.Matrix.setIdentityM(r9, r7)
            a.a.b.a.ah r9 = r0.f28b
            goto L_0x00c8
        L_0x00ad:
            co.polarr.renderer.filters.Basic r9 = r0.c
            if (r9 != 0) goto L_0x00c1
            co.polarr.renderer.filters.Basic r9 = new co.polarr.renderer.filters.Basic
            android.content.res.Resources r12 = r0.y
            co.polarr.renderer.entities.Context r13 = r0.t
            r9.<init>(r12, r13)
            r0.c = r9
            co.polarr.renderer.filters.Basic r9 = r0.c
            r9.a()
        L_0x00c1:
            co.polarr.renderer.filters.Basic r9 = r0.c
            r9.setNeedClear(r8)
            co.polarr.renderer.filters.Basic r9 = r0.c
        L_0x00c8:
            int r12 = r0.C
            co.polarr.renderer.entities.Context r13 = r0.t
            a.a.b.b.d r13 = r13.writableTexture
            r0.a((a.a.b.a.a.a) r9, (int) r12, (a.a.b.b.d) r13)
            a.a.b.c r9 = r0.e
            co.polarr.renderer.entities.Context r12 = r0.t
            a.a.b.b.d r12 = r12.writableTexture
            int r13 = r5.width()
            int r14 = r5.height()
            a.a.b.b.d r9 = r9.a((a.a.b.b.d) r12, (int) r13, (int) r14)
            int r9 = r9.f11a
            int r12 = r5.width()
            int r13 = r5.height()
            r0.c(r12, r13)
            goto L_0x012b
        L_0x00f1:
            a.a.b.c r12 = r0.e
            if (r12 == 0) goto L_0x00fb
            r12.close()
            r12 = 0
            r0.e = r12
        L_0x00fb:
            int r12 = r5.width()
            int r13 = r5.height()
            r0.c(r12, r13)
            if (r9 == 0) goto L_0x0129
            co.polarr.renderer.entities.Context r9 = r0.t
            boolean r9 = r9.isOES
            if (r9 == 0) goto L_0x0129
            a.a.b.a.ah r9 = r0.f28b
            float[] r9 = r9.getMatrix()
            android.opengl.Matrix.setIdentityM(r9, r7)
            a.a.b.a.ah r9 = r0.f28b
            int r12 = r0.C
            co.polarr.renderer.entities.Context r13 = r0.t
            a.a.b.b.d r13 = r13.writableTexture
            r0.a((a.a.b.a.a.a) r9, (int) r12, (a.a.b.b.d) r13)
            co.polarr.renderer.entities.Context r9 = r0.t
            a.a.b.b.d r9 = r9.writableTexture
            int r9 = r9.f11a
            goto L_0x012b
        L_0x0129:
            int r9 = r0.C
        L_0x012b:
            a.a.b.a.ak r12 = r0.f27a
            float[] r12 = r12.getMatrix()
            android.opengl.Matrix.setIdentityM(r12, r7)
            a.a.b.a.ak r12 = r0.f27a
            float[] r12 = r12.getMatrix()
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            android.opengl.Matrix.scaleM(r12, r7, r14, r14, r13)
            a.a.b.a.a.c r12 = r0.z
            r12.b(r2)
            a.a.b.a.a.c r2 = r0.z
            int r12 = r5.width()
            int r5 = r5.height()
            r2.b((int) r12, (int) r5)
            a.a.b.a.a.c r2 = r0.z
            r2.p()
            a.a.b.a.ak r2 = r0.f27a
            r2.K = r7
            java.util.Iterator r1 = r22.iterator()
        L_0x0160:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x024e
            java.lang.Object r2 = r1.next()
            co.polarr.renderer.entities.DrawingItem r2 = (co.polarr.renderer.entities.DrawingItem) r2
            android.graphics.Bitmap r5 = r2.thumbBitmap
            if (r5 == 0) goto L_0x0185
            boolean r5 = r5.isRecycled()
            if (r5 == 0) goto L_0x0177
            goto L_0x0185
        L_0x0177:
            a.a.b.a.ak r5 = r0.f27a
            a.a.b.e.n r12 = r0.n
            android.graphics.Bitmap r13 = r2.thumbBitmap
            int r12 = r12.a((android.graphics.Bitmap) r13)
            r5.a((int) r12)
            goto L_0x018a
        L_0x0185:
            a.a.b.a.ak r5 = r0.f27a
            r5.a((int) r9)
        L_0x018a:
            java.lang.String r5 = r2.filterId
            float r12 = r2.intensity
            r0.b((java.lang.String) r5, (float) r12)
            android.graphics.Rect r5 = r2.rect
            int r12 = r5.left
            int r13 = r5.top
            int r5 = r5.width()
            android.graphics.Rect r14 = r2.rect
            int r14 = r14.height()
            android.opengl.GLES20.glViewport(r12, r13, r5, r14)
            android.graphics.Rect r5 = r2.rect
            int r5 = r5.width()
            android.graphics.Rect r12 = r2.rect
            int r12 = r12.height()
            if (r5 > r12) goto L_0x01b9
            android.graphics.Rect r5 = r2.rect
            int r5 = r5.width()
            goto L_0x01bf
        L_0x01b9:
            android.graphics.Rect r5 = r2.rect
            int r5 = r5.height()
        L_0x01bf:
            float r5 = (float) r5
            android.graphics.Rect r12 = r2.rect
            int r12 = r12.width()
            float r12 = (float) r12
            android.graphics.Rect r13 = r2.rect
            int r13 = r13.height()
            float r13 = (float) r13
            a.a.b.a.ak r14 = r0.f27a
            float r16 = r5 * r25
            float r17 = r26 * r12
            float r18 = r27 * r13
            android.graphics.Rect r5 = r2.rect
            int r5 = r5.width()
            float r5 = (float) r5
            android.graphics.Rect r12 = r2.rect
            int r12 = r12.height()
            float r12 = (float) r12
            r15 = r24
            r19 = r5
            r20 = r12
            r14.a(r15, r16, r17, r18, r19, r20)
            android.graphics.Bitmap r5 = r2.overlayBitmap
            if (r5 == 0) goto L_0x0160
            boolean r5 = r5.isRecycled()
            if (r5 == 0) goto L_0x01f9
            goto L_0x0160
        L_0x01f9:
            android.graphics.Bitmap r5 = r2.overlayBitmap
            int r5 = r5.getWidth()
            android.graphics.Bitmap r12 = r2.overlayBitmap
            int r12 = r12.getHeight()
            co.polarr.renderer.filters.Basic r13 = r0.c
            if (r13 != 0) goto L_0x0219
            co.polarr.renderer.filters.Basic r13 = new co.polarr.renderer.filters.Basic
            android.content.res.Resources r14 = r0.y
            co.polarr.renderer.entities.Context r15 = r0.t
            r13.<init>(r14, r15)
            r0.c = r13
            co.polarr.renderer.filters.Basic r13 = r0.c
            r13.a()
        L_0x0219:
            co.polarr.renderer.filters.Basic r13 = r0.c
            r13.setNeedClear(r7)
            co.polarr.renderer.filters.Basic r13 = r0.c
            a.a.b.e.n r14 = r0.o
            android.graphics.Bitmap r15 = r2.overlayBitmap
            int r14 = r14.a((android.graphics.Bitmap) r15)
            r13.a((int) r14)
            android.graphics.Rect r13 = r2.rect
            int r14 = r13.left
            int r15 = r2.overlayLeft
            int r14 = r14 + r15
            int r13 = r13.top
            int r2 = r2.overlayTop
            int r13 = r13 + r2
            android.opengl.GLES20.glViewport(r14, r13, r5, r12)
            r2 = 3042(0xbe2, float:4.263E-42)
            android.opengl.GLES20.glEnable(r2)
            r5 = 771(0x303, float:1.08E-42)
            android.opengl.GLES20.glBlendFunc(r8, r5)
            co.polarr.renderer.filters.Basic r5 = r0.c
            r5.draw()
            android.opengl.GLES20.glDisable(r2)
            goto L_0x0160
        L_0x024e:
            a.a.b.a.a.c r1 = r0.z
            r1.m()
            r0.D = r6
            r0.c(r10, r11)
            android.opengl.GLES20.glGetError()
            if (r4 == 0) goto L_0x0260
            android.opengl.GLES20.glEnable(r3)
        L_0x0260:
            java.lang.String r1 = "end draw filter frame"
            a.a.b.a.a((java.lang.String) r1)
        L_0x0265:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.d.a(java.util.List, int, boolean, float, float, float):void");
    }

    public void a(Map<String, Object> map) {
        a(map, true, true);
    }

    public void a(Map<String, Object> map, int i2, float f2, boolean z2) {
        Map<String, Object> map2 = map;
        int i3 = i2;
        a.a("start auto enhance face");
        if (map2 != null) {
            a.a.b.e.b.a("autoEnhanceFace::faceStates=%s::faceIndex=%d::percent=%f::needReduceGlobal=%b", map2, Integer.valueOf(i2), Float.valueOf(f2), Boolean.valueOf(z2));
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            List list = (List) map2.get("faces");
            List list2 = (List) map2.get("face_features");
            if (list != null && list2 != null && !list.isEmpty() && !list2.isEmpty()) {
                if (this.O == null) {
                    this.O = a.a.b.b.a.a(this.y, this.t.imageTexture, 300, 300);
                }
                if (i3 == -1) {
                    int min = Math.min(list.size(), list2.size());
                    for (int i4 = 0; i4 < min; i4++) {
                        j.a(300, 300, this.O, (FaceItem) list.get(i4), (Context.FaceFeaturesState) list2.get(i4), f2, z2);
                    }
                } else if (list.size() > i3 && list2.size() > i3) {
                    j.a(300, 300, this.O, (FaceItem) list.get(i3), (Context.FaceFeaturesState) list2.get(i3), f2, z2);
                }
            }
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            a.a("end auto enhance face");
        }
    }

    public final void a(Map<String, Object> map, boolean z2, boolean z3) {
        a.a.b.a.a.d dVar;
        a.a.b.e.b.a("updateStates::renderStates=%s::needUpdateFilter=%b::fastUpdate=%b", map == null ? "null" : map.toString(), Boolean.valueOf(z2), Boolean.valueOf(z3));
        if (!z3) {
            Object obj = this.t.renderStates.get("prevFaces");
            Object obj2 = this.t.renderStates.get("prevFaceFeatures");
            f.a(this.t.renderStates);
            ak akVar = this.f27a;
            if (akVar != null) {
                akVar.t();
            }
            if (map != null) {
                for (String next : map.keySet()) {
                    Object a2 = t.a(next, map.get(next));
                    if (next.equals("lut_id")) {
                        b((String) map.get(next), ((Float) t.a("lookup_intensity", map.get("lookup_intensity"))).floatValue());
                    } else {
                        this.t.renderStates.put(next, a2);
                    }
                }
            }
            this.t.renderStates.remove("prevFaceFeatures");
            this.t.renderStates.remove("prevFaces");
            this.t.renderStates.remove("prevBrushes");
            this.t.renderStates.remove("zPrevSpots");
            this.t.renderStates.put("prevFaces", obj);
            this.t.renderStates.put("prevFaceFeatures", obj2);
            if (map != null) {
                if (!this.t.isSDK && map.containsKey("distortion_mesh")) {
                    a.a.b.e.d.a(this.t, (float[]) this.t.renderStates.get("distortion_mesh"));
                }
                if (z2) {
                    for (String next2 : this.t.renderStates.keySet()) {
                        f.a((List<? extends a.a.b.a.a.a>) this.s.p(), next2, this.t.renderStates.get(next2));
                    }
                }
            }
            x();
        } else {
            this.t.renderStates.putAll(map);
            if (z2 && (dVar = this.s) != null) {
                bl blVar = (bl) f.a((List<? extends a.a.b.a.a.a>) dVar.p(), bl.class);
                bm bmVar = (bm) f.a((List<? extends a.a.b.a.a.a>) this.s.p(), bm.class);
                if (!(blVar == null || bmVar == null || (blVar.a(map) && bmVar.a(map)))) {
                    for (String next3 : map.keySet()) {
                        f.a((List<? extends a.a.b.a.a.a>) this.s.p(), next3, this.t.renderStates.get(next3));
                    }
                    blVar.b(map);
                    bmVar.b(map);
                }
            }
        }
        a.a("do update states");
    }

    public final void a(boolean z2) {
        a((android.content.Context) null, z2);
        if (this.G) {
            Basic a2 = Basic.a(this.y, this.t);
            a2.a(this.t.readableTexture.f11a);
            Matrix.setIdentityM(a2.getMatrix(), 0);
            o.a(a2.getMatrix(), false, true);
            a2.draw();
        }
    }

    public boolean a(int[] iArr) {
        int[] iArr2 = this.t.textures;
        boolean z2 = false;
        if (iArr2 != null && iArr2.length == 4) {
            int length = iArr2.length;
            int i2 = 0;
            boolean z3 = true;
            int i3 = 0;
            while (i3 < length) {
                if (iArr2[i3] != iArr[i2]) {
                    z3 = false;
                }
                i3++;
                i2++;
            }
            z2 = z3;
        }
        if (!z2) {
            this.t.textures = iArr;
        }
        this.C = -1;
        return z2;
    }

    public void b() {
        this.n.a();
        this.o.a();
    }

    public void b(float f2) {
        a.a.b.e.b.a("setFilterIntensity::intensity=%f", Float.valueOf(f2));
        ak akVar = this.f27a;
        if (akVar != null && !akVar.q()) {
            this.f27a.a(f2);
        }
    }

    public void b(int i2) {
        a.a.b.e.b.a("setInputTexture::inputTexture=%d", Integer.valueOf(i2));
        a.a("start set input");
        this.C = i2;
        this.t.textures = null;
        this.R = false;
        a.a("end set input");
    }

    public void b(int i2, int i3) {
        int i4 = i2 * i2;
        Context context = Context.LutContext;
        a.a.b.b.d dVar = context.imageTexture;
        dVar.f12b = i4;
        dVar.c = i2;
        context.renderStates = this.t.renderStates;
        this.s.a(context);
        this.s.b(i4, i2);
        this.s.a(i3);
        this.s.v();
        this.s.n();
        this.s.o();
        a((a.a.b.a.a.a) Basic.a(this.y, this.t), this.s.q(), i3, i4, i2);
        this.s.a(this.t);
        this.s.b(this.u, this.v);
    }

    public void b(BrushItem brushItem) {
        a.a.b.e.b.a("updateBrushPoints::brushItem=%s", brushItem);
        if (brushItem != null) {
            if (brushItem.points == null) {
                brushItem.points = new ArrayList();
            }
            synchronized (brushItem.points) {
                r.a(brushItem.touchPoints, brushItem, (float) this.t.paintTexture.f12b, (float) this.t.paintTexture.c);
            }
        }
    }

    public void b(String str) {
        a.a.b.e.b.a("updateStates::stateString=%s", str);
        a.a("start update states json");
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        b(a.a.b.e.c.a(str));
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        a.a("end update states json");
    }

    public void b(String str, float f2) {
        a.a.b.e.b.a("fastUpdateFilter::filterID=%s::filterIntensity=%f", str, Float.valueOf(f2));
        String[] a2 = FilterPackageUtil.a(this.y.getAssets(), str);
        if (a2 != null) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : a2) {
                LutItem lutItem = new LutItem();
                lutItem.filterId = str2;
                lutItem.intensity = 1.0f;
                arrayList.add(lutItem);
            }
            if (f2 >= 0.3f) {
                ((LutItem) arrayList.get(0)).intensity = (f2 - 0.3f) / 0.7f;
                ((LutItem) arrayList.get(1)).intensity = 1.0f;
            } else {
                ((LutItem) arrayList.get(0)).intensity = 0.0f;
                ((LutItem) arrayList.get(1)).intensity = f2 / 0.3f;
            }
            b((List<LutItem>) arrayList);
            return;
        }
        a(str, f2);
    }

    public void b(List<LutItem> list) {
        a.a.b.b.d o2 = this.f27a.o();
        a.a.b.b.d p2 = this.f27a.p();
        this.f27a.m();
        ak akVar = this.f27a;
        float f2 = akVar.M;
        akVar.M = 0.0f;
        for (LutItem next : list) {
            if (next != null && !TextUtils.isEmpty(next.filterId)) {
                a(next.filterId, next.intensity);
                this.z.a((a.a.b.a.a.a) this.f27a);
                this.z.b(p2.f11a);
                this.z.b(o2.f12b, o2.c);
                this.z.a(o2.f11a);
                this.z.draw();
                s.a(o2, p2);
            }
        }
        ak akVar2 = this.f27a;
        akVar2.M = f2;
        akVar2.c("COMBAIN_FILTER");
        this.f27a.a(1.0f);
    }

    public void b(Map<String, Object> map) {
        String str;
        if (map != null) {
            a.a.b.e.b.a("updateStates::renderStates=%s", map.toString());
            a.a("start update states");
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            if (this.N) {
                a(map);
                str = "end fast update states";
            } else {
                a(map, true, false);
                GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
                str = "end update states";
            }
            a.a(str);
        }
    }

    public void b(boolean z2) {
        this.d = z2;
    }

    public void c() {
        a.a.b.e.b.a("createInputTexture", new Object[0]);
        a.a("start create input");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.C = iArr[0];
        a.a.b.b.g.c(this.C);
        GLES20.glBindTexture(3553, this.C);
        s.b();
        this.R = true;
        a.a("end create input");
    }

    public void c(float f2) {
        ak akVar = this.f27a;
        if (akVar != null) {
            akVar.B = f2 != 0.0f;
            this.f27a.M = f2;
        }
    }

    public void c(int i2) {
        a.a("start set output");
        a.a.b.e.b.a("setOutputTexture::outTexture=%d", Integer.valueOf(i2));
        this.D = i2;
        a.a("end set output");
    }

    public void c(int i2, int i3) {
        a.a.b.e.b.a("updateSize::width=%d::height=%d", Integer.valueOf(i2), Integer.valueOf(i3));
        a.a("start update size");
        this.u = i2;
        this.v = i3;
        s.b(this.t.imageTexture, this.u, this.v);
        if (!this.N) {
            a.a.b.a.a.d dVar = this.s;
            if (dVar != null) {
                dVar.b(this.u, this.v);
            }
            for (a.a.b.a.a.a next : this.w) {
                next.a();
                next.b(this.u, this.v);
            }
        }
        a.a.b.b.g.d(this.t);
        a.a.b.b.g.e(this.t);
        a.a.b.b.g.a(this.t, (float) this.u, (float) this.v, this.H, true, (float[]) null);
        a.a("end update size");
    }

    public void c(boolean z2) {
        a.a.b.e.b.a("enableRealTimeAutoEnhancement::isEnable=%b", Boolean.valueOf(z2));
        this.E = !z2;
        this.F = z2;
        if (this.F && !this.N) {
            if (this.f28b == null) {
                this.f28b = new ah(this.y, this.t);
                this.f28b.a();
            }
            if (this.f27a == null) {
                this.f27a = new ak(this.y, this.t);
                this.f27a.a();
            }
            n();
        }
        if (this.F && this.j == null) {
            HandlerThread handlerThread = new HandlerThread("PO_AE_THEREAD");
            handlerThread.start();
            this.j = new Handler(handlerThread.getLooper());
        }
        if (!this.E) {
            s.b(this.t.dehazeTexture, 1, 1);
        }
    }

    public final void d() {
        if (!this.N && this.M == 1) {
            if (this.f == null) {
                this.f = new b();
                this.f.a();
            }
            int i2 = this.C;
            if (i2 >= 0) {
                this.f.a(i2);
                this.z.b(this.t.imageTexture.f11a);
                this.z.b(this.u, this.v);
                this.z.p();
                this.f.a((SurfaceTexture) null, (float[]) null);
                this.z.m();
            }
        } else if (this.N || this.C < 0) {
            Matrix.setIdentityM(this.f28b.getMatrix(), 0);
            a((a.a.b.a.a.a) this.f28b, this.C, this.t.imageTexture);
        } else {
            this.z.b(this.t.imageTexture.f11a);
            a.a.b.b.d dVar = this.t.imageTexture;
            int i3 = this.u;
            dVar.f12b = i3;
            int i4 = this.v;
            dVar.c = i4;
            this.z.b(i3, i4);
            this.z.p();
            Basic a2 = Basic.a(this.y, this.t);
            a2.a(this.C);
            a2.draw();
            this.z.m();
            this.x.c(this.t.imageTexture);
        }
    }

    public void d(boolean z2) {
        a.a.b.e.b.a("autoEnhanceGlobal::isEnable=%b", Boolean.valueOf(z2));
        this.h = z2;
        if (this.h) {
            this.g = 2;
        } else {
            e(false);
        }
    }

    public void e() {
        a.a.b.e.b.a("drawFrame", new Object[0]);
        a.a("start draw frame");
        boolean glIsEnabled = GLES20.glIsEnabled(3089);
        if (glIsEnabled) {
            GLES20.glDisable(3089);
        }
        if (this.N || this.F) {
            if (this.h) {
                if (this.g >= 1) {
                    a aVar = new a(v());
                    if (this.g > 1) {
                        aVar.run();
                    } else if (!this.l) {
                        this.j.post(aVar);
                    }
                }
                synchronized (this.i) {
                    if (!this.i.isEmpty()) {
                        b(this.i);
                        e(true);
                        this.i.clear();
                    }
                }
                this.g--;
                if (this.g <= 0) {
                    this.g = 1;
                }
            }
            g();
        } else if (this.M == 1) {
            a(false);
        } else {
            GLES20.glGetError();
            int[] iArr = new int[4];
            GLES20.glGetIntegerv(2978, iArr, 0);
            a((android.content.Context) null, false);
            if (this.G) {
                Basic a2 = Basic.a(this.y, this.t);
                a2.a(this.t.readableTexture.f11a);
                Matrix.setIdentityM(a2.getMatrix(), 0);
                a2.draw();
            }
            GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
            if (glIsEnabled) {
                GLES20.glEnable(3089);
            }
            a.a("end draw frame");
        }
    }

    public void e(boolean z2) {
        ak akVar = this.f27a;
        if (akVar == null) {
            return;
        }
        if (z2) {
            a.a.b.b.d n2 = akVar.n();
            b(n2.c, n2.f11a);
            this.f27a.c("AUTO_ENHANCE_FILTER");
            return;
        }
        akVar.c(FilterPackageUtil.F_DEFAULT);
    }

    public void f() {
        this.f27a.L = true;
        e();
        this.f27a.L = false;
    }

    public void f(boolean z2) {
        this.G = z2;
    }

    public final void g() {
        int i2;
        int i3;
        ak akVar;
        a.a.b.b.d dVar;
        a.a.b.e.b.a("fastDrawFrame", new Object[0]);
        ak akVar2 = this.f27a;
        if (akVar2 != null) {
            akVar2.K = true;
            Matrix.setIdentityM(akVar2.getMatrix(), 0);
            Context context = this.t;
            if (context.isOES) {
                Matrix.scaleM(this.f27a.getMatrix(), 0, -1.0f, -1.0f, 1.0f);
                if (this.D > 0) {
                    a((a.a.b.a.a.a) this.f28b, this.C, this.t.readableTexture);
                    akVar = this.f27a;
                    dVar = this.t.readableTexture;
                    i3 = dVar.f11a;
                    i2 = this.D;
                } else {
                    Context context2 = this.t;
                    a.a.b.b.d dVar2 = context2.imageTexture;
                    a.a.b.b.d dVar3 = context2.writableTexture;
                    List list = (List) context2.renderStates.get("faces");
                    if (!(this.m == null || list == null || list.isEmpty())) {
                        a.a.b.b.d dVar4 = dVar3;
                        a.a.b.b.d dVar5 = dVar2;
                        for (int i4 = 0; i4 < list.size(); i4++) {
                            a.a.b.b.f fVar = this.t.faceMasks[i4];
                            Context.FaceState faceState = ((FaceItem) list.get(i4)).adjustments;
                            if (faceState != null) {
                                bj bjVar = this.m;
                                bjVar.r = fVar;
                                bjVar.s = faceState;
                                a((a.a.b.a.a.a) bjVar, dVar5.f11a, dVar4);
                                a.a.b.b.d dVar6 = dVar4;
                                dVar4 = dVar5;
                                dVar5 = dVar6;
                            }
                        }
                        dVar2 = dVar5;
                    }
                    a((a.a.b.a.a.a) this.f27a, dVar2.f11a, this.t.readableTexture);
                }
            } else {
                i2 = this.D;
                if (i2 > 0) {
                    akVar = this.f27a;
                    i3 = this.C;
                    dVar = context.readableTexture;
                } else {
                    a((a.a.b.a.a.a) this.f27a, this.C, context.readableTexture);
                }
            }
            a((a.a.b.a.a.a) akVar, i3, i2, dVar.f12b, dVar.c);
        }
        if (this.G) {
            Basic a2 = Basic.a(this.y, this.t);
            a2.a(this.t.readableTexture.f11a);
            Matrix.setIdentityM(a2.getMatrix(), 0);
            a2.draw();
        }
    }

    public void g(boolean z2) {
        this.H = z2;
    }

    public final void h() {
        d();
        GLES20.glGetError();
        a.a("fast update texture");
        if (this.E) {
            a(this.y, this.t, 2, false);
            s.b(this.t.readableTexture, this.u, this.v);
            s.b(this.t.writableTexture, this.u, this.v);
            a.a("update texture for maps");
        }
        Context context = this.t;
        Basic.a(context.resources, context);
    }

    public void i() {
        ak akVar = this.f27a;
        if (akVar != null) {
            akVar.c("COMBAIN_FILTER");
            this.f27a.a(1.0f);
        }
    }

    public int j() {
        return this.x.c().f11a;
    }

    public ak k() {
        return this.f27a;
    }

    public int l() {
        a.a.b.e.b.a("getOutputId", new Object[0]);
        int i2 = this.D;
        return i2 > 0 ? i2 : this.t.readableTexture.f11a;
    }

    public int m() {
        a.a.b.e.b.a("getTextureId", new Object[0]);
        return this.C;
    }

    @Deprecated
    public void n() {
        a.a.b.e.b.a("initAllFilters", new Object[0]);
        ak akVar = this.f27a;
        if (akVar != null) {
            akVar.l();
            this.f27a.m();
            if (!this.f27a.c(FilterPackageUtil.F_DEFAULT)) {
                this.f27a.a(FilterPackageUtil.b(this.y.getAssets(), FilterPackageUtil.F_DEFAULT));
            }
        }
    }

    public void o() {
        a.a.b.e.b.a("release", new Object[0]);
        a.a("start release");
        r();
        t();
        a.a("end release");
    }

    public final void p() {
        Basic.l();
        be.l();
        bd.l();
        y.l();
        bb.l();
        bj.l();
        bi.l();
        a.a.b.a.o.l();
        ay.l();
        a.a.b.a.a.l();
        bg.l();
        l.l();
        v.l();
        ap.l();
        bo.n();
        at.l();
        az.k();
        ai.k();
        aa.l();
        m.l();
        aq.l();
        ba.l();
        g.l();
        a.a.b.a.r.l();
        an.l();
        a.a.b.a.f.l();
        p.l();
        w.l();
        aj.l();
        af.l();
        e.l();
        a.a.b.a.t.l();
        c.l();
        av.l();
        ao.l();
        i.l();
        a.a.b.a.s.l();
        aw.l();
    }

    public final void q() {
        Map<String, a.a.b.b.d> map;
        Context context = this.t;
        if (!(context == null || (map = context.brushes) == null)) {
            for (a.a.b.b.d a2 : map.values()) {
                a.a(a2);
            }
        }
        Context context2 = this.t;
        if (context2 != null) {
            context2.brushes = null;
        }
    }

    public void r() {
        a.a.b.e.b.a("releaseGLRes", new Object[0]);
        a.a("start release gl");
        c cVar = this.e;
        if (cVar != null) {
            cVar.close();
            this.e = null;
        }
        this.n.a();
        this.o.a();
        a.a.b.a.a.d dVar = this.s;
        if (dVar != null) {
            bl blVar = (bl) f.a((List<? extends a.a.b.a.a.a>) dVar.p(), bl.class);
            bm bmVar = (bm) f.a((List<? extends a.a.b.a.a.a>) this.s.p(), bm.class);
            if (blVar != null) {
                blVar.m();
            }
            a.a("releaseGLRes filter1");
            if (bmVar != null) {
                bmVar.m();
            }
            a.a("releaseGLRes filter2");
            this.s.t();
            a.a("releaseGLRes filter3");
        }
        c.a(this.t).q();
        a.a.b.b.f[] fVarArr = this.t.faceMasks;
        if (fVarArr != null) {
            for (a.a.b.b.f a2 : fVarArr) {
                a.a((a.a.b.b.d) a2);
            }
        }
        List<a.a.b.b.d> list = this.t.textLayers;
        if (list != null) {
            for (a.a.b.b.d a3 : list) {
                a.a(a3);
            }
        }
        int[] iArr = this.t.textures;
        if (iArr != null) {
            for (int a4 : iArr) {
                s.a(a4);
            }
        }
        a.a.b.b.d[] dVarArr = this.t.brushTextures;
        if (dVarArr != null) {
            for (a.a.b.b.d a5 : dVarArr) {
                a.a(a5);
            }
        }
        a.a(this.I);
        a.a(this.J);
        a.a(this.K);
        a.a(this.t.imageTexture);
        a.a(this.t.dehazeTexture);
        a.a(this.t.denoiseTexture);
        a.a(this.t.cacheTexture);
        if (!this.N || this.D <= 0) {
            a.a(this.t.readableTexture);
        }
        a.a(this.t.writableTexture);
        a.a(this.t.paintTexture);
        a.a(this.t.retouchTexture);
        a.a(this.t.lensBlurTexture);
        a.a(this.t.intermediateTexture);
        a.a(this.t.grainTexture);
        a.a(this.t.overlayTexture);
        u();
        a.a("releaseGLRes pattern");
        q();
        a.a("releaseGLRes brushes");
        s();
        h hVar = this.L;
        if (hVar != null) {
            hVar.a();
        }
        a.a("releaseGLRes patch");
        r rVar = this.x;
        if (rVar != null) {
            rVar.e();
        }
        a.a("releaseGLRes brush");
        a.a.b.b.g.b();
        a.a("releaseGLRes render");
        GLES20.glFlush();
        this.t.shaderUtil.a();
        a.a("end release gl");
    }

    public void s() {
        int i2;
        if (this.R && (i2 = this.C) >= 0) {
            s.a(i2);
            a.a.b.b.g.e(this.C);
        }
        this.C = -1;
    }

    public void t() {
        a.a.b.e.b.a("releaseNonGLRes", new Object[0]);
        a.a("start release non-gl");
        this.O = null;
        this.P = null;
        this.Q = null;
        p();
        h hVar = this.L;
        if (hVar != null) {
            hVar.b();
        }
        a.a("end release non-gl");
    }

    public final void u() {
        Map<String, a.a.b.b.d> map;
        Context context = this.t;
        if (!(context == null || (map = context.patterns) == null)) {
            for (a.a.b.b.d a2 : map.values()) {
                a.a(a2);
            }
        }
        Context context2 = this.t;
        if (context2 != null) {
            context2.patterns = null;
        }
    }

    public final byte[] v() {
        s.b(this.t.intermediateTexture, 300, 300);
        if (this.k == null) {
            this.k = ByteBuffer.allocate(360000);
        }
        c a2 = c.a((Context) null);
        a2.b(this.t.intermediateTexture.f11a);
        a2.b(300, 300);
        a2.p();
        Basic instance = Basic.getInstance(this.y);
        instance.setInputTextureId(this.t.imageTexture.f11a);
        instance.draw();
        GLES20.glReadPixels(0, 0, 300, 300, 6408, 5121, this.k);
        a2.m();
        byte[] array = this.k.array();
        this.k.rewind();
        return array;
    }

    public void w() {
        a.a.b.e.b.a("updateInputTexture", new Object[0]);
        a.a("start update input");
        boolean glIsEnabled = GLES20.glIsEnabled(3089);
        if (glIsEnabled) {
            GLES20.glDisable(3089);
        }
        this.O = null;
        this.P = null;
        this.Q = null;
        if (this.N || this.F) {
            h();
            return;
        }
        int[] iArr = new int[4];
        GLES20.glGetIntegerv(2978, iArr, 0);
        d();
        GLES20.glGetError();
        a.a("updated input texture");
        this.t.renderStates.remove("prevFaces");
        this.t.renderStates.remove("prevFaceFeatures");
        if (this.E) {
            a(this.y, this.t, 2, false);
            a.a.b.b.g.a(this.t, (float) this.u, (float) this.v, this.H, true, (float[]) null);
            a.a("input render maps");
            x();
            a.a("input update others");
        }
        GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
        if (glIsEnabled) {
            GLES20.glEnable(3089);
        }
        a.a("end update input");
    }

    public final void x() {
        if (this.t.renderStates.containsKey("faces")) {
            k.a((List<FaceItem>) (List) this.t.renderStates.get("faces"), this.y, this.t);
            if (this.t.renderStates.containsKey("face_features")) {
                Context context = this.t;
                a.a.b.e.d.a(context, (List<Context.FaceFeaturesState>) (List) context.renderStates.get("face_features"));
            }
        }
    }
}
