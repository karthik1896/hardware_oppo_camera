package com.airbnb.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.a.b.a;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.c.a.k;
import com.airbnb.lottie.c.b;
import com.airbnb.lottie.c.c;
import com.airbnb.lottie.c.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TextLayer */
public class h extends a {
    private final StringBuilder e = new StringBuilder(2);
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
    private final Map<d, List<com.airbnb.lottie.a.a.d>> j = new HashMap();
    private final LongSparseArray<String> k = new LongSparseArray<>();
    private final n l;
    private final f m;
    private final com.airbnb.lottie.d n;
    private a<Integer, Integer> o;
    private a<Integer, Integer> p;
    private a<Integer, Integer> q;
    private a<Integer, Integer> r;
    private a<Float, Float> s;
    private a<Float, Float> t;
    private a<Float, Float> u;
    private a<Float, Float> v;
    private a<Float, Float> w;
    private a<Float, Float> x;

    h(f fVar, d dVar) {
        super(fVar, dVar);
        this.m = fVar;
        this.n = dVar.a();
        this.l = dVar.s().a();
        this.l.a((a.C0053a) this);
        a((a<?, ?>) this.l);
        k t2 = dVar.t();
        if (!(t2 == null || t2.f1662a == null)) {
            this.o = t2.f1662a.a();
            this.o.a((a.C0053a) this);
            a((a<?, ?>) this.o);
        }
        if (!(t2 == null || t2.f1663b == null)) {
            this.q = t2.f1663b.a();
            this.q.a((a.C0053a) this);
            a((a<?, ?>) this.q);
        }
        if (!(t2 == null || t2.c == null)) {
            this.s = t2.c.a();
            this.s.a((a.C0053a) this);
            a((a<?, ?>) this.s);
        }
        if (t2 != null && t2.d != null) {
            this.u = t2.d.a();
            this.u.a((a.C0053a) this);
            a((a<?, ?>) this.u);
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, (float) this.n.d().width(), (float) this.n.d().height());
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.m.q()) {
            canvas.setMatrix(matrix);
        }
        b bVar = (b) this.l.g();
        c cVar = this.n.k().get(bVar.f1668b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        a<Integer, Integer> aVar = this.p;
        if (aVar != null) {
            this.h.setColor(aVar.g().intValue());
        } else {
            a<Integer, Integer> aVar2 = this.o;
            if (aVar2 != null) {
                this.h.setColor(aVar2.g().intValue());
            } else {
                this.h.setColor(bVar.h);
            }
        }
        a<Integer, Integer> aVar3 = this.r;
        if (aVar3 != null) {
            this.i.setColor(aVar3.g().intValue());
        } else {
            a<Integer, Integer> aVar4 = this.q;
            if (aVar4 != null) {
                this.i.setColor(aVar4.g().intValue());
            } else {
                this.i.setColor(bVar.i);
            }
        }
        int intValue = ((this.d.a() == null ? 100 : this.d.a().g().intValue()) * 255) / 100;
        this.h.setAlpha(intValue);
        this.i.setAlpha(intValue);
        a<Float, Float> aVar5 = this.t;
        if (aVar5 != null) {
            this.i.setStrokeWidth(aVar5.g().floatValue());
        } else {
            a<Float, Float> aVar6 = this.s;
            if (aVar6 != null) {
                this.i.setStrokeWidth(aVar6.g().floatValue());
            } else {
                this.i.setStrokeWidth(bVar.j * com.airbnb.lottie.f.h.a() * com.airbnb.lottie.f.h.a(matrix));
            }
        }
        if (this.m.q()) {
            a(bVar, matrix, cVar, canvas);
        } else {
            a(bVar, cVar, matrix, canvas);
        }
        canvas.restore();
    }

