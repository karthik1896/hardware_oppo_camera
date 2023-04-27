package a.a.b.d;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public class c extends b {
    public Surface c;
    public boolean d;

    public c(a aVar, SurfaceTexture surfaceTexture) {
        super(aVar);
        a(surfaceTexture);
    }

    public void d() {
        b();
        Surface surface = this.c;
        if (surface != null) {
            if (this.d) {
                surface.release();
            }
            this.c = null;
        }
    }
}
