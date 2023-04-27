package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;

public class bq extends b {
    public float q = 0.0f;

    public bq(Resources resources, Context context) {
        super(resources, t.a("lookup_export_filter"), context);
    }

    public void i() {
        super.i();
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "lut_color_space"), this.q);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "img_size");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation, (float) dVar.f12b, (float) dVar.c);
    }

    public boolean k() {
        return !this.f2a.isLutRender;
    }
}
