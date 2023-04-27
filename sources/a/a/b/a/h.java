package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;

public class h extends b {
    public float q;
    public float r;

    public h(Resources resources, Context context) {
        super(resources, t.a("gausspyd"), context);
    }

    public void c(int i, int i2) {
        this.q = (float) i;
        this.r = (float) i2;
    }

    public void i() {
        super.i();
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "size"), this.q, this.r);
    }
}
