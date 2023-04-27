package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;

public class ab extends b {
    public ab(Resources resources, Context context) {
        super(resources, t.a("grain"), context);
        this.o = t.a("composite_vertex");
        a(new String[]{"grain_amount", "grain_size"});
    }

    public void i() {
        super.i();
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "scale"), this.f2a.zoom);
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation, (float) dVar.f12b, (float) dVar.c);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
    }
}
