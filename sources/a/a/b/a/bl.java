package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.b.g;
import a.a.b.e.a;
import a.a.b.e.s;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bl extends b {
    public static LruCache<Map<String, Object>, byte[]> q = new LruCache<>(10);
    public static final Map<String, String> r = new HashMap();
    public d s;
    public byte[] t;
    public Map<String, Float> u = new HashMap();
    public boolean v;

    static {
        r.put("hue_red", "hue");
        r.put("hue_orange", "hue");
        r.put("hue_yellow", "hue");
        r.put("hue_green", "hue");
        r.put("hue_aqua", "hue");
        r.put("hue_blue", "hue");
        r.put("hue_purple", "hue");
        r.put("hue_magenta", "hue");
        r.put("saturation_red", "saturation");
        r.put("saturation_orange", "saturation");
        r.put("saturation_yellow", "saturation");
        r.put("saturation_green", "saturation");
        r.put("saturation_aqua", "saturation");
        r.put("saturation_blue", "saturation");
        r.put("saturation_purple", "saturation");
        r.put("saturation_magenta", "saturation");
        r.put("luminance_red", "luminance");
        r.put("luminance_orange", "luminance");
        r.put("luminance_yellow", "luminance");
        r.put("luminance_green", "luminance");
        r.put("luminance_aqua", "luminance");
        r.put("luminance_blue", "luminance");
        r.put("luminance_purple", "luminance");
        r.put("luminance_magenta", "luminance");
    }

    public bl(Resources resources, Context context) {
        super(resources, t.a("hsl"), context);
        Map<String, Float> map = this.u;
        Float valueOf = Float.valueOf(0.0f);
        map.put("hue_red", valueOf);
        this.u.put("hue_orange", valueOf);
        this.u.put("hue_yellow", valueOf);
        this.u.put("hue_green", valueOf);
        this.u.put("hue_aqua", valueOf);
        this.u.put("hue_blue", valueOf);
        this.u.put("hue_purple", valueOf);
        this.u.put("hue_magenta", valueOf);
        this.u.put("saturation_red", valueOf);
        this.u.put("saturation_orange", valueOf);
        this.u.put("saturation_yellow", valueOf);
        this.u.put("saturation_green", valueOf);
        this.u.put("saturation_aqua", valueOf);
        this.u.put("saturation_blue", valueOf);
        this.u.put("saturation_purple", valueOf);
        this.u.put("saturation_magenta", valueOf);
        this.u.put("luminance_red", valueOf);
        this.u.put("luminance_orange", valueOf);
        this.u.put("luminance_yellow", valueOf);
        this.u.put("luminance_green", valueOf);
        this.u.put("luminance_aqua", valueOf);
        this.u.put("luminance_blue", valueOf);
        this.u.put("luminance_purple", valueOf);
        this.u.put("luminance_magenta", valueOf);
    }

    public static float[][] a(String str, Map<String, Float> map) {
        return new float[][]{new float[]{0.0f, 30.0f, 60.0f, 90.0f, 180.0f, 240.0f, 270.0f, 300.0f, 360.0f}, new float[]{((map.get(str + "_red").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_orange").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_yellow").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_green").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_aqua").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_blue").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_purple").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_magenta").floatValue() / 2.0f) + 0.5f) * 255.0f, ((map.get(str + "_red").floatValue() / 2.0f) + 0.5f) * 255.0f}};
    }

    public final void a(String str, float f, boolean z) {
        if (z || this.u.get(str).floatValue() != f) {
            this.u.put(str, Float.valueOf(f));
            String str2 = r.get(str);
            char c = 65535;
            int hashCode = str2.hashCode();
            int i = 2;
            if (hashCode != -230491182) {
                if (hashCode != 103672) {
                    if (hashCode == 1178092792 && str2.equals("luminance")) {
                        c = 2;
                    }
                } else if (str2.equals("hue")) {
                    c = 0;
                }
            } else if (str2.equals("saturation")) {
                c = 1;
            }
            if (c == 0) {
                i = 0;
            } else if (c == 1) {
                i = 1;
            } else if (c != 2) {
                return;
            }
            float[][] a2 = a(str2, this.u);
            a.a.b.c.b bVar = new a.a.b.c.b(a2[0], a2[1]);
            for (int i2 = 0; i2 <= 359; i2++) {
                this.t[(i2 * 3) + i] = (byte) ((byte) ((int) a.a((double) bVar.a(i2), 0.0d, 255.0d)));
            }
        }
    }

    public void a(String str, Object obj) {
        this.v = true;
        synchronized (this.t) {
            if (obj instanceof Integer) {
                a(str, (float) ((Integer) obj).intValue(), false);
            } else {
                a(str, ((Float) obj).floatValue(), false);
            }
        }
    }

    public boolean a(Map<String, Object> map) {
        byte[] bArr = q.get(map);
        if (bArr == null || bArr.length != this.t.length) {
            return false;
        }
        this.v = true;
        this.t = bArr;
        return true;
    }

    public void b(Map<String, Object> map) {
        LruCache<Map<String, Object>, byte[]> lruCache = q;
        byte[] bArr = this.t;
        lruCache.put(map, Arrays.copyOf(bArr, bArr.length));
    }

    public void f() {
        super.f();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        g.c(iArr[0]);
        this.t = new byte[1080];
        this.s = s.b(iArr[0], 6407, 360, 1);
        GLES20.glBindTexture(3553, this.s.f11a);
        s.b();
        GLES20.glBindTexture(3553, 0);
        this.v = true;
        for (String next : this.u.keySet()) {
            a(next, ((Float) f.a(next, this.f2a.renderStates)).floatValue(), true);
        }
    }

    public void i() {
        super.i();
        if (this.v) {
            synchronized (this.t) {
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.t.length);
                allocateDirect.order(ByteOrder.nativeOrder());
                allocateDirect.put(this.t);
                allocateDirect.position(0);
                GLES20.glBindTexture(3553, this.s.f11a);
                GLES20.glPixelStorei(3317, 4);
                GLES20.glTexImage2D(3553, 0, this.s.d, this.s.f12b, this.s.c, 0, this.s.d, 5121, allocateDirect);
                GLES20.glBindTexture(3553, 0);
            }
            this.v = false;
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "map");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.s.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
    }

    public boolean k() {
        Map<String, Float> map = this.u;
        if (map == null) {
            return true;
        }
        for (Float floatValue : map.values()) {
            if (floatValue.floatValue() != 0.0f) {
                return false;
            }
        }
        return true;
    }

    public void l() {
        m();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        g.c(iArr[0]);
        this.t = new byte[1080];
        this.s = s.b(iArr[0], 6407, 360, 1);
        GLES20.glBindTexture(3553, this.s.f11a);
        s.b();
        GLES20.glBindTexture(3553, 0);
        this.v = true;
        for (String next : this.u.keySet()) {
            Object a2 = f.a(next, this.f2a.renderStates);
            if (a2 != null && (a2 instanceof Float)) {
                a(next, ((Float) a2).floatValue(), true);
            }
        }
    }

    public void m() {
        d dVar = this.s;
        if (dVar != null) {
            g.a(dVar);
            g.e(this.s.f11a);
        }
    }
}
