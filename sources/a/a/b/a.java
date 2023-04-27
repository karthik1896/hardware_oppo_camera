package a.a.b;

import a.a.b.a.ak;
import a.a.b.b.c;
import a.a.b.b.d;
import a.a.b.e.b;
import a.a.b.e.h;
import a.a.b.e.s;
import a.a.b.e.t;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.entities.Cube;
import co.polarr.renderer.entities.FilterItem;
import co.polarr.renderer.entities.MagicEraserPath;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f1a;

    public static int a() {
        int i;
        synchronized (a.class) {
            try {
                i = f1a / 90;
            } catch (Throwable th) {
                Class<a> cls = a.class;
                throw th;
            }
        }
        return i % 4;
    }

    public static List<Bitmap> a(Resources resources, Bitmap bitmap, List<String> list) {
        return a(resources, bitmap, list, 1.0f, 0.0f);
    }

    public static List<Bitmap> a(Resources resources, Bitmap bitmap, List<String> list, float f, float f2) {
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || list == null || list.isEmpty()) {
            return null;
        }
        b.a("renderBitmaps::idList=%s::filterIntensity=%f", list.toString(), Float.valueOf(f));
        c cVar = new c();
        cVar.a(100, 100);
        d dVar = new d();
        dVar.a(resources, bitmap.getWidth(), bitmap.getHeight(), true, 0);
        dVar.c();
        ArrayList arrayList = new ArrayList();
        for (String a2 : list) {
            arrayList.add(dVar.a(bitmap, a2, f, f2));
        }
        dVar.o();
        cVar.a();
        return arrayList;
    }

    public static void a(float f, float f2, float f3, float f4, float f5, float f6) {
        b.a("setupVignetteParams::vignette_amount=%f::vignette_feather=%f::vignette_highlights=%f::vignette_exposure=%f::vignette_roundness=%f::vignette_size=%f", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6));
        ak.r = f;
        ak.s = f2;
        ak.t = f3;
        ak.u = f4;
        ak.v = f5;
        ak.w = f6;
    }

    public static void a(int i) {
        synchronized (a.class) {
            try {
                b.a("PolarrRenderImpl::updateGlobalScreenOrientation = %d", Integer.valueOf(i));
                f1a = i;
            } catch (Throwable th) {
                Class<a> cls = a.class;
                throw th;
            }
        }
    }

    public static void a(int i, int i2, int i3) {
        b.a("clearTextureHelper::textureId=%d::width=%d::height=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        ByteBuffer allocate = ByteBuffer.allocate(i2 * i3 * 4);
        GLES20.glBindTexture(3553, i);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, allocate);
        GLES20.glBindTexture(3553, 0);
    }

    public static void a(d dVar) {
        if (dVar != null) {
            s.a(dVar.f11a);
        }
    }

    public static void a(Resources resources, int i, int i2, int i3, MagicEraserPath magicEraserPath, int i4) {
        if (i > 0) {
            a("start magicEraserOneTime");
            if (magicEraserPath != null) {
                b.a("doMagicEraserOneTime::applyTextureId=%d::width=%d::height=%d::path=%s::compatibleLevel=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), magicEraserPath, Integer.valueOf(i4));
                boolean glIsEnabled = GLES20.glIsEnabled(3089);
                if (glIsEnabled) {
                    GLES20.glDisable(3089);
                }
                int[] iArr = new int[4];
                GLES20.glGetIntegerv(2978, iArr, 0);
                h hVar = new h(resources, t.a(resources));
                hVar.b(i, i2, i3, i4);
                hVar.a(i, magicEraserPath);
                hVar.a();
                hVar.b();
                GLES20.glViewport(iArr[0], iArr[1], iArr[2], iArr[3]);
                if (glIsEnabled) {
                    GLES20.glEnable(3089);
                }
                a("end magicEraserOneTime");
            }
        }
    }

    public static void a(String str) {
    }

    public static void a(boolean z) {
        b.a(z);
        b.a("enableLogger::enableLogger=%b", Boolean.valueOf(z));
    }

    public static byte[] a(Context context, byte[] bArr, int i, int i2, String str, float f, boolean z) {
        String str2 = str;
        b.a("renderNV21::width=%d::height=%d::filterId=%s::filterIntensity=%f::isUseVignette=%b", Integer.valueOf(i), Integer.valueOf(i2), str2, Float.valueOf(f), Boolean.valueOf(z));
        boolean a2 = FilterPackageUtil.a(str2, "vignette_amount");
        boolean a3 = FilterPackageUtil.a(str2, "overlay_amount");
        if (z || a2 || a3) {
            a(context, bArr, i, i2, str, false);
            throw null;
        }
        Cube b2 = FilterPackageUtil.b(context.getAssets(), str2);
        a.a.a.a.a(i, i2, i, i2, false, -1, b2.data, bArr, false, b2.size);
        throw null;
    }

    public static byte[] a(Context context, byte[] bArr, int i, int i2, String str, boolean z) {
        String str2 = str;
        b.a("renderNV12::getGlobalScreenOrientation=%d", Integer.valueOf(a()));
        Cube b2 = FilterPackageUtil.b(context.getAssets(), str2);
        boolean a2 = FilterPackageUtil.a(str2, "vignette_amount");
        boolean a3 = FilterPackageUtil.a(str2, "overlay_amount");
        if (a2) {
            FilterItem a4 = e.a().a(str2);
            a.a.a.a.a(i, i2, i, i2, false, -1, b2.data, bArr, z, b2.size, ((Float) a4.state.get("vignette_amount")).floatValue(), ((Float) a4.state.get("vignette_feather")).floatValue(), ((Float) a4.state.get("vignette_highlights")).floatValue(), ((Float) a4.state.get("vignette_exposure")).floatValue(), ((Float) a4.state.get("vignette_roundness")).floatValue(), ((Float) a4.state.get("vignette_size")).floatValue(), true, ak.x, a(), 0.08f, 0.6f, 0.88f, 0.2f);
            throw null;
        } else if (a3) {
            a.a.a.a.a(i, i2, i, i2, false, -2, b2.data, bArr, z, b2.size, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, true, ak.y, a());
            throw null;
        } else {
            int i3 = i;
            int i4 = i2;
            int i5 = i;
            int i6 = i2;
            byte[] bArr2 = bArr;
            boolean z2 = z;
            a.a.a.a.a(i3, i4, i5, i6, false, 0, b2.data, bArr2, z2, b2.size, ak.r, ak.s, ak.t, ak.u, ak.v, ak.w, false, new byte[0], a());
            throw null;
        }
    }

    public static Map<String, Object> b(String str) {
        Map<String, Object> a2 = a.a.b.e.c.a(str);
        for (String next : a2.keySet()) {
            a2.put(next, t.a(next, a2.get(next)));
        }
        return a2;
    }

    public static byte[] b(Context context, byte[] bArr, int i, int i2, String str, float f, boolean z) {
        String str2 = str;
        b.a("renderNV12::width=%d::height=%d::filterId=%s::filterIntensity=%f::isUseVignette=%b", Integer.valueOf(i), Integer.valueOf(i2), str2, Float.valueOf(f), Boolean.valueOf(z));
        boolean a2 = FilterPackageUtil.a(str2, "vignette_amount");
        boolean a3 = FilterPackageUtil.a(str2, "overlay_amount");
        if (z || a2 || a3) {
            a(context, bArr, i, i2, str, true);
            throw null;
        }
        Cube b2 = FilterPackageUtil.b(context.getAssets(), str2);
        a.a.a.a.a(i, i2, i, i2, false, -1, b2.data, bArr, true, b2.size);
        throw null;
    }
}
