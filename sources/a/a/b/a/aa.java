package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.o;
import a.a.b.e.q;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class aa extends b {
    public static LruCache<String, aa> q = new LruCache<>(5);

    public aa(Resources resources, Context context) {
        super(resources, t.a("watermark"), context);
        a(new String[]{"opacity"});
    }

    public static aa a(Resources resources, Context context) {
        aa aaVar = q.get(Thread.currentThread().getName());
        if (aaVar == null) {
            aaVar = new aa(resources, context);
            aaVar.a();
            q.put(Thread.currentThread().getName(), aaVar);
        }
        aaVar.a(context);
        return aaVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void d() {
    }

    public void e() {
    }

    public void i() {
        Context context = this.f2a;
        if (context.watermarkTexture != null) {
            Context.WatermarkOptions watermarkOptions = context.watermarkOptions;
            if (watermarkOptions.enabled || watermarkOptions.preview) {
                m();
                super.i();
                int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "texture");
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.f2a.watermarkTexture.f11a);
                GLES20.glUniform1i(glGetUniformLocation, 0);
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.f2a.watermarkOptions.opacity);
            }
        }
    }

    public final void m() {
        float[] a2 = q.a(this.f2a);
        Context context = this.f2a;
        d dVar = context.watermarkTexture;
        float f = (float) dVar.f12b;
        float f2 = (float) dVar.c;
        float f3 = a2[2];
        float f4 = a2[3];
        float[] b2 = q.b(context);
        if (this.f2a.cropMode) {
            f3 = b2[0];
            f4 = b2[1];
        }
        float f5 = f / f3;
        float f6 = f2 / f4;
        Context.WatermarkOptions watermarkOptions = this.f2a.watermarkOptions;
        float[] fArr = watermarkOptions.position;
        float f7 = watermarkOptions.scale;
        float f8 = watermarkOptions.rotation;
        float max = Math.max(f5, f6);
        float f9 = (f5 / max) * f7;
        float f10 = (f6 / max) * f7;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = b2[0] / 2.0f;
        float f14 = b2[1] / 2.0f;
        float f15 = a2[0];
        float f16 = this.f2a.cropScale;
        float[] fArr2 = {((f15 - f13) * f16) + f13, ((a2[1] - f14) * f16) + f14, a2[2] * f16, a2[3] * f16};
        float f17 = fArr2[0];
        float f18 = fArr2[1];
        float f19 = (-(((b2[0] - fArr2[2]) / 2.0f) - f17)) / fArr2[2];
        float f20 = (-(((b2[1] - fArr2[3]) / 2.0f) - f18)) / fArr2[3];
        float f21 = fArr2[2] / b2[0];
        float f22 = fArr2[3] / b2[1];
        float[] a3 = o.a();
        Matrix.multiplyMM(a3, 0, a3, 0, this.f2a.viewMatrix, 0);
        Matrix.scaleM(a3, 0, this.f2a.viewMatrix, 0, f21, f22, 1.0f);
        Matrix.translateM(a3, 0, f19 * 2.0f, f20 * 2.0f, 0.0f);
        Matrix.translateM(a3, 0, f11 - (f9 * f11), f12 - (f10 * f12), 0.0f);
        Matrix.scaleM(a3, 0, 1.0f / f3, 1.0f / f4, 1.0f);
        Matrix.rotateM(a3, 0, f8, 0.0f, 0.0f, 1.0f);
        Matrix.scaleM(a3, 0, f3, f4, 1.0f);
        Matrix.scaleM(a3, 0, f9, f10, 1.0f);
        a(a3);
    }
}
