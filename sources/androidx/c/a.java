package androidx.c;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: EglRectBlt */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f480a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    private static final FloatBuffer f481b = a(f480a);
    private final float[] c = new float[8];
    private final FloatBuffer d = a(this.c);
    private final int e;
    private final int f;
    private e g;

    public static FloatBuffer a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public a(e eVar, int i, int i2) {
        this.g = eVar;
        this.e = i;
        this.f = i2;
    }

    public void a(boolean z) {
        e eVar = this.g;
        if (eVar != null) {
            if (z) {
                eVar.a();
            }
            this.g = null;
        }
    }

    public int a() {
        return this.g.b();
    }

    public void a(int i, Bitmap bitmap) {
        this.g.a(i, bitmap);
    }

    public void a(int i, float[] fArr, Rect rect) {
        a(rect);
        this.g.a(e.f502a, f481b, 0, 4, 2, 8, fArr, this.d, i, 8);
    }

    /* access modifiers changed from: package-private */
    public void a(Rect rect) {
        this.c[0] = ((float) rect.left) / ((float) this.e);
        this.c[1] = 1.0f - (((float) rect.bottom) / ((float) this.f));
        this.c[2] = ((float) rect.right) / ((float) this.e);
        this.c[3] = 1.0f - (((float) rect.bottom) / ((float) this.f));
        this.c[4] = ((float) rect.left) / ((float) this.e);
        this.c[5] = 1.0f - (((float) rect.top) / ((float) this.f));
        this.c[6] = ((float) rect.right) / ((float) this.e);
        this.c[7] = 1.0f - (((float) rect.top) / ((float) this.f));
        this.d.put(this.c);
        this.d.position(0);
    }
}
