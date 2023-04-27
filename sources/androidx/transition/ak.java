package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.a;
import androidx.transition.m;

/* compiled from: Visibility */
public abstract class ak extends m {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f1251a = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: b  reason: collision with root package name */
    private int f1252b = 3;

    public Animator a(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        return null;
    }

    public Animator b(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        return null;
    }

    /* compiled from: Visibility */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f1257a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1258b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        b() {
        }
    }

    public void a(int i) {
        if ((i & -4) == 0) {
            this.f1252b = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public String[] getTransitionProperties() {
        return f1251a;
    }

    private void a(t tVar) {
        tVar.f1311a.put("android:visibility:visibility", Integer.valueOf(tVar.f1312b.getVisibility()));
        tVar.f1311a.put("android:visibility:parent", tVar.f1312b.getParent());
        int[] iArr = new int[2];
        tVar.f1312b.getLocationOnScreen(iArr);
        tVar.f1311a.put("android:visibility:screenLocation", iArr);
    }

    public void captureStartValues(t tVar) {
        a(tVar);
    }

    public void captureEndValues(t tVar) {
        a(tVar);
    }

    private b a(t tVar, t tVar2) {
        b bVar = new b();
        bVar.f1257a = false;
        bVar.f1258b = false;
        if (tVar == null || !tVar.f1311a.containsKey("android:visibility:visibility")) {
            bVar.c = -1;
            bVar.e = null;
        } else {
            bVar.c = ((Integer) tVar.f1311a.get("android:visibility:visibility")).intValue();
            bVar.e = (ViewGroup) tVar.f1311a.get("android:visibility:parent");
        }
        if (tVar2 == null || !tVar2.f1311a.containsKey("android:visibility:visibility")) {
            bVar.d = -1;
            bVar.f = null;
        } else {
            bVar.d = ((Integer) tVar2.f1311a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) tVar2.f1311a.get("android:visibility:parent");
        }
        if (tVar == null || tVar2 == null) {
            if (tVar == null && bVar.d == 0) {
                bVar.f1258b = true;
                bVar.f1257a = true;
            } else if (tVar2 == null && bVar.c == 0) {
                bVar.f1258b = false;
                bVar.f1257a = true;
            }
        } else if (bVar.c == bVar.d && bVar.e == bVar.f) {
            return bVar;
        } else {
            if (bVar.c != bVar.d) {
                if (bVar.c == 0) {
                    bVar.f1258b = false;
                    bVar.f1257a = true;
                } else if (bVar.d == 0) {
                    bVar.f1258b = true;
                    bVar.f1257a = true;
                }
            } else if (bVar.f == null) {
                bVar.f1258b = false;
                bVar.f1257a = true;
            } else if (bVar.e == null) {
                bVar.f1258b = true;
                bVar.f1257a = true;
            }
        }
        return bVar;
    }

    public Animator createAnimator(ViewGroup viewGroup, t tVar, t tVar2) {
        b a2 = a(tVar, tVar2);
        if (!a2.f1257a) {
            return null;
        }
        if (a2.e == null && a2.f == null) {
            return null;
        }
        if (a2.f1258b) {
            return a(viewGroup, tVar, a2.c, tVar2, a2.d);
        }
        return b(viewGroup, tVar, a2.c, tVar2, a2.d);
    }

    public Animator a(ViewGroup viewGroup, t tVar, int i, t tVar2, int i2) {
        if ((this.f1252b & 1) != 1 || tVar2 == null) {
            return null;
        }
        if (tVar == null) {
            View view = (View) tVar2.f1312b.getParent();
            if (a(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f1257a) {
                return null;
            }
        }
        return a(viewGroup, tVar2.f1312b, tVar, tVar2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
        if (r9.mCanRemoveViews != false) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator b(final android.view.ViewGroup r10, androidx.transition.t r11, int r12, androidx.transition.t r13, int r14) {
        /*
            r9 = this;
            int r12 = r9.f1252b
            r0 = 2
            r12 = r12 & r0
            r1 = 0
            if (r12 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r11 != 0) goto L_0x000b
            return r1
        L_0x000b:
            android.view.View r12 = r11.f1312b
            if (r13 == 0) goto L_0x0012
            android.view.View r2 = r13.f1312b
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            int r3 = androidx.transition.R.id.save_overlay_view
            java.lang.Object r3 = r12.getTag(r3)
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0023
            r6 = r1
            r2 = r5
            goto L_0x0084
        L_0x0023:
            if (r2 == 0) goto L_0x0035
            android.view.ViewParent r3 = r2.getParent()
            if (r3 != 0) goto L_0x002c
            goto L_0x0035
        L_0x002c:
            r3 = 4
            if (r14 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            if (r12 != r2) goto L_0x003b
        L_0x0032:
            r3 = r1
            r6 = r2
            goto L_0x0039
        L_0x0035:
            if (r2 == 0) goto L_0x003b
            r6 = r1
            r3 = r2
        L_0x0039:
            r2 = r4
            goto L_0x003e
        L_0x003b:
            r3 = r1
            r6 = r3
            r2 = r5
        L_0x003e:
            if (r2 == 0) goto L_0x0083
            android.view.ViewParent r2 = r12.getParent()
            if (r2 != 0) goto L_0x0047
            goto L_0x0082
        L_0x0047:
            android.view.ViewParent r2 = r12.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x0083
            android.view.ViewParent r2 = r12.getParent()
            android.view.View r2 = (android.view.View) r2
            androidx.transition.t r7 = r9.getTransitionValues(r2, r5)
            androidx.transition.t r8 = r9.getMatchedTransitionValues(r2, r5)
            androidx.transition.ak$b r7 = r9.a(r7, r8)
            boolean r7 = r7.f1257a
            if (r7 != 0) goto L_0x006b
            android.view.View r2 = androidx.transition.s.a(r10, r12, r2)
            r3 = r2
            goto L_0x0083
        L_0x006b:
            int r7 = r2.getId()
            android.view.ViewParent r2 = r2.getParent()
            if (r2 != 0) goto L_0x0083
            r2 = -1
            if (r7 == r2) goto L_0x0083
            android.view.View r2 = r10.findViewById(r7)
            if (r2 == 0) goto L_0x0083
            boolean r2 = r9.mCanRemoveViews
            if (r2 == 0) goto L_0x0083
        L_0x0082:
            r3 = r12
        L_0x0083:
            r2 = r4
        L_0x0084:
            if (r3 == 0) goto L_0x00d8
            if (r2 != 0) goto L_0x00ba
            java.util.Map<java.lang.String, java.lang.Object> r14 = r11.f1311a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r14 = r14.get(r1)
            int[] r14 = (int[]) r14
            int[] r14 = (int[]) r14
            r1 = r14[r4]
            r14 = r14[r5]
            int[] r0 = new int[r0]
            r10.getLocationOnScreen(r0)
            r4 = r0[r4]
            int r1 = r1 - r4
            int r4 = r3.getLeft()
            int r1 = r1 - r4
            r3.offsetLeftAndRight(r1)
            r0 = r0[r5]
            int r14 = r14 - r0
            int r0 = r3.getTop()
            int r14 = r14 - r0
            r3.offsetTopAndBottom(r14)
            androidx.transition.x r14 = androidx.transition.y.a(r10)
            r14.a(r3)
        L_0x00ba:
            android.animation.Animator r11 = r9.b(r10, r3, r11, r13)
            if (r2 != 0) goto L_0x00d7
            if (r11 != 0) goto L_0x00ca
            androidx.transition.x r10 = androidx.transition.y.a(r10)
            r10.b(r3)
            goto L_0x00d7
        L_0x00ca:
            int r13 = androidx.transition.R.id.save_overlay_view
            r12.setTag(r13, r3)
            androidx.transition.ak$1 r13 = new androidx.transition.ak$1
            r13.<init>(r10, r3, r12)
            r9.addListener(r13)
        L_0x00d7:
            return r11
        L_0x00d8:
            if (r6 == 0) goto L_0x00fa
            int r12 = r6.getVisibility()
            androidx.transition.ad.a((android.view.View) r6, (int) r4)
            android.animation.Animator r10 = r9.b(r10, r6, r11, r13)
            if (r10 == 0) goto L_0x00f6
            androidx.transition.ak$a r11 = new androidx.transition.ak$a
            r11.<init>(r6, r14, r5)
            r10.addListener(r11)
            androidx.transition.a.a(r10, r11)
            r9.addListener(r11)
            goto L_0x00f9
        L_0x00f6:
            androidx.transition.ad.a((android.view.View) r6, (int) r12)
        L_0x00f9:
            return r10
        L_0x00fa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ak.b(android.view.ViewGroup, androidx.transition.t, int, androidx.transition.t, int):android.animation.Animator");
    }

    public boolean isTransitionRequired(t tVar, t tVar2) {
        if (tVar == null && tVar2 == null) {
            return false;
        }
        if (tVar != null && tVar2 != null && tVar2.f1311a.containsKey("android:visibility:visibility") != tVar.f1311a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b a2 = a(tVar, tVar2);
        if (!a2.f1257a) {
            return false;
        }
        if (a2.c == 0 || a2.d == 0) {
            return true;
        }
        return false;
    }

    /* compiled from: Visibility */
    private static class a extends AnimatorListenerAdapter implements a.C0039a, m.d {

        /* renamed from: a  reason: collision with root package name */
        boolean f1255a = false;

        /* renamed from: b  reason: collision with root package name */
        private final View f1256b;
        private final int c;
        private final ViewGroup d;
        private final boolean e;
        private boolean f;

        public void a(m mVar) {
        }

        public void e(m mVar) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        a(View view, int i, boolean z) {
            this.f1256b = view;
            this.c = i;
            this.d = (ViewGroup) view.getParent();
            this.e = z;
            a(true);
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f1255a) {
                ad.a(this.f1256b, this.c);
            }
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f1255a) {
                ad.a(this.f1256b, 0);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f1255a = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void b(m mVar) {
            a();
            mVar.removeListener(this);
        }

        public void c(m mVar) {
            a(false);
        }

        public void d(m mVar) {
            a(true);
        }

        private void a() {
            if (!this.f1255a) {
                ad.a(this.f1256b, this.c);
                ViewGroup viewGroup = this.d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (this.e && this.f != z && (viewGroup = this.d) != null) {
                this.f = z;
                y.a(viewGroup, z);
            }
        }
    }
}
