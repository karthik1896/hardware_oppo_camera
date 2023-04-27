package a.a.b.e;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public int f72a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f73b;
    public int[] c;
    public int d = 0;
    public boolean e = true;

    public n(int i) {
        this.f72a = i;
        int i2 = this.f72a;
        this.f73b = new int[i2];
        this.c = new int[i2];
    }

    public int a(Bitmap bitmap) {
        int i;
        int hashCode = bitmap.hashCode();
        int i2 = 0;
        while (true) {
            if (i2 >= this.f72a) {
                i2 = -1;
                break;
            } else if (hashCode == this.f73b[i2]) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            return this.c[i2];
        }
        this.d %= this.f72a;
        int[] iArr = this.c;
        int i3 = this.d;
        if (iArr[i3] == 0) {
            int[] iArr2 = new int[1];
            s.a(iArr2.length, iArr2, 0, 6408, bitmap.getWidth(), bitmap.getHeight());
            i = iArr2[0];
            this.c[this.d] = i;
        } else {
            i = iArr[i3];
        }
        int[] iArr3 = this.f73b;
        int i4 = this.d;
        iArr3[i4] = hashCode;
        this.d = i4 + 1;
        s.b(i, bitmap.getWidth(), bitmap.getHeight());
        GLES20.glBindTexture(3553, i);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        if (this.e) {
            GLES20.glGenerateMipmap(3553);
        }
        GLES20.glBindTexture(3553, 0);
        return i;
    }

    public void a() {
        for (int i : this.c) {
            if (i != 0) {
                s.a(i);
            }
        }
        int i2 = this.f72a;
        this.c = new int[i2];
        this.f73b = new int[i2];
        this.d = 0;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
