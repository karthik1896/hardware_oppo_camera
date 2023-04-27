package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;

public class n extends b {
    public boolean q;
    public float r = 1.0f;

    public n(Resources resources, Context context) {
        super(resources, t.a("overlay"), context);
    }

    public void draw() {
        j();
        i();
        d();
        g();
    }

    public void i() {
        super.i();
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f3b, "overlayMask"), 1, this.f2a.overlayMask, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.r);
    }
}
