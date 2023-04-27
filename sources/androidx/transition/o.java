package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.g.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager */
public class o {

    /* renamed from: a  reason: collision with root package name */
    static ArrayList<ViewGroup> f1298a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private static m f1299b = new b();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<m>>>> c = new ThreadLocal<>();

    static ArrayMap<ViewGroup, ArrayList<m>> a() {
        ArrayMap<ViewGroup, ArrayList<m>> arrayMap;
        WeakReference weakReference = c.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<m>> arrayMap2 = new ArrayMap<>();
        c.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    private static void b(ViewGroup viewGroup, m mVar) {
        if (mVar != null && viewGroup != null) {
            a aVar = new a(mVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    /* compiled from: TransitionManager */
    private static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        m f1300a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f1301b;

        public void onViewAttachedToWindow(View view) {
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f1300a = mVar;
            this.f1301b = viewGroup;
        }

        private void a() {
            this.f1301b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f1301b.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            o.f1298a.remove(this.f1301b);
            ArrayList arrayList = o.a().get(this.f1301b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).resume(this.f1301b);
                }
            }
            this.f1300a.clearValues(true);
        }

        public boolean onPreDraw() {
            a();
            if (!o.f1298a.remove(this.f1301b)) {
                return true;
            }
            final ArrayMap<ViewGroup, ArrayList<m>> a2 = o.a();
            ArrayList arrayList = a2.get(this.f1301b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a2.put(this.f1301b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f1300a);
            this.f1300a.addListener(new n() {
                public void b(m mVar) {
                    ((ArrayList) a2.get(a.this.f1301b)).remove(mVar);
                    mVar.removeListener(this);
                }
            });
            this.f1300a.captureValues(this.f1301b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).resume(this.f1301b);
                }
            }
            this.f1300a.playTransition(this.f1301b);
            return true;
        }
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        ArrayList arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((m) it.next()).pause(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.captureValues(viewGroup, true);
        }
        k a2 = k.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (!f1298a.contains(viewGroup) && v.A(viewGroup)) {
            f1298a.add(viewGroup);
            if (mVar == null) {
                mVar = f1299b;
            }
            m clone = mVar.clone();
            c(viewGroup, clone);
            k.a(viewGroup, (k) null);
            b(viewGroup, clone);
        }
    }
}
