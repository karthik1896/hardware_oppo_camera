package com.oppo.camera;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.ConditionVariable;
import android.text.TextUtils;
import android.util.Size;
import com.oplus.os.OplusUsbEnvironment;
import com.oppo.camera.aps.config.AlgoSwitchConfig;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.jni.FormatConverter;
import com.oppo.camera.jni.OppoSloganJNI;
import com.oppo.camera.o;
import com.oppo.camera.util.Util;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: BaseSloganUtil */
public class c {

    /* renamed from: b  reason: collision with root package name */
    protected static Typeface f2776b;
    protected static Typeface c;
    protected boolean A = false;
    protected int B = 0;
    protected Size C;
    protected int D = 0;
    protected int E = 0;
    protected int F = 0;
    protected String G = "";
    protected String H = "";
    protected String I = "";
    protected String J = "";
    protected String K = "";
    protected String L = "";
    protected volatile int M = 0;
    protected volatile long N = 0;
    protected long O = 0;
    protected SimpleDateFormat P = null;
    protected SimpleDateFormat Q = null;
    protected b R = new b();

    /* renamed from: a  reason: collision with root package name */
    public byte[] f2777a = null;
    protected final ConditionVariable d = new ConditionVariable();
    protected boolean e = false;
    protected int f = 0;
    protected int g = 0;
    protected String h = "";
    protected String i = null;
    protected Activity j = null;
    protected k k = null;
    protected FormatConverter l = null;
    protected Resources m = null;
    protected Set<String> n = new HashSet();
    protected OppoSloganJNI o = null;
    protected Size p = null;
    protected int q = 0;
    protected float r = 0.0f;
    protected float s = 0.0f;
    protected float t = 0.0f;
    protected Bitmap u = null;
    protected Bitmap v = null;
    protected boolean w = false;
    protected boolean x = false;
    protected boolean y = false;
    protected boolean z = false;

