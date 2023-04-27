package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.v;

/* compiled from: Fade */
public class d extends ak {
    public d(int i) {
        a(i);
    }

    public d() {
    }

    public void captureStartValues(t tVar) {
        super.captureStartValues(tVar);
        tVar.f1311a.put("android:fade:transitionAlpha", Float.valueOf(ad.c(tVar.f1312b)));
    }

    private Animator a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ad.a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ad.f1242a, new float[]{f2});
        ofFloat.addListener(new a(view));
        addListener(new n() {
            public void b(m mVar) {
                ad.a(view, 1.0f);
                ad.e(view);
                mVar.removeListener(this);
            }
        });
        return ofFloat;
    }

    public Animator a(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        float f = 0.0f;
        float a2 = a(tVar, 0.0f);
        if (a2 != 1.0f) {
            f = a2;
        }
        return a(view, f, 1.0f);
    }

    public Animator b(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        ad.d(view);
        return a(view, a(tVar, 1.0f), 0.0f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f1311a.get("android:fade:transitionAlpha");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float a(androidx.transition.t r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f1311a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.d.a(androidx.transition.t, float):float");
    }

    /* compiled from: Fade */
    private static class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f1276a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1277b = false;

        a(View view) {
            this.f1276a = view;
        }

        public void onAnimationStart(Animator animator) {
            if (v.u(this.f1276a) && this.f1276a.getLayerType() == 0) {
                this.f1277b = true;
                this.f1276a.setLayerType(2, (Paint) null);
            }
        }

        public void onAnimationEnd(Animator animator) {
            ad.a(this.f1276a, 1.0f);
            if (this.f1277b) {
                this.f1276a.setLayerType(0, (Paint) null);
            }
        }
    }
}
