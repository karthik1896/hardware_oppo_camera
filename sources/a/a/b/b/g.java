package a.a.b.b;

import a.a.b.a.a.c;
import a.a.b.a.aa;
import a.a.b.a.af;
import a.a.b.a.ai;
import a.a.b.a.aj;
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
import a.a.b.a.bc;
import a.a.b.a.bd;
import a.a.b.a.be;
import a.a.b.a.bg;
import a.a.b.a.bi;
import a.a.b.a.bj;
import a.a.b.a.bl;
import a.a.b.a.bm;
import a.a.b.a.bo;
import a.a.b.a.e;
import a.a.b.a.f;
import a.a.b.a.i;
import a.a.b.a.l;
import a.a.b.a.m;
import a.a.b.a.n;
import a.a.b.a.v;
import a.a.b.a.w;
import a.a.b.a.y;
import a.a.b.d.d;
import a.a.b.e.k;
import a.a.b.e.o;
import a.a.b.e.p;
import a.a.b.e.q;
import a.a.b.e.r;
import a.a.b.e.s;
import a.a.b.e.t;
import a.a.b.e.u;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.FaceItem;
import co.polarr.renderer.entities.Mesh;
import co.polarr.renderer.entities.SpotItem;
import co.polarr.renderer.entities.TextItem;
import co.polarr.renderer.filters.Basic;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class g implements GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f15a = {0.0f, 0.0f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    public static float f16b = 2.0f;
    public static int c = 60;
    public static final HashMap<Long, b> d = new HashMap<>();
    public Queue<Runnable> A;
    public p B;
    public r C;
    public boolean D;
    public long E = 0;
    public long F = 0;
    public int e = 0;
    public volatile boolean f = false;
    public d g;
    public GLSurfaceView h;
    public float[] i = new float[25];
    public int j = 0;
    public final Resources k;
    public a.a.b.a.a.d l;
    public List<a.a.b.a.a.b> m;
    public a.a.b.a.a.b n;
    public n o;
    public n p;
    public Point q;
    public List<Bitmap> r;
    public Bitmap s;
    public Point t;
    public boolean u = false;
    public AtomicBoolean v;
    public AtomicBoolean w;
    public AtomicBoolean x;
    public AtomicBoolean y;
    public boolean z;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f17a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f18b;
        public final /* synthetic */ boolean c;

        public a(boolean z, d dVar, boolean z2) {
            this.f17a = z;
            this.f18b = dVar;
            this.c = z2;
        }

        public void run() {
            g.this.a(this.f17a, this.f18b, this.c, false);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final LinkedList<Integer> f19a;

        /* renamed from: b  reason: collision with root package name */
        public final LinkedList<Integer> f20b;
        public final LinkedList<Integer> c;

        public b() {
            this.f19a = new LinkedList<>();
            this.f20b = new LinkedList<>();
            this.c = new LinkedList<>();
        }

        public /* synthetic */ b(e eVar) {
            this();
        }
    }

    public g(Context context, Resources resources, d dVar) {
        this.g = dVar;
        this.k = resources;
        j();
    }

    public g(Context context, Resources resources, GLSurfaceView gLSurfaceView) {
        this.h = gLSurfaceView;
        this.k = resources;
        j();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v24, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v26, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v27, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v28, resolved type: a.a.b.a.l} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a.a.b.a.a.a a(android.content.res.Resources r12, co.polarr.renderer.entities.Context r13, a.a.b.a.a.d r14, java.util.List<a.a.b.a.a.b> r15) {
        /*
            monitor-enter(r13)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r13.renderStates     // Catch:{ all -> 0x01f4 }
            java.lang.String r1 = "local_adjustments"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x01f4 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x01f4 }
            r1 = 0
            if (r0 == 0) goto L_0x01f2
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x01f4 }
            if (r2 != 0) goto L_0x01f2
            java.util.Map<java.lang.String, java.lang.Object> r2 = r13.renderStates     // Catch:{ all -> 0x01f4 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x01f4 }
            r3.<init>()     // Catch:{ all -> 0x01f4 }
            r13.renderStates = r3     // Catch:{ all -> 0x01f4 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r13.renderStates     // Catch:{ all -> 0x01f4 }
            a.a.b.f.a(r3)     // Catch:{ all -> 0x01f4 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x01f4 }
            r3 = r1
        L_0x0027:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x01f4 }
            r5 = 0
            if (r4 == 0) goto L_0x01c7
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x01f4 }
            co.polarr.renderer.entities.Adjustment r4 = (co.polarr.renderer.entities.Adjustment) r4     // Catch:{ all -> 0x01f4 }
            boolean r6 = r4.disabled     // Catch:{ all -> 0x01f4 }
            if (r6 == 0) goto L_0x0039
            goto L_0x0027
        L_0x0039:
            java.lang.String r6 = "radial"
            java.lang.String r7 = r4.type     // Catch:{ all -> 0x01f4 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x01f4 }
            r7 = 2
            r8 = 1
            r9 = 1065353216(0x3f800000, float:1.0)
            if (r6 == 0) goto L_0x0078
            a.a.b.a.o r6 = a.a.b.a.o.a(r12, r13)     // Catch:{ all -> 0x01f4 }
            float r10 = r4.feather     // Catch:{ all -> 0x01f4 }
            r6.r = r10     // Catch:{ all -> 0x01f4 }
            float[] r10 = r4.size     // Catch:{ all -> 0x01f4 }
            r6.v = r10     // Catch:{ all -> 0x01f4 }
            float[] r10 = r4.position     // Catch:{ all -> 0x01f4 }
            float[] r7 = java.util.Arrays.copyOf(r10, r7)     // Catch:{ all -> 0x01f4 }
            r6.u = r7     // Catch:{ all -> 0x01f4 }
            float[] r7 = r6.u     // Catch:{ all -> 0x01f4 }
            float[] r10 = r6.u     // Catch:{ all -> 0x01f4 }
            r10 = r10[r8]     // Catch:{ all -> 0x01f4 }
            float r10 = -r10
            r7[r8] = r10     // Catch:{ all -> 0x01f4 }
            float r7 = r4.angle     // Catch:{ all -> 0x01f4 }
            float r7 = -r7
            r6.t = r7     // Catch:{ all -> 0x01f4 }
            boolean r7 = r4.invert     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x006f
            r7 = r9
            goto L_0x0070
        L_0x006f:
            r7 = r5
        L_0x0070:
            r6.s = r7     // Catch:{ all -> 0x01f4 }
            r6.w = r9     // Catch:{ all -> 0x01f4 }
            r6.x = r5     // Catch:{ all -> 0x01f4 }
            goto L_0x0196
        L_0x0078:
            java.lang.String r6 = "gradient"
            java.lang.String r10 = r4.type     // Catch:{ all -> 0x01f4 }
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x01f4 }
            if (r6 == 0) goto L_0x00c0
            a.a.b.a.a r6 = a.a.b.a.a.a(r12, r13)     // Catch:{ all -> 0x01f4 }
            float[] r10 = r4.startPoint     // Catch:{ all -> 0x01f4 }
            float[] r10 = java.util.Arrays.copyOf(r10, r7)     // Catch:{ all -> 0x01f4 }
            r6.r = r10     // Catch:{ all -> 0x01f4 }
            float[] r10 = r6.r     // Catch:{ all -> 0x01f4 }
            float[] r11 = r6.r     // Catch:{ all -> 0x01f4 }
            r11 = r11[r8]     // Catch:{ all -> 0x01f4 }
            float r11 = -r11
            r10[r8] = r11     // Catch:{ all -> 0x01f4 }
            float[] r10 = r4.endPoint     // Catch:{ all -> 0x01f4 }
            float[] r7 = java.util.Arrays.copyOf(r10, r7)     // Catch:{ all -> 0x01f4 }
            r6.s = r7     // Catch:{ all -> 0x01f4 }
            float[] r7 = r6.s     // Catch:{ all -> 0x01f4 }
            float[] r10 = r6.s     // Catch:{ all -> 0x01f4 }
            r10 = r10[r8]     // Catch:{ all -> 0x01f4 }
            float r10 = -r10
            r7[r8] = r10     // Catch:{ all -> 0x01f4 }
            boolean r7 = r4.invert     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x00ae
            r7 = r9
            goto L_0x00af
        L_0x00ae:
            r7 = r5
        L_0x00af:
            r6.t = r7     // Catch:{ all -> 0x01f4 }
            boolean r7 = r4.reflect     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x00b7
            r7 = r9
            goto L_0x00b8
        L_0x00b7:
            r7 = r5
        L_0x00b8:
            r6.u = r7     // Catch:{ all -> 0x01f4 }
            r6.v = r9     // Catch:{ all -> 0x01f4 }
            r6.w = r5     // Catch:{ all -> 0x01f4 }
            goto L_0x0196
        L_0x00c0:
            java.lang.String r6 = "luminance"
            java.lang.String r10 = r4.type     // Catch:{ all -> 0x01f4 }
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x01f4 }
            if (r6 == 0) goto L_0x00e9
            a.a.b.a.bg r6 = a.a.b.a.bg.a(r12, r13)     // Catch:{ all -> 0x01f4 }
            float r7 = r4.target     // Catch:{ all -> 0x01f4 }
            r6.r = r7     // Catch:{ all -> 0x01f4 }
            float r7 = r4.range     // Catch:{ all -> 0x01f4 }
            r6.s = r7     // Catch:{ all -> 0x01f4 }
            boolean r7 = r4.invert     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x00dc
            r7 = r9
            goto L_0x00dd
        L_0x00dc:
            r7 = r5
        L_0x00dd:
            r6.u = r7     // Catch:{ all -> 0x01f4 }
            float r7 = r4.smoothness     // Catch:{ all -> 0x01f4 }
            r6.t = r7     // Catch:{ all -> 0x01f4 }
            r6.v = r9     // Catch:{ all -> 0x01f4 }
            r6.w = r5     // Catch:{ all -> 0x01f4 }
            goto L_0x0196
        L_0x00e9:
            java.lang.String r6 = "color"
            java.lang.String r10 = r4.type     // Catch:{ all -> 0x01f4 }
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x01f4 }
            if (r6 == 0) goto L_0x0144
            a.a.b.a.ay r6 = a.a.b.a.ay.a(r12, r13)     // Catch:{ all -> 0x01f4 }
            float r10 = r4.feather     // Catch:{ all -> 0x01f4 }
            r6.r = r10     // Catch:{ all -> 0x01f4 }
            float r10 = r4.threshold     // Catch:{ all -> 0x01f4 }
            r6.u = r10     // Catch:{ all -> 0x01f4 }
            float[] r10 = r4.size     // Catch:{ all -> 0x01f4 }
            r6.w = r10     // Catch:{ all -> 0x01f4 }
            float[] r10 = r4.position     // Catch:{ all -> 0x01f4 }
            float[] r7 = java.util.Arrays.copyOf(r10, r7)     // Catch:{ all -> 0x01f4 }
            r6.v = r7     // Catch:{ all -> 0x01f4 }
            float[] r7 = r6.v     // Catch:{ all -> 0x01f4 }
            float[] r10 = r6.v     // Catch:{ all -> 0x01f4 }
            r10 = r10[r8]     // Catch:{ all -> 0x01f4 }
            float r10 = -r10
            r7[r8] = r10     // Catch:{ all -> 0x01f4 }
            boolean r7 = r4.invert     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x011a
            r7 = r9
            goto L_0x011b
        L_0x011a:
            r7 = r5
        L_0x011b:
            r6.s = r7     // Catch:{ all -> 0x01f4 }
            boolean r7 = r4.useRadius     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x0123
            r7 = r9
            goto L_0x0124
        L_0x0123:
            r7 = r5
        L_0x0124:
            r6.t = r7     // Catch:{ all -> 0x01f4 }
            float[] r7 = r4.selectedColor     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x012d
            float[] r7 = r4.selectedColor     // Catch:{ all -> 0x01f4 }
            goto L_0x012f
        L_0x012d:
            float[] r7 = f15a     // Catch:{ all -> 0x01f4 }
        L_0x012f:
            r6.z = r7     // Catch:{ all -> 0x01f4 }
            float[] r7 = r4.selectedColor     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x013c
            float[] r7 = r4.selectedColor     // Catch:{ all -> 0x01f4 }
            int r7 = r7.length     // Catch:{ all -> 0x01f4 }
            if (r7 <= 0) goto L_0x013c
            r7 = r9
            goto L_0x013d
        L_0x013c:
            r7 = r5
        L_0x013d:
            r6.A = r7     // Catch:{ all -> 0x01f4 }
            r6.x = r9     // Catch:{ all -> 0x01f4 }
            r6.y = r5     // Catch:{ all -> 0x01f4 }
            goto L_0x0196
        L_0x0144:
            java.lang.String r6 = "brush"
            java.lang.String r7 = r4.type     // Catch:{ all -> 0x01f4 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x01f4 }
            if (r6 == 0) goto L_0x0195
            java.lang.String r6 = "paint"
            java.lang.String r7 = r4.brush_mode     // Catch:{ all -> 0x01f4 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x01f4 }
            if (r6 == 0) goto L_0x017f
            co.polarr.renderer.filters.Basic r5 = co.polarr.renderer.filters.Basic.a(r12, r13)     // Catch:{ all -> 0x01f4 }
            r14.b(r5)     // Catch:{ all -> 0x01f4 }
            r5 = 3042(0xbe2, float:4.263E-42)
            android.opengl.GLES20.glEnable(r5)     // Catch:{ all -> 0x01f4 }
            r6 = 32774(0x8006, float:4.5926E-41)
            android.opengl.GLES20.glBlendEquation(r6)     // Catch:{ all -> 0x01f4 }
            r6 = 771(0x303, float:1.08E-42)
            android.opengl.GLES20.glBlendFunc(r8, r6)     // Catch:{ all -> 0x01f4 }
            a.a.b.a.av r6 = a.a.b.a.av.a(r12, r13)     // Catch:{ all -> 0x01f4 }
            int r7 = r4.paintTextureId     // Catch:{ all -> 0x01f4 }
            r6.a((int) r7)     // Catch:{ all -> 0x01f4 }
            r6.draw()     // Catch:{ all -> 0x01f4 }
            android.opengl.GLES20.glDisable(r5)     // Catch:{ all -> 0x01f4 }
            goto L_0x0195
        L_0x017f:
            a.a.b.a.l r6 = a.a.b.a.l.a(r12, r13)     // Catch:{ all -> 0x01f4 }
            float[] r7 = r4.channel     // Catch:{ all -> 0x01f4 }
            r6.s = r7     // Catch:{ all -> 0x01f4 }
            boolean r7 = r4.invert     // Catch:{ all -> 0x01f4 }
            if (r7 == 0) goto L_0x018d
            r7 = r9
            goto L_0x018e
        L_0x018d:
            r7 = r5
        L_0x018e:
            r6.r = r7     // Catch:{ all -> 0x01f4 }
            r6.t = r9     // Catch:{ all -> 0x01f4 }
            r6.u = r5     // Catch:{ all -> 0x01f4 }
            goto L_0x0196
        L_0x0195:
            r6 = r1
        L_0x0196:
            if (r6 != 0) goto L_0x019a
            goto L_0x0027
        L_0x019a:
            boolean r5 = r4.showOverlay     // Catch:{ all -> 0x01f4 }
            if (r5 == 0) goto L_0x019f
            r3 = r6
        L_0x019f:
            r14.b(r6)     // Catch:{ all -> 0x01f4 }
            java.util.Map<java.lang.String, java.lang.Object> r5 = r13.renderStates     // Catch:{ all -> 0x01f4 }
            co.polarr.renderer.entities.Context$LocalState r4 = r4.adjustments     // Catch:{ all -> 0x01f4 }
            java.util.Map r4 = co.polarr.renderer.entities.Adjustment.getAdjustmentHashMap(r4)     // Catch:{ all -> 0x01f4 }
            r5.putAll(r4)     // Catch:{ all -> 0x01f4 }
            java.util.Iterator r4 = r15.iterator()     // Catch:{ all -> 0x01f4 }
        L_0x01b1:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x01f4 }
            if (r5 == 0) goto L_0x0027
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x01f4 }
            a.a.b.a.a.b r5 = (a.a.b.a.a.b) r5     // Catch:{ all -> 0x01f4 }
            boolean r6 = r5.k()     // Catch:{ all -> 0x01f4 }
            if (r6 != 0) goto L_0x01b1
            r14.b(r5)     // Catch:{ all -> 0x01f4 }
            goto L_0x01b1
        L_0x01c7:
            r13.renderStates = r2     // Catch:{ all -> 0x01f4 }
            java.util.Map<java.lang.String, java.lang.Object> r15 = r13.renderStates     // Catch:{ all -> 0x01f4 }
            java.lang.String r0 = "blur_opacity"
            java.lang.Object r15 = r15.get(r0)     // Catch:{ all -> 0x01f4 }
            java.lang.Float r15 = (java.lang.Float) r15     // Catch:{ all -> 0x01f4 }
            float r15 = r15.floatValue()     // Catch:{ all -> 0x01f4 }
            int r15 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r15 != 0) goto L_0x01f1
            r14.r()     // Catch:{ all -> 0x01f4 }
            c(r12, r13)     // Catch:{ all -> 0x01f4 }
            a.a.b.b.d r15 = r13.readableTexture     // Catch:{ all -> 0x01f4 }
            a.a.b.b.d r0 = r13.tempTexture     // Catch:{ all -> 0x01f4 }
            r13.readableTexture = r0     // Catch:{ all -> 0x01f4 }
            a.a.b.b.d r0 = r13.readableTexture     // Catch:{ all -> 0x01f4 }
            a((android.content.res.Resources) r12, (co.polarr.renderer.entities.Context) r13, (a.a.b.b.d) r0)     // Catch:{ all -> 0x01f4 }
            r13.readableTexture = r15     // Catch:{ all -> 0x01f4 }
            r14.u()     // Catch:{ all -> 0x01f4 }
        L_0x01f1:
            r1 = r3
        L_0x01f2:
            monitor-exit(r13)     // Catch:{ all -> 0x01f4 }
            return r1
        L_0x01f4:
            r12 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x01f4 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.b.g.a(android.content.res.Resources, co.polarr.renderer.entities.Context, a.a.b.a.a.d, java.util.List):a.a.b.a.a.a");
    }

    public static d a(co.polarr.renderer.entities.Context context, a.a.b.a.g gVar, d dVar, d dVar2, float f2, Float f3) {
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
        gVar.s = co.polarr.renderer.entities.Context.overlayMesh;
        a(context, dVar.f11a, context.readableTexture, (a.a.b.a.a.a) gVar, true);
        gVar.r = new float[]{0.0f, (1.0f / ((float) dVar2.c)) * f2, 0.0f, (1.0f / ((float) dVar2.c)) * floatValue2};
        gVar.s = co.polarr.renderer.entities.Context.overlayMesh;
        a(context, context.readableTexture.f11a, dVar2, (a.a.b.a.a.a) gVar, true);
        return dVar2;
    }

    public static d a(co.polarr.renderer.entities.Context context, a.a.b.a.r rVar, an anVar, d dVar, d dVar2) {
        if (dVar2 == null) {
            dVar2 = dVar;
        }
        rVar.r = new float[]{(1.0f / ((float) dVar2.f12b)) * 8.0f, 0.0f};
        rVar.s = co.polarr.renderer.entities.Context.overlayMesh;
        a(context, dVar.f11a, context.readableTexture, (a.a.b.a.a.a) rVar, true);
        anVar.r = new float[]{0.0f, (1.0f / ((float) dVar2.c)) * 8.0f};
        anVar.s = co.polarr.renderer.entities.Context.overlayMesh;
        a(context, context.readableTexture.f11a, dVar2, (a.a.b.a.a.a) anVar, true);
        return dVar2;
    }

    public static b a() {
        b bVar;
        Long valueOf = Long.valueOf(Thread.currentThread().getId());
        synchronized (d) {
            if (!d.containsKey(valueOf)) {
                bVar = new b((e) null);
                d.put(valueOf, bVar);
            } else {
                bVar = d.get(valueOf);
            }
        }
        return bVar;
    }

    public static void a(int i2) {
        b a2 = a();
        synchronized (a2.c) {
            a2.c.add(Integer.valueOf(i2));
        }
    }

    public static void a(d dVar) {
        s.a(dVar.f11a);
    }

    public static void a(Context context, Resources resources, co.polarr.renderer.entities.Context context2, ArrayList<TextItem> arrayList) {
        if (context != null) {
            ArrayList arrayList2 = (ArrayList) context2.renderStates.get("zPrevText");
            if (arrayList != null && !arrayList.isEmpty()) {
                int i2 = 0;
                Iterator<TextItem> it = arrayList.iterator();
                while (it.hasNext()) {
                    TextItem next = it.next();
                    d dVar = context2.textLayers.size() > i2 ? context2.textLayers.get(i2) : null;
                    if (dVar == null) {
                        context2.textLayers.add(u.a(context, resources.getAssets(), next, context2, (d) null));
                    } else if (arrayList2 == null || arrayList2.size() <= i2 || !a.a.b.e.a.a(arrayList2.get(i2), (Object) next)) {
                        u.a(context, resources.getAssets(), next, context2, dVar);
                    }
                    i2++;
                }
                context2.renderStates.put("zPrevText", arrayList);
            }
        }
    }

    public static void a(Resources resources, co.polarr.renderer.entities.Context context) {
        String[] strArr = {"brush_08_8.png", "brush_09_8.png", "brush_07.png", "brush_05.png", "brush_04.png", "brush_03.png", "brush_02.png"};
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (Build.VERSION.SDK_INT >= 19) {
                options.inPremultiplied = false;
            }
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(resources.getAssets().open("paint/" + strArr[i2]), (Rect) null, options);
            } catch (IOException unused) {
            }
            if (bitmap != null) {
                int[] iArr = new int[1];
                s.a(iArr.length, iArr, 0, 6408, bitmap.getWidth(), bitmap.getHeight());
                d b2 = s.b(iArr[0], 6408, bitmap.getWidth(), bitmap.getHeight());
                GLES20.glBindTexture(3553, b2.f11a);
                GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
                bitmap.recycle();
                hashMap.put(new String[]{"stroke_5", "stroke_6", "stroke_3", "stroke_4", "dot", "speckles", "chalk"}[i2], b2);
            }
        }
        context.brushes = hashMap;
    }

    public static void a(Resources resources, co.polarr.renderer.entities.Context context, int i2) {
        d dVar;
        d dVar2 = context.imageTexture;
        int i3 = dVar2.f12b;
        int i4 = dVar2.c;
        if (i3 != 0 && i4 != 0) {
            int max = Math.max(0, (int) (Math.log((double) i2) / Math.log(2.0d)));
            int i5 = i3 >> max;
            int i6 = i4 >> max;
            s.b(context.writableTexture, i5, i6);
            s.b(context.readableTexture, i5, i6);
            s.b(context.dehazeTexture, i5, i6);
            s.b(context.denoiseTexture, i5, i6);
            float max2 = 1024.0f / ((float) Math.max(i3, i4));
            float f2 = (float) i3;
            int floor = (int) Math.floor((double) (f2 * max2));
            float f3 = (float) i4;
            int floor2 = (int) Math.floor((double) (max2 * f3));
            s.b(context.paintTexture, floor, floor2);
            d[] dVarArr = context.brushTextures;
            if (dVarArr != null) {
                for (d b2 : dVarArr) {
                    s.b(b2, floor, floor2);
                }
            }
            s.b(context.intermediateTexture, floor, floor2);
            GLES20.glDisable(3042);
            int[] iArr = context.textures;
            if (iArr == null || iArr.length <= 0) {
                dVar = context.imageTexture;
            } else {
                a(context, 0, context.readableTexture, (a.a.b.a.a.a) ba.a(resources, context), false);
                dVar = context.readableTexture;
            }
            float[] fArr = new float[15];
            float f4 = 1.0f / ((float) 15);
            float f5 = 1.0f / f2;
            float f6 = 1.0f / f3;
            for (int i7 = 0; i7 <= 7; i7++) {
                float exp = (float) Math.exp((double) (((float) (-(i7 * i7))) * f4));
                fArr[7 - i7] = exp;
                fArr[i7 + 7] = exp;
            }
            af a2 = af.a(resources, context);
            a2.a("delta", (Object) Float.valueOf(f5));
            a2.r = fArr;
            e a3 = e.a(resources, context);
            a3.a("delta", (Object) Float.valueOf(f6));
            a3.r = fArr;
            a(context, dVar.f11a, context.writableTexture, (a.a.b.a.a.a) a2, true);
            a(context, context.writableTexture.f11a, context.denoiseTexture, (a.a.b.a.a.a) a3, true);
            a(context, resources);
        }
    }

    public static void a(Resources resources, co.polarr.renderer.entities.Context context, d dVar) {
        if (dVar == null) {
            dVar = context.readableTexture;
        }
        be a2 = be.a(resources, context);
        a2.a(context);
        a2.r = new float[]{0.0f, (((float) dVar.f12b) / ((float) dVar.c)) * 0.036f};
        a(context, context.readableTexture.f11a, context.writableTexture, (a.a.b.a.a.a) a2, false);
        a2.r = new float[]{0.036f, 0.0f};
        a(context, context.writableTexture.f11a, dVar, (a.a.b.a.a.a) a2, false);
    }

    public static void a(Resources resources, co.polarr.renderer.entities.Context context, Point point) {
        d[] dVarArr = context.brushTextures;
        int i2 = 16;
        int[] iArr = new int[(dVarArr != null ? dVarArr.length + 16 : 16)];
        s.a(iArr.length, iArr, 0, 6408, point.x, point.y);
        int i3 = 0;
        context.imageTexture = s.b(iArr[0], 6408, point.x, point.y);
        context.dehazeTexture = s.b(iArr[1], 6408, point.x, point.y);
        context.denoiseTexture = s.b(iArr[2], 6408, point.x, point.y);
        context.cacheTexture = s.b(iArr[3], 6408, point.x, point.y);
        context.readableTexture = s.b(iArr[4], 6408, point.x, point.y);
        context.writableTexture = s.b(iArr[5], 6408, point.x, point.y);
        context.paintTexture = s.b(iArr[6], 6408, point.x, point.y);
        context.retouchTexture = s.b(iArr[7], 6408, point.x, point.y);
        context.intermediateTexture = s.b(iArr[8], 6408, point.x, point.y);
        context.lensBlurTexture = s.b(iArr[9], 6408, point.x, point.y);
        context.tempTexture = s.b(iArr[10], 6408, point.x, point.y);
        context.screenTexture = s.b(iArr[11], 6408, point.x, point.y);
        context.watermarkTexture = s.b(iArr[12], 6408, point.x, point.y);
        context.exportTexture = s.b(iArr[13], 6408, point.x, point.y);
        context.grainTexture = s.b(iArr[14], 6408, 1024, 1024);
        context.overlayTexture = s.b(iArr[15], 6408, 1000, 1000);
        if (context.brushTextures != null) {
            while (true) {
                d[] dVarArr2 = context.brushTextures;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                dVarArr2[i3] = s.b(iArr[i2], 6408, point.x, point.y);
                i3++;
                i2++;
            }
        }
        b(resources, context);
        a(resources, context);
    }

    public static void a(co.polarr.renderer.entities.Context context) {
        float[] fArr = context.compositeResolution;
        int i2 = (int) fArr[0];
        int i3 = (int) fArr[1];
        s.b(context.readableTexture, i2, i3);
        s.b(context.writableTexture, i2, i3);
    }

    public static void a(co.polarr.renderer.entities.Context context, float f2, float f3) {
        float[] b2 = q.b(context);
        Matrix.setIdentityM(context.scaleMatrix, 0);
        Matrix.scaleM(context.scaleMatrix, 0, (b2[0] / 2.0f) / f2, (b2[1] / 2.0f) / f3, 1.0f);
    }

    public static void a(co.polarr.renderer.entities.Context context, float f2, float f3, float f4, float f5) {
        Matrix.setIdentityM(context.cropMatrix, 0);
        Matrix.scaleM(context.cropMatrix, 0, f4, f5, 1.0f);
        Matrix.translateM(context.cropMatrix, 0, f2, f3, 0.0f);
    }

    public static void a(co.polarr.renderer.entities.Context context, float f2, float f3, boolean z2, boolean z3, float[] fArr) {
        float[] fArr2;
        float[] fArr3;
        co.polarr.renderer.entities.Context context2 = context;
        if (z3) {
            fArr2 = q.b(context);
        } else {
            d dVar = context2.imageTexture;
            fArr2 = new float[]{(float) dVar.f12b, (float) dVar.c};
        }
        float f4 = fArr2[0] / 2.0f;
        float f5 = fArr2[1] / 2.0f;
        float[] a2 = q.a(context);
        float[] fArr4 = fArr != null ? new float[]{a2[0] + fArr[0], a2[1] + fArr[1], (float) Math.floor((double) (a2[2] * fArr[2])), (float) Math.floor((double) (a2[3] * fArr[3]))} : a2;
        if (z3) {
            float f6 = fArr4[0];
            float f7 = context2.cropScale;
            fArr3 = new float[]{((f6 - f4) * f7) + f4, ((fArr4[1] - f5) * f7) + f5, fArr4[2] * f7, fArr4[3] * f7};
        } else {
            fArr3 = new float[]{0.0f, 0.0f, fArr2[0], fArr2[1]};
        }
        float f8 = ((-(fArr2[0] - fArr3[2])) / 2.0f) + fArr3[0];
        float f9 = ((-(fArr2[1] - fArr3[3])) / 2.0f) + fArr3[1];
        float f10 = fArr3[2] / fArr2[0];
        float f11 = fArr3[3] / fArr2[1];
        float f12 = f8 / fArr3[2];
        float f13 = f9 / fArr3[3];
        float f14 = z2 ? -1.0f : 1.0f;
        e(context);
        b(context, -f8, -f9);
        a(context, f10, f14 * f11);
        c(context);
        a(context, f12 * 2.0f, f13 * 2.0f, f10, f11);
        int i2 = (int) f2;
        int i3 = (int) f3;
        s.b(context2.readableTexture, i2, i3);
        s.b(context2.writableTexture, i2, i3);
    }

    public static void a(co.polarr.renderer.entities.Context context, int i2, d dVar, a.a.b.a.a.a aVar, boolean z2) {
        if (i2 != dVar.f11a) {
            c a2 = c.a(context);
            a2.a(aVar);
            a2.b(dVar.f11a);
            a2.a(o.a());
            a2.b(dVar.f12b, dVar.c);
            if (i2 != 0) {
                a2.a(i2);
            }
            a2.draw();
        }
    }

    public static void a(co.polarr.renderer.entities.Context context, Resources resources) {
        co.polarr.renderer.entities.Context context2 = context;
        Resources resources2 = resources;
        a.a.b.a.g a2 = a.a.b.a.g.a(resources2, context2);
        a.a.b.a.r a3 = a.a.b.a.r.a(resources2, context2);
        an a4 = an.a(resources2, context2);
        f a5 = f.a(resources2, context2);
        a.a.b.a.p a6 = a.a.b.a.p.a(resources2, context2);
        w a7 = w.a(resources2, context2);
        aj a8 = aj.a(resources2, context2);
        d dVar = context2.imageTexture;
        float f2 = (float) dVar.f12b;
        float f3 = (float) dVar.c;
        float max = 512.0f / Math.max(f2, f3);
        int i2 = (int) (f2 * max);
        int i3 = (int) (f3 * max);
        s.b(context2.writableTexture, i2, i3);
        s.b(context2.readableTexture, i2, i3);
        int[] iArr = new int[3];
        s.a(iArr.length, iArr, 0, 6408, i2, i3);
        d b2 = s.b(iArr[0], 6408, i2, i3);
        d b3 = s.b(iArr[1], 6408, i2, i3);
        d b4 = s.b(iArr[2], 6408, i2, i3);
        d dVar2 = context2.denoiseTexture;
        a(context2, a3, a4, dVar2, b4);
        a8.r = co.polarr.renderer.entities.Context.overlayMesh;
        a(context2, dVar2.f11a, b3, (a.a.b.a.a.a) a8, true);
        co.polarr.renderer.entities.Context context3 = context;
        a.a.b.a.g gVar = a2;
        d dVar3 = b2;
        d dVar4 = dVar2;
        d a9 = a(context3, gVar, dVar2, dVar3, 8.0f, (Float) null);
        d dVar5 = b3;
        d dVar6 = b3;
        d dVar7 = a9;
        d a10 = a(context3, gVar, dVar5, dVar6, 8.0f, (Float) null);
        d dVar8 = b4;
        d dVar9 = b4;
        d dVar10 = a10;
        d a11 = a(context3, gVar, dVar8, dVar9, 48.0f, (Float) null);
        a6.r = dVar7.f11a;
        a6.s = dVar10.f11a;
        a6.t = a11.f11a;
        a6.u = co.polarr.renderer.entities.Context.overlayMesh;
        a(context2, 0, context2.writableTexture, (a.a.b.a.a.a) a6, true);
        d dVar11 = context2.writableTexture;
        a7.r = dVar7.f11a;
        a7.s = a11.f11a;
        a7.t = dVar11.f11a;
        a7.u = co.polarr.renderer.entities.Context.overlayMesh;
        a(context2, 0, dVar10, (a.a.b.a.a.a) a7, true);
        Float valueOf = Float.valueOf(48.0f);
        co.polarr.renderer.entities.Context context4 = context;
        d dVar12 = a11;
        d a12 = a(context4, gVar, dVar10, dVar10, 8.0f, valueOf);
        a5.r = a(context4, gVar, dVar11, dVar11, 8.0f, valueOf).f11a;
        a5.s = a12.f11a;
        a5.t = dVar4.f11a;
        a5.u = co.polarr.renderer.entities.Context.overlayMesh;
        a(context2, 0, context2.dehazeTexture, (a.a.b.a.a.a) a5, true);
        a(dVar7);
        a(dVar10);
        a(dVar12);
    }

    public static void b() {
        b a2 = a();
        synchronized (a2.f19a) {
            Iterator it = a2.f19a.iterator();
            while (it.hasNext()) {
                GLES20.glDeleteProgram(((Integer) it.next()).intValue());
            }
            a2.f19a.clear();
        }
        synchronized (a2.c) {
            int[] iArr = new int[a2.c.size()];
            Iterator it2 = a2.c.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr[i2] = ((Integer) it2.next()).intValue();
                i2++;
            }
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
            a2.c.clear();
        }
        synchronized (a2.f20b) {
            int[] iArr2 = new int[a2.f20b.size()];
            Iterator it3 = a2.f20b.iterator();
            int i3 = 0;
            while (it3.hasNext()) {
                iArr2[i3] = ((Integer) it3.next()).intValue();
                i3++;
            }
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
            a2.f20b.clear();
        }
    }

    public static void b(int i2) {
        b a2 = a();
        synchronized (a2.f19a) {
            a2.f19a.add(Integer.valueOf(i2));
        }
    }

    public static void b(Resources resources, co.polarr.renderer.entities.Context context) {
        String[] strArr = {"mosaic_pattern_00.png", "mosaic_pattern_01.png", "mosaic_pattern_02.png", "mosaic_pattern_03.png", "mosaic_pattern_04.png"};
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (Build.VERSION.SDK_INT >= 19) {
                options.inPremultiplied = false;
            }
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(resources.getAssets().open("paint/" + strArr[i2]), (Rect) null, options);
            } catch (IOException unused) {
            }
            if (bitmap != null) {
                int[] iArr = new int[1];
                s.a(iArr.length, iArr, 0, 6408, bitmap.getWidth(), bitmap.getHeight());
                d b2 = s.b(iArr[0], 6408, bitmap.getWidth(), bitmap.getHeight());
                GLES20.glBindTexture(3553, b2.f11a);
                GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
                bitmap.recycle();
                hashMap.put(new String[]{"square", "hexagon", "dot", "triangle", "diamond"}[i2], b2);
            }
        }
        context.patterns = hashMap;
    }

    public static void b(co.polarr.renderer.entities.Context context) {
        d dVar = context.readableTexture;
        context.readableTexture = context.writableTexture;
        context.writableTexture = dVar;
    }

    public static void b(co.polarr.renderer.entities.Context context, float f2, float f3) {
        d dVar = context.imageTexture;
        float[] fArr = {(float) dVar.f12b, (float) dVar.c};
        Matrix.setIdentityM(context.translationMatrix, 0);
        Matrix.translateM(context.translationMatrix, 0, (f2 / fArr[0]) * 2.0f, (f3 / fArr[1]) * 2.0f, 0.0f);
    }

    public static void c(int i2) {
        b a2 = a();
        synchronized (a2.f20b) {
            if (!a2.f20b.contains(Integer.valueOf(i2))) {
                a2.f20b.add(Integer.valueOf(i2));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: a.a.b.a.ay} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: a.a.b.a.bg} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: a.a.b.a.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: a.a.b.a.o} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: a.a.b.a.l} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: a.a.b.a.l} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.res.Resources r16, co.polarr.renderer.entities.Context r17) {
        /*
            r0 = r17
            java.util.Map<java.lang.String, java.lang.Object> r1 = r0.renderStates
            java.lang.String r2 = "local_adjustments"
            java.lang.Object r1 = r1.get(r2)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0179
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0016
            goto L_0x0179
        L_0x0016:
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 0
            r4 = r2
            r2 = r3
        L_0x001e:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0179
            java.lang.Object r5 = r1.next()
            co.polarr.renderer.entities.Adjustment r5 = (co.polarr.renderer.entities.Adjustment) r5
            java.lang.String r6 = r5.type
            java.lang.String r7 = "brush"
            boolean r6 = r7.equals(r6)
            java.lang.String r8 = "paint"
            if (r6 == 0) goto L_0x003f
            java.lang.String r6 = r5.brush_mode
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x003f
            goto L_0x001e
        L_0x003f:
            co.polarr.renderer.entities.Context$LocalState r6 = r5.adjustments
            float r6 = r6.blur
            r9 = 1069547520(0x3fc00000, float:1.5)
            float r6 = r6 / r9
            r9 = 1
            int r10 = java.lang.Math.min(r9, r2)
            float r10 = (float) r10
            java.lang.String r11 = r5.type
            java.lang.String r12 = "radial"
            boolean r11 = r12.equals(r11)
            r12 = 2
            r13 = 1065353216(0x3f800000, float:1.0)
            r14 = 0
            if (r11 == 0) goto L_0x0087
            a.a.b.a.o r4 = a.a.b.a.o.a(r16, r17)
            float r7 = r5.feather
            r4.r = r7
            float[] r7 = r5.size
            r4.v = r7
            float[] r7 = r5.position
            float[] r7 = java.util.Arrays.copyOf(r7, r12)
            r4.u = r7
            float[] r7 = r4.u
            r8 = r7[r9]
            float r8 = -r8
            r7[r9] = r8
            float r7 = r5.angle
            float r7 = -r7
            r4.t = r7
            boolean r5 = r5.invert
            if (r5 == 0) goto L_0x007f
            r14 = r13
        L_0x007f:
            r4.s = r14
            r4.w = r6
            r4.x = r10
            goto L_0x0167
        L_0x0087:
            java.lang.String r11 = r5.type
            java.lang.String r15 = "gradient"
            boolean r11 = r15.equals(r11)
            if (r11 == 0) goto L_0x00c9
            a.a.b.a.a r4 = a.a.b.a.a.a(r16, r17)
            float[] r7 = r5.startPoint
            float[] r7 = java.util.Arrays.copyOf(r7, r12)
            r4.r = r7
            float[] r7 = r4.r
            r8 = r7[r9]
            float r8 = -r8
            r7[r9] = r8
            float[] r7 = r5.endPoint
            float[] r7 = java.util.Arrays.copyOf(r7, r12)
            r4.s = r7
            float[] r7 = r4.s
            r8 = r7[r9]
            float r8 = -r8
            r7[r9] = r8
            boolean r7 = r5.invert
            if (r7 == 0) goto L_0x00b9
            r7 = r13
            goto L_0x00ba
        L_0x00b9:
            r7 = r14
        L_0x00ba:
            r4.t = r7
            boolean r5 = r5.reflect
            if (r5 == 0) goto L_0x00c1
            r14 = r13
        L_0x00c1:
            r4.u = r14
            r4.v = r6
            r4.w = r10
            goto L_0x0167
        L_0x00c9:
            java.lang.String r11 = r5.type
            java.lang.String r15 = "luminance"
            boolean r11 = r15.equals(r11)
            if (r11 == 0) goto L_0x00f0
            a.a.b.a.bg r4 = a.a.b.a.bg.a(r16, r17)
            float r7 = r5.target
            r4.r = r7
            float r7 = r5.range
            r4.s = r7
            boolean r7 = r5.invert
            if (r7 == 0) goto L_0x00e4
            r14 = r13
        L_0x00e4:
            r4.u = r14
            float r5 = r5.smoothness
            r4.t = r5
            r4.v = r6
            r4.w = r10
            goto L_0x0167
        L_0x00f0:
            java.lang.String r11 = r5.type
            java.lang.String r15 = "color"
            boolean r11 = r15.equals(r11)
            if (r11 == 0) goto L_0x0143
            a.a.b.a.ay r4 = a.a.b.a.ay.a(r16, r17)
            float r7 = r5.feather
            r4.r = r7
            float r7 = r5.threshold
            r4.u = r7
            float[] r7 = r5.size
            r4.w = r7
            float[] r7 = r5.position
            float[] r7 = java.util.Arrays.copyOf(r7, r12)
            r4.v = r7
            float[] r7 = r4.v
            r8 = r7[r9]
            float r8 = -r8
            r7[r9] = r8
            boolean r7 = r5.invert
            if (r7 == 0) goto L_0x011f
            r7 = r13
            goto L_0x0120
        L_0x011f:
            r7 = r14
        L_0x0120:
            r4.s = r7
            boolean r7 = r5.useRadius
            if (r7 == 0) goto L_0x0128
            r7 = r13
            goto L_0x0129
        L_0x0128:
            r7 = r14
        L_0x0129:
            r4.t = r7
            float[] r7 = r5.selectedColor
            if (r7 == 0) goto L_0x0130
            goto L_0x0132
        L_0x0130:
            float[] r7 = f15a
        L_0x0132:
            r4.z = r7
            float[] r5 = r5.selectedColor
            if (r5 == 0) goto L_0x013c
            int r5 = r5.length
            if (r5 <= 0) goto L_0x013c
            r14 = r13
        L_0x013c:
            r4.A = r14
            r4.x = r6
            r4.y = r10
            goto L_0x0167
        L_0x0143:
            java.lang.String r9 = r5.type
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0167
            java.lang.String r7 = r5.brush_mode
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0154
            goto L_0x0167
        L_0x0154:
            a.a.b.a.l r4 = a.a.b.a.l.a(r16, r17)
            float[] r7 = r5.channel
            r4.s = r7
            boolean r5 = r5.invert
            if (r5 == 0) goto L_0x0161
            r14 = r13
        L_0x0161:
            r4.r = r14
            r4.t = r6
            r4.u = r10
        L_0x0167:
            if (r4 == 0) goto L_0x0175
            a.a.b.b.d r5 = r0.readableTexture
            int r5 = r5.f11a
            a.a.b.b.d r6 = r0.writableTexture
            a((co.polarr.renderer.entities.Context) r0, (int) r5, (a.a.b.b.d) r6, (a.a.b.a.a.a) r4, (boolean) r3)
            b((co.polarr.renderer.entities.Context) r17)
        L_0x0175:
            int r2 = r2 + 1
            goto L_0x001e
        L_0x0179:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.b.g.c(android.content.res.Resources, co.polarr.renderer.entities.Context):void");
    }

    public static void c(co.polarr.renderer.entities.Context context) {
        Matrix.setIdentityM(context.matrix, 0);
        float[] fArr = context.matrix;
        Matrix.multiplyMM(fArr, 0, fArr, 0, context.projectionMatrix, 0);
        float[] fArr2 = context.matrix;
        Matrix.multiplyMM(fArr2, 0, fArr2, 0, context.scaleMatrix, 0);
        float[] fArr3 = context.matrix;
        Matrix.multiplyMM(fArr3, 0, fArr3, 0, context.translationMatrix, 0);
        float[] fArr4 = context.matrix;
        context.viewMatrix = Arrays.copyOf(fArr4, fArr4.length);
        if (!context.cropMode) {
            float[] fArr5 = context.matrix;
            Matrix.multiplyMM(fArr5, 0, fArr5, 0, context.projectionMatrix, 0);
            float[] fArr6 = context.matrix;
            Matrix.multiplyMM(fArr6, 0, fArr6, 0, context.rotationMatrix, 0);
            float[] fArr7 = context.matrix;
            Matrix.multiplyMM(fArr7, 0, fArr7, 0, context.projectionMatrixInv, 0);
            float[] fArr8 = context.matrix;
            Matrix.multiplyMM(fArr8, 0, fArr8, 0, context.rotation90Matrix, 0);
        }
        Matrix.invertM(context.matrixInv, 0, context.matrix, 0);
    }

    public static void d(int i2) {
        b a2 = a();
        synchronized (a2.c) {
            int indexOf = a2.c.indexOf(Integer.valueOf(i2));
            if (indexOf >= 0) {
                a2.c.remove(indexOf);
            }
        }
    }

    public static void d(Resources resources, co.polarr.renderer.entities.Context context) {
        a(resources, context, 2);
    }

    public static void d(co.polarr.renderer.entities.Context context) {
        float[] b2 = q.b(context);
        float f2 = b2[0];
        float f3 = b2[1];
        Matrix.orthoM(context.projectionMatrix, 0, f2 / -2.0f, f2 / 2.0f, f3 / -2.0f, f3 / 2.0f, -9999.0f, 9999.0f);
        Matrix.invertM(context.projectionMatrixInv, 0, context.projectionMatrix, 0);
    }

    public static void e(int i2) {
        b a2 = a();
        synchronized (a2.f20b) {
            int indexOf = a2.f20b.indexOf(Integer.valueOf(i2));
            if (indexOf >= 0) {
                a2.f20b.remove(indexOf);
            }
        }
    }

    public static void e(Resources resources, co.polarr.renderer.entities.Context context) {
        float f2;
        float f3;
        co.polarr.renderer.entities.Context context2 = context;
        ArrayList arrayList = (ArrayList) context2.renderStates.get("text");
        if (!arrayList.isEmpty()) {
            bi a2 = bi.a(resources, context);
            if (((Boolean) context2.renderStates.get("textInverted")).booleanValue()) {
                a2.r = (float[]) context2.renderStates.get("textInvertedColor");
                f2 = 22.0f;
                f3 = 1.0f;
            } else {
                a2.r = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
                f3 = -1.0f;
                f2 = -1.0f;
            }
            a(context2, context2.readableTexture.f11a, context2.writableTexture, (a.a.b.a.a.a) a2, false);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (context2.textLayers.size() > i2) {
                    d dVar = context2.textLayers.get(i2);
                    TextItem textItem = (TextItem) arrayList.get(i2);
                    if (!(dVar == null || textItem == null || textItem.disabled)) {
                        at a3 = at.a(resources, context);
                        float[] a4 = u.a(textItem, context2, dVar);
                        float[] matrix = a3.getMatrix();
                        Object a5 = a.a.b.f.a("flip_x", context2.renderStates);
                        boolean booleanValue = a5 instanceof Boolean ? ((Boolean) a5).booleanValue() : false;
                        Object a6 = a.a.b.f.a("flip_y", context2.renderStates);
                        boolean booleanValue2 = a6 instanceof Boolean ? ((Boolean) a6).booleanValue() : false;
                        float[] fArr = matrix;
                        Matrix.multiplyMM(matrix, 0, context2.matrix, 0, a4, 0);
                        Matrix.scaleM(fArr, 0, booleanValue ? -1.0f : 1.0f, booleanValue2 ? -1.0f : 1.0f, 1.0f);
                        a3.a(fArr);
                        a3.w = fArr;
                        a3.r = dVar;
                        a3.s = textItem.f1430color;
                        a3.t = f3 > 0.0f ? f3 : textItem.opacity;
                        a3.u = f2 > 0.0f ? f2 : textItem.blendMode;
                        a3.v = textItem.blendMix;
                        s.a(true, false);
                        a(context2, context2.readableTexture.f11a, context2.writableTexture, (a.a.b.a.a.a) a3, false);
                        s.a(false, false);
                    }
                }
            }
            b(context);
        }
    }

    public static void e(co.polarr.renderer.entities.Context context) {
        float floatValue = ((Float) a.a.b.f.a("rotation", context.renderStates)).floatValue();
        context.rotation = floatValue;
        float[] b2 = q.b(context);
        double d2 = ((double) floatValue) * 0.017453292519943295d;
        double abs = Math.abs(Math.cos(d2));
        double abs2 = Math.abs(Math.sin(d2));
        double d3 = (double) (b2[0] / 2.0f);
        double d4 = (double) (b2[1] / 2.0f);
        context.cropScale = (float) Math.min(d3 / ((d3 * abs) + (d4 * abs2)), d4 / ((d3 * abs2) + (abs * d4)));
        context.cropScale = Math.min(1.0f, context.cropScale);
        Object a2 = a.a.b.f.a("flip_x", context.renderStates);
        boolean booleanValue = a2 instanceof Boolean ? ((Boolean) a2).booleanValue() : false;
        Object a3 = a.a.b.f.a("flip_y", context.renderStates);
        boolean booleanValue2 = a3 instanceof Boolean ? ((Boolean) a3).booleanValue() : false;
        int floatValue2 = (((int) ((Float) context.renderStates.get("rotate90")).floatValue()) + 4) % 4;
        context.renderStates.put("rotate90", Float.valueOf((float) floatValue2));
        if (floatValue2 % 2 == 1) {
            if (booleanValue && !booleanValue2) {
                booleanValue = false;
                booleanValue2 = true;
            } else if (!booleanValue && booleanValue2) {
                booleanValue2 = false;
                booleanValue = true;
            }
        }
        Matrix.setIdentityM(context.rotationMatrix, 0);
        Matrix.rotateM(context.rotationMatrix, 0, context.rotation, 0.0f, 0.0f, 1.0f);
        o.a(context.rotationMatrix, booleanValue, booleanValue2);
        Matrix.setIdentityM(context.rotation90Matrix, 0);
        Matrix.rotateM(context.rotation90Matrix, 0, (float) (floatValue2 * 90), 0.0f, 0.0f, 1.0f);
        Matrix.invertM(context.rotation90MatrixInv, 0, context.rotation90Matrix, 0);
    }

    public static void f(Resources resources, co.polarr.renderer.entities.Context context) {
        s.a(true, true);
        a(context, context.readableTexture.f11a, context.writableTexture, (a.a.b.a.a.a) aa.a(resources, context), false);
        b(context);
        s.a(false, false);
    }

    public final void a(co.polarr.renderer.entities.Context context, a.a.b.a.a.a aVar, a.a.b.a.a.d dVar) {
        dVar.b(aVar);
        GLES20.glEnable(3042);
        GLES20.glBlendEquation(32774);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        context.overlayMask = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
        n nVar = this.p;
        nVar.r = 1.0f;
        dVar.b(nVar);
        GLES20.glDisable(3042);
    }

    public void a(Runnable runnable) {
        this.A.add(runnable);
    }

    public final void a(List<Bitmap> list) {
        List<Bitmap> list2 = list;
        r.a();
        if (i().imageTexture == null) {
            a(this.k, i(), this.q);
        } else {
            o();
        }
        if (i().textures != null && i().textures.length > 0) {
            GLES20.glDeleteTextures(4, i().textures, 0);
            GLES20.glFlush();
            i().textures = new int[0];
        }
        if (list.size() == 1) {
            GLES20.glBindTexture(3553, i().imageTexture.f11a);
            s.b();
            GLUtils.texImage2D(3553, 0, 6408, list2.get(0), 0);
        } else {
            i().textures = new int[4];
            s.a(i().textures.length, i().textures, 0, 6408, list2.get(0).getWidth(), list2.get(0).getHeight());
            for (int i2 = 0; i2 < 4; i2++) {
                GLES20.glBindTexture(3553, i().textures[i2]);
                s.b();
                GLES20.glTexImage2D(3553, 0, 6408, list2.get(i2).getWidth(), list2.get(i2).getHeight(), 0, 6408, 5121, (Buffer) null);
                GLUtils.texImage2D(3553, 0, 6408, list2.get(i2), 0);
            }
            i().imageTexture.f12b = this.q.x;
            i().imageTexture.c = this.q.y;
        }
        d(this.k, i());
        d dVar = i().screenTexture;
        Point point = this.t;
        s.b(dVar, point.x, point.y);
        this.u = true;
    }

    public final void a(boolean z2, d dVar, boolean z3) {
        a aVar = new a(z2, dVar, z3);
        d dVar2 = this.g;
        if (dVar2 != null) {
            dVar2.a((Runnable) aVar);
        }
        GLSurfaceView gLSurfaceView = this.h;
        if (gLSurfaceView != null) {
            gLSurfaceView.queueEvent(aVar);
        }
    }

    public final void a(boolean z2, d dVar, boolean z3, boolean z4) {
        float f2;
        float f3;
        if ((!z2 || !this.f) && this.l != null && i().writableTexture != null && i().writableTexture.c != 0 && i().photoLoaded) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f = true;
            if (z2) {
                e();
            }
            if (!this.z) {
                this.C.a(i(), false);
                a.a.b.e.f.a(i(), this.k);
            }
            a.a.b.a.a.a a2 = (i().textures == null || i().textures.length <= 0) ? y.a(this.k, i()) : bb.a(this.k, i());
            a2.a(i().matrix);
            c a3 = c.a(i());
            a3.a(a2);
            a3.b(i().readableTexture.f11a);
            a3.b(i().readableTexture.f12b, i().readableTexture.c);
            a3.a(i().imageTexture.f11a);
            if (this.z) {
                Mesh mesh = i().mesh;
                i().mesh = co.polarr.renderer.entities.Context.DefaultMesh;
                a3.draw();
                i().mesh = mesh;
            } else {
                a3.draw();
            }
            if (!this.z) {
                s.a(false, false);
                k.a((List<FaceItem>) (List) i().renderStates.get("faces"), this.k, i());
                if (i().readableTexture != null) {
                    this.l.a(i().readableTexture.f11a);
                    this.l.v();
                    List list = (List) i().renderStates.get("spots");
                    if (list != null && !list.isEmpty()) {
                        v a4 = (i().textures == null || i().textures.length <= 0) ? v.a(this.k, i()) : bo.b(this.k, i());
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            SpotItem spotItem = (SpotItem) list.get(i2);
                            a4.r = spotItem.feather;
                            a4.s = spotItem.size;
                            a4.t = a.a.b.e.a.a(spotItem.position);
                            a4.u = a.a.b.e.a.a(spotItem.sourcePosition);
                            a4.v = spotItem.angle;
                            a4.w = spotItem.opacity;
                            a4.x = spotItem.mode;
                            this.l.b(a4);
                        }
                    }
                    this.l.n();
                    List list2 = (List) i().renderStates.get("faces");
                    int i3 = 0;
                    while (i3 < list2.size()) {
                        try {
                            FaceItem faceItem = (FaceItem) list2.get(i3);
                            f fVar = i().faceMasks[i3];
                            if (faceItem.adjustments != null) {
                                bj a5 = bj.a(this.k, i());
                                a5.r = fVar;
                                a5.s = faceItem.adjustments;
                                this.l.b(a5);
                            }
                            i3++;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    a.a.b.a.a.a a6 = a(this.k, i(), this.l, this.m);
                    if (z4) {
                        a(i(), this.l.q(), i().readableTexture, (a.a.b.a.a.a) Basic.a(this.k, i()), false);
                        this.l.o();
                        return;
                    }
                    Object obj = i().renderStates.get("blur_opacity");
                    if ((((obj instanceof Integer) && ((Integer) obj).intValue() != 0) || ((obj instanceof Float) && ((Float) obj).floatValue() != 0.0f)) && i().lensBlurTexture.f12b != 1) {
                        this.l.b(bd.a(this.k, i()));
                    }
                    if (a6 != null) {
                        a(i(), a6, this.l);
                    }
                    this.l.o();
                    a(i(), this.l.q(), i().readableTexture, (a.a.b.a.a.a) Basic.a(this.k, i()), false);
                    e(this.k, i());
                    if (!i().cropMode && i().watermarkTexture != null && (i().watermarkOptions.enabled || i().watermarkOptions.preview)) {
                        a.a.b.a.a.a a7 = (i().textures == null || i().textures.length <= 0) ? m.a(this.k, i()) : aq.a(this.k, i());
                        a7.a(i().matrix);
                        c a8 = c.a(i());
                        a8.a(a7);
                        a8.b(i().writableTexture.f11a);
                        a8.b(i().readableTexture.f12b, i().readableTexture.c);
                        a8.a(i().readableTexture.f11a);
                        a8.draw();
                        b(i());
                        f(this.k, i());
                    }
                    if (dVar != null) {
                        if (dVar == i().cacheTexture) {
                            if (i().cropMode) {
                                f2 = (float) i().imageTexture.f12b;
                                f3 = (float) i().imageTexture.c;
                            } else {
                                float[] a9 = q.a(i());
                                float f4 = a9[2];
                                f3 = a9[3];
                                f2 = f4;
                            }
                            Point point = this.t;
                            float min = Math.min(((float) point.x) / f2, ((float) point.y) / f3);
                            s.b(dVar, (int) (f2 * min), (int) (f3 * min));
                        }
                        a(i(), i().readableTexture.f11a, dVar, (a.a.b.a.a.a) Basic.a(this.k, i()), false);
                    }
                } else {
                    return;
                }
            }
            if (z2 && i().readableTexture != null) {
                a(i(), i().readableTexture.f11a, i().screenTexture, (a.a.b.a.a.a) Basic.a(this.k, i()), false);
                this.n.a(i().screenTexture.f11a);
                if (z3) {
                    this.F = System.currentTimeMillis();
                }
            }
            this.f = false;
            long currentTimeMillis2 = System.currentTimeMillis();
            float[] fArr = this.i;
            int i4 = this.j;
            this.j = i4 + 1;
            fArr[i4] = 1000.0f / ((float) (currentTimeMillis2 - currentTimeMillis));
            this.j %= fArr.length;
        }
    }

    public void b(List<a.a.b.a.a.a> list) {
        for (a.a.b.a.a.a a2 : list) {
            this.l.a(a2);
        }
    }

    public void c() {
        if (this.f) {
            k();
        } else {
            a(true, (d) null, true);
        }
    }

    public final boolean d() {
        float f2 = (float) c;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.E;
        if (j2 != 0) {
            f2 = 1000.0f / ((float) (currentTimeMillis - j2));
        }
        boolean z2 = false;
        if (System.currentTimeMillis() - this.F > 200 && !this.f) {
            this.F = Long.MAX_VALUE;
            Point point = this.t;
            this.l.b(point.x, point.y);
            a(true, (d) null, false, false);
            Point point2 = this.t;
            float f3 = f16b;
            this.l.b((int) (((float) point2.x) / f3), (int) (((float) point2.y) / f3));
        }
        this.E = System.currentTimeMillis();
        int i2 = this.e;
        if (i2 > 0) {
            this.e = i2 - 1;
            return this.e != 0;
        }
        float g2 = g();
        this.e = 0;
        if (g2 > 0.0f && g2 < 40.0f) {
            this.e = (int) Math.ceil((double) (60.0f / g2));
            z2 = true;
        }
        p pVar = this.B;
        if (pVar != null) {
            pVar.a(f2, g2, this.e - 1);
        }
        return z2;
    }

    public void e() {
        if (this.y.getAndSet(false)) {
            if (i().imageTexture == null) {
                float[] fArr = i().screenMatrix;
                Point point = this.q;
                int i2 = point.x;
                int i3 = point.y;
                Point point2 = this.t;
                o.a(fArr, 2, i2, i3, point2.x, point2.y);
                Point point3 = this.q;
                if (((float) point3.x) / ((float) point3.y) < 1.0f) {
                    o.a(i().screenMatrix, false, true);
                }
            }
            q();
            r();
        }
    }

    public final void f() {
        Vector vector = new Vector();
        while (true) {
            Runnable poll = this.A.poll();
            if (poll == null) {
                break;
            }
            vector.add(poll);
        }
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final float g() {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            float[] fArr = this.i;
            if (i2 >= fArr.length) {
                break;
            }
            if (fArr[i2] > 0.0f) {
                i4 = (int) (((float) i4) + fArr[i2]);
                i3++;
            }
            i2++;
        }
        if (i3 < 15) {
            return 0.0f;
        }
        return ((float) i4) / ((float) i3);
    }

    public float h() {
        co.polarr.renderer.entities.Context i2 = i();
        Point point = this.t;
        return q.a(i2, point.x, point.y, false, (float[]) null);
    }

    public final co.polarr.renderer.entities.Context i() {
        return a.f6a;
    }

    public final void j() {
        i().shaderUtil = t.a(this.k);
        this.l = new a.a.b.a.a.d(i(), this.k);
        this.q = new Point();
        this.t = new Point();
        this.n = new bc(this.k, i());
        this.o = new n(this.k, i());
        this.p = new n(this.k, i());
        this.v = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.y = new AtomicBoolean(false);
        b(t.a(this.k, i()));
        this.m = t.b(this.k, i());
        t.a((String) null, (List<FaceItem>) null, (List<Context.FaceFeaturesState>) null);
        this.A = new LinkedBlockingQueue();
    }

    public void k() {
        this.F = System.currentTimeMillis();
    }

    public void l() {
        a.f6a = new co.polarr.renderer.entities.Context();
        a.f6a.resources = this.k;
        r rVar = this.C;
        if (rVar != null) {
            rVar.e();
        }
        n();
        r.a();
    }

    public boolean m() {
        Bitmap bitmap;
        if (d() && this.g != null) {
            f();
            return true;
        } else if (this.v.getAndSet(false)) {
            List<Bitmap> list = this.r;
            if (list != null && !list.isEmpty()) {
                a(this.r);
                if (this.D) {
                    for (Bitmap recycle : this.r) {
                        recycle.recycle();
                    }
                }
                if (i().textures == null || i().textures.length <= 0) {
                    i().glRenderView.a(i().imageTexture.f11a);
                } else {
                    i().glRenderView.a(i().textures);
                }
                this.r = null;
            }
            co.polarr.renderer.entities.Context i2 = i();
            Point point = this.t;
            q.a(i2, (float) point.x, (float) point.y);
            i().screen.zoom = h();
            s();
            p();
            i().photoLoaded = true;
            c();
            bm bmVar = (bm) a.a.b.f.a((List<? extends a.a.b.a.a.a>) this.l.p(), bm.class);
            if (bmVar != null) {
                bmVar.l();
            }
            bl blVar = (bl) a.a.b.f.a((List<? extends a.a.b.a.a.a>) this.l.p(), bl.class);
            if (blVar != null) {
                blVar.l();
            }
            return false;
        } else {
            if (i().imageTexture != null && this.x.getAndSet(false)) {
                d(this.k, i());
            }
            if (i().imageTexture != null && this.w.getAndSet(false) && (bitmap = this.s) != null && !bitmap.isRecycled()) {
                s.b(i().watermarkTexture, this.s.getWidth(), this.s.getHeight());
                s.c(9729, 9729, 33071, 33071);
                GLUtils.texImage2D(3553, 0, 6408, this.s, 0);
                i().watermarkOptions.width = this.s.getWidth();
                i().watermarkOptions.height = this.s.getHeight();
                this.s.recycle();
                this.s = null;
            }
            if (!this.u || !i().photoLoaded) {
                i();
                float[] fArr = co.polarr.renderer.entities.Context.backgroundColor;
                GLES20.glClearColor(fArr[0], fArr[1], fArr[2], 1.0f);
                GLES20.glClear(16640);
            } else {
                Point point2 = this.t;
                GLES20.glViewport(0, 0, point2.x, point2.y);
                this.n.a(i().screenTexture.f11a);
                this.n.draw();
                GLES20.glEnable(3042);
                GLES20.glBlendEquation(32774);
                GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
                float[] a2 = o.a();
                Matrix.multiplyMM(a2, 0, a2, 0, i().overlayMatrix, 0);
                o.a(a2, false, true);
                n nVar = this.o;
                if (nVar.q) {
                    nVar.a(a2);
                    this.o.draw();
                }
                if (az.a(this.k, i()) != null && az.a(this.k, i()).r) {
                    az.a(this.k, i()).draw();
                }
                if (ai.a(this.k, i()) != null && ai.a(this.k, i()).u) {
                    ai.a(this.k, i()).draw();
                }
                GLES20.glDisable(3042);
            }
            f();
            return false;
        }
    }

    public final void n() {
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
        a.a.b.a.g.l();
        a.a.b.a.r.l();
        an.l();
        f.l();
        a.a.b.a.p.l();
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

    public final void o() {
        co.polarr.renderer.entities.Context i2 = i();
        d dVar = i2.imageTexture;
        Point point = this.q;
        s.a(dVar, point.x, point.y);
        i2.faceMasks = null;
    }

    public void onDrawFrame(GL10 gl10) {
        m();
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Point point = this.t;
        point.x = i2;
        point.y = i3;
        s();
        p();
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        i().glRenderView.e();
        a(this.k, i(), new Point(512, 512));
        this.n.a();
        this.l.a();
        for (a.a.b.a.a.b a2 : this.m) {
            a2.a();
        }
        this.o.a();
        this.p.a();
        this.C = new r(i(), this.k);
    }

    public final void p() {
        Point point = this.t;
        float f2 = f16b;
        int i2 = (int) (((float) point.x) / f2);
        int i3 = (int) (((float) point.y) / f2);
        this.l.b(i2, i3);
        for (a.a.b.a.a.b b2 : this.m) {
            b2.b(i2, i3);
        }
    }

    public void q() {
        co.polarr.renderer.entities.Context i2 = i();
        d(i2);
        float[] b2 = q.b(i2);
        Point point = this.t;
        float[] fArr = {(float) point.x, (float) point.y};
        float[] a2 = q.a(i2);
        float f2 = i2.cropScale;
        if (i2.cropMode) {
            a2 = new float[]{0.0f, 0.0f, b2[0], b2[1]};
            f2 = 1.0f;
        }
        float f3 = (float) ((int) (b2[0] / 2.0f));
        float f4 = (float) ((int) (b2[1] / 2.0f));
        float[] fArr2 = {((a2[0] - f3) * f2) + f3, ((a2[1] - f4) * f2) + f4, a2[2] * f2, a2[3] * f2};
        Context.Screen screen = i2.screen;
        float f5 = screen.zoom / f2;
        float[] fArr3 = {0.0f, 0.0f};
        float[] fArr4 = screen.offset;
        float f6 = fArr4[0] - fArr3[0];
        float f7 = fArr3[1] + fArr4[1];
        int i3 = (int) (fArr2[2] * f5);
        int i4 = (int) (fArr2[3] * f5);
        float f8 = (float) i3;
        int i5 = ((int) (fArr[0] - f8)) >> 1;
        float f9 = (float) i4;
        int i6 = ((int) (fArr[1] - f9)) >> 1;
        int i7 = (int) (((float) ((int) (((float) i5) - f6))) + ((fArr[0] % 2.0f) / 2.0f));
        int i8 = (int) (((float) ((int) (((float) i6) + f7))) + ((fArr[1] % 2.0f) / 2.0f));
        int i9 = (int) (((float) (i3 + i7)) - fArr[0]);
        int i10 = (int) (((float) (i4 + i8)) - fArr[1]);
        if (f8 < fArr[0]) {
            i9 = Math.max(0, i9) + Math.min(0, i7);
        }
        if (f9 < fArr[1]) {
            i10 = Math.min(0, i8) + Math.max(0, i10);
        }
        float min = Math.min(fArr[0] / f5, fArr2[2]);
        float min2 = Math.min(fArr[1] / f5, fArr2[3]);
        float f10 = ((b2[0] - fArr2[2]) / 2.0f) - fArr2[0];
        float f11 = f7;
        float f12 = ((b2[1] - fArr2[3]) / 2.0f) - fArr2[1];
        float f13 = f9;
        float[] fArr5 = fArr;
        co.polarr.renderer.entities.Context context = i2;
        float[] fArr6 = b2;
        float a3 = (float) ((((double) (((int) (fArr2[2] - min)) >> 1)) - a.a.b.e.a.a((double) ((int) (((float) i9) / f5)), 0.0d, (double) (fArr2[2] - min))) - ((double) f10));
        float f14 = min / fArr6[0];
        float f15 = min2 / fArr6[1];
        co.polarr.renderer.entities.Context context2 = context;
        context2.compositeResolution[0] = Math.min(fArr5[0], f8);
        context2.compositeResolution[1] = Math.min(fArr5[1], f13);
        double d2 = (double) f6;
        context2.compositeCoords[0] = (float) (a.a.b.e.a.a(d2, (double) i5, (double) (-i5)) - d2);
        double d3 = (double) f11;
        int i11 = i6;
        context2.compositeCoords[1] = (float) (a.a.b.e.a.a(d3, (double) i11, (double) (-i11)) - d3);
        float[] fArr7 = context2.compositeCoords;
        float f16 = fArr7[0];
        float[] fArr8 = context2.compositeResolution;
        fArr7[2] = f16 + fArr8[0];
        fArr7[3] = fArr7[1] + fArr8[1];
        e(context2);
        b(context2, -a3, -((float) ((((double) (((int) (fArr2[3] - min2)) >> 1)) - a.a.b.e.a.a((double) ((int) (((float) i10) / f5)), 0.0d, (double) (fArr2[3] - min2))) - ((double) f12))));
        a(context2, f14, f15);
        c(context2);
        a(context2, ((-f10) / fArr2[2]) * 2.0f, ((-f12) / fArr2[3]) * 2.0f, fArr2[2] / fArr6[0], fArr2[3] / fArr6[1]);
        q.d(context2);
        a(context2);
        context2.minZoom = q.a(context2, (int) fArr5[0], (int) fArr5[1], false, (float[]) null);
    }

    public void r() {
        this.n.a(i().screenMatrix);
    }

    public void s() {
        this.y.lazySet(true);
    }
}
