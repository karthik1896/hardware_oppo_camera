package co.polarr.renderer;

import a.a.b.e.o;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PolarrPainter {
    public static final float BUFFER_THES = 5.0f;
    public static final float DETLA_MOVEMENT = 10.0f;
    public static final PorterDuffXfermode K = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    public static final float MAX_FADE_THRES = 20.0f;
    public static final boolean USE_PATH_HISTORY = true;
    public PathMeasure A;
    public float B;
    public int C;
    public int D;
    public float E;
    public float F;
    public float G;
    public int H;
    public BrushStyle I;
    public Canvas J;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1415a;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f1416b;
    public Bitmap c;
    public Bitmap d;
    public Bitmap e;
    public Bitmap f;
    public Bitmap g;
    public Paint h;
    public Paint i;
    public Canvas j;
    public Canvas k;
    public Canvas l;
    public Canvas m;
    public float[] n;
    public float[] o;
    public Matrix p;
    public porender_qbdmL q = porender_qbdmL.IDLE;
    public BrushStyle r = null;
    public double s;
    public float t;
    public float u;
    public int v;
    public float[] w;
    public List<porender_iuAiH> x = new ArrayList();
    public int y;
    public Path z;

    public enum BrushStyle {
        MARKER("brush/brush8.png", 0.04f, 5.0f, 0.0f, 1, 0.8f, false),
        PENCIL("brush/dot10.png", 0.1f, 360.0f, 0.5f, 5, 1.0f, true),
        PAINTING("brush/pen2.png", 0.025f, 0.0f, 0.0f, 1, 1.0f, false);
        
        public final boolean canFade;
        public final int maxFlow;
        public final float maxRot;
        public final float paintAlpha;
        public final float randomRange;
        public final String resName;
        public final float spacing;

        /* access modifiers changed from: public */
        BrushStyle(String str, float f, float f2, float f3, int i, float f4, boolean z) {
            this.resName = str;
            this.spacing = f;
            this.maxRot = f2;
            this.randomRange = f3;
            this.maxFlow = i;
            this.paintAlpha = f4;
            this.canFade = z;
        }
    }

    public static /* synthetic */ class porender_YuvEf {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1417a = new int[porender_qbdmL.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                co.polarr.renderer.PolarrPainter$porender_qbdmL[] r0 = co.polarr.renderer.PolarrPainter.porender_qbdmL.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1417a = r0
                int[] r0 = f1417a     // Catch:{ NoSuchFieldError -> 0x0014 }
                co.polarr.renderer.PolarrPainter$porender_qbdmL r1 = co.polarr.renderer.PolarrPainter.porender_qbdmL.IDLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1417a     // Catch:{ NoSuchFieldError -> 0x001f }
                co.polarr.renderer.PolarrPainter$porender_qbdmL r1 = co.polarr.renderer.PolarrPainter.porender_qbdmL.START     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1417a     // Catch:{ NoSuchFieldError -> 0x002a }
                co.polarr.renderer.PolarrPainter$porender_qbdmL r1 = co.polarr.renderer.PolarrPainter.porender_qbdmL.MOVE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f1417a     // Catch:{ NoSuchFieldError -> 0x0035 }
                co.polarr.renderer.PolarrPainter$porender_qbdmL r1 = co.polarr.renderer.PolarrPainter.porender_qbdmL.DONE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: co.polarr.renderer.PolarrPainter.porender_YuvEf.<clinit>():void");
        }
    }

    public class porender_iuAiH {

        /* renamed from: a  reason: collision with root package name */
        public float f1418a;

        /* renamed from: b  reason: collision with root package name */
        public float f1419b;
        public int c;
        public float d;
        public boolean e;
        public BrushStyle f;
        public Path g;
        public boolean h;

        public porender_iuAiH(PolarrPainter polarrPainter) {
        }

        public /* synthetic */ porender_iuAiH(PolarrPainter polarrPainter, porender_YuvEf porender_yuvef) {
            this(polarrPainter);
        }
    }

    public enum porender_qbdmL {
        IDLE,
        START,
        MOVE,
        DONE
    }

    public PolarrPainter(Context context) {
        this.f1415a = context;
        this.n = new float[2];
        this.o = new float[2];
        this.w = new float[2];
        this.h = new Paint();
        this.i = new Paint();
        this.l = new Canvas();
        this.k = new Canvas();
        this.m = new Canvas();
        this.j = new Canvas();
        this.p = new Matrix();
        this.y = 0;
        updateBrushStyle(BrushStyle.MARKER);
    }

    public static Bitmap a(Bitmap bitmap, Rect rect) {
        Bitmap createBitmap = Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postTranslate((float) (-rect.left), (float) (-rect.top));
        canvas.drawBitmap(bitmap, matrix, (Paint) null);
        return createBitmap;
    }

    public final void a() {
        this.l.drawColor(0, PorterDuff.Mode.CLEAR);
        this.m.drawColor(0, PorterDuff.Mode.CLEAR);
        this.k.drawColor(0, PorterDuff.Mode.CLEAR);
        this.j.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0067, code lost:
        if (r9.v == co.polarr.renderer.PolarrPainter.porender_iuAiH.b(r10)) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r10) {
        /*
            r9 = this;
            android.graphics.Picture r0 = new android.graphics.Picture
            r0.<init>()
            android.graphics.Bitmap r1 = r9.e
            int r1 = r1.getWidth()
            android.graphics.Bitmap r2 = r9.e
            int r2 = r2.getHeight()
            android.graphics.Canvas r1 = r0.beginRecording(r1, r2)
            r9.l = r1
            java.util.List<co.polarr.renderer.PolarrPainter$porender_iuAiH> r1 = r9.x
            java.lang.Object r10 = r1.get(r10)
            co.polarr.renderer.PolarrPainter$porender_iuAiH r10 = (co.polarr.renderer.PolarrPainter.porender_iuAiH) r10
            boolean r1 = r10.h
            if (r1 == 0) goto L_0x0029
            r9.a()
            return
        L_0x0029:
            android.graphics.PathMeasure r1 = new android.graphics.PathMeasure
            r1.<init>()
            co.polarr.renderer.PolarrPainter$BrushStyle r2 = r10.f
            co.polarr.renderer.PolarrPainter$BrushStyle r3 = r9.r
            if (r2 == r3) goto L_0x004d
            co.polarr.renderer.PolarrPainter$BrushStyle r2 = r10.f
            r9.updateBrushStyle(r2)
        L_0x003d:
            float r2 = r10.f1419b
            float r3 = r10.d
            int r4 = r10.c
            r9.updateBrushSize(r2, r3, r4)
            goto L_0x006a
        L_0x004d:
            float r2 = r9.t
            float r3 = r10.f1419b
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x003d
            float r2 = r9.u
            float r3 = r10.d
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x003d
            int r2 = r9.v
            int r3 = r10.c
            if (r2 == r3) goto L_0x006a
            goto L_0x003d
        L_0x006a:
            r2 = 0
            r9.B = r2
            android.graphics.Path r3 = r10.g
            r4 = 0
            r1.setPath(r3, r4)
            float r3 = r10.f1418a
            float r5 = r9.B
            float r6 = r9.E
            r7 = 1084227584(0x40a00000, float:5.0)
            float r7 = r7 * r6
            r8 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 * r7
            float r5 = r5 + r8
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x008c
            float r3 = r3 - r7
            r9.a(r1, r3, r6, r4)
        L_0x008c:
            float r3 = r1.getLength()
            float r5 = r9.E
            boolean r10 = r10.e
            r9.a(r1, r3, r5, r10)
            r0.endRecording()
            android.graphics.Canvas r10 = r9.J
            r0.draw(r10)
            android.graphics.Paint r10 = r9.h
            r0 = 0
            r10.setXfermode(r0)
            android.graphics.Canvas r10 = r9.k
            float r1 = r9.u
            r3 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 * r3
            int r1 = (int) r1
            int r3 = r9.v
            int r3 = android.graphics.Color.red(r3)
            int r5 = r9.v
            int r5 = android.graphics.Color.green(r5)
            int r6 = r9.v
            int r6 = android.graphics.Color.blue(r6)
            int r1 = android.graphics.Color.argb(r1, r3, r5, r6)
            r10.drawColor(r1)
            android.graphics.Paint r10 = r9.h
            android.graphics.PorterDuffXfermode r1 = K
            r10.setXfermode(r1)
            android.graphics.Canvas r10 = r9.k
            android.graphics.Bitmap r1 = r9.e
            android.graphics.Paint r3 = r9.h
            r10.drawBitmap(r1, r2, r2, r3)
            android.graphics.Paint r10 = r9.h
            r10.setXfermode(r0)
            android.graphics.Canvas r10 = r9.j
            android.graphics.Bitmap r1 = r9.f1416b
            r10.drawBitmap(r1, r2, r2, r0)
            android.graphics.Canvas r10 = r9.k
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.CLEAR
            r10.drawColor(r4, r0)
            android.graphics.Canvas r10 = r9.J
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.CLEAR
            r10.drawColor(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: co.polarr.renderer.PolarrPainter.a(int):void");
    }

    public final void a(Bitmap bitmap, float f2) {
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (Color.alpha(i3) != 0) {
                int alpha = (int) (((float) Color.alpha(i3)) * f2);
                if (alpha > 0) {
                    iArr[i2] = Color.argb(alpha, Color.red(i3), Color.green(i3), Color.blue(i3));
                } else {
                    iArr[i2] = 0;
                }
            }
        }
        bitmap.setPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public final void a(PathMeasure pathMeasure, float f2, float f3, boolean z2) {
        float f4 = this.B;
        while (true) {
            float f5 = this.B;
            if (f5 >= f2) {
                break;
            }
            pathMeasure.getPosTan(f5, this.o, this.w);
            float[] fArr = this.w;
            double atan2 = Math.atan2((double) fArr[0], (double) fArr[1]);
            if (this.B == 0.0f) {
                this.s = atan2;
            }
            double max = Math.max(this.s - ((double) this.r.maxRot), Math.min(this.s + ((double) this.r.maxRot), atan2));
            double d2 = max;
            for (int i2 = 0; i2 < this.r.maxFlow; i2++) {
                if (this.r.randomRange > 0.0f) {
                    d2 = (Math.random() * 360.0d * ((double) this.r.randomRange)) + max;
                }
                this.p.reset();
                this.p.postTranslate(((float) (-this.C)) / 2.0f, (((float) (-this.D)) / 2.0f) + 0.0f);
                this.p.postRotate((float) d2, 0.0f, 0.0f);
                Matrix matrix = this.p;
                float[] fArr2 = this.o;
                matrix.postTranslate(fArr2[0], fArr2[1]);
                if (z2) {
                    this.i.setAlpha((int) (this.u * this.r.paintAlpha * 255.0f * ((f2 - this.B) / (f2 - f4))));
                }
                this.l.drawBitmap(this.g, this.p, this.i);
            }
            this.B += f3;
        }
        if (z2) {
            this.i = new Paint();
        }
    }

    public final void a(porender_qbdmL porender_qbdml, float[] fArr, float[] fArr2) {
        int i2 = porender_YuvEf.f1417a[porender_qbdml.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                float[] fArr3 = this.n;
                fArr3[0] = fArr[0];
                fArr3[1] = fArr[1];
                this.B = 0.0f;
                this.z = new Path();
                this.A = new PathMeasure();
                this.q = porender_qbdml;
                this.z.moveTo(fArr[0], fArr[1]);
                return;
            } else if (i2 != 3) {
                if (i2 == 4) {
                    float f2 = fArr[0];
                    float[] fArr4 = this.n;
                    this.z.quadTo(fArr4[0], fArr4[1], (f2 + fArr4[0]) / 2.0f, (fArr[1] + fArr4[1]) / 2.0f);
                    float[] fArr5 = this.n;
                    fArr5[0] = fArr[0];
                    fArr5[1] = fArr[1];
                    this.A.setPath(this.z, false);
                    float length = this.A.getLength();
                    boolean z2 = fArr2 != null && this.r.canFade && o.a(fArr2, this.n) > this.E * 20.0f;
                    porender_iuAiH porender_iuaih = new porender_iuAiH(this, (porender_YuvEf) null);
                    float unused = porender_iuaih.f1418a = this.B;
                    a(this.A, length, this.E, z2);
                    d();
                    Path unused2 = porender_iuaih.g = this.z;
                    BrushStyle unused3 = porender_iuaih.f = this.r;
                    float unused4 = porender_iuaih.f1419b = this.t;
                    int unused5 = porender_iuaih.c = this.v;
                    float unused6 = porender_iuaih.d = this.u;
                    boolean unused7 = porender_iuaih.e = z2;
                    this.y++;
                    this.x.add(porender_iuaih);
                    this.h.setXfermode((Xfermode) null);
                    this.k.drawColor(Color.argb((int) (this.u * 255.0f), Color.red(this.v), Color.green(this.v), Color.blue(this.v)));
                    this.h.setXfermode(K);
                    this.k.drawBitmap(this.e, 0.0f, 0.0f, this.h);
                    this.h.setXfermode((Xfermode) null);
                    this.j.drawBitmap(this.f1416b, 0.0f, 0.0f, (Paint) null);
                    this.k.drawColor(0, PorterDuff.Mode.CLEAR);
                    this.l.drawColor(0, PorterDuff.Mode.CLEAR);
                    porender_qbdml = porender_qbdmL.IDLE;
                } else {
                    return;
                }
            } else if (o.a(fArr, this.n) > 10.0f) {
                float f3 = fArr[0];
                float[] fArr6 = this.n;
                this.z.quadTo(fArr6[0], fArr6[1], (f3 + fArr6[0]) / 2.0f, (fArr[1] + fArr6[1]) / 2.0f);
                float[] fArr7 = this.n;
                fArr7[0] = fArr[0];
                fArr7[1] = fArr[1];
                this.A.setPath(this.z, false);
                float length2 = this.A.getLength();
                float f4 = this.B;
                float f5 = this.E;
                float f6 = 5.0f * f5;
                if (length2 > f4 + (2.0f * f6)) {
                    a(this.A, length2 - f6, f5, false);
                }
                this.m.drawColor(0, PorterDuff.Mode.CLEAR);
                this.k.drawColor(Color.argb((int) (this.u * 255.0f), Color.red(this.v), Color.green(this.v), Color.blue(this.v)));
                this.h.setXfermode(K);
                this.k.drawBitmap(this.e, 0.0f, 0.0f, this.h);
                this.h.setXfermode((Xfermode) null);
                this.m.drawBitmap(this.f1416b, 0.0f, 0.0f, (Paint) null);
                this.k.drawColor(0, PorterDuff.Mode.CLEAR);
            } else {
                return;
            }
        }
        this.q = porender_qbdml;
    }

    public void addPoint(float[] fArr) {
        a(porender_qbdmL.MOVE, fArr, (float[]) null);
    }

    public final int b() {
        for (int i2 = this.y - 1; i2 >= 0; i2--) {
            if (this.x.get(i2).h) {
                return i2;
            }
        }
        return 0;
    }

    public final void c() {
        a();
        f();
        for (int b2 = b(); b2 < this.y; b2++) {
            a(b2);
        }
        e();
    }

    public boolean canRedo() {
        return this.y < this.x.size();
    }

    public boolean canUndo() {
        return this.y > 0;
    }

    public void clear() {
        a();
        d();
        int i2 = this.y;
        if (i2 != 0 && !this.x.get(i2 - 1).h) {
            porender_iuAiH porender_iuaih = new porender_iuAiH(this, (porender_YuvEf) null);
            boolean unused = porender_iuaih.h = true;
            this.x.add(porender_iuaih);
            this.y++;
        }
    }

    public final void d() {
        while (this.x.size() > this.y) {
            List<porender_iuAiH> list = this.x;
            list.remove(list.size() - 1);
        }
    }

    public void draw(Canvas canvas) {
        if (this.f1416b != null) {
            canvas.drawBitmap(this.c, 0.0f, 0.0f, (Paint) null);
            if (this.q == porender_qbdmL.MOVE) {
                canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    public final void e() {
        updateBrushStyle(this.I);
        updateBrushSize(this.F, this.G, this.H);
        this.l = this.J;
        this.l.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public void endBrush(float[] fArr, float[] fArr2) {
        a(porender_qbdmL.DONE, fArr, fArr2);
    }

    public final void f() {
        this.F = this.t;
        this.G = this.u;
        this.H = this.v;
        this.I = this.r;
        this.J = this.l;
    }

    public Bitmap getLastPaintBitmap() {
        return this.c;
    }

    public void redo() {
        if (canRedo()) {
            f();
            a(this.y);
            e();
            this.y++;
        }
    }

    public void reset() {
        clear();
        this.x.clear();
        this.y = 0;
    }

    public void setLastPaintBitmap(Bitmap bitmap) {
        Canvas canvas = this.j;
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.j.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public void startBrush(float[] fArr) {
        a(porender_qbdmL.START, fArr, (float[]) null);
    }

    public void undo() {
        if (canUndo()) {
            this.y--;
            c();
        }
    }

    public void updateBrushSize(float f2, float f3, int i2) {
        Bitmap bitmap;
        this.t = f2;
        this.u = f3;
        this.v = i2;
        if (f2 == 0.0f) {
            f2 = 1.0f;
        }
        if (f2 == 1.0f) {
            bitmap = this.f.copy(Bitmap.Config.ARGB_8888, true);
        } else if (this.f.getWidth() != this.f.getHeight()) {
            Bitmap bitmap2 = this.f;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, bitmap2.getWidth(), (int) (((float) this.f.getHeight()) * f2), false);
            bitmap = a(createScaledBitmap, new Rect(0, 0, (int) (((float) this.f.getWidth()) * f2), createScaledBitmap.getHeight()));
        } else {
            Bitmap bitmap3 = this.f;
            bitmap = Bitmap.createScaledBitmap(bitmap3, (int) (((float) bitmap3.getWidth()) * f2), (int) (((float) this.f.getHeight()) * f2), false);
        }
        if (this.r.paintAlpha < 1.0f) {
            a(bitmap, this.r.paintAlpha);
        }
        this.g = bitmap;
        this.C = this.g.getWidth();
        this.D = this.g.getHeight();
        this.E = ((float) this.g.getWidth()) * this.r.spacing;
        this.E = Math.max(this.E, 0.1f);
    }

    public void updateBrushStyle(BrushStyle brushStyle) {
        this.r = brushStyle;
        try {
            this.f = BitmapFactory.decodeStream(this.f1415a.getAssets().open(this.r.resName), (Rect) null, new BitmapFactory.Options());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        float f2 = this.t;
        if (f2 != 0.0f) {
            updateBrushSize(f2, this.u, this.v);
        }
    }

    public void updateSize(int i2, int i3) {
        this.f1416b = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        this.e = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        this.c = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        this.d = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        this.j.setBitmap(this.c);
        this.k.setBitmap(this.f1416b);
        this.l.setBitmap(this.e);
        this.m.setBitmap(this.d);
    }
}
