package com.color.support.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import color.support.v7.appcompat.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: SecurityKeyboard */
public class n {
    private static float s = 1.8f;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f2225a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f2226b;
    /* access modifiers changed from: private */
    public int c;
    /* access modifiers changed from: private */
    public int d;
    private int e;
    private a[] f;
    private int[] g;
    private int h;
    private int i;
    private List<a> j;
    private List<a> k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    private int n;
    private int o;
    private int p;
    private int[][] q;
    private int r;
    private ArrayList<b> t;
    private int u;

    /* compiled from: SecurityKeyboard */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2229a;

        /* renamed from: b  reason: collision with root package name */
        public int f2230b;
        public int c;
        public int d;
        ArrayList<a> e = new ArrayList<>();
        public int f;
        public int g;
        /* access modifiers changed from: private */
        public n h;

        public b(n nVar) {
            this.h = nVar;
        }

        public b(Resources resources, n nVar, XmlResourceParser xmlResourceParser) {
            this.h = nVar;
            TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard);
            this.f2229a = n.a(obtainAttributes, R.styleable.SecurityKeyboard_colorKeyWidth, nVar.l, nVar.f2226b);
            this.f2230b = n.a(obtainAttributes, R.styleable.SecurityKeyboard_colorKeyHeight, nVar.m, nVar.c);
            this.c = n.a(obtainAttributes, R.styleable.SecurityKeyboard_colorHorizontalGap, nVar.l, nVar.f2225a);
            this.d = n.a(obtainAttributes, R.styleable.SecurityKeyboard_colorVerticalGap, nVar.m, nVar.d);
            obtainAttributes.recycle();
            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard_Row);
            this.f = obtainAttributes2.getInt(R.styleable.SecurityKeyboard_Row_colorRowEdgeFlags, 0);
            this.g = obtainAttributes2.getResourceId(R.styleable.SecurityKeyboard_Row_colorKeyboardMode, 0);
        }
    }

    /* compiled from: SecurityKeyboard */
    public static class a {
        private static final int[] u = {16842911, 16842912};
        private static final int[] v = {16842919, 16842911, 16842912};
        private static final int[] w = {16842911};
        private static final int[] x = {16842919, 16842911};
        private static final int[] y = new int[0];
        private static final int[] z = {16842919};

        /* renamed from: a  reason: collision with root package name */
        public int[] f2227a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f2228b;
        public Drawable c;
        public Drawable d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public int i;
        public int j;
        public boolean k;
        public boolean l;
        public CharSequence m;
        public CharSequence n;
        public CharSequence o;
        public int p;
        public boolean q;
        public int r;
        public boolean s;
        private n t;

        public a(b bVar) {
            this.o = null;
            this.t = bVar.h;
            this.f = bVar.f2230b;
            this.e = bVar.f2229a;
            this.g = bVar.c;
            this.p = bVar.f;
        }

        public a(Resources resources, b bVar, int i2, int i3, XmlResourceParser xmlResourceParser) {
            this(bVar);
            this.i = i2;
            this.j = i3;
            TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard);
            this.e = n.a(obtainAttributes, R.styleable.SecurityKeyboard_colorKeyWidth, this.t.l, bVar.f2229a);
            this.f = n.a(obtainAttributes, R.styleable.SecurityKeyboard_colorKeyHeight, this.t.m, bVar.f2230b);
            this.g = n.a(obtainAttributes, R.styleable.SecurityKeyboard_colorHorizontalGap, this.t.l, bVar.c);
            obtainAttributes.recycle();
            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard_Key);
            this.i += this.g;
            TypedValue typedValue = new TypedValue();
            obtainAttributes2.getValue(R.styleable.SecurityKeyboard_Key_colorCodes, typedValue);
            if (typedValue.type == 16 || typedValue.type == 17) {
                this.f2227a = new int[]{typedValue.data};
            } else if (typedValue.type == 3) {
                this.f2227a = a(typedValue.string.toString());
            }
            this.d = obtainAttributes2.getDrawable(R.styleable.SecurityKeyboard_Key_colorIconPreview);
            Drawable drawable = this.d;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.d.getIntrinsicHeight());
            }
            this.n = obtainAttributes2.getText(R.styleable.SecurityKeyboard_Key_colorPopupCharacters);
            this.r = obtainAttributes2.getResourceId(R.styleable.SecurityKeyboard_Key_colorPopupKeyboard, 0);
            this.s = obtainAttributes2.getBoolean(R.styleable.SecurityKeyboard_Key_colorIsRepeatable, false);
            this.q = obtainAttributes2.getBoolean(R.styleable.SecurityKeyboard_Key_colorIsModifier, false);
            this.h = obtainAttributes2.getBoolean(R.styleable.SecurityKeyboard_Key_colorIsSticky, false);
            this.p = obtainAttributes2.getInt(R.styleable.SecurityKeyboard_Key_colorKeyEdgeFlags, 0);
            this.p = bVar.f | this.p;
            this.c = obtainAttributes2.getDrawable(R.styleable.SecurityKeyboard_Key_colorKeyIcon);
            Drawable drawable2 = this.c;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.c.getIntrinsicHeight());
            }
            this.f2228b = obtainAttributes2.getText(R.styleable.SecurityKeyboard_Key_colorKeyLabel);
            this.m = obtainAttributes2.getText(R.styleable.SecurityKeyboard_Key_colorKeyOutputText);
            this.o = obtainAttributes2.getText(R.styleable.SecurityKeyboard_Key_colorKeyAnnounce);
            if (this.f2227a == null && !TextUtils.isEmpty(this.f2228b)) {
                this.f2227a = new int[]{this.f2228b.charAt(0)};
            }
            obtainAttributes2.recycle();
        }

        public void a() {
            this.k = !this.k;
            Drawable drawable = this.c;
            if (drawable != null) {
                drawable.setState(b());
            }
        }

        public void a(boolean z2) {
            this.k = !this.k;
            if (this.h && z2) {
                this.l = !this.l;
            }
            Drawable drawable = this.c;
            if (drawable != null) {
                drawable.setState(b());
            }
        }

        /* access modifiers changed from: package-private */
        public int[] a(String str) {
            int i2;
            int i3 = 0;
            if (str.length() > 0) {
                i2 = 1;
                int i4 = 0;
                while (true) {
                    i4 = str.indexOf(",", i4 + 1);
                    if (i4 <= 0) {
                        break;
                    }
                    i2++;
                }
            } else {
                i2 = 0;
            }
            int[] iArr = new int[i2];
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                int i5 = i3 + 1;
                try {
                    iArr[i3] = Integer.parseInt(stringTokenizer.nextToken());
                } catch (NumberFormatException unused) {
                    Log.e("SecurityKeyboard", "Error parsing keycodes " + str);
                }
                i3 = i5;
            }
            return iArr;
        }

        public boolean a(int i2, int i3) {
            int i4;
            boolean z2 = (this.p & 1) > 0;
            boolean z3 = (this.p & 2) > 0;
            boolean z4 = (this.p & 4) > 0;
            boolean z5 = (this.p & 8) > 0;
            int i5 = this.i;
            if (i2 >= i5 || (z2 && i2 <= i5 + this.e)) {
                int i6 = this.i;
                if ((i2 < this.e + i6 || (z3 && i2 >= i6)) && (i3 >= (i4 = this.j) || (z4 && i3 <= i4 + this.f))) {
                    int i7 = this.j;
                    if (i3 < this.f + i7 || (z5 && i3 >= i7)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int b(int i2, int i3) {
            int i4 = (this.i + (this.e / 2)) - i2;
            int i5 = (this.j + (this.f / 2)) - i3;
            return (i4 * i4) + (i5 * i5);
        }

        public int[] b() {
            int[] iArr = y;
            if (this.l) {
                if (this.k) {
                    return v;
                }
                return u;
            } else if (!this.h) {
                return this.k ? z : iArr;
            } else {
                if (this.k) {
                    return x;
                }
                return w;
            }
        }
    }

    public n(Context context, int i2) {
        this(context, i2, 0);
    }

    public n(Context context, int i2, int i3) {
        this.e = 0;
        this.f = new a[]{null, null};
        this.g = new int[]{-1, -1};
        this.t = new ArrayList<>();
        this.u = 0;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.l = displayMetrics.widthPixels;
        this.m = displayMetrics.heightPixels;
        this.f2225a = 0;
        this.f2226b = this.l / 10;
        this.d = 0;
        this.c = this.f2226b;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.n = i3;
        a(context, context.getResources().getXml(i2));
        b(context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: int[]} */
    /* JADX WARNING: type inference failed for: r4v1, types: [char] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public n(android.content.Context r9, int r10, java.lang.CharSequence r11, int r12, int r13) {
        /*
            r8 = this;
            r8.<init>(r9, r10)
            r9 = 0
            r8.i = r9
            com.color.support.widget.n$b r10 = new com.color.support.widget.n$b
            r10.<init>(r8)
            int r0 = r8.c
            r10.f2230b = r0
            int r0 = r8.f2226b
            r10.f2229a = r0
            int r0 = r8.f2225a
            r10.c = r0
            int r0 = r8.d
            r10.d = r0
            r0 = 12
            r10.f = r0
            r0 = -1
            if (r12 != r0) goto L_0x0025
            r12 = 2147483647(0x7fffffff, float:NaN)
        L_0x0025:
            r0 = r9
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x0029:
            int r4 = r11.length()
            if (r0 >= r4) goto L_0x0075
            char r4 = r11.charAt(r0)
            if (r2 >= r12) goto L_0x003d
            int r5 = r8.f2226b
            int r5 = r5 + r3
            int r5 = r5 + r13
            int r6 = r8.l
            if (r5 <= r6) goto L_0x0045
        L_0x003d:
            int r2 = r8.d
            int r3 = r8.c
            int r2 = r2 + r3
            int r1 = r1 + r2
            r2 = r9
            r3 = r2
        L_0x0045:
            com.color.support.widget.n$a r5 = new com.color.support.widget.n$a
            r5.<init>(r10)
            r5.i = r3
            r5.j = r1
            java.lang.String r6 = java.lang.String.valueOf(r4)
            r5.f2228b = r6
            r6 = 1
            int[] r7 = new int[r6]
            r7[r9] = r4
            r5.f2227a = r7
            int r2 = r2 + r6
            int r4 = r5.e
            int r6 = r5.g
            int r4 = r4 + r6
            int r3 = r3 + r4
            java.util.List<com.color.support.widget.n$a> r4 = r8.j
            r4.add(r5)
            java.util.ArrayList<com.color.support.widget.n$a> r4 = r10.e
            r4.add(r5)
            int r4 = r8.i
            if (r3 <= r4) goto L_0x0072
            r8.i = r3
        L_0x0072:
            int r0 = r0 + 1
            goto L_0x0029
        L_0x0075:
            int r9 = r8.c
            int r1 = r1 + r9
            r8.h = r1
            java.util.ArrayList<com.color.support.widget.n$b> r9 = r8.t
            r9.add(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.color.support.widget.n.<init>(android.content.Context, int, java.lang.CharSequence, int, int):void");
    }

    public List<a> a() {
        return this.j;
    }

    public int b() {
        return this.h;
    }

    public int c() {
        return this.i;
    }

    public void a(int i2) {
        for (a aVar : this.f) {
            if (aVar != null) {
                if (i2 == 1 || i2 == 2) {
                    aVar.l = true;
                } else if (i2 == 0) {
                    aVar.l = false;
                }
            }
        }
        this.e = i2;
    }

    public int d() {
        return this.e;
    }

    private void f() {
        this.o = ((c() + 10) - 1) / 10;
        this.p = ((b() + 5) - 1) / 5;
        this.q = new int[50][];
        int[] iArr = new int[this.j.size()];
        int i2 = this.o * 10;
        int i3 = this.p * 5;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = 0;
            while (i5 < i3) {
                int i6 = 0;
                for (int i7 = 0; i7 < this.j.size(); i7++) {
                    a aVar = this.j.get(i7);
                    if (aVar.b(i4, i5) < this.r || aVar.b((this.o + i4) - 1, i5) < this.r || aVar.b((this.o + i4) - 1, (this.p + i5) - 1) < this.r || aVar.b(i4, (this.p + i5) - 1) < this.r) {
                        iArr[i6] = i7;
                        i6++;
                    }
                }
                int[] iArr2 = new int[i6];
                System.arraycopy(iArr, 0, iArr2, 0, i6);
                int[][] iArr3 = this.q;
                int i8 = this.p;
                iArr3[((i5 / i8) * 10) + (i4 / this.o)] = iArr2;
                i5 += i8;
            }
            i4 += this.o;
        }
    }

    public int[] a(int i2, int i3) {
        int i4;
        if (this.q == null) {
            f();
        }
        if (i2 < 0 || i2 >= c() || i3 < 0 || i3 >= b() || (i4 = ((i3 / this.p) * 10) + (i2 / this.o)) >= 50) {
            return new int[0];
        }
        return this.q[i4];
    }

    /* access modifiers changed from: protected */
    public b a(Resources resources, XmlResourceParser xmlResourceParser) {
        return new b(resources, this, xmlResourceParser);
    }

    /* access modifiers changed from: protected */
    public a a(Resources resources, b bVar, int i2, int i3, XmlResourceParser xmlResourceParser) {
        return new a(resources, bVar, i2, i3, xmlResourceParser);
    }

    private void a(Context context, XmlResourceParser xmlResourceParser) {
        Resources resources = context.getResources();
        a aVar = null;
        b bVar = null;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        loop0:
        while (true) {
            int i4 = i3;
            while (true) {
                try {
                    int next = xmlResourceParser.next();
                    if (next == 1) {
                        break loop0;
                    } else if (next == 2) {
                        String name = xmlResourceParser.getName();
                        if ("Row".equals(name)) {
                            bVar = a(resources, xmlResourceParser);
                            this.t.add(bVar);
                            if ((bVar.g == 0 || bVar.g == this.n) ? false : true) {
                                break;
                            }
                            i4 = 0;
                            i3 = 1;
                        } else if ("Key".equals(name)) {
                            a a2 = a(resources, bVar, i4, i2, xmlResourceParser);
                            this.j.add(a2);
                            if (a2.f2227a[0] == -1) {
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= this.f.length) {
                                        break;
                                    } else if (this.f[i5] == null) {
                                        this.f[i5] = a2;
                                        this.g[i5] = this.j.size() - 1;
                                        break;
                                    } else {
                                        i5++;
                                    }
                                }
                                this.k.add(a2);
                            } else if (a2.f2227a[0] == -6) {
                                this.k.add(a2);
                            }
                            bVar.e.add(a2);
                            aVar = a2;
                            z = true;
                        } else if ("Keyboard".equals(name)) {
                            b(resources, xmlResourceParser);
                        }
                    } else if (next == 3) {
                        if (z) {
                            i4 += aVar.g + aVar.e;
                            if (i4 > this.i) {
                                this.i = i4;
                            }
                            z = false;
                        } else if (i3 != 0) {
                            i2 = i2 + bVar.d + bVar.f2230b;
                            i3 = 0;
                        }
                    }
                } catch (Exception e2) {
                    Log.e("SecurityKeyboard", "Parse error:" + e2);
                    e2.printStackTrace();
                }
            }
            a(xmlResourceParser);
            i3 = 0;
        }
        this.h = i2 - this.d;
    }

    private void a(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlResourceParser.getName().equals("Row")) {
                return;
            }
        }
    }

    private void b(Resources resources, XmlResourceParser xmlResourceParser) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.SecurityKeyboard);
        int i2 = R.styleable.SecurityKeyboard_colorKeyWidth;
        int i3 = this.l;
        this.f2226b = a(obtainAttributes, i2, i3, i3 / 10);
        this.c = a(obtainAttributes, R.styleable.SecurityKeyboard_colorKeyHeight, this.m, 50);
        this.f2225a = a(obtainAttributes, R.styleable.SecurityKeyboard_colorHorizontalGap, this.l, 0);
        this.d = a(obtainAttributes, R.styleable.SecurityKeyboard_colorVerticalGap, this.m, 0);
        this.r = (int) (((float) this.f2226b) * s);
        int i4 = this.r;
        this.r = i4 * i4;
        obtainAttributes.recycle();
    }

    static int a(TypedArray typedArray, int i2, int i3, int i4) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return i4;
        }
        if (peekValue.type == 5) {
            return typedArray.getDimensionPixelOffset(i2, i4);
        }
        return peekValue.type == 6 ? Math.round(typedArray.getFraction(i2, i3, i3, (float) i4)) : i4;
    }

    public int e() {
        return this.u;
    }

    public static float a(Context context) {
        int i2;
        if (context.getResources().getConfiguration().orientation == 1) {
            i2 = context.getResources().getDisplayMetrics().widthPixels;
        } else {
            i2 = context.getResources().getDisplayMetrics().heightPixels;
        }
        return (((float) i2) / 360.0f) / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    public void b(Context context) {
        float a2 = a(context);
        int size = this.t.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            b bVar = this.t.get(i2);
            int size2 = bVar.e.size();
            bVar.d = (int) (((float) bVar.d) * a2);
            bVar.c = (int) (((float) bVar.c) * a2);
            bVar.f2230b = (int) (((float) bVar.f2230b) * a2);
            bVar.f2229a = (int) (((float) bVar.f2229a) * a2);
            int i4 = 0;
            int i5 = i3;
            for (int i6 = 0; i6 < size2; i6++) {
                a aVar = bVar.e.get(i6);
                aVar.g = (int) (((float) aVar.g) * a2);
                int i7 = i4 + aVar.g;
                aVar.i = i7;
                aVar.j = (int) (((float) aVar.j) * a2);
                aVar.e = (int) (((float) aVar.e) * a2);
                aVar.f = (int) (((float) aVar.f) * a2);
                i4 = i7 + aVar.e;
                if (i4 > i5) {
                    i5 = i4;
                }
            }
            i2++;
            i3 = i5;
        }
        this.i = i3;
        this.h = (int) (((float) this.h) * a2);
    }
}
