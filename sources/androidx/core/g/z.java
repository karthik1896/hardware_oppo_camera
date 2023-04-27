package androidx.core.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    Runnable f720a = null;

    /* renamed from: b  reason: collision with root package name */
    Runnable f721b = null;
    int c = -1;
    private WeakReference<View> d;

    z(View view) {
        this.d = new WeakReference<>(view);
    }

    /* compiled from: ViewPropertyAnimatorCompat */
    static class a implements aa {

        /* renamed from: a  reason: collision with root package name */
        z f726a;

        /* renamed from: b  reason: collision with root package name */
        boolean f727b;

        a(z zVar) {
            this.f726a = zVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.core.g.aa} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.View r4) {
            /*
                r3 = this;
                r0 = 0
                r3.f727b = r0
                androidx.core.g.z r0 = r3.f726a
                int r0 = r0.c
                r1 = 0
                r2 = -1
                if (r0 <= r2) goto L_0x000f
                r0 = 2
                r4.setLayerType(r0, r1)
            L_0x000f:
                androidx.core.g.z r0 = r3.f726a
                java.lang.Runnable r0 = r0.f720a
                if (r0 == 0) goto L_0x0020
                androidx.core.g.z r0 = r3.f726a
                java.lang.Runnable r0 = r0.f720a
                androidx.core.g.z r2 = r3.f726a
                r2.f720a = r1
                r0.run()
            L_0x0020:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r2 = r0 instanceof androidx.core.g.aa
                if (r2 == 0) goto L_0x002d
                r1 = r0
                androidx.core.g.aa r1 = (androidx.core.g.aa) r1
            L_0x002d:
                if (r1 == 0) goto L_0x0032
                r1.a(r4)
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.g.z.a.a(android.view.View):void");
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.core.g.aa} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"WrongConstant"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(android.view.View r4) {
            /*
                r3 = this;
                androidx.core.g.z r0 = r3.f726a
                int r0 = r0.c
                r1 = -1
                r2 = 0
                if (r0 <= r1) goto L_0x0013
                androidx.core.g.z r0 = r3.f726a
                int r0 = r0.c
                r4.setLayerType(r0, r2)
                androidx.core.g.z r0 = r3.f726a
                r0.c = r1
            L_0x0013:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 16
                if (r0 >= r1) goto L_0x001d
                boolean r0 = r3.f727b
                if (r0 != 0) goto L_0x0043
            L_0x001d:
                androidx.core.g.z r0 = r3.f726a
                java.lang.Runnable r0 = r0.f721b
                if (r0 == 0) goto L_0x002e
                androidx.core.g.z r0 = r3.f726a
                java.lang.Runnable r0 = r0.f721b
                androidx.core.g.z r1 = r3.f726a
                r1.f721b = r2
                r0.run()
            L_0x002e:
                r0 = 2113929216(0x7e000000, float:4.2535296E37)
                java.lang.Object r0 = r4.getTag(r0)
                boolean r1 = r0 instanceof androidx.core.g.aa
                if (r1 == 0) goto L_0x003b
                r2 = r0
                androidx.core.g.aa r2 = (androidx.core.g.aa) r2
            L_0x003b:
                if (r2 == 0) goto L_0x0040
                r2.b(r4)
            L_0x0040:
                r4 = 1
                r3.f727b = r4
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.g.z.a.b(android.view.View):void");
        }

        public void c(View view) {
            Object tag = view.getTag(2113929216);
            aa aaVar = tag instanceof aa ? (aa) tag : null;
            if (aaVar != null) {
                aaVar.c(view);
            }
        }
    }

    public z a(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public z a(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    public z b(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    public long a() {
        View view = (View) this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0;
    }

    public z a(Interpolator interpolator) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public z b(long j) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    public z c(float f) {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().rotation(f);
        }
        return this;
    }

    public void b() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = (View) this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public z a(aa aaVar) {
        View view = (View) this.d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                a(view, aaVar);
            } else {
                view.setTag(2113929216, aaVar);
                a(view, new a(this));
            }
        }
        return this;
    }

    private void a(final View view, final aa aaVar) {
        if (aaVar != null) {
            view.animate().setListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    aaVar.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    aaVar.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    aaVar.a(view);
                }
            });
        } else {
            view.animate().setListener((Animator.AnimatorListener) null);
        }
    }

    public z a(final ac acVar) {
        final View view = (View) this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            AnonymousClass2 r1 = null;
            if (acVar != null) {
                r1 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        acVar.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(r1);
        }
        return this;
    }
}
