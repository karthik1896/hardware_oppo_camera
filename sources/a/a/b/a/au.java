package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.q;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.util.Arrays;

public class au extends b {
    public au(Resources resources, Context context) {
        super(resources, t.a("vignette"), context);
        this.o = t.a("composite_vertex");
        a(new String[]{"vignette_amount", "vignette_feather", "vignette_highlights", "vignette_roundness", "vignette_size"});
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "crop");
        float[] fArr = (float[]) f.a("crop", this.f2a.renderStates);
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        copyOf[1] = (1.0f - copyOf[3]) - copyOf[1];
        GLES20.glUniform4fv(glGetUniformLocation, 1, copyOf, 0);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "rotationMatrix"), 1, false, this.f2a.rotation90MatrixInv, 0);
        float[] b2 = q.b(this.f2a);
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "imgSize"), b2[0], b2[1]);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
    }
}
