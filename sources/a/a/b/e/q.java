package a.a.b.e;

import a.a.b.b.d;
import a.a.b.f;
import android.opengl.Matrix;
import co.polarr.renderer.entities.Context;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static float f74a = -1.0f;

    public static float a(Context context, int i, int i2, boolean z, float[] fArr) {
        if (context.imageTexture == null) {
            return 1.0f;
        }
        float[] a2 = a(context);
        float[] fArr2 = context.margins;
        float f = context.margin;
        if (fArr == null) {
            fArr = b(context);
        }
        return Math.min(1.0f, Math.min(((((float) i) - ((fArr2[0] + fArr2[2]) * c(context))) - f) / ((context.cropMode || z) ? fArr[0] : a2[2]), ((((float) i2) - ((fArr2[1] + fArr2[3]) * c(context))) - f) / ((context.cropMode || z) ? fArr[1] : a2[3])));
    }

    public static void a(Context context, float f, float f2) {
        float max = Math.max(100.0f, f);
        float max2 = Math.max(100.0f, f2);
        context.fov = (float) Math.tan((double) 0.3926991f);
        context.invFov = -1.0f / context.fov;
        float[] a2 = o.a();
        o.a(a2, 0.7853982f, 1, 0.1f, 1000);
        Matrix.scaleM(a2, 0, a2, 0, 1.0f / (max / 2.0f), 1.0f / (max2 / 2.0f), 1.0f);
        context.perspectiveMatrix = a2;
    }

    public static float[] a(Context context) {
        if (context.imageTexture == null) {
            return new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        }
        float[] b2 = b(context);
        float f = b2[0];
        float f2 = b2[1];
        float[] fArr = (float[]) f.a("crop", context.renderStates);
        if (fArr == null) {
            fArr = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        }
        return new float[]{fArr[0] * f, fArr[1] * f2, fArr[2] * f, fArr[3] * f2};
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float[] b(co.polarr.renderer.entities.Context r4) {
        /*
            a.a.b.b.d r0 = r4.imageTexture
            r1 = 2
            if (r0 != 0) goto L_0x000b
            float[] r4 = new float[r1]
            r4 = {0, 0} // fill-array
            return r4
        L_0x000b:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.renderStates
            java.lang.String r2 = "rotate90"
            boolean r0 = r0.containsKey(r2)
            r3 = 0
            if (r0 == 0) goto L_0x0028
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.renderStates     // Catch:{ Exception -> 0x0024 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ Exception -> 0x0024 }
            java.lang.Float r0 = (java.lang.Float) r0     // Catch:{ Exception -> 0x0024 }
            float r0 = r0.floatValue()     // Catch:{ Exception -> 0x0024 }
            int r0 = (int) r0
            goto L_0x0029
        L_0x0024:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0028:
            r0 = r3
        L_0x0029:
            int r0 = java.lang.Math.abs(r0)
            int r0 = r0 % r1
            r2 = 1
            if (r0 <= 0) goto L_0x0040
            a.a.b.b.d r4 = r4.imageTexture
            float[] r0 = new float[r1]
            int r1 = r4.c
            float r1 = (float) r1
            r0[r3] = r1
            int r4 = r4.f12b
            float r4 = (float) r4
            r0[r2] = r4
            return r0
        L_0x0040:
            a.a.b.b.d r4 = r4.imageTexture
            float[] r0 = new float[r1]
            int r1 = r4.f12b
            float r1 = (float) r1
            r0[r3] = r1
            int r4 = r4.c
            float r4 = (float) r4
            r0[r2] = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.e.q.b(co.polarr.renderer.entities.Context):float[]");
    }

    public static float c(Context context) {
        if (f74a == -1.0f) {
            f74a = context.resources.getDisplayMetrics().density;
        }
        return f74a;
    }

    public static void d(Context context) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Context context2 = context;
        d dVar = context2.imageTexture;
        if (dVar != null) {
            float[] fArr = (float[]) f.a("crop", context2.renderStates);
            float[] a2 = a(context);
            float f7 = context2.screen.zoom;
            float f8 = context2.cropScale;
            float f9 = (((float) dVar.f12b) * f7) / f8;
            float f10 = (((float) dVar.c) * f7) / f8;
            float floatValue = context2.rotation + context2.screen.rotation[2] + ((float) (((int) ((Float) context2.renderStates.get("rotate90")).floatValue()) * 90));
            float[] b2 = b(context);
            if (context2.cropMode) {
                f6 = (float) Math.round(f9 / 2.0f);
                f5 = (float) Math.round(f10 / 2.0f);
                float[] fArr2 = context2.screen.rotation;
                float f11 = fArr2[0];
                f = fArr2[1];
                f2 = f11;
                f4 = 0.0f;
                f3 = 0.0f;
            } else {
                f5 = (float) Math.round((a2[3] / 2.0f) * context2.screen.zoom);
                float f12 = fArr[0];
                float f13 = b2[0];
                float f14 = context2.screen.zoom;
                f3 = (((1.0f - fArr[2]) / 2.0f) - f12) * f13 * f14;
                f4 = f14 * (((1.0f - fArr[3]) / 2.0f) - fArr[1]) * b2[1];
                f6 = (float) Math.round((a2[2] / 2.0f) * context2.screen.zoom);
                f2 = 0.0f;
                f = 0.0f;
            }
            float[] fArr3 = context2.margins;
            Context.Screen screen = context2.screen;
            float c = ((-screen.offset[0]) + screen.center[0]) - (((fArr3[0] - fArr3[2]) * c(context)) / 2.0f);
            Context.Screen screen2 = context2.screen;
            float c2 = ((-screen2.offset[1]) - screen2.center[1]) - (((fArr3[1] - fArr3[3]) * c(context)) / 2.0f);
            Context.Overlay overlay = context2.overlay;
            overlay.imageWidth = b2[0];
            overlay.imageHeight = b2[1];
            overlay.width = f9;
            overlay.height = f10;
            overlay.rotation = floatValue;
            Object a3 = f.a("flip_x", context2.renderStates);
            boolean booleanValue = a3 instanceof Boolean ? ((Boolean) a3).booleanValue() : false;
            Object a4 = f.a("flip_y", context2.renderStates);
            boolean booleanValue2 = a4 instanceof Boolean ? ((Boolean) a4).booleanValue() : false;
            int i = -1;
            context2.overlay.flipX = booleanValue ? -1 : 1;
            Context.Overlay overlay2 = context2.overlay;
            if (!booleanValue2) {
                i = 1;
            }
            overlay2.flipY = i;
            Context.Overlay overlay3 = context2.overlay;
            overlay3.tx = f3 + c;
            overlay3.ty = c2 - f4;
            float f15 = context2.invFov;
            float[] fArr4 = {c, c2, f15};
            float[] fArr5 = {f6, f5, 1.0f};
            float[] fArr6 = {overlay3.tx, overlay3.ty, f15};
            float[] fArr7 = {f9 * ((float) overlay3.flipX) * 0.5f, f10 * ((float) overlay3.flipY) * 0.5f, 1.0f};
            float[] fArr8 = context2.screenMatrix;
            Matrix.setIdentityM(fArr8, 0);
            float[] fArr9 = fArr8;
            Matrix.rotateM(fArr9, 0, context2.perspectiveMatrix, 0, (float) (-context2.screen.orientation), 0.0f, 0.0f, 1.0f);
            Matrix.translateM(context2.overlayMatrix, 0, context2.perspectiveMatrix, 0, fArr6[0], fArr6[1], fArr6[2]);
            Matrix.translateM(fArr9, 0, context2.perspectiveMatrix, 0, fArr4[0], fArr4[1], fArr4[2]);
            if (context2.cropMode) {
                float[] fArr10 = fArr8;
                float[] fArr11 = fArr8;
                Matrix.rotateM(fArr10, 0, fArr11, 0, -floatValue, 0.0f, 0.0f, 1.0f);
                Matrix.scaleM(fArr10, 0, fArr11, 0, fArr5[0], fArr5[1], fArr5[2]);
                Matrix.rotateM(fArr8, 0, fArr8, 0, f2, 1.0f, 0.0f, 0.0f);
                Matrix.rotateM(fArr8, 0, fArr8, 0, f, 0.0f, 1.0f, 0.0f);
            } else {
                Matrix.scaleM(fArr8, 0, fArr8, 0, fArr5[0], fArr5[1], fArr5[2]);
            }
            float[] fArr12 = context2.overlayMatrix;
            Matrix.rotateM(fArr12, 0, fArr12, 0, -floatValue, 0.0f, 0.0f, 1.0f);
            float[] fArr13 = context2.overlayMatrix;
            Matrix.scaleM(fArr13, 0, fArr13, 0, fArr7[0], fArr7[1], fArr7[2]);
            o.a(fArr8, false, true);
        }
    }
}
