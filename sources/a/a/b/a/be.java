package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.t;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import com.oppo.camera.statistics.CameraStatisticsUtil;

public class be extends b {
    public static LruCache<String, be> q = new LruCache<>(5);
    public float[] r;

    public be(Resources resources, Context context) {
        super(resources, t.a(CameraStatisticsUtil.PORTRAIT_BLUR), context);
        a(new String[]{CameraStatisticsUtil.PORTRAIT_BLUR});
    }

    public static be a(Resources resources, Context context) {
        be beVar = q.get(Thread.currentThread().getName());
        if (beVar == null) {
            beVar = new be(resources, context);
            beVar.a();
            q.put(Thread.currentThread().getName(), beVar);
        }
        beVar.a(context);
        return beVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void i() {
        super.i();
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "delta");
        float[] fArr = this.r;
        GLES20.glUniform2fv(glGetUniformLocation, fArr.length / 2, fArr, 0);
    }
}
