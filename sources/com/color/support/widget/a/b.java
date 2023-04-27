package com.color.support.widget.a;

import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: ShapePath */
public class b {
    public static Path a(Path path, RectF rectF, float f, boolean z, boolean z2, boolean z3, boolean z4) {
        float f2;
        float f3;
        Path path2 = path;
        RectF rectF2 = rectF;
        float f4 = f < 0.0f ? 0.0f : f;
        path.reset();
        float f5 = rectF2.left;
        float f6 = rectF2.right;
        float f7 = rectF2.bottom;
        float f8 = rectF2.top;
        float f9 = f6 - f5;
        float f10 = f7 - f8;
        float f11 = f9 / 2.0f;
        float f12 = f10 / 2.0f;
        float f13 = 1.0f;
        float min = ((double) (f4 / Math.min(f11, f12))) > 0.5d ? 1.0f - (Math.min(1.0f, ((f4 / Math.min(f11, f12)) - 0.5f) / 0.4f) * 0.13877845f) : 1.0f;
        if (f4 / Math.min(f11, f12) > 0.6f) {
            f13 = 1.0f + (Math.min(1.0f, ((f4 / Math.min(f11, f12)) - 0.6f) / 0.3f) * 0.042454004f);
        }
        float f14 = f13;
        path2.moveTo(f5 + f11, f8);
        if (!z2) {
            path2.lineTo(f5 + f9, f8);
            f2 = f11;
        } else {
            float f15 = f4 / 100.0f;
            float f16 = f15 * 128.19f * min;
            path2.lineTo(Math.max(f11, f9 - f16) + f5, f8);
            float f17 = f5 + f9;
            float f18 = f15 * 83.62f * f14;
            float f19 = f15 * 67.45f;
            float f20 = f15 * 4.64f;
            float f21 = f15 * 51.16f;
            float f22 = f15 * 13.36f;
            f2 = f11;
            path.cubicTo(f17 - f18, f8, f17 - f19, f8 + f20, f17 - f21, f8 + f22);
            float f23 = f15 * 34.86f;
            float f24 = f15 * 22.07f;
            path.cubicTo(f17 - f23, f8 + f24, f17 - f24, f8 + f23, f17 - f22, f8 + f21);
            path.cubicTo(f17 - f20, f8 + f19, f17, f8 + f18, f17, f8 + Math.min(f12, f16));
        }
        if (!z4) {
            path2.lineTo(f9 + f5, f8 + f10);
            f3 = f2;
        } else {
            float f25 = f5 + f9;
            float f26 = f4 / 100.0f;
            float f27 = f26 * 128.19f * min;
            path2.lineTo(f25, Math.max(f12, f10 - f27) + f8);
            float f28 = f8 + f10;
            float f29 = f26 * 83.62f * f14;
            float f30 = f26 * 4.64f;
            float f31 = f26 * 67.45f;
            float f32 = f26 * 13.36f;
            float f33 = f26 * 51.16f;
            path.cubicTo(f25, f28 - f29, f25 - f30, f28 - f31, f25 - f32, f28 - f33);
            float f34 = f26 * 22.07f;
            float f35 = f26 * 34.86f;
            path.cubicTo(f25 - f34, f28 - f35, f25 - f35, f28 - f34, f25 - f33, f28 - f32);
            float f36 = f25 - f29;
            f3 = f2;
            path.cubicTo(f25 - f31, f28 - f30, f36, f28, f5 + Math.max(f3, f9 - f27), f28);
        }
        if (!z3) {
            path2.lineTo(f5, f10 + f8);
        } else {
            float f37 = f4 / 100.0f;
            float f38 = f37 * 128.19f * min;
            float f39 = f8 + f10;
            path2.lineTo(Math.min(f3, f38) + f5, f39);
            float f40 = f37 * 83.62f * f14;
            float f41 = f37 * 67.45f;
            float f42 = f37 * 4.64f;
            float f43 = f37 * 51.16f;
            float f44 = f37 * 13.36f;
            float f45 = f39;
            path.cubicTo(f5 + f40, f39, f5 + f41, f39 - f42, f5 + f43, f39 - f44);
            float f46 = f37 * 34.86f;
            float f47 = f37 * 22.07f;
            path.cubicTo(f5 + f46, f45 - f47, f5 + f47, f45 - f46, f5 + f44, f45 - f43);
            path.cubicTo(f5 + f42, f45 - f41, f5, f45 - f40, f5, f8 + Math.max(f12, f10 - f38));
        }
        if (!z) {
            path2.lineTo(f5, f8);
        } else {
            float f48 = f4 / 100.0f;
            float f49 = 128.19f * f48 * min;
            path2.lineTo(f5, Math.min(f12, f49) + f8);
            float f50 = 83.62f * f48 * f14;
            float f51 = 4.64f * f48;
            float f52 = 67.45f * f48;
            float f53 = 13.36f * f48;
            float f54 = 51.16f * f48;
            Path path3 = path;
            path3.cubicTo(f5, f8 + f50, f5 + f51, f8 + f52, f5 + f53, f8 + f54);
            float f55 = 22.07f * f48;
            float f56 = f48 * 34.86f;
            path3.cubicTo(f5 + f55, f8 + f56, f5 + f56, f8 + f55, f5 + f54, f8 + f53);
            path.cubicTo(f5 + f52, f8 + f51, f5 + f50, f8, f5 + Math.min(f3, f49), f8);
        }
        path.close();
        return path2;
    }

    public static Path a(Path path, RectF rectF, float f) {
        return a(path, rectF, f, true, true, true, true);
    }
}
