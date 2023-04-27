package com.oppo.camera.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.aps.ApsAdapterConstant;
import com.oppo.camera.e;
import com.oppo.camera.ui.inverse.c;
import com.oppo.camera.ui.l;
import com.oppo.camera.ui.menu.OppoTextView;
import com.oppo.camera.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CameraScreenHintView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private static int f3782a;

    /* renamed from: b  reason: collision with root package name */
    private static int f3783b;
    private static int c;
    private static int d;
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    /* access modifiers changed from: private */
    public RotateImageView H;
    /* access modifiers changed from: private */
    public OppoTextView I;
    /* access modifiers changed from: private */
    public List<HashMap> J;
    private List<String> K;
    /* access modifiers changed from: private */
    public a L;
    private l M;
    private b N;
    private a O;
    private Size P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    /* access modifiers changed from: private */
    public boolean U;
    private boolean V;
    private boolean W;
    private Handler aa;
    private l.a ab;
    private int e;
    /* access modifiers changed from: private */
    public int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
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
    private long z;

    public CameraScreenHintView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CameraScreenHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public CameraScreenHintView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = 1;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = -1;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = new ArrayList();
        this.L = new a();
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.aa = new Handler() {
            public void handleMessage(Message message) {
                e.a("CameraScreenHintView", "handleMessage, what: " + message.what);
                int i = message.what;
                if (i == 1) {
                    synchronized (this) {
                        if (CameraScreenHintView.this.J == null || CameraScreenHintView.this.J.size() <= 0) {
                            if (CameraScreenHintView.this.A) {
                                CameraScreenHintView.this.setHintTextViewVisible(8);
                                CameraScreenHintView.this.H.setVisibility(0);
                                CameraScreenHintView.this.H.setAlpha(0.0f);
                                CameraScreenHintView.this.L.a(1);
                            } else if (CameraScreenHintView.this.I.a()) {
                                CameraScreenHintView.this.L.a(2);
                            }
                        } else if (CameraScreenHintView.this.J.size() > 1) {
                            CameraScreenHintView.this.b(((Integer) ((HashMap) CameraScreenHintView.this.J.get(0)).get("TEXT_BG_COLOR")).intValue(), ((Integer) ((HashMap) CameraScreenHintView.this.J.get(0)).get("TEXT_COLOR")).intValue());
                            CameraScreenHintView.this.I.setText((String) ((HashMap) CameraScreenHintView.this.J.get(0)).get("TEXT"));
                            CameraScreenHintView.this.setHintTextViewVisible(0);
                            CameraScreenHintView.this.I.setAlpha(0.0f);
                            CameraScreenHintView.this.L.a(0);
                        } else if (CameraScreenHintView.this.A) {
                            CameraScreenHintView.this.b((int) R.drawable.screen_hint_textview_bg, (int) R.color.screen_hint_text_color);
                            CameraScreenHintView.this.H.setVisibility(0);
                            CameraScreenHintView.this.setHintTextViewVisible(8);
                            CameraScreenHintView.this.H.setAlpha(0.0f);
                            if (CameraScreenHintView.this.I.getText().equals(CameraScreenHintView.this.getResources().getString(R.string.camera_toast_LDAF))) {
                                boolean unused = CameraScreenHintView.this.U = false;
                            }
                            CameraScreenHintView.this.L.a(1);
                        } else {
                            CameraScreenHintView.this.b(((Integer) ((HashMap) CameraScreenHintView.this.J.get(0)).get("TEXT_BG_COLOR")).intValue(), ((Integer) ((HashMap) CameraScreenHintView.this.J.get(0)).get("TEXT_COLOR")).intValue());
                            CameraScreenHintView.this.I.setText((String) ((HashMap) CameraScreenHintView.this.J.get(0)).get("TEXT"));
                            CameraScreenHintView.this.setHintTextViewVisible(0);
                            CameraScreenHintView.this.I.setAlpha(0.0f);
                            CameraScreenHintView.this.L.a(0);
                        }
                    }
                    CameraScreenHintView.this.m();
                    CameraScreenHintView.this.d();
                } else if (i == 2) {
                    CameraScreenHintView.this.b(true);
                } else if (i == 3) {
                    CameraScreenHintView.this.d();
                } else if (i == 4) {
                    CameraScreenHintView.this.k();
                } else if (i == 5) {
                    CameraScreenHintView.this.l();
                }
            }
        };
        this.ab = new l.a() {
            public void a(int i) {
                int unused = CameraScreenHintView.this.f = i;
                if (CameraScreenHintView.this.H != null) {
                    CameraScreenHintView.this.H.a(CameraScreenHintView.this.f, false);
                }
                if (CameraScreenHintView.this.I != null) {
                    CameraScreenHintView.this.I.a(CameraScreenHintView.this.f, false);
                    CameraScreenHintView.this.I.invalidate();
                }
                CameraScreenHintView.this.d();
            }

            public boolean a() {
                if (CameraScreenHintView.this.getVisibility() != 0) {
                    return false;
                }
                if ((CameraScreenHintView.this.H == null || CameraScreenHintView.this.H.getVisibility() != 0) && (CameraScreenHintView.this.I == null || !CameraScreenHintView.this.I.a())) {
                    return false;
                }
                return true;
            }

            public void a(float f) {
                if (CameraScreenHintView.this.H != null) {
                    CameraScreenHintView.this.H.setAlpha(f);
                }
                if (CameraScreenHintView.this.I != null) {
                    CameraScreenHintView.this.I.setAlpha(f);
                }
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CameraScreenHintView);
        try {
            this.h = obtainStyledAttributes.getDimensionPixelSize(1, 42);
            this.i = obtainStyledAttributes.getDimensionPixelSize(2, 20);
            this.t = getResources().getDimensionPixelSize(R.dimen.camera_up_hint_text_default_max_width);
            this.u = getResources().getDimensionPixelOffset(R.dimen.camera_up_hint_text_secondary_max_width);
            this.v = getResources().getDimensionPixelSize(R.dimen.camera_up_hint_text_video_max_width);
            obtainStyledAttributes.recycle();
            this.J = new ArrayList();
            f3783b = Util.v() + context.getResources().getDimensionPixelSize(R.dimen.toast_margin_top);
            c = Util.v() + context.getResources().getDimensionPixelSize(R.dimen.toast_margin_top_text);
            d = Util.v();
            f3782a = (int) (((double) Util.E()) * 1.3333333333333333d);
            this.q = (int) (((double) Util.E()) * 1.7777777777777777d);
            this.r = (int) (((double) Util.E()) * 1.0d);
            this.s = Util.C();
            this.x = getResources().getDimensionPixelSize(R.dimen.movie_time_margin_bottom);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.H = (RotateImageView) findViewById(R.id.camera_screen_hint_icon);
        this.H.setVisibility(8);
        this.I = (OppoTextView) findViewById(R.id.camera_screen_hint_text);
        setHintTextViewVisible(8);
        this.H.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public OppoTextView getHintTextView() {
        OppoTextView oppoTextView = this.I;
        if (oppoTextView != null) {
            return oppoTextView;
        }
        return null;
    }

    public void setChangeHintColor(boolean z2) {
        this.E = z2;
    }

    public RotateImageView getHintIconView() {
        RotateImageView rotateImageView = this.H;
        if (rotateImageView != null) {
            return rotateImageView;
        }
        return null;
    }

    private void i() {
        this.M = new l(1.0f, 0.0f);
        this.M.setDuration(300);
        this.M.a(this.ab);
    }

    public void a() {
        this.C = true;
        this.B = false;
        this.V = false;
        OppoTextView oppoTextView = this.I;
        if (oppoTextView != null) {
            oppoTextView.clearAnimation();
            setHintTextViewVisible(8);
        }
        RotateImageView rotateImageView = this.H;
        if (rotateImageView != null) {
            rotateImageView.clearAnimation();
        }
    }

    public void b() {
        this.C = false;
        this.V = false;
    }

    private synchronized void a(String str, int i2, int i3) {
        if (this.J == null) {
            this.J = new ArrayList();
        }
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("TEXT", str);
            hashMap.put("TEXT_BG_COLOR", Integer.valueOf(i2));
            hashMap.put("TEXT_COLOR", Integer.valueOf(i3));
            for (int i4 = 0; i4 < this.J.size(); i4++) {
                if (str.equals(this.J.get(i4).get("TEXT"))) {
                    this.J.remove(i4);
                }
            }
            this.J.add(0, hashMap);
            if (this.J.size() > 2) {
                this.J.remove(this.J.size() - 1);
            }
        }
    }

    private synchronized void b(String str) {
        if (this.J != null && !TextUtils.isEmpty(str)) {
            for (int i2 = 0; i2 < this.J.size(); i2++) {
                if (str.equals(this.J.get(i2).get("TEXT"))) {
                    this.J.remove(i2);
                }
            }
        }
    }

    private synchronized void j() {
        if (this.J != null && this.J.size() > 0) {
            this.J.clear();
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2, int i3) {
        OppoTextView oppoTextView;
        if (this.E && (oppoTextView = this.I) != null) {
            oppoTextView.setBackgroundResource(i2);
            this.I.setTextColor(getResources().getColor(i3));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(boolean r10) {
        /*
            r9 = this;
            boolean r0 = r9.Q
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r9)
            java.util.List<java.util.HashMap> r0 = r9.J     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x0062
            java.util.List<java.util.HashMap> r0 = r9.J     // Catch:{ all -> 0x0064 }
            int r0 = r0.size()     // Catch:{ all -> 0x0064 }
            if (r0 <= 0) goto L_0x0062
            java.util.List<java.util.HashMap> r0 = r9.J     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = "CameraScreenHintView"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r2.<init>()     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "showRecentCameraScreenHintText, "
            r2.append(r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r3 = "TEXT"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0064 }
            r2.append(r3)     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0064 }
            com.oppo.camera.e.a(r1, r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = "TEXT"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0064 }
            r4 = 1
            r5 = 0
            java.lang.String r1 = "TEXT_BG_COLOR"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0064 }
            int r6 = r1.intValue()     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = "TEXT_COLOR"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0064 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0064 }
            int r7 = r0.intValue()     // Catch:{ all -> 0x0064 }
            r2 = r9
            r8 = r10
            r2.a((java.lang.String) r3, (boolean) r4, (boolean) r5, (int) r6, (int) r7, (boolean) r8)     // Catch:{ all -> 0x0064 }
            r10 = 1
            monitor-exit(r9)     // Catch:{ all -> 0x0064 }
            return r10
        L_0x0062:
            monitor-exit(r9)     // Catch:{ all -> 0x0064 }
            return r1
        L_0x0064:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0064 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.CameraScreenHintView.a(boolean):boolean");
    }

    public void a(String str, boolean z2, boolean z3) {
        a(str, z2, z3, (int) R.drawable.screen_hint_textview_bg, (int) R.color.screen_hint_text_color);
    }

    public void a(String str, boolean z2, boolean z3, int i2, boolean z4, boolean z5) {
        a(str, z2, z3, R.drawable.screen_hint_textview_bg, R.color.screen_hint_text_color, ApsAdapterConstant.LOG_INTERVAL, z4, z5);
    }

    public void a(String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        a(str, z2, z3, 0, R.color.screen_hint_text_color, ApsAdapterConstant.LOG_INTERVAL, z4, z5);
    }

    public void a(String str, boolean z2, boolean z3, int i2, int i3) {
        a(str, z2, z3, i2, i3, ApsAdapterConstant.LOG_INTERVAL, false, false);
    }

    public void a(String str, boolean z2, boolean z3, int i2, int i3, boolean z4) {
        a(str, z2, z3, i2, i3, ApsAdapterConstant.LOG_INTERVAL, false, z4);
    }

    public void a(String str, boolean z2, boolean z3, int i2, int i3, int i4, boolean z4) {
        a(str, z2, z3, i2, i3, i4, z4, false);
    }

    private void a(String str, boolean z2, boolean z3, int i2, int i3, int i4, boolean z4, boolean z5) {
        e.b("CameraScreenHintView", "showCameraScreenHintText, hintText: " + str + ", mCurOrientation: " + this.g + ", showAlways: " + z2 + ", hideAuto: " + z3 + ", bgDrawable: " + i2 + ", color: " + i3 + ", hideAutoTime: " + i4 + ", showRecordCenter: " + z4 + ", showFullScreen: " + z5);
        boolean z6 = !TextUtils.isEmpty(str) && str.equals(getResources().getString(R.string.camera_toast_LDAF));
        if (this.Q) {
            return;
        }
        if (!this.B || !z6) {
            this.S = z5;
            if (!this.T) {
                this.R = z4;
            }
            if (this.I != null && !TextUtils.isEmpty(str)) {
                b(i2, i3);
                RotateImageView rotateImageView = this.H;
                if (rotateImageView != null) {
                    rotateImageView.setVisibility(8);
                }
                this.aa.removeMessages(1);
                if (z2) {
                    a(str, i2, i3);
                }
                setOrientation(getSupportRotaeScreen() ? this.g : 0);
                boolean z7 = !str.equals(this.I.getText().toString());
                if (z6) {
                    this.U = true;
                    this.V = true;
                }
                if (i2 == 0) {
                    this.I.setShadowLayer(4.0f, 0.0f, 0.0f, getResources().getColor(R.color.color_black_with_70_percent_transparency));
                } else {
                    this.I.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                setHintTextViewVisible(0);
                this.I.setText(str);
                if (z7 || this.W) {
                    this.W = false;
                    this.I.setAlpha(0.0f);
                    this.L.a(0);
                }
                if (!z2 && z3) {
                    this.aa.removeMessages(1);
                    this.aa.sendEmptyMessageDelayed(1, (long) i4);
                }
                if (z7 || this.A) {
                    m();
                    this.aa.sendEmptyMessage(3);
                }
            }
        }
    }

    public void a(String str) {
        OppoTextView oppoTextView;
        if (!TextUtils.isEmpty(str) && (oppoTextView = this.I) != null) {
            boolean equals = str.equals(oppoTextView.getText().toString());
            b(str);
            if (equals) {
                this.W = equals;
                this.aa.removeMessages(1);
                this.aa.sendEmptyMessage(1);
            }
        }
    }

    public void a(int i2) {
        a(getResources().getString(i2));
    }

    public void a(List<String> list, long j2) {
        if (!this.K.isEmpty()) {
            this.K.clear();
        }
        this.K.addAll(list);
        this.z = j2;
        k();
    }

    /* access modifiers changed from: private */
    public void k() {
        this.y = (this.y + 1) % this.K.size();
        a(this.K.get(this.y), true, false);
        this.aa.sendEmptyMessageDelayed(5, this.z);
    }

    /* access modifiers changed from: private */
    public void l() {
        a(this.K.get(this.y));
        this.aa.sendEmptyMessageDelayed(4, 3000);
    }

    public void c() {
        if (this.K != null) {
            e.a("CameraScreenHintView", "hideLooperCameraScreenHintText");
            this.aa.removeMessages(4);
            this.aa.removeMessages(5);
            c(false);
            this.K.clear();
            this.y = -1;
            this.z = 0;
        }
    }

    public void a(int i2, boolean z2, boolean z3, int i3, boolean z4) {
        OppoTextView oppoTextView;
        RotateImageView rotateImageView;
        e.b("CameraScreenHintView", "showCameraScreenHintImage, lowPriority: " + z2 + ", hideAuto: " + z3 + ", hideAutoTime: " + i3);
        if (!this.Q) {
            if ((this.o != i2 || (rotateImageView = this.H) == null || rotateImageView.getVisibility() != 0) && -1 != i2) {
                this.S = z4;
                if (!this.T) {
                    this.R = false;
                }
                this.o = i2;
                if (this.H != null) {
                    if (this.G) {
                        c.INS.registerInverse(getContext(), this.H);
                    }
                    this.H.setImageResource(i2);
                    setOrientation(getSupportRotaeScreen() ? this.g : 0);
                    Drawable a2 = androidx.core.content.a.a(getContext(), i2);
                    this.m = a2.getIntrinsicHeight();
                    this.n = a2.getIntrinsicWidth();
                    this.A = true;
                    if (!z2 || !this.aa.hasMessages(1) || (oppoTextView = this.I) == null || oppoTextView.getVisibility() != 0) {
                        if (this.I != null) {
                            setHintTextViewVisible(8);
                        }
                        this.H.setVisibility(0);
                        this.H.setAlpha(0.0f);
                        this.L.a(1);
                        if (z3) {
                            this.aa.removeMessages(2);
                            this.aa.sendEmptyMessageDelayed(2, (long) i3);
                        }
                        m();
                        d();
                        return;
                    }
                    e.a("CameraScreenHintView", "showCameraScreenHintImage, lowPriority, so wait text hint hide.");
                }
            }
        }
    }

    public void a(int i2, boolean z2, boolean z3) {
        a(i2, z2, false, (int) ApsAdapterConstant.LOG_INTERVAL, z3);
    }

    public void b(boolean z2) {
        RotateImageView rotateImageView = this.H;
        if (rotateImageView != null && this.A) {
            this.A = false;
            this.o = -1;
            if (!z2) {
                rotateImageView.setVisibility(8);
            } else if (rotateImageView.getVisibility() == 0) {
                this.L.a(3);
            }
            synchronized (this) {
                if (this.J != null && this.J.size() > 0) {
                    b(((Integer) this.J.get(0).get("TEXT_BG_COLOR")).intValue(), ((Integer) this.J.get(0).get("TEXT_COLOR")).intValue());
                    this.I.setText((String) this.J.get(0).get("TEXT"));
                    setHintTextViewVisible(0);
                    this.I.setAlpha(0.0f);
                    this.L.a(0);
                    d();
                }
            }
        }
    }

    public void c(boolean z2) {
        a(z2, true);
    }

    public void a(boolean z2, boolean z3) {
        OppoTextView oppoTextView = this.I;
        if (oppoTextView == null || oppoTextView.getVisibility() != 8) {
            this.A = false;
            OppoTextView oppoTextView2 = this.I;
            if (oppoTextView2 != null) {
                if (z2) {
                    this.L.a(4);
                } else {
                    oppoTextView2.clearAnimation();
                    this.B = false;
                    setHintTextViewVisible(8);
                }
            }
            if (z3) {
                j();
            }
        }
    }

    public void a(int i2, int i3, int i4, boolean z2) {
        this.k = i2;
        this.j = i3;
        this.l = i4;
        this.D = z2;
        d();
    }

    public void a(int i2, int i3) {
        this.l = i2;
        this.k = i3;
        d();
    }

    public void setRecordTimeWidth(int i2) {
        this.w = i2;
        d();
    }

    /* access modifiers changed from: private */
    public void m() {
        OppoTextView oppoTextView = this.I;
        if (oppoTextView != null) {
            oppoTextView.measure(Util.E(), f3782a);
        }
        RotateImageView rotateImageView = this.H;
        if (rotateImageView != null) {
            rotateImageView.measure(Util.E(), f3782a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        r0 = r3.m;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getChildMeasureWidth() {
        /*
            r3 = this;
            int r0 = r3.f
            r1 = 90
            r2 = 0
            if (r0 == r1) goto L_0x002a
            r1 = 270(0x10e, float:3.78E-43)
            if (r0 == r1) goto L_0x002a
            com.oppo.camera.ui.menu.OppoTextView r0 = r3.I
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x001c
            com.oppo.camera.ui.menu.OppoTextView r0 = r3.I
            int r0 = r0.getViewWidth()
            int r2 = r2 + r0
        L_0x001c:
            com.oppo.camera.ui.RotateImageView r0 = r3.H
            if (r0 == 0) goto L_0x0053
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0053
            int r0 = r3.n
            int r2 = r2 + r0
            goto L_0x0053
        L_0x002a:
            com.oppo.camera.ui.menu.OppoTextView r0 = r3.I
            if (r0 == 0) goto L_0x0043
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0043
            com.oppo.camera.ui.menu.OppoTextView r0 = r3.I
            int r0 = r0.getViewWidth()
            if (r0 >= 0) goto L_0x003d
            goto L_0x0043
        L_0x003d:
            com.oppo.camera.ui.menu.OppoTextView r0 = r3.I
            int r2 = r0.getViewWidth()
        L_0x0043:
            com.oppo.camera.ui.RotateImageView r0 = r3.H
            if (r0 == 0) goto L_0x0053
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0053
            int r0 = r3.m
            if (r2 <= r0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r2 = r0
        L_0x0053:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.CameraScreenHintView.getChildMeasureWidth():int");
    }

    private int getChildMeasureHeight() {
        int i2;
        int i3 = this.f;
        int i4 = 0;
        if (i3 == 90 || i3 == 270) {
            OppoTextView oppoTextView = this.I;
            if (oppoTextView != null && oppoTextView.a()) {
                i4 = 0 + this.I.getViewHeight();
            }
            RotateImageView rotateImageView = this.H;
            return (rotateImageView == null || rotateImageView.getVisibility() != 0) ? i4 : i4 + this.n;
        }
        OppoTextView oppoTextView2 = this.I;
        if (oppoTextView2 != null && oppoTextView2.a() && this.I.getViewHeight() >= 0) {
            i4 = this.I.getViewHeight();
        }
        RotateImageView rotateImageView2 = this.H;
        if (rotateImageView2 == null || rotateImageView2.getVisibility() != 0 || i4 > (i2 = this.m)) {
            return i4;
        }
        return i2;
    }

    public int getViewGap() {
        return this.h;
    }

    public void setOrientation(int i2) {
        this.g = i2;
        boolean supportRotaeScreen = getSupportRotaeScreen();
        if (!getSupportRotaeScreen() && this.f != 0) {
            supportRotaeScreen = true;
            i2 = 0;
        }
        if (supportRotaeScreen) {
            if (this.M == null) {
                i();
            }
            if (i2 == -1) {
                i2 = 0;
            }
            if (i2 % 180 == 0) {
                i2 = 0;
            }
            l.a aVar = this.ab;
            if (aVar != null && aVar.a() && getSupportRotaeScreen() && !this.M.b() && this.M.a() != i2) {
                startAnimation(this.M);
            }
            this.M.a(i2, getSupportRotaeScreen());
        }
    }

    public int getCurrentOrientation() {
        return this.g;
    }

    public void setSupportRotateScreen(int i2) {
        this.e = i2 & 3;
    }

    public boolean getSupportRotaeScreen() {
        return (this.e & 3) == 1;
    }

    public void d() {
        int i2;
        RotateImageView rotateImageView;
        int childMeasureWidth = getChildMeasureWidth();
        int childMeasureHeight = getChildMeasureHeight();
        Size size = this.P;
        int b2 = size != null ? Util.b(size.getWidth(), this.P.getHeight()) : 0;
        e.a("CameraScreenHintView", "refreshLayout, width: " + childMeasureWidth + ", height: " + childMeasureHeight + ", mOrientation: " + this.f + ", sizeType: " + b2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(childMeasureWidth, childMeasureHeight);
        e();
        if (b2 == 1) {
            i2 = this.q;
        } else if (b2 == 2) {
            i2 = this.r;
        } else if (b2 != 5) {
            i2 = f3782a;
        } else {
            i2 = this.s;
        }
        if (this.S) {
            i2 = Util.C();
        }
        OppoTextView oppoTextView = this.I;
        if (oppoTextView != null && !this.B) {
            oppoTextView.setMaxWidth(this.R ? this.v : getUpHintMaxWidth());
        }
        int i3 = this.f;
        if (i3 == 90) {
            layoutParams.addRule(10);
            if (this.D) {
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.h + this.l;
                if (2 == b2) {
                    layoutParams.topMargin = ((i2 - childMeasureHeight) / 2) + d + Util.t();
                } else if (5 == b2) {
                    layoutParams.topMargin = (i2 - childMeasureHeight) / 2;
                } else {
                    layoutParams.topMargin = ((i2 - childMeasureHeight) / 2) + d;
                }
            } else {
                layoutParams.addRule(9);
                layoutParams.leftMargin = this.h + this.l;
                if (this.S) {
                    layoutParams.topMargin = (i2 - childMeasureHeight) / 2;
                } else {
                    layoutParams.topMargin = (((f3782a - childMeasureHeight) + this.p) / 2) + d;
                }
            }
        } else if (i3 == 270) {
            layoutParams.addRule(10);
            if (this.D) {
                layoutParams.addRule(9);
                layoutParams.leftMargin = this.h + this.l;
                if (2 == b2) {
                    layoutParams.topMargin = ((i2 - childMeasureHeight) / 2) + Util.t();
                } else if (5 == b2) {
                    layoutParams.topMargin = (i2 - childMeasureHeight) / 2;
                } else {
                    layoutParams.topMargin = ((i2 - childMeasureHeight) / 2) + d;
                }
            } else {
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.h + this.l;
                if (!this.S) {
                    layoutParams.topMargin = (((f3782a - childMeasureHeight) - this.p) / 2) + d;
                } else if (this.w == 0) {
                    layoutParams.topMargin = ((i2 - childMeasureHeight) / 2) + this.k;
                } else {
                    layoutParams.topMargin = (((i2 - childMeasureHeight) / 2) - (childMeasureHeight / 2)) - this.x;
                }
            }
        } else if (this.D) {
            layoutParams.addRule(12);
            layoutParams.addRule(14);
            layoutParams.bottomMargin = this.h + this.j;
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            if (!this.A || (rotateImageView = this.H) == null || rotateImageView.getVisibility() != 0) {
                layoutParams.topMargin = c + this.h + this.k;
            } else {
                layoutParams.topMargin = f3783b + this.h + this.k;
            }
            layoutParams.rightMargin = ((Util.E() - childMeasureWidth) + this.p) / 2;
        }
        setLayoutParams(layoutParams);
    }

    private int getUpHintMaxWidth() {
        a aVar = this.O;
        if (aVar == null || !aVar.a()) {
            return this.t;
        }
        return this.u;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = this.f;
        int i9 = 0;
        if (i8 == 90) {
            OppoTextView oppoTextView = this.I;
            if (oppoTextView != null && oppoTextView.a()) {
                int measuredWidth = (i6 - this.I.getMeasuredWidth()) / 2;
                RotateImageView rotateImageView = this.H;
                if (rotateImageView == null || rotateImageView.getVisibility() != 0) {
                    i9 = 0 + ((i7 - this.I.getMeasuredHeight()) / 2);
                }
                OppoTextView oppoTextView2 = this.I;
                oppoTextView2.layout(measuredWidth, i9, oppoTextView2.getMeasuredWidth() + measuredWidth, this.I.getMeasuredHeight() + i9);
                i9 += this.I.getMeasuredHeight();
            }
            RotateImageView rotateImageView2 = this.H;
            if (rotateImageView2 != null && rotateImageView2.getVisibility() == 0) {
                int i10 = (i6 - this.m) / 2;
                int i11 = i9 + (((i7 - i9) - this.n) / 2);
                RotateImageView rotateImageView3 = this.H;
                rotateImageView3.layout(i10, i11, rotateImageView3.getMeasuredWidth() + i10, this.H.getMeasuredHeight() + i11);
                this.H.layout(i10, i11, this.m + i10, this.n + i11);
            }
        } else if (i8 != 270) {
            RotateImageView rotateImageView4 = this.H;
            if (rotateImageView4 != null && rotateImageView4.getVisibility() == 0) {
                int i12 = (i7 - this.m) / 2;
                OppoTextView oppoTextView3 = this.I;
                if (oppoTextView3 == null || !oppoTextView3.a()) {
                    i9 = (i6 - this.n) / 2;
                }
                this.H.layout(i9, i12, this.n + i9, this.m + i12);
                i9 += this.n;
            }
            OppoTextView oppoTextView4 = this.I;
            if (oppoTextView4 != null && oppoTextView4.a()) {
                int measuredHeight = (i7 - this.I.getMeasuredHeight()) / 2;
                int measuredWidth2 = i9 + (((i6 - i9) - this.I.getMeasuredWidth()) / 2);
                OppoTextView oppoTextView5 = this.I;
                oppoTextView5.layout(measuredWidth2, measuredHeight, oppoTextView5.getMeasuredWidth() + measuredWidth2, this.I.getMeasuredHeight() + measuredHeight);
            }
        } else {
            RotateImageView rotateImageView5 = this.H;
            if (rotateImageView5 != null && rotateImageView5.getVisibility() == 0) {
                int i13 = (i6 - this.m) / 2;
                OppoTextView oppoTextView6 = this.I;
                if (oppoTextView6 == null || !oppoTextView6.a()) {
                    i9 = 0 + (((i7 + 0) - this.n) / 2);
                } else {
                    i13 = 0;
                }
                this.H.layout(i13, i9, this.m + i13, this.n + i9);
                i9 += this.n;
            }
            OppoTextView oppoTextView7 = this.I;
            if (oppoTextView7 != null && oppoTextView7.a()) {
                int measuredWidth3 = (i6 - this.I.getMeasuredWidth()) / 2;
                int measuredHeight2 = i9 + (((i7 - i9) - this.I.getMeasuredHeight()) / 2);
                OppoTextView oppoTextView8 = this.I;
                oppoTextView8.layout(measuredWidth3, measuredHeight2, oppoTextView8.getMeasuredWidth() + measuredWidth3, this.I.getMeasuredHeight() + measuredHeight2);
            }
        }
    }

    public void b(int i2) {
        if (i2 != this.p) {
            this.p = i2;
            d();
        }
    }

    private class a extends Animation implements Animation.AnimationListener {

        /* renamed from: b  reason: collision with root package name */
        private float f3787b = 1.0f;
        private float c = 0.0f;
        private float d = 1.2f;
        private float e = 1.0f;
        private int f = 0;
        private int g = 0;
        private int h = 0;

        public void onAnimationRepeat(Animation animation) {
        }

        public a() {
            setAnimationListener(this);
            boolean unused = CameraScreenHintView.this.B = false;
        }

        public void a(int i) {
            e.a("CameraScreenHintView", "startScreenAnimation, animationType: " + i + ", mbAnimationRunning: " + CameraScreenHintView.this.B);
            if (i == 0) {
                int i2 = this.h;
                if (i2 == 1 || i2 == 3) {
                    if (CameraScreenHintView.this.H != null) {
                        CameraScreenHintView.this.H.clearAnimation();
                        CameraScreenHintView.this.H.setVisibility(8);
                    }
                    boolean unused = CameraScreenHintView.this.B = false;
                }
                a(80, 330);
                setInterpolator(CameraScreenHintView.this.getContext(), R.anim.hint_view_show_alpha_path_interpolator);
                this.c = 0.0f;
                this.f3787b = 1.0f;
            } else if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        a(0, 300);
                        this.c = 1.0f;
                        this.f3787b = 0.0f;
                    } else if (i != 4) {
                        a(0, 300);
                    }
                }
                a(0, 160);
                setInterpolator(CameraScreenHintView.this.getContext(), R.anim.alpha_path_interpolator);
                this.c = 1.0f;
                this.f3787b = 0.0f;
            } else {
                int i3 = this.h;
                if (i3 == 0 || i3 == 2) {
                    if (CameraScreenHintView.this.I != null) {
                        CameraScreenHintView.this.I.clearAnimation();
                        CameraScreenHintView.this.setHintTextViewVisible(8);
                    }
                    boolean unused2 = CameraScreenHintView.this.B = false;
                }
                a(0, 300);
                this.c = 0.0f;
                this.f3787b = 1.0f;
            }
            this.h = i;
            if (!CameraScreenHintView.this.B || CameraScreenHintView.this.C) {
                CameraScreenHintView cameraScreenHintView = CameraScreenHintView.this;
                boolean unused3 = cameraScreenHintView.B = !cameraScreenHintView.C;
                int i4 = this.h;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                if (CameraScreenHintView.this.C) {
                                    if (CameraScreenHintView.this.I != null) {
                                        CameraScreenHintView.this.setHintTextViewVisible(8);
                                        CameraScreenHintView.this.I.setAlpha(1.0f);
                                    }
                                    if (CameraScreenHintView.this.H != null) {
                                        CameraScreenHintView.this.H.setVisibility(8);
                                        CameraScreenHintView.this.H.setAlpha(1.0f);
                                        return;
                                    }
                                    return;
                                } else if (CameraScreenHintView.this.I != null) {
                                    CameraScreenHintView.this.I.clearAnimation();
                                    CameraScreenHintView.this.I.startAnimation(CameraScreenHintView.this.L);
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                    if (CameraScreenHintView.this.H == null) {
                        return;
                    }
                    if (CameraScreenHintView.this.C) {
                        CameraScreenHintView.this.H.setAlpha(this.f3787b);
                        return;
                    }
                    CameraScreenHintView.this.H.clearAnimation();
                    CameraScreenHintView.this.H.startAnimation(CameraScreenHintView.this.L);
                    return;
                }
                if (CameraScreenHintView.this.I == null) {
                    return;
                }
                if (CameraScreenHintView.this.C) {
                    CameraScreenHintView.this.setHintTextViewVisible(8);
                    CameraScreenHintView.this.I.setAlpha(1.0f);
                    return;
                }
                CameraScreenHintView.this.I.clearAnimation();
                CameraScreenHintView.this.I.startAnimation(CameraScreenHintView.this.L);
            }
        }

        private void a(int i, int i2) {
            setStartOffset((long) i);
            setDuration((long) i2);
        }

        private void a(float f2, Transformation transformation) {
            float scaleFactor = getScaleFactor();
            float f3 = this.d;
            float f4 = f3 + ((this.e - f3) * f2);
            transformation.getMatrix().setScale(f4, f4, ((float) this.f) * scaleFactor, scaleFactor * ((float) this.g));
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f2, Transformation transformation) {
            if (!CameraScreenHintView.this.C) {
                float f3 = this.c;
                float f4 = f3 + ((this.f3787b - f3) * f2);
                int i = this.h;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    if (CameraScreenHintView.this.I != null) {
                                        CameraScreenHintView.this.I.setAlpha(f4);
                                    }
                                    if (CameraScreenHintView.this.H != null) {
                                        CameraScreenHintView.this.H.setAlpha(f4);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        } else if (CameraScreenHintView.this.I != null) {
                            CameraScreenHintView.this.I.setAlpha(f4);
                            return;
                        } else {
                            return;
                        }
                    }
                    if (CameraScreenHintView.this.H != null) {
                        CameraScreenHintView.this.H.setAlpha(f4);
                        return;
                    }
                    return;
                }
                a(f2, transformation);
                if (CameraScreenHintView.this.I != null) {
                    CameraScreenHintView.this.I.setAlpha(f4);
                }
            }
        }

        public void onAnimationEnd(Animation animation) {
            e.a("CameraScreenHintView", "onAnimationEnd(), mAnimationType: " + this.h);
            int i = this.h;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                if (CameraScreenHintView.this.I != null) {
                                    CameraScreenHintView.this.setHintTextViewVisible(8);
                                    CameraScreenHintView.this.I.setAlpha(1.0f);
                                }
                                if (CameraScreenHintView.this.H != null) {
                                    CameraScreenHintView.this.H.setVisibility(8);
                                    CameraScreenHintView.this.H.setAlpha(1.0f);
                                }
                            }
                        } else if (CameraScreenHintView.this.H != null) {
                            CameraScreenHintView.this.H.setVisibility(8);
                            CameraScreenHintView.this.H.setAlpha(1.0f);
                        }
                    } else if (CameraScreenHintView.this.I != null) {
                        CameraScreenHintView.this.setHintTextViewVisible(8);
                        CameraScreenHintView.this.I.setAlpha(1.0f);
                    }
                } else if (CameraScreenHintView.this.H != null) {
                    CameraScreenHintView.this.H.setAlpha(this.f3787b);
                }
            } else if (CameraScreenHintView.this.I != null) {
                CameraScreenHintView.this.I.setAlpha(this.f3787b);
            }
            boolean unused = CameraScreenHintView.this.B = false;
        }

        public void onAnimationStart(Animation animation) {
            e.a("CameraScreenHintView", "onAnimationStart(), mbActivityPause: " + CameraScreenHintView.this.C);
            if (!CameraScreenHintView.this.C) {
                boolean unused = CameraScreenHintView.this.B = true;
                int i = this.h;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    if (CameraScreenHintView.this.I != null) {
                                        CameraScreenHintView.this.I.setAlpha(this.c);
                                    }
                                    if (CameraScreenHintView.this.H != null) {
                                        CameraScreenHintView.this.H.setAlpha(this.c);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                        } else if (CameraScreenHintView.this.I != null) {
                            CameraScreenHintView.this.I.setAlpha(this.c);
                            return;
                        } else {
                            return;
                        }
                    }
                    if (CameraScreenHintView.this.H != null) {
                        CameraScreenHintView.this.H.setAlpha(this.c);
                    }
                } else if (CameraScreenHintView.this.I != null) {
                    this.f = CameraScreenHintView.this.I.getViewWidth() / 2;
                    this.g = CameraScreenHintView.this.I.getViewHeight() / 2;
                    CameraScreenHintView.this.I.setAlpha(this.c);
                }
            }
        }
    }

    public void e() {
        if (this.N != null && this.I.a()) {
            this.p = 0;
        }
    }

    public void setCameraScreenHintListener(b bVar) {
        this.N = bVar;
    }

    public void setCameraScreenHintInterface(a aVar) {
        this.O = aVar;
    }

    /* access modifiers changed from: private */
    public void setHintTextViewVisible(int i2) {
        e.a("CameraScreenHintView", "setHintTextViewVisible, visibile: " + i2);
        b bVar = this.N;
        if (bVar != null) {
            if (i2 == 0) {
                bVar.b(0);
            } else {
                bVar.b(8);
            }
        }
        if (i2 != 0) {
            this.I.setText((CharSequence) null);
        }
        this.I.setVisibility(i2);
    }

    public String getHintTextViewString() {
        OppoTextView oppoTextView = this.I;
        return (oppoTextView == null || !oppoTextView.a()) ? "" : this.I.getText().toString();
    }

    public int getHintIconViewResId() {
        RotateImageView rotateImageView = this.H;
        if (rotateImageView == null || rotateImageView.getVisibility() != 0) {
            return 0;
        }
        return this.o;
    }

    public int getMarginTop() {
        return this.h + this.k;
    }

    public int getMarginLeft() {
        return this.h + this.l;
    }

    public boolean isShown() {
        if (!super.isShown()) {
            return false;
        }
        if (this.I.isShown() || this.H.isShown()) {
            return true;
        }
        return false;
    }

    public void setMoreMode(boolean z2) {
        this.Q = z2;
    }

    public boolean f() {
        return this.H.getVisibility() == 0 || this.I.getVisibility() == 0 || this.A;
    }

    public boolean g() {
        return this.A;
    }

    public boolean h() {
        return this.U;
    }

    public void setLDAFShowed(boolean z2) {
        this.V = z2;
    }

    public void setShowRecorderCenter(boolean z2) {
        this.R = z2;
    }

    public void setShowRecorderCenterAlways(boolean z2) {
        this.T = z2;
    }

    public void setChangeHintTextShadow(boolean z2) {
        this.F = z2;
    }

    public void setIsGestureHintNeedInverse(boolean z2) {
        this.G = z2;
    }
}
