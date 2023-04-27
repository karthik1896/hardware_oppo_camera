package com.oppo.camera.ui.menu.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import color.support.v7.app.b;
import com.oppo.camera.R;
import com.oppo.camera.aps.config.CameraConfig;
import com.oppo.camera.aps.config.ConfigDataBase;
import com.oppo.camera.e;
import com.oppo.camera.statistics.CameraStatisticsUtil;
import com.oppo.camera.statistics.model.DcsMsgData;
import com.oppo.camera.statistics.model.MenuClickMsgData;
import com.oppo.camera.ui.OppoNumAISeekBar;
import com.oppo.camera.ui.OppoNumSeekBar;
import com.oppo.camera.ui.f;
import com.oppo.camera.ui.menu.a.c;
import com.oppo.camera.util.Util;

/* compiled from: FaceBeautyMenu */
public class g implements View.OnClickListener, OppoNumSeekBar.a, c.b {
    private AnimatorSet A = null;
    private Animator.AnimatorListener B = new Animator.AnimatorListener() {
        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            if (g.this.m && 1 == g.this.d) {
                g.this.u.b().setVisibility(0);
                g.this.u.b().setAlpha(1.0f);
                g.this.u.g().setVisibility(0);
                g.this.u.g().setAlpha(1.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            if (!g.this.m) {
                g gVar = g.this;
                gVar.a(gVar.l());
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private int f4060a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f4061b = 0;
    private int c = 0;
    /* access modifiers changed from: private */
    public int d = 0;
    private int e;
    private int f = 0;
    private f g = null;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int[] l = {0, 0, 0, 0, 0, 0, 0, 0};
    /* access modifiers changed from: private */
    public boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private PathInterpolator p = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
    private PathInterpolator q = new PathInterpolator(0.35f, 0.62f, 0.2f, 1.0f);
    private PathInterpolator r = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
    private Activity s = null;
    /* access modifiers changed from: private */
    public a t = null;
    /* access modifiers changed from: private */
    public e u = null;
    private d v = null;
    /* access modifiers changed from: private */
    public b w = null;
    private AnimatorSet x = null;
    private AnimatorSet y = null;
    private AnimatorSet z = null;

    /* compiled from: FaceBeautyMenu */
    public interface a {
        int a(int i);

        void a();

        void a(int i, int i2, boolean z);

        void a(View view);

        int b();

        void b(int i);

        boolean c();

        int d();

        int[] e();
    }

    public void a(OppoNumSeekBar oppoNumSeekBar, int i2) {
    }

    static /* synthetic */ int e(g gVar) {
        int i2 = gVar.j;
        gVar.j = i2 + 1;
        return i2;
    }

    static /* synthetic */ int g(g gVar) {
        int i2 = gVar.i;
        gVar.i = i2 + 1;
        return i2;
    }

    public g(Activity activity, a aVar, int i2, f fVar) {
        this.s = activity;
        this.t = aVar;
        this.e = i2;
        this.g = fVar;
        Resources resources = activity.getApplicationContext().getResources();
        this.f4060a = resources.getDimensionPixelSize(R.dimen.face_beauty_menu_translate_x);
        this.f4061b = resources.getDimensionPixelSize(R.dimen.face_beauty_menu_translate_hide_x);
        this.c = resources.getDimensionPixelSize(R.dimen.face_beauty_menu_translate_y);
    }

    public int b() {
        return this.d;
    }

    public View a(int i2) {
        a l2;
        int i3 = this.d;
        this.d = i2;
        if (!(i3 == this.d || (l2 = l()) == null)) {
            l2.a();
        }
        int i4 = this.d;
        if (i4 == 1) {
            if (this.u == null) {
                this.u = new e(this.s, this, this, this);
            }
            return this.u.b();
        } else if (i4 != 2) {
            return null;
        } else {
            if (this.v == null) {
                this.v = new d(this.s, this);
            }
            return this.v.b();
        }
    }

    public ViewGroup.LayoutParams c() {
        int i2 = this.d;
        if (i2 == 1) {
            return this.u.f();
        }
        if (i2 != 2) {
            return null;
        }
        return this.v.c();
    }

    public void a(boolean z2) {
        e.a("FaceBeautyMenu", "setMenuOpen, menuOpen: " + z2);
        this.m = z2;
    }

    public void b(int i2) {
        e.a("FaceBeautyMenu", "setProperCameraId, cameraId: " + i2);
        this.f = i2;
    }

    public void b(boolean z2) {
        e.a("FaceBeautyMenu", "open, needAnim: " + z2);
        int i2 = this.d;
        if (i2 == 1) {
            e(z2);
        } else if (i2 == 2) {
            g(z2);
        }
    }

    public void c(boolean z2) {
        e.a("FaceBeautyMenu", "close, needAnim: " + z2);
        a((Animator) this.x);
        a((Animator) this.z);
        int i2 = this.d;
        if (i2 == 1) {
            f(z2);
        } else if (i2 == 2) {
            if (this.g.b() && this.t.b() == 0) {
                this.o = true;
            }
            h(z2);
        }
    }

    private void a(Animator animator) {
        if (animator != null && animator.isRunning()) {
            animator.cancel();
        }
    }

    public void a(int i2, boolean z2) {
        a l2;
        e.a("FaceBeautyMenu", "setVisibility, visibility: " + i2 + ", needAnim: " + z2);
        long j2 = 160;
        long j3 = i2 == 0 ? 160 : 0;
        if (i2 != 0) {
            j2 = 80;
        }
        long j4 = j2;
        if (this.m && (l2 = l()) != null) {
            if (z2) {
                Util.a(l2.b(), i2, (Animation.AnimationListener) null, j4, j3, (Interpolator) this.p);
            } else {
                l2.b().setVisibility(i2);
            }
        }
    }

    public void d(boolean z2) {
        this.o = z2;
    }

    public boolean d() {
        return this.o;
    }

    public void e() {
        e eVar;
        if (1 == this.d && (eVar = this.u) != null && this.n) {
            eVar.a(0, false);
        }
    }

    /* access modifiers changed from: private */
    public a l() {
        int i2 = this.d;
        if (i2 == 1) {
            return this.u;
        }
        if (i2 != 2) {
            return null;
        }
        return this.v;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0 = r1.A;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.y;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        r0 = r1.z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r1 = this;
            android.animation.AnimatorSet r0 = r1.x
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0028
        L_0x000a:
            android.animation.AnimatorSet r0 = r1.y
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0028
        L_0x0014:
            android.animation.AnimatorSet r0 = r1.z
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0028
        L_0x001e:
            android.animation.AnimatorSet r0 = r1.A
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x002a
        L_0x0028:
            r0 = 1
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.a.g.f():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g() {
        /*
            r1 = this;
            android.animation.AnimatorSet r0 = r1.x
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0014
        L_0x000a:
            android.animation.AnimatorSet r0 = r1.z
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.ui.menu.a.g.g():boolean");
    }

    public boolean h() {
        return this.m;
    }

    public void i() {
        q();
    }

    public void j() {
        b bVar = this.w;
        if (bVar != null) {
            bVar.cancel();
            this.w = null;
        }
    }

    public void onClick(View view) {
        if (f()) {
            e.d("FaceBeautyMenu", "onClick, isAnimationRunning");
        } else if (((OppoNumAISeekBar) this.u.h()).b()) {
            e.d("FaceBeautyMenu", "onClick, isThumbOnDragging so return");
        } else {
            switch (view.getId()) {
                case R.id.face_beauty_none:
                    e.a("FaceBeautyMenu", "onClick, close face beauty");
                    if (this.n) {
                        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_BEAUTY_FRONT_VIDEO)) {
                            this.t.a(view);
                        }
                        a(this.u.h(), false);
                        o();
                        this.u.a(false);
                        this.u.b(true);
                        this.u.a(-1, false);
                        this.u.c();
                    } else {
                        n();
                        c(this.u.h());
                        this.u.d();
                        this.u.b(p());
                        this.u.a(0, false);
                        this.u.a(this.t.a(0), this.t.e());
                    }
                    r();
                    return;
                case R.id.face_beauty_reset:
                    e.a("FaceBeautyMenu", "onClick, reset face beauty");
                    if (this.n && !p()) {
                        m();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void k() {
        b bVar = this.w;
        if (bVar == null || !bVar.isShowing()) {
            this.w = null;
            return;
        }
        this.w.cancel();
        this.w = null;
        m();
    }

    private void m() {
        if (this.w == null) {
            this.w = new b.a(this.s, 2131821193).setTitle((int) R.string.camera_face_beauty_menu_reset_alert).setPositiveButton((int) R.string.camera_face_beauty_menu_reset, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    g.this.u.a(-100000, g.this.t.e());
                    g.this.t.a();
                    g.this.u.b(true);
                    g.g(g.this);
                    b unused = g.this.w = null;
                    g.this.i(true);
                }
            }).setNegativeButton((int) R.string.camera_face_beauty_menu_cancle, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    g.e(g.this);
                    b unused = g.this.w = null;
                    g.this.i(false);
                }
            }).create();
            this.w.setCancelable(true);
            this.h++;
        }
        if (!this.w.isShowing()) {
            this.w.show();
        }
    }

    public void a(View view, int i2) {
        e.a("FaceBeautyMenu", "onItemClick, position: " + i2 + ", mMenuType: " + this.d);
        if (f()) {
            e.d("FaceBeautyMenu", "onItemClick, isAnimationRunning");
        } else if (((OppoNumAISeekBar) this.u.h()).b()) {
            e.d("FaceBeautyMenu", "onItemClick, isThumbOnDragging");
            ((OppoNumAISeekBar) this.u.h()).a();
        } else if (1 == this.d) {
            if (!this.n) {
                n();
                c(this.u.h());
                this.u.d();
                this.u.b(p());
            }
            this.u.a(i2, false);
            this.u.a(this.t.a(i2), this.t.e());
            int[] iArr = this.l;
            if (i2 < iArr.length) {
                iArr[i2] = iArr[i2] + 1;
            }
        }
    }

    public void a(OppoNumSeekBar oppoNumSeekBar, int i2, boolean z2) {
        int i3 = this.d;
        if (1 == i3) {
            if (this.u.e() >= 0) {
                this.t.a(this.u.e(), i2, false);
            }
        } else if (2 == i3) {
            this.t.a(0, i2, false);
            if (!this.n && i2 != 0) {
                n();
            } else if (this.n && i2 == 0) {
                o();
            }
        }
    }

    public void b(OppoNumSeekBar oppoNumSeekBar, int i2) {
        int i3 = this.d;
        if (1 == i3) {
            if (this.u.e() >= 0) {
                this.t.a(this.u.e(), i2, true);
            }
            this.u.b(p());
        } else if (2 == i3) {
            this.t.a(0, i2, true);
            if (this.n && i2 == 0) {
                o();
            } else if (!this.n && i2 != 0) {
                n();
            }
        }
    }

    public boolean a() {
        return this.t.c();
    }

    private void n() {
        this.t.b(102);
        this.n = true;
    }

    private void o() {
        this.t.b(0);
        this.n = false;
    }

    private void e(boolean z2) {
        this.n = this.t.b() != 0;
        if (this.n) {
            this.u.d();
            int e2 = this.u.e();
            if (e2 < 0) {
                e2 = 0;
            }
            this.u.a(e2, true);
            e eVar = this.u;
            eVar.a(this.t.a(eVar.e()), this.t.e());
            this.u.a(true);
            this.u.b(p());
        } else {
            this.u.a(-1, false);
            this.u.c();
            this.u.a(false);
            this.u.b(true);
        }
        if (z2) {
            a(this.u.g());
            c(this.u.h());
            return;
        }
        this.u.b().setAlpha(1.0f);
        this.u.g().setAlpha(1.0f);
        this.u.g().setTranslationX(0.0f);
        this.u.h().setEnabled(true);
    }

    private void f(boolean z2) {
        if (this.u != null) {
            b bVar = this.w;
            if (bVar != null && bVar.isShowing()) {
                this.w.cancel();
            }
            if (((OppoNumAISeekBar) this.u.h()).b()) {
                e.a("FaceBeautyMenu", "closeCustomBeautyMenu, isThumbOnDragging");
                ((OppoNumAISeekBar) this.u.h()).a();
            }
            if (z2) {
                b(this.u.g());
                if (this.n) {
                    a(this.u.h(), false);
                    return;
                }
                return;
            }
            a((a) this.u);
        }
    }

    private void g(boolean z2) {
        this.n = this.t.b() != 0;
        if (2 == this.d) {
            this.v.a(this.t.a(0), this.t.d());
        }
        if (z2) {
            c(this.v.b());
        }
        this.k++;
    }

    public void c(int i2) {
        d dVar;
        if (2 == this.d && (dVar = this.v) != null) {
            dVar.a(i2, this.t.d());
        }
    }

    private void h(boolean z2) {
        d dVar = this.v;
        if (dVar != null) {
            if (((OppoNumAISeekBar) dVar.b()).b()) {
                e.a("FaceBeautyMenu", "closeCommonBeautyMenu, isThumbOnDragging");
                ((OppoNumAISeekBar) this.v.b()).a();
            }
            if (z2) {
                a(this.v.b(), true);
            } else {
                a((a) this.v);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    private boolean p() {
        int i2 = 0;
        for (int i3 : this.t.e()) {
            int a2 = this.t.a(i2);
            if (a2 != i3 && a2 != -100000) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private void a(View view) {
        view.setVisibility(4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(this.p);
        ofFloat.setDuration(330);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) this.f4060a, 0.0f});
        ofFloat2.setInterpolator(this.q);
        ofFloat2.setDuration(330);
        ofFloat2.addListener(this.B);
        this.x = new AnimatorSet();
        this.x.play(ofFloat2).with(ofFloat);
        this.x.start();
    }

    private void b(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(this.p);
        ofFloat.setDuration(160);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, (float) this.f4061b});
        ofFloat2.setInterpolator(this.r);
        ofFloat2.setDuration(410);
        this.y = new AnimatorSet();
        this.y.play(ofFloat2).with(ofFloat);
        this.y.addListener(this.B);
        this.y.start();
    }

    private void c(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setInterpolator(this.p);
        ofFloat.setDuration(160);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) this.c, 0.0f});
        ofFloat2.setInterpolator(this.q);
        ofFloat2.setDuration(330);
        this.z = new AnimatorSet();
        this.z.play(ofFloat2).with(ofFloat);
        this.z.start();
        view.setEnabled(true);
    }

    private void a(View view, boolean z2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(this.p);
        ofFloat.setDuration(160);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, (float) this.c});
        ofFloat2.setInterpolator(this.r);
        ofFloat2.setDuration(330);
        this.A = new AnimatorSet();
        if (z2) {
            this.A.addListener(this.B);
        }
        this.A.play(ofFloat2).with(ofFloat);
        this.A.start();
        view.setEnabled(false);
    }

    private void q() {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            int[] iArr = this.l;
            if (i2 >= iArr.length) {
                break;
            }
            if (iArr[i2] > 0) {
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.CUSTOM_BEAUTY_CLICK_NUMS[i2], String.valueOf(this.l[i2])));
                this.l[i2] = 0;
            }
            i2++;
        }
        int i3 = this.h;
        if (i3 > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.FACE_BEAUTY_RESET_SHOW, String.valueOf(i3)));
            this.h = 0;
        }
        int i4 = this.i;
        if (i4 > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.FACE_BEAUTY_RESET_OK, String.valueOf(i4)));
            this.i = 0;
        }
        int i5 = this.j;
        if (i5 > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.FACE_BEAUTY_RESET_CANCEL, String.valueOf(i5)));
            this.j = 0;
        }
        int i6 = this.k;
        if (i6 > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.FACE_BEAUTY_COMMON_SHOW, String.valueOf(i6)));
            this.k = 0;
        }
        if (sb.length() > 0) {
            CameraStatisticsUtil.onCommon(this.s, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString(), false);
        }
    }

    /* access modifiers changed from: private */
    public void i(boolean z2) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.s);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 2;
        menuClickMsgData.mItem = MenuClickMsgData.KEY_RESET_SMOOTH;
        menuClickMsgData.mCameraEnterType = String.valueOf(this.e);
        menuClickMsgData.mCaptureMode = this.g.P();
        menuClickMsgData.mCameraId = this.g.v();
        if (z2) {
            menuClickMsgData.mItemValue = String.valueOf(0);
        } else {
            menuClickMsgData.mItemValue = String.valueOf(1);
        }
        menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.f) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    private void r() {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.s);
        menuClickMsgData.buildEvent(true);
        menuClickMsgData.mFuncKeyId = 2;
        menuClickMsgData.mItem = MenuClickMsgData.KEY_NONE_SMOOTH;
        menuClickMsgData.mCameraId = this.g.t();
        menuClickMsgData.mCameraEnterType = String.valueOf(this.e);
        menuClickMsgData.mCaptureMode = this.g.P();
        menuClickMsgData.mRearOrFront = com.oppo.camera.f.a.c(this.g.u()) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }
}
