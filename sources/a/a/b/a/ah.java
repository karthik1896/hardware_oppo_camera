package a.a.b.a;

import a.a.b.a.a.b;
import android.content.res.Resources;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class ah extends b {
    public static LruCache<String, ah> q = new LruCache<>(5);
    public boolean r = true;

    public ah(Resources resources, Context context) {
        super(resources, "basic.glsl", context);
    }

    public void draw() {
        super.draw();
    }

    public void e() {
        if (this.r) {
            super.e();
        }
    }

    public float[] getMatrix() {
        return super.getMatrix();
    }

    public boolean k() {
        return false;
    }
}
