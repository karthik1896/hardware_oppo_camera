package com.oppo.camera.ui.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.gl.h;
import com.oppo.camera.gl.l;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiFocusView extends View implements j {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4346a = {0, 0};
    private Drawable A = null;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<RectF> B = new CopyOnWriteArrayList<>();
    private int[] C = {0, 0};
    private l D = new l();
    private Size E = null;
    private q F = new q() {
        public void a(h hVar, boolean z) {
        }

        public void b(h hVar, boolean z) {
            if (!MultiFocusView.this.i) {
                if (z) {
                    MultiFocusView.this.B.clear();
                }
                if (1 == MultiFocusView.this.c && !MultiFocusView.this.B.isEmpty()) {
                    Iterator it = MultiFocusView.this.B.iterator();
                    while (it.hasNext()) {
                        MultiFocusView.this.a(hVar, (RectF) it.next());
                    }
                }
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private int f4347b = 0;
    /* access modifiers changed from: private */
    public int c = -1;
    private int d = 255;
    private int e = 0;
    private int f = 0;
    private int g = 4;
    private int h = (this.g / 2);
    /* access modifiers changed from: private */
    public boolean i = true;
    private float j = 0.0f;
    private int[] k = null;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private ArrayList<Integer> s = null;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private Matrix x = new Matrix();
    private RectF y = null;
    private Rect z = null;

    public MultiFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = context.getResources();
        this.A = Util.b(context, (int) R.drawable.icon_face_detecte);
        this.j = (float) resources.getDimensionPixelSize(R.dimen.multi_focus_view_rect_space);
        this.f = Util.s(context);
        this.y = new RectF();
        this.z = new Rect();
        this.s = new ArrayList<>();
        this.D.a(this.f);
        this.D.a((float) this.g);
    }

    public void a(int[] iArr, Size size) {
        if (!this.i && iArr != null) {
            int[] iArr2 = this.k;
            if (iArr2 == null || iArr2.length <= 0 || !Arrays.equals(iArr, iArr2)) {
                int[] iArr3 = this.k;
                if (!(iArr3 == null || iArr3.length <= 0 || iArr[0] == iArr3[0])) {
                    b();
                }
                this.k = iArr;
                if (iArr.length != 0) {
                    switch (iArr[0]) {
                        case 2:
                        case 3:
                            this.c = 0;
                            break;
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            this.c = 1;
                            break;
                        default:
                            this.c = -1;
                            return;
                    }
                    this.x.reset();
                    this.x.setTranslate((float) ((-getHeight()) / 2), (float) ((-getWidth()) / 2));
                    this.x.postRotate((float) this.f4347b);
                    this.x.postTranslate((float) (getWidth() / 2), (float) (getHeight() / 2));
                    int i2 = this.c;
                    if (i2 == 0) {
                        this.z.setEmpty();
                        this.B.clear();
                        float f2 = 1.0f;
                        if (size.getHeight() != 0) {
                            f2 = ((float) getWidth()) / ((float) size.getHeight());
                        }
                        this.t = (int) (((float) iArr[1]) * f2);
                        this.u = (int) (((float) iArr[2]) * f2);
                        this.v = (int) (((float) iArr[3]) * f2);
                        this.w = (int) (((float) iArr[4]) * f2);
                        RectF rectF = this.y;
                        int i3 = this.t;
                        int i4 = this.u;
                        rectF.set((float) i3, (float) i4, (float) (i3 + this.v), (float) (i4 + this.w));
                        this.x.mapRect(this.y);
                        this.y.round(this.z);
                    } else if (1 == i2) {
                        this.l = iArr[1];
                        this.m = iArr[2];
                        this.n = iArr[3];
                        this.o = iArr[4];
                        this.p = iArr[5];
                        this.q = iArr[6];
                        this.r = iArr[7];
                        if (this.m <= 0) {
                            e.b("MultiFocusView", "setPosition, Face info is error");
                            return;
                        }
                        this.e = Util.E() / this.m;
                        this.s = a(this.r);
                        this.z.setEmpty();
                        this.B.clear();
                        Iterator<Integer> it = this.s.iterator();
                        while (it.hasNext()) {
                            int intValue = it.next().intValue();
                            int i5 = this.n;
                            int i6 = this.p;
                            int i7 = this.e;
                            float f3 = this.j;
                            int i8 = this.o;
                            RectF rectF2 = new RectF(((float) (((intValue % (i6 - i5)) + i5) * i7)) + f3, ((float) (((intValue / (i6 - i5)) + i8) * i7)) + f3, ((float) ((((intValue % (i6 - i5)) + i5) + 1) * i7)) - f3, ((float) (((i8 + (intValue / (i6 - i5))) + 1) * i7)) - f3);
                            this.x.mapRect(rectF2);
                            this.B.add(rectF2);
                        }
                    }
                }
                invalidate();
            }
        }
    }

    public boolean a() {
        return 1 == this.c;
    }

    public void setDisplayOrientation(int i2) {
        this.f4347b = i2;
        e.b("MultiFocusView", "setDisplayOrientation, mDisplayOrientation: " + this.f4347b);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Rect rect;
        if (this.c == 0 && (rect = this.z) != null) {
            this.A.setBounds(rect);
            this.A.setAlpha(this.d);
            this.A.draw(canvas);
        }
    }

    public void a(boolean z2, boolean z3) {
        e.b("MultiFocusView", "showSuccess");
        invalidate();
    }

    public void b() {
        if (this.k != null) {
            e.b("MultiFocusView", "clear");
            if (this.k != null) {
                this.k = null;
            }
            Rect rect = this.z;
            if (rect != null) {
                rect.setEmpty();
            }
            RectF rectF = this.y;
            if (rectF != null) {
                rectF.setEmpty();
            }
            ArrayList<Integer> arrayList = this.s;
            if (arrayList != null) {
                arrayList.clear();
            }
            Matrix matrix = this.x;
            if (matrix != null) {
                matrix.reset();
            }
            this.B.clear();
            this.c = -1;
            invalidate();
        }
    }

    public void c() {
        e.b("MultiFocusView", "pause");
        b();
        this.i = true;
        this.C = f4346a;
    }

    public void d() {
        e.b("MultiFocusView", "resume");
        b();
        this.i = false;
    }

    public void e() {
        e.b("MultiFocusView", "releaseMultiFocusView");
        b();
        this.i = true;
        if (this.A != null) {
            this.A = null;
        }
        if (this.x != null) {
            this.x = null;
        }
        if (this.k != null) {
            this.k = null;
        }
        if (this.y != null) {
            this.y = null;
        }
        if (this.z != null) {
            this.z = null;
        }
        ArrayList<Integer> arrayList = this.s;
        if (arrayList != null) {
            arrayList.clear();
            this.s = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r1 = this;
            boolean r0 = r1.i
            if (r0 != 0) goto L_0x000d
            int[] r0 = r1.k
            if (r0 == 0) goto L_0x000d
            int r0 = r0.length
            if (r0 <= 0) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.preview.MultiFocusView.f():boolean");
    }

    private ArrayList a(int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i2 != 0) {
            if (1 == (i2 & 1)) {
                arrayList.add(Integer.valueOf(i3));
            }
            i3++;
            i2 >>>= 1;
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(h hVar, RectF rectF) {
        RectF rectF2 = rectF;
        PointF pointF = new PointF(((float) this.C[0]) + rectF2.left, ((float) this.C[1]) + rectF2.top);
        PointF pointF2 = new PointF(pointF.x, pointF.y + rectF.height());
        PointF pointF3 = new PointF(pointF2.x + rectF.width(), pointF2.y);
        PointF pointF4 = new PointF(pointF3.x, pointF3.y - rectF.height());
        PointF pointF5 = new PointF(pointF4.x - rectF.width(), pointF4.y);
        if (a(pointF) && a(pointF2) && a(pointF2) && a(pointF3) && a(pointF3) && a(pointF4) && a(pointF4) && a(pointF5)) {
            h hVar2 = hVar;
            hVar2.a(pointF.x, pointF.y, pointF2.x, pointF2.y + ((float) this.h), this.D);
            h hVar3 = hVar;
            hVar3.a(pointF2.x, pointF2.y, pointF3.x + ((float) this.h), pointF3.y, this.D);
            hVar2.a(pointF3.x, pointF3.y, pointF4.x, pointF4.y - ((float) this.h), this.D);
            hVar3.a(pointF4.x, pointF4.y, pointF5.x - ((float) this.h), pointF5.y, this.D);
        }
    }

    /* access modifiers changed from: protected */
    public q getListener() {
        return this.F;
    }

    private boolean a(PointF pointF) {
        int[] iArr = this.C;
        int i2 = iArr[0];
        int i3 = iArr[1];
        return pointF.x >= ((float) i2) && pointF.x <= ((float) (i2 + getWidth())) && pointF.y >= ((float) i3) && pointF.y <= ((float) (i3 + getHeight()));
    }

    public void g() {
        if (!this.i) {
            b();
            getLocationOnScreen(this.C);
        }
    }
}
