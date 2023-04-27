package a.a.b.a;

import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.b.g;
import a.a.b.c.a;
import a.a.b.e.s;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.LruCache;
import co.polarr.renderer.entities.Context;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bm extends b {
    public static LruCache<Map<String, Object>, int[]> q = new LruCache<>(10);
    public static List<String> r = new ArrayList();
    public d s;
    public int[] t;
    public Map<String, float[][]> u = new HashMap();
    public boolean v;

    static {
        r.add("curves_red");
        r.add("curves_green");
        r.add("curves_blue");
        r.add("curves_all");
    }

    public bm(Resources resources, Context context) {
        super(resources, t.a("curves"), context);
        this.u.put("curves_red", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.u.put("curves_green", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.u.put("curves_blue", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        this.u.put("curves_all", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
    }

    public static int a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 3;
        while (i5 >= 0) {
            i4 += (i5 == i2 ? i3 & 255 : (i >> (i5 * 8)) & 255) << (i5 * 8);
            i5--;
        }
        return i4;
    }

    public static int a(a aVar, int i, float f) {
        float a2 = aVar.a(i);
        return a2 == -1.0f ? (int) f : (int) Math.round(a.a.b.e.a.a((double) a2, 0.0d, 255.0d));
    }

    public static float[][] a(float[][] fArr) {
        float[][] fArr2 = {new float[fArr.length], new float[fArr.length]};
        int i = 0;
        for (float[] fArr3 : fArr) {
            fArr2[0][i] = fArr3[0];
            fArr2[1][i] = fArr3[1];
            i++;
        }
        return fArr2;
    }

    public void a(String str, Object obj) {
        this.v = true;
        synchronized (this.t) {
            a(str, (float[][]) obj, false);
        }
    }

    public final void a(String str, float[][] fArr, boolean z) {
        if (z || (this.u.get(str) != fArr && !Arrays.deepEquals((Object[]) this.u.get(str), fArr))) {
            this.u.put(str, fArr);
            char c = 65535;
            int i = 2;
            switch (str.hashCode()) {
                case -1917275032:
                    if (str.equals("curves_green")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1829931962:
                    if (str.equals("curves_all")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1829915850:
                    if (str.equals("curves_red")) {
                        c = 0;
                        break;
                    }
                    break;
                case -893285803:
                    if (str.equals("curves_blue")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                i = 0;
            } else if (c == 1) {
                i = 1;
            } else if (c != 2) {
                if (c == 3) {
                    i = 3;
                } else {
                    return;
                }
            }
            try {
                float[][] a2 = a(fArr);
                a aVar = new a(a2[0], a2[1], (Float) null, (Float) null);
                int i2 = (int) a2[1][0];
                for (int i3 = 0; i3 <= 255; i3++) {
                    i2 = a(aVar, i3, (float) i2);
                    this.t[i3] = a(this.t[i3], i, i2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean a(Map<String, Object> map) {
        int[] iArr = q.get(map);
        if (iArr == null || iArr.length != this.t.length) {
            return false;
        }
        this.v = true;
        this.t = iArr;
        return true;
    }

    public void b(Map<String, Object> map) {
        LruCache<Map<String, Object>, int[]> lruCache = q;
        int[] iArr = this.t;
        lruCache.put(map, Arrays.copyOf(iArr, iArr.length));
    }

    public void f() {
        super.f();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        g.c(iArr[0]);
        this.t = new int[256];
        this.s = s.b(iArr[0], 6408, 256, 1);
        GLES20.glBindTexture(3553, this.s.f11a);
        s.b();
        GLES20.glBindTexture(3553, 0);
        this.v = true;
        for (String next : this.u.keySet()) {
            a(next, (float[][]) f.a(next, this.f2a.renderStates), true);
        }
    }

    public void i() {
        super.i();
        if (this.v) {
            synchronized (this.t) {
                IntBuffer asIntBuffer = ByteBuffer.allocateDirect(this.t.length * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
                asIntBuffer.put(this.t);
                asIntBuffer.position(0);
                GLES20.glBindTexture(3553, this.s.f11a);
                GLES20.glPixelStorei(3317, 8);
                GLES20.glTexImage2D(3553, 0, this.s.d, this.s.f12b, this.s.c, 0, this.s.d, 5121, asIntBuffer);
                GLES20.glBindTexture(3553, 0);
                GLES20.glPixelStorei(3317, 4);
                this.v = false;
            }
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "map");
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.s.f11a);
        GLES20.glUniform1i(glGetUniformLocation, 1);
    }

    public boolean k() {
        Map<String, float[][]> map = this.u;
        if (map != null) {
            for (float[][] next : map.values()) {
                if (next.length != 2) {
                    return false;
                }
                float[] fArr = next[0];
                if (fArr[0] == 0.0f && fArr[1] == 0.0f) {
                    float[] fArr2 = next[1];
                    if (fArr2[0] == 255.0f) {
                        if (fArr2[1] != 255.0f) {
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public void l() {
        m();
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.t = new int[256];
        this.s = s.b(iArr[0], 6408, 256, 1);
        g.c(iArr[0]);
        this.v = true;
        GLES20.glBindTexture(3553, this.s.f11a);
        s.b();
        GLES20.glBindTexture(3553, 0);
        for (String next : this.u.keySet()) {
            a(next, (float[][]) f.a(next, this.f2a.renderStates), true);
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
