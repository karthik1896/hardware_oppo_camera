package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.g.v;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator */
public class e extends r {
    private static TimeInterpolator i;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.w>> f1098a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ArrayList<b>> f1099b = new ArrayList<>();
    ArrayList<ArrayList<a>> c = new ArrayList<>();
    ArrayList<RecyclerView.w> d = new ArrayList<>();
    ArrayList<RecyclerView.w> e = new ArrayList<>();
    ArrayList<RecyclerView.w> f = new ArrayList<>();
    ArrayList<RecyclerView.w> g = new ArrayList<>();
    private ArrayList<RecyclerView.w> j = new ArrayList<>();
    private ArrayList<RecyclerView.w> k = new ArrayList<>();
    private ArrayList<b> l = new ArrayList<>();
    private ArrayList<a> m = new ArrayList<>();

    /* compiled from: DefaultItemAnimator */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.w f1118a;

        /* renamed from: b  reason: collision with root package name */
        public int f1119b;
        public int c;
        public int d;
        public int e;

        b(RecyclerView.w wVar, int i, int i2, int i3, int i4) {
            this.f1118a = wVar;
            this.f1119b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    /* compiled from: DefaultItemAnimator */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.w f1116a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.w f1117b;
        public int c;
        public int d;
        public int e;
        public int f;

        private a(RecyclerView.w wVar, RecyclerView.w wVar2) {
            this.f1116a = wVar;
            this.f1117b = wVar2;
        }

        a(RecyclerView.w wVar, RecyclerView.w wVar2, int i, int i2, int i3, int i4) {
            this(wVar, wVar2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f1116a + ", newHolder=" + this.f1117b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }
    }

    public void a() {
        boolean z = !this.j.isEmpty();
        boolean z2 = !this.l.isEmpty();
        boolean z3 = !this.m.isEmpty();
        boolean z4 = !this.k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.w> it = this.j.iterator();
            while (it.hasNext()) {
                u(it.next());
            }
            this.j.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.l);
                this.f1099b.add(arrayList);
                this.l.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            e.this.b(bVar.f1118a, bVar.f1119b, bVar.c, bVar.d, bVar.e);
                        }
                        arrayList.clear();
                        e.this.f1099b.remove(arrayList);
                    }
                };
                if (z) {
                    v.a(((b) arrayList.get(0)).f1118a.itemView, (Runnable) r6, g());
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.m);
                this.c.add(arrayList2);
                this.m.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            e.this.a((a) it.next());
                        }
                        arrayList2.clear();
                        e.this.c.remove(arrayList2);
                    }
                };
                if (z) {
                    v.a(((a) arrayList2.get(0)).f1116a.itemView, (Runnable) r62, g());
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.k);
                this.f1098a.add(arrayList3);
                this.k.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            e.this.c((RecyclerView.w) it.next());
                        }
                        arrayList3.clear();
                        e.this.f1098a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    long j2 = 0;
                    long g2 = z ? g() : 0;
                    long e2 = z2 ? e() : 0;
                    if (z3) {
                        j2 = h();
                    }
                    v.a(((RecyclerView.w) arrayList3.get(0)).itemView, (Runnable) r5, g2 + Math.max(e2, j2));
                    return;
                }
                r5.run();
            }
        }
    }

    public boolean a(RecyclerView.w wVar) {
        v(wVar);
        this.j.add(wVar);
        return true;
    }

    private void u(final RecyclerView.w wVar) {
        final View view = wVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f.add(wVar);
        animate.setDuration(g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                e.this.l(wVar);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                e.this.i(wVar);
                e.this.f.remove(wVar);
                e.this.c();
            }
        }).start();
    }

    public boolean b(RecyclerView.w wVar) {
        v(wVar);
        wVar.itemView.setAlpha(0.0f);
        this.k.add(wVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c(final RecyclerView.w wVar) {
        final View view = wVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.d.add(wVar);
        animate.alpha(1.0f).setDuration(f()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                e.this.n(wVar);
            }

            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                e.this.k(wVar);
                e.this.d.remove(wVar);
                e.this.c();
            }
        }).start();
    }

    public boolean a(RecyclerView.w wVar, int i2, int i3, int i4, int i5) {
        View view = wVar.itemView;
        int translationX = i2 + ((int) wVar.itemView.getTranslationX());
        int translationY = i3 + ((int) wVar.itemView.getTranslationY());
        v(wVar);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            j(wVar);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.l.add(new b(wVar, translationX, translationY, i4, i5));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(RecyclerView.w wVar, int i2, int i3, int i4, int i5) {
        final View view = wVar.itemView;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.e.add(wVar);
        final RecyclerView.w wVar2 = wVar;
        animate.setDuration(e()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                e.this.m(wVar2);
            }

            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                e.this.j(wVar2);
                e.this.e.remove(wVar2);
                e.this.c();
            }
        }).start();
    }

    public boolean a(RecyclerView.w wVar, RecyclerView.w wVar2, int i2, int i3, int i4, int i5) {
        if (wVar == wVar2) {
            return a(wVar, i2, i3, i4, i5);
        }
        float translationX = wVar.itemView.getTranslationX();
        float translationY = wVar.itemView.getTranslationY();
        float alpha = wVar.itemView.getAlpha();
        v(wVar);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        wVar.itemView.setTranslationX(translationX);
        wVar.itemView.setTranslationY(translationY);
        wVar.itemView.setAlpha(alpha);
        if (wVar2 != null) {
            v(wVar2);
            wVar2.itemView.setTranslationX((float) (-i6));
            wVar2.itemView.setTranslationY((float) (-i7));
            wVar2.itemView.setAlpha(0.0f);
        }
        this.m.add(new a(wVar, wVar2, i2, i3, i4, i5));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(final a aVar) {
        final View view;
        RecyclerView.w wVar = aVar.f1116a;
        final View view2 = null;
        if (wVar == null) {
            view = null;
        } else {
            view = wVar.itemView;
        }
        RecyclerView.w wVar2 = aVar.f1117b;
        if (wVar2 != null) {
            view2 = wVar2.itemView;
        }
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(h());
            this.g.add(aVar.f1116a);
            duration.translationX((float) (aVar.e - aVar.c));
            duration.translationY((float) (aVar.f - aVar.d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    e.this.b(aVar.f1116a, true);
                }

                public void onAnimationEnd(Animator animator) {
                    duration.setListener((Animator.AnimatorListener) null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    e.this.a(aVar.f1116a, true);
                    e.this.g.remove(aVar.f1116a);
                    e.this.c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.g.add(aVar.f1117b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    e.this.b(aVar.f1117b, false);
                }

                public void onAnimationEnd(Animator animator) {
                    animate.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    e.this.a(aVar.f1117b, false);
                    e.this.g.remove(aVar.f1117b);
                    e.this.c();
                }
            }).start();
        }
    }

    private void a(List<a> list, RecyclerView.w wVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, wVar) && aVar.f1116a == null && aVar.f1117b == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.f1116a != null) {
            a(aVar, aVar.f1116a);
        }
        if (aVar.f1117b != null) {
            a(aVar, aVar.f1117b);
        }
    }

    private boolean a(a aVar, RecyclerView.w wVar) {
        boolean z = false;
        if (aVar.f1117b == wVar) {
            aVar.f1117b = null;
        } else if (aVar.f1116a != wVar) {
            return false;
        } else {
            aVar.f1116a = null;
            z = true;
        }
        wVar.itemView.setAlpha(1.0f);
        wVar.itemView.setTranslationX(0.0f);
        wVar.itemView.setTranslationY(0.0f);
        a(wVar, z);
        return true;
    }

    public void d(RecyclerView.w wVar) {
        View view = wVar.itemView;
        view.animate().cancel();
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.l.get(size).f1118a == wVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                j(wVar);
                this.l.remove(size);
            }
        }
        a((List<a>) this.m, wVar);
        if (this.j.remove(wVar)) {
            view.setAlpha(1.0f);
            i(wVar);
        }
        if (this.k.remove(wVar)) {
            view.setAlpha(1.0f);
            k(wVar);
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.c.get(size2);
            a((List<a>) arrayList, wVar);
            if (arrayList.isEmpty()) {
                this.c.remove(size2);
            }
        }
        for (int size3 = this.f1099b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f1099b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((b) arrayList2.get(size4)).f1118a == wVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    j(wVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f1099b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f1098a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f1098a.get(size5);
            if (arrayList3.remove(wVar)) {
                view.setAlpha(1.0f);
                k(wVar);
                if (arrayList3.isEmpty()) {
                    this.f1098a.remove(size5);
                }
            }
        }
        this.f.remove(wVar);
        this.d.remove(wVar);
        this.g.remove(wVar);
        this.e.remove(wVar);
        c();
    }

    private void v(RecyclerView.w wVar) {
        if (i == null) {
            i = new ValueAnimator().getInterpolator();
        }
        wVar.itemView.animate().setInterpolator(i);
        d(wVar);
    }

    public boolean b() {
        return !this.k.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.j.isEmpty() || !this.e.isEmpty() || !this.f.isEmpty() || !this.d.isEmpty() || !this.g.isEmpty() || !this.f1099b.isEmpty() || !this.f1098a.isEmpty() || !this.c.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!b()) {
            i();
        }
    }

    public void d() {
        int size = this.l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.l.get(size);
            View view = bVar.f1118a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            j(bVar.f1118a);
            this.l.remove(size);
        }
        for (int size2 = this.j.size() - 1; size2 >= 0; size2--) {
            i(this.j.get(size2));
            this.j.remove(size2);
        }
        int size3 = this.k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.w wVar = this.k.get(size3);
            wVar.itemView.setAlpha(1.0f);
            k(wVar);
            this.k.remove(size3);
        }
        for (int size4 = this.m.size() - 1; size4 >= 0; size4--) {
            b(this.m.get(size4));
        }
        this.m.clear();
        if (b()) {
            for (int size5 = this.f1099b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f1099b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = (b) arrayList.get(size6);
                    View view2 = bVar2.f1118a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    j(bVar2.f1118a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1099b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f1098a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f1098a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.w wVar2 = (RecyclerView.w) arrayList2.get(size8);
                    wVar2.itemView.setAlpha(1.0f);
                    k(wVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1098a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b((a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.c.remove(arrayList3);
                    }
                }
            }
            a((List<RecyclerView.w>) this.f);
            a((List<RecyclerView.w>) this.e);
            a((List<RecyclerView.w>) this.d);
            a((List<RecyclerView.w>) this.g);
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<RecyclerView.w> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public boolean a(RecyclerView.w wVar, List<Object> list) {
        return !list.isEmpty() || super.a(wVar, list);
    }
}
