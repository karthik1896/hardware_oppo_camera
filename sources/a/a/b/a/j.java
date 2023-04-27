package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;

public class j extends b {
    public j(Resources resources, Context context) {
        super(resources, t.a("sharpen"), context);
        this.o = t.a("sharpen_vertex");
        a(new String[]{"sharpen"});
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "step");
        Context context = this.f2a;
        d dVar = context.imageTexture;
        float f = context.zoom;
        GLES20.glUniform2f(glGetUniformLocation, (1.0f / ((float) dVar.f12b)) * f, (1.0f / ((float) dVar.c)) * f);
    }
}
