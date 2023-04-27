package a.a.b.a.a;

import a.a.b.f;
import android.content.res.Resources;
import android.opengl.GLES20;
import co.polarr.renderer.entities.Context;
import java.util.LinkedHashMap;

public class b extends a {
    public static final String defaultVertexShader = "vertex.glsl";
    public String n;
    public String o;
    public LinkedHashMap<String, Float> p = new LinkedHashMap<>();

    public b(Resources resources, String str, Context context) {
        super(context, resources);
        this.n = str;
        this.o = defaultVertexShader;
    }

    public void a(int i, int i2) {
    }

    public void a(Context context) {
        this.f2a = context;
    }

    public void a(String str, Object obj) {
        this.p.put(str, (Float) obj);
    }

    public void a(String[] strArr) {
        float f;
        LinkedHashMap<String, Float> linkedHashMap;
        if (strArr != null) {
            for (String str : strArr) {
                if (f.f83a.containsKey(str)) {
                    linkedHashMap = this.p;
                    f = ((Float) f.f83a.get(str)).floatValue();
                } else {
                    linkedHashMap = this.p;
                    f = 0.0f;
                }
                linkedHashMap.put(str, Float.valueOf(f));
            }
        }
    }

    public void e() {
        float[] fArr = Context.backgroundColor;
        GLES20.glClearColor(fArr[0], fArr[1], fArr[2], 1.0f);
        GLES20.glClear(16384);
    }

    public void f() {
        b(this.o, this.n);
    }

    public void i() {
        super.i();
        if (!this.p.isEmpty()) {
            for (String next : this.p.keySet()) {
                int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, next);
                Object a2 = f.a(next, this.f2a.renderStates);
                GLES20.glUniform1f(glGetUniformLocation, a2 != null ? Float.parseFloat(a2.toString()) : this.p.get(next).floatValue());
            }
        }
    }

    public boolean k() {
        if (this.p.isEmpty()) {
            return false;
        }
        for (String next : this.p.keySet()) {
            Object a2 = f.a(next, this.f2a.renderStates);
            if (a2 == null) {
                a2 = this.p.get(next);
            }
            if (((Float) f.f83a.get(next)).floatValue() != Float.parseFloat(a2.toString())) {
                return false;
            }
        }
        return true;
    }
}
