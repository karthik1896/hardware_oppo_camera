package a.a.b.e;

import a.a.b.b.d;
import a.a.b.b.g;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.text.TextPaint;
import co.polarr.renderer.entities.TextItem;
import java.util.ArrayList;
import java.util.List;

public class u {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public float f79a;

        /* renamed from: b  reason: collision with root package name */
        public float f80b;
        public String[] c;
        public Float[] d;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f81a;

        /* renamed from: b  reason: collision with root package name */
        public RectF f82b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float[] g;
        public float[] h;
        public TextItem i;
        public int j;
    }

    public static float a(Canvas canvas, Paint paint, String str, float f, float f2, float f3, float f4, String str2) {
        if (str.isEmpty()) {
            return 0.0f;
        }
        while (true) {
            String substring = str.substring(0, 1);
            str = str.substring(1);
            canvas.drawText(substring, f, paint.getFontMetrics().descent + f2, paint);
            float a2 = str.isEmpty() ? 0.0f : a(str, paint);
            f += (f3 - a2) + f4;
            if (str.isEmpty()) {
                return f;
            }
            f3 = a2;
        }
    }

    public static float a(String str, Paint paint) {
        return paint.measureText(str, 0, str.length());
    }

    public static d a(Context context, AssetManager assetManager, TextItem textItem, co.polarr.renderer.entities.Context context2, d dVar) {
        int i;
        if (dVar != null) {
            GLES20.glBindTexture(3553, dVar.f11a);
            i = 0;
        } else {
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            g.c(iArr[0]);
            GLES20.glBindTexture(3553, iArr[0]);
            i = iArr[0];
        }
        GLES20.glPixelStorei(3317, 1);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        Bitmap a2 = a(context, assetManager, textItem, context2);
        GLUtils.texImage2D(3553, 0, 6408, a2, 0);
        if (dVar == null) {
            dVar = s.b(i, 6408, a2.getWidth(), a2.getHeight());
        } else {
            dVar.f12b = a2.getWidth();
            dVar.c = a2.getHeight();
        }
        a2.recycle();
        return dVar;
    }

    public static a a(Context context, AssetManager assetManager, TextItem textItem, b bVar) {
        RectF rectF = bVar.f82b;
        float f = bVar.f;
        float f2 = bVar.d;
        float f3 = bVar.f81a;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(i.a(context, assetManager, textItem, bVar.j));
        textPaint.setTextSize(bVar.c);
        String[] a2 = a(context, assetManager, textItem.text.replaceAll("/ +$/g", ""), bVar);
        ArrayList arrayList = new ArrayList();
        float f4 = 0.0f;
        for (String str : a2) {
            float a3 = a(str, (Paint) textPaint);
            f4 = Math.max(f4, (((float) str.length()) * f) + a3);
            arrayList.add(Float.valueOf(a3));
        }
        float length = (float) a2.length;
        float f5 = rectF.bottom;
        if (f3 > 0.0f) {
            f4 = Math.max(f4, f3);
        }
        a aVar = new a();
        aVar.f79a = f4;
        aVar.f80b = (f2 * length) + f5;
        aVar.c = a2;
        aVar.d = (Float[]) arrayList.toArray(new Float[arrayList.size()]);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a.a.b.e.u.b a(android.content.Context r9, android.content.res.AssetManager r10, co.polarr.renderer.entities.TextItem r11, int r12) {
        /*
            java.lang.String r0 = r11.type
            r1 = 0
            if (r0 == 0) goto L_0x001c
            java.lang.String r2 = "artwork"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x001c
            float r0 = r11.fontSize
            float r12 = (float) r12
            float r0 = r0 * r12
            r12 = 1050253722(0x3e99999a, float:0.3)
            float r0 = r0 * r12
            android.graphics.RectF r12 = new android.graphics.RectF
            r12.<init>(r1, r1, r1, r1)
            r4 = r12
            goto L_0x0046
        L_0x001c:
            float r0 = r11.fontSize
            float r12 = (float) r12
            float r0 = r0 * r12
            r2 = 1036831949(0x3dcccccd, float:0.1)
            float r0 = r0 * r2
            r2 = 1067030938(0x3f99999a, float:1.2)
            float r3 = r11.lineHeight
            float r2 = r2 - r3
            float r2 = java.lang.Math.max(r1, r2)
            r3 = 1045220557(0x3e4ccccd, float:0.2)
            float r3 = r3 * r0
            android.graphics.RectF r4 = new android.graphics.RectF
            float r2 = r2 * r0
            r4.<init>(r1, r2, r3, r3)
            float r2 = r11.wrap
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0046
            float r12 = r12 * r2
            float r1 = r4.left
            float r2 = r4.right
            float r1 = r1 + r2
            float r1 = r12 - r1
        L_0x0046:
            java.lang.String r12 = r11.fontStyle
            r2 = 0
            r3 = 1
            r5 = 2
            if (r12 == 0) goto L_0x0087
            r6 = -1
            int r7 = r12.hashCode()
            r8 = -1657669071(0xffffffff9d31fa31, float:-2.35551E-21)
            if (r7 == r8) goto L_0x0076
            r8 = -1178781136(0xffffffffb9bd3a30, float:-3.6092242E-4)
            if (r7 == r8) goto L_0x006c
            r8 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            if (r7 == r8) goto L_0x0062
            goto L_0x007f
        L_0x0062:
            java.lang.String r7 = "normal"
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x007f
            r6 = r2
            goto L_0x007f
        L_0x006c:
            java.lang.String r7 = "italic"
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x007f
            r6 = r3
            goto L_0x007f
        L_0x0076:
            java.lang.String r7 = "oblique"
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x007f
            r6 = r5
        L_0x007f:
            if (r6 == 0) goto L_0x0087
            if (r6 == r3) goto L_0x0086
            if (r6 == r5) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r2 = r5
        L_0x0087:
            java.lang.String r12 = r11.fontWeight
            if (r12 == 0) goto L_0x00a5
            java.lang.String r6 = "bold"
            boolean r12 = r12.equals(r6)
            if (r12 != 0) goto L_0x009d
            java.lang.String r12 = r11.fontWeight
            java.lang.String r6 = "900"
            boolean r12 = r12.equals(r6)
            if (r12 == 0) goto L_0x00a5
        L_0x009d:
            if (r2 != 0) goto L_0x00a1
            r12 = r3
            goto L_0x00a6
        L_0x00a1:
            if (r2 != r5) goto L_0x00a5
            r12 = 3
            goto L_0x00a6
        L_0x00a5:
            r12 = r2
        L_0x00a6:
            android.text.TextPaint r2 = new android.text.TextPaint
            r2.<init>(r3)
            android.graphics.Typeface r9 = a.a.b.e.i.a(r9, r10, r11, r12)
            r2.setTypeface(r9)
            r2.setTextSize(r0)
            a.a.b.e.u$b r9 = new a.a.b.e.u$b
            r9.<init>()
            r9.f81a = r1
            r9.f82b = r4
            r9.c = r0
            float r10 = r11.lineHeight
            float r10 = r10 * r0
            r9.d = r10
            r10 = 1008981770(0x3c23d70a, float:0.01)
            float r10 = r10 * r0
            r9.e = r10
            float r10 = r11.letterSpacing
            float r0 = r0 * r10
            r9.f = r0
            float[] r10 = r11.scale
            if (r10 == 0) goto L_0x00d5
            goto L_0x00da
        L_0x00d5:
            float[] r10 = new float[r5]
            r10 = {1065353216, 1065353216} // fill-array
        L_0x00da:
            r9.g = r10
            float[] r10 = r11.f1430color
            if (r10 == 0) goto L_0x00e1
            goto L_0x00e7
        L_0x00e1:
            r10 = 4
            float[] r10 = new float[r10]
            r10 = {1065353216, 1065353216, 1065353216, 1065353216} // fill-array
        L_0x00e7:
            r9.h = r10
            java.lang.String r10 = a.a.b.e.m.a(r11)
            java.lang.Class<co.polarr.renderer.entities.TextItem> r11 = co.polarr.renderer.entities.TextItem.class
            java.lang.Object r10 = a.a.b.e.m.a(r10, r11)
            co.polarr.renderer.entities.TextItem r10 = (co.polarr.renderer.entities.TextItem) r10
            r9.i = r10
            r9.j = r12
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.e.u.a(android.content.Context, android.content.res.AssetManager, co.polarr.renderer.entities.TextItem, int):a.a.b.e.u$b");
    }

    public static Bitmap a(Context context, AssetManager assetManager, TextItem textItem, co.polarr.renderer.entities.Context context2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        Canvas canvas;
        Float[] fArr;
        Bitmap bitmap;
        Context context3 = context;
        AssetManager assetManager2 = assetManager;
        TextItem textItem2 = textItem;
        b a2 = a(context3, assetManager2, textItem2, context2.imageTexture.f12b);
        RectF rectF = a2.f82b;
        float f6 = a2.f;
        float f7 = a2.d;
        float[] fArr2 = a2.g;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(i.a(context3, assetManager2, textItem2, a2.j));
        textPaint.setTextSize(a2.c);
        a a3 = a(context3, assetManager2, textItem2, a2);
        String[] strArr = a3.c;
        Float[] fArr3 = a3.d;
        float f8 = a3.f79a;
        float f9 = a3.f80b;
        float f10 = (float) ((int) (rectF.left + f8 + rectF.right));
        float f11 = (float) ((int) f9);
        float max = Math.max(fArr2[0] * f10, fArr2[1] * f11);
        float min = Math.min(max, (float) 2048) / max;
        float[] fArr4 = {Math.abs(fArr2[0] * min), Math.abs(min * fArr2[1])};
        int i = (int) (f10 * fArr4[0]);
        int i2 = (int) (f11 * fArr4[1]);
        if (i == 0 || i2 == 0) {
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        canvas2.scale(fArr4[0], fArr4[1]);
        float f12 = rectF.left;
        float length = ((f9 / 2.0f) - ((((float) (strArr.length - 1)) * f7) / 2.0f)) - (rectF.bottom / 2.0f);
        float[] fArr5 = a2.h;
        Bitmap bitmap2 = createBitmap;
        textPaint.setColor(Color.argb((int) (fArr5[3] * 255.0f), (int) (fArr5[0] * 255.0f), (int) (fArr5[1] * 255.0f), (int) (fArr5[2] * 255.0f)));
        String str = textItem2.type;
        if (str != null && str.equalsIgnoreCase("artwork")) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            length += fontMetrics.descent - fontMetrics.leading;
        }
        if (textItem2.mode.equals("outline")) {
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(a2.e);
        } else {
            textPaint.setStyle(Paint.Style.FILL);
        }
        if (textItem2.align.equals("justify")) {
            int i3 = 0;
            while (i3 < strArr.length) {
                String str2 = strArr[i3];
                float length2 = f8 - (((float) str2.length()) * f6);
                float f13 = length + (((float) i3) * f7);
                if (fArr3[i3].floatValue() < length2) {
                    String[] split = str2.split("/\\s/g");
                    float[] a4 = a(split, textPaint);
                    float f14 = 0.0f;
                    for (float f15 : a4) {
                        f14 += f15;
                    }
                    float length3 = (length2 - f14) / ((float) (split.length - 1));
                    float f16 = f12;
                    int i4 = 0;
                    while (i4 < split.length) {
                        String str3 = split[i4];
                        float f17 = a4[i4];
                        Canvas canvas3 = canvas2;
                        String str4 = str3;
                        int i5 = i4;
                        float f18 = f16;
                        Bitmap bitmap3 = bitmap2;
                        float a5 = a(canvas2, textPaint, str4, f18, f13, f17, f6, textItem2.mode);
                        i4 = i5 + 1;
                        fArr3 = fArr3;
                        canvas2 = canvas3;
                        a4 = a4;
                        f8 = f8;
                        f12 = f12;
                        length = length;
                        f16 = a5 + length3 + f6;
                    }
                    bitmap = bitmap2;
                    f3 = length;
                    canvas = canvas2;
                    f5 = f8;
                    fArr = fArr3;
                    f4 = f12;
                } else {
                    bitmap = bitmap2;
                    f3 = length;
                    canvas = canvas2;
                    f5 = f8;
                    fArr = fArr3;
                    f4 = f12;
                    a(canvas, textPaint, str2, f4, f13, fArr[i3].floatValue(), f6, textItem2.mode);
                }
                i3++;
                length = f3;
                bitmap2 = bitmap;
                fArr3 = fArr;
                canvas2 = canvas;
                f8 = f5;
                f12 = f4;
            }
            return bitmap2;
        }
        Bitmap bitmap4 = bitmap2;
        float f19 = length;
        Canvas canvas4 = canvas2;
        float f20 = f8;
        Float[] fArr6 = fArr3;
        float f21 = f12;
        for (int i6 = 0; i6 < strArr.length; i6++) {
            String str5 = strArr[i6];
            float floatValue = fArr6[i6].floatValue();
            float length4 = f20 - (((float) str5.length()) * f6);
            String str6 = textItem2.align;
            char c = 65535;
            int hashCode = str6.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode == 108511772 && str6.equals("right")) {
                    c = 0;
                }
            } else if (str6.equals("center")) {
                c = 1;
            }
            if (c == 0) {
                f2 = (f21 + length4) - floatValue;
            } else if (c != 1) {
                f = f21;
                a(canvas4, textPaint, str5, f, f19 + (((float) i6) * f7), floatValue, f6, textItem2.mode);
            } else {
                f2 = f21 + ((length4 - floatValue) / 2.0f);
            }
            f = f2;
            a(canvas4, textPaint, str5, f, f19 + (((float) i6) * f7), floatValue, f6, textItem2.mode);
        }
        return bitmap4;
    }

    public static String a(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static float[] a(TextItem textItem, co.polarr.renderer.entities.Context context, d dVar) {
        TextItem textItem2 = textItem;
        co.polarr.renderer.entities.Context context2 = context;
        d dVar2 = dVar;
        float f = (float) dVar2.f12b;
        float f2 = (float) dVar2.c;
        d dVar3 = context2.imageTexture;
        float f3 = (float) dVar3.f12b;
        float f4 = (float) dVar3.c;
        float f5 = f3 / f4;
        float[] fArr = textItem2.orientation % 2.0f != 0.0f ? new float[]{f4, f3} : new float[]{f3, f4};
        float f6 = fArr[0];
        float f7 = fArr[1];
        float[] a2 = o.a();
        float[] a3 = o.a();
        float[] a4 = o.a();
        float[] fArr2 = a3;
        Matrix.orthoM(a3, 0, f6 / -2.0f, f6 / 2.0f, f7 / -2.0f, f7 / 2.0f, -1.0f, 1.0f);
        Matrix.invertM(a4, 0, fArr2, 0);
        if (textItem2.position == null) {
            textItem2.position = new float[]{0.0f, 0.0f};
        }
        float[] fArr3 = textItem2.position;
        Matrix.translateM(a2, 0, (fArr3[0] - 0.5f) * 2.0f, (fArr3[1] - 0.5f) * 2.0f * f5, 0.0f);
        float[] fArr4 = a2;
        Matrix.multiplyMM(fArr4, 0, a2, 0, fArr2, 0);
        Matrix.rotateM(fArr4, 0, textItem2.angle + textItem2.orientation, 0.0f, 0.0f, 1.0f);
        Matrix.multiplyMM(fArr4, 0, a2, 0, a4, 0);
        d dVar4 = context2.imageTexture;
        Matrix.scaleM(a2, 0, f / ((float) dVar4.f12b), f2 / ((float) dVar4.c), 1.0f);
        return a2;
    }

    public static float[] a(String[] strArr, TextPaint textPaint) {
        float[] fArr = new float[strArr.length];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            fArr[i2] = a(strArr[i], (Paint) textPaint);
            i++;
            i2++;
        }
        return fArr;
    }

    public static String[] a(Context context, AssetManager assetManager, String str, b bVar) {
        String str2 = str;
        b bVar2 = bVar;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(i.a(context, assetManager, bVar2.i, bVar2.j));
        textPaint.setTextSize(bVar2.c);
        float f = bVar2.f;
        float f2 = bVar2.f81a;
        float f3 = 0.0f;
        if (f2 == 0.0f) {
            return str2.split("\n");
        }
        ArrayList arrayList = new ArrayList();
        float a2 = a(" ", (Paint) textPaint);
        float f4 = (float) ((int) f2);
        String[] split = str2.split("\n");
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str3 = split[i];
            ArrayList arrayList2 = new ArrayList();
            float f5 = f3;
            int i2 = 0;
            for (String str4 : str3.split(" ")) {
                float a3 = a(str4, (Paint) textPaint) + (((float) str4.length()) * f);
                f5 += a3;
                if (f5 <= f4) {
                    f5 += a2 + f;
                } else if (i2 > 0) {
                    arrayList.add(a((List<String>) arrayList2, " "));
                    arrayList2.clear();
                    f5 = a3;
                }
                arrayList2.add(str4);
                i2++;
            }
            i++;
            f3 = 0.0f;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
