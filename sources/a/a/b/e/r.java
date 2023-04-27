package a.a.b.e;

import a.a.b.a.a.a;
import a.a.b.a.a.c;
import a.a.b.a.ai;
import a.a.b.a.ao;
import a.a.b.a.aw;
import a.a.b.a.ax;
import a.a.b.a.bf;
import a.a.b.a.i;
import a.a.b.a.s;
import a.a.b.a.z;
import a.a.b.b.d;
import a.a.b.b.g;
import android.content.res.Resources;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.LruCache;
import co.polarr.renderer.entities.Adjustment;
import co.polarr.renderer.entities.BrushItem;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.filters.Basic;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import java.util.ArrayList;
import java.util.List;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public static LruCache<String, List<Float>> f75a = new LruCache<>(100);

    /* renamed from: b  reason: collision with root package name */
    public static final float[][] f76b = {new float[]{1.0f, 0.0f, 0.0f, 0.0f}, new float[]{0.0f, 1.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.0f, 1.0f, 0.0f}, new float[]{0.0f, 0.0f, 0.0f, 1.0f}};
    public static float c = 255.0f;
    public final z d;
    public final ax e;
    public final c f;
    public final d g;
    public final d h;
    public final d i;
    public final d j;
    public final d k;
    public final aw l;
    public final ao m;
    public final s n;
    public final i o;
    public d p;
    public final Resources q;
    public final bf r;
    public BrushItem s = new BrushItem();
    public d t;
    public d u;
    public d v;
    public float w;
    public float x = (c * 0.5f);

    public r(Context context, Resources resources) {
        this.q = resources;
        this.d = new z(context, resources);
        this.e = new ax(context, resources);
        this.f = c.a(context);
        this.r = new bf(resources, context);
        this.r.a();
        int[] iArr = new int[5];
        s.a(iArr.length, iArr, 0, 6408, 1, 1);
        this.g = s.b(iArr[0], 6408, 1, 1);
        this.h = s.b(iArr[1], 6408, 1, 1);
        GLES20.glBindTexture(3553, this.h.f11a);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glBindTexture(3553, 0);
        this.j = s.b(iArr[2], 6408, 1, 1);
        this.i = s.b(iArr[3], 6408, 1, 1);
        this.k = s.b(iArr[4], 6408, 1, 1);
        this.m = ao.a(resources, context);
        this.n = s.a(resources, context);
        this.o = i.a(resources, context);
        this.l = aw.a(resources, context);
    }

    public static double a(double d2) {
        return ((a.a(d2) / 10.0d) * 9.0d) + 1.0d;
    }

    public static List<Float> a(BrushItem brushItem, PointF pointF, float f2, float f3) {
        float[] fArr;
        float[] fArr2;
        BrushItem brushItem2 = brushItem;
        PointF pointF2 = pointF;
        float f4 = brushItem2.size * c;
        float f5 = brushItem2.spacing;
        int i2 = 4;
        float[] fArr3 = new float[4];
        float[] fArr4 = {1.0f / f2, 1.0f / f3};
        float[] fArr5 = {pointF2.x * f2, pointF2.y * f3, 0.5f};
        ArrayList arrayList = new ArrayList();
        if (brushItem2.prevPoint == null) {
            brushItem2.prevPoint = new float[]{fArr5[0], fArr5[1], fArr5[2]};
            if (!"paint".equals(brushItem2.mode)) {
                fArr5[0] = fArr5[0] * fArr4[0];
                fArr5[1] = fArr5[1] * fArr4[1];
                brushItem2.points.add(Float.valueOf(fArr5[0]));
                brushItem2.points.add(Float.valueOf(fArr5[1]));
                brushItem2.points.add(Float.valueOf(fArr5[2]));
            }
        } else {
            if ("paint".equals(brushItem2.mode)) {
                float f6 = fArr5[1];
                float[] fArr6 = brushItem2.prevPoint;
                fArr = fArr4;
                fArr3[3] = (float) Math.atan2((double) (f6 - fArr6[1]), (double) (fArr5[0] - fArr6[0]));
            } else {
                fArr = fArr4;
            }
            int max = Math.max((int) (f5 * f4 * fArr5[2]), 1);
            float a2 = o.a(fArr5, brushItem2.prevPoint);
            if (a2 >= ((float) max)) {
                float f7 = 0.0f;
                if (brushItem2.interpolate) {
                    int i3 = max;
                    while (true) {
                        float f8 = (float) i3;
                        if (f8 > a2) {
                            break;
                        }
                        try {
                            o.a(brushItem2.prevPoint, fArr5, f8 / a2, fArr3);
                            arrayList.add(Float.valueOf(fArr3[0]));
                            arrayList.add(Float.valueOf(fArr3[1]));
                            arrayList.add(Float.valueOf(fArr3[2]));
                            if ("paint".equals(brushItem2.mode)) {
                                arrayList.add(Float.valueOf(fArr3[3]));
                            }
                            i3 += max;
                        } catch (OutOfMemoryError e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (!"paint".equals(brushItem2.mode)) {
                        i2 = 3;
                    }
                    int size = arrayList.size();
                    int i4 = size - i2;
                    brushItem2.prevPoint = new float[]{((Float) arrayList.get(i4)).floatValue(), ((Float) arrayList.get(i4 + 1)).floatValue(), ((Float) arrayList.get(i4 + 2)).floatValue()};
                    int i5 = 0;
                    while (i5 < size) {
                        if (brushItem2.randomize > f7) {
                            fArr2 = fArr;
                            double d2 = (double) f4;
                            arrayList.set(i5, Float.valueOf((float) (((double) ((Float) arrayList.get(i5)).floatValue()) + ((Math.random() - 0.5d) * ((double) brushItem2.randomize) * d2))));
                            int i6 = i5 + 1;
                            arrayList.set(i6, Float.valueOf((float) (((double) ((Float) arrayList.get(i6)).floatValue()) + ((Math.random() - 0.5d) * ((double) brushItem2.randomize) * d2))));
                        } else {
                            fArr2 = fArr;
                        }
                        arrayList.set(i5, Float.valueOf(((Float) arrayList.get(i5)).floatValue() * fArr2[0]));
                        int i7 = i5 + 1;
                        arrayList.set(i7, Float.valueOf(((Float) arrayList.get(i7)).floatValue() * fArr2[1]));
                        i5 += i2;
                        fArr = fArr2;
                        f7 = 0.0f;
                    }
                    brushItem2.points.addAll(arrayList);
                } else {
                    float[] fArr7 = fArr;
                    fArr3[0] = fArr5[0];
                    fArr3[1] = fArr5[1];
                    fArr3[2] = fArr5[2];
                    arrayList.add(Float.valueOf(fArr3[0]));
                    arrayList.add(Float.valueOf(fArr3[1]));
                    arrayList.add(Float.valueOf(fArr3[2]));
                    if ("paint".equals(brushItem2.mode)) {
                        arrayList.add(Float.valueOf(fArr3[3]));
                    }
                    if (!"paint".equals(brushItem2.mode)) {
                        i2 = 3;
                    }
                    int size2 = arrayList.size();
                    int i8 = size2 - i2;
                    brushItem2.prevPoint = new float[]{((Float) arrayList.get(i8)).floatValue(), ((Float) arrayList.get(i8 + 1)).floatValue(), ((Float) arrayList.get(i8 + 2)).floatValue()};
                    for (int i9 = 0; i9 < size2; i9 += i2) {
                        if (brushItem2.randomize > 0.0f) {
                            double d3 = (double) f4;
                            arrayList.set(i9, Float.valueOf((float) (((double) ((Float) arrayList.get(i9)).floatValue()) + ((Math.random() - 0.5d) * ((double) brushItem2.randomize) * d3))));
                            int i10 = i9 + 1;
                            arrayList.set(i10, Float.valueOf((float) (((double) ((Float) arrayList.get(i10)).floatValue()) + ((Math.random() - 0.5d) * ((double) brushItem2.randomize) * d3))));
                        }
                        arrayList.set(i9, Float.valueOf(((Float) arrayList.get(i9)).floatValue() * fArr7[0]));
                        int i11 = i9 + 1;
                        arrayList.set(i11, Float.valueOf(((Float) arrayList.get(i11)).floatValue() * fArr7[1]));
                    }
                    brushItem2.points.addAll(arrayList);
                }
            }
        }
        return arrayList;
    }

    public static void a() {
        f75a.evictAll();
    }

    public static void a(List<PointF> list, BrushItem brushItem, float f2, float f3) {
        brushItem.points.clear();
        brushItem.prevPoint = null;
        for (PointF a2 : list) {
            a(brushItem, a2, f2, f3);
        }
    }

    public void a(int i2) {
        int i3 = this.h.f11a;
        if (i2 != i3) {
            d dVar = this.t;
            s.a(i2, i3, dVar.f12b, dVar.c);
        }
        a(this.h.f11a, this.g.f11a, 0.0f, 0.0f, 1.0f);
    }

    public void a(int i2, int i3, float f2, float f3, float f4) {
        GLES20.glDisable(3042);
        this.o.a(i2);
        i iVar = this.o;
        iVar.r = this.t.f11a;
        Matrix.setIdentityM(iVar.getMatrix(), 0);
        Matrix.translateM(this.o.getMatrix(), 0, f2, f3, 0.0f);
        Matrix.scaleM(this.o.getMatrix(), 0, f4, f4, 1.0f);
        a((a) this.o, i3);
    }

    public final void a(a aVar, int i2) {
        c k2 = c.k();
        k2.b(i2);
        k2.a(o.a());
        d dVar = this.t;
        k2.b(dVar.f12b, dVar.c);
        k2.a(aVar);
        k2.p();
        aVar.draw();
        k2.m();
    }

    public final void a(a aVar, d dVar) {
        c k2 = c.k();
        k2.b(dVar.f11a);
        k2.a(o.a());
        k2.b(dVar.f12b, dVar.c);
        k2.a(aVar);
        k2.p();
        aVar.draw();
        k2.m();
    }

    public final void a(d dVar) {
        GLES20.glBindTexture(3553, dVar.f11a);
        s.c(33071, 33071, 9729, 9729);
        GLES20.glBindTexture(3553, 0);
        this.f.b(dVar.f11a);
        this.f.a(o.a());
        this.f.b(dVar.f12b, dVar.c);
        this.f.p();
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        b();
        this.f.m();
        GLES20.glFinish();
        GLES20.glFlush();
    }

    public void a(Context context, BrushItem brushItem) {
        this.x = Math.max(10.0f, brushItem.size * c);
        float f2 = brushItem.spacing;
        this.w = (float) a(brushItem.hardness);
        if ("paint".equals(brushItem.mode)) {
            boolean z = brushItem.erase;
            if (z) {
                z zVar = this.d;
                zVar.r = z;
                zVar.n = this.x;
                zVar.o = this.w;
                zVar.p = brushItem.flow;
                zVar.q = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
                return;
            }
            ax axVar = this.e;
            axVar.n = this.x;
            axVar.o = brushItem.flow;
            if (context.brushes.get(brushItem.texture) != null) {
                this.e.p = context.brushes.get(brushItem.texture).f11a;
                return;
            }
            this.e.p = context.brushes.values().iterator().next().f11a;
            return;
        }
        z zVar2 = this.d;
        zVar2.n = this.x;
        zVar2.o = this.w;
        zVar2.p = brushItem.flow;
        zVar2.q = brushItem.channel;
        zVar2.r = brushItem.erase;
        zVar2.s = false;
    }

    public void a(Context context, BrushItem brushItem, d dVar) {
        GLES20.glDisable(3042);
        brushItem.interpolate = true;
        if (CameraStatisticsUtil.PORTRAIT_BLUR.equals(brushItem.texture) || "mosaic".equals(brushItem.texture) || "dot".equals(brushItem.texture) || "eraser".equals(brushItem.texture)) {
            brushItem.mode = "effect";
        } else {
            brushItem.mode = "paint";
        }
        this.u = dVar;
        this.p = context.intermediateTexture;
        this.s = brushItem;
        this.s.points.clear();
        this.s.prevPoint = null;
        this.f.b(this.p.f11a);
        this.f.a(o.a());
        c cVar = this.f;
        d dVar2 = this.p;
        cVar.b(dVar2.f12b, dVar2.c);
        this.f.p();
        if ("effect".equals(this.s.mode)) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        } else {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        b();
        this.f.m();
        if (CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.s.texture)) {
            f();
        } else if ("mosaic".equals(this.s.texture)) {
            a("square");
        } else if ("dot".equals(this.s.texture)) {
            a("dot");
        } else {
            a(this.j);
        }
        d dVar3 = this.p;
        d dVar4 = context.paintTexture;
        s.b(dVar3, dVar4.f12b, dVar4.c);
        a(context, this.s);
        this.f.b(this.p.f11a);
        this.f.a(o.a());
        c cVar2 = this.f;
        d dVar5 = this.p;
        cVar2.b(dVar5.f12b, dVar5.c);
        this.f.p();
        if ("effect".equals(this.s.mode)) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        } else {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
        b();
        this.f.m();
    }

    public void a(Context context, BrushItem brushItem, BrushItem brushItem2, boolean z, boolean z2) {
        ax axVar;
        Object obj;
        if (brushItem == null) {
            brushItem = new BrushItem();
        }
        if (brushItem2 == null) {
            brushItem2 = this.s;
        }
        if (z2) {
            brushItem.size = brushItem2.size;
            brushItem.hardness = brushItem2.hardness;
            brushItem.flow = brushItem2.flow;
        }
        brushItem2.points = brushItem.points;
        brushItem2.size = brushItem.size;
        brushItem2.spacing = brushItem.spacing;
        brushItem2.hardness = brushItem.hardness;
        brushItem2.flow = brushItem.flow;
        brushItem2.channel = brushItem.channel;
        brushItem2.erase = brushItem.erase;
        brushItem2.mode = brushItem.mode;
        brushItem2.texture = brushItem.texture;
        brushItem2.randomize = brushItem.randomize;
        brushItem2.interpolate = brushItem.interpolate;
        BrushItem brushItem3 = this.s;
        brushItem3.mode = brushItem.mode;
        brushItem3.texture = brushItem.texture;
        brushItem3.randomize = brushItem.randomize;
        brushItem3.interpolate = brushItem.interpolate;
        brushItem3.erase = brushItem2.erase;
        this.x = Math.max(10.0f, brushItem2.size * c);
        float f2 = brushItem2.spacing;
        this.w = (float) a(brushItem2.hardness);
        d dVar = context.paintTexture;
        int i2 = dVar.f12b;
        int i3 = dVar.c;
        if ("paint".equals(brushItem2.mode)) {
            boolean z3 = brushItem2.erase;
            if (z3) {
                z zVar = this.d;
                zVar.r = z3;
                zVar.n = this.x;
                zVar.o = this.w;
                zVar.p = brushItem2.flow;
                zVar.q = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
                return;
            }
            ax axVar2 = this.e;
            axVar2.n = this.x;
            axVar2.o = brushItem2.flow;
            if (context.brushes.get(brushItem2.texture) != null) {
                axVar = this.e;
                obj = context.brushes.get(brushItem2.texture);
            } else {
                axVar = this.e;
                obj = context.brushes.values().iterator().next();
            }
            axVar.p = ((d) obj).f11a;
            return;
        }
        z zVar2 = this.d;
        zVar2.n = this.x;
        zVar2.o = this.w;
        zVar2.p = brushItem2.flow;
        zVar2.q = brushItem2.channel;
        zVar2.r = brushItem2.erase;
        zVar2.s = false;
        if (z) {
            ai.a(context.glRenderView.c(), context).r = this.x;
            ai.a(context.glRenderView.c(), context).s = this.w;
            ai.a(context.glRenderView.c(), context).t = brushItem2.flow;
        }
    }

    public void a(Context context, BrushItem brushItem, boolean z) {
        List<Float> list;
        if (!brushItem.blend) {
            BrushItem brushItem2 = new BrushItem();
            if (brushItem.pointId == null || (list = brushItem.points) == null || list.isEmpty()) {
                String str = brushItem.pointId;
                if (str != null) {
                    brushItem.points = f75a.get(str);
                }
            } else {
                f75a.put(brushItem.pointId, brushItem.points);
            }
            a(context, brushItem, brushItem2, z, false);
            List<Float> list2 = brushItem2.points;
            if (list2 != null && !list2.isEmpty()) {
                a(brushItem2.points);
            }
        }
    }

    public void a(Context context, boolean z) {
        d[] dVarArr;
        Context context2 = context;
        boolean z2 = z;
        List list = (List) context2.renderStates.get("local_adjustments");
        List arrayList = new ArrayList();
        List list2 = (List) context2.renderStates.get("prevBrushes");
        if (list2 == null) {
            list2 = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            boolean z3 = false;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                Adjustment adjustment = (Adjustment) list.get(i4);
                if (!"mask".equals(adjustment.brush_mode)) {
                    List<BrushItem> list3 = adjustment.brush;
                    if (list3 != null && !list3.isEmpty() && (dVarArr = context2.brushTextures) != null && i3 < 4) {
                        this.p = dVarArr[i3];
                        this.f.b(this.p.f11a);
                        this.f.a(o.a());
                        c cVar = this.f;
                        d dVar = this.p;
                        cVar.b(dVar.f12b, dVar.c);
                        this.f.p();
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        b();
                        for (int i5 = 0; i5 < adjustment.brush.size(); i5++) {
                            a(context2, adjustment.brush.get(i5), z2);
                        }
                        this.f.m();
                        adjustment.paintTextureId = this.p.f11a;
                        i3++;
                    }
                } else if (i2 < 4) {
                    adjustment.channel = f76b[i2];
                    List<BrushItem> list4 = adjustment.brush;
                    if (list4 != null) {
                        for (BrushItem brushItem : list4) {
                            brushItem.channel = f76b[i2];
                        }
                    }
                    List<BrushItem> list5 = adjustment.brush;
                    if (list5 != null) {
                        arrayList.addAll(list5);
                        z3 = true;
                    }
                    i2++;
                }
            }
            GLES20.glDisable(3042);
            if (arrayList.size() != list2.size() || (z3 && arrayList.isEmpty())) {
                context2.overlayMask = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
                this.p = context2.paintTexture;
                this.f.b(this.p.f11a);
                this.f.a(o.a());
                c cVar2 = this.f;
                d dVar2 = this.p;
                cVar2.b(dVar2.f12b, dVar2.c);
                this.f.p();
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                b();
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    a(context2, (BrushItem) arrayList.get(i6), z2);
                }
                this.f.m();
                context2.renderStates.put("prevBrushes", arrayList);
            }
        }
        arrayList = list2;
        context2.renderStates.put("prevBrushes", arrayList);
    }

    public final void a(String str) {
        d dVar = this.t;
        int i2 = dVar.f12b;
        int i3 = dVar.c;
        float f2 = this.s.mosaicSize;
        d dVar2 = this.j;
        s.b(dVar2, i2, i3);
        GLES20.glBindTexture(3553, dVar2.f11a);
        s.c(33071, 33071, 9728, 9728);
        GLES20.glBindTexture(3553, 0);
        aw awVar = this.l;
        awVar.r = str;
        awVar.s = f2;
        awVar.t = (float) dVar.f12b;
        awVar.u = (float) dVar.c;
        awVar.v = this.v.f11a;
        awVar.a(dVar.f11a);
        a((a) this.l, dVar2);
    }

    public void a(List<Float> list) {
        boolean z;
        z zVar;
        if (!"paint".equals(this.s.mode)) {
            zVar = this.d;
            z = false;
        } else if (this.s.erase) {
            zVar = this.d;
            z = true;
        } else {
            this.e.a(list);
            return;
        }
        zVar.a(list, z);
    }

    public void a(List<PointF> list, float f2, float f3, float f4) {
        GLES20.glDisable(3042);
        this.f.b(this.p.f11a);
        this.f.a(o.a());
        c cVar = this.f;
        d dVar = this.p;
        cVar.b(dVar.f12b, dVar.c);
        this.f.p();
        ArrayList arrayList = new ArrayList();
        for (PointF a2 : list) {
            BrushItem brushItem = this.s;
            d dVar2 = this.p;
            arrayList.addAll(a(brushItem, a2, (float) dVar2.f12b, (float) dVar2.c));
        }
        a((List<Float>) arrayList);
        this.f.m();
        a(false, f2, f3, f4);
    }

    public final void a(boolean z) {
        bf bfVar;
        d dVar;
        GLES20.glFinish();
        "effect".equals(this.s.mode);
        this.f.b(this.u.f11a);
        this.f.a(o.a());
        c cVar = this.f;
        d dVar2 = this.u;
        cVar.b(dVar2.f12b, dVar2.c);
        this.f.p();
        Basic instance = Basic.getInstance(this.q);
        instance.setNeedClear(false);
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 0, 1);
        if ("effect".equals(this.s.mode)) {
            this.r.a(o.a());
            this.r.a(this.p.f11a);
            bf bfVar2 = this.r;
            bfVar2.q = 1.0f;
            bfVar2.r = 1.0f;
            if (!CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.s.texture) && !"mosaic".equals(this.s.texture) && !"dot".equals(this.s.texture) && !z) {
                bfVar = this.r;
                dVar = this.t;
            } else {
                bfVar = this.r;
                dVar = this.j;
            }
            bfVar.s = dVar.f11a;
            this.r.draw();
        } else {
            GLES20.glBlendFunc(1, 771);
            instance.setInputTextureId(this.p.f11a);
            instance.draw();
        }
        GLES20.glDisable(3042);
        this.f.m();
    }

    public final void a(boolean z, float f2, float f3, float f4) {
        bf bfVar;
        d dVar;
        this.f.b(this.u.f11a);
        this.f.a(o.a());
        c cVar = this.f;
        d dVar2 = this.u;
        cVar.b(dVar2.f12b, dVar2.c);
        this.f.p();
        Basic instance = Basic.getInstance(this.q);
        instance.setNeedClear(false);
        Matrix.translateM(instance.getMatrix(), 0, f2, f3, 0.0f);
        Matrix.scaleM(instance.getMatrix(), 0, f4, f4, 1.0f);
        if (!z) {
            GLES20.glClear(16384);
            GLES20.glDisable(3042);
            instance.setInputTextureId(this.g.f11a);
            instance.draw();
        }
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 0, 1);
        if ("effect".equals(this.s.mode)) {
            this.r.a(o.a());
            Matrix.translateM(this.r.getMatrix(), 0, f2, f3, 0.0f);
            Matrix.scaleM(this.r.getMatrix(), 0, f4, f4, 1.0f);
            this.r.a(this.p.f11a);
            bf bfVar2 = this.r;
            bfVar2.q = 1.0f;
            bfVar2.r = 1.0f;
            if (!CameraStatisticsUtil.PORTRAIT_BLUR.equals(this.s.texture) && !"mosaic".equals(this.s.texture) && !"dot".equals(this.s.texture) && !z) {
                bfVar = this.r;
                dVar = this.t;
            } else {
                bfVar = this.r;
                dVar = this.j;
            }
            bfVar.s = dVar.f11a;
            this.r.draw();
        } else {
            GLES20.glBlendFunc(1, 771);
            instance.setInputTextureId(this.p.f11a);
            instance.draw();
        }
        GLES20.glDisable(3042);
        this.f.m();
    }

    public void a(float[] fArr) {
        boolean z = false;
        boolean z2 = fArr[0] != 0.0f;
        boolean z3 = fArr[1] != 0.0f;
        boolean z4 = fArr[2] != 0.0f;
        if (fArr[3] != 0.0f) {
            z = true;
        }
        GLES20.glColorMask(z2, z3, z4, z);
        GLES20.glClear(16384);
    }

    public void b() {
        a(new float[]{1.0f, 1.0f, 1.0f, 1.0f});
    }

    public void b(d dVar) {
        this.v = dVar;
    }

    public d c() {
        return this.h;
    }

    public void c(d dVar) {
        this.t = dVar;
        s.b(this.g, dVar.f12b, dVar.c);
        s.b(this.h, dVar.f12b, dVar.c);
        s.b(this.i, dVar.f12b, dVar.c);
        a(this.h);
        s.a(dVar.f11a, this.g.f11a, dVar.f12b, dVar.c);
    }

    public void d() {
        GLES20.glDisable(3042);
        this.u = this.g;
        a(false);
        g();
        GLES20.glBindTexture(3553, this.h.f11a);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9728.0f);
        GLES20.glBindTexture(3553, 0);
    }

    public void e() {
        d dVar = this.g;
        if (dVar != null) {
            g.a(dVar);
            g.e(this.g.f11a);
        }
        d dVar2 = this.h;
        if (dVar2 != null) {
            g.a(dVar2);
            g.e(this.h.f11a);
        }
        d dVar3 = this.j;
        if (dVar3 != null) {
            g.a(dVar3);
            g.e(this.j.f11a);
        }
        d dVar4 = this.k;
        if (dVar4 != null) {
            g.a(dVar4);
            g.e(this.k.f11a);
        }
    }

    public final void f() {
        d dVar = this.t;
        int i2 = dVar.f12b;
        int i3 = dVar.c;
        while (true) {
            if (i2 > 2048 || i3 > 2048) {
                i2 >>= 1;
                i3 >>= 1;
            } else {
                float f2 = 1.0f / ((float) i2);
                float f3 = 1.0f / ((float) i3);
                d dVar2 = this.j;
                d dVar3 = this.p;
                s.b(dVar2, i2, i3);
                s.b(dVar3, i2, i3);
                GLES20.glBindTexture(3553, dVar2.f11a);
                s.c(33071, 33071, 9729, 9729);
                GLES20.glBindTexture(3553, 0);
                ao aoVar = this.m;
                aoVar.s = Context.overlayMesh;
                aoVar.r = new float[]{f2, 0.0f};
                aoVar.a(this.t.f11a);
                a((a) this.m, dVar3);
                ao aoVar2 = this.m;
                aoVar2.r = new float[]{0.0f, f3};
                aoVar2.a(dVar3.f11a);
                a((a) this.m, dVar2);
                ao aoVar3 = this.m;
                aoVar3.r = new float[]{f2, 0.0f};
                aoVar3.a(dVar2.f11a);
                a((a) this.m, dVar3);
                ao aoVar4 = this.m;
                aoVar4.r = new float[]{0.0f, f3};
                aoVar4.a(dVar3.f11a);
                a((a) this.m, dVar2);
                return;
            }
        }
    }

    public final void g() {
        d dVar = this.h;
        s.a(dVar.f11a, this.i.f11a, dVar.f12b, dVar.c);
        this.n.a(this.g.f11a);
        s sVar = this.n;
        sVar.r = this.t.f11a;
        sVar.s = this.i.f11a;
        sVar.t = this.p.f11a;
        a((a) sVar, this.h);
    }
}
