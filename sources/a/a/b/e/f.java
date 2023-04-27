package a.a.b.e;

import a.a.b.a.a.a;
import a.a.b.a.ap;
import a.a.b.a.bb;
import a.a.b.a.be;
import a.a.b.a.y;
import a.a.b.b.d;
import a.a.b.b.g;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.SpotItem;
import java.util.List;

public class f {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(co.polarr.renderer.entities.Context r4, android.content.res.Resources r5) {
        /*
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.renderStates
            java.lang.String r1 = "spots"
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            java.util.Map<java.lang.String, java.lang.Object> r1 = r4.renderStates
            java.lang.String r2 = "zPrevSpots"
            java.lang.Object r1 = r1.get(r2)
            java.util.List r1 = (java.util.List) r1
            if (r0 == 0) goto L_0x0030
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x0030
            boolean r3 = a.a.b.e.a.a((java.lang.Object) r1, (java.lang.Object) r0)
            if (r3 != 0) goto L_0x0030
            java.lang.Class r1 = r0.getClass()
            java.lang.Object r0 = a.a.b.e.a.a((java.lang.Object) r0, r1)
            r1 = r0
            java.util.List r1 = (java.util.List) r1
            c(r4, r5)
        L_0x0030:
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.renderStates
            r4.put(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.e.f.a(co.polarr.renderer.entities.Context, android.content.res.Resources):void");
    }

    public static void b(Context context, Resources resources) {
        GLES20.glDisable(3042);
        int[] iArr = context.textures;
        a a2 = (iArr == null || iArr.length <= 0) ? y.a(resources, context) : bb.a(resources, context);
        a2.a(o.a());
        g.a(context, context.imageTexture.f11a, context.readableTexture, a2, false);
        List list = (List) context.renderStates.get("spots");
        ap a3 = ap.a(resources, context);
        for (int i = 0; i < list.size(); i++) {
            SpotItem spotItem = (SpotItem) list.get(i);
            a3.r = spotItem.feather;
            a3.s = spotItem.size;
            a3.t = a.a(spotItem.position);
            a3.u = a.a(spotItem.sourcePosition);
            a3.v = spotItem.size[0] * 6.0f;
            a3.w = (float) Math.min(1, i);
            g.a(context, context.readableTexture.f11a, context.writableTexture, (a) a3, false);
            g.b(context);
        }
    }

    public static void c(Context context, Resources resources) {
        d dVar = context.paintTexture;
        int i = dVar.f12b;
        int i2 = dVar.c;
        d dVar2 = context.readableTexture;
        int i3 = dVar2.f12b;
        int i4 = dVar2.c;
        s.b(context.retouchTexture, i, i2);
        s.b(context.readableTexture, i, i2);
        s.b(context.writableTexture, i, i2);
        b(context, resources);
        be a2 = be.a(resources, context);
        a2.a(context);
        a2.r = new float[]{0.0f, (((float) i) / ((float) i2)) * 0.036f};
        g.a(context, context.readableTexture.f11a, context.writableTexture, (a) a2, true);
        a2.r = new float[]{0.036f, 0.0f};
        g.a(context, context.writableTexture.f11a, context.retouchTexture, (a) a2, false);
        s.b(context.readableTexture, i3, i4);
        s.b(context.writableTexture, i3, i4);
    }
}
