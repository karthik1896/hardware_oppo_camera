package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.g.v;
import java.util.Map;

/* compiled from: ChangeBounds */
public class c extends m {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f1261a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: b  reason: collision with root package name */
    private static final Property<Drawable, PointF> f1262b = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {

        /* renamed from: a  reason: collision with root package name */
        private Rect f1263a = new Rect();

        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f1263a);
            this.f1263a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f1263a);
        }

        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f1263a);
            return new PointF((float) this.f1263a.left, (float) this.f1263a.top);
        }
    };
    private static final Property<a, PointF> c = new Property<a, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.a(pointF);
        }
    };
    private static final Property<a, PointF> d = new Property<a, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(a aVar) {
            return null;
        }

        /* renamed from: a */
        public void set(a aVar, PointF pointF) {
            aVar.b(pointF);
        }
    };
    private static final Property<View, PointF> e = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            ad.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> f = new Property<View, PointF>(PointF.class, "topLeft") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            ad.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> g = new Property<View, PointF>(PointF.class, "position") {
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ad.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static j k = new j();
    private int[] h = new int[2];
    private boolean i = false;
    private boolean j = false;

    public String[] getTransitionProperties() {
        return f1261a;
    }

    private void a(t tVar) {
        View view = tVar.f1312b;
        if (v.A(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            tVar.f1311a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            tVar.f1311a.put("android:changeBounds:parent", tVar.f1312b.getParent());
            if (this.j) {
                tVar.f1312b.getLocationInWindow(this.h);
                tVar.f1311a.put("android:changeBounds:windowX", Integer.valueOf(this.h[0]));
                tVar.f1311a.put("android:changeBounds:windowY", Integer.valueOf(this.h[1]));
            }
            if (this.i) {
                tVar.f1311a.put("android:changeBounds:clip", v.C(view));
            }
        }
    }

    public void captureStartValues(t tVar) {
        a(tVar);
    }

    public void captureEndValues(t tVar) {
        a(tVar);
    }

    private boolean a(View view, View view2) {
        if (!this.j) {
            return true;
        }
        t matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f1312b) {
            return true;
        }
        return false;
    }

    public Animator createAnimator(ViewGroup viewGroup, t tVar, t tVar2) {
        int i2;
        View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator2;
        t tVar3 = tVar;
        t tVar4 = tVar2;
        if (tVar3 == null || tVar4 == null) {
            return null;
        }
        Map<String, Object> map = tVar3.f1311a;
        Map<String, Object> map2 = tVar4.f1311a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = tVar4.f1312b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) tVar3.f1311a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) tVar4.f1311a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            View view3 = view2;
            Rect rect4 = (Rect) tVar3.f1311a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) tVar4.f1311a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (!(i8 == i9 && i10 == i11)) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 <= 0) {
                return null;
            }
            Rect rect6 = rect5;
            Rect rect7 = rect4;
            if (!this.i) {
                view = view3;
                ad.a(view, i4, i6, i8, i10);
                if (i2 == 2) {
                    if (i12 == i14 && i13 == i15) {
                        animator = f.a(view, g, getPathMotion().a((float) i4, (float) i6, (float) i5, (float) i7));
                    } else {
                        final a aVar = new a(view);
                        ObjectAnimator a2 = f.a(aVar, c, getPathMotion().a((float) i4, (float) i6, (float) i5, (float) i7));
                        ObjectAnimator a3 = f.a(aVar, d, getPathMotion().a((float) i8, (float) i10, (float) i9, (float) i11));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(new Animator[]{a2, a3});
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            private a mViewBounds = aVar;
                        });
                        animator = animatorSet;
                    }
                } else if (i4 == i5 && i6 == i7) {
                    animator = f.a(view, e, getPathMotion().a((float) i8, (float) i10, (float) i9, (float) i11));
                } else {
                    animator = f.a(view, f, getPathMotion().a((float) i4, (float) i6, (float) i5, (float) i7));
                }
            } else {
                view = view3;
                ad.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                if (i4 == i5 && i6 == i7) {
                    objectAnimator = null;
                } else {
                    objectAnimator = f.a(view, g, getPathMotion().a((float) i4, (float) i6, (float) i5, (float) i7));
                }
                if (rect7 == null) {
                    i3 = 0;
                    rect = new Rect(0, 0, i12, i13);
                } else {
                    i3 = 0;
                    rect = rect7;
                }
                Rect rect8 = rect6 == null ? new Rect(i3, i3, i14, i15) : rect6;
                if (!rect.equals(rect8)) {
                    v.a(view, rect);
                    j jVar = k;
                    Object[] objArr = new Object[2];
                    objArr[i3] = rect;
                    objArr[1] = rect8;
                    objectAnimator2 = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                    final View view4 = view;
                    final Rect rect9 = rect6;
                    final int i16 = i5;
                    final int i17 = i7;
                    final int i18 = i9;
                    final int i19 = i11;
                    objectAnimator2.addListener(new AnimatorListenerAdapter() {
                        private boolean h;

                        public void onAnimationCancel(Animator animator) {
                            this.h = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.h) {
                                v.a(view4, rect9);
                                ad.a(view4, i16, i17, i18, i19);
                            }
                        }
                    });
                } else {
                    objectAnimator2 = null;
                }
                animator = s.a(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                y.a(viewGroup4, true);
                addListener(new n() {

                    /* renamed from: a  reason: collision with root package name */
                    boolean f1264a = false;

                    public void a(m mVar) {
                        y.a(viewGroup4, false);
                        this.f1264a = true;
                    }

                    public void b(m mVar) {
                        if (!this.f1264a) {
                            y.a(viewGroup4, false);
                        }
                        mVar.removeListener(this);
                    }

                    public void c(m mVar) {
                        y.a(viewGroup4, false);
                    }

                    public void d(m mVar) {
                        y.a(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) tVar3.f1311a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) tVar3.f1311a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) tVar4.f1311a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) tVar4.f1311a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.h);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = ad.c(view2);
        ad.a(view2, 0.0f);
        ad.a(viewGroup).a(bitmapDrawable);
        g pathMotion = getPathMotion();
        int[] iArr = this.h;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, new PropertyValuesHolder[]{i.a(f1262b, pathMotion.a((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1])))});
        final ViewGroup viewGroup5 = viewGroup;
        final BitmapDrawable bitmapDrawable2 = bitmapDrawable;
        final View view5 = view2;
        final float f2 = c2;
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ad.a(viewGroup5).b(bitmapDrawable2);
                ad.a(view5, f2);
            }
        });
        return ofPropertyValuesHolder;
    }

    /* compiled from: ChangeBounds */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f1272a;

        /* renamed from: b  reason: collision with root package name */
        private int f1273b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        a(View view) {
            this.e = view;
        }

        /* access modifiers changed from: package-private */
        public void a(PointF pointF) {
            this.f1272a = Math.round(pointF.x);
            this.f1273b = Math.round(pointF.y);
            this.f++;
            if (this.f == this.g) {
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            this.g++;
            if (this.f == this.g) {
                a();
            }
        }

        private void a() {
            ad.a(this.e, this.f1272a, this.f1273b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }
    }
}
