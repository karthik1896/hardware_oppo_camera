package com.coloros.anim.f;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.coloros.anim.a.a.s;
import com.coloros.anim.a.b.c;
import com.coloros.anim.k;
import java.io.Closeable;

/* compiled from: Utils */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final PathMeasure f2459a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private static final Path f2460b = new Path();
    private static final Path c = new Path();
    private static final float[] d = new float[4];
    private static final float e = ((float) Math.sqrt(2.0d));
    private static float f = -1.0f;

    public static int a(float f2, float f3, float f4, float f5) {
        int i = f2 != 0.0f ? (int) (((float) 527) * f2) : 17;
        if (f3 != 0.0f) {
            i = (int) (((float) (i * 31)) * f3);
        }
        if (f4 != 0.0f) {
            i = (int) (((float) (i * 31)) * f4);
        }
        return f5 != 0.0f ? (int) (((float) (i * 31)) * f5) : i;
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i < i4) {
            return false;
        }
        if (i > i4) {
            return true;
        }
        if (i2 < i5) {
            return false;
        }
        if (i2 > i5) {
            return true;
        }
        return i3 >= i6;
    }

    public static Path a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            Path path2 = path;
            path2.cubicTo(pointF3.x + pointF.x, pointF.y + pointF3.y, pointF2.x + pointF4.x, pointF2.y + pointF4.y, pointF2.x, pointF2.y);
        }
        return path;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static float a(Matrix matrix) {
        float[] fArr = d;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f2 = e;
        fArr[2] = f2;
        fArr[3] = f2;
        matrix.mapPoints(fArr);
        float[] fArr2 = d;
        return ((float) Math.hypot((double) (fArr2[2] - fArr2[0]), (double) (fArr2[3] - fArr2[1]))) / 2.0f;
    }

    public static void a(Path path, s sVar) {
        if (sVar != null && !sVar.g()) {
            a(path, ((c) sVar.d()).i() / 100.0f, ((c) sVar.e()).i() / 100.0f, ((c) sVar.f()).i() / 360.0f);
        }
    }

    public static void a(Path path, float f2, float f3, float f4) {
        k.c("applyTrimPathIfNeeded");
        f2459a.setPath(path, false);
        float length = f2459a.getLength();
        if (f2 == 1.0f && f3 == 0.0f) {
            k.d("applyTrimPathIfNeeded");
        } else if (length < 1.0f || ((double) Math.abs((f3 - f2) - 1.0f)) < 0.01d) {
            k.d("applyTrimPathIfNeeded");
        } else {
            float f5 = f2 * length;
            float f6 = f3 * length;
            float f7 = f4 * length;
            float min = Math.min(f5, f6) + f7;
            float max = Math.max(f5, f6) + f7;
            if (min >= length && max >= length) {
                min = (float) f.a(min, length);
                max = (float) f.a(max, length);
            }
            if (min < 0.0f) {
                min = (float) f.a(min, length);
            }
            if (max < 0.0f) {
                max = (float) f.a(max, length);
            }
            int i = (min > max ? 1 : (min == max ? 0 : -1));
            if (i == 0) {
                path.reset();
                k.d("applyTrimPathIfNeeded");
                return;
            }
            if (i >= 0) {
                min -= length;
            }
            f2460b.reset();
            f2459a.getSegment(min, max, f2460b, true);
            if (max > length) {
                c.reset();
                f2459a.getSegment(0.0f, max % length, c, true);
                f2460b.addPath(c);
            } else if (min < 0.0f) {
                c.reset();
                f2459a.getSegment(min + length, length, c, true);
                f2460b.addPath(c);
            }
            path.set(f2460b);
            k.d("applyTrimPathIfNeeded");
        }
    }

    public static float a() {
        if (f == -1.0f) {
            f = Resources.getSystem().getDisplayMetrics().density;
        }
        return f;
    }

    public static void b() {
        f = Resources.getSystem().getDisplayMetrics().density;
    }

    public static Typeface a(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}
