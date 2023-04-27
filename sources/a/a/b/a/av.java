package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.e.o;
import android.content.res.Resources;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;

public class av extends b {
    public static LruCache<String, av> q = new LruCache<>(5);

    public av(Resources resources, Context context) {
        super(resources, "basic.glsl", context);
    }

    public static av a(Resources resources, Context context) {
        av avVar = q.get(Thread.currentThread().getName());
        if (avVar == null) {
            avVar = new av(resources, context);
            avVar.a();
            q.put(Thread.currentThread().getName(), avVar);
        }
        avVar.a(context);
        avVar.a(o.a());
        return avVar;
    }

    public static void l() {
        q.evictAll();
    }

    public void e() {
    }

    public boolean k() {
        return false;
    }
}
