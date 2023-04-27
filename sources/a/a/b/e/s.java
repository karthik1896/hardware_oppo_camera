package a.a.b.e;

import a.a.b.a;
import a.a.b.b.d;
import a.a.b.b.g;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class s {
    public static ByteBuffer a(int i, int i2, int i3) {
        ByteBuffer allocate = ByteBuffer.allocate(i2 * i3 * 4);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        a(iArr[0], i);
        GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, allocate);
        a();
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return allocate;
    }

    public static void a() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    public static void a(int i) {
        GLES20.glBindTexture(3553, i);
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        GLES20.glFlush();
        a.a("del tex");
    }

    public static void a(int i, int i2) {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
    }

    public static void a(int i, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        int i5 = i;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        int i6 = i2;
        GLES20.glBindTexture(3553, i2);
        GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, i3, i4);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    public static void a(int i, int i2, Rect rect) {
        ByteBuffer allocate = ByteBuffer.allocate(rect.width() * rect.height() * 4);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        a(iArr[0], i);
        GLES20.glReadPixels(rect.left, rect.top, rect.width(), rect.height(), 6408, 5121, allocate);
        a();
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexImage2D(3553, 0, 6408, rect.width(), rect.height(), 0, 6408, 5121, allocate);
        GLES20.glBindTexture(3553, 0);
    }

    public static void a(int i, int[] iArr, int i2, int i3, int i4, int i5) {
        a(i, iArr, i2, i3, 5121, i4, i5);
    }

    public static void a(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i;
        int i10 = i3;
        int i11 = i4;
        GLES20.glGenTextures(i, iArr, i2);
        for (int i12 = 0; i12 < i9; i12++) {
            g.c(iArr[i2 + i12]);
        }
        for (int i13 = 0; i13 < i9; i13++) {
            GLES20.glBindTexture(3553, iArr[i13]);
            b.a("genTexturesWithParameter::texId=%d::width=%d::height=%d", Integer.valueOf(iArr[i13]), Integer.valueOf(i5), Integer.valueOf(i6));
            if (Build.VERSION.SDK_INT < 18 || !(i11 == 5126 || i11 == 5131 || i11 == 36193)) {
                GLES20.glTexImage2D(3553, 0, i3, i5, i6, 0, i3, i4, (Buffer) null);
            } else {
                if (i10 == 6408) {
                    i8 = 34842;
                } else if (i10 == 6407) {
                    i8 = 34843;
                } else {
                    i7 = i10;
                    GLES30.glTexImage2D(3553, 0, i7, i5, i6, 0, i3, i4, (Buffer) null);
                }
                i7 = i8;
                GLES30.glTexImage2D(3553, 0, i7, i5, i6, 0, i3, i4, (Buffer) null);
            }
            b();
        }
        GLES20.glBindTexture(3553, 0);
        a.a("gen tex");
    }

    public static void a(d dVar, int i, int i2) {
        if (i <= 0) {
            i = 1;
        }
        dVar.f12b = i;
        if (i2 <= 0) {
            i2 = 1;
        }
        dVar.c = i2;
    }

    public static void a(d dVar, int i, int i2, int i3, int i4) {
        if (dVar == null) {
            return;
        }
        if (dVar.f12b != i3 || dVar.c != i4) {
            GLES30.glBindTexture(3553, dVar.f11a);
            GLES30.glTexImage2D(3553, 0, i, i3, i4, 0, dVar.d, i2, (Buffer) null);
            int i5 = 1;
            if (i3 <= 0) {
                i3 = 1;
            }
            dVar.f12b = i3;
            if (i4 > 0) {
                i5 = i4;
            }
            dVar.c = i5;
            GLES30.glBindTexture(3553, 0);
            a.a("resize tex gl3");
        }
    }

    public static void a(d dVar, d dVar2) {
        int i = dVar.f11a;
        dVar.f11a = dVar2.f11a;
        dVar2.f11a = i;
    }

    public static void a(boolean z, boolean z2) {
        if (z) {
            GLES20.glEnable(3042);
            if (z2) {
                GLES20.glBlendFunc(1, 771);
            } else {
                GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
            }
        } else {
            GLES20.glDisable(3042);
        }
    }

    public static d b(int i, int i2, int i3, int i4) {
        d dVar = new d();
        dVar.f11a = i;
        dVar.d = i2;
        dVar.f12b = i3;
        dVar.c = i4;
        return dVar;
    }

    public static void b() {
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
    }

    public static void b(int i, int i2, int i3) {
        GLES20.glBindTexture(3553, i);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, (Buffer) null);
        GLES20.glBindTexture(3553, 0);
        a.a("resize tex id");
    }

    public static void b(int i, int i2, Rect rect) {
        Rect rect2 = rect;
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        int i3 = i2;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        int i4 = i;
        GLES20.glBindTexture(3553, i);
        GLES20.glCopyTexSubImage2D(3553, 0, rect2.left, rect2.top, 0, 0, rect.width(), rect.height());
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    public static void b(d dVar, int i, int i2) {
        if (dVar == null) {
            return;
        }
        if (dVar.f12b != i || dVar.c != i2) {
            GLES20.glBindTexture(3553, dVar.f11a);
            int i3 = dVar.d;
            GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, (Buffer) null);
            if (i <= 0) {
                i = 1;
            }
            dVar.f12b = i;
            if (i2 <= 0) {
                i2 = 1;
            }
            dVar.c = i2;
            GLES20.glBindTexture(3553, 0);
            a.a("resize tex");
        }
    }

    public static void c(int i, int i2, int i3, int i4) {
        GLES20.glTexParameterf(3553, 10242, (float) i);
        GLES20.glTexParameterf(3553, 10243, (float) i2);
        GLES20.glTexParameterf(3553, 10241, (float) i3);
        GLES20.glTexParameterf(3553, 10240, (float) i4);
    }
}
