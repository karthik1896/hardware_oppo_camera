package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.util.Map;

public class x extends b {
    public String q = "square";

    public x(Resources resources, Context context) {
        super(resources, t.a("mosaic"), context);
        this.o = t.a("composite_vertex");
        a(new String[]{"mosaic_size"});
    }

    public void i() {
        float f;
        Map<String, d> map;
        d dVar;
        Map<String, d> map2;
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "blurTexture");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.f2a.denoiseTexture.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
        if (this.f2a.renderStates.containsKey("mosaic_pattern")) {
            Object obj = this.f2a.renderStates.get("mosaic_pattern");
            if ((obj instanceof String) && (map2 = this.f2a.patterns) != null && map2.containsKey(obj)) {
                this.q = (String) obj;
            }
        }
        String str = this.q;
        if (!(str == null || (map = this.f2a.patterns) == null || (dVar = map.get(str)) == null)) {
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "patternTexture");
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, dVar.f11a);
            GLES20.glUniform1i(glGetUniformLocation2, 2);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "patternSize"), (float) dVar.f12b, (float) dVar.c);
        }
        if (this.f2a.isSDK) {
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f3b, "mosaic_size");
            Object a2 = f.a("mosaic_size", this.f2a.renderStates);
            if (a2 != null) {
                d dVar2 = this.f2a.imageTexture;
                f = (float) (((double) Float.parseFloat(a2.toString())) * Math.sqrt((double) (((float) (dVar2.f12b * dVar2.c)) / 2073600.0f)));
            } else {
                f = 0.0f;
            }
            GLES20.glUniform1f(glGetUniformLocation3, f);
        }
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "viewMatrix"), 1, false, this.f2a.matrix, 0);
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.f3b, "imgSize");
        d dVar3 = this.f2a.imageTexture;
        GLES20.glUniform2f(glGetUniformLocation4, (float) dVar3.f12b, (float) dVar3.c);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_amount"), ((Float) f.a("distortion_amount", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_horizontal"), ((Float) f.a("distortion_horizontal", this.f2a.renderStates)).floatValue());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "distortion_vertical"), ((Float) f.a("distortion_vertical", this.f2a.renderStates)).floatValue());
    }
}
