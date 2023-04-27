package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;

public class bf extends b {
    public float q = 1.0f;
    public float r = 1.0f;
    public int s = 0;
    public float[] t = {1.0f, 0.0f, 0.0f, 0.0f};

    public bf(Resources resources, Context context) {
        super(resources, t.a("paint_overlay"), context);
    }

    public void draw() {
        j();
        i();
        d();
        g();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "overlay");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.s);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        GLES20.glUniform4fv(GLES20.glGetUniformLocation(this.f3b, "overlayMask"), 1, this.t, 0);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "opacity"), this.q);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "overlayMix"), this.r);
    }
}
