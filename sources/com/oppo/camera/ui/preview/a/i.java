package com.oppo.camera.ui.preview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.entities.DrawingItem;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.menu.levelcontrol.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

/* compiled from: FilterThumbDrawer */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f4392a = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f4393b = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static final float[] c = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private int A;
    private int B;
    private int C;
    private int D;
    private FloatBuffer E;
    private FloatBuffer F;
    private FloatBuffer G;
    private FloatBuffer H;
    private Bitmap I;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private float[] j;
    private int[] k;
    private int l;
    private int m;
    private int[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public i(Context context) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = new float[8];
        this.k = null;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.G = a(f4392a);
        this.E = a(f4393b);
        this.F = a(c);
        this.H = a(f4393b);
        this.d = a(context.getResources().openRawResource(R.raw.fragment_shader));
        this.e = a(context.getResources().openRawResource(R.raw.fragment_shader_oes));
        this.f = a(context.getResources().openRawResource(R.raw.fragment_shader_common));
        this.g = a(context.getResources().openRawResource(R.raw.vertex_shader));
        this.h = a(context.getResources().openRawResource(R.raw.vertex_shader_oes));
        this.i = a(context.getResources().openRawResource(R.raw.vertex_shader_common));
    }

    public void a() {
        int[] iArr = this.k;
        if (iArr != null) {
            GLES20.glDeleteFramebuffers(iArr.length, iArr, 0);
        }
        int[] iArr2 = this.n;
        if (iArr2 != null) {
            GLES20.glDeleteTextures(iArr2.length, iArr2, 0);
        }
    }

    private FloatBuffer a(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }

    private boolean a(int i2, float f2) {
        float a2 = (((float) h.a()) / 2.0f) + h.g();
        float f3 = f2 + a2;
        float f4 = f2 - a2;
        float g2 = ((float) (-i2)) * h.g();
        return g2 >= f4 && g2 <= f3;
    }

    public void a(b bVar, List<DrawingItem> list, int i2, int i3, float f2) {
        int i4;
        b bVar2 = bVar;
        List<DrawingItem> list2 = list;
        b();
        Rect rect = list2.get(0).rect;
        if (this.k == null) {
            this.k = new int[2];
            int[] iArr = this.k;
            GLES20.glGenFramebuffers(iArr.length, iArr, 0);
            int[] iArr2 = this.k;
            this.l = iArr2[0];
            this.m = iArr2[1];
        }
        if (!(this.n != null && this.q == rect.width() && this.r == rect.height())) {
            int[] iArr3 = this.n;
            if (iArr3 != null) {
                GLES20.glDeleteTextures(iArr3.length, iArr3, 0);
            }
            this.n = new int[3];
            int[] iArr4 = this.n;
            GLES20.glGenTextures(iArr4.length, iArr4, 0);
            this.o = this.n[0];
            a(this.o, rect);
            this.p = this.n[1];
            a(this.p, rect);
            this.s = this.n[2];
            this.q = rect.width();
            this.r = rect.height();
            float[] fArr = c;
            float[] fArr2 = this.j;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            float width = (((float) (rect.width() - rect.height())) / 2.0f) / ((float) rect.width());
            int i5 = 0;
            while (true) {
                float[] fArr3 = this.j;
                if (i5 >= fArr3.length) {
                    break;
                }
                fArr3[i5] = fArr3[i5] + (fArr3[i5] == 0.0f ? width : -width);
                i5 += 2;
            }
            DrawingItem drawingItem = list2.get(list.size() - 1);
            this.I = Bitmap.createBitmap(drawingItem.rect.right, drawingItem.rect.bottom, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            Canvas canvas = new Canvas(this.I);
            for (DrawingItem next : list) {
                int i6 = next.overlayLeft + next.rect.left;
                int i7 = next.overlayTop + next.rect.top;
                int i8 = next.rect.bottom - (i7 - next.rect.top);
                canvas.drawBitmap(next.overlayBitmap, new Rect(0, 0, next.overlayBitmap.getWidth(), next.overlayBitmap.getHeight()), new Rect(i6, i7, (((i8 - i7) * next.overlayBitmap.getWidth()) / next.overlayBitmap.getHeight()) + i6, i8), paint);
            }
            a(this.s, this.I);
        }
        int i9 = 36160;
        GLES20.glBindFramebuffer(36160, this.l);
        int i10 = 36064;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.o, 0);
        GLES20.glViewport(0, 0, rect.width(), rect.height());
        GLES20.glUseProgram(this.y);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i2);
        GLES20.glVertexAttribPointer(this.z, 2, 5126, false, 8, this.G);
        GLES20.glEnableVertexAttribArray(this.z);
        GLES20.glVertexAttribPointer(this.A, 2, 5126, false, 8, this.F);
        GLES20.glEnableVertexAttribArray(this.A);
        GLES20.glDrawArrays(5, 0, 4);
        int i11 = 0;
        while (i11 < list.size()) {
            if (!a(i11, f2)) {
                int i12 = i3;
            } else {
                DrawingItem drawingItem2 = list2.get(i11);
                Rect rect2 = drawingItem2.rect;
                if (FilterPackageUtil.F_DEFAULT.equals(drawingItem2.filterId)) {
                    i4 = this.o;
                } else {
                    GLES20.glViewport(0, 0, rect2.width(), rect2.height());
                    bVar2.a(drawingItem2.filterId);
                    bVar2.b(this.o);
                    bVar2.a(this.p);
                    bVar2.a(rect2.width(), rect2.height());
                    bVar.d();
                    i4 = this.p;
                }
                GLES20.glBindFramebuffer(i9, this.m);
                GLES20.glFramebufferTexture2D(i9, i10, 3553, i3, 0);
                GLES20.glViewport(rect2.left + ((rect2.width() - rect2.height()) / 2), rect2.top, rect2.height(), rect2.height());
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 0);
                GLES20.glUseProgram(this.t);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i4);
                GLES20.glUniform1i(this.x, 0);
                GLES20.glVertexAttribPointer(this.u, 2, 5126, false, 8, this.G);
                GLES20.glEnableVertexAttribArray(this.u);
                this.H.position(0);
                this.H.put(this.j);
                this.H.position(0);
                GLES20.glVertexAttribPointer(this.v, 2, 5126, false, 8, this.H);
                GLES20.glEnableVertexAttribArray(this.v);
                GLES20.glVertexAttribPointer(this.w, 2, 5126, false, 8, this.E);
                GLES20.glEnableVertexAttribArray(this.w);
                GLES20.glDrawArrays(5, 0, 4);
                GLES20.glDisable(3042);
            }
            i11++;
            i9 = 36160;
            i10 = 36064;
        }
        GLES20.glViewport(0, 0, this.I.getWidth(), this.I.getHeight());
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771);
        GLES20.glUseProgram(this.B);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.s);
        GLES20.glVertexAttribPointer(this.C, 2, 5126, false, 8, this.G);
        GLES20.glEnableVertexAttribArray(this.C);
        GLES20.glVertexAttribPointer(this.D, 2, 5126, false, 8, this.F);
        GLES20.glEnableVertexAttribArray(this.D);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisable(3042);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private void a(int i2, Rect rect) {
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, rect.width(), rect.height(), 0, 6408, 5121, (Buffer) null);
    }

    private void a(int i2, Bitmap bitmap) {
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
    }

    private void b() {
        c();
        d();
        e();
    }

    private void c() {
        if (this.B == 0) {
            this.B = a(this.i, this.f);
            this.C = GLES20.glGetAttribLocation(this.B, "aPosition");
            this.D = GLES20.glGetAttribLocation(this.B, "aTextureCoord");
        }
    }

    private void d() {
        if (this.t == 0) {
            this.t = a(this.g, this.d);
            this.u = GLES20.glGetAttribLocation(this.t, "aPosition");
            this.v = GLES20.glGetAttribLocation(this.t, "aTextureCoord");
            this.x = GLES20.glGetUniformLocation(this.t, "aTexture");
            this.w = GLES20.glGetAttribLocation(this.t, "aTextureCoordMask");
        }
    }

    private void e() {
        if (this.y == 0) {
            this.y = a(this.h, this.e);
            this.z = GLES20.glGetAttribLocation(this.y, "aPosition");
            this.A = GLES20.glGetAttribLocation(this.y, "aTextureCoord");
        }
    }

    private String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                inputStream.close();
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        inputStream.close();
        return byteArrayOutputStream.toString();
    }

    public static int a(String str, String str2) {
        int a2 = a(35633, str);
        if (a2 == 0) {
            e.e("FilterThumbDrawer", "load vertex shader error");
        }
        int a3 = a(35632, str2);
        if (a3 == 0) {
            e.e("FilterThumbDrawer", "load fragment shader error");
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    private static int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        a("glCreateShader type = " + i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static void a(String str) {
        for (int glGetError = GLES20.glGetError(); glGetError != 0; glGetError = GLES20.glGetError()) {
            e.e("FilterThumbDrawer", str + ": glError " + glGetError);
        }
    }
}
