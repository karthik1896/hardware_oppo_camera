package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.q;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import com.oppo.camera.statistics.CameraStatisticsUtil;

public class bc extends b {
    public bc(Resources resources, Context context) {
        super(resources, t.a("screen"), context);
        this.o = t.a("screen_vertex");
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "cacheTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, b());
        GLES20.glUniform1i(glGetUniformLocation, 1);
        GLES20.glBindTexture(3553, this.f2a.cacheTexture.f11a);
        float[] fArr = (float[]) f.a("grid_size", this.f2a.renderStates);
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "grid_size"), fArr[0], fArr[1]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "showTexture"), 1.0f);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "cropMatrix"), 1, false, this.f2a.cropMatrix, 0);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.viewMatrix, 0);
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "img_size");
        float[] a2 = q.a(this.f2a);
        GLES20.glUniform2f(glGetUniformLocation2, a2[2], a2[3]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, CameraStatisticsUtil.PORTRAIT_ZOOM), this.f2a.screen.zoom);
    }
}
