package com.coloros.anim.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.coloros.anim.a;
import com.coloros.anim.a.a.d;
import com.coloros.anim.a.b.a;
import com.coloros.anim.a.b.n;
import com.coloros.anim.b;
import com.coloros.anim.c.a.k;
import com.coloros.anim.c.b;
import com.coloros.anim.c.e;
import com.coloros.anim.f.g;
import com.coloros.anim.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer */
public class h extends a {
    private final char[] e = new char[1];
    private final RectF f = new RectF();
    private final Matrix g = new Matrix();
    private final Paint h = new Paint(1) {
        {
            setStyle(Paint.Style.FILL);
        }
    };
    private final Paint i = new Paint(1) {
        {
            setStyle(Paint.Style.STROKE);
        }
    };
    private final Map<e, List<d>> j = new HashMap();
    private final n k;
    private final b l;
    private final a m;
    private com.coloros.anim.a.b.a<Integer, Integer> n;
    private com.coloros.anim.a.b.a<Integer, Integer> o;
    private com.coloros.anim.a.b.a<Float, Float> p;
    private com.coloros.anim.a.b.a<Float, Float> q;

    h(b bVar, d dVar) {
        super(bVar, dVar);
        this.l = bVar;
        this.m = dVar.a();
        this.k = dVar.s().a();
        this.k.a((a.C0061a) this);
        a((com.coloros.anim.a.b.a<?, ?>) this.k);
        k t = dVar.t();
        if (!(t == null || t.f2363a == null)) {
            this.n = t.f2363a.a();
            this.n.a((a.C0061a) this);
            a((com.coloros.anim.a.b.a<?, ?>) this.n);
        }
        if (!(t == null || t.f2364b == null)) {
            this.o = t.f2364b.a();
            this.o.a((a.C0061a) this);
            a((com.coloros.anim.a.b.a<?, ?>) this.o);
        }
        if (!(t == null || t.c == null)) {
            this.p = t.c.a();
            this.p.a((a.C0061a) this);
            a((com.coloros.anim.a.b.a<?, ?>) this.p);
        }
        if (t != null && t.d != null) {
            this.q = t.d.a();
            this.q.a((a.C0061a) this);
            a((com.coloros.anim.a.b.a<?, ?>) this.q);
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, (float) this.m.d().width(), (float) this.m.d().height());
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i2) {
        com.coloros.anim.k.c("TextLayer#draw");
        canvas.save();
        if (!this.l.p()) {
            canvas.setMatrix(matrix);
        }
        com.coloros.anim.c.b bVar = (com.coloros.anim.c.b) this.k.g();
        com.coloros.anim.c.d dVar = this.m.k().get(bVar.f2369b);
        if (dVar == null) {
            canvas.restore();
            return;
        }
        com.coloros.anim.a.b.a<Integer, Integer> aVar = this.n;
        if (aVar != null) {
            this.h.setColor(aVar.g().intValue());
        } else {
            this.h.setColor(bVar.h);
        }
        com.coloros.anim.a.b.a<Integer, Integer> aVar2 = this.o;
        if (aVar2 != null) {
            this.i.setColor(aVar2.g().intValue());
        } else {
            this.i.setColor(bVar.i);
        }
        int intValue = ((this.d.a() == null ? 100 : this.d.a().g().intValue()) * 255) / 100;
        this.h.setAlpha(intValue);
        this.i.setAlpha(intValue);
        com.coloros.anim.a.b.a<Float, Float> aVar3 = this.p;
        if (aVar3 != null) {
            this.i.setStrokeWidth(aVar3.g().floatValue());
        } else {
            this.i.setStrokeWidth((float) (bVar.j * ((double) g.a()) * ((double) g.a(matrix))));
        }
        if (this.l.p()) {
            a(bVar, matrix, dVar, canvas);
        } else {
            a(bVar, dVar, matrix, canvas);
        }
        canvas.restore();
        com.coloros.anim.k.d("TextLayer#draw");
    }