    /* compiled from: BaseSloganUtil */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2778a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f2779b = 0;
        public int c = 0;
        public int d = 0;
        public int e = 0;
        public int f = 0;
        public int g = R.drawable.slogan_copyright_normal;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public float k = 0.0f;
        public float l = 0.0f;
        public float m = 0.0f;
        public float n = 0.0f;
    }

    /* compiled from: BaseSloganUtil */
    public class b implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public Size f2782a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f2783b = null;
        public String c = null;
        public String d = null;
        public int e = -1;

        public b() {
        }

        public String toString() {
            return "YuvInfo, size: " + this.f2782a + ", customize: " + this.f2783b + ", time" + this.c + ", location" + this.d;
        }

        public Object clone() {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public c(Activity activity, k kVar, int i2) {
        String str;
        this.j = activity;
        this.k = kVar;
        this.E = i2;
        this.L = Util.n();
        if ("00FFF002".equals(Util.i("ro.hw.phone.color")) && (str = this.L) != null && !str.toLowerCase().contains("Lamborghini".toLowerCase())) {
            this.L += " Lamborghini";
        }
        this.m = this.j.getResources();
        this.r = (float) this.m.getDimensionPixelSize(R.dimen.slogan_text_shadow_radius);
        this.s = (float) this.m.getDimensionPixelSize(R.dimen.slogan_text_shadow_x);
        this.t = (float) this.m.getDimensionPixelSize(R.dimen.slogan_text_shadow_y);
        this.q = this.m.getColor(R.color.slogan_text_shadow_color);
        this.l = new FormatConverter();
        File internalSdDirectory = OplusUsbEnvironment.getInternalSdDirectory(this.j);
        if (internalSdDirectory != null) {
            this.i = internalSdDirectory.getAbsolutePath() + File.separator + ".SLOGAN" + File.separator;
            if (!new File(this.i).exists()) {
                j();
                if (!com.oppo.camera.q.a.f(this.i)) {
                    this.i = null;
                    e.e("BaseSloganUtil", "file directory is not exist");
                    return;
                }
                return;
            }
            return;
        }
        j();
        this.i = null;
        e.e("BaseSloganUtil", "interDir is null");
    }

    public void a(Size size, o.a aVar, HashSet<String> hashSet, boolean z2, int i2, boolean z3) {
        a(size, aVar, hashSet, z2, i2, z3 ? 1 : 0);
    }

    public void a(Size size, o.a aVar, HashSet<String> hashSet, boolean z2, int i2, int i3) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (i2 == 0 || 180 == i2) {
            size = a(size);
            this.M = 0;
        } else {
            this.M = 1;
        }
        this.n = hashSet;
        this.N = System.currentTimeMillis();
        boolean z3 = i3 != 0;
        String a2 = a(z3);
        String a3 = com.oppo.camera.util.b.a((Context) this.j, aVar);
        String b2 = b(z3);
        this.e = false;
        String str = "pref_video_slogan_device_key";
        if (this.y != a(z3 ? str : "pref_slogan_device_key")) {
            if (!z3) {
                str = "pref_slogan_device_key";
            }
            this.y = a(str);
            this.e = true;
        }
        String str2 = "pref_video_slogan_location_key";
        if (this.w != a(z3 ? str2 : "pref_slogan_location_key")) {
            if (!z3) {
                str2 = "pref_slogan_location_key";
            }
            this.w = a(str2);
            this.e = true;
        }
        String str3 = "pref_video_slogan_time_key";
        if (this.x != a(z3 ? str3 : "pref_slogan_time_key")) {
            if (!z3) {
                str3 = "pref_slogan_time_key";
            }
            this.x = a(str3);
            this.e = true;
        }
        this.e = this.e || a(b2, a2, a3) || this.z != z3;
        this.e = (this.e || (i2 == 0 || 180 == i2 ? !(!z3 || z2 || ((bitmap = this.u) != null && !bitmap.isRecycled())) : !(!z3 || z2 || ((bitmap2 = this.v) != null && !bitmap2.isRecycled()))) || ((z3 && z2 != this.A) || !size.equals(this.p))) && this.g != 1;
        this.A = z2;
        this.z = z3;
        this.O = this.N;
        if (this.e) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_VIDEO_WATERMARK_HAL_SUPPORT)) {
                i();
            } else {
                b(this.h);
            }
            this.g = 1;
            b bVar = this.R;
            bVar.f2782a = size;
            bVar.f2783b = b2;
            bVar.c = a2;
            bVar.d = a3;
            this.d.close();
            a(this.R, i3);
            this.d.open();
            this.G = b2;
            this.H = a2;
            this.I = a3;
            this.J = this.L;
            this.K = "1.1.0";
            this.D = this.E;
            this.F = this.M;
            this.p = size;
            this.g = 0;
        }
    }

    public void a(b bVar, int i2) {
        float f2;
        int i3;
        e.a("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s0:create bitmap start");
        Bitmap b2 = b(bVar, i2);
        e.a("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s1:create yuv prepare");
        if (b2 != null) {
            int dimensionPixelSize = this.m.getDimensionPixelSize(R.dimen.normal_slogan_text_margin_left);
            if (bVar.f2782a.getHeight() >= bVar.f2782a.getWidth()) {
                f2 = (((float) bVar.f2782a.getWidth()) * 1.0f) / ((float) Util.E());
                i3 = Util.E();
            } else {
                f2 = (((float) bVar.f2782a.getHeight()) * 1.0f) / ((float) Util.E());
                i3 = Util.C();
            }
            int i4 = i3 - (dimensionPixelSize * 2);
            int floor = (int) Math.floor((double) (((float) b2.getWidth()) / f2));
            boolean z2 = true;
            if (floor > i4 + dimensionPixelSize) {
                float f3 = (((float) i4) * 1.0f) / ((float) (floor - dimensionPixelSize));
                int width = (int) (((float) b2.getWidth()) * f3);
                int height = (int) (((float) b2.getHeight()) * f3);
                if (width % 2 != 0) {
                    width++;
                }
                if (height % 2 != 0) {
                    height++;
                }
                b2 = Bitmap.createScaledBitmap(b2, width, height, true);
                floor = i4 + (dimensionPixelSize * 2);
            }
            this.C = new Size(b2.getWidth(), b2.getHeight());
            this.B = floor;
            this.h = ".slogan_" + System.currentTimeMillis() + "_" + b2.getWidth() + "x" + b2.getHeight() + "_" + floor + ".yuv";
            StringBuilder sb = new StringBuilder();
            sb.append("generateSloganBuffer, waterMarkBitmap width: ");
            sb.append(b2.getWidth());
            sb.append(", height(): ");
            sb.append(b2.getHeight());
            sb.append(", mRefWidth: ");
            sb.append(this.B);
            e.a("BaseSloganUtil", sb.toString());
            e.a("BaseSloganUtil", "generateSloganBuffer, mSloganBuffer start s2:create yuv start");
            if (!this.z || !this.A) {
                z2 = false;
            }
            boolean a2 = a(b2, z2);
            if (!this.z || this.A) {
                b2.recycle();
            } else {
                a(b2);
            }
            e.a("BaseSloganUtil", "generateSloganBuffer,slogan buffer build " + a2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0275  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02cb  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0349  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x035a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap b(com.oppo.camera.c.b r27, int r28) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            android.util.Size r2 = r1.f2782a
            android.app.Activity r3 = r0.j
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r4 = r1.f2783b
            java.lang.String r5 = r1.c
            java.lang.String r1 = r1.d
            java.lang.String r6 = r0.L
            boolean r7 = r0.y
            java.lang.String r8 = ""
            if (r7 != 0) goto L_0x001c
            r4 = r8
            r6 = r4
        L_0x001c:
            boolean r7 = r0.w
            if (r7 != 0) goto L_0x0021
            r1 = r8
        L_0x0021:
            boolean r7 = r0.x
            if (r7 != 0) goto L_0x0026
            r5 = r8
        L_0x0026:
            boolean r7 = android.text.TextUtils.isEmpty(r1)
            boolean r9 = android.text.TextUtils.isEmpty(r5)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "createBitmap, currentTime: "
            r10.append(r11)
            r10.append(r5)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "BaseSloganUtil"
            com.oppo.camera.e.b(r11, r10)
            int r10 = r2.getWidth()
            int r12 = r2.getHeight()
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r10 >= r12) goto L_0x005b
            int r10 = r2.getWidth()
            float r10 = (float) r10
            float r10 = r10 * r13
            int r12 = com.oppo.camera.util.Util.E()
            goto L_0x0065
        L_0x005b:
            int r10 = r2.getHeight()
            float r10 = (float) r10
            float r10 = r10 * r13
            int r12 = com.oppo.camera.util.Util.E()
        L_0x0065:
            float r12 = (float) r12
            float r10 = r10 / r12
            r12 = r10
            r10 = r28
            com.oppo.camera.c$a r10 = r0.a((float) r12, (int) r10)
            android.graphics.Bitmap r13 = r0.a((com.oppo.camera.c.a) r10, (float) r12)
            android.graphics.Paint r14 = r0.a((com.oppo.camera.c.a) r10)
            android.graphics.Paint r15 = r0.b((com.oppo.camera.c.a) r10)
            r27 = r8
            android.graphics.Paint r8 = r0.c((com.oppo.camera.c.a) r10)
            r16 = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            java.lang.String r6 = r0.c((java.lang.String) r6)
            boolean r17 = android.text.TextUtils.isEmpty(r6)
            r0 = 0
            if (r17 != 0) goto L_0x00a2
            r17 = r7
            java.lang.String r7 = r6.toUpperCase()
            r28 = r8
            int r8 = r6.length()
            r14.getTextBounds(r7, r0, r8, r1)
            goto L_0x00a6
        L_0x00a2:
            r17 = r7
            r28 = r8
        L_0x00a6:
            r7 = 2131166781(0x7f07063d, float:1.7947817E38)
            int r3 = r3.getDimensionPixelSize(r7)
            int r1 = r1.height()
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0104
            boolean r7 = android.text.TextUtils.isEmpty(r4)
            if (r7 != 0) goto L_0x00f6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            java.lang.String r6 = " · "
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            float r7 = r14.measureText(r6)
            int r7 = (int) r7
            int r8 = r4.length()
            r0 = 20
            if (r8 <= r0) goto L_0x00e4
            float r0 = r10.k
            r8 = 1058642330(0x3f19999a, float:0.6)
            float r0 = r0 * r8
            r15.setTextSize(r0)
        L_0x00e4:
            float r0 = r15.measureText(r4)
            int r0 = (int) r0
            int r8 = r13.getWidth()
            int r8 = r8 + r7
            int r8 = r8 + r0
            float r0 = r10.k
            r15.setTextSize(r0)
            r0 = r8
            goto L_0x00fc
        L_0x00f6:
            float r0 = r14.measureText(r6)
            int r0 = (int) r0
            r7 = r0
        L_0x00fc:
            r8 = 1
            r19 = r7
            r20 = r15
            r7 = r6
            r6 = r1
            goto L_0x010c
        L_0x0104:
            r7 = r6
            r20 = r15
            r0 = 0
            r6 = 0
            r8 = 0
            r19 = 0
        L_0x010c:
            int r15 = r2.getWidth()
            r21 = r13
            int r13 = r10.f2778a
            r22 = r4
            r4 = 2
            int r13 = r13 * r4
            int r13 = r13 + r0
            int r13 = java.lang.Math.max(r15, r13)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r4 = "createBitmap, maxWatermarkWidth: "
            r15.append(r4)
            r15.append(r13)
            java.lang.String r4 = ", scale: "
            r15.append(r4)
            r15.append(r12)
            java.lang.String r4 = ", pictureSize: "
            r15.append(r4)
            r15.append(r2)
            java.lang.String r2 = ", firstLineContentWidth: "
            r15.append(r2)
            r15.append(r0)
            java.lang.String r2 = r15.toString()
            com.oppo.camera.e.b(r11, r2)
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            if (r9 != 0) goto L_0x0162
            int r12 = r5.length()
            r15 = r28
            r28 = r14
            r14 = 0
            r15.getTextBounds(r5, r14, r12, r2)
            goto L_0x0167
        L_0x0162:
            r15 = r28
            r28 = r14
            r14 = 0
        L_0x0167:
            if (r17 != 0) goto L_0x0175
            int r12 = r16.length()
            r18 = r1
            r1 = r16
            r15.getTextBounds(r1, r14, r12, r4)
            goto L_0x0179
        L_0x0175:
            r18 = r1
            r1 = r16
        L_0x0179:
            if (r17 != 0) goto L_0x01c3
            if (r9 != 0) goto L_0x01c3
            float r9 = r15.measureText(r5)
            int r9 = (int) r9
            float r12 = r15.measureText(r1)
            int r12 = (int) r12
            int r16 = r13 - r9
            int r14 = r10.f
            int r16 = r16 - r14
            int r14 = r10.f2778a
            r17 = 2
            int r14 = r14 * 2
            int r14 = r16 - r14
            if (r12 > r14) goto L_0x01a3
            r12 = r26
            r14 = r1
            r16 = r11
            r25 = r7
            r7 = r27
            r27 = r25
            goto L_0x01b1
        L_0x01a3:
            r12 = r26
            r25 = r7
            r7 = r27
            r27 = r25
            java.lang.String r14 = r12.a(r1, r15, r14, r7)
            r16 = r11
        L_0x01b1:
            float r11 = r15.measureText(r14)
            int r11 = (int) r11
            int r11 = r11 + r9
            r17 = r9
            int r9 = r10.f
            int r9 = r9 + r11
            int r8 = r8 + 1
            int r2 = r2.height()
            goto L_0x020b
        L_0x01c3:
            r12 = r26
            r16 = r11
            r25 = r7
            r7 = r27
            r27 = r25
            if (r17 != 0) goto L_0x01f3
            if (r9 == 0) goto L_0x01f3
            float r2 = r15.measureText(r1)
            int r2 = (int) r2
            int r9 = r13 + 0
            int r11 = r10.f2778a
            r14 = 2
            int r11 = r11 * r14
            int r9 = r9 - r11
            if (r2 > r9) goto L_0x01e1
            r2 = r1
            goto L_0x01e5
        L_0x01e1:
            java.lang.String r2 = r12.a(r1, r15, r9, r7)
        L_0x01e5:
            float r9 = r15.measureText(r2)
            int r9 = (int) r9
            int r8 = r8 + 1
            int r11 = r4.height()
            r14 = r2
            r2 = r11
            goto L_0x0209
        L_0x01f3:
            if (r17 == 0) goto L_0x0206
            if (r9 != 0) goto L_0x0206
            float r9 = r15.measureText(r5)
            int r9 = (int) r9
            int r8 = r8 + 1
            int r2 = r2.height()
            r14 = r7
            r17 = r9
            goto L_0x020b
        L_0x0206:
            r14 = r7
            r2 = 0
            r9 = 0
        L_0x0209:
            r17 = 0
        L_0x020b:
            boolean r11 = android.text.TextUtils.isEmpty(r14)
            if (r11 != 0) goto L_0x0219
            int r7 = r14.length()
            java.lang.String r7 = r1.substring(r7)
        L_0x0219:
            boolean r11 = android.text.TextUtils.isEmpty(r7)
            if (r11 != 0) goto L_0x0233
            int r4 = r4.height()
            int r11 = r10.f2778a
            r23 = 2
            int r11 = r11 * 2
            int r13 = r13 - r11
            java.lang.String r11 = "..."
            java.lang.String r7 = r12.a(r7, r15, r13, r11)
            int r8 = r8 + 1
            goto L_0x0234
        L_0x0233:
            r4 = 0
        L_0x0234:
            int r6 = r6 + r3
            int r2 = r2 + r6
            int r2 = r2 + r4
            int r11 = r10.f2779b
            int r2 = r2 + r11
            r11 = 3
            if (r11 != r8) goto L_0x024e
            boolean r8 = r12.x
            if (r8 == 0) goto L_0x0247
            int r8 = r10.c
            int r2 = r2 + r8
            int r8 = r10.e
            goto L_0x024c
        L_0x0247:
            int r8 = r10.d
            int r2 = r2 + r8
            int r8 = r10.e
        L_0x024c:
            int r2 = r2 + r8
            goto L_0x0262
        L_0x024e:
            r13 = 2
            if (r13 != r8) goto L_0x0262
            boolean r8 = r12.y
            if (r8 == 0) goto L_0x0258
            int r8 = r10.e
            goto L_0x024c
        L_0x0258:
            boolean r8 = r12.x
            if (r8 == 0) goto L_0x025f
            int r8 = r10.c
            goto L_0x024c
        L_0x025f:
            int r8 = r10.d
            goto L_0x024c
        L_0x0262:
            int r0 = java.lang.Math.max(r0, r9)
            int r8 = r10.f2778a
            r9 = 2
            int r8 = r8 * r9
            int r0 = r0 + r8
            int r8 = r0 % 2
            if (r8 == 0) goto L_0x0271
            int r0 = r0 + 1
        L_0x0271:
            int r8 = r2 % 2
            if (r8 == 0) goto L_0x0277
            int r2 = r2 + 1
        L_0x0277:
            android.graphics.Bitmap$Config r8 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r8 = com.oppo.camera.util.Util.a((int) r0, (int) r2, (android.graphics.Bitmap.Config) r8)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r13 = "createBitmap, sloganWidth: "
            r9.append(r13)
            r9.append(r0)
            java.lang.String r0 = ", sloganHeight: "
            r9.append(r0)
            r9.append(r2)
            java.lang.String r0 = ", composeBitmap: "
            r9.append(r0)
            r9.append(r8)
            java.lang.String r0 = r9.toString()
            r9 = r16
            com.oppo.camera.e.a(r9, r0)
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>(r8)
            android.graphics.PaintFlagsDrawFilter r13 = new android.graphics.PaintFlagsDrawFilter
            r16 = r8
            r8 = 0
            r13.<init>(r8, r11)
            r0.setDrawFilter(r13)
            boolean r8 = android.text.TextUtils.isEmpty(r27)
            if (r8 != 0) goto L_0x02cb
            int r8 = r10.f2778a
            float r8 = (float) r8
            int r11 = r18 + r3
            float r11 = (float) r11
            r13 = r28
            r25 = r14
            r14 = r27
            r27 = r25
            r0.drawText(r14, r8, r11, r13)
            goto L_0x02cd
        L_0x02cb:
            r27 = r14
        L_0x02cd:
            boolean r8 = android.text.TextUtils.isEmpty(r22)
            if (r8 != 0) goto L_0x0349
            android.graphics.Paint r8 = new android.graphics.Paint
            r8.<init>()
            r11 = 255(0xff, float:3.57E-43)
            r8.setAlpha(r11)
            android.graphics.Matrix r11 = new android.graphics.Matrix
            r11.<init>()
            int r13 = r10.f2778a
            int r13 = r13 + r19
            int r14 = r21.getHeight()
            int r19 = r21.getWidth()
            r23 = 1073741824(0x40000000, float:2.0)
            r24 = r5
            int r5 = r13 + r19
            int r14 = r18 - r14
            float r14 = (float) r14
            float r14 = r14 / r23
            int r14 = (int) r14
            int r14 = r14 + r3
            r19 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r28 = r4
            java.lang.String r4 = "createBitmap, textHeight: "
            r1.append(r4)
            r4 = r18
            r1.append(r4)
            java.lang.String r4 = ", textMarginTop: "
            r1.append(r4)
            r1.append(r3)
            java.lang.String r3 = ", ownerNameX: "
            r1.append(r3)
            r1.append(r5)
            java.lang.String r3 = ", ownerNameY: "
            r1.append(r3)
            r1.append(r6)
            java.lang.String r3 = ", copyRightY: "
            r1.append(r3)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            com.oppo.camera.e.a(r9, r1)
            float r1 = (float) r13
            float r3 = (float) r14
            r11.postTranslate(r1, r3)
            r1 = r21
            r0.drawBitmap(r1, r11, r8)
            float r1 = (float) r5
            float r3 = (float) r6
            r4 = r20
            r8 = r22
            r0.drawText(r8, r1, r3, r4)
            goto L_0x034f
        L_0x0349:
            r19 = r1
            r28 = r4
            r24 = r5
        L_0x034f:
            int r1 = r10.f2779b
            int r1 = r2 - r1
            float r1 = (float) r1
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            if (r3 != 0) goto L_0x0377
            int r3 = r10.f2778a
            float r3 = (float) r3
            int r4 = r10.f2779b
            int r2 = r2 - r4
            float r2 = (float) r2
            r0.drawText(r7, r3, r2, r15)
            boolean r2 = r12.x
            if (r2 == 0) goto L_0x036f
            int r2 = r10.c
            float r2 = (float) r2
            float r1 = r1 - r2
            r4 = r28
            goto L_0x0375
        L_0x036f:
            r4 = r28
            int r2 = r10.d
            float r2 = (float) r2
            float r1 = r1 - r2
        L_0x0375:
            float r2 = (float) r4
            float r1 = r1 - r2
        L_0x0377:
            boolean r2 = android.text.TextUtils.isEmpty(r19)
            if (r2 != 0) goto L_0x0399
            boolean r2 = android.text.TextUtils.isEmpty(r24)
            if (r2 != 0) goto L_0x0399
            int r2 = r10.f2778a
            float r2 = (float) r2
            r5 = r24
            r0.drawText(r5, r2, r1, r15)
            int r2 = r10.f2778a
            int r2 = r2 + r17
            int r3 = r10.f
            int r2 = r2 + r3
            float r2 = (float) r2
            r7 = r27
            r0.drawText(r7, r2, r1, r15)
            goto L_0x03b2
        L_0x0399:
            r7 = r27
            r5 = r24
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            int r3 = r10.f2778a
            float r3 = (float) r3
            r0.drawText(r2, r3, r1, r15)
        L_0x03b2:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.c.b(com.oppo.camera.c$b, int):android.graphics.Bitmap");
    }

    private boolean a(Bitmap bitmap, boolean z2) {
        if (bitmap == null || bitmap.isRecycled()) {
            e.e("BaseSloganUtil", "generateYuvFile fail, bitmap: " + bitmap);
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int i3 = (int) (((float) i2) * 1.5f);
        byte[] bArr = new byte[(i3 + i2)];
        byte[] bArr2 = new byte[i2];
        FormatConverter formatConverter = this.l;
        int i4 = -1;
        int argbToNv21 = formatConverter != null ? formatConverter.argbToNv21(bitmap, bArr, bArr2, 0) : -1;
        System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
        e.a("BaseSloganUtil", "generateYuvBuffer, width: " + width + ", height: " + height + ", flag: " + argbToNv21);
        if (argbToNv21 < 0) {
            e.e("BaseSloganUtil", "generateYuvBuffer fail, yuvData: " + bArr);
            return false;
        }
        this.f2777a = bArr;
        boolean z3 = true;
        if (2 == AlgoSwitchConfig.getApsVersion() && z2 && h() != null) {
            i4 = h().setSloganBuffer(bArr, width, height, bArr.length, this.h);
        }
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            z3 = com.oppo.camera.q.a.a(this.i + this.h, com.oppo.camera.q.a.h, bArr);
        }
        e.a("BaseSloganUtil", "generateYuvFile, setBufferResult: " + i4);
        return z3;
    }

    private OppoSloganJNI h() {
        if (this.o == null) {
            this.o = new OppoSloganJNI();
        }
        return this.o;
    }

    private void b(String str) {
        e.a("BaseSloganUtil", "deleteDir, yuvFileDir: " + str);
        if (this.i != null) {
            File file = new File(str);
            if (!file.isDirectory()) {
                e.b("BaseSloganUtil", "deleteDir, dir is not directory");
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                e.b("BaseSloganUtil", "deleteDir, fileList is null");
                return;
            }
            for (File file2 : listFiles) {
                if (file2 != null && file2.isFile()) {
                    String name = file2.getName();
                    String absolutePath = file2.getAbsolutePath();
                    String[] split = name.split("_");
                    if (split.length == 4) {
                        String str2 = split[1];
                        e.b("BaseSloganUtil", "deleteDir, timeStamp: " + str2 + ", mYuvDoneTimeStamp: " + this.O + ", filePath: " + absolutePath);
                        try {
                            if (!TextUtils.isEmpty(str2)) {
                                if (TextUtils.isDigitsOnly(str2)) {
                                    if (Math.abs(this.O - Long.parseLong(str2)) >= 300000 && !this.n.contains(absolutePath)) {
                                        com.oppo.camera.q.a.c(absolutePath);
                                    }
                                }
                            }
                            com.oppo.camera.q.a.c(absolutePath);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            i();
        }
    }

    private void i() {
        if (2 == AlgoSwitchConfig.getApsVersion() && this.z && h() != null) {
            int sloganFileDeleteAll = h().sloganFileDeleteAll();
            e.b("BaseSloganUtil", "deleteDir, JNI sloganFileDeleteAll result: " + sloganFileDeleteAll);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00ae, code lost:
        if (a(r3.z ? "pref_video_slogan_time_key" : "pref_slogan_time_key") == false) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c5, code lost:
        if (a(r3.z ? "pref_video_slogan_location_key" : "pref_slogan_location_key") == false) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0097, code lost:
        if (a(r3.z ? "pref_video_slogan_device_key" : "pref_slogan_device_key") == false) goto L_0x0099;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isSloganInfoChange, currentCustomize: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ", mSloganCustomize: "
            r0.append(r1)
            java.lang.String r1 = r3.G
            r0.append(r1)
            java.lang.String r1 = ", currentTime: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = ", mS1loganTime: "
            r0.append(r1)
            java.lang.String r1 = r3.H
            r0.append(r1)
            java.lang.String r1 = ", VERSION: "
            r0.append(r1)
            java.lang.String r1 = "1.1.0"
            r0.append(r1)
            java.lang.String r2 = ", mSloganVersion: "
            r0.append(r2)
            java.lang.String r2 = r3.K
            r0.append(r2)
            java.lang.String r2 = ", mMarketName: "
            r0.append(r2)
            java.lang.String r2 = r3.L
            r0.append(r2)
            java.lang.String r2 = ", mSloganMarketName: "
            r0.append(r2)
            java.lang.String r2 = r3.J
            r0.append(r2)
            java.lang.String r2 = ", mEnterType: "
            r0.append(r2)
            int r2 = r3.E
            r0.append(r2)
            java.lang.String r2 = ", mSloganEnterType: "
            r0.append(r2)
            int r2 = r3.D
            r0.append(r2)
            java.lang.String r2 = ", mCurrentOrientation"
            r0.append(r2)
            int r2 = r3.M
            r0.append(r2)
            java.lang.String r2 = ", mSloganOrientation"
            r0.append(r2)
            int r2 = r3.F
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "BaseSloganUtil"
            com.oppo.camera.e.a(r2, r0)
            java.lang.String r0 = r3.G
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L_0x0099
            boolean r4 = r3.z
            if (r4 == 0) goto L_0x0091
            java.lang.String r4 = "pref_video_slogan_device_key"
            goto L_0x0093
        L_0x0091:
            java.lang.String r4 = "pref_slogan_device_key"
        L_0x0093:
            boolean r4 = r3.a((java.lang.String) r4)
            if (r4 != 0) goto L_0x00e8
        L_0x0099:
            java.lang.String r4 = r3.H
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00b0
            boolean r4 = r3.z
            if (r4 == 0) goto L_0x00a8
            java.lang.String r4 = "pref_video_slogan_time_key"
            goto L_0x00aa
        L_0x00a8:
            java.lang.String r4 = "pref_slogan_time_key"
        L_0x00aa:
            boolean r4 = r3.a((java.lang.String) r4)
            if (r4 != 0) goto L_0x00e8
        L_0x00b0:
            java.lang.String r4 = r3.I
            boolean r4 = r6.equals(r4)
            if (r4 != 0) goto L_0x00c7
            boolean r4 = r3.z
            if (r4 == 0) goto L_0x00bf
            java.lang.String r4 = "pref_video_slogan_location_key"
            goto L_0x00c1
        L_0x00bf:
            java.lang.String r4 = "pref_slogan_location_key"
        L_0x00c1:
            boolean r4 = r3.a((java.lang.String) r4)
            if (r4 != 0) goto L_0x00e8
        L_0x00c7:
            java.lang.String r4 = r3.L
            java.lang.String r5 = r3.J
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x00e8
            java.lang.String r4 = r3.K
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x00e8
            int r4 = r3.E
            int r5 = r3.D
            if (r4 != r5) goto L_0x00e8
            int r4 = r3.M
            int r5 = r3.F
            if (r4 == r5) goto L_0x00e6
            goto L_0x00e8
        L_0x00e6:
            r4 = 0
            goto L_0x00e9
        L_0x00e8:
            r4 = 1
        L_0x00e9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.c.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private void j() {
        e.a("BaseSloganUtil", "clearAllPrefValue");
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = "";
        this.D = 0;
        this.F = 0;
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        String replaceAll = Pattern.compile("[一-龥]").matcher(str).replaceAll("");
        e.b("BaseSloganUtil", "removeChineseOfString,repickStr: " + replaceAll);
        return replaceAll;
    }

    /* access modifiers changed from: protected */
    public Bitmap a(a aVar, float f2) {
        Bitmap decodeResource = BitmapFactory.decodeResource(this.j.getResources(), aVar.g);
        Matrix matrix = new Matrix();
        float f3 = f2 / 2.77777f;
        matrix.postScale(f3, f3);
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, true);
    }

    /* access modifiers changed from: protected */
    public Typeface a() {
        Typeface typeface = f2776b;
        if (typeface != null) {
            return typeface;
        }
        try {
            f2776b = Typeface.createFromAsset(this.j.getAssets(), "fonts/Gotham-Bold.otf");
        } catch (Exception unused) {
            f2776b = Typeface.DEFAULT;
            e.e("BaseSloganUtil", "getMarketFontTypeface, create special typeface fail");
        }
        return f2776b;
    }

    private Typeface k() {
        Typeface typeface = c;
        if (typeface != null) {
            return typeface;
        }
        try {
            c = Typeface.createFromFile("/system/fonts/Roboto-Medium.ttf");
        } catch (Exception unused) {
            c = Typeface.DEFAULT;
            e.e("BaseSloganUtil", "getNormalFontTypeface, create special typeface fail");
        }
        return c;
    }

    private Paint a(a aVar) {
        Paint paint = new Paint();
        paint.setTypeface(a());
        paint.setTextSize(aVar.k);
        paint.setColor(this.j.getColor(R.color.camera_white));
        paint.setShadowLayer(this.r, this.s, this.t, this.q);
        return paint;
    }

    private Paint b(a aVar) {
        Paint paint = new Paint();
        paint.setTypeface(k());
        paint.setTextSize(aVar.k);
        paint.setColor(this.j.getColor(R.color.camera_white));
        paint.setShadowLayer(this.r, this.s, this.t, this.q);
        return paint;
    }

    private Paint c(a aVar) {
        Paint paint = new Paint();
        paint.setTypeface(k());
        paint.setTextSize(aVar.l);
        paint.setColor(this.j.getColor(R.color.camera_white));
        paint.setShadowLayer(this.r, this.s, this.t, this.q);
        return paint;
    }

    public Size b() {
        this.d.block(3000);
        return this.C;
    }

    public int c() {
        this.d.block(3000);
        return this.B;
    }

    public byte[] d() {
        this.d.block(3000);
        return this.f2777a;
    }

    public Bitmap a(int i2) {
        this.d.block(3000);
        e.b("BaseSloganUtil", "getVideoWatermarkBitmap, orientation: " + i2);
        if (i2 == 0 || 180 == i2) {
            return this.u;
        }
        return this.v;
    }

    public String e() {
        this.d.block(3000);
        String str = this.i + this.h;
        if (2 == AlgoSwitchConfig.getApsVersion()) {
            e.a("BaseSloganUtil", "getYuvFilePath, return path: " + this.h);
            return this.h;
        }
        e.a("BaseSloganUtil", "getYuvFilePath, return path: " + str);
        return str;
    }

    public int f() {
        this.f = 0;
        boolean isEmpty = TextUtils.isEmpty(b(this.z));
        if (!this.y && isEmpty) {
            this.f = 0;
        } else if (this.y && isEmpty) {
            this.f = 1;
        } else if (this.y && !isEmpty) {
            this.f = 2;
        }
        return this.f;
    }

    private String a(boolean z2) {
        if (!z2 && this.P == null) {
            this.P = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault());
        } else if (z2 && this.Q == null) {
            this.Q = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        }
        TimeZone timeZone = TimeZone.getDefault();
        if (!z2) {
            if (!timeZone.equals(this.P.getTimeZone())) {
                this.P.setTimeZone(timeZone);
            }
            return this.P.format(new Date(this.N));
        }
        if (!timeZone.equals(this.Q.getTimeZone())) {
            this.Q.setTimeZone(timeZone);
        }
        return this.Q.format(new Date(this.N));
    }

    private String b(boolean z2) {
        String str = z2 ? "pref_video_slogan_customize_key" : "pref_slogan_customize_key";
        if (this.k != null && CameraConfig.getSupportSettingMenuKey(str)) {
            String string = this.k.getString(str, "");
            e.b("BaseSloganUtil", "getCustomizedStr, customizedStr: " + string);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public a a(float f2) {
        return a(f2, 0);
    }

    /* access modifiers changed from: protected */
    public a a(float f2, int i2) {
        int i3;
        a aVar = new a();
        Resources resources = this.j.getResources();
        if (2 == i2) {
            i3 = resources.getDimensionPixelSize(R.dimen.movie_slogan_text_margin_left);
        } else {
            i3 = resources.getDimensionPixelSize(R.dimen.normal_slogan_text_margin_left);
        }
        aVar.f2778a = (int) (((float) i3) * f2);
        aVar.f2779b = (int) (((float) resources.getDimensionPixelSize(R.dimen.slogan_text_margin_bottom)) * f2);
        aVar.k = (float) ((int) (((float) resources.getDimensionPixelSize(R.dimen.slogan_text_firstline_size)) * f2));
        aVar.l = (float) ((int) (((float) resources.getDimensionPixelSize(R.dimen.slogan_text_normal_size)) * f2));
        aVar.g = R.drawable.slogan_copyright_normal;
        aVar.e = (int) (((float) this.j.getResources().getDimensionPixelSize(R.dimen.slogan_inteval_between_first_second_line)) * f2);
        aVar.d = (int) (((float) this.j.getResources().getDimensionPixelSize(R.dimen.slogan_inteval_between_second_third_line_without_time)) * f2);
        aVar.c = (int) (((float) this.j.getResources().getDimensionPixelSize(R.dimen.slogan_inteval_between_second_third_line_with_time)) * f2);
        aVar.f = (int) (((float) this.j.getResources().getDimensionPixelSize(R.dimen.slogan_inteval_between_time_and_addr)) * f2);
        return aVar;
    }

    private String a(String str, Paint paint, int i2, String str2) {
        if (a(paint, str, i2)) {
            int measureText = str2 != null ? (int) paint.measureText(str2) : 0;
            int measureText2 = (int) paint.measureText(str, 0, 1);
            int i3 = i2 - measureText;
            int i4 = i3 / measureText2;
            String substring = str.substring(0, i4);
            if (str2 != null) {
                substring = substring + str2;
            }
            int measureText3 = (int) ((((float) i2) - paint.measureText(substring)) / ((float) measureText2));
            int i5 = i4 + measureText3;
            str = str.substring(0, i5);
            if (str2 != null) {
                str = str + str2;
            }
            e.b("BaseSloganUtil", "createSplitString, inputString: " + substring + ", endSymbol:" + str2 + ", endSymbolWidth: " + measureText + ", remainingWidth: " + i3 + ", contentSize: " + i5 + ", limit: " + i2 + ", deviationSize: " + measureText3 + ", outputString: " + str);
        }
        return str;
    }

    private boolean a(Paint paint, String str, int i2) {
        return paint.measureText(str) > ((float) i2);
    }

    private void a(Bitmap bitmap) {
        if (this.R.f2782a != null && bitmap != null) {
            if (this.M == 0 || 180 == this.M) {
                this.u = bitmap;
            } else {
                this.v = bitmap;
            }
        }
    }

    private Size a(Size size) {
        if (size != null) {
            return new Size(size.getHeight(), size.getWidth());
        }
        return null;
    }

    public boolean a(String str) {
        k kVar = this.k;
        if (kVar != null) {
            return "on".equals(kVar.getString(str, this.j.getString(R.string.camera_slogan_default_value)));
        }
        return false;
    }

    public void g() {
        if (!Util.p(this.j)) {
            this.k.edit().putString("pref_camera_recordlocation_key", "off").apply();
            this.k.edit().putString("pref_slogan_location_key", "off").apply();
            this.k.edit().putString("pref_video_slogan_location_key", "off").apply();
            if (!a("pref_slogan_time_key") && !a("pref_slogan_device_key")) {
                this.k.edit().putString("pref_camera_slogan_key", "off").apply();
            }
            if (!a("pref_video_slogan_time_key") && !a("pref_video_slogan_device_key")) {
                this.k.edit().putString("pref_camera_video_slogan_key", "off").apply();
            }
        }
    }
}
