package com.oppo.camera.sticker.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.oppo.camera.R;
import com.oppo.camera.e;
import com.oppo.camera.sticker.data.StickerItem;
import com.oppo.camera.ui.RotateImageView;
import com.oppo.camera.ui.control.MainShutterButton;
import com.oppo.camera.ui.preview.a.l;
import com.oppo.camera.util.Util;

/* compiled from: StickerMenu */
public class h {
    private c A = null;
    /* access modifiers changed from: private */
    public boolean B = false;
    private Drawable C = null;
    private Drawable D = null;
    private Drawable E = null;
    /* access modifiers changed from: private */
    public e F = null;
    /* access modifiers changed from: private */
    public g G = null;
    /* access modifiers changed from: private */
    public RelativeLayout H = null;
    /* access modifiers changed from: private */
    public f I = null;
    /* access modifiers changed from: private */
    public StickerCategoryRecycleView J = null;
    private RotateImageView K = null;
    /* access modifiers changed from: private */
    public int L = -1;
    /* access modifiers changed from: private */
    public boolean M = false;
    private c N = null;
    /* access modifiers changed from: private */
    public LinearLayoutManager O = null;
    /* access modifiers changed from: private */
    public d P = null;
    /* access modifiers changed from: private */
    public b Q = null;
    /* access modifiers changed from: private */
    public a R = null;
    private View.OnClickListener S = new View.OnClickListener() {
        public void onClick(View view) {
            if ((h.this.j == null || !h.this.j.isRunning()) && h.this.z.g() && h.this.u.isEnabled() && h.this.u.isClickable()) {
                h.this.d(true);
            } else {
                e.a("StickerMenu", "mEnterMenuButtonOnClickListener, onClick, return");
            }
        }
    };
    private View.OnClickListener T = new View.OnClickListener() {
        public void onClick(View view) {
            if (h.this.L != 0) {
                h.this.G.a(0, 0, h.this.Q.c, false);
            }
        }
    };
    private ContentObserver U = new ContentObserver((Handler) null) {
        public void onChange(boolean z) {
            e.a("StickerMenu", "onChange, slefChange: " + z);
            h.this.r.runOnUiThread(new Runnable() {
                public void run() {
                    h.this.b();
                }
            });
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final int f3707a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3708b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private Interpolator g = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
    private TimeInterpolator h = new PathInterpolator(0.75f, 0.1f, 0.75f, 1.0f);
    private AnimatorSet i = null;
    /* access modifiers changed from: private */
    public AnimatorSet j = null;
    private AnimatorSet k = null;
    private AnimatorSet l = null;
    private Animator m = null;
    private Animator n = null;
    private boolean o = false;
    /* access modifiers changed from: private */
    public boolean p = false;
    private int q = 0;
    /* access modifiers changed from: private */
    public Activity r = null;
    private RelativeLayout s = null;
    /* access modifiers changed from: private */
    public RelativeLayout t = null;
    /* access modifiers changed from: private */
    public RotateImageView u = null;
    private MainShutterButton v = null;
    /* access modifiers changed from: private */
    public StickerPageView w = null;
    /* access modifiers changed from: private */
    public RotateImageView x = null;
    /* access modifiers changed from: private */
    public j y = null;
    /* access modifiers changed from: private */
    public i z = null;

    /* compiled from: StickerMenu */
    public interface a {
        void a();
    }

    public h(Activity activity, int i2, boolean z2) {
        e.a("StickerMenu", "StickerMenu");
        this.r = activity;
        this.p = this.r.getResources().getConfiguration().getLayoutDirection() == 0;
        this.s = (RelativeLayout) this.r.findViewById(R.id.camera);
        this.q = i2;
        this.P = new d();
        this.f3707a = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_type_view_item_size);
        this.f3708b = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_view_padding);
        this.c = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_view_second_padding);
        this.d = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_top_margin);
        this.e = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_list_padding);
        this.f = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_list_margin_left);
        if (this.s != null) {
            e.a("StickerMenus");
            this.u = (RotateImageView) activity.getLayoutInflater().inflate(R.layout.enter_sticker_button, (ViewGroup) null);
            this.u.a(this.q, true);
            this.u.setOnClickListener(this.S);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(20);
            layoutParams.addRule(2, R.id.control_panel_layout);
            layoutParams.bottomMargin = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_menu_button_top_margin);
            layoutParams.setMarginStart(this.r.getResources().getDimensionPixelSize(R.dimen.sticker_menu_button_right_margin));
            if (z2) {
                c(true);
            } else {
                c(false);
            }
            this.s.addView(this.u, layoutParams);
            this.C = this.r.getDrawable(R.drawable.sticker_music_play);
            this.D = this.r.getDrawable(R.drawable.sticker_music_pause);
            this.E = this.C;
            this.G = new g() {
                public void a(int i, int i2, String str, boolean z) {
                    if (h.this.z != null) {
                        h.this.z.b(str);
                        int unused = h.this.L = i;
                        h.this.a(str, z);
                        h.this.w.a(h.this.L, false);
                        h.this.a(i2);
                        l.b((Context) h.this.r).b(str);
                    }
                    if (h.this.F != null && i == 0) {
                        h.this.F.b(-1);
                    }
                    h.this.k();
                }

                public boolean a() {
                    return !h.this.M;
                }

                public void b() {
                    if (h.this.z != null) {
                        h.this.z.d();
                    }
                }
            };
            e.b("StickerMenus");
        }
    }

    public RotateImageView a() {
        return this.u;
    }

    /* access modifiers changed from: private */
    public void k() {
        b bVar = this.Q;
        if (bVar != null) {
            if (this.L == 0) {
                this.K.setImageDrawable(bVar.f3728a);
            } else {
                this.K.setImageDrawable(bVar.f3729b);
            }
        }
    }

    public void a(boolean z2, boolean z3) {
        RotateImageView rotateImageView;
        e.a("StickerMenu", "onResume");
        e.a("StickerMenus.onResume");
        b();
        if (z2 && (rotateImageView = this.u) != null) {
            rotateImageView.setAlpha(0.0f);
        }
        if (!z3) {
            a(0, false, false);
        }
        f();
        e.b("StickerMenus.onResume");
    }

    public void a(final String str) {
        Activity activity = this.r;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (h.this.y != null) {
                        h.this.y.a(str);
                    }
                }
            });
        }
    }

    public void b() {
        e.a("StickerMenu", "updateLayout, mGridViewRelativeLayout: " + this.t);
        if (this.t != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, o());
            layoutParams.addRule(12);
            layoutParams.bottomMargin = Util.I();
            this.t.setLayoutParams(layoutParams);
        }
    }

    public void c() {
        e.a("StickerMenu", "onPause");
        if (h()) {
            b(true, false, false);
        }
        a(false);
        this.L = -1;
        g();
    }

    public void d() {
        e.a("StickerMenu", "onDestroy");
        this.r = null;
    }

    public void e() {
        StickerItem stickerItem = null;
        int i2 = 0;
        if (this.w == null) {
            e.a("StickerMenus.initEffectMenuPanel");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, o());
            layoutParams.addRule(12);
            layoutParams.bottomMargin = Util.I();
            this.t = (RelativeLayout) LayoutInflater.from(this.r).inflate(R.layout.sticker_page_view, (ViewGroup) null);
            RelativeLayout relativeLayout = (RelativeLayout) this.r.findViewById(R.id.control_panel_layout);
            this.v = (MainShutterButton) this.r.findViewById(R.id.shutter_button);
            relativeLayout.addView(this.t, relativeLayout.indexOfChild((RelativeLayout) this.r.findViewById(R.id.control_panel_button_layout)), layoutParams);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.v, "translationY", new float[]{0.0f, (float) p()});
            ofFloat.setInterpolator(this.h);
            ofFloat.setDuration(300);
            this.k = new AnimatorSet();
            this.k.play(ofFloat);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.v, "translationY", new float[]{(float) p(), 0.0f});
            ofFloat2.setInterpolator(this.h);
            ofFloat2.setDuration(300);
            this.l = new AnimatorSet();
            this.l.play(ofFloat2);
            i iVar = this.z;
            if (iVar != null) {
                stickerItem = iVar.e();
            }
            this.w = (StickerPageView) this.r.findViewById(R.id.page_view);
            this.y = new j(this.r, this.q, stickerItem, this.z, this.A);
            this.y.c(this.L);
            this.w.setAdapter(this.y);
            this.w.a(this.y.d(), false);
            this.w.setStickerCategoryInterface(this.G);
            this.w.setOnPageChangeListener(new ViewPager.f() {
                public void onPageScrolled(int i, float f, int i2) {
                    if (f == 0.0f && h.this.F != null && i < h.this.F.getItemCount()) {
                        h.this.z.a(h.this.F.a(i).c);
                    }
                }

                public void onPageSelected(int i) {
                    int i2;
                    e.b("StickerMenu", "onPageSelected, position: " + i);
                    if (h.this.y != null && h.this.F != null && h.this.G != null && h.this.J != null && h.this.L != i) {
                        int findFirstCompletelyVisibleItemPosition = h.this.O.findFirstCompletelyVisibleItemPosition();
                        int findLastCompletelyVisibleItemPosition = h.this.O.findLastCompletelyVisibleItemPosition();
                        int i3 = i - 1;
                        if (i3 >= 0) {
                            if (findFirstCompletelyVisibleItemPosition > i3 || i3 > findLastCompletelyVisibleItemPosition) {
                                int itemCount = h.this.F.getItemCount();
                                if (i3 == 0 || 1 == i3 || (2 == i3 && 2 == h.this.L)) {
                                    h.this.J.scrollToPosition(0);
                                } else {
                                    int i4 = itemCount - 1;
                                    if (i3 == i4 || i3 == itemCount - 2 || (i3 == itemCount - 3 && h.this.L == i2)) {
                                        h.this.J.scrollToPosition(i4);
                                    } else {
                                        if (i3 > h.this.L - 1) {
                                            h.this.J.scrollToPosition(i3 - 3);
                                        } else {
                                            h.this.J.scrollToPosition(i3 - 1);
                                        }
                                        boolean unused = h.this.M = true;
                                        h.this.P.a(i3);
                                    }
                                }
                            } else {
                                h.this.a(i3);
                            }
                            h hVar = h.this;
                            hVar.a(hVar.F.a(i3).c, false);
                        } else {
                            h.this.J.scrollTo(0, 0);
                            h hVar2 = h.this;
                            hVar2.a(hVar2.F.a(0).c, false);
                        }
                        int unused2 = h.this.L = i;
                        h.this.y.c(h.this.L);
                        h.this.F.b(i3);
                        h.this.k();
                    }
                }

                public void onPageScrollStateChanged(int i) {
                    e.b("StickerMenu", "onPageScrollStateChanged, position: " + i);
                }
            });
            this.x = new RotateImageView(this.r);
            this.x.setImageDrawable(this.E);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (this.p) {
                layoutParams2.addRule(11);
                layoutParams2.rightMargin = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_music_margin_right);
            } else {
                layoutParams2.addRule(9);
                layoutParams2.leftMargin = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_music_margin_right);
            }
            layoutParams2.addRule(8);
            layoutParams2.bottomMargin = this.r.getResources().getDimensionPixelSize(R.dimen.sticker_music_margin_bottom);
            layoutParams2.addRule(2, R.id.control_panel_layout);
            this.s.addView(this.x, layoutParams2);
            RotateImageView rotateImageView = this.x;
            if (!this.B) {
                i2 = 4;
            }
            rotateImageView.setVisibility(i2);
            this.x.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (h.this.z != null) {
                        h.this.z.f();
                    }
                }
            });
        } else {
            i iVar2 = this.z;
            if (iVar2 != null) {
                stickerItem = iVar2.e();
            }
            this.y = new j(this.r, this.q, stickerItem, this.z, this.A);
            this.y.c(this.L);
            this.w.setAdapter(this.y);
            this.w.a(this.y.d(), false);
        }
        e.b("StickerMenus.initEffectMenuPanel");
    }

    /* compiled from: StickerMenu */
    public class d implements View.OnLayoutChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private int f3733b = -1;

        public d() {
        }

        public void a(int i) {
            this.f3733b = i;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (h.this.M) {
                int i9 = this.f3733b;
                if (i9 != -1) {
                    h.this.a(i9);
                }
                boolean unused = h.this.M = false;
                this.f3733b = -1;
            }
        }
    }

    public void a(int i2) {
        int i3;
        int i4;
        int i5;
        if (this.F != null) {
            int childCount = this.J.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = this.J.getChildAt(i6);
                if (((Integer) childAt.getTag()).intValue() == i2) {
                    int left = childAt.getLeft();
                    int itemCount = this.F.getItemCount();
                    if (i2 == 0) {
                        i5 = this.e;
                    } else {
                        if (i2 == 1) {
                            i3 = this.e + this.f3707a;
                            i4 = this.f3708b;
                        } else if (i2 == itemCount - 1) {
                            i3 = this.e + (this.f3707a * 4);
                            i4 = this.f3708b * 4;
                        } else if (i2 == itemCount - 2) {
                            i3 = this.e + (this.f3707a * 3);
                            i4 = this.f3708b * 3;
                        } else {
                            i3 = this.e + (this.f3707a * 2);
                            i4 = this.f3708b * 2;
                        }
                        i5 = i3 + i4;
                    }
                    int i7 = left - i5;
                    if (i7 != Integer.MAX_VALUE) {
                        this.J.smoothScrollBy(i7, 0);
                    }
                }
            }
        }
    }

    public void a(final StickerItem stickerItem, final boolean z2) {
        Activity activity = this.r;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (h.this.y != null) {
                        h.this.y.a(stickerItem, z2);
                    }
                }
            });
        }
    }

    public void a(String str, boolean z2) {
        j jVar = this.y;
        if (jVar != null) {
            jVar.a(str, z2);
        }
    }

    public void a(StickerItem stickerItem) {
        if (stickerItem == null) {
            this.B = false;
            return;
        }
        b(stickerItem.getStickerUUID());
        this.B = stickerItem.hasMusic();
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.E = l.b((Context) this.r).a(str) ? this.D : this.C;
            RotateImageView rotateImageView = this.x;
            if (rotateImageView != null) {
                rotateImageView.setImageDrawable(this.E);
            }
        }
    }

    public void a(String str, int i2, int i3, String str2, boolean z2, StickerItem stickerItem) {
        if (this.y != null && !TextUtils.isEmpty(str2)) {
            this.y.a(str, i2, i3, l.b((Context) this.r).a((Context) this.r, Uri.parse(str2)), z2, stickerItem);
        }
    }

    public void f() {
        e.a("StickerMenu", "registerNavigationBarObserver");
        this.r.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("manual_hide_navigationbar"), true, this.U);
    }

    public void g() {
        e.a("StickerMenu", "unregisterNavigationBarObserver");
        this.r.getContentResolver().unregisterContentObserver(this.U);
    }

    public void a(i iVar) {
        this.z = iVar;
    }

    public void a(c cVar) {
        this.A = cVar;
    }

    public void a(int i2, boolean z2, boolean z3) {
        e.a("StickerMenu", "setVisibility, visible: " + i2 + ", includePanel: " + z3);
        if (z2) {
            if (h()) {
                if (z3) {
                    RelativeLayout relativeLayout = this.t;
                    if (relativeLayout != null) {
                        Util.a((View) relativeLayout, i2, (Animation.AnimationListener) null, 300);
                    }
                    f fVar = this.I;
                    if (fVar != null) {
                        Util.a((View) fVar, i2, (Animation.AnimationListener) null, 300);
                    }
                }
            } else if (this.u != null) {
                l();
                if (i2 == 0) {
                    Animator n2 = n();
                    if (n2 != null) {
                        n2.start();
                        return;
                    }
                    return;
                }
                Animator m2 = m();
                if (m2 != null) {
                    m2.start();
                }
            }
        } else if (h()) {
            if (z3) {
                RelativeLayout relativeLayout2 = this.t;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(i2);
                }
                f fVar2 = this.I;
                if (fVar2 != null) {
                    fVar2.setVisibility(i2);
                }
            }
        } else if (this.u != null) {
            l();
            this.u.setVisibility(i2);
            this.u.setAlpha(i2 == 0 ? 1.0f : 0.0f);
        }
    }

    private void l() {
        Animator animator = this.m;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.n;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private Animator m() {
        RotateImageView rotateImageView = this.u;
        if (rotateImageView != null && rotateImageView.getVisibility() != 0) {
            return null;
        }
        this.n = ObjectAnimator.ofFloat(this.u, "alpha", new float[]{1.0f, 0.0f});
        this.n.setInterpolator(this.g);
        this.n.setDuration(80);
        this.n.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                h.this.u.setClickable(false);
            }

            public void onAnimationEnd(Animator animator) {
                h.this.u.setClickable(false);
                h.this.u.setVisibility(4);
            }

            public void onAnimationCancel(Animator animator) {
                h.this.u.setClickable(true);
                h.this.u.setVisibility(0);
                h.this.u.setAlpha(1.0f);
            }
        });
        return this.n;
    }

    private Animator n() {
        if (this.u.getVisibility() == 0 && 1.0f == this.u.getAlpha()) {
            return null;
        }
        this.m = ObjectAnimator.ofFloat(this.u, "alpha", new float[]{0.0f, 1.0f});
        this.m.setInterpolator(this.g);
        this.m.setDuration(160);
        this.m.setStartDelay(160);
        this.m.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                h.this.u.setVisibility(0);
                h.this.u.setClickable(false);
            }

            public void onAnimationEnd(Animator animator) {
                h.this.u.setClickable(true);
                if (h.this.R != null) {
                    h.this.R.a();
                }
            }

            public void onAnimationCancel(Animator animator) {
                h.this.u.setClickable(false);
                h.this.u.setVisibility(4);
                h.this.u.setAlpha(0.0f);
            }
        });
        return this.m;
    }

    public void a(a aVar) {
        this.R = aVar;
    }

    public void a(boolean z2) {
        RotateImageView rotateImageView;
        e.a("StickerMenu", "setEnable, enable: " + z2 + ", isStickerMenuOpen: " + h());
        if (!h() && (rotateImageView = this.u) != null) {
            rotateImageView.setClickable(z2);
        }
    }

    public void b(boolean z2) {
        e.a("StickerMenu", "setStickerPanelEnable, enable: " + z2);
        j jVar = this.y;
        if (jVar != null) {
            jVar.a(z2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h() {
        /*
            r1 = this;
            boolean r0 = r1.o
            if (r0 != 0) goto L_0x0011
            android.animation.AnimatorSet r0 = r1.i
            if (r0 == 0) goto L_0x000f
            boolean r0 = r0.isRunning()
            if (r0 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.ui.h.h():boolean");
    }

    public void c(final String str) {
        Activity activity = this.r;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    boolean unused = h.this.B = true;
                    h.this.b(str);
                    Util.a((View) h.this.x, 0, (Animation.AnimationListener) null, 300);
                    if (h.this.I != null) {
                        h.this.I.a(h.this.B);
                    }
                }
            });
        }
    }

    public void i() {
        Activity activity = this.r;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    boolean unused = h.this.B = false;
                    Util.a((View) h.this.x, 8, (Animation.AnimationListener) null, 300);
                    if (h.this.I != null) {
                        h.this.I.a(h.this.B);
                    }
                }
            });
        }
    }

    public void b(int i2) {
        this.q = i2;
        RotateImageView rotateImageView = this.u;
        if (rotateImageView != null) {
            rotateImageView.a(this.q, true);
        }
        j jVar = this.y;
        if (jVar != null) {
            jVar.d(this.q);
        }
        e eVar = this.F;
        if (eVar != null) {
            eVar.c(this.q);
        }
        RotateImageView rotateImageView2 = this.x;
        if (rotateImageView2 != null) {
            rotateImageView2.a(this.q, true);
        }
        RotateImageView rotateImageView3 = this.K;
        if (rotateImageView3 != null) {
            rotateImageView3.a(this.q, true);
        }
    }

    public void c(boolean z2) {
        if (z2) {
            this.u.setImageDrawable(Util.b((Context) this.r, (int) R.drawable.sticker_menu_control_button_highlight));
        } else {
            this.u.setImageResource(R.drawable.sticker_menu_control_button);
        }
    }

    public boolean j() {
        AnimatorSet animatorSet = this.i;
        if (animatorSet != null && animatorSet.isRunning()) {
            return true;
        }
        AnimatorSet animatorSet2 = this.j;
        return animatorSet2 != null && animatorSet2.isRunning();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x01fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.ArrayList<com.oppo.camera.sticker.ui.h.b> r19, int r20, boolean r21) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            java.lang.String r8 = "StickerMenus.updateStickerCategoryMenu"
            com.oppo.camera.e.a((java.lang.String) r8)
            android.widget.RelativeLayout r0 = r6.H
            r9 = 4
            r10 = -1
            r11 = 5
            r12 = 6
            r13 = 0
            r14 = 1
            if (r0 != 0) goto L_0x016e
            com.oppo.camera.sticker.ui.f r0 = new com.oppo.camera.sticker.ui.f
            android.app.Activity r1 = r6.r
            r0.<init>(r1)
            r6.I = r0
            com.oppo.camera.sticker.ui.f r0 = r6.I
            android.app.Activity r1 = r6.r
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131100490(0x7f06034a, float:1.7813363E38)
            int r1 = r1.getColor(r2)
            r0.setBackgroundColor(r1)
            android.widget.RelativeLayout$LayoutParams r15 = new android.widget.RelativeLayout$LayoutParams
            android.app.Activity r0 = r6.r
            android.content.res.Resources r0 = r0.getResources()
            r1 = 2131166848(0x7f070680, float:1.7947953E38)
            int r0 = r0.getDimensionPixelSize(r1)
            r15.<init>(r10, r0)
            r0 = 2
            r5 = 2131296472(0x7f0900d8, float:1.8210862E38)
            r15.addRule(r0, r5)
            android.app.Activity r0 = r6.r
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r1 = 2131493113(0x7f0c00f9, float:1.8609697E38)
            com.oppo.camera.sticker.ui.f r2 = r6.I
            android.view.View r0 = r0.inflate(r1, r2, r13)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r6.H = r0
            com.oppo.camera.sticker.ui.e r0 = new com.oppo.camera.sticker.ui.e
            android.app.Activity r1 = r6.r
            com.oppo.camera.sticker.ui.g r2 = r6.G
            int r3 = r6.q
            r0.<init>(r1, r2, r3)
            r6.F = r0
            com.oppo.camera.sticker.ui.e r0 = r6.F
            r0.a((java.util.ArrayList<com.oppo.camera.sticker.ui.h.b>) r7)
            android.widget.RelativeLayout r0 = r6.H
            r1 = 2131296884(0x7f090274, float:1.8211697E38)
            android.view.View r0 = r0.findViewById(r1)
            com.oppo.camera.ui.RotateImageView r0 = (com.oppo.camera.ui.RotateImageView) r0
            r6.K = r0
            java.lang.Object r0 = r7.get(r13)
            com.oppo.camera.sticker.ui.h$b r0 = (com.oppo.camera.sticker.ui.h.b) r0
            r6.Q = r0
            com.oppo.camera.ui.RotateImageView r0 = r6.K
            com.oppo.camera.sticker.ui.h$b r1 = r6.Q
            android.graphics.drawable.Drawable r1 = r1.f3729b
            r0.setImageDrawable(r1)
            com.oppo.camera.ui.RotateImageView r0 = r6.K
            android.view.View$OnClickListener r1 = r6.T
            r0.setOnClickListener(r1)
            android.widget.RelativeLayout r0 = r6.H
            r1 = 2131296262(0x7f090006, float:1.8210436E38)
            android.view.View r0 = r0.findViewById(r1)
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r0 = (com.oppo.camera.sticker.ui.StickerCategoryRecycleView) r0
            r6.J = r0
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r0 = r6.J
            com.oppo.camera.sticker.ui.h$d r1 = r6.P
            r0.addOnLayoutChangeListener(r1)
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r0 = r6.J
            com.oppo.camera.sticker.ui.g r1 = r6.G
            r0.setStickerCategoryInterface(r1)
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.app.Activity r1 = r6.r
            r0.<init>(r1)
            r6.O = r0
            androidx.recyclerview.widget.LinearLayoutManager r0 = r6.O
            r0.setOrientation(r13)
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r0 = r6.J
            r1 = 100
            r0.setItemViewCacheSize(r1)
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r0 = r6.J
            androidx.recyclerview.widget.LinearLayoutManager r1 = r6.O
            r0.setLayoutManager(r1)
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r0 = r6.J
            com.oppo.camera.sticker.ui.e r1 = r6.F
            r0.setAdapter(r1)
            com.oppo.camera.sticker.ui.h$c r4 = new com.oppo.camera.sticker.ui.h$c
            android.app.Activity r2 = r6.r
            int r3 = r6.f3708b
            int r1 = r6.e
            int r0 = r6.c
            r16 = r0
            r0 = r4
            r17 = r1
            r1 = r18
            r13 = r4
            r4 = r17
            r10 = r5
            r5 = r16
            r0.<init>(r2, r3, r4, r5)
            r6.N = r13
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r0 = r6.J
            com.oppo.camera.sticker.ui.h$c r1 = r6.N
            r0.addItemDecoration(r1)
            int r0 = r19.size()
            if (r0 > r12) goto L_0x011d
            int r0 = r19.size()
            int r1 = r0 + -1
            int r2 = r6.f3707a
            int r0 = r0 * r2
            int r3 = r6.f3708b
            int r1 = r1 * r3
            int r0 = r0 + r1
            int r1 = r6.c
            int r0 = r0 + r1
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r0, r2)
            r1.addRule(r11)
            int r0 = r6.f
            r1.leftMargin = r0
            int r0 = r1.leftMargin
            r1.rightMargin = r0
            int r0 = r6.d
            r1.topMargin = r0
            goto L_0x0140
        L_0x011d:
            int r0 = r6.f3707a
            int r1 = r0 * 6
            int r2 = r6.f3708b
            int r2 = r2 * r9
            int r1 = r1 + r2
            int r2 = r6.c
            int r1 = r1 + r2
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            r2.<init>(r1, r0)
            r2.addRule(r11)
            int r0 = r6.f
            int r1 = r6.e
            int r0 = r0 - r1
            r2.leftMargin = r0
            int r0 = r2.leftMargin
            r2.rightMargin = r0
            int r0 = r6.d
            r2.topMargin = r0
            r1 = r2
        L_0x0140:
            boolean r0 = r18.h()
            if (r0 == 0) goto L_0x014e
            com.oppo.camera.sticker.ui.e r0 = r6.F
            int r0 = r0.getItemCount()
            if (r0 > r14) goto L_0x0153
        L_0x014e:
            com.oppo.camera.sticker.ui.f r0 = r6.I
            r0.setVisibility(r9)
        L_0x0153:
            com.oppo.camera.sticker.ui.f r0 = r6.I
            android.widget.RelativeLayout r2 = r6.H
            r0.addView(r2, r1)
            android.app.Activity r0 = r6.r
            android.view.View r0 = r0.findViewById(r10)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            android.widget.RelativeLayout r1 = r6.s
            com.oppo.camera.sticker.ui.f r2 = r6.I
            int r0 = r1.indexOfChild(r0)
            r1.addView(r2, r0, r15)
            goto L_0x01d6
        L_0x016e:
            int r0 = r19.size()
            if (r0 <= r14) goto L_0x01d6
            android.widget.RelativeLayout r0 = r6.H
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r0 = (android.widget.RelativeLayout.LayoutParams) r0
            int r1 = r19.size()
            if (r1 > r12) goto L_0x01a6
            int r1 = r19.size()
            int r2 = r1 + -1
            int r3 = r6.f3707a
            int r1 = r1 * r3
            int r4 = r6.f3708b
            int r2 = r2 * r4
            int r1 = r1 + r2
            int r2 = r6.c
            int r1 = r1 + r2
            r0.width = r1
            r0.height = r3
            r0.addRule(r11)
            int r1 = r6.f
            r0.leftMargin = r1
            int r1 = r0.leftMargin
            r0.rightMargin = r1
            int r1 = r6.d
            r0.topMargin = r1
            goto L_0x01c7
        L_0x01a6:
            int r1 = r6.f3707a
            int r2 = r1 * 6
            int r3 = r6.f3708b
            int r3 = r3 * r9
            int r2 = r2 + r3
            int r3 = r6.c
            int r2 = r2 + r3
            r0.width = r2
            r0.height = r1
            r0.addRule(r11)
            int r1 = r6.f
            int r2 = r6.e
            int r1 = r1 - r2
            r0.leftMargin = r1
            int r1 = r0.leftMargin
            r0.rightMargin = r1
            int r1 = r6.d
            r0.topMargin = r1
        L_0x01c7:
            android.widget.RelativeLayout r1 = r6.H
            r1.setLayoutParams(r0)
            com.oppo.camera.sticker.ui.e r0 = r6.F
            r0.a((java.util.ArrayList<com.oppo.camera.sticker.ui.h.b>) r7)
            com.oppo.camera.sticker.ui.e r0 = r6.F
            r0.notifyDataSetChanged()
        L_0x01d6:
            if (r21 != 0) goto L_0x01e6
            int r0 = r6.L
            r1 = -1
            if (r0 == r1) goto L_0x01e7
            int r2 = r19.size()
            if (r0 < r2) goto L_0x01e4
            goto L_0x01e7
        L_0x01e4:
            r0 = 0
            goto L_0x01f3
        L_0x01e6:
            r1 = -1
        L_0x01e7:
            int r0 = r6.L
            if (r1 != r0) goto L_0x01ee
            r6.L = r14
            goto L_0x01f2
        L_0x01ee:
            r0 = r20
            r6.L = r0
        L_0x01f2:
            r0 = r14
        L_0x01f3:
            int r1 = r6.L
            int r2 = r19.size()
            if (r1 >= r2) goto L_0x0231
            com.oppo.camera.sticker.ui.j r1 = r6.y
            if (r1 == 0) goto L_0x0210
            int r2 = r6.L
            r1.c(r2)
            com.oppo.camera.sticker.ui.StickerPageView r1 = r6.w
            com.oppo.camera.sticker.ui.j r2 = r6.y
            int r2 = r2.d()
            r3 = 0
            r1.a((int) r2, (boolean) r3)
        L_0x0210:
            if (r0 == 0) goto L_0x021b
            r6.M = r14
            com.oppo.camera.sticker.ui.h$d r0 = r6.P
            int r1 = r6.L
            r0.a(r1)
        L_0x021b:
            com.oppo.camera.sticker.ui.h$c r0 = r6.N
            int r1 = r19.size()
            r0.a(r1)
            int r0 = r6.L
            java.lang.Object r0 = r7.get(r0)
            com.oppo.camera.sticker.ui.h$b r0 = (com.oppo.camera.sticker.ui.h.b) r0
            java.lang.String r0 = r0.c
            r6.a((java.lang.String) r0, (boolean) r14)
        L_0x0231:
            int r0 = r6.L
            int r0 = r0 - r14
            com.oppo.camera.sticker.ui.e r1 = r6.F
            if (r1 == 0) goto L_0x0251
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r2 = r6.J
            if (r2 == 0) goto L_0x0251
            if (r0 < 0) goto L_0x0251
            int r1 = r1.getItemCount()
            if (r0 >= r1) goto L_0x0251
            com.oppo.camera.sticker.ui.e r1 = r6.F
            r1.b((int) r0)
            com.oppo.camera.sticker.ui.StickerCategoryRecycleView r1 = r6.J
            r1.scrollToPosition(r0)
            r18.k()
        L_0x0251:
            com.oppo.camera.e.b(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oppo.camera.sticker.ui.h.a(java.util.ArrayList, int, boolean):void");
    }

    public void d(boolean z2) {
        f fVar;
        e.a("StickerMenu", "show, isAnim: " + z2);
        AnimatorSet animatorSet = this.j;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.o = true;
        RotateImageView rotateImageView = this.u;
        if (rotateImageView != null) {
            rotateImageView.setClickable(false);
        }
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
        }
        RelativeLayout relativeLayout2 = this.H;
        if (relativeLayout2 != null) {
            relativeLayout2.setEnabled(false);
        }
        i iVar = this.z;
        if (iVar != null) {
            iVar.a(z2);
        }
        e();
        AnimatorSet animatorSet2 = this.k;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        if (z2) {
            Util.a((View) this.t, 0, (Animation.AnimationListener) null, 300);
            if (this.B) {
                Util.a((View) this.x, 0, (Animation.AnimationListener) null, 300);
            }
            e eVar = this.F;
            if (!(eVar == null || eVar.getItemCount() <= 1 || (fVar = this.I) == null)) {
                Util.a((View) fVar, 0, (Animation.AnimationListener) null, 300);
                this.I.a(this.B);
            }
            this.i = new AnimatorSet();
            this.i.play(m());
            this.i.addListener(new Animator.AnimatorListener() {
                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (h.this.t != null) {
                        h.this.t.setEnabled(true);
                    }
                    if (h.this.z != null) {
                        h.this.z.a();
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    if (h.this.t != null) {
                        h.this.t.setEnabled(true);
                    }
                    if (h.this.z != null) {
                        h.this.z.a();
                    }
                }
            });
            this.i.start();
            return;
        }
        RotateImageView rotateImageView2 = this.u;
        if (rotateImageView2 != null) {
            rotateImageView2.setAlpha(0.0f);
        }
        RelativeLayout relativeLayout3 = this.t;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(0);
            this.t.setEnabled(true);
        }
        i iVar2 = this.z;
        if (iVar2 != null) {
            iVar2.a();
        }
        e eVar2 = this.F;
        if (eVar2 != null && eVar2.getItemCount() > 1) {
            f fVar2 = this.I;
            if (fVar2 != null) {
                fVar2.setVisibility(0);
                this.I.a(this.B);
            }
            a(this.L);
        }
    }

    public void e(boolean z2) {
        a(z2, true, true);
    }

    public void a(boolean z2, final boolean z3, boolean z4) {
        AnimatorSet animatorSet = this.i;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.k;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
        }
        RelativeLayout relativeLayout2 = this.H;
        if (relativeLayout2 != null) {
            relativeLayout2.setEnabled(false);
        }
        i iVar = this.z;
        if (iVar != null && z3) {
            iVar.b();
        }
        Util.a((View) this.t, 4, (Animation.AnimationListener) null, 300);
        Util.a((View) this.I, 4, (Animation.AnimationListener) null, 300);
        this.I.a(this.B);
        if (this.B) {
            Util.a((View) this.x, 4, (Animation.AnimationListener) null, 300);
        }
        this.j = new AnimatorSet();
        if (!z2) {
            this.j.play(n());
        }
        this.j.addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                if (h.this.t != null) {
                    h.this.t.setEnabled(true);
                }
                if (h.this.H != null) {
                    h.this.H.setEnabled(true);
                }
                if (h.this.z != null && z3) {
                    h.this.z.c();
                }
            }

            public void onAnimationCancel(Animator animator) {
                if (h.this.t != null) {
                    h.this.t.setEnabled(true);
                }
                if (h.this.z != null && z3) {
                    h.this.z.c();
                }
                if (h.this.H != null) {
                    h.this.H.setEnabled(true);
                }
            }
        });
        AnimatorSet animatorSet3 = this.l;
        if (animatorSet3 != null && z4) {
            animatorSet3.start();
        }
        this.j.start();
        this.o = false;
    }

    public void b(boolean z2, boolean z3, boolean z4) {
        AnimatorSet animatorSet = this.i;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.j;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.k;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.l;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        f fVar = this.I;
        if (fVar != null) {
            fVar.setVisibility(4);
            this.I.a(this.B);
        }
        RotateImageView rotateImageView = this.x;
        if (rotateImageView != null && this.B) {
            rotateImageView.setVisibility(4);
        }
        RotateImageView rotateImageView2 = this.u;
        if (rotateImageView2 != null) {
            rotateImageView2.setTranslationY(0.0f);
            this.u.setTranslationX(0.0f);
            this.u.setAlpha(1.0f);
            if (z2) {
                this.u.setVisibility(4);
            }
        }
        MainShutterButton mainShutterButton = this.v;
        if (mainShutterButton != null) {
            mainShutterButton.setTranslationY(0.0f);
            this.v.setScaleX(1.0f);
            this.v.setScaleY(1.0f);
        }
        RotateImageView rotateImageView3 = this.u;
        if (rotateImageView3 != null) {
            rotateImageView3.setClickable(true);
        }
        i iVar = this.z;
        if (iVar != null) {
            iVar.b(z3);
        }
        this.o = false;
    }

    private int o() {
        return Util.w() - Util.I();
    }

    private int p() {
        return this.r.getResources().getDimensionPixelSize(R.dimen.sticker_shutter_button_translate_y);
    }

    /* compiled from: StickerMenu */
    class c extends RecyclerView.h {

        /* renamed from: b  reason: collision with root package name */
        private int f3731b = 0;
        private int c = 0;
        private int d = 0;
        private int e = 0;
        private int f = 0;
        private int g = 0;
        private int h = 0;
        private int i = 0;
        private Activity j = null;
        private Paint k = null;

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.t tVar) {
            super.getItemOffsets(rect, view, recyclerView, tVar);
            rect.top = 0;
            rect.bottom = 0;
            if (this.d > 6) {
                if (h.this.p) {
                    if (((Integer) view.getTag()).intValue() == 0) {
                        rect.right = 0;
                        rect.left = this.c;
                    } else if (((Integer) view.getTag()).intValue() == this.d - 1) {
                        rect.right = this.c;
                        rect.left = this.f3731b;
                    } else {
                        rect.right = 0;
                        rect.left = this.f3731b;
                    }
                } else if (((Integer) view.getTag()).intValue() == 0) {
                    rect.left = 0;
                    rect.right = this.c;
                } else if (((Integer) view.getTag()).intValue() == this.d - 1) {
                    rect.left = this.c;
                    rect.right = this.f3731b;
                } else {
                    rect.left = 0;
                    rect.right = this.f3731b;
                }
            } else if (h.this.p) {
                if (((Integer) view.getTag()).intValue() == 0) {
                    rect.right = 0;
                    rect.left = this.c;
                } else if (((Integer) view.getTag()).intValue() != 0) {
                    rect.right = 0;
                    rect.left = this.f3731b;
                }
            } else if (((Integer) view.getTag()).intValue() == 0) {
                rect.left = 0;
                rect.right = this.c;
            } else if (((Integer) view.getTag()).intValue() != 0) {
                rect.left = 0;
                rect.right = this.f3731b;
            }
        }

        public c(Activity activity, int i2, int i3, int i4) {
            int i5;
            this.j = activity;
            this.f3731b = i2;
            this.c = i3;
            this.e = i4;
            if (h.this.p) {
                i5 = this.j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_left_padding);
            } else {
                i5 = Util.E() - this.j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_left_padding);
            }
            this.f = i5;
            this.g = this.j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_top_padding);
            this.h = this.j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_width);
            this.i = this.j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_height);
            this.k = new Paint();
            this.k.setColor(this.j.getResources().getColor(R.color.color_white_with_30_percent_transparency));
            this.k.setStrokeWidth((float) this.h);
        }

        public void a(int i2) {
            this.d = i2;
        }
    }

    /* compiled from: StickerMenu */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f3728a = null;

        /* renamed from: b  reason: collision with root package name */
        public Drawable f3729b = null;
        public String c = null;
        public boolean d = false;

        public b(Drawable drawable, Drawable drawable2, String str, boolean z) {
            this.f3728a = drawable;
            this.f3729b = drawable2;
            this.c = str;
            this.d = z;
        }
    }
}