    private void a(com.coloros.anim.c.b bVar, Matrix matrix, com.coloros.anim.c.d dVar, Canvas canvas) {
        com.coloros.anim.c.b bVar2 = bVar;
        Canvas canvas2 = canvas;
        float f2 = ((float) bVar2.c) / 100.0f;
        float a2 = g.a(matrix);
        String str = bVar2.f2368a;
        float a3 = ((float) bVar2.f) * g.a();
        List<String> a4 = a(str);
        int size = a4.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = a4.get(i2);
            float a5 = a(str2, dVar, f2, a2);
            canvas.save();
            a(bVar2.d, canvas2, a5);
            canvas2.translate(0.0f, (((float) i2) * a3) - ((((float) (size - 1)) * a3) / 2.0f));
            a(str2, bVar, matrix, dVar, canvas, a2, f2);
            canvas.restore();
        }
    }

    private void a(String str, com.coloros.anim.c.b bVar, Matrix matrix, com.coloros.anim.c.d dVar, Canvas canvas, float f2, float f3) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            e eVar = this.m.j().get(e.a(str.charAt(i2), dVar.a(), dVar.c()));
            if (eVar != null) {
                a(eVar, matrix, f3, bVar, canvas);
                float b2 = ((float) eVar.b()) * f3 * g.a() * f2;
                float f4 = ((float) bVar.e) / 10.0f;
                com.coloros.anim.a.b.a<Float, Float> aVar = this.q;
                if (aVar != null) {
                    f4 += aVar.g().floatValue();
                }
                canvas.translate(b2 + (f4 * f2), 0.0f);
            }
        }
    }

    private void a(com.coloros.anim.c.b bVar, com.coloros.anim.c.d dVar, Matrix matrix, Canvas canvas) {
        Typeface typeface;
        float a2 = g.a(matrix);
        if (TextUtils.isEmpty(dVar.a()) || !dVar.a().contains("ColorFont")) {
            typeface = this.l.a(dVar.a(), dVar.c());
        } else {
            typeface = g.a(Typeface.create(Typeface.DEFAULT, 0), dVar.c());
        }
        if (typeface != null) {
            String str = bVar.f2368a;
            p o2 = this.l.o();
            if (o2 != null) {
                str = o2.a(str);
            }
            this.h.setTypeface(typeface);
            this.h.setTextSize((float) (bVar.c * ((double) g.a())));
            this.i.setTypeface(this.h.getTypeface());
            this.i.setTextSize(this.h.getTextSize());
            float a3 = ((float) bVar.f) * g.a();
            List<String> a4 = a(str);
            int size = a4.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = a4.get(i2);
                a(bVar.d, canvas, this.i.measureText(str2));
                canvas.translate(0.0f, (((float) i2) * a3) - ((((float) (size - 1)) * a3) / 2.0f));
                a(str2, bVar, canvas, a2);
                canvas.setMatrix(matrix);
            }
        }
    }

    private List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(String str, com.coloros.anim.c.b bVar, Canvas canvas, float f2) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            a(charAt, bVar, canvas);
            char[] cArr = this.e;
            cArr[0] = charAt;
            float measureText = this.h.measureText(cArr, 0, 1);
            float f3 = ((float) bVar.e) / 10.0f;
            com.coloros.anim.a.b.a<Float, Float> aVar = this.q;
            if (aVar != null) {
                f3 += aVar.g().floatValue();
            }
            canvas.translate(measureText + (f3 * f2), 0.0f);
        }
    }

    private float a(String str, com.coloros.anim.c.d dVar, float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            e eVar = this.m.j().get(e.a(str.charAt(i2), dVar.a(), dVar.c()));
            if (eVar != null) {
                f4 = (float) (((double) f4) + (eVar.b() * ((double) f2) * ((double) g.a()) * ((double) f3)));
            }
        }
        return f4;
    }

    /* renamed from: com.coloros.anim.c.c.h$3  reason: invalid class name */
    /* compiled from: TextLayer */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2415a = new int[b.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.coloros.anim.c.b$a[] r0 = com.coloros.anim.c.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2415a = r0
                int[] r0 = f2415a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.coloros.anim.c.b$a r1 = com.coloros.anim.c.b.a.LEFT_ALIGN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f2415a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.coloros.anim.c.b$a r1 = com.coloros.anim.c.b.a.RIGHT_ALIGN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f2415a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.coloros.anim.c.b$a r1 = com.coloros.anim.c.b.a.CENTER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coloros.anim.c.c.h.AnonymousClass3.<clinit>():void");
        }
    }

    private void a(b.a aVar, Canvas canvas, float f2) {
        int i2 = AnonymousClass3.f2415a[aVar.ordinal()];
        if (i2 == 1) {
            return;
        }
        if (i2 == 2) {
            canvas.translate(-f2, 0.0f);
        } else if (i2 == 3) {
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    private void a(e eVar, Matrix matrix, float f2, com.coloros.anim.c.b bVar, Canvas canvas) {
        List<d> a2 = a(eVar);
        for (int i2 = 0; i2 < a2.size(); i2++) {
            Path e2 = a2.get(i2).e();
            e2.computeBounds(this.f, false);
            this.g.set(matrix);
            this.g.preTranslate(0.0f, ((float) (-bVar.g)) * g.a());
            this.g.preScale(f2, f2);
            e2.transform(this.g);
            if (bVar.k) {
                a(e2, this.h, canvas);
                a(e2, this.i, canvas);
            } else {
                a(e2, this.i, canvas);
                a(e2, this.h, canvas);
            }
        }
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void a(char c, com.coloros.anim.c.b bVar, Canvas canvas) {
        this.e[0] = c;
        if (bVar.k) {
            a(this.e, this.h, canvas);
            a(this.e, this.i, canvas);
            return;
        }
        a(this.e, this.i, canvas);
        a(this.e, this.h, canvas);
    }

    private void a(char[] cArr, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(cArr, 0, 1, 0.0f, 0.0f, paint);
            }
        }
    }

    private List<d> a(e eVar) {
        if (this.j.containsKey(eVar)) {
            return this.j.get(eVar);
        }
        List<com.coloros.anim.c.b.n> a2 = eVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new d(this.l, this, a2.get(i2)));
        }
        this.j.put(eVar, arrayList);
        return arrayList;
    }

    public <T> void a(T t, com.coloros.anim.g.b<T> bVar) {
        com.coloros.anim.a.b.a<Float, Float> aVar;
        com.coloros.anim.a.b.a<Float, Float> aVar2;
        com.coloros.anim.a.b.a<Integer, Integer> aVar3;
        com.coloros.anim.a.b.a<Integer, Integer> aVar4;
        super.a(t, bVar);
        if (t == com.coloros.anim.d.f2426a && (aVar4 = this.n) != null) {
            aVar4.a((com.coloros.anim.g.b<Integer>) bVar);
        } else if (t == com.coloros.anim.d.f2427b && (aVar3 = this.o) != null) {
            aVar3.a((com.coloros.anim.g.b<Integer>) bVar);
        } else if (t == com.coloros.anim.d.m && (aVar2 = this.p) != null) {
            aVar2.a((com.coloros.anim.g.b<Float>) bVar);
        } else if (t == com.coloros.anim.d.n && (aVar = this.q) != null) {
            aVar.a((com.coloros.anim.g.b<Float>) bVar);
        }
    }
}