    private void a(b bVar, Matrix matrix, c cVar, Canvas canvas) {
        float f2;
        b bVar2 = bVar;
        Canvas canvas2 = canvas;
        a<Float, Float> aVar = this.x;
        if (aVar != null) {
            f2 = aVar.g().floatValue();
        } else {
            a<Float, Float> aVar2 = this.w;
            if (aVar2 != null) {
                f2 = aVar2.g().floatValue();
            } else {
                f2 = bVar2.c;
            }
        }
        float f3 = f2 / 100.0f;
        float a2 = com.airbnb.lottie.f.h.a(matrix);
        String str = bVar2.f1667a;
        float a3 = bVar2.f * com.airbnb.lottie.f.h.a();
        List<String> a4 = a(str);
        int size = a4.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = a4.get(i2);
            float a5 = a(str2, cVar, f3, a2);
            canvas.save();
            a(bVar2.d, canvas2, a5);
            canvas2.translate(0.0f, (((float) i2) * a3) - ((((float) (size - 1)) * a3) / 2.0f));
            a(str2, bVar, matrix, cVar, canvas, a2, f3);
            canvas.restore();
        }
    }

    private void a(String str, b bVar, Matrix matrix, c cVar, Canvas canvas, float f2, float f3) {
        float floatValue;
        for (int i2 = 0; i2 < str.length(); i2++) {
            d dVar = this.n.j().get(d.a(str.charAt(i2), cVar.a(), cVar.c()));
            if (dVar != null) {
                a(dVar, matrix, f3, bVar, canvas);
                float b2 = ((float) dVar.b()) * f3 * com.airbnb.lottie.f.h.a() * f2;
                float f4 = ((float) bVar.e) / 10.0f;
                a<Float, Float> aVar = this.v;
                if (aVar != null) {
                    floatValue = aVar.g().floatValue();
                } else {
                    a<Float, Float> aVar2 = this.u;
                    if (aVar2 != null) {
                        floatValue = aVar2.g().floatValue();
                    }
                    canvas.translate(b2 + (f4 * f2), 0.0f);
                }
                f4 += floatValue;
                canvas.translate(b2 + (f4 * f2), 0.0f);
            }
        }
    }

    private void a(b bVar, c cVar, Matrix matrix, Canvas canvas) {
        float f2;
        float a2 = com.airbnb.lottie.f.h.a(matrix);
        Typeface a3 = this.m.a(cVar.a(), cVar.c());
        if (a3 != null) {
            String str = bVar.f1667a;
            q p2 = this.m.p();
            if (p2 != null) {
                str = p2.a(str);
            }
            this.h.setTypeface(a3);
            a<Float, Float> aVar = this.x;
            if (aVar != null) {
                f2 = aVar.g().floatValue();
            } else {
                a<Float, Float> aVar2 = this.w;
                if (aVar2 != null) {
                    f2 = aVar2.g().floatValue();
                } else {
                    f2 = bVar.c;
                }
            }
            this.h.setTextSize(f2 * com.airbnb.lottie.f.h.a());
            this.i.setTypeface(this.h.getTypeface());
            this.i.setTextSize(this.h.getTextSize());
            float a4 = bVar.f * com.airbnb.lottie.f.h.a();
            List<String> a5 = a(str);
            int size = a5.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = a5.get(i2);
                a(bVar.d, canvas, this.i.measureText(str2));
                canvas.translate(0.0f, (((float) i2) * a4) - ((((float) (size - 1)) * a4) / 2.0f));
                a(str2, bVar, canvas, a2);
                canvas.setMatrix(matrix);
            }
        }
    }

    private List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(String str, b bVar, Canvas canvas, float f2) {
        float floatValue;
        int i2 = 0;
        while (i2 < str.length()) {
            String a2 = a(str, i2);
            i2 += a2.length();
            a(a2, bVar, canvas);
            float measureText = this.h.measureText(a2, 0, 1);
            float f3 = ((float) bVar.e) / 10.0f;
            a<Float, Float> aVar = this.v;
            if (aVar != null) {
                floatValue = aVar.g().floatValue();
            } else {
                a<Float, Float> aVar2 = this.u;
                if (aVar2 != null) {
                    floatValue = aVar2.g().floatValue();
                } else {
                    canvas.translate(measureText + (f3 * f2), 0.0f);
                }
            }
            f3 += floatValue;
            canvas.translate(measureText + (f3 * f2), 0.0f);
        }
    }

    private float a(String str, c cVar, float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            d dVar = this.n.j().get(d.a(str.charAt(i2), cVar.a(), cVar.c()));
            if (dVar != null) {
                f4 = (float) (((double) f4) + (dVar.b() * ((double) f2) * ((double) com.airbnb.lottie.f.h.a()) * ((double) f3)));
            }
        }
        return f4;
    }

    /* renamed from: com.airbnb.lottie.c.c.h$3  reason: invalid class name */
    /* compiled from: TextLayer */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1713a = new int[b.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.airbnb.lottie.c.b$a[] r0 = com.airbnb.lottie.c.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1713a = r0
                int[] r0 = f1713a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b$a r1 = com.airbnb.lottie.c.b.a.LEFT_ALIGN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1713a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b$a r1 = com.airbnb.lottie.c.b.a.RIGHT_ALIGN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1713a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b$a r1 = com.airbnb.lottie.c.b.a.CENTER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.c.h.AnonymousClass3.<clinit>():void");
        }
    }

    private void a(b.a aVar, Canvas canvas, float f2) {
        int i2 = AnonymousClass3.f1713a[aVar.ordinal()];
        if (i2 == 1) {
            return;
        }
        if (i2 == 2) {
            canvas.translate(-f2, 0.0f);
        } else if (i2 == 3) {
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    private void a(d dVar, Matrix matrix, float f2, b bVar, Canvas canvas) {
        List<com.airbnb.lottie.a.a.d> a2 = a(dVar);
        for (int i2 = 0; i2 < a2.size(); i2++) {
            Path e2 = a2.get(i2).e();
            e2.computeBounds(this.f, false);
            this.g.set(matrix);
            this.g.preTranslate(0.0f, (-bVar.g) * com.airbnb.lottie.f.h.a());
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

    private void a(String str, b bVar, Canvas canvas) {
        if (bVar.k) {
            a(str, this.h, canvas);
            a(str, this.i, canvas);
            return;
        }
        a(str, this.i, canvas);
        a(str, this.h, canvas);
    }

    private void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    private List<com.airbnb.lottie.a.a.d> a(d dVar) {
        if (this.j.containsKey(dVar)) {
            return this.j.get(dVar);
        }
        List<com.airbnb.lottie.c.b.n> a2 = dVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.airbnb.lottie.a.a.d(this.m, this, a2.get(i2)));
        }
        this.j.put(dVar, arrayList);
        return arrayList;
    }

    private String a(String str, int i2) {
        int codePointAt = str.codePointAt(i2);
        int charCount = Character.charCount(codePointAt) + i2;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!a(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j2 = (long) codePointAt;
        if (this.k.containsKey(j2)) {
            return this.k.get(j2);
        }
        this.e.setLength(0);
        while (i2 < charCount) {
            int codePointAt3 = str.codePointAt(i2);
            this.e.appendCodePoint(codePointAt3);
            i2 += Character.charCount(codePointAt3);
        }
        String sb = this.e.toString();
        this.k.put(j2, sb);
        return sb;
    }

    private boolean a(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    public <T> void a(T t2, com.airbnb.lottie.g.c<T> cVar) {
        super.a(t2, cVar);
        if (t2 == com.airbnb.lottie.k.f1837a) {
            a<Integer, Integer> aVar = this.p;
            if (aVar != null) {
                b((a<?, ?>) aVar);
            }
            if (cVar == null) {
                this.p = null;
                return;
            }
            this.p = new p(cVar);
            this.p.a((a.C0053a) this);
            a((a<?, ?>) this.p);
        } else if (t2 == com.airbnb.lottie.k.f1838b) {
            a<Integer, Integer> aVar2 = this.r;
            if (aVar2 != null) {
                b((a<?, ?>) aVar2);
            }
            if (cVar == null) {
                this.r = null;
                return;
            }
            this.r = new p(cVar);
            this.r.a((a.C0053a) this);
            a((a<?, ?>) this.r);
        } else if (t2 == com.airbnb.lottie.k.o) {
            a<Float, Float> aVar3 = this.t;
            if (aVar3 != null) {
                b((a<?, ?>) aVar3);
            }
            if (cVar == null) {
                this.t = null;
                return;
            }
            this.t = new p(cVar);
            this.t.a((a.C0053a) this);
            a((a<?, ?>) this.t);
        } else if (t2 == com.airbnb.lottie.k.p) {
            a<Float, Float> aVar4 = this.v;
            if (aVar4 != null) {
                b((a<?, ?>) aVar4);
            }
            if (cVar == null) {
                this.v = null;
                return;
            }
            this.v = new p(cVar);
            this.v.a((a.C0053a) this);
            a((a<?, ?>) this.v);
        } else if (t2 == com.airbnb.lottie.k.B) {
            a<Float, Float> aVar5 = this.x;
            if (aVar5 != null) {
                b((a<?, ?>) aVar5);
            }
            if (cVar == null) {
                this.x = null;
                return;
            }
            this.x = new p(cVar);
            this.x.a((a.C0053a) this);
            a((a<?, ?>) this.x);
        }
    }
}
