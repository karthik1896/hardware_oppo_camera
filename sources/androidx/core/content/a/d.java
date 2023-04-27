package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: GradientColorInflaterCompat */
final class d {
    static Shader a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Resources.Theme theme2 = theme;
            TypedArray a2 = g.a(resources, theme2, attributeSet, R.styleable.GradientColor);
            float a3 = g.a(a2, xmlPullParser2, "startX", R.styleable.GradientColor_android_startX, 0.0f);
            float a4 = g.a(a2, xmlPullParser2, "startY", R.styleable.GradientColor_android_startY, 0.0f);
            float a5 = g.a(a2, xmlPullParser2, "endX", R.styleable.GradientColor_android_endX, 0.0f);
            float a6 = g.a(a2, xmlPullParser2, "endY", R.styleable.GradientColor_android_endY, 0.0f);
            float a7 = g.a(a2, xmlPullParser2, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
            float a8 = g.a(a2, xmlPullParser2, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
            int a9 = g.a(a2, xmlPullParser2, "type", R.styleable.GradientColor_android_type, 0);
            int b2 = g.b(a2, xmlPullParser2, "startColor", R.styleable.GradientColor_android_startColor, 0);
            boolean a10 = g.a(xmlPullParser2, "centerColor");
            int b3 = g.b(a2, xmlPullParser2, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
            int b4 = g.b(a2, xmlPullParser2, "endColor", R.styleable.GradientColor_android_endColor, 0);
            int a11 = g.a(a2, xmlPullParser2, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
            float f = a7;
            float a12 = g.a(a2, xmlPullParser2, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
            a2.recycle();
            a a13 = a(b(resources, xmlPullParser, attributeSet, theme), b2, b4, a10, b3);
            if (a9 == 1) {
                float f2 = f;
                if (a12 > 0.0f) {
                    int[] iArr = a13.f620a;
                    return new RadialGradient(f2, a8, a12, iArr, a13.f621b, a(a11));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (a9 != 2) {
                return new LinearGradient(a3, a4, a5, a6, a13.f620a, a13.f621b, a(a11));
            } else {
                return new SweepGradient(f, a8, a13.f620a, a13.f621b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.a.d.a b(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r9.next()
            if (r3 == r1) goto L_0x0085
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0085
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = androidx.core.R.styleable.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.content.a.g.a((android.content.res.Resources) r8, (android.content.res.Resources.Theme) r11, (android.util.AttributeSet) r10, (int[]) r3)
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = androidx.core.R.styleable.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L_0x006a
            if (r6 == 0) goto L_0x006a
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = androidx.core.R.styleable.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x006a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L_0x0085:
            int r8 = r4.size()
            if (r8 <= 0) goto L_0x0091
            androidx.core.content.a.d$a r8 = new androidx.core.content.a.d$a
            r8.<init>((java.util.List<java.lang.Integer>) r4, (java.util.List<java.lang.Float>) r2)
            return r8
        L_0x0091:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.a.d.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.a.d$a");
    }

    private static a a(a aVar, int i, int i2, boolean z, int i3) {
        if (aVar != null) {
            return aVar;
        }
        if (z) {
            return new a(i, i3, i2);
        }
        return new a(i, i2);
    }

    private static Shader.TileMode a(int i) {
        if (i == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    /* compiled from: GradientColorInflaterCompat */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f620a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f621b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f620a = new int[size];
            this.f621b = new float[size];
            for (int i = 0; i < size; i++) {
                this.f620a[i] = list.get(i).intValue();
                this.f621b[i] = list2.get(i).floatValue();
            }
        }

        a(int i, int i2) {
            this.f620a = new int[]{i, i2};
            this.f621b = new float[]{0.0f, 1.0f};
        }

        a(int i, int i2, int i3) {
            this.f620a = new int[]{i, i2, i3};
            this.f621b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
