package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.g.v;
import androidx.core.g.w;

/* compiled from: TooltipCompatHandler */
class au implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static au j;
    private static au k;

    /* renamed from: a  reason: collision with root package name */
    private final View f425a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f426b;
    private final int c;
    private final Runnable d = new Runnable() {
        public void run() {
            au.this.a(false);
        }
    };
    private final Runnable e = new Runnable() {
        public void run() {
            au.this.a();
        }
    };
    private int f;
    private int g;
    private av h;
    private boolean i;

    public void onViewAttachedToWindow(View view) {
    }

    public static void a(View view, CharSequence charSequence) {
        au auVar = j;
        if (auVar != null && auVar.f425a == view) {
            a((au) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            au auVar2 = k;
            if (auVar2 != null && auVar2.f425a == view) {
                auVar2.a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new au(view, charSequence);
    }

    private au(View view, CharSequence charSequence) {
        this.f425a = view;
        this.f426b = charSequence;
        this.c = w.a(ViewConfiguration.get(this.f425a.getContext()));
        d();
        this.f425a.setOnLongClickListener(this);
        this.f425a.setOnHoverListener(this);
    }

    public boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        a(true);
        return true;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f425a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                d();
                a();
            }
        } else if (this.f425a.isEnabled() && this.h == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        long j2;
        int i2;
        long j3;
        if (v.D(this.f425a)) {
            a((au) null);
            au auVar = k;
            if (auVar != null) {
                auVar.a();
            }
            k = this;
            this.i = z;
            this.h = new av(this.f425a.getContext());
            this.h.a(this.f425a, this.f, this.g, this.i, this.f426b);
            this.f425a.addOnAttachStateChangeListener(this);
            if (this.i) {
                j2 = 2500;
            } else {
                if ((v.r(this.f425a) & 1) == 1) {
                    j3 = 3000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j3 = 15000;
                    i2 = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j3 - ((long) i2);
            }
            this.f425a.removeCallbacks(this.e);
            this.f425a.postDelayed(this.e, j2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (k == this) {
            k = null;
            av avVar = this.h;
            if (avVar != null) {
                avVar.a();
                this.h = null;
                d();
                this.f425a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (j == this) {
            a((au) null);
        }
        this.f425a.removeCallbacks(this.e);
    }

    private static void a(au auVar) {
        au auVar2 = j;
        if (auVar2 != null) {
            auVar2.c();
        }
        j = auVar;
        au auVar3 = j;
        if (auVar3 != null) {
            auVar3.b();
        }
    }

    private void b() {
        this.f425a.postDelayed(this.d, (long) ViewConfiguration.getLongPressTimeout());
    }

    private void c() {
        this.f425a.removeCallbacks(this.d);
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f) <= this.c && Math.abs(y - this.g) <= this.c) {
            return false;
        }
        this.f = x;
        this.g = y;
        return true;
    }

    private void d() {
        this.f = Integer.MAX_VALUE;
        this.g = Integer.MAX_VALUE;
    }
}
