package a.a.b.e;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class a {
    public static double a(double d) {
        double d2 = d * 2.0d;
        if (d2 >= 1.0d) {
            double d3 = d2 - 1.0d;
            d2 = Math.log(0.5d) / Math.log(((1.0d - d3) * 0.5d) + (d3 * 0.9332d));
        }
        return a(d2, 0.0d, 10.0d);
    }

    public static double a(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static float a(float f) {
        double d = (double) f;
        return (float) Math.exp(-6.283185307179586d * d * d);
    }

    public static float a(float f, float f2, float f3) {
        return (f2 * (1.0f - f)) + (f3 * f);
    }

    public static float a(float[] fArr, float[] fArr2) {
        float f = fArr2[0] - fArr[0];
        float f2 = fArr2[1] - fArr[1];
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public static float a(float[] fArr, float[] fArr2, float[] fArr3) {
        float b2 = b(fArr2, fArr3);
        if (b2 == 0.0f) {
            return b(fArr, fArr2);
        }
        float max = Math.max(0.0f, Math.min(1.0f, (((fArr[0] - fArr2[0]) * (fArr3[0] - fArr2[0])) + ((fArr[1] - fArr2[1]) * (fArr3[1] - fArr2[1]))) / b2));
        return a(fArr, new float[]{fArr2[0] + ((fArr3[0] - fArr2[0]) * max), fArr2[1] + (max * (fArr3[1] - fArr2[1]))});
    }

    public static float a(float[] fArr, float[][] fArr2) {
        if (b(fArr, fArr2)) {
            return 0.0f;
        }
        int length = fArr2.length;
        float f = 1.0f;
        int i = length - 1;
        for (int i2 = 0; i2 < length; i2++) {
            a(fArr, fArr2[i2], fArr2[i]);
            f = Math.min(f, a(fArr, fArr2[i2], fArr2[i]));
            i = i2;
        }
        return f;
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float min = Math.min(1.0f, Math.min(f / width, f2 / height));
        return Bitmap.createScaledBitmap(bitmap, (int) (width * min), (int) (height * min), true);
    }

    public static <T> T a(Object obj, Class<T> cls) {
        return m.a(m.a(obj), cls);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null && obj2 != null) {
            return false;
        }
        if (obj == null || obj2 != null) {
            return m.a(obj).equals(m.a(obj2));
        }
        return false;
    }

    public static byte[] a(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr, 0, inputStream.available());
        return bArr;
    }

    public static float[] a(float[] fArr) {
        if (fArr == null || fArr.length < 2) {
            return fArr;
        }
        return new float[]{fArr[0], -fArr[1]};
    }

    public static float[] a(float[] fArr, float f) {
        double d = (double) ((float) (((double) f) * 0.017453292519943295d));
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        return new float[]{(fArr[0] * cos) - (fArr[1] * sin), (fArr[0] * sin) + (fArr[1] * cos)};
    }

    public static float[] a(float[] fArr, float[] fArr2, float[] fArr3, float f) {
        float f2 = fArr2[0];
        float f3 = fArr2[1];
        fArr[0] = f2 + ((fArr3[0] - f2) * f);
        fArr[1] = f3 + (f * (fArr3[1] - f3));
        return fArr;
    }

    public static float[] a(float[][] fArr) {
        int length = fArr.length;
        float f = 1.0f;
        float f2 = -1.0f;
        float f3 = -1.0f;
        float f4 = 1.0f;
        for (int i = 0; i < length; i++) {
            float f5 = fArr[i][0];
            float f6 = fArr[i][1];
            f4 = Math.min(f4, f5);
            f2 = Math.max(f2, f5);
            f = Math.min(f, f6);
            f3 = Math.max(f3, f6);
        }
        return new float[]{(f4 * 0.5f) + (f2 * 0.5f), (f * 0.5f) + (f3 * 0.5f)};
    }

    public static float b(float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    public static float b(float[] fArr, float[] fArr2) {
        float f = fArr2[0] - fArr[0];
        float f2 = fArr2[1] - fArr[1];
        return (f * f) + (f2 * f2);
    }

    public static boolean b(float[] fArr, float[][] fArr2) {
        float[][] fArr3 = new float[(fArr2.length + 1)][];
        System.arraycopy(fArr2, 0, fArr3, 0, fArr2.length);
        fArr3[fArr2.length] = fArr2[0];
        float f = fArr[0];
        float f2 = fArr[1];
        int length = fArr3.length - 1;
        boolean z = false;
        for (int i = 0; i < fArr3.length; i++) {
            float f3 = fArr3[i][0];
            float f4 = fArr3[i][1];
            float f5 = fArr3[length][0];
            float f6 = fArr3[length][1];
            if (((f4 > f2 ? 1 : (f4 == f2 ? 0 : -1)) > 0) != ((f6 > f2 ? 1 : (f6 == f2 ? 0 : -1)) > 0) && f < (((f5 - f3) * (f2 - f4)) / (f6 - f4)) + f3) {
                z = !z;
            }
            length = i;
        }
        return z;
    }

    public static byte[] b(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
        bitmap.copyPixelsToBuffer(allocate);
        return allocate.array();
    }

    public static float[] b(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] + fArr3[0];
        fArr[1] = fArr2[1] + fArr3[1];
        return fArr;
    }

    public static float[] c(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] / fArr3[0];
        fArr[1] = fArr2[1] / fArr3[1];
        return fArr;
    }

    public static float[] d(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] * fArr3[0];
        fArr[1] = fArr2[1] * fArr3[1];
        return fArr;
    }

    public static float[] e(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = fArr2[0] - fArr3[0];
        fArr[1] = fArr2[1] - fArr3[1];
        return fArr;
    }
}
