package com.oppo.camera.ui.preview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.ui.preview.CameraTimeView;
import com.oppo.camera.util.Util;

/* compiled from: VideoRecordingTimeUI */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private Activity f4570a = null;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f4571b = null;
    private int c = 0;
    private boolean d = false;
    private boolean e = false;
    private int f = 0;
    /* access modifiers changed from: private */
    public CameraTimeView g = null;
    /* access modifiers changed from: private */
    public CameraTimeView h = null;
    private long i = 0;
    private long j = 0;
    private int k = 0;

    public v(Activity activity) {
        this.f4570a = activity;
        this.k = activity.getResources().getDimensionPixelSize(R.dimen.movie_time_margin_top);
    }

    private void e(boolean z) {
        this.f4571b = (RelativeLayout) this.f4570a.findViewById(R.id.camera);
        if (this.f4571b != null) {
            PreviewFrameLayout previewFrameLayout = (PreviewFrameLayout) this.f4570a.findViewById(R.id.frame_layout);
            int top = previewFrameLayout.getTop();
            int height = previewFrameLayout.getHeight();
            LayoutInflater layoutInflater = this.f4570a.getLayoutInflater();
            if (this.g == null) {
                this.g = (CameraTimeView) layoutInflater.inflate(R.layout.record_time, (ViewGroup) null);
                this.f4571b.addView(this.g);
                this.g.a(false, this.c, top, height, f(z));
            }
            if (this.d && this.h == null) {
                this.h = (CameraTimeView) layoutInflater.inflate(R.layout.record_time, (ViewGroup) null);
                this.f4571b.addView(this.h);
                this.g.measure(Util.E(), Util.E());
                this.h.a(this.d, this.c, top, height, (this.g.getMeasuredWidth() - this.g.getBlinkRecordIconWidth()) / 2);
                this.h.measure(Util.E(), Util.E());
                this.g.a((-this.h.getMeasuredWidth()) / 2);
                if (180 == this.f) {
                    this.g.a(this.h.getMeasuredWidth() / 2);
                    this.h.a((this.g.getBlinkRecordIconWidth() - this.g.getMeasuredWidth()) / 2);
                } else {
                    this.g.a((-this.h.getMeasuredWidth()) / 2);
                    this.h.a((this.g.getMeasuredWidth() - this.g.getBlinkRecordIconWidth()) / 2);
                }
                AnonymousClass1 r12 = new CameraTimeView.a() {
                    public void a(int i) {
                        if (v.this.h != null) {
                            v.this.h.a((i - v.this.g.getBlinkRecordIconWidth()) / 2);
                        }
                    }
                };
                AnonymousClass2 r0 = new CameraTimeView.a() {
                    public void a(int i) {
                        if (v.this.g != null) {
                            v.this.g.a((-i) / 2);
                        }
                    }
                };
                this.g.setCameraTimeListener(r12);
                this.h.setCameraTimeListener(r0);
            }
        }
    }

    private void k() {
        this.f4571b = (RelativeLayout) this.f4570a.findViewById(R.id.camera);
        if (this.f4571b != null) {
            CameraTimeView cameraTimeView = this.g;
            if (cameraTimeView != null) {
                cameraTimeView.a();
                this.f4571b.removeView(this.g);
                this.g = null;
            }
            CameraTimeView cameraTimeView2 = this.h;
            if (cameraTimeView2 != null) {
                cameraTimeView2.a();
                this.f4571b.removeView(this.h);
                this.h = null;
            }
        }
    }

    public void a(int i2, int i3, boolean z, boolean z2) {
        a(i2, i3, this.f, z, z2);
    }

    public void a(int i2, int i3, int i4, boolean z, boolean z2) {
        this.c = i2;
        this.d = z;
        this.f = i4;
        k();
        e(z2);
        CameraTimeView cameraTimeView = this.h;
        if (cameraTimeView != null) {
            cameraTimeView.a(i2, i3, i4, z2);
        }
        CameraTimeView cameraTimeView2 = this.g;
        if (cameraTimeView2 != null) {
            cameraTimeView2.a(i2, i3, i4, z2);
        }
        e.e("VideoRecordingTimeUI", "CameraTest Video Shutter Timing Start");
    }

    public void a() {
        this.i = 0;
        this.j = 0;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        CameraTimeView cameraTimeView = this.h;
        if (cameraTimeView != null) {
            cameraTimeView.a(z, z2);
        }
        CameraTimeView cameraTimeView2 = this.g;
        if (cameraTimeView2 != null) {
            cameraTimeView2.a(z, z2);
        }
    }

    public void a(int i2, int i3, boolean z) {
        this.f = i3;
        CameraTimeView cameraTimeView = this.g;
        if (cameraTimeView != null && cameraTimeView.getVisibility() == 0) {
            a(this.c, i2, this.d, z);
        }
        a(this.i, this.j, false);
    }

    public int b() {
        return this.f;
    }

    public void c() {
        e.a("VideoRecordingTimeUI", "onPause");
        CameraTimeView cameraTimeView = this.h;
        if (cameraTimeView != null) {
            cameraTimeView.clearAnimation();
            this.h.setVisibility(8);
        }
        CameraTimeView cameraTimeView2 = this.g;
        if (cameraTimeView2 != null) {
            cameraTimeView2.clearAnimation();
            this.g.setVisibility(8);
        }
        k();
    }

    public int d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public void b(boolean z) {
        CameraTimeView cameraTimeView = this.g;
        if (cameraTimeView != null) {
            cameraTimeView.a(z);
        }
    }

    public void f() {
        a(this.i, this.j, false);
    }

    public void a(long j2, long j3, boolean z, boolean z2, long j4) {
        this.i = j2;
        this.j = j3;
        CameraTimeView cameraTimeView = this.g;
        if (cameraTimeView != null) {
            if (!z2) {
                cameraTimeView.a(j2, z);
            } else {
                long j5 = j4 - j2;
                if (300 >= j5) {
                    j5 = 0;
                }
                cameraTimeView.a(j5, z, true);
            }
        }
        CameraTimeView cameraTimeView2 = this.h;
        if (cameraTimeView2 != null) {
            cameraTimeView2.a(j3, false);
        }
    }

    public void a(long j2, long j3, boolean z) {
        a(j2, j3, z, false, 0);
    }

    public boolean g() {
        CameraTimeView cameraTimeView = this.g;
        return cameraTimeView != null && cameraTimeView.b();
    }

    public void h() {
        this.f4570a = null;
    }

    public int i() {
        CameraTimeView cameraTimeView = this.g;
        if (cameraTimeView == null) {
            return 0;
        }
        cameraTimeView.measure(Util.E(), Util.E());
        return this.g.getMeasuredWidth();
    }

    public boolean j() {
        CameraTimeView cameraTimeView = this.g;
        return cameraTimeView != null && cameraTimeView.getVisibility() == 0;
    }

    public void c(boolean z) {
        this.g.a(f(z));
    }

    public void d(boolean z) {
        this.e = z;
    }

    private int f(boolean z) {
        if (this.f4570a == null) {
            return 0;
        }
        int i2 = (i() / 2) + this.k;
        if (this.e && z) {
            return i2;
        }
        CameraTimeView cameraTimeView = this.h;
        if (cameraTimeView == null || !this.d) {
            return 0;
        }
        if (180 == this.f) {
            return cameraTimeView.getMeasuredWidth() / 2;
        }
        return (-cameraTimeView.getMeasuredWidth()) / 2;
    }
}
