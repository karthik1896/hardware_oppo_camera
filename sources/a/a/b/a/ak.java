package a.a.b.a;

import a.a.b.a;
import a.a.b.a.a.b;
import a.a.b.b.d;
import a.a.b.e;
import a.a.b.e.q;
import a.a.b.e.s;
import a.a.b.e.t;
import a.a.b.f;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Cube;
import co.polarr.renderer.entities.FilterItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ak extends b {
    public static String q;
    public static float r;
    public static float s;
    public static float t;
    public static float u;
    public static float v;
    public static float w;
    public static byte[] x;
    public static byte[] y;
    public float A = 0.0f;
    public boolean B;
    public Bitmap C;
    public Map<String, d> D = new HashMap();
    public String E = null;
    public Map<String, Float> F = new HashMap();
    public float G = 1.0f;
    public float[] H = {0.0f, 0.0f, 0.0f};
    public float[] I = {1.0f, 1.0f, 1.0f};
    public Random J = new Random();
    public boolean K = true;
    public boolean L = false;
    public float M = 0.08f;
    public float N = 0.6f;
    public float O = 0.88f;
    public float P = 0.2f;
    public boolean Q = false;
    public float R = 0.0f;
    public float S = 0.0f;
    public float T = 0.0f;
    public float z = 0.0f;

    public ak(Resources resources, Context context) {
        super(resources, t.a("lookup_table"), context);
    }

    public static void b(String str) {
        q = str;
    }

    public final d a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9987.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 10497.0f);
        GLES20.glTexParameterf(3553, 10243, 10497.0f);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, ByteBuffer.wrap(bArr));
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        return s.b(i, 6408, i2, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b A[SYNTHETIC, Splitter:B:19:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0031 A[SYNTHETIC, Splitter:B:24:0x0031] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap a(android.content.res.Resources r3, java.lang.String r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x001f }
            r4.<init>()     // Catch:{ IOException -> 0x001f }
            r1 = 0
            r4.inPremultiplied = r1     // Catch:{ IOException -> 0x001f }
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r3, r0, r4)     // Catch:{ IOException -> 0x001f }
            if (r3 == 0) goto L_0x001a
            r3.close()     // Catch:{ IOException -> 0x001a }
        L_0x001a:
            return r4
        L_0x001b:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L_0x002f
        L_0x001f:
            r4 = move-exception
            goto L_0x0026
        L_0x0021:
            r3 = move-exception
            goto L_0x002f
        L_0x0023:
            r3 = move-exception
            r4 = r3
            r3 = r0
        L_0x0026:
            r4.printStackTrace()     // Catch:{ all -> 0x001b }
            if (r3 == 0) goto L_0x002e
            r3.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            return r0
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.a.ak.a(android.content.res.Resources, java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0024 A[SYNTHETIC, Splitter:B:18:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002a A[SYNTHETIC, Splitter:B:23:0x002a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap a(java.io.File r4) {
        /*
            r3 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x001d, all -> 0x001b }
            r1.<init>(r4)     // Catch:{ IOException -> 0x001d, all -> 0x001b }
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x0019 }
            r4.<init>()     // Catch:{ IOException -> 0x0019 }
            r2 = 0
            r4.inPremultiplied = r2     // Catch:{ IOException -> 0x0019 }
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r1, r0, r4)     // Catch:{ IOException -> 0x0019 }
            r1.close()     // Catch:{ IOException -> 0x0015 }
        L_0x0015:
            return r4
        L_0x0016:
            r4 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0019:
            r4 = move-exception
            goto L_0x001f
        L_0x001b:
            r4 = move-exception
            goto L_0x0028
        L_0x001d:
            r4 = move-exception
            r1 = r0
        L_0x001f:
            r4.printStackTrace()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0027
            r1.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            return r0
        L_0x0028:
            if (r0 == 0) goto L_0x002d
            r0.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b.a.ak.a(java.io.File):android.graphics.Bitmap");
    }

    public void a(float f) {
        this.G = f;
    }

    public void a(Cube cube) {
        d dVar;
        Cube cube2 = cube;
        if (cube2 != null) {
            String str = cube2.filterID;
            this.E = str;
            this.F.put(str, Float.valueOf((float) cube2.size));
            int i = cube2.size;
            int i2 = i * i;
            if (this.D.containsKey(cube2.filterID)) {
                dVar = this.D.get(cube2.filterID);
                s.b(dVar, i2, i);
            } else {
                int[] iArr = new int[1];
                s.a(iArr.length, iArr, 0, 6408, i2, i);
                dVar = s.b(iArr[0], 6408, i2, i);
                s.c(33071, 33071, 9728, 9728);
                this.D.put(cube2.filterID, dVar);
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(cube2.data.length);
            allocateDirect.order(ByteOrder.nativeOrder());
            allocateDirect.put(cube2.data);
            allocateDirect.position(0);
            GLES20.glBindTexture(3553, dVar.f11a);
            int i3 = dVar.d;
            GLES20.glTexImage2D(3553, 0, i3, dVar.f12b, dVar.c, 0, i3, 5121, allocateDirect);
            GLES20.glBindTexture(3553, 0);
        }
    }

    public void a(boolean z2, float f, float f2, float f3, float f4, float f5) {
        this.Q = z2;
        this.R = f;
        this.S = f2;
        this.T = f3;
        this.z = f4;
        this.A = f5;
        super.draw();
        this.Q = false;
    }

    public boolean c(String str) {
        if (str == null || !this.D.containsKey(str)) {
            return false;
        }
        this.E = str;
        return true;
    }

    public void d() {
        super.d();
        if (FilterPackageUtil.PORTRAIT4_1.equals(this.E) || FilterPackageUtil.PORTRAIT4_1B.equals(this.E) || this.B) {
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "grainTexture");
            GLES20.glActiveTexture(33986);
            r();
            GLES20.glBindTexture(3553, this.f2a.grainTexture.f11a);
            GLES20.glUniform1i(glGetUniformLocation, 2);
        }
        if (FilterPackageUtil.PORTRAIT4_3.equals(this.E)) {
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "overlayTexture");
            GLES20.glActiveTexture(33987);
            s();
            GLES20.glBindTexture(3553, this.f2a.overlayTexture.f11a);
            GLES20.glUniform1i(glGetUniformLocation2, 3);
        }
    }

    public void e() {
        if (this.K) {
            super.e();
        }
    }

    public void f() {
        super.f();
        m();
    }

    public void h() {
    }

    public void i() {
        int glGetUniformLocation;
        float f;
        super.i();
        if (!this.D.isEmpty() && this.E != null) {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "lut_size"), this.F.get(this.E).floatValue());
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f3b, "lookup_texture");
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.D.get(this.E).f11a);
            GLES20.glUniform1i(glGetUniformLocation2, 1);
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f3b, "grainTextureSize");
            d dVar = this.f2a.grainTexture;
            GLES20.glUniform2f(glGetUniformLocation3, (float) dVar.f12b, (float) dVar.c);
            float[] b2 = q.b(this.f2a);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "textureSize"), b2[0], b2[1]);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f3b, "globalScreenRotation"), a.a());
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "grainRandomOffset"), this.J.nextFloat(), this.J.nextFloat());
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f3b, "is_apply_roundcorner"), this.Q ? 1 : 0);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "roundcorner_radius"), this.R);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "roundcorner_offset"), this.S, this.T);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "roundcorner_size"), this.z, this.A);
        }
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f3b, "is_apply_vignette"), this.L ? 1 : 0);
        int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.f3b, "crop");
        float[] fArr = (float[]) f.a("crop", this.f2a.renderStates);
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        copyOf[1] = (1.0f - copyOf[3]) - copyOf[1];
        GLES20.glUniform4fv(glGetUniformLocation4, 1, copyOf, 0);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.f3b, "rotationMatrix"), 1, false, this.f2a.rotation90MatrixInv, 0);
        float[] b3 = q.b(this.f2a);
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.f3b, "imgSize"), b3[0], b3[1]);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "lookup_intensity"), this.G);
        GLES20.glUniform3fv(GLES20.glGetUniformLocation(this.f3b, "domain_min"), 1, this.H, 0);
        GLES20.glUniform3fv(GLES20.glGetUniformLocation(this.f3b, "domain_max"), 1, this.I, 0);
        if (FilterPackageUtil.a(this.E, "vignette_amount")) {
            FilterItem a2 = e.a().a(this.E);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f3b, "is_apply_vignette"), 1);
            if (a2.state.containsKey("vignette_amount")) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_amount"), ((Float) a2.state.get("vignette_amount")).floatValue());
            }
            if (a2.state.containsKey("vignette_feather")) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_feather"), ((Float) a2.state.get("vignette_feather")).floatValue());
            }
            if (a2.state.containsKey("vignette_highlights")) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_highlights"), ((Float) a2.state.get("vignette_highlights")).floatValue());
            }
            if (a2.state.containsKey("vignette_roundness")) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_roundness"), ((Float) a2.state.get("vignette_roundness")).floatValue());
            }
            if (a2.state.containsKey("vignette_size")) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_size"), ((Float) a2.state.get("vignette_size")).floatValue());
            }
            if (a2.state.containsKey("vignette_exposure")) {
                GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_exposure"), ((Float) a2.state.get("vignette_exposure")).floatValue());
            }
        } else if (FilterPackageUtil.b(this.E)) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f3b, "is_apply_vignette"), 0);
        } else {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_amount"), r);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_feather"), s);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_highlights"), t);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_roundness"), v);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_size"), w);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "vignette_exposure"), u);
        }
        if (FilterPackageUtil.a(this.E, "grain_amount")) {
            e.a().a(this.E);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "grain_amount"), 0.08f);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "grain_size"), 0.6f);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "grain_highlights"), 0.88f);
            glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "grain_roughness");
            f = 0.2f;
        } else if (this.B) {
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "grain_amount"), this.M);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "grain_size"), this.N);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.f3b, "grain_highlights"), this.O);
            glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "grain_roughness");
            f = this.P;
        } else {
            glGetUniformLocation = GLES20.glGetUniformLocation(this.f3b, "grain_amount");
            f = 0.0f;
        }
        GLES20.glUniform1f(glGetUniformLocation, f);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f3b, "is_apply_overlay"), FilterPackageUtil.a(this.E, "overlay_amount") ? 1 : 0);
    }

    public boolean k() {
        if (this.E == null) {
            return true;
        }
        return super.k();
    }

    public void l() {
        this.E = "AUTO_ENHANCE_FILTER";
        this.F.put("AUTO_ENHANCE_FILTER", Float.valueOf(32.0f));
        if (this.D.containsKey("AUTO_ENHANCE_FILTER")) {
            s.b(this.D.get("AUTO_ENHANCE_FILTER"), 1024, 32);
            return;
        }
        int[] iArr = new int[1];
        s.a(iArr.length, iArr, 0, 6408, 1024, 32);
        d b2 = s.b(iArr[0], 6408, 1024, 32);
        s.c(33071, 33071, 9728, 9728);
        this.D.put("AUTO_ENHANCE_FILTER", b2);
    }

    public void m() {
        d dVar;
        this.E = "COMBAIN_FILTER";
        if (this.C == null) {
            InputStream inputStream = null;
            try {
                if (q != null) {
                    File file = new File(q, "lut_all_points.png");
                    if (file.exists()) {
                        inputStream = new FileInputStream(file);
                    }
                }
                if (inputStream == null) {
                    inputStream = this.i.getAssets().open("textures/lut_all_points.png");
                }
                this.C = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int width = this.C.getWidth();
        int height = this.C.getHeight();
        this.F.put("COMBAIN_FILTER", Float.valueOf((float) height));
        if (this.D.containsKey("COMBAIN_FILTER")) {
            dVar = this.D.get("COMBAIN_FILTER");
            s.b(dVar, width, height);
        } else {
            int[] iArr = new int[2];
            s.a(iArr.length, iArr, 0, 6408, width, height);
            d b2 = s.b(iArr[0], 6408, width, height);
            d b3 = s.b(iArr[1], 6408, width, height);
            s.c(33071, 33071, 9728, 9728);
            this.D.put("COMBAIN_FILTER", b2);
            this.D.put("COMBAIN_FILTER_SWAP", b3);
            dVar = b2;
        }
        GLES20.glBindTexture(3553, dVar.f11a);
        GLUtils.texImage2D(3553, 0, 6408, this.C, 0);
        GLES20.glBindTexture(3553, 0);
    }

    public d n() {
        if (!this.D.containsKey("AUTO_ENHANCE_FILTER")) {
            l();
        }
        return this.D.get("AUTO_ENHANCE_FILTER");
    }

    public d o() {
        return this.D.get("COMBAIN_FILTER");
    }

    public d p() {
        return this.D.get("COMBAIN_FILTER_SWAP");
    }

    public boolean q() {
        return "COMBAIN_FILTER".equals(this.E);
    }

    public final void r() {
        if (!this.f2a.grainTextureBinded) {
            try {
                if (x == null || x.length != 4194304) {
                    InputStream inputStream = null;
                    if (q != null) {
                        File file = new File(q, "film_grain_small.bin");
                        if (file.exists()) {
                            inputStream = new FileInputStream(file);
                        }
                    }
                    if (inputStream == null) {
                        inputStream = this.i.getAssets().open("textures/film_grain_small.bin");
                    }
                    byte[] a2 = a.a.b.e.a.a(inputStream);
                    inputStream.close();
                    x = a2;
                }
                this.f2a.grainTexture = a(this.f2a.grainTexture.f11a, x, 1024, 1024);
                this.f2a.grainTextureBinded = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final void s() {
        if (!this.f2a.overlayTextureBinded) {
            byte[] bArr = y;
            if (bArr == null || bArr.length != 4000000) {
                Bitmap bitmap = null;
                String str = q;
                if (str != null) {
                    File file = new File(str, "overlay_p4_3_weak.png");
                    if (file.exists()) {
                        bitmap = a(file);
                    }
                }
                if (bitmap == null) {
                    bitmap = a(this.i, "textures/overlay_p4_3_weak.png");
                }
                y = a.a.b.e.a.b(bitmap);
                bitmap.recycle();
            }
            Context context = this.f2a;
            context.overlayTexture = a(context.overlayTexture.f11a, y, 1000, 1000);
            this.f2a.overlayTextureBinded = true;
        }
    }

    public void t() {
        this.E = null;
    }
}
