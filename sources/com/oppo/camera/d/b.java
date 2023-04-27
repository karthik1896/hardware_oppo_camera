package com.oppo.camera.d;

import android.app.Activity;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Handler;
import android.os.Message;
import android.util.Size;
import com.oppo.camera.e;
import com.oppo.camera.f.c;
import com.oppo.camera.f.f;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.ui.beauty3d.g;
import com.oppo.camera.ui.preview.a.j;
import com.oppo.camera.util.Util;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: Beauty3DManager */
public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f2789a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile int f2790b = 0;
    private volatile boolean c = false;
    /* access modifiers changed from: private */
    public boolean d = false;
    private int e = 0;
    private f f = null;
    /* access modifiers changed from: private */
    public g g = null;
    /* access modifiers changed from: private */
    public d h = null;
    private c i = null;
    private int[] j = {1};
    private int[] k = {2};
    private int[] l = {3};
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private Handler q = new Handler() {
        public void handleMessage(Message message) {
            TotalCaptureResult totalCaptureResult = (TotalCaptureResult) message.obj;
            int i = message.what;
            if (i == 1) {
                b.this.c(totalCaptureResult);
            } else if (i == 2) {
                b.this.a(totalCaptureResult);
            } else if (i == 3) {
                b.this.a(totalCaptureResult);
                b.this.b(totalCaptureResult);
            }
        }
    };
    private g.a r = new g.a() {
        public void a() {
            if (b.this.h != null) {
                b.this.h.c();
            }
        }

        public void b() {
            if (b.this.f2790b != 1 && b.this.h != null) {
                b.this.a(false);
                b.this.a(1);
                b.this.h.d();
                b.c(b.this);
            }
        }

        public void c() {
            if (b.this.f2790b != 1 && b.this.h != null) {
                b.this.a(false);
                b.this.a(1);
                b.this.h.d();
            }
        }

        public void a(boolean z) {
            if (b.this.h != null) {
                b.this.a(false);
                b.this.h.a(z);
            }
        }

        public void d() {
            if (b.this.h != null) {
                b.this.a(0);
                b.this.a(false);
                b.this.h.b(false);
            }
        }

        public void e() {
            e.a("Beauty3DManager", "onEditSave");
            if (j.a(b.this.f2789a) == 0) {
                j.c(b.this.f2789a);
                b.e(b.this);
            }
            if (b.this.h != null) {
                b.this.a(0);
                b.this.a(false);
                b.this.h.b(true);
            }
        }

        public void f() {
            if (b.this.h != null) {
                b.this.h.c(false);
            }
        }

        public void a(String str, int[] iArr) {
            if ("com.oplus.beauty3d.mode".equals(str) && iArr != null && iArr[0] == 3) {
                b.this.a(10);
            } else if ("com.oplus.beauty3d.scan.state".equals(str) && iArr != null) {
                b.this.a(2);
            }
            if (iArr != null) {
                b.this.b(str, iArr);
            }
        }

        public void g() {
            b.this.a(8);
            b.this.a(false);
            if (b.this.h != null) {
                b.this.h.e();
            }
            b.f(b.this);
        }

        public void h() {
            b.this.o();
            if (b.this.h != null) {
                b.this.h.f();
            }
            b.g(b.this);
        }

        public void i() {
            b.this.a(6);
            b.this.a(false);
            if (b.this.h != null) {
                b.this.h.b();
            }
            boolean unused = b.this.d = false;
        }
    };

    static /* synthetic */ int c(b bVar) {
        int i2 = bVar.m;
        bVar.m = i2 + 1;
        return i2;
    }

    static /* synthetic */ int e(b bVar) {
        int i2 = bVar.n;
        bVar.n = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(b bVar) {
        int i2 = bVar.p;
        bVar.p = i2 + 1;
        return i2;
    }

    static /* synthetic */ int g(b bVar) {
        int i2 = bVar.o;
        bVar.o = i2 + 1;
        return i2;
    }

    public b(Activity activity, d dVar) {
        this.f2789a = activity;
        this.h = dVar;
        this.g = new g(activity);
        this.i = c.a();
        this.i.a(activity);
    }

    public void a() {
        this.g.a(this.r);
    }

    public void b() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.d();
        }
        c();
    }

    public void c() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.m;
        if (i2 > 0) {
            String format = CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SCAN_CLICK, String.valueOf(i2));
            this.m = 0;
            sb.append(format);
        }
        int i3 = this.n;
        if (i3 > 0) {
            String format2 = CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_SAVE_CLICK, String.valueOf(i3));
            this.n = 0;
            sb.append(format2);
        }
        int i4 = this.o;
        if (i4 > 0) {
            String format3 = CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_DELETE_CLICK, String.valueOf(i4));
            this.o = 0;
            sb.append(format3);
        }
        int i5 = this.p;
        if (i5 > 0) {
            String format4 = CameraStatisticsUtil.format(CameraStatisticsUtil.BEAUTY3D_START_EDIT_CLICK, String.valueOf(i5));
            this.p = 0;
            sb.append(format4);
        }
        if (sb.length() > 0) {
            CameraStatisticsUtil.onCommon(this.f2789a, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString(), false);
        }
    }

    public boolean d() {
        if (this.g == null) {
            return false;
        }
        a(false);
        return this.g.b(this.f2790b);
    }

    public void e() {
        HashMap<String, int[]> n2;
        if (this.h != null && (n2 = n()) != null) {
            for (String next : n2.keySet()) {
                int[] iArr = n2.get(next);
                if (iArr != null) {
                    a(next, iArr);
                }
            }
        }
    }

    public boolean a(String str, int[] iArr) {
        f fVar = this.f;
        if (fVar == null) {
            return false;
        }
        fVar.a(str, iArr);
        e.a("Beauty3DManager", "setBeauty3DParams, setParam, key: " + str + ", value: " + iArr[0]);
        return true;
    }

    public boolean b(String str, int[] iArr) {
        f fVar = this.f;
        if (fVar == null) {
            return false;
        }
        fVar.a(str, iArr);
        this.f.a((f.c) null);
        e.a("Beauty3DManager", "submitBeauty3DParams, setParam, key: " + str + ", value: " + iArr[0]);
        return true;
    }

    public void a(Size size) {
        this.c = false;
        if (this.f2790b == 3) {
            a(2);
        } else if (this.f2790b == 10) {
            g gVar = this.g;
            if (gVar == null || gVar.k() == 0) {
                a(8);
            } else {
                a(9);
            }
        }
        b(size);
    }

    public int a(CaptureResult captureResult) {
        if (!this.c) {
            this.q.removeCallbacksAndMessages((Object) null);
            return this.f2790b;
        }
        Message obtain = Message.obtain();
        obtain.obj = captureResult;
        int i2 = this.f2790b;
        if (i2 == 3) {
            this.q.removeMessages(1);
            obtain.what = 1;
            this.q.sendMessage(obtain);
        } else if (i2 == 7) {
            this.q.removeMessages(2);
            obtain.what = 2;
            this.q.sendMessage(obtain);
        } else if (i2 == 10) {
            this.q.removeMessages(3);
            obtain.what = 3;
            this.q.sendMessage(obtain);
        }
        return this.f2790b;
    }

    public void a(f fVar) {
        this.f = fVar;
        a(true);
        e.a("Beauty3DManager", "onBeauty3DSessionConfigured, enterBeauty3D Mode");
    }

    public void b(f fVar) {
        this.f = fVar;
        e.a("Beauty3DManager", "onBeauty3DCreateSession, enterBeauty3D Mode");
        if (this.f2790b == 6 || this.f2790b == 7) {
            a("com.oplus.beauty3d.mode", this.k);
            e();
        } else if (this.f2790b == 1) {
            a("com.oplus.beauty3d.mode", this.j);
            a("com.oplus.beauty3d.scan.state", new int[]{0});
        } else if (this.f2790b == 2) {
            a("com.oplus.beauty3d.mode", this.j);
            a("com.oplus.beauty3d.scan.state", new int[]{1});
        } else if (this.f2790b == 8 || this.f2790b == 9) {
            a("com.oplus.beauty3d.mode", this.l);
            if (this.f2790b == 8) {
                a("com.oplus.beauty3d.analyses.rotatedegree", new int[]{0});
                a("com.oplus.beauty3d.custom.position", new int[]{0, 0});
            } else if (this.f2790b == 9) {
                e();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(TotalCaptureResult totalCaptureResult) {
        Object a2 = c.a(totalCaptureResult, c.B);
        if (a2 != null && (a2 instanceof int[])) {
            int[] iArr = (int[]) a2;
            if (iArr.length == 6 && iArr[0] == 2) {
                c("com.oplus.beauty3d.analyses.result", Arrays.copyOfRange(iArr, 1, 6));
            }
        }
        Object a3 = c.a(totalCaptureResult, c.C);
        if (a3 != null && (a3 instanceof int[])) {
            int[] iArr2 = (int[]) a3;
            if (iArr2.length == 11 && iArr2[0] == 3) {
                c("com.oplus.beauty3d.analyses.ffd", Arrays.copyOfRange(iArr2, 1, 11));
            }
        }
    }

    public void b(CaptureResult captureResult) {
        if (this.f2790b == 2) {
            this.q.post(new Runnable() {
                public void run() {
                    b.this.a(3);
                    b.this.b(true);
                }
            });
        } else if (this.f2790b == 6) {
            this.q.post(new Runnable() {
                public void run() {
                    b.this.a(7);
                    b.this.d(true);
                }
            });
        } else if (this.f2790b == 8 || this.f2790b == 9) {
            this.q.post(new Runnable() {
                public void run() {
                    b.this.a(10);
                    b.this.d(true);
                }
            });
        }
        a(captureResult);
    }

    /* access modifiers changed from: private */
    public void b(TotalCaptureResult totalCaptureResult) {
        e.a("Beauty3DManager", "onBeauty3DEdit");
        Object a2 = c.a(totalCaptureResult, c.D);
        if (a2 != null && (a2 instanceof int[])) {
            int[] iArr = (int[]) a2;
            if (iArr.length == 2) {
                e.a("Beauty3DManager", "onBeauty3DEdit, styleResult.length: " + iArr.length);
                c("com.oplus.beauty3d.custom.result", iArr);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(TotalCaptureResult totalCaptureResult) {
        Object a2 = c.a(totalCaptureResult, c.E);
        if (a2 != null && (a2 instanceof int[])) {
            int[] iArr = (int[]) a2;
            if (iArr.length >= 2) {
                e.a("Beauty3DManager", "onBeautyScanResult, update hint: " + iArr[0]);
                int i2 = iArr[1];
                if (this.e != i2) {
                    this.e = i2;
                    b(i2);
                }
                int i3 = iArr[0];
                if (i3 == 0) {
                    e.a("Beauty3DManager", "onBeautyScanResult, BEAUTY3D_SCAN_SUCCESS");
                    int i4 = iArr[1];
                    e.a("Beauty3DManager", "onBeautyScanResult, update process: " + i4);
                    if (i4 == 100 && !this.d) {
                        b(100);
                        this.d = true;
                        this.q.removeMessages(1);
                        l();
                    }
                } else if (i3 == 1) {
                    int i5 = iArr[1];
                    e.a("Beauty3DManager", "onBeautyScanResult, update process: " + i5);
                    b(i5);
                } else if (i3 <= 19) {
                    c(i3);
                } else if (i3 >= 20) {
                    e.a("Beauty3DManager", "onBeautyScanResult, updateHintValue: " + i3);
                    a(false);
                    c(i3);
                    this.q.removeMessages(1);
                    this.q.postDelayed(new Runnable() {
                        public void run() {
                            b.this.c(false);
                            if (b.this.h != null) {
                                b.this.h.a();
                            }
                        }
                    }, 2000);
                }
            }
        }
    }

    public int f() {
        return this.f2790b;
    }

    public void a(int i2) {
        e.a("Beauty3DManager", "setBeauty3DState, mBeauty3DState: " + this.f2790b + " -> " + i2);
        this.f2790b = i2;
    }

    private void c(int i2) {
        Integer f2 = this.i.f(i2);
        if (f2 != null) {
            a(f2);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean g() {
        return this.c;
    }

    public void b(Size size) {
        e.a("Beauty3DManager", "onBeauty3DResume, beauty3dState: " + this.f2790b);
        if (this.g != null) {
            int i2 = 1;
            if (this.f2790b == 1) {
                d dVar = this.h;
                if (dVar != null) {
                    dVar.c(true);
                }
                this.g.a(0, false, Util.w(), Util.v());
                this.g.d(false);
            } else if (this.f2790b == 2) {
                d dVar2 = this.h;
                if (dVar2 != null) {
                    dVar2.c(true);
                }
                this.g.a(0, false);
                this.g.d(false);
            } else if (this.f2790b == 7 || this.f2790b == 9) {
                d dVar3 = this.h;
                if (dVar3 != null) {
                    dVar3.c(true);
                }
                if (this.f2790b == 7 && this.g.k() != 1) {
                    if (this.g.k() == 0) {
                        this.g.a();
                    }
                    a(1, size);
                }
                this.g.f();
            } else if (this.f2790b == 8 || this.f2790b == 6) {
                e.a("Beauty3DManager", "onBeauty3DResume, editUICurrentState: " + this.g.k());
                if (this.g.k() == 0) {
                    j();
                }
                if (this.f2790b == 8) {
                    i2 = 2;
                }
                a(i2, size);
                this.g.c(false);
            }
            if (this.f2790b != 0) {
                this.g.j();
            }
        }
    }

    public void h() {
        d dVar = this.h;
        if (dVar != null) {
            dVar.c(false);
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.a(0, false, Util.w(), Util.v());
        }
    }

    public void b(boolean z) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.c(false);
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.d(z);
        }
    }

    public void c(Size size) {
        g gVar = this.g;
        if (gVar != null && size != null) {
            gVar.b(Util.b(size.getWidth(), size.getHeight()), Util.a(size), Util.w(), Util.v());
        }
    }

    public boolean i() {
        g gVar = this.g;
        if (gVar != null) {
            return gVar.c();
        }
        return false;
    }

    public void j() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void k() {
        if (this.h != null) {
            a(false);
            a(1);
            this.h.d();
            this.m++;
        }
    }

    public void l() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.l();
        }
    }

    public void a(int i2, Size size) {
        g gVar = this.g;
        if (gVar != null && size != null) {
            gVar.a(i2, Util.b(size.getWidth(), size.getHeight()), Util.a(size));
        }
    }

    public void d(Size size) {
        g gVar = this.g;
        if (gVar != null && size != null) {
            gVar.c(Util.b(size.getWidth(), size.getHeight()), Util.a(size), Util.w(), Util.v());
        }
    }

    public void a(Integer num) {
        g gVar = this.g;
        if (gVar != null) {
            gVar.a(num);
        }
    }

    public void m() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.b();
        }
    }

    public void b(final int i2) {
        Activity activity = this.f2789a;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (b.this.g != null) {
                        b.this.g.a(i2);
                    }
                }
            });
        }
    }

    public void c(String str, int[] iArr) {
        g gVar = this.g;
        if (gVar != null) {
            gVar.a(str, iArr);
        }
    }

    public void c(boolean z) {
        g gVar = this.g;
        if (gVar != null) {
            gVar.b(z);
        }
    }

    public void d(boolean z) {
        d dVar = this.h;
        if (dVar != null) {
            dVar.c(false);
        }
        g gVar = this.g;
        if (gVar != null) {
            gVar.c(z);
        }
    }

    public HashMap<String, int[]> n() {
        g gVar = this.g;
        if (gVar != null) {
            return gVar.g();
        }
        return null;
    }

    public void o() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.h();
        }
    }

    public void p() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.i();
        }
    }

    public void e(boolean z) {
        g gVar = this.g;
        if (gVar != null) {
            gVar.e(z);
        }
    }

    public void q() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.j();
        }
    }

    public void r() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.e();
        }
        this.g = null;
        this.h = null;
        this.f2790b = 0;
    }
}
